<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script 
		  src="https://code.jquery.com/jquery-3.3.1.min.js"
		  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		  crossorigin="anonymous"></script>
		<script src="js/script.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
		<style type="text/css">
        	<%@ include file="css/style.css" %>
        </style>
	</head>
	<body>
		<h1>Welcome</h1>
		<div id="all_notes">
		<h1>Recent Posts</h1>
		</div>
		<div id="left">
		<h3>Add a post</h3>
		<form class ="new" action="/notes/create" method="post">
			Title: 
			<input id="title" type="text" name="title"/>
			<br>
			Post: 
			<br>
			<textarea id="desc" name="description"></textarea>
			<br>
			<input type="submit" value="Create"/>
			<br>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		</div>
	</body>
</html>