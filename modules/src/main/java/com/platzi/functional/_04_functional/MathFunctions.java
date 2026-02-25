package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

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


        // Function que recibe un entero y devuelve un booleano
        // Si el numero que recibe es par, devuelve 1
        Function<Integer, Boolean> isOdd = x -> x%2 == 1;

        // Funcion que trabaja sobre un tipo de dato y genera un boolean
        Predicate<Integer> isEven = x -> x%2 == 0;
        // Las funciones Predicate se invocan con .test()
        isEven.test(4); //true

        // Funcion Predicate que recibe Student y nos dice si aprobo (cuando calificacion es mayor o igual a 6)
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;

        // Creamos un estudiante e imprimimos si aprobo o no
        Student juan = new Student(5.9);
        System.out.println(isApproved.test(juan));
    }


    // Clase Student
    static class  Student {
        private double calificacion;

        // Constructor
        public Student(double calificacion){
            this.calificacion = calificacion;
        }

        // Getter
        public double getCalificacion() {
            return calificacion;
        }
    }

}
