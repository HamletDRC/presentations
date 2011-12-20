function insertBanner( bannerJson ) {
	jQuery( 'div#centralNotice' ).prepend( bannerJson.bannerHtml );
	if ( bannerJson.autolink ) {
		var url = 'https://wikimediafoundation.org/wiki/Special:LandingCheck';
		if ( ( bannerJson.landingPages !== null ) && bannerJson.landingPages.length ) {
			targets = String( bannerJson.landingPages ).split(',');
			url += "?" + jQuery.param( {
				'landing_page': targets[Math.floor( Math.random() * targets.length )].replace( /^\s+|\s+$/, '' )
			} );
			url += "&" + jQuery.param( {
				'utm_medium': 'sitenotice', 'utm_campaign': bannerJson.campaign, 
				'utm_source': bannerJson.bannerName, 'language': wgUserLanguage, 
				'country': Geo.country
			} );
			jQuery( '#cn-landingpage-link' ).attr( 'href', url );
		}
	}
}
function hideBanner() {
	jQuery( '#centralNotice' ).hide(); // Hide current banner
	var bannerType = $.centralNotice.data.bannerType;
	if ( bannerType === undefined ) bannerType = 'default';
	setBannerHidingCookie( bannerType ); // Hide future banners of the same type
}
function setBannerHidingCookie( bannerType ) {
	var e = new Date();
	e.setTime( e.getTime() + (14*24*60*60*1000) ); // two weeks
	var work='centralnotice_'+bannerType+'=hide; expires=' + e.toGMTString() + '; path=/';
	document.cookie = work;
}
// This function is deprecated
function toggleNotice() {
	hideBanner();
}
var wgNoticeToggleState = (document.cookie.indexOf('hidesnmessage=1')==-1);

( function( $ ) {
	$.ajaxSetup({ cache: true });
	$.centralNotice = {
		'data': {
			'getVars': {},
			'bannerType': 'default'
		},
		'fn': {
			'loadBanner': function( bannerName, campaign, bannerType ) {
				// Store the bannerType in case we need to set a banner hiding cookie later
				$.centralNotice.data.bannerType = bannerType;
				// Get the requested banner
				var bannerPageQuery = $.param( { 
					'banner': bannerName, 'campaign': campaign, 'userlang': wgUserLanguage, 
					'db': wgDBname, 'sitename': wgSiteName, 'country': Geo.country
				} );
				var bannerPage = '?title=Special:BannerLoader&' + bannerPageQuery;
				var bannerScript = '<script type="text/javascript" src="//meta.wikimedia.org/w/index.php' + bannerPage + '"></script>';
				if ( document.cookie.indexOf( 'centralnotice_'+bannerType+'=hide' ) == -1 ) {
					jQuery( '#siteNotice' ).prepend( '<div id="centralNotice" class="' + 
						( wgNoticeToggleState ? 'expanded' : 'collapsed' ) + 
						' cn-' + bannerType + '">'+bannerScript+'</div>' );
				}
			},
			'loadBannerList': function( geoOverride ) {
				if ( geoOverride ) {
					var geoLocation = geoOverride; // override the geo info
				} else {
					var geoLocation = Geo.country; // pull the geo info
				}
				var bannerListQuery = $.param( { 'language': wgContentLanguage, 'project': wgNoticeProject, 'country': geoLocation } );
				var bannerListURL = wgScript + '?title=' + encodeURIComponent('Special:BannerListLoader') + '&cache=/cn.js&' + bannerListQuery;
				var request = $.ajax( {
					url: bannerListURL,
					dataType: 'json',
					success: $.centralNotice.fn.chooseBanner
				} );
			},
			'chooseBanner': function( bannerList ) {
				// Convert the json object to a true array
				bannerList = Array.prototype.slice.call( bannerList );
				
				// Make sure there are some banners to choose from
				if ( bannerList.length == 0 ) return false;
				
				var groomedBannerList = [];
				
				for( var i = 0; i < bannerList.length; i++ ) {
					// Only include this banner if it's intended for the current user
					if( ( wgUserName && bannerList[i].display_account ) || 
						( !wgUserName && bannerList[i].display_anon == 1 ) ) 
					{
						// add the banner to our list once per weight
						for( var j=0; j < bannerList[i].weight; j++ ) {
							groomedBannerList.push( bannerList[i] );
						}
					}
				}
				
				// Return if there's nothing left after the grooming
				if( groomedBannerList.length == 0 ) return false;
				
				// Choose a random key
				var pointer = Math.floor( Math.random() * groomedBannerList.length );
				
				// Load a random banner from our groomed list
				$.centralNotice.fn.loadBanner( 
					groomedBannerList[pointer].name,
					groomedBannerList[pointer].campaign,
					( groomedBannerList[pointer].fundraising ? 'fundraising' : 'default' )
				);
			},
			'getQueryStringVariables': function() {
				document.location.search.replace( /\??(?:([^=]+)=([^&]*)&?)/g, function () {
					function decode( s ) {
						return decodeURIComponent( s.split( "+" ).join( " " ) );
					}
					$.centralNotice.data.getVars[decode( arguments[1] )] = decode( arguments[2] );
				} );
			}
		}
	}
	jQuery( document ).ready( function ( $ ) {
		// Initialize the query string vars
		$.centralNotice.fn.getQueryStringVariables();
		if( $.centralNotice.data.getVars['banner'] ) {
			// if we're forcing one banner
			$.centralNotice.fn.loadBanner( $.centralNotice.data.getVars['banner'] );
		} else {
			// Look for banners ready to go NOW
			$.centralNotice.fn.loadBannerList( $.centralNotice.data.getVars['country'] );
		}
	} ); //document ready
} )( jQuery );