
package negocio.exception;

import java.sql.SQLException;

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

    public DAOException(SQLException e) {
        
    }
}
