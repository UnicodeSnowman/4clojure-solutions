;; Palindrome Detector - Easy
;; Write a function which returns true if the given sequence is a palindrome.<br/><br>
;;                Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p27
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(defn palindrome? [values]
  (= (-> values reverse seq) (seq values)))

(s/fdef palindrome?
        :args (s/cat :values (s/or
                               :nums (s/coll-of number? :max-count 20)
                               :strings string?
                               :kws (s/coll-of keyword? :max-count 20)))
        :ret boolean?)

; these hang... need tighter specs and/or different generator(s)?
(stest/check `palindrome?)
(s/exercise-fn `palindrome?)

(defn -main []
  (are [soln] soln
       (false? (palindrome? '(1 2 3 4 5)))
       (true? (palindrome? "racecar"))
       (true? (palindrome? [:foo :bar :foo]))
       (true? (palindrome? '(1 1 3 3 1 1)))
       (false? (palindrome? '(:a :b :c)))))
