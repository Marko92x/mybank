(ns mybank.core
    (:use compojure.core
      ring.middleware.json
      ring.util.response)
    (:require [compojure.route :as route]
              [mybank.view :as view]
              [mybank.News :as news]))

(defn foo [x] (str "Hello, " x))

(defroutes my_routes
           (GET "/" [] (view/index-page))
           (GET "/rest" [] (response (news/getNews)))
           (POST "/insertNews" {params :params} (response (news/insert params)))
           (DELETE "/delete/:id" [id] (news/delete id))
           (PUT "/updateNews"  {params :params}  (news/update (params "id") params))
           (route/resources "/"))

(def app (-> my_routes
             (wrap-json-params)
             (wrap-json-response)))
