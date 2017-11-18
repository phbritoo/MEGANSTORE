/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import negocio.basica.Fornecedor;
import negocio.exception.ExceptionsFornecedor;
import negocio.regra.RegraFornecedor;

/**
 *
 * @author aluno
 */
public class FachadaFornecedor {
    
    public void cadastrarFornecedor (Fornecedor fornecedor) throws ExceptionsFornecedor{
        RegraFornecedor rn = new RegraFornecedor();
        rn.validar(fornecedor);
        rn.eUnico(fornecedor);
        rn.incluir(fornecedor);
    }
    
}
