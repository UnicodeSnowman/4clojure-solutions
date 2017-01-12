;; Compress a Sequence - Easy
;; Write a function which removes consecutive duplicates from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p30
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(def compress
  #(map first (partition-by identity %)))

(defn naive-compress [coll]
  (let [curr (first coll)]
    (if (nil? curr)
      '()
      (cons curr (lazy-seq (naive-compress (drop-while #(= curr %) (rest coll))))))))

(defn -main []
  (are [soln] soln
       (= (apply str (compress "Leeeeeerrroyyy")) "Leroy")
       (= (compress [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
       (= (compress [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))
