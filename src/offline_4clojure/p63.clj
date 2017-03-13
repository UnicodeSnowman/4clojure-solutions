;; Group a Sequence - Easy
;; Given a function f and a sequence s, write a function which returns a map. 
; The keys should be the values of f applied to each item in s. 
; The value at each key should be a vector of corresponding items in the order they appear in s.
;; tags - core-functions
;; restricted - group-by
(ns offline-4clojure.p63
  (:use clojure.test))

(defn grouper [f s]
  (apply merge-with concat (for [v s]
                             {(f v) [v]})))

(defn -main []
  (are [soln] soln
       (= (grouper #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
       (= (grouper #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
          {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
       (= (grouper count [[1] [1 2] [3] [1 2 3] [2 3]])
          {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

 ; (update { :stuff [1 2 3] } :other conj 4)
 ; (update (update {} false conj 1) false conj 3)
