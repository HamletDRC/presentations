if(!window.console){window.console={}
}if(typeof window.console.log!=="function"){window.console.log=function(){}
}if(typeof window.console.warn!=="function"){window.console.warn=function(){}
}(function(){var N={"bootstrapInit":+new Date()},p=document,l=(/^https?:\/\/.*?linkedin.*?\/in\.js.*?$/),b=(/async=true/),B=(/^https:\/\//),H=(/\/\*((?:.|[\s])*?)\*\//m),D=(/\r/g),j=(/[\s]/g),g=(/^[\s]*(.*?)[\s]*:[\s]*(.*)[\s]*$/),y=(/^[\s]+|[\s]+$/g),A=(/suppress(Warnings|_warnings):true/gi),d=(/^api(Key|_key)$/gi),k="\n",E=",",n="",G="@",R="&",o="extensions",U="on",v="onDOMReady",X="onOnce",V="script",J="https://www.linkedin.com/uas/js/userspace?v=0.0.1140-RC3.13944-1337",h="https://platform.linkedin.com/js/secureAnonymousFramework?v=0.0.1140-RC3.13944-1337",F="http://platform.linkedin.com/js/nonSecureAnonymousFramework?v=0.0.1140-RC3.13944-1337",z=p.getElementsByTagName("head")[0],t=p.getElementsByTagName(V),a=[],M={},c=false,Y,m,S,r,I,C,W;
if(window.IN&&IN.ENV&&IN.ENV.js){if(!IN.ENV.js.suppressWarnings){console.warn("duplicate in.js loaded, any parameters will be ignored")
}return
}window.IN=window.IN||{};
IN.ENV={};
IN.ENV.js={};
IN.ENV.js.extensions={};
statsQueue=IN.ENV.statsQueue=[];
statsQueue.push(N);
Y=IN.ENV.evtQueue=[];
IN.Event={on:function(){Y.push({type:U,args:arguments})
},onDOMReady:function(){Y.push({type:v,args:arguments})
},onOnce:function(){Y.push({type:X,args:arguments})
}};
IN.$extensions=function(ab){var ae,i,aa,ad,ac=IN.ENV.js.extensions;
ae=ab.split(E);
for(var Z=0,e=ae.length;
Z<e;
Z++){i=Q(ae[Z],G,2);
aa=i[0].replace(y,n);
ad=i[1];
if(!ac[aa]){ac[aa]={src:(ad)?ad.replace(y,n):n,loaded:false}
}}};
function Q(ab,Z,e){var ac=ab.split(Z);
if(!e){return ac
}if(ac.length<e){return ac
}var aa=ac.splice(0,e-1);
var i=ac.join(Z);
aa.push(i);
return aa
}function u(e,i){if(e==o){IN.$extensions(i);
return null
}if(d.test(e)){i=i.replace(j,n)
}if(i==""){return null
}return i
}function K(e,i){i=u(e,i);
if(i){e=e.replace(/_([a-z])/gi,function(){return arguments[1].toUpperCase()
});
IN.ENV.js[e]=i;
a.push(encodeURIComponent(e)+"="+encodeURIComponent(i))
}}m="";
for(P=0,q=t.length;
P<q;
P++){var f=t[P];
if(!l.test(f.src)){continue
}if(b.test(f.src)){c=true
}try{m=f.innerHTML.replace(y,n)
}catch(x){try{m=f.text.replace(y,n)
}catch(w){}}}m=m.replace(H,"$1").replace(y,n).replace(D,n);
W=A.test(m.replace(j,n));
for(var P=0,O=m.split(k),q=O.length;
P<q;
P++){var s=O[P];
if(!s||s.replace(j,n).length<=0){continue
}try{S=s.match(g);
r=S[1].replace(y,n);
I=S[2].replace(y,n)
}catch(T){if(!W){console.warn("script tag contents must be key/value pairs separated by a colon. Source: "+T)
}continue
}K(r,I)
}IN.ENV.js.secure=(B.test(document.location.href))?1:0;
a.push("secure="+encodeURIComponent(IN.ENV.js.secure));
IN.init=function L(e){var Z;
e=e||{};
for(var i in e){if(e.hasOwnProperty(i)){K(i,e[i])
}}C=p.createElement(V);
C.src=(IN.ENV.js.apiKey)?J+R+a.join(R):(IN.ENV.js.secure)?h:F;
z.appendChild(C);
statsQueue.push({"userspaceRequested":+new Date()})
};
statsQueue.push({"bootstrapLoaded":+new Date()});
if(!c){IN.init()
}})();
