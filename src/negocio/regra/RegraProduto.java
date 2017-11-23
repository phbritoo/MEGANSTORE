/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOProduto;
import dados.DAOProdutoImpl;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ProdutoException;

/**
 *
 * @author Gabriel
 */
public class RegraProduto{
    
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
    public Produto consultar(String Prd_cod) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
    
     public void incluir(Produto produto) {
    }
}               