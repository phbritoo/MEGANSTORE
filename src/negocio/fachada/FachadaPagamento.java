/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import negocio.basica.Pagamento;
import negocio.exception.ExceptionPagamento;
import negocio.regra.RegraPagamento;

/**
 *
 * @author aluno
 */
public class FachadaPagamento {
    public void cadastrar (Pagamento pagamento) throws ExceptionPagamento{
        RegraPagamento rn = new RegraPagamento();
        rn.validar(pagamento);
        rn.incluir(pagamento);
               
    }
}
