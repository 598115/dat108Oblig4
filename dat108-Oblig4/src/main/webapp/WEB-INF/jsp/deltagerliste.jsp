<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
    <p>Innlogget som: ${deltager.mobil} / ${deltager.fornavn} ${deltager.etternavn}</p>
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
        </tr>    
               <c:forEach var="deltagere" items="${deltagerList}">   
				  <tr class="${deltagere.mobil == deltager.mobil ? 'highlight' : ''}">
                       <td align="ceneter">${deltagere.kjonn == 'mann' ? '&#9794;' : '&#9792;'}</td>
                       <td>${deltagere.fornavn} ${deltagere.etternavn}</td>
                       <td>${deltagere.mobil}</td>
		         </tr>
              </c:forEach>
	</table>
	<br>
	<form action="utlogging" method="post">
	   <button type="submit">Logg ut</button> 
	</form>
</body>
</html>