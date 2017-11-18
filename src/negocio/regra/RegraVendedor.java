/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOVendedor;
import dados.DAOVendedorImpl;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOVendedorException;
import negocio.exception.ExceptionsVendedor;

/**
 *
 * @author gildo
 */
public class RegraVendedor {
    /**
     * Valida o objeto Vendedor
     * @param vendedor Objeto que retorna apenas o nome do vendedor
     * @throws ExceptionsVendedor 
     */
    public void validar (Vendedor vendedor) throws ExceptionsVendedor {
        
        if (vendedor==null){
            throw new ExceptionsVendedor("Objeto inválido!");
        }
        if ((vendedor.getVend_nome()==null)||(vendedor.getVend_nome().isEmpty())){
            throw new ExceptionsVendedor("Nome inválido!");
        }
    }
    /**
     * Verifica se o nome já existe no banco de dados
     * @param vendedor Objeto contentdo o nome a ser pesquisado
     */
    public void eUnico (Vendedor vendedor) throws ExceptionsVendedor{
       DAOVendedor dao = new DAOVendedorImpl();
       try{ 
       if(dao.consultar(vendedor.getVend_nome())!=null){
            throw new ExceptionsVendedor("Esse funcionário já existe!");
        }
       }catch(ConexaoException e){
            throw new ExceptionsVendedor("Erro no BD!");
       }catch(DAOVendedorException e){
            throw new ExceptionsVendedor("Erro de Aplicação(SQL)!");
       }
           }

           public Vendedor consultar(String nome) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       
       
    
    /**
     * Salva os dados no Banco de Dados
     * @param vendedor Objeto com nome a ser salvo no BD
     */
    public void incluir(Vendedor vendedor) {
    }
    
}