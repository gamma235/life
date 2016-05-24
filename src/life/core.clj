(ns life.core
  (:gen-class))

(def first-line (into (repeatedly 31 (fn [] false)) (into [true] (repeatedly 32 (fn [] false)))))

(defn get-neighbor [f coll index]
  (let [neighbor (f index 1)]
    (if-not (or (<  neighbor 0) (>  neighbor 63)) (nth coll neighbor))))

(defn oldline->newline [input]
  (loop [index 0
         left (get-neighbor - input index)
         right (get-neighbor + input index)
         new-line []]
    (if (== index 64) new-line
        (if (or (and (= left \*) (= right \*)) (and (= left \-) (= right \-)))
          (recur (inc index) (get-neighbor - input (inc index)) (get-neighbor + input (inc index)) (conj new-line \-))
          (recur (inc index) (get-neighbor - input (inc index)) (get-neighbor + input (inc index)) (conj new-line \*))))))

(defn -main []
  (loop [state (map #(if (true? %) \* \-) first-line)
         incr 0]
    (if (== incr 32) (println "GAME OVER!")
      (do (println state)
        (recur (oldline->newline state) (inc incr))))))
