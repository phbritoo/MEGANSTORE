/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.basica.Pagamento;
import negocio.exceptions.ExceptionPagamento;

/**
 *
 * @author paulo
 */
public class RegraPagamento {
    /**
     * Valida o objeto Pagamento passado
     * @param pagamento. Objeto com todos os dados
     * @throws ExceptionPagamento
     */
    public void validar (Pagamento pagamento) throws ExceptionPagamento{
        
        if ((pagamento==null)){
            throw new ExceptionPagamento("Objeto invalido!");
        }
         if ((pagamento.getCardParcelas()==null)||(pagamento.getCardParcelas() == 0)){
            throw new ExceptionPagamento("Nome invalido!");
        }
        if ((pagamento.getCardValor()==null)||(pagamento.getCardValor() == 0)){
            throw new ExceptionPagamento("CPF invalido!");
        }
        if ((pagamento.getCardnum()==null)||(pagamento.getCardnum().isEmpty())){
            throw new ExceptionPagamento("Sexo invalido!");
        }
    }
    
    /**
     * Salva os dados no BD
     * @param pagamento. Objeto com os dados a serem salvos
     */
    public void incluir(Pagamento aluno) {
        
    }
}


