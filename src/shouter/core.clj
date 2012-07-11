(ns shouter.core
  (:use [compojure.core :only [defroutes GET]])
  (:require [ring.adapter.jetty :as ring])
  (:use [hiccup.page :only [html5]]))

(defn index []
  (html5
    [:head
      [:title "Hello World"]]
    [:body
      [:div {:id "content"} "Hello World"]]))

(defroutes routes
  (GET "/" [] (index)))

(defn start []
  (ring/run-jetty #'routes {:port 8080 :join? false}))
