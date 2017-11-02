(ns dell-tag-query.core
  (:require [org.httpkit.client :as http]
            [clojure.pprint :as pprint]
            [hickory.core :refer [parse as-hickory as-hiccup]]
            [hickory.select :as s]
            [cheshire.core :refer :all]
            [clojure.string :as str])
  (:gen-class))



(defn get-summary [m]
  (let [f (-> (s/select
                (s/and (s/class "rt-responsive-table-0")
                       (s/node-type :element)) m) first :content next first :content next first :content)
        summary-head (map (-> str/trim ) (remove nil? (map #(-> % :content next first :content first) f)))
        summary-tail (mapv str/trim (remove nil? (map #(-> % :content next next next first :content first) f)))
        summary (zipmap summary-head summary-tail)]
    summary))

(defn html->hickory [content]
  (-> content parse as-hickory))

(defn print-summary [m]
  (pprint/print-table [(get-summary (html->hickory m))]))

(defn print-parts [m]
 (pprint/print-table (map #(select-keys (first (:Parts %)) [:Qty :Description :PartNumber]) m)))

(defn isError? [h]
  (not (nil? (-> (s/select (s/and (s/id "mse_entryErrorMessage")) h) first :content first))))

(defn get-parts [m]
  (-> (s/select (s/and (s/id "hdnParts") ) m) first :attrs :value))

(defn parse-hickory->csv [body]
    (let [hickory (html->hickory body)
          summary (get-summary hickory)
          hickory-data (if (not (isError? hickory))
                         (get-parts hickory)
                         (throw (Exception. "Asset not found")))
          json->edn (parse-string hickory-data true)]
      json->edn))

(defn get-configuration [service-tag]
  (let [url (str "http://www.dell.com/support/home/us/en/19/product-support/servicetag/" service-tag "/configuration")
        response (http/get url)
        status (:status @response)
        body (:body @response)]
   (condp = status
       200 body
       (throw (Exception. (str (:status @response)))))))


(defn -main [service-tag]
  (try
    (let [config (get-configuration (str service-tag))
          output (parse-hickory->csv config)]
      (print-summary config)
      (print-parts output))

    (catch Exception e
      (print (str "Exception: Asset " service-tag " " e)))))


