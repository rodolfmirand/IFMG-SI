/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.exerciciosjava_classeobjeto;

/**
 *
 * @author rodol
 */
public class Televisor {

    int canal = 1;
    int volume = 0;
    boolean ligado = false;

    public void ligarTV() {
        if (ligado == true) {
            System.out.println("TV já ligada.");
        } else {
            ligado = true;
            System.out.println("TV ligada.");
        }
    }

    public void desligarTV() {
        if (ligado == false) {
            System.out.println("TV já desligada.");
        } else {
            ligado = false;
            System.out.println("TV desligada.");
        }
    }

    public void aumentarVolume() {
        if (ligado == true) {
            if (volume == 10) {
                System.out.println("Volume no máximo! 10");
            } else {
                volume++;
                System.out.println("Volume aumentado: " + volume);
            }
        }else{
            System.out.println("TV desligada.");
        }
    }

    public void diminuirVolume() {
        if (ligado == true) {
            if (volume == 0) {
                System.out.println("Volume no minimo! 0");
            } else {
                volume--;
                System.out.println("Volume diminuido: " + volume);
            }
        }else{
            System.out.println("TV desligada.");
        }
    }

    public void subirCanal() {
        if (ligado == true) {
            if (canal == 16) {
                canal = 1;
            } else {
                canal++;
            }
            System.out.println("Canal: " + canal);
        }else{
            System.out.println("TV desligada.");
        }
    }

    public void descerCanal() {
        if (ligado == true) {
            if (canal == 1) {
                canal = 16;
            } else {
                canal--;
            }
            System.out.println("Canal: " + canal);
        }else{
            System.out.println("TV desligada.");
        }
    }

    public void mostrarStatus() {
        if (ligado == true) {
            if (ligado == true) {
                System.out.println("A TV está ligada \nCanal: " + canal + "\nVolume: " + volume);
            } else {
                System.out.println("A TV está desligada.");
            }
        }else{
            System.out.println("TV desligada.");
        }
    }
}
