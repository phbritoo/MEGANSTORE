/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

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
 * @author hp
 */
public class DAOProdutoImpl implements DAOProduto{
    
     @Override
    public void inserir(Produto produto) throws DAOException, ConexaoException {
        
    }

    @Override
    public Produto consultar(Integer codigo) throws DAOException, ConexaoException {
        Produto produto = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT Cli_nome, Cli_cpf FROM Cliente, Cli_tel WHERE nome=1";
        try{
        PreparedStatement pstm = ger.abrirConexao().prepareStatement(sql);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          produto = new Produto();
          produto.setPrd_cod(rs.getInt("codigo"));
          produto.setPrd_nome(rs.getString("nome"));
          produto.setPrd_estoque(rs.getInt("estoque"));
          produto.setPrd_preco(rs.getDouble("preco"));
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
       
    }

    @Override
    public void alterar(Produto produto) throws DAOException, ConexaoException {
      
    }
       
}
