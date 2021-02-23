<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso Retiro a una cuenta</title>
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
	<h1>Ingreso / Retiro a una cuenta</h1>
	<form action="singresoretirocuenta" method="post">
		<table>
			<tr>
				<td align="center">
					Ingresar<input type="radio" name="btncuenta" value="Ingresar" checked></br></br>				
				</td>		
				<td align="center">
					Retirar<input type="radio" name="btncuenta" value="Retirar"></br></br>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					Cuenta: <input type="text" name="idCuenta"></br>
					Monto: <input type="text" name="monto"></br>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="Realizar la acción"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="taError" rows="10" cols="50"><%=request.getAttribute("jspInRetCuenta") %></textarea></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>