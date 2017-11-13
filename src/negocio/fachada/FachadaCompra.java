package negocio.fachada;

import negocio.basica.Compra;
import negocio.exception.ExceptionsCompra;
import negocio.regra.RegraCompra;

/**
 *
 * @author aluno
 */
public class FachadaCompra {

    public void cadastrar(Compra compra) throws ExceptionsCompra{
        RegraCompra rn = new RegraCompra();
        rn.validar(compra);
        rn.Incluir(compra);
        
        
    }
}
