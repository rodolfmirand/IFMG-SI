package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.util.List;

public class TestPassword extends Thread{

    public static boolean testPassword(ZipFile zipFile, String senha) {
        try {
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(senha.toCharArray());
            }
            List<FileHeader> fileHeaderList = zipFile.getFileHeaders();

            for (FileHeader header : fileHeaderList) {
                zipFile.extractFile((FileHeader) header, Main.directory.getAbsolutePath());
                System.out.println("encontramos a senha e o arquivo");
                return true;
            }
        } catch (net.lingala.zip4j.exception.ZipException ex) {
            //erro na extração do arquivo
            return false;
        }
        return false;
    }

    @Override
    
}
