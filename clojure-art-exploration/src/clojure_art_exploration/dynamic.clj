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

(defn drawFlames []
(stroke-weight 5)
(stroke 220 20 60)
(let [flameXpos 880
      flameYpos (- (screen-height) (* (frame-count) 20))]
   (if (= (mod (frame-count) 2) 0)	
   	(do (begin-shape :triangles)
		(triangle flameXpos flameYpos (- flameXpos 20) (+ (+ flameYpos 30) (* (frame-count) 2) ) (- flameXpos 10) (+ (+ flameYpos 10) (* (frame-count) 2) ) )
		(triangle (+ flameXpos 10) flameYpos (- flameXpos 10) (+ (+ flameYpos 10) (* (frame-count) 2) ) (- flameXpos 10) (+ (+ flameYpos 45) (* (frame-count) 2) ))
        	(triangle (+ flameXpos 20) flameYpos (+ flameXpos 20) (+ (+ flameYpos 45) (* (frame-count) 2) ) (- flameXpos 66) (+ (+ flameYpos 80) (* (frame-count) 2) ))
        	(triangle (+ flameXpos 60) flameYpos (+ flameXpos 60) (+ (+ flameYpos 45)(* (frame-count) 2) ) (+ flameXpos 66) (+ (+ flameYpos 80) (* (frame-count) 2) ))
		(triangle (+ flameXpos 70) flameYpos (+ flameXpos 80) (+ (+ flameYpos 10) (* (frame-count) 2) ) (+ flameXpos 20) (+ (+ flameYpos 90) (* (frame-count) 2) ))
        	(triangle (+ flameXpos 80) flameYpos (+ flameXpos 100) (+ (+ flameYpos 30) (* (frame-count) 2) ) (+ flameXpos 120) (+ (+ flameYpos 30) (* (frame-count) 2) ))        
   	(end-shape))
   	(do (begin-shape :lines)
		(line flameXpos flameYpos (- flameXpos 20) (+ (+ flameYpos 15) (* (frame-count) 2) ) )
		(line (+ flameXpos 10) flameYpos (- flameXpos 10) (+ (+ flameYpos 5) (* (frame-count) 2) ) )
        	(line (+ flameXpos 20) flameYpos (+ flameXpos 20) (+ (+ flameYpos 25) (* (frame-count) 2) ) )
        	(line (+ flameXpos 60) flameYpos (+ flameXpos 60) (+ (+ flameYpos 25)(* (frame-count) 2) ) )
		(line (+ flameXpos 70) flameYpos (+ flameXpos 80) (+ (+ flameYpos 5) (* (frame-count) 2) ) )
        	(line (+ flameXpos 80) flameYpos (+ flameXpos 100) (+ (+ flameYpos 15) (* (frame-count) 2) ) )        
   	(end-shape))
   ))
)

(defn drawRocket []
  (frame-rate (frame-count))
  (stroke 255 (* (frame-count) 7))
  (stroke-weight 10)
  (fill 220 20 60 (* (frame-count) 7))
  (let [widthBody 80 
	heightBody 120
        rocketXposition 880
        rocketAscension (- (- (screen-height) heightBody) (* (frame-count) 20))] 
  (rect rocketXposition rocketAscension widthBody heightBody)
  (triangle (- rocketXposition 20) (+ rocketAscension 1) (+ rocketXposition 40) (- rocketAscension 40) (+ rocketXposition 100) (+ rocketAscension 1)))
  (drawFlames)
)

(defn seizure []
  (stroke-weight (random 10))
  (fill (random 255)(random 255)(random 255))
  (frame-rate 30) 
  (text-font (create-font "Utopia Italic" (random 250) true))
  (if (= (mod (frame-count) 10) 0) (text "CLOJURE!!!" (random 800) (random 800)) (background (random 255)(random 255)(random 255)) )
)

(defn draw []
  (if (< (frame-count) 60)
  	      (do (background 0 255 255 75) 
              (fill 255 0 0)
              (text-font (create-font "Liberation Serif Bold" 250 true))
              (text "America!" 100 600)
              (drawRocket))
    
    (seizure)  
  )
  (if (= (frame-count) 200) (System/exit 0))
)


