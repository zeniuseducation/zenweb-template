(ns {{ns-name}}.routes
  (:require [compojure.core :refer :all]
            [{{ns-name}}.layout :as page]))

(defn homepage
  "The rendering function for homepage"
  []
  (page/render "base.html"
               {:headline "Welcome to ...."
                :title "Luminoob website"}))

(defroutes home
  (GET "/" req
       (homepage)))
