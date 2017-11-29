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
     * @return the produtoCodigo
     */
    public Integer getProdutoCodigo() {
        return produtoCodigo;
    }

    /**
     * @param produtoCodigo the produtoCodigo to set
     */
    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

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
    public Integer getProdutoEstoque() {
        return produtoEstoque;
    }

    /**
     * @param produtoEstoque the produtoEstoque to set
     */
    public void setProdutoEstoque(Integer produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
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

@Override
    public String toString(){
        return (getProdutoNome());
    }

}