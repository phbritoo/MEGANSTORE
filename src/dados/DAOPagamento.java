/*
 * Interface de acesso a dados
 * relacionado a classe Pagamento
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */
package dados;

import negocio.basica.Pagamento;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;

/**
 * @author Heloísa Galvão
 * Revisado por Gildo Neto
 */
public interface DAOPagamento {
    
    /**
     * Salva os dados no BD
     * @param pagamento Objeto com os dados
     * @throws negocio.exception.DAOException
     * @throws negocio.exception.ConexaoException
     */
    public void inserir (Pagamento pagamento) throws DAOException, ConexaoException;
}
