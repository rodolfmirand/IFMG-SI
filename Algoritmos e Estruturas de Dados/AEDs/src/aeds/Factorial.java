/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds;

import java.util.Scanner;

/**
 *
 * @author 0057149
 */
public class Factorial {
    public static void main(String[] args) {
        double x;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        System.out.println(fatorial(x));
        
    }
    
    static double fatorial(double x){
       if(x == 0){
           return 1;
       }else{
           return (x * fatorial(x-1));
       }
    }
}
