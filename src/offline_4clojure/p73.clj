;; Analyze a Tic-Tac-Toe Board - Hard
;; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe</a> board is represented by a two
;; dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.
;; A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.
;; Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won,
;; and nil if neither player has won.
;; tags - game
;; restricted - 
(ns offline-4clojure.p73
  (:use clojure.test))

(defn winning-side [values]
  (cond
    (every? #(= :x %) values) :x
    (every? #(= :o %) values) :o
    :else nil))

(defn rotate-matrix [rows]
  (apply mapv vector rows))

(defn row-win [rows]
  (some winning-side rows))

(def col-win
  (comp row-win rotate-matrix))

(defn diag-win [rows]
  (winning-side (map-indexed (fn [idx row] (nth row idx)) rows)))

(defn __ [brd]
  (some #(% brd) [row-win col-win diag-win (comp diag-win reverse)]))

(defn -main []
  (are [soln] soln
       (= nil (__ [[:e :e :e]
                   [:e :e :e]
                   [:e :e :e]]))
       (= :x (__ [[:x :e :o]
                  [:x :e :e]
                  [:x :e :o]]))
       (= :x (__ [[:x :x :x]
                  [:o :e :e]
                  [:o :e :o]]))
       (= :o (__ [[:e :x :e]
                  [:o :o :o]
                  [:x :e :x]]))
       (= nil (__ [[:x :e :o]
                   [:x :x :e]
                   [:o :x :o]]))
       (= :x (__ [[:x :e :e]
                  [:o :x :e]
                  [:o :e :x]]))
       (= :o (__ [[:x :e :o]
                  [:x :o :e]
                  [:o :e :x]]))
       (= nil (__ [[:x :o :x]
                   [:x :o :x]
                   [:o :x :o]]))))
