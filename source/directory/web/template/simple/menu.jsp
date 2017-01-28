
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar3">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><img src="${sessionScope.config.logo}" alt="Sanatorio Huerta SA de CV">
            </a>
        </div>
        <div id="navbar3" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="home.jsp">Busqueda</a></li>
                <li><a href="#" onclick="openModal();">Registrar llamada directa</a></li>
                <c:if test="${sessionScope.usuarioSesion.usertype.queryReports}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Reportes<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Llamadas realizadas</a></li>
                            <li><a href="#">Contactos por departamento</a></li>
                            <li><a href="#">Correcciones realizadas</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Configuraci&oacute;n <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Sistema</a></li>
                        <li><a href="#">Usuarios</a></li>
                        <li><a href="#">Contactos</a></li>
                        <li><a href="#">Telefonos</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Correcciones <span class="badge">42</span></a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Otras configuraciones</li>
                        <li><a href="#">Departamentos</a></li>
                        <li><a href="#">Telefonos SH</a></li>
                        <li><a href="#">Giros de empresa</a></li>
                        <li><a href="#">Etiquetas para telefonos</a></li>
                        <li><a href="#">Tipos de usuarios</a></li>
                    </ul>
                </li>
                <li><a href="logout">Cerrar sesi&oacute;n</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>