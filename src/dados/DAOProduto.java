/*
 * Interface de acesso a dados
 * relacionado a classe Produto
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package dados;

import java.util.ArrayList;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;


/**
 * @author Gabriel Carvalho
 * Revisado por Gildo Neto
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
     * @return 
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public Produto consultar(Integer codigo) throws DAOException, ConexaoException;
    
    /**
     * Busca no BD um registro correspondente ao Nome passado
     * @param nome
     * @return 
     * @throws DAOException
     * @throws ConexaoException 
     */
    public Produto consultar(String nome) throws DAOException, ConexaoException;
    
    /**
     * Busca no BD um registro correspondente ao Preço passado
     * @param nomeProduto
     * @return 
     * @throws DAOException
     * @throws ConexaoException 
     */
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
    public ArrayList<Produto> listarPoNome(String produtoNome) throws DAOException, ConexaoException;
    
    /**
     * Consulta chave do último registro inserido 
     * @return ultima chave inserida no BD 
     * @throws negocio.exception.DAOException 
     * @throws negocio.exception.ConexaoException 
     */
        public Integer obterChave() throws DAOException, ConexaoException;
    
    /**
     * Inclui associação entre produto e fornecedor
     * @param cnpj do fornecedor do produto
     * @param codProduto do produto do fornecedor 
     * @throws negocio.exception.DAOException 
     * @throws negocio.exception.ConexaoException 
     */
    public void incluirFornecedorProduto(String cnpj, Integer codProduto) throws DAOException, ConexaoException;
}
