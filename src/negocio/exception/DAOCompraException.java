/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exception;

/**
 *
 * @author paulo
 */
public class DAOCompraException extends Exception{
    
    public DAOCompraException(String texto) {
        super(texto);
    }
    
    public DAOCompraException(){
    }
    
}
