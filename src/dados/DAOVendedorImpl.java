/*
 * Classe de acesso a dados
 * relacionado a classe Vendedor
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
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Gildo
 */
public class DAOVendedorImpl implements DAOVendedor{
    private final GerenciadorConexao GC;
    
    public DAOVendedorImpl(){
       GC = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Salva os vendedores no BD
     * @param vendedor objeto com o nome do vendedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public void incluir(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "INSERT INTO VENDEDOR (VEND_NOME) VALUES (?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVendedorNome());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
    * Altera no BD um registro o nome do vendedor selecionado
     * @param vendedor Objeto contendo ID e nome a ser alterado
    * @throws DAOException
    * @throws ConexaoException 
    */
    @Override
    public void alterar(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "UPDATE VENDEDOR SET VEND_NOME = ? WHERE VEND_COD = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVendedorNome());
            pstm.setInt(2, vendedor.getVendedorCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Exclui no BD o vendedor selecionado
     * @param vendedor Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public void excluir(Vendedor vendedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "DELETE FROM VENDEDOR WHERE VEND_COD = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, vendedor.getVendedorCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Busca no BD um registro correspondente ao nome passado
     * @param vendedorNome Objeto com o nome a ser pesquisado
     * @return o código do vendedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public Vendedor consultar(String vendedorNome) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "SELECT VEND_NOME, VEND_COD FROM VENDEDOR WHERE VEND_NOME = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedorNome);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setVendedorNome(rs.getString("VEND_NOME") );
                vendedor.setVendedorCodigo(rs.getInt("VEND_COD"));
                return vendedor;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        }   
    }
    
    /**
     * Lista um ou mais vendedores atráves do nome
     * @param vendedorNome nome ou parte do nome a ser pesquisado
     * @return ArrayList contendo um ou mais vendedores
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public ArrayList<Vendedor> listarPorNome(String vendedorNome) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        ArrayList<Vendedor> lista = new ArrayList();
        Vendedor vendedor;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM vendedor WHERE Vend_Nome LIKE ?");
            pstm.setString(1, "%"+ vendedorNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setVendedorCodigo(rs.getInt("Vend_Cod"));
                vendedor.setVendedorNome(rs.getString("Vend_Nome"));
                lista.add(vendedor);
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
     * Lista todos os vendedores cadastrados
     * @return ArrayList com todos os vendedores cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
    @Override
    public ArrayList<Vendedor>listarTodos() throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "SELECT * FROM VENDEDOR";
        ArrayList<Vendedor> lista = new ArrayList();
        Vendedor vendedor;
        try{
            Statement pstm = c.createStatement();
            ResultSet rs = pstm.executeQuery(sql);
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setVendedorCodigo(rs.getInt("Vend_Cod"));
                vendedor.setVendedorNome(rs.getString("Vend_Nome"));
                lista.add(vendedor);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        }
    }
    
}
