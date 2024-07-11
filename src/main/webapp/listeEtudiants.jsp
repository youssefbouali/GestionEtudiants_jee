<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Liste des étuduants</title>
</head>
<body>

<form action="AjouterEtudiantServlet" method="POST">
	<input type="text" name="nom" placeholder="Nom"><br />
	<input type="text" name="prenom" placeholder="Prénom"><br />
	<input type="email" name="email" placeholder="Email"><br />
	<input type="submit" name="submit" value="Submit">
</form>

<ul>

<table border="1">
    <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
    </tr>
    <c:forEach var="etudiant" items="${listeEtudiants}">
            <tr>
                <td><c:out value="${etudiant.nom}" /></td>
                <td><c:out value="${etudiant.prenom}" /></td>
                <td><c:out value="${etudiant.email}" /></td>
            </tr>
    </c:forEach>
</table>

</ul>

</body>
</html>