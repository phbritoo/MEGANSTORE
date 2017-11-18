
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.exception.ConexaoException;

/**
 *
 * @author Gildo
 */
public class GerenciadorConexaoImpl implements GerenciadorConexao {

    private static GerenciadorConexaoImpl instancia;
    private final String url;
    private final String usuario;
    private final String senha;
    
    private GerenciadorConexaoImpl(){
    ResourceBundle rb = ResourceBundle.getBundle("MeganStore.util.banco");
    url = rb.getString("url");
    usuario = rb.getString("usuario");
    senha = rb.getString("senha");
    }
    
    public static GerenciadorConexaoImpl getInstancia(){
        if(instancia==null){
            instancia = new GerenciadorConexaoImpl();
        }
        return instancia;
    }
    @Override
    public Connection abrirConexao() throws ConexaoException {
        //JDBC
        //DriverManager - Connection - Statement - ResultSet
        Connection c;
        try{
        c = DriverManager.getConnection(url, usuario, senha);
            return c;
        }catch(SQLException e){
            throw new ConexaoException();
        } 
    }

    @Override
    public void fecharConexao(Connection c) throws ConexaoException{
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }
    
}
