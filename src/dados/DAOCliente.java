/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import negocio.basica.Cliente;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 *
 * @author William
 */
public interface DAOCliente {

    /**
     * Salva os dados no BD
     * @param cliente objeto com CPF, nome e telefone do cliente
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void incluir(Cliente cliente) throws DAOException, ConexaoException;
 
    /**
     * Exclui no BD o cliente selecionado
     * @param cliente Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    public void excluir (Cliente cliente) throws DAOException, ConexaoException;
    
    /**
    * Altera no BD um registro do cliente selecionado
     * @param cliente Objeto contendo ID e dados a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    public void alterar (Cliente cliente) throws DAOException, ConexaoException;
   
    /**
     * Busca no BD um registro correspondente ao CPF passado
     * @param cpf Objeto com CPF a ser pesquisado
     * @return o código do cliente
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public Cliente consultar(String cpf) throws DAOException, ConexaoException;
    
    /**
     * Lista todos os clientes cadastrados
     * @return ArrayList com todos os fornedores cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Cliente>listarTodos() throws DAOException, ConexaoException;
    
      /**
     * Lista um ou mais clientees atráves do nome
     * @param clienteNome
     * @return ArrayList contendo um ou mais clientes
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public ArrayList<Cliente>listarPorNome(String clienteNome) throws DAOException, ConexaoException;
    
}
    

