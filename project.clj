(defproject worker-demo "0.1.0"
  :description "A simple worker to work with the SQS service on AWS"
  :url "http://notsureyet.com"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-json "0.3.1"]
                 [com.cemerick/bandalore "0.0.5"]]
  :plugins [[lein-ring "0.8.10"]
            [org.clojars.jhosteny/lein-elastic-beanstalk "0.2.9-SNAPSHOT"]]
  :ring {:handler worker-demo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :aws {:access-key ~(System/getenv "AWS_ACCESS_KEY_ID")
        :secret-key ~(System/getenv "AWS_SECRET_KEY")
        :beanstalk {:stack-name "64bit Amazon Linux running Tomcat 7"
                    :app-tier {:name "Worker" :type "SQS/HTTP" :version "1.0"}
                    :environments [{:name "development"}]}})