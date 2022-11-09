<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/listaClientes" var="consulta"/>
<c:url value="/novoCliente" var="cadastro"/>
<c:url value="/novoContrato" var="orcamento"/>
<c:url value="/front/index.jsp" var="index"/>
<c:url value="/front/estilo.css" var="css"/>
<c:url value="/front/imagens/logo.png" var="logo"/>
<c:url value="/mostraContrato" var="proposta"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <link rel="stylesheet" type="text/css" href="${css}">
    <title>Elegance Buffet - Proposta</title>
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

<main class="proposta_comercial">
	<h1>Proposta comercial</h1>
    <p>
        A Elegance Buffet se compromete a atender os serviços 
        contratados, diante da proposta aferida abaixo, caso aceita, com todos os 
        termos legais, seguindo as normas e padrões instituídos a fim de boa 
        relação comercial na prestação de serviços do ramo de eventos e culinários.
    </p>
    <br>
    <p>A quantidade de convidados será de: ${contrato.quantidadeConvidados}</p>
    <br>
    <p>A quantidade de garçons contratados será de: ${contrato.quantidadeGarcons}</p>
    <br>
    <p>A taxa referida ao pagamento dos garçons será de: R$${contrato.taxaGarcom}</p>

    <br>
<%--    <c:if test="contrato.valorSobremesa != 0">--%>
    <p>
        A taxa referente à inclusão da sobremesa é de: R$${contrato.valorSobremesa}<br>
        O que representa 10% do valor do contrato
    </p>
    <br><br>
<%--    </c:if>--%>
    <p>O valor total do contrato, somado o valor da sobremesa, é de
        R$${contrato.valorTotal}</p><br><br>
    <p>Contratado</p><div class="contratado">
    <p class="contrato">x</p>
</div>

    <p>Contratante</p>
    <p class="contrato">x</p>

</main>



</body>
</html>