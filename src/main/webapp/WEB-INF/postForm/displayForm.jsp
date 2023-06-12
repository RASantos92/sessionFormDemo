<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Movie Title: <c:out value="${movie}"/></h1>
	<h1>comment: <c:out value="${comment}"/></h1>
	<h1>Rating: ${rating}</h1>
	<h2>Reviewer : <c:out value="${reviewer}"/></h2>
	<h1>${test}</h1>
</body>
