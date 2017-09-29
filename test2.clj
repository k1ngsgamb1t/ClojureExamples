(ns example.simpleread
  (:require [clojurelib :as lib]))



  (defn -main
    "Read from STDIN"
    [& args]
    (println "Enter text:")
  
    (loop [input (read-line) acc []]
      (if (= ":done" input)
        (lib/do-something-cool acc)
        (recur (read-line) (conj acc input))))
  
    (println "End"))

( #(println %)  "Hello world!" )

(loop [input (read-line) val 1] 
;(if (or (= ":exit" input) (< (lib/str2int input) 5)) 
;    (println "First!")   
    (recur (read-line) (println (reduce (fn [a v] (+ a v)) (range input)))))
    
