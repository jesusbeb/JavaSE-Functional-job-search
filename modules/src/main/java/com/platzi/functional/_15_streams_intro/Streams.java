package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        // Creamos un List
        List<String> courseList = NombresUtils.getList(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack");

        // Iteramos en la lista y hacemos cosas
        for (String course: courseList){
            String newCourseName = course.toLowerCase().replace("!", "!!!"); // Crea un nuevo nombre con modificaciones
            System.out.println("Curso: " + newCourseName); // Agrega un prefijo
        }

        // Creamos un Stream de tipo String parecido al List anterior
        Stream<String> coursesStream = Stream.of(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack");

        // map devuelve un Stream. Por lo que aqui se crea un Stream de tipo Integer, de la longitud de caracteres de coursesStream
        //Stream<Integer> courseLenghtStream = coursesStream.map(course -> course.length());

        // El nombre mas largo dentro del Stream. max recibe un comparator que es una especie de funcion que recibe dos
        // valores y determina cual es el mas grande, max devuelve un Optional porque puede que el Stream este vacio
        //Optional<Integer> longest = courseLenghtStream.max((x, y) -> y - x);

        // Un Stream solo puede ser consumido una sola vez, cuando un Stream recibe una operacion genera un nuevo
        // Stream que debera consumirse, por lo que el original ya no puede operarse

        // Creamos un nuevo Stream, agregando enfasis (!) a cada uno de los elementos
        Stream<String> emphasisCourses = coursesStream.map(course -> course + "!");
        // Creamos un nuevo Stream con los elementos que tienen la palabra Java
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println); // Imprimimos el Stream


        // Los Stream tienen dos tipos de operaciones, intermedias y terminales. Las intermedias generan un nuevo Stream
        // Las finales genera un dato final despues de haber operado todo o pueden no devolver ningun dato.

        // Creamos un Stream a partir de una Coleccion ya existente "courseList"
        Stream<String> coursesStream2 = courseList.stream();

        addOperator(
                coursesStream2.map(course -> course + "!!" ) // Agregamos !! a cada elemento
                .filter(course -> course.contains("Java")) // Filtramos los que tienen la palabra Java
        ).forEach(System.out::println);
    }

    // Funcion que devuelve un Stream de algun tipo e internamente agrega operadores a un Stream que recibe como parametro
    // Retornamos el stream que se recibe, se le aplica peek que hace una iteracion sobre los datos para verlos
    static <T> Stream<T> addOperator(Stream<T> stream){
        return stream.peek(data -> System.out.println("Dato: " + data));
    }
}





/*
Cómo trabajar con múltiples datos usando streams en Java

Trabajar con múltiples datos en Java a menudo plantea desafíos, especialmente cuando se trata de procesar colecciones grandes o
complejas. Java 8 introduce el concepto de Stream, que ofrece una forma más efectiva de manejar estas operaciones al permitir el
procesamiento de datos de manera más fluida y concisa.

¿Qué es un Stream en Java?

Un Stream es una secuencia de elementos respaldada por fuentes de datos como listas, mapas, arreglos u otras colecciones.
Permite realizar distintas operaciones de manera declarativa, enfocándose en el "qué" en lugar del "cómo". Esto se logra a
través de una API que soporta operaciones como filtrado, mapeo y reducción sobre la secuencia de datos, ofreciendo un
enfoque más limpio en comparación con los bucles tradicionales.

¿Cuáles son las limitaciones del consumo de Streams?

Un aspecto crítico a tener en cuenta al trabajar con Stream es que solo pueden consumirse una vez. Después de
operar sobre él, el Stream se considera "consumido" y no puede reutilizarse ni realizar más operaciones. Intentar
hacerlo resulta en excepciones, lo cual es importante para evitar errores durante la ejecución.
 */