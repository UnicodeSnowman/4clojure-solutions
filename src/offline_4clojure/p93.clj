;; Partially Flatten a Sequence - Medium
;; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.),
;; but maintains the lowest level sequential items. The result should be a sequence of sequences with
;; only one level of nesting.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p93
  (:use clojure.test))

(defn partial-flatten [xs]
  (remove
    empty?
    (if (not-any? coll? xs)
      [xs]
      (concat
        (partial-flatten (first xs))
        (partial-flatten (rest xs))))))

(defn partial-flatten-better [tree]
  (if (every? sequential? tree)
    (mapcat partial-flatten-better tree)
    [tree]))

; (partial-flatten-better [[[[:a :b]]] [[:c :d]] [:e :f]])
; (partial-flatten-better '((1 2)((3 4)((((5 6)))))))

(defn -main []
  (are [soln] soln
       (= (partial-flatten [["Do"] ["Nothing"]])
          [["Do"] ["Nothing"]])
       (= (partial-flatten [[[[:a :b]]] [[:c :d]] [:e :f]])
          [[:a :b] [:c :d] [:e :f]])
       (= (partial-flatten '((1 2)((3 4)((((5 6)))))))
          '((1 2)(3 4)(5 6)))))
