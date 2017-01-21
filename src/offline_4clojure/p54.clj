;; Partition a Sequence - Medium
;; Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.
;; tags - seqs:core-functions
;; restricted - partition:partition-all
(ns offline-4clojure.p54
  (:use clojure.test))

(defn lists-of [n xs]
  (->> (map-indexed #(vector (quot %1 n) %2) xs)
       (group-by first)
       (vals)
       (map #(map second %))
       (filter #(= (count %) n))))

; "official" recursive solution is cool... grab n elements, cons'd with
; (recursive) remainder, iterate until empty or remaing count
; is less than n. COOL!
; (defn p [n c]
;   (when (and (seq c) (>= (count c) n))
;     (cons (take n c)
;           (lazy-seq (p n (drop n c))))))
; 
; (p 3 (range 8))

(defn -main []
  (are [soln] soln
       (= (lists-of 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
       (= (lists-of 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
       (= (lists-of 3 (range 8)) '((0 1 2) (3 4 5)))))
