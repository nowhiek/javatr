<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/main.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="auth">
			<div class="alert alert-warning" role="alert">
				<c:out value="${message}"></c:out>
			</div>
			<form action="Controller" method="POST">
				<div class="form-group	">
					<label for="formGroupExampleInput">Enter login:</label>
					<input class="form-control" id="formGroupExampleInput" name="login"/>
				</div>
				<div class="form-group	">
					<label for="formGroupExampleInput">Enter password:</label>
					<input type="password" class="form-control" id="exampleInputPassword1" name="password"/>
				</div>
				<div class="form-group	">
					<label for="formGroupExampleInput">Enter repeat password:</label>
					<input type="password" class="form-control" id="exampleInputPassword1" name="repeat_password"/>
				</div>
				<div class="form-group	">
					<label for="formGroupExampleInput">Enter email:</label>
					<input type="email" class="form-control" id="exampleInputEmail1" name="email"/>
				</div>		
				<input type="hidden" name="command" value="registr">
				<button class="btn btn-primary" type="submit">Registration</button>
				<a href="index.jsp">Main</a>
			</form>
		</div>
	</body>
</html>