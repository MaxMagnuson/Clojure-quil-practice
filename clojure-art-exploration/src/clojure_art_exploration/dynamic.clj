(ns clojure-art-exploration.dynamic
  (:use quil.core))

(defn setup []
  (smooth)
  (frame-rate 1000)
  
  ;;(background (random 255)(random 255)(random 255))
   )

(defn draw []
  (stroke (random 255)(random 255)(random 255))
  (stroke-weight (random 10))
  (fill (random 255)(random 255)(random 255))
  ;;(let [diam (random 100)
  ;;      x    (random (width))
  ;;      y    (random (height))
  ;;      z    (random 20)]
 (set-image (frame-count) (frame-count) (load-image "rubber-ducks.jpg")))
  ;;(rect (* 5 (frame-count)) (* 5 (frame-count)) 20 20))
