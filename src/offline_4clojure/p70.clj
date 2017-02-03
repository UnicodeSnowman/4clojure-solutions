;; Word Sorting - Medium
;; Write a function that splits a sentence up into a sorted list of words.
;; Capitalization should not affect sort order and punctuation should be ignored.
;; tags - sorting
;; restricted - 
(ns offline-4clojure.p70
  (:use clojure.test))

(defn sorter [string]
  (sort
    #(compare (.toLowerCase %1) (.toLowerCase %2))
    (clojure.string/split string #"[\W]")))

; coolor, simpler solution, just pass clojure.string/lower-case as comparator
; to sort-by
; (defn sorter [string]
;   (sort-by
;     clojure.string/lower-case
;     (clojure.string/split string #"[\W]")))

(defn -main []
  (are [soln] soln
       (= (sorter  "Have a nice day.")
          ["a" "day" "Have" "nice"])
       (= (sorter  "Clojure is a fun language!")
          ["a" "Clojure" "fun" "is" "language"])
       (= (sorter  "Fools fall for foolish follies.")
          ["fall" "follies" "foolish" "Fools" "for"])))
