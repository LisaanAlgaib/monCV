<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Contact</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/contacter" method="post">
	<label for="email">Email* : </label>
	<input type="text" name="email" id="email" placeholder="example@mail.com" required min="5" max="40"><br>
	<label for="sujet">Sujet* : </label>
	<input type="text" name="sujet" id="sujet" max="60" placeholder="Objet" required><br>
	<label for="corps_email">Message* : </label>
	<textarea id="corps_email" name="corps_email" placeholder="Votre message" rows="5" cols="33" maxlength="300" required></textarea><br>
	<input type="submit" value="Envoyer">
</form>
<%@ include file="/WEB-INF/parts/header.jsp" %>
<%@ include file="/WEB-INF/parts/footer.jsp" %>