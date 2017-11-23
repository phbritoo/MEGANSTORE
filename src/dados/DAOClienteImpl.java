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
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.basica.Cliente;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author William
 */
public class DAOClienteImpl implements DAOCliente {
    
    private final GerenciadorConexao gc;
    
    public DAOClienteImpl(){
       gc = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override

    public void inserir(Cliente cliente) throws DAOException, ConexaoException {
            Connection c = gc.conectar();
            String sql = "INSERT INTO CLIENTE (CLI_NOME) VALUES (?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getClienteNome());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    }
    

    @Override
    public Cliente consultar(String nome) throws DAOException, ConexaoException {
         Cliente cliente = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT CLI_NOME, CLI_CPF FROM Cliente, CLI_TEL WHERE nome=1";
        try{
        PreparedStatement pstm = ger.conectar().prepareStatement(sql);
        pstm.setString(1, nome);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
          cliente = new Cliente();
          cliente.setClienteNome(rs.getString("nome") );
          cliente.setClienteCpf(rs.getInt("cpf"));
          cliente.setClienteTel(rs.getString("tel"));
        }
    }catch(SQLException e){
         throw new DAOException();
    }   catch (ConexaoException ex) {
            Logger.getLogger(DAOClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;  
    }

    @Override
    public void deletar(Cliente cliente) throws DAOException, ConexaoException {
        Connection c = gc.conectar();
        String sql = "DELETE FROM CLIENTE WHERE CLI_CPF=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, cliente.getClienteCpf());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        } 
    
    }

    @Override
    public void alterar(Cliente cliente) throws DAOException, ConexaoException {
          Connection c = gc.conectar();
        String sql = "UPDATE VENDEDOR SET CLI_NOME=? WHERE CLI_CPF=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getClienteNome());
            pstm.setInt(2, cliente.getClienteCpf());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gc.desconectar(c);
        }
    }
    }
    
    
    
