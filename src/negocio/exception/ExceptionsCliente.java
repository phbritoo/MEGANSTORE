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
public class ExceptionsCliente  extends Exception{
   

    public ExceptionsCliente(String texto) {
        super(texto);
    }
    
    public ExceptionsCliente(){
    }
}

    