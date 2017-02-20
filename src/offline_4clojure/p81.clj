;; Set Intersection - Easy
;; Write a function which returns the intersection of two sets. 
;; The intersection is the sub-set of items that each set has in common.
;; tags - set-theory
;; restricted - intersection
(ns offline-4clojure.p81
  (:use clojure.test))

(defn intersection [s1 s2]
  (clojure.set/select #(s2 %) s1))

(defn -main []
  (are [soln] soln
       (= (intersection #{0 1 2 3} #{2 3 4 5}) #{2 3})
       (= (intersection #{0 1 2} #{3 4 5}) #{})
       (= (intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})))
