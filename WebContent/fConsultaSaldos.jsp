<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Saldos</title>
</head>
<body>
	<header>
		<div>
			<a href="index.jsp">Menú Aplicación Bancaria</a><br/> 
			<a href="fConsultaSaldos.jsp">Visualizar saldos</a><br/> 
			<a href="fGestionCDT.jsp">Gestionar un CDT</a><br/> 
			<a href="fIngresoRetiroCuenta.jsp">Ingresar/Retirar</a><br/> 
		</div>
	</header>
<div>
	<h1>Visualizar Saldos</h1>
	<form action="sconsultasaldos" method="post">
		<table>
			<tr>
				<td><input type="radio" name="saldo" value="SaldoCuenta" checked>Saldo Cuenta</br> 
				<input type="radio" name="saldo" value="SaldoCDT">Saldo CDT</br> 
				<input type="radio" name="saldo" value="SaldoCliente">Saldo Cliente</br></br>
				</td>
				
				<td>
					Identificador <input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Consultar Saldo"></td>
			</tr>
			<tr>
				<td></td>	
				<td><input type="text" name="txtsaldo" value="<%=request.getAttribute("jspSaldo") %>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea name="taError" rows="10" cols="40"><%=request.getAttribute("jspSaldoError") %></textarea></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>