package com.nowe.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Ana Garcia
 * @version 1.0
 * @since 16-02-2021
 *
 */
public class Conexion {
	
	 protected Connection miConexion;
	    public void abrirConexion() throws ClassNotFoundException, SQLException {
	        //Cargar el driver
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	        String stringConexion =  "jdbc:sqlserver://localhost:1433;" + 
	                       "databaseName=CUENTAS_BANCOS;" + 
	                       "user=CAMBIAR;" +  
	                        "password=CAMBIAR;" +
	                      "encrypt=false;" +
	                     "trustServerCertificate=false;" +
	                      "loginTimeout=30;";
	        //Obtenermos un objeto de tipo conexion
	        miConexion = DriverManager.getConnection(stringConexion); //Obtenemos la conexion y le damos el string de conexion
	        //System.out.println("Exito al abrir la conexion");                     //Obtenemos un objeto conexion que está conectado a la BD
	    }
	    
	    public void cerrarConexion() throws SQLException {
	        miConexion.close(); //es muy importante cerrar la conexion porque los servidores de BD tienen limitadas las conexiones que puede atender
	    }

}//fin clase Conexion
