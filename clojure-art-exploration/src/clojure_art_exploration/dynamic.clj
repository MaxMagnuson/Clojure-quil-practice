(ns clojure-art-exploration.dynamic
  (:use quil.core))

(defn setup []
  (smooth)
  (frame-rate 5)
(background 0 255 255) 
(fill 255 0 0)
(text-font (create-font "Liberation Serif Bold" 250 true))
(text "America!" 100 600)
   )

(defn drawRocket []
  (frame-rate (frame-count))
  (stroke 255)
  (stroke-weight 10)
  (fill 220 20 60)
  (let [widthBody 80 
	heightBody 120
        rocketXposition 880
        rocketAscension (- (- (screen-height) heightBody) (* (frame-count) 20))] 
  (rect rocketXposition (- (- (screen-height) heightBody) (* (frame-count) 20)) widthBody heightBody)
  (triangle (- rocketXposition 20) (+ rocketAscension 1) (+ rocketXposition 40) (- rocketAscension 40) (+ rocketXposition 100) (+ rocketAscension 1)))
)

(defn seizure []
  (stroke-weight (random 10))
  (fill (random 255)(random 255)(random 255))
  (frame-rate 30) 
  (text-font (create-font "Utopia Italic" (random 250) true))
  (if (= (mod (frame-count) 10) 0) (text "CLOJURE!!!" (random 800) (random 800)) (background (random 255)(random 255)(random 255)) )
)

(defn draw []
  ;;(let [diam (random 100)
  ;;      x    (random (width))
  ;;      y    (random (height))
  ;;      z    (random 20)]
  (if (< (frame-count) 60)
    (if (= (mod (frame-count) 2) 0)
	  (drawRocket)
  	  (do (background 0 255 255) 
              (fill 255 0 0)
              (text-font (create-font "Liberation Serif Bold" 250 true))
              (text "America!" 100 600))
    )
    (seizure)  
  )
  ;;(if (= (mod (frame-count) 10) 0) (set-image (* 5 (frame-count)) (* 2 (frame-count)) (load-image "rubber-ducks.jpg")))
  
  ;;(if (= (mod (frame-count) 5) 0) (rect (* 5 (frame-count)) (* 5 (frame-count)) 20 20))
  ;;(if (= (frame-count) 50) (System/exit 0))
)


