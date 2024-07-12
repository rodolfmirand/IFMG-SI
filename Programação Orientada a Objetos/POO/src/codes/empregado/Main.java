/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.empregado;

import codes.empregado.classes.Assalariado;
import codes.empregado.classes.Comissionario;
import codes.empregado.classes.Horista;
import codes.empregado.classes.abstracts.Empregado;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Empregado> empregados = new ArrayList<>();

        Empregado a1 = new Assalariado(1200, "Pedro", "Silva", "000.000.000-00");
        Empregado a2 = new Assalariado(1200, "Luísa", "Maria", "111.111.111-11");

        Empregado c1 = new Comissionario(6000, 25, "Eduardo", "Octário", "222.222.222-22");
        Empregado c2 = new Comissionario(7500, 25, "Guilherme", "Victor", "333.333.333-33");

        Empregado h1 = new Horista(15, 6, "Claúdio", "Pereira", "444.444.444-44");
        Empregado h2 = new Horista(15, 4, "Jorge", "Machado", "555.555.555-55");

        empregados.add(a1);
        empregados.add(a2);
        empregados.add(c1);
        empregados.add(c2);
        empregados.add(h1);
        empregados.add(h1);

        
        double salarioTotal = 0;
        
        for (int i = 0; i < empregados.size(); i++) {
            salarioTotal += empregados.get(i).vencimento();
            System.out.println("Empregado " + (i + 1) + "\tPagamento: R$" + empregados.get(i).vencimento());
        }
        
        System.out.println("\nTotal a pagar: R$" + salarioTotal);
         
        double salarioTotal_2 = 0;
        Iterator<Empregado> it = empregados.iterator();
        while (it.hasNext()) {
            Empregado e = it.next();
            salarioTotal_2 += e.vencimento();

        }
        System.out.println("Total a pagar: R$" + salarioTotal_2);
    }
}
