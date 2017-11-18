/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.basica.Produto;
import negocio.basica.Vendedor;
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
    }}      
        
   /*
      public void eUnico (Produto produto) throws ExceptionsProduto{
       DAOProduto dao = new DAOProdutoImpl();
       try{ 
       if(dao.consultar(Produto.getPrd_nome())!=null){
            throw new ExceptionsProduto("Esse nome já existe!");
        }
       }catch(ConexaoProdutoException e){
            throw new ExceptionsProduto("Erro no banco!");
       }catch(DAOProdutoException e){
            throw new ExceptionsProduto("Erro de Aplicação(SQL)!");
       }
           }
           public Produto consultar(Integer codigo) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
   
    /**
     * Salva os dados no Banco de Dados
     * @param vendedor Objeto com nome a ser salvo no BD
     */
   /*
        public void incluir(Vendedor vendedor) {
    }
        
    }
}*/