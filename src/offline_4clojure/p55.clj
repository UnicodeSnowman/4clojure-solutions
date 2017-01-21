;; Count Occurrences - Medium
;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
;; tags - seqs:core-functions
;; restricted - frequencies
(ns offline-4clojure.p55
  (:use clojure.test))

(defn occurrence-count [xs]
  (->> (sort xs)
       (partition-by identity)
       (group-by first)
       (reduce-kv (fn [m k v] (assoc m k (count (first v)))) {})))

; "official" solution really cool (again). the `for` comprehension
; produces a seq of maps with keys set to collection vals and values
; set to 1.
; this seq of maps is passed to merge-with, which resolves duplicate
; keys with the provided function (+ in this case), so duplicate
; keys  are resolved by summing the values. awesome.
; #(apply merge-with + (for [e %] {e 1}))

; (for [e [1 1 2 3 2 1 1]] {e 1})

(defn -main []
  (are [soln] soln
       (= (occurrence-count [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
       (= (occurrence-count [:b :a :b :a :b]) {:a 2, :b 3})
       (= (occurrence-count '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))
