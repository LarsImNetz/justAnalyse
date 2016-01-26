'use strict';

// http://stackoverflow.com/questions/9899372/pure-javascript-equivalent-to-jquerys-ready-how-to-call-a-function-when-the
$(document).ready(function() {

	var cookieValidation = "cookie-line";
	var cookieValidationLayer = cookieValidation + "__layer";
	var cookieValidationLayerInner = cookieValidationLayer + "-inner";
	var cookieValidationLayerOk = cookieValidationLayer + "-ok";
	
	$("head").append(
	    $("<style></style>").text(
	    "." + cookieValidationLayer + "{"
		+"box-sizing: border-box;"
	    +"margin:0;"
	    +"color:#666;"
	    +"background-color:#f4f4f4;"
	    +"box-shadow: 0 0 10px rgba(0,0,0,.5);"
	    +"z-index:11;"
	    +"line-height:20px;"
	    +"position:fixed;"
	    +"bottom:0;"
	    +"left:0;"
	    +"right:0;"
	    +"display:none;"
	    +"}"
	    
		+ "." + cookieValidationLayer +" p {"
		+"margin: 0px;"
	    +"padding: 0px 50px 0px 0px;"
	    +"font-size:11px;"
	    +"font-family: Verdana,Helvetica,Arial,sans-serif;"
		+"}"
		+ "." + cookieValidationLayer + " a {"
		+"margin: 0px;"
	    +"padding: 0px 0px 0px 0px;"
	    +"font-size:11px;"
	    +"font-family: Verdana,Arial,sans-serif;"		
		+"}"

		+"@media only screen and (min-width: 47.8125em)"
		+"." + cookieValidationLayerInner + " {"
		+"padding-left: 30px;"
    	+"padding-right: 30px;"
    	+"padding-bottom: 15px;"
		+"}"

	    +"." + cookieValidationLayerInner + " {"
	    +"max-width: 1020px;"
	    +"margin: 0 auto;"
	    +"position: relative;"
	    +"padding: 15px 15px 15px;"
	    +"}"
	    
	    +"@media only screen and (min-width: 47.8125em)"
		+"." + cookieValidationLayerOk + " {"
	    +"text-indent: 0;"
	    +"padding-right: 20px;"
	    +"width: auto;"
	    +"height: auto;"
	    +"background-size: 10px 10px;"
	    +"background-position: right 50%;"
	    +"right: 15px;"
	    +"bottom: 15px;"
		+"}"

	    +"." + cookieValidationLayerOk + " {"
	    +"text-decoration:underline;"
		+"}"
		
	    +"." + cookieValidationLayerOk + " {"
	    +"cursor: pointer;"
	    +"position: absolute;"
	    +"bottom: 0;"
	    +"right:0;"
	    +"width: 40px;"
	    +"height: 36px;"
	    +"text-indent: 0;"
	    +"}" )
	);
	
	var cookieName = "Ich_bin_damit_einverstanden_das_www.vergleich.de_Cookies_verwendet.";
	var cookieExpireDays = 365;
	
	var cookieLineMarkup = $("<div class=\"" + cookieValidationLayer + "\" style=\"display: block;\"></div>")
	.append(
		$("<div class=\"" + cookieValidationLayerInner + "\"></div>")
		.append(
			$("<p></p>")
				.append("www.vergleich.de verwendet Cookies, um Ihre Benutzererfahrung zu verbessern. Wenn Sie auf der Seite weitersurfen, stimmen Sie der ")
				.append("<a href=\"//www.vergleich.de/informationen/ueber-vergleichde/datenschutz.html\">Cookie-Nutzung</a>")
				.append(" zu.")
				)
			 .append("<a class=\"" + cookieValidationLayerOk + "\">OK</a>").click(function(){
				$("." + cookieValidationLayer ).removeAttr("style");
				Cookies.set(cookieName, 1, { expires: cookieExpireDays } );
			 })
			);

	// Cookies.remove(cookieName);

	var cookieValue = Cookies.get(cookieName);
	if (cookieValue != 1) {
		$("body").append("<div class=\"impressum-must-be-visible\"></div>").append( cookieLineMarkup );
		var height = $( "."+cookieValidationLayer ).height();
		$(".impressum-must-be-visible").css("height", height);
	}
 });
