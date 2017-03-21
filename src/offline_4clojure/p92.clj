;; Read Roman numerals - Hard
;; Roman numerals are easy to recognize, but not everyone knows all the rules necessary to work with them. Write a function to parse a Roman-numeral string and return the number it represents.
;;<br /><br />
;;You can assume that the input will be well-formed, in upper-case, and follow the <a href="http://en.wikipedia.org/wiki/Roman_numerals#Subtractive_principle">subtractive principle</a>. You don't need to handle any numbers greater than MMMCMXCIX (3999), the largest number representable with ordinary letters.
;; tags - strings:math
;; restricted - 
(ns offline-4clojure.p92
  (:use clojure.test))

(defn __ [numeral]
  (let [val-map {"I" 1
                 "V" 5
                 "X" 10
                 "L" 50
                 "C" 100
                 "D" 500
                 "M" 1000}]
    (reduce
      (fn [acc v]
        (let [next-n (get val-map (str v))]
          (prn (get val-map (:last acc)))
         (if (< (get val-map (:last acc)) next-n)
           (assoc
             :sum (+
                   (- next-n (:last acc))
                   (- (:sum acc) (:last acc)))
             :last v)
           (assoc
             :sum (+ next-n (:sum acc))
             :last v))))
      {:sum 0
       :last 0}
      numeral)))

(defn -main []
  (are [soln] soln
       (= 14 (__ "XIV"))
       (= 827 (__ "DCCCXXVII"))
       (= 3999 (__ "MMMCMXCIX"))
       (= 48 (__ "XLVIII"))))
