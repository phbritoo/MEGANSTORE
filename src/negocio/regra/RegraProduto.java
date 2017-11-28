/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOProduto;
import dados.DAOProdutoImpl;
import java.util.ArrayList;
import negocio.basica.Produto;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ProdutoException;
import negocio.exception.ProdutoException;
import negocio.exception.ProdutoException;

/**
 *
 * @author Gabriel
 */
public class RegraProduto{
     
        private final DAOProduto DAO;
        
    public RegraProduto(){
        DAO = new DAOProdutoImpl();
    }
    
    /**
     * Valida o objeto Produto
     * @param produto Objeto que contém nome, estoque e preço do produto 
     * @throws negocio.exception.ProdutoException 
     */
    public void validar(Produto produto) throws ProdutoException{
        
        if (produto == null){
            throw new ProdutoException("Objeto inválido!");
        }        
        if (produto.getProdutoEstoque() == 0){
             throw new ProdutoException("Estoque inválido");
        }
        if (produto.getProdutoPreco() == 0){
             throw new ProdutoException("Preço inválido");
        }
        if ((produto.getProdutoNome() == null) || (produto.getProdutoNome().isEmpty())){
             throw new ProdutoException("Nome inválido");
        }       
    }
    
    /**
     * Verifica se o produto já existe no banco de dados
     * @param produto Objeto contentdo o nome a ser pesquisado
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.DAOException
     */
    public void eUnico (Produto produto) throws ProdutoException, ConexaoException, DAOException{
       DAOProduto dao = new DAOProdutoImpl();
       try{ 
       if(dao.consultar(produto.getProdutoCodigo())!=null){
            throw new ProdutoException("Código de produto já cadastrado!");
        }
       }catch(ConexaoException e){
            throw new ProdutoException("Erro no BD!");
       }catch(DAOException e){
            throw new ProdutoException("Erro de Aplicação(SQL)!");
       }
    }
    
    /**
     * Salva os dados no Banco de Dados
     * @param produto Objeto com nome, estoque e preço a ser salvo no BD
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void incluir(Produto produto) throws ProdutoException, ConexaoException, DAOException {
        try {
            DAO.incluir(produto);
        }catch (ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException e){
            throw new ProdutoException("Erro no BD");
        }
    }
     
    /**
     * Lista todos os produtos cadastrados 
     * @return ArrayList com todos os produtos cadastrados
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Produto> listarTodos() throws ProdutoException, ConexaoException, DAOException {
        try {
            return DAO.listarTodos();
        }catch(ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex) {
            throw new ProdutoException("Erro no SQL");
        }
    }
    
    /**
     * Lista um ou mais produto através de um nome
     * @param produtoNome nome ou parte do nome a ser listado
     * @return ArrayList com um ou mais produtos
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Produto> listarPorNome(String produtoNome) throws ProdutoException, ConexaoException, DAOException {
        try {
            return DAO.listarPorNome(produtoNome);
        }catch(ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex) {
            throw new ProdutoException(ex.getMessage());
        }
    }
    
    /**
     * Consulta o preço de determinado produto
     * @param nomeProduto
     * @return preco do produto
     * @throws ProdutoException
     * @throws ConexaoException
     * @throws DAOException
     */
    public Double consultarPreco(String nomeProduto) throws ProdutoException, ConexaoException, DAOException {
    try {
            return DAO.consultarPreco(nomeProduto);
        }catch(ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex) {
            throw new ProdutoException(ex.getMessage());
        }
    }
    
    public Produto consultar (String nomeProduto) throws ProdutoException, ConexaoException, DAOException {
        try{
           return DAO.consultar(nomeProduto);
        }catch(ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex) {
            throw new ProdutoException(ex.getMessage());
        }
    }
    
    /**
     * Exclui produto selecionado
     * @param produto Objeto com ID do produto a ser excluído
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void excluir(Produto produto) throws ProdutoException, ConexaoException, DAOException{
        try{  
           DAO.excluir(produto); 
        } catch (ConexaoException ex){
                throw new ProdutoException("Erro no BD");
        } catch (DAOException ex){
            throw new ProdutoException("Erro no SQL");
        }
    }
    
    /**
     * Altera nome do produto selecionado
     * @param produto Objeto com ID e dados do produto a serem alterados
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void alterar(Produto produto) throws ProdutoException, ConexaoException, DAOException{
        try{  
           DAO.alterar(produto); 
        }catch (ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex){
            throw new ProdutoException("Erro no SQL");
        }
    }
}               