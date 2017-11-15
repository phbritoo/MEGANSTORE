
package negocio.exception;

/**
 *
 * @author Gildo
 */
public class ConexaoVendedorException extends Exception{

    public ConexaoVendedorException(String texto) {
        super(texto);
    }
    
    public ConexaoVendedorException(){
    }
}
