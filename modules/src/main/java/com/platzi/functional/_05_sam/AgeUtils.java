package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

// Clase para calcular la edad de alguien, segun su fecha de nacimiento
public class AgeUtils {

    public static void main(String[] args) {

        // Funcion que agrega ceros a la izquierda cuando el dia o mes ingresado es de un solo digito
        Function<Integer, String> addCeros = x -> x<10 ? "0" + x : String.valueOf(x);

        // Funcion que convierte tres tipos de datos Integer a una fecha
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse((year + "-" +
                        addCeros.apply(month) + "-" + addCeros.apply(day)));

        // Funcion que calcula la edad. Recibe 3 enteros con dia, mes y año, con el metodo parseDate que hicimos obtiene
        // la fecha de nacimiento y obtiene los años transcurridos a la fecha actual
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(19,9,1984));
    }


    // Funcion que trabaja con 3 diferentes tipos de datos genericos (T, U, V) y genera un tercer dato generico R
    // Estos tipos de datos se especifican al definir la funcion
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {

        // Metodo apply() que devuelve R, recibe 3 parametros
        R apply(T t, U u, V v);
    }
}





/*
¿Qué es una interfaz SAM en Java?

En Java, una interfaz SAM (Single Abstract Method) es aquella que contiene un único método abstracto definido.
Este concepto es crucial ya que permite el uso de expresiones lambda, proporcionando un enfoque más limpio y
eficiente para escribir funciones anónimas.

- Definición: Una interfaz SAM tiene un solo método abstracto que requiere implementación.
- Ejemplo: Si definimos una interfaz funcional con un único método, esta puede ser utilizada como una función.

Java introdujo en la versión 8, la anotación @FunctionalInterface para mostrar que una interfaz es funcional.
Sin embargo, si añadimos más métodos abstractos a la interfaz, dejaría de ser funcional, y el compilador nos arrojaría un error.
 */