/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exception;

import negocio.regra.RegraPagamento;

/**
 *
 * @author aluno
 */
public class ExceptionPagamento extends Exception {

    public ExceptionPagamento(String texto) {
        super(texto);
    }
    
    public ExceptionPagamento(){
    }

    public ExceptionPagamento(RegraPagamento aThis, String número_de_parcelas_inválido, int ERROR_MESSAGE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
