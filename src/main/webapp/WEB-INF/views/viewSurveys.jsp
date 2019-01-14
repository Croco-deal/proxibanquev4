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

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

</head>

<body id="page-top">

<div class="admin-container">
		<div class="chocoList">
			<h2>Liste des types :</h2>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>N� Sondage</th>
						<th>Date Ouverture</th>
						<th>Oui</th>
						<th>Non</th>
						<th class="url">Image</th>
						<th class="chocoActions">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rbs" items="${rbs}">
						<tr>
							<td>${rbs.idSurvey}</td>
							<td>${rbs.openDate}</td>
							<td>${rbs.positiveResponse}</td>
							<td>${rbs.negativeResponse}</td>
							<td class="chocoActions">
								<a class="btn btn-danger" href="deleteChoco.html?id=${choco.id}">Supprimer</a>
								<a class="btn btn-primary" href="admin.html?id=${choco.id}">Modifier</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h3>
				<a href="index.html">Retour � l'accueil</a>
			</h3>
		</div>
</div>

</body>

</html>