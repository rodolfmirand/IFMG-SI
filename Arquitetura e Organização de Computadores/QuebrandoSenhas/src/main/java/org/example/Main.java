package org.example;

import java.io.File;

import net.lingala.zip4j.ZipFile;

public class Main {

    public static final File directory = new File("D:\\Download\\projeto e arquivos para o problema da senha\\senha");

    public static void main(String[] args) {
        File[] files = directory.listFiles();
        ZipFile[] zipFiles = new ZipFile[4];

        int f = 0;
        for (File file : files) {
            zipFiles[f] = new ZipFile(new File(file.getAbsolutePath()));
            f++;
        }

        for (ZipFile zipFile : zipFiles) {
            do {
                if(TestPassword.testPassword(zipFile, GeneratePassword.generatePassword(""))) break;

            }while (true);
        }
    }
}