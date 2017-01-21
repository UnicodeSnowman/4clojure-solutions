;; Find Distinct Items - Medium
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; tags - seqs:core-functions
;; restricted - distinct
(ns offline-4clojure.p56
  (:use clojure.test))

(defn distinct-items [xs]
  (reduce (fn [acc x]
            (if (some #(= x %) acc)
              acc
              (conj acc x))) [] xs))

(defn -main []
  (are [soln] soln
       (= (distinct-items [1 2 1 3 1 2 4]) [1 2 3 4])
       (= (distinct-items [:a :a :b :b :c :c]) [:a :b :c])
       (= (distinct-items '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
       (= (distinct-items (range 50)) (range 50))))
