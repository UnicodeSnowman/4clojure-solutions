;; Power Set - Medium
;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
;; tags - set-theory
;; restricted - 
(ns offline-4clojure.p85
  (:use clojure.test))

(defn power-set [s])

(defn -main []
  (are [soln] soln
       (= (power-set #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
       (= (power-set #{}) #{#{}})
       (= (power-set #{1 2 3})
          #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
       (= (count (power-set (into #{} (range 10)))) 1024)))

; 000
; 001
; 010
; 011
; ...etc
; (nth (into [] #{1 3 2}) 0)
