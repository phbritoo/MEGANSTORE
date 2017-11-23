
package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Djalma
 */
public class DAOFornecedorImpl implements DAOFornecedor{

    @Override
    public void inserir(Fornecedor fornecedor) throws DAOException, ConexaoException{
        
    }

    @Override
    public Fornecedor consultar(String cnpj) throws DAOException, ConexaoException{
        Fornecedor fornecedor = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT forn_cnpj, forn_nome, forn_tel FROM Fornecedor WHERE cnpj=?";
    try{
        PreparedStatement pstm = ger.abrirConexao().prepareStatement(sql);
        pstm.setString(1, cnpj);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          fornecedor = new Fornecedor();
          fornecedor.setFornecedorCnpj(rs.getString("cnpj") );
          fornecedor.setFornecedorNome(rs.getString("nome"));
          
        }
    }catch(SQLException e){
         throw new DAOException();
    }
        return fornecedor;  
    }
    
}
