/*
 * Classe de acesso a dados
 * relacionado a classe Compra
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.basica.Compra;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Gildo Neto
 */
public class DAOCompraImpl implements DAOCompra {
  
    private final GerenciadorConexao GC;
    
     public DAOCompraImpl(){
       GC = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void incluir(Compra compra) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO COMPRA (NF_COD, NF_TOTAL, NF_DATA, VEND_COD, CLI_CPF) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, compra.getNfCodigo());
            pstm.setDouble(2, compra.getNfTotal());
            pstm.setDate(3, (Date) compra.getNfData());
            pstm.setInt(4, compra.getVendedor().getVendedorCodigo());
            pstm.setString(5, compra.getCliente().getClienteCpf());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    @Override
    public Compra consultar(Integer nfCodigo) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "SELECT NF_COD, NF_TOTAL, NF_DATA, VEND_COD, CLI_CPF FROM COMPRA WHERE NF_COD = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, nfCodigo);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Compra compra = new Compra();
                compra.setNfCodigo(rs.getInt("NF_COD"));
                compra.setNfTotal(rs.getDouble("NF_TOTAL"));
                compra.setNfData(rs.getDate("NF_DATA"));
                //incompleto
               /* compra.setVendedor().setVendedorCodigo(rs.getInt("VEND_COD"));
                compra.setCliente().setClienteCpf(rs.getString("CLI_CPF"));*/
                return compra;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        }
    }
    
}
