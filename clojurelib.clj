(ns clojurelib)

(defn print-matrix [matrix]
   (for [row matrix]
      (do (println row) (for [col row] (println col)))))
  
(defn str2int [txt]
  (if (number? (read-string txt)) txt 100))


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
  (repeatedly size #(rand-int maxval)))    

(defn generate-matrix [nrows ncols maxval]
  (repeatedly nrows (fn [] (generate-vector ncols maxval))))
 