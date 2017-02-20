;; Perfect Numbers - Medium
;; A number is "perfect" if the sum of its divisors equal the number itself.
;; 6 is a perfect number because 1+2+3=6. 
;; Write a function which returns true for perfect numbers and false otherwise.
;; tags - 
;; restricted - 
(ns offline-4clojure.p80
  (:use clojure.test))

(defn perfect? [n]
  (= n
     (apply +
            (filterv #(zero? (mod n %)) (range 1 n)))))

(defn -main []
  (are [soln] soln
       (= (perfect? 6) true)
       (= (perfect? 7) false)
       (= (perfect? 496) true)
       (= (perfect? 500) false)
       (= (perfect? 8128) true)))
