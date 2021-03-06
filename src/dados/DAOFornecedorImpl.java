/*
 * Classe de acesso a dados
 * relacionado a classe Fornecedor
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
import negocio.basica.Fornecedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;

/**
 *
 * @author Djalma
 */
public class DAOFornecedorImpl implements DAOFornecedor{
    private final GerenciadorConexao GC;
    
    public DAOFornecedorImpl(){
       GC = GerenciadorConexaoImpl.getInstancia();
    }
    
    /**
     * Salva os dados no BD
     * @param fornecedor objeto com CNPJ, nome e telefone do fornecedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public void incluir(Fornecedor fornecedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "INSERT INTO FORNECEDOR (FORN_CNPJ, FORN_NOME, FORN_TEL) VALUES (?, ?, ?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFornecedorCnpj());
            pstm.setString(2, fornecedor.getFornecedorNome());
            pstm.setString(3, fornecedor.getFornecedorTel());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
    * Altera no BD um registro o nome do fornecedor selecionado
     * @param fornecedor Objeto contendo ID e dados a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    @Override
    public void alterar(Fornecedor fornecedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "UPDATE FORNECEDOR SET FORN_NOME = ?, FORN_TEL = ? WHERE FORN_CNPJ = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFornecedorNome());
            pstm.setString(2, fornecedor.getFornecedorTel());
            pstm.setString(3, fornecedor.getFornecedorCnpj());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Exclui no BD o fornecedor selecionado
     * @param fornecedor Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public void excluir(Fornecedor fornecedor) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "DELETE FROM FORNECEDOR WHERE FORN_CNPJ = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFornecedorCnpj());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Busca no BD um registro correspondente ao CNPJ passado
     * @param fornecedorNome Objeto com CNPJ a ser pesquisado
     * @return o código do fornecedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public Fornecedor consultar(String cnpj) throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "SELECT FORN_CNPJ, FORN_NOME, FORN_TEL FROM FORNECEDOR WHERE FORN_CNPJ = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cnpj);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setFornecedorCnpj(rs.getString("FORN_CNPJ") );
                fornecedor.setFornecedorNome(rs.getString("FORN_NOME"));
                return fornecedor;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        }
    
    }
    
    /**
     * Lista um ou mais fornecedores atráves do nome
     * @param fornecedorNome nome ou parte do nome a ser pesquisado
     * @return ArrayList contendo um ou mais fornedores
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public ArrayList<Fornecedor> listarPorNome(String fornecedorNome) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        ArrayList<Fornecedor> lista = new ArrayList();
        Fornecedor fornecedor;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM FORNECEDOR WHERE FORN_NOME LIKE ?");
            pstm.setString(1, "%"+ fornecedorNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                fornecedor = new Fornecedor();
                fornecedor.setFornecedorCnpj(rs.getString("FORN_CNPJ"));
                fornecedor.setFornecedorNome(rs.getString("FORN_NOME"));
                lista.add(fornecedor);
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
     * Lista todos os fornecedores cadastrados
     * @return ArrayList com todos os fornedores cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */    
    @Override
    public ArrayList<Fornecedor>listarTodos() throws DAOException, ConexaoException{
        Connection c = GC.conectar();
        String sql = "SELECT * FROM FORNECEDOR";
        ArrayList<Fornecedor> lista = new ArrayList();
        Fornecedor fornecedor;
        try{
            Statement pstm = c.createStatement();
            ResultSet rs = pstm.executeQuery(sql);
            while(rs.next()){
                fornecedor = new Fornecedor();
                fornecedor.setFornecedorCnpj(rs.getString("FORN_CNPJ"));
                fornecedor.setFornecedorNome(rs.getString("FORN_NOME"));
                fornecedor.setFornecedorTel (rs.getString("FORN_TEL"));
                lista.add(fornecedor);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        }
    }
    
}
