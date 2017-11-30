/*
 * Classe para retornar exceções
 * referente a classe Cliente
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package negocio.exception;

/**
 *
 * @author Gildo Neto
 */
public class ClienteException  extends Exception{
   

    public ClienteException(String texto) {
        super(texto);
    }
    
    public ClienteException(){
    }
}

    
