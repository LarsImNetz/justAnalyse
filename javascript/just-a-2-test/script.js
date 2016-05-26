// Code goes here
$(document).ready(function() {

  $(".title").fadeOut(500);
  $(".title").fadeIn(1000);

  var text = $(".text").text();

  var firstletter = text.charAt(0);
  if (firstletter === 'T') {
    firstletter = 'Es ist ein Te.';
  }
  var newtext = text.replace("simple", "stupid");
  $(".text").text(newtext);
});