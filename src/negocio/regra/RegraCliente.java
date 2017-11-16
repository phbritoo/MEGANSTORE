/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOCliente;
import dados.DAOClienteImpl;
import negocio.basica.Cliente;
import negocio.exception.ExceptionsCliente;

/**
 *
 * @author paulo
 */
public class RegraCliente {
    
    public void validar (Cliente cliente) throws ExceptionsCliente {
        
        if (cliente==null){
            throw new ExceptionsCliente("Objeto inválido!");
        }
        if ((cliente.getCli_nome()==null)||(cliente.getCli_nome().isEmpty())){
            throw new ExceptionsCliente("Nome inválido!");
        }
    }
}