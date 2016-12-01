<!DOCTYPE html>
<html>
<head>
<title>LOGIN</title>
</head>
<body>
	<center>		
		
		<h2>Ingreso al sistema</h2>	
		<form name='form' action='login' method='POST'>
		<br>
			<table>
				<tr>
					<td>Usuario:</td>
               <td><input type='text' name='username' required="true"></td>
				</tr>
				<tr>
					<td>Password:</td>
               <td><input type='password' name='password' required="true"/></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Ingresar" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>