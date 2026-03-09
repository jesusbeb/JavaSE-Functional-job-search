package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals2 {

    // Main
    public static void main(String[] args) {

        // 4.
        // Se tienen que validar la existencia de datos
        List<String> names = getNames();
        if (names != null){
            // Operar con nombres
        }

        // 6.
        // Obtenemos el Optional y si estan presentes operamos con ellos dentro del if, esto es semejante a validar si
        // son null como en el punto 4
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()){

        }

        // 7.
        // Ahora hacemos lo mismo que el punto 6 pero de manera funcional con una lambda
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        // 9.
        // Almacenamos el dato obtenido
        Optional<String> valuablePlayer = optionalValuablePlayer();
        // Obtenemos el dato anterior. orElseGet() es una funcion que recibe una lambda y genera un nuevo dato en caso de no haberlo encontrado
        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No player!!!");

    }


    // 1.
    // Metodo que devuelve una lista de algo
    // Cuando no se tienen elementos se suele retornar un Collections.emptyList(), que es una Lista sin elementos
    static List<String> getNames() {
        List<String> list = new LinkedList<>();

        return Collections.emptyList();
    }

    // 2.
    // Metodo que retorna un String. Si no hay String, puede retornar String vacio o null
    static String mostValuablePlayer() {
        //return "";
        return null;
    }

    // 3.
    // Metodo que retorna un int. Si no hay int, retorna -1
    static int mostExpensive() {
        return -1;
    }

    //////////////////// Repetimos las funciones anteriores ahora con Optional

    // 5.
    //
    static Optional<List<String>> getOptionalNames() {
        List<String> namesList = new LinkedList<>();
        // obtencion de nombres
        return Optional.of(namesList);
    }

    // 8.
    // Cuando no se tienen datos que retornar, solo tenemos null
    static Optional<String> optionalValuablePlayer() {
        // Se hace busqueda de datos en una BD, y no se obtiene nada, entonces retornamos Optional.ofNullable(), esto
        // le dice a Optional que tenemos un dato que desconocemos si es null o no, entonces Optional lo esconde dentro
        // de un objeto de tipo null para asi evitar un NullPointerException
        //return Optional.ofNullable();

        // Si no se quiere lidiar con lo anterior de null, entonces podemos hacer lo siguiente
        try {
            // Accedemos a la BD o archivos
            return Optional.of("Retornamos algo si se encuentra");
        } catch (Exception e) { // Si algo sale mal manejamos la excepcion
            e.printStackTrace();
        }
        return Optional.empty(); // Si no encontramos nada

    }

}





/*
La clase Optional.
Este componente no solo mejora la programación funcional sino que también previene errores comunes como el NullPointerException,
al permitir manejar de forma explícita la ausencia de valores.

¿Cómo manejar valores inexistentes con Optional?

Cuando desarrollamos, enfrentamos situaciones en las que métodos deben retornar datos como listas o strings. En Java, la
práctica común es retornar una colección vacía en vez de null. Sin embargo, cuando se trata de otros tipos de datos, como
enteros, los problemas se multiplican. A menudo, se optaba por retornar valores "degenerados" como 0 o -1, pero esto
podría llevar a confusiones y errores.

Es aquí cuando la clase Optional entra en juego. Optional actúa como un contenedor que puede o no contener un valor.
Si hay un dato presente, podemos operar sobre él; si no lo hay, podemos definir un valor por defecto. De esa manera,
evitamos manipulaciones directas con datos nulos que puedan generar errores imprevistos.
 */