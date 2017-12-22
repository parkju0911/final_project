<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${member eq null}">
	<a href="./member/memberJoin">Member Join</a>
	<a href="./member/memberLogin">Member Login</a>
</c:if>

<c:if test="${member ne null}">
	<a href="./member/memberLogout">Member Logout</a>
</c:if>
</body>
</html>
