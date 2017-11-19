(ns fs-api.core
  (:use fs-api.routes
        fs-api.schema)
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s])
  (:import [org.bson.types ObjectId]))

(def app 
  (api 
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Filesystem API Service"
                    :description "A file system storage and management service"}
             :tags [{:name "nodes" :description "Node management"}]}}}

    (context "/nodes" []
      :tags ["nodes"]

        (GET "/:id" []
          :return Node
          :path-params [id :- String]
          :summary "Retrieve a filesystem node by its id"
          (node-retrieve id))
        
        (POST "/:id" []
          :path-params [id :- String]
          :body [node NewNode]
          :summary "Creates a node entry in the specified parent folder"
          (node-create id node)))))
