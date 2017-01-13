;; Reverse Interleave - Medium
;; Write a function which reverses the interleave process into x number of subsequences.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p43
  (:use clojure.test))

(defn reverse-interleave [xs v]
  (apply map vector (partition v xs)))

(defn -main []
  (are [soln] soln
       (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
       (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
       (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))
