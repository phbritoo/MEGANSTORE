/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.FornecedorException;
import negocio.regra.RegraFornecedor;

/**
 *
 * @author aluno
 */
public class FachadaFornecedor {
    
    /**
     * Faz as validações e grava um novo fornecedor no BD 
     * @param fornecedor a ser cadastrado
     * @throws negocio.exception.FornecedorException
     * @throws negocio.exception.DAOException 
     */
    public void cadastrar (Fornecedor fornecedor) throws FornecedorException, DAOException, ConexaoException{
        RegraFornecedor rn = new RegraFornecedor();
        rn.validar(fornecedor);
        rn.eUnico(fornecedor);
        rn.incluir(fornecedor);
    }
    
    /**
     * Altera o nome do fornecedor no BD
     * @param fornecedor a ser alterado
     * @throws FornecedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void alterar (Fornecedor fornecedor) throws FornecedorException, ConexaoException, DAOException{
        RegraFornecedor rn = new RegraFornecedor() ;
        rn.alterar(fornecedor);
    }
    
    /**
     * Exclui fornecedor do BD
     * @param fornecedor a ser excluído
     * @throws FornecedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void excluir (Fornecedor fornecedor) throws FornecedorException, ConexaoException, DAOException{
        RegraFornecedor rn = new RegraFornecedor() ;
        rn.excluir(fornecedor);
    }
    
    /**
     * Pesquisa um ou mais fornecedor através do nome
     * @param fornecedorNome primeiro nome ou parte do nome a ser pesquisado
     * @return lista de fornecedor de acordo com a entrada
     * @throws FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Fornecedor> listarPoNome (String fornecedorNome) throws FornecedorException, ConexaoException, DAOException{
        RegraFornecedor rn = new RegraFornecedor();
        return rn.listarPorNome(fornecedorNome);
    }
    
    /**
     * Pesquisa um ou mais fornecedor através do nome
     * @return lista com todos os fornecedores cadastrados
     * @throws FornecedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Fornecedor> listarTodos () throws FornecedorException, ConexaoException, DAOException{
        RegraFornecedor rn = new RegraFornecedor();
        return rn.listarTodos();
    }
}
