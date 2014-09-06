(ns {{ns-name}}.util
  (:require [noir.io :as io]
            [markdown.core :as md]
            [clj-time.core :as t]))

(defn md->html
  "reads a markdown file from public/md and returns an HTML string"
  [filename]
  (md/md-to-html-string (io/slurp-resource filename)))


