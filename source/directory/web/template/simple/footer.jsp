
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" tabindex="-1" role="dialog" id="addDirectCall" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">Registrar llamada directa <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></h4>
            </div>
            <form class="form-signin" name="frmDirectCall" id="signin" action="CallDirect" method="get">
                <div class="modal-body">
                    <br/>
                    <div class="row" id="resultado">   
                    </div>
                    <div class="row form-group">
                        <label for="descriptions" class="col-sm-offset-1 col-sm-3 control-label">Descripcion de numero: *</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="descriptions" name="descriptions">
                                <c:if test="${not empty descriptions}">
                                    <c:forEach items="${sessionScope.descriptions}" var="oDescrip" >
                                        <option value="${oDescrip.id}">${oDescrip.name} </option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="number" class="col-sm-offset-1 col-sm-3 control-label">Numero: *</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="numberP" name="numberP" placeholder="Ingresa un numero de telefono" required="true">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="localnumber" class="col-sm-offset-1 col-sm-3 control-label">Realizada con: *</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="localnumber" name="localnumber">
                                <c:if test="${not empty localphones}">
                                    <c:forEach items="${sessionScope.localphones}" var="oLocP" >
                                        <option value="${oLocP.id}">${oLocP.description.name} : ${oLocP.number}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="requested" class="col-sm-offset-1 col-sm-3 control-label">Solicita: *</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="requested" name="requested" placeholder="Ingresa nombre de solicitante" required="true">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="comments" class="col-sm-offset-1 col-sm-3 control-label">Observaciones:</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="comments" name="comments" placeholder="Observaciones de llamada">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="row" id="buttonsEnd">
                        <div class="col-sm-offset-1 col-sm-2">
                            <br/>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>
                        <div class="col-sm-offset-1 col-sm-7">
                            <div class="row" >
                                <div class="col-sm-12 text-center">
                                    Llamada realizada?
                                </div>
                                <div class="col-sm-3">
                                    <button type="button" id="successBtn" class="btn btn-success btn-block">Si</button>
                                </div>
                                <div class="col-sm-3">
                                    <button type="button" id="successBtn2" class="btn btn-danger btn-block" data-toggle="tooltip" data-placement="top" title="No contestan o  cualquier causa que haya provocado que no se realizara la llamada">No</button>
                                </div>
                                <div class="col-sm-6">
                                    <button type="button" id="successBtn3" class="btn btn-warning btn-block" data-toggle="tooltip" data-placement="top" title="Llamada pendiente por realizar">Pendiente</button>
                                </div>
                                <input type="hidden" id="calldone" name="calldone" value="" />
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
    function openModal() {
        $('#addDirectCall').modal('show');
    }

    $('#addDirectCall').on('hidden.bs.modal', function(e) {
        document.getElementById("numberP").value = "";
        document.getElementById("localnumber").selectedIndex = 0;
        document.getElementById("requested").value = "";
        document.getElementById("comments").value = "";
        document.getElementById("resultado").innerHTML = "";
        var block = "<div class='col-sm-offset-1 col-sm-2'>" +
                "<br/>" +
                "<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>" +
                "</div>" +
                "<div class='col-sm-offset-1 col-sm-7'>" +
                "<div class='row' >" +
                "<div class='col-sm-12 text-center'>" +
                "Llamada realizada?" +
                "</div>" +
                "<div class='col-sm-3'>" +
                "<button type='button' id='successBtn' class='btn btn-success btn-block'>Si</button>" +
                "</div>" +
                "<div class='col-sm-3'>" +
                "<button type='button' id='successBtn2' class='btn btn-danger btn-block' data-toggle='tooltip' data-placement='top' title='No contestan o  cualquier causa que haya provocado que no se realizara la llamada'>No</button>" +
                "</div>" +
                "<div class='col-sm-6'>" +
                "<button type='button' id='successBtn3' class='btn btn-warning btn-block' data-toggle='tooltip' data-placement='top' title='Llamada pendiente por realizar'>Pendiente</button>" +
                "</div>" +
                "<input type='hidden' id='calldone' name='calldone' value='' />" +
                "</div>" +
                "</div>";
        document.getElementById("buttonsEnd").innerHTML = block;
        console.info("Antes de reinciar callDone");
        document.getElementById("calldone").value = "";
        console.info("Despues de reiniciar callDone")

        $(function() {
            $('#successBtn').on('click', function(e) {
                document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
                document.getElementById("calldone").value = "t";
                obj = new ObjetoAJAX();
                var oForm = document.forms["frmDirectCall"];
                obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
            });
        });

        $(function() {
            $('#successBtn2').on('click', function(e) {
                document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
                document.getElementById("calldone").value = "f";
                obj = new ObjetoAJAX();
                var oForm = document.forms["frmDirectCall"];
                obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
            });
        });

        $(function() {
            $('#successBtn3').on('click', function(e) {
                document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
                document.getElementById("calldone").value = "p";
                obj = new ObjetoAJAX();
                var oForm = document.forms["frmDirectCall"];
                obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
            });
        });

    });
</script>

<script src="template/simple/js/utilidades.js" language="javascript"></script>
<script>

    var obj;
    $(function() {
        $('#successBtn').on('click', function(e) {
            document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
            document.getElementById("calldone").value = "t";
            obj = new ObjetoAJAX();
            var oForm = document.forms["frmDirectCall"];
            obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
        });
    });

    $(function() {
        $('#successBtn2').on('click', function(e) {
            document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
            document.getElementById("calldone").value = "f";
            obj = new ObjetoAJAX();
            var oForm = document.forms["frmDirectCall"];
            obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
        });
    });

    $(function() {
        $('#successBtn3').on('click', function(e) {
            document.getElementById("resultado").innerHTML = "<img src='images/loading_spinner.gif' width=100 height=100 alt='' class='img-rounded'>";
            document.getElementById("calldone").value = "p";
            obj = new ObjetoAJAX();
            var oForm = document.forms["frmDirectCall"];
            obj.enviar(oForm.action, oForm.method, "procesaResultado", oForm);
        });
    });

    function procesaResultado() {
        if (obj.estado() == 200) {
            //document.getElementById("resultado").innerHTML = obj.respuestaTexto();
            console.info(obj.respuestaTexto().trim());
            var contentResponse = obj.respuestaTexto().trim().split("&");
            var success = contentResponse[0];
            var message = contentResponse[1];
            var messageType = contentResponse[2];
            var alert = "<div class='alert " + messageType + " alert-dismissible col-sm-offset-2 col-sm-8' role='alert'>\n\
                <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>\n\
                </button>" + message + "</div>";
            if (success == "true") {
                document.getElementById("buttonsEnd").innerHTML =
                        "<div class='col-sm-offset-3 col-sm-4'><button type='button' " +
                        "class='btn btn-default' data-dismiss='modal'>Cerrar</button></div>";
                console.info(obj.obtenerEncabezados().trim());
            } else {
                console.info("[" + obj.respuestaTexto() + "]");
            }
            document.getElementById("resultado").innerHTML = alert;
        } else {
            alert(obj.textoEstado());
        }
    }
</script>