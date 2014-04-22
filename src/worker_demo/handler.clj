(ns worker-demo.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn process-message [body]
	(str body))

(defroutes app-routes
  (GET "/" [] "Waiiiiiit a minute...what are you doing here? Scram!")
  (POST "/" {body :body} (process-message body))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
