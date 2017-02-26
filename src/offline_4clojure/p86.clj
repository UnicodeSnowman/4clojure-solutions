;; Happy numbers - Medium
;; Happy numbers are positive integers that follow a particular formula:
;; take each individual digit, square it, and then sum the squares to get a new number.
;; Repeat with the new number and eventually, you might get to a number whose squared sum is 1.
;; This is a happy number. An unhappy number (or sad number) is one that loops endlessly.
;; Write a function that determines if a number is happy or not.
;; tags - math
;; restricted - 
(ns offline-4clojure.p86
  (:use clojure.test))


(defn digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

; could also do this for digits...
; (defn digits [n]
;   (if (zero? n)
;     nil
;     (cons (int (mod n 10))
;           (digits (Math/floor (/ n 10))))))

; my solution "works" (or it could work, just need an ending condition). that being said,
; the "official" solution is fucking genius... below
(defn happy? [n]
  (let [sum-of-squares (reduce #(+ %1 (int (Math/pow %2 2))) 0 (digits n))]
    (if (= 1 sum-of-squares)
      true
      (recur sum-of-squares))))

(defn sum-of-squares [n]
  (reduce #(+ %1 (int (Math/pow %2 2))) 0 (digits n)))

; here, a couple smart things... use `iterate` to just call `sum-of-squares` forever,
; but only take 100 (assume that after 100 iterations, this number isn't going to be happy)
; then use some to find value. awesome thing is that it will only iterate the necessary
; number of times (some happily accepts a lazy seq) until it gets a 1.
; FUCKING COOL
(defn happy-official? [n]
  (boolean (some #{1} (take 100 (iterate sum-of-squares n)))))

(defn -main []
  (are [soln] soln
       (= (happy? 7) true)
       (= (happy? 986543210) true)
       (= (happy? 2) false)
       (= (happy? 3) false)))

(digits 986543210)
(digits 47)
(Math/floor (/ 7 10))
(/ 986543210 10)
