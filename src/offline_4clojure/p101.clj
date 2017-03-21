;; Levenshtein Distance - Hard
;; Given two sequences x and y, calculate the <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Levenshtein_distance">Levenshtein distance</a> of x and y, i. e. the minimum number of edits needed to transform x into y.  The allowed edits are:<br/><br/>- insert a single item<br/>- delete a single item<br/>- replace a single item with another item<br/><br/>WARNING: Some of the test cases may timeout if you write an inefficient solution!
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p101
  (:use clojure.test))

(defn __ [s1 s2]
  (cond (empty? s1) (count s2)
        (empty? s2) (count s1)
        (= (first s1) (first s2)) (recur (rest s1) (rest s2))
        :else (inc (min (__ (rest s1) s2)
                        (__ s1 (rest s2))
                        (__ (rest s1) (rest s2))))))

(defn -main []
  (are [soln] soln
       (= (__ "kitten" "sitting") 3)
       (= (__ "closure" "clojure") (__ "clojure" "closure") 1)
       (= (__ "xyx" "xyyyx") 2)
       (= (__ "" "123456") 6)
       (= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0)
       (= (__ [1 2 3 4] [0 2 3 4 5]) 2)
       (= (__ '(:a :b :c :d) '(:a :d)) 2)
       (= (__ "ttttattttctg" "tcaaccctaccat") 10)
       (= (__ "gaattctaatctc" "caaacaaaaaattt") 9)))
