/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;

import negocio.basica.Produto;
import negocio.exception.ExceptionsProduto;
import negocio.regra.RegraProduto;

/**
 *
 * @author Gabriel
 */
public class FachadaProduto {
    
    public void cadastrarProduto(Produto produto)throws ExceptionsProduto{
        RegraProduto rn = new RegraProduto();
        rn.validar(produto);
        rn.eUnico(produto);
        rn.incluir(produto);
    }           
}
