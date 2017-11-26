/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 *
 * @author Djalma
 */
public interface DAOFornecedor {
    
   /**
     * Salva os dados no BD
     * @param fornecedor objeto com CNPJ, nome e telefone do fornecedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void incluir(Fornecedor fornecedor) throws DAOException, ConexaoException;
    
    /**
     * Busca no BD um registro correspondente ao CNPJ passado
     * @param fornecedorNome Objeto com CNPJ a ser pesquisado
     * @return o código do fornecedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public Fornecedor consultar(String fornecedorNome) throws DAOException, ConexaoException;
    
    /**
    * Altera no BD um registro o nome do fornecedor selecionado
     * @param fornecedor Objeto contendo ID e dados a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    public void alterar(Fornecedor fornecedor) throws DAOException, ConexaoException;
    
    /**
     * Exclui no BD o fornecedor selecionado
     * @param fornecedor Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    public void excluir(Fornecedor fornecedor) throws DAOException, ConexaoException;
    
    /**
     * Lista um ou mais fornecedores atráves do nome
     * @param fornecedorNome nome ou parte do nome a ser pesquisado
     * @return ArrayList contendo um ou mais fornedores
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public ArrayList<Fornecedor>listarPorNome(String fornecedorNome) throws DAOException, ConexaoException;          
    
    /**
     * Lista todos os fornecedores cadastrados
     * @return ArrayList com todos os fornedores cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Fornecedor>listarTodos() throws DAOException, ConexaoException;      
    
}
