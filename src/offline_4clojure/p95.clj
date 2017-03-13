;; To Tree, or not to Tree - Easy
;; Write a predicate which checks whether or not a given sequence represents a
;; <a href="http://en.wikipedia.org/wiki/Binary_tree">binary tree</a>.
;; Each node in the tree must have a value, a left child, and a right child.
;; tags - trees
;; restricted - 
(ns offline-4clojure.p95
  (:use clojure.test))

(defn is-a-tree? [tree]
  (cond
    (nil? tree) true
    (and (coll? tree) (= (count tree) 3))
      (let [left (second tree)
            right (nth tree 2 :not-found)]
        (and (is-a-tree? left)
             (is-a-tree? right)))
    :else false))

(is-a-tree? '(:a nil nil))
(tree-seq '(:a (:b nil nil) nil))

(defn -main []
  (are [soln] soln
       (= (is-a-tree? '(:a (:b nil nil) nil))
          true)
       (= (is-a-tree? '(:a (:b nil nil)))
          false)
       (= (is-a-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
          true)
       (= (is-a-tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
          false)
       (= (is-a-tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
          true)
       (= (is-a-tree? [1 [2 [3 [4 false nil] nil] nil] nil])
          false)
       (= (is-a-tree? '(:a nil ()))
          false)))
