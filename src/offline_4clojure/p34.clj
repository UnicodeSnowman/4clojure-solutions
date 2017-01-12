;; Implement range - Easy
;; Write a function which creates a list of all integers in a given range.
;; tags - seqs:core-functions
;; restricted - range
(ns offline-4clojure.p34
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(defn my-range [start end]
  (take (- end start)
        (cons start
              (lazy-seq (my-range (inc start) end)))))

(s/fdef my-range
        :args (s/cat :start integer? :end integer?)
        :fn #(<= (-> % :args :start) (-> % :args :end))
        :ret seq?)
; (take (- %2 %1) (iterate inc %1)) ; woah...
(s/exercise-fn `my-range) ;? :fn doesn't seem to work right now?

(defn -main []
  (are [soln] soln
       (= (my-range 1 4) '(1 2 3))
       (= (my-range -2 2) '(-2 -1 0 1))
       (= (my-range 5 8) '(5 6 7))))
