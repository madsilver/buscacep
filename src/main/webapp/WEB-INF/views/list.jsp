<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca CEP - Lista</title>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.11.3.min.js" var="jQuery" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jQuery}"></script>
<script src="${bootstrapJs}"></script>
</head>
<body>

<div class="container">
  <h2>Lista de endereços</h2>
  <p><a href="/buscacep">Home</a></p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Rua</th>
        <th>Número</th>
        <th>Complemento</th>
        <th>Bairro</th>
        <th>Cidade</th>
        <th>Estado</th>
        <th>CEP</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listAddress}" var="address">
      <tr>
        <td>${address.id}</td>
        <td>${address.street}</td>
        <td>${address.number}</td>
        <td>${address.complement}</td>
        <td>${address.neighborhood}</td>
        <td>${address.city}</td>
        <td>${address.state}</td>
        <td>${address.zipcode}</td>
        <td>
        	<a href="/buscacep?id=${address.id}" class="btn btn-primary">Editar</a>
        	<a href="/buscacep/removeAddress/${address.id}" class="btn btn-danger">Excluir</a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>


</body>
</html>