package negocio.basica;

/**
 *
 * @author gildo
 */
public class Vendedor {

    /**
     * @return the vendedorCodigo
     */
    public Integer getVendedorCodigo() {
        return vendedorCodigo;
    }

    /**
     * @param vendedorCodigo the vendedorCodigo to set
     */
    public void setVendedorCodigo(Integer vendedorCodigo) {
        this.vendedorCodigo = vendedorCodigo;
    }

    /**
     * @return the vendedorNome
     */
    public String getVendedorNome() {
        return vendedorNome;
    }

    /**
     * @param vendedorNome the vendedorNome to set
     */
    public void setVendedorNome(String vendedorNome) {
        this.vendedorNome = vendedorNome.trim();
    }
    
    @Override
    public String toString(){
        return getVendedorNome();
    }
    private Integer vendedorCodigo;
    private String vendedorNome;
}
