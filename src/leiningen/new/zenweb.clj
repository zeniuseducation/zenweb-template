(ns leiningen.new.zenweb
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "zenweb"))

(defn zenweb
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (do (->files data
                 [(str "src/" name "/core.clj") (render "core.clj" data)]
                 [(str "src/" name "/util.clj") (render "util.clj" data)]
                 [(str "src/" name "/session_manager.clj") (render "session_manager.clj" data)]
                 [(str "src/" name "/layout.clj") (render "layout.clj" data)]
                 [(str "src/" name "/routes.clj") (render "routes.clj" data)]
                 [(str "test/" name "/test/handler.clj") (render "test.clj" data)]
                 [(str "src/" name "/handler.clj") (render "handler.clj" data)]
                 [(str "src/" name "/repl.clj") (render "repl.clj" data)]
                 [(str "src/" name "/middleware.clj") (render "middleware.clj" data)]
                 ["project.clj" (render "project.clj" data)]
                 [(str "src/" name "/dbase.clj") (render "dbase.clj" data)]
                 ["resources/public/css/main-style.css" (render "main_style.css")]
                 ["resources/public/css/.DS_Store" (render ".DS_Store")]
                 ["resources/public/css/main-style.scss" (render "main_style.scss")]
                 ["resources/public/assets/foundation.min.css" (render "foundation.min.css")]
                 ["resources/public/assets/normalize.css" (render "normalize.css")]
                 ["resources/public/js/.DS_Store" (render ".DS_Store")]
                 ["resources/public/js/app.js" (render "app.js")]
                 ["resources/selmer/base.html" (render "base.html")]
                 ["resources/public/assets/react.min.js" (render "react.min.js")])
        (println "Hello fellow Jackers.. May your lein be long and prosper!! Happy Jacking!"))))
