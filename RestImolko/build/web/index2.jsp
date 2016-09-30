
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" language="text/javascript" type="text/javascript"></script>
        <script language="text/javascript" type="text/javascript">

                    $(document).ready(function () {

                    // Cuando pulso el botón se envía la petición (sólo para probar, al pasar a producción se debe quitar)
            $('#trigger').click(function() {
                            $('#userMsg').text("Enviando XML data..."); 

                            /* Define AJAX Settings */
                            var ajaxURL = "http://www.imolko.com/wordpress/sites/pruebasimolko/xmlrpc.php";
                            var ajaxType = "POST";
                            var ajaxAcceptedResponseFormat = "text/xml";                     
                            var ajaxAcceptedResponseTxt = "text/plain";
                            var ajaxResponseParseMethod = "xml";
                            //var ajaxContentType = "application/x-www-form-urlencoded; charset=UTF-8";
                            var ajaxContentType = "text/xml";
                            var ajaxAsynchronous = true;
                            var ajaxCache = false;
                            var ajaxCrossDomain = false;
                            var ajaxDataToTarget = ("<methodCall><methodName>wp.getPost</methodName><params><!--id del blog de zenkiu correspondiente al usuario pruebasimolko--><param><value><string>8313</string></value></param><param><value><string>pruebasimolko</string></value></param><param><value><string>123456</string></value></param><param><!--id de la publicación, este id es la respuesta del ADD CONTENT--><value><string>25</string></value></param><param><value><struct><member><name>1</name><value><string>link</string></value></member></struct></value></param></params></methodCall>");
                            var ajaxUseGlobalHandlers = false;
                            var ajaxUsername = "pruebasimolko";
                            var ajaxPassword = "123456";
                            var ajaxTimeout = 5000;
                            var haveRootNodeTag = "Info";
                            var haveChildNodeTag = "Item";
                            var haveExpectedFormat = 0;
                            var haveExpectedResponse = 0;
                            var haveNonExpected = "";
                            var haveRawResponse = 0;
                            var haveRawResponseData = "";
                            /* Inicio el trabajo del AJAX */
                            $.ajax({
                            accepts: {xml: ajaxAcceptedResponseFormat, text: ajaxAcceptedResponseTxt}	
                            , global: false									
                                    , type: ajaxType									
                                    , contentType: ajaxContentType							
                                    , url: ajaxURL									
                                    , async: ajaxAsynchronous							
                                    , cache: ajaxCache								
                                    , converters: {"text xml": jQuery.parseXML}					
                            , crossDomain: ajaxCrossDomain							
                                    , data: ({datasnd: ajaxDataToTarget})						
                                    , dataType: ajaxResponseParseMethod						
                                    , global: ajaxUseGlobalHandlers						
                                    , ifModified: false								
                                    , username: ajaxUsername							
                                    , password: ajaxPassword							
                                    , timeout: ajaxTimeout	
                            })
                            .done(
                                    /* Parseando la date recibida */
                                            function(data) {
                                            $(data).find(haveRootNodeTag).each(function() {
                                            haveExpectedFormat = 1;
                                                    $(this).find(haveChildNodeTag).each(function() {
                                            haveExpectedResponse = 1;
                                                    alert("URL = " + $(this).find("link").text() + "\nID = " + $(this).find("string").text());
                                            } /* Fin Función */
                                            ); /* Fin Each */
                                            } /* Fin Función  */
                                            ); /* Fin Each */
                                            } /* Fin Función  */
                                    )
                                            .fail(
                                                    function(data) {
                                                    $('#userMsg').text("La carga falló por >> " + data.statusText + ".");
                                                    }
                                            )
                                            .always(
                                                    function(data) {
                                                    if (haveExpectedFormat === 1) {
                                                    if (haveExpectedResponse === 0) {
                                                    $('#userMsg').text("El XML tiene formato incorrecto");
                                                    }
                                                    else { $('#userMsg').text("Carga completa"); }
                                                    }
                                                    else {
                                                  
                                                    haveRawResponseData = data.responseText.toLowerCase();
                                                    if (haveRawResponseData.indexOf("<title") !== -1) {
                                                                                                        haveNonExpected = haveRawResponseData.split("<title>")[1].split("</title>")[0];
                                                                                                      }
                                                    if (haveNonExpected.length === 0) { haveNonExpected = "An unknown data response was received >> " + haveRawResponseData; }
                                                    else { haveNonExpected = "A data response of \"" + haveNonExpected + "\" was received >> " + haveRawResponseData; }
                                                    $('#userMsg').text(haveNonExpected);
                                                   }
                                             }
                             )
                        ; 

                }); 

        }); 

        </script>
    </head>
    <body>
        Enviar data a Imolko: <input type="button" value="Enviar" id="trigger" /> <div id="userMsg" />
    </body>
</html>