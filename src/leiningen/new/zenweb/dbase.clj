(ns {{ns-name}}.dbase
  (:require [cemerick.url :as curl]))

(def couch (assoc (curl/url "https://cloudant-account-name.cloudant.com/" "databasename")
          :username "username"
          :password "password"))

(def quest "databasename")


