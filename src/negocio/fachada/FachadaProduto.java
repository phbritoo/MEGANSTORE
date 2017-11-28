/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
import negocio.basica.Produto;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ProdutoException;
import negocio.exception.ProdutoException;
import negocio.regra.RegraProduto;
import negocio.regra.RegraProduto;

/**
 *
 * @author Gabriel
 */
public class FachadaProduto {
    
    /**
     * Faz as validações e grava um novo produto no BD 
     * @param produto a ser cadastrado
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException 
     */
    public void cadastrarProduto(Produto produto)throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto();
        rn.validar(produto);
        rn.eUnico(produto);
        rn.incluir(produto);
    }           
    
    /**
     * Altera o nome do produto no BD
     * @param produto a ser alterado
     * @throws ProdutoException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void alterar (Produto produto) throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto() ;
      //  rn.alterar(produto);
    }
    
    /**
     * Exclui produto do BD
     * @param produto a ser excluído
     * @throws ProdutoException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void excluir (Produto produto) throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto() ;
       // rn.excluir(produto);
    }
    
    /**
     * Pesquisa um ou mais produto através do nome
     * @return lista com todos os produtoes cadastrados
     * @throws ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Produto> listarTodos () throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rp = new RegraProduto();
        return rp.listarTodos();
    }
    
    /**
     * Pesquisa um ou mais produto através do nome
     * @param produtoNome primeiro nome ou parte do nome a ser pesquisado
     * @return lista de produto de acordo com a entrada
     * @throws ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Produto> listarPorNome (String produtoNome) throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rp = new RegraProduto();
        return rp.listarPorNome(produtoNome);
        }
    
    /**
     * Consulta o preço de um determinado produto através do nome
     * @param produto a ser pesquisado
     * @throws ProdutoException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public Double consultarPreco (String nomeProduto) throws ProdutoException, ConexaoException, DAOException{
    RegraProduto rp = new RegraProduto();
    return rp.consultarPreco(nomeProduto);
    }
    
    /**
     * Consulta um determinado produto através do nome
     * @param produto Objeto com nome do produto a ser pesquisado
     * @throws ProdutoException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public Produto consultar(String nomeProduto) throws ProdutoException, DAOException, ConexaoException{
    RegraProduto rp = new RegraProduto();
    return rp.consultar(nomeProduto);
    }
    
}
