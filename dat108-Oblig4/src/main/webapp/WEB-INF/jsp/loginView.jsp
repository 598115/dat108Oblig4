<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<c:if test="${not empty redirectMessage}">
	<p style="color:red;">${redirectMessage}</p>
    </c:if>
	<form action=innlogging method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>

</body>
</html>

<!--Oppdatert-->