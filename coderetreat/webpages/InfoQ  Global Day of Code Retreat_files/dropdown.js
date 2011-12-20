$(document).ready(function(){
	$('.dropdown-link').click(function(e){
		var link = $(this);
		e.preventDefault();
		link.next('.dropdown').toggle();
		link.parent().toggleClass('dropdown-active');
	});
	
});
