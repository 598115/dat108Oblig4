<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<script src="js/Validation.js" defer></script>
		
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<c:if test="${not empty errorMessage}">
	    <p style="color:red;">${errorMessage}</p>
	</c:if>
	<form action="paamelding" method="post">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="" required />
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="" required/>
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value="" required/>
			
			<label>Passord</label>
			<input type="password" name="passord" required/>
			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" required/>
			
			<label>Kjønn</label> 
			<input type="radio" name="kjonn" value="mann" class="kjonn" checked="checked" required/>mann
			<input type="radio" name="kjonn" value="kvinne" class="kjonn" required/>kvinne
			     
			<br><br><button type="submit" class="submit-button">Meld meg på</button>
		</fieldset>
	</form>
</body>
</html>

<!--Oppdatert-->