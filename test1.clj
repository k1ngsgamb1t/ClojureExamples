(ns example.simpleread
    (:require [clojurelib :as lib]))

(defn square [x]
    (* x x))

(defn sum [x y]
    *(+ x x) y)

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


(defn run_mult_sort [nvecs nsize nthreads]
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
        (dorun (apply pcalls (repeat nthreads #(lib/bubble-sort vect))))
        (report)))
;(run 10 10 10 100000)
run_mult_sort(1 10 2)

;(println
;     (* (square 4) (sum 5 56)))
;(println (lib/bubble-sort [5 7 9 1 3 1 2])) ; [1 2 3]