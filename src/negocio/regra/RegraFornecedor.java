/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOFornecedor;
import dados.DAOFornecedorImpl;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.FornecedorException;

/**
 *
 * @author Djalma
 */
public class RegraFornecedor {
    /**
     * Valida o objeto Fornecedor
     * @param Fornecedor Objeto que retorna apenas o nome do ornecedor
     * @throws FornecedorException 
     */
    public void validar (Fornecedor fornecedor) throws FornecedorException {
        
        if (fornecedor==null){
            throw new FornecedorException("Objeto inválido!");
        }
        if ((fornecedor.getForn_cnpj()==null)||(fornecedor.getForn_cnpj().isEmpty())){
            throw new FornecedorException("CNPJ inválido!");
        }
    }
    /**
     * Verifica se o nome já existe no banco de dados
     * @param fornecedor Objeto contentdo o CNPJ a ser pesquisado
     */
    public void eUnico (Fornecedor fornecedor) throws FornecedorException, DAOException{
       DAOFornecedor dao = new DAOFornecedorImpl();
       try{ 
       if(dao.consultar(fornecedor.getForn_cnpj())!=null){
            throw new FornecedorException("Esse CNPJ já existe!");
        }
       }catch(ConexaoException e){
            throw new FornecedorException("Erro no BD!");
       }catch(DAOException e){
            throw new FornecedorException("Erro de Aplicação(SQL)!");
       }
           }

           public Fornecedor consultar(String cnpj) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       
       
    
    /**
     * Salva os dados no Banco de Dados
     * @param fornecedor Objeto com CNPJ a ser salvo no BD
     */
    public void incluir(Fornecedor fornecedor) {
    }
    
}