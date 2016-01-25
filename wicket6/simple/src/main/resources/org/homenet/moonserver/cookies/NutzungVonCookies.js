
// http://stackoverflow.com/questions/9899372/pure-javascript-equivalent-to-jquerys-ready-how-to-call-a-function-when-the
 $(document).ready(function() {

	$("head").append(
	    $("<style></style>").text(
	    ".data-protection__layer{"
		+"box-sizing: border-box;"
	    +"margin:0;"
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
	    
		+".data-protection__layer p {"
		+"margin: 0px;"
	    +"padding: 0px 50px 0px 0px;"
	    +"font-size:11px;"
	    +"font-family: Verdana,Arial,sans-serif;"		
		+"}"
		+".data-protection__layer a {"
		+"margin: 0px;"
	    +"padding: 0px 0px 0px 0px;"
	    +"font-size:11px;"
	    +"font-family: Verdana,Arial,sans-serif;"		
		+"}"

		+"@media only screen and (min-width: 47.8125em)"
		+".data-protection__layer-inner {"
		+"padding-left: 30px;"
    	+"padding-right: 30px;"
    	+"padding-bottom: 15px;"
		+"}"

	    +".data-protection__layer-inner {"
	    +"max-width: 1020px;"
	    +"margin: 0 auto;"
	    +"position: relative;"
	    +"padding: 15px 15px 15px;"
	    +"}"
	    
	    +"@media only screen and (min-width: 47.8125em)"
		+".data-protection__layer-ok {"
	    +"text-indent: 0;"
	    +"padding-right: 20px;"
	    +"width: auto;"
	    +"height: auto;"
	    +"background-size: 10px 10px;"
	    +"background-position: right 50%;"
	    +"right: 15px;"
	    +"bottom: 15px;"
		+"}"

	    +".data-protection__layer-ok {"
	    +"text-decoration:underline;"
		+"}"
		
	    +".data-protection__layer-ok {"
	    +"cursor: pointer;"
	    +"position: absolute;"
	    +"bottom: 0;"
	    +"right:0;"
	    +"width: 40px;"
	    +"height: 36px;"
	    +"text-indent: 0;"
	    +"}" )
	);
	
	var dataProtection = $("<div class=\"data-protection__layer\" style=\"display: block;\"></div>")
	.append(
		$("<div class=\"data-protection__layer-inner\"></div>")
		.append(
			$("<p></p>")
				.append("www.vergleich.de verwendet Cookies, um Ihre Benutzererfahrung zu verbessern. Wenn Sie auf der Seite weitersurfen, stimmen Sie der ")
				.append("<a href=\"//www.vergleich.de/informationen/ueber-vergleichde/datenschutz.html\">Cookie-Nutzung</a>")
				.append(" zu.")
				)
			 .append("<a class=\"data-protection__layer-ok\">OK</a>").click(function(){
				$(".data-protection__layer").removeAttr("style");
			 })
			);
	$(".data-protection__layer-ok");

	$( "body" ).append( dataProtection );
 });
