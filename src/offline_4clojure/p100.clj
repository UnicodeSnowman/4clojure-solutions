;; Least Common Multiple - Easy
;; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.
;; Your function should accept a variable number of positive integers or ratios. 
;; tags - math
;; restricted - 
(ns offline-4clojure.p100
  (:use clojure.test))

(defn least-common-multiple [& nums]
  (let [max-val (apply max nums)
        f (fn [lcm]
            (if (every? #(zero? (mod lcm %)) nums)
              lcm
              (recur (+ lcm max-val))))]
    (f max-val)))

(defn -main []
  (are [soln] soln
       (== (least-common-multiple 2 3) 6)
       (== (least-common-multiple 5 3 7) 105)
       (== (least-common-multiple 1/3 2/5) 2)
       (== (least-common-multiple 3/4 1/6) 3/2)
       (== (least-common-multiple 7 5/7 2 3/5) 210)))
