/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
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
    
    public void cadastrarProduto(Produto produto)throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rn = new RegraProduto();
        rn.validar(produto);
        rn.eUnico(produto);
        rn.incluir(produto);
    }           

    public ArrayList<Produto> listarTodos () throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rp = new RegraProduto();
        return rp.listarTodos();
    }
    
    public ArrayList<Produto> listarPorNome (String produtoNome) throws ProdutoException, ConexaoException, DAOException{
        RegraProduto rp = new RegraProduto();
        return rp.listarPorNome(produtoNome);
        }
    
    public Double consultarPreco (String nomeProduto) throws ProdutoException, ConexaoException, DAOException{
    RegraProduto rp = new RegraProduto();
    return rp.consultarPreco(nomeProduto);
    }
}
