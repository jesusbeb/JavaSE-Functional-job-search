package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

// Clase cualquiera, llamada Sintaxis solo por poner un nombre
public class Sintaxis {

    public static void main(String[] args) {
        // Creamos una Lista con getList de la clase NombresUtils
        List<String> cursos = NombresUtils.getList("Java", "Functional");


        // Dentro del forEach usamos una lambda, es una lambda porque no esta almacenada en ningun lugar, solo en este fragmento de codigo
        cursos.forEach(curso -> System.out.println(curso));

        // Usamos la funcion usarZero y le pasamos una lambda que no toma argumentos (), la funcion flecha para indicar el
        // cuerpo de la lambda y el valor de retorno 2. No usamos return ya que el valor de retorno es directo y Java infiere que este es el valor que se retorna.
        usarZero(() -> 2);

        // Pasamos una lambda a un Predicado, los predicados toman un solo dato, que le llamamos text y devuelven un
        // booleano, por lo que la lambda genera ese booleano para pasarlo. En la lambda no definimos tipo de dato que recibe ni el que retorna
        usarPredicado(text -> text.isEmpty());

        // Pasamos una lambda a una BiFunction que recibe dos enteros y genera un entero
        usarBiFunction((x,y) -> x * y);

        // Cuando dentro de una funcion se necesitan hacer mas cosas, se usan llaves {} para generar un cuerpo mas
        // grande y se indica explicitamente que se esta retornando
        usarBiFunction((x,y) -> {
            System.out.println("X: " + x + ", Y:" + y);
            return x - y;
        });

        // Pasamos una lambda que recibe nada y retorna nada
        usarNada( () -> {} );

        // Tambien se usa una lambda que recibe nada y retorna nada
        usarNada( () -> {
            System.out.println("Hola");
        } );

        // Cuando es necesario definir los tipos de dato en la lambda, no se pueden usar variables primitivas, sino
        // objetos, en este caso se usa Integer en lugar de int
        usarBiFunction((Integer x, Integer y) -> x * y);

    }


    // Funciones hechas solo para mostrar el uso de lambdas

    static void usarZero(ZeroArgumentos zeroArgumentos) {

    }

    static void usarPredicado(Predicate<String> predicado) {

    }

    static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion) {

    }

    static void usarNada(OperarNada operarNada) {

    }

    // Para usar esta FunctionalInterface con un solo metodo y que no recibe argumentos, creamos la funcion usarZero()
    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }

    @FunctionalInterface
    interface OperarNada {
        void nada();
    }

}





/*
¿Qué son y cómo se utilizan las funciones lambda en Java?

Las funciones lambda en Java son una herramienta poderosa que permite crear funciones anónimas, facilitando el manejo y
manipulación de expresiones funcionales de manera clara y concisa. Estas funciones permiten introducir bloques de
código más compactos que pueden ser evaluados en tiempo de ejecución sin necesidad de almacenarse bajo un
nombre específico. Aprender a utilizar las funciones lambda correctamente es esencial para cualquier desarrollador que
quiera emplear programación funcional en Java.

¿Por qué utilizar funciones lambda?

Las lambdas ofrecen varias ventajas:

- Mitigan el uso de clases anónimas: Reducen el código redundante y evitan la creación de clases anónimas sin necesidad.
- Simplifican el código: Permiten expresar comportamientos de manera compacta y clara.
- Facilitan operaciones en colecciones: Trabajar con streams y otras APIs que utilizan funciones de orden superior es más sencillo y directo.

¿Cómo es la sintaxis de las funciones lambda?
La sintaxis básica de las funciones lambda se puede descomponer en los siguientes elementos:

1. Parámetros: Se colocan dentro de paréntesis. En caso de varios parámetros, se separan por comas.
2. Operador 'flecha' ->: Separa los parámetros del cuerpo de la función.
3. Cuerpo: Puede ser una sola expresión o un bloque de sentencias delimitado por llaves si se trata de múltiples expresiones.

¿Cómo funcionan las interfaces funcionales en Java?
Las lambdas se implementan generalmente mediante interfaces funcionales, que son interfaces definidas con una sola
función abstracta. Esto permite a Java inferir el tipo de la lambda automáticamente, reduciendo así verborrea de código.

¿Cómo se aplican las lambdas en funciones de orden superior?

Java permite que las funciones sean pasadas como argumentos gracias a las lambdas, comúnmente conocidas como
higher-order functions. Estas funciones pueden recibir una lambda como argumento o devolver una.

¿Qué consideraciones debemos tener al usar lambdas?

- Uso de tipos primitivos y tipo de retorno: Al definir lambdas, es importante notar que trabajan sobre objetos y no
sobre tipos primitivos. Es necesario utilizar clases envolventes como Integer en lugar de int.
- Claridad y legibilidad del código: Si bien las lambdas pueden hacer el código más conciso, es importante mantener la
legibilidad del código. Esto puede requerir que a veces definamos explícitamente los tipos involucrados.
Al adoptar las lambdas y otras características de la programación funcional, los desarrolladores de Java pueden
escribir código más limpio y eficiente, simplificando operaciones que de otra manera serían mucho más complejas.

 */