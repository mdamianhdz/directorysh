<%-- 
    Document   : index
    Created on : 5/09/2016, 09:12:36 PM
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/signin.css" rel="stylesheet" />
        <title>Diretorio | Sanatorio Huerta SA de CV</title>
    </head>
    <body>
        <div class="container">
            <form class="form-signin" id="signin" action="login" method="post">
                <c:if test="${not empty msj}">
                    <div class="alert ${requestScope.msjtype} alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        ${requestScope.msj}
                    </div>
                </c:if>
                    <h4 class="form-signin-heading">Acceso a directorio telef&oacute;nico</h4>
                <label for="inputUser" class="sr-only">Nombre de usuario</label>
                <input type="text" placeholder="Nombre de usuario" id="user" name="user" autofocus="true" class="form-control" required="true" />
                <label for="inputPassword" class="sr-only">Contrase&ntilde;a</label>
                <input type="password" placeholder="Contraseña" id="password" name="password" class="form-control" required="true" />
                <button class="btn btn-lg btn-primary btn-block" id="submit" type="submit">Enviar</button>
                <input type="hidden" value="login" name="accion"/>
            </form>

        </div> <!-- /container -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
