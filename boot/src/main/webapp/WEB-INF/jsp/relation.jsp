<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-canche">
<meta http-equiv="Cahe-Control" content="no-canche">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
<title>Boot Sample | Relations</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
					<li><a href="new-relationComposition">Manage Relation</a></li>
					<li><a href="all-relationCompositions">All relations</a></li>
					
				</ul>
			</div>
		</div>
	</div>
<c:choose>
<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Relation Manager </h1>
				</div>
			</div>
		</c:when>

	<c:when test="${mode == 'MODE_RELATIONS' }">
			<div class="container text-center" id="relationDiv">
				<h3>My Relations</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id </th>
								<th>Relation 1 Id</th>
								<th>Relation 2 Id</th>
								<th>Inferred relation Id</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="relationComposition" items="${relation_composition}">
								<tr>
									<td>${relationComposition.id}</td>
									<td>${relationComposition.relation1Id}</td>
									<td>${relationComposition.relation2Id}</td>
									<td>${relationComposition.inferredRelationId }</td>

									<td><a href="update-relationComposition?id=${relationComposition.id}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-relationComposition?id=${relationComposition.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Manage Relation Composition</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-relationComposition">
				<input type="hidden" name="id" value="${relationComposition.id}"/>
				
			<div class="form-group"> 
				<label class="control-label col-md-3">Realation 1 Id: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="relation1Id" value="${relationComposition.relation1Id}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Relation 2 Id: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="relation2Id" value="${relationComposition.relation2Id}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Inferred relation Id: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="inferredRelationId" value="${relationComposition.inferredRelationId}"/>
				</div>
			</div>
			
			<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Save"/>
			</div>
				</form>
			</div>
		</c:when>


		</c:choose>

	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
</body>

</html>