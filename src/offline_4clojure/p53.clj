;; Longest Increasing Sub-Seq - Hard
;; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers.
;; If two sub-sequences have the same length, use the one that occurs first.
;; An increasing sub-sequence must have a length of 2 or greater to qualify.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p53
  (:use clojure.test))

(defn valid? [coll]
  (and
    (>= (count coll) 2)
    (= coll (range (first coll) (inc (last coll))))))

(defn longest-increasing-sub-seq
  ([xs] (longest-increasing-sub-seq xs (count xs)))
  ([xs n]
   (if (< n 2)
     []
     (let [valid-seqs (filter valid? (partition n 1 xs))]
       (if (empty? valid-seqs)
         (recur xs (dec n))
         (first valid-seqs))))))

(defn -main []
  (are [soln] soln
       (= (longest-increasing-sub-seq [1 0 1 2 3 0 4 5]) [0 1 2 3])
       (= (longest-increasing-sub-seq [5 6 1 3 2 7]) [5 6])
       (= (longest-increasing-sub-seq [2 3 3 4 5]) [3 4 5])
       (= (longest-increasing-sub-seq [7 6 5 4]) [])))
