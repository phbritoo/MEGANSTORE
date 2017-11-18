
package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoFornecedorException;
import negocio.exception.DAOFornecedorException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Djalma
 */
public class DAOFornecedorImpl implements DAOFornecedor{

    @Override
    public void inserir(Fornecedor fornecedor) throws DAOFornecedorException, ConexaoFornecedorException{
        
    }

    @Override
    public Fornecedor consultar(String cnpj) throws DAOFornecedorException, ConexaoFornecedorException{
        Fornecedor fornecedor = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT forn_cnpj, forn_nome, forn_tel FROM Fornecedor WHERE cnpj=?";
    try{
        PreparedStatement pstm = ger.abrirConexao().prepareStatement(sql);
        pstm.setString(1, cnpj);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          fornecedor = new Fornecedor();
          fornecedor.setForn_cnpj(rs.getString("cnpj") );
          fornecedor.setForn_nome(rs.getString("nome"));
          
        }
    }catch(SQLException e){
         throw new DAOFornecedorException();
    }
        return fornecedor;  
    }
    
}
