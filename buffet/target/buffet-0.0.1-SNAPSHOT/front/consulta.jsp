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
    <title>Elegance Buffet - Consulta</title>
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
	
		<form id="formulario" action="${consulta}" method="post">
			<c:if test="${fn:length(contratos) == 0}">
			
			    <h1>Consulta</h1>
			    <input class="nome" type="text" name="nome" id="nome">
			    <input class="submit_reset" type="submit" value="Pesquisar">
			
			</c:if>
		</form>
	<main>
		<table id="tabela">
			<c:if test="${fn:length(contratos) > 0}">
			    
		        <thead>
			        <tr>
			        	<th>Nome do Cliente</th>
			        	<th>CPF do Cliente</th>
			        	<th>Mostrar Contrato</th>
			        </tr>	
		        </thead>
		        <tbody>
		        <c:forEach items="${contratos}" var="contrato">
		            <tr>
		                <td>${contrato.cliente.nome}</td>
		                <td>${contrato.cliente.cpf}</td>
		                <td>
		                	<a href="${proposta}?id=${contrato.id}">Selecionar</a>
		                </td>
		            </tr>
		        </c:forEach>
		        </tbody>
			    
			</c:if>
		</table>
	</main>
	

</body>
</html>
