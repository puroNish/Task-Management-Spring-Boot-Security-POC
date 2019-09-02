<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Management - Main Portal</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<form id="logoutForm" method="POST" action="/logout"></form>
	<h1 class="container text-center">
		<strong>Task Management - Main Portal</strong>
	</h1>
	<div class="container text-center">
		<div class="">Current User: ${loggedinUser}</div>
		<div class="">
			<a onclick="document.forms['logoutForm'].submit()">Logout</a>
		</div>
	</div>
	<p>
		<c:choose>
			<c:when test="${userrole == 'ROLE_ADMIN'}">
				<div class="container text-center">
					<h3>Add New Task</h3>
					<hr>
					<form class="form-horizontal" method="POST" action="addTask">
						<input type="hidden" name="taskId" value="task.taskId" />
						<div class="form-group">
							<label class="control-label col-md-3">Task Name</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskName"
									value="${task.taskName}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Task Details</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskDetails"
									value="${task.taskDetails}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Scheduled
								Completion Date</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskScheduled"
									value="${task.taskScheduled}" />
							</div>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
					</form>
				</div>
				<p>
					<br>
					<%-- 			</c:when>
			<c:when
				test="${userrole == 'ROLE_ADMIN' || userrole == 'ROLE_USER'}"> --%>
				<div class="container text-center">
					<h3>Find Task Details</h3>
					<hr>
					<form class="form-horizontal" method="POST" action="someTasks">
						Enter Task Id: <input type="text" name="taskId"
							value="${loadedtask.taskId}" />
						<div class="form-group">
							<br> <input type="submit" class="btn btn-primary"
								value="Get Task Details" name="getdetails" /> <input
								type="submit" class="btn btn-primary" name="deletetask"
								value="Delete Task" />
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Task Id</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskId"
									value="${loadedtask.taskId}" readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Task Name</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskName"
									value="${loadedtask.taskName}" readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Task Details</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskDetails"
									value="${loadedtask.taskDetails}" readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Scheduled
								Completion Date</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskScheduled"
									value="${loadedtask.taskScheduled}" readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Task Created Date</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="taskCreated"
									value="${loadedtask.taskCreated}" readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Created by</label>
							<div class="col-md-7">
								<input type="text" class="form-control" name="createdBy"
									value="${loadedtask.createdBy}" readonly />
							</div>
						</div>
					</form>
				</div>
				<%-- 			</c:when>
			<c:when test="${userrole == 'ROLE_ADMIN'}"> --%>

			</c:when>
		</c:choose>
	<div class="table-responsive text-center">
		<h3>My Tasks</h3>
		<table class="table table-striped table-bordered text-left">
			<thead>
				<tr>
					<th>Task Id</th>
					<th>Task Name</th>
					<th>Date Scheduled</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
					<tr>
						<td>${task.taskId}</td>
						<td>${task.taskName}</td>
						<td>${task.taskScheduled}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>