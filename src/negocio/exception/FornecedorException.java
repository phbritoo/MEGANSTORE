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
public class FornecedorException extends Exception {    
    
    public FornecedorException(String texto){
        super(texto);
    }
    public FornecedorException(){
        
    }
}
