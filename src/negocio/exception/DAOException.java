
package negocio.exception;

/**
 *
 * @author Gildo
 */
public class DAOException extends Exception{

    public DAOException(String texto) {
        super(texto);
    }
    
    public DAOException(){
    }
}
