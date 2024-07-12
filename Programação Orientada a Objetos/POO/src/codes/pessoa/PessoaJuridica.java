/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.pessoa;

/**
 *
 * @author rodol
 */
public class PessoaJuridica extends Pessoa{
    private int cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private final double imposto = 20;
    
    public PessoaJuridica(String nome, String endereco, double valorPagamento, int cnpj) {
        super(nome, endereco, valorPagamento);
        this.cnpj = cnpj;
    }

    @Override
    public double realizarPagamento() {
        return super.getValorPagamento() - (super.getValorPagamento() * (imposto/100));
    }
    
}
