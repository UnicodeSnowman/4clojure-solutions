;; A Half-Truth - Easy
;; Write a function which takes a variable number of booleans.
;; Your function should return true if some of the parameters are true,
;; but not all of the parameters are true.
;; Otherwise your function should return false.
;; tags - 
;; restricted - 
(ns offline-4clojure.p83
  (:use clojure.test))

(defn some-but-not-all? [& bools]
  (boolean
    (and
     (not (every? #{true} bools))
     (some #{true} bools))))

(defn -main []
  (are [soln] soln
       (= false (some-but-not-all? false false))
       (= true (some-but-not-all? true false))
       (= false (some-but-not-all? true))
       (= true (some-but-not-all? false true false))
       (= false (some-but-not-all? true true true))
       (= true (some-but-not-all? true true true false))))
