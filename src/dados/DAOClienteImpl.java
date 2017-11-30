/*
 * Classe de acesso a dados
 * relacionado a classe Cliente
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.basica.Cliente;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author William Santos
 */
public class DAOClienteImpl implements DAOCliente {
    
    private final GerenciadorConexao GC;
    
    public DAOClienteImpl(){
       GC = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Salva os dados no BD
     * @param cliente objeto com CPF, nome e telefone do cliente
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public void incluir(Cliente cliente) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO CLIENTE (CLI_CPF, CLI_TEL, CLI_NOME) VALUES (?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getClienteCpf());
            pstm.setString(2, cliente.getClienteTel());
            pstm.setString(3, cliente.getClienteNome());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Busca no BD um cliente correspondente ao CPF passado
     * @param cpf Objeto com CPF a ser pesquisado
     * @return o código do cliente
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public Cliente consultar(String cpf) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "SELECT CLI_CPF, CLI_NOME, CLI_TEL FROM CLIENTE WHERE CLI_CPF = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setClienteNome(rs.getString("CLI_NOME"));
                cliente.setClienteCpf(rs.getString("CLI_CPF"));
                cliente.setClienteTel(rs.getString("CLI_TEL"));
                return cliente;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        }
    }
    
    /**
     * Exclui no BD o cliente selecionado
     * @param cliente Objeto contendo CPF a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public void excluir(Cliente cliente) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "DELETE FROM CLIENTE WHERE CLI_CPF = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getClienteCpf());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    
    }

    /**
    * Altera no BD um registro do cliente selecionado
    * @param cliente Objeto contendo nome e telefone a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    @Override
    public void alterar(Cliente cliente) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_TEL = ? WHERE CLI_CPF = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getClienteNome());
            pstm.setString(2, cliente.getClienteTel());
            pstm.setString(3, cliente.getClienteCpf());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
            }
    }
    
    /**
     * Lista um ou mais clientes atráves do nome
     * @param clienteNome
     * @return ArrayList contendo um ou mais clientes
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public ArrayList<Cliente> listarPorNome(String clienteNome) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cliente;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM CLIENTE WHERE CLI_NOME LIKE ?");
            pstm.setString(1, "%"+ clienteNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                cliente = new Cliente();
                cliente.setClienteCpf(rs.getString("CLI_CPF"));
                cliente.setClienteNome(rs.getString("CLI_NOME"));
                cliente.setClienteTel(rs.getString("CLI_TEL"));
                lista.add(cliente);
            }
            if (lista.isEmpty()){
                throw new DAOException("Não existem dados para a pesquisa");
            }else {
                return lista;
            }
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        }
    }
    
    /**
     * Lista todos os clientes cadastrados
     * @return ArrayList com todos os fornedores cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
     @Override
    public ArrayList<Cliente>listarTodos() throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "SELECT * FROM CLIENTE";
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cliente;
        try{
            Statement pstm = c.createStatement();
            ResultSet rs = pstm.executeQuery(sql);
            while(rs.next()){
                cliente = new Cliente();
                cliente.setClienteNome(rs.getString("CLI_NOME"));
                cliente.setClienteCpf(rs.getString("CLI_CPF"));
                cliente.setClienteTel(rs.getString("CLI_TEL"));
                lista.add(cliente);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        }
    }
}
    
    
    
