
package negocio.basica;

/**
 *
 * @author paulo
 */
public class CompraProduto {
        private int produtoQtd;
        private double produtoPreco;
        private Compra compra;
        private Produto produto;

    public int getProdutoQtd() {
        return produtoQtd;
    }

    public void setProdutoQtd(int produtoQtd) {
        this.produtoQtd = produtoQtd;
    }

    public double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
        
}
