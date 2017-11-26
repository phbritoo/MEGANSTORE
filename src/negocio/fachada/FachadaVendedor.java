/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import java.util.ArrayList;
import negocio.basica.Vendedor;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.VendedorException;
import negocio.regra.RegraVendedor;

/**
 *
 * @author aluno
 */
public class FachadaVendedor {
    
    /**
     * Faz as validações e grava um novo vendedor no BD
     * @param vendedor a ser cadastrado
     * @throws VendedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void cadastrar (Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor() ;
        rn.validar(vendedor);
        rn.eUnico(vendedor);
        rn.incluir(vendedor);
    }
    
    /**
     * Altera o nome do vendedor no BD
     * @param vendedor a ser alterado
     * @throws VendedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void alterar (Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor() ;
        rn.alterar(vendedor);
    }
    
    /**
     * Exclui vendedor do BD
     * @param vendedor a ser excluído
     * @throws VendedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void excluir (Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor() ;
        rn.excluir(vendedor);
    }
    
    /**
     * Pesquisa um ou mais vendedor através do nome
     * @param vendedorNome primeiro nome ou parte do nome a ser pesquisado
     * @return lista de vendedor de acordo com a entrada
     * @throws VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Vendedor> listarPoNome (String vendedorNome) throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor();
        return rn.listarPorNome(vendedorNome);
    }
    
    /**
     * Pesquisa um ou mais vendedor através do nome
     * @return lista com todos os vendedores cadastrados
     * @throws VendedorException
     * @throws negocio.exception.ConexaoException
     * @throws negocio.exception.DAOException
     */
    public ArrayList<Vendedor> listarTodos () throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor();
        return rn.listarTodos();
    }
}
