package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nowe.modelo.Movimiento;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SIngresoRetiroCuenta
 */
@WebServlet("/singresoretirocuenta")
public class SIngresoRetiroCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SIngresoRetiroCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Atributos
		boolean exito;
        int cuenta;
        double monto;
        Movimiento m1;
		String respuesta;
		String btncuenta = request.getParameter("btncuenta");
		

		AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		if (btncuenta.equals("Ingresar")) {

			try {
				cuenta = Integer.parseInt(request.getParameter("idCuenta"));
				monto = Double.parseDouble(request.getParameter("monto"));

				//1.2 Instanciar un objeto Movimiento
				 m1 = new Movimiento(monto, cuenta);

				exito = ac1.ingreso(m1);

				if (exito) {
					respuesta = "Se ha realizado el ingreso correctamente";
				} else {
					respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				}

				request.setAttribute("jspInRetCuenta", respuesta);

				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException ex) {
				respuesta = "Los datos deben ser numéricos y las comas se ponen con puntos";
				request.setAttribute("jspInRetCuenta", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException ex) {
				respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				request.setAttribute("jspInRetCuenta", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);
			} // fin catch			
		} // fin if Ingresar
		
		if (btncuenta.equals("Retirar")) {

			try {
				cuenta = Integer.parseInt(request.getParameter("idCuenta"));
				monto = Double.parseDouble(request.getParameter("monto"));

				//1.2 Instanciar un objeto Movimiento
				 m1 = new Movimiento(monto, cuenta);

				exito = ac1.retiro(m1);

				if (exito) {
					respuesta = "Se ha realizado el retiro correctamente";
				} else {
					respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				}

				request.setAttribute("jspInRetCuenta", respuesta);

				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException ex) {
				respuesta = "Los datos deben ser numéricos y las comas se ponen con puntos";
				request.setAttribute("jspInRetCuenta", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException ex) {
				respuesta = "Se ha producido un error, no se realizó la acción correctamente";
				request.setAttribute("jspInRetCuenta", respuesta + "\n" + ex.toString());
				RequestDispatcher rd = request.getRequestDispatcher("/fIngresoRetiroCuenta.jsp");
				rd.forward(request, response);
			} // fin catch			
		} // fin if Retirar
		

	}// fin doPost
	

}// fin clase SIngresoRetiroCuenta
