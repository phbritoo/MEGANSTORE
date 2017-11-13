/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Pagamento;
import negocio.exception.ConexaoPagamentoException;
import negocio.exception.DAOPagamentoException;

/**
 *
 * @author heloi
 */
public class DAOPagamentoImpl implements DAOPagamento{
    
    @Override
    public void inserir (Pagamento pagamento)throws DAOPagamentoException, ConexaoPagamentoException{
    }
    
}
