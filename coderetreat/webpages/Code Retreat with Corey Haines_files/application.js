$(function () {
  $('.read-more').click(function() {
    $('#' + $(this).attr('href')).toggle();
    return false;
  });
});
$(function() {
  var contact = $("#contact"),
    info = contact.find("#contact-info"),
    button = contact.find("#contact-btn");

  button.click(function(){
    info.slideToggle();
  });
});

