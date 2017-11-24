/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOPagamento;
import dados.DAOPagamentoImpl;
import java.util.Calendar;
import javax.swing.JOptionPane;
import negocio.basica.Pagamento;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.PagamentoException;

/**
 *
 * @author paulo
 */
public class RegraPagamento {
    //public final DAOPagamento DAO;
    DAOPagamento dao = new DAOPagamentoImpl();
    /*public RegraPagamento(){
        DAO = new DAOPagamentoImpl();
    }*/
    
    /**
     * Valida o objeto Pagamento passado
     * @param pagamento. Objeto com todos os dados
     * @throws PagamentoException
     */
    public void validar (Pagamento pagamento) throws PagamentoException{
        
        if ((pagamento==null)){
            throw new PagamentoException("Objeto invalido!");
        }
        
        
         if ((pagamento.getCardParcelas()==null)||(pagamento.getCardParcelas()== 0)){
            throw new PagamentoException(this, "Número de parcelas inválido!", JOptionPane.ERROR_MESSAGE);
        } else if (pagamento.getCardParcelas() > 12) {
                throw new PagamentoException("Só é possível dividir em até 12x.");
        }
        if ((pagamento.getCardValor()==null)||(pagamento.getCardValor()== 0)){
            throw new PagamentoException("Valor total inválido!");
        } 
        if ((pagamento.getCardNum()==null)||(pagamento.getCardNum().isEmpty())){
            throw new PagamentoException("Número do cartão inválido!");
        } else if (pagamento.getCardNum().length() != 16) {
            throw new PagamentoException("O número do cartão deve conter 16 digitos");
        }
        
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int anoMax = year + 5 - 2000;
        int anoMin = year - 2000;
        
        if ((pagamento.getCardValidade()==null)||(pagamento.getCardValidade().isEmpty())){
            throw new PagamentoException("Validade do cartão inválida!");
        } else if ((Integer.parseInt(pagamento.getCardValidade().substring(0,2)) == 00)
                 ||(Integer.parseInt(pagamento.getCardValidade().substring(0,2)) > 12)){
            throw new PagamentoException("Mês inválido!");
        }
        if ( (Integer.parseInt(pagamento.getCardValidade().substring(3,5)) <= anoMin)
                && (Integer.parseInt(pagamento.getCardValidade().substring(0,2)) < month) 
                || (Integer.parseInt(pagamento.getCardValidade().substring(3,5)) > anoMax) ){
            throw new PagamentoException("Cartão fora da validade!");
        }
        if ((pagamento.getCardTitular()==null)||(pagamento.getCardNum().isEmpty())){
            throw new PagamentoException("Nome do titular inválido!");
        }// else if (CONSISTIR NOME COM PELO MENOS DUAS PALAVRAS);
    }

    /**
     *
     * @param parcelas com a quantidade de parcelas a serem divididas
     * @param valor todal da compra
     * @throws PagamentoException
     */
    public void validar (Integer parcelas, Double valor) throws PagamentoException{
        
        if ((parcelas ==null)||(parcelas == 0)){
            throw new PagamentoException(this, "Número de parcelas inválido!", JOptionPane.ERROR_MESSAGE);
        } else if (parcelas > 12) {
                throw new PagamentoException("Só é possível dividir em até 12x.");
        }
        if ((valor ==null)||(valor == 0)){
            throw new PagamentoException("Valor total inválido!");
        } 
    }
    /**
     * Salva os dados no BD
     * @param pagamento. Objeto com os dados a serem salvos
     * @throws negocio.exception.PagamentoException
     * @throws negocio.exception.DAOException
     */
    public void incluir(Pagamento pagamento) throws PagamentoException, DAOException {
        try{
            dao.inserir(pagamento);
        }catch (ConexaoException | DAOException ce) {
            throw new PagamentoException(ce.getMessage());
        }
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