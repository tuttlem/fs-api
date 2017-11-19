(defproject tuttlem/fs-api "0.1.0-SNAPSHOT"
  :description "File system REST api"
  :url "http://github.com/tuttlem/fs-api"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :ring {:handler fs-api.core/app
         :nrepl {:start? true
                 :port 9998}}

  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[lein-ring "0.12.0"]
                             [ragtime/ragtime.lein "0.3.6"]]}}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "1.1.11"]
                 [aero "1.1.2"]
                 [com.novemberain/monger "3.1.0"]])
