;; Regular Expressions - Elementary
;; Regex patterns are supported with a special reader macro.
;; tags - regex:syntax
;; restricted - 
(ns offline-4clojure.p37
  (:use clojure.test))

(defn -main []
  (are [soln] soln
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))
