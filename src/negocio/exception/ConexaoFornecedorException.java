
package negocio.exception;

/**
 *
 * @author Djalma
 */
public class ConexaoFornecedorException extends Exception{

    public ConexaoFornecedorException(String texto) {
        super(texto);
    }
    
    public ConexaoFornecedorException(){
    }
}
