package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class PasswordBroker {

    public static final int startAscii = 33;
    public static final int endAscii = 126;

//    @Override
//    public void run() {
//        generatePassword(1);
//    }

    public static boolean testPassword(File file, String senha) {
        try {
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(senha.toCharArray());
            }
            List fileHeaderList = zipFile.getFileHeaders();

            for (int i = 0; i < fileHeaderList.size(); i++) {
                FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
                //onde você deseja extrair (neste caso no mesmo caminho)
                zipFile.extractFile(fileHeader, Main.directory.getAbsolutePath());
                System.out.println("encontramos a senha e o arquivo");
                return true;
            }

        } catch (net.lingala.zip4j.exception.ZipException ex) {
            //erro na extração do arquivo
            return false;
        }

        return false;
    }


    public boolean generatePassword(File file, int numbChar) {
        String senha = "";
        do {
            if (numbChar == 1) {
                for (int i = startAscii; i <= endAscii; i++) {
                    if (!Objects.equals(senha, "")) senha = "";
                    senha = String.valueOf((char) i);
                    System.out.println(senha);
                    if (testPassword(file, senha)) {
                        break;
                    }
                }
                return generatePassword(file, 1 + numbChar);
            }
            if (numbChar == 2) {
                for (int i = startAscii; i <= endAscii; i++) {
                    for (int j = startAscii; j < endAscii; j++) {
                        if (!Objects.equals(senha, "")) senha = "";
                        senha = String.valueOf((char) i);
                        senha += String.valueOf((char) j);
                        System.out.println(senha);
                        if (testPassword(file, senha)) {
                            break;
                        }
                    }
                }
                return generatePassword(file, 1 + numbChar);
            }

            if (numbChar == 3) {
                for (int i = startAscii; i <= endAscii; i++) {
                    for (int j = startAscii; j <= endAscii; j++) {
                        for (int k = startAscii; k <= endAscii; k++) {
                            if (!Objects.equals(senha, "")) senha = "";
                            senha = String.valueOf((char) i);
                            senha += String.valueOf((char) j);
                            senha += String.valueOf((char) k);
                            System.out.println(senha);
                            if (testPassword(file, senha)) {
                                break;
                            }
                        }
                    }
                }
                return false;
            }
        } while (true);
    }

}
