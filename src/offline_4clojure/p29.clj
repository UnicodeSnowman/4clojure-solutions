;; Get the Caps - Easy
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; tags - strings
;; restricted - 
(ns offline-4clojure.p29
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.spec.test :as stest])
  (:use clojure.test))

(defn caps [string]
  (clojure.string/replace string #"[a-z\W0-9]+" ""))

(def caps-better #(apply str (re-seq #"[A-Z]+" %)))
(s/fdef caps
        :args (s/cat :string string?)
        :ret string?)

(stest/check `caps)

(defn -main []
  (are [soln] soln
       (= (caps "HeLlO, WoRlD!") "HLOWRD")
       (empty? (caps "nothing"))
       (= (caps "$#A(*&987Zf") "AZ")))
