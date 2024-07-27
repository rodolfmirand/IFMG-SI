package org.example;

import net.lingala.zip4j.ZipFile;

import java.util.ArrayList;
import java.util.List;

public class FileBreaker extends Thread {

    //Valor do caracter inicial
    private final int start;

    //Valor do caracter final
    private final int end;

    //Flag que indica se a senha foi ou ainda não foi encontrada
    public static boolean isPasswordBroken = false;

    //Arquivo a ser descompactados pelas threads
    private static ZipFile zipFile = null;

    public static void setZipFile(ZipFile zipFile) {
        FileBreaker.zipFile = zipFile;
    }

    public FileBreaker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {

        //Caso a senha já tenha sido encontrada a thread é "finalizada"
        if (isPasswordBroken) return;

        //Instancia a classe que irá gerar e testar as senhas
        PasswordGenerator passwordGenerator = new PasswordGenerator(zipFile);

        //Primeiro testa uma senha com um caracter, depois com dois caracteres e por fim, com três caracteres
        for (int i = 1; i <= 3; i++) {

            //Testa novas senhas enquanto não encontrar a senha
            if (passwordGenerator.generatePassword(i, this.start, this.end)) {
                isPasswordBroken = true;
                return;
            }
        }
    }
}
