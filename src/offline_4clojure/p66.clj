;; Greatest Common Divisor - Easy
;; Given two integers, write a function which
;;returns the greatest common divisor.
;; tags - 
;; restricted - 
(ns offline-4clojure.p66
  (:use clojure.test))

(defn gcd [a b]
  (let [max-value (max a b)
        min-value (min a b)
        test-val (mod max-value min-value)]
    (if (zero? test-val)
      min-value
      (recur max-value test-val))))

(defn -main []
  (are [soln] soln
       (= (gcd 2 4) 2)
       (= (gcd 10 5) 5)
       (= (gcd 5 7) 1)
       (= (gcd 1023 858) 33)))
