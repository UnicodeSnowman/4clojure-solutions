;; Factorial Fun - Easy
;; Write a function which calculates factorials.
;; tags - math
;; restricted - 
(ns offline-4clojure.p42
  (:use clojure.test))

(defn factorial [v]
  (apply * (range 1 (inc v))))

(defn -main []
  (are [soln] soln
       (= (factorial 1) 1)
       (= (factorial 3) 6)
       (= (factorial 5) 120)
       (= (factorial 8) 40320)))
