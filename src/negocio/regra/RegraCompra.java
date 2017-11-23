/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.basica.Compra;
import negocio.basica.Produto;
import negocio.exception.CompraException;

/**
 *
 * @author paulo
 */
public class RegraCompra {

    /**
     *
     * @param compra
     * @throws negocio.exception.CompraException
     * @throws negocio.exception.CompraException
     * @throws CompraException
     */
    public void validar(Compra compra) throws CompraException{
        if(compra == null){
            throw new CompraException("Objeto Invalido");
        }
        if(compra.getCliente().getCli_cpf() == 0|| compra.getCliente() == null){
               throw new CompraException("Cliente Invalido");
        }
        if(compra.getVendedor()== null){
               throw new CompraException("Vendedor Invalido");
        }
        if(compra.getData()== null){
               throw new CompraException("Data Invalida");
        }
       
        
    }

    public void Incluir(Compra compra) {
        
    }
    
}
