/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

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
    
}
    

