var timeOut;
var ev;
var loginWindowShown=false;
var globalMessageId=0;
var tooltipid = "";
var  events = [];

var xposition = 0;
var yposition = 0;

function initializeTooltip(e) {
	xposition = e.pageX+15;
	yposition = e.pageY-5;
	tooltipid = $(e.target).attr('id');
	if (tooltipid == null ) {
		tooltipid = $(e.target).parent().attr('id');
	}
	var temp = tooltipid;
	
	events[tooltipid] = setTimeout("showTooltip('" + temp + "');", 200);
}

function deintializeTooltip(e) {
	tooltipid = "";
	var eventid = $(e.target).attr('id');
	if (eventid == null ) {
		eventid = $(e.target).parent().attr('id');
	}
	if (events[eventid]!=null) {
		clearTimeout(events[eventid]);
	}
}

function fixTags(text) {
    var tagStack = [];
    var output = [];
    var openTag= false;
    var closeTag= false;
    var tagChars = [];
    var length = text.length;
    var tagName;
    var ch = '';
    for(var i = 0; i < length; i++) {
        ch = text.charAt(i);
        if( ((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch<='Z'))) {
            if(openTag || closeTag) {
                tagChars.push(ch);
            }
            else {
                output.push(ch);
            }
            continue;
        }
        if(ch == '<') {
            if(openTag || closeTag) { // flush the accumulated chars as this is possibly a tag opener
                output.push(tagChars.join(""));
                tagChars= [];
            }
            if( i+2 < length && text.charAt(i+1) != " ") {
                if(text.charAt(i+1) == "/") {
                    i=i+1;
                    if(i+2 < length && text.charAt(i+1) != " ") {
                        closeTag = true;
                        tagChars.push("</");
                    }
                    else {
                       output.push("</");
                    }
                }
                else {
                    openTag = true;
                    tagChars.push("<");
                }
            }
            else {
                output.push(ch);
            }   
            continue;
        }
        if (ch == '>') {
            if(openTag) {
                // found a tag
                var fullTagName= tagChars.join("");
                var alreadyClosed= false;
                if("/" == text.charAt(i-1)) {
                   // see if it is already closed
                   fullTagName= fullTagName.substring(0, fullTagName.length - 1);
                   alreadyClosed= true;
                }
                var spaceIdx= fullTagName.indexOf(" ");
                if(spaceIdx == -1) { // tag name only
                  tagName= fullTagName.substring(1);
                }
                else { // tag with attributes
                  tagName= fullTagName.substring(1, spaceIdx);
                }
                var lowerCaseTagName= tagName.toLowerCase();
                if(alreadyClosed) {
                    output.push(fullTagName + "/>");
                }
                else if("br" == lowerCaseTagName) {
                    // br doesn't need a closing tag
                    output.push("<br/>");
                }
                else {
                    tagStack.push(tagName.toLowerCase());
                    output.push(fullTagName + ">");
                }
                tagChars= [];
                openTag= false;
            }
            else if(closeTag) {
                // found close tag
                tagName = tagChars.join("").substring(2);
                tagChars= [];
                closeTag= false;
                // check if the tag is in the stack
                if(tagStack.length > 0) {
                    var lastEl = tagStack[tagStack.length - 1];
                    if(lastEl == tagName.toLowerCase()) {
                        tagStack.pop();
                    }
                    else if("br" != tagName){
                        output.push("<" + tagName + ">");
                    }
                }
                else if("br" != tagName){
                    output.push("<" + tagName + ">");
                }
                if("br" == tagName) {
                    output.push("<br/>");
                }
                else {
                    output.push("</" + tagName + ">");
                }
            }
            else {
                output.push(ch);
            }
            continue;
        }
        if(openTag) {
          tagChars.push(ch);
        }
        else if(closeTag) { // close tags do not allow attribute
            closeTag = false;
            output.push(tagChars.join(""));
            tagChars= [];
        }
        else {
          output.push(ch);
        }
    }
    if(tagChars.length > 0) {
        output.push(tagChars.join(""));
    }
    while(tagStack.length > 0) {
        var tag = tagStack.pop();
        output.push("</" + tag + ">");
    }
    return output.join("");
}

var currentMessage;
var currentFlatMessage;

var content;
var flatContent;

var subject;
var flatSubject;

var body;
var flatBody;

