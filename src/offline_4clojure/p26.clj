;; Fibonacci Sequence - Easy
;; Write a function which returns the first X fibonacci numbers.
;; tags - Fibonacci:seqs
;; restricted - 
(ns offline-4clojure.p26
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(defn __ [n]
  (letfn [(iter [a b]
    (lazy-seq
      (cons b (iter b (+ a b)))))]
        (take n (concat '(1) (iter 1 1)))))

; cooler solution
(defn fib-lazy [n]
  (take n (map
            first
            (iterate ; iterate returns passed value first time, which is how we get first and second value of 1
              (fn [[a b]] [b (+ a b)])
              [1 1]))))

(s/def ::fib-sequence (s/and
                        (s/coll-of int?)
                        #(every? pos? %)
                        (fn [x] (or
                                  (zero? (count x))
                                  (apply <= x)))))

(s/fdef __
        :args (s/cat :n (s/and int? pos?))
        :fn #(= (count (:ret %))
                (-> % :args :n))
        :ret ::fib-sequence)

(s/exercise-fn `__)
(stest/check `__)
(s/exercise ::fib-sequence)

(defn -main []
  (are [soln] soln
(= (__ 0) '())
(= (__ 2) '(1 1))
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21))))
