package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    // Funcion que muestra el manual cuando la propiedad isHelp esta presente
    static void showHelp(CLIArguments cliArguments) {

        // Consumer es una interface generica que trabaja sobre un tipo de dato
        // Recibe un cliArguments y si existe la propiedad isHelp, imprime un String
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()){
                System.out.println("Manual solicitado");
            }
        };

        // Para invocar al Consumer, usamos su metodo .accept() y pasamos el argumento
        consumerHelper.accept(cliArguments);
    }

    // Funcion
    static CLIArguments generateCLI(){

        // Supplier es una interface generica que genera datos de un cierto tipo. generator no recibe ningun dato (), genera
        // un nuevo CLIArguments. Usamos el metodo get() de Supplier para retornar
        Supplier<CLIArguments> generator = () -> new CLIArguments();

        return generator.get();
    }
}
