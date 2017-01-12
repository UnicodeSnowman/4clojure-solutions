;; Find the odd numbers - Easy
;; Write a function which returns only the odd numbers from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p25
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen])
  (:use clojure.test))

(defn filter-odd [xs] (filter odd? xs))

(s/def ::num-collection (s/coll-of int?))
(s/fdef filter-odd
  :args (s/cat :xs ::num-collection)
  :fn #(<= (count (:ret %)) (count (-> % :args :xs)))
  :ret ::num-collection)

(defn -main []
  (are [soln] soln
(= (filter-odd #{1 2 3 4 5}) '(1 3 5))
(= (filter-odd [4 2 1 6]) '(1))
(= (filter-odd [2 2 4 6]) '())
(= (filter-odd [1 1 1 3]) '(1 1 1 3))))
