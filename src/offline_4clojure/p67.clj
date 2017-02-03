;; Prime Numbers - Medium
;; Write a function which returns the first x
;;number of prime numbers.
;; tags - primes
;; restricted - 
(ns offline-4clojure.p67
  (:use clojure.test))

(defn primes [n]
  (take n (iterate
            (fn [x]
              (let [next-val (inc x)]
                (if (not-any? #(zero? (mod next-val %)) (range 2 next-val))
                  next-val
                  (recur next-val))))
            2)))

(defn -main []
  (are [soln] soln
       (= (primes 2) [2 3])
       (= (primes 5) [2 3 5 7 11])
       (= (last (primes 100)) 541)))
