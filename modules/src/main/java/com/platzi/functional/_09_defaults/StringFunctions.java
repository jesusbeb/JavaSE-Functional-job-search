package com.platzi.functional._09_defaults;


public class StringFunctions {

    // Interface con un metodo abstracto que no tiene una definicion, getAmount(). Devuelve un entero
    // La palabra reservada "default" permite crear un metodo con una definicion dentro de una interface
    @FunctionalInterface
    interface StringOperation {
        int getAmount();

        default void operate(String text) {
            int x = getAmount(); // obtenemos un numero con la otra funcion
            while (x-- > 0) {
                System.out.println(text);
            }
        }
    }

    // Interface que toma un texto. Tiene un metodo void que toma el texto
    // Se crea un "default" que recibe un entero y un texto
    @FunctionalInterface
    interface DoOperation {
        void take(String text);

        default void execute(int x, String text) {
            while(x-- > 0)
                take(text);
        }
    }


    // Main
    public static void main(String[] args) {

        // Hacemos una funcion de la interface que lo unico que hace es retornar un 6
        // Invocamos a la funcion operate y le pasamos un texto
        // * Se imprime 6 veces el texto enviado
        StringOperation six = () -> 6;
        six.operate("Alumno");

        // Usamos la otra interface que hace lo mismo que la anterior
        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "Persona");
    }
}





/*
¿Cómo funcionan las interfaces personalizadas en Java 8?

En Java 8, la personalización de interfaces adquiere un nuevo significado, brindando más flexibilidad y control sobre
las funciones que podemos crear y utilizar. Esta capacidad permite definir métodos con un cuerpo dentro de una
interfaz, lo cual se lleva a cabo por medio de la palabra clave default.

Este tipo de configuraciones demuestra la versatilidad que ofrece Java 8, permitiéndonos generar interfaces que no
solo ejecutan métodos simples, sino que también se pueden integrar en operaciones más grandes como consultas a bases de
datos o servicios web. Aquí, la funcionalidad se centra en lo que deseamos implementar, sin necesidad de modificar la
conexión o la forma en que se invocan estas operaciones.
 */