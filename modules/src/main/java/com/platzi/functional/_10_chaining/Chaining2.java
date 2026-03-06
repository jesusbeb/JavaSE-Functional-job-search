package com.platzi.functional._10_chaining;

public class Chaining2 {

    // Main
    public static void main(String[] args) {
        // Creamos un StringBuilder y le vamos pasando textos con el metodo append(). A esto se le llama encadenamiento de llamadas
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola")
                .append("alumno")
                .append("de")
                .append("java");

        // Objeto de tipo Chainer. Retorna Hola y Adios
        // No se almacenan los resultados
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye();

        // Aqui si almacenamos los resultados
        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer.sayBye();

    }


    static class Chainer {

        // Metodo que retorna un Chainer con un texto
        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public  Chainer sayBye() {
            System.out.println("Bye");
            return this;
        }
    }
}





/*
¿Qué es el encadenamiento de llamadas?

El encadenamiento de llamadas, también conocido como "chaining", es un concepto frecuentemente utilizado en programación,
aunque no es exclusivo de la programación funcional. Permite conectar la salida de una ejecución con la entrada de otra,
facilitando códigos más eficientes y legibles. Este patrón es especialmente útil cuando se trabaja con funciones u
objetos que devuelven una instancia de sí mismos.

¿Cómo se aplica en la clase StringBuilder?

La clase StringBuilder es un ejemplo clásico del uso de encadenamiento de llamadas. Esta clase está diseñada para
construir cadenas de caracteres de manera eficiente en Java. Puedes comenzar creando una instancia de StringBuilder y
luego encadenar múltiples métodos sobre ella.

¿Cuáles son las ventajas de usar el encadenamiento de llamadas?

El encadenamiento de llamadas ofrece diversas ventajas en el desarrollo de software:

- Código más limpio y legible: Al evitar repetir el nombre del objeto constantemente, se mejora la claridad del código.
- Eficiencia: Reduce la creación de variables innecesarias para cada resultado intermedio, ahorrando memoria y tiempo de ejecución.
- Flexibilidad: Facilita la adición de nuevas operaciones o métodos al objeto, permitiendo que el código evolucione con menos riesgos de errores.

 */