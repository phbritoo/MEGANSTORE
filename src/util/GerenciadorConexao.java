/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import negocio.exception.ConexaoVendedorException;

/**
 *
 * @author Gildo
 */
public interface GerenciadorConexao {
    /**
     * Abre uma conexao com o BD
     * @return Objeto de conexão
     * @exception ConexaoVendedorException
     */
    public Connection abrirConexao()throws ConexaoVendedorException;
    /**
     * Fecha a conexao com o BD
     * @param c Objeto contendo a conexao aberta
     * @exception ConexaoVendedorException
     */
    public void fecharConexao(Connection c) throws ConexaoVendedorException;
}
