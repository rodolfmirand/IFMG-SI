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
public class Animacao extends Video {

    public Animacao(double duracao, String tipo) {
        super(duracao, tipo);
    }

    @Override
    public double calcularPreco() {
        if (duracao <= 17) {
            return 35 + (35 * 0.5);
        } else if (duracao > 17 && duracao <= 45) {
            return 45 + (45 * 0.5);
        } else if (duracao > 45) {
            return 55 + (55 * 0.5);
        }
        return 0;
    }

    @Override
    public double calcularTempoEstimadoServico() {
        if (duracao <= 17) {
            return 90;
        } else if (duracao > 17 && duracao <= 45) {
            return 110;
        } else if (duracao > 45) {
            return 135;
        }
        return 0;
    }

}
