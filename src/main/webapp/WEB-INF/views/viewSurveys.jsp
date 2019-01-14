<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Sondages</title>
<!-- CSS de Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- JavaScript pour JQuery, Popper, Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</head>

<body id="page-top">

<div class="admin-container">
		<div class="chocoList">
			<h2>Liste des types :</h2>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>N° Sondage</th>
						<th>Date Ouverture</th>
						<th>Oui</th>
						<th>Non</th>
				
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rbs" items="${rbs}">
						<tr>
							<td>${rbs.idSurvey}</td>
							<td>${rbs.openDate}</td>
							<td>${rbs.positiveResp}</td>
							<td>${rbs.negativeResp}</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h3>
				<a href="index.html">Retour à l'accueil</a>
			</h3>
		</div>
</div>

</body>

</html>