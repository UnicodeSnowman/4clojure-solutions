;; Drop Every Nth Item - Easy
;; Write a function which drops every Nth item from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p41
  (:use clojure.test))

(defn drop-every-nth [xs n]
  (mapcat #(take (dec n) %) (partition-all n xs)))

(defn drop-every-nth-naive [xs n]
  (if (empty? xs)
    xs
    (concat (take (dec n) xs)
            (lazy-seq (drop-every-nth-naive (drop n xs) n)))))

(defn -main []
  (are [soln] soln
       (= (drop-every-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
       (= (drop-every-nth [:a :b :c :d :e :f] 2) [:a :c :e])
       (= (drop-every-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])))
