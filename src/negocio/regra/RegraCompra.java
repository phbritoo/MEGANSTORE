/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.regra;

import negocio.basica.Compra;
import negocio.exceptions.ExceptionsCompra;

/**
 *
 * @author paulo
 */
public class RegraCompra {

    /**
     *
     * @param compra
     * @throws negocio.exceptions.ExceptionsCompra
     * @throws negocio.exceptions.ExceptionsCompra
     * @throws ExceptionsCompra
     */
    public void validar(Compra compra) throws ExceptionsCompra{
        if(compra == null){
            throw new ExceptionsCompra("Objeto Invalido");
        }
        if(compra.getCliente() == null){
               throw new ExceptionsCompra("Cliente Invalido");
        }
        if(compra.getVendedor()== null){
               throw new ExceptionsCompra("Vendedor Invalido");
        }
        if(compra.getData()== null){
               throw new ExceptionsCompra("Data Invalida");
        }
        
        
    }

    public void Incluir(Compra compra) {
        
    }
    
}
