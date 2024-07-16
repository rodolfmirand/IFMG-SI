package org.example;

import java.io.File;
import java.util.List;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

public class Main {
    public static void main(String[] args) {
        File[] files = directory.listFiles();
        ZipFile[] zipFiles = new ZipFile[4];

        int f = 0;
        for (File file : files) {
            zipFiles[f] = new ZipFile(new File(file.getAbsolutePath()));
            f++;
        }

    }

    public static final File directory = new File("D:\\Download\\projeto e arquivos para o problema da senha\\senha");

    
}