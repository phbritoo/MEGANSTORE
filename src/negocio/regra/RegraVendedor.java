/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import dados.DAOVendedor;
import dados.DAOVendedorImpl;
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
     * @param vendedor Objeto que retorna apenas o nome do vendedor
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
                throw new VendedorException("Erro na consulta de eUnico");
        }catch(ConexaoException | DAOException e){
                throw new VendedorException("Erro na conexao ou dao da consulta de eUnico");
        }
           }

    public void inserir(Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
            try{  
               DAO.inserir(vendedor); 
           } catch (ConexaoException ex){
                throw new VendedorException("Erro no BD");
           } catch (DAOException ex){
                throw new VendedorException("Erro no SQL");
           }
           
    }
       
       
    
    /**
     * Salva os dados no Banco de Dados
     * @param vendedor Objeto com nome a ser salvo no BD
     */
    public void incluir(Vendedor vendedor) {
        
    }
    
}