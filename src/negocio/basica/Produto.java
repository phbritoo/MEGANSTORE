/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.basica;

/**
 *
 * @author Gabriel
 */
public class Produto {
    private int prd_cod;
    private String prd_nome;
    private int prd_estoque;
    private double prd_preco;

    /**
     * @return the prd_nome
     */
    public String getPrd_nome() {
        return prd_nome;
    }

    /**
     * @param prd_nome the prd_nome to set
     */
    public void setPrd_nome(String prd_nome) {
        this.prd_nome = prd_nome;
    }

    /**
     * @return the prd_estoque
     */
    public int getPrd_estoque() {
        return prd_estoque;
    }

    /**
     * @param prd_estoque the prd_estoque to set
     */
    public void setPrd_estoque(int prd_estoque) {
        this.prd_estoque = prd_estoque;
    }

    /**
     * @return the prd_preco
     */
    public double getPrd_preco() {
        return prd_preco;
    }

    /**
     * @param prd_preco the prd_preco to set
     */
    public void setPrd_preco(double prd_preco) {
        this.prd_preco = prd_preco;
    }   

    /**
     * @return the prd_cod
     */
    public int getPrd_cod() {
        return prd_cod;
    }

    /**
     * @param prd_cod the prd_cod to set
     */
    public void setPrd_cod(int prd_cod) {
        this.prd_cod = prd_cod;
    }
}