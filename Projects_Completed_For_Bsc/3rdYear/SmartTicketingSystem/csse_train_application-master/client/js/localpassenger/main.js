$(function() {
  var $inspectors = $("#inspectors");

  //Get Inspectors
  $.ajax({
    type: "GET",
    url: "localhost:3000/practise",
    success: function(inspectors) {
      $.each(inspectors, function(i, inspector) {
        $inspectors.append("<li>name:</li>");
      });
    },
    error: function() {
      alert("Error loading available Inspectors");
    }
  });
});