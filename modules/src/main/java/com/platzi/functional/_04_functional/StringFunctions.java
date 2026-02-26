package com.platzi.functional._04_functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {

        // UnaryOperator trabaja sobre un mismo tipo de valor y devuelve de ese mismo tipo de valor
        // Solo se define el tipo de valor que trabajara
        UnaryOperator<String> quote = text -> "\""+ text + "\""; // Recibe un texto y le agrega comillas
        UnaryOperator<String> addMark = text -> text + "!"; // Recibe un texto y le agrega ! al final

        // Para llamar al UnaryOperator usamos el metodo .apply() y enviamos el texto
        System.out.println(quote.apply("Hola estudiante"));
        System.out.println(addMark.apply("Hola"));

        // BiFunction recibe dos tipos de valores y devuelve un tipo de valor
        // String.format() crea un nuevo String con los parametros que se le envien. "%" significa el tamaño total del
        // nuevo String, "s" agrega espacios para alcanzar el tamaño total del nuevo String si el text que recibe es mas pequeño.
        // Si el text que recibiera es mas grande que el tamaño del nuevo String, devolvera el mismo text
        BiFunction<String, Integer, String> lefPad =
                 (text, number) -> String.format("%" + number + "s", text);

        System.out.println(lefPad.apply("Java", 10));

        //
        //List<BiFunction<String, Integer, String>> formateadores;

        BiFunction<Integer, Integer, Integer> multiplicacion =
                (x, y) -> x * y;
        multiplicacion.apply(5,4);
    }
}
