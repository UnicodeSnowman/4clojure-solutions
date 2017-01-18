;; Split a sequence - Easy
;; Write a function which will split a sequence into two parts.
;; tags - seqs:core-functions
;; restricted - split-at
(ns offline-4clojure.p49
  (:use clojure.test))

(defn split-in-two [idx xs]
          (vector (take idx xs) (drop idx xs)))

(defn -main []
  (are [soln] soln
       (= (split-in-two 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
       (= (split-in-two 1 [:a :b :c :d]) [[:a] [:b :c :d]])
       (= (split-in-two 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))
