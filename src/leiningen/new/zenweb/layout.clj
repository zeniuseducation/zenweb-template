(ns {{ns-name}}.layout
  (:require [selmer.parser :as parser]
            [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]))

(def template-path "selmer/")

(deftype
  RenderableTemplate
  [template params]
  Renderable
  (render
    [this request]
    (content-type
      (->>
        (assoc
          params
          :dev
          (env :dev)
          :servlet-context
          (if-let [context (:servlet-context request)]
            (try
              (.getContextPath context)
              (catch IllegalArgumentException _ context))))
        (parser/render-file (str template-path template))
        response)
      "text/html; charset=utf-8")))

(defn render [template & [params]]
  (RenderableTemplate. template params))

