
package negocio.basica;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author paulo
 */
public class Compra {
    
  
    private int nfCodigo;
    private double nfTotal;
    private Date nfData;
    private Vendedor vendedor;
    private Cliente cliente;
    private ArrayList<CompraProduto> itens;

    /**
     * @return the nfCodigo
     */
    public int getNfCodigo() {
        return nfCodigo;
    }

    /**
     * @param nfCodigo the nfCodigo to set
     */
    public void setNfCodigo(int nfCodigo) {
        this.nfCodigo = nfCodigo;
    }

    /**
     * @return the nfTotal
     */
    public double getNfTotal() {
        return nfTotal;
    }

    /**
     * @param nfTotal the nfTotal to set
     */
    public void setNfTotal(double nfTotal) {
        this.nfTotal = nfTotal;
    }

    /**
     * @return the nfData
     */
    public Date getNfData() {
        return nfData;
    }

    /**
     * @param nfData the nfData to set
     */
    public void setNfData(Date nfData) {
        this.nfData = nfData;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    
}
