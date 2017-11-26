/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOCliente;
import dados.DAOClienteImpl;
import java.util.ArrayList;
import negocio.basica.Cliente;
import negocio.exception.DAOException;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;
/**
 *
 * @author William
 */
public class RegraCliente {
        private final DAOCliente DAO;
        public RegraCliente(){
        DAO = new DAOClienteImpl();
    }
    
    public void validar (Cliente cliente) throws ClienteException {
        
        if (cliente==null){
            throw new ClienteException("Objeto inválido!");
        }
        if ((cliente.getClienteNome()==null)||(cliente.getClienteNome().isEmpty())){
            throw new ClienteException("Nome inválido!");
        }
    }
    public void eUnico (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
       
       try{
       if(DAO.consultar(cliente.getClienteNome())!=null){
            throw new ClienteException("Esse Cliente já existe!");
        }
       }catch(ConexaoException e){
            throw new ClienteException("Erro no BD!");
       }catch(DAOException e){
            throw new ClienteException("Erro de Aplicação(SQL)!");
       }
           }
    
     public void incluir(Cliente cliente) throws ClienteException, ConexaoException, DAOException{
           
         try{  
               DAO.inserir(cliente); 
           } catch (ConexaoException ex){
                throw new ClienteException("Erro no BD");
           } catch (DAOException ex){
                throw new ClienteException("Erro no SQL");
           }
           
    }
     
      /**
     * Lista todos os vendedores cadastrados 
     * @return 
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Cliente> listarTodos() throws ClienteException, ConexaoException, DAOException {
        try {
            return DAO.listarTodos();
        }catch(ConexaoException ex){
            throw new ClienteException("Erro no BD");
        }catch (DAOException ex) {
            throw new ClienteException("Erro no SQL");
        }
    }
    
    public ArrayList<Cliente> listarPorNome(String clienteNome) throws ClienteException, ConexaoException, DAOException {
        try {
            return DAO.listarPorNome(clienteNome);
        }catch(ConexaoException ex){
            throw new ClienteException("Erro no BD");
        }catch (DAOException ex) {
            throw new ClienteException(ex.getMessage());
        }
    }
    
}