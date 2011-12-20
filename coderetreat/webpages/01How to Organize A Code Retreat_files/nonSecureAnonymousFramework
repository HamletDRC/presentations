(function(){
var l,
    doAuth,
    h = [],
    valid = false,
    a = "",
    fwk = "http://platform.linkedin.com/js/framework?v=0.0.1128-RC2.7982-1337",
    xtnreg = /extensions=([^&]*)&?/,
    xtn = fwk.match(xtnreg),
    dotRegex = /\./g,
    starRegex = /\*/g,
    selfUrl = window.location.host.replace(/:\d+$/,"").toLowerCase();

window.IN = window.IN || {};
IN.ENV = IN.ENV || {};
IN.ENV.js = IN.ENV.js || {};
IN.ENV.js.xtn = IN.ENV.js.xtn || {};

/*
if !ANONYMOUS_USERSPACE
endif
*/

/*
if AUTH_USERSPACE
else if FULL_USERSPACE || ANONYMOUS_USERSPACE
*/
  
  l = IN.ENV.ui = IN.ENV.ui || {};
  l.popup_window_width = 600;
  l.window_width = 100;
  
  l = IN.ENV.auth = IN.ENV.auth || {};
  l.oauth_token = "";
  l.oauth_expires_in = parseInt("0", 10);
  l.anonymous_token = "";
  l.anonymous_expires_in = parseInt("${ANONYMOUS_EXPIRES_IN}", 10);
  l.member_id = "";
  l.api_key = "";

  l = IN.ENV.api = IN.ENV.api || {};
  l.queue_interval = parseInt("300", 10);

  l = IN.ENV.url =  IN.ENV.url || {};
  l.xd_html = "https://platform.linkedin.com/js/xdrpc.html?v=0.0.1128-RC2.7982-1337";
  l.xd_us_html = "http://platform.linkedin.com/js/xdrpc.html?v=0.0.1128-RC2.7982-1337";
  l.api_xd_html = "https://api.linkedin.com/uas/js/xdrpc.html?v=0.0.1128-RC2.7982-1337";
  l.api = "https://api.linkedin.com/v1";
  l.login = "https://www.linkedin.com/uas/connect/user-signin";
  l.authorize = "https://www.linkedin.com/uas/oauth2/authorize?immediate=true";
  l.logout = "https://www.linkedin.com/uas/connect/logout?oauth_token={OAUTH_TOKEN}&api_key={API_KEY}&callback={CALLBACK}";
  l.userspace_renew = "https://www.linkedin.com/uas/js/authuserspace?v=0.0.1128-RC2.7982-1337&api_key={API_KEY}";
  l.base_js_url = "http://static01.linkedin.com/scds/concat/common/js?v=build-1128_2_7982-prod&f=js%2Fconnect%2FPATH_INFO";
  l.analytics_us_url = "http://www.linkedin.com/analytics/?type=__ETYPE__&trk=__TINFO__&original_referer=__ORIGIN__&wt=__WTYPE__";
  l.analytics_url = "http://www.linkedin.com/analytics/?type=__ETYPE__&trk=__TINFO__&original_referer=__ORIGIN__&wt=__WTYPE__";

  l = IN.ENV.widget = IN.ENV.widget || {};

  l.settings_url = "http://www.linkedin.com/cws/settings";
  l.share_url = "http://www.linkedin.com/cws/share";
  l.share_counter_url = "http://www.linkedin.com/countserv/count/share";
  l.recommend_product_url = "http://www.linkedin.com/company/{COMPANY_ID}/product?prdId={PRODUCT_ID}";
  l.recommend_product_counter_url = "http://www.linkedin.com/company/api/recommendation/count?type=PDCT&id={PRODUCT_ID}&callback={CALLBACK}";
  l.company_url = "http://www.linkedin.com/cws/company/profile";
  l.member_profile_url = "http://www.linkedin.com/cws/member/public_profile";
  l.full_member_profile_url = "http://www.linkedin.com/cws/member/full_profile";
  l.company_follow_url = "http://www.linkedin.com/cws/demo-company-follow-display";
  l.referral_center_url= "http://www.linkedin.com/cws/referral";
  l.apply_url= "${WIDGET_APPLY_URL}";
  l.mail_url= "http://www.linkedin.com/cws/mail";
  l.apply_counter_url = "${WIDGET_APPLY_COUNTER_URL}";
  l.company_insider_url = "http://www.linkedin.com/cws/company/insider";
  l.sfdc_member_url = "https://www.linkedin.com/cws/sfdc/member";
  l.sfdc_company_url = "https://www.linkedin.com/cws/sfdc/company";
  l.sfdc_signal_url = "https://www.linkedin.com/cws/sfdc/signal";
  l.cap_full_profile_url = "${WIDGET_CAP_FULL_PROFILE_URL}";
  l.cap_member_search_url = "${WIDGET_CAP_MEMBER_SEARCH_URL}";
  l.cap_public_member_search_url = "${WIDGET_CAP_PUBLIC_MEMBER_SEARCH_URL}";
  l.cap_public_member_url = "${WIDGET_CAP_PUBLIC_MEMBER_URL}";
  l.cap_recruiter_member_url = "${WIDGET_CAP_RECRUITER_MEMBER_URL}";
  l.cap_public_profile_url = "${WIDGET_CAP_PUBLIC_PROFILE_URL}";
  l.jymbii_url = "http://www.linkedin.com/cws/jymbii";


  l = IN.ENV.images = IN.ENV.images || {};
  l.sprite = "http://static01.linkedin.com/scds/common/u/img/sprite/sprite_connect_v12.png";

  l.unsecure_xdswf = "http://platform.linkedin.com/js/easyXDM.swf?v=0.0.1128-RC2.7982-1337";
  l.secure_xdswf = "https://platform.linkedin.com/js/easyXDM.swf?v=0.0.1128-RC2.7982-1337";

/*
  # Client Side Extensions
  # These are possibly in framework js and need to be loaded
  # via IN.$extensions() instead. This also helps ensure we're under
  # the 2048 limit for URL length in cases where a lot of extensions
  # are being loaded
  */
  if (xtn && xtn[1] && IN.$extensions) {
    IN.$extensions(decodeURIComponent(xtn[1]));
    fwk = fwk.replace(xtn[0], "").replace(/&*$/, "");
  }
  
/*
endif
*/

/*
if FULL_USERSPACE
endif
*/

/*
if !ANONYMOUS_USERSPACE
endif
*/

})();


/* ANONYMOUS USER_SPACE */

/* Version Path: dev */

/* res://connect-min/dev/lib/json2.js */

if(!this.JSON){this.JSON={}
}(function(){function f(n){return n<10?"0"+n:n
}if(typeof Date.prototype.toJSON!=="function"){Date.prototype.toJSON=function(key){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null
};
String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(key){return this.valueOf()
}
}var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},rep;
function quote(string){escapable.lastIndex=0;
return escapable.test(string)?'"'+string.replace(escapable,function(a){var c=meta[a];
return typeof c==="string"?c:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)
})+'"':'"'+string+'"'
}function str(key,holder){var i,k,v,length,mind=gap,partial,value=holder[key];
if(value&&typeof value==="object"&&typeof value.toJSON==="function"){value=value.toJSON(key)
}if(typeof rep==="function"){value=rep.call(holder,key,value)
}switch(typeof value){case"string":return quote(value);
case"number":return isFinite(value)?String(value):"null";
case"boolean":case"null":return String(value);
case"object":if(!value){return"null"
}gap+=indent;
partial=[];
if(Object.prototype.toString.apply(value)==="[object Array]"){length=value.length;
for(i=0;
i<length;
i+=1){partial[i]=str(i,value)||"null"
}v=partial.length===0?"[]":gap?"[\n"+gap+partial.join(",\n"+gap)+"\n"+mind+"]":"["+partial.join(",")+"]";
gap=mind;
return v
}if(rep&&typeof rep==="object"){length=rep.length;
for(i=0;
i<length;
i+=1){k=rep[i];
if(typeof k==="string"){v=str(k,value);
if(v){partial.push(quote(k)+(gap?": ":":")+v)
}}}}else{for(k in value){if(Object.hasOwnProperty.call(value,k)){v=str(k,value);
if(v){partial.push(quote(k)+(gap?": ":":")+v)
}}}}v=partial.length===0?"{}":gap?"{\n"+gap+partial.join(",\n"+gap)+"\n"+mind+"}":"{"+partial.join(",")+"}";
gap=mind;
return v
}}if(typeof JSON.stringify!=="function"){JSON.stringify=function(value,replacer,space){var i;
gap="";
indent="";
if(typeof space==="number"){for(i=0;
i<space;
i+=1){indent+=" "
}}else{if(typeof space==="string"){indent=space
}}rep=replacer;
if(replacer&&typeof replacer!=="function"&&(typeof replacer!=="object"||typeof replacer.length!=="number")){throw new Error("JSON.stringify")
}return str("",{"":value})
}
}if(typeof JSON.parse!=="function"){JSON.parse=function(text,reviver){var j;
function walk(holder,key){var k,v,value=holder[key];
if(value&&typeof value==="object"){for(k in value){if(Object.hasOwnProperty.call(value,k)){v=walk(value,k);
if(v!==undefined){value[k]=v
}else{delete value[k]
}}}}return reviver.call(holder,key,value)
}text=String(text);
cx.lastIndex=0;
if(cx.test(text)){text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)
})
}if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,""))){j=eval("("+text+")");
return typeof reviver==="function"?walk({"":j},""):j
}throw new SyntaxError("JSON.parse")
}
}}());

/* res://connect-min/dev/lib/sslac.js */

(function(){var n=this,g="Sslac",m={},o=null,i=n[g];
n[g]=n[g]||{};
o=n[g];
function h(u,v,t){var s=function(){};
s.prototype=v.prototype;
u.prototype=new s();
u.prototype.constructor=u;
u.superclass=v.prototype;
if(v.prototype.constructor===Object.prototype.constructor){v.prototype.constructor=v
}if(t){for(var r in t){if(t.hasOwnProperty(t,r)){u.prototype[r]=t[r]
}}}}function j(w,s){var t,v,u=s||n,x=w.split(/\./),r=x.length;
for(t=0;
t<r;
t++){v=x[t];
if(t+1===r){return u
}u[v]=u[v]||{};
u=u[v]
}}function p(r){var t=r.split(/\./),s=t[t.length-1];
return s
}function k(r){m[r]=new b(r);
return m[r]
}function f(r){m[r]=new b(r,true);
return m[r]
}function d(t,s){var u=j(t);
var r=p(t);
u[r]=s
}function q(s){var t=j(s);
var r=p(s);
t[r]=t[r]||{}
}function e(s,r){return j(s,r)[p(s)]
}function l(r){return m[r]
}function c(){var r=o;
n[g]=i;
return r
}function a(){this.Identifier=function(){return{name:"Sslac.ClassObject",ext:""}
}
}function b(v,A){var z=null,t="",u=function(){},s={},x=j(v),y={};
function w(C,D){return function(){this.Parents.push(C);
var E=s[C].apply(D,arguments);
this.Parents.pop();
return E
}
}function r(C,D){return function(){this.Parents.push(C);
var E=D.apply(this,arguments);
this.Parents.pop();
return E
}
}function B(){var E=this,C=null,D=null;
this.Parents=[];
this.Parent=function(){var F=this.Parents[this.Parents.length-1],I=this.Identifier(),H=j(I.ext)[p(I.ext)],G=(z[F])?z[F]:(H.prototype&&H.prototype[F])?H.prototype[F]:function(){};
return G.apply(E,arguments)
};
s.Identifier=function(){return{name:v,ext:t}
};
for(C in s){if(s.hasOwnProperty(C)){this[C]=w(C,E)
}}this.Parents.push("constructor");
D=u.apply(this,arguments);
this.Parents.pop();
for(C in s){if(s.hasOwnProperty(C)){this[C]=w(C,E)
}}return D
}this.Implements=function(){var F=this;
function D(I){return function(){throw new Error("The interface defined requires "+I)
}
}for(var G=0,C=arguments.length;
G<C;
G++){if(Object.prototype.toString.call(arguments[G]).slice(8,-1).toLowerCase()==="array"){for(var E=0,H=arguments[G].length;
E<H;
E++){F.Implements(arguments[G][E])
}}else{if(arguments[G].indexOf(".")>=0){F.Implements(e(arguments[G]))
}else{if(!this.getMethod(arguments[G])){this.Method(arguments[G],D(arguments[G]))
}}}}return this
};
this.Constructor=function(C){u=C;
return this
};
this.getConstructor=function(){return u
};
this.Method=function(C,D){B.prototype[C]=r(C,D);
return this
};
this.getMethod=function(C){return B.prototype[C]
};
this.Static=function(C,D){B[C]=D;
y[C]=D;
return this
};
this.getStatic=function(C){return B[C]
};
this.Extends=function(C){var D=C;
if(typeof C==="string"){D=j(C)[p(C)];
t=C
}h(B,D);
z=B.superclass;
return this
};
this.getExtends=function(){return z
};
this.Extends(a);
if(A){x[p(v)]=y
}else{x[p(v)]=B
}}o.ClassObject=a;
o.Class=k;
o.Static=f;
o.Function=d;
o.Define=q;
o.namespaceOf=j;
o.nameOf=p;
o.valueOf=e;
o.definitionOf=l;
o.noConflict=c;
if(typeof module!=="undefined"&&module.exports){module.exports=o.noConflict()
}}());

/* res://connect-min/dev/lib/easyxdm.js */

