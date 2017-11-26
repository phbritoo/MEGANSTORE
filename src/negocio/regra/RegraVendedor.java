/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOVendedor;
import dados.DAOVendedorImpl;
import java.util.ArrayList;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.VendedorException;

/**
 *
 * @author gildo
 */
public class RegraVendedor {
    private final DAOVendedor DAO;
    
    public RegraVendedor(){
        DAO = new DAOVendedorImpl();
    }
    
    /**
     * Valida o objeto Vendedor
     * @param vendedor Objeto que contém o nome do vendedor
     * @throws VendedorException 
     */
    public void validar (Vendedor vendedor) throws VendedorException {
        if (vendedor==null){
            throw new VendedorException("Objeto inválido!");
        }
        if ((vendedor.getVendedorNome()==null)||(vendedor.getVendedorNome().isEmpty())){
            throw new VendedorException("Nome inválido!");
        }
    }
    
    /**
     * Verifica se o nome já existe no banco de dados
     * @param vendedor Objeto contentdo o nome a ser pesquisado
     * @throws negocio.exception.VendedorException
     */
    public void eUnico (Vendedor vendedor) throws VendedorException{
        try{
            if(DAO.consultar(vendedor.getVendedorNome())!=null)
                throw new VendedorException("Vendedor já cadastrado");
        }catch (ConexaoException ex){
            throw new VendedorException("Erro no BD");
        } catch (DAOException ex){
            throw new VendedorException("Erro de Aplicação(SQL)");
        }
    }

    /**
     * Inclui novo vendedor no BD
     * @param vendedor Objeto com nome a ser incluido
     * @throws VendedorException
     * @throws ConexaoException
     * @throws DAOException
     */
    public void incluir(Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        try{  
            DAO.incluir(vendedor); 
        } catch (ConexaoException ex){
            throw new VendedorException("Erro no BD");
        } catch (DAOException ex){
            throw new VendedorException("Erro no SQL");
        }
    }
    
    /**
     * Lista um ou mais vendedor através de um nome
     * @param vendedorNome nome ou parte do nome a ser listado
     * @return ArrayList com um ou mais vendedores
     * @throws negocio.exception.VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Vendedor> listarPorNome(String vendedorNome) throws VendedorException, ConexaoException, DAOException {
        try {
            return DAO.listarPorNome(vendedorNome);
        }catch(ConexaoException ex){
            throw new VendedorException("Erro no BD");
        }catch (DAOException ex) {
            throw new VendedorException(ex.getMessage());
        }
    }
    
    /**
     * Lista todos os vendedores cadastrados 
     * @return 
     * @throws negocio.exception.VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Vendedor> listarTodos() throws VendedorException, ConexaoException, DAOException {
        try {
            return DAO.listarTodos();
        }catch(ConexaoException ex){
            throw new VendedorException("Erro no BD");
        }catch (DAOException ex) {
            throw new VendedorException("Erro no SQL");
        }
    }
    
    /**
     * Exclui vendedor selecionado
     * @param vendedor Objeto com ID do vendedor a ser excluído
     * @throws negocio.exception.VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void excluir(Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        try{  
           DAO.excluir(vendedor); 
        } catch (ConexaoException ex){
                throw new VendedorException("Erro no BD");
        } catch (DAOException ex){
            throw new VendedorException("Erro no SQL");
        }
    }
    
    /**
     * Altera nome do vendedor selecionado
     * @param vendedor Objeto com ID e nome do vendedor a sere alterado
     * @throws negocio.exception.VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public void alterar(Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        try{  
           DAO.alterar(vendedor); 
        } catch (ConexaoException ex){
            throw new VendedorException("Erro no BD");
        } catch (DAOException ex){
            throw new VendedorException("Erro no SQL");
        }
    }
    
}