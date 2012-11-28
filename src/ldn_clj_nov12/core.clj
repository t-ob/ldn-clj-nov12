(ns ldn-clj-nov12.core)

;; 173
x y

;; 128
(fn [str]
  (let [[suit rank] str
        rank-map (zipmap "23456789TJQKA" (range))
        suit-map (zipmap "DHCS" '(:diamond :heart :club :spade))]
     {:suit (suit-map suit) :rank (rank-map rank)}))

;; 59
(fn [& fns]
  (fn [& args]
    (map #(apply % args) fns)))

;; 69
(defn merge-with* [func & maps]
  (let [mapm (fn [f m] (into {} (for [[k v] m] [k (f v)])))]
    (->> (for [m maps [k v] m] [k v])
         (group-by first)
         (mapm #(reduce func (map last %))))))