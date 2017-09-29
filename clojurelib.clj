(ns clojurelib)

(defn do-something-cool [v]
    (println v))
  
(defn str2int [txt]
  (if (number? (read-string txt)) txt 100))