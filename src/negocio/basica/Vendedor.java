/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.basica;

/**
 *
 * @author gildo
 */
public class Vendedor {

    /**
     * @return the vend_cod
     */
    public Integer getVend_cod() {
        return vend_cod;
    }

    /**
     * @param vend_cod the vend_cod to set
     */
    public void setVend_cod(Integer vend_cod) {
        this.vend_cod = vend_cod;
    }

    /**
     * @return the vend_nome
     */
    public String getVend_nome() {
        return vend_nome;
    }

    /**
     * @param vend_nome the vend_nome to set
     */
    public void setVend_nome(String vend_nome) {
        this.vend_nome = vend_nome;
    }
    private Integer vend_cod;
    private String vend_nome;
}
