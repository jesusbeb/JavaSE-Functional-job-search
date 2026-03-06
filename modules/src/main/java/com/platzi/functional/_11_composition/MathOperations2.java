package com.platzi.functional._11_composition;

import java.util.function.Function;


public class MathOperations2 {

    public static void main(String[] args) {

        // Funcion que recibe un entero y devuelve ese entero multiplicado por 3
        Function<Integer, Integer> multiplyBy3 = x -> {
            System.out.println("Multiplicando x: " + x + " por 3");
            return x * 3;
    };

        // Funcion que toma un entero y devuelve un entero mas 1
        // compose, genera una nueva funcion, ejecuta un paso antes de una funcion
        Function<Integer, Integer> add1MultiplyBy3 =
                multiplyBy3.compose(y -> {
                    System.out.println("Se le suma 1 a: " + y);
                    return y + 1;
                });

        // De esta manera agregamos pasos despues de la ejecucion de un funcion
        // andThen() ejecuta una funcion, despues de que se ejecuto otra funcion
        Function<Integer, Integer> andSquare =
                add1MultiplyBy3.andThen(x -> {
                    System.out.println("Elevando " + x + " al cuadrado");
                    return x * x;
                });


        // Ejecutamos la funcion y le enviamos 5
        // Internamente compose() genera una funcion intermedia que le suma 1 al numero recibido y despues ejecuta la
        // funcion multiplyBy3
        System.out.println(add1MultiplyBy3.apply(5));

        System.out.println("///////////////////////////////");

        System.out.println(andSquare.apply(3));


    }
}





/*
¿Qué son las funciones de orden mayor?

Las funciones de orden mayor son una parte fascinante y esencial de la programación funcional. Este tipo de
funciones puede tomar como parámetro otra función o devolver una función como resultado. También pueden darse ambos casos a
la vez. Esto nos permite crear composiciones de funciones, donde podemos combinar múltiples funciones para realizar tareas más complejas.
 */