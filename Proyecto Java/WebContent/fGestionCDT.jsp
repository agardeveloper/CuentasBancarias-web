<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de CDT</title>
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
	<h1>Gestión de CDT</h1>
	<form action="sgestioncdt" method="post">
		<table>
			<tr>
				<td align="center">
					Crear un CDT<input type="radio" name="btncdt" value="CrearCDT" checked></br></br>
					Cuenta: <input type="text" name="idCuenta"></br>
					Interés: <input type="text" name="interes"></br>
					Monto: <input type="text" name="monto"></br>
				</td>
				
				<td align="center">
					Cerrar un CDT<input type="radio" name="btncdt" value="cerrarCDT"></br></br>
					CDT: <input type="text" name="idCDT">
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="Realizar la acción"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="taError" rows="10" cols="50"><%=request.getAttribute("jspGestionCDT") %></textarea></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>