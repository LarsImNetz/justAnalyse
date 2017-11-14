/* jshint node: true */

var express = require("express");
var pjson = require("./package.json");

var app = express();

app.get("/apps/" + pjson.name + "/*", function(req, res) {
	res.redirect("/" + req.params[0]);
});

app.use(express.static(__dirname + "/app"));

var server = app.listen(3030, function() {
	console.log("Listening on port %d", server.address().port);
});
