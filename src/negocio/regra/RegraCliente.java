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
import negocio.basica.Cliente;
import negocio.exception.DAOException;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;
import negocio.exception.ClienteException;
/**
 *
 * @author William
 */
public class RegraCliente {
    private final DAOCliente DAO;
    
    public RegraCliente(){
        DAO = new DAOClienteImpl();
    }
    
    /**
     * Valida o objeto Cliente  
     * @param cliente 
     * @throws negocio.exception.ClienteException 
     */
    public void validar (Cliente cliente) throws ClienteException {
        if (cliente==null){
            throw new ClienteException("Objeto inválido!");
        }
        if ((cliente.getClienteNome()==null)||(cliente.getClienteNome().isEmpty())){
            throw new ClienteException("Nome inválido!");
        }
    }
    
    /**
     * Verifica se o CPF já existe no banco de dados
     * @param cliente Objeto com o CPF a ser pesquisado
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void eUnico (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        try{
            if(DAO.consultar(cliente.getClienteCpf())!= null){
                throw new ClienteException("Cliente já cadastrado");
        }
        }catch(ConexaoException e){
            throw new ClienteException("Erro no BD!");
        }catch(DAOException e){
            throw new ClienteException("Erro de Aplicação(SQL)!");
       }
    }
    
    /**
     * Salva os dados no Banco de Dados
     * @param cliente bjeto com CPF, nome e telefone a ser salvo no BD
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void incluir(Cliente cliente) throws ClienteException, ConexaoException, DAOException{  
        try{  
            DAO.incluir(cliente); 
        } catch (ConexaoException ex){
            throw new ClienteException("Erro no BD");
        } catch (DAOException ex){
            throw new ClienteException("Erro no SQL");
        }
           
    }
     
      /**
     * Lista todos os clientes cadastrados 
     * @return ArrayList com todos os clientes cadastrados
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
    
    /**
     * Lista um ou mais cliente através de um nome 
     * @param clienteNome nome ou parte do nome a ser listado
     * @return ArrayList com um ou mais clientees
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Cliente> listarPorNome(String clienteNome) throws ClienteException, ConexaoException, DAOException {
        try {
            return DAO.listarPorNome(clienteNome);
        }catch(ConexaoException ex){
            throw new ClienteException("Erro no BD");
        }catch (DAOException ex) {
            throw new ClienteException(ex.getMessage());
        }
    }
    
    /**
     * Exclui cliente selecionado
     * @param cliente Objeto com ID do cliente a ser excluído
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void excluir(Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        try{  
           DAO.excluir(cliente); 
        } catch (ConexaoException ex){
                throw new ClienteException("Erro no BD");
        } catch (DAOException ex){
            throw new ClienteException("Erro no SQL");
        }
    }
    
    /**
     * Altera nome do cliente selecionado
     * @param cliente Objeto com ID e dados do cliente a serem alterados
     * @throws negocio.exception.ClienteException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void alterar(Cliente cliente) throws ClienteException, ConexaoException, DAOException{
        try{  
           DAO.alterar(cliente); 
        } catch (ConexaoException ex){
            throw new ClienteException("Erro no BD");
        } catch (DAOException ex){
            throw new ClienteException("Erro no SQL");
        }
    }
}