/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasLineares;

/**
 *
 * @author rodol
 */
public class Aluno {
    private String nome;
    private long ra;
    
    public Aluno(String nome, long ra){
        this.nome = nome;
        this.ra = ra;
        
        
    }

    public String getNome() {
        return this.nome;
    }

    public long getRa() {
        return this.ra;
    }
}
