;; Product Digits - Easy
;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
;; tags - math:seqs
;; restricted - 
(ns offline-4clojure.p99
  (:use clojure.test))

(defn product-digits [a b]
  (mapv #(Integer/parseInt (str %)) (str (* a b))))

(defn -main []
  (are [soln] soln
       (= (product-digits 1 1) [1])
       (= (product-digits 99 9) [8 9 1])
       (= (product-digits 999 99) [9 8 9 0 1])))
