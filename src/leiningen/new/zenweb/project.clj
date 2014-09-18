(defproject {{ns-name}} "0.1.0"
  :repl-options {:init-ns {{ns-name}}.repl}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring-server "0.3.1"]
                 [lib-noir "0.8.6"]
                 [http-kit "2.1.19"]
                 [com.cemerick/url "0.1.1"]
                 [noir-exception "0.2.2"]
                 [environ "1.0.0"]
                 [clj-time "0.8.0"]
                 [im.chit/cronj "1.4.2"]
                 [com.taoensso/timbre "3.3.0"]
                 [prone "0.6.0"]
                 [enlive "1.1.5"]
                 [selmer "0.6.9"]
                 [markdown-clj "0.9.47"]
                 [org.clojure/core.async "0.1.338.0-5c5012-alpha"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [reagent "0.4.2"]
                 [cljs-ajax "0.2.6"]
                 [secretary "1.2.0"]
                 [enfocus "2.1.0"]
                 [kioo "0.4.0"]
                 [om "0.7.1"]
                 [com.ashafa/clutch "0.4.0-RC1"]
                 [couchbase-clj "0.2.0"]
                 [zenedu.squest/questdb "0.2.2"]
                 [expectations "2.0.9"]]
  
  :cljsbuild {:builds
              [{:source-paths ["src-cljs"],
                :compiler {:pretty-print true,
                           :output-dir "resources/public/js/",
                           :source-map true,
                           :output-to "resources/public/js/app.js",
                           :optimizations :none},
                :id "dev"}
               {:source-paths ["src-cljs"],
                :compiler {:pretty-print false,
                           :closure-warnings {:non-standard-jsdoc :off},
                           :output-to "resources/public/js/app.js",
                           :output-wrapper false,
                           :optimizations :advanced},
                :id "prod"}]}
  :ring {:handler {{ns-name}}.handler/app,
         :init {{ns-name}}.handler/init,
         :destroy {{ns-name}}.handler/destroy}
  :profiles {:uberjar {:aot :all},
             :production
             {:ring
              {:open-browser? false, :stacktraces? false, :auto-reload? false}},
             :dev
             {:dependencies [[ring-mock "0.1.5"]
                             [ring/ring-devel "1.3.1"]
                             [pjstadig/humane-test-output "0.6.0"]],
              :injections [(require 'pjstadig.humane-test-output)
                           (pjstadig.humane-test-output/activate!)],
              :env {:dev true}}}
  :url "http://example.com/FIXME"
  :main {{ns-name}}.core
  :jvm-opts ["-server"]
  :plugins [[lein-ring "0.8.11"]
            [codox "0.8.10"]
            [lein-expectations "0.0.8"]
            [lein-environ "1.0.0"]
            [lein-cljsbuild "1.0.3"]
            [lein-autoexpect "1.2.2"]]
  :description "FIXME: write description"
  :min-lein-version "2.0.0")
