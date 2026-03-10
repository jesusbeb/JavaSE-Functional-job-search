package com.platzi.functional._15_streams_intro;

import java.util.stream.IntStream;

public class TypeStream {

    public static void main(String[] args) {

        // Un IntStream emite enteros, generamos uno que empiece de cero y lo haga de manera infinita, pero lo limitamos a 1000
        // Filtramos solo los pares e imprimimos
        // parallel hace que el Stream se ejecute de manera concurrente, es decir si el procesador tiene 4 nucleos, se ejecutaran
        // cuatro operaciones a la vez. Esto sirve para operaciones grandes y que no importe el orden de los resultados, ya que
        // estos no se muestran continuos, sino de manera concurrente
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        infiniteStream.limit(1000)
                .parallel()
                .filter(x -> x%2 == 0)
                .forEach(System.out::println);
    }
}
