;; Filter Perfect Squares - Medium
;; Given a string of comma separated integers, write a function which returns a new comma separated string
;; that only contains the numbers which are perfect squares.
;; tags - 
;; restricted - 
(ns offline-4clojure.p74
  (:use clojure.test))

; NOTE could also use
; (= (Math/sqrt n) (Math/floor (Math/sqrt n)))
; to check for perfect square
(defn perfect-square? [n]
  (zero? (mod (Math/sqrt n) 1.0)))

(defn perfect-squares [s]
  (->> (clojure.string/split s #",")
       (mapv #(Integer/parseInt %))
       (filter perfect-square?)
       (clojure.string/join ",")))

(defn -main []
  (are [soln] soln
       (= (perfect-squares "4,5,6,7,8,9") "4,9")
       (= (perfect-squares "15,16,25,36,37") "16,25,36")))
