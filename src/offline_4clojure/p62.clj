;; Re-implement Iterate - Easy
;; Given a side-effect free function f and an initial value x write a function which returns an infinite 
; lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
;; tags - seqs:core-functions
;; restricted - iterate
(ns offline-4clojure.p62
  (:use clojure.test))

(defn re-iterate [f x]
  (cons x (lazy-seq (re-iterate f (f x)))))

(defn -main []
  (are [soln] soln
       (= (take 5 (re-iterate #(* 2 %) 1)) [1 2 4 8 16])
       (= (take 100 (re-iterate inc 0)) (take 100 (range)))
       (= (take 9 (re-iterate #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))