function changeOrder(order) {
	var url = document.location.href;
	if (url.indexOf('#')!=-1) {
		url = url.substring(0,url.indexOf('#'));
	}
	var index = url.indexOf('order=');
	var hasParameters = (url.indexOf('&')!=-1);
	if (index==-1) {
		if (hasParameters) {
			url += "&order="+order;
		}
		else {
			url += "?order="+order;
		}
	}
	else {
		url = url.substring(0,index)+"order="+order+url.substring(index+7,url.length);
	}
	document.location.href = url;
}


function showTooltip(event) {
	if (loginWindowShown) {
		return;	
	}
	
	if (tooltipid==null || tooltipid== "" || tooltipid!=event) {
		return;
	}
	
	var messageId = tooltipid.substring(8);
	
	if (messageId == globalMessageId) {
		return;
	}
	else {
		if (document.getElementById('header_'+messageId)==null) {
			return;
		}
		globalMessageId = messageId;
	}
		
	var replyButton = '';
	if (loggedIn) {
		replyButton = '<a class="comment-reply" href="javascript:void(0);" onClick="javascript:replyFromTooltip('+messageId+');">'+reply+'</a>'
	}
	else {
		replyButton = '<span><a class="comment-reply" href="javascript:void(0);" '+
		'onClick="javascript:showLoginWindow(this,ALIGN_RIGHT,new Function(\'replyFromTooltip('+messageId+')\'));">'+reply+'</a></span>'
	}
	$('#tooltip').html(
		'<div id="innertooltip" class="popup comment-popup"  style="display:none; left:'+
		(xposition)+'px; '+
		'top:'+ (yposition)+'px; "><div class="popup-wrapper">'+
		'<div class="comment-header">'+
		'<p class="popup-close"><a href="javascript:void(0);" onclick="hideTooltip()">Close</a></p>'+
		document.getElementById('header_'+messageId).innerHTML+
		'</div>'+
		document.getElementById('body_'+messageId).innerHTML+
		'<p class="comment-footer"><a href="#view_'+messageId+'" class="comment-view" onClick="javascript:hideTooltip();return true;">'+JSResource.forum_view+'</a>'+
		replyButton+'</p>'+
		'</div></div>');			
	$('#tooltip').show();		
	
	if ($('#innertooltip').height()>500) {
		$('#tooltip').html(
			'<div id="innertooltip" class="popup comment-popup"  style="display:none; left:'+
			(xposition)+'px; '+
			'top:'+ (yposition)+'px; "><div class="popup-wrapper">'+
			'<div class="comment-header">'+
			'<p class="popup-close"><a href="javascript:void(0);" onclick="hideTooltip()">'+JSResource.close+'</a></p>'+
			document.getElementById('header_'+messageId).innerHTML+
			'</div>'+
			'<div style="overflow:auto; height:300px;">'+
			document.getElementById('body_'+messageId).innerHTML+
			'</div>'+
			'<p class="comment-footer"><a href="#view_'+messageId+'" class="comment-view" onClick="javascript:hideTooltip();return true;">'+JSResource.forum_view+'</a>'+
			replyButton+'</p>'+
			'</div></div>');				
	}
	$('#innertooltip').show();	
}

function hideTooltip() {
	globalMessageId = 0;
	if (document.getElementById('tooltip')!=null) {
		$('#tooltip').hide();
	}
	if (document.getElementById('innertooltip')!=null) {
		$('#innertooltip').hide();
	}
}


function getPreviewButton() {
	return '<input  type="button" onClick="javascript:doPreview()" value="'+previewText+'"/>';
}

function getPostButton() {
	return '<input type="button" onClick="javascript:doPost()" value="'+postMessage+'"/>';
}

function getFlatPreviewButton() {
	return '<input  type="button" onClick="javascript:doFlatPreview()" value="'+previewText+'"/>';
}

function getFlatPostButton() {
	return '<input type="button" onClick="javascript:doFlatPost()" value="'+postMessage+'"/>';
}

function getBackButton() {
	return '<input  type="button" onClick="javascript:goBackEdit()" value="'+goBackOrEdit+'"/>';
}

function getFlatBackButton() {
	return '<input  type="button" onClick="javascript:goBackEditFlat()" value="'+goBackOrEdit+'"/>';
}

function getSubject() {
	var messageSubject = document.getElementById('tooltip_'+currentMessage).innerHTML;
	messageSubject = trim(messageSubject);
	if(messageSubject.length<re.length || messageSubject.substring(0,re.length)!=re) {
		messageSubject = re + ' '+ messageSubject;
	}
	messageSubject = escapeQuotes(messageSubject);
	if (messageSubject.length>75) {
		messageSubject = messageSubject.substring(0,75);
	}
	return messageSubject;
}

