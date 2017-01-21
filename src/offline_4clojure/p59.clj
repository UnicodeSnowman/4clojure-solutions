;; Juxtaposition - Medium
;; Take a set of functions and return a new function that takes a variable number of arguments and returns
;; a sequence containing the result of applying each function left-to-right to the argument list.
;; tags - higher-order-functions:core-functions
;; restricted - juxt
(ns offline-4clojure.p59
  (:use clojure.test))

(defn juxtaposition [& fns]
  (fn [& args]
    (map #(apply % args) fns)))

(defn -main []
  (are [soln] soln
       (= [21 6 1] ((juxtaposition + max min) 2 3 5 1 6 4))
       (= ["HELLO" 5] ((juxtaposition #(.toUpperCase %) count) "hello"))
       (= [2 6 4] ((juxtaposition :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))
