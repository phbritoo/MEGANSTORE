
package negocio.exception;

/**
 *
 * @author Gildo
 */
public class ConexaoException extends Exception{

    public ConexaoException(String texto) {
        super(texto);
    }
    
    public ConexaoException(){
    }
}
