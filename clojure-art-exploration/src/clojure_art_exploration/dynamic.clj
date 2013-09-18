(ns clojure-art-exploration.dynamic
  (:use quil.core))

(defn setup []
  (smooth)
  (frame-rate 20)
  ;;(load-image "rubber-ducks.jpg")
  ;;(background-image "rubber-ducks.jpg")
  (background (random 255)(random 255)(random 255)))

(defn draw []
  (stroke (random 255)(random 255)(random 255))
  (stroke-weight (random 10))
  (fill (random 255)(random 255)(random 255))
  (let [diam (random 100)
        x    (random (width))
        y    (random (height))
        z    (random 20)]
    (rect x y diam diam)
    (triangle x y y x z diam)))
