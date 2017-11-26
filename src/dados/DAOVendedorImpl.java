
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.VendedorException;
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
        Connection c = gc.conectar();
        String sql = "SELECT Vend_Nome, Vend_Cod FROM Vendedor WHERE Vend_Nome=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedorNome);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setVendedorNome(rs.getString("Vend_Nome") );
                vendedor.setVendedorCodigo(rs.getInt("Vend_Cod"));
                return vendedor;
        }
        return null;
    }catch(SQLException e){
         throw new DAOException(e.getMessage());
    }finally{
          gc.desconectar(c);
        }
          
    }
    
    @Override
    public ArrayList<Vendedor> listar(String vendedorNome) throws DAOException, ConexaoException {
        Connection c = gc.conectar();
        //String sql = "SELECT * FROM vendedor WHERE Vend_Nome LIKE ?";
        ArrayList<Vendedor> lista = new ArrayList();
        Vendedor vendedor;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM vendedor WHERE Vend_Nome LIKE ?");
            pstm.setString(1, "%"+ vendedorNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setVendedorCodigo(rs.getInt("Vend_Cod"));
                vendedor.setVendedorNome(rs.getString("Vend_Nome"));
                lista.add(vendedor);
            }
            if (lista.isEmpty()){
                throw new DAOException("Não existem dados para a pesquisa");
            }else {
                return lista;
            }
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        }
    }
    
    @Override
    public ArrayList<Vendedor>listarTodos() throws DAOException, ConexaoException{
        Connection c = gc.conectar();
        String sql = "SELECT Vend_Cod, Vend_Nome FROM vendedor";
        ArrayList<Vendedor> lista = new ArrayList();
        Vendedor vendedor;
        try{
            Statement pstm = c.createStatement();
            ResultSet rs = pstm.executeQuery(sql);
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setVendedorCodigo(rs.getInt("Vend_Cod"));
                vendedor.setVendedorNome(rs.getString("Vend_Nome"));
                lista.add(vendedor);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        }
    }
    
}
