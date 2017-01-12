;; Flatten a Sequence - Easy
;; Write a function which flattens a sequence.
;; tags - seqs:core-functions
;; restricted - flatten
(ns offline-4clojure.p28
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(defn my-flatten [[x & xs]]
  (cond
    (nil? x) '()
    (coll? x) (lazy-seq (my-flatten (concat x xs)))
    :else (cons x (lazy-seq (my-flatten xs)))))

(s/fdef my-flatten
        :args (s/cat :coll coll?)
        :ret coll?)

(clojure.repl/source flatten)

(s/exercise-fn `my-flatten)

; this hangs, need tighter specs and/or different generator(s)?
(stest/check `my-flatten)

(defn -main []
  (are [soln] soln
       (= (my-flatten '()) '())
       (= (my-flatten '(1 2)) '(1 2))
       (= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
       (= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c"))
       (= (my-flatten '((((:a))))) '(:a))))
