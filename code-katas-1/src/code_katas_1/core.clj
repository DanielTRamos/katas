(ns code-katas-1.core)

(defn filter-odd
  "1)Escribir una funcion que retorne solamente los numeros impares de
   una secuencia.
  2)en esta funcion lo que hago es fitrar la sequencia s y evaluar si cada elemento de s en modulo
   2 me da mayor que cero si ese es el caso se que es un numero impar"
  [s]
  (filter #(> (mod % 2) 0)s)
  
  )

(defn nil-key
  "1)Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil
   2)Se termina la funcion, utilizo el # para llamar a la funcion anonima, donde evalua, elemento por 
   elemento si es igual a nil"
  [k m]
  (#(= (m k) nil))
  
  )

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  
  [start end]
  ;La funcion itera por el inicio y se queda con el rango entre el start y end, el iterate , como su nombre indica
  ;itera hasta el infinito, el take le dice en que numero parar.
  (take (- end start)(iterate inc start))
  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  ;se utiliza la funcion partition-by con la opcion identity, cuando encuentra 2 numeros iguales y 
  ;consecutivos separa por eso, el map first se queda con el primero devolviendo la cadena entera sin
  ;el duplicado.
  (map first (partition-by identity s))
   )

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args]
  ;en esta funcion se toma un conjunto de numeros y se decide cual es el mayor comparando 
  ;el simbolo % hace referencia a los elementos del conjunto y los compara 
  ;cuando  encunto encuentra el mayor termina
   (reduce #(if (> % %2) % %2) args)
  )

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  ;la funcion toma un caracter de control y una secuencia y recorre la secuencia,
  ; si encuentra el caracter corta la secuencia en dos.
  [(take length s) (drop length s)]
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  ;"mergea" dos secuencias tomando el primer de ambas y agregandolas a un nuevo vector.
  ;teoricamente deberia andar sin el vector, pero no logro que ande sin el.
  (mapcat vector s1 s2)
  )

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  ;utiliza el applay str(al igual que en el compress-sequence) para retornar el resultado como un
  ; string concatenado sin caractere raros, el re-seq devuelve una secuencia de coincidencias en los caracers de un string
  ;en este caso si "machean" con las mayusculas del texto
  (apply str (re-seq #"[A-Z]+" text))
  )

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  ;en esta funcion se encarga de verificar atravez de and, primero chequea que no sea nulo el valor que me pasa.
  ;luego veo que si se cumplen las 2 condiciones el que algunos de los elementos sean true y que no todos lo sean.
  (and (not= nil (some true? xs)) (not-every? true? xs))
  )

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  ;esta funcion se encarga de "mergear" 2 vectores uno de claves y otro de valores en un mapa.
  ;para ello se utiliza la funcion hash-map y luego utiliza el merge para agregarlo a un solo mapa
  (apply merge (map hash-map k v))
  )