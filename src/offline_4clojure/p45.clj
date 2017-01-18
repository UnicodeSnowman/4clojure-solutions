;; Intro to Iterate - Easy
;; The iterate function can be used to produce an infinite lazy sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p45
  (:use clojure.test))

(def answer [1 4 7 10 13])

(defn -main []
  (are [soln] soln
       (= answer (take 5 (iterate #(+ 3 %) 1)))))
