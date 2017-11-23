
package negocio.basica;

/**
 *
 * @author Gildo
 */
public class FornecedorProduto {

    /**
     * @return the fornecedorCnpj
     */
    public Integer getFornecedorCnpj() {
        return fornecedorCnpj;
    }

    /**
     * @param fornecedorCnpj the fornecedorCnpj to set
     */
    public void setFornecedorCnpj(Integer fornecedorCnpj) {
        this.fornecedorCnpj = fornecedorCnpj;
    }

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
    private Integer fornecedorCnpj;
    private Integer produtoCodigo;
}