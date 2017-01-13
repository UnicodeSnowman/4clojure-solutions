;; Interpose a Seq - Easy
;; Write a function which separates the items of a sequence by an arbitrary value.
;; tags - seqs:core-functions
;; restricted - interpose
(ns offline-4clojure.p40
  (:use clojure.test)
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest]))

(defn my-interpose [v xs]
  (butlast (mapcat #(vector % v) xs)))

(s/def ::collection (s/or :strings (s/coll-of string?)
                                        :ints (s/coll-of int?)
                                        :kws (s/coll-of keyword?)))

(s/fdef my-interpose
        :args (s/cat :v any? :seq ::collection)
        :ret (s/nilable (s/coll-of any?)))

(stest/check `my-interpose {:clojure.spec.test.check/opts {:max-size 5}})
(s/exercise-fn `my-interpose 10)
(gen/generate (s/gen (s/and (s/coll-of any? :count 2))))

(defn -main []
  (are [soln] soln
       (= (my-interpose {} []) [1 0 2 0 3])
       (= (my-interpose 0 [1 2 3]) [1 0 2 0 3])
       (= (apply str (my-interpose ", " ["one" "two" "three"])) "one, two, three")
       (= (my-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))
