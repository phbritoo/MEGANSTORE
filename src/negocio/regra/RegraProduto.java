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
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
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
    
    public void validar(Produto produto) throws ProdutoException{
        
        if (produto == null){
            throw new ProdutoException("objeto produto não criado");
        }
        if (produto.getProdutoCodigo() == 0){
             throw new ProdutoException("Código inválido");
        }        
        if (produto.getProdutoEstoque() == 0){
             throw new ProdutoException("Estoque inválido");
        }
        if (produto.getProdutoPreco() == 0){
             throw new ProdutoException("Preco inválido");
        }
        if ((produto.getProdutoNome() == null) || (produto.getProdutoNome().isEmpty())){
             throw new ProdutoException("Nome inválido");
        }       
    }
    
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
      
     public void incluir(Produto produto) {
    }
     
    public ArrayList<Produto> listarTodos() throws ProdutoException, ConexaoException, DAOException {
        try {
            return DAO.listarTodos();
        }catch(ConexaoException ex){
            throw new ProdutoException("Erro no BD");
        }catch (DAOException ex) {
            throw new ProdutoException("Erro no SQL");
        }
    }
    
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
     *
     * @param nomeProduto
     * @return
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
}               