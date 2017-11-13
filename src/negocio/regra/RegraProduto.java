/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.basica.Produto;
import negocio.exception.ExceptionsProduto;

/**
 *
 * @author Gabriel
 */
public class RegraProduto{
    
    public void validar(Produto produto) throws ExceptionsProduto{
        
        if (produto == null){
            throw new ExceptionsProduto("objeto produto não criado");
        }
        
    }
}
