;; Replicate a Sequence - Easy
;; Write a function which replicates each element of a sequence a variable number of times.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p33
  (:use clojure.test))

(defn repeat-seq [xs n]
  (mapcat #(repeat n %) xs))

(defn -main []
  (are [soln] soln
       (= (repeat-seq [1 2 3] 2) '(1 1 2 2 3 3))
       (= (repeat-seq [:a :b] 4) '(:a :a :a :a :b :b :b :b))
       (= (repeat-seq [4 5 6] 1) '(4 5 6))
       (= (repeat-seq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
       (= (repeat-seq [44 33] 2) [44 44 33 33])))
