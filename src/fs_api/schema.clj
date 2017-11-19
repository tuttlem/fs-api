(ns fs-api.schema
  (:require [schema.core :as s]
            [ring.swagger.schema :refer [coerce!]]
            [compojure.api.sweet :refer :all]
            monger.json)
  (:import  [org.bson.types ObjectId]))

(s/defschema Node {:_id    ObjectId
                   :name   String
                   :type   (s/enum "file" "link" "directory")
                   (s/optional-key :target) ObjectId})

(s/defschema NewNode (dissoc Node :_id))
