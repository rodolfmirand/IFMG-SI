/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.listas;

import java.util.ArrayList;
import java.util.List;
import orçamentoDeMarketing.classes.abstracts.Video;

/**
 *
 * @author rodol
 */
public class ListaVideos {
    public static ArrayList<Video> videos = new ArrayList<Video>();

    public void adicionar(Video video) {
        
        videos.add(video);
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (int i = 0; i < videos.size(); i++) {
            total += videos.get(i).getPrecoFinal();
        }
        return total;
    }
}
