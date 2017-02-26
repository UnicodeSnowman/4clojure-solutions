;; Word Chains - Hard
;; A word chain consists of a set of words ordered so that each word differs by only one letter
;; from the words directly before and after it. The one letter difference can be either an
;; insertion, a deletion, or a substitution.
;; Here is an example word chain:
;; cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog
;;
;; Write a function which takes a sequence of words, and returns true if they can
;; be arranged into one continous word chain, and false if they cannot.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p82
  (:use clojure.test))

(defn lev-distance [s1 s2]
  (cond (empty? s1) (count s2)
        (empty? s2) (count s1)
        (= (first s1) (first s2)) (recur (rest s1) (rest s2))
        :else (inc (min (lev-distance (rest s1) s2)
                        (lev-distance s1 (rest s2))
                        (lev-distance (rest s1) (rest s2))))))

(defn possible-vals [word words]
  (filter #(= 1 (lev-distance word %)) words))

(defn build-chain [words neighbors-map visited current-word]
  (let [updated-visited (conj visited current-word)
        neighbors (remove updated-visited (neighbors-map current-word))]
    (if (= updated-visited words)
     true
     (some (partial build-chain words neighbors-map updated-visited) neighbors))))

(defn word-chain? [words]
  (let [neighbors-map (reduce (fn [acc word]
                                (assoc acc word (possible-vals word words))) {} words)]
    (boolean (some (partial build-chain words neighbors-map #{}) words))))

(defn -main []
  (are [soln] soln
       (= true (word-chain? #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
       (= false (word-chain? #{"cot" "hot" "bat" "fat"}))
       (= false (word-chain? #{"to" "top" "stop" "tops" "toss"}))
       (= true (word-chain? #{"spout" "do" "pot" "pout" "spot" "dot"}))
       (= true (word-chain? #{"share" "hares" "shares" "hare" "are"}))
       (= false (word-chain? #{"share" "hares" "hare" "are"}))))
