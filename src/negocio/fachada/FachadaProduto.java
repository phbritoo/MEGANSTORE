/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
import negocio.basica.FornecedorProduto;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ProdutoException;
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
    public void cadastrar(Produto produto)throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto();
        rn.validar(produto);
        rn.eUnico(produto);
        rn.incluir(produto);
    }  
    
    /**
     * Consulta chave do último registro
     * @return Chave do produto cadastrado
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException 
     */
    public Integer obterChave()throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto();
        return rn.obterChave(); 
    }
    
    /**
     * Associa o produto ao seu fornecedor
     * @param produto a ser cadastrado
     * @param fornecedorProduto
     * @throws negocio.exception.ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException 
     */
    public void associar(Produto produto, FornecedorProduto fornecedorProduto)throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto();
        rn.incluirFornecedorProduto(fornecedorProduto.getFornecedorCnpj(), produto.getProdutoCodigo());
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
        rn.alterar(produto);
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
        rn.excluir(produto);
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
     * Pesquisa um ou mais produto através do nome e/ou CNPJ do fornecedor
     * @param produtoNome primeiro nome ou parte do nome a ser pesquisado
     * @return lista de produto de acordo com a entrada
     * @throws ProdutoException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Produto> listarPoNome (String produtoNome) throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rp = new RegraProduto();
        return rp.listarPoNome(produtoNome);
        }
    
    /**
     * Consulta o preço de um determinado produto através do nome
     * @param nomeProduto a ser pesquisado
     * @return preço do produto
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
     * @param nomeProduto nome do produto a ser pesquisado
     * @return Objeto produto
     * @throws ProdutoException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public Produto consultar(String nomeProduto) throws ProdutoException, DAOException, ConexaoException{
    RegraProduto rp = new RegraProduto();
    return rp.consultar(nomeProduto);
    }
    
}
