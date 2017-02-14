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
  (filter (partial coprime? x) (range 1 (inc x))))

; apparently my gcd function is incorrect? need to think more on
; why...
(defn totient [n]
  (if (= n 1)
    1
    (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))]
      (count (filter #{1} (map (partial gcd n) (range 1 n)))))))

(defn -main []
  (are [soln] soln
       (= (totient 1) 1)
       (= (totient 10) (count '(1 3 7 9)) 4)
       (= (totient 40) 16)
       (= (totient 99) 60)))
