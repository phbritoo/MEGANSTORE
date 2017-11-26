/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
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
        rn.incluir(cliente);
        
    }
    
     /**
     * Pesquisa um ou mais vendedor através do nome
     * @return lista com todos os vendedores cadastrados
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Cliente> listarTodos () throws ClienteException, ConexaoException, DAOException{
        RegraCliente rc = new RegraCliente();
        return rc.listarTodos();
    }
    
    public ArrayList<Cliente> listarPorNome (String clienteNome) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rc = new RegraCliente();
        return rc.listarPorNome(clienteNome);
        }
}
