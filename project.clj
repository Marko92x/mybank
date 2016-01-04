(defproject mybank "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler mybank.core/app
         :auto-reload? true
         :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [ring/ring "1.2.0"]
                 [hiccup "1.0.4"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.2.0-SNAPSHOT"]])
