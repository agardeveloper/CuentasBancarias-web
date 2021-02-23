package com.nowe.negocio;

import java.sql.SQLException;

import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * 
 * @author Ana Garcia
 * @version 1.0
 * @since 16-02-2021
 *
 */
public class Cajero {
	 //Método de consultar saldo:
    public double consultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldo(idCuenta);
    }
    
    public double consultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldoCDT(idInversion);
    }
    
    //Consulta de saldo total
     public double consultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldoTotal(nif);
    }

}//fin clase Cajero
