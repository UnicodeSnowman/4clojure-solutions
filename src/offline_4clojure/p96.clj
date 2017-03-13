;; Beauty is Symmetry - Easy
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the
;; right half of the tree.Write a predicate to determine whether or not a given binary tree is symmetric.
;; (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're
;; using).
;; tags - trees
;; restricted - 
(ns offline-4clojure.p96
  (:require [offline-4clojure.p95 :refer [is-a-tree?]])
  (:use clojure.test))

;; TODO FIXME
(prn is-a-tree?)

(defn symmetric-binary-tree? [tree]
(prn (nth tree 1))
(prn (nth tree 2))
  (and
    (is-a-tree? tree)
    (= (nth tree 1) (nth tree 2))))

(= [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
   [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil])

(defn -main []
  (are [soln] soln
(= (symmetric-binary-tree? '(:a (:b nil nil) (:b nil nil))) true)
(= (symmetric-binary-tree? '(:a (:b nil nil) nil)) false)
(= (symmetric-binary-tree? '(:a (:b nil nil) (:c nil nil))) false)
(= (symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                              [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)
(= (symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                              [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)
(= (symmetric-binary-tree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                              [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)))
