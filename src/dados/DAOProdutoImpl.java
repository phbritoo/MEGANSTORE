/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import static java.lang.System.gc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;


/**
 *
 * @author Gabriel
 */
public class DAOProdutoImpl implements DAOProduto{
    
     @Override
    public void incluir(Produto produto) throws DAOException, ConexaoException {
        GerenciadorConexao gc = GerenciadorConexaoImpl.getInstancia();
        Connection c = gc.conectar();
        String sql = "INSERT INTO PRODUTO (PRD_COD, PRD_NOME, PRD_ESTOQUE, PRD_PRECO) VALUES (?,?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, produto.getProdutoCodigo());
            pstm.setString(2, produto.getProdutoNome());
            pstm.setInt(3, produto.getProdutoEstoque());
            pstm.setDouble(4, produto.getProdutoPreco());
            
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }

    @Override
    public Produto consultar(Integer codigo) throws DAOException, ConexaoException {
        Produto produto = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT PRD_COD FROM Codigo WHERE PRD_COD=?, PRD_NOME FROM Nome, PRD_ESTOQUE FROM Estoque, PRD_PRECO FROM Preco";
        try{
        PreparedStatement pstm = ger.conectar().prepareStatement(sql);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          produto = new Produto();
          produto.setProdutoCodigo(rs.getInt("PRD_COD"));
          produto.setProdutoNome(rs.getString("PRD_NOME"));
          produto.setProdutoEstoque(rs.getInt("PRD_ESTOQUE"));
          produto.setProdutoPreco(rs.getDouble("PRD_PRECO"));
        }
    }catch(SQLException e){
         throw new DAOException();
    }    catch (ConexaoException ex) {   
             Logger.getLogger(DAOProdutoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }   
        return produto;  
    }

    @Override
    public void deletar(Produto produto) throws DAOException, ConexaoException {
       GerenciadorConexao gc = GerenciadorConexaoImpl.getInstancia();
       Connection c = gc.conectar();
        String sql = "DELETE FROM PRODUTO WHERE PRD_COD=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
             pstm.setInt(1, produto.getProdutoCodigo());
            pstm.setString(2, produto.getProdutoNome());
            pstm.setInt(3, produto.getProdutoEstoque());
            pstm.setDouble(4, produto.getProdutoPreco());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }

    @Override
    public void alterar(Produto produto) throws DAOException, ConexaoException {
      GerenciadorConexao gc = GerenciadorConexaoImpl.getInstancia();
      Connection c = gc.conectar();
        String sql = "UPDATE PRODUTO SET PRD_COD=? WHERE PRD_COD=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, produto.getProdutoCodigo());
            pstm.setString(2, produto.getProdutoNome());
            pstm.setInt(3, produto.getProdutoEstoque());
            pstm.setDouble(4, produto.getProdutoPreco());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }
       
}
