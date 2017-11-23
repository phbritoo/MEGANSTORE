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

    @Override
    public void inserir(Cliente cliente) throws DAOException, ConexaoException {
        
    }

    @Override
    public Cliente consultar(String nome) throws DAOException, ConexaoException {
         Cliente cliente = null;
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        String sql = "SELECT Cli_nome, Cli_cpf FROM Cliente, Cli_tel WHERE nome=1";
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
       
    }

    @Override
    public void alterar(Cliente cliente) throws DAOException, ConexaoException {
      
    }
    }
    
    
    
