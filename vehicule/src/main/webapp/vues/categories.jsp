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
<div class="container">
<div class="row ">
          <div class="col-md-4">
            <span class="anchor" id="formRegister"></span>
            <hr class="mb-5">
            <!-- form card register -->
            <div class="card card-outline-secondary">
              <div class="card-header">
                <h3 class="mb-0">
                <c:choose>
   					 <c:when test="${empty categorie.id}">
      					   Add Category
    					</c:when>
   					 <c:otherwise>
       					Modify Category
       					<a class="btn btn-primary" href="/apicategorie/ajoutercategorie" role="button" style="float:right;"><i class="bi bi-arrow-left-right"></i></a>
    					</c:otherwise>
					</c:choose>
                </h3>
                
              </div>
              <div class="card-body">
                <form action = "/apicategorie/ajoutercategorie" autocomplete="off" class="form" role="form" method=post>
                 <input type="hidden" id="idc" name="idc" value="${categorie.id}"
                 
                  >
                  <div class="form-group">
                    <label for="inputName">Nom</label> 
					<input class="form-control" id="nom" name="nom" placeholder="Nom" type="text" value="${categorie.nom}">
                  </div>
               
                
           
                  <div class="form-group">
               
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="onClick" value="save">save</button>

                  </div>
                </form>
              </div>
            </div>
            </div>
            <div class="col-md-8">
            <table class="table table-striped">
						<tr>
						<th scope="col">ID</th>
						<th scope="col">Nom</th>
						<th scope = "col">PUTC</th>
						<th scope="col">Actions</th>
						</tr>
						
							<c:forEach items="${liste}" var="cc">
							<tr>
							
							<td <c:if test="${categorie.id==cc.id}">class="table-success"</c:if>>${cc.id}</td>
							<td <c:if test="${categorie.id==cc.id}">class="table-success"</c:if>>${cc.nom}</td>
							<c:if test="${empty cc.liste}">
							<td <c:if test="${categorie.id==cc.id}">class="table-success"</c:if>>
							0</td>
							</c:if>
							<c:if test="${not empty cc.liste}">
							<td <c:if test="${categorie.id==cc.id}">class="table-success"</c:if>>
							${cc.listeLength}</td>
							</c:if>
							
							<td <c:if test="${categorie.id==cc.id}">class="table-success"</c:if>>
							<a class="btn btn-warning" href="/apicategorie/modifiercategorie/${cc.id}" role="button"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-filter-square" viewBox="0 0 16 16">
  <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
  <path d="M6 11.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5zm-2-3a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-2-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5z"/>
</svg></i></a>
							<a class="btn btn-danger" href="/apicategorie/supprimercategorie/${cc.id}" role="button" data-toggle="modal" data-target="#exampleModal"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
  <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1V2zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5H2zm13-3H1v2h14V2zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
</svg></i></a>
							</td>
							</tr>
							</c:forEach>
							
						</table></div>
            </div>
            </div>
            <br>
          	
			
						
</body>
</html>