(function(window,document,location,setTimeout,decodeURIComponent,encodeURIComponent){var global=this;
var channelId=Math.floor(Math.random()*10000);
var emptyFn=Function.prototype;
var reURI=/^((http.?:)\/\/([^:\/\s]+)(:\d+)*)/;
var reParent=/[\-\w]+\/\.\.\//;
var reDoubleSlash=/([^:])\/\//g;
var reFunction=/^function/;
var namespace="";
var easyXDM={};
var _easyXDM=window.easyXDM;
var IFRAME_PREFIX="easyXDM_";
var HAS_NAME_PROPERTY_BUG;
var HAS_FUNCTION_RECAST_BUG=false
/*@cc_on || ((ScriptEngineMajorVersion()+(ScriptEngineMinorVersion()/10)) <= 5.8)@*/
;
var useHash=false;
var flashVersion;
var HAS_FLASH_THROTTLED_BUG;
function isCallableFunction(fn){if(typeof fn==="function"){return true
}if(HAS_FUNCTION_RECAST_BUG&&typeof fn==="object"&&typeof fn.call!=="undefined"&&typeof fn.apply!=="undefined"){try{return reFunction.test(fn.toString())
}catch(e){return false
}}return false
}function isHostMethod(object,property){var t=typeof object[property];
return t=="function"||(!!(t=="object"&&object[property]))||t=="unknown"
}function isHostObject(object,property){return !!(typeof(object[property])=="object"&&object[property])
}function isArray(o){return Object.prototype.toString.call(o)==="[object Array]"
}function hasFlash(){try{var activeX=new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
flashVersion=Array.prototype.slice.call(activeX.GetVariable("$version").match(/(\d+),(\d+),(\d+),(\d+)/),1);
HAS_FLASH_THROTTLED_BUG=parseInt(flashVersion[0],10)>9&&parseInt(flashVersion[1],10)>0;
activeX=null;
return true
}catch(notSupportedException){return false
}}var on,un;
if(isHostMethod(window,"addEventListener")){on=function(target,type,listener){target.addEventListener(type,listener,false)
};
un=function(target,type,listener){target.removeEventListener(type,listener,false)
}
}else{if(isHostMethod(window,"attachEvent")){on=function(object,sEvent,fpNotify){object.attachEvent("on"+sEvent,fpNotify)
};
un=function(object,sEvent,fpNotify){object.detachEvent("on"+sEvent,fpNotify)
}
}else{throw new Error("Browser not supported")
}}var domIsReady=false,domReadyQueue=[],readyState;
if("readyState" in document){readyState=document.readyState;
domIsReady=readyState=="complete"||(~navigator.userAgent.indexOf("AppleWebKit/")&&(readyState=="loaded"||readyState=="interactive"))
}else{domIsReady=!!document.body
}function dom_onReady(){if(domIsReady){return
}domIsReady=true;
for(var i=0;
i<domReadyQueue.length;
i++){domReadyQueue[i]()
}domReadyQueue.length=0
}if(!domIsReady){if(isHostMethod(window,"addEventListener")){on(document,"DOMContentLoaded",dom_onReady)
}else{on(document,"readystatechange",function(){if(document.readyState=="complete"){dom_onReady()
}});
if(document.documentElement.doScroll&&window===top){(function doScrollCheck(){if(domIsReady){return
}try{document.documentElement.doScroll("left")
}catch(e){setTimeout(doScrollCheck,1);
return
}dom_onReady()
}())
}}on(window,"load",dom_onReady)
}function whenReady(fn,scope){if(domIsReady){fn.call(scope);
return
}domReadyQueue.push(function(){fn.call(scope)
})
}function getParentObject(){var obj=parent;
if(namespace!==""){for(var i=0,ii=namespace.split(".");
i<ii.length;
i++){obj=obj[ii[i]]
}}return obj.easyXDM
}function noConflict(ns){window.easyXDM=_easyXDM;
namespace=ns;
if(namespace){IFRAME_PREFIX="easyXDM_"+namespace.replace(".","_")+"_"
}return easyXDM
}function getDomainName(url){return url.match(reURI)[3]
}function getPort(url){return url.match(reURI)[4]||""
}function getLocation(url){var m=url.toLowerCase().match(reURI);
var proto=m[2],domain=m[3],port=m[4]||"";
if((proto=="http:"&&port==":80")||(proto=="https:"&&port==":443")){port=""
}return proto+"//"+domain+port
}function resolveUrl(url){url=url.replace(reDoubleSlash,"$1/");
if(!url.match(/^(http||https):\/\//)){var path=(url.substring(0,1)==="/")?"":location.pathname;
if(path.substring(path.length-1)!=="/"){path=path.substring(0,path.lastIndexOf("/")+1)
}url=location.protocol+"//"+location.host+path+url
}while(reParent.test(url)){url=url.replace(reParent,"")
}return url
}function appendQueryParameters(url,parameters){var hash="",indexOf=url.indexOf("#");
if(indexOf!==-1){hash=url.substring(indexOf);
url=url.substring(0,indexOf)
}var q=[];
for(var key in parameters){if(parameters.hasOwnProperty(key)){q.push(key+"="+encodeURIComponent(parameters[key]))
}}return url+(useHash?"#":(url.indexOf("?")==-1?"?":"&"))+q.join("&")+(useHash?"&"+hash.substring(1):hash)
}var query=(function(input){input=input.substring(1).split("&");
var data={},pair,i=input.length;
while(i--){pair=input[i].split("=");
data[pair[0]]=decodeURIComponent(pair[1])
}return data
}(/xdm_e=/.test(location.search)?location.search:location.hash));
function undef(v){return typeof v==="undefined"
}var getJSON=function(){var cached={};
var obj={a:[1,2,3]},json='{"a":[1,2,3]}';
if(typeof JSON!="undefined"&&typeof JSON.stringify==="function"&&JSON.stringify(obj).replace((/\s/g),"")===json){return JSON
}if(Object.toJSON){if(Object.toJSON(obj).replace((/\s/g),"")===json){cached.stringify=Object.toJSON
}}if(typeof String.prototype.evalJSON==="function"){obj=json.evalJSON();
if(obj.a&&obj.a.length===3&&obj.a[2]===3){cached.parse=function(str){return str.evalJSON()
}
}}if(cached.stringify&&cached.parse){getJSON=function(){return cached
};
return cached
}return null
};
function apply(destination,source,noOverwrite){var member;
for(var prop in source){if(source.hasOwnProperty(prop)){if(prop in destination){member=source[prop];
if(typeof member==="object"){apply(destination[prop],member,noOverwrite)
}else{if(!noOverwrite){destination[prop]=source[prop]
}}}else{destination[prop]=source[prop]
}}}return destination
}function testForNamePropertyBug(){var form=document.body.appendChild(document.createElement("form")),input=form.appendChild(document.createElement("input"));
input.name=IFRAME_PREFIX+"TEST"+channelId;
HAS_NAME_PROPERTY_BUG=input!==form.elements[input.name];
document.body.removeChild(form)
}function createFrame(config){if(undef(HAS_NAME_PROPERTY_BUG)){testForNamePropertyBug()
}var frame;
if(HAS_NAME_PROPERTY_BUG){frame=document.createElement('<iframe name="'+config.props.name+'"/>')
}else{frame=document.createElement("IFRAME");
frame.name=config.props.name
}frame.id=frame.name=config.props.name;
delete config.props.name;
if(config.onLoad){on(frame,"load",config.onLoad)
}if(typeof config.container=="string"){config.container=document.getElementById(config.container)
}if(!config.container){apply(frame.style,HAS_FLASH_THROTTLED_BUG?{position:"fixed",right:0,top:0,height:"20px",width:"20px"}:{position:"absolute",top:"-2000px"});
config.container=document.body
}var src=config.props.src;
delete config.props.src;
apply(frame,config.props);
frame.border=frame.frameBorder=0;
frame.allowTransparency=true;
config.container.appendChild(frame);
frame.src=src;
config.props.src=src;
return frame
}function checkAcl(acl,domain){if(typeof acl=="string"){acl=[acl]
}var re,i=acl.length;
while(i--){re=acl[i];
re=new RegExp(re.substr(0,1)=="^"?re:("^"+re.replace(/(\*)/g,".$1").replace(/\?/g,".")+"$"));
if(re.test(domain)){return true
}}return false
}function prepareTransportStack(config){var protocol=config.protocol,stackEls;
config.isHost=config.isHost||undef(query.xdm_p);
useHash=config.hash||false;
if(!config.props){config.props={}
}if(!config.isHost){config.channel=query.xdm_c;
config.secret=query.xdm_s;
config.remote=query.xdm_e;
protocol=query.xdm_p;
if(config.acl&&!checkAcl(config.acl,config.remote)){throw new Error("Access denied for "+config.remote)
}}else{config.remote=resolveUrl(config.remote);
config.channel=config.channel||"default"+channelId++;
config.secret=Math.random().toString(16).substring(2);
if(undef(protocol)){if(getLocation(location.href)==getLocation(config.remote)){protocol="4"
}else{if(isHostMethod(window,"postMessage")||isHostMethod(document,"postMessage")){protocol="1"
}else{if(isHostMethod(window,"ActiveXObject")&&hasFlash()){protocol="6"
}else{if(navigator.product==="Gecko"&&"frameElement" in window&&navigator.userAgent.indexOf("WebKit")==-1){protocol="5"
}else{if(config.remoteHelper){config.remoteHelper=resolveUrl(config.remoteHelper);
protocol="2"
}else{protocol="0"
}}}}}}}config.protocol=protocol;
switch(protocol){case"0":apply(config,{interval:100,delay:2000,useResize:true,useParent:false,usePolling:false},true);
if(config.isHost){if(!config.local){var domain=location.protocol+"//"+location.host,images=document.body.getElementsByTagName("img"),image;
var i=images.length;
while(i--){image=images[i];
if(image.src.substring(0,domain.length)===domain){config.local=image.src;
break
}}if(!config.local){config.local=window
}}var parameters={xdm_c:config.channel,xdm_p:0};
if(config.local===window){config.usePolling=true;
config.useParent=true;
config.local=location.protocol+"//"+location.host+location.pathname+location.search;
parameters.xdm_e=config.local;
parameters.xdm_pa=1
}else{parameters.xdm_e=resolveUrl(config.local)
}if(config.container){config.useResize=false;
parameters.xdm_po=1
}config.remote=appendQueryParameters(config.remote,parameters)
}else{apply(config,{channel:query.xdm_c,remote:query.xdm_e,useParent:!undef(query.xdm_pa),usePolling:!undef(query.xdm_po),useResize:config.useParent?false:config.useResize})
}stackEls=[new easyXDM.stack.HashTransport(config),new easyXDM.stack.ReliableBehavior({}),new easyXDM.stack.QueueBehavior({encode:true,maxLength:4000-config.remote.length}),new easyXDM.stack.VerifyBehavior({initiate:config.isHost})];
break;
case"1":stackEls=[new easyXDM.stack.PostMessageTransport(config)];
break;
case"2":stackEls=[new easyXDM.stack.NameTransport(config),new easyXDM.stack.QueueBehavior(),new easyXDM.stack.VerifyBehavior({initiate:config.isHost})];
break;
case"3":stackEls=[new easyXDM.stack.NixTransport(config)];
break;
case"4":stackEls=[new easyXDM.stack.SameOriginTransport(config)];
break;
case"5":stackEls=[new easyXDM.stack.FrameElementTransport(config)];
break;
case"6":if(!config.swf){config.swf="../../tools/easyxdm.swf"
}if(!flashVersion){hasFlash()
}stackEls=[new easyXDM.stack.FlashTransport(config)];
break
}stackEls.push(new easyXDM.stack.QueueBehavior({lazy:config.lazy,remove:true}));
return stackEls
}function chainStack(stackElements){var stackEl,defaults={incoming:function(message,origin){this.up.incoming(message,origin)
},outgoing:function(message,recipient){this.down.outgoing(message,recipient)
},callback:function(success){this.up.callback(success)
},init:function(){this.down.init()
},destroy:function(){this.down.destroy()
}};
for(var i=0,len=stackElements.length;
i<len;
i++){stackEl=stackElements[i];
apply(stackEl,defaults,true);
if(i!==0){stackEl.down=stackElements[i-1]
}if(i!==len-1){stackEl.up=stackElements[i+1]
}}return stackEl
}function removeFromStack(element){element.up.down=element.down;
element.down.up=element.up;
element.up=element.down=null
}apply(easyXDM,{version:"2.4.13.20",query:query,stack:{},apply:apply,getJSONObject:getJSON,whenReady:whenReady,noConflict:noConflict});
easyXDM.DomHelper={on:on,un:un,requiresJSON:function(path){if(!isHostObject(window,"JSON")){document.write("<"+'script type="text/javascript" src="'+path+'"><'+"/script>")
}}};
(function(){var _map={};
easyXDM.Fn={set:function(name,fn){_map[name]=fn
},get:function(name,del){var fn=_map[name];
if(del){delete _map[name]
}return fn
}}
}());
easyXDM.Socket=function(config){var stack=chainStack(prepareTransportStack(config).concat([{incoming:function(message,origin){config.onMessage(message,origin)
},callback:function(success){if(config.onReady){config.onReady(success)
}}}])),recipient=getLocation(config.remote);
this.origin=getLocation(config.remote);
this.destroy=function(){stack.destroy()
};
this.postMessage=function(message){stack.outgoing(message,recipient)
};
stack.init()
};
easyXDM.Rpc=function(config,jsonRpcConfig){if(jsonRpcConfig.local){for(var method in jsonRpcConfig.local){if(jsonRpcConfig.local.hasOwnProperty(method)){var member=jsonRpcConfig.local[method];
if(typeof member==="function"){jsonRpcConfig.local[method]={method:member}
}}}}var stack=chainStack(prepareTransportStack(config).concat([new easyXDM.stack.RpcBehavior(this,jsonRpcConfig),{callback:function(success){if(config.onReady){config.onReady(success)
}}}]));
this.origin=getLocation(config.remote);
this.destroy=function(){stack.destroy()
};
stack.init()
};
easyXDM.stack.SameOriginTransport=function(config){var pub,frame,send,targetOrigin;
return(pub={outgoing:function(message,domain,fn){send(message);
if(fn){fn()
}},destroy:function(){if(frame){frame.parentNode.removeChild(frame);
frame=null
}},onDOMReady:function(){targetOrigin=getLocation(config.remote);
if(config.isHost){apply(config.props,{src:appendQueryParameters(config.remote,{xdm_e:location.protocol+"//"+location.host+location.pathname,xdm_c:config.channel,xdm_p:4}),name:IFRAME_PREFIX+config.channel+"_provider"});
frame=createFrame(config);
easyXDM.Fn.set(config.channel,function(sendFn){send=sendFn;
setTimeout(function(){pub.up.callback(true)
},0);
return function(msg){pub.up.incoming(msg,targetOrigin)
}
})
}else{send=getParentObject().Fn.get(config.channel,true)(function(msg){pub.up.incoming(msg,targetOrigin)
});
setTimeout(function(){pub.up.callback(true)
},0)
}},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.FlashTransport=function(config){var pub,frame,send,targetOrigin,swf,swfContainer;
function onMessage(message,origin){setTimeout(function(){pub.up.incoming(message,targetOrigin)
},0)
}function addSwf(domain){var url=config.swf+"?host="+config.isHost;
var id="easyXDM_swf_"+Math.floor(Math.random()*10000);
easyXDM.Fn.set("flash_loaded"+domain.replace(/-\./g,"_"),function(){easyXDM.stack.FlashTransport[domain].swf=swf=swfContainer.firstChild;
var queue=easyXDM.stack.FlashTransport[domain].queue;
for(var i=0;
i<queue.length;
i++){queue[i]()
}queue.length=0
});
swfContainer=document.createElement("div");
apply(swfContainer.style,HAS_FLASH_THROTTLED_BUG?{height:"20px",width:"20px",position:"fixed",right:0,top:0}:{height:"1",width:"1",position:"absolute",overflow:"hidden",right:0,top:0});
document.body.appendChild(swfContainer);
var flashVars="callback=flash_loaded"+domain.replace(/-\./g,"_")+"&proto="+global.location.protocol+"&domain="+getDomainName(global.location.href)+"&port="+getPort(global.location.href)+"&ns="+namespace;
swfContainer.innerHTML="<object height='20' width='20' type='application/x-shockwave-flash' id='"+id+"' data='"+url+"'>"+"<param name='allowScriptAccess' value='always'></param>"+"<param name='wmode' value='transparent'>"+"<param name='movie' value='"+url+"'></param>"+"<param name='flashvars' value='"+flashVars+"'></param>"+"<embed type='application/x-shockwave-flash' FlashVars='"+flashVars+"' allowScriptAccess='always' wmode='transparent' src='"+url+"' height='1' width='1'></embed>"+"</object>"
}return(pub={outgoing:function(message,domain,fn){swf.postMessage(config.channel,message.toString());
if(fn){fn()
}},destroy:function(){try{swf.destroyChannel(config.channel)
}catch(e){}swf=null;
if(frame){frame.parentNode.removeChild(frame);
frame=null
}},onDOMReady:function(){targetOrigin=config.remote;
easyXDM.Fn.set("flash_"+config.channel+"_init",function(){setTimeout(function(){pub.up.callback(true)
})
});
easyXDM.Fn.set("flash_"+config.channel+"_onMessage",onMessage);
config.swf=resolveUrl(config.swf);
var swfdomain=getDomainName(config.swf);
var fn=function(){easyXDM.stack.FlashTransport[swfdomain].init=true;
swf=easyXDM.stack.FlashTransport[swfdomain].swf;
swf.createChannel(config.channel,config.secret,getLocation(config.remote),config.isHost);
if(config.isHost){apply(config.props,{src:appendQueryParameters(config.remote,{xdm_e:getLocation(location.href),xdm_c:config.channel,xdm_p:6,xdm_s:config.secret}),name:IFRAME_PREFIX+config.channel+"_provider"});
frame=createFrame(config)
}};
if(easyXDM.stack.FlashTransport[swfdomain]&&easyXDM.stack.FlashTransport[swfdomain].init){fn()
}else{if(!easyXDM.stack.FlashTransport[swfdomain]){easyXDM.stack.FlashTransport[swfdomain]={queue:[fn]};
addSwf(swfdomain)
}else{easyXDM.stack.FlashTransport[swfdomain].queue.push(fn)
}}},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.PostMessageTransport=function(config){var pub,frame,callerWindow,targetOrigin;
function _getOrigin(event){if(event.origin){return getLocation(event.origin)
}if(event.uri){return getLocation(event.uri)
}if(event.domain){return location.protocol+"//"+event.domain
}throw"Unable to retrieve the origin of the event"
}function _window_onMessage(event){var origin=_getOrigin(event);
if(origin==targetOrigin&&event.data.substring(0,config.channel.length+1)==config.channel+" "){pub.up.incoming(event.data.substring(config.channel.length+1),origin)
}}return(pub={outgoing:function(message,domain,fn){callerWindow.postMessage(config.channel+" "+message,domain||targetOrigin);
if(fn){fn()
}},destroy:function(){un(window,"message",_window_onMessage);
if(frame){callerWindow=null;
frame.parentNode.removeChild(frame);
frame=null
}},onDOMReady:function(){targetOrigin=getLocation(config.remote);
if(config.isHost){var waitForReady=function(event){if(event.data==config.channel+"-ready"){callerWindow=("postMessage" in frame.contentWindow)?frame.contentWindow:frame.contentWindow.document;
un(window,"message",waitForReady);
on(window,"message",_window_onMessage);
setTimeout(function(){pub.up.callback(true)
},0)
}};
on(window,"message",waitForReady);
apply(config.props,{src:appendQueryParameters(config.remote,{xdm_e:getLocation(location.href),xdm_c:config.channel,xdm_p:1}),name:IFRAME_PREFIX+config.channel+"_provider"});
frame=createFrame(config)
}else{on(window,"message",_window_onMessage);
callerWindow=("postMessage" in window.parent)?window.parent:window.parent.document;
callerWindow.postMessage(config.channel+"-ready",targetOrigin);
setTimeout(function(){pub.up.callback(true)
},0)
}},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.FrameElementTransport=function(config){var pub,frame,send,targetOrigin;
return(pub={outgoing:function(message,domain,fn){send.call(this,message);
if(fn){fn()
}},destroy:function(){if(frame){frame.parentNode.removeChild(frame);
frame=null
}},onDOMReady:function(){targetOrigin=getLocation(config.remote);
if(config.isHost){apply(config.props,{src:appendQueryParameters(config.remote,{xdm_e:getLocation(location.href),xdm_c:config.channel,xdm_p:5}),name:IFRAME_PREFIX+config.channel+"_provider"});
frame=createFrame(config);
frame.fn=function(sendFn){delete frame.fn;
send=sendFn;
setTimeout(function(){pub.up.callback(true)
},0);
return function(msg){pub.up.incoming(msg,targetOrigin)
}
}
}else{if(document.referrer&&getLocation(document.referrer)!=query.xdm_e){window.top.location=query.xdm_e
}send=window.frameElement.fn(function(msg){pub.up.incoming(msg,targetOrigin)
});
pub.up.callback(true)
}},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.NameTransport=function(config){var pub;
var isHost,callerWindow,remoteWindow,readyCount,callback,remoteOrigin,remoteUrl;
function _sendMessage(message){var url=config.remoteHelper+(isHost?"#_3":"#_2")+config.channel;
callerWindow.contentWindow.sendMessage(message,url)
}function _onReady(){if(isHost){if(++readyCount===2||!isHost){pub.up.callback(true)
}}else{_sendMessage("ready");
pub.up.callback(true)
}}function _onMessage(message){pub.up.incoming(message,remoteOrigin)
}function _onLoad(){if(callback){setTimeout(function(){callback(true)
},0)
}}return(pub={outgoing:function(message,domain,fn){callback=fn;
_sendMessage(message)
},destroy:function(){callerWindow.parentNode.removeChild(callerWindow);
callerWindow=null;
if(isHost){remoteWindow.parentNode.removeChild(remoteWindow);
remoteWindow=null
}},onDOMReady:function(){isHost=config.isHost;
readyCount=0;
remoteOrigin=getLocation(config.remote);
config.local=resolveUrl(config.local);
if(isHost){easyXDM.Fn.set(config.channel,function(message){if(isHost&&message==="ready"){easyXDM.Fn.set(config.channel,_onMessage);
_onReady()
}});
remoteUrl=appendQueryParameters(config.remote,{xdm_e:config.local,xdm_c:config.channel,xdm_p:2});
apply(config.props,{src:remoteUrl+"#"+config.channel,name:IFRAME_PREFIX+config.channel+"_provider"});
remoteWindow=createFrame(config)
}else{config.remoteHelper=config.remote;
easyXDM.Fn.set(config.channel,_onMessage)
}callerWindow=createFrame({props:{src:config.local+"#_4"+config.channel},onLoad:function onLoad(){var w=callerWindow||this;
un(w,"load",onLoad);
easyXDM.Fn.set(config.channel+"_load",_onLoad);
(function test(){if(typeof w.contentWindow.sendMessage=="function"){_onReady()
}else{setTimeout(test,50)
}}())
}})
},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.HashTransport=function(config){var pub;
var me=this,isHost,_timer,pollInterval,_lastMsg,_msgNr,_listenerWindow,_callerWindow;
var useParent,_remoteOrigin;
function _sendMessage(message){if(!_callerWindow){return
}var url=config.remote+"#"+(_msgNr++)+"_"+message;
((isHost||!useParent)?_callerWindow.contentWindow:_callerWindow).location=url
}function _handleHash(hash){_lastMsg=hash;
pub.up.incoming(_lastMsg.substring(_lastMsg.indexOf("_")+1),_remoteOrigin)
}function _pollHash(){if(!_listenerWindow){return
}var href=_listenerWindow.location.href,hash="",indexOf=href.indexOf("#");
if(indexOf!=-1){hash=href.substring(indexOf)
}if(hash&&hash!=_lastMsg){_handleHash(hash)
}}function _attachListeners(){_timer=setInterval(_pollHash,pollInterval)
}return(pub={outgoing:function(message,domain){_sendMessage(message)
},destroy:function(){window.clearInterval(_timer);
if(isHost||!useParent){_callerWindow.parentNode.removeChild(_callerWindow)
}_callerWindow=null
},onDOMReady:function(){isHost=config.isHost;
pollInterval=config.interval;
_lastMsg="#"+config.channel;
_msgNr=0;
useParent=config.useParent;
_remoteOrigin=getLocation(config.remote);
if(isHost){config.props={src:config.remote,name:IFRAME_PREFIX+config.channel+"_provider"};
if(useParent){config.onLoad=function(){_listenerWindow=window;
_attachListeners();
pub.up.callback(true)
}
}else{var tries=0,max=config.delay/50;
(function getRef(){if(++tries>max){throw new Error("Unable to reference listenerwindow")
}try{_listenerWindow=_callerWindow.contentWindow.frames[IFRAME_PREFIX+config.channel+"_consumer"]
}catch(ex){}if(_listenerWindow){_attachListeners();
pub.up.callback(true)
}else{setTimeout(getRef,50)
}}())
}_callerWindow=createFrame(config)
}else{_listenerWindow=window;
_attachListeners();
if(useParent){_callerWindow=parent;
pub.up.callback(true)
}else{apply(config,{props:{src:config.remote+"#"+config.channel+new Date(),name:IFRAME_PREFIX+config.channel+"_consumer"},onLoad:function(){pub.up.callback(true)
}});
_callerWindow=createFrame(config)
}}},init:function(){whenReady(pub.onDOMReady,pub)
}})
};
easyXDM.stack.ReliableBehavior=function(config){var pub,callback;
var idOut=0,idIn=0,currentMessage="";
return(pub={incoming:function(message,origin){var indexOf=message.indexOf("_"),ack=message.substring(0,indexOf).split(",");
message=message.substring(indexOf+1);
if(ack[0]==idOut){currentMessage="";
if(callback){callback(true)
}}if(message.length>0){pub.down.outgoing(ack[1]+","+idOut+"_"+currentMessage,origin);
if(idIn!=ack[1]){idIn=ack[1];
pub.up.incoming(message,origin)
}}},outgoing:function(message,origin,fn){currentMessage=message;
callback=fn;
pub.down.outgoing(idIn+","+(++idOut)+"_"+message,origin)
}})
};
easyXDM.stack.QueueBehavior=function(config){var pub,queue=[],waiting=true,incoming="",destroying,maxLength=0,lazy=false,doFragment=false;
function dispatch(){if(config.remove&&queue.length===0){removeFromStack(pub);
return
}if(waiting||queue.length===0||destroying){return
}waiting=true;
var message=queue.shift();
pub.down.outgoing(message.data,message.origin,function(success){waiting=false;
if(message.callback){setTimeout(function(){message.callback(success)
},0)
}dispatch()
})
}return(pub={init:function(){if(undef(config)){config={}
}if(config.maxLength){maxLength=config.maxLength;
doFragment=true
}if(config.lazy){lazy=true
}else{pub.down.init()
}},callback:function(success){waiting=false;
var up=pub.up;
dispatch();
up.callback(success)
},incoming:function(message,origin){if(doFragment){var indexOf=message.indexOf("_"),seq=parseInt(message.substring(0,indexOf),10);
incoming+=message.substring(indexOf+1);
if(seq===0){if(config.encode){incoming=decodeURIComponent(incoming)
}pub.up.incoming(incoming,origin);
incoming=""
}}else{pub.up.incoming(message,origin)
}},outgoing:function(message,origin,fn){if(config.encode){message=encodeURIComponent(message)
}var fragments=[],fragment;
if(doFragment){while(message.length!==0){fragment=message.substring(0,maxLength);
message=message.substring(fragment.length);
fragments.push(fragment)
}while((fragment=fragments.shift())){queue.push({data:fragments.length+"_"+fragment,origin:origin,callback:fragments.length===0?fn:null})
}}else{queue.push({data:message,origin:origin,callback:fn})
}if(lazy){pub.down.init()
}else{dispatch()
}},destroy:function(){destroying=true;
pub.down.destroy()
}})
};
easyXDM.stack.VerifyBehavior=function(config){var pub,mySecret,theirSecret,verified=false;
function startVerification(){mySecret=Math.random().toString(16).substring(2);
pub.down.outgoing(mySecret)
}return(pub={incoming:function(message,origin){var indexOf=message.indexOf("_");
if(indexOf===-1){if(message===mySecret){pub.up.callback(true)
}else{if(!theirSecret){theirSecret=message;
if(!config.initiate){startVerification()
}pub.down.outgoing(message)
}}}else{if(message.substring(0,indexOf)===theirSecret){pub.up.incoming(message.substring(indexOf+1),origin)
}}},outgoing:function(message,origin,fn){pub.down.outgoing(mySecret+"_"+message,origin,fn)
},callback:function(success){if(config.initiate){startVerification()
}}})
};
easyXDM.stack.RpcBehavior=function(proxy,config){var pub,serializer=config.serializer||getJSON();
var _callbackCounter=0,_callbacks={};
function _send(data){data.jsonrpc="2.0";
pub.down.outgoing(serializer.stringify(data))
}function _createMethod(definition,method){var slice=Array.prototype.slice;
return function(){var l=arguments.length,callback,message={method:method};
if(l>0&&isCallableFunction(arguments[l-1])){if(l>1&&isCallableFunction(arguments[l-2])){callback={success:arguments[l-2],error:arguments[l-1]};
message.params=slice.call(arguments,0,l-2)
}else{callback={success:arguments[l-1]};
message.params=slice.call(arguments,0,l-1)
}_callbacks[""+(++_callbackCounter)]=callback;
message.id=_callbackCounter
}else{message.params=slice.call(arguments,0)
}if(definition.namedParams&&message.params.length===1){message.params=message.params[0]
}_send(message)
}
}function _executeMethod(method,id,fn,params){if(!fn){if(id){_send({id:id,error:{code:-32601,message:"Procedure not found."}})
}return
}var success,error;
if(id){success=function(result){success=emptyFn;
_send({id:id,result:result})
};
error=function(message,data){error=emptyFn;
var msg={id:id,error:{code:-32099,message:message}};
if(data){msg.error.data=data
}_send(msg)
}
}else{success=error=emptyFn
}if(!isArray(params)){params=[params]
}try{var result=fn.method.apply(fn.scope,params.concat([success,error]));
if(!undef(result)){success(result)
}}catch(ex1){error(ex1.message)
}}return(pub={incoming:function(message,origin){var data=serializer.parse(message);
if(data.method){if(config.handle){config.handle(data,_send)
}else{_executeMethod(data.method,data.id,config.local[data.method],data.params)
}}else{var callback=_callbacks[data.id];
if(data.error){if(callback.error){callback.error(data.error)
}}else{if(callback.success){callback.success(data.result)
}}delete _callbacks[data.id]
}},init:function(){if(config.remote){for(var method in config.remote){if(config.remote.hasOwnProperty(method)){proxy[method]=_createMethod(config.remote[method],method)
}}}pub.down.init()
},destroy:function(){for(var method in config.remote){if(config.remote.hasOwnProperty(method)&&proxy.hasOwnProperty(method)){delete proxy[method]
}}pub.down.destroy()
}})
};
global.easyXDM=easyXDM
})(window,document,location,window.setTimeout,decodeURIComponent,encodeURIComponent);

/* res://connect-min/dev/connect/core.js */

IN=window.IN||{};
if(!window.console){window.console={log:function(){}}
}(function(){if(!IN.ENV||!IN.ENV||!IN.ENV.js){return
}var g=IN.ENV.js.extensions||{},f,d=IN.ENV.url.base_js_url,a=/PATH_INFO/,e=IN.$extensions;
IN.$extensions=function(i,h){if(!h){return e(i)
}IN.Event.on(IN,"frameworkLoaded",function(){h();
IN.ENV.js.extensions[i].loaded=true
})
};
for(var b in g){var c=g[b];
if(c.loaded){continue
}f=document.createElement("script");
f.type="text/javascript";
f.src=c.src||d.replace(a,"extensions/"+b);
document.getElementsByTagName("head")[0].appendChild(f)
}})();
Sslac.Function("IN.$Tag",function(b,a){a=a||document;
return a.getElementsByTagName(b)
});
Sslac.Function("IN.$Id",function(a){return(typeof(a)=="string")?document.getElementById(a):a
});
Sslac.Function("IN.$Class",function(c,b,d){var a=function(f,e,g){if(document.getElementsByClassName){a=function(n,q,m){m=m||document;
var h=m.getElementsByClassName(n),p=(q)?new RegExp("\\b"+q+"\\b","i"):null,j=[],l;
for(var k=0,o=h.length;
k<o;
k+=1){l=h[k];
if(!p||p.test(l.nodeName)){j.push(l)
}}return j
}
}else{if(document.evaluate){a=function(r,u,q){u=u||"*";
q=q||document;
var k=r.split(" "),s="",o="http://www.w3.org/1999/xhtml",t=(document.documentElement.namespaceURI===o)?o:null,l=[],h,i;
for(var m=0,n=k.length;
m<n;
m+=1){s+="[contains(concat(' ', @class, ' '), ' "+k[m]+" ')]"
}try{h=document.evaluate(".//"+u+s,q,t,0,null)
}catch(p){h=document.evaluate(".//"+u+s,q,null,0,null)
}while((i=h.iterateNext())){l.push(i)
}return l
}
}else{a=function(v,y,u){y=y||"*";
u=u||document;
var o=v.split(" "),x=[],h=(y==="*"&&u.all)?u.all:u.getElementsByTagName(y),t,q=[],s;
for(var p=0,i=o.length;
p<i;
p+=1){x.push(new RegExp("(^|\\s)"+o[p]+"(\\s|$)"))
}for(var n=0,w=h.length;
n<w;
n+=1){t=h[n];
s=false;
for(var j=0,r=x.length;
j<r;
j+=1){s=x[j].test(t.className);
if(!s){break
}}if(s){q.push(t)
}}return q
}
}}return a(f,e,g)
};
return a(c,b,d)
});
(function(){var b=0;
var a="li_gen_";
Sslac.Function("IN.$uid",function(d){var c=((d)?d+"_":"")+a+(new Date()).getTime()+"_"+(b++);
return c
})
})();
(function(){var a=function(b,c,f,e){var d;
return function(){if(c){window.setTimeout(function(){window[b]=d
},50)
}f.apply(e,arguments)
}
};
Sslac.Function("IN.$fn",function(e,d,c){var b=IN.$uid("fn");
window[b]=a(b,c,e,d);
return b
})
})();

/* res://connect-min/dev/lib/easyxdm_noconflict.js */

IN.Lib=IN.Lib||{};
IN.Lib.easyXDM=easyXDM.noConflict("IN.Lib");

/* res://connect-min/dev/event/custom.js */

Sslac.Class("IN.CustomEvent").Constructor(function(a,b){this.occursOnlyOnce=(b)?true:false;
this.fired=false;
this.firedArgs=[];
this.name=a;
this.events=[]
}).Method("unsubscribe",function(f,h,c,b){var j=this.events;
var a=[];
for(var d=0,e=j.length;
d<e;
d++){var g=j[d];
if(g.fn!==f||g.scope!==h||g.obj!==c||g.once!==b){a.push(g)
}}this.events=a
}).Method("subscribe",function(e,d,f,c){var a={fn:e,scope:d,obj:f,once:c};
var b=this.firedArgs;
if(this.fired&&this.occursOnlyOnce){b.push((a.obj||{}));
a.fn.apply((a.scope||window),b)
}else{this.events[this.events.length]=a
}}).Method("fire",function(){if(this.fired&&this.occursOnlyOnce){return false
}var e=[];
this.firedArgs=[].slice.apply(arguments);
this.fired=true;
for(var d=0,a=this.events.length;
d<a;
d++){var b=this.events[d];
var c=[].slice.apply(arguments);
c.push((b.obj||{}));
if(!b.once){e.push(b)
}b.fn.apply((b.scope||window),c)
}this.events=e
});

/* res://connect-min/dev/event/global.js */

Sslac.Static("IN.GlobalEvents");
IN.GlobalEvents.auth=new IN.CustomEvent("auth");
IN.GlobalEvents.noAuth=new IN.CustomEvent("noAuth");
IN.GlobalEvents.logout=new IN.CustomEvent("logout");
IN.GlobalEvents.refresh=new IN.CustomEvent("refresh");
IN.GlobalEvents.systemReady=new IN.CustomEvent("systemReady",true);
IN.GlobalEvents.frameworkLoaded=new IN.CustomEvent("frameworkLoaded",true);

/* res://connect-min/dev/event/event.js */

IN.Event=null;
(function(){var h={};
var g=null;
function c(r,m,p){if(!p.preventDefault){p.preventDefault=function(){p.returnValue=false
}
}if(!p.stopPropagation){p.stopPropagation=function(){p.cancelBubble=true
}
}if(!p.stopEvent){p.stopEvent=function(){p.preventDefault();
p.stopPropagation()
}
}var l=h[r][m];
var k=l.el;
var j=[];
for(var n=0,o=l.length;
n<o;
n++){var q=l[n];
q.fn.call((q.scope||k),p,q.obj);
if(!q.fireOnce){j.push(q)
}}h[r][m]=j
}Sslac.Static("IN.Event").Static("remove",function(l,m,v,z,q,o){var t=IN.Event.getElType(l);
var u=m.toLowerCase();
switch(t){case"string":l=IN.$Id(l);
case"html":var y=IN.Event.getElKey(l);
if(!h[y]||!h[y][u]){return
}var n=h[y][u];
var k=[];
for(var p=0,r=n.length;
p<r;
p++){var x=n[p];
if(x.el!==l||x.fn!==v||x.scope!==z||x.obj!==q||x.fireOnce!==o){k.push(x)
}}h[y][u]=k;
break;
case"uiObject":try{var j="un"+m.charAt(0).toUpperCase()+m.substr(1);
if(l[j]){l[j](v,z,q,o)
}else{l[j.toLowerCase()](v,z,q,o)
}}catch(s){}break;
case"globalEvent":var w=IN.GlobalEvents[m];
if(!w){throw new Error("Global Event "+m+" is not defined.")
}return w.unsubscribe(v,z,q,o);
break
}}).Static("getElKey",function(i){if(!i.getAttribute){return i
}var j=i.id||i.getAttribute("data-IN-event-id");
if(!j){j=IN.$uid();
i.setAttribute("data-IN-event-id",j)
}return"k"+j
}).Static("getElType",function(i){if(typeof(i)=="string"){return"string"
}if(i!==window&&(typeof(i)=="function"||typeof(i)=="object")){try{var j=(i instanceof IN.Objects.Base);
if(j){return"uiObject"
}}catch(k){}}if(i===IN){return"globalEvent"
}return"html"
}).Static("onOnce",function(k,m,j,i,l){return IN.Event.on(k,m,j,i,l,true)
}).Static("on",function(k,l,u,y,n,m){try{if(k&&k.constructor&&k.constructor.toString().indexOf("Array")>-1){for(var o=0,q=k.length;
o<q;
o++){IN.Event.on(k[o],l,u,y,n,m)
}return
}}catch(r){}var s=IN.Event.getElType(k);
var p=false;
var t=l.toLowerCase();
switch(s){case"string":k=IN.$Id(k);
case"html":var x=IN.Event.getElKey(k);
if(!h[x]){h[x]={el:k}
}if(!h[x][t]){h[x][t]=[];
p=true
}h[x][t].push({fn:u,scope:y,obj:n,fireOnce:m});
if(p){var w=function(i){c(x,t,i)
};
if(window.addEventListener){k.addEventListener(l,w,false)
}else{k.attachEvent("on"+l,w)
}}break;
case"uiObject":try{var j="on"+l.charAt(0).toUpperCase()+l.substr(1);
if(k[j]){k[j](u,y,n,m)
}else{k[j.toLowerCase()](u,y,n,m)
}}catch(r){}break;
case"globalEvent":var v=IN.GlobalEvents[l];
if(!v){throw new Error("Global Event "+l+" is not defined.")
}return v.subscribe(u,y,n,m);
break
}}).Static("onDOMReady",function(){var k=[];
var m=null;
var l=false;
function n(r,q){q=q||window;
if(l){r.call(q);
return
}else{k[k.length]={fn:r,scope:q}
}}function p(){var r;
for(var s=0,q=k.length;
s<q;
s++){r=k[s];
r.fn.call(r.scope)
}}function j(q){if(q&&(q.type=="DOMContentLoaded"||q.type=="load")){i()
}if(document.readyState){if((/loaded|complete/).test(document.readyState)){i()
}}if(document.documentElement.doScroll&&window==window.top){try{l||document.documentElement.doScroll("left");
i()
}catch(q){}}}function i(){if(!l){l=true;
if(document.removeEventListener){document.removeEventListener("DOMContentLoaded",j,false)
}document.onreadystatechange=null;
clearInterval(timer);
timer=null;
p()
}}if(document.addEventListener){document.addEventListener("DOMContentLoaded",j,false)
}document.onreadystatechange=j;
timer=setInterval(j,5);
if(window.onload){var o=window.onload;
if(IN.ENV.evtQueue){IN.ENV.evtQueue.push({type:"on",args:[window,"load",o]})
}else{IN.Event.on(window,"load",o)
}}window.onload=j;
return n
}());
if(IN.ENV&&IN.ENV.evtQueue){for(var d=0,a=IN.ENV.evtQueue.length;
d<a;
d++){var f=IN.ENV.evtQueue[d],e=IN.Event[f.type],b=f.args;
e.apply(window,b)
}IN.ENV.evtQueue=null
}})();

/* res://connect-min/dev/util/util.js */

Sslac.Function("IN.Util.trim",function(b,a){a=a||"\\s";
return b.replace(new RegExp("^(?:"+a+")+|(?:"+a+")+$","g"),"")
});
Sslac.Function("IN.Util.findIn",function(f,e){var d=e.split(/\./),b=f;
for(var c=0,a=d.length;
c<a;
c++){if(!b[d[c]]){throw new Error("not found")
}b=b[d[c]]
}return b
});
Sslac.Function("IN.Util.assembleRootURL",function(a){return a.protocol+"://"+a.host+((a.port)?":"+a.port:"")
});
Sslac.Function("IN.Util.getRootURL",function(a){var b=IN.Util.getRootURLObject(a);
return IN.Util.assembleRootURL(b)
});
Sslac.Function("IN.Util.getRootDomain",function(a){var b=IN.Util.getRootURLObject(a);
return b.host
});
Sslac.Function("IN.Util.getRootURLObject",function(b){b=b||location.href;
if(b.indexOf("//")==0){b=window.location.protocol+b
}if(b.indexOf("://")==-1){b=window.location.protocol+"//"+b
}var c=b.substring(b.indexOf("://")+3);
var e=b.substring(0,b.indexOf("://")).toLowerCase();
c=(c.indexOf("/")!=-1)?c.substring(0,c.indexOf("/")):c;
var d=c.indexOf(":");
var a="";
if(d>=0){a=c.substring(d+1);
c=c.substring(0,d)
}if((a==="80"&&e==="http")||(a==="443"&&e==="https")){a=""
}return{protocol:e,host:c,port:a}
});
Sslac.Function("IN.Util.getDebuggerUrl",function(){try{return window.location.href.replace(window.location.hash,"").replace(document.domain,"").replace(/https?:\/\//g,"")
}catch(a){return(window.opener)?"[spawned window]":(window.parent&&window.self!=window.parent)?"[spawned frame]":"[parent window]"
}});
(function(){var a;
Sslac.Function("IN.Util.addCSS",function(c){if(document.createStyleSheet){try{document.createStyleSheet().cssText=c
}catch(d){try{document.styleSheets[0].cssText+=c
}catch(b){}}}else{if(!a){a=document.createElement("style");
a.type="text/css";
document.getElementsByTagName("head")[0].appendChild(a)
}a.textContent=[a.textContent,c].join("")
}})
})();
(function(){var b={};
function a(c){if(!b[c]){b[c]=new RegExp("(\\s|^)"+c+"(\\s|$)")
}return b[c]
}Sslac.Function("IN.Util.hasClass",function(d,c){return(d&&d.className&&d.className.match(a(c)))
});
Sslac.Function("IN.Util.addClass",function(d,c){if(!IN.Util.hasClass(d,c)){d.className=IN.Util.trim(d.className+" "+c)
}});
Sslac.Function("IN.Util.removeClass",function(d,c){var e="";
if(IN.Util.hasClass(d,c)){e=IN.Util.trim(d.className.replace(a(c)," "));
if(e){d.className=e
}else{d.className="";
d.removeAttribute("class");
d.removeAttribute("className")
}}})
})();
Sslac.Function("IN.Util.isArray",function(a){if(!a||!a.constructor){return false
}return !(a.constructor.toString().indexOf("Array")==-1)
});
Sslac.Function("IN.Util.isNode",function(a){return(typeof Node==="object"?a instanceof Node:typeof a==="object"&&typeof a.nodeType==="number"&&typeof a.nodeName==="string")
});
Sslac.Function("IN.Util.isElement",function(a){return(typeof HTMLElement==="object"?a instanceof HTMLElement:typeof a==="object"&&a.nodeType===1&&typeof a.nodeName==="string")
});
Sslac.Function("IN.Util.toObject",function(e,k,a){var c={},h,l,g;
k=k||[];
if(!e||e.legth<=0){return c
}if(typeof(k)=="string"||typeof(k)=="function"){k=[k]
}for(var d=0,f=e.length;
d<f;
d++){l=e[d];
h=d;
for(var b=k.length-1;
b>=0;
b--){g=l[k[b]];
if(typeof(g)=="function"){g=g(d);
if(g){h=g
}}else{if(typeof(g)!="undefined"){h=g
}}}h=""+h;
if(a){h=a(d,h)
}c[h]=l
}return c
});
Sslac.Function("IN.Util.parseParams",function(h){var c={},j,d,a,g;
for(var e=0,b=h.split("&"),f=b.length;
e<f;
e++){j=b[e];
d=j.split("=");
a=decodeURIComponent(d.splice(0,1));
g=decodeURIComponent(d.join("="));
c[a]=g
}return c
});
Sslac.Function("IN.Util.createParams",function(g){var d=[],f=0;
for(var c in g){if(c==="type"&&IN.Util.isArray(g[c])){var e=g[c];
for(var b=0,a=e.length;
b<a;
b++){d[f++]=encodeURIComponent(c)+"="+encodeURIComponent(e[b])
}}else{d[f++]=encodeURIComponent(c)+"="+encodeURIComponent(g[c])
}}return d.join("&")
});
Sslac.Function("IN.Util.base64encode",function(f,h){var a=(h)?"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=":"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
var d=[],g,c,b,m,l,k,j;
for(var e=0;
e<f.length;
){g=f.charCodeAt(e++);
c=f.charCodeAt(e++);
b=f.charCodeAt(e++);
m=g>>2;
l=((g&3)<<4)+(c>>4);
k=((c&15)<<2)+(b>>6);
j=b&63;
if(isNaN(c)){k=j=64
}else{if(isNaN(b)){j=64
}}d[d.length]=a.charAt(m)+a.charAt(l)+a.charAt(k)+a.charAt(j)
}return d.join("")
});
Sslac.Function("IN.Util.base64decode",function(f,h){var a=(h)?"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=":"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
var d=[],g,c,b,m,l,k,j;
for(var e=0;
e<f.length;
){m=a.indexOf(f.charAt(e++));
l=a.indexOf(f.charAt(e++));
k=a.indexOf(f.charAt(e++));
j=a.indexOf(f.charAt(e++));
g=(m<<2)+(l>>4);
c=((l&15)<<4)+(k>>2);
b=((k&3)<<6)+j;
d[d.length]=String.fromCharCode(g);
if(k!=64){d[d.length]=String.fromCharCode(c)
}if(j!=64){d[d.length]=String.fromCharCode(b)
}}return d.join("")
});
(function(){var a=["00000000 77073096 EE0E612C 990951BA 076DC419 706AF48F E963A535 9E6495A3 0EDB8832 79DCB8A4","E0D5E91E 97D2D988 09B64C2B 7EB17CBD E7B82D07 90BF1D91 1DB71064 6AB020F2 F3B97148 84BE41DE","1ADAD47D 6DDDE4EB F4D4B551 83D385C7 136C9856 646BA8C0 FD62F97A 8A65C9EC 14015C4F 63066CD9","FA0F3D63 8D080DF5 3B6E20C8 4C69105E D56041E4 A2677172 3C03E4D1 4B04D447 D20D85FD A50AB56B","35B5A8FA 42B2986C DBBBC9D6 ACBCF940 32D86CE3 45DF5C75 DCD60DCF ABD13D59 26D930AC 51DE003A","C8D75180 BFD06116 21B4F4B5 56B3C423 CFBA9599 B8BDA50F 2802B89E 5F058808 C60CD9B2 B10BE924","2F6F7C87 58684C11 C1611DAB B6662D3D 76DC4190 01DB7106 98D220BC EFD5102A 71B18589 06B6B51F","9FBFE4A5 E8B8D433 7807C9A2 0F00F934 9609A88E E10E9818 7F6A0DBB 086D3D2D 91646C97 E6635C01","6B6B51F4 1C6C6162 856530D8 F262004E 6C0695ED 1B01A57B 8208F4C1 F50FC457 65B0D9C6 12B7E950","8BBEB8EA FCB9887C 62DD1DDF 15DA2D49 8CD37CF3 FBD44C65 4DB26158 3AB551CE A3BC0074 D4BB30E2","4ADFA541 3DD895D7 A4D1C46D D3D6F4FB 4369E96A 346ED9FC AD678846 DA60B8D0 44042D73 33031DE5","AA0A4C5F DD0D7CC9 5005713C 270241AA BE0B1010 C90C2086 5768B525 206F85B3 B966D409 CE61E49F","5EDEF90E 29D9C998 B0D09822 C7D7A8B4 59B33D17 2EB40D81 B7BD5C3B C0BA6CAD EDB88320 9ABFB3B6","03B6E20C 74B1D29A EAD54739 9DD277AF 04DB2615 73DC1683 E3630B12 94643B84 0D6D6A3E 7A6A5AA8","E40ECF0B 9309FF9D 0A00AE27 7D079EB1 F00F9344 8708A3D2 1E01F268 6906C2FE F762575D 806567CB","196C3671 6E6B06E7 FED41B76 89D32BE0 10DA7A5A 67DD4ACC F9B9DF6F 8EBEEFF9 17B7BE43 60B08ED5","D6D6A3E8 A1D1937E 38D8C2C4 4FDFF252 D1BB67F1 A6BC5767 3FB506DD 48B2364B D80D2BDA AF0A1B4C","36034AF6 41047A60 DF60EFC3 A867DF55 316E8EEF 4669BE79 CB61B38C BC66831A 256FD2A0 5268E236","CC0C7795 BB0B4703 220216B9 5505262F C5BA3BBE B2BD0B28 2BB45A92 5CB36A04 C2D7FFA7 B5D0CF31","2CD99E8B 5BDEAE1D 9B64C2B0 EC63F226 756AA39C 026D930A 9C0906A9 EB0E363F 72076785 05005713","95BF4A82 E2B87A14 7BB12BAE 0CB61B38 92D28E9B E5D5BE0D 7CDCEFB7 0BDBDF21 86D3D2D4 F1D4E242","68DDB3F8 1FDA836E 81BE16CD F6B9265B 6FB077E1 18B74777 88085AE6 FF0F6A70 66063BCA 11010B5C","8F659EFF F862AE69 616BFFD3 166CCF45 A00AE278 D70DD2EE 4E048354 3903B3C2 A7672661 D06016F7","4969474D 3E6E77DB AED16A4A D9D65ADC 40DF0B66 37D83BF0 A9BCAE53 DEBB9EC5 47B2CF7F 30B5FFE9","BDBDF21C CABAC28A 53B39330 24B4A3A6 BAD03605 CDD70693 54DE5729 23D967BF B3667A2E C4614AB8","5D681B02 2A6F2B94 B40BBE37 C30C8EA1 5A05DF1B 2D02EF8D"].join(" ");
Sslac.Function("IN.Util.crc32",function(f){var e=0,g=0,c=0;
e=e^(-1);
for(var d=0,b=f.length;
d<b;
d++){g=(e^f.charCodeAt(d))&255;
c="0x"+a.substr(g*9,8);
e=(e>>>8)^c
}return e^(-1)
})
})();
Sslac.Function("IN.Util.RC4",function(r,n,d){var h=[];
var l,k,m,a;
var o=r.length,p=n.length;
var g;
var c="0123456789abcdef";
var b=new Array();
d=d||20;
function e(j,q,i){var s=j[q];
j[q]=j[i];
j[i]=s
}for(l=0;
l<256;
l++){h[l]=l;
b[l]=((l<16)?"0":"")+l.toString(16)
}for(l=0;
l<256;
l++){k=(k+h[l]+r.charCodeAt(l%o))%256;
e(h,l,k)
}l=0;
k=0;
g=[];
for(a=0;
a<d;
a++){l=(l+1)%256;
k=(k+h[l])%256;
e(h,l,k)
}for(a=0;
a<p;
a++){l=(l+1)%256;
k=(k+h[l])%256;
e(h,l,k);
var f=String.fromCharCode(n.charCodeAt(a)^h[(h[l]+h[k])%256]);
g[g.length]=b[f.charCodeAt(0)]
}return g.join("")
});
Sslac.Function("IN.Util.getHashParams",function(){function g(j){var l=j+"=";
var e=document.cookie.split(";");
for(var k=0;
k<e.length;
k++){var m=e[k];
while(m.charAt(0)==" "){m=m.substring(1,m.length)
}if(m.indexOf(l)==0){return m.substring(l.length,m.length)
}}return null
}var a=window.name.replace(/[^a-z0-9]/gi,"_");
var f=window.location.hash.substring(1);
if(!f||f.indexOf("=")===-1){f=g("IN_HASH");
if(f){f=decodeURIComponent(f)
}}if(!f||f.indexOf("=")===-1){f=window.IN_HASH
}if(!f||f.indexOf("=")===-1){return function(){return false
}
}document.cookie="IN_HASH="+encodeURIComponent(f);
var h=IN.Util.parseParams(f);
var i={};
for(var b in h){var c=h[b];
i[b]=c;
if((b!="access_token")&&(b!="oauth_token")&&c.match(/^(?:[A-Za-z0-9+\/]{4})*(?:[A-Za-z0-9+\/]{2}==|[A-Za-z0-9+\/]{3}=)?$/)){c=IN.Util.base64decode(c)
}try{c=JSON.parse(c)
}catch(d){}h[b]=c
}return function(e){return(e)?i:h
}
}());
Sslac.Function("IN.Util.throwWarning",function(a){if(!a){return
}console=console||{};
console.warn=console.warn||(console.log||function(){});
console.warn(a)
});
Sslac.Function("IN.Util.extendObject",function(){var f=arguments[0]||{};
if(typeof f!=="object"){f={}
}for(var b=1,c=arguments.length;
b<c;
b++){var e=arguments[b];
if(e){for(key in e){var d=f[key];
var a=e[key];
if(f===a){continue
}if(a&&(typeof a==="object"||IN.Util.isArray(a))){var g=d||{};
f[key]=IN.Util.extendObject(g,a)
}else{if(typeof(a)!=="undefined"){f[key]=a
}}}}}return f
});
Sslac.Function("IN.Util.clone",function(c){if(!IN.Util.isArray(c)){return IN.Util.extendObject({},c)
}else{var d=[];
for(var b=0,a=c.length;
b--;
){d[b]=c[b]
}}});
Sslac.Function("IN.Util.toArray",function(a){if(!IN.Util.isArray(a)){a=[a]
}return a
});
Sslac.Function("IN.Util.formatString",function(){var a=arguments;
var b=a[0].replace(/{(\d+)}/g,function(c,d){d=Number(d);
return(typeof a[1+d]!=="undefined")?a[1+d]:"{"+d+"}"
});
return b
});
Sslac.Function("IN.Util.computeGradientStyle",function(p,o){p=p.toLowerCase();
var m;
o=IN.Util.toArray(o);
var d=o.length;
var n={webkit:["-webkit-gradient(linear, left top, left bottom, {0})","-webkit-"],gecko:"-moz-",msieold:"progid:DXImageTransform.Microsoft.gradient({0}, GradientType=0)",msie:"-ms-",opera:"-o-",w3c:"linear-gradient(top, {0})"};
var l=n[p]||n.w3c;
l=IN.Util.toArray(l);
var q=l.length;
for(var g=q;
g--;
){if(l[g].length<10){l[g]=l[g]+n.w3c
}}var h={webkit:"color-stop({0}%,{1})",msieold:"startColorstr='{0}', endColorstr='{1}'",w3c:"{1} {0}%"};
h.webkit=[h.webkit,h.w3c];
h=h[p]||h.w3c;
function c(r){var j={};
var i=o[r].split(":");
if(i.length>1){j.stop=i[0];
j.color=i[1]
}else{j.color=i[0];
j.stop=Math.round(r/(d-1)*100)
}return j
}if(p==="msieold"){var a=c(0).color;
var e=c(d-1).color;
var k=IN.Util.formatString(h,a,e);
m=IN.Util.formatString(l[0],k)
}else{h=IN.Util.toArray(h);
m=[];
for(var g=0;
g<q;
g++){var b=[];
for(var f=0;
f<d;
f++){var k=c(f);
b.push(IN.Util.formatString(h[g],k.stop,k.color))
}b=b.join(", ");
m.push(IN.Util.formatString(l[g],b))
}m=m.join(" !important; background-image: ")
}return m
});
Sslac.Function("IN.Util.relativeTime",function(h){var b=+new Date();
var k=+new Date().getTimezoneOffset()*60;
var d=b+k;
var a=Math.round((d-h)/1000);
if(a>31556916){var f=new Date(h);
var c=["January","February","March","April","May","June","July","August","September","October","November","December"];
return IN.Util.formatString("on {0} {1}, {2}",c[f.getMonth()],f.getDate(),f.getFullYear())
}else{if(a<=0){return""
}}var g=[{seconds:60,unit:"minute"},{seconds:3600,unit:"hour"},{seconds:86400,unit:"day"},{seconds:604800,unit:"week"},{seconds:2629743,unit:"month"}];
var j,e;
for(j=g.length-1;
(j>=0)&&((e=a/g[j].seconds)<=1);
j--){}if(j<0){j=0
}e=Math.floor(e);
if(e<1){e=1
}var i=(e===1)?"":"s";
return[Math.floor(e),""+g[j].unit+i,"ago"].join(" ")
});
(function(){var a={},c="___JS_REPLACE___",g="___END_JS_REPLACE___",i=/^\n*/,d=/\n*$/,j=/"/g,h=/___JS_REPLACE___=(.+?)___END_JS_REPLACE___/g,e=/("(?:(?!___JS_REPLACE___).)*)___END_JS_REPLACE___/g,f=/[-[\]{}()*+?.,\\^$|#\s]/g;
function k(l){return l.replace(j,"\r")
}function b(l){return l.replace(f,"\\$&")
}Sslac.Function("IN.Util.createJSTemplate",function(q,l){var m="t"+Math.abs(IN.Util.crc32(q));
if(a[m]){return a[m]
}if(!l&&IN.ENV&&IN.ENV.js&&IN.ENV.js.templateMarkers){l=IN.ENV.js.templateMarkers
}l=l||"<?js ?>";
l=l.split(" ");
var p=l[0]||"<?js",o=l[1]||"?>";
if(!p||!o){throw new Error("Template markers must be set.")
}if(p==o){throw new Error("Start and end markers cannot be identical.")
}p=new RegExp(b(p),"g");
o=new RegExp(b(o),"g");
var n=["","var p=[],","$=function(v) {",'return (v == "*") ? obj : obj[v];',"},","print=function() {","p.push.apply(p, arguments);","};","with(obj) {","try {",'p.push("',q.replace(p,c).replace(o,g).split("\r").join("").split("\t").join("    ").replace(i,"").replace(d,"").split("\n").join("\\n").replace(e,k).split('"').join('\\"').split("\r").join('"').replace(h,'",$1,"').split(c).join('");').split(g).join('p.push("'),'");',"}","catch(_tmplEx_) {",'p.push("Error: ", _tmplEx_.message)',"}","}",'return p.join("");',""].join("");
a[m]=new Function("obj",n);
return a[m]
})
})();

/* res://connect-min/dev/util/support.js */

Sslac.Static("IN.Util.support").Static("li_attributesSpecified",
/*@cc_on true || @*/
false).Static("li_createStyleSheet",
/*@cc_on true || @*/
false);

/* res://connect-min/dev/util/hashqueue.js */

Sslac.Class("IN.Util.HashQueue").Constructor(function(){this.queues={};
this.queueKeys=[]
}).Method("push",function(a,b){if(!this.queues[a]){this.queues[a]=[];
this.queueKeys.push(a)
}this.queues[a].push(b)
}).Method("pop",function(a){if(this.queues[a]){return this.queues[a].pop()
}}).Method("get",function(a){return this.queues[a]
}).Method("set",function(b,a){this.queues[b]=a
}).Method("size",function(){var b=0;
for(var a in this.queues){b+=this.queues[a].length
}return b
}).Method("keys",function(){return this.queueKeys
}).Method("clear",function(b){if(b){if(this.queues[b]){delete this.queues[b]
}var d=[];
for(var c=0,a=this.queueKeys.length;
c<a;
c++){if(this.queueKeys[c]!=b){d.push(this.queueKeys[c])
}}this.queueKeys=d
}else{this.queues={};
this.queueKeys=[]
}});

/* res://connect-min/dev/tagparser/tagparser.js */

Sslac.Class("IN.TagParser").Constructor(function(){this.tagRegistry={}
}).Method("processTagMatch",function(m){var a=m.tagName.toLowerCase(),s,f=false,c=false;
switch(a){case"in:tag":s=m.getAttribute("name").toLowerCase();
c=true;
if(/\+init$/.test(s)){return false
}break;
case"script":var b=m.type.toLowerCase();
f=true;
if(/\+init$/.test(b)){return false
}var d=b.split("/");
var g=d[0];
if(g!="in"){return false
}s=d[1];
break
}if(!this.tagRegistry[s]){return false
}if(c){m.setAttribute("name",s+"+init")
}if(f){m.type=m.type+"+init"
}var h,j,q=m.innerHTML,l={},r="data-";
for(var o=0,k=m.attributes,p=k.length;
o<p;
o++){var e=k.item(o),n=e.nodeName;
if(n.indexOf(r)===0){if(IN.Util.support.li_attributesSpecified||e.specified){n=n.replace(r,"").toLowerCase();
l[n]=e.nodeValue
}}}l.type=m.type;
l.content=q;
j=document.createElement("span");
j.style.lineHeight="1";
j.style.verticalAlign="baseline";
j.style.display="inline-block";
j.className="IN-widget";
m.parentNode.insertBefore(j,m);
h=new this.tagRegistry[s](j,l);
return true
}).Method("parse",function(e){var b=[];
for(var d=0,c=IN.$Tag("script",e),a=c.length;
d<a;
d++){if(c[d]){if(this.processTagMatch(c[d])){b.push(c[d])
}}}for(var d=0,c=IN.$Tag("in:tag",e),a=c.length;
d<a;
d++){if(c[d]){if(this.processTagMatch(c[d])){b.push(c[d])
}}}}).Method("add",function(a,b){this.tagRegistry[a.toLowerCase()]=b
});
(function(){var a=new IN.TagParser();
window.IN.addTag=function(){a.add.apply(a,arguments)
};
window.IN.parse=function(b){a.parse(b)
};
IN.Event.on(IN,"systemReady",function(){a.parse(document.body)
})
})();

/* res://connect-min/dev/tags/base.js */

Sslac.Class("IN.Tags.Base").Constructor(function(b,a){this.el=function(){return b
}
}).Method("addCSS",function(a){return IN.Util.addCSS(a)
}).Method("parseAttribute",function(b,d){if(!b){return[]
}b=b.split(",");
for(var c=0,a=b.length;
c<a;
c++){b[c]=IN.Util.trim(b[c]);
if(d=="callback"){b[c]=Sslac.valueOf(b[c])
}}return b
}).Method("createTemplate",function(a){return IN.Util.createJSTemplate(a)
}).Method("requireAuth",function(b,a){return IN.User.authorize(b,a)
}).Method("validateAttributes",function(b,l){var f="isValid_"+(new Date().getTime());
function k(p){if(typeof l[p][f]!=="undefined"){return l[p][f]
}var o=l[p].transform;
if(o){try{b[p]=o(b[p]);
l[p][f]=true;
return true
}catch(r){var n=e.invalidError||"data-"+p+" is not a valid "+p+" ("+b[p]+")";
throw new Error(n)
}}var q=b[p];
var m=l[p].match;
if(!m||!q){return true
}var s=typeof m;
s=(m instanceof RegExp)?"regex":s;
var i=true;
switch(s){case"function":i=m(q);
break;
case"string":m=new Regex(m);
case"regex":var q=b[p];
i=m.test(q);
break;
default:break
}l[p][f]=i;
return i
}for(var j in l){if(l.hasOwnProperty(j)){var e=l[j];
var a=k(j);
if(!a){var h=e.invalidError||"data-"+j+" is not a valid "+j+" ("+b[j]+")";
throw new Error(h)
}if(e.defaultValue&&(!a||!b[j])){b[j]=e.defaultValue;
continue
}if(e.required===true){if(b[j]&&a){continue
}else{var d=true;
if(e.exception){for(var c=e.exception.length;
c--;
){var g=e.exception[c];
if(b[g]&&k(g)){d=false;
break
}}}if(d){var h=e.error||"data-"+j+" was not provided";
throw new Error(h)
}}}}}return b
});

/* res://connect-min/dev/tags/share.js */

(function(){Sslac.Class("IN.Tags.Share").Extends("IN.Tags.Base").Constructor(function(i,h){this.Parent(i,h);
this.url=h.url||location.href;
this.el().style.textAlign="center";
this.successCallbacks=this.parseAttribute(h.onsuccess,"callback");
this.errorCallbacks=this.parseAttribute(h.onerror,"callback");
this.useCounter=h.counter||false;
this.position=this.useCounter||"right";
this.showZero=(h.showzero===true||h.showzero==="true")?true:false;
this.counter=null;
this.button=null;
this.clickedOnce=false;
this.count=0;
this.makeButton();
this.winObj=null
}).Method("makeButton",function(){var h={state:(this.position=="right"&&!this.showZero)?"hidden":null,position:this.position,alwaysShow:this.showZero,content:0},j=(this.position=="right")?"after":"before";
function k(){if(!this.clickedOnce){this.clickedOnce=true;
this.increaseCount()
}if(this.winObj){this.winObj.remove();
this.winObj=null
}this.winObj=IN.UI.Share().params({url:this.url});
for(var m=0,l=this.successCallbacks.length;
m<l;
m++){this.winObj.success(this.successCallbacks[m])
}for(var m=0,l=this.errorCallbacks.length;
m<l;
m++){this.winObj.error(this.errorCallbacks[m])
}this.winObj.place()
}this.button=new IN.Objects.Button({title:"Share"});
this.button.place(this.el());
IN.Event.on(this.button,"click",k,this);
if(this.useCounter){f(this.url,this);
this.counter=new IN.Objects.Callout(h);
this.counter.place(j,this.button.el());
if(this.position=="top"||this.position=="talltop"){var i=document.createElement("br");
this.button.el().parentNode.insertBefore(i,this.button.el())
}IN.Event.on(this.button,"mouseOver",function(){this.counter.setState("mouseOver")
},this);
IN.Event.on(this.button,"mouseOut",function(){this.counter.setState("mouseOut")
},this);
IN.Event.on(this.button,"mouseDown",function(){this.counter.setState("mouseDown")
},this);
IN.Event.on(this.button,"click",function(){this.counter.setState("click")
},this);
IN.Event.on(this.counter,"mouseOver",function(){this.button.setState("mouseOver")
},this);
IN.Event.on(this.counter,"mouseOut",function(){this.button.setState("mouseOut")
},this);
IN.Event.on(this.counter,"mouseDown",function(){this.button.setState("mouseDown")
},this);
IN.Event.on(this.counter,"click",function(){this.button.setState("click")
},this);
IN.Event.on(this.counter,"click",k,this)
}}).Method("setCount",function(h){if(this.counter&&(h!=""||this.position=="top"||this.position=="talltop")){h=h+"";
if(!h.match(/^[\d]+$/)){return
}h=h*1;
this.count=h;
this.counter.setState("visible");
this.counter.setContent(d(h))
}}).Method("increaseCount",function(h){h=h||1;
this.setCount(this.count+h)
}).Static("getCount",function(h,j,i){a(h,j,i)
}).Static("handleCount",function(h){b(h)
});
var e,c={};
function g(h){return IN.ENV.widget.share_counter_url+"?url="+encodeURIComponent(h)
}function f(i,h){a(i,h.setCount,h)
}function a(h,k,i){if(!e){e=document.getElementsByTagName("head")[0]
}if(!c[h]){c[h]=[]
}c[h].push({callback:k||function(){},scope:i||window});
var j=document.createElement("script");
j.type="text/javascript";
j.src=g(h);
e.appendChild(j)
}function b(m){if(!e){e=document.getElementsByTagName("head")[0]
}m=m||{};
if(typeof(m.url)=="undefined"||typeof(m.count)=="undefined"){return
}var h=m.url,p=m.count,j=e.getElementsByTagName("script"),k,l,q=[];
for(var n=0,o=j.length;
n<o;
n++){k=j[n];
if(k.src==g(h)){q.push(k)
}}window.setTimeout(function(){for(var s=0,r=q.length;
s<r;
s++){if(q[s].parentNode){q[s].parentNode.removeChild(q[s])
}}},100);
for(var n=0,o=c[h].length;
n<o;
n++){var l=c[h][n];
l.callback.call(l.scope,p)
}}function d(j){var i=j+"";
var h=/(\d+)(\d{3})/;
if(j>10000){i=Math.floor(j/1000);
return d(i)+" k"
}else{if(j>1000){while(h.test(i)){i=i.replace(h,"$1"+","+"$2")
}return i
}else{return i
}}}})();
IN.addTag("Share",IN.Tags.Share);

/* res://connect-min/dev/tags/mail.js */

Sslac.Class("IN.Tags.Mail").Extends("IN.Tags.Base").Constructor(function(b,a){this.Parent(b,a);
this.emails=a.emails;
this.createFrame()
}).Method("createFrame",function(){this.el().innerHTML="";
var a={};
a.api_key=IN.ENV.auth.api_key;
a.emails=this.emails;
var b=new IN.Objects.SmartWindow({mode:"embedded",url:IN.ENV.widget.mail_url}).params(a);
b.place(this.el())
});
IN.addTag("Mail",IN.Tags.Mail);

/* res://connect-min/dev/tags/recommendproduct.js */

(function(){Sslac.Class("IN.Tags.RecommendProduct").Extends("IN.Tags.Base").Constructor(function(g,f){this.Parent(g,f);
this.companyId=f.company||null;
this.productId=f.product||null;
this.url=f.url||null;
if(!this.companyId&&!this.url){throw new Error("You must provide either a company ID, a company name, or a URL to a product item")
}this.el().style.textAlign="center";
this.useCounter=f.counter||false;
this.position=this.useCounter||"right";
this.counter=null;
this.button=null;
this.clickedOnce=false;
this.count=0;
this.makeButton()
}).Method("makeButton",function(){var f={state:(this.position=="right")?"hidden":null,position:this.position},h=(this.position=="right")?"after":"before";
function i(){var j;
if(!this.clickedOnce){this.clickedOnce=true
}if(this.url){j=this.url
}else{j=a(this.companyId,this.productId)
}window.open(j)
}this.button=new IN.Objects.Button({title:"Recommend"});
this.button.place(this.el());
IN.Event.on(this.button,"click",i,this);
if(this.useCounter){d({url:this.url,companyId:this.companyId,productId:this.productId},this);
this.counter=new IN.Objects.Callout(f);
this.counter.place(h,this.button.el());
if(this.position=="top"){var g=document.createElement("br");
this.button.el().parentNode.insertBefore(g,this.button.el())
}IN.Event.on(this.button,"mouseOver",function(){this.counter.setState("mouseOver")
},this);
IN.Event.on(this.button,"mouseOut",function(){this.counter.setState("mouseOut")
},this);
IN.Event.on(this.button,"mouseDown",function(){this.counter.setState("mouseDown")
},this);
IN.Event.on(this.button,"click",function(){this.counter.setState("click")
},this);
IN.Event.on(this.counter,"mouseOver",function(){this.button.setState("mouseOver")
},this);
IN.Event.on(this.counter,"mouseOut",function(){this.button.setState("mouseOut")
},this);
IN.Event.on(this.counter,"mouseDown",function(){this.button.setState("mouseDown")
},this);
IN.Event.on(this.counter,"click",function(){this.button.setState("click")
},this);
IN.Event.on(this.counter,"click",i,this)
}}).Method("setCount",function(f){if(this.counter&&(f!=""||this.position=="top")){this.counter.setState("visible");
this.counter.setContent(b(f))
}});
var c;
function e(f,g,h){return IN.ENV.widget.recommend_product_counter_url.replace(/\{PRODUCT_ID\}/g,g).replace(/\{CALLBACK\}/g,h)
}function a(f,g){return IN.ENV.widget.recommend_product_url.replace(/\{COMPANY_ID\}/g,f).replace(/\{PRODUCT_ID\}/g,g)
}function d(h,f){var i=document.createElement("script"),j=IN.$fn(function(k){if(i.parentNode){i.parentNode.removeChild(i)
}k=k||{};
if(typeof(k.count)=="undefined"){return
}this.setCount(k.count)
},f,true),g=e(h.companyId,h.productId,j);
if(!c){c=document.getElementsByTagName("head")[0]
}i.type="text/javascript";
i.src=g;
c.appendChild(i)
}function b(h){var g=h+"";
var f=/(\d+)(\d{3})/;
if(h>10000){g=Math.floor(h/1000);
return b(g)+" k"
}else{if(h>1000){while(f.test(g)){g=g.replace(f,"$1"+","+"$2")
}return g
}else{return g
}}}})();
IN.addTag("RecommendProduct",IN.Tags.RecommendProduct);

/* res://connect-min/dev/tags/companyprofile.js */

Sslac.Class("IN.Tags.CompanyProfile").Extends("IN.Tags.Base").Constructor(function(b,a){this.Parent(b,a);
if(!a.id){return
}this.id=a.id;
this.format=a.format||"hover";
if(this.format==="inline"){this.width=parseInt(a.width,10);
if(this.width>0&&this.width<300){this.width=300
}}this.related=a.related||true;
this.text=a.text||"";
this.createFrame()
}).Method("createFrame",function(){var d={companyIdentifier:this.id,format:this.format},c,b,a=[{fixed:"tr",movable:"tl",offsetY:-20},{fixed:"tl",movable:"tr",offsetY:-20},{fixed:"bl",movable:"br",offsetY:20},{fixed:"br",movable:"bl",offsetY:20},{fixed:"tl",movable:"br",offsetY:20},{fixed:"tr",movable:"bl",offsetY:20}];
if(this.related==="false"){d.related=false
}if(this.width>0){d.width=this.width
}if(this.format==="inline"){this.el().innerHTML="";
var e=new IN.Objects.SmartWindow({mode:"embedded",url:IN.ENV.widget.company_url}).params(d);
e.place(this.el())
}else{if(this.format==="click"){this.open=false;
b=new IN.Objects.InLink({text:this.text});
b.place(this.el());
IN.Event.on(b,"click",function(){if(this.open){return
}b.setState("pending");
c=new IN.Objects.SmartWindow({mode:"hovercard",anchor:{fixed:b.el(),movable:null,context:a},url:IN.ENV.widget.company_url},this).params(d);
c.ready(function(){b.setState("normal")
});
c.place(this.el());
c.onWindowCreate.subscribe(function(){this.windowOpen=true
})
},this);
IN.Event.on(document,"click",function(){if(this.open){this.open=false;
b.setState("normal")
}},this)
}else{this.open=false;
b=new IN.Objects.InLink({text:this.text});
b.place(this.el());
IN.Event.on(document,"click",function(){if(this.open){this.open=false;
b.setState("normal")
}},this);
IN.Event.on(b,"mouseOver",function(){if(this.open){return
}this.open=true;
b.setState("pending");
c=new IN.Objects.SmartWindow({mode:"hovercard",anchor:{fixed:b.el(),movable:null,context:a},url:IN.ENV.widget.company_url},this).params(d);
c.ready(function(){b.setState("normal")
});
c.place(this.el())
},this)
}}});
IN.addTag("CompanyProfile",IN.Tags.CompanyProfile);

/* res://connect-min/dev/tags/memberprofile.js */

Sslac.Class("IN.Tags.MemberProfile").Extends("IN.Tags.Base").Constructor(function(b,a){this.Parent(b,a);
if(!a.id){return
}this.id=a.id;
this.format=a.format||"hover";
if(this.format==="inline"){this.width=parseInt(a.width,10);
if(this.width>0&&this.width<300){this.width=300
}}this.related=a.related||true;
this.text=a.text||"";
this.createFrame()
}).Method("createFrame",function(){var d={public_profile_url:this.id,format:this.format},c,b,a=[{fixed:"tr",movable:"tl",offsetY:-20},{fixed:"tl",movable:"tr",offsetY:-20},{fixed:"bl",movable:"br",offsetY:20},{fixed:"br",movable:"bl",offsetY:20},{fixed:"tl",movable:"br",offsetY:20},{fixed:"tr",movable:"bl",offsetY:20}];
if(this.related==="false"){d.related=false
}if(this.width>0){d.width=this.width
}if(this.format==="inline"){this.el().innerHTML="";
var e=new IN.Objects.SmartWindow({mode:"embedded",url:IN.ENV.widget.member_profile_url}).params(d);
e.place(this.el())
}else{if(this.format==="click"){this.open=false;
b=new IN.Objects.InLink({text:this.text});
b.place(this.el());
IN.Event.on(b,"click",function(){if(this.open){return
}b.setState("pending");
c=new IN.Objects.SmartWindow({mode:"hovercard",anchor:{fixed:b.el(),movable:null,context:a},url:IN.ENV.widget.member_profile_url},this).params(d);
c.ready(function(){b.setState("normal")
});
c.place(this.el());
c.onWindowCreate.subscribe(function(){this.windowOpen=true
})
},this);
IN.Event.on(document,"click",function(){if(this.open){this.open=false;
b.setState("normal")
}},this)
}else{this.open=false;
b=new IN.Objects.InLink({text:this.text});
b.place(this.el());
IN.Event.on(document,"click",function(){if(this.open){this.open=false;
b.setState("normal")
}},this);
IN.Event.on(b,"mouseOver",function(){if(this.open){return
}this.open=true;
b.setState("pending");
c=new IN.Objects.SmartWindow({mode:"hovercard",anchor:{fixed:b.el(),movable:null,context:a},url:IN.ENV.widget.member_profile_url},this).params(d);
c.ready(function(){b.setState("normal")
});
c.place(this.el())
},this)
}}});
IN.addTag("MemberProfile",IN.Tags.MemberProfile);

/* res://connect-min/dev/tags/companyinsider.js */

Sslac.Class("IN.Tags.CompanyInsider").Extends("IN.Tags.Base").Constructor(function(b,a){this.Parent(b,a);
if(!a.id){return
}this.id=a.id;
this.modules=a.modules||"";
this.createFrame()
}).Method("createFrame",function(){var a={companyIdentifier:this.id,modules:this.modules};
this.el().innerHTML="";
var b=new IN.Objects.SmartWindow({mode:"embedded",url:IN.ENV.widget.company_insider_url}).params(a);
b.place(this.el())
});
IN.addTag("CompanyInsider",IN.Tags.CompanyInsider);

/* res://connect-min/dev/tags/wizard.js */

Sslac.Class("IN.Tags.Wizard").Extends("IN.Tags.Base").Constructor(function Wizard(c,b){this.Parent(c,b);
this.size=(b.size=="large")?"large":"small";
var d={large:"pic_wizard_423x423.png",small:"pic_wizard_212x212.png"},e=IN.ENV.images.sprite.replace(/\/sprite\/.*/,"")+"/pic/"+d[this.size],a=document.createElement("img");
a.src=e;
a.style.border=0;
c.appendChild(a)
});
IN.addTag("Wizard",IN.Tags.Wizard);

/* res://connect-min/dev/tags/jymbii.js */

Sslac.Class("IN.Tags.jymbii").Extends("IN.Tags.Base").Constructor(function(e,b){this.Parent(e,b);
var d=[{fixed:"tr",movable:"tl",offsetY:-20},{fixed:"tl",movable:"tr",offsetY:-20},{fixed:"bl",movable:"br",offsetY:20},{fixed:"br",movable:"bl",offsetY:20},{fixed:"tl",movable:"br",offsetY:20},{fixed:"tr",movable:"bl",offsetY:20}];
var g=b.format;
if(g.indexOf("inline")===0){var f=new IN.Objects.SmartWindow({mode:"embedded",url:IN.ENV.widget.jymbii_url}).params({"companyId":b.companyid,"industry":b.industry,"jobFunction":b.jobfunction,"country":b.country,"max":b.max,"title":b.title});
f.place(this.el())
}else{var c=new IN.Objects.InLink({text:b.text});
c.place(this.el());
IN.Event.on(document,"click",function(){if(this.open){this.open=false;
c.setState("normal")
}},this);
var a;
if(g==="click"){a="click"
}else{a="mouseOver"
}IN.Event.on(c,a,function(){if(this.open){return
}this.open=true;
c.setState("pending");
var h=new IN.Objects.SmartWindow({mode:"hovercard",anchor:{fixed:c.el(),movable:null,context:d},url:IN.ENV.widget.jymbii_url},this).params({"companyId":b.companyid,"industry":b.industry,"jobFunction":b.jobfunction,"country":b.country,"max":b.max,"title":b.title});
h.ready(function(){c.setState("normal")
});
h.place(c.el())
},this)
}});
IN.addTag("jymbii",IN.Tags.jymbii);

/* res://connect-min/dev/objects/lib.js */

Sslac.Function("IN.Objects.Lib.center",function(b){var a=IN.Objects.Lib.getCenter(b);
b.style.top=a.top+"px";
b.style.left=a.left+"px"
});
Sslac.Function("IN.Objects.Lib.anchor",function(f,d,g){var l=IN.Objects.Lib.getXY(f),o=IN.Objects.Lib.getDimensions(f),b=IN.Objects.Lib.getDimensions(d),y=IN.Objects.Lib.getViewport(),h=IN.Objects.Lib.getDimensions(document.body),t=Math.max(y.width||0,h.width||0,(l.x+l.width)||0),a=Math.max(y.height||0,h.height||0,h.scrollHeight||0,(l.y+l.height)||0),e=null,k=0,j=0,u=0,m=0,q=0,x=0,w=0,v=0,c=0,s=0,r=0;
for(var n=0,p=g.length;
n<p;
n++){e=g[n];
j=0;
u=0;
m=0;
q=0;
r=e.offsetY||0;
s=e.offsetX||0;
switch(e.fixed.toLowerCase()){case"tl":j=l.x;
m=l.y;
u=j+b.width;
q=m+b.height;
break;
case"tr":j=l.x+o.width;
m=l.y;
u=j+b.width;
q=m+b.height;
break;
case"bl":j=l.x;
m=l.y+o.height;
u=j+b.width;
q=m+b.height;
break;
case"br":j=l.x+o.width;
m=l.y+o.height;
u=j+b.width;
q=m+b.height;
break
}switch(e.movable.toLowerCase()){case"tl":break;
case"tr":j=j-b.width;
u=u-b.width;
break;
case"bl":m=m-b.height;
q=q-b.height;
break;
case"br":j=j-b.width;
u=u-b.width;
m=m-b.height;
q=q-b.height;
break
}j=j+s;
u=u+s;
m=m+r;
q=q+r;
if(n===0){k=e;
x=j;
w=u;
v=m;
c=q
}if(u<=t&&q<=a&&j>=0&&m>=0){k=e;
x=j;
w=u;
v=m;
c=q;
break
}}d.style.left=x+"px";
d.style.top=v+"px";
return k
});
Sslac.Function("IN.Objects.Lib.getScrollOffsets",function(){var c=window.pageXOffset||document.documentElement.scrollLeft||document.body.scrollLeft,b=window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop;
var a=[c,b];
a.left=c;
a.top=b;
return a
});
Sslac.Function("IN.Objects.Lib.getXY",function(a){function b(d,c){c=c.substr(0,1).toUpperCase()+c.substr(1);
var e=d["offset"+c]+d["scroll"+c];
while((d=d.offsetParent)!==null){e+=d["offset"+c]
}return e
}return{x:b(a,"left"),y:b(a,"top")}
});
Sslac.Function("IN.Objects.Lib.UA",function(){var e=navigator.userAgent;
var g={webkit:/KHTML/,opera:/Opera[\s\/]([^\s]*)/,ie:/MSIE\s([^;]*)/,gecko:/Gecko\/([^\s]*)/};
var a=0;
var f=0;
var c=0;
var b=0;
var d=(document["compatMode"]==="BackCompat");
(function(){var h;
h=e.match(g.webkit);
if(h&&h[1]){a=1;
return
}h=e.match(g.opera);
if(h&&h[1]){c=1;
return
}h=e.match(g.ie);
if(h&&h[1]){f=1;
return
}h=e.match(g.gecko);
if(h&&h[1]){b=1;
return
}})();
return{isIE:function(){return f
},isWebkit:function(){return a
},isOpera:function(){return c
},isGecko:function(){return b
},isQuirksMode:function(){return d
}}
}());
(function(){Sslac.Function("IN.Objects.Lib.getViewport",function(){var c={};
var a=document["compatMode"];
var b="CSS1Compat";
c={width:window.self.innerWidth,height:window.self.innerHeight};
if(c.width&&c.height){return c
}if(c.width&&c.height){return c
}if((a||IN.Objects.Lib.UA.isIE())&&!IN.Objects.Lib.UA.isOpera()){if(a==b){c.height=document.documentElement.clientHeight
}else{c.height=document.body.clientHeight
}}if(a||IN.Objects.Lib.UA.isIE()){if(a==b){c.width=document.documentElement.clientWidth
}else{c.width=document.body.clientWidth
}}return c
})
})();
Sslac.Function("IN.Objects.Lib.getDimensions",function(d){function c(){var j=document.body,f=0,i=0,g=j.style.overflow;
if(IN.Objects.Lib.UA.isGecko()){j.style.overflow="auto"
}f=j.scrollWidth;
i=j.clientHeight;
if(IN.Objects.Lib.UA.isGecko()){j.style.overflow=g
}return{width:f,height:i,scrollHeight:j.scrollHeight}
}if(d===document.body){return c()
}var a=d.offsetWidth,b=(d.offsetHeight>d.clientHeight)?d.offsetHeight:d.clientHeight,e;
e=[a,b];
e.width=a;
e.height=b;
return e
});
Sslac.Function("IN.Objects.Lib.getCenter",function(c){var b=IN.Objects.Lib.getScrollOffsets(),d=IN.Objects.Lib.getViewport(),g=IN.Objects.Lib.getDimensions(c),f=b.left+((d.width-g.width)/2),e=b.top+((d.height-g.height)/2);
if(e<0){e=0
}if(f<0){f=0
}var a={top:e,right:(f+g.width),bottom:(e+g.height),left:f};
return a
});
Sslac.Function("IN.Objects.Lib.getCurrentPosition",function(b){var a={top:b.offsetTop||0,left:b.offsetLeft||0};
while(b=b.offsetParent){a.top+=b.offsetTop;
a.left+=b.offsetLeft
}return a
});
Sslac.Function("IN.Objects.Lib.getAnimationInterval",function(c,b){b=b||45;
var a={};
a.interval=1000/b;
a.total=c/a.interval;
return a
});
Sslac.Function("IN.Objects.Lib.shake",function(c,b){b=b||{};
b={duration:b.duration||300,frequency:b.frequency||2,cycles:b.cycles||Math.PI,amplitude:b.amplitude||20,decay:b.decay||3,axis:b.axis||"x"};
var d=IN.Objects.Lib.getAnimationInterval(b.duration);
var h=(b.axis==="x")?"left":"top";
var g=IN.Objects.Lib.getCurrentPosition(c);
function e(j){return b.amplitude*Math.cos(b.frequency*j*2*Math.PI)/Math.exp(b.decay*j)
}var i=b.cycles/d.total;
var f=0;
function a(){if(d.total>0){c.style[h]=(g[h]+e(f))+"px";
f+=i;
d.total--;
setTimeout(a,d.interval)
}}a()
});
Sslac.Function("IN.Objects.Lib.slideTo",function(f,k,c){c=c||{};
c={duration:c.duration||700,bounce:c.bounce||0.2};
var g=IN.Objects.Lib.getAnimationInterval(c.duration);
var e=IN.Objects.Lib.getCurrentPosition(f);
var j={top:(k.top-e.top),left:(k.left-e.left)};
var d=g.total;
if(c.bounce){var a={top:(c.bounce*2*j.top),left:(c.bounce*2*j.left)};
var i={top:0,left:0};
j.top+=a.top;
j.left+=a.left;
if(j.top!==0){i.top=Math.abs(a.top/j.top)
}if(j.left!==0){i.left=Math.abs(a.left/j.left)
}i=Math.max(i.top,i.left);
d=(1-i)*g.total
}var h=(1+g.total)*(g.total/2);
if(c.bounce){h=h*(1-(2*c.bounce))
}j.top=j.top/h;
j.left=j.left/h;
function b(){if(g.total>0){e.top+=j.top*d;
e.left+=j.left*d;
f.style.top=e.top+"px";
f.style.left=e.left+"px";
g.total--;
d--;
setTimeout(b,g.interval)
}}b()
});
Sslac.Function("IN.Objects.Lib.setShadowBox",function(c,b){c=c||false;
b=b||{};
b={color:b.color||"#000000",opacity:b.opacity||0.6,zIndex:b.zIndex||"9990"};
var d;
if(!IN.ENV.shadowBoxId){if(!c){return
}IN.ENV.shadowBoxId=IN.$uid("li_ui_shadowbox");
d=document.createElement("div");
d.id=IN.ENV.shadowBoxId;
if(IN.Objects.Lib.UA.isQuirksMode()&&IN.Objects.Lib.UA.isIE()){d.style.position="absolute"
}else{d.style.position="fixed"
}d.style.top="0";
d.style.left="0";
document.body.insertBefore(d,document.body.firstChild)
}else{d=IN.$Id(IN.ENV.shadowBoxId)
}if(!c){d.style.display="none";
return
}d.style.zIndex=b.zIndex;
d.style.backgroundColor=b.color;
d.style.filter="alpha(opacity="+(b.opacity*100)+")";
d.style.MozOpacity=d.style.WebkitOpacity=d.style.KthmlOpacity=d.style.opacity=b.opacity;
function a(){var f=IN.Objects.Lib.getViewport(),e=IN.Objects.Lib.getDimensions(document.body);
d.style.width=Math.max(e.width,f.width)+"px";
d.style.height=Math.max(e.height,e.scrollHeight,f.height)+"px"
}IN.Event.on(window,"resize",a,d);
a();
d.style.display="block"
});

/* res://connect-min/dev/objects/base.js */

(function(){var c;
Sslac.Class("IN.Objects.Base").Constructor(function(i){var h=document.createElement("span"),j={"padding":"0","margin":"0","text-indent":"0","display":"inline-block","vertical-align":"baseline"};
if(!i.suppressFont){j["font-size"]="1px"
}h.style.cssText=this.createStyle(j);
this.el=function(){return h
};
this.components={};
this.componentId=null;
this.placed=false;
this.handlers=[]
}).Method("removeHandler",function(i,h){return function(p,r,m,k){if(this.isPlaced()){IN.Event.remove(i,h,p,r,m,k)
}else{var l=this.handlers;
var j=[];
for(var n=0,o=l.length;
n<o;
n++){var q=l[n];
if(q.id!==i||q.on!==h||q.fn!==p||q.scope!==r||q.obj!==m||q.once!==k){j.push(q)
}}this.handlers=j
}}
}).Method("addHandler",function(j,h){var i=function(m,l,n,k){var m=m;
var o=function(p,q){if(!i.enabled){return false
}if(q){m.call(this,p,q)
}else{m.call(this,p)
}};
if(this.isPlaced()){IN.Event.on(j,h,o,l,n,k)
}else{this.handlers[this.handlers.length]={id:j,on:h,fn:o,scope:l,obj:n,once:k}
}};
i.enabled=true;
return i
}).Method("createTemplate",function(h){return IN.Util.createJSTemplate(h)
}).Method("place",function(){var k=[].slice.apply(arguments),j="",o=null,m=this.el();
if(!k[0]){j="in";
o=document.body
}else{if(!k[1]){j="in";
o=k[0]
}else{j=k[0];
o=k[1]
}}switch(j){case"in":o.appendChild(m);
break;
case"before":o.parentNode.insertBefore(m,o);
break;
case"after":if(o.nextSibling){o.nextSibling.parentNode.insertBefore(m,o.nextSibling)
}else{o.parentNode.appendChild(m)
}break
}this.placed=true;
for(var l=0,h=this.handlers.length;
l<h;
l++){var n=this.handlers[l];
IN.Event.on(n.id,n.on,n.fn,n.scope,n.obj,n.once)
}this.handlers=[];
return this
}).Method("remove",function(){var h=this.el();
if(h.parentNode){h.parentNode.removeChild(h)
}this.placed=false
}).Method("isPlaced",function(){return this.placed
}).Method("createStyle",function(k){var i,h=[],j="";
if(!c){i=navigator.userAgent;
c=(i.match(/Webkit\//i))?"Webkit":(i.match(/Gecko\//i))?"Gecko":(i.match(/MSIE/))?"MSIE":"other"
}for(name in k){if(typeof(k[name])=="object"){j=k[name][c]||k[name]["other"]
}else{j=k[name]
}if(!j){continue
}h[h.length]=name+":"+j+" !important;"
}return h.join("")
}).Method("setComponentId",function g(h){this.componentId=h
}).Method("registerComponent",function d(i,h,j){j=j||"normal";
this.components[i]=h
}).Method("getComponent",function a(i,k,j){var h=this.components[i]||"",k=k||"",j=j||"";
h=h.replace(/\{ID\}/g,this.componentId).replace(/\{\.STATE\}/g,(k)?"."+k:"").replace(/\{\#STATE\}/g,(k)?"#"+k:"").replace(/\{:PSEUDO\}/g,(j)?":"+j:"");
return h
}).Method("createCSS",function b(m,l,n){if(!IN.Util.isArray(m)){m=[m]
}var k=[],n=(typeof n==="undefined")?"":n+" ";
for(var j=0,h=m.length;
j<h;
j++){k.push(n+this.getComponent(m[j].component,m[j].state,m[j].pseudo))
}return[k.join(", "),"{",l,"}"].join("")
}).Method("addCSS",function f(h){return IN.Util.addCSS(h)
}).Method("computeGradientStyle",function e(i,h){return IN.Util.computeGradientStyle(i,h)
}).Method("generateId",function(h){h=(h)?"li_ui_"+h:"li_ui";
return IN.$uid(h)
})
})();

/* res://connect-min/dev/objects/button.js */

Sslac.Class("IN.Objects.Button").Extends("IN.Objects.Base").Constructor(function(c){c=c||{};
this.config={title:c.title||"",successTitle:c.successTitle||(c.title||""),useLogo:(c.useLogo===false||!IN.ENV.images||!IN.ENV.images.sprite)?false:true,highlight:(c.highlight===false)?false:true,theme:(c.theme||"basic").toLowerCase(),size:(c.size||"small").toLowerCase(),showSuccessMark:c.showSuccessMark||false};
this.Parent(this.config);
this.setButtonStyles();
var b="",f=this.generateId(),e={},d=false,a=this;
b=["",'<span id="'+f+'">','<a id="'+f+'-link" href="javascript:void(0);">',(this.config.useLogo)?'<span id="'+f+'-logo">in</span>':"",(this.config.title)?'<span id="'+f+'-title"><span id="'+f+'-mark"></span><span id="'+f+'-title-text">'+this.config.title+"</span></span>":"","</a>","</span>",""].join("");
this.setComponentId(f);
this.registerComponent("outer","#{ID}{.STATE}");
this.registerComponent("link","#{ID}{.STATE} a#{ID}-link{:PSEUDO}");
this.registerComponent("logo","#{ID}{.STATE} #{ID}-logo");
this.registerComponent("title","#{ID}{.STATE} #{ID}-title");
this.registerComponent("titleText","#{ID}{.STATE} #{ID}-title-text");
this.registerComponent("mark","#{ID}{.STATE} #{ID}-title #{ID}-mark");
e=["",this.getBaseStyles(),this.getLogoStyles(),this.getTitleStyles(),""].join("").replace(/\{ID\}/g,f);
IN.Util.addCSS(e);
this.el().innerHTML=b;
this.mainNodeId=f;
this.onClick=this.addHandler(f,"click");
this.onMouseDown=this.addHandler(f,"mousedown");
this.onMouseOver=this.addHandler(f,"mouseover");
this.onMouseOut=this.addHandler(f,"mouseout");
this.onClick(function(g){this.setState("click")
},this);
this.onMouseDown(function(g){this.setState("mouseDown")
},this);
this.onMouseOver(function(g){this.setState("mouseOver")
},this);
this.onMouseOut(function(){this.setState("mouseOut")
},this)
}).Method("computeBoxShadow",function(d,c){if(c.off){return""
}var b={w3c:c.horizontal+"px "+c.vertical+"px "+c.blur+"px "+c.color};
var a=b[d]||b.w3c;
return a
}).Method("setState",function(c){var a=IN.$Id(this.mainNodeId),b=this;
if(!a){return
}switch(c){case"mouseOver":IN.Util.addClass(a,"hovered");
break;
case"mouseOut":IN.Util.removeClass(a,"hovered");
IN.Util.removeClass(a,"down");
break;
case"mouseDown":IN.Util.removeClass(a,"hovered");
IN.Util.addClass(a,"down");
break;
case"click":if(IN.Util.hasClass(a,"clicked")){return
}IN.Util.addClass(a,"clicked");
window.setTimeout(function(){b.setState("normal")
},2000);
break;
case"normal":IN.Util.removeClass(a,"hovered");
IN.Util.removeClass(a,"down");
IN.Util.removeClass(a,"clicked");
break
}}).Method("getSetting",function(a){return this.settings[a]
}).Method("setMaxSize",function(){var b=IN.$Id(this.mainNodeId+"-title-text");
var i=IN.Objects.Lib.getDimensions(b).width;
this.setTitleText(this.config.successTitle);
var f=IN.Objects.Lib.getDimensions(b);
this.setTitleText(this.config.title);
f=f.width;
if(this.config.showSuccessMark){var d=this.settings.mark;
var a=d.width+d.margin.left+d.margin.right;
f+=a
}var h=Math.max(i,f);
var e=IN.$Id(this.mainNodeId+"-title");
if(IN.Objects.Lib.UA.isQuirksMode()&&IN.Objects.Lib.UA.isIE()){var g=this.settings.title.padding.resolved.left+this.settings.title.padding.resolved.right;
var c=this.settings.border.left+this.settings.border.right;
h+=g
}e.style.width=(h+1)+"px"
}).Method("getBaseStyles",function(){return["",this.createCSS({component:"link"},this.createStyle({"height":"1%"}),"* html"),this.createCSS({component:"outer"},this.createStyle({"position":"relative","overflow":"visible","display":"block"})),this.createCSS({component:"link"},this.createStyle({"border":"0","height":this.getSetting("height")+"px","text-decoration":"none","padding":"0","margin":"0","zoom":{MSIE:"1"},"display":{MSIE:"inline",other:"inline-block"}})),this.createCSS([{component:"link",pseudo:"link"},{component:"link",pseudo:"visited"},{component:"link",pseudo:"hover"},{component:"link",pseudo:"active"}],this.createStyle({"border":"0","text-decoration":"none"})),this.createCSS({component:"link",pseudo:"after"},this.createStyle({"content":'"."',"display":"block","clear":"both","visibility":"hidden","line-height":"0","height":"0"})),""].join("")
}).Method("getLogoStyles",function(){if(!this.config.useLogo){return""
}this.settings.logo.width=Math.ceil(this.settings.logo.height*this.settings.logo.ratio);
var a=this.settings.logo.background.row+this.settings.logo.background.rowOffset;
this.settings.logo.background.normal=[0,a];
this.settings.logo.background.hover=[-1*this.settings.logo.width,a];
this.settings.logo.background.click=[-2*this.settings.logo.width,a];
return["",this.createCSS({component:"logo"},this.createStyle({"background":"url("+IN.ENV.images.sprite+") "+this.settings.logo.background.normal.join("px ")+"px no-repeat","cursor":"pointer","border":"0","text-indent":"-9999em","overflow":"hidden","padding":"0","margin":"0","z-index":"1","position":(this.config.title)?"absolute":"","left":(this.config.title)?this.settings.logo.position.left:"","right":(this.config.title)?this.settings.logo.position.right:"","top":(this.config.title)?this.settings.logo.position.top:"","display":"block","width":this.settings.logo.width+"px","height":this.settings.logo.height+"px","float":(this.settings.logo.position.floated)?"right":"left"})),this.createCSS({component:"logo",state:"hovered"},this.createStyle({"background-position":this.settings.logo.background.hover.join("px ")+"px"})),this.createCSS([{component:"logo",state:"clicked"},{component:"logo",state:"down"}],this.createStyle({"background-position":this.settings.logo.background.click.join("px ")+"px"})),""].join("")
}).Method("getTitleStyles",function(){if(this.config.title===""){return""
}var b=this.settings;
var c={left:Math.round((b.title.padding.left*b.title.padding.ratio)+b.logo.width+b.logo.padding-1),right:Math.round((b.title.padding.right*b.title.padding.ratio)+b.logo.padding)};
if(b.logo.position.floated==="left"){c={left:c.right,right:c.left}
}b.title.padding.resolved=c;
var a=IN.Objects.Lib.UA.isQuirksMode();
return["",this.createCSS({component:"title"},this.createStyle({"font-size":b.font.size+"px","font-family":b.font.family,"font-weight":b.font.weight,"color":b.color.normal,"cursor":"pointer","display":"block","white-space":"nowrap","float":"left","margin-left":"1px","vertical-align":"top","overflow":"hidden","text-align":b.title.textAlign,"height":{MSIE:(a?(b.title.height+b.ieOffset):(b.title.height-b.ieOffset))+"px",other:b.title.height+"px"},"padding":{MSIE:"0 "+c.left+"px "+(a?"0 ":(b.ieOffset+"px "))+c.right+"px",other:"0 "+c.left+"px 0 "+c.right+"px"},"border":"1px solid #000","border-top-color":b.border.color.normal.top,"border-right-color":b.border.color.normal.right,"border-bottom-color":b.border.color.normal.bottom,"border-left-color":b.border.color.normal.left,"border-left":(b.border.corners!=="all")?"0":"","text-shadow":b.font.shadow,"line-height":{MSIE:(a?b.title.height:(b.title.height-b.ieOffset*2))+"px",other:b.logo.height+"px"},"border-radius":(this.config.useLogo&&b.border.corners!=="all")?"0":b.border.radius+"px","-webkit-border-radius":{Webkit:(this.config.useLogo&&b.border.corners!=="all")?"0":b.border.radius+"px"},"-moz-border-radius":{Gecko:(this.config.useLogo&&b.border.corners!=="all")?"0":b.border.radius+"px"},"border-top-right-radius":b.border.radius+"px","border-bottom-right-radius":b.border.radius+"px","-webkit-border-top-right-radius":{Webkit:b.border.radius+"px"},"-webkit-border-bottom-right-radius":{Webkit:b.border.radius+"px"},"-moz-border-radius-topright":{Gecko:b.border.radius+"px"},"-moz-border-radius-bottomright":{Gecko:b.border.radius+"px"},"background-color":{Webkit:"",Gecko:"",MSIE:"",other:b.background.normal},"background-image":{Webkit:this.computeGradientStyle("webkit",b.gradient.normal),Gecko:this.computeGradientStyle("gecko",b.gradient.normal),MSIE:this.computeGradientStyle("msie",b.gradient.normal),Opera:this.computeGradientStyle("opera",b.gradient.normal),other:this.computeGradientStyle("w3c",b.gradient.normal)},"filter":{MSIE:this.computeGradientStyle("msieold",b.gradient.normal)},"-moz-box-shadow":{Gecko:this.computeBoxShadow("w3c",b.boxShadow.normal)},"-webkit-box-shadow":{Webkit:this.computeBoxShadow("w3c",b.boxShadow.normal)},"-ms-box-shadow":{MSIE:this.computeBoxShadow("w3c",b.boxShadow.normal)},"-o-box-shadow":{Opera:this.computeBoxShadow("w3c",b.boxShadow.normal)},"box-shadow":{other:this.computeBoxShadow("w3c",b.boxShadow.normal)}})),this.createCSS({component:"title",state:"hovered"},this.createStyle({"color":b.color.hover,"border":"1px solid #000","border-top-color":b.border.color.hover.top,"border-right-color":b.border.color.hover.right,"border-bottom-color":b.border.color.hover.bottom,"border-left-color":b.border.color.hover.left,"border-left":(this.config.useLogo&&b.border.corners!=="all")?"0":"","background-color":{Webkit:"",Gecko:"",MSIE:"",other:b.background.hover},"background-image":{Webkit:this.computeGradientStyle("webkit",b.gradient.hover),Gecko:this.computeGradientStyle("gecko",b.gradient.hover),MSIE:this.computeGradientStyle("msie",b.gradient.hover),Opera:this.computeGradientStyle("opera",b.gradient.hover),other:this.computeGradientStyle("w3c",b.gradient.hover)},"filter":{MSIE:this.computeGradientStyle("msieold",b.gradient.hover)},"-moz-box-shadow":{Gecko:this.computeBoxShadow("w3c",b.boxShadow.hover)},"-webkit-box-shadow":{Webkit:this.computeBoxShadow("w3c",b.boxShadow.hover)},"-ms-box-shadow":{MSIE:this.computeBoxShadow("w3c",b.boxShadow.hover)},"-o-box-shadow":{Opera:this.computeBoxShadow("w3c",b.boxShadow.hover)},"box-shadow":{other:this.computeBoxShadow("w3c",b.boxShadow.hover)}})),this.createCSS([{component:"title",state:"clicked"},{component:"title",state:"down"}],this.createStyle({"color":b.color.click,"border":"1px solid #000","border-top-color":b.border.color.click.top,"border-right-color":b.border.color.click.right,"border-bottom-color":b.border.color.click.bottom,"border-left-color":b.border.color.click.left,"border-left":(this.config.useLogo&&b.border.corners!=="all")?"0":"","background-color":{Webkit:"",Gecko:"",MSIE:"",other:b.background.click},"background-image":{Webkit:this.computeGradientStyle("webkit",b.gradient.click),Gecko:this.computeGradientStyle("gecko",b.gradient.click),MSIE:this.computeGradientStyle("msie",b.gradient.click),Opera:this.computeGradientStyle("opera",b.gradient.click),other:this.computeGradientStyle("w3c",b.gradient.click)},"filter":{MSIE:this.computeGradientStyle("msieold",b.gradient.click)},"-moz-box-shadow":{Gecko:this.computeBoxShadow("w3c",b.boxShadow.click)},"-webkit-box-shadow":{Webkit:this.computeBoxShadow("w3c",b.boxShadow.click)},"-ms-box-shadow":{MSIE:this.computeBoxShadow("w3c",b.boxShadow.click)},"-o-box-shadow":{Opera:this.computeBoxShadow("w3c",b.boxShadow.click)},"box-shadow":{other:this.computeBoxShadow("w3c",b.boxShadow.click)}})),this.createCSS({component:"titleText"},this.createStyle({"display":"inline-block","vertical-align":"top","height":b.title.height+"px","line-height":b.title.lineHeight+"px"})),this.createCSS({component:"mark"},this.createStyle({"display":"inline-block","width":"0px","overflow":"hidden"})),""].join("")
}).Method("setTitleText",function(a){IN.$Id(this.mainNodeId+"-title-text").innerHTML=a
}).Method("setSuccess",function(c,a){if(!a){IN.Util.removeClass(this.el(),c);
this.setTitleText(this.config.title);
return
}this.setTitleText(this.config.successTitle);
IN.Util.addClass(this.el(),c);
if(this.successStylesSet){return
}var b=this.settings;
function f(g){return{"color":b.color.success[g],"border-top-color":b.border.color.success[g].top,"border-right-color":b.border.color.success[g].right,"border-bottom-color":b.border.color.success[g].bottom,"border-left-color":b.border.color.success[g].left,"background-color":{Webkit:"",Gecko:"",MSIE:"",other:b.background.success[g]},"background-image":{Webkit:IN.Util.computeGradientStyle("webkit",b.gradient.success[g]),Gecko:IN.Util.computeGradientStyle("gecko",b.gradient.success[g]),MSIE:IN.Util.computeGradientStyle("msie",b.gradient.success[g]),Opera:IN.Util.computeGradientStyle("opera",b.gradient.success[g]),other:IN.Util.computeGradientStyle("w3c",b.gradient.success[g])},"filter":{MSIE:IN.Util.computeGradientStyle("msieold",b.gradient.success[g])}}
}var e="";
if(this.config.showSuccessMark){var d=b.mark.margin;
d=[d.top||"0",d.right||"0",d.bottom||"0",d.left||"0"].join("px ")+"px";
e=this.createCSS({component:"mark"},this.createStyle({"width":b.mark.width+"px","height":b.mark.height+"px","background":"url("+IN.ENV.images.sprite+") "+b.mark.background.join("px ")+"px no-repeat","margin":d,"display":"inline-block"}),"."+c)
}this.addCSS(["",e,this.createCSS({component:"title"},this.createStyle(f("normal")),"."+c),this.createCSS({component:"title",state:"hovered"},this.createStyle(f("hover")),"."+c),this.createCSS([{component:"title",state:"clicked"},{component:"title",state:"down"}],this.createStyle(f("click")),"."+c),""].join(""));
this.successStylesSet=true
}).Method("setButtonStyles",function(){this.settings={logo:{height:20,ratio:1,padding:4,position:{top:"0px",right:"",bottom:"",left:"0px",floated:"left"},background:{row:-170,rowOffset:-106}},font:{size:11,family:"Arial, sans-serif",weight:"bold",shadow:"#FFFFFF -1px 1px 0"},title:{padding:{left:0,right:0,ratio:1},height:18,lineHeight:20,textAlign:"center"},boxShadow:{normal:{off:true,horizontal:0,vertical:0,blur:2,color:""},hover:{off:true,horizontal:0,vertical:0,blur:2,color:""},click:{off:true,horizontal:0,vertical:0,blur:2,color:""}},border:{corners:"right",radius:2,color:{normal:{top:"#E2E2E2",right:"#BFBFBF",bottom:"#B9B9B9",left:"#E2E2E2"},hover:{top:"#ABABAB",right:"#9A9A9A",bottom:"#787878",left:(this.config.useLogo)?"#04568B":"#ABABAB"},click:{top:"#B6B6B6",right:"#B3B3B3",bottom:"#9D9D9D",left:(this.config.useLogo)?"#49627B":"#B6B6B6"},success:{normal:{top:"#E2E2E2",right:"#BFBFBF",bottom:"#B9B9B9",left:"#E2E2E2"},hover:{top:"#ABABAB",right:"#9A9A9A",bottom:"#787878",left:(this.config.useLogo)?"#04568B":"#ABABAB"},click:{top:"#B6B6B6",right:"#B3B3B3",bottom:"#9D9D9D",left:(this.config.useLogo)?"#49627B":"#B6B6B6"}}}},ieOffset:2,textShadow:"none",color:{normal:"#333",hover:"#000",click:"#666",success:{normal:"#333",hover:"#000",click:"#666"}},background:{normal:"#ECECEC",click:"#DEDEDE",hover:"#EDEDED",success:{normal:"#ECECEC",click:"#DEDEDE",hover:"#EDEDED"}},gradient:{normal:["#FEFEFE","#ECECEC"],hover:["#EDEDED","#DEDEDE"],click:["#E3E3E3","#EDEDED"],success:{normal:["#FEFEFE","#ECECEC"],hover:["#EDEDED","#DEDEDE"],click:["#E3E3E3","#EDEDED"]}},mark:{width:12+3,height:11,background:[-250,-140],margin:{top:2,right:0,bottom:0,left:0}}};
var e={small:{},medium:{logo:{height:25,background:{rowOffset:-81}},font:{size:13},title:{height:23,lineHeight:23,padding:{ratio:1.25}},border:{radius:3},mark:{width:14+3,height:13,background:[-250,-160],margin:{top:5}}},large:{logo:{height:33,background:{rowOffset:-48}},font:{size:15},title:{height:31,lineHeight:31,padding:{ratio:1.65}},border:{radius:3},mark:{width:14+3,height:13,background:[-250,-160],margin:{top:9,right:5}}},xlarge:{logo:{height:48,background:{rowOffset:0}},font:{size:24},title:{height:46,lineHeight:46,padding:{ratio:2.4}},border:{radius:5},mark:{width:20+5,height:19,background:[-250,-180],margin:{top:1}}}};
var d={basic:{},shernaz:{logo:{ratio:1.06060606,position:{top:"0px",right:"0px",bottom:"",left:"",floated:"right"},background:{row:-298}},font:{weight:"normal",shadow:"none",family:"'Helvetica Neue', Arial, Helvetica, sans-serif"},title:{padding:{left:0.5,right:3.5}},boxShadow:{hover:{off:false,horizontal:0,vertical:2,blur:2,color:"#b7b7b7"}},color:{normal:"#000",hover:"#000",click:"#000",success:{normal:"#000",hover:"#000",click:"#000"}},gradient:{normal:["#ffffff","#f9f9f9","#e3e3e3","#cbcbcb"],hover:["#fdfdfd","#f2f2f2","#e3e3e3","#cbcbcb"],click:["#cbcbcb","#e3e3e3","#f2f2f2","#fdfdfd"],success:{normal:["#ffffff","#f9f9f9","#e3e3e3","#cbcbcb"],hover:["#fdfdfd","#f2f2f2","#e3e3e3","#cbcbcb"],click:["#cbcbcb","#e3e3e3","#f2f2f2","#fdfdfd"]}},background:{normal:"#07547d",click:"#0067a0",hover:"#65add2"},border:{corners:"all",color:{normal:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#acacac",left:"#cdcdcd"},hover:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#acacac",left:"#cdcdcd"},click:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#cdcdcd",left:"#cdcdcd"},success:{normal:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#acacac",left:"#cdcdcd"},hover:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#acacac",left:"#cdcdcd"},click:{top:"#cdcdcd",right:"#cdcdcd",bottom:"#cdcdcd",left:"#cdcdcd"}}}},fancy:{color:{normal:"#fff",hover:"#fff",click:"#fff"},gradient:{normal:["#65add2","30:#0f90d2","67:#006daa","#07547d"],hover:["#5caad2","30:#0084ce","67:#006daa","#07527b"],click:["#07527b","30:#006daa","67:#0084ce","#5caad2"]},background:{normal:"#007cbb",hover:"#0083c6",click:"#007cbb"},border:{corners:"all",color:{normal:{top:"#2771aa",right:"#2771aa",bottom:"#2771aa",left:"#2771aa"},hover:{top:"#2771aa",right:"#2771aa",bottom:"#2771aa",left:"#2771aa"},click:{top:"#2771aa",right:"#2771aa",bottom:"#2771aa",left:"#2771aa"}}}},simple:{title:{padding:{left:0,right:0}},boxShadow:{hover:{off:true}}}}};
var f=this.config.theme.split("-");
var c=d;
for(var a=0,b=f.length;
a<b;
a++){c=c[f[a]];
if(!c){break
}IN.Util.extendObject(this.settings,c)
}e=e[this.config.size]||{};
IN.Util.extendObject(this.settings,e)
});

/* res://connect-min/dev/objects/inlink.js */

Sslac.Class("IN.Objects.InLink").Extends("IN.Objects.Base").Constructor(function(c){c=c||{};
c={text:c.text||"",size:(c.size)||"small",suppressFont:true};
this.Parent(c);
this.size=c.size.toLowerCase();
this.sizeSettings={small:{height:16,width:16,logo:[-92,-42]}};
var b="",f=this.generateId(),e={},d=false,a=this;
b=["",'<span id="'+f+'" class="li-connect-widget">','<a id="'+f+'-link" class="li-connect-link" href="javascript:void(0);"><span id="'+f+'-mark" class="li-connect-mark"></span></a>',(c.text)?' <a class="li-connect-link" href="javascript:void(0);"><span id="'+f+'-text" class="li-connect-text">'+c.text+"</span></a>":"","</a>","</span>",""].join("");
e=["",this.getBaseStyles(c),""].join("").replace(/\{ID\}/g,f);
IN.Util.addCSS(e);
this.el().innerHTML=b;
this.mainNodeId=f;
this.onClick=this.addHandler(f,"click");
this.onMouseDown=this.addHandler(f,"mousedown");
this.onMouseOver=this.addHandler(f,"mouseover");
this.onMouseOut=this.addHandler(f,"mouseout");
this.onClick(function(g){this.setState("click")
},this);
this.onMouseDown(function(g){this.setState("mouseDown")
},this);
this.onMouseOver(function(g){this.setState("mouseOver")
},this);
this.onMouseOut(function(){this.setState("mouseOut")
},this)
}).Method("setState",function(e){var a=IN.$Id(this.mainNodeId),d=this,f="hovered",b="clicked",c="pending";
if(!a){return
}switch(e){case"pending":IN.Util.addClass(a,c);
window.setTimeout(function(){d.setState("normal")
},10000);
break;
case"mouseOver":IN.Util.addClass(a,f);
break;
case"mouseOut":IN.Util.removeClass(a,f);
break;
case"mouseDown":break;
case"click":IN.Util.addClass(a,b);
break;
case"normal":IN.Util.removeClass(a,f);
IN.Util.removeClass(a,b);
IN.Util.removeClass(a,c);
break
}}).Method("getSetting",function(a){if(typeof(this.sizeSettings[this.size])=="undefined"){return this.sizeSettings.small[a]
}return this.sizeSettings[this.size][a]
}).Method("getBaseStyles",function(a){return["",".li-connect-widget .li-connect-mark {",this.createStyle({"background":"url("+IN.ENV.images.sprite+") "+this.getSetting("logo").join("px ")+"px no-repeat","display":"inline-block","height":this.getSetting("height")+"px","text-decoration":"none","width":this.getSetting("width")+"px","vertical-align":"middle","*margin-left":"3px"}),"}",".IN-widget .hovered .li-connect-mark {",this.createStyle({"cursor":"pointer"}),"}",".li-connect-widget.pending .li-connect-mark {",this.createStyle({"background":"url(data:image/jpeg;base64,R0lGODlhEAAQAKIAAP///+bm5s7OzpycnGNjYwAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh+QQFCgAAACwAAAAADgAQAAADNAi6MMNQOReBEG0CQta92cZ11seMZBlxClh55lu6Mi23GBQEsL3vOBDwx8MBiMei7ndLQhIAIfkEBQoAAAAsAgAAAA4ADgAAAyUIqiL7rzUIpRuDsouzVp33AdgIEYQJoKjJpi4cBOo8mzaN62MCACH5BAUKAAAALAAAAgAQAAwAAAMmCLoMIi2q92Sj0LK6QtDAMACeZ4li+UnoaGoiqBCEPNO1jOc6nwAAIfkEBQoAAAAsAgACAA4ADgAAAyUIEdD+ajH45KRu4Y2F4I3ngeJHmtswgICqYgTRulQcz7DN3lQCACH5BAUKAAAALAIAAAAMABAAAAMmCKoR+6w5GBtd9urNu/8XQVCCAIjiU5boOAzAaqbvG5tPDWv2kwAAIfkEBQoAAAAsAAACAA4ADgAAAyUIugwRLb4X2YR1UUBIXl33ceFImsswmKo6tqsgZK4sj/aM60sCACH5BAUKAAAALAAAAgAQAAwAAAMmCEqk/o8xSIFsFc7sxuBAEACel4li+VXoaHLiIwigM881cNM5DiYAIfkECQoAAAAsAAAAABAAEAAAAygIukDEkDkX1xhtVnBv3lwHMt4ICIKpoKjKpi6sjkEw17WK2zo//5EEADs=) no-repeat","*background":"url("+IN.ENV.images.sprite+") "+this.getSetting("logo").join("px ")+"px no-repeat","cursor":"wait"}),"}",""].join("")
});

/* res://connect-min/dev/objects/callout.js */

Sslac.Class("IN.Objects.Callout").Extends("IN.Objects.Base").Constructor(function(c){c=c||{};
c={position:c.position||"right",state:c.state||"visible",alwaysShow:c.alwaysShow||false,content:(!c.content&&c.content!==0)?"":c.content};
this.Parent(c);
if(c.position.toLowerCase()==="talltop"){c.position="top"
}var b="",h=this.generateId(),f=null,e=null,g=null,d=false,a=this;
this.mainNodeId=h;
this.alwaysShow=c.alwaysShow;
b=["",'<span id="'+h+'-container" class="IN-'+c.position+(c.state=="hidden"?" IN-hidden":"")+'">','<span id="'+h+'" class="IN-'+c.position+'">','<span id="'+h+'-inner" class="IN-'+c.position+'">','<span id="'+h+'-content" class="IN-'+c.position+'">'+c.content+"</span>","</span>","</span>","</span>",""].join("");
g=["","#{ID}-container.IN-right {",this.createStyle({"display":"inline-block","float":"left","overflow":"visible","position":"relative","height":"18px","padding-left":"2px","line-height":"1px","cursor":"pointer","vertical-align":{MSIE:"-2px"}}),"}","#{ID}.IN-right {",this.createStyle({"display":"block","float":"left","height":"18px","margin-right":"4px","padding-right":"4px","background":"url("+IN.ENV.images.sprite+") right -100px no-repeat"}),"}","#{ID}-inner.IN-right {",this.createStyle({"display":"block","float":"left","padding-left":"8px","text-align":"center","background":"url("+IN.ENV.images.sprite+") 0px -60px no-repeat"}),"}","#{ID}-content.IN-right {",this.createStyle({"display":"inline","font-size":"11px","color":"#04558B","font-weight":"bold","font-family":"Arial, sans-serif","line-height":"18px","padding":"0 5px 0 5px"}),"}","#{ID}-container.IN-hovered #{ID}.IN-right, #{ID}-container.IN-clicked #{ID}.IN-right, #{ID}-container.IN-down #{ID}.IN-right {",this.createStyle({"background-position-y":"-120px"}),"}","#{ID}-container.IN-hovered #{ID}-inner.IN-right, #{ID}-container.IN-clicked #{ID}-inner.IN-right, #{ID}-container.IN-down #{ID}-inner.IN-right {",this.createStyle({"background-position-y":"-80px"}),"}","#{ID}-container.IN-empty {",this.createStyle({"display":"none"}),"}",""].join("").replace(/\{ID\}/g,h);
e=["","#{ID}-container.IN-top {",this.createStyle({"display":"inline-block","overflow":"visible","position":"relative","height":"42px","line-height":"1px","cursor":"pointer"}),"}","#{ID}.IN-top {",this.createStyle({"display":"inline-block","height":"42px","width":"57px","background":"url("+IN.ENV.images.sprite+") -150px top no-repeat"}),"}","#{ID}-content.IN-top {",this.createStyle({"display":"inline","font-size":"16px","color":"#04558B","font-weight":"bold","font-family":"Arial, sans-serif","line-height":"34px"}),"}","#{ID}-container.IN-hovered #{ID}.IN-top, #{ID}-container.IN-clicked #{ID}.IN-top, #{ID}-container.IN-down #{ID}.IN-top {",this.createStyle({"background-position-x":"-210px"}),"}","#{ID}-container.IN-empty #{ID}-inner.IN-top {",this.createStyle({"background":"url("+IN.ENV.images.sprite+") 0px -20px no-repeat","overflow":"hidden","margin":"5px auto 0 auto","width":"26px","height":"26px","display":"block"}),"}","#{ID}-container.IN-empty #{ID}-content.IN-top {",this.createStyle({"text-indent":"-999px","display":"inline-block"}),"}",""].join("").replace(/\{ID\}/g,h);
f=["",(c.position=="right")?g:"",(c.position=="top")?e:"","#{ID}-container.IN-hidden #{ID} {",this.createStyle({"display":"none"}),"}",""].join("").replace(/\{ID\}/g,h);
IN.Util.addCSS(f);
this.el().innerHTML=b;
this.onClick=this.addHandler(h,"click");
this.onMouseDown=this.addHandler(h,"mousedown");
this.onMouseOver=this.addHandler(h,"mouseover");
this.onMouseOut=this.addHandler(h,"mouseout");
this.onMouseDown(function(i){this.setState("mouseDown")
},this);
this.onMouseOver(function(i){this.setState("mouseOver")
},this);
this.onMouseOut(function(i){this.setState("mouseOut")
},this);
this.onClick(function(i){this.setState("click")
},this)
}).Method("setContent",function(c){var b=IN.$Id(this.mainNodeId+"-container"),a=IN.$Id(this.mainNodeId+"-content");
IN.Util.removeClass(b,"IN-empty");
if(c==="0"||c===""){IN.Util.addClass(b,"IN-empty")
}a.innerHTML=c
}).Method("getContent",function(){var a=IN.$Id(this.mainNodeId+"-content");
return a.innerHTML
}).Method("setState",function(c){var a=IN.$Id(this.mainNodeId+"-container"),b=this;
switch(c){case"hidden":IN.Util.addClass(a,"IN-hidden");
break;
case"visible":IN.Util.removeClass(a,"IN-hidden");
break;
case"mouseOver":IN.Util.addClass(a,"IN-hovered");
break;
case"mouseDown":IN.Util.addClass(a,"IN-down");
break;
case"mouseOut":IN.Util.removeClass(a,"IN-hovered");
IN.Util.removeClass(a,"IN-down");
break;
case"click":if(IN.Util.hasClass(a,"IN-clicked")){return
}IN.Util.removeClass(a,"IN-hovered");
IN.Util.addClass(a,"IN-clicked");
window.setTimeout(function(){b.setState("normal")
},2000);
break;
case"normal":IN.Util.removeClass(a,"IN-hovered");
IN.Util.removeClass(a,"IN-clicked");
break
}});

/* res://connect-min/dev/objects/smartwindow.js */

Sslac.Class("IN.Objects.SmartWindow").Extends("IN.Objects.Base").Constructor(function Constructor(a){a=a||{};
a={url:a.url||"about:blank",mode:a.mode||"auto",anchor:a.anchor||null,width:a.width||IN.ENV.ui.popup_window_width,height:a.height||400};
this.onWindowCreate=new IN.CustomEvent("windowCreate");
this.onWindowRemove=new IN.CustomEvent("windowRemove",true);
this.Parent(a);
var b=a.url.match(/^https:\/\//);
this.disableRefresh=a.disableRefresh;
this.anchorInfo=a.anchor;
this.transport=null;
this.created=false;
this.channelId=IN.$uid();
this.postUrl=a.url;
this.transportUrl=(b)?IN.ENV.url.xd_html:IN.ENV.url.xd_us_html;
this.xdSwfUrl=(b)?IN.ENV.images.secure_xdswf:IN.ENV.images.unsecure_xdswf;
this.postParams={};
this.transportOptions=[];
this.callbacks={success:[],error:[],ready:[]};
this.width=a.width;
this.height=a.height;
this.frameMode=a.mode;
if(this.frameMode=="auto"){if(IN.User.isAuthorized()){this.frameMode="modal"
}else{this.frameMode="popup"
}}this.onWindowCreate.subscribe(function(){this.created=true
},this);
this.transportOptions.push("target="+this.channelId);
this.transportOptions.push("width="+this.width);
this.transportOptions.push("height="+this.height);
switch(this.frameMode){case"inline-iframe":case"iframe":case"embedded":case"modal":case"hovercard":case"invisible":this.transportOptions.push("mode=wrapper");
break;
case"popup":win=window.open(this.transportUrl+"#mode=popup-wait&target=easyXDM_IN_Lib_"+this.channelId+"_provider","easyXDM_IN_Lib_"+this.channelId+"_provider_popup","width="+this.width+", height="+this.height);
this.transportOptions.push("mode=popup");
break
}return this
}).Method("remove",function remove(){if(this.transport){this.transport.destroy();
this.transport=null
}this.onWindowRemove.fire();
this.Parent()
}).Method("params",function params(a){a.original_referer=location.href;
a.token=IN.ENV.auth.anonymous_token;
this.postParams=a;
return this
}).Method("ready",function ready(b,a){return this.pushCallback(b,"ready",a)
}).Method("success",function success(b,a){return this.pushCallback(b,"success",a)
}).Method("error",function error(b,a){return this.pushCallback(b,"error",a)
}).Method("pushCallback",function handleEvent(b,c,a){this.callbacks[c].push({fn:b||function(){},scope:a||window});
return this
}).Method("handleWidgetReady",function handleWidgetReady(b,c,a){this.handleCallback(b,c,a,"ready")
}).Method("handleWidgetSuccess",function handleWidgetSuccess(b,c,a){this.handleCallback(b,c,a,"success")
}).Method("handleWidgetFailure",function handleWidgetFailure(b,c,a){this.handleCallback(b,c,a,"error")
}).Method("handleCallback",function handleCallback(f,g,c,e){if(this.callbacks[e]&&this.callbacks[e].length){for(var d=0,b=this.callbacks[e].length;
d<b;
d++){var a=this.callbacks[e][d];
a.fn.call(a.scope,f)
}}g()
}).Method("mode",function mode(e){var b=this.frameOptions;
var a=this.frameMode||"";
var c=this;
var g={};
switch(e.toLowerCase()){case"embedded":g={embedded:true};
break;
case"modal":g={embedded:false,shadowBox:true,closeOnDocClick:true,overlay:true,reCenter:true};
break;
case"hovercard":g={embedded:false,overlay:true,closeOnDocClick:true};
break;
case"invisible":g={embedded:false,closeOnDocClick:false,disableRefresh:true};
break;
case"popup":g={popup:true};
if(a&&a!=="popup"){throw new Error("cannot change to the popup type")
}break;
default:throw new Error(e+" is not supported")
}this.frameMode=e;
this.frameOptions=g;
function d(h){if(g.popup){return
}h.style.position="";
if(!g.embedded){h.style.position="absolute";
h.style.left="-2345px";
h.style.top="0"
}if(g.overlay){h.style.zIndex="9999"
}else{h.style.zIndex=""
}if(!g.shadowBox){IN.Objects.Lib.setShadowBox(false)
}}function f(h){if(g.popup){return
}function j(){IN.Event.remove(IN,"refresh",c.triggerRefresh,c);
IN.Event.remove(IN,"logout",c.triggerRefresh,c);
c.remove()
}function i(){IN.Objects.Lib.center(h)
}if(g.closeOnDocClick){IN.Event.onOnce(document,"click",j,c.transport)
}else{if(b&&b.closeOnDocClick){IN.Event.remove(document,"click",j,c.transport)
}}if(!g.disableRefresh){IN.Event.on(IN,"refresh",c.triggerRefresh,c);
IN.Event.on(IN,"logout",c.triggerRefresh,c)
}else{if(b&&!b.disableRefresh){IN.Event.remove(IN,"refresh",c.triggerRefresh,c);
IN.Event.remove(IN,"logout",c.triggerRefresh,c)
}}if(g.reCenter){IN.Event.on(window,"resize",i,c)
}else{IN.Event.remove(window,"resize",i,c)
}}if(this.created){d(this.frameNode);
f(this.frameNode)
}else{this.onWindowCreate.subscribe(function(){if(this.frameNode){d(this.frameNode);
f(this.frameNode);
this.frameNode.style.width="1px";
this.frameNode.style.height="1px";
this.frameNode.style.display="inline-block"
}if(g.shadowBox){IN.Objects.Lib.setShadowBox(true)
}},this);
this.onWindowRemove.subscribe(function(){IN.Objects.Lib.setShadowBox(false)
},this)
}}).Method("triggerRefresh",function triggerRefresh(){if(this.transport&&this.transport.refresh){this.transport.refresh()
}}).Method("place",function place(a,c){this.Parent(a,c);
var d,b=this.transportOptions.join("&");
switch(this.frameMode){case"embedded":case"hovercard":case"invisible":case"modal":d=this.getEmbeddedRpc(b);
break;
case"popup":d=this.getPopupRpc(b);
break
}this.mode(this.frameMode);
this.transport=new IN.Lib.easyXDM.Rpc(d[0],d[1]);
return this
}).Method("getPopupRpc",function getPopupRpc(i){var e=this,b,a,f,c="";
b={remote:this.transportUrl+"#"+i,swf:this.xdSwfUrl,hash:true,channel:this.channelId,onReady:function g(){e.onWindowCreate.fire();
e.transport.form({action:e.postUrl,items:e.postParams})
}};
a={local:{authorize:function d(q,n,p,r,o){IN.User.setAuthorized(q,n,p);
r()
},logout:function m(o,n){IN.User.setLoggedOut();
o()
},widgetSuccess:function l(o,p,n){e.handleWidgetSuccess(o,p,n)
},widgetError:function h(o,p,n){e.handleWidgetFailure(o,p,n)
},widgetReady:function k(o,p,n){e.handleWidgetReady(o,p,n)
},closedWindow:function j(p,n){window.setTimeout(function o(){e.remove()
},1)
}},remote:{form:{}}};
return[b,a]
}).Method("getEmbeddedRpc",function getIframeRpc(h){var e=this,d,c,i;
d={remote:this.transportUrl+"#"+h,hash:true,swf:this.xdSwfUrl,channel:this.channelId,container:this.el(),props:{style:{position:"absolute"}},onReady:function f(){i=e.el().getElementsByTagName("iframe")[0];
e.frameNode=i;
e.onWindowCreate.fire(i);
e.transport.form({action:e.postUrl,items:e.postParams})
}};
c={local:{logout:function n(p,o){IN.User.setLoggedOut();
p()
},reload:function a(p,o){e.transport.refresh()
},resize:function b(t,p,v,q){i.style.width=t+"px";
i.style.height=p+"px";
if(!e.frameOptions.embedded&&e.frameMode!=="hovercard"){var o=IN.Objects.Lib.getCenter(i);
if(e.hasAnimated){IN.Objects.Lib.slideTo(i,o,{bounce:0,duration:200})
}else{var s=IN.Objects.Lib.getViewport();
var u=IN.Objects.Lib.getScrollOffsets();
e.hasAnimated=true;
i.style.left=o.left+"px";
i.style.top=u.top+s.height-(o.bottom-o.top)+"px";
IN.Objects.Lib.slideTo(i,o)
}}if(!e.frameOptions.embedded&&e.anchorInfo){var r=IN.Objects.Lib.anchor(e.anchorInfo.fixed,i,e.anchorInfo.context);
e.transport.mode({display:"hover",context:r.movable})
}v({width:t,height:p})
},login:function k(p,o){IN.GlobalEvents.refresh.fire()
},close:function m(p,o){e.remove()
},widgetSuccess:function l(p,q,o){e.handleWidgetSuccess(p,q,o)
},widgetError:function g(p,q,o){e.handleWidgetFailure(p,q,o);
IN.Objects.Lib.shake(i)
},widgetReady:function j(p,q,o){e.handleWidgetReady(p,q,o)
}},remote:{mode:{},refresh:{},form:{}}};
return[d,c]
});

/* res://connect-min/dev/ui/ui.js */

Sslac.Static("IN.UI").Static("Authorize",function(){var a=["",IN.ENV.url.authorize,(IN.ENV.url.authorize.indexOf("?")===-1)?"?":"&","client_id="+IN.ENV.auth.api_key,"&type=user-agent",""].join("");
var b=new IN.Objects.SmartWindow({url:a,mode:"popup"});
return b
}).Static("WidgetSignin",function(b){var a=IN.ENV.url.login,c;
b=b||{};
c=new IN.Objects.SmartWindow({url:a,mode:"popup",existingPopup:b.existingPopup||null});
return c
}).Static("Logout",function(){var a=IN.ENV.url.logout,b;
a=a.replace(/\{OAUTH_TOKEN\}/,IN.ENV.auth.oauth_token).replace(/\{API_KEY\}/,IN.ENV.auth.api_key);
b=new IN.Objects.SmartWindow({mode:"invisible",url:a,disableRefresh:true});
b.success(function(){IN.User.setLoggedOut()
});
return b
}).Static("Share",function(){return new IN.Objects.SmartWindow({url:IN.ENV.widget.share_url})
}).Static("Apply",function(){return new IN.Objects.SmartWindow({mode:"modal",url:IN.ENV.widget.apply_url})
}).Static("Debugger",function(){return new IN.Objects.SmartWindow({mode:"popup",url:IN.ENV.widget.settings_url})
});

/* res://connect-min/dev/user/user.js */

Sslac.Static("IN.User").Static("setAuthorized",function(b,c,a){IN.ENV.auth.oauth_token=b;
IN.ENV.auth.member_id=c;
IN.User.setOauthCookie(a);
window.setTimeout(function d(){IN.GlobalEvents.auth.fire();
IN.GlobalEvents.refresh.fire()
},0)
}).Static("setNotAuthorized",function(){IN.GlobalEvents.noAuth.fire()
}).Static("setLoggedOut",function(){IN.ENV.auth.oauth_token="";
IN.ENV.auth.member_id="";
IN.User.setOauthCookie("");
window.setTimeout(function a(){IN.GlobalEvents.logout.fire()
},0)
}).Static("authorize",function(b,a){a=a||window;
if(IN.User.isAuthorized()){if(b){b.apply(a)
}return true
}else{if(b){IN.Event.onOnce(IN,"auth",b,a)
}IN.UI.Authorize().place();
return false
}}).Static("logout",function(b,a){var c=IN.UI.Logout();
a=a||window;
if(b){c.success(b,a)
}c.place(document.body)
}).Static("refresh",function(){var a=IN.ENV.url.userspace_renew,b=document.createElement("script");
a=a.replace(/\{API_KEY\}/,IN.ENV.auth.api_key);
b.type="text/javascript";
b.src=a;
b.className="in_keepalive";
IN.$Tag("head")[0].appendChild(b)
}).Static("isAuthorized",function(){if(IN.ENV.auth.oauth_token||IN.ENV.auth.oauth_verified){return true
}return false
}).Static("setOauthCookie",function(b){var g="linkedin_oauth_"+IN.ENV.auth.api_key;
if(!IN.ENV.auth.is_set_client_auth_cookie||b===""||b===null){var a=new Date();
a.setTime(a.getTime()-1);
window.setTimeout(function f(){document.cookie=g+"=null;path=/;secure;expires="+a.toGMTString();
document.cookie=g+"_crc=null;path=/;expires="+a.toGMTString()
},0);
return
}if(typeof b==="string"){try{b=JSON.parse(b)
}catch(d){}}if((typeof b)==="object"){b=encodeURIComponent(JSON.stringify(b))
}window.setTimeout(function c(){document.cookie=g+"="+b+";path=/;secure;";
if(IN.ENV.js.credentials_cookie_crc){document.cookie=g+"_crc="+IN.Util.crc32(b)+";path=/;"
}},0)
}).Static("getUIMode",function(){var a=IN.User;
if(!a.isAuthorized()){return"window"
}else{return"iframe"
}}).Static("getMemberId",function(){return(IN.ENV&&IN.ENV.auth&&IN.ENV.auth.member_id)?IN.ENV.auth.member_id:""
});

/* res://connect-min/dev/connect/onload.js */

(function(){var i,c,d=false,h=20,e=4000,j=Math.floor(e/h);
IN.GlobalEvents.frameworkLoaded.fire();
IN.Event.on(IN,"systemReady",function(){if(IN.ENV.js.onLoad){for(var n,m=0,o=IN.ENV.js.onLoad.split(","),l=o.length;
m<l&&(n=o[m]);
m++){var p=Sslac.valueOf(IN.Util.trim(n));
if(p&&typeof(p)=="function"){p.call()
}else{throw new Error("Could not execute '"+n+"'. Please provide a valid function for callback.")
}}}});
function a(){var m=[],n=IN.ENV.js.extensions;
d=true;
for(var l in n){if(n[l].loaded===false){m.push(l+" @ "+(n[l].src||"linkedin"))
}}if(console&&console.log){console.log("The following extensions did not load: "+m.join(", "))
}}function k(){if(d){return true
}if(!IN.ENV.js||!IN.ENV.js.extensions){return true
}var m=IN.ENV.js.extensions;
for(var l in m){if(m[l].loaded===false){return false
}}return true
}function f(){if(k()){window.clearTimeout(i);
IN.Event.onDOMReady(function l(){IN.GlobalEvents.systemReady.fire()
})
}else{j--;
if(j<=0){a()
}else{i=window.setTimeout(f,10)
}}}f();
IN.parse(document.body);
if(IN.ENV.js.statistics!=="false"&&IN.ENV.js.statistics!==false){var b=(/^https:\/\//).test(location.href)?IN.ENV.url.analytics_url:IN.ENV.url.analytics_us_url,g=new Image();
b=b.replace("__ETYPE__","widgetJSTracking").replace("__TINFO__",(IN.ENV.js.api_key)?"cws-fwk-userspace":"cws-fwk-anonymous").replace("__WTYPE__","framework").replace("__ORIGIN__",encodeURIComponent(location.href));
g.src=b+"&cache="+(new Date()).getTime()
}})();