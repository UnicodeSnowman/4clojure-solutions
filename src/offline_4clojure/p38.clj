;; Maximum value - Easy
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; tags - core-functions
;; restricted - max:max-key
(ns offline-4clojure.p38
  (:use clojure.test))

(defn my-max [& xs]
  (reduce (fn [acc v]
            (if (> v acc) v acc)) xs))

(defn max-clojure-y [& xs] (last (sort xs)))

(defn -main []
  (are [soln] soln
       (= (max-clojure-y 1 8 3 4) 8)
       (= (max-clojure-y 30 20) 30)
       (= (max-clojure-y 45 67 11) 67)))
