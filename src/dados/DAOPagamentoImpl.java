/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.basica.Pagamento;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author heloi
 */
public class DAOPagamentoImpl implements DAOPagamento{
    
    @Override
    public void inserir (Pagamento pagamento)throws ConexaoException, DAOException{
        GerenciadorConexao gc = GerenciadorConexaoImpl.getInstancia();
        Connection con = gc.conectar();
        String sql = "INSERT INTO PAGAMENTO (CARD_PARCELAS, CARD_VALOR, CARD_NUM, CARD_VALIDADE, CARD_TITULAR) "
                + "                VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, pagamento.getCardParcelas());
            pstm.setDouble(2, pagamento.getCardValor());
            pstm.setString(3, pagamento.getCardNum());
            pstm.setString(4, pagamento.getCardValidade());
            pstm.setString(5, pagamento.getCardTitular());
            pstm.executeUpdate();
        }catch (SQLException errosql){
            throw new DAOException (errosql.getMessage());
        }finally {
            gc.desconectar(con);
        }
    }
    
}
