/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

/**
 *
 * @author gildo
 */
public class RegraVendedor {
    
    public void validar (Vendedor vendedor) {
        
        if (vendedor==null){}
        if (vendedor.getVend_cod()==null){}
        if (vendedor.getVend_nome()==null){}
    }
    
    public void eUnico (Vendedor vendedor){
       return null; 
    }
    
}