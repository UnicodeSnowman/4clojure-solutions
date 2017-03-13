;; Pascal's Triangle - Easy
;; <a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle
;; of numbers computed using the following rules:<br/></br>- The first row is 1.</br>-
;; Each successive row is computed by adding together adjacent numbers in the row above,
;; and adding a 1 to the beginning and end of the row.<br/><br/>Write a function which returns
;; the nth row of Pascal's Triangle.
;;
;; tags - 
;; restricted - 
(ns offline-4clojure.p97
  (:use clojure.test))

(defn- triangle-for-row [row]
  (map
   #(apply + %)
   (concat
     '((0 1))
     (partition 2 1 row)
     '((0 1)))))

(defn p-triangle [x]
  (last (take x (iterate triangle-for-row '(1)))))

(defn -main []
  (are [soln] soln
(= (p-triangle 1) [1])
(= (map p-triangle (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])
(= (p-triangle 11)
   [1 10 45 120 210 252 210 120 45 10 1])))
