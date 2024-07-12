/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.veiculos;

import java.util.ArrayList;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Moto("Harley Davidson", 120.000, 1995));
        veiculos.add(new Moto("Royal Einfield", 100.000, 2001));
        veiculos.add(new Carro(15.000, "Volkswagem", 150.000));
        veiculos.add(new Carro(25.000, "Lamborghini", 600.000));

        double precoTotalVeiculos = 0;
        for (int i = 0; i < veiculos.size(); i++) {
            veiculos.get(i).printDados();
            if (veiculos.get(i) instanceof Moto) {
                Moto m = (Moto) veiculos.get(i);
                if (m.getAno() >= 2008) {
                    m.setPreco(m.getPreco() + ( m.getPreco() * 0.1));
                }
            }
            precoTotalVeiculos += veiculos.get(i).getPreco();
        }

    }
}
