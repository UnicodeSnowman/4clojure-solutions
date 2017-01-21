;; Sequence Reductions - Medium
;; Write a function which behaves like reduce, but returns each intermediate value of the reduction.
; Your function must accept either two or three arguments, and the return sequence must be lazy.
;; tags - seqs:core-functions
;; restricted - reductions
(ns offline-4clojure.p60
  (:use clojure.test))

(defn sequence-reductions
  ([f coll] (sequence-reductions f (first coll) (rest coll)))
  ([f prev-result [x & xs]]
   (let [current-result (f prev-result x)]
     (cons
       prev-result
       (lazy-seq
         (if (seq xs)
           (sequence-reductions f current-result xs)
           [current-result]))))))

(defn -main []
  (are [soln] soln
       (= (take 5 (sequence-reductions + (range))) [0 1 3 6 10])
       (= (sequence-reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
       (= (last (sequence-reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))
