/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    private final GerenciadorConexao gc;
    
    public DAOProdutoImpl(){
       gc = GerenciadorConexaoImpl.getInstancia();
    }
    
     @Override
    public void incluir(Produto produto) throws DAOException, ConexaoException {
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
        Connection c = gc.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE PRD_COD=?";
        try{
        PreparedStatement pstm = gc.conectar().prepareStatement(sql);
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
    public Produto consultar(String nome) throws DAOException, ConexaoException {
        Produto produto = null;
        Connection c = gc.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE PRD_NOME=?";
        try{
        PreparedStatement pstm = gc.conectar().prepareStatement(sql);
        pstm.setString(1, nome);
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
    public Double consultarPreco(String nomeProduto) throws DAOException, ConexaoException {
         Connection c = gc.conectar();
        String sql = "SELECT PRD_PRECO FROM PRODUTO WHERE PRD_NOME=?";
        Produto produto = new Produto();
        Double precoProduto = null;
        try{
            PreparedStatement pstm = gc.conectar().prepareStatement(sql);
            pstm.setString(1, nomeProduto);
            ResultSet rs = pstm.executeQuery();
           
                
                precoProduto = (rs.getDouble("PRD_PRECO"));
        
    }catch(SQLException e){
         throw new DAOException();
    }    catch (ConexaoException ex) {   
             Logger.getLogger(DAOProdutoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }   
        return precoProduto;  
    }
     

    @Override
    public void deletar(Produto produto) throws DAOException, ConexaoException {
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
    
    @Override
    public ArrayList<Produto> listarPorNome(String produtoNome) throws DAOException, ConexaoException {
        Connection c = gc.conectar();
        ArrayList<Produto> lista = new ArrayList();
        Produto produto;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PRODUTO WHERE PRD_NOME LIKE ?");
            pstm.setString(1, "%"+ produtoNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                produto = new Produto();
                produto.setProdutoNome(rs.getString("PRD_NOME"));
                lista.add(produto);
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
    public ArrayList<Produto>listarTodos() throws DAOException, ConexaoException{
        Connection c = gc.conectar();
        String sql = "SELECT * FROM PRODUTO";
        ArrayList<Produto> lista = new ArrayList();
        Produto produto;
        try{
            Statement pstm = c.createStatement();
            ResultSet rs = pstm.executeQuery(sql);
            while(rs.next()){
                produto = new Produto();
                produto.setProdutoCodigo(rs.getInt("PRD_COD"));
                produto.setProdutoNome(rs.getString("PRD_NOME"));               
                produto.setProdutoPreco(rs.getInt("PRD_ESTOQUE"));
                produto.setProdutoPreco(rs.getDouble("PRD_PRECO"));
                lista.add(produto);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        }
    }
       
}
