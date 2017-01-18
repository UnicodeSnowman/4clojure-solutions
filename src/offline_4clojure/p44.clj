;; Rotate Sequence - Medium
;; Write a function which can rotate a sequence in either direction.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p44
  (:use clojure.test))

(defn rotate [n xs]
  (let [offset (mod n (count xs))]
   (take (count xs) (drop offset (cycle xs)))))

(defn -main []
  (are [soln] soln
       (= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))
       (= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))
       (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))
       (= (rotate 1 '(:a :b :c)) '(:b :c :a))
       (= (rotate -4 '(:a :b :c)) '(:c :a :b))))
