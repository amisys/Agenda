<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<title>Agenda de Contatos</title>
		<script>
			$(document).ready(function(){
	     		$("#updateContato").hide();
			});
	     </script>
	     <c:if test="${update != null}">
		     <script>
				$(document).ready(function(){
			       	$("#updateContato").show();
		        	$("#createContato").hide();
		    	});
			</script>
		</c:if>
	</head>
    <body>
   	<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("user")) userName = cookie.getValue();
			}
		}
		if(userName == null) response.sendRedirect("index.html");
	%>
	<h1>Cadastrar contato:</h1>
		<form name="create" action="AgendaServlet" method="post">
			<fieldset>
				<p>
					<label for="nome">Nome: </label>
					<input type="text" name="nome" value="<%=(request.getAttribute("nome") != null) ? request.getAttribute("nome") : ""%>"/>
				</p>
				<p>
					<label for="endereco">Endereço: </label>
					<input type="text" name="endereco" value="<%=(request.getAttribute("endereco") != null) ? request.getAttribute("endereco") : ""%>"/>
				</p>
				<p>
					<label for="cidade">Cidade: </label>
					<input type="text" name="cidade" value="<%=(request.getAttribute("cidade") != null) ? request.getAttribute("cidade") : ""%>"/>
				</p>
				<p>
					<label for="estado">Estado: </label>
					<input type="text" name="estado" value="<%=(request.getAttribute("estado") != null) ? request.getAttribute("estado") : ""%>"/>
				</p>
				<p>
					<label for="cep">CEP: </label>
					<input type="text" name="cep" value="<%=(request.getAttribute("cep") != null) ? request.getAttribute("cep") : ""%>"/>
				</p>
				<p>
					<label for="telefone1">Telefone 01: </label>
					<input type="text" name="telefone1" value="<%=(request.getAttribute("telefone_1") != null) ? request.getAttribute("telefone_1") : ""%>"/>
				</p>
				<p>
					<label for="telefone2">Telefone 02: </label>
					<input type="text" name="telefone2" value="<%=(request.getAttribute("telefone_2") != null) ? request.getAttribute("telefone_2") : ""%>"/>
				</p>
				<input type="hidden" name="idupdreq" value="${idupdresp}"/>
			</fieldset>
			<p>
				<input type="submit" name="createContato" id="createContato" value="Cadastrar"/>
				<input type="submit" name="updateContato" id="updateContato" value="Atualizar"/>
			</p>
		</form>
	<h1>Contatos:</h1>
   	<table border="1">
   		<tr>
   			<th>Nome</th>
   			<th>Endereço</th>
   			<th>Cidade</th>
   			<th>Estado</th>
   			<th>CEP</th>
   			<th>Telefone 1</th>
   			<th>Telefone 2</th>
   		</tr>
        <c:forEach var="contato" items="${listaContatos}">
	       	<tr>
	       		<td>${contato.get_nome()}</td>
	       		<td>${contato.get_endereco()}</td>
				<td>${contato.get_cidade()}</td>
				<td>${contato.get_estado()}</td>
				<td>${contato.get_cep()}</td>
				<td>${contato.get_telefone_1()}</td>
				<td>${contato.get_telefone_2()}</td>
				<td>
					<form name="deleteform" action="AgendaServlet" method="post">
						<input type="hidden" name="iddel" value="${contato.get_idcontatos()}"/>
						<input type="submit" name="delete" id="delete" value="Remover"/>
					</form>
				</td>
				<td>
					<form name="updateform" action="AgendaServlet" method="post">
						<input type="hidden" name="idupd" value="${contato.get_idcontatos()}">
						<input type="submit" name="update" id="update" value="Alterar">
					</form>
				</td>
			</tr>
        </c:forEach>
    </table>
    <p>
	<form action="AgendaServlet" method="post">
		<input type="submit" name="logout" value="Logout" >
	</form>
	</body>
</html>