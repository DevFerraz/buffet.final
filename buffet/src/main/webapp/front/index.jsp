<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/listaClientes" var="consulta"/>
<c:url value="/novoCliente" var="cadastro"/>
<c:url value="/novoContrato" var="orcamento"/>
<c:url value="/front/index.jsp" var="index"/>
<c:url value="/front/estilo.css" var="css"/>
<c:url value="/front/imagens/logo.png" var="logo"/>
<c:url value="/front/imagens/buffet1.jpg" var="buffet1"/>
<c:url value="/front/imagens/buffet2.jpg" var="buffet2"/>
<c:url value="/front/imagens/buffet3.jpg" var="buffet3"/>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <link rel="stylesheet" type="text/css" href="${css}">
    <title>Elegance Buffet</title>
</head>
<body>
<header>
    <img src="${logo}" alt="">
</header>

<nav>
    <a href="${index}">Inicial</a>
    <a href="${orcamento}">Orcamento</a>
    <a href="${cadastro}">Cadastro</a>
    <a href="${consulta}">Consulta</a>
</nav>
<p>${mensagem}</p>
<main>
    <img src="${buffet1}" alt="Imagem 1">
    <img src="${buffet2}" alt="Imagem 2">
    <img src="${buffet3}" alt="Imagem 3">
</main>

<footer>
    <p>Criado por Silvany Sousa, Gabriel Gaspar e Natan Ferraz.</p>
</footer>

</body>
</html>