(ns worker-demo.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cemerick.bandalore :as sqs]))

(defn process-message [body]

	(require '[cemerick.bandalore :as sqs])
	(def client (sqs/create-client ~(System/getenv "AWS_ACCESS_KEY_ID") ~(System/getenv "AWS_SECRET_KEY")))
	(sqs/send client "https://queue.amazonaws.com/598573023317/demo_queue_2" (str body "***")))
	(str body))

(defroutes app-routes
  (GET "/" [] "Waiiiiiit a minute...what are you doing here? Scram!")
  (POST "/" {body :body} (process-message body))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
