package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SConsultaSaldos
 */
@WebServlet("/sconsultasaldos")
public class SConsultaSaldos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SConsultaSaldos() {
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
		// Obtener valores
		double respuesta;
		String respuestaError;
		String saldo = request.getParameter("saldo");	
		request.setAttribute("jspSaldoError", "");
		//Llamar a la capa de persistencia
		AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		if (saldo.equals("SaldoCuenta")) {
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				respuesta = ac1.ConsultaSaldo(id);
				
				request.setAttribute("jspSaldo", respuesta);
				
				RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
				
  
			} catch (NumberFormatException  ex) {
				respuestaError = "Los datos deben ser numéricos";
	        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
	        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
					rd.forward(request, response);
		 
          } catch (ClassNotFoundException | SQLException ex) {
        	  respuestaError = "Se ha producido un error, no se realizó la acción correctamente";
        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
          }//fin catch
			
		}// fin if
		
		if (saldo.equals("SaldoCDT")) {
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				respuesta = ac1.ConsultaSaldoCDT(id);
				
				request.setAttribute("jspSaldo", respuesta);
				
				RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
				
  
			} catch (NumberFormatException  ex) {
				respuestaError = "Los datos deben ser numéricos";
	        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
	        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
					rd.forward(request, response);
		 
          } catch (ClassNotFoundException | SQLException ex) {
        	  respuestaError = "Se ha producido un error, no se realizó la acción correctamente";
        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
          }//fin catch
			
		}// fin if
		
		if (saldo.equals("SaldoCliente")) {
			
			try {
				String numNIF = request.getParameter("id");
				
				respuesta = ac1.ConsultaSaldoTotal(numNIF);
				
				request.setAttribute("jspSaldo", respuesta);
				
				RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
				
  
			} catch (NumberFormatException  ex) {
				respuestaError = "Los datos deben introducidos no son correctos";
	        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
	        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
					rd.forward(request, response);
		 
          } catch (ClassNotFoundException | SQLException ex) {
        	  respuestaError = "Se ha producido un error, no se realizó la acción correctamente";
        	  request.setAttribute("jspSaldoError", respuestaError + "\n" + ex.toString());
        	  RequestDispatcher rd = request.getRequestDispatcher("/fConsultaSaldos.jsp");
				rd.forward(request, response);
          }//fin catch
			
		}// fin if
		
	}//fin doPost

}//fin clase SConsultaSaldo
