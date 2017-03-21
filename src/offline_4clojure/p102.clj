;; intoCamelCase - Medium
;; When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
;; tags - strings
;; restricted - 
(ns offline-4clojure.p102
  (:require [clojure.string :refer [join upper-case split]])
  (:use clojure.test))

(defn camelize [s]
  (let [parts (clojure.string/split s #"-")]
    (->>
      (drop 1 parts)
      (mapv
        (fn [[head & tail]]
          (str
            (-> head str upper-case)
            (join tail))))
      (join)
      (str (first parts)))))

(defn -main []
  (are [soln] soln
       (= (camelize "something") "something")
       (= (camelize "multi-word-key") "multiWordKey")
       (= (camelize "leaveMeAlone") "leaveMeAlone")))
