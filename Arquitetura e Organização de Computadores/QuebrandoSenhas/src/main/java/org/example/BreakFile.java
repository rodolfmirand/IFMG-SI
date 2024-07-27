package org.example;

import java.util.ArrayList;
import java.util.List;

public class BreakFile {

    public static void breakFile() throws InterruptedException {

        //Número de caracteres da tabela ASCII (33 - 126)
        int numberOfCharsAscii = 93;

        //Caracter inicial
        int startOfAscii = 33;

        //Caracter final
        int endOfAscii = 126;

        //Número de Threads disponíveis
        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        //Número de caracteres para cada thread
        int numberOfCharsPerThread = numberOfCharsAscii / numberOfThreads;

        //Lista para armazenar as threads
        List<FileBreaker> threads = new ArrayList<>(numberOfThreads);

        //Criação e Iniciação das threads
        for (int counter = 0; counter < numberOfThreads; counter++){

            //O valor inícial de uma determinada thread
            int start = startOfAscii + (numberOfCharsPerThread * counter);

            //Valor final de uma determinada thread
            int end = (counter != numberOfThreads - 1) ? startOfAscii + (numberOfCharsPerThread * (counter + 1)) : endOfAscii;

            //Instancia uma thread
            FileBreaker thread = new FileBreaker(start, end);

            //Adiciona a nova thread na lista
            threads.add(thread);

            //Inicia a thread
            thread.start();
        }

        //Espera que todas as threads terminem suas tarefas
        for(FileBreaker thread : threads){
            thread.join();
        }
    }
}
