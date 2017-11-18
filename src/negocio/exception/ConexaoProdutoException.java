/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.exception;

/**
 *
 * @author Gabriel
 */
public class ConexaoProdutoException extends Exception{
    
    public ConexaoProdutoException(String texto) {
        super(texto);
    }
    
    public ConexaoProdutoException(){
    }
    
}
