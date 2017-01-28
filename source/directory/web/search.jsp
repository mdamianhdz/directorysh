<%-- 
    Document   : search
    Created on : 11/09/2016, 09:55:08 PM
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
            <div class="col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10">

                <div class="panel panel-primary">
                    <div class="panel-heading center">20 resultados para la busqueda de "${requestScope.value}"</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default.png" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default.png" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default.png" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default.png" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil" class="img-rounded">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="panel panel-info">
                <div class="panel-heading center">Adicionalmente se han encontrado 20 sugerencias de contactos :)</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4 col-md-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-3">
                            <div class="thumbnail">
                                <img src="images/default-photo.jpg" alt="Foto de perfil">
                                <div class="caption center">
                                    <h3>Thumbnail label</h3>
                                    <p>Contacto</p>
                                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div><!--//Panel content-->
        <jsp:include page="template/simple/footer.jsp"></jsp:include>
    </body>
</html>
