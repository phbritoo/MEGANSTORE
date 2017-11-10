/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

/**
 *
 * @author aluno
 */
public class FachadaVendedor {
    
    public void cadastrarVendedor (Vendedor vendedor){
        RegraVendedor rn = new RegraVendedor();
        rn.validar(vendedor);
        rn.eUnico(vendedor);
    }
    
}
