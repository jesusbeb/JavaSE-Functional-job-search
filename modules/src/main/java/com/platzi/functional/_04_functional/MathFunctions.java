package com.platzi.functional._04_functional;

import java.util.function.Function;

public class MathFunctions {

    public static void main(String[] args) {

        // Function<tipo de dato que recibe, tipo de dato que devuelve>
        // al teclear new Function, IntelliJ sugiere el codigo de la funcion. Inicialmente la funcion solo se llamaba square
        Function<Integer, Integer> squareFuction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        // La funcion se invoca usando .apply que es el unico metodo interno que tiene Function
        System.out.println(squareFuction.apply(5));
        System.out.println(squareFuction.apply(25));

        System.out.println(square(5));
    }

    // squareFunction es relativamente lo mismo que este metodo
    static int square(int x) {
        return x*x;
    }

}
