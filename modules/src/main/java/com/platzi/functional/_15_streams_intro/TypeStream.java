package com.platzi.functional._15_streams_intro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TypeStream {

    public static void main(String[] args) {

        // Un IntStream emite enteros, generamos uno que empiece de cero y lo haga de manera infinita, pero lo limitamos a 1000
        // Filtramos solo los pares e imprimimos
        // boxed() convierte un IntStream de enteros a Stream de Integer, recopilamos todos los datos con Collect y
        // convertimos a un List
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        List<Integer> numbersList = infiniteStream.limit(1000)
                .filter(x -> x%2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
