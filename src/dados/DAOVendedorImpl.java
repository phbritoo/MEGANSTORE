
package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoVendedorException;
import negocio.exception.DAOVendedorException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Gildo
 */
public class DAOVendedorImpl implements DAOVendedor{

    @Override
    public void inserir(Vendedor vendedor) throws DAOVendedorException, ConexaoVendedorException{
        
    }

    @Override
    public Vendedor consultar(String nome) throws DAOVendedorException, ConexaoVendedorException{
        Vendedor vendedor = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT Vend_Nome, Vend_Cod FROM Vendedor WHERE nome=1";
        try{
        PreparedStatement pstm = ger.abrirConexao().prepareStatement(sql);
        pstm.setString(1, nome);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          vendedor = new Vendedor();
          vendedor.setVend_nome(rs.getString("nome") );
          vendedor.setVend_cod(rs.getInt("cod"));
        }
    }catch(SQLException e){
         throw new DAOVendedorException();
    }
        return vendedor;  
    }
    
}
