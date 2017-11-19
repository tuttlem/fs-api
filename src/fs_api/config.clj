(ns fs-api.config
 (:use clojure.java [io :as io]))

(defn from-edn
 [fname]
 (with-open [rdr (-> (io/resource fname)
                     io/reader
                     java.io.PushbackReader . )]
   (clojure.edn/read rdr)))



