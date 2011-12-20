var Tracker = {
	trackVcrImpressions : true,
	trackPresentationDisplay : true,
	trackTaxonomyImpressions : true,
	trackAuthorImpressions : true,
	trackForgotPasswordSteps : true,
	trackContentBookmarking : true,
	trackUserRegistered : true,
	trackUserPrefs : true,
	
	doTrackVcrImpressions : function() {
		if(!Tracker.trackVcrImpressions) {
			return;
		}
		$(".f_vcrbottom").each(
			function doTrack(index) {
				var vcr = jQuery.parseJSON($(this).attr("jsh"));
				_gaq.push(["_trackEvent", "VCRImpression-"+vcr.id, $(location).attr("href"), "bottom"]);
			}
		);
		$(".f_vcrembed").each(
			function doTrack(index) {
				var vcr = jQuery.parseJSON($(this).attr("jsh"));
				_gaq.push(["_trackEvent", "VCRImpression-"+vcr.id, $(location).attr("href"), "embedded"]);
			}
		);
	},
	
	doTrackPresentationDefaultDisplay : function() {
		if(!Tracker.trackPresentationDisplay) {
			return;
		}
		jsonResolutions = "{\"SCR\":\""+screen.width+"x"+screen.height+"\",\"VPR\":\""+$(window).width()+"x"+$(window).height()+"\"}";		
		// check if we are on a presentation.
		if($("#presentationContent").length > 0){
			_gaq.push(["_trackEvent", "Presentation display", "default", jsonResolutions]);
		}
	},
	
	doTrackPresentationDisplayChange : function(type) {
		if(!Tracker.trackPresentationDisplay) {
			return;
		}		
		jsonResolutions = "{\"SCR\":\""+screen.width+"x"+screen.height+"\",\"VPR\":\""+$(window).width()+"x"+$(window).height()+"\"}";
		_gaq.push(["_trackEvent", "Presentation display", type, jsonResolutions]);
		
	},
	
	doTrackContentBookmark : function(action, label) {		
		if(!Tracker.trackContentBookmarking) {
			return;
		}		
		_gaq.push(['_trackEvent', 'Bookmarks', action, label]);
		
	},
	
	doTrackUserRegistered : function(type) {		
		if(!Tracker.trackUserRegistered) {
			return;
		}		
		_gaq.push(['_trackEvent', 'userregistered', type]);
		
	},
	
	doTrackUserPrefs : function(type) {		
		if(!Tracker.trackUserPrefs) {
			return;
		}		
		_gaq.push(['_trackEvent', 'userprefs', type]);
		
	},	
	
	doTrackTaxonomyImpressions : function() {
		if(!Tracker.trackTaxonomyImpressions) {
			return;
		}

		if($(".f_taxonomy").length > 0) {
			// track taxonomy impressions via events
			var categories = "";
			$(".f_taxonomy").each(
					function doTrack(index) {
						var catName = $(this).attr("name");
						if(categories == "") {
							categories = "|";
						}
						categories = categories + catName + "|";
					}
			);
			var pageUrl = $(location).attr("href");
			var pageTitle = document.title;
			if(categories != "") {
				_gaq.push(["_trackEvent", "TAXONOMYIMPRESSION", "TAXONOMYIMPRESSION~"+categories, "TAXONOMYIMPRESSION~"+pageUrl + "~" + pageTitle]);
			}
			
			// track taxonomy impressions via ecommerce
			var orderId = new Date().getTime();
			_gaq.push(["_addTrans",
			           orderId, // order ID - required
			           "TAXONOMYIMPRESSION~"+orderId, // affiliation or store name
			           "1",        // total - required
			           "",         // tax
			           "",         // shipping
			           "",         // city
			           "",         // state or province
			           ""          // country
			        ]);
			$(".f_taxonomy").each(
					function doTrack(index) {
						var catName = $(this).attr("name");
						_gaq.push(["_addItem",
						           orderId,                     	// order ID - necessary to associate item with transaction
						           "TAXONOMYIMPRESSION~"+catName,   // SKU/code - required
						           "TAXONOMYIMPRESSION~"+pageUrl,   // product name
						           "",               				// category or variation
						           "1",                         	// unit price - required
						           "1"                          	// quantity - required
						        ]);
					}
			);
			_gaq.push(["_trackTrans"]);
		}
	},

	doTrackAuthorImpressions : function() {
		if(!Tracker.trackAuthorImpressions) {
			return;
		}
		var authorName = "";
		$(".f_taxonomyEditor").each(
				function doTrack(index) {
					if(index > 0) {
						authorName = authorName + ","; 
					}
					authorName = authorName + jQuery.trim($(this).html());
				}
		);
		if(authorName=="") {
			return;
		}
		else {
			authorName = "AUTHOR-" + authorName;
		}
		var translatorName = "";
		$(".f_taxonomyTranslator").each(
				function doTrack(index) {
					if(index > 0) {
						translatorName = translatorName + ","; 
					}
					translatorName = translatorName + jQuery.trim($(this).html());
				}
		);
		if(translatorName != "") {
			authorName = authorName + "~TRANSLATOR-" + translatorName;
		}
		var pageUrl = $(location).attr("href");
		_gaq.push(["_trackEvent", "AUTHORIMPRESSION", "AUTHORIMPRESSION~"+authorName, "AUTHORIMPRESSION~"+pageUrl]);
	},
	
	doTrackForgotPasswordSteps : function(step) {
		if(!Tracker.trackForgotPasswordSteps) {
			return;
		}
		_gaq.push(["_trackEvent", "Forgot password", step, ""]);
	},
	
	safeExec: function(f) {
		try {
			f();
		}
		catch(ex) {
			if(window.console && window.console.log) {
				window.console.log(ex);
			}
		}
	}
};