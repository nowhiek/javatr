<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/main.css">
		<title>Start page</title>
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
				<div class="form-group">
					<label for="formGroupExampleInput">Enter password:</label>
					<input type="password" class="form-control" id="exampleInputPassword1" name="password"/>
				</div>
				<input type="hidden" name="command" value="sign_in">
				<button class="btn btn-primary" type="submit">Sign in</button>
				<a href="registr_page.jsp">Registration</a>
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</body>
</html>
