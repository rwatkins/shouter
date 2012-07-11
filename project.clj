(defproject shouter "0.0.1"
  :description "Shouter app"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [ring/ring-jetty-adapter "1.1.1"]
                 [compojure "1.1.0"]
                 [hiccup "1.0.0"]])