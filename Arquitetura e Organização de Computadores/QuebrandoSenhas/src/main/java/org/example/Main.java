package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.io.*;
import java.util.List;

public class Main {

    //Diretório dos arquivos a serem descompactados
    public static final String path = "D:\\Área de Trabalho\\IFMG-SI\\Arquitetura e Organização de Computadores\\QuebrandoSenhas\\";

    public static void main(String[] args) throws InterruptedException, IOException {

        //Senha do arquivo final
        String finalPassword = "";

        for (int i = 1; i <= 4; i++){

            //Localiza o arquivo a ser descompactado
            ZipFile file = new ZipFile(path + "doc" + i + ".zip");

            //Define o arquivo que as threads devem quebrar a senha
            FileBreaker.setZipFile(file);

            //Tenta quebrar a senha do arquivo
            BreakFile.breakFile();

            //Redefine se a senha já foi quebrada para 'false' para o próximo arquivo a ser quebrado
            FileBreaker.isPasswordBroken = false;
        }

        //Lê a primeira linha dos arquivos .txt e os concatenam em uma String
        for(int i = 1; i <= 4; i++){
            BufferedReader br = new BufferedReader(new FileReader(path + "doc" + i + ".txt"));
            finalPassword += br.readLine();
        }

        //Tenta descompactar o arquivo final
        try{
            ZipFile finalFile = new ZipFile(path + "final.zip");

            finalFile.setPassword(finalPassword.toCharArray());

            List<FileHeader> fileHeaderList = finalFile.getFileHeaders();

            for (FileHeader header : fileHeaderList) {
                finalFile.extractFile(header, Main.path);
                System.out.println("Arquivo final descompactado.");
            }
        }catch (net.lingala.zip4j.exception.ZipException ex){
            System.out.println("Erro na descompactação do arquivo final.");
        }

    }
}