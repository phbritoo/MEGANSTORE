/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;


/**
 *
 * @author Gabriel
 */
public interface DAOProduto {
    
    /**
     * Salva os dados no BD
     * @param produto objeto com nome, estoque e preço do produto
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void incluir(Produto produto) throws DAOException, ConexaoException;
    
    /**
     * Exclui no BD o produto selecionado
     * @param produto Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    public void excluir (Produto produto) throws DAOException, ConexaoException;
    
    /**
    * Altera no BD o registro o selecionado
     * @param produto Objeto contendo ID e dados a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    public void alterar (Produto produto) throws DAOException, ConexaoException;
    
    /**
     * Busca no BD um registro correspondente ao CNPJ passado
     * @param codigo
     * @return o código do produto
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public Produto consultar(Integer codigo) throws DAOException, ConexaoException;
    
    public Produto consultar(String nome) throws DAOException, ConexaoException;
    
    public Double consultarPreco(String nomeProduto) throws DAOException, ConexaoException;
    
    /**
     * Lista todos os produtos cadastrados
     * @return ArrayList com todos os produtos cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Produto>listarTodos() throws DAOException, ConexaoException;
    
    /**
     * Lista um ou mais produtos atráves do nome
     * @param produtoNome nome ou parte do nome a ser pesquisado
     * @return ArrayList contendo um ou mais produtos
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public ArrayList<Produto> listarPorNome(String produtoNome) throws DAOException, ConexaoException;
    
}
