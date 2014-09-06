(ns leiningen.new.zenweb
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "zenweb"))

(defn zenweb
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/one/core.clj" (render "core.clj" data)]
["src/one/util.clj" (render "util.clj" data)]
["src/one/session_manager.clj" (render "session_manager.clj" data)]
["src/one/layout.clj" (render "layout.clj" data)]
["src/one/routes.clj" (render "routes.clj" data)]
["test/one/test/handler.clj" (render "handler.clj" data)]
["src/one/handler.clj" (render "handler.clj" data)]
["src/one/repl.clj" (render "repl.clj" data)]
["src/one/middleware.clj" (render "middleware.clj" data)]
["project.clj" (render "project.clj" data)]
["src/one/dbase.clj" (render "dbase.clj" data)]
["resources/public/css/main-style.css" (render "main_style.css")]
["resources/public/css/.DS_Store" (render ".DS_Store")]
["resources/public/css/main-style.scss" (render "main_style.scss")]
["resources/public/assets/foundation.min.css" (render "foundation.min.css")]
["resources/public/assets/normalize.css" (render "normalize.css")]
["resources/public/js/.DS_Store" (render ".DS_Store")]
["resources/public/js/app.js" (render "app.js")]
["resources/selmer/base.html" (render "base.html")]
["resources/public/assets/react.min.js" (render "react.min.js")]
)))