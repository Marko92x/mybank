(ns mybank.core
    (:use compojure.core
      ring.middleware.json
      ring.util.response)
    (:require [compojure.route :as route]
              [mybank.view :as view]))

(defn foo [x] (str "Hello, " x))

(defroutes my_routes
           (GET "/" [] (view/index-page))
           (POST "/rest" [] (response {:email "kurac@kurcina.cvabalo"}))
           (route/resources "/"))

(def app (wrap-json-response my_routes))
