;; Symmetric Difference - Easy
;; Write a function which returns the symmetric difference of two sets. 
;; The symmetric difference is the set of items belonging to one but not both of the two sets.
;; tags - set-theory
;; restricted - 
(ns offline-4clojure.p88
  (:use clojure.test))

(defn symmetric-difference [s1 s2]
  (clojure.set/union
   (clojure.set/difference s1 s2)
   (clojure.set/difference s2 s1)))

(defn -main []
  (are [soln] soln
       (= (symmetric-difference #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
       (= (symmetric-difference #{:a :b :c} #{}) #{:a :b :c})
       (= (symmetric-difference #{} #{4 5 6}) #{4 5 6})
       (= (symmetric-difference #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))
