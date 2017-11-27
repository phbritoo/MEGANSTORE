/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
import negocio.basica.Cliente;
import negocio.basica.Cliente;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ClienteException;
import negocio.regra.RegraCliente;
import negocio.regra.RegraCliente;

/**
 *
 * @author William
 */
public class FachadaCliente {
    
    /**
     * Faz as validações e grava um novo cliente no BD 
     * @param cliente Objeto com dados do cliente a ser cadastrado
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException 
     */
    public void cadastrar (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rn = new RegraCliente();
        rn.validar(cliente);
        rn.eUnico(cliente);
        rn.incluir(cliente);
    }
    /**
     * Altera o nome do cliente no BD
     * @param cliente a ser alterado
     * @throws ClienteException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void alterar (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rn = new RegraCliente() ;
        rn.alterar(cliente);
    }
    
    /**
     * Exclui cliente do BD
     * @param cliente a ser excluído
     * @throws ClienteException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void excluir (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rn = new RegraCliente() ;
        rn.excluir(cliente);
    }
     /**
     * Pesquisa todos os clientes cadastrados
     * @return lista com todos os clientes cadastrados
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Cliente> listarTodos () throws ClienteException, ConexaoException, DAOException{
        RegraCliente rc = new RegraCliente();
        return rc.listarTodos();
    }
    
     /**
     * Pesquisa um ou mais cliente através do nome
     * @param clienteNome nome ou parte do nome do cliente a ser pesquisado
     * @return lista com todos os clientes cadastrados
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Cliente> listarPorNome (String clienteNome) throws ClienteException, ConexaoException, DAOException{
        RegraCliente rc = new RegraCliente();
        return rc.listarPorNome(clienteNome);
        }
}
