;; Pack a Sequence - Easy
;; Write a function which packs consecutive duplicates into sub-lists.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p31
  (:use clojure.test))

(defn pack [xs]
  (partition-by identity xs))

(defn -main []
  (are [soln] soln
(= (pack [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (pack [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (pack [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))
