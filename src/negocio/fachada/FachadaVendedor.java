/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

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
     * @param vendedor
     * @throws VendedorException 
     * @throws negocio.exception.ConexaoException 
     * @throws negocio.exception.DAOException 
     */
    public void cadastrarVendedor (Vendedor vendedor) throws VendedorException, ConexaoException, DAOException{
        RegraVendedor rn = new RegraVendedor();
        rn.validar(vendedor);
        rn.eUnico(vendedor);
        rn.incluir(vendedor);
    }
    
}
