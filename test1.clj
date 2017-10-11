(ns example.simpleread
    (:require [clojurelib :as lib]))

(comment
(defn run [nvecs nitems nthreads niters]
    (let [vec-refs (->> (range (* nvecs nitems)) (partition nitems) (map (comp ref vec)) vec)
            swap #(let [v1 (rand-int nvecs)
                        v2 (rand-int nvecs)
                        i1 (rand-int nitems)
                        i2 (rand-int nitems)]
                    (dosync
                    (let [tmp (nth @(vec-refs v1) i1)]
                        (alter (vec-refs v1) assoc i1 (nth @(vec-refs v2) i2))
                        (alter (vec-refs v2) assoc i2 tmp))))
            report #(let [derefed (map deref vec-refs)]
                    (prn derefed)
                    (println "Distinct:" (->> derefed (apply concat) distinct count)))]
        (report)
        (dorun (apply pcalls (repeat nthreads #(dotimes [_ niters] (swap)))))
        (report)))
)
;(run 10 10 10 100000)
(println (lib/fib 100))

;(let [matrix1 (lib/generate-matrix 2 2 10)
;      matrix2 (lib/generate-matrix 2 2 10)]
;    (do (lib/print-matrix matrix1)
;       (newline)
;       (lib/print-matrix matrix2)
;       (newline)       
;       (println (lib/add-matrix matrix1 matrix2))))

;(let [size 10 maxval 10]
;(map println
;     (lib/bubble-sort  (lib/generate-vector size maxval)))
;)
