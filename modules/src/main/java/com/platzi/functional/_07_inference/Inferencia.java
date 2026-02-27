package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {

    public static void main(String[] args) {

        // Funcion que recibe un Integer y devuelve un String. Al momento de compilar, Java se encarga de validar que
        // los datos que recibe la funcion sean del tipo que se definieron, a esto se le llama Inferencia de tipos
        Function<Integer, String> funcionConvertidora =
                x -> "Al doble: " + (x * 2);

        // Generamos una lista con el metodo getList de la clase NombresUtils.
        // En el primer forEach definimos que tipo de dato se recibe
        // En el segundo forEach, no definimos el tipo de dato gracias a la Inferencia de tipos
        // En el tercer forEach, con el operador de referencia, invocamos una funcion que ya sabe de que tipo es
        List<String> alumnos = NombresUtils.getList("Hugo", "Paco", "Luis");
        alumnos.forEach((String name) -> System.out.println(name));
        alumnos.forEach( name -> System.out.println(name));
        alumnos.forEach(System.out::println);

    }
}





/*
¿Qué es la inferencia de tipos en programación?

La programación moderna ha evolucionado de manera que se facilita el trabajo del desarrollador, una de estas
características es la inferencia de tipos. Este concepto permite que el compilador deduzca automáticamente el tipo de
dato que se está utilizando dentro de una función o expresión, sin necesidad de que el programador lo
especifique explícitamente. Esto no solo hace el código más limpio y legible, sino que también reduce el riesgo de errores.
 */