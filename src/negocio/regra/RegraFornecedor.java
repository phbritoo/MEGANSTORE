/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.exceptions.ExceptionsFornecedor;
import negocio.basica.Fornecedor;

/**
 *
 * @author paulo
 */
public class RegraFornecedor{
    public void validar(Fornecedor fornecedor)throws ExceptionsFornecedor{
        if(fornecedor==null){
            throw new ExceptionsFornecedor();
        }
    }
   
            
}
