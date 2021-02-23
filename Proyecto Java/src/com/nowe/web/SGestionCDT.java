package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.CDT;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SGestionCDT
 */
@WebServlet("/sgestioncdt")
public class SGestionCDT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SGestionCDT() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Atributos
		 int cuenta, CDT;
         double interes, monto;
         CDT inversion;
         boolean exito;
         String respuesta;
         String btncdt = request.getParameter("btncdt");
         request.setAttribute("jspGestionCDT", "");

		AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		if (btncdt.equals("CrearCDT")) {

			try {
				cuenta = Integer.parseInt(request.getParameter("idCuenta"));
                interes = Double.parseDouble(request.getParameter("interes"));
                monto = Double.parseDouble(request.getParameter("monto"));
              
                //1.2 Instanciar un objeto CDT
                inversion = new CDT(cuenta, interes, monto);
                
				exito = ac1.crearInversion(inversion);
				
				if (exito) {
                    respuesta = "Se ha realizado el alta de su CDT correctamente";
                } else {
                    respuesta = "Se ha producido un error, no se realizó la acción correctamente";
                }

				request.setAttribute("jspGestionCDT", respuesta);

				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException ex) {
				respuesta = "Los datos deben ser numéricos y las comas se ponen con puntos";
				request.setAttribute("jspGestionCDT", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException ex) {
				respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				request.setAttribute("jspGestionCDT", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);
			} // fin catch			
		} // fin if CrearCDT
		
		if (btncdt.equals("cerrarCDT")) {
	
			try {
				CDT = Integer.parseInt(request.getParameter("idCDT"));  
				exito = ac1.cerrarInversion(CDT);
				
				if (exito) {
                    respuesta = "Se ha realizado el cierre de su CDT correctamente";
                } else {
                    respuesta = "Se ha producido un error, no se realizó la acción correctamente";
                }

				request.setAttribute("jspGestionCDT", respuesta);

				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException ex) {
				respuesta = "Los datos deben ser numéricos y las comas se ponen con puntos";
				request.setAttribute("jspGestionCDT", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException ex) {
				respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				request.setAttribute("jspGestionCDT", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fGestionCDT.jsp");
				rd.forward(request, response);
			} // fin catch			
		} // fin if cerrarCDT
		
	}// fin doPost

}// fin clase SGestionCDT
