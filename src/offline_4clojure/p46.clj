;; Flipping out - Medium
;; Write a higher-order function which flips the order of the arguments of an input function.
;; tags - higher-order-functions
;; restricted - 
(ns offline-4clojure.p46
  (:use clojure.test))

(defn flip [f]
  (fn [& args]
    (apply f (reverse args))))

(defn -main []
  (are [soln] soln
       (= 3 ((flip nth) 2 [1 2 3 4 5]))
       (= true ((flip >) 7 8))
       (= 4 ((flip quot) 2 8))
       (= [1 2 3] ((flip take) [1 2 3 4 5] 3))))

