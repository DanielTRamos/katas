(ns code-katas-2.core)
 
(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  ;Documentacion utilizada para el primer ejercicio
  ;la documentacion del partial http://clojuredocs.org/clojure_core/clojure.core/partial 
  ;estudiando las ppt del curso vemos que podemos utilizar la funcion let, http://clojuredocs.org/clojure_core/clojure.core/let  
  ;la documentacion del recur http://clojuredocs.org/clojure_core/clojure.core/recur
   (partial
     (fn [f & args];aqui formamos la lista f mas los argumentos 
     (let [q(f (first args))] ; el let "guarda" en "q" f mas el primer argumento de f.
     (if (fn? q); en este if preguntamos si "q" es es una funcion(en este caso si no esta vacia) luego del let
     (recur q (rest args)); aqui llamamos recursivamente a con "q" y el resto de los argumentos de f.
     q)))
     f)
  )

;Documentacion utilizada para la funcion search
;funcion ffirst http://clojuredocs.org/clojure_core/clojure.core/ffirst
;funcion apply http://clojuredocs.org/clojure_core/clojure.core/apply
;funcion let, http://clojuredocs.org/clojure_core/clojure.core/let  
(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  ([& seqs]
    ((fn [t] 
    (let [f (map first t) m (apply min f)] ;primero se toma el primer de t y se guarda en f, luego se aplica la funcion min a f y se guarda en m
    (if (apply = f)
    (ffirst t); el ffirst funciona como (first(first(t))), osea el primero del primero de t(una sequencia)
    (recur (map #(if (= m (first %)) (rest %) %) t))))) seqs));utilizo una funcion anonima para evaluar con un if si m es igual a t, si es asi llamo recursivamente con el primer elemento, el resto y con argumento sequs
  )


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  )


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
  )
