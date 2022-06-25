<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="navbar.jsp" %>

<form action="/apivehicule/vehiculeParCategorie" method="get">
  <div class="mb-3">
     <select class="form-select" name="categorie" onchange="submit()">
       <option selected hidden >${categorie}</option>
       <option value="0" >Toutes les categories</option>
       <c:forEach items="${categories}" var="cat">
        <option value="${cat.id}">${cat.nom}</option>
       </c:forEach>
     </select>
  </div>
</form>

<br><br>
<div class="container">
<form class="form-inline" name="search" method = "get" action=vehiculemc>
    <input class="form-control mr-sm-2" type="search" name="mc" id="mc" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
</form>
</div>
<br>

<table class="table table-striped">
<tr class="bg-dark text-light">
<th scope="col">Image</th>
<th scope="col">ID</th>
<th scope="col">Marque</th>
<th scope="col">Année</th>
<th scope="col">Matricule</th>
<th scope="col">Categorie</th>
<th scope="col">Actions</th>
</tr>


	<c:forEach items="${liste}" var="v">
	<tr>
	<td><c:choose>
	<c:when test="${v.image=='' || v.image == null}">
	<img src="/images/no-name.png" width="50" height="50">
	</c:when>
	<c:when test="${v.image!='' }">
	<img src="/images/${v.image }" width="50" height="50">
	</c:when>
	</c:choose>
	</td>
	<td>${v.id}</td>
	<td>${v.marque}</td>
	<td>${v.annee}</td>
	<td>${v.matricule}</td>
	<c:if test="${empty v.categorie.nom}"><td>Rien !</td></c:if>
	<c:if test="${not empty v.categorie.nom}"><td>${v.categorie.nom}</td></c:if>
	<td>
	<a class="btn btn-warning" href="/apivehicule/modifiervehicule/${v.id}" role="button"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-filter-square" viewBox="0 0 16 16">
  <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
  <path d="M6 11.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5zm-2-3a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-2-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5z"/>
</svg></i></a>
	<a class="btn btn-danger" href="/apivehicule/supprimervehicule/${v.id}" role="button" data-toggle="modal" data-target="#exampleModal"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
  <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1V2zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5H2zm13-3H1v2h14V2zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
</svg></a>
	</td>
	</tr>
	</c:forEach>
	


</table>
</body>
</html>