
package negocio.basica;

/**
 *
 * @author Gildo
 */
public class FornecedorProduto {

    /**
     * @return the fornecedorCnpj
     */
    public String getFornecedorCnpj() {
        return fornecedorCnpj;
    }

    /**
     * @param fornecedorCnpj the fornecedorCnpj to set
     */
    public void setFornecedorCnpj(String fornecedorCnpj) {
        this.fornecedorCnpj = fornecedorCnpj.trim();
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
    private String fornecedorCnpj;
    private Integer produtoCodigo;
}