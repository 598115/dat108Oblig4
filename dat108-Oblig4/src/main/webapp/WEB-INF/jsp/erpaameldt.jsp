<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no"> <!--Modifisert fra orginal-->
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.mobil}<br /> &nbsp;&nbsp;&nbsp;${deltager.kjonn}
	</p>
	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>