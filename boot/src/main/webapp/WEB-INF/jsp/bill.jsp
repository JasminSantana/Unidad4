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
<title>Boot Sample | Bills</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
					<li><a href="new-bill">Manage Bill</a></li>
					<li><a href="all-bills">All bills</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Bill Manager </h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_BILLS' }">
			<div class="container text-center" id="billDiv">
				<h3>My Bills</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id bill</th>
								<th>Delivery date</th>
								<th>Amount</th>
								<th>Observation</th>
								<th>Delivered</th>
								<th>Client code</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bill" items="${bills}">
								<tr>
									<td>${bill.id_bill}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${bill.deliveryDate}" /></td>
									<td>${bill.amount }</td>
									<td>${bill.observation }</td>
									<td>${bill.delivered ==true?'YES':'NO'}</td>
									<td>${bill.clientCode }</td>
									<td><a href="update-bill?id_bill=${bill.id_bill}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-bill?id_bill=${bill.id_bill}"> <span
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
				<h3>Manage Bill</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-bill">
				<input type="hidden" name="id_bill" value="${bill.id_bill }"/>
				
			<div class="form-group"> 
				<label class="control-label col-md-3">Client code: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="clientCode" value="${bill.clientCode}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Amount: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="amount" value="${bill.amount}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Observation: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="observation" value="${bill.observation}"/>
				</div>
			</div>
			
			<div class="form-group"> 
				<label class="control-label col-md-3">Delivered: </label>
				<div class="col-md-7">
				<input type="radio" class="col-sm-1" name="delivered" value="true"/>
				<div class="col-sm-1">YES</div>
				<input type="radio" class="col-sm-1" name="delivered" value="false" checked="checked"/>
				<div class="col-sm-1">NO</div>
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