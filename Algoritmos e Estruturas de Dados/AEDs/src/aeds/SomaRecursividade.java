/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds;

/**
 *
 * @author 0057149
 */
public class SomaRecursividade {
    public static void main(String[] args) {
        System.out.println(soma(10));
    }
    
    static int soma(int x){
        if(x == 1){
            return 1;
        }else{
            return x += soma(x-1);
        }
    }
}
