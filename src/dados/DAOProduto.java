/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Produto;
import negocio.exception.ConexaoProdutoException;
import negocio.exception.DAOProdutoException;


/**
 *
 * @author Gabriel
 */
public interface DAOProduto {
    
    /**
     *
     * @param produto
     * @throws DAOProdutoException
     * @throws ConexaoProdutoException
     */
    public void inserir(Produto produto) throws DAOProdutoException, ConexaoProdutoException;
 
    public void deletar (Produto produto) throws DAOProdutoException, ConexaoProdutoException;
    
    public void alterar (Produto produto) throws DAOProdutoException, ConexaoProdutoException;
   
    public Produto consultar(Integer  codigo) throws DAOProdutoException, ConexaoProdutoException;
    
    
    
}
