(ns shouter.core
  (:use [compojure.core :only [defroutes]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [shouter.controllers.shouts]
            [shouter.views.layout :as layout]))

(defn index []
  (html5
    [:head
      [:title "Hello World"]]
    [:body
      [:div {:id "content"} "Hello World"]]))

(defroutes routes
  shouter.controllers.shouts/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty #'application {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))
