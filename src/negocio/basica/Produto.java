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
    private Integer produtoCodigo;
    private String produtoNome;
    private Integer produtoEstoque;
    private double produtoPreco;

    /**
     * @return the produtoNome
     */
    public String getProdutoNome() {
        return produtoNome;
    }

    /**
     * @param produtoNome the produtoNome to set
     */
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    /**
     * @return the produtoEstoque
     */
    public int getPrd_estoque() {
        return produtoEstoque;
    }

    /**
     * @param prd_estoque the produtoEstoque to set
     */
    public void setPrd_estoque(int prd_estoque) {
        this.produtoEstoque = prd_estoque;
    }

    /**
     * @return the produtoPreco
     */
    public double getProdutoPreco() {
        return produtoPreco;
    }

    /**
     * @param produtoPreco the produtoPreco to set
     */
    public void setProdutoPreco(double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }   

    /**
     * @return the produtoCodigo
     */
    public int getPrd_cod() {
        return produtoCodigo;
    }

    /**
     * @param prd_cod the produtoCodigo to set
     */
    public void setPrd_cod(int prd_cod) {
        this.produtoCodigo = prd_cod;
    }
}