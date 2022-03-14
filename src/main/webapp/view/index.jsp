<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/inicio" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="view/style-telainicio.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@200;400;700&display=swap" rel="stylesheet">
  <title>Document</title>
</head>
<body>
	<div class="card">
    <h1>Previsao Web</h1>
    <div class="container-form">
    	<form class ='form' action="${linkEntradaServlet}" method="get">
	        <div class="label-container">
	    		  <label for='city'>Cidade: </label>
	       		<input id='city' placeholder="City" name="city" >
	        </div>
	        <div class="label-container">
	        	<input type="hidden" name=acao value=buscaAPI>
				    <input type="submit" value="Entrar">
	        </div>
		</form>
    </div>
  </div>
</body>
</html>
