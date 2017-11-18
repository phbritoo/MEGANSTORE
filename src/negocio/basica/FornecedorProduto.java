
package negocio.basica;

/**
 *
 * @author Gildo
 */
public class FornecedorProduto {

    /**
     * @return the forn_cnpj
     */
    public Integer getForn_cnpj() {
        return forn_cnpj;
    }

    /**
     * @param forn_cnpj the forn_cnpj to set
     */
    public void setForn_cnpj(Integer forn_cnpj) {
        this.forn_cnpj = forn_cnpj;
    }

    /**
     * @return the prd_cod
     */
    public Integer getPrd_cod() {
        return prd_cod;
    }

    /**
     * @param prd_cod the prd_cod to set
     */
    public void setPrd_cod(Integer prd_cod) {
        this.prd_cod = prd_cod;
    }
    private Integer forn_cnpj;
    private Integer prd_cod;
}