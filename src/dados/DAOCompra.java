/*
 * Interface de acesso a dados
 * relacionado a classe Compra
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package dados;

import negocio.basica.Compra;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 * @author Paulo Brito
 * revisado por Gildo Neto
 */
public interface DAOCompra {
    
     
    /**
     * Salva os dados relacionados a compra no BD
     * @param compra Objeto com os dados
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void incluir (Compra compra) throws DAOException, ConexaoException;
    
    /**
     * Consulta os dados a partir do código da compra
     * @param nfCodigo
     * @return
     * @throws DAOException
     * @throws ConexaoException 
     */
    public Compra consultar(Integer nfCodigo) throws DAOException, ConexaoException;
}
