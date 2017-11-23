
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Gildo
 */
public class DAOVendedorImpl implements DAOVendedor{
    private final GerenciadorConexao gc;
    
    public DAOVendedorImpl(){
       gc = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = gc.conectar();
        String sql = "INSERT INTO VENDEDOR (VEND_NOME) VALUES (?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVendedorNome());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }
    
    @Override
    public void alterar(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = gc.conectar();
        String sql = "UPDATE VENDEDOR SET VEND_NOME=? WHERE VEND_COD=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVendedorNome());
            pstm.setInt(2, vendedor.getVendedorCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }
    
      @Override
    public void excluir(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = gc.conectar();
        String sql = "DELETE FROM VENDEDOR WHERE VEND_COD=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, vendedor.getVendedorCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }

    @Override
    public Vendedor consultar(String vendedorNome) throws DAOException, ConexaoException{
        Vendedor vendedor = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT Vend_Nome, Vend_Cod FROM Vendedor WHERE nome=1";
        try{
        PreparedStatement pstm = ger.conectar().prepareStatement(sql);
        pstm.setString(1, vendedorNome);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          vendedor = new Vendedor();
          vendedor.setVendedorNome(rs.getString("nome") );
          vendedor.setVendedorCodigo(rs.getInt("cod"));
        }
    }catch(SQLException e){
         throw new DAOException();
    }
        return vendedor;  
    }
    
}
