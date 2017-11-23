/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import negocio.basica.Cliente;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.regra.RegraCliente;

/**
 *
 * @author William
 */
public class FachadaCliente {
    
     public void cadastrarCliente (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rn = new RegraCliente();
        rn.validar(cliente);
        rn.eUnico(cliente);
        rn.inserir(cliente);
        
    }
    
}
