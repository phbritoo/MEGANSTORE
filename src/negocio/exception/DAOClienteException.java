/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exception;

/**
 *
 * @author PC
 */
public class DAOClienteException extends Exception{

    public DAOClienteException(String texto) {
        super(texto);
    }

    public DAOClienteException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}


