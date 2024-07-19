package org.example;

import java.io.File;

import net.lingala.zip4j.ZipFile;

public class Main {

    public static final File directory = new File("D:\\Download\\projeto e arquivos para o problema da senha\\senha\\arquivosTP");

    public static void main(String[] args) {
//        File[] files = directory.listFiles();
//        ZipFile[] zipFiles = new ZipFile[4];
//
//        int f = 0;
//        for (File file : files) {
//            zipFiles[f] = new ZipFile(new File(file.getAbsolutePath()));
//            f++;
//        }
//
//        for (ZipFile zipFile : zipFiles) {
//            do {
//
//
//            }while (true);
//        }

        //ZipFile zipFile = new ZipFile(new File("D:\\Download\\projeto e arquivos para o problema da senha\\senha\\arquivosTP\\teste.rar"));
//        File file = new File("C:\\Users\\rodol\\Downloads\\projeto e arquivos para o problema da senha\\senha\\arquivosTP\\doc1.zip");
//        ZipFile zipFile = new ZipFile(file);

        ZipFile zipFile = new ZipFile(new File("C:\\Users\\rodol\\Downloads\\projeto e arquivos para o problema da senha\\senha\\arquivosTP\\senha.rar"));
        PasswordBroker passwordBroker = new PasswordBroker();
        PasswordBroker.setZipFile(zipFile);
        passwordBroker.brokeFile();




    }
}