var cookieName    = 'portal';
var cookie = readCookie(cookieName);
var viewMap = new Object();

if(cookie)
{
	var values = cookie.split("|");
	for(var i = 0; i < values.length; i++)
	{
		var keyValue = values[i].split(":")
		var key = keyValue[0];
		var value = keyValue[1];
		
		if(key.charAt(0)=='n')
		{
		    viewMap[key] = value;
		}
	}
}

// lpd - int - Date of last presentation viewed (number of milliseconds since the Epoch)
var lpd = new Date().getTime();

if(viewMap['nv' + lpt] == null)
{
    viewMap['nv' + lpt] = 1;
}
else
{
    viewMap['nv' + lpt]++;
}

// Cookie parameters
var expires = 'Wed, 1 Jan 2020 00:00:00 UTC';
var path    = '/';
var domain  = '.sliderocket.com';

// Create the cookie
var cookieString = cookieName + '=';
for(var key in viewMap)
{
    cookieString = cookieString + key + ':' + viewMap[key] + '|';
}

cookieString = cookieString + 'lpt:' + lpt + '|lpd:' + lpd + '|lpi:' + lpi + '|; expires=' + expires + '; path=' + path + ';domain=' + domain + ';';
document.cookie = cookieString;

function readCookie(name) 
{
	var nameEQ = name + "=";
	var startIndex = document.cookie.indexOf(nameEQ);

	if(startIndex > -1)
	{
	    var endIndex = document.cookie.indexOf(";", startIndex);
	   if(endIndex == -1) endIndex = document.cookie.length;
	   
	   return document.cookie.substring(startIndex + nameEQ.length, endIndex);
	}
	return null;
}