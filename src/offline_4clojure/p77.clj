;; Anagram Finder - Medium
;; Write a function which finds all the anagrams in a vector of words.
;; A word x is an anagram of word y if all the letters in x can be rearranged 
;; in a different order to form y.
;; Your function should return a set of sets, where each sub-set is a group of
;; words which are anagrams of each other.
;; Each sub-set should have at least two words. 
;; Words without any anagrams should not be included in the result.
;; tags - 
;; restricted - 
(ns offline-4clojure.p77
  (:use clojure.test))

; are there better set-specific operations (equivalents of filter, map, etc.) so that I 
; don't need to wrap everything in `set`?
(defn find-anagrams [words]
  (set
    (filter
      #(> (count %) 1)
      (reduce (fn [acc word]
                (let [sorted (sort word)]
                  (conj
                    acc
                    (set (filterv #(= sorted (sort %)) words)))))
              #{} words))))

;; "official" solution is way more elegant... composition FTW
(defn find-anagrams-better [words]
  (set
    (map
     (comp set val)
     (remove
       (comp #{1} count val)
       (group-by frequencies words)))))

(defn -main []
  (are [soln] soln
       (= (find-anagrams ["meat" "mat" "team" "mate" "eat"])
          #{#{"meat" "team" "mate"}})
       (= (find-anagrams-better ["meat" "mat" "team" "mate" "eat"])
          #{#{"meat" "team" "mate"}})
       (= (find-anagrams ["veer" "lake" "item" "kale" "mite" "ever"])
          #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))