function getFlatSubject() {
	var messageSubject = document.getElementById('tooltip_'+currentFlatMessage).innerHTML;
	messageSubject = trim(messageSubject);
	if(messageSubject.length<re.length || messageSubject.substring(0,re.length)!=re) {
		messageSubject = re + ' '+ messageSubject;
	}
	if (messageSubject.length>75) {
		messageSubject = messageSubject.substring(0,75);
	}
	return messageSubject;
}

function addQuote() {
	$('#replybody_'+currentMessage).val($('#replybody_'+currentMessage).val() +
	'<blockquote>'+trim(document.getElementById('quote_'+currentMessage).innerHTML.replace(/<br>/gim, '\n'))+'</blockquote>');
}

function addFlatQuote() {
	$('#flatreplybody_'+currentFlatMessage).val($('#flatreplybody_'+currentFlatMessage).val() +
	'<blockquote>'+trim(document.getElementById('quote_'+currentFlatMessage).innerHTML.replace(/<br>/gim, '\n'))+'</blockquote>');
}

function getReply(firstPost) {	
	var replyHTML = '<div id="reply-form" class="comment-form"><form action="#">'+
		'<p class="popup-close"><a href="javascript:void(0);" onClick="javascript:hideReplyFromTooltip()">'+JSResource.close+'</a></p>'+
		'<div id="reply">' +
		(firstPost!=null?'':'<p class="comment-quote"><input value="'+JSResource.forum_quoteOriginalMessage+'" type="button" onClick="javascript:addQuote()"></p>')+
		'<p><label for="replysubject_'+currentMessage+'">'+JSResource.forum_subject+'</label> <input style="width: 100%;" maxlength="75" name="subject" id="replysubject_'+
		currentMessage+'" type="text" value="'+(firstPost!=null?'':getSubject())+'"></p>'+
		'<p><label for="replybody_'+currentMessage+'">'+JSResource.forum_yourReply+'</label> <textarea style="width: 100%;" name="body" id="replybody_'+currentMessage+
		'" cols="22" rows="7"></textarea></p>'+
		'</div><span style="font-weight: normal;">'+JSResource.forum_allowedHtml+' a,b,br,blockquote,i,li,pre,u,ul,p</span>'+		
        '<p class="comment-post"><span id="post_'+currentMessage+'">'+getPostButton()+'</span>'+
        '<span id="preview_'+currentMessage+'">'+getPreviewButton()+'</span>'+
        '<span><input type="button" class="comment-cancel" onClick="javascript:hideReplyFromTooltip()" value="'+cancel+'"></span><div style="margin-left:200px;margin-top:-30px;height:30px;">';
		if(forumNotificationDefault){
			replyHTML += '<input id="notificationCB" type="checkbox" checked="checked" value="true"/>';
		} else {
			replyHTML += '<input id="notificationCB" type="checkbox" value="true"/>';
		}
		replyHTML += '<div style="position:relative;top:-20px;left:25px;width:200px;">' + JSResource.forum_notificationLabel1 + '<br/>' + JSResource.forum_notificationLabel2 + '</div></div></p></form></div>';
	return replyHTML;
}

function getReplyFromFlat() {
	var replyHTML = '<div id="reply-form" class="comment-form"><form action="#">'+
		'<p class="popup-close"><a href="javascript:void(0);" onClick="javascript:hideReplyFromFlat()">'+JSResource.close+'</a></p>'+
		'<div id="flatreply">' +
		'<p class="comment-quote"><input value="'+JSResource.forum_quoteOriginalMessage+'" type="button" onClick="javascript:addFlatQuote()"></p>'+
		'<p><label for="flatreplysubject_'+currentFlatMessage+'">'+JSResource.forum_subject+'</label> <input style="width: 100%;" maxlength="75" name="flatsubject" id="flatreplysubject_'+
		currentFlatMessage+'" type="text" value="'+getFlatSubject()+'"></p>'+
		'<p><label for="flatreplybody_'+currentMessage+'">'+JSResource.forum_yourReply+'</label> <textarea style="width: 100%;" name="flatbody" id="flatreplybody_'+currentFlatMessage+
		'" cols="22" rows="7"></textarea></p>'+
		'</div><span style="font-weight: normal;">'+JSResource.forum_allowedHtml+' a,b,br,blockquote,i,li,pre,u,ul,p</span>'+		
        '<p class="comment-post"><span id="flatpost_'+currentFlatMessage+'">'+getFlatPostButton()+'</span>'+
        '<span id="flatpreview_'+currentFlatMessage+'">'+getFlatPreviewButton()+'</span>'+
        '<span><input type="button" class="comment-cancel" onClick="javascript:hideReplyFromFlat()" value="'+cancel+'"></span><div style="margin-left:200px;margin-top:-30px;height:30px;">';
		if(forumNotificationDefault){
			replyHTML += '<input id="notificationCB" type="checkbox" checked="checked" value="true"/>';
		} else {
			replyHTML += '<input id="notificationCB" type="checkbox" value="true"/>';
		}
		replyHTML += '<div style="position:relative;top:-20px;left:25px;width:200px;">' + JSResource.forum_notificationLabel1 + '<br/>' + JSResource.forum_notificationLabel2 + '</div></div></p></form></div>';		
	return replyHTML;
}

