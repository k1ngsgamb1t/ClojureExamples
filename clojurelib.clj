(ns clojurelib)

(defn do-something-cool [v]
    (println v))
  
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
  (take size (repeatedly #(rand-int maxval))))     