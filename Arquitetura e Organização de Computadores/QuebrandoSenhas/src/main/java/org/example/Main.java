package org.example;

import java.io.File;
import java.util.List;
import java.util.zip.ZipException;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

public class Main {

    public static ZipFile zipFile;
    public static final int startAscii = 33;
    public static final int endAscii = 126;

    //caminho absoluto da pasta
    public static final String caminho = "D:\\Download\\projeto e arquivos para o problema da senha (1)\\senha\\arquivosTP\\";

    public static boolean testaSenha(String senha) {
        //necessário trocar o nome do arquivo de maneira iterativa
        ZipFile zipFile = new ZipFile(new File(caminho + "doc1.zip"));
        try {

            //encriptado?
            zipFile.setPassword(senha.toCharArray());

            List fileHeaderList = zipFile.getFileHeaders();

            for (int i = 0; i < fileHeaderList.size(); i++) {
                FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
                //onde você deseja extrair (neste caso no mesmo caminho)
                zipFile.extractFile(fileHeader, caminho);
                System.out.println("Encontramos a senha e o arquivo: " + senha);
                return true;
            }

        } catch (net.lingala.zip4j.exception.ZipException ex) {
            //erro na extração do arquivo
            return false;
        }

        return false;
    }

    public static boolean generatePassword(int numbChar) {
        String senha = "";
        for (int i = startAscii; i <= endAscii; i++) {
            if (numbChar == 1) {
                senha = String.valueOf((char) i);
                System.out.println(senha);
                if (testaSenha(senha)) {
                    return true;
                }
            } else {
                for (int j = startAscii; j <= endAscii; j++) {
                    if (numbChar == 2) {
                        senha = String.valueOf((char) i) + (char) j;
                        System.out.println(senha);
                        if (testaSenha(senha)) {
                            return true;
                        }
                    } else {
                        for (int k = startAscii; k <= endAscii; k++) {
                            if (numbChar == 3) {
                                senha = String.valueOf((char) i) + (char) j + (char) k;
                                System.out.println(senha);
                                if (testaSenha(senha)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maxPasswordLength = 3;
        for (int i = 1; i <= maxPasswordLength; i++) {
            if (generatePassword(i)) {
                break;
            }
        }
    }
}