/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOProduto;
import dados.DAOProdutoImpl;
import negocio.basica.Produto;
import negocio.exception.ConexaoProdutoException;
import negocio.exception.DAOProdutoException;
import negocio.exception.ExceptionsProduto;

/**
 *
 * @author Gabriel
 */
public class RegraProduto{
    
    public void validar(Produto produto) throws ExceptionsProduto{
        
        if (produto == null){
            throw new ExceptionsProduto("objeto produto não criado");
        }
        if (produto.getPrd_cod() == 0){
             throw new ExceptionsProduto("Código inválido");
        }        
        if (produto.getPrd_estoque() == 0){
             throw new ExceptionsProduto("Estoque inválido");
        }
        if (produto.getPrd_preco() == 0){
             throw new ExceptionsProduto("Preco inválido");
        }
        if ((produto.getPrd_nome() == null) || (produto.getPrd_nome().isEmpty())){
             throw new ExceptionsProduto("Nome inválido");
        }       
    }
    
    public void eUnico (Produto produto) throws ExceptionsProduto{
       DAOProdutoImpl dao = new DAOProdutoImpl();
       try{ 
       if(dao.consultar(produto.getPrd_cod())!=null){
            throw new ExceptionsProduto("Código de produto já cadastrado!");
        }
       }catch(ConexaoProdutoException e){
            throw new ExceptionsProduto("Erro no BD!");
       }catch(DAOProdutoException e){
            throw new ExceptionsProduto("Erro de Aplicação(SQL)!");
       }
    }
    public Produto consultar(String Prd_cod) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
    
     public void incluir(Produto produto) {
    }
}               