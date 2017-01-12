;; Duplicate a Sequence - Easy
;; Write a function which duplicates each element of a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p32
  (:use clojure.test))

(defn duplicate-sequence [xs]
  (mapcat #(repeat 2 %) xs))

(defn -main []
  (are [soln] soln
(= (duplicate-sequence [1 2 3]) '(1 1 2 2 3 3))
(= (duplicate-sequence [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (duplicate-sequence [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (duplicate-sequence [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))
