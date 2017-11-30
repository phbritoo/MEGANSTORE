/*
 * Classe de acesso a dados
 * relacionado a classe Produto
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
import negocio.basica.Produto;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoImpl;


/**
 * @author Gabriel Carvalho
 * Revisado por Gildo Neto
 */
public class DAOProdutoImpl implements DAOProduto{
    
    private final GerenciadorConexao GC;
    
    public DAOProdutoImpl(){
       GC = GerenciadorConexaoImpl.getInstancia();
    }
    
      /**
     * Salva os dados de Produto no BD
     * @param produto objeto com nome, estoque e preço do produto
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public void incluir(Produto produto) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO PRODUTO (PRD_NOME, PRD_ESTOQUE, PRD_PRECO) VALUES (?, ?, ?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getProdutoNome());
            pstm.setInt(2, produto.getProdutoEstoque());
            pstm.setDouble(3, produto.getProdutoPreco());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
     * Busca no BD um registro correspondente ao CNPJ passado
     * @param codigo
     * @return 
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public Produto consultar(Integer codigo) throws DAOException, ConexaoException {
        Produto produto = null;
        Connection c = GC.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE PRD_COD = ?";
        try{            
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                produto = new Produto();
                produto.setProdutoCodigo(rs.getInt("PRD_COD"));
                produto.setProdutoNome(rs.getString("PRD_NOME"));
                produto.setProdutoEstoque(rs.getInt("PRD_ESTOQUE"));
                produto.setProdutoPreco(rs.getDouble("PRD_PRECO"));
                return produto;
            }
            return null;
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        }  
    }
    
     /**
     * Busca no BD um registro correspondente ao Nome passado
     * @param nome
     * @return 
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public Produto consultar(String nome) throws DAOException, ConexaoException {
        Produto produto = null;
        Connection c = GC.conectar();
        String sql = "SELECT * FROM PRODUTO WHERE PRD_NOME = ?";
        try{
            PreparedStatement pstm = GC.conectar().prepareStatement(sql);
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
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        } 
        return produto;  
    }
    
    /**
     * Busca no BD um registro correspondente ao Preço passado
     * @param nomeProduto
     * @return 
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public Double consultarPreco(String nomeProduto) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "SELECT PRD_PRECO FROM PRODUTO WHERE PRD_NOME=?";
        Produto produto = new Produto();
        Double precoProduto = null;
        try{
            PreparedStatement pstm = GC.conectar().prepareStatement(sql);
            pstm.setString(1, nomeProduto);
            ResultSet rs = pstm.executeQuery();
           
                
                precoProduto = (rs.getDouble("PRD_PRECO"));
        
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        } 
        return precoProduto;  
    }
     
    /**
     * Exclui no BD o produto selecionado
     * @param produto Objeto contendo ID a ser excluído
     * @throws DAOException
     * @throws ConexaoException 
     */
    @Override
    public void excluir(Produto produto) throws DAOException, ConexaoException {
       Connection c = GC.conectar();
        String sql = "DELETE FROM PRODUTO WHERE PRD_COD = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, produto.getProdutoCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
    /**
    * Altera no BD o registro o selecionado
    * @param produto Objeto contendo ID e dados a serem alterados
    * @throws DAOException
    * @throws ConexaoException 
    */
    @Override
    public void alterar(Produto produto) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "UPDATE PRODUTO SET PRD_NOME = ?, PRD_ESTOQUE = ?, PRD_PRECO = ? WHERE PRD_COD = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getProdutoNome());
            pstm.setInt(2, produto.getProdutoEstoque());
            pstm.setDouble(3, produto.getProdutoPreco());
            pstm.setInt(4, produto.getProdutoCodigo());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        } 
    }
    
     /**
     * Lista um ou mais produtos atráves do nome
     * @param produtoNome nome ou parte do nome a ser pesquisado
     * @return ArrayList contendo um ou mais produtos
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    @Override
    public ArrayList<Produto> listarPoNome(String produtoNome) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        ArrayList<Produto> lista = new ArrayList();
        Produto produto;
        try{
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PRODUTO WHERE PRD_NOME LIKE ?"); 
            pstm.setString(1, "%"+ produtoNome +"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                produto = new Produto();
                produto.setProdutoCodigo(rs.getInt("PRD_COD"));
                produto.setProdutoNome(rs.getString("PRD_NOME"));
                produto.setProdutoEstoque(rs.getInt("PRD_ESTOQUE"));
                produto.setProdutoPreco(rs.getDouble("PRD_PRECO"));
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
            GC.desconectar(c);
        }
    }
    
    /**
     * Lista todos os produtos cadastrados
     * @return ArrayList com todos os produtos cadastrados
     * @throws DAOException
     * @throws ConexaoException
     */
    @Override
    public ArrayList<Produto>listarTodos() throws DAOException, ConexaoException{
        Connection c = GC.conectar();
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
                produto.setProdutoEstoque(rs.getInt("PRD_ESTOQUE"));
                produto.setProdutoPreco(rs.getDouble("PRD_PRECO"));
                lista.add(produto);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GC.desconectar(c);
        }
    }
    
    /**
     * Consulta chave do último registro inserido 
     * @return ultima chave inserida no BD 
     * @throws negocio.exception.DAOException 
     * @throws negocio.exception.ConexaoException 
     */
    @Override
    public Integer obterChave() throws DAOException, ConexaoException {
        Produto produto;
        Connection c = GC.conectar();
        int cont = 0;
        String sql = "SELECT PRD_COD FROM PRODUTO ORDER BY PRD_COD";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                if (cont < rs.getInt("PRD_COD"))
                    cont = rs.getInt("PRD_COD");
                }
            produto = new Produto();
            produto.setProdutoCodigo(cont);
            return produto.getProdutoCodigo();
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        } 
    
    }
    
    /**
     * Inclui associação entre produto e fornecedor
     * @param cnpj do fornecedor do produto
     * @param codProduto do produto do fornecedor 
     * @throws negocio.exception.DAOException 
     * @throws negocio.exception.ConexaoException 
     */
    @Override
    public void incluirFornecedorProduto(String cnpj, Integer codProduto) throws DAOException, ConexaoException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO FORNECEDOR_PRODUTO (FORN_CNPJ, PRD_COD) VALUES (?, ?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cnpj);
            pstm.setInt(2, codProduto);
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e.getMessage());
        }finally{
            GC.desconectar(c);
        } 
    }
       
}