function doPreview() {
	if (verifyPost()) {
		var handlerFunc = function(t) {
			var response = trim(t);
			if (response.substring(0,6)=='error:') {
				alert(response.substring(6,response.length));
				$('#preview_'+currentMessage).html(getPreviewButton());
			}
			else {
				$('#reply').html(t);
				$('#preview_'+currentMessage).html(getBackButton());
			}
		}
		
		var errFunc = function(t) {
		    alert(JSResource.error);
		}		
		content = document.getElementById('reply').innerHTML;
		subject = $('#replysubject_'+currentMessage).val();
		body = $('#replybody_'+currentMessage).val();
		$('#preview_'+currentMessage).html('<input type="button" disabled="true" value="'+pleaseWait+'"/>');		
		$.ajax({
			url: postAddress,
			type: 'POST',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {'doPreview':'preview','forumID':forumID,'threadID':threadID,'messageID':currentMessage,'subject':$('#replysubject_'+currentMessage).val(),'body':fixTags($('#replybody_'+currentMessage).val())},
			success: handlerFunc,
			error: errFunc
		});
	}
}

function doFlatPreview() {
	if (verifyFlatPost()) {
		var handlerFunc = function(t) {
			var response = trim(t);
			if (response.substring(0,6)=='error:') {
				alert(response.substring(6,response.length));
				$('#flatpreview_'+currentFlatMessage).html(getFlatPreviewButton());
			}
			else {
				$('#flatreply').html(t);
				$('#flatpreview_'+currentFlatMessage).html(getFlatBackButton());
			}
		}
		
		var errFunc = function(t) {
		    alert(JSResource.error);
		}		
		flatContent = document.getElementById('flatreply').innerHTML;
		flatSubject = $('#flatreplysubject_'+currentFlatMessage).val();
		flatBody = $('#flatreplybody_'+currentFlatMessage).val();
		$('#flatpreview_'+currentFlatMessage).html('<input type="button" disabled="true" value="'+pleaseWait+'"/>');
		$.ajax({
			url: postAddress,
			type: 'POST',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {'doPreview':'preview','forumID':forumID,'threadID':threadID,'messageID':currentFlatMessage,'subject':$('#flatreplysubject_'+currentFlatMessage).val(),'body':fixTags($('#flatreplybody_'+currentFlatMessage).val())},
			success: handlerFunc,
			error: errFunc
		});
	}
}

function updateCommentCount() {
	var comments = parseInt(document.getElementById('comments-number').innerHTML)+1;
	document.getElementById('comments-number').innerHTML = comments;
	if (comments==2) {
		$('#comments-sort').show();
	}
}

