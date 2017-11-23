/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Compra;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 *
 * @author paulo
 */
public interface DAOCompra {
    
     
    /**
     * Salva os dados no BD
     * @param compra Objeto com os dados
     * @throws negocio.exception.DAOCompraException
     * @throws negocio.exception.ConexaoCompraException
     */
    public void inserir (Compra compra) throws DAOException, ConexaoException;
}
