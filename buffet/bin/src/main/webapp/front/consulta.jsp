<%--
  Created by IntelliJ IDEA.
  User: ff_cm
  Date: 07/11/2022
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:url value="/front/estilo.css" var="css"/>
<c:url value="/front/imagens/logo.png" var="logo"/>

<c:url value="/front/index.jsp" var="index"/>
<c:url value="/novoContrato" var="orcamento"/>
<c:url value="/novoCliente" var="cadastro"/>
<c:url value="/listaClientes" var="consulta"/>
<c:url value="/mostraContrato" var="proposta"/>

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
<c:if test="${fn:length(contratos) == 0}">
<form action="${consulta}" method="post">
    <h1>Consulta</h1>
    <input class="nome" type="text" name="nome" id="nome">
    <input class="submit_reset" type="submit" value="Pesquisar">
</form>
</c:if>
<c:if test="${fn:length(contratos) > 0}">
    <table>
        <thead>
        <th>
            Nome do Cliente
        </th>
        <th>
            CPF do Cliente
        </th>
        <th>
            Mostrar Contrato
        </th>
        </thead>
        <c:forEach items="${contratos}" var="contrato">
            <tr>

                <td>
                        ${contrato.cliente.nome}
                </td>
                <td>
                        ${contrato.cliente.cpf}
                </td>
                <td>
                    <a href="${proposta}?id=${contrato.id}">Selecionar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<footer>
    <p>Criado por Silvany Sousa, Gabriel Gaspar e Natan Ferraz.</p>
</footer>

</body>
</html>
