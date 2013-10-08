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
      flameYpos (- (screen-height) (* (frame-count) 20))
      pi (/ 22 7)]
   
   ;; Thrusters
   (fill 128 128 128)
   (stroke 128 128 128)
   (arc (+ 5 flameXpos) (+ flameYpos 15) 25 25 pi (* 2 pi))
   (arc (+ 40 flameXpos) (+ flameYpos 15) 25 25 pi (* 2 pi))
   (arc (+ 75 flameXpos) (+ flameYpos 15) 25 25 pi (* 2 pi))

   (if (= (mod (frame-count) 2) 0)	
   	(do (fill 255 127 0)
        (stroke 220 20 60)
	(begin-shape :triangles)
		(triangle (- flameXpos 7.5) (+ flameYpos 15) (+ flameXpos 5) (+ flameYpos 50) (+ flameXpos 17.5)  (+ flameYpos 15) ) 
                (triangle (+ flameXpos 27.5) (+ flameYpos 15) (+ flameXpos 40) (+ flameYpos 50) (+ flameXpos 52.5)  (+ flameYpos 15) ) 
        	(triangle (+ flameXpos 62.5) (+ flameYpos 15) (+ flameXpos 75) (+ flameYpos 50) (+ flameXpos 87.5)  (+ flameYpos 15) ) ) 

   	(end-shape))
   )
)

(defn drawDot []
  	(ellipse (+ (random 80) 1500) (+ (random 80) 200) 5 5)
)

(defn drawMoon []
  (fill 220 220 220)
  (stroke-weight 5)
  (stroke 0 0 0)
  (arc 1500 200 200 200 0 6.283)
  ;;(ellipse (+ (random 75) 1500) (+ (random 75) 200) 3 3)
  ;;(ellipse (+ (random 75) 1500) (+ (random 75) 200) 3 3)
  ;;(ellipse (+ (random 75) 1500) (+ (random 75) 200) 3 3)
  ;;(ellipse (+ (random 75) 1500) (+ (random 75) 200) 3 3)
  ;;(ellipse (+ (random 75) 1500) (+ (random 75) 200) 3 3)

  ;;(ellipse (+ (random 75) 1500) (- 200 (random 75)) 3 3)
  ;;(ellipse (+ (random 75) 1500) (- 200 (random 75)) 3 3)
  ;;(ellipse (+ (random 75) 1500) (- 200 (random 75)) 3 3)
  ;;(ellipse (+ (random 75) 1500) (- 200 (random 75)) 3 3)
  ;;(ellipse (+ (random 75) 1500) (- 200 (random 75)) 3 3)

  ;;(ellipse (- 1500 (random 75)) (+ (random 75) 200) 3 3)
  ;;(ellipse (- 1500 (random 75)) (+ (random 75) 200) 3 3)
  ;;(ellipse (- 1500 (random 75)) (+ (random 75) 200) 3 3)
  ;;(ellipse (- 1500 (random 75)) (+ (random 75) 200) 3 3)
  ;;(ellipse (- 1500 (random 75)) (+ (random 75) 200) 3 3)

  ;;(ellipse (- 1500 (random 75)) (- 200 (random 75)) 3 3)
  ;;(ellipse (- 1500 (random 75)) (- 200 (random 75)) 3 3)
  ;;(ellipse (- 1500 (random 75)) (- 200 (random 75)) 3 3)
  ;;(ellipse (- 1500 (random 75)) (- 200 (random 75)) 3 3)
  ;;(ellipse (- 1500 (random 75)) (- 200 (random 75)) 3 3)
  (doall (map (fn[f] (f)) (take 20 (repeat drawDot))))
  ;;(doall (take 20 (repeat (ellipse (- (random 80) 1500) (- (random 80) 200) 5 5))))	
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
  (rect rocketXposition rocketAscension widthBody heightBody)
  (triangle (- rocketXposition 20) (+ rocketAscension 1) (+ rocketXposition 40) (- rocketAscension 40) (+ rocketXposition 100) (+ rocketAscension 1)))
  (drawFlames)
)

(defn seizure []
  (stroke-weight (random 10))
  (fill (random 255)(random 255)(random 255))
  (frame-rate 30) 
  (text-font (create-font "Utopia Italic" (random 250) true))
  (if (= (mod (frame-count) 10) 0)  
	(text "CLOJURE!!!" (random 800) (random 800)) 
	(do (background (random 255)(random 255)(random 255))(set-image (+ 850 (random 35)) (+ 400 (random 35)) (load-image "nick-cage-as-a-baby.jpg")) ) )
)

(defn draw []
  (if (< (frame-count) 60)
  	      (do (background 0 255 255 75) 
              (drawMoon)
              (fill 255 0 0)
              (text-font (create-font "Liberation Serif Bold" 250 true))
              (text "America!" 100 600)
              (drawRocket))
    
    ;;(seizure)  
  )
  ;;(if (= (frame-count) 200) (System/exit 0))
)


