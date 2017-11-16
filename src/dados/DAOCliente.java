/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Cliente;
import negocio.exception.ConexaoClienteException;
import negocio.exception.DAOClienteException;

/**
 *
 * @author PC
 */
public interface DAOCliente {

 public void inserir(Cliente cliente) throws DAOClienteException, ConexaoClienteException;
    
    /**
     * Busca no BD um registro correspondente ao nome passado
     * @param nome
     * @return nome do vendedor
     */
    public Cliente consultar(String nome) throws DAOClienteException, ConexaoClienteException;
    
}
    

