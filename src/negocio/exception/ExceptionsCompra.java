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
public class ExceptionsCompra extends Exception{

    public ExceptionsCompra() {
        
    }

    public ExceptionsCompra(String texto) {
        super(texto);
    }
    
}
