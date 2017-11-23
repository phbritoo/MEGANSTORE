/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 *
 * @author Djalma
 */
public interface DAOFornecedor {
    
    
    public void inserir(Fornecedor fornecedor) throws DAOException, ConexaoException;
    
 
    public Fornecedor consultar(String cnpj) throws DAOException, ConexaoException;
    
}
