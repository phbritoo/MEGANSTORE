/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import java.util.Calendar;
import javax.swing.JOptionPane;
import negocio.basica.Pagamento;
import negocio.exception.ExceptionPagamento;

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
        
        
         if ((pagamento.getCardParcelas()==null)||(pagamento.getCardParcelas()== 0)){
            throw new ExceptionPagamento(this, "Número de parcelas inválido!", JOptionPane.ERROR_MESSAGE);
        } else if (pagamento.getCardParcelas() > 12) {
                throw new ExceptionPagamento("Só é possível dividir em até 12x.");
        }
        if ((pagamento.getCardValor()==null)||(pagamento.getCardValor()== 0)){
            throw new ExceptionPagamento("Valor total inválido!");
        } 
        if ((pagamento.getCardNum()==null)||(pagamento.getCardNum().isEmpty())){
            throw new ExceptionPagamento("Número do cartão inválido!");
        } else if (pagamento.getCardNum().length() != 16) {
            throw new ExceptionPagamento("O número do cartão deve conter 16 digitos");
        }
        
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int anoMax = year + 5 - 2000;
        int anoMin = year - 5 - 2000;
        
        if ((pagamento.getCardValidade()==null)||(pagamento.getCardValidade().isEmpty())){
            throw new ExceptionPagamento("Validade do cartão inválida!");
        } else if ((Integer.parseInt(pagamento.getCardValidade().substring(0,2)) == 00)
                 ||(Integer.parseInt(pagamento.getCardValidade().substring(0,2)) > 12)){
            throw new ExceptionPagamento("Mês inválido!");
        } else if ((Integer.parseInt(pagamento.getCardValidade().substring(3,5)) > anoMax)
                || (Integer.parseInt(pagamento.getCardValidade().substring(3,5)) < anoMin)) {
            throw new ExceptionPagamento("Cartão fora da validade!");
        }
        if ((pagamento.getCardTitular()==null)||(pagamento.getCardNum().isEmpty())){
            throw new ExceptionPagamento("Nome do titular inválido!");
        }// else if (CONSISTIR NOME COM PELO MENOS DUAS PALAVRAS);
    }

    /**
     *
     * @param parcelas com a quantidade de parcelas a serem divididas
     * @param valor todal da compra
     * @throws ExceptionPagamento
     */
    public void validar (Integer parcelas, Double valor) throws ExceptionPagamento{
        
        if ((parcelas ==null)||(parcelas == 0)){
            throw new ExceptionPagamento(this, "Número de parcelas inválido!", JOptionPane.ERROR_MESSAGE);
        } else if (parcelas > 12) {
                throw new ExceptionPagamento("Só é possível dividir em até 12x.");
        }
        if ((valor ==null)||(valor == 0)){
            throw new ExceptionPagamento("Valor total inválido!");
        } 
    }
    /**
     * Salva os dados no BD
     * @param pagamento. Objeto com os dados a serem salvos
     */
    public void incluir(Pagamento pagamento) {
        
    }
    /**
     * Salva os dados no BD
     * @param pacelas com a quantidade de parcelas a serem divididas
     * @param valor todal da compra
     * @return Valor da parcela que é = valor total / por parcela
     */
    public Double parcelar(Integer pacelas, Double valor) {
        Double valorparcela;
        valorparcela = valor/pacelas;
            
        return valorparcela; 
    }
}