;; Euler's Totient Function - Medium
;; Two numbers are coprime if their greatest common divisor equals 1.
;; Euler's totient function f(x) is defined as the number of positive integers less than x which are
;; coprime to x.
;; The special case f(1) equals 1.  Write a function which calculates Euler's totient function.
;; tags - 
;; restricted - 
(ns offline-4clojure.p75
  (:require [offline-4clojure.p66 :refer [gcd]])
  (:use clojure.test))

(defn coprime? [a b]
  (= 1 (gcd a b)))

(defn totient [x]
  (count (filter (partial coprime? x) (range 1 (inc x)))))

(defn -main []
  (are [soln] soln
       (= (totient 1) 1)
       (= (totient 10) (count '(1 3 7 9)) 4)
       (= (totient 40) 16)
       (= (totient 99) 60)))
