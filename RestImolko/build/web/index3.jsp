<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" language="text/javascript" type="text/javascript"></script>
<script language="text/javascript" type="text/javascript">

// Wrap everyting in this READY directive
$(document).ready(function () {

	//alert( 'You are running jQuery version: ' + $.fn.jquery );

	// When the button is clicked perform the AJAX request
	$('#trigger').click(function() {
		$('#userMsg').text("Sending JSON data..."); // update status of AJAX call

		/* Define AJAX Settings */
		var ajaxURL = "http://www.imolko.com/wordpress/sites/pruebasimolko/xmlrpc.php";
		var ajaxType = "POST";
		var ajaxAcceptedResponseFormat = "text/xml";
		var ajaxAcceptedResponseTxt = "text/plain";
		var ajaxResponseParseMethod = "json";

		var ajaxContentType = "application/x-www-form-urlencoded; charset=utf-8"; /* When JSON is being sent as a POST, this should be "application/x-www-form-urlencoded; charset=utf-8" (normally "application/j-son; charset=utf-8" is suggested for JSON).  With GET, it does not matter what this is set to. */
		var ajaxAsynchronous = true;
		var ajaxCache = false;
		var ajaxCrossDomain = false;

		/* While this uses an array, if you have contents of a form to send as json you could reference the form */
		var saveBook = new Object();
		saveBook.Title = "Book number 1";
		saveBook.RenderAs = "html";
		saveBook.Publisher = "Pub1";

		var ajaxDataToTarget = JSON.stringify(saveBook); /* Transforms the object into: {"Title":"Book number 1","RenderAs":"html","Publisher":"Pub1"} */
		ajaxDataToTarget = encodeURIComponent(ajaxDataToTarget); /* Transforms string to %7B%22Title%22%3A%22Book%20number%201%22%2C%22RenderAs%22%3A%22html%22%2C%22Publisher%22%3A%22Pub1%22%7D */

		var ajaxUseGlobalHandlers = false;
		var ajaxUsername = "pruebasimolko";
		var ajaxPassword = "123456";
		var ajaxTimeout = 5000;

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
		        ,converters: {"text json": jQuery.parseJSON}					/* Formats response - {"* text": window.String, "text html": true, "text json": jQuery.parseJSON, "text xml": jQuery.parseXML} */
		        ,crossDomain: ajaxCrossDomain							/* Setting to true allows cross domain requests on the same domain and server-side redirection to another domain */
			,data: ({datasnd: ajaxDataToTarget})						/* Data to send to the target which is appended to the URL for GET requests as name/value pairs like { name: "John", location: "Boston" } or XML like var xmlDocument = [create xml document here]; declared outside the block of code and data: having a value of xmlDocument */
		        ,dataType: ajaxResponseParseMethod						/* "xml": Returns a XML document that can be processed via jQuery, "html": Returns HTML as plain text; included script tags are evaluated when inserted in the DOM, "script": Evaluates the response as JavaScript and returns it as plain text, "json": Evaluates the response as JSON and returns a JavaScript object, "jsonp": Loads in a JSON block using JSONP, "text": A plain text string */
		        ,global: ajaxUseGlobalHandlers							/* true - allows global ajax event handlers to be used for request, false - no...we are handling it in the .ajax below */
		        ,ifModified: false								/* true - allow request success if response has changed since last request, false - ignore */
		        ,username: ajaxUsername								/* username to be used in response to a http authentication request */
		        ,password: ajaxPassword								/* password to be used in response to a http authentication request */
		        ,timeout: ajaxTimeout								/* Number of milliseconds to wait for a response from the target */
	      	      })
	      .done(
		    /* Parse the data response */
		    function(data) {
				    var bookTitle = "", bookRenderAs = "", bookPublisher = "";
				    bookTitle = data.Title;
				    bookRenderAs = data.RenderAs;
				    bookPublisher = data.Publisher;
				    haveExpectedFormat = 1; 
				    haveExpectedResponse = 1;
				    alert("Title = " + bookTitle + "\nRenderAs = " + bookRenderAs + "\nPublisher = " + bookPublisher);
//				    /* This is longer but steps through the returned JSON */
//				    $(data).each(function(i, val) {
//								   $.each(val, function(name, value) {
//												      alert("name = " + name + "\nvalue = " + value);
//												     } /* End Function */
//									 ) /* End Each */
//								  } /* End Function */
//
//						) /* End Each */
				   } /* End Function */
		   )
	      .fail(
		    function(data) {
				    $('#userMsg').text("Loading JSON data response failed with >> " + data.statusText + ".");
				   }
		   )
	      .always(
		      function(data) {
				      /* Check to ensure that we received an JSON response and with the expected elements */
				      if (haveExpectedFormat === 1) {
								     if (haveExpectedResponse === 0) {
												      $('#userMsg').text("JSON was returned but not in the expected format.");
												     }
								     else { $('#userMsg').text("Loading JSON data response completed."); }
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
				     } /* End Function */
		     )
		; /* End AJAX Work */

	}); /* End Button Click */

}); /* End document.ready */

</script>
</head>
<body>
Send some JSON data to an external source.  <input type="button" value="Click Here" id="trigger" /> <div id="userMsg" />
</body>
</html>