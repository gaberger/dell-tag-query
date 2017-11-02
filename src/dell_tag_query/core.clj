(ns dell-tag-query.core
  (:require [org.httpkit.client :as http]
            [clojure.pprint :as pprint]
            [hickory.core :refer [parse as-hickory as-hiccup]]
            [hickory.select :as s]
            [cheshire.core :refer :all]))

;
;(defn find-sku [sku]
;  (-> (s/select (s/child (s/class "sku0"))))
;  nil)

(defn get-parts [m]
  (pprint/print-table (map #(select-keys (first (:Parts %)) [:Qty :Description :PartNumber]) m)))


(defn isError? [h]
  (not (nil? (-> (s/select (s/and (s/id "mse_entryErrorMessage")) h) first :content first))))

(defn get-summary [m]
  (-> (s/select (s/and (s/class "rt-responsive-table-0")) m)))

(defn get-parts [m]
  (-> (s/select (s/and (s/id "hdnParts") ) m) first :attrs :value))

(defn parse-hickory->csv [service-tag body]
  (try
    (let [hickory (-> body parse as-hickory)
          _ (pprint/pprint get-summary hickory)
          hickory-data (if (not (isError? hickory))
                         (get-parts hickory)
                         (throw (Exception.)))
          _ (print hickory-data)
          json->edn (parse-string hickory-data true)]
      json->edn)
    (catch Exception e
           (print (str "Exception: Asset " service-tag " doesn't exist")))))



(defn get-configuration [service-tag]
  (let [url (str "http://www.dell.com/support/home/us/en/19/product-support/servicetag/" service-tag "/configuration")
        response (http/get url)
        status (:status @response)
        body (:body @response)]
   (condp = status
       200 body
       (print (str "Unexpected return: " (:status @response))))))



(defn -main [service-tag]
 (let [config (get-configuration (str service-tag))
       parse (parse-hickory->csv service-tag config)]))



