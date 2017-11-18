/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import negocio.basica.Fornecedor;
import negocio.exception.ConexaoFornecedorException;
import negocio.exception.DAOFornecedorException;

/**
 *
 * @author Djalma
 */
public interface DAOFornecedor {
    
    /**
     * Salva os dados no BD
     * @param fornecedor objeto com o nome do vendedor
     * @throws negocio.exception.DAOFornecedorException
     * @throws negocio.exception.ConexaoFornecedorException
     */
    public void inserir(Fornecedor fornecedor) throws DAOFornecedorException, ConexaoFornecedorException;
    
    /**
     * Busca no BD um registro correspondente ao nome passado
     * @param cnpj
     * @return nome do vendedor
     */
    public Fornecedor consultar(String cnpj) throws DAOFornecedorException, ConexaoFornecedorException;
    
}
