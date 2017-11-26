/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 *
 * @author Gildo
 */
public interface DAOVendedor {
    
    /**
     * Salva os dados no BD
     * @param vendedor objeto com o nome do vendedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void inserir(Vendedor vendedor) throws DAOException, ConexaoException;
    
    /**
     * Busca no BD um registro correspondente ao nome passado
     * @param vendedorNome
     * @return o código do vendedor
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public Vendedor consultar(String vendedorNome) throws DAOException, ConexaoException;
    
    /**
    * Altera no BD um registro o nome do vendedor selecionado
     * @param vendedor
    * @throws DAOException
    * @throws ConexaoException 
    */
    public void alterar(Vendedor vendedor) throws DAOException, ConexaoException;
    
    /**
     * Exclui no BD o vendedor selecionado
     * @param vendedor
     * @throws DAOException
     * @throws ConexaoException 
     */
    public void excluir(Vendedor vendedor) throws DAOException, ConexaoException;
    
    /**
     * Lista um ou mais vendedores atráves do nome
     * @param vendedorNome
     * @return 
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public ArrayList<Vendedor>listar(String vendedorNome) throws DAOException, ConexaoException;          
    
    /**
     * Lista todos os vendedores cadastrados
     * @return
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Vendedor>listarTodos() throws DAOException, ConexaoException;      
    
}
