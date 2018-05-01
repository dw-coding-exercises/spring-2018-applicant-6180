(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.anti-forgery :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [my-exercise.home :as home]))

(defroutes app
  (GET "/" [] home/page)
  (route/resources "/")
  (POST "/search" {params :params} 
    (str " " params))
  (route/not-found "Not found"))

(def handler
  (-> app
      (wrap-defaults api-defaults)
      wrap-reload))
