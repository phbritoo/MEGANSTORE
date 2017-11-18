
package negocio.basica;

/**
 *
 * @author Gildo
 */
public class CompraPagamento {

    /**
     * @return the pag_cod
     */
    public Integer getPag_cod() {
        return pag_cod;
    }

    /**
     * @param pag_cod the pag_cod to set
     */
    public void setPag_cod(Integer pag_cod) {
        this.pag_cod = pag_cod;
    }

    /**
     * @return the nf_cod
     */
    public Integer getNf_cod() {
        return nf_cod;
    }

    /**
     * @param nf_cod the nf_cod to set
     */
    public void setNf_cod(Integer nf_cod) {
        this.nf_cod = nf_cod;
    }
    private Integer pag_cod;
    private Integer nf_cod;
}