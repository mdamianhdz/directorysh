<%-- 
    Document   : home
    Created on : 5/09/2016, 11:07:06 PM
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
        <link href="css/home.css" rel="stylesheet" />
        <title>${sessionScope.usuarioSesion.name} - Directorio v${sessionScope.config.version} | Sanatorio Huerta SA de CV</title>
    </head>
    <body>
        <div class="example3">
            <jsp:include page="template/simple/menu.jsp"></jsp:include>
            </div>
            <br>
            <h3 style="text-align: center;">Directorio telef&oacute;nico</h3>
        <c:if test="${not empty msj}">
            <div class="row">
                <div class="alert ${requestScope.msjtype} alert-dismissible col-sm-offset-4 col-sm-4" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    ${requestScope.msj}
                </div>
            </div>
        </c:if>
        <form class="form-horizontal " id="search" action="search" method="post">
            <div class="form-group">
                <label for="value" class="col-sm-offset-1 col-sm-2 control-label">Buscar:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="value" name="value" placeholder="Ingresa un valor a buscar" required="true">
                </div>
            </div>
            <div class="form-group">
                <label for="department" class="col-sm-offset-1 col-sm-2 control-label">Departamento:</label>
                <div class="col-sm-6">
                    <select class="form-control" id="department" name="department">
                        <c:if test="${not empty departments}">
                            <c:forEach items="${sessionScope.departments}" var="oDep" >
                                <option value="${oDep.id}">${oDep.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="department" class="col-sm-offset-1 col-sm-2 control-label">Filtros:</label>
                <div class="col-sm-6">
                    <label class="radio-inline">
                        <input type="radio" checked="checked" id="contactSearch" name="filterSearch" value="contact"> Nombre de contacto
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="turningSearch" name="filterSearch" value="turning"> Giro o especialidad
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="contactNameSearch" name="filterSearch" value="contactCompany"> Contacto de empresa
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-4">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar
                    </button>
                </div>
            </div>
        </form>
        <jsp:include page="template/simple/footer.jsp"></jsp:include>
    </body>
</html>
