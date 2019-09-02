<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Task</title>
</head>
<jsp:include page="sitemap.jsp" />
<body>
	<h3>Add New Task</h3>

	<div id="addTask">
		<form:form action="/addTasks" method="put" methodAttribute="addTasks">
			<p>
				<label>Enter Task Name</label>
				<form:input path="taskName" />
			</p>
			<p>
				<label>Enter User Name</label>
				<form:input path="createdBy" />
			</p>
			<p>
				<label>Enter Scheduled Date</label>
				<form:input path="taskScheduled" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>