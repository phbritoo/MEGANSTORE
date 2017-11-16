/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOCliente;
import dados.DAOClienteImpl;
import negocio.basica.Cliente;
import negocio.exception.ConexaoClienteException;
import negocio.exception.DAOClienteException;
import negocio.exception.ExceptionsCliente;

/**
 *
 * @author William
 */
public class RegraCliente {
    
    public void validar (Cliente cliente) throws ExceptionsCliente {
        
        if (cliente==null){
            throw new ExceptionsCliente("Objeto inválido!");
        }
        if ((cliente.getCli_nome()==null)||(cliente.getCli_nome().isEmpty())){
            throw new ExceptionsCliente("Nome inválido!");
        }
    }
    public void eUnico (Cliente cliente) throws ExceptionsCliente{
       DAOCliente dao = new DAOClienteImpl();
       try{ 
       if(dao.consultar(cliente.getCli_nome())!=null){
            throw new ExceptionsCliente("Esse Cliente já existe!");
        }
       }catch(ConexaoClienteException e){
            throw new ExceptionsCliente("Erro no BD!");
       }catch(DAOClienteException e){
            throw new ExceptionsCliente("Erro de Aplicação(SQL)!");
       }
           }
}