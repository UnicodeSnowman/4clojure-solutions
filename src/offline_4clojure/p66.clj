;; Greatest Common Divisor - Easy
;; Given two integers, write a function which
;;returns the greatest common divisor.
;; tags - 
;; restricted - 
(ns offline-4clojure.p66
  (:use clojure.test))

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn -main []
  (are [soln] soln
       (= (gcd 2 4) 2)
       (= (gcd 10 5) 5)
       (= (gcd 5 7) 1)
       (= (gcd 1023 858) 33)))

; works for any order of operations... need to check for `zero?` value
; of whatever number is in the denominator of the modulo. i.e.
; this could also be

(defn alt-gcd [a b]
  (if (zero? a)
    b
    (recur (mod b a) a)))

; (gcd 10 5)
; 5 0 => 5
; 
; (gcd 5 10)
; 10 5
; 5 0 => 5
