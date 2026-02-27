package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("Nicolas", "Juan", "Zulema");

        // Consumer de tipo String que recibe un texto y lo imprime
        // forEach recibe un Consumer que reciba los elementos de una lista e itera en ellos
        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("////////");

        // Otra forma de hacerlo sin consumer, es usando una referencia de un metodo que pueda hacer lo anterior, para
        // eso usamos :: que busca System.out y ejecuta println
        profesores.forEach(System.out::println);

    }

    // Metodo que devuelve una lista de tipo T que recibe una candidad indefinida de elementos T
    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }
}





/*
¿Cómo introducir la programación funcional en un proyecto ya existente?

Ha llegado el momento de enfrentarte a un dilema clásico en el desarrollo de software: incorporar nuevas tecnologías o
paradigmas a un proyecto que ya está en marcha. Uno de los desafíos actuales es integrar la programación funcional en un
proyecto donde ya existen métodos, funciones y clases definidas. La programación funcional no sólo promete elegancia,
sino también eficiencia y flexibilidad en el manejo de datos. Pero, ¿por dónde empezar?

¿Cómo referenciar métodos en Java?

Supongamos que tienes una lista de elementos y deseas aplicarles una operación funcional sin necesidad de redefinir o
crear nuevos métodos desde cero. Aquí es donde las referencias a métodos en Java resultan muy útiles. Este
operador ((::)) te permite utilizar métodos existentes al hacer referencia a ellos.

¿Cuándo son útiles las referencias a métodos?

Las referencias a métodos son particularmente útiles cuando:

- Tienes métodos estáticos o de instancia ya definidos que coinciden con la firma de la función que necesitas.
- Deseas mantener el código preciso y claro, utilizando funciones predefinidas que realizan una tarea específica.
- Necesitas realizar operaciones repetitivas sobre estructuras de datos, como listas o conjuntos, aplicando funciones conocidas sin redefinirlas.

Recuerda que los métodos son, de hecho, funciones ligadas a un objeto o clase, por lo que pueden ser utilizados de
forma funcional siempre que cumplan con la misma cantidad y tipo de parámetros que las funciones a las cuales sustituyen.
La clave está en que el método referenciado debe coincidir en definición, garantizando así que la funcionalidad se mantenga sin excepción.
 */