/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOCliente;
import dados.DAOClienteImpl;
import negocio.basica.Cliente;
import negocio.exception.DAOException;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;

/**
 *
 * @author William
 */
public class RegraCliente {
    
    public void validar (Cliente cliente) throws ClienteException {
        
        if (cliente==null){
            throw new ClienteException("Objeto inválido!");
        }
        if ((cliente.getCli_nome()==null)||(cliente.getCli_nome().isEmpty())){
            throw new ClienteException("Nome inválido!");
        }
    }
    public void eUnico (Cliente cliente) throws ClienteException, ConexaoException, DAOException{
       DAOCliente dao = new DAOClienteImpl();
       try{ 
       if(dao.consultar(cliente.getCli_nome())!=null){
            throw new ClienteException("Esse Cliente já existe!");
        }
       }catch(ConexaoException e){
            throw new ClienteException("Erro no BD!");
       }catch(DAOException e){
            throw new ClienteException("Erro de Aplicação(SQL)!");
       }
           }
}