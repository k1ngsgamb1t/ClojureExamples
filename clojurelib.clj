(ns clojurelib)

(defn add-matrix [m1 m2] 
    (doseq [i1 m1 i2 m2] (println (into [] (map + i1 i2)))))

(defn print-matrix [matrix]
   (doseq [item matrix] (println item)))
  
(defn str2int [txt]
  (if (number? (read-string txt)) txt 100))

(defn fib [maxVal]
(loop [start [0 1]]                                                                                                                                                                    
  (if (<= maxVal (last start))                                                                                                                                                                                                                         
    (drop-last start)                                                                                                                                                                                                                                  
    (recur (let [subvector (subvec start (- (count start) 2))                                                                                                                                                                               
                x (nth subvector 0)                                                                                                                                                                                                        
                y (nth subvector 1)                                                                                                                                                                                                        
                z (+ x y)]                                                                                                                                                                                                                 
             (conj start z))                                                                                                                                                                                                               
          ))))

(defn- bubble [ys x]
  (if-let [y (peek ys)]
    (if (> y x)
      (conj (pop ys) x y)
      (conj ys x))
    [x]))

(defn bubble-sort [xs]
  (let [ys (reduce bubble [] xs)]
    (if (= xs ys)
      xs
      (do (println ys) (recur ys)))))

 (defn generate-vector [size maxval]
  (into [] (repeatedly size #(rand-int maxval))))    

(defn generate-matrix [nrows ncols maxval]
  (repeatedly nrows (fn [] (generate-vector ncols maxval))))
 