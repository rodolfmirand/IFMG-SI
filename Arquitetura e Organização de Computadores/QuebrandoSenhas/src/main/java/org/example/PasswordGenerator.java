package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.util.List;

public class PasswordGenerator {

    private final ZipFile zipFile;

    public PasswordGenerator(ZipFile zipFile){
        this.zipFile = zipFile;
    }

    //Método para testar a senha gerada
    //Poucas mudanças foram feitas
    private boolean testPassword(String password) {
        try {
            zipFile.setPassword(password.toCharArray());

            List<FileHeader> fileHeaderList = zipFile.getFileHeaders();

            for (FileHeader header : fileHeaderList) {
                zipFile.extractFile(header, Main.path);
                System.out.println("Encontramos a senha e o arquivo: " + password);
                return true;
            }
        } catch (net.lingala.zip4j.exception.ZipException ex) {
            return false;
        }

        return false;
    }

    public boolean generatePassword(int numbChar, int start, int end) {

        String password = "";

        //Gera uma senha dependendo do número de caracteres necessários
        for (int i = start; i <= end; i++) {

            //Verifica se a senha já foi encontrada
            if(FileBreaker.isPasswordBroken) return false;

            //Se a quantidade de caracteres necessários forem 1, é retornado apenas um caracter, se não é gerado mais caracteres
            if (numbChar == 1) {
                password = String.valueOf((char) i);
                if (testPassword(password)) return true;

            } else {
                //Valor do caracter inicial da tabela ASCII
                int startAscii = 33;
                //Valor do caracter final da tabela ASCII
                int endAscii = 126;

                for (int j = startAscii; j <= endAscii; j++) {

                    //Verifica se a senha já foi encontrada
                    if(FileBreaker.isPasswordBroken) return false;

                    //Se a quantidade de caracteres necessários forem 2, é retornado dois caracteres, se não é gerado mais um caracter
                    if (numbChar == 2) {
                        password = String.valueOf((char) i) + (char) j;
                        if (testPassword(password)) return true;

                    } else {
                        for (int k = startAscii; k <= endAscii; k++) {

                            //Verifica se a senha já foi encontrada
                            if(FileBreaker.isPasswordBroken) return false;

                            //Gera o último caracter necessários
                            if (numbChar == 3) {
                                password = String.valueOf((char) i) + (char) j + (char) k;
                                if (testPassword(password)) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
