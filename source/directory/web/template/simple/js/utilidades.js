var xhr;
function ObjetoAJAX() {

    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    }
    else if ((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined) {
        xhr = new XMLHttpRequest();
    }
    else {
        xhr = null;
    }

    this.enviar = m_enviar;
    this.respuestaTexto = m_texto;
    this.respuestaXML = m_XML;
    this.obtenerEncabezados = m_encabezados;
    this.estado = m_estado;
    this.textoEstado = m_textoEstado;

    function m_enviar(url, method, funcionRetorno, objForm) {
        console.info("Dentro de enviar");
        var dataSend = null;
        if (method.toLowerCase() == "post" && objForm != null) {
            dataSend = obtenerDatos(objForm);
           // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        }
        else if (method.toLowerCase() == "get" && objForm != null) {
            dataSend = obtenerDatos(objForm);
            if (url.indexOf("?") == -1) {
                url += "?" + dataSend;
            }
            else {
                url += "&" + dataSend;
            }
        }
        //realiza siempre la petición en modo
        //asíncrono
        
        console.info("Dentro de enviar, antes de open");
        xhr.open(method, url, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                eval(funcionRetorno + "(" + ")");
            }
        };
        xhr.send(dataSend);
        console.info("Dentro de enviar, despues de send");
    }
    function m_texto() {
        return xhr.responseText;
    }
    function m_XML() {
        return xhr.responseXML;
    }
    function m_encabezados() {
        return xhr.getAllResponseHeaders();
    }
    function m_estado() {
        return xhr.status;
    }
    function m_textoEstado() {
        return xhr.statusText;
    }
    function obtenerDatos(objForm) {
        var controles = objForm.elements;
        var datos = new Array();
        var cad = "";
        for (var i = 0; i < controles.length; i++) {
            cad = encodeURIComponent(controles[i].name) + "=";
            cad += encodeURIComponent(controles[i].value);
            datos.push(cad);
        }
        //se forma la cadena con el método join() del array
        //para evitar múltiples concatenaciones
        cad = datos.join("&");
        return cad;
    }
}























