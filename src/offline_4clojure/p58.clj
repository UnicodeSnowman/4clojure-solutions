;; Function Composition - Medium
;; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
;; tags - higher-order-functions:core-functions
;; restricted - comp
(ns offline-4clojure.p58
  (:use clojure.test))

; I hate using `reverse` here, this is wrong (but it works)
(defn compose [& fns]
  (fn [& args]
    (first (reduce #(vector (apply %2 %1)) args (reverse fns)))))

; "official" solution is much nicer... essentially creating a nested
; set of function calls, which ends up solving the `reverse` issue 
; I complain about above

; (fn [& fs] (reduce (fn [f g] #(f (apply g %&))) fs)) ; returns a function...

(defn -main []
  (are [soln] soln
       (= [3 2 1] ((compose rest reverse) [1 2 3 4]))
       (= 5 ((compose (partial + 3) second) [1 2 3 4]))
       (= true ((compose zero? #(mod % 8) +) 3 5 7 9))
       (= "HELLO" ((compose #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))
