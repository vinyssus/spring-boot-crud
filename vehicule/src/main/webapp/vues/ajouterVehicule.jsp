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
<br><br>

<div class="row justify-content-center">
          <div class="col-md-6">
            <span class="anchor" id="formRegister"></span>
            <hr class="mb-5">
            <!-- form card register -->
            <div class="card card-outline-secondary">
              <div class="card-header">
                <h3 class="mb-0">Ajouter Vehicule</h3>
              </div>
              <div class="card-body">
              <c:if test="${message!=null}">
					<div class="alert alert-success" role="alert">
					<c:out value="${message}"></c:out>
					${vehicule=null}
					</div>
					</c:if>
                <form action = "/apivehicule/ajoutervehicule" autocomplete="off" class="form" role="form" method="post" enctype="multipart/form-data">
                 <input type="hidden" id="inputId" name="id" value="${vehicule.id}"
                 
                  >
                  <div class="form-group">
                    <label for="inputName">Marque</label> 
										<input class="form-control" id="marque" name="marque" placeholder="Marque" type="text" value="${vehicule.marque}">
                  </div>
                  <div class="form-group">
                    <label for="inputEmail3">Annee</label> 
										<input class="form-control" id="annee" name="annee" placeholder="annee" type="number" value="${vehicule.annee}">
										<small class="form-text text-muted">only numbers accepted.</small>
                  </div>	
                  <div class="form-group">
                    <label for="inputPassword3">Matricule</label> 
										<input class="form-control" id="matricule" name="matricule" placeholder="matricule" type="number" value="${vehicule.matricule}">
										<small class="form-text text-muted">only numbers accepted.</small>
                  </div>
                  
                    <label for="inputPassword3">Categorie : </label> 
                    <div class="input-group ">
  							<select class="custom-select" aria-label="Default select example" name="categorie">
   							<option selected hidden>Choose here</option>
										<c:forEach items="${categories}" var="cc" >
											<option value="${cc.id}" <c:if test="${produit.categorie.id==cc.id}">selected="ture"</c:if>>${cc.nom}</option>
										</c:forEach>
								</select>
				
                         </div>

								
										
						  </div>
						</div>
                   	<br>
						<div>
  <label for="formFileLg" class="form-label">Image</label>
  <input type=hidden name=image value="${vehicule.image}">
  <input class="form-control form-control-lg" type="file" id="formFileLg" name="file" accept="image/png,image/jpeg">
</div>
							
										

               
           
                  <div class="form-group">
               
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="onClick" value="save">save</button>
              </div>
            </div>

</body>
</html>