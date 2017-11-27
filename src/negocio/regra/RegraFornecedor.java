/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOFornecedor;
import dados.DAOFornecedorImpl;
import java.util.ArrayList;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.FornecedorException;

/**
 *
 * @author Djalma
 */
public class RegraFornecedor {
    private final DAOFornecedor DAO;
    
    public RegraFornecedor(){
        DAO = new DAOFornecedorImpl();
    }
    
    /**
     * Valida o objeto Fornecedor
     * @param fornecedor Objeto que contém o CNPJ, nome e telefone do fornecedor
     * @throws FornecedorException 
     */
    public void validar (Fornecedor fornecedor) throws FornecedorException {
        
        if (fornecedor==null){
            throw new FornecedorException("Objeto inválido!");
        }
        if ((fornecedor.getFornecedorCnpj()==null)||(fornecedor.getFornecedorCnpj().isEmpty())){
            throw new FornecedorException("CNPJ inválido!");
        } else if (fornecedor.getFornecedorCnpj().length() != 14){
            throw new FornecedorException("O número do CNPJ deve conter 14 digitos");
        }
        if ((fornecedor.getFornecedorNome()==null)||(fornecedor.getFornecedorNome().isEmpty())){
            throw new FornecedorException("Nome inválido!");
        }
        if ((fornecedor.getFornecedorTel()==null)||(fornecedor.getFornecedorTel().isEmpty())){
            throw new FornecedorException("Telefone inválido!");
        }
        else if (fornecedor.getFornecedorTel().length() != 11){
            throw new FornecedorException("O número do telefone deve conter 11 digitos");
        }
    }
    
    /**
     * Verifica se o CNPJ já existe no banco de dados
     * @param fornecedor Objeto contentdo o CNPJ a ser pesquisado
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.DAOException
     */
    public void eUnico (Fornecedor fornecedor) throws FornecedorException, DAOException{
        try{ 
            if(DAO.consultar(fornecedor.getFornecedorCnpj())!=null){
                throw new FornecedorException("Fornecedor já cadastrado");
            }
       }catch(ConexaoException e){
            throw new FornecedorException("Erro no BD");
       }catch(DAOException e){
            throw new FornecedorException("Erro de Aplicação(SQL)");
       }
    }       
    
    /**
     * Salva os dados no Banco de Dados
     * @param fornecedor Objeto com CNPJ, nome e telefone a ser salvo no BD
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void incluir(Fornecedor fornecedor) throws FornecedorException, ConexaoException, DAOException {
        try {
            DAO.incluir(fornecedor);
        }catch (ConexaoException ex){
            throw new FornecedorException("Erro no BD");
        }catch (DAOException e){
            throw new FornecedorException("Erro no BD");
        }
    }
    
    /**
     * Lista um ou mais fornecedor através de um nome
     * @param fornecedorNome nome ou parte do nome a ser listado
     * @return ArrayList com um ou mais fornecedores
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Fornecedor> listarPorNome(String fornecedorNome) throws FornecedorException, ConexaoException, DAOException {
        try {
            return DAO.listarPorNome(fornecedorNome);
        }catch(ConexaoException ex){
            throw new FornecedorException("Erro no BD");
        }catch (DAOException ex) {
            throw new FornecedorException(ex.getMessage());
        }
    }
    
    /**
     * Lista todos os fornecedores cadastrados 
     * @return 
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Fornecedor> listarTodos() throws FornecedorException, ConexaoException, DAOException {
        try {
            return DAO.listarTodos();
        }catch(ConexaoException ex){
            throw new FornecedorException("Erro no BD");
        }catch (DAOException ex) {
            throw new FornecedorException("Erro no SQL");
        }
    }
    
    /**
     * Exclui fornecedor selecionado
     * @param fornecedor Objeto com ID do fornecedor a ser excluído
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void excluir(Fornecedor fornecedor) throws FornecedorException, ConexaoException, DAOException{
        try{  
           DAO.excluir(fornecedor); 
        } catch (ConexaoException ex){
                throw new FornecedorException("Erro no BD");
        } catch (DAOException ex){
            throw new FornecedorException("Erro no SQL");
        }
    }
    
    /**
     * Altera nome do fornecedor selecionado
     * @param fornecedor Objeto com ID e dados do fornecedor a serem alterados
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void alterar(Fornecedor fornecedor) throws FornecedorException, ConexaoException, DAOException{
        try{  
           DAO.alterar(fornecedor); 
        } catch (ConexaoException ex){
            throw new FornecedorException("Erro no BD");
        } catch (DAOException ex){
            throw new FornecedorException("Erro no SQL");
        }
    }
    
}