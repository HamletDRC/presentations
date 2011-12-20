$(function(){	
	iehover();	
});


// IE6 dropdown Nav
function iehover()
{
	if(jQuery.browser.msie)
	{
		jQuery("ul.view-type li").hover(
			function()
			{
				jQuery(this).addClass("hover");
				jQuery("select").css("display", "none");
			},
			function()
			{
				jQuery(this).removeClass("hover");
				jQuery(this).css("zIndex","5000");
				jQuery("select").css("display", "block");

			}
		);
		jQuery("ul.view-type li.hover ul li").hover(
			function()
			{
				jQuery(this).addClass("hover");
				jQuery(this).css("zIndex","5000");
				jQuery("select").css("display", "none");
			},
			function()
			{
				jQuery(this).removeClass("hover");
				jQuery(this).css("zIndex","5000");
				jQuery("select").css("display", "block");
			}
		);
		
		jQuery(".navigation ul li").hover(
			function()
			{
				jQuery(this).addClass("hover");
				jQuery("select").css("display", "none");
			},
			function()
			{
				jQuery(this).removeClass("hover");
				jQuery(this).css("zIndex","5000");
				jQuery("select").css("display", "block");

			}
		);
	}
}