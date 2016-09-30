<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" language="text/javascript" type="text/javascript"></script>
<script language="text/javascript" type="text/javascript">

// Wrap everyting in this READY directive
$(document).ready(function () {

	//alert( 'You are running jQuery version: ' + $.fn.jquery );

	// When the button is clicked perform the AJAX request
	$('#trigger').click(function() {
		$('#userMsg').text("Authenticating and Sending XML data..."); // update status of AJAX call

		/* Define AJAX Settings */
		var ajaxURL = "http://www.imolko.com/wordpress/sites/pruebasimolko/xmlrpc.php";
		var ajaxType = "POST";
		var ajaxAcceptedResponseFormat = "text/xml";
		var ajaxAcceptedResponseTxt = "text/plain";
                var ajaxAcceptedResponseTxt = "application/json";
		var ajaxResponseParseMethod = "xml";
		var ajaxContentType = "application/x-www-form-urlencoded; charset=UTF-8";
		var ajaxAsynchronous = false;
		var ajaxCache = false;
		var ajaxCrossDomain = false;
		var ajaxDataToTarget = "<methodCall><methodName>wp.getPost</methodName><params><!--id del blog de zenkiu correspondiente al usuario pruebasimolko--><param><value><string>8313</string></value></param><param><value><string>pruebasimolko</string></value></param><param><value><string>123456</string></value></param><param><!--id de la publicación, este id es la respuesta del ADD CONTENT--><value><string>25</string></value></param><param><value><struct><member><name>1</name><value><string>link</string></value></member></struct></value></param></params></methodCall>";
                alert(ajaxDataToTarget);
		var ajaxUseGlobalHandlers = false;
		/* Under windows server, a folder was setup with basic authentication on it.  Then a local user account (created on the server) was created and then given permissions to the folder.  NOTE: a domain account could be used as well. */
		var ajaxUsername = "pruebasimolko";
		var ajaxPassword = "123456";
		var ajaxTimeout = 10000;

		/* Required for Basic Authentication (HTTP 401 Challenge); jQuery not able to perform basic authentication with native .username and .password parameters */
		var basicAuthData = "";
		basicAuthData = "Basic " + btoa(ajaxUsername + ":" + ajaxPassword);
                
		/* Handle XML Response (in this example just getting back the XML that was sent to the server) */
		var haveRootNodeTag = "Info";
		var haveChildNodeTag = "Item";

		var haveExpectedFormat = 0;
		var haveExpectedResponse = 0;
		var haveNonExpected = "";
		var haveRawResponse = 0;
		var haveRawResponseData = "";

		/* Begin AJAX Work */
		$.ajax({
		        accepts: {xml: ajaxAcceptedResponseFormat, text: ajaxAcceptedResponseTxt}	/* Accepted response data from the target */
		        ,global: false									/* Do not use global callback functions */
		        ,type: ajaxType									/* HEAD/GET/POST/DELETE */
		        ,contentType: ajaxContentType							/* Default content type */
		        ,url: ajaxURL									/* Target URL */
		        ,async: ajaxAsynchronous							/* if false, may lock browser until response is received */
		        ,cache: ajaxCache								/* true - will cache URL data returned; false - will not cache URL data but only for HEAD AND GET requests */
		        ,converters: {"text xml": jQuery.parseXML}					/* Formats response - {"* text": window.String, "text html": true, "text json": jQuery.parseJSON, "text xml": jQuery.parseXML} */
		        ,crossDomain: ajaxCrossDomain							/* Setting to true allows cross domain requests on the same domain and server-side redirection to another domain */
		        ,data: ({datasnd: ajaxDataToTarget})						/* Data to send to the target which is appended to the URL for GET requests as name/value pairs like { name: "John", location: "Boston" } or XML like var xmlDocument = [create xml document here]; declared outside the block of code and data: having a value of xmlDocument */
		        ,dataType: ajaxResponseParseMethod						/* "xml": Returns a XML document that can be processed via jQuery, "html": Returns HTML as plain text; included script tags are evaluated when inserted in the DOM, "script": Evaluates the response as JavaScript and returns it as plain text, "json": Evaluates the response as JSON and returns a JavaScript object, "jsonp": Loads in a JSON block using JSONP, "text": A plain text string */
		        ,global: ajaxUseGlobalHandlers							/* true - allows global ajax event handlers to be used for request, false - no...we are handling it in the .ajax below */
		        ,ifModified: false								/* true - allow request success if response has changed since last request, false - ignore */
		        ,username: ajaxUsername								/* username to be used in response to a http authentication request - useless with Basic Authentication on Windows IIS7 */
		        ,password: ajaxPassword								/* password to be used in response to a http authentication request - useless with Basic Authentication on Windows IIS7 */
		        ,timeout: ajaxTimeout								/* Number of milliseconds to wait for a response from the target */
			,beforeSend: function(me) {
			me.setRequestHeader('Authorization ', basicAuthData);				/* Basic Authentication method required for Windows IIS7 */
						  }
	      	      })
	      .done(
		    /* Parse the data response */
		    function(data) {
				    /* Go through the root node */
				    $(data).find(haveRootNodeTag).each(function() {
										   haveExpectedFormat = 1;
										   /* Iterate through each child node */
										   $(this).find(haveChildNodeTag).each(function() {
																   /* Grab the element name and description */
																   haveExpectedResponse = 1;
																   alert("Title = " + $(this).find("Title").text() + "\nDescription = " + $(this).find("Description").text());
																  } /* End Function */
														       ); /* End Each */
										   } /* End Function */
								    ); /* End Each */
				   } /* End Function */
		   )
	      .fail(
		    function(data) {
				    $('#userMsg').text("Loading XML data response failed with >> " + data.statusText + ".");
				   }
		   )
	      .always(
		      function(data) {
				      /* Check to ensure that we received an XML response and with the expected elements */
				      if (haveExpectedFormat === 1) {
								     if (haveExpectedResponse === 0) {
												      $('#userMsg').text("XML was returned but not in the expected format.");
												     }
								     else { $('#userMsg').text("Loading XML data response completed."); }
								    }
				      else {
					    /* More checking for non-expected response such as server error/message page */
					    haveRawResponseData = data.responseText.toLowerCase();
					    if (haveRawResponseData.indexOf("<title") !== -1) {
												haveNonExpected = haveRawResponseData.split("<title>")[1].split("</title>")[0];
											      }
					    /* Inform the user and grab the raw response with any accompanying tags and markup */
					    if (haveNonExpected.length === 0) { haveNonExpected = "An unknown data response was received >> " + haveRawResponseData; }
					    else { haveNonExpected = "A data response of \"" + haveNonExpected + "\" was received >> " + haveRawResponseData; }
					    $('#userMsg').text(haveNonExpected);
					   }
				     }
		     )
		; /* End AJAX Work */

	}); /* End Button Click */

}); /* End document.ready */

</script>
</head>
<body>
Authenticate to a location on a website, then send XML and get a response.  <input type="button" value="Click Here" id="trigger" /> <div id="userMsg" />
</body>
</html>

