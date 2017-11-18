/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Pagamento;
import negocio.exception.ConexaoException;
import negocio.exception.ConexaoPagamentoException;
import negocio.exception.DAOPagamentoException;

/**
 *
 * @author heloi
 */
public interface DAOPagamento {
    
    /**
     * Salva os dados no BD
     * @param pagamento Objeto com os dados
     * @throws negocio.exception.DAOPagamentoException
     * @throws negocio.exception.ConexaoException
     */
    public void inserir (Pagamento pagamento) throws DAOPagamentoException, ConexaoException;
}
