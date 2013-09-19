(ns clojure-art-exploration.core
(:use quil.core)
  (:require [clojure-art-exploration.dynamic :as dynamic]))

(defsketch example                
  :title "What is happening!?"
  :setup dynamic/setup           
  :draw dynamic/draw              
  :size [600 450]
)  

(defn -main [& args]
 example
)              

