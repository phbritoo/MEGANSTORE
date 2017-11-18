
package negocio.basica;

import java.util.Date;


/**
 *
 * @author paulo
 */
public class Compra {
    
  
    private int nf_cod;
    private double nf_total;
    private Date data;
    private Vendedor vendedor;
    private Cliente cliente;
    private ArrayList<CompraProduto> itens;

    /**
     * @return the nf_cod
     */
    public int getNf_cod() {
        return nf_cod;
    }

    /**
     * @param nf_cod the nf_cod to set
     */
    public void setNf_cod(int nf_cod) {
        this.nf_cod = nf_cod;
    }

    /**
     * @return the nf_total
     */
    public double getNf_total() {
        return nf_total;
    }

    /**
     * @param nf_total the nf_total to set
     */
    public void setNf_total(double nf_total) {
        this.nf_total = nf_total;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
