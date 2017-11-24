/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import negocio.basica.Pagamento;
import negocio.exception.DAOException;
import negocio.exception.PagamentoException;
import negocio.regra.RegraPagamento;

/**
 *
 * @author aluno
 */
public class FachadaPagamento {
    RegraPagamento rn = new RegraPagamento();
    
    public void cadastrar (Pagamento pagamento) throws PagamentoException, DAOException{
        rn.validar(pagamento);
        rn.incluir(pagamento);
               
    }
    /*public void cadastrar (Integer pacelas, Double Valor) throws PagamentoException{
        rn.validar(pacelas, Valor);
        rn.parcelar(pacelas, Valor);
              
    }*/

    /**
     *
     * @param pacelas
     * @param Valor
     * @return
     * @throws PagamentoException
     */
    
    public Double cadastrar (Integer pacelas, Double Valor) throws PagamentoException{
        rn.validar(pacelas, Valor);
        return rn.parcelar(pacelas, Valor);
    }
}
