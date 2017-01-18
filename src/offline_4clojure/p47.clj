;; Contain Yourself - Easy
;; The contains? function checks if a KEY is present in a given collection.  This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.
;; tags - 
;; restricted - 
(ns offline-4clojure.p47
  (:use clojure.test))

(def answer 4)

(defn -main []
  (are [soln] soln
       (contains? #{4 5 6} answer)
       (contains? [1 1 1 1 1] answer)
       (contains? {4 :a 2 :b} answer)
       (not (contains? [1 2 4] answer))))
