
package negocio.basica;

/**
 *
 * @author Gildo
 */
public class CompraPagamento {

    /**
     * @return the pagCodigo
     */
    public Integer getPagCodigo() {
        return pagCodigo;
    }

    /**
     * @param pagCodigo the pagCodigo to set
     */
    public void setPagCodigo(Integer pagCodigo) {
        this.pagCodigo = pagCodigo;
    }

    /**
     * @return the nfCodigo
     */
    public Integer getNfCodigo() {
        return nfCodigo;
    }

    /**
     * @param nfCodigo the nfCodigo to set
     */
    public void setNfCodigo(Integer nfCodigo) {
        this.nfCodigo = nfCodigo;
    }
    private Integer pagCodigo;
    private Integer nfCodigo;
}