function doPost() {
	if (verifyPost()) {
		var handlerFunc = function(t) {
			var response = trim(t);
			if (response.substring(0,6)=='error:') {		
				alert(response.substring(6,response.length));		
				$('#post_'+currentMessage).html(getPostButton());
			}
			else {
				$('#newMessage').html(t);				
				var newMessageId = trim(document.getElementById('newMessageId').innerHTML);
				var headerText = document.getElementById('newMessageHeader').innerHTML;
				var oldHeaderText = document.getElementById('replyMessage_'+currentMessage).innerHTML;
				document.getElementById('replyMessage_'+currentMessage).appendChild(document.getElementById('newMessageHeader'));
				if (descending!='true' || document.getElementById('lastMessages').childNodes.length==0) {
					document.getElementById('lastMessages').appendChild(document.getElementById('newMessageBody'));
				}
				else {					
					var firstChild = document.getElementById('lastMessages').childNodes[0];
					document.getElementById('lastMessages').insertBefore(document.getElementById('newMessageBody'),firstChild);
				}				
				$('#newMessage').html('');
				var newTooltip = trim('tooltip_'+newMessageId);
				$('#'+newTooltip).mouseover(function(e) {
					initializeTooltip(e);
				});
				$('#'+newTooltip).mouseout(function(e) {
					deintializeTooltip(e);
				});
				setNotificationsState(document.getElementById('notificationCB').checked);
				hideReplyFromTooltip();
				updateCommentCount();
			}
		}
		
		var errFunc = function(t) {
		    alert(JSResource.error);
		}		
		$('#post_'+currentMessage).html('<input type="button" disabled="true" value="'+pleaseWait+'"/>');
		var subjectContent;
		if ($('#replysubject_'+currentMessage).length == 0) {
			subjectContent = subject;
		}	
		else {
			subjectContent = $('#replysubject_'+currentMessage).val();
		}
		var bodyContent;
		if ($('#replybody_'+currentMessage).length == 0) {
			bodyContent = body;
		}	
		else {
			bodyContent = $('#replybody_'+currentMessage).val();
		}		
		$.ajax({
			url: postAddress,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			type: 'POST',
			data: {'reply':'true','forumID':forumID,'threadID':threadID,'messageID':currentMessage,'subject':subjectContent,'notification':document.getElementById('notificationCB').checked,'contentUrl':document.location.href,'body':fixTags(bodyContent)},
			success: handlerFunc,
			error: errFunc
		});
	}
}


function doFlatPost() {
	if (verifyFlatPost()) {
		var handlerFunc = function(t) {
			var response = trim(t);
			if (response.substring(0,6)=='error:') {		
				alert(response.substring(6,response.length));		
				$('#flatpost_'+currentFlatMessage).html(getFlatPostButton());
			}
			else {
				$('#newMessage').html(t);
				var newMessageId = trim(document.getElementById('newMessageId').innerHTML);				
				document.getElementById('replyMessage_'+currentFlatMessage).appendChild(document.getElementById('newMessageHeader'));				
				var bodyText = document.getElementById('newMessageBody').innerHTML;						
				document.getElementById('replyFlatMessage_'+currentFlatMessage).appendChild(document.getElementById('newMessageBody'));
				$('#newMessage').html('');
				var newTooltip = trim('tooltip_'+newMessageId);			
				$('#'+newTooltip).mouseout(function(e) {
					deintializeTooltip(e);
				});
				$('#'+newTooltip).mouseout(function(e) {
					deintializeTooltip(e);
				});
				setNotificationsState(document.getElementById('notificationCB').checked);
				hideReplyFromFlat();
				updateCommentCount();			
			}
		}
		
		var errFunc = function(t) {
		    alert(JSResource.error);
		}		

		$('#flatpost_'+currentFlatMessage).html('<input type="button" disabled="true" value="'+pleaseWait+'"/>');
		var subjectContent;
		if ($('#flatreplysubject_'+currentFlatMessage).length == 0) {
			subjectContent = flatSubject;
		}	
		else {
			subjectContent = $('#flatreplysubject_'+currentFlatMessage).val();
		}
		var bodyContent;
		if ($('#flatreplybody_'+currentFlatMessage).length == 0) {
			bodyContent = flatBody;
		}	
		else {
			bodyContent = $('#flatreplybody_'+currentFlatMessage).val();
		}
		$.ajax({
			url: postAddress,
			type: 'POST',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {'reply':'true','forumID':forumID,'threadID':threadID,'messageID':currentFlatMessage,'subject':subjectContent,'notification':document.getElementById('notificationCB').checked,'contentUrl':document.location.href,'body':fixTags(bodyContent)},
			success: handlerFunc,
			error: errFunc
		});
	}
}

function goBackEdit() {
	$('#reply').html(content);
	$('#replysubject_'+currentMessage).val(subject);
	$('#replybody_'+currentMessage).val(body);
	$('#preview_'+currentMessage).html(getPreviewButton());
}

function goBackEditFlat() {
	$('#flatreply').html(flatContent);
	$('#flatreplysubject_'+currentFlatMessage).val(flatSubject);
	$('#flatreplybody_'+currentFlatMessage).val(flatBody);
	$('#flatpreview_'+currentFlatMessage).html(getFlatPreviewButton());
}

