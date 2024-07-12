/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.model.video;

import orçamentoDeMarketing.classes.abstracts.Video;

/**
 *
 * @author rodol
 */
public class Filmagem extends Video {

    public Filmagem(double duracao, String tipo) {
        super(duracao, tipo);
    }

    @Override
    public double calcularPreco() {
        if (duracao <= 17) {
            return 35 + (35 * 0.25);
        } else if (duracao > 17 && duracao <= 45) {
            return 45 + (45 * 0.25);
        } else if (duracao > 45) {
            return 55 + (55 * 0.25);
        }
        return 0;
    }

    @Override
    public double calcularTempoEstimadoServico() {
        if (duracao <= 17) {
            return 60;
        } else if (duracao > 17 && duracao <= 45) {
            return 75;
        } else if (duracao > 45) {
            return 90;
        }
        return 0;
    }

}
