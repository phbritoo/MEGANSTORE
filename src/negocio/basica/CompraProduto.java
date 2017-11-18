
package negocio.basica;

/**
 *
 * @author paulo
 */
public class CompraProduto {
        private int prd_qtd;
        private double preco;
        private Compra compra;
        private Produto produto;

    public int getPrd_qtd() {
        return prd_qtd;
    }

    public void setPrd_qtd(int prd_qtd) {
        this.prd_qtd = prd_qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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