function verifyPost() { 
	if ($('#replysubject_'+currentMessage).length == 0) {
		if (subject == null || subject == "") {
			alert(errorSubject);
			return false;	
		}
	} 
	else {
		if ($('#replysubject_'+currentMessage).val()=="") {
			alert(errorSubject);
			return false;
		}
	}
	if ($('#replybody_'+currentMessage).length == 0) {
		if (body == null || body == "") {
			alert(errorBody);
			return false;	
		}
	} 
	else {
		if ($('#replybody_'+currentMessage).val()=="") {
			alert(errorBody);
			return false;
		}
	}
	return true;
}

function verifyFlatPost() { 
	if ($('#flatreplysubject_'+currentFlatMessage).length == 0) {
		if (flatSubject == null || flatSubject == "") {
			alert(errorSubject);
			return false;	
		}
	} 
	else {
		if ($('#flatreplysubject_'+currentFlatMessage).val()=="") {
			alert(errorSubject);
			return false;
		}
	}
	if ($('#flatreplybody_'+currentFlatMessage).length == 0) {
		if (flatBody == null || flatBody == "") {
			alert(errorBody);
			return false;	
		}
	} 
	else {
		if ($('#flatreplybody_'+currentFlatMessage).val()=="") {
			alert(errorBody);
			return false;
		}
	}
	return true;
}

function hideReplyFromTooltip() {
	if (currentMessage != null) {
		$('#replyTree_'+currentMessage).hide();
		$('#replyTree_'+currentMessage).html('');
		currentMessage = null;		
	}
}

function hideReplyFromFlat() {
	if (currentFlatMessage != null) {
		$('#replyFlat_'+currentFlatMessage).hide();
		$('#replyFlat_'+currentFlatMessage).html('');
		currentFlatMessage = null;		
	}
}

function replyFromFlat(messageId) {
	hideReplyFromFlat();
	hideReplyFromTooltip();
	currentFlatMessage = messageId;
	$('#replyFlat_'+messageId).html(getReplyFromFlat());	
	$('#replyFlat_'+messageId).show();	
}

function replyFromTooltip(messageId, firstPost) {
	if (firstPost == null ) {
		hideTooltip();		
	}
	hideReplyFromFlat();
	hideReplyFromTooltip();
	currentMessage = messageId;	
	$('#replyTree_'+messageId).html(getReply(firstPost));
	$('#replyTree_'+messageId).show();	
}

function startWatch() {	
	var handlerFunc = function(t) {
		var response = trim(t);
		if (response.substring(0,6)=='error:') {
			alert(response.substring(6,response.length));			
		}
		else {
			$('#watch').html('<a href="javascript:void(0)" class="comment-watch" onClick="javascript:stopWatch()">'+stopWatchText+'</a>');
		}
	}
	
	var errFunc = function(t) {
	    alert(JSResource.error);
	}		
	$.ajax({
		url: postAddWatches,
		type: 'POST',
		data: {'forumID':forumID,'threadID':threadID},
		success: handlerFunc,
		error: errFunc
	});
}

function stopWatch() {
	var handlerFunc = function(t) {
		var response = trim(t);
		if (response.substring(0,6)=='error:') {
			alert(response.substring(6,response.length));			
		}
		else {
			$('#watch').html('<a href="javascript:void(0)" class="comment-watch" onClick="javascript:startWatch()">'+startWatchText+'</a>');
		}
	}
	
	var errFunc = function(t) {
	    alert(JSResource.error);
	}		
	$.ajax({
		url: postRemoveWatches,
		type: 'POST',
		data: {'forumID':forumID,'threadID':threadID},
		success: handlerFunc,
		error: errFunc
	});
};

function toggleNotifications(mid, uid) {
	var domEl = document.getElementById('notifications_'+mid);
	if(domEl != null){
		domEl.disabled = true;
		ForumNotifications.toggleNotifications(mid, uid, domEl.checked, toggleNotificationsDone);
	}
};

function toggleNotificationsDone(mid) {
	var domEl = document.getElementById('notifications_'+mid);
	if(domEl != null){
		domEl.disabled = false;
		setNotificationsState(domEl.checked);
	}
};

function setNotificationsState(state){
	var allCb = document.getElementsByName('notifications_CB');
	for(var i=0;i<allCb.length;i++){
		allCb[i].checked = state;
	}
};

function getRelativeTime(timeInMilliseconds){
	// create a new date with the browser locale
	var date= new Date();
	// set the milliseconds to this localized date
	date.setTime(timeInMilliseconds);
	// get the relative time 
	return jQuery.timeago(date);
}
