/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exception;

/**
 *
 * @author Djalma
 */
public class ExceptionsFornecedor extends Exception {
    public ExceptionsFornecedor(){
        
    }
    public ExceptionsFornecedor(String texto){
        super(texto);
    }
}
