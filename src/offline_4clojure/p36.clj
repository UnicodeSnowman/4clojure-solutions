;; Let it Be - Elementary
;; Can you bind x, y, and z so that these are all true?
;; tags - math:syntax
;; restricted - 
(ns offline-4clojure.p36
  (:use clojure.test))

(def __
  (let [x 7
        y 3
        z 1]))

(defn -main []
  (are [soln] soln
(= 10 (let [x 7
            y 3] (+ x y)))
(= 4 (let [y 3
           z 1] (+ y z)))
(= 1 (let [z 1] z))))
