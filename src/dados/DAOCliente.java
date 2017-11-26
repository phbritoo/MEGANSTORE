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

    public void inserir(Cliente cliente) throws DAOException, ConexaoException;
 
    public void deletar (Cliente cliente) throws DAOException, ConexaoException;
    
    public void alterar (Cliente cliente) throws DAOException, ConexaoException;
   
    public Cliente consultar(String nome) throws DAOException, ConexaoException;
    
    public ArrayList<Cliente>listarTodos() throws DAOException, ConexaoException;
    
      /**
     * Lista um ou mais vendedores atráves do nome
     * @param clienteNome
     * @return ArrayList contendo um ou mais clientes
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public ArrayList<Cliente>listarPorNome(String clienteNome) throws DAOException, ConexaoException;
    
}
    

