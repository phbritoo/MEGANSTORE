
package util;

import java.sql.Connection;

/**
 *
 * @author Gildo
 */
public class GerenciadorConexaoImpl implements GerenciadorConexao {

    @Override
    public Connection abrirConexao() {
        return null;
        //JDBC
        //DriverManager - Connection - Statement - ResultSet
    }

    @Override
    public void fecharConexao(Connection c) {
        
    }
    
}
