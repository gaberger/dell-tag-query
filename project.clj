(defproject dell-tag-query "1.0.1"
  :description "Application to report system config using Dell service tag"
  :url "http://github.com/gaberger/dell-tag-query"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [cheshire "5.8.0"]
                 [hickory "0.7.1"]]
  :main dell-tag-query.core
  :aot  [dell-tag-query.core])
