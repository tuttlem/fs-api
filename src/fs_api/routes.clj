(ns fs-api.routes
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.json]
            [aero.core :refer (read-config)]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s])
  (:import [com.mongodb MongoOptions ServerAddress]
           [org.bson.types ObjectId]))


;; mongo --------------------------------------------------

(def conf (read-config "config.edn"))
(def mongo (mg/connect-via-uri (:mongo conf)))
(def conn (:conn mongo))
(def db (:db mongo))
(def coll "nodes")

;; routes --------------------------------------------------

(defn node-retrieve [id]
  (let [node (mc/find-one-as-map db coll { :_id (ObjectId. id)})]
    (if (nil? node)
      (not-found)
      (ok node))))

(defmulti node-create (fn [id node] (:type node)))
(defmethod node-create "file"
  [id node]
  (created (str (ObjectId.)))) 


