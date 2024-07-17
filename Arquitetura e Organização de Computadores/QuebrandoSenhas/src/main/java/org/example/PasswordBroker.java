package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.util.List;

public class PasswordBroker {

    private ZipFile zipFile;

    public PasswordBroker(ZipFile zipFile) {
        this.zipFile = zipFile;
    }

    public void setZipFile(ZipFile zipFile){
        this.zipFile = zipFile;
    }

    public static StringBuilder stringBuilder = new StringBuilder();

    public static final int startAscii = 33;
    public static final int endAscii = 126;

//    @Override
//    public void run() {
//        generatePassword(1);
//    }

    public void brokeFile() {
        generatePassword(1);
    }

    private static boolean testPassword(ZipFile zipFile, String senha) {
        try {
            //System.out.println(senha.toCharArray());
            zipFile.setPassword(senha.toCharArray());

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

    private boolean generatePassword(int numbChar) {
        String password = "";
        do {
            if (numbChar == 1) {
                for (int i = startAscii; i <= endAscii; i++) {
                    if(!password.isEmpty()) password = "";

                    password = String.valueOf(i);

                    if (testPassword(this.zipFile, password)) {
                        return true;
                    }
                }
                return generatePassword(1 + numbChar);
            }
            if (numbChar == 2) {
                for (int i = startAscii; i <= endAscii; i++) {
                    for (int j = startAscii; j < endAscii; j++) {
                        if(!password.isEmpty()) password = "";
                        password = String.valueOf(i);
                        password += String.valueOf(j);

                        if (testPassword(this.zipFile, password)) {
                            return true;
                        }
                    }
                }
                return generatePassword(1 + numbChar);
            }

            if (numbChar == 3) {
                for (int i = startAscii; i <= endAscii; i++) {
                    for (int j = startAscii; j <= endAscii; j++) {
                        for (int k = startAscii; k <= endAscii; k++) {
                            if(!password.isEmpty()) password = "";
                            password = String.valueOf(i);
                            password += String.valueOf(j);
                            password += String.valueOf(k);

                            if (testPassword(this.zipFile, password)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        } while (true);
    }


}
