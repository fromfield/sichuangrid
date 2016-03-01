/*! jQuery v1.8.2 jquery.com | jquery.org/license */
;(function(a,b){function G(a){var b=F[a]={};return p.each(a.split(s),function(a,c){b[c]=!0}),b}function J(a,c,d){if(d===b&&a.nodeType===1){var e="data-"+c.replace(I,"-$1").toLowerCase();d=a.getAttribute(e);if(typeof d=="string"){try{d=d==="true"?!0:d==="false"?!1:d==="null"?null:+d+""===d?+d:H.test(d)?p.parseJSON(d):d}catch(f){}p.data(a,c,d)}else d=b}return d}function K(a){var b;for(b in a){if(b==="data"&&p.isEmptyObject(a[b]))continue;if(b!=="toJSON")return!1}return!0}function ba(){return!1}function bb(){return!0}function bh(a){return!a||!a.parentNode||a.parentNode.nodeType===11}function bi(a,b){do a=a[b];while(a&&a.nodeType!==1);return a}function bj(a,b,c){b=b||0;if(p.isFunction(b))return p.grep(a,function(a,d){var e=!!b.call(a,d,a);return e===c});if(b.nodeType)return p.grep(a,function(a,d){return a===b===c});if(typeof b=="string"){var d=p.grep(a,function(a){return a.nodeType===1});if(be.test(b))return p.filter(b,d,!c);b=p.filter(b,d)}return p.grep(a,function(a,d){return p.inArray(a,b)>=0===c})}function bk(a){var b=bl.split("|"),c=a.createDocumentFragment();if(c.createElement)while(b.length)c.createElement(b.pop());return c}function bC(a,b){return a.getElementsByTagName(b)[0]||a.appendChild(a.ownerDocument.createElement(b))}function bD(a,b){if(b.nodeType!==1||!p.hasData(a))return;var c,d,e,f=p._data(a),g=p._data(b,f),h=f.events;if(h){delete g.handle,g.events={};for(c in h)for(d=0,e=h[c].length;d<e;d++)p.event.add(b,c,h[c][d])}g.data&&(g.data=p.extend({},g.data))}function bE(a,b){var c;if(b.nodeType!==1)return;b.clearAttributes&&b.clearAttributes(),b.mergeAttributes&&b.mergeAttributes(a),c=b.nodeName.toLowerCase(),c==="object"?(b.parentNode&&(b.outerHTML=a.outerHTML),p.support.html5Clone&&a.innerHTML&&!p.trim(b.innerHTML)&&(b.innerHTML=a.innerHTML)):c==="input"&&bv.test(a.type)?(b.defaultChecked=b.checked=a.checked,b.value!==a.value&&(b.value=a.value)):c==="option"?b.selected=a.defaultSelected:c==="input"||c==="textarea"?b.defaultValue=a.defaultValue:c==="script"&&b.text!==a.text&&(b.text=a.text),b.removeAttribute(p.expando)}function bF(a){return typeof a.getElementsByTagName!="undefined"?a.getElementsByTagName("*"):typeof a.querySelectorAll!="undefined"?a.querySelectorAll("*"):[]}function bG(a){bv.test(a.type)&&(a.defaultChecked=a.checked)}function bY(a,b){if(b in a)return b;var c=b.charAt(0).toUpperCase()+b.slice(1),d=b,e=bW.length;while(e--){b=bW[e]+c;if(b in a)return b}return d}function bZ(a,b){return a=b||a,p.css(a,"display")==="none"||!p.contains(a.ownerDocument,a)}function b$(a,b){var c,d,e=[],f=0,g=a.length;for(;f<g;f++){c=a[f];if(!c.style)continue;e[f]=p._data(c,"olddisplay"),b?(!e[f]&&c.style.display==="none"&&(c.style.display=""),c.style.display===""&&bZ(c)&&(e[f]=p._data(c,"olddisplay",cc(c.nodeName)))):(d=bH(c,"display"),!e[f]&&d!=="none"&&p._data(c,"olddisplay",d))}for(f=0;f<g;f++){c=a[f];if(!c.style)continue;if(!b||c.style.display==="none"||c.style.display==="")c.style.display=b?e[f]||"":"none"}return a}function b_(a,b,c){var d=bP.exec(b);return d?Math.max(0,d[1]-(c||0))+(d[2]||"px"):b}function ca(a,b,c,d){var e=c===(d?"border":"content")?4:b==="width"?1:0,f=0;for(;e<4;e+=2)c==="margin"&&(f+=p.css(a,c+bV[e],!0)),d?(c==="content"&&(f-=parseFloat(bH(a,"padding"+bV[e]))||0),c!=="margin"&&(f-=parseFloat(bH(a,"border"+bV[e]+"Width"))||0)):(f+=parseFloat(bH(a,"padding"+bV[e]))||0,c!=="padding"&&(f+=parseFloat(bH(a,"border"+bV[e]+"Width"))||0));return f}function cb(a,b,c){var d=b==="width"?a.offsetWidth:a.offsetHeight,e=!0,f=p.support.boxSizing&&p.css(a,"boxSizing")==="border-box";if(d<=0||d==null){d=bH(a,b);if(d<0||d==null)d=a.style[b];if(bQ.test(d))return d;e=f&&(p.support.boxSizingReliable||d===a.style[b]),d=parseFloat(d)||0}return d+ca(a,b,c||(f?"border":"content"),e)+"px"}function cc(a){if(bS[a])return bS[a];var b=p("<"+a+">").appendTo(e.body),c=b.css("display");b.remove();if(c==="none"||c===""){bI=e.body.appendChild(bI||p.extend(e.createElement("iframe"),{frameBorder:0,width:0,height:0}));if(!bJ||!bI.createElement)bJ=(bI.contentWindow||bI.contentDocument).document,bJ.write("<!doctype html><html><body>"),bJ.close();b=bJ.body.appendChild(bJ.createElement(a)),c=bH(b,"display"),e.body.removeChild(bI)}return bS[a]=c,c}function ci(a,b,c,d){var e;if(p.isArray(b))p.each(b,function(b,e){c||ce.test(a)?d(a,e):ci(a+"["+(typeof e=="object"?b:"")+"]",e,c,d)});else if(!c&&p.type(b)==="object")for(e in b)ci(a+"["+e+"]",b[e],c,d);else d(a,b)}function cz(a){return function(b,c){typeof b!="string"&&(c=b,b="*");var d,e,f,g=b.toLowerCase().split(s),h=0,i=g.length;if(p.isFunction(c))for(;h<i;h++)d=g[h],f=/^\+/.test(d),f&&(d=d.substr(1)||"*"),e=a[d]=a[d]||[],e[f?"unshift":"push"](c)}}function cA(a,c,d,e,f,g){f=f||c.dataTypes[0],g=g||{},g[f]=!0;var h,i=a[f],j=0,k=i?i.length:0,l=a===cv;for(;j<k&&(l||!h);j++)h=i[j](c,d,e),typeof h=="string"&&(!l||g[h]?h=b:(c.dataTypes.unshift(h),h=cA(a,c,d,e,h,g)));return(l||!h)&&!g["*"]&&(h=cA(a,c,d,e,"*",g)),h}function cB(a,c){var d,e,f=p.ajaxSettings.flatOptions||{};for(d in c)c[d]!==b&&((f[d]?a:e||(e={}))[d]=c[d]);e&&p.extend(!0,a,e)}function cC(a,c,d){var e,f,g,h,i=a.contents,j=a.dataTypes,k=a.responseFields;for(f in k)f in d&&(c[k[f]]=d[f]);while(j[0]==="*")j.shift(),e===b&&(e=a.mimeType||c.getResponseHeader("content-type"));if(e)for(f in i)if(i[f]&&i[f].test(e)){j.unshift(f);break}if(j[0]in d)g=j[0];else{for(f in d){if(!j[0]||a.converters[f+" "+j[0]]){g=f;break}h||(h=f)}g=g||h}if(g)return g!==j[0]&&j.unshift(g),d[g]}function cD(a,b){var c,d,e,f,g=a.dataTypes.slice(),h=g[0],i={},j=0;a.dataFilter&&(b=a.dataFilter(b,a.dataType));if(g[1])for(c in a.converters)i[c.toLowerCase()]=a.converters[c];for(;e=g[++j];)if(e!=="*"){if(h!=="*"&&h!==e){c=i[h+" "+e]||i["* "+e];if(!c)for(d in i){f=d.split(" ");if(f[1]===e){c=i[h+" "+f[0]]||i["* "+f[0]];if(c){c===!0?c=i[d]:i[d]!==!0&&(e=f[0],g.splice(j--,0,e));break}}}if(c!==!0)if(c&&a["throws"])b=c(b);else try{b=c(b)}catch(k){return{state:"parsererror",error:c?k:"No conversion from "+h+" to "+e}}}h=e}return{state:"success",data:b}}function cL(){try{return new a.XMLHttpRequest}catch(b){}}function cM(){try{return new a.ActiveXObject("Microsoft.XMLHTTP")}catch(b){}}function cU(){return setTimeout(function(){cN=b},0),cN=p.now()}function cV(a,b){p.each(b,function(b,c){var d=(cT[b]||[]).concat(cT["*"]),e=0,f=d.length;for(;e<f;e++)if(d[e].call(a,b,c))return})}function cW(a,b,c){var d,e=0,f=0,g=cS.length,h=p.Deferred().always(function(){delete i.elem}),i=function(){var b=cN||cU(),c=Math.max(0,j.startTime+j.duration-b),d=1-(c/j.duration||0),e=0,f=j.tweens.length;for(;e<f;e++)j.tweens[e].run(d);return h.notifyWith(a,[j,d,c]),d<1&&f?c:(h.resolveWith(a,[j]),!1)},j=h.promise({elem:a,props:p.extend({},b),opts:p.extend(!0,{specialEasing:{}},c),originalProperties:b,originalOptions:c,startTime:cN||cU(),duration:c.duration,tweens:[],createTween:function(b,c,d){var e=p.Tween(a,j.opts,b,c,j.opts.specialEasing[b]||j.opts.easing);return j.tweens.push(e),e},stop:function(b){var c=0,d=b?j.tweens.length:0;for(;c<d;c++)j.tweens[c].run(1);return b?h.resolveWith(a,[j,b]):h.rejectWith(a,[j,b]),this}}),k=j.props;cX(k,j.opts.specialEasing);for(;e<g;e++){d=cS[e].call(j,a,k,j.opts);if(d)return d}return cV(j,k),p.isFunction(j.opts.start)&&j.opts.start.call(a,j),p.fx.timer(p.extend(i,{anim:j,queue:j.opts.queue,elem:a})),j.progress(j.opts.progress).done(j.opts.done,j.opts.complete).fail(j.opts.fail).always(j.opts.always)}function cX(a,b){var c,d,e,f,g;for(c in a){d=p.camelCase(c),e=b[d],f=a[c],p.isArray(f)&&(e=f[1],f=a[c]=f[0]),c!==d&&(a[d]=f,delete a[c]),g=p.cssHooks[d];if(g&&"expand"in g){f=g.expand(f),delete a[d];for(c in f)c in a||(a[c]=f[c],b[c]=e)}else b[d]=e}}function cY(a,b,c){var d,e,f,g,h,i,j,k,l=this,m=a.style,n={},o=[],q=a.nodeType&&bZ(a);c.queue||(j=p._queueHooks(a,"fx"),j.unqueued==null&&(j.unqueued=0,k=j.empty.fire,j.empty.fire=function(){j.unqueued||k()}),j.unqueued++,l.always(function(){l.always(function(){j.unqueued--,p.queue(a,"fx").length||j.empty.fire()})})),a.nodeType===1&&("height"in b||"width"in b)&&(c.overflow=[m.overflow,m.overflowX,m.overflowY],p.css(a,"display")==="inline"&&p.css(a,"float")==="none"&&(!p.support.inlineBlockNeedsLayout||cc(a.nodeName)==="inline"?m.display="inline-block":m.zoom=1)),c.overflow&&(m.overflow="hidden",p.support.shrinkWrapBlocks||l.done(function(){m.overflow=c.overflow[0],m.overflowX=c.overflow[1],m.overflowY=c.overflow[2]}));for(d in b){f=b[d];if(cP.exec(f)){delete b[d];if(f===(q?"hide":"show"))continue;o.push(d)}}g=o.length;if(g){h=p._data(a,"fxshow")||p._data(a,"fxshow",{}),q?p(a).show():l.done(function(){p(a).hide()}),l.done(function(){var b;p.removeData(a,"fxshow",!0);for(b in n)p.style(a,b,n[b])});for(d=0;d<g;d++)e=o[d],i=l.createTween(e,q?h[e]:0),n[e]=h[e]||p.style(a,e),e in h||(h[e]=i.start,q&&(i.end=i.start,i.start=e==="width"||e==="height"?1:0))}}function cZ(a,b,c,d,e){return new cZ.prototype.init(a,b,c,d,e)}function c$(a,b){var c,d={height:a},e=0;b=b?1:0;for(;e<4;e+=2-b)c=bV[e],d["margin"+c]=d["padding"+c]=a;return b&&(d.opacity=d.width=a),d}function da(a){return p.isWindow(a)?a:a.nodeType===9?a.defaultView||a.parentWindow:!1}var c,d,e=a.document,f=a.location,g=a.navigator,h=a.jQuery,i=a.$,j=Array.prototype.push,k=Array.prototype.slice,l=Array.prototype.indexOf,m=Object.prototype.toString,n=Object.prototype.hasOwnProperty,o=String.prototype.trim,p=function(a,b){return new p.fn.init(a,b,c)},q=/[\-+]?(?:\d*\.|)\d+(?:[eE][\-+]?\d+|)/.source,r=/\S/,s=/\s+/,t=/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,u=/^(?:[^#<]*(<[\w\W]+>)[^>]*$|#([\w\-]*)$)/,v=/^<(\w+)\s*\/?>(?:<\/\1>|)$/,w=/^[\],:{}\s]*$/,x=/(?:^|:|,)(?:\s*\[)+/g,y=/\\(?:["\\\/bfnrt]|u[\da-fA-F]{4})/g,z=/"[^"\\\r\n]*"|true|false|null|-?(?:\d\d*\.|)\d+(?:[eE][\-+]?\d+|)/g,A=/^-ms-/,B=/-([\da-z])/gi,C=function(a,b){return(b+"").toUpperCase()},D=function(){e.addEventListener?(e.removeEventListener("DOMContentLoaded",D,!1),p.ready()):e.readyState==="complete"&&(e.detachEvent("onreadystatechange",D),p.ready())},E={};p.fn=p.prototype={constructor:p,init:function(a,c,d){var f,g,h,i;if(!a)return this;if(a.nodeType)return this.context=this[0]=a,this.length=1,this;if(typeof a=="string"){a.charAt(0)==="<"&&a.charAt(a.length-1)===">"&&a.length>=3?f=[null,a,null]:f=u.exec(a);if(f&&(f[1]||!c)){if(f[1])return c=c instanceof p?c[0]:c,i=c&&c.nodeType?c.ownerDocument||c:e,a=p.parseHTML(f[1],i,!0),v.test(f[1])&&p.isPlainObject(c)&&this.attr.call(a,c,!0),p.merge(this,a);g=e.getElementById(f[2]);if(g&&g.parentNode){if(g.id!==f[2])return d.find(a);this.length=1,this[0]=g}return this.context=e,this.selector=a,this}return!c||c.jquery?(c||d).find(a):this.constructor(c).find(a)}return p.isFunction(a)?d.ready(a):(a.selector!==b&&(this.selector=a.selector,this.context=a.context),p.makeArray(a,this))},selector:"",jquery:"1.8.2",length:0,size:function(){return this.length},toArray:function(){return k.call(this)},get:function(a){return a==null?this.toArray():a<0?this[this.length+a]:this[a]},pushStack:function(a,b,c){var d=p.merge(this.constructor(),a);return d.prevObject=this,d.context=this.context,b==="find"?d.selector=this.selector+(this.selector?" ":"")+c:b&&(d.selector=this.selector+"."+b+"("+c+")"),d},each:function(a,b){return p.each(this,a,b)},ready:function(a){return p.ready.promise().done(a),this},eq:function(a){return a=+a,a===-1?this.slice(a):this.slice(a,a+1)},first:function(){return this.eq(0)},last:function(){return this.eq(-1)},slice:function(){return this.pushStack(k.apply(this,arguments),"slice",k.call(arguments).join(","))},map:function(a){return this.pushStack(p.map(this,function(b,c){return a.call(b,c,b)}))},end:function(){return this.prevObject||this.constructor(null)},push:j,sort:[].sort,splice:[].splice},p.fn.init.prototype=p.fn,p.extend=p.fn.extend=function(){var a,c,d,e,f,g,h=arguments[0]||{},i=1,j=arguments.length,k=!1;typeof h=="boolean"&&(k=h,h=arguments[1]||{},i=2),typeof h!="object"&&!p.isFunction(h)&&(h={}),j===i&&(h=this,--i);for(;i<j;i++)if((a=arguments[i])!=null)for(c in a){d=h[c],e=a[c];if(h===e)continue;k&&e&&(p.isPlainObject(e)||(f=p.isArray(e)))?(f?(f=!1,g=d&&p.isArray(d)?d:[]):g=d&&p.isPlainObject(d)?d:{},h[c]=p.extend(k,g,e)):e!==b&&(h[c]=e)}return h},p.extend({noConflict:function(b){return a.$===p&&(a.$=i),b&&a.jQuery===p&&(a.jQuery=h),p},isReady:!1,readyWait:1,holdReady:function(a){a?p.readyWait++:p.ready(!0)},ready:function(a){if(a===!0?--p.readyWait:p.isReady)return;if(!e.body)return setTimeout(p.ready,1);p.isReady=!0;if(a!==!0&&--p.readyWait>0)return;d.resolveWith(e,[p]),p.fn.trigger&&p(e).trigger("ready").off("ready")},isFunction:function(a){return p.type(a)==="function"},isArray:Array.isArray||function(a){return p.type(a)==="array"},isWindow:function(a){return a!=null&&a==a.window},isNumeric:function(a){return!isNaN(parseFloat(a))&&isFinite(a)},type:function(a){return a==null?String(a):E[m.call(a)]||"object"},isPlainObject:function(a){if(!a||p.type(a)!=="object"||a.nodeType||p.isWindow(a))return!1;try{if(a.constructor&&!n.call(a,"constructor")&&!n.call(a.constructor.prototype,"isPrototypeOf"))return!1}catch(c){return!1}var d;for(d in a);return d===b||n.call(a,d)},isEmptyObject:function(a){var b;for(b in a)return!1;return!0},error:function(a){throw new Error(a)},parseHTML:function(a,b,c){var d;return!a||typeof a!="string"?null:(typeof b=="boolean"&&(c=b,b=0),b=b||e,(d=v.exec(a))?[b.createElement(d[1])]:(d=p.buildFragment([a],b,c?null:[]),p.merge([],(d.cacheable?p.clone(d.fragment):d.fragment).childNodes)))},parseJSON:function(b){if(!b||typeof b!="string")return null;b=p.trim(b);if(a.JSON&&a.JSON.parse)return a.JSON.parse(b);if(w.test(b.replace(y,"@").replace(z,"]").replace(x,"")))return(new Function("return "+b))();p.error("Invalid JSON: "+b)},parseXML:function(c){var d,e;if(!c||typeof c!="string")return null;try{a.DOMParser?(e=new DOMParser,d=e.parseFromString(c,"text/xml")):(d=new ActiveXObject("Microsoft.XMLDOM"),d.async="false",d.loadXML(c))}catch(f){d=b}return(!d||!d.documentElement||d.getElementsByTagName("parsererror").length)&&p.error("Invalid XML: "+c),d},noop:function(){},globalEval:function(b){b&&r.test(b)&&(a.execScript||function(b){a.eval.call(a,b)})(b)},camelCase:function(a){return a.replace(A,"ms-").replace(B,C)},nodeName:function(a,b){return a.nodeName&&a.nodeName.toLowerCase()===b.toLowerCase()},each:function(a,c,d){var e,f=0,g=a.length,h=g===b||p.isFunction(a);if(d){if(h){for(e in a)if(c.apply(a[e],d)===!1)break}else for(;f<g;)if(c.apply(a[f++],d)===!1)break}else if(h){for(e in a)if(c.call(a[e],e,a[e])===!1)break}else for(;f<g;)if(c.call(a[f],f,a[f++])===!1)break;return a},trim:o&&!o.call("﻿ ")?function(a){return a==null?"":o.call(a)}:function(a){return a==null?"":(a+"").replace(t,"")},makeArray:function(a,b){var c,d=b||[];return a!=null&&(c=p.type(a),a.length==null||c==="string"||c==="function"||c==="regexp"||p.isWindow(a)?j.call(d,a):p.merge(d,a)),d},inArray:function(a,b,c){var d;if(b){if(l)return l.call(b,a,c);d=b.length,c=c?c<0?Math.max(0,d+c):c:0;for(;c<d;c++)if(c in b&&b[c]===a)return c}return-1},merge:function(a,c){var d=c.length,e=a.length,f=0;if(typeof d=="number")for(;f<d;f++)a[e++]=c[f];else while(c[f]!==b)a[e++]=c[f++];return a.length=e,a},grep:function(a,b,c){var d,e=[],f=0,g=a.length;c=!!c;for(;f<g;f++)d=!!b(a[f],f),c!==d&&e.push(a[f]);return e},map:function(a,c,d){var e,f,g=[],h=0,i=a.length,j=a instanceof p||i!==b&&typeof i=="number"&&(i>0&&a[0]&&a[i-1]||i===0||p.isArray(a));if(j)for(;h<i;h++)e=c(a[h],h,d),e!=null&&(g[g.length]=e);else for(f in a)e=c(a[f],f,d),e!=null&&(g[g.length]=e);return g.concat.apply([],g)},guid:1,proxy:function(a,c){var d,e,f;return typeof c=="string"&&(d=a[c],c=a,a=d),p.isFunction(a)?(e=k.call(arguments,2),f=function(){return a.apply(c,e.concat(k.call(arguments)))},f.guid=a.guid=a.guid||p.guid++,f):b},access:function(a,c,d,e,f,g,h){var i,j=d==null,k=0,l=a.length;if(d&&typeof d=="object"){for(k in d)p.access(a,c,k,d[k],1,g,e);f=1}else if(e!==b){i=h===b&&p.isFunction(e),j&&(i?(i=c,c=function(a,b,c){return i.call(p(a),c)}):(c.call(a,e),c=null));if(c)for(;k<l;k++)c(a[k],d,i?e.call(a[k],k,c(a[k],d)):e,h);f=1}return f?a:j?c.call(a):l?c(a[0],d):g},now:function(){return(new Date).getTime()}}),p.ready.promise=function(b){if(!d){d=p.Deferred();if(e.readyState==="complete")setTimeout(p.ready,1);else if(e.addEventListener)e.addEventListener("DOMContentLoaded",D,!1),a.addEventListener("load",p.ready,!1);else{e.attachEvent("onreadystatechange",D),a.attachEvent("onload",p.ready);var c=!1;try{c=a.frameElement==null&&e.documentElement}catch(f){}c&&c.doScroll&&function g(){if(!p.isReady){try{c.doScroll("left")}catch(a){return setTimeout(g,50)}p.ready()}}()}}return d.promise(b)},p.each("Boolean Number String Function Array Date RegExp Object".split(" "),function(a,b){E["[object "+b+"]"]=b.toLowerCase()}),c=p(e);var F={};p.Callbacks=function(a){a=typeof a=="string"?F[a]||G(a):p.extend({},a);var c,d,e,f,g,h,i=[],j=!a.once&&[],k=function(b){c=a.memory&&b,d=!0,h=f||0,f=0,g=i.length,e=!0;for(;i&&h<g;h++)if(i[h].apply(b[0],b[1])===!1&&a.stopOnFalse){c=!1;break}e=!1,i&&(j?j.length&&k(j.shift()):c?i=[]:l.disable())},l={add:function(){if(i){var b=i.length;(function d(b){p.each(b,function(b,c){var e=p.type(c);e==="function"&&(!a.unique||!l.has(c))?i.push(c):c&&c.length&&e!=="string"&&d(c)})})(arguments),e?g=i.length:c&&(f=b,k(c))}return this},remove:function(){return i&&p.each(arguments,function(a,b){var c;while((c=p.inArray(b,i,c))>-1)i.splice(c,1),e&&(c<=g&&g--,c<=h&&h--)}),this},has:function(a){return p.inArray(a,i)>-1},empty:function(){return i=[],this},disable:function(){return i=j=c=b,this},disabled:function(){return!i},lock:function(){return j=b,c||l.disable(),this},locked:function(){return!j},fireWith:function(a,b){return b=b||[],b=[a,b.slice?b.slice():b],i&&(!d||j)&&(e?j.push(b):k(b)),this},fire:function(){return l.fireWith(this,arguments),this},fired:function(){return!!d}};return l},p.extend({Deferred:function(a){var b=[["resolve","done",p.Callbacks("once memory"),"resolved"],["reject","fail",p.Callbacks("once memory"),"rejected"],["notify","progress",p.Callbacks("memory")]],c="pending",d={state:function(){return c},always:function(){return e.done(arguments).fail(arguments),this},then:function(){var a=arguments;return p.Deferred(function(c){p.each(b,function(b,d){var f=d[0],g=a[b];e[d[1]](p.isFunction(g)?function(){var a=g.apply(this,arguments);a&&p.isFunction(a.promise)?a.promise().done(c.resolve).fail(c.reject).progress(c.notify):c[f+"With"](this===e?c:this,[a])}:c[f])}),a=null}).promise()},promise:function(a){return a!=null?p.extend(a,d):d}},e={};return d.pipe=d.then,p.each(b,function(a,f){var g=f[2],h=f[3];d[f[1]]=g.add,h&&g.add(function(){c=h},b[a^1][2].disable,b[2][2].lock),e[f[0]]=g.fire,e[f[0]+"With"]=g.fireWith}),d.promise(e),a&&a.call(e,e),e},when:function(a){var b=0,c=k.call(arguments),d=c.length,e=d!==1||a&&p.isFunction(a.promise)?d:0,f=e===1?a:p.Deferred(),g=function(a,b,c){return function(d){b[a]=this,c[a]=arguments.length>1?k.call(arguments):d,c===h?f.notifyWith(b,c):--e||f.resolveWith(b,c)}},h,i,j;if(d>1){h=new Array(d),i=new Array(d),j=new Array(d);for(;b<d;b++)c[b]&&p.isFunction(c[b].promise)?c[b].promise().done(g(b,j,c)).fail(f.reject).progress(g(b,i,h)):--e}return e||f.resolveWith(j,c),f.promise()}}),p.support=function(){var b,c,d,f,g,h,i,j,k,l,m,n=e.createElement("div");n.setAttribute("className","t"),n.innerHTML="  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>",c=n.getElementsByTagName("*"),d=n.getElementsByTagName("a")[0],d.style.cssText="top:1px;float:left;opacity:.5";if(!c||!c.length)return{};f=e.createElement("select"),g=f.appendChild(e.createElement("option")),h=n.getElementsByTagName("input")[0],b={leadingWhitespace:n.firstChild.nodeType===3,tbody:!n.getElementsByTagName("tbody").length,htmlSerialize:!!n.getElementsByTagName("link").length,style:/top/.test(d.getAttribute("style")),hrefNormalized:d.getAttribute("href")==="/a",opacity:/^0.5/.test(d.style.opacity),cssFloat:!!d.style.cssFloat,checkOn:h.value==="on",optSelected:g.selected,getSetAttribute:n.className!=="t",enctype:!!e.createElement("form").enctype,html5Clone:e.createElement("nav").cloneNode(!0).outerHTML!=="<:nav></:nav>",boxModel:e.compatMode==="CSS1Compat",submitBubbles:!0,changeBubbles:!0,focusinBubbles:!1,deleteExpando:!0,noCloneEvent:!0,inlineBlockNeedsLayout:!1,shrinkWrapBlocks:!1,reliableMarginRight:!0,boxSizingReliable:!0,pixelPosition:!1},h.checked=!0,b.noCloneChecked=h.cloneNode(!0).checked,f.disabled=!0,b.optDisabled=!g.disabled;try{delete n.test}catch(o){b.deleteExpando=!1}!n.addEventListener&&n.attachEvent&&n.fireEvent&&(n.attachEvent("onclick",m=function(){b.noCloneEvent=!1}),n.cloneNode(!0).fireEvent("onclick"),n.detachEvent("onclick",m)),h=e.createElement("input"),h.value="t",h.setAttribute("type","radio"),b.radioValue=h.value==="t",h.setAttribute("checked","checked"),h.setAttribute("name","t"),n.appendChild(h),i=e.createDocumentFragment(),i.appendChild(n.lastChild),b.checkClone=i.cloneNode(!0).cloneNode(!0).lastChild.checked,b.appendChecked=h.checked,i.removeChild(h),i.appendChild(n);if(n.attachEvent)for(k in{submit:!0,change:!0,focusin:!0})j="on"+k,l=j in n,l||(n.setAttribute(j,"return;"),l=typeof n[j]=="function"),b[k+"Bubbles"]=l;return p(function(){var c,d,f,g,h="padding:0;margin:0;border:0;display:block;overflow:hidden;",i=e.getElementsByTagName("body")[0];if(!i)return;c=e.createElement("div"),c.style.cssText="visibility:hidden;border:0;width:0;height:0;position:static;top:0;margin-top:1px",i.insertBefore(c,i.firstChild),d=e.createElement("div"),c.appendChild(d),d.innerHTML="<table><tr><td></td><td>t</td></tr></table>",f=d.getElementsByTagName("td"),f[0].style.cssText="padding:0;margin:0;border:0;display:none",l=f[0].offsetHeight===0,f[0].style.display="",f[1].style.display="none",b.reliableHiddenOffsets=l&&f[0].offsetHeight===0,d.innerHTML="",d.style.cssText="box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;padding:1px;border:1px;display:block;width:4px;margin-top:1%;position:absolute;top:1%;",b.boxSizing=d.offsetWidth===4,b.doesNotIncludeMarginInBodyOffset=i.offsetTop!==1,a.getComputedStyle&&(b.pixelPosition=(a.getComputedStyle(d,null)||{}).top!=="1%",b.boxSizingReliable=(a.getComputedStyle(d,null)||{width:"4px"}).width==="4px",g=e.createElement("div"),g.style.cssText=d.style.cssText=h,g.style.marginRight=g.style.width="0",d.style.width="1px",d.appendChild(g),b.reliableMarginRight=!parseFloat((a.getComputedStyle(g,null)||{}).marginRight)),typeof d.style.zoom!="undefined"&&(d.innerHTML="",d.style.cssText=h+"width:1px;padding:1px;display:inline;zoom:1",b.inlineBlockNeedsLayout=d.offsetWidth===3,d.style.display="block",d.style.overflow="visible",d.innerHTML="<div></div>",d.firstChild.style.width="5px",b.shrinkWrapBlocks=d.offsetWidth!==3,c.style.zoom=1),i.removeChild(c),c=d=f=g=null}),i.removeChild(n),c=d=f=g=h=i=n=null,b}();var H=/(?:\{[\s\S]*\}|\[[\s\S]*\])$/,I=/([A-Z])/g;p.extend({cache:{},deletedIds:[],uuid:0,expando:"jQuery"+(p.fn.jquery+Math.random()).replace(/\D/g,""),noData:{embed:!0,object:"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000",applet:!0},hasData:function(a){return a=a.nodeType?p.cache[a[p.expando]]:a[p.expando],!!a&&!K(a)},data:function(a,c,d,e){if(!p.acceptData(a))return;var f,g,h=p.expando,i=typeof c=="string",j=a.nodeType,k=j?p.cache:a,l=j?a[h]:a[h]&&h;if((!l||!k[l]||!e&&!k[l].data)&&i&&d===b)return;l||(j?a[h]=l=p.deletedIds.pop()||p.guid++:l=h),k[l]||(k[l]={},j||(k[l].toJSON=p.noop));if(typeof c=="object"||typeof c=="function")e?k[l]=p.extend(k[l],c):k[l].data=p.extend(k[l].data,c);return f=k[l],e||(f.data||(f.data={}),f=f.data),d!==b&&(f[p.camelCase(c)]=d),i?(g=f[c],g==null&&(g=f[p.camelCase(c)])):g=f,g},removeData:function(a,b,c){if(!p.acceptData(a))return;var d,e,f,g=a.nodeType,h=g?p.cache:a,i=g?a[p.expando]:p.expando;if(!h[i])return;if(b){d=c?h[i]:h[i].data;if(d){p.isArray(b)||(b in d?b=[b]:(b=p.camelCase(b),b in d?b=[b]:b=b.split(" ")));for(e=0,f=b.length;e<f;e++)delete d[b[e]];if(!(c?K:p.isEmptyObject)(d))return}}if(!c){delete h[i].data;if(!K(h[i]))return}g?p.cleanData([a],!0):p.support.deleteExpando||h!=h.window?delete h[i]:h[i]=null},_data:function(a,b,c){return p.data(a,b,c,!0)},acceptData:function(a){var b=a.nodeName&&p.noData[a.nodeName.toLowerCase()];return!b||b!==!0&&a.getAttribute("classid")===b}}),p.fn.extend({data:function(a,c){var d,e,f,g,h,i=this[0],j=0,k=null;if(a===b){if(this.length){k=p.data(i);if(i.nodeType===1&&!p._data(i,"parsedAttrs")){f=i.attributes;for(h=f.length;j<h;j++)g=f[j].name,g.indexOf("data-")||(g=p.camelCase(g.substring(5)),J(i,g,k[g]));p._data(i,"parsedAttrs",!0)}}return k}return typeof a=="object"?this.each(function(){p.data(this,a)}):(d=a.split(".",2),d[1]=d[1]?"."+d[1]:"",e=d[1]+"!",p.access(this,function(c){if(c===b)return k=this.triggerHandler("getData"+e,[d[0]]),k===b&&i&&(k=p.data(i,a),k=J(i,a,k)),k===b&&d[1]?this.data(d[0]):k;d[1]=c,this.each(function(){var b=p(this);b.triggerHandler("setData"+e,d),p.data(this,a,c),b.triggerHandler("changeData"+e,d)})},null,c,arguments.length>1,null,!1))},removeData:function(a){return this.each(function(){p.removeData(this,a)})}}),p.extend({queue:function(a,b,c){var d;if(a)return b=(b||"fx")+"queue",d=p._data(a,b),c&&(!d||p.isArray(c)?d=p._data(a,b,p.makeArray(c)):d.push(c)),d||[]},dequeue:function(a,b){b=b||"fx";var c=p.queue(a,b),d=c.length,e=c.shift(),f=p._queueHooks(a,b),g=function(){p.dequeue(a,b)};e==="inprogress"&&(e=c.shift(),d--),e&&(b==="fx"&&c.unshift("inprogress"),delete f.stop,e.call(a,g,f)),!d&&f&&f.empty.fire()},_queueHooks:function(a,b){var c=b+"queueHooks";return p._data(a,c)||p._data(a,c,{empty:p.Callbacks("once memory").add(function(){p.removeData(a,b+"queue",!0),p.removeData(a,c,!0)})})}}),p.fn.extend({queue:function(a,c){var d=2;return typeof a!="string"&&(c=a,a="fx",d--),arguments.length<d?p.queue(this[0],a):c===b?this:this.each(function(){var b=p.queue(this,a,c);p._queueHooks(this,a),a==="fx"&&b[0]!=="inprogress"&&p.dequeue(this,a)})},dequeue:function(a){return this.each(function(){p.dequeue(this,a)})},delay:function(a,b){return a=p.fx?p.fx.speeds[a]||a:a,b=b||"fx",this.queue(b,function(b,c){var d=setTimeout(b,a);c.stop=function(){clearTimeout(d)}})},clearQueue:function(a){return this.queue(a||"fx",[])},promise:function(a,c){var d,e=1,f=p.Deferred(),g=this,h=this.length,i=function(){--e||f.resolveWith(g,[g])};typeof a!="string"&&(c=a,a=b),a=a||"fx";while(h--)d=p._data(g[h],a+"queueHooks"),d&&d.empty&&(e++,d.empty.add(i));return i(),f.promise(c)}});var L,M,N,O=/[\t\r\n]/g,P=/\r/g,Q=/^(?:button|input)$/i,R=/^(?:button|input|object|select|textarea)$/i,S=/^a(?:rea|)$/i,T=/^(?:autofocus|autoplay|async|checked|controls|defer|disabled|hidden|loop|multiple|open|readonly|required|scoped|selected)$/i,U=p.support.getSetAttribute;p.fn.extend({attr:function(a,b){return p.access(this,p.attr,a,b,arguments.length>1)},removeAttr:function(a){return this.each(function(){p.removeAttr(this,a)})},prop:function(a,b){return p.access(this,p.prop,a,b,arguments.length>1)},removeProp:function(a){return a=p.propFix[a]||a,this.each(function(){try{this[a]=b,delete this[a]}catch(c){}})},addClass:function(a){var b,c,d,e,f,g,h;if(p.isFunction(a))return this.each(function(b){p(this).addClass(a.call(this,b,this.className))});if(a&&typeof a=="string"){b=a.split(s);for(c=0,d=this.length;c<d;c++){e=this[c];if(e.nodeType===1)if(!e.className&&b.length===1)e.className=a;else{f=" "+e.className+" ";for(g=0,h=b.length;g<h;g++)f.indexOf(" "+b[g]+" ")<0&&(f+=b[g]+" ");e.className=p.trim(f)}}}return this},removeClass:function(a){var c,d,e,f,g,h,i;if(p.isFunction(a))return this.each(function(b){p(this).removeClass(a.call(this,b,this.className))});if(a&&typeof a=="string"||a===b){c=(a||"").split(s);for(h=0,i=this.length;h<i;h++){e=this[h];if(e.nodeType===1&&e.className){d=(" "+e.className+" ").replace(O," ");for(f=0,g=c.length;f<g;f++)while(d.indexOf(" "+c[f]+" ")>=0)d=d.replace(" "+c[f]+" "," ");e.className=a?p.trim(d):""}}}return this},toggleClass:function(a,b){var c=typeof a,d=typeof b=="boolean";return p.isFunction(a)?this.each(function(c){p(this).toggleClass(a.call(this,c,this.className,b),b)}):this.each(function(){if(c==="string"){var e,f=0,g=p(this),h=b,i=a.split(s);while(e=i[f++])h=d?h:!g.hasClass(e),g[h?"addClass":"removeClass"](e)}else if(c==="undefined"||c==="boolean")this.className&&p._data(this,"__className__",this.className),this.className=this.className||a===!1?"":p._data(this,"__className__")||""})},hasClass:function(a){var b=" "+a+" ",c=0,d=this.length;for(;c<d;c++)if(this[c].nodeType===1&&(" "+this[c].className+" ").replace(O," ").indexOf(b)>=0)return!0;return!1},val:function(a){var c,d,e,f=this[0];if(!arguments.length){if(f)return c=p.valHooks[f.type]||p.valHooks[f.nodeName.toLowerCase()],c&&"get"in c&&(d=c.get(f,"value"))!==b?d:(d=f.value,typeof d=="string"?d.replace(P,""):d==null?"":d);return}return e=p.isFunction(a),this.each(function(d){var f,g=p(this);if(this.nodeType!==1)return;e?f=a.call(this,d,g.val()):f=a,f==null?f="":typeof f=="number"?f+="":p.isArray(f)&&(f=p.map(f,function(a){return a==null?"":a+""})),c=p.valHooks[this.type]||p.valHooks[this.nodeName.toLowerCase()];if(!c||!("set"in c)||c.set(this,f,"value")===b)this.value=f})}}),p.extend({valHooks:{option:{get:function(a){var b=a.attributes.value;return!b||b.specified?a.value:a.text}},select:{get:function(a){var b,c,d,e,f=a.selectedIndex,g=[],h=a.options,i=a.type==="select-one";if(f<0)return null;c=i?f:0,d=i?f+1:h.length;for(;c<d;c++){e=h[c];if(e.selected&&(p.support.optDisabled?!e.disabled:e.getAttribute("disabled")===null)&&(!e.parentNode.disabled||!p.nodeName(e.parentNode,"optgroup"))){b=p(e).val();if(i)return b;g.push(b)}}return i&&!g.length&&h.length?p(h[f]).val():g},set:function(a,b){var c=p.makeArray(b);return p(a).find("option").each(function(){this.selected=p.inArray(p(this).val(),c)>=0}),c.length||(a.selectedIndex=-1),c}}},attrFn:{},attr:function(a,c,d,e){var f,g,h,i=a.nodeType;if(!a||i===3||i===8||i===2)return;if(e&&p.isFunction(p.fn[c]))return p(a)[c](d);if(typeof a.getAttribute=="undefined")return p.prop(a,c,d);h=i!==1||!p.isXMLDoc(a),h&&(c=c.toLowerCase(),g=p.attrHooks[c]||(T.test(c)?M:L));if(d!==b){if(d===null){p.removeAttr(a,c);return}return g&&"set"in g&&h&&(f=g.set(a,d,c))!==b?f:(a.setAttribute(c,d+""),d)}return g&&"get"in g&&h&&(f=g.get(a,c))!==null?f:(f=a.getAttribute(c),f===null?b:f)},removeAttr:function(a,b){var c,d,e,f,g=0;if(b&&a.nodeType===1){d=b.split(s);for(;g<d.length;g++)e=d[g],e&&(c=p.propFix[e]||e,f=T.test(e),f||p.attr(a,e,""),a.removeAttribute(U?e:c),f&&c in a&&(a[c]=!1))}},attrHooks:{type:{set:function(a,b){if(Q.test(a.nodeName)&&a.parentNode)p.error("type property can't be changed");else if(!p.support.radioValue&&b==="radio"&&p.nodeName(a,"input")){var c=a.value;return a.setAttribute("type",b),c&&(a.value=c),b}}},value:{get:function(a,b){return L&&p.nodeName(a,"button")?L.get(a,b):b in a?a.value:null},set:function(a,b,c){if(L&&p.nodeName(a,"button"))return L.set(a,b,c);a.value=b}}},propFix:{tabindex:"tabIndex",readonly:"readOnly","for":"htmlFor","class":"className",maxlength:"maxLength",cellspacing:"cellSpacing",cellpadding:"cellPadding",rowspan:"rowSpan",colspan:"colSpan",usemap:"useMap",frameborder:"frameBorder",contenteditable:"contentEditable"},prop:function(a,c,d){var e,f,g,h=a.nodeType;if(!a||h===3||h===8||h===2)return;return g=h!==1||!p.isXMLDoc(a),g&&(c=p.propFix[c]||c,f=p.propHooks[c]),d!==b?f&&"set"in f&&(e=f.set(a,d,c))!==b?e:a[c]=d:f&&"get"in f&&(e=f.get(a,c))!==null?e:a[c]},propHooks:{tabIndex:{get:function(a){var c=a.getAttributeNode("tabindex");return c&&c.specified?parseInt(c.value,10):R.test(a.nodeName)||S.test(a.nodeName)&&a.href?0:b}}}}),M={get:function(a,c){var d,e=p.prop(a,c);return e===!0||typeof e!="boolean"&&(d=a.getAttributeNode(c))&&d.nodeValue!==!1?c.toLowerCase():b},set:function(a,b,c){var d;return b===!1?p.removeAttr(a,c):(d=p.propFix[c]||c,d in a&&(a[d]=!0),a.setAttribute(c,c.toLowerCase())),c}},U||(N={name:!0,id:!0,coords:!0},L=p.valHooks.button={get:function(a,c){var d;return d=a.getAttributeNode(c),d&&(N[c]?d.value!=="":d.specified)?d.value:b},set:function(a,b,c){var d=a.getAttributeNode(c);return d||(d=e.createAttribute(c),a.setAttributeNode(d)),d.value=b+""}},p.each(["width","height"],function(a,b){p.attrHooks[b]=p.extend(p.attrHooks[b],{set:function(a,c){if(c==="")return a.setAttribute(b,"auto"),c}})}),p.attrHooks.contenteditable={get:L.get,set:function(a,b,c){b===""&&(b="false"),L.set(a,b,c)}}),p.support.hrefNormalized||p.each(["href","src","width","height"],function(a,c){p.attrHooks[c]=p.extend(p.attrHooks[c],{get:function(a){var d=a.getAttribute(c,2);return d===null?b:d}})}),p.support.style||(p.attrHooks.style={get:function(a){return a.style.cssText.toLowerCase()||b},set:function(a,b){return a.style.cssText=b+""}}),p.support.optSelected||(p.propHooks.selected=p.extend(p.propHooks.selected,{get:function(a){var b=a.parentNode;return b&&(b.selectedIndex,b.parentNode&&b.parentNode.selectedIndex),null}})),p.support.enctype||(p.propFix.enctype="encoding"),p.support.checkOn||p.each(["radio","checkbox"],function(){p.valHooks[this]={get:function(a){return a.getAttribute("value")===null?"on":a.value}}}),p.each(["radio","checkbox"],function(){p.valHooks[this]=p.extend(p.valHooks[this],{set:function(a,b){if(p.isArray(b))return a.checked=p.inArray(p(a).val(),b)>=0}})});var V=/^(?:textarea|input|select)$/i,W=/^([^\.]*|)(?:\.(.+)|)$/,X=/(?:^|\s)hover(\.\S+|)\b/,Y=/^key/,Z=/^(?:mouse|contextmenu)|click/,$=/^(?:focusinfocus|focusoutblur)$/,_=function(a){return p.event.special.hover?a:a.replace(X,"mouseenter$1 mouseleave$1")};p.event={add:function(a,c,d,e,f){var g,h,i,j,k,l,m,n,o,q,r;if(a.nodeType===3||a.nodeType===8||!c||!d||!(g=p._data(a)))return;d.handler&&(o=d,d=o.handler,f=o.selector),d.guid||(d.guid=p.guid++),i=g.events,i||(g.events=i={}),h=g.handle,h||(g.handle=h=function(a){return typeof p!="undefined"&&(!a||p.event.triggered!==a.type)?p.event.dispatch.apply(h.elem,arguments):b},h.elem=a),c=p.trim(_(c)).split(" ");for(j=0;j<c.length;j++){k=W.exec(c[j])||[],l=k[1],m=(k[2]||"").split(".").sort(),r=p.event.special[l]||{},l=(f?r.delegateType:r.bindType)||l,r=p.event.special[l]||{},n=p.extend({type:l,origType:k[1],data:e,handler:d,guid:d.guid,selector:f,needsContext:f&&p.expr.match.needsContext.test(f),namespace:m.join(".")},o),q=i[l];if(!q){q=i[l]=[],q.delegateCount=0;if(!r.setup||r.setup.call(a,e,m,h)===!1)a.addEventListener?a.addEventListener(l,h,!1):a.attachEvent&&a.attachEvent("on"+l,h)}r.add&&(r.add.call(a,n),n.handler.guid||(n.handler.guid=d.guid)),f?q.splice(q.delegateCount++,0,n):q.push(n),p.event.global[l]=!0}a=null},global:{},remove:function(a,b,c,d,e){var f,g,h,i,j,k,l,m,n,o,q,r=p.hasData(a)&&p._data(a);if(!r||!(m=r.events))return;b=p.trim(_(b||"")).split(" ");for(f=0;f<b.length;f++){g=W.exec(b[f])||[],h=i=g[1],j=g[2];if(!h){for(h in m)p.event.remove(a,h+b[f],c,d,!0);continue}n=p.event.special[h]||{},h=(d?n.delegateType:n.bindType)||h,o=m[h]||[],k=o.length,j=j?new RegExp("(^|\\.)"+j.split(".").sort().join("\\.(?:.*\\.|)")+"(\\.|$)"):null;for(l=0;l<o.length;l++)q=o[l],(e||i===q.origType)&&(!c||c.guid===q.guid)&&(!j||j.test(q.namespace))&&(!d||d===q.selector||d==="**"&&q.selector)&&(o.splice(l--,1),q.selector&&o.delegateCount--,n.remove&&n.remove.call(a,q));o.length===0&&k!==o.length&&((!n.teardown||n.teardown.call(a,j,r.handle)===!1)&&p.removeEvent(a,h,r.handle),delete m[h])}p.isEmptyObject(m)&&(delete r.handle,p.removeData(a,"events",!0))},customEvent:{getData:!0,setData:!0,changeData:!0},trigger:function(c,d,f,g){if(!f||f.nodeType!==3&&f.nodeType!==8){var h,i,j,k,l,m,n,o,q,r,s=c.type||c,t=[];if($.test(s+p.event.triggered))return;s.indexOf("!")>=0&&(s=s.slice(0,-1),i=!0),s.indexOf(".")>=0&&(t=s.split("."),s=t.shift(),t.sort());if((!f||p.event.customEvent[s])&&!p.event.global[s])return;c=typeof c=="object"?c[p.expando]?c:new p.Event(s,c):new p.Event(s),c.type=s,c.isTrigger=!0,c.exclusive=i,c.namespace=t.join("."),c.namespace_re=c.namespace?new RegExp("(^|\\.)"+t.join("\\.(?:.*\\.|)")+"(\\.|$)"):null,m=s.indexOf(":")<0?"on"+s:"";if(!f){h=p.cache;for(j in h)h[j].events&&h[j].events[s]&&p.event.trigger(c,d,h[j].handle.elem,!0);return}c.result=b,c.target||(c.target=f),d=d!=null?p.makeArray(d):[],d.unshift(c),n=p.event.special[s]||{};if(n.trigger&&n.trigger.apply(f,d)===!1)return;q=[[f,n.bindType||s]];if(!g&&!n.noBubble&&!p.isWindow(f)){r=n.delegateType||s,k=$.test(r+s)?f:f.parentNode;for(l=f;k;k=k.parentNode)q.push([k,r]),l=k;l===(f.ownerDocument||e)&&q.push([l.defaultView||l.parentWindow||a,r])}for(j=0;j<q.length&&!c.isPropagationStopped();j++)k=q[j][0],c.type=q[j][1],o=(p._data(k,"events")||{})[c.type]&&p._data(k,"handle"),o&&o.apply(k,d),o=m&&k[m],o&&p.acceptData(k)&&o.apply&&o.apply(k,d)===!1&&c.preventDefault();return c.type=s,!g&&!c.isDefaultPrevented()&&(!n._default||n._default.apply(f.ownerDocument,d)===!1)&&(s!=="click"||!p.nodeName(f,"a"))&&p.acceptData(f)&&m&&f[s]&&(s!=="focus"&&s!=="blur"||c.target.offsetWidth!==0)&&!p.isWindow(f)&&(l=f[m],l&&(f[m]=null),p.event.triggered=s,f[s](),p.event.triggered=b,l&&(f[m]=l)),c.result}return},dispatch:function(c){c=p.event.fix(c||a.event);var d,e,f,g,h,i,j,l,m,n,o=(p._data(this,"events")||{})[c.type]||[],q=o.delegateCount,r=k.call(arguments),s=!c.exclusive&&!c.namespace,t=p.event.special[c.type]||{},u=[];r[0]=c,c.delegateTarget=this;if(t.preDispatch&&t.preDispatch.call(this,c)===!1)return;if(q&&(!c.button||c.type!=="click"))for(f=c.target;f!=this;f=f.parentNode||this)if(f.disabled!==!0||c.type!=="click"){h={},j=[];for(d=0;d<q;d++)l=o[d],m=l.selector,h[m]===b&&(h[m]=l.needsContext?p(m,this).index(f)>=0:p.find(m,this,null,[f]).length),h[m]&&j.push(l);j.length&&u.push({elem:f,matches:j})}o.length>q&&u.push({elem:this,matches:o.slice(q)});for(d=0;d<u.length&&!c.isPropagationStopped();d++){i=u[d],c.currentTarget=i.elem;for(e=0;e<i.matches.length&&!c.isImmediatePropagationStopped();e++){l=i.matches[e];if(s||!c.namespace&&!l.namespace||c.namespace_re&&c.namespace_re.test(l.namespace))c.data=l.data,c.handleObj=l,g=((p.event.special[l.origType]||{}).handle||l.handler).apply(i.elem,r),g!==b&&(c.result=g,g===!1&&(c.preventDefault(),c.stopPropagation()))}}return t.postDispatch&&t.postDispatch.call(this,c),c.result},props:"attrChange attrName relatedNode srcElement altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),fixHooks:{},keyHooks:{props:"char charCode key keyCode".split(" "),filter:function(a,b){return a.which==null&&(a.which=b.charCode!=null?b.charCode:b.keyCode),a}},mouseHooks:{props:"button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),filter:function(a,c){var d,f,g,h=c.button,i=c.fromElement;return a.pageX==null&&c.clientX!=null&&(d=a.target.ownerDocument||e,f=d.documentElement,g=d.body,a.pageX=c.clientX+(f&&f.scrollLeft||g&&g.scrollLeft||0)-(f&&f.clientLeft||g&&g.clientLeft||0),a.pageY=c.clientY+(f&&f.scrollTop||g&&g.scrollTop||0)-(f&&f.clientTop||g&&g.clientTop||0)),!a.relatedTarget&&i&&(a.relatedTarget=i===a.target?c.toElement:i),!a.which&&h!==b&&(a.which=h&1?1:h&2?3:h&4?2:0),a}},fix:function(a){if(a[p.expando])return a;var b,c,d=a,f=p.event.fixHooks[a.type]||{},g=f.props?this.props.concat(f.props):this.props;a=p.Event(d);for(b=g.length;b;)c=g[--b],a[c]=d[c];return a.target||(a.target=d.srcElement||e),a.target.nodeType===3&&(a.target=a.target.parentNode),a.metaKey=!!a.metaKey,f.filter?f.filter(a,d):a},special:{load:{noBubble:!0},focus:{delegateType:"focusin"},blur:{delegateType:"focusout"},beforeunload:{setup:function(a,b,c){p.isWindow(this)&&(this.onbeforeunload=c)},teardown:function(a,b){this.onbeforeunload===b&&(this.onbeforeunload=null)}}},simulate:function(a,b,c,d){var e=p.extend(new p.Event,c,{type:a,isSimulated:!0,originalEvent:{}});d?p.event.trigger(e,null,b):p.event.dispatch.call(b,e),e.isDefaultPrevented()&&c.preventDefault()}},p.event.handle=p.event.dispatch,p.removeEvent=e.removeEventListener?function(a,b,c){a.removeEventListener&&a.removeEventListener(b,c,!1)}:function(a,b,c){var d="on"+b;a.detachEvent&&(typeof a[d]=="undefined"&&(a[d]=null),a.detachEvent(d,c))},p.Event=function(a,b){if(this instanceof p.Event)a&&a.type?(this.originalEvent=a,this.type=a.type,this.isDefaultPrevented=a.defaultPrevented||a.returnValue===!1||a.getPreventDefault&&a.getPreventDefault()?bb:ba):this.type=a,b&&p.extend(this,b),this.timeStamp=a&&a.timeStamp||p.now(),this[p.expando]=!0;else return new p.Event(a,b)},p.Event.prototype={preventDefault:function(){this.isDefaultPrevented=bb;var a=this.originalEvent;if(!a)return;a.preventDefault?a.preventDefault():a.returnValue=!1},stopPropagation:function(){this.isPropagationStopped=bb;var a=this.originalEvent;if(!a)return;a.stopPropagation&&a.stopPropagation(),a.cancelBubble=!0},stopImmediatePropagation:function(){this.isImmediatePropagationStopped=bb,this.stopPropagation()},isDefaultPrevented:ba,isPropagationStopped:ba,isImmediatePropagationStopped:ba},p.each({mouseenter:"mouseover",mouseleave:"mouseout"},function(a,b){p.event.special[a]={delegateType:b,bindType:b,handle:function(a){var c,d=this,e=a.relatedTarget,f=a.handleObj,g=f.selector;if(!e||e!==d&&!p.contains(d,e))a.type=f.origType,c=f.handler.apply(this,arguments),a.type=b;return c}}}),p.support.submitBubbles||(p.event.special.submit={setup:function(){if(p.nodeName(this,"form"))return!1;p.event.add(this,"click._submit keypress._submit",function(a){var c=a.target,d=p.nodeName(c,"input")||p.nodeName(c,"button")?c.form:b;d&&!p._data(d,"_submit_attached")&&(p.event.add(d,"submit._submit",function(a){a._submit_bubble=!0}),p._data(d,"_submit_attached",!0))})},postDispatch:function(a){a._submit_bubble&&(delete a._submit_bubble,this.parentNode&&!a.isTrigger&&p.event.simulate("submit",this.parentNode,a,!0))},teardown:function(){if(p.nodeName(this,"form"))return!1;p.event.remove(this,"._submit")}}),p.support.changeBubbles||(p.event.special.change={setup:function(){if(V.test(this.nodeName)){if(this.type==="checkbox"||this.type==="radio")p.event.add(this,"propertychange._change",function(a){a.originalEvent.propertyName==="checked"&&(this._just_changed=!0)}),p.event.add(this,"click._change",function(a){this._just_changed&&!a.isTrigger&&(this._just_changed=!1),p.event.simulate("change",this,a,!0)});return!1}p.event.add(this,"beforeactivate._change",function(a){var b=a.target;V.test(b.nodeName)&&!p._data(b,"_change_attached")&&(p.event.add(b,"change._change",function(a){this.parentNode&&!a.isSimulated&&!a.isTrigger&&p.event.simulate("change",this.parentNode,a,!0)}),p._data(b,"_change_attached",!0))})},handle:function(a){var b=a.target;if(this!==b||a.isSimulated||a.isTrigger||b.type!=="radio"&&b.type!=="checkbox")return a.handleObj.handler.apply(this,arguments)},teardown:function(){return p.event.remove(this,"._change"),!V.test(this.nodeName)}}),p.support.focusinBubbles||p.each({focus:"focusin",blur:"focusout"},function(a,b){var c=0,d=function(a){p.event.simulate(b,a.target,p.event.fix(a),!0)};p.event.special[b]={setup:function(){c++===0&&e.addEventListener(a,d,!0)},teardown:function(){--c===0&&e.removeEventListener(a,d,!0)}}}),p.fn.extend({on:function(a,c,d,e,f){var g,h;if(typeof a=="object"){typeof c!="string"&&(d=d||c,c=b);for(h in a)this.on(h,c,d,a[h],f);return this}d==null&&e==null?(e=c,d=c=b):e==null&&(typeof c=="string"?(e=d,d=b):(e=d,d=c,c=b));if(e===!1)e=ba;else if(!e)return this;return f===1&&(g=e,e=function(a){return p().off(a),g.apply(this,arguments)},e.guid=g.guid||(g.guid=p.guid++)),this.each(function(){p.event.add(this,a,e,d,c)})},one:function(a,b,c,d){return this.on(a,b,c,d,1)},off:function(a,c,d){var e,f;if(a&&a.preventDefault&&a.handleObj)return e=a.handleObj,p(a.delegateTarget).off(e.namespace?e.origType+"."+e.namespace:e.origType,e.selector,e.handler),this;if(typeof a=="object"){for(f in a)this.off(f,c,a[f]);return this}if(c===!1||typeof c=="function")d=c,c=b;return d===!1&&(d=ba),this.each(function(){p.event.remove(this,a,d,c)})},bind:function(a,b,c){return this.on(a,null,b,c)},unbind:function(a,b){return this.off(a,null,b)},live:function(a,b,c){return p(this.context).on(a,this.selector,b,c),this},die:function(a,b){return p(this.context).off(a,this.selector||"**",b),this},delegate:function(a,b,c,d){return this.on(b,a,c,d)},undelegate:function(a,b,c){return arguments.length===1?this.off(a,"**"):this.off(b,a||"**",c)},trigger:function(a,b){return this.each(function(){p.event.trigger(a,b,this)})},triggerHandler:function(a,b){if(this[0])return p.event.trigger(a,b,this[0],!0)},toggle:function(a){var b=arguments,c=a.guid||p.guid++,d=0,e=function(c){var e=(p._data(this,"lastToggle"+a.guid)||0)%d;return p._data(this,"lastToggle"+a.guid,e+1),c.preventDefault(),b[e].apply(this,arguments)||!1};e.guid=c;while(d<b.length)b[d++].guid=c;return this.click(e)},hover:function(a,b){return this.mouseenter(a).mouseleave(b||a)}}),p.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "),function(a,b){p.fn[b]=function(a,c){return c==null&&(c=a,a=null),arguments.length>0?this.on(b,null,a,c):this.trigger(b)},Y.test(b)&&(p.event.fixHooks[b]=p.event.keyHooks),Z.test(b)&&(p.event.fixHooks[b]=p.event.mouseHooks)}),function(a,b){function bc(a,b,c,d){c=c||[],b=b||r;var e,f,i,j,k=b.nodeType;if(!a||typeof a!="string")return c;if(k!==1&&k!==9)return[];i=g(b);if(!i&&!d)if(e=P.exec(a))if(j=e[1]){if(k===9){f=b.getElementById(j);if(!f||!f.parentNode)return c;if(f.id===j)return c.push(f),c}else if(b.ownerDocument&&(f=b.ownerDocument.getElementById(j))&&h(b,f)&&f.id===j)return c.push(f),c}else{if(e[2])return w.apply(c,x.call(b.getElementsByTagName(a),0)),c;if((j=e[3])&&_&&b.getElementsByClassName)return w.apply(c,x.call(b.getElementsByClassName(j),0)),c}return bp(a.replace(L,"$1"),b,c,d,i)}function bd(a){return function(b){var c=b.nodeName.toLowerCase();return c==="input"&&b.type===a}}function be(a){return function(b){var c=b.nodeName.toLowerCase();return(c==="input"||c==="button")&&b.type===a}}function bf(a){return z(function(b){return b=+b,z(function(c,d){var e,f=a([],c.length,b),g=f.length;while(g--)c[e=f[g]]&&(c[e]=!(d[e]=c[e]))})})}function bg(a,b,c){if(a===b)return c;var d=a.nextSibling;while(d){if(d===b)return-1;d=d.nextSibling}return 1}function bh(a,b){var c,d,f,g,h,i,j,k=C[o][a];if(k)return b?0:k.slice(0);h=a,i=[],j=e.preFilter;while(h){if(!c||(d=M.exec(h)))d&&(h=h.slice(d[0].length)),i.push(f=[]);c=!1;if(d=N.exec(h))f.push(c=new q(d.shift())),h=h.slice(c.length),c.type=d[0].replace(L," ");for(g in e.filter)(d=W[g].exec(h))&&(!j[g]||(d=j[g](d,r,!0)))&&(f.push(c=new q(d.shift())),h=h.slice(c.length),c.type=g,c.matches=d);if(!c)break}return b?h.length:h?bc.error(a):C(a,i).slice(0)}function bi(a,b,d){var e=b.dir,f=d&&b.dir==="parentNode",g=u++;return b.first?function(b,c,d){while(b=b[e])if(f||b.nodeType===1)return a(b,c,d)}:function(b,d,h){if(!h){var i,j=t+" "+g+" ",k=j+c;while(b=b[e])if(f||b.nodeType===1){if((i=b[o])===k)return b.sizset;if(typeof i=="string"&&i.indexOf(j)===0){if(b.sizset)return b}else{b[o]=k;if(a(b,d,h))return b.sizset=!0,b;b.sizset=!1}}}else while(b=b[e])if(f||b.nodeType===1)if(a(b,d,h))return b}}function bj(a){return a.length>1?function(b,c,d){var e=a.length;while(e--)if(!a[e](b,c,d))return!1;return!0}:a[0]}function bk(a,b,c,d,e){var f,g=[],h=0,i=a.length,j=b!=null;for(;h<i;h++)if(f=a[h])if(!c||c(f,d,e))g.push(f),j&&b.push(h);return g}function bl(a,b,c,d,e,f){return d&&!d[o]&&(d=bl(d)),e&&!e[o]&&(e=bl(e,f)),z(function(f,g,h,i){if(f&&e)return;var j,k,l,m=[],n=[],o=g.length,p=f||bo(b||"*",h.nodeType?[h]:h,[],f),q=a&&(f||!b)?bk(p,m,a,h,i):p,r=c?e||(f?a:o||d)?[]:g:q;c&&c(q,r,h,i);if(d){l=bk(r,n),d(l,[],h,i),j=l.length;while(j--)if(k=l[j])r[n[j]]=!(q[n[j]]=k)}if(f){j=a&&r.length;while(j--)if(k=r[j])f[m[j]]=!(g[m[j]]=k)}else r=bk(r===g?r.splice(o,r.length):r),e?e(null,g,r,i):w.apply(g,r)})}function bm(a){var b,c,d,f=a.length,g=e.relative[a[0].type],h=g||e.relative[" "],i=g?1:0,j=bi(function(a){return a===b},h,!0),k=bi(function(a){return y.call(b,a)>-1},h,!0),m=[function(a,c,d){return!g&&(d||c!==l)||((b=c).nodeType?j(a,c,d):k(a,c,d))}];for(;i<f;i++)if(c=e.relative[a[i].type])m=[bi(bj(m),c)];else{c=e.filter[a[i].type].apply(null,a[i].matches);if(c[o]){d=++i;for(;d<f;d++)if(e.relative[a[d].type])break;return bl(i>1&&bj(m),i>1&&a.slice(0,i-1).join("").replace(L,"$1"),c,i<d&&bm(a.slice(i,d)),d<f&&bm(a=a.slice(d)),d<f&&a.join(""))}m.push(c)}return bj(m)}function bn(a,b){var d=b.length>0,f=a.length>0,g=function(h,i,j,k,m){var n,o,p,q=[],s=0,u="0",x=h&&[],y=m!=null,z=l,A=h||f&&e.find.TAG("*",m&&i.parentNode||i),B=t+=z==null?1:Math.E;y&&(l=i!==r&&i,c=g.el);for(;(n=A[u])!=null;u++){if(f&&n){for(o=0;p=a[o];o++)if(p(n,i,j)){k.push(n);break}y&&(t=B,c=++g.el)}d&&((n=!p&&n)&&s--,h&&x.push(n))}s+=u;if(d&&u!==s){for(o=0;p=b[o];o++)p(x,q,i,j);if(h){if(s>0)while(u--)!x[u]&&!q[u]&&(q[u]=v.call(k));q=bk(q)}w.apply(k,q),y&&!h&&q.length>0&&s+b.length>1&&bc.uniqueSort(k)}return y&&(t=B,l=z),x};return g.el=0,d?z(g):g}function bo(a,b,c,d){var e=0,f=b.length;for(;e<f;e++)bc(a,b[e],c,d);return c}function bp(a,b,c,d,f){var g,h,j,k,l,m=bh(a),n=m.length;if(!d&&m.length===1){h=m[0]=m[0].slice(0);if(h.length>2&&(j=h[0]).type==="ID"&&b.nodeType===9&&!f&&e.relative[h[1].type]){b=e.find.ID(j.matches[0].replace(V,""),b,f)[0];if(!b)return c;a=a.slice(h.shift().length)}for(g=W.POS.test(a)?-1:h.length-1;g>=0;g--){j=h[g];if(e.relative[k=j.type])break;if(l=e.find[k])if(d=l(j.matches[0].replace(V,""),R.test(h[0].type)&&b.parentNode||b,f)){h.splice(g,1),a=d.length&&h.join("");if(!a)return w.apply(c,x.call(d,0)),c;break}}}return i(a,m)(d,b,f,c,R.test(a)),c}function bq(){}var c,d,e,f,g,h,i,j,k,l,m=!0,n="undefined",o=("sizcache"+Math.random()).replace(".",""),q=String,r=a.document,s=r.documentElement,t=0,u=0,v=[].pop,w=[].push,x=[].slice,y=[].indexOf||function(a){var b=0,c=this.length;for(;b<c;b++)if(this[b]===a)return b;return-1},z=function(a,b){return a[o]=b==null||b,a},A=function(){var a={},b=[];return z(function(c,d){return b.push(c)>e.cacheLength&&delete a[b.shift()],a[c]=d},a)},B=A(),C=A(),D=A(),E="[\\x20\\t\\r\\n\\f]",F="(?:\\\\.|[-\\w]|[^\\x00-\\xa0])+",G=F.replace("w","w#"),H="([*^$|!~]?=)",I="\\["+E+"*("+F+")"+E+"*(?:"+H+E+"*(?:(['\"])((?:\\\\.|[^\\\\])*?)\\3|("+G+")|)|)"+E+"*\\]",J=":("+F+")(?:\\((?:(['\"])((?:\\\\.|[^\\\\])*?)\\2|([^()[\\]]*|(?:(?:"+I+")|[^:]|\\\\.)*|.*))\\)|)",K=":(even|odd|eq|gt|lt|nth|first|last)(?:\\("+E+"*((?:-\\d)?\\d*)"+E+"*\\)|)(?=[^-]|$)",L=new RegExp("^"+E+"+|((?:^|[^\\\\])(?:\\\\.)*)"+E+"+$","g"),M=new RegExp("^"+E+"*,"+E+"*"),N=new RegExp("^"+E+"*([\\x20\\t\\r\\n\\f>+~])"+E+"*"),O=new RegExp(J),P=/^(?:#([\w\-]+)|(\w+)|\.([\w\-]+))$/,Q=/^:not/,R=/[\x20\t\r\n\f]*[+~]/,S=/:not\($/,T=/h\d/i,U=/input|select|textarea|button/i,V=/\\(?!\\)/g,W={ID:new RegExp("^#("+F+")"),CLASS:new RegExp("^\\.("+F+")"),NAME:new RegExp("^\\[name=['\"]?("+F+")['\"]?\\]"),TAG:new RegExp("^("+F.replace("w","w*")+")"),ATTR:new RegExp("^"+I),PSEUDO:new RegExp("^"+J),POS:new RegExp(K,"i"),CHILD:new RegExp("^:(only|nth|first|last)-child(?:\\("+E+"*(even|odd|(([+-]|)(\\d*)n|)"+E+"*(?:([+-]|)"+E+"*(\\d+)|))"+E+"*\\)|)","i"),needsContext:new RegExp("^"+E+"*[>+~]|"+K,"i")},X=function(a){var b=r.createElement("div");try{return a(b)}catch(c){return!1}finally{b=null}},Y=X(function(a){return a.appendChild(r.createComment("")),!a.getElementsByTagName("*").length}),Z=X(function(a){return a.innerHTML="<a href='#'></a>",a.firstChild&&typeof a.firstChild.getAttribute!==n&&a.firstChild.getAttribute("href")==="#"}),$=X(function(a){a.innerHTML="<select></select>";var b=typeof a.lastChild.getAttribute("multiple");return b!=="boolean"&&b!=="string"}),_=X(function(a){return a.innerHTML="<div class='hidden e'></div><div class='hidden'></div>",!a.getElementsByClassName||!a.getElementsByClassName("e").length?!1:(a.lastChild.className="e",a.getElementsByClassName("e").length===2)}),ba=X(function(a){a.id=o+0,a.innerHTML="<a name='"+o+"'></a><div name='"+o+"'></div>",s.insertBefore(a,s.firstChild);var b=r.getElementsByName&&r.getElementsByName(o).length===2+r.getElementsByName(o+0).length;return d=!r.getElementById(o),s.removeChild(a),b});try{x.call(s.childNodes,0)[0].nodeType}catch(bb){x=function(a){var b,c=[];for(;b=this[a];a++)c.push(b);return c}}bc.matches=function(a,b){return bc(a,null,null,b)},bc.matchesSelector=function(a,b){return bc(b,null,null,[a]).length>0},f=bc.getText=function(a){var b,c="",d=0,e=a.nodeType;if(e){if(e===1||e===9||e===11){if(typeof a.textContent=="string")return a.textContent;for(a=a.firstChild;a;a=a.nextSibling)c+=f(a)}else if(e===3||e===4)return a.nodeValue}else for(;b=a[d];d++)c+=f(b);return c},g=bc.isXML=function(a){var b=a&&(a.ownerDocument||a).documentElement;return b?b.nodeName!=="HTML":!1},h=bc.contains=s.contains?function(a,b){var c=a.nodeType===9?a.documentElement:a,d=b&&b.parentNode;return a===d||!!(d&&d.nodeType===1&&c.contains&&c.contains(d))}:s.compareDocumentPosition?function(a,b){return b&&!!(a.compareDocumentPosition(b)&16)}:function(a,b){while(b=b.parentNode)if(b===a)return!0;return!1},bc.attr=function(a,b){var c,d=g(a);return d||(b=b.toLowerCase()),(c=e.attrHandle[b])?c(a):d||$?a.getAttribute(b):(c=a.getAttributeNode(b),c?typeof a[b]=="boolean"?a[b]?b:null:c.specified?c.value:null:null)},e=bc.selectors={cacheLength:50,createPseudo:z,match:W,attrHandle:Z?{}:{href:function(a){return a.getAttribute("href",2)},type:function(a){return a.getAttribute("type")}},find:{ID:d?function(a,b,c){if(typeof b.getElementById!==n&&!c){var d=b.getElementById(a);return d&&d.parentNode?[d]:[]}}:function(a,c,d){if(typeof c.getElementById!==n&&!d){var e=c.getElementById(a);return e?e.id===a||typeof e.getAttributeNode!==n&&e.getAttributeNode("id").value===a?[e]:b:[]}},TAG:Y?function(a,b){if(typeof b.getElementsByTagName!==n)return b.getElementsByTagName(a)}:function(a,b){var c=b.getElementsByTagName(a);if(a==="*"){var d,e=[],f=0;for(;d=c[f];f++)d.nodeType===1&&e.push(d);return e}return c},NAME:ba&&function(a,b){if(typeof b.getElementsByName!==n)return b.getElementsByName(name)},CLASS:_&&function(a,b,c){if(typeof b.getElementsByClassName!==n&&!c)return b.getElementsByClassName(a)}},relative:{">":{dir:"parentNode",first:!0}," ":{dir:"parentNode"},"+":{dir:"previousSibling",first:!0},"~":{dir:"previousSibling"}},preFilter:{ATTR:function(a){return a[1]=a[1].replace(V,""),a[3]=(a[4]||a[5]||"").replace(V,""),a[2]==="~="&&(a[3]=" "+a[3]+" "),a.slice(0,4)},CHILD:function(a){return a[1]=a[1].toLowerCase(),a[1]==="nth"?(a[2]||bc.error(a[0]),a[3]=+(a[3]?a[4]+(a[5]||1):2*(a[2]==="even"||a[2]==="odd")),a[4]=+(a[6]+a[7]||a[2]==="odd")):a[2]&&bc.error(a[0]),a},PSEUDO:function(a){var b,c;if(W.CHILD.test(a[0]))return null;if(a[3])a[2]=a[3];else if(b=a[4])O.test(b)&&(c=bh(b,!0))&&(c=b.indexOf(")",b.length-c)-b.length)&&(b=b.slice(0,c),a[0]=a[0].slice(0,c)),a[2]=b;return a.slice(0,3)}},filter:{ID:d?function(a){return a=a.replace(V,""),function(b){return b.getAttribute("id")===a}}:function(a){return a=a.replace(V,""),function(b){var c=typeof b.getAttributeNode!==n&&b.getAttributeNode("id");return c&&c.value===a}},TAG:function(a){return a==="*"?function(){return!0}:(a=a.replace(V,"").toLowerCase(),function(b){return b.nodeName&&b.nodeName.toLowerCase()===a})},CLASS:function(a){var b=B[o][a];return b||(b=B(a,new RegExp("(^|"+E+")"+a+"("+E+"|$)"))),function(a){return b.test(a.className||typeof a.getAttribute!==n&&a.getAttribute("class")||"")}},ATTR:function(a,b,c){return function(d,e){var f=bc.attr(d,a);return f==null?b==="!=":b?(f+="",b==="="?f===c:b==="!="?f!==c:b==="^="?c&&f.indexOf(c)===0:b==="*="?c&&f.indexOf(c)>-1:b==="$="?c&&f.substr(f.length-c.length)===c:b==="~="?(" "+f+" ").indexOf(c)>-1:b==="|="?f===c||f.substr(0,c.length+1)===c+"-":!1):!0}},CHILD:function(a,b,c,d){return a==="nth"?function(a){var b,e,f=a.parentNode;if(c===1&&d===0)return!0;if(f){e=0;for(b=f.firstChild;b;b=b.nextSibling)if(b.nodeType===1){e++;if(a===b)break}}return e-=d,e===c||e%c===0&&e/c>=0}:function(b){var c=b;switch(a){case"only":case"first":while(c=c.previousSibling)if(c.nodeType===1)return!1;if(a==="first")return!0;c=b;case"last":while(c=c.nextSibling)if(c.nodeType===1)return!1;return!0}}},PSEUDO:function(a,b){var c,d=e.pseudos[a]||e.setFilters[a.toLowerCase()]||bc.error("unsupported pseudo: "+a);return d[o]?d(b):d.length>1?(c=[a,a,"",b],e.setFilters.hasOwnProperty(a.toLowerCase())?z(function(a,c){var e,f=d(a,b),g=f.length;while(g--)e=y.call(a,f[g]),a[e]=!(c[e]=f[g])}):function(a){return d(a,0,c)}):d}},pseudos:{not:z(function(a){var b=[],c=[],d=i(a.replace(L,"$1"));return d[o]?z(function(a,b,c,e){var f,g=d(a,null,e,[]),h=a.length;while(h--)if(f=g[h])a[h]=!(b[h]=f)}):function(a,e,f){return b[0]=a,d(b,null,f,c),!c.pop()}}),has:z(function(a){return function(b){return bc(a,b).length>0}}),contains:z(function(a){return function(b){return(b.textContent||b.innerText||f(b)).indexOf(a)>-1}}),enabled:function(a){return a.disabled===!1},disabled:function(a){return a.disabled===!0},checked:function(a){var b=a.nodeName.toLowerCase();return b==="input"&&!!a.checked||b==="option"&&!!a.selected},selected:function(a){return a.parentNode&&a.parentNode.selectedIndex,a.selected===!0},parent:function(a){return!e.pseudos.empty(a)},empty:function(a){var b;a=a.firstChild;while(a){if(a.nodeName>"@"||(b=a.nodeType)===3||b===4)return!1;a=a.nextSibling}return!0},header:function(a){return T.test(a.nodeName)},text:function(a){var b,c;return a.nodeName.toLowerCase()==="input"&&(b=a.type)==="text"&&((c=a.getAttribute("type"))==null||c.toLowerCase()===b)},radio:bd("radio"),checkbox:bd("checkbox"),file:bd("file"),password:bd("password"),image:bd("image"),submit:be("submit"),reset:be("reset"),button:function(a){var b=a.nodeName.toLowerCase();return b==="input"&&a.type==="button"||b==="button"},input:function(a){return U.test(a.nodeName)},focus:function(a){var b=a.ownerDocument;return a===b.activeElement&&(!b.hasFocus||b.hasFocus())&&(!!a.type||!!a.href)},active:function(a){return a===a.ownerDocument.activeElement},first:bf(function(a,b,c){return[0]}),last:bf(function(a,b,c){return[b-1]}),eq:bf(function(a,b,c){return[c<0?c+b:c]}),even:bf(function(a,b,c){for(var d=0;d<b;d+=2)a.push(d);return a}),odd:bf(function(a,b,c){for(var d=1;d<b;d+=2)a.push(d);return a}),lt:bf(function(a,b,c){for(var d=c<0?c+b:c;--d>=0;)a.push(d);return a}),gt:bf(function(a,b,c){for(var d=c<0?c+b:c;++d<b;)a.push(d);return a})}},j=s.compareDocumentPosition?function(a,b){return a===b?(k=!0,0):(!a.compareDocumentPosition||!b.compareDocumentPosition?a.compareDocumentPosition:a.compareDocumentPosition(b)&4)?-1:1}:function(a,b){if(a===b)return k=!0,0;if(a.sourceIndex&&b.sourceIndex)return a.sourceIndex-b.sourceIndex;var c,d,e=[],f=[],g=a.parentNode,h=b.parentNode,i=g;if(g===h)return bg(a,b);if(!g)return-1;if(!h)return 1;while(i)e.unshift(i),i=i.parentNode;i=h;while(i)f.unshift(i),i=i.parentNode;c=e.length,d=f.length;for(var j=0;j<c&&j<d;j++)if(e[j]!==f[j])return bg(e[j],f[j]);return j===c?bg(a,f[j],-1):bg(e[j],b,1)},[0,0].sort(j),m=!k,bc.uniqueSort=function(a){var b,c=1;k=m,a.sort(j);if(k)for(;b=a[c];c++)b===a[c-1]&&a.splice(c--,1);return a},bc.error=function(a){throw new Error("Syntax error, unrecognized expression: "+a)},i=bc.compile=function(a,b){var c,d=[],e=[],f=D[o][a];if(!f){b||(b=bh(a)),c=b.length;while(c--)f=bm(b[c]),f[o]?d.push(f):e.push(f);f=D(a,bn(e,d))}return f},r.querySelectorAll&&function(){var a,b=bp,c=/'|\\/g,d=/\=[\x20\t\r\n\f]*([^'"\]]*)[\x20\t\r\n\f]*\]/g,e=[":focus"],f=[":active",":focus"],h=s.matchesSelector||s.mozMatchesSelector||s.webkitMatchesSelector||s.oMatchesSelector||s.msMatchesSelector;X(function(a){a.innerHTML="<select><option selected=''></option></select>",a.querySelectorAll("[selected]").length||e.push("\\["+E+"*(?:checked|disabled|ismap|multiple|readonly|selected|value)"),a.querySelectorAll(":checked").length||e.push(":checked")}),X(function(a){a.innerHTML="<p test=''></p>",a.querySelectorAll("[test^='']").length&&e.push("[*^$]="+E+"*(?:\"\"|'')"),a.innerHTML="<input type='hidden'/>",a.querySelectorAll(":enabled").length||e.push(":enabled",":disabled")}),e=new RegExp(e.join("|")),bp=function(a,d,f,g,h){if(!g&&!h&&(!e||!e.test(a))){var i,j,k=!0,l=o,m=d,n=d.nodeType===9&&a;if(d.nodeType===1&&d.nodeName.toLowerCase()!=="object"){i=bh(a),(k=d.getAttribute("id"))?l=k.replace(c,"\\$&"):d.setAttribute("id",l),l="[id='"+l+"'] ",j=i.length;while(j--)i[j]=l+i[j].join("");m=R.test(a)&&d.parentNode||d,n=i.join(",")}if(n)try{return w.apply(f,x.call(m.querySelectorAll(n),0)),f}catch(p){}finally{k||d.removeAttribute("id")}}return b(a,d,f,g,h)},h&&(X(function(b){a=h.call(b,"div");try{h.call(b,"[test!='']:sizzle"),f.push("!=",J)}catch(c){}}),f=new RegExp(f.join("|")),bc.matchesSelector=function(b,c){c=c.replace(d,"='$1']");if(!g(b)&&!f.test(c)&&(!e||!e.test(c)))try{var i=h.call(b,c);if(i||a||b.document&&b.document.nodeType!==11)return i}catch(j){}return bc(c,null,null,[b]).length>0})}(),e.pseudos.nth=e.pseudos.eq,e.filters=bq.prototype=e.pseudos,e.setFilters=new bq,bc.attr=p.attr,p.find=bc,p.expr=bc.selectors,p.expr[":"]=p.expr.pseudos,p.unique=bc.uniqueSort,p.text=bc.getText,p.isXMLDoc=bc.isXML,p.contains=bc.contains}(a);var bc=/Until$/,bd=/^(?:parents|prev(?:Until|All))/,be=/^.[^:#\[\.,]*$/,bf=p.expr.match.needsContext,bg={children:!0,contents:!0,next:!0,prev:!0};p.fn.extend({find:function(a){var b,c,d,e,f,g,h=this;if(typeof a!="string")return p(a).filter(function(){for(b=0,c=h.length;b<c;b++)if(p.contains(h[b],this))return!0});g=this.pushStack("","find",a);for(b=0,c=this.length;b<c;b++){d=g.length,p.find(a,this[b],g);if(b>0)for(e=d;e<g.length;e++)for(f=0;f<d;f++)if(g[f]===g[e]){g.splice(e--,1);break}}return g},has:function(a){var b,c=p(a,this),d=c.length;return this.filter(function(){for(b=0;b<d;b++)if(p.contains(this,c[b]))return!0})},not:function(a){return this.pushStack(bj(this,a,!1),"not",a)},filter:function(a){return this.pushStack(bj(this,a,!0),"filter",a)},is:function(a){return!!a&&(typeof a=="string"?bf.test(a)?p(a,this.context).index(this[0])>=0:p.filter(a,this).length>0:this.filter(a).length>0)},closest:function(a,b){var c,d=0,e=this.length,f=[],g=bf.test(a)||typeof a!="string"?p(a,b||this.context):0;for(;d<e;d++){c=this[d];while(c&&c.ownerDocument&&c!==b&&c.nodeType!==11){if(g?g.index(c)>-1:p.find.matchesSelector(c,a)){f.push(c);break}c=c.parentNode}}return f=f.length>1?p.unique(f):f,this.pushStack(f,"closest",a)},index:function(a){return a?typeof a=="string"?p.inArray(this[0],p(a)):p.inArray(a.jquery?a[0]:a,this):this[0]&&this[0].parentNode?this.prevAll().length:-1},add:function(a,b){var c=typeof a=="string"?p(a,b):p.makeArray(a&&a.nodeType?[a]:a),d=p.merge(this.get(),c);return this.pushStack(bh(c[0])||bh(d[0])?d:p.unique(d))},addBack:function(a){return this.add(a==null?this.prevObject:this.prevObject.filter(a))}}),p.fn.andSelf=p.fn.addBack,p.each({parent:function(a){var b=a.parentNode;return b&&b.nodeType!==11?b:null},parents:function(a){return p.dir(a,"parentNode")},parentsUntil:function(a,b,c){return p.dir(a,"parentNode",c)},next:function(a){return bi(a,"nextSibling")},prev:function(a){return bi(a,"previousSibling")},nextAll:function(a){return p.dir(a,"nextSibling")},prevAll:function(a){return p.dir(a,"previousSibling")},nextUntil:function(a,b,c){return p.dir(a,"nextSibling",c)},prevUntil:function(a,b,c){return p.dir(a,"previousSibling",c)},siblings:function(a){return p.sibling((a.parentNode||{}).firstChild,a)},children:function(a){return p.sibling(a.firstChild)},contents:function(a){return p.nodeName(a,"iframe")?a.contentDocument||a.contentWindow.document:p.merge([],a.childNodes)}},function(a,b){p.fn[a]=function(c,d){var e=p.map(this,b,c);return bc.test(a)||(d=c),d&&typeof d=="string"&&(e=p.filter(d,e)),e=this.length>1&&!bg[a]?p.unique(e):e,this.length>1&&bd.test(a)&&(e=e.reverse()),this.pushStack(e,a,k.call(arguments).join(","))}}),p.extend({filter:function(a,b,c){return c&&(a=":not("+a+")"),b.length===1?p.find.matchesSelector(b[0],a)?[b[0]]:[]:p.find.matches(a,b)},dir:function(a,c,d){var e=[],f=a[c];while(f&&f.nodeType!==9&&(d===b||f.nodeType!==1||!p(f).is(d)))f.nodeType===1&&e.push(f),f=f[c];return e},sibling:function(a,b){var c=[];for(;a;a=a.nextSibling)a.nodeType===1&&a!==b&&c.push(a);return c}});var bl="abbr|article|aside|audio|bdi|canvas|data|datalist|details|figcaption|figure|footer|header|hgroup|mark|meter|nav|output|progress|section|summary|time|video",bm=/ jQuery\d+="(?:null|\d+)"/g,bn=/^\s+/,bo=/<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,bp=/<([\w:]+)/,bq=/<tbody/i,br=/<|&#?\w+;/,bs=/<(?:script|style|link)/i,bt=/<(?:script|object|embed|option|style)/i,bu=new RegExp("<(?:"+bl+")[\\s/>]","i"),bv=/^(?:checkbox|radio)$/,bw=/checked\s*(?:[^=]|=\s*.checked.)/i,bx=/\/(java|ecma)script/i,by=/^\s*<!(?:\[CDATA\[|\-\-)|[\]\-]{2}>\s*$/g,bz={option:[1,"<select multiple='multiple'>","</select>"],legend:[1,"<fieldset>","</fieldset>"],thead:[1,"<table>","</table>"],tr:[2,"<table><tbody>","</tbody></table>"],td:[3,"<table><tbody><tr>","</tr></tbody></table>"],col:[2,"<table><tbody></tbody><colgroup>","</colgroup></table>"],area:[1,"<map>","</map>"],_default:[0,"",""]},bA=bk(e),bB=bA.appendChild(e.createElement("div"));bz.optgroup=bz.option,bz.tbody=bz.tfoot=bz.colgroup=bz.caption=bz.thead,bz.th=bz.td,p.support.htmlSerialize||(bz._default=[1,"X<div>","</div>"]),p.fn.extend({text:function(a){return p.access(this,function(a){return a===b?p.text(this):this.empty().append((this[0]&&this[0].ownerDocument||e).createTextNode(a))},null,a,arguments.length)},wrapAll:function(a){if(p.isFunction(a))return this.each(function(b){p(this).wrapAll(a.call(this,b))});if(this[0]){var b=p(a,this[0].ownerDocument).eq(0).clone(!0);this[0].parentNode&&b.insertBefore(this[0]),b.map(function(){var a=this;while(a.firstChild&&a.firstChild.nodeType===1)a=a.firstChild;return a}).append(this)}return this},wrapInner:function(a){return p.isFunction(a)?this.each(function(b){p(this).wrapInner(a.call(this,b))}):this.each(function(){var b=p(this),c=b.contents();c.length?c.wrapAll(a):b.append(a)})},wrap:function(a){var b=p.isFunction(a);return this.each(function(c){p(this).wrapAll(b?a.call(this,c):a)})},unwrap:function(){return this.parent().each(function(){p.nodeName(this,"body")||p(this).replaceWith(this.childNodes)}).end()},append:function(){return this.domManip(arguments,!0,function(a){(this.nodeType===1||this.nodeType===11)&&this.appendChild(a)})},prepend:function(){return this.domManip(arguments,!0,function(a){(this.nodeType===1||this.nodeType===11)&&this.insertBefore(a,this.firstChild)})},before:function(){if(!bh(this[0]))return this.domManip(arguments,!1,function(a){this.parentNode.insertBefore(a,this)});if(arguments.length){var a=p.clean(arguments);return this.pushStack(p.merge(a,this),"before",this.selector)}},after:function(){if(!bh(this[0]))return this.domManip(arguments,!1,function(a){this.parentNode.insertBefore(a,this.nextSibling)});if(arguments.length){var a=p.clean(arguments);return this.pushStack(p.merge(this,a),"after",this.selector)}},remove:function(a,b){var c,d=0;for(;(c=this[d])!=null;d++)if(!a||p.filter(a,[c]).length)!b&&c.nodeType===1&&(p.cleanData(c.getElementsByTagName("*")),p.cleanData([c])),c.parentNode&&c.parentNode.removeChild(c);return this},empty:function(){var a,b=0;for(;(a=this[b])!=null;b++){a.nodeType===1&&p.cleanData(a.getElementsByTagName("*"));while(a.firstChild)a.removeChild(a.firstChild)}return this},clone:function(a,b){return a=a==null?!1:a,b=b==null?a:b,this.map(function(){return p.clone(this,a,b)})},html:function(a){return p.access(this,function(a){var c=this[0]||{},d=0,e=this.length;if(a===b)return c.nodeType===1?c.innerHTML.replace(bm,""):b;if(typeof a=="string"&&!bs.test(a)&&(p.support.htmlSerialize||!bu.test(a))&&(p.support.leadingWhitespace||!bn.test(a))&&!bz[(bp.exec(a)||["",""])[1].toLowerCase()]){a=a.replace(bo,"<$1></$2>");try{for(;d<e;d++)c=this[d]||{},c.nodeType===1&&(p.cleanData(c.getElementsByTagName("*")),c.innerHTML=a);c=0}catch(f){}}c&&this.empty().append(a)},null,a,arguments.length)},replaceWith:function(a){return bh(this[0])?this.length?this.pushStack(p(p.isFunction(a)?a():a),"replaceWith",a):this:p.isFunction(a)?this.each(function(b){var c=p(this),d=c.html();c.replaceWith(a.call(this,b,d))}):(typeof a!="string"&&(a=p(a).detach()),this.each(function(){var b=this.nextSibling,c=this.parentNode;p(this).remove(),b?p(b).before(a):p(c).append(a)}))},detach:function(a){return this.remove(a,!0)},domManip:function(a,c,d){a=[].concat.apply([],a);var e,f,g,h,i=0,j=a[0],k=[],l=this.length;if(!p.support.checkClone&&l>1&&typeof j=="string"&&bw.test(j))return this.each(function(){p(this).domManip(a,c,d)});if(p.isFunction(j))return this.each(function(e){var f=p(this);a[0]=j.call(this,e,c?f.html():b),f.domManip(a,c,d)});if(this[0]){e=p.buildFragment(a,this,k),g=e.fragment,f=g.firstChild,g.childNodes.length===1&&(g=f);if(f){c=c&&p.nodeName(f,"tr");for(h=e.cacheable||l-1;i<l;i++)d.call(c&&p.nodeName(this[i],"table")?bC(this[i],"tbody"):this[i],i===h?g:p.clone(g,!0,!0))}g=f=null,k.length&&p.each(k,function(a,b){b.src?p.ajax?p.ajax({url:b.src,type:"GET",dataType:"script",async:!1,global:!1,"throws":!0}):p.error("no ajax"):p.globalEval((b.text||b.textContent||b.innerHTML||"").replace(by,"")),b.parentNode&&b.parentNode.removeChild(b)})}return this}}),p.buildFragment=function(a,c,d){var f,g,h,i=a[0];return c=c||e,c=!c.nodeType&&c[0]||c,c=c.ownerDocument||c,a.length===1&&typeof i=="string"&&i.length<512&&c===e&&i.charAt(0)==="<"&&!bt.test(i)&&(p.support.checkClone||!bw.test(i))&&(p.support.html5Clone||!bu.test(i))&&(g=!0,f=p.fragments[i],h=f!==b),f||(f=c.createDocumentFragment(),p.clean(a,c,f,d),g&&(p.fragments[i]=h&&f)),{fragment:f,cacheable:g}},p.fragments={},p.each({appendTo:"append",prependTo:"prepend",insertBefore:"before",insertAfter:"after",replaceAll:"replaceWith"},function(a,b){p.fn[a]=function(c){var d,e=0,f=[],g=p(c),h=g.length,i=this.length===1&&this[0].parentNode;if((i==null||i&&i.nodeType===11&&i.childNodes.length===1)&&h===1)return g[b](this[0]),this;for(;e<h;e++)d=(e>0?this.clone(!0):this).get(),p(g[e])[b](d),f=f.concat(d);return this.pushStack(f,a,g.selector)}}),p.extend({clone:function(a,b,c){var d,e,f,g;p.support.html5Clone||p.isXMLDoc(a)||!bu.test("<"+a.nodeName+">")?g=a.cloneNode(!0):(bB.innerHTML=a.outerHTML,bB.removeChild(g=bB.firstChild));if((!p.support.noCloneEvent||!p.support.noCloneChecked)&&(a.nodeType===1||a.nodeType===11)&&!p.isXMLDoc(a)){bE(a,g),d=bF(a),e=bF(g);for(f=0;d[f];++f)e[f]&&bE(d[f],e[f])}if(b){bD(a,g);if(c){d=bF(a),e=bF(g);for(f=0;d[f];++f)bD(d[f],e[f])}}return d=e=null,g},clean:function(a,b,c,d){var f,g,h,i,j,k,l,m,n,o,q,r,s=b===e&&bA,t=[];if(!b||typeof b.createDocumentFragment=="undefined")b=e;for(f=0;(h=a[f])!=null;f++){typeof h=="number"&&(h+="");if(!h)continue;if(typeof h=="string")if(!br.test(h))h=b.createTextNode(h);else{s=s||bk(b),l=b.createElement("div"),s.appendChild(l),h=h.replace(bo,"<$1></$2>"),i=(bp.exec(h)||["",""])[1].toLowerCase(),j=bz[i]||bz._default,k=j[0],l.innerHTML=j[1]+h+j[2];while(k--)l=l.lastChild;if(!p.support.tbody){m=bq.test(h),n=i==="table"&&!m?l.firstChild&&l.firstChild.childNodes:j[1]==="<table>"&&!m?l.childNodes:[];for(g=n.length-1;g>=0;--g)p.nodeName(n[g],"tbody")&&!n[g].childNodes.length&&n[g].parentNode.removeChild(n[g])}!p.support.leadingWhitespace&&bn.test(h)&&l.insertBefore(b.createTextNode(bn.exec(h)[0]),l.firstChild),h=l.childNodes,l.parentNode.removeChild(l)}h.nodeType?t.push(h):p.merge(t,h)}l&&(h=l=s=null);if(!p.support.appendChecked)for(f=0;(h=t[f])!=null;f++)p.nodeName(h,"input")?bG(h):typeof h.getElementsByTagName!="undefined"&&p.grep(h.getElementsByTagName("input"),bG);if(c){q=function(a){if(!a.type||bx.test(a.type))return d?d.push(a.parentNode?a.parentNode.removeChild(a):a):c.appendChild(a)};for(f=0;(h=t[f])!=null;f++)if(!p.nodeName(h,"script")||!q(h))c.appendChild(h),typeof h.getElementsByTagName!="undefined"&&(r=p.grep(p.merge([],h.getElementsByTagName("script")),q),t.splice.apply(t,[f+1,0].concat(r)),f+=r.length)}return t},cleanData:function(a,b){var c,d,e,f,g=0,h=p.expando,i=p.cache,j=p.support.deleteExpando,k=p.event.special;for(;(e=a[g])!=null;g++)if(b||p.acceptData(e)){d=e[h],c=d&&i[d];if(c){if(c.events)for(f in c.events)k[f]?p.event.remove(e,f):p.removeEvent(e,f,c.handle);i[d]&&(delete i[d],j?delete e[h]:e.removeAttribute?e.removeAttribute(h):e[h]=null,p.deletedIds.push(d))}}}}),function(){var a,b;p.uaMatch=function(a){a=a.toLowerCase();var b=/(chrome)[ \/]([\w.]+)/.exec(a)||/(webkit)[ \/]([\w.]+)/.exec(a)||/(opera)(?:.*version|)[ \/]([\w.]+)/.exec(a)||/(msie) ([\w.]+)/.exec(a)||a.indexOf("compatible")<0&&/(mozilla)(?:.*? rv:([\w.]+)|)/.exec(a)||[];return{browser:b[1]||"",version:b[2]||"0"}},a=p.uaMatch(g.userAgent),b={},a.browser&&(b[a.browser]=!0,b.version=a.version),b.chrome?b.webkit=!0:b.webkit&&(b.safari=!0),p.browser=b,p.sub=function(){function a(b,c){return new a.fn.init(b,c)}p.extend(!0,a,this),a.superclass=this,a.fn=a.prototype=this(),a.fn.constructor=a,a.sub=this.sub,a.fn.init=function c(c,d){return d&&d instanceof p&&!(d instanceof a)&&(d=a(d)),p.fn.init.call(this,c,d,b)},a.fn.init.prototype=a.fn;var b=a(e);return a}}();var bH,bI,bJ,bK=/alpha\([^)]*\)/i,bL=/opacity=([^)]*)/,bM=/^(top|right|bottom|left)$/,bN=/^(none|table(?!-c[ea]).+)/,bO=/^margin/,bP=new RegExp("^("+q+")(.*)$","i"),bQ=new RegExp("^("+q+")(?!px)[a-z%]+$","i"),bR=new RegExp("^([-+])=("+q+")","i"),bS={},bT={position:"absolute",visibility:"hidden",display:"block"},bU={letterSpacing:0,fontWeight:400},bV=["Top","Right","Bottom","Left"],bW=["Webkit","O","Moz","ms"],bX=p.fn.toggle;p.fn.extend({css:function(a,c){return p.access(this,function(a,c,d){return d!==b?p.style(a,c,d):p.css(a,c)},a,c,arguments.length>1)},show:function(){return b$(this,!0)},hide:function(){return b$(this)},toggle:function(a,b){var c=typeof a=="boolean";return p.isFunction(a)&&p.isFunction(b)?bX.apply(this,arguments):this.each(function(){(c?a:bZ(this))?p(this).show():p(this).hide()})}}),p.extend({cssHooks:{opacity:{get:function(a,b){if(b){var c=bH(a,"opacity");return c===""?"1":c}}}},cssNumber:{fillOpacity:!0,fontWeight:!0,lineHeight:!0,opacity:!0,orphans:!0,widows:!0,zIndex:!0,zoom:!0},cssProps:{"float":p.support.cssFloat?"cssFloat":"styleFloat"},style:function(a,c,d,e){if(!a||a.nodeType===3||a.nodeType===8||!a.style)return;var f,g,h,i=p.camelCase(c),j=a.style;c=p.cssProps[i]||(p.cssProps[i]=bY(j,i)),h=p.cssHooks[c]||p.cssHooks[i];if(d===b)return h&&"get"in h&&(f=h.get(a,!1,e))!==b?f:j[c];g=typeof d,g==="string"&&(f=bR.exec(d))&&(d=(f[1]+1)*f[2]+parseFloat(p.css(a,c)),g="number");if(d==null||g==="number"&&isNaN(d))return;g==="number"&&!p.cssNumber[i]&&(d+="px");if(!h||!("set"in h)||(d=h.set(a,d,e))!==b)try{j[c]=d}catch(k){}},css:function(a,c,d,e){var f,g,h,i=p.camelCase(c);return c=p.cssProps[i]||(p.cssProps[i]=bY(a.style,i)),h=p.cssHooks[c]||p.cssHooks[i],h&&"get"in h&&(f=h.get(a,!0,e)),f===b&&(f=bH(a,c)),f==="normal"&&c in bU&&(f=bU[c]),d||e!==b?(g=parseFloat(f),d||p.isNumeric(g)?g||0:f):f},swap:function(a,b,c){var d,e,f={};for(e in b)f[e]=a.style[e],a.style[e]=b[e];d=c.call(a);for(e in b)a.style[e]=f[e];return d}}),a.getComputedStyle?bH=function(b,c){var d,e,f,g,h=a.getComputedStyle(b,null),i=b.style;return h&&(d=h[c],d===""&&!p.contains(b.ownerDocument,b)&&(d=p.style(b,c)),bQ.test(d)&&bO.test(c)&&(e=i.width,f=i.minWidth,g=i.maxWidth,i.minWidth=i.maxWidth=i.width=d,d=h.width,i.width=e,i.minWidth=f,i.maxWidth=g)),d}:e.documentElement.currentStyle&&(bH=function(a,b){var c,d,e=a.currentStyle&&a.currentStyle[b],f=a.style;return e==null&&f&&f[b]&&(e=f[b]),bQ.test(e)&&!bM.test(b)&&(c=f.left,d=a.runtimeStyle&&a.runtimeStyle.left,d&&(a.runtimeStyle.left=a.currentStyle.left),f.left=b==="fontSize"?"1em":e,e=f.pixelLeft+"px",f.left=c,d&&(a.runtimeStyle.left=d)),e===""?"auto":e}),p.each(["height","width"],function(a,b){p.cssHooks[b]={get:function(a,c,d){if(c)return a.offsetWidth===0&&bN.test(bH(a,"display"))?p.swap(a,bT,function(){return cb(a,b,d)}):cb(a,b,d)},set:function(a,c,d){return b_(a,c,d?ca(a,b,d,p.support.boxSizing&&p.css(a,"boxSizing")==="border-box"):0)}}}),p.support.opacity||(p.cssHooks.opacity={get:function(a,b){return bL.test((b&&a.currentStyle?a.currentStyle.filter:a.style.filter)||"")?.01*parseFloat(RegExp.$1)+"":b?"1":""},set:function(a,b){var c=a.style,d=a.currentStyle,e=p.isNumeric(b)?"alpha(opacity="+b*100+")":"",f=d&&d.filter||c.filter||"";c.zoom=1;if(b>=1&&p.trim(f.replace(bK,""))===""&&c.removeAttribute){c.removeAttribute("filter");if(d&&!d.filter)return}c.filter=bK.test(f)?f.replace(bK,e):f+" "+e}}),p(function(){p.support.reliableMarginRight||(p.cssHooks.marginRight={get:function(a,b){return p.swap(a,{display:"inline-block"},function(){if(b)return bH(a,"marginRight")})}}),!p.support.pixelPosition&&p.fn.position&&p.each(["top","left"],function(a,b){p.cssHooks[b]={get:function(a,c){if(c){var d=bH(a,b);return bQ.test(d)?p(a).position()[b]+"px":d}}}})}),p.expr&&p.expr.filters&&(p.expr.filters.hidden=function(a){return a.offsetWidth===0&&a.offsetHeight===0||!p.support.reliableHiddenOffsets&&(a.style&&a.style.display||bH(a,"display"))==="none"},p.expr.filters.visible=function(a){return!p.expr.filters.hidden(a)}),p.each({margin:"",padding:"",border:"Width"},function(a,b){p.cssHooks[a+b]={expand:function(c){var d,e=typeof c=="string"?c.split(" "):[c],f={};for(d=0;d<4;d++)f[a+bV[d]+b]=e[d]||e[d-2]||e[0];return f}},bO.test(a)||(p.cssHooks[a+b].set=b_)});var cd=/%20/g,ce=/\[\]$/,cf=/\r?\n/g,cg=/^(?:color|date|datetime|datetime-local|email|hidden|month|number|password|range|search|tel|text|time|url|week)$/i,ch=/^(?:select|textarea)/i;p.fn.extend({serialize:function(){return p.param(this.serializeArray())},serializeArray:function(){return this.map(function(){return this.elements?p.makeArray(this.elements):this}).filter(function(){return this.name&&!this.disabled&&(this.checked||ch.test(this.nodeName)||cg.test(this.type))}).map(function(a,b){var c=p(this).val();return c==null?null:p.isArray(c)?p.map(c,function(a,c){return{name:b.name,value:a.replace(cf,"\r\n")}}):{name:b.name,value:c.replace(cf,"\r\n")}}).get()}}),p.param=function(a,c){var d,e=[],f=function(a,b){b=p.isFunction(b)?b():b==null?"":b,e[e.length]=encodeURIComponent(a)+"="+encodeURIComponent(b)};c===b&&(c=p.ajaxSettings&&p.ajaxSettings.traditional);if(p.isArray(a)||a.jquery&&!p.isPlainObject(a))p.each(a,function(){f(this.name,this.value)});else for(d in a)ci(d,a[d],c,f);return e.join("&").replace(cd,"+")};var cj,ck,cl=/#.*$/,cm=/^(.*?):[ \t]*([^\r\n]*)\r?$/mg,cn=/^(?:about|app|app\-storage|.+\-extension|file|res|widget):$/,co=/^(?:GET|HEAD)$/,cp=/^\/\//,cq=/\?/,cr=/<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,cs=/([?&])_=[^&]*/,ct=/^([\w\+\.\-]+:)(?:\/\/([^\/?#:]*)(?::(\d+)|)|)/,cu=p.fn.load,cv={},cw={},cx=["*/"]+["*"];try{ck=f.href}catch(cy){ck=e.createElement("a"),ck.href="",ck=ck.href}cj=ct.exec(ck.toLowerCase())||[],p.fn.load=function(a,c,d){if(typeof a!="string"&&cu)return cu.apply(this,arguments);if(!this.length)return this;var e,f,g,h=this,i=a.indexOf(" ");return i>=0&&(e=a.slice(i,a.length),a=a.slice(0,i)),p.isFunction(c)?(d=c,c=b):c&&typeof c=="object"&&(f="POST"),p.ajax({url:a,type:f,dataType:"html",data:c,complete:function(a,b){d&&h.each(d,g||[a.responseText,b,a])}}).done(function(a){g=arguments,h.html(e?p("<div>").append(a.replace(cr,"")).find(e):a)}),this},p.each("ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split(" "),function(a,b){p.fn[b]=function(a){return this.on(b,a)}}),p.each(["get","post"],function(a,c){p[c]=function(a,d,e,f){return p.isFunction(d)&&(f=f||e,e=d,d=b),p.ajax({type:c,url:a,data:d,success:e,dataType:f})}}),p.extend({getScript:function(a,c){return p.get(a,b,c,"script")},getJSON:function(a,b,c){return p.get(a,b,c,"json")},ajaxSetup:function(a,b){return b?cB(a,p.ajaxSettings):(b=a,a=p.ajaxSettings),cB(a,b),a},ajaxSettings:{url:ck,isLocal:cn.test(cj[1]),global:!0,type:"GET",contentType:"application/x-www-form-urlencoded; charset=UTF-8",processData:!0,async:!0,accepts:{xml:"application/xml, text/xml",html:"text/html",text:"text/plain",json:"application/json, text/javascript","*":cx},contents:{xml:/xml/,html:/html/,json:/json/},responseFields:{xml:"responseXML",text:"responseText"},converters:{"* text":a.String,"text html":!0,"text json":p.parseJSON,"text xml":p.parseXML},flatOptions:{context:!0,url:!0}},ajaxPrefilter:cz(cv),ajaxTransport:cz(cw),ajax:function(a,c){function y(a,c,f,i){var k,s,t,u,w,y=c;if(v===2)return;v=2,h&&clearTimeout(h),g=b,e=i||"",x.readyState=a>0?4:0,f&&(u=cC(l,x,f));if(a>=200&&a<300||a===304)l.ifModified&&(w=x.getResponseHeader("Last-Modified"),w&&(p.lastModified[d]=w),w=x.getResponseHeader("Etag"),w&&(p.etag[d]=w)),a===304?(y="notmodified",k=!0):(k=cD(l,u),y=k.state,s=k.data,t=k.error,k=!t);else{t=y;if(!y||a)y="error",a<0&&(a=0)}x.status=a,x.statusText=(c||y)+"",k?o.resolveWith(m,[s,y,x]):o.rejectWith(m,[x,y,t]),x.statusCode(r),r=b,j&&n.trigger("ajax"+(k?"Success":"Error"),[x,l,k?s:t]),q.fireWith(m,[x,y]),j&&(n.trigger("ajaxComplete",[x,l]),--p.active||p.event.trigger("ajaxStop"))}typeof a=="object"&&(c=a,a=b),c=c||{};var d,e,f,g,h,i,j,k,l=p.ajaxSetup({},c),m=l.context||l,n=m!==l&&(m.nodeType||m instanceof p)?p(m):p.event,o=p.Deferred(),q=p.Callbacks("once memory"),r=l.statusCode||{},t={},u={},v=0,w="canceled",x={readyState:0,setRequestHeader:function(a,b){if(!v){var c=a.toLowerCase();a=u[c]=u[c]||a,t[a]=b}return this},getAllResponseHeaders:function(){return v===2?e:null},getResponseHeader:function(a){var c;if(v===2){if(!f){f={};while(c=cm.exec(e))f[c[1].toLowerCase()]=c[2]}c=f[a.toLowerCase()]}return c===b?null:c},overrideMimeType:function(a){return v||(l.mimeType=a),this},abort:function(a){return a=a||w,g&&g.abort(a),y(0,a),this}};o.promise(x),x.success=x.done,x.error=x.fail,x.complete=q.add,x.statusCode=function(a){if(a){var b;if(v<2)for(b in a)r[b]=[r[b],a[b]];else b=a[x.status],x.always(b)}return this},l.url=((a||l.url)+"").replace(cl,"").replace(cp,cj[1]+"//"),l.dataTypes=p.trim(l.dataType||"*").toLowerCase().split(s),l.crossDomain==null&&(i=ct.exec(l.url.toLowerCase())||!1,l.crossDomain=i&&i.join(":")+(i[3]?"":i[1]==="http:"?80:443)!==cj.join(":")+(cj[3]?"":cj[1]==="http:"?80:443)),l.data&&l.processData&&typeof l.data!="string"&&(l.data=p.param(l.data,l.traditional)),cA(cv,l,c,x);if(v===2)return x;j=l.global,l.type=l.type.toUpperCase(),l.hasContent=!co.test(l.type),j&&p.active++===0&&p.event.trigger("ajaxStart");if(!l.hasContent){l.data&&(l.url+=(cq.test(l.url)?"&":"?")+l.data,delete l.data),d=l.url;if(l.cache===!1){var z=p.now(),A=l.url.replace(cs,"$1_="+z);l.url=A+(A===l.url?(cq.test(l.url)?"&":"?")+"_="+z:"")}}(l.data&&l.hasContent&&l.contentType!==!1||c.contentType)&&x.setRequestHeader("Content-Type",l.contentType),l.ifModified&&(d=d||l.url,p.lastModified[d]&&x.setRequestHeader("If-Modified-Since",p.lastModified[d]),p.etag[d]&&x.setRequestHeader("If-None-Match",p.etag[d])),x.setRequestHeader("Accept",l.dataTypes[0]&&l.accepts[l.dataTypes[0]]?l.accepts[l.dataTypes[0]]+(l.dataTypes[0]!=="*"?", "+cx+"; q=0.01":""):l.accepts["*"]);for(k in l.headers)x.setRequestHeader(k,l.headers[k]);if(!l.beforeSend||l.beforeSend.call(m,x,l)!==!1&&v!==2){w="abort";for(k in{success:1,error:1,complete:1})x[k](l[k]);g=cA(cw,l,c,x);if(!g)y(-1,"No Transport");else{x.readyState=1,j&&n.trigger("ajaxSend",[x,l]),l.async&&l.timeout>0&&(h=setTimeout(function(){x.abort("timeout")},l.timeout));try{v=1,g.send(t,y)}catch(B){if(v<2)y(-1,B);else throw B}}return x}return x.abort()},active:0,lastModified:{},etag:{}});var cE=[],cF=/\?/,cG=/(=)\?(?=&|$)|\?\?/,cH=p.now();p.ajaxSetup({jsonp:"callback",jsonpCallback:function(){var a=cE.pop()||p.expando+"_"+cH++;return this[a]=!0,a}}),p.ajaxPrefilter("json jsonp",function(c,d,e){var f,g,h,i=c.data,j=c.url,k=c.jsonp!==!1,l=k&&cG.test(j),m=k&&!l&&typeof i=="string"&&!(c.contentType||"").indexOf("application/x-www-form-urlencoded")&&cG.test(i);if(c.dataTypes[0]==="jsonp"||l||m)return f=c.jsonpCallback=p.isFunction(c.jsonpCallback)?c.jsonpCallback():c.jsonpCallback,g=a[f],l?c.url=j.replace(cG,"$1"+f):m?c.data=i.replace(cG,"$1"+f):k&&(c.url+=(cF.test(j)?"&":"?")+c.jsonp+"="+f),c.converters["script json"]=function(){return h||p.error(f+" was not called"),h[0]},c.dataTypes[0]="json",a[f]=function(){h=arguments},e.always(function(){a[f]=g,c[f]&&(c.jsonpCallback=d.jsonpCallback,cE.push(f)),h&&p.isFunction(g)&&g(h[0]),h=g=b}),"script"}),p.ajaxSetup({accepts:{script:"text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"},contents:{script:/javascript|ecmascript/},converters:{"text script":function(a){return p.globalEval(a),a}}}),p.ajaxPrefilter("script",function(a){a.cache===b&&(a.cache=!1),a.crossDomain&&(a.type="GET",a.global=!1)}),p.ajaxTransport("script",function(a){if(a.crossDomain){var c,d=e.head||e.getElementsByTagName("head")[0]||e.documentElement;return{send:function(f,g){c=e.createElement("script"),c.async="async",a.scriptCharset&&(c.charset=a.scriptCharset),c.src=a.url,c.onload=c.onreadystatechange=function(a,e){if(e||!c.readyState||/loaded|complete/.test(c.readyState))c.onload=c.onreadystatechange=null,d&&c.parentNode&&d.removeChild(c),c=b,e||g(200,"success")},d.insertBefore(c,d.firstChild)},abort:function(){c&&c.onload(0,1)}}}});var cI,cJ=a.ActiveXObject?function(){for(var a in cI)cI[a](0,1)}:!1,cK=0;p.ajaxSettings.xhr=a.ActiveXObject?function(){return!this.isLocal&&cL()||cM()}:cL,function(a){p.extend(p.support,{ajax:!!a,cors:!!a&&"withCredentials"in a})}(p.ajaxSettings.xhr()),p.support.ajax&&p.ajaxTransport(function(c){if(!c.crossDomain||p.support.cors){var d;return{send:function(e,f){var g,h,i=c.xhr();c.username?i.open(c.type,c.url,c.async,c.username,c.password):i.open(c.type,c.url,c.async);if(c.xhrFields)for(h in c.xhrFields)i[h]=c.xhrFields[h];c.mimeType&&i.overrideMimeType&&i.overrideMimeType(c.mimeType),!c.crossDomain&&!e["X-Requested-With"]&&(e["X-Requested-With"]="XMLHttpRequest");try{for(h in e)i.setRequestHeader(h,e[h])}catch(j){}i.send(c.hasContent&&c.data||null),d=function(a,e){var h,j,k,l,m;try{if(d&&(e||i.readyState===4)){d=b,g&&(i.onreadystatechange=p.noop,cJ&&delete cI[g]);if(e)i.readyState!==4&&i.abort();else{h=i.status,k=i.getAllResponseHeaders(),l={},m=i.responseXML,m&&m.documentElement&&(l.xml=m);try{l.text=i.responseText}catch(a){}try{j=i.statusText}catch(n){j=""}!h&&c.isLocal&&!c.crossDomain?h=l.text?200:404:h===1223&&(h=204)}}}catch(o){e||f(-1,o)}l&&f(h,j,l,k)},c.async?i.readyState===4?setTimeout(d,0):(g=++cK,cJ&&(cI||(cI={},p(a).unload(cJ)),cI[g]=d),i.onreadystatechange=d):d()},abort:function(){d&&d(0,1)}}}});var cN,cO,cP=/^(?:toggle|show|hide)$/,cQ=new RegExp("^(?:([-+])=|)("+q+")([a-z%]*)$","i"),cR=/queueHooks$/,cS=[cY],cT={"*":[function(a,b){var c,d,e=this.createTween(a,b),f=cQ.exec(b),g=e.cur(),h=+g||0,i=1,j=20;if(f){c=+f[2],d=f[3]||(p.cssNumber[a]?"":"px");if(d!=="px"&&h){h=p.css(e.elem,a,!0)||c||1;do i=i||".5",h=h/i,p.style(e.elem,a,h+d);while(i!==(i=e.cur()/g)&&i!==1&&--j)}e.unit=d,e.start=h,e.end=f[1]?h+(f[1]+1)*c:c}return e}]};p.Animation=p.extend(cW,{tweener:function(a,b){p.isFunction(a)?(b=a,a=["*"]):a=a.split(" ");var c,d=0,e=a.length;for(;d<e;d++)c=a[d],cT[c]=cT[c]||[],cT[c].unshift(b)},prefilter:function(a,b){b?cS.unshift(a):cS.push(a)}}),p.Tween=cZ,cZ.prototype={constructor:cZ,init:function(a,b,c,d,e,f){this.elem=a,this.prop=c,this.easing=e||"swing",this.options=b,this.start=this.now=this.cur(),this.end=d,this.unit=f||(p.cssNumber[c]?"":"px")},cur:function(){var a=cZ.propHooks[this.prop];return a&&a.get?a.get(this):cZ.propHooks._default.get(this)},run:function(a){var b,c=cZ.propHooks[this.prop];return this.options.duration?this.pos=b=p.easing[this.easing](a,this.options.duration*a,0,1,this.options.duration):this.pos=b=a,this.now=(this.end-this.start)*b+this.start,this.options.step&&this.options.step.call(this.elem,this.now,this),c&&c.set?c.set(this):cZ.propHooks._default.set(this),this}},cZ.prototype.init.prototype=cZ.prototype,cZ.propHooks={_default:{get:function(a){var b;return a.elem[a.prop]==null||!!a.elem.style&&a.elem.style[a.prop]!=null?(b=p.css(a.elem,a.prop,!1,""),!b||b==="auto"?0:b):a.elem[a.prop]},set:function(a){p.fx.step[a.prop]?p.fx.step[a.prop](a):a.elem.style&&(a.elem.style[p.cssProps[a.prop]]!=null||p.cssHooks[a.prop])?p.style(a.elem,a.prop,a.now+a.unit):a.elem[a.prop]=a.now}}},cZ.propHooks.scrollTop=cZ.propHooks.scrollLeft={set:function(a){a.elem.nodeType&&a.elem.parentNode&&(a.elem[a.prop]=a.now)}},p.each(["toggle","show","hide"],function(a,b){var c=p.fn[b];p.fn[b]=function(d,e,f){return d==null||typeof d=="boolean"||!a&&p.isFunction(d)&&p.isFunction(e)?c.apply(this,arguments):this.animate(c$(b,!0),d,e,f)}}),p.fn.extend({fadeTo:function(a,b,c,d){return this.filter(bZ).css("opacity",0).show().end().animate({opacity:b},a,c,d)},animate:function(a,b,c,d){var e=p.isEmptyObject(a),f=p.speed(b,c,d),g=function(){var b=cW(this,p.extend({},a),f);e&&b.stop(!0)};return e||f.queue===!1?this.each(g):this.queue(f.queue,g)},stop:function(a,c,d){var e=function(a){var b=a.stop;delete a.stop,b(d)};return typeof a!="string"&&(d=c,c=a,a=b),c&&a!==!1&&this.queue(a||"fx",[]),this.each(function(){var b=!0,c=a!=null&&a+"queueHooks",f=p.timers,g=p._data(this);if(c)g[c]&&g[c].stop&&e(g[c]);else for(c in g)g[c]&&g[c].stop&&cR.test(c)&&e(g[c]);for(c=f.length;c--;)f[c].elem===this&&(a==null||f[c].queue===a)&&(f[c].anim.stop(d),b=!1,f.splice(c,1));(b||!d)&&p.dequeue(this,a)})}}),p.each({slideDown:c$("show"),slideUp:c$("hide"),slideToggle:c$("toggle"),fadeIn:{opacity:"show"},fadeOut:{opacity:"hide"},fadeToggle:{opacity:"toggle"}},function(a,b){p.fn[a]=function(a,c,d){return this.animate(b,a,c,d)}}),p.speed=function(a,b,c){var d=a&&typeof a=="object"?p.extend({},a):{complete:c||!c&&b||p.isFunction(a)&&a,duration:a,easing:c&&b||b&&!p.isFunction(b)&&b};d.duration=p.fx.off?0:typeof d.duration=="number"?d.duration:d.duration in p.fx.speeds?p.fx.speeds[d.duration]:p.fx.speeds._default;if(d.queue==null||d.queue===!0)d.queue="fx";return d.old=d.complete,d.complete=function(){p.isFunction(d.old)&&d.old.call(this),d.queue&&p.dequeue(this,d.queue)},d},p.easing={linear:function(a){return a},swing:function(a){return.5-Math.cos(a*Math.PI)/2}},p.timers=[],p.fx=cZ.prototype.init,p.fx.tick=function(){var a,b=p.timers,c=0;for(;c<b.length;c++)a=b[c],!a()&&b[c]===a&&b.splice(c--,1);b.length||p.fx.stop()},p.fx.timer=function(a){a()&&p.timers.push(a)&&!cO&&(cO=setInterval(p.fx.tick,p.fx.interval))},p.fx.interval=13,p.fx.stop=function(){clearInterval(cO),cO=null},p.fx.speeds={slow:600,fast:200,_default:400},p.fx.step={},p.expr&&p.expr.filters&&(p.expr.filters.animated=function(a){return p.grep(p.timers,function(b){return a===b.elem}).length});var c_=/^(?:body|html)$/i;p.fn.offset=function(a){if(arguments.length)return a===b?this:this.each(function(b){p.offset.setOffset(this,a,b)});var c,d,e,f,g,h,i,j={top:0,left:0},k=this[0],l=k&&k.ownerDocument;if(!l)return;return(d=l.body)===k?p.offset.bodyOffset(k):(c=l.documentElement,p.contains(c,k)?(typeof k.getBoundingClientRect!="undefined"&&(j=k.getBoundingClientRect()),e=da(l),f=c.clientTop||d.clientTop||0,g=c.clientLeft||d.clientLeft||0,h=e.pageYOffset||c.scrollTop,i=e.pageXOffset||c.scrollLeft,{top:j.top+h-f,left:j.left+i-g}):j)},p.offset={bodyOffset:function(a){var b=a.offsetTop,c=a.offsetLeft;return p.support.doesNotIncludeMarginInBodyOffset&&(b+=parseFloat(p.css(a,"marginTop"))||0,c+=parseFloat(p.css(a,"marginLeft"))||0),{top:b,left:c}},setOffset:function(a,b,c){var d=p.css(a,"position");d==="static"&&(a.style.position="relative");var e=p(a),f=e.offset(),g=p.css(a,"top"),h=p.css(a,"left"),i=(d==="absolute"||d==="fixed")&&p.inArray("auto",[g,h])>-1,j={},k={},l,m;i?(k=e.position(),l=k.top,m=k.left):(l=parseFloat(g)||0,m=parseFloat(h)||0),p.isFunction(b)&&(b=b.call(a,c,f)),b.top!=null&&(j.top=b.top-f.top+l),b.left!=null&&(j.left=b.left-f.left+m),"using"in b?b.using.call(a,j):e.css(j)}},p.fn.extend({position:function(){if(!this[0])return;var a=this[0],b=this.offsetParent(),c=this.offset(),d=c_.test(b[0].nodeName)?{top:0,left:0}:b.offset();return c.top-=parseFloat(p.css(a,"marginTop"))||0,c.left-=parseFloat(p.css(a,"marginLeft"))||0,d.top+=parseFloat(p.css(b[0],"borderTopWidth"))||0,d.left+=parseFloat(p.css(b[0],"borderLeftWidth"))||0,{top:c.top-d.top,left:c.left-d.left}},offsetParent:function(){return this.map(function(){var a=this.offsetParent||e.body;while(a&&!c_.test(a.nodeName)&&p.css(a,"position")==="static")a=a.offsetParent;return a||e.body})}}),p.each({scrollLeft:"pageXOffset",scrollTop:"pageYOffset"},function(a,c){var d=/Y/.test(c);p.fn[a]=function(e){return p.access(this,function(a,e,f){var g=da(a);if(f===b)return g?c in g?g[c]:g.document.documentElement[e]:a[e];g?g.scrollTo(d?p(g).scrollLeft():f,d?f:p(g).scrollTop()):a[e]=f},a,e,arguments.length,null)}}),p.each({Height:"height",Width:"width"},function(a,c){p.each({padding:"inner"+a,content:c,"":"outer"+a},function(d,e){p.fn[e]=function(e,f){var g=arguments.length&&(d||typeof e!="boolean"),h=d||(e===!0||f===!0?"margin":"border");return p.access(this,function(c,d,e){var f;return p.isWindow(c)?c.document.documentElement["client"+a]:c.nodeType===9?(f=c.documentElement,Math.max(c.body["scroll"+a],f["scroll"+a],c.body["offset"+a],f["offset"+a],f["client"+a])):e===b?p.css(c,d,e,h):p.style(c,d,e,h)},c,g?e:b,g,null)}})}),a.jQuery=a.$=p,typeof define=="function"&&define.amd&&define.amd.jQuery&&define("jquery",[],function(){return p})})(window);
jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        // CAUTION: Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};
/*! Copyright (c) 2010 Brandon Aaron (http://brandonaaron.net)
 * Licensed under the MIT License (LICENSE.txt).
 * Version 2.1.2
 */

;(function($){

$.fn.bgiframe = ($.browser.msie && /msie 6\.0/i.test(navigator.userAgent) ? function(s) {
    s = $.extend({
        top     : 'auto', // auto == .currentStyle.borderTopWidth
        left    : 'auto', // auto == .currentStyle.borderLeftWidth
        width   : 'auto', // auto == offsetWidth
        height  : 'auto', // auto == offsetHeight
        opacity : true,
        src     : 'javascript:false;'
    }, s);

    function prop(n) {
        return n && n.constructor === Number ? n + 'px' : n;
    }
    var html = '<iframe class="bgiframe"frameborder="0"tabindex="-1"src="'+s.src+'"'+
                   'style="display:block;position:absolute;z-index:-1;'+
                       (s.opacity !== false?'filter:Alpha(Opacity=\'0\');':'')+
                       'top:'+(s.top=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+\'px\')':prop(s.top))+';'+
                       'left:'+(s.left=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+\'px\')':prop(s.left))+';'+
                       'width:'+(s.width=='auto'?'expression(this.parentNode.offsetWidth+\'px\')':prop(s.width))+';'+
                       'height:'+(s.height=='auto'?'expression(this.parentNode.offsetHeight+\'px\')':prop(s.height))+';'+
                '"/>';
    return this.each(function() {
        if ( $(this).children('iframe.bgiframe').length === 0 )
            this.insertBefore( document.createElement(html), this.firstChild );
    });
} : function() { return this; });

// old alias
$.fn.bgIframe = $.fn.bgiframe;


})(jQuery);
/* jQuery UI - v1.9.2 - 2013-07-04
* http://jqueryui.com
* Includes: jquery.ui.core.js, jquery.ui.widget.js, jquery.ui.mouse.js, jquery.ui.position.js, jquery.ui.draggable.js, jquery.ui.droppable.js, jquery.ui.resizable.js, jquery.ui.selectable.js, jquery.ui.sortable.js, jquery.ui.accordion.js, jquery.ui.autocomplete.js, jquery.ui.button.js, jquery.ui.datepicker.js, jquery.ui.dialog.js, jquery.ui.menu.js, jquery.ui.progressbar.js, jquery.ui.slider.js, jquery.ui.spinner.js, jquery.ui.tabs.js, jquery.ui.tooltip.js, jquery.ui.effect.js, jquery.ui.effect-blind.js, jquery.ui.effect-bounce.js, jquery.ui.effect-clip.js, jquery.ui.effect-drop.js, jquery.ui.effect-explode.js, jquery.ui.effect-fade.js, jquery.ui.effect-fold.js, jquery.ui.effect-highlight.js, jquery.ui.effect-pulsate.js, jquery.ui.effect-scale.js, jquery.ui.effect-shake.js, jquery.ui.effect-slide.js, jquery.ui.effect-transfer.js
* Copyright 2013 jQuery Foundation and other contributors Licensed MIT */
;(function(a,d){var e=0,c=/^ui-id-\d+$/;a.ui=a.ui||{};if(a.ui.version){return}a.extend(a.ui,{version:"1.9.2",keyCode:{BACKSPACE:8,COMMA:188,DELETE:46,DOWN:40,END:35,ENTER:13,ESCAPE:27,HOME:36,LEFT:37,NUMPAD_ADD:107,NUMPAD_DECIMAL:110,NUMPAD_DIVIDE:111,NUMPAD_ENTER:108,NUMPAD_MULTIPLY:106,NUMPAD_SUBTRACT:109,PAGE_DOWN:34,PAGE_UP:33,PERIOD:190,RIGHT:39,SPACE:32,TAB:9,UP:38}});a.fn.extend({_focus:a.fn.focus,focus:function(g,h){return typeof g==="number"?this.each(function(){var i=this;setTimeout(function(){a(i).focus();if(h){h.call(i)}},g)}):this._focus.apply(this,arguments)},scrollParent:function(){var g;if((a.ui.ie&&(/(static|relative)/).test(this.css("position")))||(/absolute/).test(this.css("position"))){g=this.parents().filter(function(){return(/(relative|absolute|fixed)/).test(a.css(this,"position"))&&(/(auto|scroll)/).test(a.css(this,"overflow")+a.css(this,"overflow-y")+a.css(this,"overflow-x"))}).eq(0)}else{g=this.parents().filter(function(){return(/(auto|scroll)/).test(a.css(this,"overflow")+a.css(this,"overflow-y")+a.css(this,"overflow-x"))}).eq(0)}return(/fixed/).test(this.css("position"))||!g.length?a(document):g},zIndex:function(j){if(j!==d){return this.css("zIndex",j)}if(this.length){var g=a(this[0]),h,i;while(g.length&&g[0]!==document){h=g.css("position");if(h==="absolute"||h==="relative"||h==="fixed"){i=parseInt(g.css("zIndex"),10);if(!isNaN(i)&&i!==0){return i}}g=g.parent()}}return 0},uniqueId:function(){return this.each(function(){if(!this.id){this.id="ui-id-"+(++e)}})},removeUniqueId:function(){return this.each(function(){if(c.test(this.id)){a(this).removeAttr("id")}})}});function b(g,i){var j,k,h,l=g.nodeName.toLowerCase();if("area"===l){j=g.parentNode;k=j.name;if(!g.href||!k||j.nodeName.toLowerCase()!=="map"){return false}h=a("img[usemap=#"+k+"]")[0];return !!h&&f(h)}return(/input|select|textarea|button|object/.test(l)?!g.disabled:"a"===l?g.href||i:i)&&f(g)}function f(g){return a.expr.filters.visible(g)&&!a(g).parents().andSelf().filter(function(){return a.css(this,"visibility")==="hidden"}).length}a.extend(a.expr[":"],{data:a.expr.createPseudo?a.expr.createPseudo(function(g){return function(h){return !!a.data(h,g)}}):function(g,h,j){return !!a.data(g,j[3])},focusable:function(g){return b(g,!isNaN(a.attr(g,"tabindex")))},tabbable:function(g){var i=a.attr(g,"tabindex"),h=isNaN(i);return(h||i>=0)&&b(g,!h)}});a(function(){var g=document.body,h=g.appendChild(h=document.createElement("div"));h.offsetHeight;a.extend(h.style,{minHeight:"100px",height:"auto",padding:0,borderWidth:0});a.support.minHeight=h.offsetHeight===100;a.support.selectstart="onselectstart" in h;g.removeChild(h).style.display="none"});if(!a("<a>").outerWidth(1).jquery){a.each(["Width","Height"],function(g,h){var l=h==="Width"?["Left","Right"]:["Top","Bottom"],m=h.toLowerCase(),j={innerWidth:a.fn.innerWidth,innerHeight:a.fn.innerHeight,outerWidth:a.fn.outerWidth,outerHeight:a.fn.outerHeight};function k(n,p,i,o){a.each(l,function(){p-=parseFloat(a.css(n,"padding"+this))||0;if(i){p-=parseFloat(a.css(n,"border"+this+"Width"))||0}if(o){p-=parseFloat(a.css(n,"margin"+this))||0}});return p}a.fn["inner"+h]=function(i){if(i===d){return j["inner"+h].call(this)}return this.each(function(){a(this).css(m,k(this,i)+"px")})};a.fn["outer"+h]=function(n,i){if(typeof n!=="number"){return j["outer"+h].call(this,n)}return this.each(function(){a(this).css(m,k(this,n,true,i)+"px")})}})}if(a("<a>").data("a-b","a").removeData("a-b").data("a-b")){a.fn.removeData=(function(g){return function(h){if(arguments.length){return g.call(this,a.camelCase(h))}else{return g.call(this)}}})(a.fn.removeData)}(function(){var g=/msie ([\w.]+)/.exec(navigator.userAgent.toLowerCase())||[];a.ui.ie=g.length?true:false;a.ui.ie6=parseFloat(g[1],10)===6})();a.fn.extend({disableSelection:function(){return this.bind((a.support.selectstart?"selectstart":"mousedown")+".ui-disableSelection",function(g){g.preventDefault()})},enableSelection:function(){return this.unbind(".ui-disableSelection")}});a.extend(a.ui,{plugin:{add:function(h,j,l){var g,k=a.ui[h].prototype;for(g in l){k.plugins[g]=k.plugins[g]||[];k.plugins[g].push([j,l[g]])}},call:function(j,k,g){var h,l=j.plugins[k];if(!l||!j.element[0].parentNode||j.element[0].parentNode.nodeType===11){return}for(h=0;h<l.length;h++){if(j.options[l[h][0]]){l[h][1].apply(j.element,g)}}}},contains:a.contains,hasScroll:function(h,g){if(a(h).css("overflow")==="hidden"){return false}var j=(g&&g==="left")?"scrollLeft":"scrollTop",i=false;if(h[j]>0){return true}h[j]=1;i=(h[j]>0);h[j]=0;return i},isOverAxis:function(i,g,h){return(i>g)&&(i<(g+h))},isOver:function(l,k,i,h,g,j){return a.ui.isOverAxis(l,i,g)&&a.ui.isOverAxis(k,h,j)}})})(jQuery);(function(a,d){var e=0,c=Array.prototype.slice,b=a.cleanData;a.cleanData=function(h){for(var j=0,g;(g=h[j])!=null;j++){try{a(g).triggerHandler("remove")}catch(f){}}b(h)};a.widget=function(k,f,m){var j,i,h,g,l=k.split(".")[0];k=k.split(".")[1];j=l+"-"+k;if(!m){m=f;f=a.Widget}a.expr[":"][j.toLowerCase()]=function(n){return !!a.data(n,j)};a[l]=a[l]||{};i=a[l][k];h=a[l][k]=function(o,n){if(!this._createWidget){return new h(o,n)}if(arguments.length){this._createWidget(o,n)}};a.extend(h,i,{version:m.version,_proto:a.extend({},m),_childConstructors:[]});g=new f();g.options=a.widget.extend({},g.options);a.each(m,function(n,o){if(a.isFunction(o)){m[n]=(function(){var p=function(){return f.prototype[n].apply(this,arguments)},q=function(r){return f.prototype[n].apply(this,r)};return function(){var r=this._super,s=this._superApply,t;this._super=p;this._superApply=q;t=o.apply(this,arguments);this._super=r;this._superApply=s;return t}})()}});h.prototype=a.widget.extend(g,{widgetEventPrefix:i?g.widgetEventPrefix:k},m,{constructor:h,namespace:l,widgetName:k,widgetBaseClass:j,widgetFullName:j});if(i){a.each(i._childConstructors,function(p,n){var o=n.prototype;a.widget(o.namespace+"."+o.widgetName,h,n._proto)});delete i._childConstructors}else{f._childConstructors.push(h)}a.widget.bridge(k,h)};a.widget.extend=function(j){var f=c.call(arguments,1),g=0,h=f.length,i,k;for(;g<h;g++){for(i in f[g]){k=f[g][i];if(f[g].hasOwnProperty(i)&&k!==d){if(a.isPlainObject(k)){j[i]=a.isPlainObject(j[i])?a.widget.extend({},j[i],k):a.widget.extend({},k)}else{j[i]=k}}}}return j};a.widget.bridge=function(g,h){var f=h.prototype.widgetFullName||g;a.fn[g]=function(k){var j=typeof k==="string",i=c.call(arguments,1),l=this;k=!j&&i.length?a.widget.extend.apply(null,[k].concat(i)):k;if(j){this.each(function(){var n,m=a.data(this,f);if(!m){return a.error("cannot call methods on "+g+" prior to initialization; attempted to call method '"+k+"'")}if(!a.isFunction(m[k])||k.charAt(0)==="_"){return a.error("no such method '"+k+"' for "+g+" widget instance")}n=m[k].apply(m,i);if(n!==m&&n!==d){l=n&&n.jquery?l.pushStack(n.get()):n;return false}})}else{this.each(function(){var m=a.data(this,f);if(m){m.option(k||{})._init()}else{a.data(this,f,new h(k,this))}})}return l}};a.Widget=function(){};a.Widget._childConstructors=[];a.Widget.prototype={widgetName:"widget",widgetEventPrefix:"",defaultElement:"<div>",options:{disabled:false,create:null},_createWidget:function(g,f){f=a(f||this.defaultElement||this)[0];this.element=a(f);this.uuid=e++;this.eventNamespace="."+this.widgetName+this.uuid;this.options=a.widget.extend({},this.options,this._getCreateOptions(),g);this.bindings=a();this.hoverable=a();this.focusable=a();if(f!==this){a.data(f,this.widgetName,this);a.data(f,this.widgetFullName,this);this._on(true,this.element,{remove:function(h){if(h.target===f){this.destroy()}}});this.document=a(f.style?f.ownerDocument:f.document||f);this.window=a(this.document[0].defaultView||this.document[0].parentWindow)}this._create();this._trigger("create",null,this._getCreateEventData());this._init()},_getCreateOptions:a.noop,_getCreateEventData:a.noop,_create:a.noop,_init:a.noop,destroy:function(){this._destroy();this.element.unbind(this.eventNamespace).removeData(this.widgetName).removeData(this.widgetFullName).removeData(a.camelCase(this.widgetFullName));this.widget().unbind(this.eventNamespace).removeAttr("aria-disabled").removeClass(this.widgetFullName+"-disabled ui-state-disabled");this.bindings.unbind(this.eventNamespace);this.hoverable.removeClass("ui-state-hover");this.focusable.removeClass("ui-state-focus")},_destroy:a.noop,widget:function(){return this.element},option:function(h,l){var j=h,k,f,g;if(arguments.length===0){return a.widget.extend({},this.options)}if(typeof h==="string"){j={};k=h.split(".");h=k.shift();if(k.length){f=j[h]=a.widget.extend({},this.options[h]);for(g=0;g<k.length-1;g++){f[k[g]]=f[k[g]]||{};f=f[k[g]]}h=k.pop();if(l===d){return f[h]===d?null:f[h]}f[h]=l}else{if(l===d){return this.options[h]===d?null:this.options[h]}j[h]=l}}this._setOptions(j);return this},_setOptions:function(g){var f;for(f in g){this._setOption(f,g[f])}return this},_setOption:function(f,g){this.options[f]=g;if(f==="disabled"){this.widget().toggleClass(this.widgetFullName+"-disabled ui-state-disabled",!!g).attr("aria-disabled",g);this.hoverable.removeClass("ui-state-hover");this.focusable.removeClass("ui-state-focus")}return this},enable:function(){return this._setOption("disabled",false)},disable:function(){return this._setOption("disabled",true)},_on:function(j,g,h){var f,i=this;if(typeof j!=="boolean"){h=g;g=j;j=false}if(!h){h=g;g=this.element;f=this.widget()}else{g=f=a(g);this.bindings=this.bindings.add(g)}a.each(h,function(k,m){function n(){if(!j&&(i.options.disabled===true||a(this).hasClass("ui-state-disabled"))){return}return(typeof m==="string"?i[m]:m).apply(i,arguments)}if(typeof m!=="string"){n.guid=m.guid=m.guid||n.guid||a.guid++}var o=k.match(/^(\w+)\s*(.*)$/),l=o[1]+i.eventNamespace,p=o[2];if(p){f.delegate(p,l,n)}else{g.bind(l,n)}})},_off:function(f,g){g=(g||"").split(" ").join(this.eventNamespace+" ")+this.eventNamespace;f.unbind(g).undelegate(g)},_delay:function(g,f){function h(){return(typeof g==="string"?i[g]:g).apply(i,arguments)}var i=this;return setTimeout(h,f||0)},_hoverable:function(f){this.hoverable=this.hoverable.add(f);this._on(f,{mouseenter:function(g){a(g.currentTarget).addClass("ui-state-hover")},mouseleave:function(g){a(g.currentTarget).removeClass("ui-state-hover")}})},_focusable:function(f){this.focusable=this.focusable.add(f);this._on(f,{focusin:function(g){a(g.currentTarget).addClass("ui-state-focus")},focusout:function(g){a(g.currentTarget).removeClass("ui-state-focus")}})},_trigger:function(k,h,g){var j,i,f=this.options[k];g=g||{};h=a.Event(h);h.type=(k===this.widgetEventPrefix?k:this.widgetEventPrefix+k).toLowerCase();h.target=this.element[0];i=h.originalEvent;if(i){for(j in i){if(!(j in h)){h[j]=i[j]}}}this.element.trigger(h,g);return !(a.isFunction(f)&&f.apply(this.element[0],[h].concat(g))===false||h.isDefaultPrevented())}};a.each({show:"fadeIn",hide:"fadeOut"},function(g,f){a.Widget.prototype["_"+g]=function(j,l,h){if(typeof l==="string"){l={effect:l}}var k,i=!l?g:l===true||typeof l==="number"?f:l.effect||f;l=l||{};if(typeof l==="number"){l={duration:l}}k=!a.isEmptyObject(l);l.complete=h;if(l.delay){j.delay(l.delay)}if(k&&a.effects&&(a.effects.effect[i]||a.uiBackCompat!==false&&a.effects[i])){j[g](l)}else{if(i!==g&&j[i]){j[i](l.duration,l.easing,h)}else{j.queue(function(m){a(this)[g]();if(h){h.call(j[0])}m()})}}}});if(a.uiBackCompat!==false){a.Widget.prototype._getCreateOptions=function(){return a.metadata&&a.metadata.get(this.element[0])[this.widgetName]}}})(jQuery);(function(a,c){var b=false;a(document).mouseup(function(d){b=false});a.widget("ui.mouse",{version:"1.9.2",options:{cancel:"input,textarea,button,select,option",distance:1,delay:0},_mouseInit:function(){var d=this;this.element.bind("mousedown."+this.widgetName,function(e){return d._mouseDown(e)}).bind("click."+this.widgetName,function(e){if(true===a.data(e.target,d.widgetName+".preventClickEvent")){a.removeData(e.target,d.widgetName+".preventClickEvent");e.stopImmediatePropagation();return false}});this.started=false},_mouseDestroy:function(){this.element.unbind("."+this.widgetName);if(this._mouseMoveDelegate){a(document).unbind("mousemove."+this.widgetName,this._mouseMoveDelegate).unbind("mouseup."+this.widgetName,this._mouseUpDelegate)}},_mouseDown:function(f){if(b){return}(this._mouseStarted&&this._mouseUp(f));this._mouseDownEvent=f;var g=this,d=(f.which===1),e=(typeof this.options.cancel==="string"&&f.target.nodeName?a(f.target).closest(this.options.cancel).length:false);if(!d||e||!this._mouseCapture(f)){return true}this.mouseDelayMet=!this.options.delay;if(!this.mouseDelayMet){this._mouseDelayTimer=setTimeout(function(){g.mouseDelayMet=true},this.options.delay)}if(this._mouseDistanceMet(f)&&this._mouseDelayMet(f)){this._mouseStarted=(this._mouseStart(f)!==false);if(!this._mouseStarted){f.preventDefault();return true}}if(true===a.data(f.target,this.widgetName+".preventClickEvent")){a.removeData(f.target,this.widgetName+".preventClickEvent")}this._mouseMoveDelegate=function(h){return g._mouseMove(h)};this._mouseUpDelegate=function(h){return g._mouseUp(h)};a(document).bind("mousemove."+this.widgetName,this._mouseMoveDelegate).bind("mouseup."+this.widgetName,this._mouseUpDelegate);f.preventDefault();b=true;return true},_mouseMove:function(d){if(a.ui.ie&&!(document.documentMode>=9)&&!d.button){return this._mouseUp(d)}if(this._mouseStarted){this._mouseDrag(d);return d.preventDefault()}if(this._mouseDistanceMet(d)&&this._mouseDelayMet(d)){this._mouseStarted=(this._mouseStart(this._mouseDownEvent,d)!==false);(this._mouseStarted?this._mouseDrag(d):this._mouseUp(d))}return !this._mouseStarted},_mouseUp:function(d){a(document).unbind("mousemove."+this.widgetName,this._mouseMoveDelegate).unbind("mouseup."+this.widgetName,this._mouseUpDelegate);if(this._mouseStarted){this._mouseStarted=false;if(d.target===this._mouseDownEvent.target){a.data(d.target,this.widgetName+".preventClickEvent",true)}this._mouseStop(d)}return false},_mouseDistanceMet:function(d){return(Math.max(Math.abs(this._mouseDownEvent.pageX-d.pageX),Math.abs(this._mouseDownEvent.pageY-d.pageY))>=this.options.distance)},_mouseDelayMet:function(d){return this.mouseDelayMet},_mouseStart:function(d){},_mouseDrag:function(d){},_mouseStop:function(d){},_mouseCapture:function(d){return true}})})(jQuery);(function(a,n){a.ui=a.ui||{};var d,f=Math.max,c=Math.abs,j=Math.round,h=/left|center|right/,m=/top|center|bottom/,i=/[\+\-]\d+%?/,l=/^\w+/,k=/%$/,b=a.fn.position;function e(p,q,o){return[parseInt(p[0],10)*(k.test(p[0])?q/100:1),parseInt(p[1],10)*(k.test(p[1])?o/100:1)]}function g(o,p){return parseInt(a.css(o,p),10)||0}a.position={scrollbarWidth:function(){if(d!==n){return d}var q,r,o=a("<div style='display:block;width:50px;height:50px;overflow:hidden;'><div style='height:100px;width:auto;'></div></div>"),p=o.children()[0];a("body").append(o);q=p.offsetWidth;o.css("overflow","scroll");r=p.offsetWidth;if(q===r){r=o[0].clientWidth}o.remove();return(d=q-r)},getScrollInfo:function(s){var q=s.isWindow?"":s.element.css("overflow-x"),r=s.isWindow?"":s.element.css("overflow-y"),o=q==="scroll"||(q==="auto"&&s.width<s.element[0].scrollWidth),p=r==="scroll"||(r==="auto"&&s.height<s.element[0].scrollHeight);return{width:o?a.position.scrollbarWidth():0,height:p?a.position.scrollbarWidth():0}},getWithinInfo:function(o){var q=a(o||window),p=a.isWindow(q[0]);return{element:q,isWindow:p,offset:q.offset()||{left:0,top:0},scrollLeft:q.scrollLeft(),scrollTop:q.scrollTop(),width:p?q.width():q.outerWidth(),height:p?q.height():q.outerHeight()}}};a.fn.position=function(s){if(!s||!s.of){return b.apply(this,arguments)}s=a.extend({},s);var o,y,w,x,p,u=a(s.of),z=a.position.getWithinInfo(s.within),t=a.position.getScrollInfo(z),v=u[0],q=(s.collision||"flip").split(" "),r={};if(v.nodeType===9){y=u.width();w=u.height();x={top:0,left:0}}else{if(a.isWindow(v)){y=u.width();w=u.height();x={top:u.scrollTop(),left:u.scrollLeft()}}else{if(v.preventDefault){s.at="left top";y=w=0;x={top:v.pageY,left:v.pageX}}else{y=u.outerWidth();w=u.outerHeight();x=u.offset()}}}p=a.extend({},x);a.each(["my","at"],function(){var B=(s[this]||"").split(" "),A,C;if(B.length===1){B=h.test(B[0])?B.concat(["center"]):m.test(B[0])?["center"].concat(B):["center","center"]}B[0]=h.test(B[0])?B[0]:"center";B[1]=m.test(B[1])?B[1]:"center";A=i.exec(B[0]);C=i.exec(B[1]);r[this]=[A?A[0]:0,C?C[0]:0];s[this]=[l.exec(B[0])[0],l.exec(B[1])[0]]});if(q.length===1){q[1]=q[0]}if(s.at[0]==="right"){p.left+=y}else{if(s.at[0]==="center"){p.left+=y/2}}if(s.at[1]==="bottom"){p.top+=w}else{if(s.at[1]==="center"){p.top+=w/2}}o=e(r.at,y,w);p.left+=o[0];p.top+=o[1];return this.each(function(){var B,K,D=a(this),F=D.outerWidth(),E=D.outerHeight(),G=g(this,"marginLeft"),H=g(this,"marginTop"),C=F+G+g(this,"marginRight")+t.width,A=E+H+g(this,"marginBottom")+t.height,J=a.extend({},p),I=e(r.my,D.outerWidth(),D.outerHeight());if(s.my[0]==="right"){J.left-=F}else{if(s.my[0]==="center"){J.left-=F/2}}if(s.my[1]==="bottom"){J.top-=E}else{if(s.my[1]==="center"){J.top-=E/2}}J.left+=I[0];J.top+=I[1];if(!a.support.offsetFractions){J.left=j(J.left);J.top=j(J.top)}B={marginLeft:G,marginTop:H};a.each(["left","top"],function(M,L){if(a.ui.position[q[M]]){a.ui.position[q[M]][L](J,{targetWidth:y,targetHeight:w,elemWidth:F,elemHeight:E,collisionPosition:B,collisionWidth:C,collisionHeight:A,offset:[o[0]+I[0],o[1]+I[1]],my:s.my,at:s.at,within:z,elem:D})}});if(a.fn.bgiframe){D.bgiframe()}if(s.using){K=function(O){var N=x.left-J.left,P=N+y-F,Q=x.top-J.top,L=Q+w-E,M={target:{element:u,left:x.left,top:x.top,width:y,height:w},element:{element:D,left:J.left,top:J.top,width:F,height:E},horizontal:P<0?"left":N>0?"right":"center",vertical:L<0?"top":Q>0?"bottom":"middle"};if(y<F&&c(N+P)<y){M.horizontal="center"}if(w<E&&c(Q+L)<w){M.vertical="middle"}if(f(c(N),c(P))>f(c(Q),c(L))){M.important="horizontal"}else{M.important="vertical"}s.using.call(this,O,M)}}D.offset(a.extend(J,{using:K}))})};a.ui.position={fit:{left:function(u,p){var v=p.within,w=v.isWindow?v.scrollLeft:v.offset.left,r=v.width,o=u.left-p.collisionPosition.marginLeft,s=w-o,t=o+p.collisionWidth-r-w,q;if(p.collisionWidth>r){if(s>0&&t<=0){q=u.left+s+p.collisionWidth-r-w;u.left+=s-q}else{if(t>0&&s<=0){u.left=w}else{if(s>t){u.left=w+r-p.collisionWidth}else{u.left=w}}}}else{if(s>0){u.left+=s}else{if(t>0){u.left-=t}else{u.left=f(u.left-o,u.left)}}}},top:function(u,p){var v=p.within,w=v.isWindow?v.scrollTop:v.offset.top,r=p.within.height,o=u.top-p.collisionPosition.marginTop,t=w-o,s=o+p.collisionHeight-r-w,q;if(p.collisionHeight>r){if(t>0&&s<=0){q=u.top+t+p.collisionHeight-r-w;u.top+=t-q}else{if(s>0&&t<=0){u.top=w}else{if(t>s){u.top=w+r-p.collisionHeight}else{u.top=w}}}}else{if(t>0){u.top+=t}else{if(s>0){u.top-=s}else{u.top=f(u.top-o,u.top)}}}}},flip:{left:function(z,q){var A=q.within,B=A.offset.left+A.scrollLeft,w=A.width,v=A.isWindow?A.scrollLeft:A.offset.left,p=z.left-q.collisionPosition.marginLeft,x=p-v,y=p+q.collisionWidth-w-v,r=q.my[0]==="left"?-q.elemWidth:q.my[0]==="right"?q.elemWidth:0,o=q.at[0]==="left"?q.targetWidth:q.at[0]==="right"?-q.targetWidth:0,u=-2*q.offset[0],t,s;if(x<0){t=z.left+r+o+u+q.collisionWidth-w-B;if(t<0||t<c(x)){z.left+=r+o+u}}else{if(y>0){s=z.left-q.collisionPosition.marginLeft+r+o+u-v;if(s>0||c(s)<y){z.left+=r+o+u}}}},top:function(z,q){var B=q.within,C=B.offset.top+B.scrollTop,w=B.height,v=B.isWindow?B.scrollTop:B.offset.top,p=z.top-q.collisionPosition.marginTop,y=p-v,x=p+q.collisionHeight-w-v,A=q.my[1]==="top",r=A?-q.elemHeight:q.my[1]==="bottom"?q.elemHeight:0,o=q.at[1]==="top"?q.targetHeight:q.at[1]==="bottom"?-q.targetHeight:0,u=-2*q.offset[1],t,s;if(y<0){s=z.top+r+o+u+q.collisionHeight-w-C;if((z.top+r+o+u)>y&&(s<0||s<c(y))){z.top+=r+o+u}}else{if(x>0){t=z.top-q.collisionPosition.marginTop+r+o+u-v;if((z.top+r+o+u)>x&&(t>0||c(t)<x)){z.top+=r+o+u}}}}},flipfit:{left:function(){a.ui.position.flip.left.apply(this,arguments);a.ui.position.fit.left.apply(this,arguments)},top:function(){a.ui.position.flip.top.apply(this,arguments);a.ui.position.fit.top.apply(this,arguments)}}};(function(){var s,t,u,r,q,o=document.getElementsByTagName("body")[0],p=document.createElement("div");s=document.createElement(o?"div":"body");u={visibility:"hidden",width:0,height:0,border:0,margin:0,background:"none"};if(o){a.extend(u,{position:"absolute",left:"-1000px",top:"-1000px"})}for(q in u){s.style[q]=u[q]}s.appendChild(p);t=o||document.documentElement;t.insertBefore(s,t.firstChild);p.style.cssText="position: absolute; left: 10.7432222px;";r=a(p).offset().left;a.support.offsetFractions=r>10&&r<11;s.innerHTML="";t.removeChild(s)})();if(a.uiBackCompat!==false){(function(o){var p=o.fn.position;o.fn.position=function(s){if(!s||!s.offset){return p.call(this,s)}var r=s.offset.split(" "),q=s.at.split(" ");if(r.length===1){r[1]=r[0]}if(/^\d/.test(r[0])){r[0]="+"+r[0]}if(/^\d/.test(r[1])){r[1]="+"+r[1]}if(q.length===1){if(/left|center|right/.test(q[0])){q[1]="center"}else{q[1]=q[0];q[0]="center"}}return p.call(this,o.extend(s,{at:q[0]+r[0]+" "+q[1]+r[1],offset:n}))}}(jQuery))}}(jQuery));(function(a,b){a.widget("ui.draggable",a.ui.mouse,{version:"1.9.2",widgetEventPrefix:"drag",options:{addClasses:true,appendTo:"parent",axis:false,connectToSortable:false,containment:false,cursor:"auto",cursorAt:false,grid:false,handle:false,helper:"original",iframeFix:false,opacity:false,refreshPositions:false,revert:false,revertDuration:500,scope:"default",scroll:true,scrollSensitivity:20,scrollSpeed:20,snap:false,snapMode:"both",snapTolerance:20,stack:false,zIndex:false},_create:function(){if(this.options.helper=="original"&&!(/^(?:r|a|f)/).test(this.element.css("position"))){this.element[0].style.position="relative"}(this.options.addClasses&&this.element.addClass("ui-draggable"));(this.options.disabled&&this.element.addClass("ui-draggable-disabled"));this._mouseInit()},_destroy:function(){this.element.removeClass("ui-draggable ui-draggable-dragging ui-draggable-disabled");this._mouseDestroy()},_mouseCapture:function(c){var d=this.options;if(this.helper||d.disabled||a(c.target).is(".ui-resizable-handle")){return false}this.handle=this._getHandle(c);if(!this.handle){return false}a(d.iframeFix===true?"iframe":d.iframeFix).each(function(){a('<div class="ui-draggable-iframeFix" style="background: #fff;"></div>').css({width:this.offsetWidth+"px",height:this.offsetHeight+"px",position:"absolute",opacity:"0.001",zIndex:1000}).css(a(this).offset()).appendTo("body")});return true},_mouseStart:function(c){var d=this.options;this.helper=this._createHelper(c);this.helper.addClass("ui-draggable-dragging");this._cacheHelperProportions();if(a.ui.ddmanager){a.ui.ddmanager.current=this}this._cacheMargins();this.cssPosition=this.helper.css("position");this.scrollParent=this.helper.scrollParent();this.offset=this.positionAbs=this.element.offset();this.offset={top:this.offset.top-this.margins.top,left:this.offset.left-this.margins.left};a.extend(this.offset,{click:{left:c.pageX-this.offset.left,top:c.pageY-this.offset.top},parent:this._getParentOffset(),relative:this._getRelativeOffset()});this.originalPosition=this.position=this._generatePosition(c);this.originalPageX=c.pageX;this.originalPageY=c.pageY;(d.cursorAt&&this._adjustOffsetFromHelper(d.cursorAt));if(d.containment){this._setContainment()}if(this._trigger("start",c)===false){this._clear();return false}this._cacheHelperProportions();if(a.ui.ddmanager&&!d.dropBehaviour){a.ui.ddmanager.prepareOffsets(this,c)}this._mouseDrag(c,true);if(a.ui.ddmanager){a.ui.ddmanager.dragStart(this,c)}return true},_mouseDrag:function(c,d){this.position=this._generatePosition(c);this.positionAbs=this._convertPositionTo("absolute");if(!d){var e=this._uiHash();if(this._trigger("drag",c,e)===false){this._mouseUp({});return false}this.position=e.position}if(!this.options.axis||this.options.axis!="y"){this.helper[0].style.left=this.position.left+"px"}if(!this.options.axis||this.options.axis!="x"){this.helper[0].style.top=this.position.top+"px"}if(a.ui.ddmanager){a.ui.ddmanager.drag(this,c)}return false},_mouseStop:function(f){var c=false;if(a.ui.ddmanager&&!this.options.dropBehaviour){c=a.ui.ddmanager.drop(this,f)}if(this.dropped){c=this.dropped;this.dropped=false}var d=this.element[0],e=false;while(d&&(d=d.parentNode)){if(d==document){e=true}}if(!e&&this.options.helper==="original"){return false}if((this.options.revert=="invalid"&&!c)||(this.options.revert=="valid"&&c)||this.options.revert===true||(a.isFunction(this.options.revert)&&this.options.revert.call(this.element,c))){var g=this;a(this.helper).animate(this.originalPosition,parseInt(this.options.revertDuration,10),function(){if(g._trigger("stop",f)!==false){g._clear()}})}else{if(this._trigger("stop",f)!==false){this._clear()}}return false},_mouseUp:function(c){a("div.ui-draggable-iframeFix").each(function(){this.parentNode.removeChild(this)});if(a.ui.ddmanager){a.ui.ddmanager.dragStop(this,c)}return a.ui.mouse.prototype._mouseUp.call(this,c)},cancel:function(){if(this.helper.is(".ui-draggable-dragging")){this._mouseUp({})}else{this._clear()}return this},_getHandle:function(c){var d=!this.options.handle||!a(this.options.handle,this.element).length?true:false;a(this.options.handle,this.element).find("*").andSelf().each(function(){if(this==c.target){d=true}});return d},_createHelper:function(c){var e=this.options;var d=a.isFunction(e.helper)?a(e.helper.apply(this.element[0],[c])):(e.helper=="clone"?this.element.clone().removeAttr("id"):this.element);if(!d.parents("body").length){d.appendTo((e.appendTo=="parent"?this.element[0].parentNode:e.appendTo))}if(d[0]!=this.element[0]&&!(/(fixed|absolute)/).test(d.css("position"))){d.css("position","absolute")}return d},_adjustOffsetFromHelper:function(c){if(typeof c=="string"){c=c.split(" ")}if(a.isArray(c)){c={left:+c[0],top:+c[1]||0}}if("left" in c){this.offset.click.left=c.left+this.margins.left}if("right" in c){this.offset.click.left=this.helperProportions.width-c.right+this.margins.left}if("top" in c){this.offset.click.top=c.top+this.margins.top}if("bottom" in c){this.offset.click.top=this.helperProportions.height-c.bottom+this.margins.top}},_getParentOffset:function(){this.offsetParent=this.helper.offsetParent();var c=this.offsetParent.offset();if(this.cssPosition=="absolute"&&this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0])){c.left+=this.scrollParent.scrollLeft();c.top+=this.scrollParent.scrollTop()}if((this.offsetParent[0]==document.body)||(this.offsetParent[0].tagName&&this.offsetParent[0].tagName.toLowerCase()=="html"&&a.ui.ie)){c={top:0,left:0}}return{top:c.top+(parseInt(this.offsetParent.css("borderTopWidth"),10)||0),left:c.left+(parseInt(this.offsetParent.css("borderLeftWidth"),10)||0)}},_getRelativeOffset:function(){if(this.cssPosition=="relative"){var c=this.element.position();return{top:c.top-(parseInt(this.helper.css("top"),10)||0)+this.scrollParent.scrollTop(),left:c.left-(parseInt(this.helper.css("left"),10)||0)+this.scrollParent.scrollLeft()}}else{return{top:0,left:0}}},_cacheMargins:function(){this.margins={left:(parseInt(this.element.css("marginLeft"),10)||0),top:(parseInt(this.element.css("marginTop"),10)||0),right:(parseInt(this.element.css("marginRight"),10)||0),bottom:(parseInt(this.element.css("marginBottom"),10)||0)}},_cacheHelperProportions:function(){this.helperProportions={width:this.helper.outerWidth(),height:this.helper.outerHeight()}},_setContainment:function(){var g=this.options;if(g.containment=="parent"){g.containment=this.helper[0].parentNode}if(g.containment=="document"||g.containment=="window"){this.containment=[g.containment=="document"?0:a(window).scrollLeft()-this.offset.relative.left-this.offset.parent.left,g.containment=="document"?0:a(window).scrollTop()-this.offset.relative.top-this.offset.parent.top,(g.containment=="document"?0:a(window).scrollLeft())+a(g.containment=="document"?document:window).width()-this.helperProportions.width-this.margins.left,(g.containment=="document"?0:a(window).scrollTop())+(a(g.containment=="document"?document:window).height()||document.body.parentNode.scrollHeight)-this.helperProportions.height-this.margins.top]}if(!(/^(document|window|parent)$/).test(g.containment)&&g.containment.constructor!=Array){var d=a(g.containment);var e=d[0];if(!e){return}var f=d.offset();var h=(a(e).css("overflow")!="hidden");this.containment=[(parseInt(a(e).css("borderLeftWidth"),10)||0)+(parseInt(a(e).css("paddingLeft"),10)||0),(parseInt(a(e).css("borderTopWidth"),10)||0)+(parseInt(a(e).css("paddingTop"),10)||0),(h?Math.max(e.scrollWidth,e.offsetWidth):e.offsetWidth)-(parseInt(a(e).css("borderLeftWidth"),10)||0)-(parseInt(a(e).css("paddingRight"),10)||0)-this.helperProportions.width-this.margins.left-this.margins.right,(h?Math.max(e.scrollHeight,e.offsetHeight):e.offsetHeight)-(parseInt(a(e).css("borderTopWidth"),10)||0)-(parseInt(a(e).css("paddingBottom"),10)||0)-this.helperProportions.height-this.margins.top-this.margins.bottom];this.relative_container=d}else{if(g.containment.constructor==Array){this.containment=g.containment}}},_convertPositionTo:function(c,g){if(!g){g=this.position}var e=c=="absolute"?1:-1;var f=this.options,h=this.cssPosition=="absolute"&&!(this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,i=(/(html|body)/i).test(h[0].tagName);return{top:(g.top+this.offset.relative.top*e+this.offset.parent.top*e-((this.cssPosition=="fixed"?-this.scrollParent.scrollTop():(i?0:h.scrollTop()))*e)),left:(g.left+this.offset.relative.left*e+this.offset.parent.left*e-((this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():i?0:h.scrollLeft())*e))}},_generatePosition:function(e){var g=this.options,j=this.cssPosition=="absolute"&&!(this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,k=(/(html|body)/i).test(j[0].tagName);var h=e.pageX;var i=e.pageY;if(this.originalPosition){var d;if(this.containment){if(this.relative_container){var c=this.relative_container.offset();d=[this.containment[0]+c.left,this.containment[1]+c.top,this.containment[2]+c.left,this.containment[3]+c.top]}else{d=this.containment}if(e.pageX-this.offset.click.left<d[0]){h=d[0]+this.offset.click.left}if(e.pageY-this.offset.click.top<d[1]){i=d[1]+this.offset.click.top}if(e.pageX-this.offset.click.left>d[2]){h=d[2]+this.offset.click.left}if(e.pageY-this.offset.click.top>d[3]){i=d[3]+this.offset.click.top}}if(g.grid){var l=g.grid[1]?this.originalPageY+Math.round((i-this.originalPageY)/g.grid[1])*g.grid[1]:this.originalPageY;i=d?(!(l-this.offset.click.top<d[1]||l-this.offset.click.top>d[3])?l:(!(l-this.offset.click.top<d[1])?l-g.grid[1]:l+g.grid[1])):l;var f=g.grid[0]?this.originalPageX+Math.round((h-this.originalPageX)/g.grid[0])*g.grid[0]:this.originalPageX;h=d?(!(f-this.offset.click.left<d[0]||f-this.offset.click.left>d[2])?f:(!(f-this.offset.click.left<d[0])?f-g.grid[0]:f+g.grid[0])):f}}return{top:(i-this.offset.click.top-this.offset.relative.top-this.offset.parent.top+((this.cssPosition=="fixed"?-this.scrollParent.scrollTop():(k?0:j.scrollTop())))),left:(h-this.offset.click.left-this.offset.relative.left-this.offset.parent.left+((this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():k?0:j.scrollLeft())))}},_clear:function(){this.helper.removeClass("ui-draggable-dragging");if(this.helper[0]!=this.element[0]&&!this.cancelHelperRemoval){this.helper.remove()}this.helper=null;this.cancelHelperRemoval=false},_trigger:function(d,c,e){e=e||this._uiHash();a.ui.plugin.call(this,d,[c,e]);if(d=="drag"){this.positionAbs=this._convertPositionTo("absolute")}return a.Widget.prototype._trigger.call(this,d,c,e)},plugins:{},_uiHash:function(c){return{helper:this.helper,position:this.position,originalPosition:this.originalPosition,offset:this.positionAbs}}});a.ui.plugin.add("draggable","connectToSortable",{start:function(c,f){var d=a(this).data("draggable"),e=d.options,g=a.extend({},f,{item:d.element});d.sortables=[];a(e.connectToSortable).each(function(){var h=a.data(this,"sortable");if(h&&!h.options.disabled){d.sortables.push({instance:h,shouldRevert:h.options.revert});h.refreshPositions();h._trigger("activate",c,g)}})},stop:function(c,e){var d=a(this).data("draggable"),f=a.extend({},e,{item:d.element});a.each(d.sortables,function(){if(this.instance.isOver){this.instance.isOver=0;d.cancelHelperRemoval=true;this.instance.cancelHelperRemoval=false;if(this.shouldRevert){this.instance.options.revert=true}this.instance._mouseStop(c);this.instance.options.helper=this.instance.options._helper;if(d.options.helper=="original"){this.instance.currentItem.css({top:"auto",left:"auto"})}}else{this.instance.cancelHelperRemoval=false;this.instance._trigger("deactivate",c,f)}})},drag:function(d,g){var e=a(this).data("draggable"),f=this;var c=function(q){var i=this.offset.click.top,h=this.offset.click.left;var k=this.positionAbs.top,j=this.positionAbs.left;var l=q.height,p=q.width;var n=q.top,m=q.left;return a.ui.isOver(k+i,j+h,n,m,l,p)};a.each(e.sortables,function(h){var j=false;var k=this;this.instance.positionAbs=e.positionAbs;this.instance.helperProportions=e.helperProportions;this.instance.offset.click=e.offset.click;if(this.instance._intersectsWith(this.instance.containerCache)){j=true;a.each(e.sortables,function(){this.instance.positionAbs=e.positionAbs;this.instance.helperProportions=e.helperProportions;this.instance.offset.click=e.offset.click;if(this!=k&&this.instance._intersectsWith(this.instance.containerCache)&&a.ui.contains(k.instance.element[0],this.instance.element[0])){j=false}return j})}if(j){if(!this.instance.isOver){this.instance.isOver=1;this.instance.currentItem=a(f).clone().removeAttr("id").appendTo(this.instance.element).data("sortable-item",true);this.instance.options._helper=this.instance.options.helper;this.instance.options.helper=function(){return g.helper[0]};d.target=this.instance.currentItem[0];this.instance._mouseCapture(d,true);this.instance._mouseStart(d,true,true);this.instance.offset.click.top=e.offset.click.top;this.instance.offset.click.left=e.offset.click.left;this.instance.offset.parent.left-=e.offset.parent.left-this.instance.offset.parent.left;this.instance.offset.parent.top-=e.offset.parent.top-this.instance.offset.parent.top;e._trigger("toSortable",d);e.dropped=this.instance.element;e.currentItem=e.element;this.instance.fromOutside=e}if(this.instance.currentItem){this.instance._mouseDrag(d)}}else{if(this.instance.isOver){this.instance.isOver=0;this.instance.cancelHelperRemoval=true;this.instance.options.revert=false;this.instance._trigger("out",d,this.instance._uiHash(this.instance));this.instance._mouseStop(d,true);this.instance.options.helper=this.instance.options._helper;this.instance.currentItem.remove();if(this.instance.placeholder){this.instance.placeholder.remove()}e._trigger("fromSortable",d);e.dropped=false}}})}});a.ui.plugin.add("draggable","cursor",{start:function(c,f){var e=a("body"),d=a(this).data("draggable").options;if(e.css("cursor")){d._cursor=e.css("cursor")}e.css("cursor",d.cursor)},stop:function(c,e){var d=a(this).data("draggable").options;if(d._cursor){a("body").css("cursor",d._cursor)}}});a.ui.plugin.add("draggable","opacity",{start:function(c,f){var e=a(f.helper),d=a(this).data("draggable").options;if(e.css("opacity")){d._opacity=e.css("opacity")}e.css("opacity",d.opacity)},stop:function(c,e){var d=a(this).data("draggable").options;if(d._opacity){a(e.helper).css("opacity",d._opacity)}}});a.ui.plugin.add("draggable","scroll",{start:function(c,e){var d=a(this).data("draggable");if(d.scrollParent[0]!=document&&d.scrollParent[0].tagName!="HTML"){d.overflowOffset=d.scrollParent.offset()}},drag:function(c,g){var d=a(this).data("draggable"),e=d.options,f=false;if(d.scrollParent[0]!=document&&d.scrollParent[0].tagName!="HTML"){if(!e.axis||e.axis!="x"){if((d.overflowOffset.top+d.scrollParent[0].offsetHeight)-c.pageY<e.scrollSensitivity){d.scrollParent[0].scrollTop=f=d.scrollParent[0].scrollTop+e.scrollSpeed}else{if(c.pageY-d.overflowOffset.top<e.scrollSensitivity){d.scrollParent[0].scrollTop=f=d.scrollParent[0].scrollTop-e.scrollSpeed}}}if(!e.axis||e.axis!="y"){if((d.overflowOffset.left+d.scrollParent[0].offsetWidth)-c.pageX<e.scrollSensitivity){d.scrollParent[0].scrollLeft=f=d.scrollParent[0].scrollLeft+e.scrollSpeed}else{if(c.pageX-d.overflowOffset.left<e.scrollSensitivity){d.scrollParent[0].scrollLeft=f=d.scrollParent[0].scrollLeft-e.scrollSpeed}}}}else{if(!e.axis||e.axis!="x"){if(c.pageY-a(document).scrollTop()<e.scrollSensitivity){f=a(document).scrollTop(a(document).scrollTop()-e.scrollSpeed)}else{if(a(window).height()-(c.pageY-a(document).scrollTop())<e.scrollSensitivity){f=a(document).scrollTop(a(document).scrollTop()+e.scrollSpeed)}}}if(!e.axis||e.axis!="y"){if(c.pageX-a(document).scrollLeft()<e.scrollSensitivity){f=a(document).scrollLeft(a(document).scrollLeft()-e.scrollSpeed)}else{if(a(window).width()-(c.pageX-a(document).scrollLeft())<e.scrollSensitivity){f=a(document).scrollLeft(a(document).scrollLeft()+e.scrollSpeed)}}}}if(f!==false&&a.ui.ddmanager&&!e.dropBehaviour){a.ui.ddmanager.prepareOffsets(d,c)}}});a.ui.plugin.add("draggable","snap",{start:function(c,f){var d=a(this).data("draggable"),e=d.options;d.snapElements=[];a(e.snap.constructor!=String?(e.snap.items||":data(draggable)"):e.snap).each(function(){var h=a(this);var g=h.offset();if(this!=d.element[0]){d.snapElements.push({item:this,width:h.outerWidth(),height:h.outerHeight(),top:g.top,left:g.left})}})},drag:function(g,w){var k=a(this).data("draggable"),p=k.options;var f=p.snapTolerance;var x=w.offset.left,y=x+k.helperProportions.width,z=w.offset.top,A=z+k.helperProportions.height;for(var j=k.snapElements.length-1;j>=0;j--){var m=k.snapElements[j].left,q=m+k.snapElements[j].width,u=k.snapElements[j].top,c=u+k.snapElements[j].height;if(!((m-f<x&&x<q+f&&u-f<z&&z<c+f)||(m-f<x&&x<q+f&&u-f<A&&A<c+f)||(m-f<y&&y<q+f&&u-f<z&&z<c+f)||(m-f<y&&y<q+f&&u-f<A&&A<c+f))){if(k.snapElements[j].snapping){(k.options.snap.release&&k.options.snap.release.call(k.element,g,a.extend(k._uiHash(),{snapItem:k.snapElements[j].item})))}k.snapElements[j].snapping=false;continue}if(p.snapMode!="inner"){var v=Math.abs(u-A)<=f;var e=Math.abs(c-z)<=f;var n=Math.abs(m-y)<=f;var s=Math.abs(q-x)<=f;if(v){w.position.top=k._convertPositionTo("relative",{top:u-k.helperProportions.height,left:0}).top-k.margins.top}if(e){w.position.top=k._convertPositionTo("relative",{top:c,left:0}).top-k.margins.top}if(n){w.position.left=k._convertPositionTo("relative",{top:0,left:m-k.helperProportions.width}).left-k.margins.left}if(s){w.position.left=k._convertPositionTo("relative",{top:0,left:q}).left-k.margins.left}}var h=(v||e||n||s);if(p.snapMode!="outer"){var v=Math.abs(u-z)<=f;var e=Math.abs(c-A)<=f;var n=Math.abs(m-x)<=f;var s=Math.abs(q-y)<=f;if(v){w.position.top=k._convertPositionTo("relative",{top:u,left:0}).top-k.margins.top}if(e){w.position.top=k._convertPositionTo("relative",{top:c-k.helperProportions.height,left:0}).top-k.margins.top}if(n){w.position.left=k._convertPositionTo("relative",{top:0,left:m}).left-k.margins.left}if(s){w.position.left=k._convertPositionTo("relative",{top:0,left:q-k.helperProportions.width}).left-k.margins.left}}if(!k.snapElements[j].snapping&&(v||e||n||s||h)){(k.options.snap.snap&&k.options.snap.snap.call(k.element,g,a.extend(k._uiHash(),{snapItem:k.snapElements[j].item})))}k.snapElements[j].snapping=(v||e||n||s||h)}}});a.ui.plugin.add("draggable","stack",{start:function(c,g){var f=a(this).data("draggable").options;var d=a.makeArray(a(f.stack)).sort(function(h,i){return(parseInt(a(h).css("zIndex"),10)||0)-(parseInt(a(i).css("zIndex"),10)||0)});if(!d.length){return}var e=parseInt(d[0].style.zIndex)||0;a(d).each(function(h){this.style.zIndex=e+h});this[0].style.zIndex=e+d.length}});a.ui.plugin.add("draggable","zIndex",{start:function(c,f){var e=a(f.helper),d=a(this).data("draggable").options;if(e.css("zIndex")){d._zIndex=e.css("zIndex")}e.css("zIndex",d.zIndex)},stop:function(c,e){var d=a(this).data("draggable").options;if(d._zIndex){a(e.helper).css("zIndex",d._zIndex)}}})})(jQuery);(function(a,b){a.widget("ui.droppable",{version:"1.9.2",widgetEventPrefix:"drop",options:{accept:"*",activeClass:false,addClasses:true,greedy:false,hoverClass:false,scope:"default",tolerance:"intersect"},_create:function(){var d=this.options,c=d.accept;this.isover=0;this.isout=1;this.accept=a.isFunction(c)?c:function(e){return e.is(c)};this.proportions={width:this.element[0].offsetWidth,height:this.element[0].offsetHeight};a.ui.ddmanager.droppables[d.scope]=a.ui.ddmanager.droppables[d.scope]||[];a.ui.ddmanager.droppables[d.scope].push(this);(d.addClasses&&this.element.addClass("ui-droppable"))},_destroy:function(){var c=a.ui.ddmanager.droppables[this.options.scope];for(var d=0;d<c.length;d++){if(c[d]==this){c.splice(d,1)}}this.element.removeClass("ui-droppable ui-droppable-disabled")},_setOption:function(c,d){if(c=="accept"){this.accept=a.isFunction(d)?d:function(e){return e.is(d)}}a.Widget.prototype._setOption.apply(this,arguments)},_activate:function(d){var c=a.ui.ddmanager.current;if(this.options.activeClass){this.element.addClass(this.options.activeClass)}(c&&this._trigger("activate",d,this.ui(c)))},_deactivate:function(d){var c=a.ui.ddmanager.current;if(this.options.activeClass){this.element.removeClass(this.options.activeClass)}(c&&this._trigger("deactivate",d,this.ui(c)))},_over:function(d){var c=a.ui.ddmanager.current;if(!c||(c.currentItem||c.element)[0]==this.element[0]){return}if(this.accept.call(this.element[0],(c.currentItem||c.element))){if(this.options.hoverClass){this.element.addClass(this.options.hoverClass)}this._trigger("over",d,this.ui(c))}},_out:function(d){var c=a.ui.ddmanager.current;if(!c||(c.currentItem||c.element)[0]==this.element[0]){return}if(this.accept.call(this.element[0],(c.currentItem||c.element))){if(this.options.hoverClass){this.element.removeClass(this.options.hoverClass)}this._trigger("out",d,this.ui(c))}},_drop:function(f,d){var e=d||a.ui.ddmanager.current;if(!e||(e.currentItem||e.element)[0]==this.element[0]){return false}var c=false;this.element.find(":data(droppable)").not(".ui-draggable-dragging").each(function(){var g=a.data(this,"droppable");if(g.options.greedy&&!g.options.disabled&&g.options.scope==e.options.scope&&g.accept.call(g.element[0],(e.currentItem||e.element))&&a.ui.intersect(e,a.extend(g,{offset:g.element.offset()}),g.options.tolerance)){c=true;return false}});if(c){return false}if(this.accept.call(this.element[0],(e.currentItem||e.element))){if(this.options.activeClass){this.element.removeClass(this.options.activeClass)}if(this.options.hoverClass){this.element.removeClass(this.options.hoverClass)}this._trigger("drop",f,this.ui(e));return this.element}return false},ui:function(d){return{draggable:(d.currentItem||d.element),helper:d.helper,position:d.position,offset:d.positionAbs}}});a.ui.intersect=function(d,g,m){if(!g.offset){return false}var n=(d.positionAbs||d.position.absolute).left,o=n+d.helperProportions.width,p=(d.positionAbs||d.position.absolute).top,q=p+d.helperProportions.height;var i=g.offset.left,j=i+g.proportions.width,k=g.offset.top,c=k+g.proportions.height;switch(m){case"fit":return(i<=n&&o<=j&&k<=p&&q<=c);break;case"intersect":return(i<n+(d.helperProportions.width/2)&&o-(d.helperProportions.width/2)<j&&k<p+(d.helperProportions.height/2)&&q-(d.helperProportions.height/2)<c);break;case"pointer":var e=((d.positionAbs||d.position.absolute).left+(d.clickOffset||d.offset.click).left),f=((d.positionAbs||d.position.absolute).top+(d.clickOffset||d.offset.click).top),h=a.ui.isOver(f,e,k,i,g.proportions.height,g.proportions.width);return h;break;case"touch":return((p>=k&&p<=c)||(q>=k&&q<=c)||(p<k&&q>c))&&((n>=i&&n<=j)||(o>=i&&o<=j)||(n<i&&o>j));break;default:return false;break}};a.ui.ddmanager={current:null,droppables:{"default":[]},prepareOffsets:function(h,c){var g=a.ui.ddmanager.droppables[h.options.scope]||[];var k=c?c.type:null;var f=(h.currentItem||h.element).find(":data(droppable)").andSelf();droppablesLoop:for(var d=0;d<g.length;d++){if(g[d].options.disabled||(h&&!g[d].accept.call(g[d].element[0],(h.currentItem||h.element)))){continue}for(var e=0;e<f.length;e++){if(f[e]==g[d].element[0]){g[d].proportions.height=0;continue droppablesLoop}}g[d].visible=g[d].element.css("display")!="none";if(!g[d].visible){continue}if(k=="mousedown"){g[d]._activate.call(g[d],c)}g[d].offset=g[d].element.offset();g[d].proportions={width:g[d].element[0].offsetWidth,height:g[d].element[0].offsetHeight}}},drop:function(c,e){var d=false;a.each(a.ui.ddmanager.droppables[c.options.scope]||[],function(){if(!this.options){return}if(!this.options.disabled&&this.visible&&a.ui.intersect(c,this,this.options.tolerance)){d=this._drop.call(this,e)||d}if(!this.options.disabled&&this.visible&&this.accept.call(this.element[0],(c.currentItem||c.element))){this.isout=1;this.isover=0;this._deactivate.call(this,e)}});return d},dragStart:function(c,d){c.element.parentsUntil("body").bind("scroll.droppable",function(){if(!c.options.refreshPositions){a.ui.ddmanager.prepareOffsets(c,d)}})},drag:function(c,d){if(c.options.refreshPositions){a.ui.ddmanager.prepareOffsets(c,d)}a.each(a.ui.ddmanager.droppables[c.options.scope]||[],function(){if(this.options.disabled||this.greedyChild||!this.visible){return}var f=a.ui.intersect(c,this,this.options.tolerance);var e=!f&&this.isover==1?"isout":(f&&this.isover==0?"isover":null);if(!e){return}var h;if(this.options.greedy){var i=this.options.scope;var g=this.element.parents(":data(droppable)").filter(function(){return a.data(this,"droppable").options.scope===i});if(g.length){h=a.data(g[0],"droppable");h.greedyChild=(e=="isover"?1:0)}}if(h&&e=="isover"){h.isover=0;h.isout=1;h._out.call(h,d)}this[e]=1;this[e=="isout"?"isover":"isout"]=0;this[e=="isover"?"_over":"_out"].call(this,d);if(h&&e=="isout"){h.isout=0;h.isover=1;h._over.call(h,d)}})},dragStop:function(c,d){c.element.parentsUntil("body").unbind("scroll.droppable");if(!c.options.refreshPositions){a.ui.ddmanager.prepareOffsets(c,d)}}}})(jQuery);(function(a,d){a.widget("ui.resizable",a.ui.mouse,{version:"1.9.2",widgetEventPrefix:"resize",options:{alsoResize:false,animate:false,animateDuration:"slow",animateEasing:"swing",aspectRatio:false,autoHide:false,containment:false,ghost:false,grid:false,handles:"e,s,se",helper:false,maxHeight:null,maxWidth:null,minHeight:10,minWidth:10,zIndex:1000},_create:function(){var l=this,k=this.options;this.element.addClass("ui-resizable");a.extend(this,{_aspectRatio:!!(k.aspectRatio),aspectRatio:k.aspectRatio,originalElement:this.element,_proportionallyResizeElements:[],_helper:k.helper||k.ghost||k.animate?k.helper||"ui-resizable-helper":null});if(this.element[0].nodeName.match(/canvas|textarea|input|select|button|img/i)){this.element.wrap(a('<div class="ui-wrapper" style="overflow: hidden;"></div>').css({position:this.element.css("position"),width:this.element.outerWidth(),height:this.element.outerHeight(),top:this.element.css("top"),left:this.element.css("left")}));this.element=this.element.parent().data("resizable",this.element.data("resizable"));this.elementIsWrapper=true;this.element.css({marginLeft:this.originalElement.css("marginLeft"),marginTop:this.originalElement.css("marginTop"),marginRight:this.originalElement.css("marginRight"),marginBottom:this.originalElement.css("marginBottom")});this.originalElement.css({marginLeft:0,marginTop:0,marginRight:0,marginBottom:0});this.originalResizeStyle=this.originalElement.css("resize");this.originalElement.css("resize","none");this._proportionallyResizeElements.push(this.originalElement.css({position:"static",zoom:1,display:"block"}));this.originalElement.css({margin:this.originalElement.css("margin")});this._proportionallyResize()}this.handles=k.handles||(!a(".ui-resizable-handle",this.element).length?"e,s,se":{n:".ui-resizable-n",e:".ui-resizable-e",s:".ui-resizable-s",w:".ui-resizable-w",se:".ui-resizable-se",sw:".ui-resizable-sw",ne:".ui-resizable-ne",nw:".ui-resizable-nw"});if(this.handles.constructor==String){if(this.handles=="all"){this.handles="n,e,s,w,se,sw,ne,nw"}var j=this.handles.split(",");this.handles={};for(var h=0;h<j.length;h++){var f=a.trim(j[h]),g="ui-resizable-"+f;var e=a('<div class="ui-resizable-handle '+g+'"></div>');e.css({zIndex:k.zIndex});if("se"==f){e.addClass("ui-icon ui-icon-gripsmall-diagonal-se")}this.handles[f]=".ui-resizable-"+f;this.element.append(e)}}this._renderAxis=function(q){q=q||this.element;for(var n in this.handles){if(this.handles[n].constructor==String){this.handles[n]=a(this.handles[n],this.element).show()}if(this.elementIsWrapper&&this.originalElement[0].nodeName.match(/textarea|input|select|button/i)){var m=a(this.handles[n],this.element),p=0;p=/sw|ne|nw|se|n|s/.test(n)?m.outerHeight():m.outerWidth();var o=["padding",/ne|nw|n/.test(n)?"Top":/se|sw|s/.test(n)?"Bottom":/^e$/.test(n)?"Right":"Left"].join("");q.css(o,p);this._proportionallyResize()}if(!a(this.handles[n]).length){continue}}};this._renderAxis(this.element);this._handles=a(".ui-resizable-handle",this.element).disableSelection();this._handles.mouseover(function(){if(!l.resizing){if(this.className){var i=this.className.match(/ui-resizable-(se|sw|ne|nw|n|e|s|w)/i)}l.axis=i&&i[1]?i[1]:"se"}});if(k.autoHide){this._handles.hide();a(this.element).addClass("ui-resizable-autohide").mouseenter(function(){if(k.disabled){return}a(this).removeClass("ui-resizable-autohide");l._handles.show()}).mouseleave(function(){if(k.disabled){return}if(!l.resizing){a(this).addClass("ui-resizable-autohide");l._handles.hide()}})}this._mouseInit()},_destroy:function(){this._mouseDestroy();var e=function(g){a(g).removeClass("ui-resizable ui-resizable-disabled ui-resizable-resizing").removeData("resizable").removeData("ui-resizable").unbind(".resizable").find(".ui-resizable-handle").remove()};if(this.elementIsWrapper){e(this.element);var f=this.element;this.originalElement.css({position:f.css("position"),width:f.outerWidth(),height:f.outerHeight(),top:f.css("top"),left:f.css("left")}).insertAfter(f);f.remove()}this.originalElement.css("resize",this.originalResizeStyle);e(this.originalElement);return this},_mouseCapture:function(e){var f=false;for(var g in this.handles){if(a(this.handles[g])[0]==e.target){f=true}}return !this.options.disabled&&f},_mouseStart:function(i){var k=this.options,j=this.element.position(),h=this.element;this.resizing=true;this.documentScroll={top:a(document).scrollTop(),left:a(document).scrollLeft()};if(h.is(".ui-draggable")||(/absolute/).test(h.css("position"))){h.css({position:"absolute",top:j.top,left:j.left})}this._renderProxy();var e=c(this.helper.css("left")),g=c(this.helper.css("top"));if(k.containment){e+=a(k.containment).scrollLeft()||0;g+=a(k.containment).scrollTop()||0}this.offset=this.helper.offset();this.position={left:e,top:g};this.size=this._helper?{width:h.outerWidth(),height:h.outerHeight()}:{width:h.width(),height:h.height()};this.originalSize=this._helper?{width:h.outerWidth(),height:h.outerHeight()}:{width:h.width(),height:h.height()};this.originalPosition={left:e,top:g};this.sizeDiff={width:h.outerWidth()-h.width(),height:h.outerHeight()-h.height()};this.originalMousePosition={left:i.pageX,top:i.pageY};this.aspectRatio=(typeof k.aspectRatio=="number")?k.aspectRatio:((this.originalSize.width/this.originalSize.height)||1);var f=a(".ui-resizable-"+this.axis).css("cursor");a("body").css("cursor",f=="auto"?this.axis+"-resize":f);h.addClass("ui-resizable-resizing");this._propagate("start",i);return true},_mouseDrag:function(j){var i=this.helper,k=this.options,l={},n=this,m=this.originalMousePosition,e=this.axis;var g=(j.pageX-m.left)||0,h=(j.pageY-m.top)||0;var p=this._change[e];if(!p){return false}var f=p.apply(this,[j,g,h]);this._updateVirtualBoundaries(j.shiftKey);if(this._aspectRatio||j.shiftKey){f=this._updateRatio(f,j)}f=this._respectSize(f,j);this._propagate("resize",j);i.css({top:this.position.top+"px",left:this.position.left+"px",width:this.size.width+"px",height:this.size.height+"px"});if(!this._helper&&this._proportionallyResizeElements.length){this._proportionallyResize()}this._updateCache(f);this._trigger("resize",j,this.ui());return false},_mouseStop:function(e){this.resizing=false;var h=this.options,m=this;if(this._helper){var i=this._proportionallyResizeElements,f=i.length&&(/textarea/i).test(i[0].nodeName),k=f&&a.ui.hasScroll(i[0],"left")?0:m.sizeDiff.height,l=f?0:m.sizeDiff.width;var j={width:(m.helper.width()-l),height:(m.helper.height()-k)},g=(parseInt(m.element.css("left"),10)+(m.position.left-m.originalPosition.left))||null,n=(parseInt(m.element.css("top"),10)+(m.position.top-m.originalPosition.top))||null;if(!h.animate){this.element.css(a.extend(j,{top:n,left:g}))}m.helper.height(m.size.height);m.helper.width(m.size.width);if(this._helper&&!h.animate){this._proportionallyResize()}}a("body").css("cursor","auto");this.element.removeClass("ui-resizable-resizing");this._propagate("stop",e);if(this._helper){this.helper.remove()}return false},_updateVirtualBoundaries:function(f){var g=this.options,k,i,j,h,e;e={minWidth:b(g.minWidth)?g.minWidth:0,maxWidth:b(g.maxWidth)?g.maxWidth:Infinity,minHeight:b(g.minHeight)?g.minHeight:0,maxHeight:b(g.maxHeight)?g.maxHeight:Infinity};if(this._aspectRatio||f){k=e.minHeight*this.aspectRatio;j=e.minWidth/this.aspectRatio;i=e.maxHeight*this.aspectRatio;h=e.maxWidth/this.aspectRatio;if(k>e.minWidth){e.minWidth=k}if(j>e.minHeight){e.minHeight=j}if(i<e.maxWidth){e.maxWidth=i}if(h<e.maxHeight){e.maxHeight=h}}this._vBoundaries=e},_updateCache:function(e){var f=this.options;this.offset=this.helper.offset();if(b(e.left)){this.position.left=e.left}if(b(e.top)){this.position.top=e.top}if(b(e.height)){this.size.height=e.height}if(b(e.width)){this.size.width=e.width}},_updateRatio:function(h,i){var j=this.options,f=this.position,g=this.size,e=this.axis;if(b(h.height)){h.width=(h.height*this.aspectRatio)}else{if(b(h.width)){h.height=(h.width/this.aspectRatio)}}if(e=="sw"){h.left=f.left+(g.width-h.width);h.top=null}if(e=="nw"){h.top=f.top+(g.height-h.height);h.left=f.left+(g.width-h.width)}return h},_respectSize:function(h,l){var k=this.helper,s=this._vBoundaries,t=this._aspectRatio||l.shiftKey,e=this.axis,n=b(h.width)&&s.maxWidth&&(s.maxWidth<h.width),m=b(h.height)&&s.maxHeight&&(s.maxHeight<h.height),q=b(h.width)&&s.minWidth&&(s.minWidth>h.width),p=b(h.height)&&s.minHeight&&(s.minHeight>h.height);if(q){h.width=s.minWidth}if(p){h.height=s.minHeight}if(n){h.width=s.maxWidth}if(m){h.height=s.maxHeight}var j=this.originalPosition.left+this.originalSize.width,i=this.position.top+this.size.height;var g=/sw|nw|w/.test(e),f=/nw|ne|n/.test(e);if(q&&g){h.left=j-s.minWidth}if(n&&g){h.left=j-s.maxWidth}if(p&&f){h.top=i-s.minHeight}if(m&&f){h.top=i-s.maxHeight}var r=!h.width&&!h.height;if(r&&!h.left&&h.top){h.top=null}else{if(r&&!h.top&&h.left){h.left=null}}return h},_proportionallyResize:function(){var h=this.options;if(!this._proportionallyResizeElements.length){return}var f=this.helper||this.element;for(var g=0;g<this._proportionallyResizeElements.length;g++){var k=this._proportionallyResizeElements[g];if(!this.borderDif){var e=[k.css("borderTopWidth"),k.css("borderRightWidth"),k.css("borderBottomWidth"),k.css("borderLeftWidth")],j=[k.css("paddingTop"),k.css("paddingRight"),k.css("paddingBottom"),k.css("paddingLeft")];this.borderDif=a.map(e,function(o,m){var l=parseInt(o,10)||0,n=parseInt(j[m],10)||0;return l+n})}k.css({height:(f.height()-this.borderDif[0]-this.borderDif[2])||0,width:(f.width()-this.borderDif[1]-this.borderDif[3])||0})}},_renderProxy:function(){var e=this.element,g=this.options;this.elementOffset=e.offset();if(this._helper){this.helper=this.helper||a('<div style="overflow:hidden;"></div>');var f=(a.ui.ie6?1:0),h=(a.ui.ie6?2:-1);this.helper.addClass(this._helper).css({width:this.element.outerWidth()+h,height:this.element.outerHeight()+h,position:"absolute",left:this.elementOffset.left-f+"px",top:this.elementOffset.top-f+"px",zIndex:++g.zIndex});this.helper.appendTo("body").disableSelection()}else{this.helper=this.element}},_change:{e:function(g,e,f){return{width:this.originalSize.width+e}},w:function(h,f,g){var i=this.options,e=this.originalSize,j=this.originalPosition;return{left:j.left+f,width:e.width-f}},n:function(h,f,g){var i=this.options,e=this.originalSize,j=this.originalPosition;return{top:j.top+g,height:e.height-g}},s:function(g,e,f){return{height:this.originalSize.height+f}},se:function(g,e,f){return a.extend(this._change.s.apply(this,arguments),this._change.e.apply(this,[g,e,f]))},sw:function(g,e,f){return a.extend(this._change.s.apply(this,arguments),this._change.w.apply(this,[g,e,f]))},ne:function(g,e,f){return a.extend(this._change.n.apply(this,arguments),this._change.e.apply(this,[g,e,f]))},nw:function(g,e,f){return a.extend(this._change.n.apply(this,arguments),this._change.w.apply(this,[g,e,f]))}},_propagate:function(f,e){a.ui.plugin.call(this,f,[e,this.ui()]);(f!="resize"&&this._trigger(f,e,this.ui()))},plugins:{},ui:function(){return{originalElement:this.originalElement,element:this.element,helper:this.helper,position:this.position,size:this.size,originalSize:this.originalSize,originalPosition:this.originalPosition}}});a.ui.plugin.add("resizable","alsoResize",{start:function(f,i){var h=a(this).data("resizable"),g=h.options;var e=function(j){a(j).each(function(){var k=a(this);k.data("resizable-alsoresize",{width:parseInt(k.width(),10),height:parseInt(k.height(),10),left:parseInt(k.css("left"),10),top:parseInt(k.css("top"),10)})})};if(typeof(g.alsoResize)=="object"&&!g.alsoResize.parentNode){if(g.alsoResize.length){g.alsoResize=g.alsoResize[0];e(g.alsoResize)}else{a.each(g.alsoResize,function(j){e(j)})}}else{e(g.alsoResize)}},resize:function(g,l){var k=a(this).data("resizable"),h=k.options,j=k.originalSize,i=k.originalPosition;var f={height:(k.size.height-j.height)||0,width:(k.size.width-j.width)||0,top:(k.position.top-i.top)||0,left:(k.position.left-i.left)||0},e=function(n,m){a(n).each(function(){var p=a(this),q=a(this).data("resizable-alsoresize"),r={},o=m&&m.length?m:p.parents(l.originalElement[0]).length?["width","height"]:["width","height","top","left"];a.each(o,function(s,t){var u=(q[t]||0)+(f[t]||0);if(u&&u>=0){r[t]=u||null}});p.css(r)})};if(typeof(h.alsoResize)=="object"&&!h.alsoResize.nodeType){a.each(h.alsoResize,function(n,m){e(n,m)})}else{e(h.alsoResize)}},stop:function(e,f){a(this).removeData("resizable-alsoresize")}});a.ui.plugin.add("resizable","animate",{stop:function(e,p){var m=a(this).data("resizable"),h=m.options;var i=m._proportionallyResizeElements,f=i.length&&(/textarea/i).test(i[0].nodeName),j=f&&a.ui.hasScroll(i[0],"left")?0:m.sizeDiff.height,k=f?0:m.sizeDiff.width;var l={width:(m.size.width-k),height:(m.size.height-j)},g=(parseInt(m.element.css("left"),10)+(m.position.left-m.originalPosition.left))||null,n=(parseInt(m.element.css("top"),10)+(m.position.top-m.originalPosition.top))||null;m.element.animate(a.extend(l,n&&g?{top:n,left:g}:{}),{duration:h.animateDuration,easing:h.animateEasing,step:function(){var o={width:parseInt(m.element.css("width"),10),height:parseInt(m.element.css("height"),10),top:parseInt(m.element.css("top"),10),left:parseInt(m.element.css("left"),10)};if(i&&i.length){a(i[0]).css({width:o.width,height:o.height})}m._updateCache(o);m._propagate("resize",e)}})}});a.ui.plugin.add("resizable","containment",{start:function(k,s){var r=a(this).data("resizable"),m=r.options,i=r.element;var n=m.containment,e=(n instanceof a)?n.get(0):(/parent/.test(n))?i.parent().get(0):n;if(!e){return}r.containerElement=a(e);if(/document/.test(n)||n==document){r.containerOffset={left:0,top:0};r.containerPosition={left:0,top:0};r.parentData={element:a(document),left:0,top:0,width:a(document).width(),height:a(document).height()||document.body.parentNode.scrollHeight}}else{var j=a(e),q=[];a(["Top","Right","Left","Bottom"]).each(function(o,p){q[o]=c(j.css("padding"+p))});r.containerOffset=j.offset();r.containerPosition=j.position();r.containerSize={height:(j.innerHeight()-q[3]),width:(j.innerWidth()-q[1])};var g=r.containerOffset,f=r.containerSize.height,h=r.containerSize.width,t=(a.ui.hasScroll(e,"left")?e.scrollWidth:h),l=(a.ui.hasScroll(e)?e.scrollHeight:f);r.parentData={element:e,left:g.left,top:g.top,width:t,height:l}}},resize:function(j,s){var r=a(this).data("resizable"),n=r.options,q=r.containerSize,f=r.containerOffset,i=r.size,h=r.position,p=r._aspectRatio||j.shiftKey,g={top:0,left:0},e=r.containerElement;if(e[0]!=document&&(/static/).test(e.css("position"))){g=f}if(h.left<(r._helper?f.left:0)){r.size.width=r.size.width+(r._helper?(r.position.left-f.left):(r.position.left-g.left));if(p){r.size.height=r.size.width/r.aspectRatio}r.position.left=n.helper?f.left:0}if(h.top<(r._helper?f.top:0)){r.size.height=r.size.height+(r._helper?(r.position.top-f.top):r.position.top);if(p){r.size.width=r.size.height*r.aspectRatio}r.position.top=r._helper?f.top:0}r.offset.left=r.parentData.left+r.position.left;r.offset.top=r.parentData.top+r.position.top;var t=Math.abs((r._helper?r.offset.left-g.left:(r.offset.left-g.left))+r.sizeDiff.width),k=Math.abs((r._helper?r.offset.top-g.top:(r.offset.top-f.top))+r.sizeDiff.height);var m=r.containerElement.get(0)==r.element.parent().get(0),l=/relative|absolute/.test(r.containerElement.css("position"));if(m&&l){t-=r.parentData.left}if(t+r.size.width>=r.parentData.width){r.size.width=r.parentData.width-t;if(p){r.size.height=r.size.width/r.aspectRatio}}if(k+r.size.height>=r.parentData.height){r.size.height=r.parentData.height-k;if(p){r.size.width=r.size.height*r.aspectRatio}}},stop:function(j,q){var p=a(this).data("resizable"),n=p.options,i=p.position,f=p.containerOffset,g=p.containerPosition,e=p.containerElement;var l=a(p.helper),m=l.offset(),r=l.outerWidth()-p.sizeDiff.width,k=l.outerHeight()-p.sizeDiff.height;if(p._helper&&!n.animate&&(/relative/).test(e.css("position"))){a(this).css({left:m.left-g.left-f.left,width:r,height:k})}if(p._helper&&!n.animate&&(/static/).test(e.css("position"))){a(this).css({left:m.left-g.left-f.left,width:r,height:k})}}});a.ui.plugin.add("resizable","ghost",{start:function(f,i){var h=a(this).data("resizable"),g=h.options,e=h.size;h.ghost=h.originalElement.clone();h.ghost.css({opacity:0.25,display:"block",position:"relative",height:e.height,width:e.width,margin:0,left:0,top:0}).addClass("ui-resizable-ghost").addClass(typeof g.ghost=="string"?g.ghost:"");h.ghost.appendTo(h.helper)},resize:function(e,h){var g=a(this).data("resizable"),f=g.options;if(g.ghost){g.ghost.css({position:"relative",height:g.size.height,width:g.size.width})}},stop:function(e,h){var g=a(this).data("resizable"),f=g.options;if(g.ghost&&g.helper){g.helper.get(0).removeChild(g.ghost.get(0))}}});a.ui.plugin.add("resizable","grid",{resize:function(g,p){var n=a(this).data("resizable"),h=n.options,f=n.size,j=n.originalSize,i=n.originalPosition,e=n.axis,m=h._aspectRatio||g.shiftKey;h.grid=typeof h.grid=="number"?[h.grid,h.grid]:h.grid;var k=Math.round((f.width-j.width)/(h.grid[0]||1))*(h.grid[0]||1),l=Math.round((f.height-j.height)/(h.grid[1]||1))*(h.grid[1]||1);if(/^(se|s|e)$/.test(e)){n.size.width=j.width+k;n.size.height=j.height+l}else{if(/^(ne)$/.test(e)){n.size.width=j.width+k;n.size.height=j.height+l;n.position.top=i.top-l}else{if(/^(sw)$/.test(e)){n.size.width=j.width+k;n.size.height=j.height+l;n.position.left=i.left-k}else{n.size.width=j.width+k;n.size.height=j.height+l;n.position.top=i.top-l;n.position.left=i.left-k}}}}});var c=function(e){return parseInt(e,10)||0};var b=function(e){return !isNaN(parseInt(e,10))}})(jQuery);(function(a,b){a.widget("ui.selectable",a.ui.mouse,{version:"1.9.2",options:{appendTo:"body",autoRefresh:true,distance:0,filter:"*",tolerance:"touch"},_create:function(){var d=this;this.element.addClass("ui-selectable");this.dragged=false;var c;this.refresh=function(){c=a(d.options.filter,d.element[0]);c.addClass("ui-selectee");c.each(function(){var e=a(this);var f=e.offset();a.data(this,"selectable-item",{element:this,$element:e,left:f.left,top:f.top,right:f.left+e.outerWidth(),bottom:f.top+e.outerHeight(),startselected:false,selected:e.hasClass("ui-selected"),selecting:e.hasClass("ui-selecting"),unselecting:e.hasClass("ui-unselecting")})})};this.refresh();this.selectees=c.addClass("ui-selectee");this._mouseInit();this.helper=a("<div class='ui-selectable-helper'></div>")},_destroy:function(){this.selectees.removeClass("ui-selectee").removeData("selectable-item");this.element.removeClass("ui-selectable ui-selectable-disabled");this._mouseDestroy()},_mouseStart:function(c){var e=this;this.opos=[c.pageX,c.pageY];if(this.options.disabled){return}var d=this.options;this.selectees=a(d.filter,this.element[0]);this._trigger("start",c);a(d.appendTo).append(this.helper);this.helper.css({left:c.clientX,top:c.clientY,width:0,height:0});if(d.autoRefresh){this.refresh()}this.selectees.filter(".ui-selected").each(function(){var f=a.data(this,"selectable-item");f.startselected=true;if(!c.metaKey&&!c.ctrlKey){f.$element.removeClass("ui-selected");f.selected=false;f.$element.addClass("ui-unselecting");f.unselecting=true;e._trigger("unselecting",c,{unselecting:f.element})}});a(c.target).parents().andSelf().each(function(){var g=a.data(this,"selectable-item");if(g){var f=(!c.metaKey&&!c.ctrlKey)||!g.$element.hasClass("ui-selected");g.$element.removeClass(f?"ui-unselecting":"ui-selected").addClass(f?"ui-selecting":"ui-unselecting");g.unselecting=!f;g.selecting=f;g.selected=f;if(f){e._trigger("selecting",c,{selecting:g.element})}else{e._trigger("unselecting",c,{unselecting:g.element})}return false}})},_mouseDrag:function(c){var e=this;this.dragged=true;if(this.options.disabled){return}var d=this.options;var g=this.opos[0],i=this.opos[1],h=c.pageX,j=c.pageY;if(g>h){var f=h;h=g;g=f}if(i>j){var f=j;j=i;i=f}this.helper.css({left:g,top:i,width:h-g,height:j-i});this.selectees.each(function(){var l=a.data(this,"selectable-item");if(!l||l.element==e.element[0]){return}var k=false;if(d.tolerance=="touch"){k=(!(l.left>h||l.right<g||l.top>j||l.bottom<i))}else{if(d.tolerance=="fit"){k=(l.left>g&&l.right<h&&l.top>i&&l.bottom<j)}}if(k){if(l.selected){l.$element.removeClass("ui-selected");l.selected=false}if(l.unselecting){l.$element.removeClass("ui-unselecting");l.unselecting=false}if(!l.selecting){l.$element.addClass("ui-selecting");l.selecting=true;e._trigger("selecting",c,{selecting:l.element})}}else{if(l.selecting){if((c.metaKey||c.ctrlKey)&&l.startselected){l.$element.removeClass("ui-selecting");l.selecting=false;l.$element.addClass("ui-selected");l.selected=true}else{l.$element.removeClass("ui-selecting");l.selecting=false;if(l.startselected){l.$element.addClass("ui-unselecting");l.unselecting=true}e._trigger("unselecting",c,{unselecting:l.element})}}if(l.selected){if(!c.metaKey&&!c.ctrlKey&&!l.startselected){l.$element.removeClass("ui-selected");l.selected=false;l.$element.addClass("ui-unselecting");l.unselecting=true;e._trigger("unselecting",c,{unselecting:l.element})}}}});return false},_mouseStop:function(c){var e=this;this.dragged=false;var d=this.options;a(".ui-unselecting",this.element[0]).each(function(){var f=a.data(this,"selectable-item");f.$element.removeClass("ui-unselecting");f.unselecting=false;f.startselected=false;e._trigger("unselected",c,{unselected:f.element})});a(".ui-selecting",this.element[0]).each(function(){var f=a.data(this,"selectable-item");f.$element.removeClass("ui-selecting").addClass("ui-selected");f.selecting=false;f.selected=true;f.startselected=true;e._trigger("selected",c,{selected:f.element})});this._trigger("stop",c);this.helper.remove();return false}})})(jQuery);(function(a,b){a.widget("ui.sortable",a.ui.mouse,{version:"1.9.2",widgetEventPrefix:"sort",ready:false,options:{appendTo:"parent",axis:false,connectWith:false,containment:false,cursor:"auto",cursorAt:false,dropOnEmpty:true,forcePlaceholderSize:false,forceHelperSize:false,grid:false,handle:false,helper:"original",items:"> *",opacity:false,placeholder:false,revert:false,scroll:true,scrollSensitivity:20,scrollSpeed:20,scope:"default",tolerance:"intersect",zIndex:1000},_create:function(){var c=this.options;this.containerCache={};this.element.addClass("ui-sortable");this.refresh();this.floating=this.items.length?c.axis==="x"||(/left|right/).test(this.items[0].item.css("float"))||(/inline|table-cell/).test(this.items[0].item.css("display")):false;this.offset=this.element.offset();this._mouseInit();this.ready=true},_destroy:function(){this.element.removeClass("ui-sortable ui-sortable-disabled");this._mouseDestroy();for(var c=this.items.length-1;c>=0;c--){this.items[c].item.removeData(this.widgetName+"-item")}return this},_setOption:function(c,d){if(c==="disabled"){this.options[c]=d;this.widget().toggleClass("ui-sortable-disabled",!!d)}else{a.Widget.prototype._setOption.apply(this,arguments)}},_mouseCapture:function(d,f){var g=this;if(this.reverting){return false}if(this.options.disabled||this.options.type=="static"){return false}this._refreshItems(d);var c=null,e=a(d.target).parents().each(function(){if(a.data(this,g.widgetName+"-item")==g){c=a(this);return false}});if(a.data(d.target,g.widgetName+"-item")==g){c=a(d.target)}if(!c){return false}if(this.options.handle&&!f){var h=false;a(this.options.handle,c).find("*").andSelf().each(function(){if(this==d.target){h=true}});if(!h){return false}}this.currentItem=c;this._removeCurrentsFromItems();return true},_mouseStart:function(c,g,e){var f=this.options;this.currentContainer=this;this.refreshPositions();this.helper=this._createHelper(c);this._cacheHelperProportions();this._cacheMargins();this.scrollParent=this.helper.scrollParent();this.offset=this.currentItem.offset();this.offset={top:this.offset.top-this.margins.top,left:this.offset.left-this.margins.left};a.extend(this.offset,{click:{left:c.pageX-this.offset.left,top:c.pageY-this.offset.top},parent:this._getParentOffset(),relative:this._getRelativeOffset()});this.helper.css("position","absolute");this.cssPosition=this.helper.css("position");this.originalPosition=this._generatePosition(c);this.originalPageX=c.pageX;this.originalPageY=c.pageY;(f.cursorAt&&this._adjustOffsetFromHelper(f.cursorAt));this.domPosition={prev:this.currentItem.prev()[0],parent:this.currentItem.parent()[0]};if(this.helper[0]!=this.currentItem[0]){this.currentItem.hide()}this._createPlaceholder();if(f.containment){this._setContainment()}if(f.cursor){if(a("body").css("cursor")){this._storedCursor=a("body").css("cursor")}a("body").css("cursor",f.cursor)}if(f.opacity){if(this.helper.css("opacity")){this._storedOpacity=this.helper.css("opacity")}this.helper.css("opacity",f.opacity)}if(f.zIndex){if(this.helper.css("zIndex")){this._storedZIndex=this.helper.css("zIndex")}this.helper.css("zIndex",f.zIndex)}if(this.scrollParent[0]!=document&&this.scrollParent[0].tagName!="HTML"){this.overflowOffset=this.scrollParent.offset()}this._trigger("start",c,this._uiHash());if(!this._preserveHelperProportions){this._cacheHelperProportions()}if(!e){for(var d=this.containers.length-1;d>=0;d--){this.containers[d]._trigger("activate",c,this._uiHash(this))}}if(a.ui.ddmanager){a.ui.ddmanager.current=this}if(a.ui.ddmanager&&!f.dropBehaviour){a.ui.ddmanager.prepareOffsets(this,c)}this.dragging=true;this.helper.addClass("ui-sortable-helper");this._mouseDrag(c);return true},_mouseDrag:function(c){this.position=this._generatePosition(c);this.positionAbs=this._convertPositionTo("absolute");if(!this.lastPositionAbs){this.lastPositionAbs=this.positionAbs}if(this.options.scroll){var h=this.options,j=false;if(this.scrollParent[0]!=document&&this.scrollParent[0].tagName!="HTML"){if((this.overflowOffset.top+this.scrollParent[0].offsetHeight)-c.pageY<h.scrollSensitivity){this.scrollParent[0].scrollTop=j=this.scrollParent[0].scrollTop+h.scrollSpeed}else{if(c.pageY-this.overflowOffset.top<h.scrollSensitivity){this.scrollParent[0].scrollTop=j=this.scrollParent[0].scrollTop-h.scrollSpeed}}if((this.overflowOffset.left+this.scrollParent[0].offsetWidth)-c.pageX<h.scrollSensitivity){this.scrollParent[0].scrollLeft=j=this.scrollParent[0].scrollLeft+h.scrollSpeed}else{if(c.pageX-this.overflowOffset.left<h.scrollSensitivity){this.scrollParent[0].scrollLeft=j=this.scrollParent[0].scrollLeft-h.scrollSpeed}}}else{if(c.pageY-a(document).scrollTop()<h.scrollSensitivity){j=a(document).scrollTop(a(document).scrollTop()-h.scrollSpeed)}else{if(a(window).height()-(c.pageY-a(document).scrollTop())<h.scrollSensitivity){j=a(document).scrollTop(a(document).scrollTop()+h.scrollSpeed)}}if(c.pageX-a(document).scrollLeft()<h.scrollSensitivity){j=a(document).scrollLeft(a(document).scrollLeft()-h.scrollSpeed)}else{if(a(window).width()-(c.pageX-a(document).scrollLeft())<h.scrollSensitivity){j=a(document).scrollLeft(a(document).scrollLeft()+h.scrollSpeed)}}}if(j!==false&&a.ui.ddmanager&&!h.dropBehaviour){a.ui.ddmanager.prepareOffsets(this,c)}}this.positionAbs=this._convertPositionTo("absolute");if(!this.options.axis||this.options.axis!="y"){this.helper[0].style.left=this.position.left+"px"}if(!this.options.axis||this.options.axis!="x"){this.helper[0].style.top=this.position.top+"px"}for(var d=this.items.length-1;d>=0;d--){var f=this.items[d],g=f.item[0],e=this._intersectsWithPointer(f);if(!e){continue}if(f.instance!==this.currentContainer){continue}if(g!=this.currentItem[0]&&this.placeholder[e==1?"next":"prev"]()[0]!=g&&!a.contains(this.placeholder[0],g)&&(this.options.type=="semi-dynamic"?!a.contains(this.element[0],g):true)){this.direction=e==1?"down":"up";if(this.options.tolerance=="pointer"||this._intersectsWithSides(f)){this._rearrange(c,f)}else{break}this._trigger("change",c,this._uiHash());break}}this._contactContainers(c);if(a.ui.ddmanager){a.ui.ddmanager.drag(this,c)}this._trigger("sort",c,this._uiHash());this.lastPositionAbs=this.positionAbs;return false},_mouseStop:function(d,e){if(!d){return}if(a.ui.ddmanager&&!this.options.dropBehaviour){a.ui.ddmanager.drop(this,d)}if(this.options.revert){var f=this;var c=this.placeholder.offset();this.reverting=true;a(this.helper).animate({left:c.left-this.offset.parent.left-this.margins.left+(this.offsetParent[0]==document.body?0:this.offsetParent[0].scrollLeft),top:c.top-this.offset.parent.top-this.margins.top+(this.offsetParent[0]==document.body?0:this.offsetParent[0].scrollTop)},parseInt(this.options.revert,10)||500,function(){f._clear(d)})}else{this._clear(d,e)}return false},cancel:function(){if(this.dragging){this._mouseUp({target:null});if(this.options.helper=="original"){this.currentItem.css(this._storedCSS).removeClass("ui-sortable-helper")}else{this.currentItem.show()}for(var c=this.containers.length-1;c>=0;c--){this.containers[c]._trigger("deactivate",null,this._uiHash(this));if(this.containers[c].containerCache.over){this.containers[c]._trigger("out",null,this._uiHash(this));this.containers[c].containerCache.over=0}}}if(this.placeholder){if(this.placeholder[0].parentNode){this.placeholder[0].parentNode.removeChild(this.placeholder[0])}if(this.options.helper!="original"&&this.helper&&this.helper[0].parentNode){this.helper.remove()}a.extend(this,{helper:null,dragging:false,reverting:false,_noFinalSort:null});if(this.domPosition.prev){a(this.domPosition.prev).after(this.currentItem)}else{a(this.domPosition.parent).prepend(this.currentItem)}}return this},serialize:function(d){var c=this._getItemsAsjQuery(d&&d.connected);var e=[];d=d||{};a(c).each(function(){var f=(a(d.item||this).attr(d.attribute||"id")||"").match(d.expression||(/(.+)[-=_](.+)/));if(f){e.push((d.key||f[1]+"[]")+"="+(d.key&&d.expression?f[1]:f[2]))}});if(!e.length&&d.key){e.push(d.key+"=")}return e.join("&")},toArray:function(d){var c=this._getItemsAsjQuery(d&&d.connected);var e=[];d=d||{};c.each(function(){e.push(a(d.item||this).attr(d.attribute||"id")||"")});return e},_intersectsWith:function(g){var k=this.positionAbs.left,m=k+this.helperProportions.width,n=this.positionAbs.top,o=n+this.helperProportions.height;var h=g.left,i=h+g.width,j=g.top,c=j+g.height;var e=this.offset.click.top,d=this.offset.click.left;var f=(n+e)>j&&(n+e)<c&&(k+d)>h&&(k+d)<i;if(this.options.tolerance=="pointer"||this.options.forcePointerForContainers||(this.options.tolerance!="pointer"&&this.helperProportions[this.floating?"width":"height"]>g[this.floating?"width":"height"])){return f}else{return(h<k+(this.helperProportions.width/2)&&m-(this.helperProportions.width/2)<i&&j<n+(this.helperProportions.height/2)&&o-(this.helperProportions.height/2)<c)}},_intersectsWithPointer:function(g){var e=(this.options.axis==="x")||a.ui.isOverAxis(this.positionAbs.top+this.offset.click.top,g.top,g.height),f=(this.options.axis==="y")||a.ui.isOverAxis(this.positionAbs.left+this.offset.click.left,g.left,g.width),d=e&&f,h=this._getDragVerticalDirection(),c=this._getDragHorizontalDirection();if(!d){return false}return this.floating?(((c&&c=="right")||h=="down")?2:1):(h&&(h=="down"?2:1))},_intersectsWithSides:function(f){var d=a.ui.isOverAxis(this.positionAbs.top+this.offset.click.top,f.top+(f.height/2),f.height),e=a.ui.isOverAxis(this.positionAbs.left+this.offset.click.left,f.left+(f.width/2),f.width),g=this._getDragVerticalDirection(),c=this._getDragHorizontalDirection();if(this.floating&&c){return((c=="right"&&e)||(c=="left"&&!e))}else{return g&&((g=="down"&&d)||(g=="up"&&!d))}},_getDragVerticalDirection:function(){var c=this.positionAbs.top-this.lastPositionAbs.top;return c!=0&&(c>0?"down":"up")},_getDragHorizontalDirection:function(){var c=this.positionAbs.left-this.lastPositionAbs.left;return c!=0&&(c>0?"right":"left")},refresh:function(c){this._refreshItems(c);this.refreshPositions();return this},_connectWith:function(){var c=this.options;return c.connectWith.constructor==String?[c.connectWith]:c.connectWith},_getItemsAsjQuery:function(c){var h=[];var l=[];var d=this._connectWith();if(d&&c){for(var f=d.length-1;f>=0;f--){var e=a(d[f]);for(var k=e.length-1;k>=0;k--){var g=a.data(e[k],this.widgetName);if(g&&g!=this&&!g.options.disabled){l.push([a.isFunction(g.options.items)?g.options.items.call(g.element):a(g.options.items,g.element).not(".ui-sortable-helper").not(".ui-sortable-placeholder"),g])}}}}l.push([a.isFunction(this.options.items)?this.options.items.call(this.element,null,{options:this.options,item:this.currentItem}):a(this.options.items,this.element).not(".ui-sortable-helper").not(".ui-sortable-placeholder"),this]);for(var f=l.length-1;f>=0;f--){l[f][0].each(function(){h.push(this)})}return a(h)},_removeCurrentsFromItems:function(){var c=this.currentItem.find(":data("+this.widgetName+"-item)");this.items=a.grep(this.items,function(d){for(var e=0;e<c.length;e++){if(c[e]==d.item[0]){return false}}return true})},_refreshItems:function(f){this.items=[];this.containers=[this];var l=this.items;var n=[[a.isFunction(this.options.items)?this.options.items.call(this.element[0],f,{item:this.currentItem}):a(this.options.items,this.element),this]];var d=this._connectWith();if(d&&this.ready){for(var g=d.length-1;g>=0;g--){var e=a(d[g]);for(var m=e.length-1;m>=0;m--){var h=a.data(e[m],this.widgetName);if(h&&h!=this&&!h.options.disabled){n.push([a.isFunction(h.options.items)?h.options.items.call(h.element[0],f,{item:this.currentItem}):a(h.options.items,h.element),h]);this.containers.push(h)}}}}for(var g=n.length-1;g>=0;g--){var p=n[g][1];var c=n[g][0];for(var m=0,o=c.length;m<o;m++){var k=a(c[m]);k.data(this.widgetName+"-item",p);l.push({item:k,instance:p,width:0,height:0,left:0,top:0})}}},refreshPositions:function(c){if(this.offsetParent&&this.helper){this.offset.parent=this._getParentOffset()}for(var d=this.items.length-1;d>=0;d--){var e=this.items[d];if(e.instance!=this.currentContainer&&this.currentContainer&&e.item[0]!=this.currentItem[0]){continue}var g=this.options.toleranceElement?a(this.options.toleranceElement,e.item):e.item;if(!c){e.width=g.outerWidth();e.height=g.outerHeight()}var f=g.offset();e.left=f.left;e.top=f.top}if(this.options.custom&&this.options.custom.refreshContainers){this.options.custom.refreshContainers.call(this)}else{for(var d=this.containers.length-1;d>=0;d--){var f=this.containers[d].element.offset();this.containers[d].containerCache.left=f.left;this.containers[d].containerCache.top=f.top;this.containers[d].containerCache.width=this.containers[d].element.outerWidth();this.containers[d].containerCache.height=this.containers[d].element.outerHeight()}}return this},_createPlaceholder:function(e){e=e||this;var d=e.options;if(!d.placeholder||d.placeholder.constructor==String){var c=d.placeholder;d.placeholder={element:function(){var f=a(document.createElement(e.currentItem[0].nodeName)).addClass(c||e.currentItem[0].className+" ui-sortable-placeholder").removeClass("ui-sortable-helper")[0];if(!c){f.style.visibility="hidden"}return f},update:function(f,g){if(c&&!d.forcePlaceholderSize){return}if(!g.height()){g.height(e.currentItem.innerHeight()-parseInt(e.currentItem.css("paddingTop")||0,10)-parseInt(e.currentItem.css("paddingBottom")||0,10))}if(!g.width()){g.width(e.currentItem.innerWidth()-parseInt(e.currentItem.css("paddingLeft")||0,10)-parseInt(e.currentItem.css("paddingRight")||0,10))}}}}e.placeholder=a(d.placeholder.element.call(e.element,e.currentItem));e.currentItem.after(e.placeholder);d.placeholder.update(e,e.placeholder)},_contactContainers:function(f){var h=null,k=null;for(var g=this.containers.length-1;g>=0;g--){if(a.contains(this.currentItem[0],this.containers[g].element[0])){continue}if(this._intersectsWith(this.containers[g].containerCache)){if(h&&a.contains(this.containers[g].element[0],h.element[0])){continue}h=this.containers[g];k=g}else{if(this.containers[g].containerCache.over){this.containers[g]._trigger("out",f,this._uiHash(this));this.containers[g].containerCache.over=0}}}if(!h){return}if(this.containers.length===1){this.containers[k]._trigger("over",f,this._uiHash(this));this.containers[k].containerCache.over=1}else{var e=10000;var l=null;var o=this.containers[k].floating?"left":"top";var p=this.containers[k].floating?"width":"height";var c=this.positionAbs[o]+this.offset.click[o];for(var m=this.items.length-1;m>=0;m--){if(!a.contains(this.containers[k].element[0],this.items[m].item[0])){continue}if(this.items[m].item[0]==this.currentItem[0]){continue}var d=this.items[m].item.offset()[o];var n=false;if(Math.abs(d-c)>Math.abs(d+this.items[m][p]-c)){n=true;d+=this.items[m][p]}if(Math.abs(d-c)<e){e=Math.abs(d-c);l=this.items[m];this.direction=n?"up":"down"}}if(!l&&!this.options.dropOnEmpty){return}this.currentContainer=this.containers[k];l?this._rearrange(f,l,null,true):this._rearrange(f,null,this.containers[k].element,true);this._trigger("change",f,this._uiHash());this.containers[k]._trigger("change",f,this._uiHash(this));this.options.placeholder.update(this.currentContainer,this.placeholder);this.containers[k]._trigger("over",f,this._uiHash(this));this.containers[k].containerCache.over=1}},_createHelper:function(c){var e=this.options;var d=a.isFunction(e.helper)?a(e.helper.apply(this.element[0],[c,this.currentItem])):(e.helper=="clone"?this.currentItem.clone():this.currentItem);if(!d.parents("body").length){a(e.appendTo!="parent"?e.appendTo:this.currentItem[0].parentNode)[0].appendChild(d[0])}if(d[0]==this.currentItem[0]){this._storedCSS={width:this.currentItem[0].style.width,height:this.currentItem[0].style.height,position:this.currentItem.css("position"),top:this.currentItem.css("top"),left:this.currentItem.css("left")}}if(d[0].style.width==""||e.forceHelperSize){d.width(this.currentItem.width())}if(d[0].style.height==""||e.forceHelperSize){d.height(this.currentItem.height())}return d},_adjustOffsetFromHelper:function(c){if(typeof c=="string"){c=c.split(" ")}if(a.isArray(c)){c={left:+c[0],top:+c[1]||0}}if("left" in c){this.offset.click.left=c.left+this.margins.left}if("right" in c){this.offset.click.left=this.helperProportions.width-c.right+this.margins.left}if("top" in c){this.offset.click.top=c.top+this.margins.top}if("bottom" in c){this.offset.click.top=this.helperProportions.height-c.bottom+this.margins.top}},_getParentOffset:function(){this.offsetParent=this.helper.offsetParent();var c=this.offsetParent.offset();if(this.cssPosition=="absolute"&&this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0])){c.left+=this.scrollParent.scrollLeft();c.top+=this.scrollParent.scrollTop()}if((this.offsetParent[0]==document.body)||(this.offsetParent[0].tagName&&this.offsetParent[0].tagName.toLowerCase()=="html"&&a.ui.ie)){c={top:0,left:0}}return{top:c.top+(parseInt(this.offsetParent.css("borderTopWidth"),10)||0),left:c.left+(parseInt(this.offsetParent.css("borderLeftWidth"),10)||0)}},_getRelativeOffset:function(){if(this.cssPosition=="relative"){var c=this.currentItem.position();return{top:c.top-(parseInt(this.helper.css("top"),10)||0)+this.scrollParent.scrollTop(),left:c.left-(parseInt(this.helper.css("left"),10)||0)+this.scrollParent.scrollLeft()}}else{return{top:0,left:0}}},_cacheMargins:function(){this.margins={left:(parseInt(this.currentItem.css("marginLeft"),10)||0),top:(parseInt(this.currentItem.css("marginTop"),10)||0)}},_cacheHelperProportions:function(){this.helperProportions={width:this.helper.outerWidth(),height:this.helper.outerHeight()}},_setContainment:function(){var e=this.options;if(e.containment=="parent"){e.containment=this.helper[0].parentNode}if(e.containment=="document"||e.containment=="window"){this.containment=[0-this.offset.relative.left-this.offset.parent.left,0-this.offset.relative.top-this.offset.parent.top,a(e.containment=="document"?document:window).width()-this.helperProportions.width-this.margins.left,(a(e.containment=="document"?document:window).height()||document.body.parentNode.scrollHeight)-this.helperProportions.height-this.margins.top]}if(!(/^(document|window|parent)$/).test(e.containment)){var c=a(e.containment)[0];var d=a(e.containment).offset();var f=(a(c).css("overflow")!="hidden");this.containment=[d.left+(parseInt(a(c).css("borderLeftWidth"),10)||0)+(parseInt(a(c).css("paddingLeft"),10)||0)-this.margins.left,d.top+(parseInt(a(c).css("borderTopWidth"),10)||0)+(parseInt(a(c).css("paddingTop"),10)||0)-this.margins.top,d.left+(f?Math.max(c.scrollWidth,c.offsetWidth):c.offsetWidth)-(parseInt(a(c).css("borderLeftWidth"),10)||0)-(parseInt(a(c).css("paddingRight"),10)||0)-this.helperProportions.width-this.margins.left,d.top+(f?Math.max(c.scrollHeight,c.offsetHeight):c.offsetHeight)-(parseInt(a(c).css("borderTopWidth"),10)||0)-(parseInt(a(c).css("paddingBottom"),10)||0)-this.helperProportions.height-this.margins.top]}},_convertPositionTo:function(c,g){if(!g){g=this.position}var e=c=="absolute"?1:-1;var f=this.options,h=this.cssPosition=="absolute"&&!(this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,i=(/(html|body)/i).test(h[0].tagName);return{top:(g.top+this.offset.relative.top*e+this.offset.parent.top*e-((this.cssPosition=="fixed"?-this.scrollParent.scrollTop():(i?0:h.scrollTop()))*e)),left:(g.left+this.offset.relative.left*e+this.offset.parent.left*e-((this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():i?0:h.scrollLeft())*e))}},_generatePosition:function(c){var e=this.options,h=this.cssPosition=="absolute"&&!(this.scrollParent[0]!=document&&a.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,i=(/(html|body)/i).test(h[0].tagName);if(this.cssPosition=="relative"&&!(this.scrollParent[0]!=document&&this.scrollParent[0]!=this.offsetParent[0])){this.offset.relative=this._getRelativeOffset()}var f=c.pageX;var g=c.pageY;if(this.originalPosition){if(this.containment){if(c.pageX-this.offset.click.left<this.containment[0]){f=this.containment[0]+this.offset.click.left}if(c.pageY-this.offset.click.top<this.containment[1]){g=this.containment[1]+this.offset.click.top}if(c.pageX-this.offset.click.left>this.containment[2]){f=this.containment[2]+this.offset.click.left}if(c.pageY-this.offset.click.top>this.containment[3]){g=this.containment[3]+this.offset.click.top}}if(e.grid){var j=this.originalPageY+Math.round((g-this.originalPageY)/e.grid[1])*e.grid[1];g=this.containment?(!(j-this.offset.click.top<this.containment[1]||j-this.offset.click.top>this.containment[3])?j:(!(j-this.offset.click.top<this.containment[1])?j-e.grid[1]:j+e.grid[1])):j;var d=this.originalPageX+Math.round((f-this.originalPageX)/e.grid[0])*e.grid[0];f=this.containment?(!(d-this.offset.click.left<this.containment[0]||d-this.offset.click.left>this.containment[2])?d:(!(d-this.offset.click.left<this.containment[0])?d-e.grid[0]:d+e.grid[0])):d}}return{top:(g-this.offset.click.top-this.offset.relative.top-this.offset.parent.top+((this.cssPosition=="fixed"?-this.scrollParent.scrollTop():(i?0:h.scrollTop())))),left:(f-this.offset.click.left-this.offset.relative.left-this.offset.parent.left+((this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():i?0:h.scrollLeft())))}},_rearrange:function(e,g,c,f){c?c[0].appendChild(this.placeholder[0]):g.item[0].parentNode.insertBefore(this.placeholder[0],(this.direction=="down"?g.item[0]:g.item[0].nextSibling));this.counter=this.counter?++this.counter:1;var d=this.counter;this._delay(function(){if(d==this.counter){this.refreshPositions(!f)}})},_clear:function(d,f){this.reverting=false;var c=[];if(!this._noFinalSort&&this.currentItem.parent().length){this.placeholder.before(this.currentItem)}this._noFinalSort=null;if(this.helper[0]==this.currentItem[0]){for(var e in this._storedCSS){if(this._storedCSS[e]=="auto"||this._storedCSS[e]=="static"){this._storedCSS[e]=""}}this.currentItem.css(this._storedCSS).removeClass("ui-sortable-helper")}else{this.currentItem.show()}if(this.fromOutside&&!f){c.push(function(g){this._trigger("receive",g,this._uiHash(this.fromOutside))})}if((this.fromOutside||this.domPosition.prev!=this.currentItem.prev().not(".ui-sortable-helper")[0]||this.domPosition.parent!=this.currentItem.parent()[0])&&!f){c.push(function(g){this._trigger("update",g,this._uiHash())})}if(this!==this.currentContainer){if(!f){c.push(function(g){this._trigger("remove",g,this._uiHash())});c.push((function(g){return function(h){g._trigger("receive",h,this._uiHash(this))}}).call(this,this.currentContainer));c.push((function(g){return function(h){g._trigger("update",h,this._uiHash(this))}}).call(this,this.currentContainer))}}for(var e=this.containers.length-1;e>=0;e--){if(!f){c.push((function(g){return function(h){g._trigger("deactivate",h,this._uiHash(this))}}).call(this,this.containers[e]))}if(this.containers[e].containerCache.over){c.push((function(g){return function(h){g._trigger("out",h,this._uiHash(this))}}).call(this,this.containers[e]));this.containers[e].containerCache.over=0}}if(this._storedCursor){a("body").css("cursor",this._storedCursor)}if(this._storedOpacity){this.helper.css("opacity",this._storedOpacity)}if(this._storedZIndex){this.helper.css("zIndex",this._storedZIndex=="auto"?"":this._storedZIndex)}this.dragging=false;if(this.cancelHelperRemoval){if(!f){this._trigger("beforeStop",d,this._uiHash());for(var e=0;e<c.length;e++){c[e].call(this,d)}this._trigger("stop",d,this._uiHash())}this.fromOutside=false;return false}if(!f){this._trigger("beforeStop",d,this._uiHash())}this.placeholder[0].parentNode.removeChild(this.placeholder[0]);if(this.helper[0]!=this.currentItem[0]){this.helper.remove()}this.helper=null;if(!f){for(var e=0;e<c.length;e++){c[e].call(this,d)}this._trigger("stop",d,this._uiHash())}this.fromOutside=false;return true},_trigger:function(){if(a.Widget.prototype._trigger.apply(this,arguments)===false){this.cancel()}},_uiHash:function(c){var d=c||this;return{helper:d.helper,placeholder:d.placeholder||a([]),position:d.position,originalPosition:d.originalPosition,offset:d.positionAbs,item:d.currentItem,sender:c?c.element:null}}})})(jQuery);(function(a,e){var d=0,b={},c={};b.height=b.paddingTop=b.paddingBottom=b.borderTopWidth=b.borderBottomWidth="hide";c.height=c.paddingTop=c.paddingBottom=c.borderTopWidth=c.borderBottomWidth="show";a.widget("ui.accordion",{version:"1.9.2",options:{active:0,animate:{},collapsible:false,event:"click",header:"> li > :first-child,> :not(li):even",heightStyle:"auto",icons:{activeHeader:"ui-icon-triangle-1-s",header:"ui-icon-triangle-1-e"},activate:null,beforeActivate:null},_create:function(){var f=this.accordionId="ui-accordion-"+(this.element.attr("id")||++d),g=this.options;this.prevShow=this.prevHide=a();this.element.addClass("ui-accordion ui-widget ui-helper-reset");this.headers=this.element.find(g.header).addClass("ui-accordion-header ui-helper-reset ui-state-default ui-corner-all");this._hoverable(this.headers);this._focusable(this.headers);this.headers.next().addClass("ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom").hide();if(!g.collapsible&&(g.active===false||g.active==null)){g.active=0}if(g.active<0){g.active+=this.headers.length}this.active=this._findActive(g.active).addClass("ui-accordion-header-active ui-state-active").toggleClass("ui-corner-all ui-corner-top");this.active.next().addClass("ui-accordion-content-active").show();this._createIcons();this.refresh();this.element.attr("role","tablist");this.headers.attr("role","tab").each(function(k){var h=a(this),j=h.attr("id"),l=h.next(),m=l.attr("id");if(!j){j=f+"-header-"+k;h.attr("id",j)}if(!m){m=f+"-panel-"+k;l.attr("id",m)}h.attr("aria-controls",m);l.attr("aria-labelledby",j)}).next().attr("role","tabpanel");this.headers.not(this.active).attr({"aria-selected":"false",tabIndex:-1}).next().attr({"aria-expanded":"false","aria-hidden":"true"}).hide();if(!this.active.length){this.headers.eq(0).attr("tabIndex",0)}else{this.active.attr({"aria-selected":"true",tabIndex:0}).next().attr({"aria-expanded":"true","aria-hidden":"false"})}this._on(this.headers,{keydown:"_keydown"});this._on(this.headers.next(),{keydown:"_panelKeyDown"});this._setupEvents(g.event)},_getCreateEventData:function(){return{header:this.active,content:!this.active.length?a():this.active.next()}},_createIcons:function(){var f=this.options.icons;if(f){a("<span>").addClass("ui-accordion-header-icon ui-icon "+f.header).prependTo(this.headers);this.active.children(".ui-accordion-header-icon").removeClass(f.header).addClass(f.activeHeader);this.headers.addClass("ui-accordion-icons")}},_destroyIcons:function(){this.headers.removeClass("ui-accordion-icons").children(".ui-accordion-header-icon").remove()},_destroy:function(){var f;this.element.removeClass("ui-accordion ui-widget ui-helper-reset").removeAttr("role");this.headers.removeClass("ui-accordion-header ui-accordion-header-active ui-helper-reset ui-state-default ui-corner-all ui-state-active ui-state-disabled ui-corner-top").removeAttr("role").removeAttr("aria-selected").removeAttr("aria-controls").removeAttr("tabIndex").each(function(){if(/^ui-accordion/.test(this.id)){this.removeAttribute("id")}});this._destroyIcons();f=this.headers.next().css("display","").removeAttr("role").removeAttr("aria-expanded").removeAttr("aria-hidden").removeAttr("aria-labelledby").removeClass("ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content ui-accordion-content-active ui-state-disabled").each(function(){if(/^ui-accordion/.test(this.id)){this.removeAttribute("id")}});if(this.options.heightStyle!=="content"){f.css("height","")}},_setOption:function(f,g){if(f==="active"){this._activate(g);return}if(f==="event"){if(this.options.event){this._off(this.headers,this.options.event)}this._setupEvents(g)}this._super(f,g);if(f==="collapsible"&&!g&&this.options.active===false){this._activate(0)}if(f==="icons"){this._destroyIcons();if(g){this._createIcons()}}if(f==="disabled"){this.headers.add(this.headers.next()).toggleClass("ui-state-disabled",!!g)}},_keydown:function(g){if(g.altKey||g.ctrlKey){return}var h=a.ui.keyCode,i=this.headers.length,f=this.headers.index(g.target),j=false;switch(g.keyCode){case h.RIGHT:case h.DOWN:j=this.headers[(f+1)%i];break;case h.LEFT:case h.UP:j=this.headers[(f-1+i)%i];break;case h.SPACE:case h.ENTER:this._eventHandler(g);break;case h.HOME:j=this.headers[0];break;case h.END:j=this.headers[i-1];break}if(j){a(g.target).attr("tabIndex",-1);a(j).attr("tabIndex",0);j.focus();g.preventDefault()}},_panelKeyDown:function(f){if(f.keyCode===a.ui.keyCode.UP&&f.ctrlKey){a(f.currentTarget).prev().focus()}},refresh:function(){var g,h,f=this.options.heightStyle,i=this.element.parent();if(f==="fill"){if(!a.support.minHeight){h=i.css("overflow");i.css("overflow","hidden")}g=i.height();this.element.siblings(":visible").each(function(){var j=a(this),k=j.css("position");if(k==="absolute"||k==="fixed"){return}g-=j.outerHeight(true)});if(h){i.css("overflow",h)}this.headers.each(function(){g-=a(this).outerHeight(true)});this.headers.next().each(function(){a(this).height(Math.max(0,g-a(this).innerHeight()+a(this).height()))}).css("overflow","auto")}else{if(f==="auto"){g=0;this.headers.next().each(function(){g=Math.max(g,a(this).css("height","").height())}).height(g)}}},_activate:function(g){var f=this._findActive(g)[0];if(f===this.active[0]){return}f=f||this.active[0];this._eventHandler({target:f,currentTarget:f,preventDefault:a.noop})},_findActive:function(f){return typeof f==="number"?this.headers.eq(f):a()},_setupEvents:function(f){var g={};if(!f){return}a.each(f.split(" "),function(i,h){g[h]="_eventHandler"});this._on(this.headers,g)},_eventHandler:function(j){var l=this.options,f=this.active,g=a(j.currentTarget),h=g[0]===f[0],i=h&&l.collapsible,n=i?a():g.next(),m=f.next(),k={oldHeader:f,oldPanel:m,newHeader:i?a():g,newPanel:n};j.preventDefault();if((h&&!l.collapsible)||(this._trigger("beforeActivate",j,k)===false)){return}l.active=i?false:this.headers.index(g);this.active=h?a():g;this._toggle(k);f.removeClass("ui-accordion-header-active ui-state-active");if(l.icons){f.children(".ui-accordion-header-icon").removeClass(l.icons.activeHeader).addClass(l.icons.header)}if(!h){g.removeClass("ui-corner-all").addClass("ui-accordion-header-active ui-state-active ui-corner-top");if(l.icons){g.children(".ui-accordion-header-icon").removeClass(l.icons.header).addClass(l.icons.activeHeader)}g.next().addClass("ui-accordion-content-active")}},_toggle:function(f){var h=f.newPanel,g=this.prevShow.length?this.prevShow:f.oldPanel;this.prevShow.add(this.prevHide).stop(true,true);this.prevShow=h;this.prevHide=g;if(this.options.animate){this._animate(h,g,f)}else{g.hide();h.show();this._toggleComplete(f)}g.attr({"aria-expanded":"false","aria-hidden":"true"});g.prev().attr("aria-selected","false");if(h.length&&g.length){g.prev().attr("tabIndex",-1)}else{if(h.length){this.headers.filter(function(){return a(this).attr("tabIndex")===0}).attr("tabIndex",-1)}}h.attr({"aria-expanded":"true","aria-hidden":"false"}).prev().attr({"aria-selected":"true",tabIndex:0})},_animate:function(p,o,i){var q,l,k,n=this,f=0,j=p.length&&(!o.length||(p.index()<o.index())),g=this.options.animate||{},m=j&&g.down||g,h=function(){n._toggleComplete(i)};if(typeof m==="number"){k=m}if(typeof m==="string"){l=m}l=l||m.easing||g.easing;k=k||m.duration||g.duration;if(!o.length){return p.animate(c,k,l,h)}if(!p.length){return o.animate(b,k,l,h)}q=p.show().outerHeight();o.animate(b,{duration:k,easing:l,step:function(s,r){r.now=Math.round(s)}});p.hide().animate(c,{duration:k,easing:l,complete:h,step:function(s,r){r.now=Math.round(s);if(r.prop!=="height"){f+=r.now}else{if(n.options.heightStyle!=="content"){r.now=Math.round(q-o.outerHeight()-f);f=0}}}})},_toggleComplete:function(f){var g=f.oldPanel;g.removeClass("ui-accordion-content-active").prev().removeClass("ui-corner-top").addClass("ui-corner-all");if(g.length){g.parent()[0].className=g.parent()[0].className}this._trigger("activate",null,f)}});if(a.uiBackCompat!==false){(function(f,h){f.extend(h.options,{navigation:false,navigationFilter:function(){return this.href.toLowerCase()===location.href.toLowerCase()}});var g=h._create;h._create=function(){if(this.options.navigation){var l=this,k=this.element.find(this.options.header),i=k.next(),j=k.add(i).find("a").filter(this.options.navigationFilter)[0];if(j){k.add(i).each(function(m){if(f.contains(this,j)){l.options.active=Math.floor(m/2);return false}})}}g.call(this)}}(jQuery,jQuery.ui.accordion.prototype));(function(f,i){f.extend(i.options,{heightStyle:null,autoHeight:true,clearStyle:false,fillSpace:false});var g=i._create,h=i._setOption;f.extend(i,{_create:function(){this.options.heightStyle=this.options.heightStyle||this._mergeHeightStyle();g.call(this)},_setOption:function(j){if(j==="autoHeight"||j==="clearStyle"||j==="fillSpace"){this.options.heightStyle=this._mergeHeightStyle()}h.apply(this,arguments)},_mergeHeightStyle:function(){var j=this.options;if(j.fillSpace){return"fill"}if(j.clearStyle){return"content"}if(j.autoHeight){return"auto"}}})}(jQuery,jQuery.ui.accordion.prototype));(function(f,h){f.extend(h.options.icons,{activeHeader:null,headerSelected:"ui-icon-triangle-1-s"});var g=h._createIcons;h._createIcons=function(){if(this.options.icons){this.options.icons.activeHeader=this.options.icons.activeHeader||this.options.icons.headerSelected}g.call(this)}}(jQuery,jQuery.ui.accordion.prototype));(function(f,h){h.activate=h._activate;var g=h._findActive;h._findActive=function(i){if(i===-1){i=false}if(i&&typeof i!=="number"){i=this.headers.index(this.headers.filter(i));if(i===-1){i=false}}return g.call(this,i)}}(jQuery,jQuery.ui.accordion.prototype));jQuery.ui.accordion.prototype.resize=jQuery.ui.accordion.prototype.refresh;(function(f,h){f.extend(h.options,{change:null,changestart:null});var g=h._trigger;h._trigger=function(l,j,i){var k=g.apply(this,arguments);if(!k){return false}if(l==="beforeActivate"){k=g.call(this,"changestart",j,{oldHeader:i.oldHeader,oldContent:i.oldPanel,newHeader:i.newHeader,newContent:i.newPanel})}else{if(l==="activate"){k=g.call(this,"change",j,{oldHeader:i.oldHeader,oldContent:i.oldPanel,newHeader:i.newHeader,newContent:i.newPanel})}}return k}}(jQuery,jQuery.ui.accordion.prototype));(function(f,h){f.extend(h.options,{animate:null,animated:"slide"});var g=h._create;h._create=function(){var i=this.options;if(i.animate===null){if(!i.animated){i.animate=false}else{if(i.animated==="slide"){i.animate=300}else{if(i.animated==="bounceslide"){i.animate={duration:200,down:{easing:"easeOutBounce",duration:1000}}}else{i.animate=i.animated}}}}g.call(this)}}(jQuery,jQuery.ui.accordion.prototype))}})(jQuery);(function(a,c){var b=0;a.widget("ui.autocomplete",{version:"1.9.2",defaultElement:"<input>",options:{appendTo:"body",autoFocus:false,delay:300,minLength:1,position:{my:"left top",at:"left bottom",collision:"none"},source:null,change:null,close:null,focus:null,open:null,response:null,search:null,select:null},pending:0,_create:function(){var e,f,d;this.isMultiLine=this._isMultiLine();this.valueMethod=this.element[this.element.is("input,textarea")?"val":"text"];this.isNewMenu=true;this.element.addClass("ui-autocomplete-input").attr("autocomplete","off");this._on(this.element,{keydown:function(g){if(this.element.prop("readOnly")){e=true;d=true;f=true;return}e=false;d=false;f=false;var h=a.ui.keyCode;switch(g.keyCode){case h.PAGE_UP:e=true;this._move("previousPage",g);break;case h.PAGE_DOWN:e=true;this._move("nextPage",g);break;case h.UP:e=true;this._keyEvent("previous",g);break;case h.DOWN:e=true;this._keyEvent("next",g);break;case h.ENTER:case h.NUMPAD_ENTER:if(this.menu.active){e=true;g.preventDefault();this.menu.select(g)}break;case h.TAB:if(this.menu.active){this.menu.select(g)}break;case h.ESCAPE:if(this.menu.element.is(":visible")){this._value(this.term);this.close(g);g.preventDefault()}break;default:f=true;this._searchTimeout(g);break}},keypress:function(g){if(e){e=false;g.preventDefault();return}if(f){return}var h=a.ui.keyCode;switch(g.keyCode){case h.PAGE_UP:this._move("previousPage",g);break;case h.PAGE_DOWN:this._move("nextPage",g);break;case h.UP:this._keyEvent("previous",g);break;case h.DOWN:this._keyEvent("next",g);break}},input:function(g){if(d){d=false;g.preventDefault();return}this._searchTimeout(g)},focus:function(){this.selectedItem=null;this.previous=this._value()},blur:function(g){if(this.cancelBlur){delete this.cancelBlur;return}clearTimeout(this.searching);this.close(g);this._change(g)}});this._initSource();this.menu=a("<ul>").addClass("ui-autocomplete").appendTo(this.document.find(this.options.appendTo||"body")[0]).menu({input:a(),role:null}).zIndex(this.element.zIndex()+1).hide().data("menu");this._on(this.menu.element,{mousedown:function(g){g.preventDefault();this.cancelBlur=true;this._delay(function(){delete this.cancelBlur});if(g.stopPropagation){g.stopPropagation()}else{g.cancelBubble=true}var h=this.menu.element[0];if(!a(g.target).closest(".ui-menu-item").length){this._delay(function(){var i=this;this.document.one("mousedown",function(j){if(j.target!==i.element[0]&&j.target!==h&&!a.contains(h,j.target)){i.close()}})})}},menufocus:function(g,i){if(this.isNewMenu){this.isNewMenu=false;if(g.originalEvent&&/^mouse/.test(g.originalEvent.type)){this.menu.blur();this.document.one("mousemove",function(){a(g.target).trigger(g.originalEvent)});return}}var h=i.item.data("ui-autocomplete-item")||i.item.data("item.autocomplete");if(false!==this._trigger("focus",g,{item:h})){if(g.originalEvent&&/^key/.test(g.originalEvent.type)){this._value(h.value)}}else{this.liveRegion.text(h.value)}},menuselect:function(g,j){var h=j.item.data("ui-autocomplete-item")||j.item.data("item.autocomplete"),i=this.previous;if(this.element[0]!==this.document[0].activeElement){this.element.focus();this.previous=i;this._delay(function(){this.previous=i;this.selectedItem=h})}if(false!==this._trigger("select",g,{item:h})){this._value(h.value)}this.term=this._value();this.close(g);this.selectedItem=h}});this.liveRegion=a("<span>",{role:"status","aria-live":"polite"}).addClass("ui-helper-hidden-accessible").insertAfter(this.element);if(a.fn.bgiframe){this.menu.element.bgiframe()}this._on(this.window,{beforeunload:function(){this.element.removeAttr("autocomplete")}})},_destroy:function(){clearTimeout(this.searching);this.element.removeClass("ui-autocomplete-input").removeAttr("autocomplete");this.menu.element.remove();this.liveRegion.remove()},_setOption:function(d,e){this._super(d,e);if(d==="source"){this._initSource()}if(d==="appendTo"){this.menu.element.appendTo(this.document.find(e||"body")[0])}if(d==="disabled"&&e&&this.xhr){this.xhr.abort()}},_isMultiLine:function(){if(this.element.is("textarea")){return true}if(this.element.is("input")){return false}return this.element.prop("isContentEditable")},_initSource:function(){var d,f,e=this;if(a.isArray(this.options.source)){d=this.options.source;this.source=function(g,h){h(a.ui.autocomplete.filter(d,g.term))}}else{if(typeof this.options.source==="string"){f=this.options.source;this.source=function(g,h){if(e.xhr){e.xhr.abort()}e.xhr=a.ajax({url:f,data:g,dataType:"json",success:function(i){h(i)},error:function(){h([])}})}}else{this.source=this.options.source}}},_searchTimeout:function(d){clearTimeout(this.searching);this.searching=this._delay(function(){if(this.term!==this._value()){this.selectedItem=null;this.search(null,d)}},this.options.delay)},search:function(e,d){e=e!=null?e:this._value();this.term=this._value();if(e.length<this.options.minLength){return this.close(d)}if(this._trigger("search",d)===false){return}return this._search(e)},_search:function(d){this.pending++;this.element.addClass("ui-autocomplete-loading");this.cancelSearch=false;this.source({term:d},this._response())},_response:function(){var e=this,d=++b;return function(f){if(d===b){e.__response(f)}e.pending--;if(!e.pending){e.element.removeClass("ui-autocomplete-loading")}}},__response:function(d){if(d){d=this._normalize(d)}this._trigger("response",null,{content:d});if(!this.options.disabled&&d&&d.length&&!this.cancelSearch){this._suggest(d);this._trigger("open")}else{this._close()}},close:function(d){this.cancelSearch=true;this._close(d)},_close:function(d){if(this.menu.element.is(":visible")){this.menu.element.hide();this.menu.blur();this.isNewMenu=true;this._trigger("close",d)}},_change:function(d){if(this.previous!==this._value()){this._trigger("change",d,{item:this.selectedItem})}},_normalize:function(d){if(d.length&&d[0].label&&d[0].value){return d}return a.map(d,function(e){if(typeof e==="string"){return{label:e,value:e}}return a.extend({label:e.label||e.value,value:e.value||e.label},e)})},_suggest:function(d){var e=this.menu.element.empty().zIndex(this.element.zIndex()+1);this._renderMenu(e,d);this.menu.refresh();e.show();this._resizeMenu();e.position(a.extend({of:this.element},this.options.position));if(this.options.autoFocus){this.menu.next()}},_resizeMenu:function(){var d=this.menu.element;d.outerWidth(Math.max(d.width("").outerWidth()+1,this.element.outerWidth()))},_renderMenu:function(f,d){var e=this;a.each(d,function(g,h){e._renderItemData(f,h)})},_renderItemData:function(e,d){return this._renderItem(e,d).data("ui-autocomplete-item",d)},_renderItem:function(e,d){return a("<li>").append(a("<a>").text(d.label)).appendTo(e)},_move:function(d,e){if(!this.menu.element.is(":visible")){this.search(null,e);return}if(this.menu.isFirstItem()&&/^previous/.test(d)||this.menu.isLastItem()&&/^next/.test(d)){this._value(this.term);this.menu.blur();return}this.menu[d](e)},widget:function(){return this.menu.element},_value:function(){return this.valueMethod.apply(this.element,arguments)},_keyEvent:function(e,d){if(!this.isMultiLine||this.menu.element.is(":visible")){this._move(e,d);d.preventDefault()}}});a.extend(a.ui.autocomplete,{escapeRegex:function(d){return d.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g,"\\$&")},filter:function(d,f){var e=new RegExp(a.ui.autocomplete.escapeRegex(f),"i");return a.grep(d,function(g){return e.test(g.label||g.value||g)})}});a.widget("ui.autocomplete",a.ui.autocomplete,{options:{messages:{noResults:"No search results.",results:function(d){return d+(d>1?" results are":" result is")+" available, use up and down arrow keys to navigate."}}},__response:function(d){var e;this._superApply(arguments);if(this.options.disabled||this.cancelSearch){return}if(d&&d.length){e=this.options.messages.results(d.length)}else{e=this.options.messages.noResults}this.liveRegion.text(e)}})}(jQuery));(function(a,k){var e,g,h,c,b="ui-button ui-widget ui-state-default ui-corner-all",i="ui-state-hover ui-state-active ",j="ui-button-icons-only ui-button-icon-only ui-button-text-icons ui-button-text-icon-primary ui-button-text-icon-secondary ui-button-text-only",d=function(){var l=a(this).find(":ui-button");setTimeout(function(){l.button("refresh")},1)},f=function(n){var m=n.name,l=n.form,o=a([]);if(m){if(l){o=a(l).find("[name='"+m+"']")}else{o=a("[name='"+m+"']",n.ownerDocument).filter(function(){return !this.form})}}return o};a.widget("ui.button",{version:"1.9.2",defaultElement:"<button>",options:{disabled:null,text:true,label:null,icons:{primary:null,secondary:null}},_create:function(){this.element.closest("form").unbind("reset"+this.eventNamespace).bind("reset"+this.eventNamespace,d);if(typeof this.options.disabled!=="boolean"){this.options.disabled=!!this.element.prop("disabled")}else{this.element.prop("disabled",this.options.disabled)}this._determineButtonType();this.hasTitle=!!this.buttonElement.attr("title");var o=this,n=this.options,p=this.type==="checkbox"||this.type==="radio",l=!p?"ui-state-active":"",m="ui-state-focus";if(n.label===null){n.label=(this.type==="input"?this.buttonElement.val():this.buttonElement.html())}this._hoverable(this.buttonElement);this.buttonElement.addClass(b).attr("role","button").bind("mouseenter"+this.eventNamespace,function(){if(n.disabled){return}if(this===e){a(this).addClass("ui-state-active")}}).bind("mouseleave"+this.eventNamespace,function(){if(n.disabled){return}a(this).removeClass(l)}).bind("click"+this.eventNamespace,function(q){if(n.disabled){q.preventDefault();q.stopImmediatePropagation()}});this.element.bind("focus"+this.eventNamespace,function(){o.buttonElement.addClass(m)}).bind("blur"+this.eventNamespace,function(){o.buttonElement.removeClass(m)});if(p){this.element.bind("change"+this.eventNamespace,function(){if(c){return}o.refresh()});this.buttonElement.bind("mousedown"+this.eventNamespace,function(q){if(n.disabled){return}c=false;g=q.pageX;h=q.pageY}).bind("mouseup"+this.eventNamespace,function(q){if(n.disabled){return}if(g!==q.pageX||h!==q.pageY){c=true}})}if(this.type==="checkbox"){this.buttonElement.bind("click"+this.eventNamespace,function(){if(n.disabled||c){return false}a(this).toggleClass("ui-state-active");o.buttonElement.attr("aria-pressed",o.element[0].checked)})}else{if(this.type==="radio"){this.buttonElement.bind("click"+this.eventNamespace,function(){if(n.disabled||c){return false}a(this).addClass("ui-state-active");o.buttonElement.attr("aria-pressed","true");var q=o.element[0];f(q).not(q).map(function(){return a(this).button("widget")[0]}).removeClass("ui-state-active").attr("aria-pressed","false")})}else{this.buttonElement.bind("mousedown"+this.eventNamespace,function(){if(n.disabled){return false}a(this).addClass("ui-state-active");e=this;o.document.one("mouseup",function(){e=null})}).bind("mouseup"+this.eventNamespace,function(){if(n.disabled){return false}a(this).removeClass("ui-state-active")}).bind("keydown"+this.eventNamespace,function(q){if(n.disabled){return false}if(q.keyCode===a.ui.keyCode.SPACE||q.keyCode===a.ui.keyCode.ENTER){a(this).addClass("ui-state-active")}}).bind("keyup"+this.eventNamespace,function(){a(this).removeClass("ui-state-active")});if(this.buttonElement.is("a")){this.buttonElement.keyup(function(q){if(q.keyCode===a.ui.keyCode.SPACE){a(this).click()}})}}}this._setOption("disabled",n.disabled);this._resetButton()},_determineButtonType:function(){var l,n,m;if(this.element.is("[type=checkbox]")){this.type="checkbox"}else{if(this.element.is("[type=radio]")){this.type="radio"}else{if(this.element.is("input")){this.type="input"}else{this.type="button"}}}if(this.type==="checkbox"||this.type==="radio"){l=this.element.parents().last();n="label[for='"+this.element.attr("id")+"']";this.buttonElement=l.find(n);if(!this.buttonElement.length){l=l.length?l.siblings():this.element.siblings();this.buttonElement=l.filter(n);if(!this.buttonElement.length){this.buttonElement=l.find(n)}}this.element.addClass("ui-helper-hidden-accessible");m=this.element.is(":checked");if(m){this.buttonElement.addClass("ui-state-active")}this.buttonElement.prop("aria-pressed",m)}else{this.buttonElement=this.element}},widget:function(){return this.buttonElement},_destroy:function(){this.element.removeClass("ui-helper-hidden-accessible");this.buttonElement.removeClass(b+" "+i+" "+j).removeAttr("role").removeAttr("aria-pressed").html(this.buttonElement.find(".ui-button-text").html());if(!this.hasTitle){this.buttonElement.removeAttr("title")}},_setOption:function(l,m){this._super(l,m);if(l==="disabled"){if(m){this.element.prop("disabled",true)}else{this.element.prop("disabled",false)}return}this._resetButton()},refresh:function(){var l=this.element.is("input, button")?this.element.is(":disabled"):this.element.hasClass("ui-button-disabled");if(l!==this.options.disabled){this._setOption("disabled",l)}if(this.type==="radio"){f(this.element[0]).each(function(){if(a(this).is(":checked")){a(this).button("widget").addClass("ui-state-active").attr("aria-pressed","true")}else{a(this).button("widget").removeClass("ui-state-active").attr("aria-pressed","false")}})}else{if(this.type==="checkbox"){if(this.element.is(":checked")){this.buttonElement.addClass("ui-state-active").attr("aria-pressed","true")}else{this.buttonElement.removeClass("ui-state-active").attr("aria-pressed","false")}}}},_resetButton:function(){if(this.type==="input"){if(this.options.label){this.element.val(this.options.label)}return}var m=this.buttonElement.removeClass(j),n=a("<span></span>",this.document[0]).addClass("ui-button-text").html(this.options.label).appendTo(m.empty()).text(),o=this.options.icons,p=o.primary&&o.secondary,l=[];if(o.primary||o.secondary){if(this.options.text){l.push("ui-button-text-icon"+(p?"s":(o.primary?"-primary":"-secondary")))}if(o.primary){m.prepend("<span class='ui-button-icon-primary ui-icon "+o.primary+"'></span>")}if(o.secondary){m.append("<span class='ui-button-icon-secondary ui-icon "+o.secondary+"'></span>")}if(!this.options.text){l.push(p?"ui-button-icons-only":"ui-button-icon-only");if(!this.hasTitle){m.attr("title",a.trim(n))}}}else{l.push("ui-button-text-only")}m.addClass(l.join(" "))}});a.widget("ui.buttonset",{version:"1.9.2",options:{items:"button, input[type=button], input[type=submit], input[type=reset], input[type=checkbox], input[type=radio], a, :data(button)"},_create:function(){this.element.addClass("ui-buttonset")},_init:function(){this.refresh()},_setOption:function(l,m){if(l==="disabled"){this.buttons.button("option",l,m)}this._super(l,m)},refresh:function(){var l=this.element.css("direction")==="rtl";this.buttons=this.element.find(this.options.items).filter(":ui-button").button("refresh").end().not(":ui-button").button().end().map(function(){return a(this).button("widget")[0]}).removeClass("ui-corner-all ui-corner-left ui-corner-right").filter(":first").addClass(l?"ui-corner-right":"ui-corner-left").end().filter(":last").addClass(l?"ui-corner-left":"ui-corner-right").end().end()},_destroy:function(){this.element.removeClass("ui-buttonset");this.buttons.map(function(){return a(this).button("widget")[0]}).removeClass("ui-corner-left ui-corner-right").end().button("destroy")}})}(jQuery));(function($,undefined){$.extend($.ui,{datepicker:{version:"1.9.2"}});var PROP_NAME="datepicker";var dpuuid=new Date().getTime();var instActive;function Datepicker(){this.debug=false;this._curInst=null;this._keyEvent=false;this._disabledInputs=[];this._datepickerShowing=false;this._inDialog=false;this._mainDivId="ui-datepicker-div";this._inlineClass="ui-datepicker-inline";this._appendClass="ui-datepicker-append";this._triggerClass="ui-datepicker-trigger";this._dialogClass="ui-datepicker-dialog";this._disableClass="ui-datepicker-disabled";this._unselectableClass="ui-datepicker-unselectable";this._currentClass="ui-datepicker-current-day";this._dayOverClass="ui-datepicker-days-cell-over";this.regional=[];this.regional[""]={clearText:"Clear",closeText:"Done",prevText:"Prev",nextText:"Next",currentText:"Today",monthNames:["January","February","March","April","May","June","July","August","September","October","November","December"],monthNamesShort:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],dayNames:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],dayNamesShort:["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],dayNamesMin:["Su","Mo","Tu","We","Th","Fr","Sa"],weekHeader:"Wk",dateFormat:"mm/dd/yy",firstDay:0,isRTL:false,showMonthAfterYear:false,yearSuffix:""};this._defaults={showOn:"focus",showAnim:"fadeIn",showOptions:{},defaultDate:null,appendText:"",buttonText:"...",buttonImage:"",buttonImageOnly:false,hideIfNoPrevNext:false,navigationAsDateFormat:false,gotoCurrent:false,changeMonth:false,changeYear:false,yearRange:"c-10:c+10",showOtherMonths:false,selectOtherMonths:false,showWeek:false,calculateWeek:this.iso8601Week,shortYearCutoff:"+10",minDate:null,maxDate:null,duration:"fast",beforeShowDay:null,beforeShow:null,onSelect:null,onChangeMonthYear:null,onClose:null,numberOfMonths:1,showCurrentAtPos:0,stepMonths:1,stepBigMonths:12,altField:"",altFormat:"",constrainInput:true,showButtonPanel:false,autoSize:false,disabled:false,showClearButton:false};$.extend(this._defaults,this.regional[""]);this.dpDiv=bindHover($('<div id="'+this._mainDivId+'" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>'))}$.extend(Datepicker.prototype,{markerClassName:"hasDatepicker",maxRows:4,log:function(){if(this.debug){console.log.apply("",arguments)}},_widgetDatepicker:function(){return this.dpDiv},setDefaults:function(settings){extendRemove(this._defaults,settings||{});return this},_attachDatepicker:function(target,settings){var inlineSettings=null;for(var attrName in this._defaults){var attrValue=target.getAttribute("date:"+attrName);if(attrValue){inlineSettings=inlineSettings||{};try{inlineSettings[attrName]=eval(attrValue)}catch(err){inlineSettings[attrName]=attrValue}}}var nodeName=target.nodeName.toLowerCase();var inline=(nodeName=="div"||nodeName=="span");if(!target.id){this.uuid+=1;target.id="dp"+this.uuid}var inst=this._newInst($(target),inline);inst.settings=$.extend({},settings||{},inlineSettings||{});if(nodeName=="input"){this._connectDatepicker(target,inst)}else{if(inline){this._inlineDatepicker(target,inst)}}},_newInst:function(target,inline){var id=target[0].id.replace(/([^A-Za-z0-9_-])/g,"\\\\$1");return{id:id,input:target,selectedDay:0,selectedMonth:0,selectedYear:0,drawMonth:0,drawYear:0,inline:inline,dpDiv:(!inline?this.dpDiv:bindHover($('<div class="'+this._inlineClass+' ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>')))}},_connectDatepicker:function(target,inst){var input=$(target);inst.append=$([]);inst.trigger=$([]);if(input.hasClass(this.markerClassName)){return}this._attachments(input,inst);input.addClass(this.markerClassName).keydown(this._doKeyDown).keypress(this._doKeyPress).keyup(this._doKeyUp).bind("setData.datepicker",function(event,key,value){inst.settings[key]=value}).bind("getData.datepicker",function(event,key){return this._get(inst,key)});this._autoSize(inst);$.data(target,PROP_NAME,inst);if(inst.settings.disabled){this._disableDatepicker(target)}},_attachments:function(input,inst){var appendText=this._get(inst,"appendText");var isRTL=this._get(inst,"isRTL");if(inst.append){inst.append.remove()}if(appendText){inst.append=$('<span class="'+this._appendClass+'">'+appendText+"</span>");input[isRTL?"before":"after"](inst.append)}input.unbind("focus",this._showDatepicker);if(inst.trigger){inst.trigger.remove()}var showOn=this._get(inst,"showOn");if(showOn=="focus"||showOn=="both"){input.focus(this._showDatepicker)}if(showOn=="button"||showOn=="both"){var buttonText=this._get(inst,"buttonText");var buttonImage=this._get(inst,"buttonImage");inst.trigger=$(this._get(inst,"buttonImageOnly")?$("<img/>").addClass(this._triggerClass).attr({src:buttonImage,alt:buttonText,title:buttonText}):$('<button type="button"></button>').addClass(this._triggerClass).html(buttonImage==""?buttonText:$("<img/>").attr({src:buttonImage,alt:buttonText,title:buttonText})));input[isRTL?"before":"after"](inst.trigger);inst.trigger.click(function(){if($.datepicker._datepickerShowing&&$.datepicker._lastInput==input[0]){$.datepicker._hideDatepicker()}else{if($.datepicker._datepickerShowing&&$.datepicker._lastInput!=input[0]){$.datepicker._hideDatepicker();$.datepicker._showDatepicker(input[0])}else{$.datepicker._showDatepicker(input[0])}}return false})}},_autoSize:function(inst){if(this._get(inst,"autoSize")&&!inst.inline){var date=new Date(2009,12-1,20);var dateFormat=this._get(inst,"dateFormat");if(dateFormat.match(/[DM]/)){var findMax=function(names){var max=0;var maxI=0;for(var i=0;i<names.length;i++){if(names[i].length>max){max=names[i].length;maxI=i}}return maxI};date.setMonth(findMax(this._get(inst,(dateFormat.match(/MM/)?"monthNames":"monthNamesShort"))));date.setDate(findMax(this._get(inst,(dateFormat.match(/DD/)?"dayNames":"dayNamesShort")))+20-date.getDay())}inst.input.attr("size",this._formatDate(inst,date).length)}},_inlineDatepicker:function(target,inst){var divSpan=$(target);if(divSpan.hasClass(this.markerClassName)){return}divSpan.addClass(this.markerClassName).append(inst.dpDiv).bind("setData.datepicker",function(event,key,value){inst.settings[key]=value}).bind("getData.datepicker",function(event,key){return this._get(inst,key)});$.data(target,PROP_NAME,inst);this._setDate(inst,this._getDefaultDate(inst),true);this._updateDatepicker(inst);this._updateAlternate(inst);if(inst.settings.disabled){this._disableDatepicker(target)}inst.dpDiv.css("display","block")},_dialogDatepicker:function(input,date,onSelect,settings,pos){var inst=this._dialogInst;if(!inst){this.uuid+=1;var id="dp"+this.uuid;this._dialogInput=$('<input type="text" id="'+id+'" style="position: absolute; top: -100px; width: 0px;"/>');this._dialogInput.keydown(this._doKeyDown);$("body").append(this._dialogInput);inst=this._dialogInst=this._newInst(this._dialogInput,false);inst.settings={};$.data(this._dialogInput[0],PROP_NAME,inst)}extendRemove(inst.settings,settings||{});date=(date&&date.constructor==Date?this._formatDate(inst,date):date);this._dialogInput.val(date);this._pos=(pos?(pos.length?pos:[pos.pageX,pos.pageY]):null);if(!this._pos){var browserWidth=document.documentElement.clientWidth;var browserHeight=document.documentElement.clientHeight;var scrollX=document.documentElement.scrollLeft||document.body.scrollLeft;var scrollY=document.documentElement.scrollTop||document.body.scrollTop;this._pos=[(browserWidth/2)-100+scrollX,(browserHeight/2)-150+scrollY]}this._dialogInput.css("left",(this._pos[0]+20)+"px").css("top",this._pos[1]+"px");inst.settings.onSelect=onSelect;this._inDialog=true;this.dpDiv.addClass(this._dialogClass);this._showDatepicker(this._dialogInput[0]);if($.blockUI){$.blockUI(this.dpDiv)}$.data(this._dialogInput[0],PROP_NAME,inst);return this},_destroyDatepicker:function(target){var $target=$(target);var inst=$.data(target,PROP_NAME);if(!$target.hasClass(this.markerClassName)){return}var nodeName=target.nodeName.toLowerCase();$.removeData(target,PROP_NAME);if(nodeName=="input"){inst.append.remove();inst.trigger.remove();$target.removeClass(this.markerClassName).unbind("focus",this._showDatepicker).unbind("keydown",this._doKeyDown).unbind("keypress",this._doKeyPress).unbind("keyup",this._doKeyUp)}else{if(nodeName=="div"||nodeName=="span"){$target.removeClass(this.markerClassName).empty()}}},_enableDatepicker:function(target){var $target=$(target);var inst=$.data(target,PROP_NAME);if(!$target.hasClass(this.markerClassName)){return}var nodeName=target.nodeName.toLowerCase();if(nodeName=="input"){target.disabled=false;inst.trigger.filter("button").each(function(){this.disabled=false}).end().filter("img").css({opacity:"1.0",cursor:""})}else{if(nodeName=="div"||nodeName=="span"){var inline=$target.children("."+this._inlineClass);inline.children().removeClass("ui-state-disabled");inline.find("select.ui-datepicker-month, select.ui-datepicker-year").prop("disabled",false)}}this._disabledInputs=$.map(this._disabledInputs,function(value){return(value==target?null:value)})},_disableDatepicker:function(target){var $target=$(target);var inst=$.data(target,PROP_NAME);if(!$target.hasClass(this.markerClassName)){return}var nodeName=target.nodeName.toLowerCase();if(nodeName=="input"){target.disabled=true;inst.trigger.filter("button").each(function(){this.disabled=true}).end().filter("img").css({opacity:"0.5",cursor:"default"})}else{if(nodeName=="div"||nodeName=="span"){var inline=$target.children("."+this._inlineClass);inline.children().addClass("ui-state-disabled");inline.find("select.ui-datepicker-month, select.ui-datepicker-year").prop("disabled",true)}}this._disabledInputs=$.map(this._disabledInputs,function(value){return(value==target?null:value)});this._disabledInputs[this._disabledInputs.length]=target},_isDisabledDatepicker:function(target){if(!target){return false}for(var i=0;i<this._disabledInputs.length;i++){if(this._disabledInputs[i]==target){return true}}return false},_getInst:function(target){try{return $.data(target,PROP_NAME)}catch(err){throw"Missing instance data for this datepicker"}},_optionDatepicker:function(target,name,value){var inst=this._getInst(target);if(arguments.length==2&&typeof name=="string"){return(name=="defaults"?$.extend({},$.datepicker._defaults):(inst?(name=="all"?$.extend({},inst.settings):this._get(inst,name)):null))}var settings=name||{};if(typeof name=="string"){settings={};settings[name]=value}if(inst){if(this._curInst==inst){this._hideDatepicker()}var date=this._getDateDatepicker(target,true);var minDate=this._getMinMaxDate(inst,"min");var maxDate=this._getMinMaxDate(inst,"max");extendRemove(inst.settings,settings);if(minDate!==null&&settings.dateFormat!==undefined&&settings.minDate===undefined){inst.settings.minDate=this._formatDate(inst,minDate)}if(maxDate!==null&&settings.dateFormat!==undefined&&settings.maxDate===undefined){inst.settings.maxDate=this._formatDate(inst,maxDate)}this._attachments($(target),inst);this._autoSize(inst);this._setDate(inst,date);this._updateAlternate(inst);this._updateDatepicker(inst)}},_changeDatepicker:function(target,name,value){this._optionDatepicker(target,name,value)},_refreshDatepicker:function(target){var inst=this._getInst(target);if(inst){this._updateDatepicker(inst)}},_setDateDatepicker:function(target,date){var inst=this._getInst(target);if(inst){this._setDate(inst,date);this._updateDatepicker(inst);this._updateAlternate(inst)}},_getDateDatepicker:function(target,noDefault){var inst=this._getInst(target);if(inst&&!inst.inline){this._setDateFromField(inst,noDefault)}return(inst?this._getDate(inst):null)},_doKeyDown:function(event){var inst=$.datepicker._getInst(event.target);var handled=true;var isRTL=inst.dpDiv.is(".ui-datepicker-rtl");inst._keyEvent=true;if($.datepicker._datepickerShowing){switch(event.keyCode){case 9:$.datepicker._hideDatepicker();handled=false;break;case 13:var sel=$("td."+$.datepicker._dayOverClass+":not(."+$.datepicker._currentClass+")",inst.dpDiv);if(sel[0]){$.datepicker._selectDay(event.target,inst.selectedMonth,inst.selectedYear,sel[0])}var onSelect=$.datepicker._get(inst,"onSelect");if(onSelect){var dateStr=$.datepicker._formatDate(inst);onSelect.apply((inst.input?inst.input[0]:null),[dateStr,inst])}else{$.datepicker._hideDatepicker()}return false;break;case 27:$.datepicker._hideDatepicker();break;case 33:$.datepicker._adjustDate(event.target,(event.ctrlKey?-$.datepicker._get(inst,"stepBigMonths"):-$.datepicker._get(inst,"stepMonths")),"M");break;case 34:$.datepicker._adjustDate(event.target,(event.ctrlKey?+$.datepicker._get(inst,"stepBigMonths"):+$.datepicker._get(inst,"stepMonths")),"M");break;case 35:if(event.ctrlKey||event.metaKey){$.datepicker._clearDate(event.target)}handled=event.ctrlKey||event.metaKey;break;case 36:if(event.ctrlKey||event.metaKey){$.datepicker._gotoToday(event.target)}handled=event.ctrlKey||event.metaKey;break;case 37:if(event.ctrlKey||event.metaKey){$.datepicker._adjustDate(event.target,(isRTL?+1:-1),"D")}handled=event.ctrlKey||event.metaKey;if(event.originalEvent.altKey){$.datepicker._adjustDate(event.target,(event.ctrlKey?-$.datepicker._get(inst,"stepBigMonths"):-$.datepicker._get(inst,"stepMonths")),"M")}break;case 38:if(event.ctrlKey||event.metaKey){$.datepicker._adjustDate(event.target,-7,"D")}handled=event.ctrlKey||event.metaKey;break;case 39:if(event.ctrlKey||event.metaKey){$.datepicker._adjustDate(event.target,(isRTL?-1:+1),"D")}handled=event.ctrlKey||event.metaKey;if(event.originalEvent.altKey){$.datepicker._adjustDate(event.target,(event.ctrlKey?+$.datepicker._get(inst,"stepBigMonths"):+$.datepicker._get(inst,"stepMonths")),"M")}break;case 40:if(event.ctrlKey||event.metaKey){$.datepicker._adjustDate(event.target,+7,"D")}handled=event.ctrlKey||event.metaKey;break;default:handled=false}}else{if(event.keyCode==36&&event.ctrlKey){$.datepicker._showDatepicker(this)}else{handled=false}}if(handled){event.preventDefault();event.stopPropagation()}},_doKeyPress:function(event){var inst=$.datepicker._getInst(event.target);if($.datepicker._get(inst,"constrainInput")){var chars=$.datepicker._possibleChars($.datepicker._get(inst,"dateFormat"));var chr=String.fromCharCode(event.charCode==undefined?event.keyCode:event.charCode);return event.ctrlKey||event.metaKey||(chr<" "||!chars||chars.indexOf(chr)>-1)}},_doKeyUp:function(event){var inst=$.datepicker._getInst(event.target);if(inst.input.val()!=inst.lastVal){try{var date=$.datepicker.parseDate($.datepicker._get(inst,"dateFormat"),(inst.input?inst.input.val():null),$.datepicker._getFormatConfig(inst));if(date){$.datepicker._setDateFromField(inst);$.datepicker._updateAlternate(inst);$.datepicker._updateDatepicker(inst)}}catch(err){$.datepicker.log(err)}}return true},_doblur:function(event){var inst=$.datepicker._getInst(event.target);if(inst.input[0].value.length==0){return}var reg=/^(\d{4})(\/|-)(\d{1,2})\2(\d{1,2})$/;var arr=inst.input[0].value.match(reg);if(arr==null){alert("閿欒鐨勬椂闂存牸寮?璇锋寜鏍煎紡濉啓\n ��? 2012-12-22");var today=new Date();inst.input[0].value=today.getYear()+"-"+(today.getMonth()+1)+"-"+today.getDate();inst.input[0].focus();return}var tempDate=new Date(arr[1],arr[3]-1,arr[4]);if((tempDate.getFullYear()==arr[1]&&(tempDate.getMonth()+1)==arr[3]&&tempDate.getDate()==arr[4])==false){alert("閿欒鐨勬椂闂存牸寮?璇锋寜鏍煎紡濉啓\n ��? 2012-12-22");var today=new Date();inst.input[0].value=today.getYear()+"-"+(today.getMonth()+1)+"-"+today.getDate();inst.input[0].focus();return}},_showDatepicker:function(input){input=input.target||input;if(input.nodeName.toLowerCase()!="input"){input=$("input",input.parentNode)[0]}if($.datepicker._isDisabledDatepicker(input)||$.datepicker._lastInput==input){return}var inst=$.datepicker._getInst(input);if($.datepicker._curInst&&$.datepicker._curInst!=inst){$.datepicker._curInst.dpDiv.stop(true,true);if(inst&&$.datepicker._datepickerShowing){$.datepicker._hideDatepicker($.datepicker._curInst.input[0])}}var beforeShow=$.datepicker._get(inst,"beforeShow");var beforeShowSettings=beforeShow?beforeShow.apply(input,[input,inst]):{};if(beforeShowSettings===false){return}extendRemove(inst.settings,beforeShowSettings);inst.lastVal=null;$.datepicker._lastInput=input;$.datepicker._setDateFromField(inst);if($.datepicker._inDialog){input.value=""}if(!$.datepicker._pos){$.datepicker._pos=$.datepicker._findPos(input);$.datepicker._pos[1]+=input.offsetHeight}var isFixed=false;$(input).parents().each(function(){isFixed|=$(this).css("position")=="fixed";return !isFixed});var offset={left:$.datepicker._pos[0],top:$.datepicker._pos[1]};$.datepicker._pos=null;inst.dpDiv.empty();inst.dpDiv.css({position:"absolute",display:"block",top:"-1000px"});$.datepicker._updateDatepicker(inst);offset=$.datepicker._checkOffset(inst,offset,isFixed);inst.dpDiv.css({position:($.datepicker._inDialog&&$.blockUI?"static":(isFixed?"fixed":"absolute")),display:"none",left:offset.left+"px",top:offset.top+"px"});if(!inst.inline){var showAnim=$.datepicker._get(inst,"showAnim");var duration=$.datepicker._get(inst,"duration");var postProcess=function(){var cover=inst.dpDiv.find("iframe.ui-datepicker-cover");if(!!cover.length){var borders=$.datepicker._getBorders(inst.dpDiv);cover.css({left:-borders[0],top:-borders[1],width:inst.dpDiv.outerWidth(),height:inst.dpDiv.outerHeight()})}};inst.dpDiv.zIndex($(input).zIndex()+1);$.datepicker._datepickerShowing=true;if($.effects&&($.effects.effect[showAnim]||$.effects[showAnim])){inst.dpDiv.show(showAnim,$.datepicker._get(inst,"showOptions"),duration,postProcess)}else{inst.dpDiv[showAnim||"show"]((showAnim?duration:null),postProcess)}if(!showAnim||!duration){postProcess()}if(inst.input.is(":visible")&&!inst.input.is(":disabled")){inst.input.focus()}$.datepicker._curInst=inst}},_updateDatepicker:function(inst){this.maxRows=4;var borders=$.datepicker._getBorders(inst.dpDiv);instActive=inst;inst.dpDiv.empty().append(this._generateHTML(inst));this._attachHandlers(inst);var cover=inst.dpDiv.find("iframe.ui-datepicker-cover");if(!!cover.length){cover.css({left:-borders[0],top:-borders[1],width:inst.dpDiv.outerWidth(),height:inst.dpDiv.outerHeight()})}inst.dpDiv.find("."+this._dayOverClass+" a").mouseover();var numMonths=this._getNumberOfMonths(inst);var cols=numMonths[1];var width=17;inst.dpDiv.removeClass("ui-datepicker-multi-2 ui-datepicker-multi-3 ui-datepicker-multi-4").width("");if(cols>1){inst.dpDiv.addClass("ui-datepicker-multi-"+cols).css("width",(width*cols)+"em")}inst.dpDiv[(numMonths[0]!=1||numMonths[1]!=1?"add":"remove")+"Class"]("ui-datepicker-multi");inst.dpDiv[(this._get(inst,"isRTL")?"add":"remove")+"Class"]("ui-datepicker-rtl");if(inst==$.datepicker._curInst&&$.datepicker._datepickerShowing&&inst.input&&inst.input.is(":visible")&&!inst.input.is(":disabled")&&inst.input[0]!=document.activeElement){inst.input.focus()}if(inst.yearshtml){var origyearshtml=inst.yearshtml;setTimeout(function(){if(origyearshtml===inst.yearshtml&&inst.yearshtml){inst.dpDiv.find("select.ui-datepicker-year:first").replaceWith(inst.yearshtml)}origyearshtml=inst.yearshtml=null},0)}},_getBorders:function(elem){var convert=function(value){return{thin:1,medium:2,thick:3}[value]||value};return[parseFloat(convert(elem.css("border-left-width"))),parseFloat(convert(elem.css("border-top-width")))]},_checkOffset:function(inst,offset,isFixed){var dpWidth=inst.dpDiv.outerWidth();var dpHeight=inst.dpDiv.outerHeight();var inputWidth=inst.input?inst.input.outerWidth():0;var inputHeight=inst.input?inst.input.outerHeight():0;var viewWidth=document.documentElement.clientWidth+(isFixed?0:$(document).scrollLeft());var viewHeight=document.documentElement.clientHeight+(isFixed?0:$(document).scrollTop());offset.left-=(this._get(inst,"isRTL")?(dpWidth-inputWidth):0);offset.left-=(isFixed&&offset.left==inst.input.offset().left)?$(document).scrollLeft():0;offset.top-=(isFixed&&offset.top==(inst.input.offset().top+inputHeight))?$(document).scrollTop():0;offset.left-=Math.min(offset.left,(offset.left+dpWidth>viewWidth&&viewWidth>dpWidth)?Math.abs(offset.left+dpWidth-viewWidth):0);offset.top-=Math.min(offset.top,(offset.top+dpHeight>viewHeight&&viewHeight>dpHeight)?Math.abs(dpHeight+inputHeight):0);return offset},_findPos:function(obj){var inst=this._getInst(obj);var isRTL=this._get(inst,"isRTL");while(obj&&(obj.type=="hidden"||obj.nodeType!=1||$.expr.filters.hidden(obj))){obj=obj[isRTL?"previousSibling":"nextSibling"]}var position=$(obj).offset();return[position.left,position.top]},_hideDatepicker:function(input){var inst=this._curInst;if(!inst||(input&&inst!=$.data(input,PROP_NAME))){return}if(this._datepickerShowing){var showAnim=this._get(inst,"showAnim");var duration=this._get(inst,"duration");var postProcess=function(){$.datepicker._tidyDialog(inst)};if($.effects&&($.effects.effect[showAnim]||$.effects[showAnim])){inst.dpDiv.hide(showAnim,$.datepicker._get(inst,"showOptions"),duration,postProcess)}else{inst.dpDiv[(showAnim=="slideDown"?"slideUp":(showAnim=="fadeIn"?"fadeOut":"hide"))]((showAnim?duration:null),postProcess)}if(!showAnim){postProcess()}this._datepickerShowing=false;var onClose=this._get(inst,"onClose");if(onClose){onClose.apply((inst.input?inst.input[0]:null),[(inst.input?inst.input.val():""),inst])}this._lastInput=null;if(this._inDialog){this._dialogInput.css({position:"absolute",left:"0",top:"-100px"});if($.blockUI){$.unblockUI();$("body").append(this.dpDiv)}}this._inDialog=false}},_tidyDialog:function(inst){inst.dpDiv.removeClass(this._dialogClass).unbind(".ui-datepicker-calendar")},_checkExternalClick:function(event){if(!$.datepicker._curInst){return}var $target=$(event.target),inst=$.datepicker._getInst($target[0]);if((($target[0].id!=$.datepicker._mainDivId&&$target.parents("#"+$.datepicker._mainDivId).length==0&&!$target.hasClass($.datepicker.markerClassName)&&!$target.closest("."+$.datepicker._triggerClass).length&&$.datepicker._datepickerShowing&&!($.datepicker._inDialog&&$.blockUI)))||($target.hasClass($.datepicker.markerClassName)&&$.datepicker._curInst!=inst)){$.datepicker._hideDatepicker()}},_adjustDate:function(id,offset,period){var target=$(id);var inst=this._getInst(target[0]);if(this._isDisabledDatepicker(target[0])){return}this._adjustInstDate(inst,offset+(period=="M"?this._get(inst,"showCurrentAtPos"):0),period);this._updateDatepicker(inst)},_gotoToday:function(id){var target=$(id);var inst=this._getInst(target[0]);if(this._get(inst,"gotoCurrent")&&inst.currentDay){inst.selectedDay=inst.currentDay;inst.drawMonth=inst.selectedMonth=inst.currentMonth;inst.drawYear=inst.selectedYear=inst.currentYear}else{var date=new Date();inst.selectedDay=date.getDate();inst.drawMonth=inst.selectedMonth=date.getMonth();inst.drawYear=inst.selectedYear=date.getFullYear()}this._notifyChange(inst);this._adjustDate(target)},_selectMonthYear:function(id,select,period){var target=$(id);var inst=this._getInst(target[0]);inst["selected"+(period=="M"?"Month":"Year")]=inst["draw"+(period=="M"?"Month":"Year")]=parseInt(select.options[select.selectedIndex].value,10);this._notifyChange(inst);this._adjustDate(target)},_selectDay:function(id,month,year,td){var target=$(id);if($(td).hasClass(this._unselectableClass)||this._isDisabledDatepicker(target[0])){return}var inst=this._getInst(target[0]);inst.selectedDay=inst.currentDay=$("a",td).html();inst.selectedMonth=inst.currentMonth=month;inst.selectedYear=inst.currentYear=year;this._selectDate(id,this._formatDate(inst,inst.currentDay,inst.currentMonth,inst.currentYear))},_clearDate:function(id){var target=$(id);var inst=this._getInst(target[0]);this._selectDate(target,"")},_selectDate:function(id,dateStr){var target=$(id);var inst=this._getInst(target[0]);dateStr=(dateStr!=null?dateStr:this._formatDate(inst));if(inst.input){inst.input.val(dateStr)}this._updateAlternate(inst);var onSelect=this._get(inst,"onSelect");if(onSelect){onSelect.apply((inst.input?inst.input[0]:null),[dateStr,inst])}else{if(inst.input){inst.input.trigger("change")}}if(inst.inline){this._updateDatepicker(inst)}else{this._hideDatepicker();this._lastInput=inst.input[0];if(typeof(inst.input[0])!="object"){inst.input.focus()}this._lastInput=null}},_updateAlternate:function(inst){var altField=this._get(inst,"altField");if(altField){var altFormat=this._get(inst,"altFormat")||this._get(inst,"dateFormat");var date=this._getDate(inst);var dateStr=this.formatDate(altFormat,date,this._getFormatConfig(inst));$(altField).each(function(){$(this).val(dateStr)})}},noWeekends:function(date){var day=date.getDay();return[(day>0&&day<6),""]},iso8601Week:function(date){var checkDate=new Date(date.getTime());checkDate.setDate(checkDate.getDate()+4-(checkDate.getDay()||7));var time=checkDate.getTime();checkDate.setMonth(0);checkDate.setDate(1);return Math.floor(Math.round((time-checkDate)/86400000)/7)+1},parseDate:function(format,value,settings){if(format==null||value==null){throw"Invalid arguments"}value=(typeof value=="object"?value.toString():value+"");if(value==""){return null}var shortYearCutoff=(settings?settings.shortYearCutoff:null)||this._defaults.shortYearCutoff;shortYearCutoff=(typeof shortYearCutoff!="string"?shortYearCutoff:new Date().getFullYear()%100+parseInt(shortYearCutoff,10));var dayNamesShort=(settings?settings.dayNamesShort:null)||this._defaults.dayNamesShort;var dayNames=(settings?settings.dayNames:null)||this._defaults.dayNames;var monthNamesShort=(settings?settings.monthNamesShort:null)||this._defaults.monthNamesShort;var monthNames=(settings?settings.monthNames:null)||this._defaults.monthNames;var year=-1;var month=-1;var day=-1;var doy=-1;var literal=false;var lookAhead=function(match){var matches=(iFormat+1<format.length&&format.charAt(iFormat+1)==match);if(matches){iFormat++}return matches};var getNumber=function(match){var isDoubled=lookAhead(match);var size=(match=="@"?14:(match=="!"?20:(match=="y"&&isDoubled?4:(match=="o"?3:2))));var digits=new RegExp("^\\d{1,"+size+"}");var num=value.substring(iValue).match(digits);if(!num){throw"Missing number at position "+iValue}iValue+=num[0].length;return parseInt(num[0],10)};var getName=function(match,shortNames,longNames){var names=$.map(lookAhead(match)?longNames:shortNames,function(v,k){return[[k,v]]}).sort(function(a,b){return -(a[1].length-b[1].length)});var index=-1;$.each(names,function(i,pair){var name=pair[1];if(value.substr(iValue,name.length).toLowerCase()==name.toLowerCase()){index=pair[0];iValue+=name.length;return false}});if(index!=-1){return index+1}else{throw"Unknown name at position "+iValue}};var checkLiteral=function(){if(value.charAt(iValue)!=format.charAt(iFormat)){throw"Unexpected literal at position "+iValue}iValue++};var iValue=0;for(var iFormat=0;iFormat<format.length;iFormat++){if(literal){if(format.charAt(iFormat)=="'"&&!lookAhead("'")){literal=false}else{checkLiteral()}}else{switch(format.charAt(iFormat)){case"d":day=getNumber("d");break;case"D":getName("D",dayNamesShort,dayNames);break;case"o":doy=getNumber("o");break;case"m":month=getNumber("m");break;case"M":month=getName("M",monthNamesShort,monthNames);break;case"y":year=getNumber("y");break;case"@":var date=new Date(getNumber("@"));year=date.getFullYear();month=date.getMonth()+1;day=date.getDate();break;case"!":var date=new Date((getNumber("!")-this._ticksTo1970)/10000);year=date.getFullYear();month=date.getMonth()+1;day=date.getDate();break;case"'":if(lookAhead("'")){checkLiteral()}else{literal=true}break;default:checkLiteral()}}}if(iValue<value.length){var extra=value.substr(iValue);if(!/^\s+/.test(extra)){throw"Extra/unparsed characters found in date: "+extra}}if(year==-1){year=new Date().getFullYear()}else{if(year<100){year+=new Date().getFullYear()-new Date().getFullYear()%100+(year<=shortYearCutoff?0:-100)}}if(doy>-1){month=1;day=doy;do{var dim=this._getDaysInMonth(year,month-1);if(day<=dim){break}month++;day-=dim}while(true)}var date=this._daylightSavingAdjust(new Date(year,month-1,day));if(date.getFullYear()!=year||date.getMonth()+1!=month||date.getDate()!=day){throw"Invalid date"}return date},ATOM:"yy-mm-dd",COOKIE:"D, dd M yy",ISO_8601:"yy-mm-dd",RFC_822:"D, d M y",RFC_850:"DD, dd-M-y",RFC_1036:"D, d M y",RFC_1123:"D, d M yy",RFC_2822:"D, d M yy",RSS:"D, d M y",TICKS:"!",TIMESTAMP:"@",W3C:"yy-mm-dd",_ticksTo1970:(((1970-1)*365+Math.floor(1970/4)-Math.floor(1970/100)+Math.floor(1970/400))*24*60*60*10000000),formatDate:function(format,date,settings){if(!date){return""}var dayNamesShort=(settings?settings.dayNamesShort:null)||this._defaults.dayNamesShort;var dayNames=(settings?settings.dayNames:null)||this._defaults.dayNames;var monthNamesShort=(settings?settings.monthNamesShort:null)||this._defaults.monthNamesShort;var monthNames=(settings?settings.monthNames:null)||this._defaults.monthNames;var lookAhead=function(match){var matches=(iFormat+1<format.length&&format.charAt(iFormat+1)==match);if(matches){iFormat++}return matches};var formatNumber=function(match,value,len){var num=""+value;if(lookAhead(match)){while(num.length<len){num="0"+num}}return num};var formatName=function(match,value,shortNames,longNames){return(lookAhead(match)?longNames[value]:shortNames[value])};var output="";var literal=false;if(date){for(var iFormat=0;iFormat<format.length;iFormat++){if(literal){if(format.charAt(iFormat)=="'"&&!lookAhead("'")){literal=false}else{output+=format.charAt(iFormat)}}else{switch(format.charAt(iFormat)){case"d":output+=formatNumber("d",date.getDate(),2);break;case"D":output+=formatName("D",date.getDay(),dayNamesShort,dayNames);break;case"o":output+=formatNumber("o",Math.round((new Date(date.getFullYear(),date.getMonth(),date.getDate()).getTime()-new Date(date.getFullYear(),0,0).getTime())/86400000),3);break;case"m":output+=formatNumber("m",date.getMonth()+1,2);break;case"M":output+=formatName("M",date.getMonth(),monthNamesShort,monthNames);break;case"y":output+=(lookAhead("y")?date.getFullYear():(date.getYear()%100<10?"0":"")+date.getYear()%100);break;case"@":output+=date.getTime();break;case"!":output+=date.getTime()*10000+this._ticksTo1970;break;case"'":if(lookAhead("'")){output+="'"}else{literal=true}break;default:output+=format.charAt(iFormat)}}}}return output},_possibleChars:function(format){var chars="";var literal=false;var lookAhead=function(match){var matches=(iFormat+1<format.length&&format.charAt(iFormat+1)==match);if(matches){iFormat++}return matches};for(var iFormat=0;iFormat<format.length;iFormat++){if(literal){if(format.charAt(iFormat)=="'"&&!lookAhead("'")){literal=false}else{chars+=format.charAt(iFormat)}}else{switch(format.charAt(iFormat)){case"d":case"m":case"y":case"@":chars+="0123456789";break;case"D":case"M":return null;case"'":if(lookAhead("'")){chars+="'"}else{literal=true}break;default:chars+=format.charAt(iFormat)}}}return chars},_get:function(inst,name){return inst.settings[name]!==undefined?inst.settings[name]:this._defaults[name]},_setDateFromField:function(inst,noDefault){if(inst.input.val()==inst.lastVal){return}var dateFormat=this._get(inst,"dateFormat");var dates=inst.lastVal=inst.input?inst.input.val():null;var date,defaultDate;date=defaultDate=this._getDefaultDate(inst);var settings=this._getFormatConfig(inst);try{date=this.parseDate(dateFormat,dates,settings)||defaultDate}catch(event){this.log(event);dates=(noDefault?"":dates)}inst.selectedDay=date.getDate();inst.drawMonth=inst.selectedMonth=date.getMonth();inst.drawYear=inst.selectedYear=date.getFullYear();inst.currentDay=(dates?date.getDate():0);inst.currentMonth=(dates?date.getMonth():0);inst.currentYear=(dates?date.getFullYear():0);this._adjustInstDate(inst)},_getDefaultDate:function(inst){return this._restrictMinMax(inst,this._determineDate(inst,this._get(inst,"defaultDate"),new Date()))},_determineDate:function(inst,date,defaultDate){var offsetNumeric=function(offset){var date=new Date();date.setDate(date.getDate()+offset);return date};var offsetString=function(offset){try{return $.datepicker.parseDate($.datepicker._get(inst,"dateFormat"),offset,$.datepicker._getFormatConfig(inst))}catch(e){}var date=(offset.toLowerCase().match(/^c/)?$.datepicker._getDate(inst):null)||new Date();var year=date.getFullYear();var month=date.getMonth();var day=date.getDate();var pattern=/([+-]?[0-9]+)\s*(d|D|w|W|m|M|y|Y)?/g;var matches=pattern.exec(offset);while(matches){switch(matches[2]||"d"){case"d":case"D":day+=parseInt(matches[1],10);break;case"w":case"W":day+=parseInt(matches[1],10)*7;break;case"m":case"M":month+=parseInt(matches[1],10);day=Math.min(day,$.datepicker._getDaysInMonth(year,month));break;case"y":case"Y":year+=parseInt(matches[1],10);day=Math.min(day,$.datepicker._getDaysInMonth(year,month));break}matches=pattern.exec(offset)}return new Date(year,month,day)};var newDate=(date==null||date===""?defaultDate:(typeof date=="string"?offsetString(date):(typeof date=="number"?(isNaN(date)?defaultDate:offsetNumeric(date)):new Date(date.getTime()))));newDate=(newDate&&newDate.toString()=="Invalid Date"?defaultDate:newDate);if(newDate){newDate.setHours(0);newDate.setMinutes(0);newDate.setSeconds(0);newDate.setMilliseconds(0)}return this._daylightSavingAdjust(newDate)},_daylightSavingAdjust:function(date){if(!date){return null}date.setHours(date.getHours()>12?date.getHours()+2:0);return date},_setDate:function(inst,date,noChange){var clear=!date;var origMonth=inst.selectedMonth;var origYear=inst.selectedYear;var newDate=this._restrictMinMax(inst,this._determineDate(inst,date,new Date()));inst.selectedDay=inst.currentDay=newDate.getDate();inst.drawMonth=inst.selectedMonth=inst.currentMonth=newDate.getMonth();inst.drawYear=inst.selectedYear=inst.currentYear=newDate.getFullYear();if((origMonth!=inst.selectedMonth||origYear!=inst.selectedYear)&&!noChange){this._notifyChange(inst)}this._adjustInstDate(inst);if(inst.input){inst.input.val(clear?"":this._formatDate(inst))}},_getDate:function(inst){var startDate=(!inst.currentYear||(inst.input&&inst.input.val()=="")?null:this._daylightSavingAdjust(new Date(inst.currentYear,inst.currentMonth,inst.currentDay)));return startDate},_attachHandlers:function(inst){var stepMonths=this._get(inst,"stepMonths");var id="#"+inst.id.replace(/\\\\/g,"\\");inst.dpDiv.find("[data-handler]").map(function(){var handler={prev:function(){window["DP_jQuery_"+dpuuid].datepicker._adjustDate(id,-stepMonths,"M")},next:function(){window["DP_jQuery_"+dpuuid].datepicker._adjustDate(id,+stepMonths,"M")},hide:function(){window["DP_jQuery_"+dpuuid].datepicker._hideDatepicker()},today:function(){window["DP_jQuery_"+dpuuid].datepicker._gotoToday(id)},selectDay:function(){window["DP_jQuery_"+dpuuid].datepicker._selectDay(id,+this.getAttribute("data-month"),+this.getAttribute("data-year"),this);return false},selectMonth:function(){window["DP_jQuery_"+dpuuid].datepicker._selectMonthYear(id,this,"M");return false},selectYear:function(){window["DP_jQuery_"+dpuuid].datepicker._selectMonthYear(id,this,"Y");return false}};$(this).bind(this.getAttribute("data-event"),handler[this.getAttribute("data-handler")])})},_generateHTML:function(inst){var today=new Date();today=this._daylightSavingAdjust(new Date(today.getFullYear(),today.getMonth(),today.getDate()));var isRTL=this._get(inst,"isRTL");var showButtonPanel=this._get(inst,"showButtonPanel");var showClearButton=this._get(inst,"showClearButton");var hideIfNoPrevNext=this._get(inst,"hideIfNoPrevNext");var navigationAsDateFormat=this._get(inst,"navigationAsDateFormat");var numMonths=this._getNumberOfMonths(inst);var showCurrentAtPos=this._get(inst,"showCurrentAtPos");var stepMonths=this._get(inst,"stepMonths");var isMultiMonth=(numMonths[0]!=1||numMonths[1]!=1);var currentDate=this._daylightSavingAdjust((!inst.currentDay?new Date(9999,9,9):new Date(inst.currentYear,inst.currentMonth,inst.currentDay)));var minDate=this._getMinMaxDate(inst,"min");var maxDate=this._getMinMaxDate(inst,"max");var drawMonth=inst.drawMonth-showCurrentAtPos;var drawYear=inst.drawYear;if(drawMonth<0){drawMonth+=12;drawYear--}if(maxDate){var maxDraw=this._daylightSavingAdjust(new Date(maxDate.getFullYear(),maxDate.getMonth()-(numMonths[0]*numMonths[1])+1,maxDate.getDate()));maxDraw=(minDate&&maxDraw<minDate?minDate:maxDraw);while(this._daylightSavingAdjust(new Date(drawYear,drawMonth,1))>maxDraw){drawMonth--;if(drawMonth<0){drawMonth=11;drawYear--}}}inst.drawMonth=drawMonth;inst.drawYear=drawYear;var prevText=this._get(inst,"prevText");prevText=(!navigationAsDateFormat?prevText:this.formatDate(prevText,this._daylightSavingAdjust(new Date(drawYear,drawMonth-stepMonths,1)),this._getFormatConfig(inst)));var prev=(this._canAdjustMonth(inst,-1,drawYear,drawMonth)?'<a class="ui-datepicker-prev ui-corner-all" data-handler="prev" data-event="click" title="'+prevText+'"><span class="ui-icon ui-icon-circle-triangle-'+(isRTL?"e":"w")+'">'+prevText+"</span></a>":(hideIfNoPrevNext?"":'<a class="ui-datepicker-prev ui-corner-all ui-state-disabled" title="'+prevText+'"><span class="ui-icon ui-icon-circle-triangle-'+(isRTL?"e":"w")+'">'+prevText+"</span></a>"));var nextText=this._get(inst,"nextText");nextText=(!navigationAsDateFormat?nextText:this.formatDate(nextText,this._daylightSavingAdjust(new Date(drawYear,drawMonth+stepMonths,1)),this._getFormatConfig(inst)));var next=(this._canAdjustMonth(inst,+1,drawYear,drawMonth)?'<a class="ui-datepicker-next ui-corner-all" data-handler="next" data-event="click" title="'+nextText+'"><span class="ui-icon ui-icon-circle-triangle-'+(isRTL?"w":"e")+'">'+nextText+"</span></a>":(hideIfNoPrevNext?"":'<a class="ui-datepicker-next ui-corner-all ui-state-disabled" title="'+nextText+'"><span class="ui-icon ui-icon-circle-triangle-'+(isRTL?"w":"e")+'">'+nextText+"</span></a>"));var clearControl='<button type="button" class="ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all" onclick="DP_jQuery_'+dpuuid+".datepicker._clearDate('#"+inst.id+"');\">"+this._get(inst,"clearText")+"</button>";var currentText=this._get(inst,"currentText");var gotoDate=(this._get(inst,"gotoCurrent")&&inst.currentDay?currentDate:today);currentText=(!navigationAsDateFormat?currentText:this.formatDate(currentText,gotoDate,this._getFormatConfig(inst)));var controls=(!inst.inline?'<button type="button" class="ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all" data-handler="hide" data-event="click">'+this._get(inst,"closeText")+"</button>":"");var buttonPanel=(showButtonPanel)?'<div class="ui-datepicker-buttonpane ui-widget-content">'+(isRTL?controls:"")+(this._isInRange(inst,gotoDate)?'<button type="button" class="ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all" data-handler="today" data-event="click">'+currentText+"</button>":"")+(isRTL?"":controls)+((showClearButton)?clearControl:"")+"</div>":"";var firstDay=parseInt(this._get(inst,"firstDay"),10);firstDay=(isNaN(firstDay)?0:firstDay);var showWeek=this._get(inst,"showWeek");var dayNames=this._get(inst,"dayNames");var dayNamesShort=this._get(inst,"dayNamesShort");var dayNamesMin=this._get(inst,"dayNamesMin");var monthNames=this._get(inst,"monthNames");var monthNamesShort=this._get(inst,"monthNamesShort");var beforeShowDay=this._get(inst,"beforeShowDay");var showOtherMonths=this._get(inst,"showOtherMonths");var selectOtherMonths=this._get(inst,"selectOtherMonths");var calculateWeek=this._get(inst,"calculateWeek")||this.iso8601Week;var defaultDate=this._getDefaultDate(inst);var html="";for(var row=0;row<numMonths[0];row++){var group="";this.maxRows=4;for(var col=0;col<numMonths[1];col++){var selectedDate=this._daylightSavingAdjust(new Date(drawYear,drawMonth,inst.selectedDay));var cornerClass=" ui-corner-all";var calender="";if(isMultiMonth){calender+='<div class="ui-datepicker-group';if(numMonths[1]>1){switch(col){case 0:calender+=" ui-datepicker-group-first";cornerClass=" ui-corner-"+(isRTL?"right":"left");break;case numMonths[1]-1:calender+=" ui-datepicker-group-last";cornerClass=" ui-corner-"+(isRTL?"left":"right");break;default:calender+=" ui-datepicker-group-middle";cornerClass="";break}}calender+='">'}calender+='<div class="ui-datepicker-header ui-widget-header ui-helper-clearfix'+cornerClass+'">'+(/all|left/.test(cornerClass)&&row==0?(isRTL?next:prev):"")+(/all|right/.test(cornerClass)&&row==0?(isRTL?prev:next):"")+this._generateMonthYearHeader(inst,drawMonth,drawYear,minDate,maxDate,row>0||col>0,monthNames,monthNamesShort)+'</div><table class="ui-datepicker-calendar"><thead><tr>';var thead=(showWeek?'<th class="ui-datepicker-week-col">'+this._get(inst,"weekHeader")+"</th>":"");for(var dow=0;dow<7;dow++){var day=(dow+firstDay)%7;thead+="<th"+((dow+firstDay+6)%7>=5?' class="ui-datepicker-week-end"':"")+'><span title="'+dayNames[day]+'">'+dayNamesMin[day]+"</span></th>"}calender+=thead+"</tr></thead><tbody>";var daysInMonth=this._getDaysInMonth(drawYear,drawMonth);if(drawYear==inst.selectedYear&&drawMonth==inst.selectedMonth){inst.selectedDay=Math.min(inst.selectedDay,daysInMonth)}var leadDays=(this._getFirstDayOfMonth(drawYear,drawMonth)-firstDay+7)%7;var curRows=Math.ceil((leadDays+daysInMonth)/7);var numRows=(isMultiMonth?this.maxRows>curRows?this.maxRows:curRows:curRows);this.maxRows=numRows;var printDate=this._daylightSavingAdjust(new Date(drawYear,drawMonth,1-leadDays));for(var dRow=0;dRow<numRows;dRow++){calender+="<tr>";var tbody=(!showWeek?"":'<td class="ui-datepicker-week-col">'+this._get(inst,"calculateWeek")(printDate)+"</td>");for(var dow=0;dow<7;dow++){var daySettings=(beforeShowDay?beforeShowDay.apply((inst.input?inst.input[0]:null),[printDate]):[true,""]);var otherMonth=(printDate.getMonth()!=drawMonth);var unselectable=(otherMonth&&!selectOtherMonths)||!daySettings[0]||(minDate&&printDate<minDate)||(maxDate&&printDate>maxDate);tbody+='<td class="'+((dow+firstDay+6)%7>=5?" ui-datepicker-week-end":"")+(otherMonth?" ui-datepicker-other-month":"")+((printDate.getTime()==selectedDate.getTime()&&drawMonth==inst.selectedMonth&&inst._keyEvent)||(defaultDate.getTime()==printDate.getTime()&&defaultDate.getTime()==selectedDate.getTime())?" "+this._dayOverClass:"")+(unselectable?" "+this._unselectableClass+" ui-state-disabled":"")+(otherMonth&&!showOtherMonths?"":" "+daySettings[1]+(printDate.getTime()==currentDate.getTime()?" "+this._currentClass:"")+(printDate.getTime()==today.getTime()?" ui-datepicker-today":""))+'"'+((!otherMonth||showOtherMonths)&&daySettings[2]?' title="'+daySettings[2]+'"':"")+(unselectable?"":' data-handler="selectDay" data-event="click" data-month="'+printDate.getMonth()+'" data-year="'+printDate.getFullYear()+'"')+">"+(otherMonth&&!showOtherMonths?"&#xa0;":(unselectable?'<span class="ui-state-default">'+printDate.getDate()+"</span>":'<a class="ui-state-default'+(printDate.getTime()==today.getTime()?" ui-state-highlight":"")+(printDate.getTime()==currentDate.getTime()?" ui-state-active":"")+(otherMonth?" ui-priority-secondary":"")+'" href="#">'+printDate.getDate()+"</a>"))+"</td>";printDate.setDate(printDate.getDate()+1);printDate=this._daylightSavingAdjust(printDate)}calender+=tbody+"</tr>"}drawMonth++;if(drawMonth>11){drawMonth=0;drawYear++}calender+="</tbody></table>"+(isMultiMonth?"</div>"+((numMonths[0]>0&&col==numMonths[1]-1)?'<div class="ui-datepicker-row-break"></div>':""):"");group+=calender}html+=group}html+=buttonPanel+($.ui.ie6&&!inst.inline?'<iframe src="javascript:false;" class="ui-datepicker-cover" frameborder="0"></iframe>':"");inst._keyEvent=false;return html},_generateMonthYearHeader:function(inst,drawMonth,drawYear,minDate,maxDate,secondary,monthNames,monthNamesShort){var changeMonth=this._get(inst,"changeMonth");var changeYear=this._get(inst,"changeYear");var showMonthAfterYear=this._get(inst,"showMonthAfterYear");var html='<div class="ui-datepicker-title">';var monthHtml="";if(secondary||!changeMonth){monthHtml+='<span class="ui-datepicker-month">'+monthNames[drawMonth]+"</span>"}else{var inMinYear=(minDate&&minDate.getFullYear()==drawYear);var inMaxYear=(maxDate&&maxDate.getFullYear()==drawYear);monthHtml+='<select class="ui-datepicker-month" data-handler="selectMonth" data-event="change">';for(var month=0;month<12;month++){if((!inMinYear||month>=minDate.getMonth())&&(!inMaxYear||month<=maxDate.getMonth())){monthHtml+='<option value="'+month+'"'+(month==drawMonth?' selected="selected"':"")+">"+monthNamesShort[month]+"</option>"}}monthHtml+="</select>"}if(!showMonthAfterYear){html+=monthHtml+(secondary||!(changeMonth&&changeYear)?"&#xa0;":"")}if(!inst.yearshtml){inst.yearshtml="";if(secondary||!changeYear){html+='<span class="ui-datepicker-year">'+drawYear+"</span>"}else{var years=this._get(inst,"yearRange").split(":");var thisYear=new Date().getFullYear();var determineYear=function(value){var year=(value.match(/c[+-].*/)?drawYear+parseInt(value.substring(1),10):(value.match(/[+-].*/)?thisYear+parseInt(value,10):parseInt(value,10)));return(isNaN(year)?thisYear:year)};var year=determineYear(years[0]);var endYear=Math.max(year,determineYear(years[1]||""));year=(minDate?Math.max(year,minDate.getFullYear()):year);endYear=(maxDate?Math.min(endYear,maxDate.getFullYear()):endYear);inst.yearshtml+='<select class="ui-datepicker-year" data-handler="selectYear" data-event="change">';for(;year<=endYear;year++){inst.yearshtml+='<option value="'+year+'"'+(year==drawYear?' selected="selected"':"")+">"+year+"</option>"}inst.yearshtml+="</select>";html+=inst.yearshtml;inst.yearshtml=null}}html+=this._get(inst,"yearSuffix");if(showMonthAfterYear){html+=(secondary||!(changeMonth&&changeYear)?"&#xa0;":"")+monthHtml}html+="</div>";return html},_adjustInstDate:function(inst,offset,period){var year=inst.drawYear+(period=="Y"?offset:0);var month=inst.drawMonth+(period=="M"?offset:0);var day=Math.min(inst.selectedDay,this._getDaysInMonth(year,month))+(period=="D"?offset:0);var date=this._restrictMinMax(inst,this._daylightSavingAdjust(new Date(year,month,day)));inst.selectedDay=date.getDate();inst.drawMonth=inst.selectedMonth=date.getMonth();inst.drawYear=inst.selectedYear=date.getFullYear();if(period=="M"||period=="Y"){this._notifyChange(inst)}},_restrictMinMax:function(inst,date){var minDate=this._getMinMaxDate(inst,"min");var maxDate=this._getMinMaxDate(inst,"max");var newDate=(minDate&&date<minDate?minDate:date);newDate=(maxDate&&newDate>maxDate?maxDate:newDate);return newDate},_notifyChange:function(inst){var onChange=this._get(inst,"onChangeMonthYear");if(onChange){onChange.apply((inst.input?inst.input[0]:null),[inst.selectedYear,inst.selectedMonth+1,inst])}},_getNumberOfMonths:function(inst){var numMonths=this._get(inst,"numberOfMonths");return(numMonths==null?[1,1]:(typeof numMonths=="number"?[1,numMonths]:numMonths))},_getMinMaxDate:function(inst,minMax){return this._determineDate(inst,this._get(inst,minMax+"Date"),null)},_getDaysInMonth:function(year,month){return 32-this._daylightSavingAdjust(new Date(year,month,32)).getDate()},_getFirstDayOfMonth:function(year,month){return new Date(year,month,1).getDay()},_canAdjustMonth:function(inst,offset,curYear,curMonth){var numMonths=this._getNumberOfMonths(inst);var date=this._daylightSavingAdjust(new Date(curYear,curMonth+(offset<0?offset:numMonths[0]*numMonths[1]),1));if(offset<0){date.setDate(this._getDaysInMonth(date.getFullYear(),date.getMonth()))}return this._isInRange(inst,date)},_isInRange:function(inst,date){var minDate=this._getMinMaxDate(inst,"min");var maxDate=this._getMinMaxDate(inst,"max");return((!minDate||date.getTime()>=minDate.getTime())&&(!maxDate||date.getTime()<=maxDate.getTime()))},_getFormatConfig:function(inst){var shortYearCutoff=this._get(inst,"shortYearCutoff");shortYearCutoff=(typeof shortYearCutoff!="string"?shortYearCutoff:new Date().getFullYear()%100+parseInt(shortYearCutoff,10));return{shortYearCutoff:shortYearCutoff,dayNamesShort:this._get(inst,"dayNamesShort"),dayNames:this._get(inst,"dayNames"),monthNamesShort:this._get(inst,"monthNamesShort"),monthNames:this._get(inst,"monthNames")}},_formatDate:function(inst,day,month,year){if(!day){inst.currentDay=inst.selectedDay;inst.currentMonth=inst.selectedMonth;inst.currentYear=inst.selectedYear}var date=(day?(typeof day=="object"?day:this._daylightSavingAdjust(new Date(year,month,day))):this._daylightSavingAdjust(new Date(inst.currentYear,inst.currentMonth,inst.currentDay)));return this.formatDate(this._get(inst,"dateFormat"),date,this._getFormatConfig(inst))}});function bindHover(dpDiv){var selector="button, .ui-datepicker-prev, .ui-datepicker-next, .ui-datepicker-calendar td a";return dpDiv.delegate(selector,"mouseout",function(){$(this).removeClass("ui-state-hover");if(this.className.indexOf("ui-datepicker-prev")!=-1){$(this).removeClass("ui-datepicker-prev-hover")}if(this.className.indexOf("ui-datepicker-next")!=-1){$(this).removeClass("ui-datepicker-next-hover")}}).delegate(selector,"mouseover",function(){if(!$.datepicker._isDisabledDatepicker(instActive.inline?dpDiv.parent()[0]:instActive.input[0])){$(this).parents(".ui-datepicker-calendar").find("a").removeClass("ui-state-hover");$(this).addClass("ui-state-hover");if(this.className.indexOf("ui-datepicker-prev")!=-1){$(this).addClass("ui-datepicker-prev-hover")}if(this.className.indexOf("ui-datepicker-next")!=-1){$(this).addClass("ui-datepicker-next-hover")}}})}function extendRemove(target,props){$.extend(target,props);for(var name in props){if(props[name]==null||props[name]==undefined){target[name]=props[name]}}return target}$.fn.datepicker=function(options){if(!this.length){return this}if(!$.datepicker.initialized){$(document).mousedown($.datepicker._checkExternalClick).find(document.body).append($.datepicker.dpDiv);$.datepicker.initialized=true}var otherArgs=Array.prototype.slice.call(arguments,1);if(typeof options=="string"&&(options=="isDisabled"||options=="getDate"||options=="widget")){return $.datepicker["_"+options+"Datepicker"].apply($.datepicker,[this[0]].concat(otherArgs))}if(options=="option"&&arguments.length==2&&typeof arguments[1]=="string"){return $.datepicker["_"+options+"Datepicker"].apply($.datepicker,[this[0]].concat(otherArgs))}return this.each(function(){typeof options=="string"?$.datepicker["_"+options+"Datepicker"].apply($.datepicker,[this].concat(otherArgs)):$.datepicker._attachDatepicker(this,options)})};$.datepicker=new Datepicker();$.datepicker.initialized=false;$.datepicker.uuid=new Date().getTime();$.datepicker.version="1.9.2";window["DP_jQuery_"+dpuuid]=$})(jQuery);(function(a,e){var d="ui-dialog ui-widget ui-widget-content ui-corner-all ",c={buttons:true,height:true,maxHeight:true,maxWidth:true,minHeight:true,minWidth:true,width:true},b={maxHeight:true,maxWidth:true,minHeight:true,minWidth:true};a.widget("ui.dialog",{version:"1.9.2",options:{autoOpen:true,buttons:{},closeOnEscape:true,closeText:"close",dialogClass:"",draggable:true,hide:null,height:"auto",maxHeight:false,maxWidth:false,minHeight:150,minWidth:150,modal:false,position:{my:"center",at:"center",of:window,collision:"fit",using:function(f){var g=a(this).css(f).offset().top;if(g<0){a(this).css("top",f.top-g)}}},resizable:true,show:null,stack:true,title:"",width:300,zIndex:1000},_create:function(){this.originalTitle=this.element.attr("title");if(typeof this.originalTitle!=="string"){this.originalTitle=""}this.oldPosition={parent:this.element.parent(),index:this.element.parent().children().index(this.element)};this.options.title=this.options.title||this.originalTitle;var g=this,f=this.options,h=f.title||"&#160;",i,l,m,k,j;i=(this.uiDialog=a("<div>")).addClass(d+f.dialogClass).css({display:"none",outline:0,zIndex:f.zIndex}).attr("tabIndex",-1).keydown(function(n){if(f.closeOnEscape&&!n.isDefaultPrevented()&&n.keyCode&&n.keyCode===a.ui.keyCode.ESCAPE){g.close(n);n.preventDefault()}}).mousedown(function(n){g.moveToTop(false,n)}).appendTo("body");this.element.show().removeAttr("title").addClass("ui-dialog-content ui-widget-content").appendTo(i);l=(this.uiDialogTitlebar=a("<div>")).addClass("ui-dialog-titlebar  ui-widget-header  ui-corner-all  ui-helper-clearfix").bind("mousedown",function(){i.focus()}).prependTo(i);m=a("<a href='#'></a>").addClass("ui-dialog-titlebar-close  ui-corner-all").attr("role","button").click(function(n){n.preventDefault();g.close(n)}).appendTo(l);(this.uiDialogTitlebarCloseText=a("<span>")).addClass("ui-icon ui-icon-closethick").text(f.closeText).appendTo(m);k=a("<span>").uniqueId().addClass("ui-dialog-title").html(h).prependTo(l);j=(this.uiDialogButtonPane=a("<div>")).addClass("ui-dialog-buttonpane ui-widget-content ui-helper-clearfix");(this.uiButtonSet=a("<div>")).addClass("ui-dialog-buttonset").appendTo(j);i.attr({role:"dialog","aria-labelledby":k.attr("id")});l.find("*").add(l).disableSelection();this._hoverable(m);this._focusable(m);if(f.draggable&&a.fn.draggable){this._makeDraggable()}if(f.resizable&&a.fn.resizable){this._makeResizable()}this._createButtons(f.buttons);this._isOpen=false;if(a.fn.bgiframe){i.bgiframe()}this._on(i,{keydown:function(n){if(!f.modal||n.keyCode!==a.ui.keyCode.TAB){return}var q=a(":tabbable",i),o=q.filter(":first"),p=q.filter(":last");if(n.target===p[0]&&!n.shiftKey){o.focus(1);return false}else{if(n.target===o[0]&&n.shiftKey){p.focus(1);return false}}}})},_init:function(){if(this.options.autoOpen){this.open()}},_destroy:function(){var f,g=this.oldPosition;if(this.overlay){this.overlay.destroy()}this.uiDialog.hide();this.element.removeClass("ui-dialog-content ui-widget-content").hide().appendTo("body");this.uiDialog.remove();if(this.originalTitle){this.element.attr("title",this.originalTitle)}f=g.parent.children().eq(g.index);if(f.length&&f[0]!==this.element[0]){f.before(this.element)}else{g.parent.append(this.element)}},widget:function(){return this.uiDialog},close:function(f){var h=this,g,i;if(!this._isOpen){return}if(false===this._trigger("beforeClose",f)){return}this._isOpen=false;if(this.overlay){this.overlay.destroy()}if(this.options.hide){this._hide(this.uiDialog,this.options.hide,function(){h._trigger("close",f)})}else{this.uiDialog.hide();this._trigger("close",f)}a.ui.dialog.overlay.resize();if(this.options.modal){g=0;a(".ui-dialog").each(function(){if(this!==h.uiDialog[0]){i=a(this).css("z-index");if(!isNaN(i)){g=Math.max(g,i)}}});a.ui.dialog.maxZ=g}return this},isOpen:function(){return this._isOpen},moveToTop:function(g,f){var h=this.options,i;if((h.modal&&!g)||(!h.stack&&!h.modal)){return this._trigger("focus",f)}if(h.zIndex>a.ui.dialog.maxZ){a.ui.dialog.maxZ=h.zIndex}if(this.overlay){a.ui.dialog.maxZ+=1;a.ui.dialog.overlay.maxZ=a.ui.dialog.maxZ;this.overlay.$el.css("z-index",a.ui.dialog.overlay.maxZ)}i={scrollTop:this.element.scrollTop(),scrollLeft:this.element.scrollLeft()};a.ui.dialog.maxZ+=1;this.uiDialog.css("z-index",a.ui.dialog.maxZ);this.element.attr(i);this._trigger("focus",f);return this},open:function(){if(this._isOpen){return}var f,g=this.options,h=this.uiDialog;this._size();this._position(g.position);h.show(g.show);this.overlay=g.modal?new a.ui.dialog.overlay(this):null;this.moveToTop(true);f=this.element.find(":tabbable");if(!f.length){f=this.uiDialogButtonPane.find(":tabbable");if(!f.length){f=h}}f.eq(0).focus();this._isOpen=true;this._trigger("open");return this},_createButtons:function(f){var h=this,g=false;this.uiDialogButtonPane.remove();this.uiButtonSet.empty();if(typeof f==="object"&&f!==null){a.each(f,function(){return !(g=true)})}if(g){a.each(f,function(k,l){var i,j;l=a.isFunction(l)?{click:l,text:k}:l;l=a.extend({type:"button"},l);j=l.click;l.click=function(){j.apply(h.element[0],arguments)};i=a("<button></button>",l).appendTo(h.uiButtonSet);if(a.fn.button){i.button()}});this.uiDialog.addClass("ui-dialog-buttons");this.uiDialogButtonPane.appendTo(this.uiDialog)}else{this.uiDialog.removeClass("ui-dialog-buttons")}},_makeDraggable:function(){var h=this,g=this.options;function f(i){return{position:i.position,offset:i.offset}}this.uiDialog.draggable({cancel:".ui-dialog-content, .ui-dialog-titlebar-close",handle:".ui-dialog-titlebar",containment:"document",start:function(i,j){a(this).addClass("ui-dialog-dragging");h._trigger("dragStart",i,f(j))},drag:function(i,j){h._trigger("drag",i,f(j))},stop:function(i,j){g.position=[j.position.left-h.document.scrollLeft(),j.position.top-h.document.scrollTop()];a(this).removeClass("ui-dialog-dragging");h._trigger("dragStop",i,f(j));a.ui.dialog.overlay.resize()}})},_makeResizable:function(g){g=(g===e?this.options.resizable:g);var k=this,h=this.options,i=this.uiDialog.css("position"),j=typeof g==="string"?g:"n,e,s,w,se,sw,ne,nw";function f(l){return{originalPosition:l.originalPosition,originalSize:l.originalSize,position:l.position,size:l.size}}this.uiDialog.resizable({cancel:".ui-dialog-content",containment:"document",alsoResize:this.element,maxWidth:h.maxWidth,maxHeight:h.maxHeight,minWidth:h.minWidth,minHeight:this._minHeight(),handles:j,start:function(l,m){a(this).addClass("ui-dialog-resizing");k._trigger("resizeStart",l,f(m))},resize:function(l,m){k._trigger("resize",l,f(m))},stop:function(l,m){a(this).removeClass("ui-dialog-resizing");h.height=a(this).height();h.width=a(this).width();k._trigger("resizeStop",l,f(m));a.ui.dialog.overlay.resize()}}).css("position",i).find(".ui-resizable-se").addClass("ui-icon ui-icon-grip-diagonal-se")},_minHeight:function(){var f=this.options;if(f.height==="auto"){return f.minHeight}else{return Math.min(f.minHeight,f.height)}},_position:function(i){var g=[],h=[0,0],f;if(i){if(typeof i==="string"||(typeof i==="object"&&"0" in i)){g=i.split?i.split(" "):[i[0],i[1]];if(g.length===1){g[1]=g[0]}a.each(["left","top"],function(j,k){if(+g[j]===g[j]){h[j]=g[j];g[j]=k}});i={my:g[0]+(h[0]<0?h[0]:"+"+h[0])+" "+g[1]+(h[1]<0?h[1]:"+"+h[1]),at:g.join(" ")}}i=a.extend({},a.ui.dialog.prototype.options.position,i)}else{i=a.ui.dialog.prototype.options.position}f=this.uiDialog.is(":visible");if(!f){this.uiDialog.show()}this.uiDialog.position(i);if(!f){this.uiDialog.hide()}},_setOptions:function(f){var i=this,g={},h=false;a.each(f,function(j,k){i._setOption(j,k);if(j in c){h=true}if(j in b){g[j]=k}});if(h){this._size()}if(this.uiDialog.is(":data(resizable)")){this.uiDialog.resizable("option",g)}},_setOption:function(h,j){var f,g,i=this.uiDialog;switch(h){case"buttons":this._createButtons(j);break;case"closeText":this.uiDialogTitlebarCloseText.text(""+j);break;case"dialogClass":i.removeClass(this.options.dialogClass).addClass(d+j);break;case"disabled":if(j){i.addClass("ui-dialog-disabled")}else{i.removeClass("ui-dialog-disabled")}break;case"draggable":f=i.is(":data(draggable)");if(f&&!j){i.draggable("destroy")}if(!f&&j){this._makeDraggable()}break;case"position":this._position(j);break;case"resizable":g=i.is(":data(resizable)");if(g&&!j){i.resizable("destroy")}if(g&&typeof j==="string"){i.resizable("option","handles",j)}if(!g&&j!==false){this._makeResizable(j)}break;case"title":a(".ui-dialog-title",this.uiDialogTitlebar).html(""+(j||"&#160;"));break}this._super(h,j)},_size:function(){var i,h,f,j=this.options,g=this.uiDialog.is(":visible");this.element.show().css({width:"auto",minHeight:0,height:0});if(j.minWidth>j.width){j.width=j.minWidth}i=this.uiDialog.css({height:"auto",width:j.width}).outerHeight();h=Math.max(0,j.minHeight-i);if(j.height==="auto"){if(a.support.minHeight){this.element.css({minHeight:h,height:"auto"})}else{this.uiDialog.show();f=this.element.css("height","auto").height();if(!g){this.uiDialog.hide()}this.element.height(Math.max(f,h))}}else{this.element.height(Math.max(j.height-i,0))}if(this.uiDialog.is(":data(resizable)")){this.uiDialog.resizable("option","minHeight",this._minHeight())}}});a.extend(a.ui.dialog,{uuid:0,maxZ:0,getTitleId:function(f){var g=f.attr("id");if(!g){this.uuid+=1;g=this.uuid}return"ui-dialog-title-"+g},overlay:function(f){this.$el=a.ui.dialog.overlay.create(f)}});a.extend(a.ui.dialog.overlay,{instances:[],oldInstances:[],maxZ:0,events:a.map("focus,mousedown,mouseup,keydown,keypress,click".split(","),function(f){return f+".dialog-overlay"}).join(" "),create:function(g){if(this.instances.length===0){setTimeout(function(){if(a.ui.dialog.overlay.instances.length){a(document).bind(a.ui.dialog.overlay.events,function(h){if(a(h.target).zIndex()<a.ui.dialog.overlay.maxZ){return false}})}},1);a(window).bind("resize.dialog-overlay",a.ui.dialog.overlay.resize)}var f=(this.oldInstances.pop()||a("<div>").addClass("ui-widget-overlay"));a(document).bind("keydown.dialog-overlay",function(h){var i=a.ui.dialog.overlay.instances;if(i.length!==0&&i[i.length-1]===f&&g.options.closeOnEscape&&!h.isDefaultPrevented()&&h.keyCode&&h.keyCode===a.ui.keyCode.ESCAPE){g.close(h);h.preventDefault()}});f.appendTo(document.body).css({width:this.width(),height:this.height()});if(a.fn.bgiframe){f.bgiframe()}this.instances.push(f);return f},destroy:function(f){var g=a.inArray(f,this.instances),h=0;if(g!==-1){this.oldInstances.push(this.instances.splice(g,1)[0])}if(this.instances.length===0){a([document,window]).unbind(".dialog-overlay")}f.height(0).width(0).remove();a.each(this.instances,function(){h=Math.max(h,this.css("z-index"))});this.maxZ=h},height:function(){var g,f;if(a.ui.ie){g=Math.max(document.documentElement.scrollHeight,document.body.scrollHeight);f=Math.max(document.documentElement.offsetHeight,document.body.offsetHeight);if(g<f){return a(window).height()+"px"}else{return g+"px"}}else{return a(document).height()+"px"}},width:function(){var g,f;if(a.ui.ie){g=Math.max(document.documentElement.scrollWidth,document.body.scrollWidth);f=Math.max(document.documentElement.offsetWidth,document.body.offsetWidth);if(g<f){return a(window).width()+"px"}else{return g+"px"}}else{return a(document).width()+"px"}},resize:function(){var f=a([]);a.each(a.ui.dialog.overlay.instances,function(){f=f.add(this)});f.css({width:0,height:0}).css({width:a.ui.dialog.overlay.width(),height:a.ui.dialog.overlay.height()})}});a.extend(a.ui.dialog.overlay.prototype,{destroy:function(){a.ui.dialog.overlay.destroy(this.$el)}})}(jQuery));(function(a,c){var b=false;a.widget("ui.menu",{version:"1.9.2",defaultElement:"<ul>",delay:300,options:{icons:{submenu:"ui-icon-carat-1-e"},menus:"ul",position:{my:"left top",at:"right top"},role:"menu",blur:null,focus:null,select:null},_create:function(){this.activeMenu=this.element;this.element.uniqueId().addClass("ui-menu ui-widget ui-widget-content ui-corner-all").toggleClass("ui-menu-icons",!!this.element.find(".ui-icon").length).attr({role:this.options.role,tabIndex:0}).bind("click"+this.eventNamespace,a.proxy(function(d){if(this.options.disabled){d.preventDefault()}},this));if(this.options.disabled){this.element.addClass("ui-state-disabled").attr("aria-disabled","true")}this._on({"mousedown .ui-menu-item > a":function(d){d.preventDefault()},"click .ui-state-disabled > a":function(d){d.preventDefault()},"click .ui-menu-item:has(a)":function(d){var e=a(d.target).closest(".ui-menu-item");if(!b&&e.not(".ui-state-disabled").length){b=true;this.select(d);if(e.has(".ui-menu").length){this.expand(d)}else{if(!this.element.is(":focus")){this.element.trigger("focus",[true]);if(this.active&&this.active.parents(".ui-menu").length===1){clearTimeout(this.timer)}}}}},"mouseenter .ui-menu-item":function(d){var e=a(d.currentTarget);e.siblings().children(".ui-state-active").removeClass("ui-state-active");this.focus(d,e)},mouseleave:"collapseAll","mouseleave .ui-menu":"collapseAll",focus:function(d,f){var e=this.active||this.element.children(".ui-menu-item").eq(0);if(!f){this.focus(d,e)}},blur:function(d){this._delay(function(){if(!a.contains(this.element[0],this.document[0].activeElement)){this.collapseAll(d)}})},keydown:"_keydown"});this.refresh();this._on(this.document,{click:function(d){if(!a(d.target).closest(".ui-menu").length){this.collapseAll(d)}b=false}})},_destroy:function(){this.element.removeAttr("aria-activedescendant").find(".ui-menu").andSelf().removeClass("ui-menu ui-widget ui-widget-content ui-corner-all ui-menu-icons").removeAttr("role").removeAttr("tabIndex").removeAttr("aria-labelledby").removeAttr("aria-expanded").removeAttr("aria-hidden").removeAttr("aria-disabled").removeUniqueId().show();this.element.find(".ui-menu-item").removeClass("ui-menu-item").removeAttr("role").removeAttr("aria-disabled").children("a").removeUniqueId().removeClass("ui-corner-all ui-state-hover").removeAttr("tabIndex").removeAttr("role").removeAttr("aria-haspopup").children().each(function(){var d=a(this);if(d.data("ui-menu-submenu-carat")){d.remove()}});this.element.find(".ui-menu-divider").removeClass("ui-menu-divider ui-widget-content")},_keydown:function(f){var g,h,d,k,j,i=true;function e(l){return l.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g,"\\$&")}switch(f.keyCode){case a.ui.keyCode.PAGE_UP:this.previousPage(f);break;case a.ui.keyCode.PAGE_DOWN:this.nextPage(f);break;case a.ui.keyCode.HOME:this._move("first","first",f);break;case a.ui.keyCode.END:this._move("last","last",f);break;case a.ui.keyCode.UP:this.previous(f);break;case a.ui.keyCode.DOWN:this.next(f);break;case a.ui.keyCode.LEFT:this.collapse(f);break;case a.ui.keyCode.RIGHT:if(this.active&&!this.active.is(".ui-state-disabled")){this.expand(f)}break;case a.ui.keyCode.ENTER:case a.ui.keyCode.SPACE:this._activate(f);break;case a.ui.keyCode.ESCAPE:this.collapse(f);break;default:i=false;h=this.previousFilter||"";d=String.fromCharCode(f.keyCode);k=false;clearTimeout(this.filterTimer);if(d===h){k=true}else{d=h+d}j=new RegExp("^"+e(d),"i");g=this.activeMenu.children(".ui-menu-item").filter(function(){return j.test(a(this).children("a").text())});g=k&&g.index(this.active.next())!==-1?this.active.nextAll(".ui-menu-item"):g;if(!g.length){d=String.fromCharCode(f.keyCode);j=new RegExp("^"+e(d),"i");g=this.activeMenu.children(".ui-menu-item").filter(function(){return j.test(a(this).children("a").text())})}if(g.length){this.focus(f,g);if(g.length>1){this.previousFilter=d;this.filterTimer=this._delay(function(){delete this.previousFilter},1000)}else{delete this.previousFilter}}else{delete this.previousFilter}}if(i){f.preventDefault()}},_activate:function(d){if(!this.active.is(".ui-state-disabled")){if(this.active.children("a[aria-haspopup='true']").length){this.expand(d)}else{this.select(d)}}},refresh:function(){var e,d=this.options.icons.submenu,f=this.element.find(this.options.menus);f.filter(":not(.ui-menu)").addClass("ui-menu ui-widget ui-widget-content ui-corner-all").hide().attr({role:this.options.role,"aria-hidden":"true","aria-expanded":"false"}).each(function(){var h=a(this),g=h.prev("a"),i=a("<span>").addClass("ui-menu-icon ui-icon "+d).data("ui-menu-submenu-carat",true);g.attr("aria-haspopup","true").prepend(i);h.attr("aria-labelledby",g.attr("id"))});e=f.add(this.element);e.children(":not(.ui-menu-item):has(a)").addClass("ui-menu-item").attr("role","presentation").children("a").uniqueId().addClass("ui-corner-all").attr({tabIndex:-1,role:this._itemRole()});e.children(":not(.ui-menu-item)").each(function(){var g=a(this);if(!/[^\-鈥斺€揬s]/.test(g.text())){g.addClass("ui-widget-content ui-menu-divider")}});e.children(".ui-state-disabled").attr("aria-disabled","true");if(this.active&&!a.contains(this.element[0],this.active[0])){this.blur()}},_itemRole:function(){return{menu:"menuitem",listbox:"option"}[this.options.role]},focus:function(d,f){var g,e;this.blur(d,d&&d.type==="focus");this._scrollIntoView(f);this.active=f.first();e=this.active.children("a").addClass("ui-state-focus");if(this.options.role){this.element.attr("aria-activedescendant",e.attr("id"))}this.active.parent().closest(".ui-menu-item").children("a:first").addClass("ui-state-active");if(d&&d.type==="keydown"){this._close()}else{this.timer=this._delay(function(){this._close()},this.delay)}g=f.children(".ui-menu");if(g.length&&(/^mouse/.test(d.type))){this._startOpening(g)}this.activeMenu=f.parent();this._trigger("focus",d,{item:f})},_scrollIntoView:function(f){var d,i,h,j,e,g;if(this._hasScroll()){d=parseFloat(a.css(this.activeMenu[0],"borderTopWidth"))||0;i=parseFloat(a.css(this.activeMenu[0],"paddingTop"))||0;h=f.offset().top-this.activeMenu.offset().top-d-i;j=this.activeMenu.scrollTop();e=this.activeMenu.height();g=f.height();if(h<0){this.activeMenu.scrollTop(j+h)}else{if(h+g>e){this.activeMenu.scrollTop(j+h-e+g)}}}},blur:function(d,e){if(!e){clearTimeout(this.timer)}if(!this.active){return}this.active.children("a").removeClass("ui-state-focus");this.active=null;this._trigger("blur",d,{item:this.active})},_startOpening:function(d){clearTimeout(this.timer);if(d.attr("aria-hidden")!=="true"){return}this.timer=this._delay(function(){this._close();this._open(d)},this.delay)},_open:function(e){var d=a.extend({of:this.active},this.options.position);clearTimeout(this.timer);this.element.find(".ui-menu").not(e.parents(".ui-menu")).hide().attr("aria-hidden","true");e.show().removeAttr("aria-hidden").attr("aria-expanded","true").position(d)},collapseAll:function(e,d){clearTimeout(this.timer);this.timer=this._delay(function(){var f=d?this.element:a(e&&e.target).closest(this.element.find(".ui-menu"));if(!f.length){f=this.element}this._close(f);this.blur(e);this.activeMenu=f},this.delay)},_close:function(d){if(!d){d=this.active?this.active.parent():this.element}d.find(".ui-menu").hide().attr("aria-hidden","true").attr("aria-expanded","false").end().find("a.ui-state-active").removeClass("ui-state-active")},collapse:function(d){var e=this.active&&this.active.parent().closest(".ui-menu-item",this.element);if(e&&e.length){this._close();this.focus(d,e)}},expand:function(d){var e=this.active&&this.active.children(".ui-menu ").children(".ui-menu-item").first();if(e&&e.length){this._open(e.parent());this._delay(function(){this.focus(d,e)})}},next:function(d){this._move("next","first",d)},previous:function(d){this._move("prev","last",d)},isFirstItem:function(){return this.active&&!this.active.prevAll(".ui-menu-item").length},isLastItem:function(){return this.active&&!this.active.nextAll(".ui-menu-item").length},_move:function(d,f,e){var g;if(this.active){if(d==="first"||d==="last"){g=this.active[d==="first"?"prevAll":"nextAll"](".ui-menu-item").eq(-1)}else{g=this.active[d+"All"](".ui-menu-item").eq(0)}}if(!g||!g.length||!this.active){g=this.activeMenu.children(".ui-menu-item")[f]()}this.focus(e,g)},nextPage:function(e){var g,d,f;if(!this.active){this.next(e);return}if(this.isLastItem()){return}if(this._hasScroll()){d=this.active.offset().top;f=this.element.height();this.active.nextAll(".ui-menu-item").each(function(){g=a(this);return g.offset().top-d-f<0});this.focus(e,g)}else{this.focus(e,this.activeMenu.children(".ui-menu-item")[!this.active?"first":"last"]())}},previousPage:function(e){var g,d,f;if(!this.active){this.next(e);return}if(this.isFirstItem()){return}if(this._hasScroll()){d=this.active.offset().top;f=this.element.height();this.active.prevAll(".ui-menu-item").each(function(){g=a(this);return g.offset().top-d+f>0});this.focus(e,g)}else{this.focus(e,this.activeMenu.children(".ui-menu-item").first())}},_hasScroll:function(){return this.element.outerHeight()<this.element.prop("scrollHeight")},select:function(d){this.active=this.active||a(d.target).closest(".ui-menu-item");var e={item:this.active};if(!this.active.has(".ui-menu").length){this.collapseAll(d,true)}this._trigger("select",d,e)}})}(jQuery));(function(a,b){a.widget("ui.progressbar",{version:"1.9.2",options:{value:0,max:100},min:0,_create:function(){this.element.addClass("ui-progressbar ui-widget ui-widget-content ui-corner-all").attr({role:"progressbar","aria-valuemin":this.min,"aria-valuemax":this.options.max,"aria-valuenow":this._value()});this.valueDiv=a("<div class='ui-progressbar-value ui-widget-header ui-corner-left'></div>").appendTo(this.element);this.oldValue=this._value();this._refreshValue()},_destroy:function(){this.element.removeClass("ui-progressbar ui-widget ui-widget-content ui-corner-all").removeAttr("role").removeAttr("aria-valuemin").removeAttr("aria-valuemax").removeAttr("aria-valuenow");this.valueDiv.remove()},value:function(c){if(c===b){return this._value()}this._setOption("value",c);return this},_setOption:function(c,d){if(c==="value"){this.options.value=d;this._refreshValue();if(this._value()===this.options.max){this._trigger("complete")}}this._super(c,d)},_value:function(){var c=this.options.value;if(typeof c!=="number"){c=0}return Math.min(this.options.max,Math.max(this.min,c))},_percentage:function(){return 100*this._value()/this.options.max},_refreshValue:function(){var d=this.value(),c=this._percentage();if(this.oldValue!==d){this.oldValue=d;this._trigger("change")}this.valueDiv.toggle(d>this.min).toggleClass("ui-corner-right",d===this.options.max).width(c.toFixed(0)+"%");this.element.attr("aria-valuenow",d)}})})(jQuery);(function(a,c){var b=5;a.widget("ui.slider",a.ui.mouse,{version:"1.9.2",widgetEventPrefix:"slide",options:{animate:false,distance:0,max:100,min:0,orientation:"horizontal",range:false,step:1,value:0,values:null},_create:function(){var h,f,j=this.options,d=this.element.find(".ui-slider-handle").addClass("ui-state-default ui-corner-all"),e="<a class='ui-slider-handle ui-state-default ui-corner-all' href='#'></a>",g=[];this._keySliding=false;this._mouseSliding=false;this._animateOff=true;this._handleIndex=null;this._detectOrientation();this._mouseInit();this.element.addClass("ui-slider ui-slider-"+this.orientation+" ui-widget ui-widget-content ui-corner-all"+(j.disabled?" ui-slider-disabled ui-disabled":""));this.range=a([]);if(j.range){if(j.range===true){if(!j.values){j.values=[this._valueMin(),this._valueMin()]}if(j.values.length&&j.values.length!==2){j.values=[j.values[0],j.values[0]]}}this.range=a("<div></div>").appendTo(this.element).addClass("ui-slider-range ui-widget-header"+((j.range==="min"||j.range==="max")?" ui-slider-range-"+j.range:""))}f=(j.values&&j.values.length)||1;for(h=d.length;h<f;h++){g.push(e)}this.handles=d.add(a(g.join("")).appendTo(this.element));this.handle=this.handles.eq(0);this.handles.add(this.range).filter("a").click(function(i){i.preventDefault()}).mouseenter(function(){if(!j.disabled){a(this).addClass("ui-state-hover")}}).mouseleave(function(){a(this).removeClass("ui-state-hover")}).focus(function(){if(!j.disabled){a(".ui-slider .ui-state-focus").removeClass("ui-state-focus");a(this).addClass("ui-state-focus")}else{a(this).blur()}}).blur(function(){a(this).removeClass("ui-state-focus")});this.handles.each(function(k){a(this).data("ui-slider-handle-index",k)});this._on(this.handles,{keydown:function(l){var i,k,n,o,m=a(l.target).data("ui-slider-handle-index");switch(l.keyCode){case a.ui.keyCode.HOME:case a.ui.keyCode.END:case a.ui.keyCode.PAGE_UP:case a.ui.keyCode.PAGE_DOWN:case a.ui.keyCode.UP:case a.ui.keyCode.RIGHT:case a.ui.keyCode.DOWN:case a.ui.keyCode.LEFT:l.preventDefault();if(!this._keySliding){this._keySliding=true;a(l.target).addClass("ui-state-active");i=this._start(l,m);if(i===false){return}}break}o=this.options.step;if(this.options.values&&this.options.values.length){k=n=this.values(m)}else{k=n=this.value()}switch(l.keyCode){case a.ui.keyCode.HOME:n=this._valueMin();break;case a.ui.keyCode.END:n=this._valueMax();break;case a.ui.keyCode.PAGE_UP:n=this._trimAlignValue(k+((this._valueMax()-this._valueMin())/b));break;case a.ui.keyCode.PAGE_DOWN:n=this._trimAlignValue(k-((this._valueMax()-this._valueMin())/b));break;case a.ui.keyCode.UP:case a.ui.keyCode.RIGHT:if(k===this._valueMax()){return}n=this._trimAlignValue(k+o);break;case a.ui.keyCode.DOWN:case a.ui.keyCode.LEFT:if(k===this._valueMin()){return}n=this._trimAlignValue(k-o);break}this._slide(l,m,n)},keyup:function(i){var k=a(i.target).data("ui-slider-handle-index");if(this._keySliding){this._keySliding=false;this._stop(i,k);this._change(i,k);a(i.target).removeClass("ui-state-active")}}});this._refreshValue();this._animateOff=false},_destroy:function(){this.handles.remove();this.range.remove();this.element.removeClass("ui-slider ui-slider-horizontal ui-slider-vertical ui-slider-disabled ui-widget ui-widget-content ui-corner-all");this._mouseDestroy()},_mouseCapture:function(g){var m,j,f,e,h,d,l,i,n=this,k=this.options;if(k.disabled){return false}this.elementSize={width:this.element.outerWidth(),height:this.element.outerHeight()};this.elementOffset=this.element.offset();m={x:g.pageX,y:g.pageY};j=this._normValueFromMouse(m);f=this._valueMax()-this._valueMin()+1;this.handles.each(function(o){var p=Math.abs(j-n.values(o));if(f>p){f=p;e=a(this);h=o}});if(k.range===true&&this.values(1)===k.min){h+=1;e=a(this.handles[h])}d=this._start(g,h);if(d===false){return false}this._mouseSliding=true;this._handleIndex=h;e.addClass("ui-state-active").focus();l=e.offset();i=!a(g.target).parents().andSelf().is(".ui-slider-handle");this._clickOffset=i?{left:0,top:0}:{left:g.pageX-l.left-(e.width()/2),top:g.pageY-l.top-(e.height()/2)-(parseInt(e.css("borderTopWidth"),10)||0)-(parseInt(e.css("borderBottomWidth"),10)||0)+(parseInt(e.css("marginTop"),10)||0)};if(!this.handles.hasClass("ui-state-hover")){this._slide(g,h,j)}this._animateOff=true;return true},_mouseStart:function(){return true},_mouseDrag:function(d){var f={x:d.pageX,y:d.pageY},e=this._normValueFromMouse(f);this._slide(d,this._handleIndex,e);return false},_mouseStop:function(d){this.handles.removeClass("ui-state-active");this._mouseSliding=false;this._stop(d,this._handleIndex);this._change(d,this._handleIndex);this._handleIndex=null;this._clickOffset=null;this._animateOff=false;return false},_detectOrientation:function(){this.orientation=(this.options.orientation==="vertical")?"vertical":"horizontal"},_normValueFromMouse:function(g){var f,e,d,i,h;if(this.orientation==="horizontal"){f=this.elementSize.width;e=g.x-this.elementOffset.left-(this._clickOffset?this._clickOffset.left:0)}else{f=this.elementSize.height;e=g.y-this.elementOffset.top-(this._clickOffset?this._clickOffset.top:0)}d=(e/f);if(d>1){d=1}if(d<0){d=0}if(this.orientation==="vertical"){d=1-d}i=this._valueMax()-this._valueMin();h=this._valueMin()+d*i;return this._trimAlignValue(h)},_start:function(d,e){var f={handle:this.handles[e],value:this.value()};if(this.options.values&&this.options.values.length){f.value=this.values(e);f.values=this.values()}return this._trigger("start",d,f)},_slide:function(e,f,g){var i,h,d;if(this.options.values&&this.options.values.length){i=this.values(f?0:1);if((this.options.values.length===2&&this.options.range===true)&&((f===0&&g>i)||(f===1&&g<i))){g=i}if(g!==this.values(f)){h=this.values();h[f]=g;d=this._trigger("slide",e,{handle:this.handles[f],value:g,values:h});i=this.values(f?0:1);if(d!==false){this.values(f,g,true)}}}else{if(g!==this.value()){d=this._trigger("slide",e,{handle:this.handles[f],value:g});if(d!==false){this.value(g)}}}},_stop:function(d,e){var f={handle:this.handles[e],value:this.value()};if(this.options.values&&this.options.values.length){f.value=this.values(e);f.values=this.values()}this._trigger("stop",d,f)},_change:function(d,e){if(!this._keySliding&&!this._mouseSliding){var f={handle:this.handles[e],value:this.value()};if(this.options.values&&this.options.values.length){f.value=this.values(e);f.values=this.values()}this._trigger("change",d,f)}},value:function(d){if(arguments.length){this.options.value=this._trimAlignValue(d);this._refreshValue();this._change(null,0);return}return this._value()},values:function(e,f){var h,g,d;if(arguments.length>1){this.options.values[e]=this._trimAlignValue(f);this._refreshValue();this._change(null,e);return}if(arguments.length){if(a.isArray(arguments[0])){h=this.options.values;g=arguments[0];for(d=0;d<h.length;d+=1){h[d]=this._trimAlignValue(g[d]);this._change(null,d)}this._refreshValue()}else{if(this.options.values&&this.options.values.length){return this._values(e)}else{return this.value()}}}else{return this._values()}},_setOption:function(e,g){var d,f=0;if(a.isArray(this.options.values)){f=this.options.values.length}a.Widget.prototype._setOption.apply(this,arguments);switch(e){case"disabled":if(g){this.handles.filter(".ui-state-focus").blur();this.handles.removeClass("ui-state-hover");this.handles.prop("disabled",true);this.element.addClass("ui-disabled")}else{this.handles.prop("disabled",false);this.element.removeClass("ui-disabled")}break;case"orientation":this._detectOrientation();this.element.removeClass("ui-slider-horizontal ui-slider-vertical").addClass("ui-slider-"+this.orientation);this._refreshValue();break;case"value":this._animateOff=true;this._refreshValue();this._change(null,0);this._animateOff=false;break;case"values":this._animateOff=true;this._refreshValue();for(d=0;d<f;d+=1){this._change(null,d)}this._animateOff=false;break;case"min":case"max":this._animateOff=true;this._refreshValue();this._animateOff=false;break}},_value:function(){var d=this.options.value;d=this._trimAlignValue(d);return d},_values:function(e){var f,g,d;if(arguments.length){f=this.options.values[e];f=this._trimAlignValue(f);return f}else{g=this.options.values.slice();for(d=0;d<g.length;d+=1){g[d]=this._trimAlignValue(g[d])}return g}},_trimAlignValue:function(f){if(f<=this._valueMin()){return this._valueMin()}if(f>=this._valueMax()){return this._valueMax()}var e=(this.options.step>0)?this.options.step:1,g=(f-this._valueMin())%e,d=f-g;if(Math.abs(g)*2>=e){d+=(g>0)?e:(-e)}return parseFloat(d.toFixed(5))},_valueMin:function(){return this.options.min},_valueMax:function(){return this.options.max},_refreshValue:function(){var f,j,k,m,l,h=this.options.range,g=this.options,i=this,e=(!this._animateOff)?g.animate:false,d={};if(this.options.values&&this.options.values.length){this.handles.each(function(n){j=(i.values(n)-i._valueMin())/(i._valueMax()-i._valueMin())*100;d[i.orientation==="horizontal"?"left":"bottom"]=j+"%";a(this).stop(1,1)[e?"animate":"css"](d,g.animate);if(i.options.range===true){if(i.orientation==="horizontal"){if(n===0){i.range.stop(1,1)[e?"animate":"css"]({left:j+"%"},g.animate)}if(n===1){i.range[e?"animate":"css"]({width:(j-f)+"%"},{queue:false,duration:g.animate})}}else{if(n===0){i.range.stop(1,1)[e?"animate":"css"]({bottom:(j)+"%"},g.animate)}if(n===1){i.range[e?"animate":"css"]({height:(j-f)+"%"},{queue:false,duration:g.animate})}}}f=j})}else{k=this.value();m=this._valueMin();l=this._valueMax();j=(l!==m)?(k-m)/(l-m)*100:0;d[this.orientation==="horizontal"?"left":"bottom"]=j+"%";this.handle.stop(1,1)[e?"animate":"css"](d,g.animate);if(h==="min"&&this.orientation==="horizontal"){this.range.stop(1,1)[e?"animate":"css"]({width:j+"%"},g.animate)}if(h==="max"&&this.orientation==="horizontal"){this.range[e?"animate":"css"]({width:(100-j)+"%"},{queue:false,duration:g.animate})}if(h==="min"&&this.orientation==="vertical"){this.range.stop(1,1)[e?"animate":"css"]({height:j+"%"},g.animate)}if(h==="max"&&this.orientation==="vertical"){this.range[e?"animate":"css"]({height:(100-j)+"%"},{queue:false,duration:g.animate})}}}})}(jQuery));(function(a){function b(c){return function(){var d=this.element.val();c.apply(this,arguments);this._refresh();if(d!==this.element.val()){this._trigger("change")}}}a.widget("ui.spinner",{version:"1.9.2",defaultElement:"<input>",widgetEventPrefix:"spin",options:{culture:null,icons:{down:"ui-icon-triangle-1-s",up:"ui-icon-triangle-1-n"},incremental:true,max:null,min:null,numberFormat:null,page:10,step:1,change:null,spin:null,start:null,stop:null},_create:function(){this._setOption("max",this.options.max);this._setOption("min",this.options.min);this._setOption("step",this.options.step);this._value(this.element.val(),true);this._draw();this._on(this._events);this._refresh();this._on(this.window,{beforeunload:function(){this.element.removeAttr("autocomplete")}})},_getCreateOptions:function(){var d={},c=this.element;a.each(["min","max","step"],function(e,f){var g=c.attr(f);if(g!==undefined&&g.length){d[f]=g}});return d},_events:{keydown:function(c){if(this._start(c)&&this._keydown(c)){c.preventDefault()}},keyup:"_stop",focus:function(){this.previous=this.element.val()},blur:function(c){if(this.cancelBlur){delete this.cancelBlur;return}this._refresh();if(this.previous!==this.element.val()){this._trigger("change",c)}},mousewheel:function(d,c){if(!c){return}if(!this.spinning&&!this._start(d)){return false}this._spin((c>0?1:-1)*this.options.step,d);clearTimeout(this.mousewheelTimer);this.mousewheelTimer=this._delay(function(){if(this.spinning){this._stop(d)}},100);d.preventDefault()},"mousedown .ui-spinner-button":function(d){var e;e=this.element[0]===this.document[0].activeElement?this.previous:this.element.val();function c(){var f=this.element[0]===this.document[0].activeElement;if(!f){this.element.focus();this.previous=e;this._delay(function(){this.previous=e})}}d.preventDefault();c.call(this);this.cancelBlur=true;this._delay(function(){delete this.cancelBlur;c.call(this)});if(this._start(d)===false){return}this._repeat(null,a(d.currentTarget).hasClass("ui-spinner-up")?1:-1,d)},"mouseup .ui-spinner-button":"_stop","mouseenter .ui-spinner-button":function(c){if(!a(c.currentTarget).hasClass("ui-state-active")){return}if(this._start(c)===false){return false}this._repeat(null,a(c.currentTarget).hasClass("ui-spinner-up")?1:-1,c)},"mouseleave .ui-spinner-button":"_stop"},_draw:function(){var c=this.uiSpinner=this.element.addClass("ui-spinner-input").attr("autocomplete","off").wrap(this._uiSpinnerHtml()).parent().append(this._buttonHtml());this.element.attr("role","spinbutton");this.buttons=c.find(".ui-spinner-button").attr("tabIndex",-1).button().removeClass("ui-corner-all");if(this.buttons.height()>Math.ceil(c.height()*0.5)&&c.height()>0){c.height(c.height())}if(this.options.disabled){this.disable()}},_keydown:function(c){var e=this.options,d=a.ui.keyCode;switch(c.keyCode){case d.UP:this._repeat(null,1,c);return true;case d.DOWN:this._repeat(null,-1,c);return true;case d.PAGE_UP:this._repeat(null,e.page,c);return true;case d.PAGE_DOWN:this._repeat(null,-e.page,c);return true}return false},_uiSpinnerHtml:function(){return"<span class='ui-spinner ui-widget ui-widget-content ui-corner-all'></span>"},_buttonHtml:function(){return"<a class='ui-spinner-button ui-spinner-up ui-corner-tr'><span class='ui-icon "+this.options.icons.up+"'>&#9650;</span></a><a class='ui-spinner-button ui-spinner-down ui-corner-br'><span class='ui-icon "+this.options.icons.down+"'>&#9660;</span></a>"},_start:function(c){if(!this.spinning&&this._trigger("start",c)===false){return false}if(!this.counter){this.counter=1}this.spinning=true;return true},_repeat:function(d,e,c){d=d||500;clearTimeout(this.timer);this.timer=this._delay(function(){this._repeat(40,e,c)},d);this._spin(e*this.options.step,c)},_spin:function(d,c){var e=this.value()||0;if(!this.counter){this.counter=1}e=this._adjustValue(e+d*this._increment(this.counter));if(!this.spinning||this._trigger("spin",c,{value:e})!==false){this._value(e);this.counter++}},_increment:function(c){var d=this.options.incremental;if(d){return a.isFunction(d)?d(c):Math.floor(c*c*c/50000-c*c/500+17*c/200+1)}return 1},_precision:function(){var c=this._precisionOf(this.options.step);if(this.options.min!==null){c=Math.max(c,this._precisionOf(this.options.min))}return c},_precisionOf:function(d){var e=d.toString(),c=e.indexOf(".");return c===-1?0:e.length-c-1},_adjustValue:function(f){var d,c,e=this.options;d=e.min!==null?e.min:0;c=f-d;c=Math.round(c/e.step)*e.step;f=d+c;f=parseFloat(f.toFixed(this._precision()));if(e.max!==null&&f>e.max){return e.max}if(e.min!==null&&f<e.min){return e.min}return f},_stop:function(c){if(!this.spinning){return}clearTimeout(this.timer);clearTimeout(this.mousewheelTimer);this.counter=0;this.spinning=false;this._trigger("stop",c)},_setOption:function(c,e){if(c==="culture"||c==="numberFormat"){var d=this._parse(this.element.val());this.options[c]=e;this.element.val(this._format(d));return}if(c==="max"||c==="min"||c==="step"){if(typeof e==="string"){e=this._parse(e)}}this._super(c,e);if(c==="disabled"){if(e){this.element.prop("disabled",true);this.buttons.button("disable")}else{this.element.prop("disabled",false);this.buttons.button("enable")}}},_setOptions:b(function(c){this._super(c);this._value(this.element.val())}),_parse:function(c){if(typeof c==="string"&&c!==""){c=window.Globalize&&this.options.numberFormat?Globalize.parseFloat(c,10,this.options.culture):+c}return c===""||isNaN(c)?null:c},_format:function(c){if(c===""){return""}return window.Globalize&&this.options.numberFormat?Globalize.format(c,this.options.numberFormat,this.options.culture):c},_refresh:function(){this.element.attr({"aria-valuemin":this.options.min,"aria-valuemax":this.options.max,"aria-valuenow":this._parse(this.element.val())})},_value:function(e,c){var d;if(e!==""){d=this._parse(e);if(d!==null){if(!c){d=this._adjustValue(d)}e=this._format(d)}}this.element.val(e);this._refresh()},_destroy:function(){this.element.removeClass("ui-spinner-input").prop("disabled",false).removeAttr("autocomplete").removeAttr("role").removeAttr("aria-valuemin").removeAttr("aria-valuemax").removeAttr("aria-valuenow");this.uiSpinner.replaceWith(this.element)},stepUp:b(function(c){this._stepUp(c)}),_stepUp:function(c){this._spin((c||1)*this.options.step)},stepDown:b(function(c){this._stepDown(c)}),_stepDown:function(c){this._spin((c||1)*-this.options.step)},pageUp:b(function(c){this._stepUp((c||1)*this.options.page)}),pageDown:b(function(c){this._stepDown((c||1)*this.options.page)}),value:function(c){if(!arguments.length){return this._parse(this.element.val())}b(this._value).call(this,c)},widget:function(){return this.uiSpinner}})}(jQuery));(function(a,f){var e=0,d=/#.*$/;function b(){return ++e}function c(g){return g.hash.length>1&&g.href.replace(d,"")===location.href.replace(d,"").replace(/\s/g,"%20")}a.widget("ui.tabs",{version:"1.9.2",delay:300,options:{active:null,collapsible:false,event:"click",heightStyle:"content",hide:null,show:null,activate:null,beforeActivate:null,beforeLoad:null,load:null},_create:function(){var j=this,i=this.options,g=i.active,h=location.hash.substring(1);this.running=false;this.element.addClass("ui-tabs ui-widget ui-widget-content ui-corner-all").toggleClass("ui-tabs-collapsible",i.collapsible).delegate(".ui-tabs-nav > li","mousedown"+this.eventNamespace,function(k){if(a(this).is(".ui-state-disabled")){k.preventDefault()}}).delegate(".ui-tabs-anchor","focus"+this.eventNamespace,function(){if(a(this).closest("li").is(".ui-state-disabled")){this.blur()}});this._processTabs();if(g===null){if(h){this.tabs.each(function(k,l){if(a(l).attr("aria-controls")===h){g=k;return false}})}if(g===null){g=this.tabs.index(this.tabs.filter(".ui-tabs-active"))}if(g===null||g===-1){g=this.tabs.length?0:false}}if(g!==false){g=this.tabs.index(this.tabs.eq(g));if(g===-1){g=i.collapsible?false:0}}i.active=g;if(!i.collapsible&&i.active===false&&this.anchors.length){i.active=0}if(a.isArray(i.disabled)){i.disabled=a.unique(i.disabled.concat(a.map(this.tabs.filter(".ui-state-disabled"),function(k){return j.tabs.index(k)}))).sort()}if(this.options.active!==false&&this.anchors.length){this.active=this._findActive(this.options.active)}else{this.active=a()}this._refresh();if(this.active.length){this.load(i.active)}},_getCreateEventData:function(){return{tab:this.active,panel:!this.active.length?a():this._getPanelForTab(this.active)}},_tabKeydown:function(g){var h=a(this.document[0].activeElement).closest("li"),j=this.tabs.index(h),i=true;if(this._handlePageNav(g)){return}switch(g.keyCode){case a.ui.keyCode.RIGHT:case a.ui.keyCode.DOWN:j++;break;case a.ui.keyCode.UP:case a.ui.keyCode.LEFT:i=false;j--;break;case a.ui.keyCode.END:j=this.anchors.length-1;break;case a.ui.keyCode.HOME:j=0;break;case a.ui.keyCode.SPACE:g.preventDefault();clearTimeout(this.activating);this._activate(j);return;case a.ui.keyCode.ENTER:g.preventDefault();clearTimeout(this.activating);this._activate(j===this.options.active?false:j);return;default:return}g.preventDefault();clearTimeout(this.activating);j=this._focusNextTab(j,i);if(!g.ctrlKey){h.attr("aria-selected","false");this.tabs.eq(j).attr("aria-selected","true");this.activating=this._delay(function(){this.option("active",j)},this.delay)}},_panelKeydown:function(g){if(this._handlePageNav(g)){return}if(g.ctrlKey&&g.keyCode===a.ui.keyCode.UP){g.preventDefault();this.active.focus()}},_handlePageNav:function(g){if(g.altKey&&g.keyCode===a.ui.keyCode.PAGE_UP){this._activate(this._focusNextTab(this.options.active-1,false));return true}if(g.altKey&&g.keyCode===a.ui.keyCode.PAGE_DOWN){this._activate(this._focusNextTab(this.options.active+1,true));return true}},_findNextTab:function(i,h){var j=this.tabs.length-1;function g(){if(i>j){i=0}if(i<0){i=j}return i}while(a.inArray(g(),this.options.disabled)!==-1){i=h?i+1:i-1}return i},_focusNextTab:function(h,g){h=this._findNextTab(h,g);this.tabs.eq(h).focus();return h},_setOption:function(g,h){if(g==="active"){this._activate(h);return}if(g==="disabled"){this._setupDisabled(h);return}this._super(g,h);if(g==="collapsible"){this.element.toggleClass("ui-tabs-collapsible",h);if(!h&&this.options.active===false){this._activate(0)}}if(g==="event"){this._setupEvents(h)}if(g==="heightStyle"){this._setupHeightStyle(h)}},_tabId:function(g){return g.attr("aria-controls")||"ui-tabs-"+b()},_sanitizeSelector:function(g){return g?g.replace(/[!"$%&'()*+,.\/:;<=>?@\[\]\^`{|}~]/g,"\\$&"):""},refresh:function(){var h=this.options,g=this.tablist.children(":has(a[href])");h.disabled=a.map(g.filter(".ui-state-disabled"),function(i){return g.index(i)});this._processTabs();if(h.active===false||!this.anchors.length){h.active=false;this.active=a()}else{if(this.active.length&&!a.contains(this.tablist[0],this.active[0])){if(this.tabs.length===h.disabled.length){h.active=false;this.active=a()}else{this._activate(this._findNextTab(Math.max(0,h.active-1),false))}}else{h.active=this.tabs.index(this.active)}}this._refresh()},_refresh:function(){this._setupDisabled(this.options.disabled);this._setupEvents(this.options.event);this._setupHeightStyle(this.options.heightStyle);this.tabs.not(this.active).attr({"aria-selected":"false",tabIndex:-1});this.panels.not(this._getPanelForTab(this.active)).hide().attr({"aria-expanded":"false","aria-hidden":"true"});if(!this.active.length){this.tabs.eq(0).attr("tabIndex",0)}else{this.active.addClass("ui-tabs-active ui-state-active").attr({"aria-selected":"true",tabIndex:0});this._getPanelForTab(this.active).show().attr({"aria-expanded":"true","aria-hidden":"false"})}},_processTabs:function(){var g=this;this.tablist=this._getList().addClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all").attr("role","tablist");this.tabs=this.tablist.find("> li:has(a[href])").addClass("ui-state-default ui-corner-top").attr({role:"tab",tabIndex:-1});this.anchors=this.tabs.map(function(){return a("a",this)[0]}).addClass("ui-tabs-anchor").attr({role:"presentation",tabIndex:-1});this.panels=a();this.anchors.each(function(k,h){var o,m,n,j=a(h).uniqueId().attr("id"),p=a(h).closest("li"),l=p.attr("aria-controls");if(c(h)){o=h.hash;m=g.element.find(g._sanitizeSelector(o))}else{n=g._tabId(p);o="#"+n;m=g.element.find(o);if(!m.length){m=g._createPanel(n);m.insertAfter(g.panels[k-1]||g.tablist)}m.attr("aria-live","polite")}if(m.length){g.panels=g.panels.add(m)}if(l){p.data("ui-tabs-aria-controls",l)}p.attr({"aria-controls":o.substring(1),"aria-labelledby":j});m.attr("aria-labelledby",j)});this.panels.addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").attr("role","tabpanel")},_getList:function(){return this.element.find("ol,ul").eq(0)},_createPanel:function(g){return a("<div>").attr("id",g).addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").data("ui-tabs-destroy",true)},_setupDisabled:function(g){if(a.isArray(g)){if(!g.length){g=false}else{if(g.length===this.anchors.length){g=true}}}for(var h=0,j;(j=this.tabs[h]);h++){if(g===true||a.inArray(h,g)!==-1){a(j).addClass("ui-state-disabled").attr("aria-disabled","true")}else{a(j).removeClass("ui-state-disabled").removeAttr("aria-disabled")}}this.options.disabled=g},_setupEvents:function(g){var h={click:function(i){i.preventDefault()}};if(g){a.each(g.split(" "),function(j,i){h[i]="_eventHandler"})}this._off(this.anchors.add(this.tabs).add(this.panels));this._on(this.anchors,h);this._on(this.tabs,{keydown:"_tabKeydown"});this._on(this.panels,{keydown:"_panelKeydown"});this._focusable(this.tabs);this._hoverable(this.tabs)},_setupHeightStyle:function(g){var h,i,j=this.element.parent();if(g==="fill"){if(!a.support.minHeight){i=j.css("overflow");j.css("overflow","hidden")}h=j.height();this.element.siblings(":visible").each(function(){var k=a(this),l=k.css("position");if(l==="absolute"||l==="fixed"){return}h-=k.outerHeight(true)});if(i){j.css("overflow",i)}this.element.children().not(this.panels).each(function(){h-=a(this).outerHeight(true)});this.panels.each(function(){a(this).height(Math.max(0,h-a(this).innerHeight()+a(this).height()))}).css("overflow","auto")}else{if(g==="auto"){h=0;this.panels.each(function(){h=Math.max(h,a(this).height("").height())}).height(h)}}},_eventHandler:function(k){var m=this.options,g=this.active,h=a(k.currentTarget),n=h.closest("li"),i=n[0]===g[0],j=i&&m.collapsible,p=j?a():this._getPanelForTab(n),o=!g.length?a():this._getPanelForTab(g),l={oldTab:g,oldPanel:o,newTab:j?a():n,newPanel:p};k.preventDefault();if(n.hasClass("ui-state-disabled")||n.hasClass("ui-tabs-loading")||this.running||(i&&!m.collapsible)||(this._trigger("beforeActivate",k,l)===false)){return}m.active=j?false:this.tabs.index(n);this.active=i?a():n;if(this.xhr){this.xhr.abort()}if(!o.length&&!p.length){a.error("jQuery UI Tabs: Mismatching fragment identifier.")}if(p.length){this.load(this.tabs.index(n),k)}this._toggle(k,l)},_toggle:function(h,i){var k=this,m=i.newPanel,l=i.oldPanel;this.running=true;function g(){k.running=false;k._trigger("activate",h,i)}function j(){i.newTab.closest("li").addClass("ui-tabs-active ui-state-active");if(m.length&&k.options.show){k._show(m,k.options.show,g)}else{m.show();g()}}if(l.length&&this.options.hide){this._hide(l,this.options.hide,function(){i.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");j()})}else{i.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");l.hide();j()}l.attr({"aria-expanded":"false","aria-hidden":"true"});i.oldTab.attr("aria-selected","false");if(m.length&&l.length){i.oldTab.attr("tabIndex",-1)}else{if(m.length){this.tabs.filter(function(){return a(this).attr("tabIndex")===0}).attr("tabIndex",-1)}}m.attr({"aria-expanded":"true","aria-hidden":"false"});i.newTab.attr({"aria-selected":"true",tabIndex:0})},_activate:function(i){var h,g=this._findActive(i);if(g[0]===this.active[0]){return}if(!g.length){g=this.active}h=g.find(".ui-tabs-anchor")[0];this._eventHandler({target:h,currentTarget:h,preventDefault:a.noop})},_findActive:function(g){return g===false?a():this.tabs.eq(g)},_getIndex:function(g){if(typeof g==="string"){g=this.anchors.index(this.anchors.filter("[href$='"+g+"']"))}return g},_destroy:function(){if(this.xhr){this.xhr.abort()}this.element.removeClass("ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-collapsible");this.tablist.removeClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all").removeAttr("role");this.anchors.removeClass("ui-tabs-anchor").removeAttr("role").removeAttr("tabIndex").removeData("href.tabs").removeData("load.tabs").removeUniqueId();this.tabs.add(this.panels).each(function(){if(a.data(this,"ui-tabs-destroy")){a(this).remove()}else{a(this).removeClass("ui-state-default ui-state-active ui-state-disabled ui-corner-top ui-corner-bottom ui-widget-content ui-tabs-active ui-tabs-panel").removeAttr("tabIndex").removeAttr("aria-live").removeAttr("aria-busy").removeAttr("aria-selected").removeAttr("aria-labelledby").removeAttr("aria-hidden").removeAttr("aria-expanded").removeAttr("role")}});this.tabs.each(function(){var g=a(this),h=g.data("ui-tabs-aria-controls");if(h){g.attr("aria-controls",h)}else{g.removeAttr("aria-controls")}});this.panels.show();if(this.options.heightStyle!=="content"){this.panels.css("height","")}},enable:function(h){var g=this.options.disabled;if(g===false){return}if(h===f){g=false}else{h=this._getIndex(h);if(a.isArray(g)){g=a.map(g,function(i){return i!==h?i:null})}else{g=a.map(this.tabs,function(i,j){return j!==h?j:null})}}this._setupDisabled(g)},disable:function(h){var g=this.options.disabled;if(g===true){return}if(h===f){g=true}else{h=this._getIndex(h);if(a.inArray(h,g)!==-1){return}if(a.isArray(g)){g=a.merge([h],g).sort()}else{g=[h]}}this._setupDisabled(g)},load:function(j,h){j=this._getIndex(j);var m=this,l=this.tabs.eq(j),g=l.find(".ui-tabs-anchor"),k=this._getPanelForTab(l),i={tab:l,panel:k};if(c(g[0])){return}this.xhr=a.ajax(this._ajaxSettings(g,h,i));if(this.xhr&&this.xhr.statusText!=="canceled"){l.addClass("ui-tabs-loading");k.attr("aria-busy","true");this.xhr.success(function(n){setTimeout(function(){k.html(n);m._trigger("load",h,i)},1)}).complete(function(n,o){setTimeout(function(){if(o==="abort"){m.panels.stop(false,true)}l.removeClass("ui-tabs-loading");k.removeAttr("aria-busy");if(n===m.xhr){delete m.xhr}},1)})}},_ajaxSettings:function(g,h,i){var j=this;return{url:g.attr("href"),beforeSend:function(k,l){return j._trigger("beforeLoad",h,a.extend({jqXHR:k,ajaxSettings:l},i))}}},_getPanelForTab:function(h){var g=a(h).attr("aria-controls");return this.element.find(this._sanitizeSelector("#"+g))}});if(a.uiBackCompat!==false){a.ui.tabs.prototype._ui=function(h,g){return{tab:h,panel:g,index:this.anchors.index(h)}};a.widget("ui.tabs",a.ui.tabs,{url:function(g,h){this.anchors.eq(g).attr("href",h)}});a.widget("ui.tabs",a.ui.tabs,{options:{ajaxOptions:null,cache:false},_create:function(){this._super();var g=this;this._on({tabsbeforeload:function(h,i){if(a.data(i.tab[0],"cache.tabs")){h.preventDefault();return}i.jqXHR.success(function(){if(g.options.cache){a.data(i.tab[0],"cache.tabs",true)}})}})},_ajaxSettings:function(h,i,j){var g=this.options.ajaxOptions;return a.extend({},g,{error:function(m,l){try{g.error(m,l,j.tab.closest("li").index(),j.tab[0])}catch(k){}}},this._superApply(arguments))},_setOption:function(g,h){if(g==="cache"&&h===false){this.anchors.removeData("cache.tabs")}this._super(g,h)},_destroy:function(){this.anchors.removeData("cache.tabs");this._super()},url:function(g){this.anchors.eq(g).removeData("cache.tabs");this._superApply(arguments)}});a.widget("ui.tabs",a.ui.tabs,{abort:function(){if(this.xhr){this.xhr.abort()}}});a.widget("ui.tabs",a.ui.tabs,{options:{spinner:"<em>Loading&#8230;</em>"},_create:function(){this._super();this._on({tabsbeforeload:function(g,j){if(g.target!==this.element[0]||!this.options.spinner){return}var i=j.tab.find("span"),h=i.html();i.html(this.options.spinner);j.jqXHR.complete(function(){i.html(h)})}})}});a.widget("ui.tabs",a.ui.tabs,{options:{enable:null,disable:null},enable:function(g){var h=this.options,i;if(g&&h.disabled===true||(a.isArray(h.disabled)&&a.inArray(g,h.disabled)!==-1)){i=true}this._superApply(arguments);if(i){this._trigger("enable",null,this._ui(this.anchors[g],this.panels[g]))}},disable:function(g){var h=this.options,i;if(g&&h.disabled===false||(a.isArray(h.disabled)&&a.inArray(g,h.disabled)===-1)){i=true}this._superApply(arguments);if(i){this._trigger("disable",null,this._ui(this.anchors[g],this.panels[g]))}}});a.widget("ui.tabs",a.ui.tabs,{options:{add:null,remove:null,tabTemplate:"<li><a href='#{href}'><span>#{label}</span></a></li>"},add:function(n,j,i){if(i===f){i=this.anchors.length}var g,m,l=this.options,k=a(l.tabTemplate.replace(/#\{href\}/g,n).replace(/#\{label\}/g,j)),h=!n.indexOf("#")?n.replace("#",""):this._tabId(k);k.addClass("ui-state-default ui-corner-top").data("ui-tabs-destroy",true);k.attr("aria-controls",h);g=i>=this.tabs.length;m=this.element.find("#"+h);if(!m.length){m=this._createPanel(h);if(g){if(i>0){m.insertAfter(this.panels.eq(-1))}else{m.appendTo(this.element)}}else{m.insertBefore(this.panels[i])}}m.addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").hide();if(g){k.appendTo(this.tablist)}else{k.insertBefore(this.tabs[i])}l.disabled=a.map(l.disabled,function(o){return o>=i?++o:o});this.refresh();if(this.tabs.length===1&&l.active===false){this.option("active",0)}this._trigger("add",null,this._ui(this.anchors[i],this.panels[i]));return this},remove:function(g){g=this._getIndex(g);var h=this.options,j=this.tabs.eq(g).remove(),i=this._getPanelForTab(j).remove();if(j.hasClass("ui-tabs-active")&&this.anchors.length>2){this._activate(g+(g+1<this.anchors.length?1:-1))}h.disabled=a.map(a.grep(h.disabled,function(k){return k!==g}),function(k){return k>=g?--k:k});this.refresh();this._trigger("remove",null,this._ui(j.find("a")[0],i[0]));return this}});a.widget("ui.tabs",a.ui.tabs,{length:function(){return this.anchors.length}});a.widget("ui.tabs",a.ui.tabs,{options:{idPrefix:"ui-tabs-"},_tabId:function(h){var g=h.is("li")?h.find("a[href]"):h;g=g[0];return a(g).closest("li").attr("aria-controls")||g.title&&g.title.replace(/\s/g,"_").replace(/[^\w\u00c0-\uFFFF\-]/g,"")||this.options.idPrefix+b()}});a.widget("ui.tabs",a.ui.tabs,{options:{panelTemplate:"<div></div>"},_createPanel:function(g){return a(this.options.panelTemplate).attr("id",g).addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").data("ui-tabs-destroy",true)}});a.widget("ui.tabs",a.ui.tabs,{_create:function(){var g=this.options;if(g.active===null&&g.selected!==f){g.active=g.selected===-1?false:g.selected}this._super();g.selected=g.active;if(g.selected===false){g.selected=-1}},_setOption:function(g,i){if(g!=="selected"){return this._super(g,i)}var h=this.options;this._super("active",i===-1?false:i);h.selected=h.active;if(h.selected===false){h.selected=-1}},_eventHandler:function(){this._superApply(arguments);this.options.selected=this.options.active;if(this.options.selected===false){this.options.selected=-1}}});a.widget("ui.tabs",a.ui.tabs,{options:{show:null,select:null},_create:function(){this._super();if(this.options.active!==false){this._trigger("show",null,this._ui(this.active.find(".ui-tabs-anchor")[0],this._getPanelForTab(this.active)[0]))}},_trigger:function(l,h,g){var k,i,j=this._superApply(arguments);if(!j){return false}if(l==="beforeActivate"){k=g.newTab.length?g.newTab:g.oldTab;i=g.newPanel.length?g.newPanel:g.oldPanel;j=this._super("select",h,{tab:k.find(".ui-tabs-anchor")[0],panel:i[0],index:k.closest("li").index()})}else{if(l==="activate"&&g.newTab.length){j=this._super("show",h,{tab:g.newTab.find(".ui-tabs-anchor")[0],panel:g.newPanel[0],index:g.newTab.closest("li").index()})}}return j}});a.widget("ui.tabs",a.ui.tabs,{select:function(g){g=this._getIndex(g);if(g===-1){if(this.options.collapsible&&this.options.selected!==-1){g=this.options.selected}else{return}}this.anchors.eq(g).trigger(this.options.event+this.eventNamespace)}});(function(){var g=0;a.widget("ui.tabs",a.ui.tabs,{options:{cookie:null},_create:function(){var i=this.options,h;if(i.active==null&&i.cookie){h=parseInt(this._cookie(),10);if(h===-1){h=false}i.active=h}this._super()},_cookie:function(h){var i=[this.cookie||(this.cookie=this.options.cookie.name||"ui-tabs-"+(++g))];if(arguments.length){i.push(h===false?-1:h);i.push(this.options.cookie)}return a.cookie.apply(null,i)},_refresh:function(){this._super();if(this.options.cookie){this._cookie(this.options.active,this.options.cookie)}},_eventHandler:function(){this._superApply(arguments);if(this.options.cookie){this._cookie(this.options.active,this.options.cookie)}},_destroy:function(){this._super();if(this.options.cookie){this._cookie(null,this.options.cookie)}}})})();a.widget("ui.tabs",a.ui.tabs,{_trigger:function(j,i,h){var g=a.extend({},h);if(j==="load"){g.panel=g.panel[0];g.tab=g.tab.find(".ui-tabs-anchor")[0]}return this._super(j,i,g)}});a.widget("ui.tabs",a.ui.tabs,{options:{fx:null},_getFx:function(){var h,i,g=this.options.fx;if(g){if(a.isArray(g)){h=g[0];i=g[1]}else{h=i=g}}return g?{show:i,hide:h}:null},_toggle:function(h,i){var l=this,n=i.newPanel,m=i.oldPanel,j=this._getFx();if(!j){return this._super(h,i)}l.running=true;function g(){l.running=false;l._trigger("activate",h,i)}function k(){i.newTab.closest("li").addClass("ui-tabs-active ui-state-active");if(n.length&&j.show){n.animate(j.show,j.show.duration,function(){g()})}else{n.show();g()}}if(m.length&&j.hide){m.animate(j.hide,j.hide.duration,function(){i.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");k()})}else{i.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");m.hide();k()}}})}})(jQuery);(function(a){var c=0;function b(f,g){var e=(f.attr("aria-describedby")||"").split(/\s+/);e.push(g);f.data("ui-tooltip-id",g).attr("aria-describedby",a.trim(e.join(" ")))}function d(f){var g=f.data("ui-tooltip-id"),e=(f.attr("aria-describedby")||"").split(/\s+/),h=a.inArray(g,e);if(h!==-1){e.splice(h,1)}f.removeData("ui-tooltip-id");e=a.trim(e.join(" "));if(e){f.attr("aria-describedby",e)}else{f.removeAttr("aria-describedby")}}a.widget("ui.tooltip",{version:"1.9.2",options:{content:function(){return a(this).attr("title")},hide:true,items:"[title]:not([disabled])",position:{my:"left top+15",at:"left bottom",collision:"flipfit flip"},show:true,tooltipClass:null,track:false,close:null,open:null},_create:function(){this._on({mouseover:"open",focusin:"open"});this.tooltips={};this.parents={};if(this.options.disabled){this._disable()}},_setOption:function(e,g){var f=this;if(e==="disabled"){this[g?"_disable":"_enable"]();this.options[e]=g;return}this._super(e,g);if(e==="content"){a.each(this.tooltips,function(i,h){f._updateContent(h)})}},_disable:function(){var e=this;a.each(this.tooltips,function(h,f){var g=a.Event("blur");g.target=g.currentTarget=f[0];e.close(g,true)});this.element.find(this.options.items).andSelf().each(function(){var f=a(this);if(f.is("[title]")){f.data("ui-tooltip-title",f.attr("title")).attr("title","")}})},_enable:function(){this.element.find(this.options.items).andSelf().each(function(){var e=a(this);if(e.data("ui-tooltip-title")){e.attr("title",e.data("ui-tooltip-title"))}})},open:function(e){var g=this,f=a(e?e.target:this.element).closest(this.options.items);if(!f.length||f.data("ui-tooltip-id")){return}if(f.attr("title")){f.data("ui-tooltip-title",f.attr("title"))}f.data("ui-tooltip-open",true);if(e&&e.type==="mouseover"){f.parents().each(function(){var i=a(this),h;if(i.data("ui-tooltip-open")){h=a.Event("blur");h.target=h.currentTarget=this;g.close(h,true)}if(i.attr("title")){i.uniqueId();g.parents[this.id]={element:this,title:i.attr("title")};i.attr("title","")}})}this._updateContent(f,e)},_updateContent:function(i,g){var e,f=this.options.content,j=this,h=g?g.type:null;if(typeof f==="string"){return this._open(g,i,f)}e=f.call(i[0],function(k){if(!i.data("ui-tooltip-open")){return}j._delay(function(){if(g){g.type=h}this._open(g,i,k)})});if(e){this._open(g,i,e)}},_open:function(g,k,e){var l,h,f,j=a.extend({},this.options.position);if(!e){return}l=this._find(k);if(l.length){l.find(".ui-tooltip-content").html(e);return}if(k.is("[title]")){if(g&&g.type==="mouseover"){k.attr("title","")}else{k.removeAttr("title")}}l=this._tooltip(k);b(k,l.attr("id"));l.find(".ui-tooltip-content").html(e);function i(m){j.of=m;if(l.is(":hidden")){return}l.position(j)}if(this.options.track&&g&&/^mouse/.test(g.type)){this._on(this.document,{mousemove:i});i(g)}else{l.position(a.extend({of:k},this.options.position))}l.hide();this._show(l,this.options.show);if(this.options.show&&this.options.show.delay){f=setInterval(function(){if(l.is(":visible")){i(j.of);clearInterval(f)}},a.fx.interval)}this._trigger("open",g,{tooltip:l});h={keyup:function(m){if(m.keyCode===a.ui.keyCode.ESCAPE){var n=a.Event(m);n.currentTarget=k[0];this.close(n,true)}},remove:function(){this._removeTooltip(l)}};if(!g||g.type==="mouseover"){h.mouseleave="close"}if(!g||g.type==="focusin"){h.focusout="close"}this._on(true,k,h)},close:function(e){var g=this,f=a(e?e.currentTarget:this.element),h=this._find(f);if(this.closing){return}if(f.data("ui-tooltip-title")){f.attr("title",f.data("ui-tooltip-title"))}d(f);h.stop(true);this._hide(h,this.options.hide,function(){g._removeTooltip(a(this))});f.removeData("ui-tooltip-open");this._off(f,"mouseleave focusout keyup");if(f[0]!==this.element[0]){this._off(f,"remove")}this._off(this.document,"mousemove");if(e&&e.type==="mouseleave"){a.each(this.parents,function(i,j){a(j.element).attr("title",j.title);delete g.parents[i]})}this.closing=true;this._trigger("close",e,{tooltip:h});this.closing=false},_tooltip:function(e){var f="ui-tooltip-"+c++,g=a("<div>").attr({id:f,role:"tooltip"}).addClass("ui-tooltip ui-widget ui-corner-all ui-widget-content "+(this.options.tooltipClass||""));a("<div>").addClass("ui-tooltip-content").appendTo(g);g.appendTo(this.document[0].body);if(a.fn.bgiframe){g.bgiframe()}this.tooltips[f]=e;return g},_find:function(f){var e=f.data("ui-tooltip-id");return e?a("#"+e):a()},_removeTooltip:function(e){e.remove();delete this.tooltips[e.attr("id")]},_destroy:function(){var e=this;a.each(this.tooltips,function(h,f){var g=a.Event("blur");g.target=g.currentTarget=f[0];e.close(g,true);a("#"+h).remove();if(f.data("ui-tooltip-title")){f.attr("title",f.data("ui-tooltip-title"));f.removeData("ui-tooltip-title")}})}})}(jQuery));(jQuery.effects||(function(a,d){var b=a.uiBackCompat!==false,c="ui-effects-";a.effects={effect:{}};
/*
 * jQuery Color Animations v2.0.0
 * http://jquery.com/
 *
 * Copyright 2012 jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 *
 * Date: Mon Aug 13 13:41:02 2012 -0500
 */
;(function(j,s){var n="backgroundColor borderBottomColor borderLeftColor borderRightColor borderTopColor color columnRuleColor outlineColor textDecorationColor textEmphasisColor".split(" "),l=/^([\-+])=\s*(\d+\.?\d*)/,p=[{re:/rgba?\(\s*(\d{1,3})\s*,\s*(\d{1,3})\s*,\s*(\d{1,3})\s*(?:,\s*(\d+(?:\.\d+)?)\s*)?\)/,parse:function(t){return[t[1],t[2],t[3],t[4]]}},{re:/rgba?\(\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d+(?:\.\d+)?)\s*)?\)/,parse:function(t){return[t[1]*2.55,t[2]*2.55,t[3]*2.55,t[4]]}},{re:/#([a-f0-9]{2})([a-f0-9]{2})([a-f0-9]{2})/,parse:function(t){return[parseInt(t[1],16),parseInt(t[2],16),parseInt(t[3],16)]}},{re:/#([a-f0-9])([a-f0-9])([a-f0-9])/,parse:function(t){return[parseInt(t[1]+t[1],16),parseInt(t[2]+t[2],16),parseInt(t[3]+t[3],16)]}},{re:/hsla?\(\s*(\d+(?:\.\d+)?)\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d+(?:\.\d+)?)\s*)?\)/,space:"hsla",parse:function(t){return[t[1],t[2]/100,t[3]/100,t[4]]}}],f=j.Color=function(v,w,u,t){return new j.Color.fn.parse(v,w,u,t)},m={rgba:{props:{red:{idx:0,type:"byte"},green:{idx:1,type:"byte"},blue:{idx:2,type:"byte"}}},hsla:{props:{hue:{idx:0,type:"degrees"},saturation:{idx:1,type:"percent"},lightness:{idx:2,type:"percent"}}}},k={"byte":{floor:true,max:255},percent:{max:1},degrees:{mod:360,floor:true}},q=f.support={},r=j("<p>")[0],g,h=j.each;r.style.cssText="background-color:rgba(1,1,1,.5)";q.rgba=r.style.backgroundColor.indexOf("rgba")>-1;h(m,function(u,t){t.cache="_"+u;t.props.alpha={idx:3,type:"percent",def:1}});function e(w,u,t){var v=k[u.type]||{};if(w==null){return(t||!u.def)?null:u.def}w=v.floor?~~w:parseFloat(w);if(isNaN(w)){return u.def}if(v.mod){return(w+v.mod)%v.mod}return 0>w?0:v.max<w?v.max:w}function o(v){var t=f(),u=t._rgba=[];v=v.toLowerCase();h(p,function(w,z){var y,x=z.re.exec(v),B=x&&z.parse(x),A=z.space||"rgba";if(B){y=t[A](B);t[m[A].cache]=y[m[A].cache];u=t._rgba=y._rgba;return false}});if(u.length){if(u.join()==="0,0,0,0"){j.extend(u,g.transparent)}return t}return g[v]}f.fn=j.extend(f.prototype,{parse:function(x,v,u,t){if(x===s){this._rgba=[null,null,null,null];return this}if(x.jquery||x.nodeType){x=j(x).css(v);v=s}var w=this,z=j.type(x),y=this._rgba=[];if(v!==s){x=[x,v,u,t];z="array"}if(z==="string"){return this.parse(o(x)||g._default)}if(z==="array"){h(m.rgba.props,function(A,B){y[B.idx]=e(x[B.idx],B)});return this}if(z==="object"){if(x instanceof f){h(m,function(B,A){if(x[A.cache]){w[A.cache]=x[A.cache].slice()}})}else{h(m,function(C,B){var A=B.cache;h(B.props,function(D,E){if(!w[A]&&B.to){if(D==="alpha"||x[D]==null){return}w[A]=B.to(w._rgba)}w[A][E.idx]=e(x[D],E,true)});if(w[A]&&a.inArray(null,w[A].slice(0,3))<0){w[A][3]=1;if(B.from){w._rgba=B.from(w[A])}}})}return this}},is:function(t){var v=f(t),w=true,u=this;h(m,function(x,A){var z,y=v[A.cache];if(y){z=u[A.cache]||A.to&&A.to(u._rgba)||[];h(A.props,function(B,C){if(y[C.idx]!=null){w=(y[C.idx]===z[C.idx]);return w}})}return w});return w},_space:function(){var u=[],t=this;h(m,function(w,v){if(t[v.cache]){u.push(w)}});return u.pop()},transition:function(v,t){var u=f(v),y=u._space(),x=m[y],A=this.alpha()===0?f("transparent"):this,z=A[x.cache]||x.to(A._rgba),w=z.slice();u=u[x.cache];h(x.props,function(D,E){var C=E.idx,F=z[C],B=u[C],G=k[E.type]||{};if(B===null){return}if(F===null){w[C]=B}else{if(G.mod){if(B-F>G.mod/2){F+=G.mod}else{if(F-B>G.mod/2){F-=G.mod}}}w[C]=e((B-F)*t+F,E)}});return this[y](w)},blend:function(v){if(this._rgba[3]===1){return this}var w=this._rgba.slice(),t=w.pop(),u=f(v)._rgba;return f(j.map(w,function(y,x){return(1-t)*u[x]+t*y}))},toRgbaString:function(){var t="rgba(",u=j.map(this._rgba,function(x,w){return x==null?(w>2?1:0):x});if(u[3]===1){u.pop();t="rgb("}return t+u.join()+")"},toHslaString:function(){var u="hsla(",t=j.map(this.hsla(),function(x,w){if(x==null){x=w>2?1:0}if(w&&w<3){x=Math.round(x*100)+"%"}return x});if(t[3]===1){t.pop();u="hsl("}return u+t.join()+")"},toHexString:function(u){var v=this._rgba.slice(),t=v.pop();if(u){v.push(~~(t*255))}return"#"+j.map(v,function(w){w=(w||0).toString(16);return w.length===1?"0"+w:w}).join("")},toString:function(){return this._rgba[3]===0?"transparent":this.toRgbaString()}});f.fn.parse.prototype=f.fn;function i(u,v,t){t=(t+1)%1;if(t*6<1){return u+(v-u)*t*6}if(t*2<1){return v}if(t*3<2){return u+(v-u)*((2/3)-t)*6}return u}m.hsla.to=function(D){if(D[0]==null||D[1]==null||D[2]==null){return[null,null,null,D[3]]}var C=D[0]/255,x=D[1]/255,v=D[2]/255,t=D[3],A=Math.max(C,x,v),B=Math.min(C,x,v),w=A-B,u=A+B,z=u*0.5,y,E;if(B===A){y=0}else{if(C===A){y=(60*(x-v)/w)+360}else{if(x===A){y=(60*(v-C)/w)+120}else{y=(60*(C-x)/w)+240}}}if(z===0||z===1){E=z}else{if(z<=0.5){E=w/u}else{E=w/(2-u)}}return[Math.round(y)%360,E,z,t==null?1:t]};m.hsla.from=function(v){if(v[0]==null||v[1]==null||v[2]==null){return[null,null,null,v[3]]}var u=v[0]/360,z=v[1],w=v[2],t=v[3],y=w<=0.5?w*(1+z):w+z-w*z,x=2*w-y;return[Math.round(i(x,y,u+(1/3))*255),Math.round(i(x,y,u)*255),Math.round(i(x,y,u-(1/3))*255),t]};h(m,function(x,w){var v=w.props,t=w.cache,y=w.to,u=w.from;f.fn[x]=function(D){if(y&&!this[t]){this[t]=y(this._rgba)}if(D===s){return this[t].slice()}var B,C=j.type(D),z=(C==="array"||C==="object")?D:arguments,A=this[t].slice();h(v,function(E,F){var G=z[C==="object"?E:F.idx];if(G==null){G=A[F.idx]}A[F.idx]=e(G,F)});if(u){B=f(u(A));B[t]=A;return B}else{return f(A)}};h(v,function(z,A){if(f.fn[z]){return}f.fn[z]=function(F){var G=j.type(F),C=(z==="alpha"?(this._hsla?"hsla":"rgba"):x),D=this[C](),B=D[A.idx],E;if(G==="undefined"){return B}if(G==="function"){F=F.call(this,B);G=j.type(F)}if(F==null&&A.empty){return this}if(G==="string"){E=l.exec(F);if(E){F=B+parseFloat(E[2])*(E[1]==="+"?1:-1)}}D[A.idx]=F;return this[C](D)}})});h(n,function(u,t){j.cssHooks[t]={set:function(y,B){var A,w,v="";if(j.type(B)!=="string"||(A=o(B))){B=f(A||B);if(!q.rgba&&B._rgba[3]!==1){w=t==="backgroundColor"?y.parentNode:y;while((v===""||v==="transparent")&&w&&w.style){try{v=j.css(w,"backgroundColor");w=w.parentNode}catch(x){}}B=B.blend(v&&v!=="transparent"?v:"_default")}B=B.toRgbaString()}try{y.style[t]=B}catch(z){}}};j.fx.step[t]=function(v){if(!v.colorInit){v.start=f(v.elem,t);v.end=f(v.end);v.colorInit=true}j.cssHooks[t].set(v.elem,v.start.transition(v.end,v.pos))}});j.cssHooks.borderColor={expand:function(u){var t={};h(["Top","Right","Bottom","Left"],function(v,w){t["border"+w+"Color"]=u});return t}};g=j.Color.names={aqua:"#00ffff",black:"#000000",blue:"#0000ff",fuchsia:"#ff00ff",gray:"#808080",green:"#008000",lime:"#00ff00",maroon:"#800000",navy:"#000080",olive:"#808000",purple:"#800080",red:"#ff0000",silver:"#c0c0c0",teal:"#008080",white:"#ffffff",yellow:"#ffff00",transparent:[null,null,null,0],_default:"#ffffff"}})(jQuery);(function(){var e=["add","remove","toggle"],g={border:1,borderBottom:1,borderColor:1,borderLeft:1,borderRight:1,borderTop:1,borderWidth:1,margin:1,padding:1};a.each(["borderLeftStyle","borderRightStyle","borderBottomStyle","borderTopStyle"],function(i,j){a.fx.step[j]=function(k){if(k.end!=="none"&&!k.setAttr||k.pos===1&&!k.setAttr){jQuery.style(k.elem,j,k.end);k.setAttr=true}}});function f(){var l=this.ownerDocument.defaultView?this.ownerDocument.defaultView.getComputedStyle(this,null):this.currentStyle,k={},i,j;if(l&&l.length&&l[0]&&l[l[0]]){j=l.length;while(j--){i=l[j];if(typeof l[i]==="string"){k[a.camelCase(i)]=l[i]}}}else{for(i in l){if(typeof l[i]==="string"){k[i]=l[i]}}}return k}function h(l,k){var i={},j,m;for(j in k){m=k[j];if(l[j]!==m){if(!g[j]){if(a.fx.step[j]||!isNaN(parseFloat(m))){i[j]=m}}}}return i}a.effects.animateClass=function(m,j,k,i){var l=a.speed(j,k,i);return this.queue(function(){var o=a(this),q=o.attr("class")||"",p,n=l.children?o.find("*").andSelf():o;n=n.map(function(){var r=a(this);return{el:r,start:f.call(this)}});p=function(){a.each(e,function(s,r){if(m[r]){o[r+"Class"](m[r])}})};p();n=n.map(function(){this.end=f.call(this.el[0]);this.diff=h(this.start,this.end);return this});o.attr("class",q);n=n.map(function(){var t=this,r=a.Deferred(),s=jQuery.extend({},l,{queue:false,complete:function(){r.resolve(t)}});this.el.animate(this.diff,s);return r.promise()});a.when.apply(a,n.get()).done(function(){p();a.each(arguments,function(){var r=this.el;a.each(this.diff,function(s){r.css(s,"")})});l.complete.call(o[0])})})};a.fn.extend({_addClass:a.fn.addClass,addClass:function(j,l,k,i){return l?a.effects.animateClass.call(this,{add:j},l,k,i):this._addClass(j)},_removeClass:a.fn.removeClass,removeClass:function(j,l,k,i){return l?a.effects.animateClass.call(this,{remove:j},l,k,i):this._removeClass(j)},_toggleClass:a.fn.toggleClass,toggleClass:function(j,l,m,k,i){if(typeof l==="boolean"||l===d){if(!m){return this._toggleClass(j,l)}else{return a.effects.animateClass.call(this,(l?{add:j}:{remove:j}),m,k,i)}}else{return a.effects.animateClass.call(this,{toggle:j},l,m,k)}},switchClass:function(l,i,m,k,j){return a.effects.animateClass.call(this,{add:i,remove:l},m,k,j)}})})();(function(){a.extend(a.effects,{version:"1.9.2",save:function(g,j){for(var h=0;h<j.length;h++){if(j[h]!==null){g.data(c+j[h],g[0].style[j[h]])}}},restore:function(g,j){var k,h;for(h=0;h<j.length;h++){if(j[h]!==null){k=g.data(c+j[h]);if(k===d){k=""}g.css(j[h],k)}}},setMode:function(g,h){if(h==="toggle"){h=g.is(":hidden")?"show":"hide"}return h},getBaseline:function(g,h){var j,i;switch(g[0]){case"top":j=0;break;case"middle":j=0.5;break;case"bottom":j=1;break;default:j=g[0]/h.height}switch(g[1]){case"left":i=0;break;case"center":i=0.5;break;case"right":i=1;break;default:i=g[1]/h.width}return{x:i,y:j}},createWrapper:function(i){if(i.parent().is(".ui-effects-wrapper")){return i.parent()}var j={width:i.outerWidth(true),height:i.outerHeight(true),"float":i.css("float")},l=a("<div></div>").addClass("ui-effects-wrapper").css({fontSize:"100%",background:"transparent",border:"none",margin:0,padding:0}),k={width:i.width(),height:i.height()},g=document.activeElement;try{g.id}catch(h){g=document.body}i.wrap(l);if(i[0]===g||a.contains(i[0],g)){a(g).focus()}l=i.parent();if(i.css("position")==="static"){l.css({position:"relative"});i.css({position:"relative"})}else{a.extend(j,{position:i.css("position"),zIndex:i.css("z-index")});a.each(["top","left","bottom","right"],function(m,n){j[n]=i.css(n);if(isNaN(parseInt(j[n],10))){j[n]="auto"}});i.css({position:"relative",top:0,left:0,right:"auto",bottom:"auto"})}i.css(k);return l.css(j).show()},removeWrapper:function(h){var g=document.activeElement;if(h.parent().is(".ui-effects-wrapper")){h.parent().replaceWith(h);if(h[0]===g||a.contains(h[0],g)){a(g).focus()}}return h},setTransition:function(g,i,h,j){j=j||{};a.each(i,function(k,m){var l=g.cssUnit(m);if(l[0]>0){j[m]=l[0]*h+l[1]}});return j}});function e(h,i,j,g){if(a.isPlainObject(h)){i=h;h=h.effect}h={effect:h};if(i==null){i={}}if(a.isFunction(i)){g=i;j=null;i={}}if(typeof i==="number"||a.fx.speeds[i]){g=j;j=i;i={}}if(a.isFunction(j)){g=j;j=null}if(i){a.extend(h,i)}j=j||i.duration;h.duration=a.fx.off?0:typeof j==="number"?j:j in a.fx.speeds?a.fx.speeds[j]:a.fx.speeds._default;h.complete=g||i.complete;return h}function f(g){if(!g||typeof g==="number"||a.fx.speeds[g]){return true}if(typeof g==="string"&&!a.effects.effect[g]){if(b&&a.effects[g]){return false}return true}return false}a.fn.extend({effect:function(){var g=e.apply(this,arguments),i=g.mode,k=g.queue,h=a.effects.effect[g.effect],j=!h&&b&&a.effects[g.effect];if(a.fx.off||!(h||j)){if(i){return this[i](g.duration,g.complete)}else{return this.each(function(){if(g.complete){g.complete.call(this)}})}}function l(q){var o=a(this),m=g.complete,p=g.mode;function n(){if(a.isFunction(m)){m.call(o[0])}if(a.isFunction(q)){q()}}if(o.is(":hidden")?p==="hide":p==="show"){n()}else{h.call(o[0],g,n)}}if(h){return k===false?this.each(l):this.queue(k||"fx",l)}else{return j.call(this,{options:g,duration:g.duration,callback:g.complete,mode:g.mode})}},_show:a.fn.show,show:function(h){if(f(h)){return this._show.apply(this,arguments)}else{var g=e.apply(this,arguments);g.mode="show";return this.effect.call(this,g)}},_hide:a.fn.hide,hide:function(h){if(f(h)){return this._hide.apply(this,arguments)}else{var g=e.apply(this,arguments);g.mode="hide";return this.effect.call(this,g)}},__toggle:a.fn.toggle,toggle:function(h){if(f(h)||typeof h==="boolean"||a.isFunction(h)){return this.__toggle.apply(this,arguments)}else{var g=e.apply(this,arguments);g.mode="toggle";return this.effect.call(this,g)}},cssUnit:function(g){var h=this.css(g),i=[];a.each(["em","px","%","pt"],function(j,k){if(h.indexOf(k)>0){i=[parseFloat(h),k]}});return i}})})();(function(){var e={};a.each(["Quad","Cubic","Quart","Quint","Expo"],function(f,g){e[g]=function(h){return Math.pow(h,f+2)}});a.extend(e,{Sine:function(f){return 1-Math.cos(f*Math.PI/2)},Circ:function(f){return 1-Math.sqrt(1-f*f)},Elastic:function(f){return f===0||f===1?f:-Math.pow(2,8*(f-1))*Math.sin(((f-1)*80-7.5)*Math.PI/15)},Back:function(f){return f*f*(3*f-2)},Bounce:function(g){var h,f=4;while(g<((h=Math.pow(2,--f))-1)/11){}return 1/Math.pow(4,3-f)-7.5625*Math.pow((h*3-2)/22-g,2)}});a.each(e,function(g,f){a.easing["easeIn"+g]=f;a.easing["easeOut"+g]=function(h){return 1-f(1-h)};a.easing["easeInOut"+g]=function(h){return h<0.5?f(h*2)/2:1-f(h*-2+2)/2}})})()})(jQuery));(function(a,d){var c=/up|down|vertical/,b=/up|left|vertical|horizontal/;a.effects.effect.blind=function(m,h){var i=a(this),n=["position","top","bottom","left","right","height","width"],k=a.effects.setMode(i,m.mode||"hide"),f=m.direction||"up",s=c.test(f),p=s?"height":"width",q=s?"top":"left",l=b.test(f),e={},r=k==="show",t,g,j;if(i.parent().is(".ui-effects-wrapper")){a.effects.save(i.parent(),n)}else{a.effects.save(i,n)}i.show();t=a.effects.createWrapper(i).css({overflow:"hidden"});g=t[p]();j=parseFloat(t.css(q))||0;e[p]=r?g:0;if(!l){i.css(s?"bottom":"right",0).css(s?"top":"left","auto").css({position:"absolute"});e[q]=r?j:g+j}if(r){t.css(p,0);if(!l){t.css(q,j+g)}}t.animate(e,{duration:m.duration,easing:m.easing,queue:false,complete:function(){if(k==="hide"){i.hide()}a.effects.restore(i,n);a.effects.removeWrapper(i);h()}})}})(jQuery);(function(a,b){a.effects.effect.bounce=function(p,f){var j=a(this),q=["position","top","bottom","left","right","height","width"],m=a.effects.setMode(j,p.mode||"effect"),k=m==="hide",u=m==="show",d=p.direction||"up",e=p.distance,w=p.times||5,c=w*2+(u||k?1:0),v=p.duration/c,h=p.easing,t=(d==="up"||d==="down")?"top":"left",n=(d==="up"||d==="left"),l,x,g,r=j.queue(),s=r.length;if(u||k){q.push("opacity")}a.effects.save(j,q);j.show();a.effects.createWrapper(j);if(!e){e=j[t==="top"?"outerHeight":"outerWidth"]()/3}if(u){g={opacity:1};g[t]=0;j.css("opacity",0).css(t,n?-e*2:e*2).animate(g,v,h)}if(k){e=e/Math.pow(2,w-1)}g={};g[t]=0;for(l=0;l<w;l++){x={};x[t]=(n?"-=":"+=")+e;j.animate(x,v,h).animate(g,v,h);e=k?e*2:e/2}if(k){x={opacity:0};x[t]=(n?"-=":"+=")+e;j.animate(x,v,h)}j.queue(function(){if(k){j.hide()}a.effects.restore(j,q);a.effects.removeWrapper(j);f()});if(s>1){r.splice.apply(r,[1,0].concat(r.splice(s,c+1)))}j.dequeue()}})(jQuery);(function(a,b){a.effects.effect.clip=function(j,g){var h=a(this),l=["position","top","bottom","left","right","height","width"],i=a.effects.setMode(h,j.mode||"hide"),m=i==="show",e=j.direction||"vertical",p=e==="vertical",n=p?"height":"width",k=p?"top":"left",d={},q,c,f;a.effects.save(h,l);h.show();q=a.effects.createWrapper(h).css({overflow:"hidden"});c=(h[0].tagName==="IMG")?q:h;f=c[n]();if(m){c.css(n,0);c.css(k,f/2)}d[n]=m?f:0;d[k]=m?0:f/2;c.animate(d,{queue:false,duration:j.duration,easing:j.easing,complete:function(){if(!m){h.hide()}a.effects.restore(h,l);a.effects.removeWrapper(h);g()}})}})(jQuery);(function(a,b){a.effects.effect.drop=function(j,f){var g=a(this),k=["position","top","bottom","left","right","opacity","height","width"],h=a.effects.setMode(g,j.mode||"hide"),m=h==="show",d=j.direction||"left",l=(d==="up"||d==="down")?"top":"left",i=(d==="up"||d==="left")?"pos":"neg",c={opacity:m?1:0},e;a.effects.save(g,k);g.show();a.effects.createWrapper(g);e=j.distance||g[l==="top"?"outerHeight":"outerWidth"](true)/2;if(m){g.css("opacity",0).css(l,i==="pos"?-e:e)}c[l]=(m?(i==="pos"?"+=":"-="):(i==="pos"?"-=":"+="))+e;g.animate(c,{queue:false,duration:j.duration,easing:j.easing,complete:function(){if(h==="hide"){g.hide()}a.effects.restore(g,k);a.effects.removeWrapper(g);f()}})}})(jQuery);(function(a,b){a.effects.effect.explode=function(r,f){var u=r.pieces?Math.round(Math.sqrt(r.pieces)):3,d=u,g=a(this),n=a.effects.setMode(g,r.mode||"hide"),v=n==="show",s=g.show().css("visibility","hidden").offset(),x=Math.ceil(g.outerWidth()/d),h=Math.ceil(g.outerHeight()/u),t=[],k,l,m,w,p,q;function e(){t.push(this);if(t.length===u*d){c()}}for(k=0;k<u;k++){w=s.top+k*h;q=k-(u-1)/2;for(l=0;l<d;l++){m=s.left+l*x;p=l-(d-1)/2;g.clone().appendTo("body").wrap("<div></div>").css({position:"absolute",visibility:"visible",left:-l*x,top:-k*h}).parent().addClass("ui-effects-explode").css({position:"absolute",overflow:"hidden",width:x,height:h,left:m+(v?p*x:0),top:w+(v?q*h:0),opacity:v?0:1}).animate({left:m+(v?0:p*x),top:w+(v?0:q*h),opacity:v?1:0},r.duration||500,r.easing,e)}}function c(){g.css({visibility:"visible"});a(t).remove();if(!v){g.hide()}f()}}})(jQuery);(function(a,b){a.effects.effect.fade=function(f,c){var d=a(this),e=a.effects.setMode(d,f.mode||"toggle");d.animate({opacity:e},{queue:false,duration:f.duration,easing:f.easing,complete:c})}})(jQuery);(function(a,b){a.effects.effect.fold=function(l,f){var h=a(this),n=["position","top","bottom","left","right","height","width"],k=a.effects.setMode(h,l.mode||"hide"),q=k==="show",i=k==="hide",r=l.size||15,m=/([0-9]+)%/.exec(r),j=!!l.horizFirst,s=q!==j,p=s?["width","height"]:["height","width"],g=l.duration/2,t,e,c={},d={};a.effects.save(h,n);h.show();t=a.effects.createWrapper(h).css({overflow:"hidden"});e=s?[t.width(),t.height()]:[t.height(),t.width()];if(m){r=parseInt(m[1],10)/100*e[i?0:1]}if(q){t.css(j?{height:0,width:r}:{height:r,width:0})}c[p[0]]=q?e[0]:r;d[p[1]]=q?e[1]:0;t.animate(c,g,l.easing).animate(d,g,l.easing,function(){if(i){h.hide()}a.effects.restore(h,n);a.effects.removeWrapper(h);f()})}})(jQuery);(function(a,b){a.effects.effect.highlight=function(g,d){var e=a(this),h=["backgroundImage","backgroundColor","opacity"],f=a.effects.setMode(e,g.mode||"show"),c={backgroundColor:e.css("backgroundColor")};if(f==="hide"){c.opacity=0}a.effects.save(e,h);e.show().css({backgroundImage:"none",backgroundColor:g.color||"#ffff99"}).animate(c,{queue:false,duration:g.duration,easing:g.easing,complete:function(){if(f==="hide"){e.hide()}a.effects.restore(e,h);d()}})}})(jQuery);(function(a,b){a.effects.effect.pulsate=function(l,e){var g=a(this),k=a.effects.setMode(g,l.mode||"show"),p=k==="show",h=k==="hide",q=(p||k==="hide"),d=((l.times||5)*2)+(q?1:0),f=l.duration/d,c=0,m=g.queue(),n=m.length,j;if(p||!g.is(":visible")){g.css("opacity",0).show();c=1}for(j=1;j<d;j++){g.animate({opacity:c},f,l.easing);c=1-c}g.animate({opacity:c},f,l.easing);g.queue(function(){if(h){g.hide()}e()});if(n>1){m.splice.apply(m,[1,0].concat(m.splice(n,d+1)))}g.dequeue()}})(jQuery);(function(a,b){a.effects.effect.puff=function(h,c){var d=a(this),g=a.effects.setMode(d,h.mode||"hide"),f=g==="hide",j=parseInt(h.percent,10)||150,e=j/100,i={height:d.height(),width:d.width(),outerHeight:d.outerHeight(),outerWidth:d.outerWidth()};a.extend(h,{effect:"scale",queue:false,fade:true,mode:g,complete:c,percent:f?j:100,from:f?i:{height:i.height*e,width:i.width*e,outerHeight:i.outerHeight*e,outerWidth:i.outerWidth*e}});d.effect(h)};a.effects.effect.scale=function(h,d){var e=a(this),i=a.extend(true,{},h),g=a.effects.setMode(e,h.mode||"effect"),l=parseInt(h.percent,10)||(parseInt(h.percent,10)===0?0:(g==="hide"?0:100)),c=h.direction||"both",j=h.origin,k={height:e.height(),width:e.width(),outerHeight:e.outerHeight(),outerWidth:e.outerWidth()},f={y:c!=="horizontal"?(l/100):1,x:c!=="vertical"?(l/100):1};i.effect="size";i.queue=false;i.complete=d;if(g!=="effect"){i.origin=j||["middle","center"];i.restore=true}i.from=h.from||(g==="show"?{height:0,width:0,outerHeight:0,outerWidth:0}:k);i.to={height:k.height*f.y,width:k.width*f.x,outerHeight:k.outerHeight*f.y,outerWidth:k.outerWidth*f.x};if(i.fade){if(g==="show"){i.from.opacity=0;i.to.opacity=1}if(g==="hide"){i.from.opacity=1;i.to.opacity=0}}e.effect(i)};a.effects.effect.size=function(j,e){var l,c,g,f=a(this),p=["position","top","bottom","left","right","width","height","overflow","opacity"],q=["position","top","bottom","left","right","overflow","opacity"],r=["width","height","overflow"],d=["fontSize"],u=["borderTopWidth","borderBottomWidth","paddingTop","paddingBottom"],h=["borderLeftWidth","borderRightWidth","paddingLeft","paddingRight"],i=a.effects.setMode(f,j.mode||"effect"),s=j.restore||i!=="effect",t=j.scale||"both",k=j.origin||["middle","center"],m=f.css("position"),n=s?p:q,v={height:0,width:0,outerHeight:0,outerWidth:0};if(i==="show"){f.show()}l={height:f.height(),width:f.width(),outerHeight:f.outerHeight(),outerWidth:f.outerWidth()};if(j.mode==="toggle"&&i==="show"){f.from=j.to||v;f.to=j.from||l}else{f.from=j.from||(i==="show"?v:l);f.to=j.to||(i==="hide"?v:l)}g={from:{y:f.from.height/l.height,x:f.from.width/l.width},to:{y:f.to.height/l.height,x:f.to.width/l.width}};if(t==="box"||t==="both"){if(g.from.y!==g.to.y){n=n.concat(u);f.from=a.effects.setTransition(f,u,g.from.y,f.from);f.to=a.effects.setTransition(f,u,g.to.y,f.to)}if(g.from.x!==g.to.x){n=n.concat(h);f.from=a.effects.setTransition(f,h,g.from.x,f.from);f.to=a.effects.setTransition(f,h,g.to.x,f.to)}}if(t==="content"||t==="both"){if(g.from.y!==g.to.y){n=n.concat(d).concat(r);f.from=a.effects.setTransition(f,d,g.from.y,f.from);f.to=a.effects.setTransition(f,d,g.to.y,f.to)}}a.effects.save(f,n);f.show();a.effects.createWrapper(f);f.css("overflow","hidden").css(f.from);if(k){c=a.effects.getBaseline(k,l);f.from.top=(l.outerHeight-f.outerHeight())*c.y;f.from.left=(l.outerWidth-f.outerWidth())*c.x;f.to.top=(l.outerHeight-f.to.outerHeight)*c.y;f.to.left=(l.outerWidth-f.to.outerWidth)*c.x}f.css(f.from);if(t==="content"||t==="both"){u=u.concat(["marginTop","marginBottom"]).concat(d);h=h.concat(["marginLeft","marginRight"]);r=p.concat(u).concat(h);f.find("*[width]").each(function(){var w=a(this),o={height:w.height(),width:w.width(),outerHeight:w.outerHeight(),outerWidth:w.outerWidth()};if(s){a.effects.save(w,r)}w.from={height:o.height*g.from.y,width:o.width*g.from.x,outerHeight:o.outerHeight*g.from.y,outerWidth:o.outerWidth*g.from.x};w.to={height:o.height*g.to.y,width:o.width*g.to.x,outerHeight:o.height*g.to.y,outerWidth:o.width*g.to.x};if(g.from.y!==g.to.y){w.from=a.effects.setTransition(w,u,g.from.y,w.from);w.to=a.effects.setTransition(w,u,g.to.y,w.to)}if(g.from.x!==g.to.x){w.from=a.effects.setTransition(w,h,g.from.x,w.from);w.to=a.effects.setTransition(w,h,g.to.x,w.to)}w.css(w.from);w.animate(w.to,j.duration,j.easing,function(){if(s){a.effects.restore(w,r)}})})}f.animate(f.to,{queue:false,duration:j.duration,easing:j.easing,complete:function(){if(f.to.opacity===0){f.css("opacity",f.from.opacity)}if(i==="hide"){f.hide()}a.effects.restore(f,n);if(!s){if(m==="static"){f.css({position:"relative",top:f.to.top,left:f.to.left})}else{a.each(["top","left"],function(o,w){f.css(w,function(x,y){var A=parseInt(y,10),z=o?f.to.left:f.to.top;if(y==="auto"){return z+"px"}return A+z+"px"})})}}a.effects.removeWrapper(f);e()}})}})(jQuery);(function(a,b){a.effects.effect.shake=function(n,j){var k=a(this),q=["position","top","bottom","left","right","height","width"],m=a.effects.setMode(k,n.mode||"effect"),g=n.direction||"left",h=n.distance||20,v=n.times||3,f=v*2+1,u=Math.round(n.duration/f),t=(g==="up"||g==="down")?"top":"left",p=(g==="up"||g==="left"),c={},d={},e={},l,r=k.queue(),s=r.length;a.effects.save(k,q);k.show();a.effects.createWrapper(k);c[t]=(p?"-=":"+=")+h;d[t]=(p?"+=":"-=")+h*2;e[t]=(p?"-=":"+=")+h*2;k.animate(c,u,n.easing);for(l=1;l<v;l++){k.animate(d,u,n.easing).animate(e,u,n.easing)}k.animate(d,u,n.easing).animate(c,u/2,n.easing).queue(function(){if(m==="hide"){k.hide()}a.effects.restore(k,q);a.effects.removeWrapper(k);j()});if(s>1){r.splice.apply(r,[1,0].concat(r.splice(s,f+1)))}k.dequeue()}})(jQuery);(function(a,b){a.effects.effect.slide=function(i,f){var g=a(this),k=["position","top","bottom","left","right","width","height"],h=a.effects.setMode(g,i.mode||"show"),m=h==="show",d=i.direction||"left",l=(d==="up"||d==="down")?"top":"left",j=(d==="up"||d==="left"),e,c={};a.effects.save(g,k);g.show();e=i.distance||g[l==="top"?"outerHeight":"outerWidth"](true);a.effects.createWrapper(g).css({overflow:"hidden"});if(m){g.css(l,j?(isNaN(e)?"-"+e:-e):e)}c[l]=(m?(j?"+=":"-="):(j?"-=":"+="))+e;g.animate(c,{queue:false,duration:i.duration,easing:i.easing,complete:function(){if(h==="hide"){g.hide()}a.effects.restore(g,k);a.effects.removeWrapper(g);f()}})}})(jQuery);(function(a,b){a.effects.effect.transfer=function(j,e){var f=a(this),l=a(j.to),m=l.css("position")==="fixed",d=a("body"),i=m?d.scrollTop():0,h=m?d.scrollLeft():0,g=l.offset(),c={top:g.top-i,left:g.left-h,height:l.innerHeight(),width:l.innerWidth()},k=f.offset(),n=a('<div class="ui-effects-transfer"></div>').appendTo(document.body).addClass(j.className).css({top:k.top-i,left:k.left-h,height:f.innerHeight(),width:f.innerWidth(),position:m?"fixed":"absolute"}).animate(c,j.duration,j.easing,function(){n.remove();e()})}})(jQuery);
/*! jQuery Timepicker Addon - v1.4.1 - 2013-11-10
* http://trentrichardson.com/examples/timepicker
* Copyright (c) 2013 Trent Richardson; Licensed MIT */
;(function ($) {

	/*
	* Lets not redefine timepicker, Prevent "Uncaught RangeError: Maximum call stack size exceeded"
	*/
	$.ui.timepicker = $.ui.timepicker || {};
	if ($.ui.timepicker.version) {
		return;
	}

	/*
	* Extend jQueryUI, get it started with our version number
	*/
	$.extend($.ui, {
		timepicker: {
			version: "1.4.1"
		}
	});

	/* 
	* Timepicker manager.
	* Use the singleton instance of this class, $.timepicker, to interact with the time picker.
	* Settings for (groups of) time pickers are maintained in an instance object,
	* allowing multiple different settings on the same page.
	*/
	var Timepicker = function () {
		this.regional = []; // Available regional settings, indexed by language code
		this.regional[''] = { // Default regional settings
			currentText: 'Now',
			closeText: 'Done',
			amNames: ['AM', 'A'],
			pmNames: ['PM', 'P'],
			timeFormat: 'HH:mm',
			timeSuffix: '',
			timeOnlyTitle: 'Choose Time',
			timeText: 'Time',
			hourText: 'Hour',
			minuteText: 'Minute',
			secondText: 'Second',
			millisecText: 'Millisecond',
			microsecText: 'Microsecond',
			timezoneText: 'Time Zone',
			isRTL: false
		};
		this._defaults = { // Global defaults for all the datetime picker instances
			showButtonPanel: true,
			timeOnly: false,
			showHour: null,
			showMinute: null,
			showSecond: null,
			showMillisec: null,
			showMicrosec: null,
			showTimezone: null,
			showTime: true,
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1,
			stepMillisec: 1,
			stepMicrosec: 1,
			hour: 0,
			minute: 0,
			second: 0,
			millisec: 0,
			microsec: 0,
			timezone: null,
			hourMin: 0,
			minuteMin: 0,
			secondMin: 0,
			millisecMin: 0,
			microsecMin: 0,
			hourMax: 23,
			minuteMax: 59,
			secondMax: 59,
			millisecMax: 999,
			microsecMax: 999,
			minDateTime: null,
			maxDateTime: null,
			onSelect: null,
			hourGrid: 0,
			minuteGrid: 0,
			secondGrid: 0,
			millisecGrid: 0,
			microsecGrid: 0,
			alwaysSetTime: true,
			separator: ' ',
			altFieldTimeOnly: true,
			altTimeFormat: null,
			altSeparator: null,
			altTimeSuffix: null,
			pickerTimeFormat: null,
			pickerTimeSuffix: null,
			showTimepicker: true,
			timezoneList: null,
			addSliderAccess: false,
			sliderAccessArgs: null,
			controlType: 'slider',
			defaultValue: null,
			parse: 'strict'
		};
		$.extend(this._defaults, this.regional['']);
	};

	$.extend(Timepicker.prototype, {
		$input: null,
		$altInput: null,
		$timeObj: null,
		inst: null,
		hour_slider: null,
		minute_slider: null,
		second_slider: null,
		millisec_slider: null,
		microsec_slider: null,
		timezone_select: null,
		hour: 0,
		minute: 0,
		second: 0,
		millisec: 0,
		microsec: 0,
		timezone: null,
		hourMinOriginal: null,
		minuteMinOriginal: null,
		secondMinOriginal: null,
		millisecMinOriginal: null,
		microsecMinOriginal: null,
		hourMaxOriginal: null,
		minuteMaxOriginal: null,
		secondMaxOriginal: null,
		millisecMaxOriginal: null,
		microsecMaxOriginal: null,
		ampm: '',
		formattedDate: '',
		formattedTime: '',
		formattedDateTime: '',
		timezoneList: null,
		units: ['hour', 'minute', 'second', 'millisec', 'microsec'],
		support: {},
		control: null,

		/* 
		* Override the default settings for all instances of the time picker.
		* @param  {Object} settings  object - the new settings to use as defaults (anonymous object)
		* @return {Object} the manager object
		*/
		setDefaults: function (settings) {
			extendRemove(this._defaults, settings || {});
			return this;
		},

		/*
		* Create a new Timepicker instance
		*/
		_newInst: function ($input, opts) {
			var tp_inst = new Timepicker(),
				inlineSettings = {},
				fns = {},
				overrides, i;

			for (var attrName in this._defaults) {
				if (this._defaults.hasOwnProperty(attrName)) {
					var attrValue = $input.attr('time:' + attrName);
					if (attrValue) {
						try {
							inlineSettings[attrName] = eval(attrValue);
						} catch (err) {
							inlineSettings[attrName] = attrValue;
						}
					}
				}
			}

			overrides = {
				beforeShow: function (input, dp_inst) {
					if ($.isFunction(tp_inst._defaults.evnts.beforeShow)) {
						return tp_inst._defaults.evnts.beforeShow.call($input[0], input, dp_inst, tp_inst);
					}
				},
				onChangeMonthYear: function (year, month, dp_inst) {
					// Update the time as well : this prevents the time from disappearing from the $input field.
					tp_inst._updateDateTime(dp_inst);
					if ($.isFunction(tp_inst._defaults.evnts.onChangeMonthYear)) {
						tp_inst._defaults.evnts.onChangeMonthYear.call($input[0], year, month, dp_inst, tp_inst);
					}
				},
				onClose: function (dateText, dp_inst) {
					if (tp_inst.timeDefined === true && $input.val() !== '') {
						tp_inst._updateDateTime(dp_inst);
					}
					if ($.isFunction(tp_inst._defaults.evnts.onClose)) {
						tp_inst._defaults.evnts.onClose.call($input[0], dateText, dp_inst, tp_inst);
					}
				}
			};
			for (i in overrides) {
				if (overrides.hasOwnProperty(i)) {
					fns[i] = opts[i] || null;
				}
			}

			tp_inst._defaults = $.extend({}, this._defaults, inlineSettings, opts, overrides, {
				evnts: fns,
				timepicker: tp_inst // add timepicker as a property of datepicker: $.datepicker._get(dp_inst, 'timepicker');
			});
			tp_inst.amNames = $.map(tp_inst._defaults.amNames, function (val) {
				return val.toUpperCase();
			});
			tp_inst.pmNames = $.map(tp_inst._defaults.pmNames, function (val) {
				return val.toUpperCase();
			});

			// detect which units are supported
			tp_inst.support = detectSupport(
					tp_inst._defaults.timeFormat + 
					(tp_inst._defaults.pickerTimeFormat ? tp_inst._defaults.pickerTimeFormat : '') +
					(tp_inst._defaults.altTimeFormat ? tp_inst._defaults.altTimeFormat : ''));

			// controlType is string - key to our this._controls
			if (typeof(tp_inst._defaults.controlType) === 'string') {
				if (tp_inst._defaults.controlType === 'slider' && typeof($.ui.slider) === 'undefined') {
					tp_inst._defaults.controlType = 'select';
				}
				tp_inst.control = tp_inst._controls[tp_inst._defaults.controlType];
			}
			// controlType is an object and must implement create, options, value methods
			else {
				tp_inst.control = tp_inst._defaults.controlType;
			}

			// prep the timezone options
			var timezoneList = [-720, -660, -600, -570, -540, -480, -420, -360, -300, -270, -240, -210, -180, -120, -60,
					0, 60, 120, 180, 210, 240, 270, 300, 330, 345, 360, 390, 420, 480, 525, 540, 570, 600, 630, 660, 690, 720, 765, 780, 840];
			if (tp_inst._defaults.timezoneList !== null) {
				timezoneList = tp_inst._defaults.timezoneList;
			}
			var tzl = timezoneList.length, tzi = 0, tzv = null;
			if (tzl > 0 && typeof timezoneList[0] !== 'object') {
				for (; tzi < tzl; tzi++) {
					tzv = timezoneList[tzi];
					timezoneList[tzi] = { value: tzv, label: $.timepicker.timezoneOffsetString(tzv, tp_inst.support.iso8601) };
				}
			}
			tp_inst._defaults.timezoneList = timezoneList;

			// set the default units
			tp_inst.timezone = tp_inst._defaults.timezone !== null ? $.timepicker.timezoneOffsetNumber(tp_inst._defaults.timezone) :
							((new Date()).getTimezoneOffset() * -1);
			tp_inst.hour = tp_inst._defaults.hour < tp_inst._defaults.hourMin ? tp_inst._defaults.hourMin :
							tp_inst._defaults.hour > tp_inst._defaults.hourMax ? tp_inst._defaults.hourMax : tp_inst._defaults.hour;
			tp_inst.minute = tp_inst._defaults.minute < tp_inst._defaults.minuteMin ? tp_inst._defaults.minuteMin :
							tp_inst._defaults.minute > tp_inst._defaults.minuteMax ? tp_inst._defaults.minuteMax : tp_inst._defaults.minute;
			tp_inst.second = tp_inst._defaults.second < tp_inst._defaults.secondMin ? tp_inst._defaults.secondMin :
							tp_inst._defaults.second > tp_inst._defaults.secondMax ? tp_inst._defaults.secondMax : tp_inst._defaults.second;
			tp_inst.millisec = tp_inst._defaults.millisec < tp_inst._defaults.millisecMin ? tp_inst._defaults.millisecMin :
							tp_inst._defaults.millisec > tp_inst._defaults.millisecMax ? tp_inst._defaults.millisecMax : tp_inst._defaults.millisec;
			tp_inst.microsec = tp_inst._defaults.microsec < tp_inst._defaults.microsecMin ? tp_inst._defaults.microsecMin :
							tp_inst._defaults.microsec > tp_inst._defaults.microsecMax ? tp_inst._defaults.microsecMax : tp_inst._defaults.microsec;
			tp_inst.ampm = '';
			tp_inst.$input = $input;

			if (tp_inst._defaults.altField) {
				tp_inst.$altInput = $(tp_inst._defaults.altField).css({
					cursor: 'pointer'
				}).focus(function () {
					$input.trigger("focus");
				});
			}

			if (tp_inst._defaults.minDate === 0 || tp_inst._defaults.minDateTime === 0) {
				tp_inst._defaults.minDate = new Date();
			}
			if (tp_inst._defaults.maxDate === 0 || tp_inst._defaults.maxDateTime === 0) {
				tp_inst._defaults.maxDate = new Date();
			}

			// datepicker needs minDate/maxDate, timepicker needs minDateTime/maxDateTime..
			if (tp_inst._defaults.minDate !== undefined && tp_inst._defaults.minDate instanceof Date) {
				tp_inst._defaults.minDateTime = new Date(tp_inst._defaults.minDate.getTime());
			}
			if (tp_inst._defaults.minDateTime !== undefined && tp_inst._defaults.minDateTime instanceof Date) {
				tp_inst._defaults.minDate = new Date(tp_inst._defaults.minDateTime.getTime());
			}
			if (tp_inst._defaults.maxDate !== undefined && tp_inst._defaults.maxDate instanceof Date) {
				tp_inst._defaults.maxDateTime = new Date(tp_inst._defaults.maxDate.getTime());
			}
			if (tp_inst._defaults.maxDateTime !== undefined && tp_inst._defaults.maxDateTime instanceof Date) {
				tp_inst._defaults.maxDate = new Date(tp_inst._defaults.maxDateTime.getTime());
			}
			tp_inst.$input.bind('focus', function () {
				tp_inst._onFocus();
			});

			return tp_inst;
		},

		/*
		* add our sliders to the calendar
		*/
		_addTimePicker: function (dp_inst) {
			var currDT = (this.$altInput && this._defaults.altFieldTimeOnly) ? this.$input.val() + ' ' + this.$altInput.val() : this.$input.val();

			this.timeDefined = this._parseTime(currDT);
			this._limitMinMaxDateTime(dp_inst, false);
			this._injectTimePicker();
		},

		/*
		* parse the time string from input value or _setTime
		*/
		_parseTime: function (timeString, withDate) {
			if (!this.inst) {
				this.inst = $.datepicker._getInst(this.$input[0]);
			}

			if (withDate || !this._defaults.timeOnly) {
				var dp_dateFormat = $.datepicker._get(this.inst, 'dateFormat');
				try {
					var parseRes = parseDateTimeInternal(dp_dateFormat, this._defaults.timeFormat, timeString, $.datepicker._getFormatConfig(this.inst), this._defaults);
					if (!parseRes.timeObj) {
						return false;
					}
					$.extend(this, parseRes.timeObj);
				} catch (err) {
					$.timepicker.log("Error parsing the date/time string: " + err +
									"\ndate/time string = " + timeString +
									"\ntimeFormat = " + this._defaults.timeFormat +
									"\ndateFormat = " + dp_dateFormat);
					return false;
				}
				return true;
			} else {
				var timeObj = $.datepicker.parseTime(this._defaults.timeFormat, timeString, this._defaults);
				if (!timeObj) {
					return false;
				}
				$.extend(this, timeObj);
				return true;
			}
		},

		/*
		* generate and inject html for timepicker into ui datepicker
		*/
		_injectTimePicker: function () {
			var $dp = this.inst.dpDiv,
				o = this.inst.settings,
				tp_inst = this,
				litem = '',
				uitem = '',
				show = null,
				max = {},
				gridSize = {},
				size = null,
				i = 0,
				l = 0;

			// Prevent displaying twice
			if ($dp.find("div.ui-timepicker-div").length === 0 && o.showTimepicker) {
				var noDisplay = ' style="display:none;"',
					html = '<div class="ui-timepicker-div' + (o.isRTL ? ' ui-timepicker-rtl' : '') + '"><dl>' + '<dt class="ui_tpicker_time_label"' + ((o.showTime) ? '' : noDisplay) + '>' + o.timeText + '</dt>' +
								'<dd class="ui_tpicker_time"' + ((o.showTime) ? '' : noDisplay) + '></dd>';

				// Create the markup
				for (i = 0, l = this.units.length; i < l; i++) {
					litem = this.units[i];
					uitem = litem.substr(0, 1).toUpperCase() + litem.substr(1);
					show = o['show' + uitem] !== null ? o['show' + uitem] : this.support[litem];

					// Added by Peter Medeiros:
					// - Figure out what the hour/minute/second max should be based on the step values.
					// - Example: if stepMinute is 15, then minMax is 45.
					max[litem] = parseInt((o[litem + 'Max'] - ((o[litem + 'Max'] - o[litem + 'Min']) % o['step' + uitem])), 10);
					gridSize[litem] = 0;

					html += '<dt class="ui_tpicker_' + litem + '_label"' + (show ? '' : noDisplay) + '>' + o[litem + 'Text'] + '</dt>' +
								'<dd class="ui_tpicker_' + litem + '"><div class="ui_tpicker_' + litem + '_slider"' + (show ? '' : noDisplay) + '></div>';

					if (show && o[litem + 'Grid'] > 0) {
						html += '<div style="padding-left: 1px"><table class="ui-tpicker-grid-label"><tr>';

						if (litem === 'hour') {
							for (var h = o[litem + 'Min']; h <= max[litem]; h += parseInt(o[litem + 'Grid'], 10)) {
								gridSize[litem]++;
								var tmph = $.datepicker.formatTime(this.support.ampm ? 'hht' : 'HH', {hour: h}, o);
								html += '<td data-for="' + litem + '">' + tmph + '</td>';
							}
						}
						else {
							for (var m = o[litem + 'Min']; m <= max[litem]; m += parseInt(o[litem + 'Grid'], 10)) {
								gridSize[litem]++;
								html += '<td data-for="' + litem + '">' + ((m < 10) ? '0' : '') + m + '</td>';
							}
						}

						html += '</tr></table></div>';
					}
					html += '</dd>';
				}
				
				// Timezone
				var showTz = o.showTimezone !== null ? o.showTimezone : this.support.timezone;
				html += '<dt class="ui_tpicker_timezone_label"' + (showTz ? '' : noDisplay) + '>' + o.timezoneText + '</dt>';
				html += '<dd class="ui_tpicker_timezone" ' + (showTz ? '' : noDisplay) + '></dd>';

				// Create the elements from string
				html += '</dl></div>';
				var $tp = $(html);

				// if we only want time picker...
				if (o.timeOnly === true) {
					$tp.prepend('<div class="ui-widget-header ui-helper-clearfix ui-corner-all">' + '<div class="ui-datepicker-title">' + o.timeOnlyTitle + '</div>' + '</div>');
					$dp.find('.ui-datepicker-header, .ui-datepicker-calendar').hide();
				}
				
				// add sliders, adjust grids, add events
				for (i = 0, l = tp_inst.units.length; i < l; i++) {
					litem = tp_inst.units[i];
					uitem = litem.substr(0, 1).toUpperCase() + litem.substr(1);
					show = o['show' + uitem] !== null ? o['show' + uitem] : this.support[litem];

					// add the slider
					tp_inst[litem + '_slider'] = tp_inst.control.create(tp_inst, $tp.find('.ui_tpicker_' + litem + '_slider'), litem, tp_inst[litem], o[litem + 'Min'], max[litem], o['step' + uitem]);

					// adjust the grid and add click event
					if (show && o[litem + 'Grid'] > 0) {
						size = 100 * gridSize[litem] * o[litem + 'Grid'] / (max[litem] - o[litem + 'Min']);
						$tp.find('.ui_tpicker_' + litem + ' table').css({
							width: size + "%",
							marginLeft: o.isRTL ? '0' : ((size / (-2 * gridSize[litem])) + "%"),
							marginRight: o.isRTL ? ((size / (-2 * gridSize[litem])) + "%") : '0',
							borderCollapse: 'collapse'
						}).find("td").click(function (e) {
								var $t = $(this),
									h = $t.html(),
									n = parseInt(h.replace(/[^0-9]/g), 10),
									ap = h.replace(/[^apm]/ig),
									f = $t.data('for'); // loses scope, so we use data-for

								if (f === 'hour') {
									if (ap.indexOf('p') !== -1 && n < 12) {
										n += 12;
									}
									else {
										if (ap.indexOf('a') !== -1 && n === 12) {
											n = 0;
										}
									}
								}
								
								tp_inst.control.value(tp_inst, tp_inst[f + '_slider'], litem, n);

								tp_inst._onTimeChange();
								tp_inst._onSelectHandler();
							}).css({
								cursor: 'pointer',
								width: (100 / gridSize[litem]) + '%',
								textAlign: 'center',
								overflow: 'hidden'
							});
					} // end if grid > 0
				} // end for loop

				// Add timezone options
				this.timezone_select = $tp.find('.ui_tpicker_timezone').append('<select></select>').find("select");
				$.fn.append.apply(this.timezone_select,
				$.map(o.timezoneList, function (val, idx) {
					return $("<option />").val(typeof val === "object" ? val.value : val).text(typeof val === "object" ? val.label : val);
				}));
				if (typeof(this.timezone) !== "undefined" && this.timezone !== null && this.timezone !== "") {
					var local_timezone = (new Date(this.inst.selectedYear, this.inst.selectedMonth, this.inst.selectedDay, 12)).getTimezoneOffset() * -1;
					if (local_timezone === this.timezone) {
						selectLocalTimezone(tp_inst);
					} else {
						this.timezone_select.val(this.timezone);
					}
				} else {
					if (typeof(this.hour) !== "undefined" && this.hour !== null && this.hour !== "") {
						this.timezone_select.val(o.timezone);
					} else {
						selectLocalTimezone(tp_inst);
					}
				}
				this.timezone_select.change(function () {
					tp_inst._onTimeChange();
					tp_inst._onSelectHandler();
				});
				// End timezone options
				
				// inject timepicker into datepicker
				var $buttonPanel = $dp.find('.ui-datepicker-buttonpane');
				if ($buttonPanel.length) {
					$buttonPanel.before($tp);
				} else {
					$dp.append($tp);
				}

				this.$timeObj = $tp.find('.ui_tpicker_time');

				if (this.inst !== null) {
					var timeDefined = this.timeDefined;
					this._onTimeChange();
					this.timeDefined = timeDefined;
				}

				// slideAccess integration: http://trentrichardson.com/2011/11/11/jquery-ui-sliders-and-touch-accessibility/
				if (this._defaults.addSliderAccess) {
					var sliderAccessArgs = this._defaults.sliderAccessArgs,
						rtl = this._defaults.isRTL;
					sliderAccessArgs.isRTL = rtl;
						
					setTimeout(function () { // fix for inline mode
						if ($tp.find('.ui-slider-access').length === 0) {
							$tp.find('.ui-slider:visible').sliderAccess(sliderAccessArgs);

							// fix any grids since sliders are shorter
							var sliderAccessWidth = $tp.find('.ui-slider-access:eq(0)').outerWidth(true);
							if (sliderAccessWidth) {
								$tp.find('table:visible').each(function () {
									var $g = $(this),
										oldWidth = $g.outerWidth(),
										oldMarginLeft = $g.css(rtl ? 'marginRight' : 'marginLeft').toString().replace('%', ''),
										newWidth = oldWidth - sliderAccessWidth,
										newMarginLeft = ((oldMarginLeft * newWidth) / oldWidth) + '%',
										css = { width: newWidth, marginRight: 0, marginLeft: 0 };
									css[rtl ? 'marginRight' : 'marginLeft'] = newMarginLeft;
									$g.css(css);
								});
							}
						}
					}, 10);
				}
				// end slideAccess integration

				tp_inst._limitMinMaxDateTime(this.inst, true);
			}
		},

		/*
		* This function tries to limit the ability to go outside the
		* min/max date range
		*/
		_limitMinMaxDateTime: function (dp_inst, adjustSliders) {
			var o = this._defaults,
				dp_date = new Date(dp_inst.selectedYear, dp_inst.selectedMonth, dp_inst.selectedDay);

			if (!this._defaults.showTimepicker) {
				return;
			} // No time so nothing to check here

			if ($.datepicker._get(dp_inst, 'minDateTime') !== null && $.datepicker._get(dp_inst, 'minDateTime') !== undefined && dp_date) {
				var minDateTime = $.datepicker._get(dp_inst, 'minDateTime'),
					minDateTimeDate = new Date(minDateTime.getFullYear(), minDateTime.getMonth(), minDateTime.getDate(), 0, 0, 0, 0);

				if (this.hourMinOriginal === null || this.minuteMinOriginal === null || this.secondMinOriginal === null || this.millisecMinOriginal === null || this.microsecMinOriginal === null) {
					this.hourMinOriginal = o.hourMin;
					this.minuteMinOriginal = o.minuteMin;
					this.secondMinOriginal = o.secondMin;
					this.millisecMinOriginal = o.millisecMin;
					this.microsecMinOriginal = o.microsecMin;
				}

				if (dp_inst.settings.timeOnly || minDateTimeDate.getTime() === dp_date.getTime()) {
					this._defaults.hourMin = minDateTime.getHours();
					if (this.hour <= this._defaults.hourMin) {
						this.hour = this._defaults.hourMin;
						this._defaults.minuteMin = minDateTime.getMinutes();
						if (this.minute <= this._defaults.minuteMin) {
							this.minute = this._defaults.minuteMin;
							this._defaults.secondMin = minDateTime.getSeconds();
							if (this.second <= this._defaults.secondMin) {
								this.second = this._defaults.secondMin;
								this._defaults.millisecMin = minDateTime.getMilliseconds();
								if (this.millisec <= this._defaults.millisecMin) {
									this.millisec = this._defaults.millisecMin;
									this._defaults.microsecMin = minDateTime.getMicroseconds();
								} else {
									if (this.microsec < this._defaults.microsecMin) {
										this.microsec = this._defaults.microsecMin;
									}
									this._defaults.microsecMin = this.microsecMinOriginal;
								}
							} else {
								this._defaults.millisecMin = this.millisecMinOriginal;
								this._defaults.microsecMin = this.microsecMinOriginal;
							}
						} else {
							this._defaults.secondMin = this.secondMinOriginal;
							this._defaults.millisecMin = this.millisecMinOriginal;
							this._defaults.microsecMin = this.microsecMinOriginal;
						}
					} else {
						this._defaults.minuteMin = this.minuteMinOriginal;
						this._defaults.secondMin = this.secondMinOriginal;
						this._defaults.millisecMin = this.millisecMinOriginal;
						this._defaults.microsecMin = this.microsecMinOriginal;
					}
				} else {
					this._defaults.hourMin = this.hourMinOriginal;
					this._defaults.minuteMin = this.minuteMinOriginal;
					this._defaults.secondMin = this.secondMinOriginal;
					this._defaults.millisecMin = this.millisecMinOriginal;
					this._defaults.microsecMin = this.microsecMinOriginal;
				}
			}

			if ($.datepicker._get(dp_inst, 'maxDateTime') !== null && $.datepicker._get(dp_inst, 'maxDateTime') !== undefined && dp_date) {
				var maxDateTime = $.datepicker._get(dp_inst, 'maxDateTime'),
					maxDateTimeDate = new Date(maxDateTime.getFullYear(), maxDateTime.getMonth(), maxDateTime.getDate(), 0, 0, 0, 0);

				if (this.hourMaxOriginal === null || this.minuteMaxOriginal === null || this.secondMaxOriginal === null || this.millisecMaxOriginal === null) {
					this.hourMaxOriginal = o.hourMax;
					this.minuteMaxOriginal = o.minuteMax;
					this.secondMaxOriginal = o.secondMax;
					this.millisecMaxOriginal = o.millisecMax;
					this.microsecMaxOriginal = o.microsecMax;
				}

				if (dp_inst.settings.timeOnly || maxDateTimeDate.getTime() === dp_date.getTime()) {
					this._defaults.hourMax = maxDateTime.getHours();
					if (this.hour >= this._defaults.hourMax) {
						this.hour = this._defaults.hourMax;
						this._defaults.minuteMax = maxDateTime.getMinutes();
						if (this.minute >= this._defaults.minuteMax) {
							this.minute = this._defaults.minuteMax;
							this._defaults.secondMax = maxDateTime.getSeconds();
							if (this.second >= this._defaults.secondMax) {
								this.second = this._defaults.secondMax;
								this._defaults.millisecMax = maxDateTime.getMilliseconds();
								if (this.millisec >= this._defaults.millisecMax) {
									this.millisec = this._defaults.millisecMax;
									this._defaults.microsecMax = maxDateTime.getMicroseconds();
								} else {
									if (this.microsec > this._defaults.microsecMax) {
										this.microsec = this._defaults.microsecMax;
									}
									this._defaults.microsecMax = this.microsecMaxOriginal;
								}
							} else {
								this._defaults.millisecMax = this.millisecMaxOriginal;
								this._defaults.microsecMax = this.microsecMaxOriginal;
							}
						} else {
							this._defaults.secondMax = this.secondMaxOriginal;
							this._defaults.millisecMax = this.millisecMaxOriginal;
							this._defaults.microsecMax = this.microsecMaxOriginal;
						}
					} else {
						this._defaults.minuteMax = this.minuteMaxOriginal;
						this._defaults.secondMax = this.secondMaxOriginal;
						this._defaults.millisecMax = this.millisecMaxOriginal;
						this._defaults.microsecMax = this.microsecMaxOriginal;
					}
				} else {
					this._defaults.hourMax = this.hourMaxOriginal;
					this._defaults.minuteMax = this.minuteMaxOriginal;
					this._defaults.secondMax = this.secondMaxOriginal;
					this._defaults.millisecMax = this.millisecMaxOriginal;
					this._defaults.microsecMax = this.microsecMaxOriginal;
				}
			}

			if (adjustSliders !== undefined && adjustSliders === true) {
				var hourMax = parseInt((this._defaults.hourMax - ((this._defaults.hourMax - this._defaults.hourMin) % this._defaults.stepHour)), 10),
					minMax = parseInt((this._defaults.minuteMax - ((this._defaults.minuteMax - this._defaults.minuteMin) % this._defaults.stepMinute)), 10),
					secMax = parseInt((this._defaults.secondMax - ((this._defaults.secondMax - this._defaults.secondMin) % this._defaults.stepSecond)), 10),
					millisecMax = parseInt((this._defaults.millisecMax - ((this._defaults.millisecMax - this._defaults.millisecMin) % this._defaults.stepMillisec)), 10),
					microsecMax = parseInt((this._defaults.microsecMax - ((this._defaults.microsecMax - this._defaults.microsecMin) % this._defaults.stepMicrosec)), 10);

				if (this.hour_slider) {
					this.control.options(this, this.hour_slider, 'hour', { min: this._defaults.hourMin, max: hourMax });
					this.control.value(this, this.hour_slider, 'hour', this.hour - (this.hour % this._defaults.stepHour));
				}
				if (this.minute_slider) {
					this.control.options(this, this.minute_slider, 'minute', { min: this._defaults.minuteMin, max: minMax });
					this.control.value(this, this.minute_slider, 'minute', this.minute - (this.minute % this._defaults.stepMinute));
				}
				if (this.second_slider) {
					this.control.options(this, this.second_slider, 'second', { min: this._defaults.secondMin, max: secMax });
					this.control.value(this, this.second_slider, 'second', this.second - (this.second % this._defaults.stepSecond));
				}
				if (this.millisec_slider) {
					this.control.options(this, this.millisec_slider, 'millisec', { min: this._defaults.millisecMin, max: millisecMax });
					this.control.value(this, this.millisec_slider, 'millisec', this.millisec - (this.millisec % this._defaults.stepMillisec));
				}
				if (this.microsec_slider) {
					this.control.options(this, this.microsec_slider, 'microsec', { min: this._defaults.microsecMin, max: microsecMax });
					this.control.value(this, this.microsec_slider, 'microsec', this.microsec - (this.microsec % this._defaults.stepMicrosec));
				}
			}

		},

		/*
		* when a slider moves, set the internal time...
		* on time change is also called when the time is updated in the text field
		*/
		_onTimeChange: function () {
			if (!this._defaults.showTimepicker) {
                                return;
			}
			var hour = (this.hour_slider) ? this.control.value(this, this.hour_slider, 'hour') : false,
				minute = (this.minute_slider) ? this.control.value(this, this.minute_slider, 'minute') : false,
				second = (this.second_slider) ? this.control.value(this, this.second_slider, 'second') : false,
				millisec = (this.millisec_slider) ? this.control.value(this, this.millisec_slider, 'millisec') : false,
				microsec = (this.microsec_slider) ? this.control.value(this, this.microsec_slider, 'microsec') : false,
				timezone = (this.timezone_select) ? this.timezone_select.val() : false,
				o = this._defaults,
				pickerTimeFormat = o.pickerTimeFormat || o.timeFormat,
				pickerTimeSuffix = o.pickerTimeSuffix || o.timeSuffix;

			if (typeof(hour) === 'object') {
				hour = false;
			}
			if (typeof(minute) === 'object') {
				minute = false;
			}
			if (typeof(second) === 'object') {
				second = false;
			}
			if (typeof(millisec) === 'object') {
				millisec = false;
			}
			if (typeof(microsec) === 'object') {
				microsec = false;
			}
			if (typeof(timezone) === 'object') {
				timezone = false;
			}

			if (hour !== false) {
				hour = parseInt(hour, 10);
			}
			if (minute !== false) {
				minute = parseInt(minute, 10);
			}
			if (second !== false) {
				second = parseInt(second, 10);
			}
			if (millisec !== false) {
				millisec = parseInt(millisec, 10);
			}
			if (microsec !== false) {
				microsec = parseInt(microsec, 10);
			}
			if (timezone !== false) {
				timezone = parseInt(timezone, 10);
			}

			var ampm = o[hour < 12 ? 'amNames' : 'pmNames'][0];

			// If the update was done in the input field, the input field should not be updated.
			// If the update was done using the sliders, update the input field.
			var hasChanged = (hour !== this.hour || minute !== this.minute || second !== this.second || millisec !== this.millisec || microsec !== this.microsec || 
					(this.ampm.length > 0 && (hour < 12) !== ($.inArray(this.ampm.toUpperCase(), this.amNames) !== -1)) || (this.timezone !== null && timezone !== this.timezone));

			if (hasChanged) {

				if (hour !== false) {
					this.hour = hour;
				}
				if (minute !== false) {
					this.minute = minute;
				}
				if (second !== false) {
					this.second = second;
				}
				if (millisec !== false) {
					this.millisec = millisec;
				}
				if (microsec !== false) {
					this.microsec = microsec;
				}
				if (timezone !== false) {
					this.timezone = timezone;
				}

				if (!this.inst) {
					this.inst = $.datepicker._getInst(this.$input[0]);
				}

				this._limitMinMaxDateTime(this.inst, true);
			}
			if (this.support.ampm) {
				this.ampm = ampm;
			}

			// Updates the time within the timepicker
			this.formattedTime = $.datepicker.formatTime(o.timeFormat, this, o);
			if (this.$timeObj) {
				if (pickerTimeFormat === o.timeFormat) {
					this.$timeObj.text(this.formattedTime + pickerTimeSuffix);
				}
				else {
					this.$timeObj.text($.datepicker.formatTime(pickerTimeFormat, this, o) + pickerTimeSuffix);
				}
			}

			this.timeDefined = true;
			if (hasChanged) {
				this._updateDateTime();
			}
		},

		/*
		* call custom onSelect.
		* bind to sliders slidestop, and grid click.
		*/
		_onSelectHandler: function () {
			var onSelect = this._defaults.onSelect || this.inst.settings.onSelect;
			var inputEl = this.$input ? this.$input[0] : null;
			if (onSelect && inputEl) {
				onSelect.apply(inputEl, [this.formattedDateTime, this]);
			}
		},

		/*
		* update our input with the new date time..
		*/
		_updateDateTime: function (dp_inst) {
			dp_inst = this.inst || dp_inst;
			var dtTmp = (dp_inst.currentYear > 0? 
							new Date(dp_inst.currentYear, dp_inst.currentMonth, dp_inst.currentDay) : 
							new Date(dp_inst.selectedYear, dp_inst.selectedMonth, dp_inst.selectedDay)),
				dt = $.datepicker._daylightSavingAdjust(dtTmp),
				//dt = $.datepicker._daylightSavingAdjust(new Date(dp_inst.selectedYear, dp_inst.selectedMonth, dp_inst.selectedDay)),
				//dt = $.datepicker._daylightSavingAdjust(new Date(dp_inst.currentYear, dp_inst.currentMonth, dp_inst.currentDay)),
				dateFmt = $.datepicker._get(dp_inst, 'dateFormat'),
				formatCfg = $.datepicker._getFormatConfig(dp_inst),
				timeAvailable = dt !== null && this.timeDefined;
			this.formattedDate = $.datepicker.formatDate(dateFmt, (dt === null ? new Date() : dt), formatCfg);
			var formattedDateTime = this.formattedDate;
			
			// if a slider was changed but datepicker doesn't have a value yet, set it
			if (dp_inst.lastVal === "") {
                dp_inst.currentYear = dp_inst.selectedYear;
                dp_inst.currentMonth = dp_inst.selectedMonth;
                dp_inst.currentDay = dp_inst.selectedDay;
            }

			/*
			* remove following lines to force every changes in date picker to change the input value
			* Bug descriptions: when an input field has a default value, and click on the field to pop up the date picker. 
			* If the user manually empty the value in the input field, the date picker will never change selected value.
			*/
			//if (dp_inst.lastVal !== undefined && (dp_inst.lastVal.length > 0 && this.$input.val().length === 0)) {
			//	return;
			//}

			if (this._defaults.timeOnly === true) {
				formattedDateTime = this.formattedTime;
			} else if (this._defaults.timeOnly !== true && (this._defaults.alwaysSetTime || timeAvailable)) {
				formattedDateTime += this._defaults.separator + this.formattedTime + this._defaults.timeSuffix;
			}

			this.formattedDateTime = formattedDateTime;

			if (!this._defaults.showTimepicker) {
				this.$input.val(this.formattedDate);
			} else if (this.$altInput && this._defaults.timeOnly === false && this._defaults.altFieldTimeOnly === true) {
				this.$altInput.val(this.formattedTime);
				this.$input.val(this.formattedDate);
			} else if (this.$altInput) {
				this.$input.val(formattedDateTime);
				var altFormattedDateTime = '',
					altSeparator = this._defaults.altSeparator ? this._defaults.altSeparator : this._defaults.separator,
					altTimeSuffix = this._defaults.altTimeSuffix ? this._defaults.altTimeSuffix : this._defaults.timeSuffix;
				
				if (!this._defaults.timeOnly) {
					if (this._defaults.altFormat) {
						altFormattedDateTime = $.datepicker.formatDate(this._defaults.altFormat, (dt === null ? new Date() : dt), formatCfg);
					}
					else {
						altFormattedDateTime = this.formattedDate;
					}

					if (altFormattedDateTime) {
						altFormattedDateTime += altSeparator;
					}
				}

				if (this._defaults.altTimeFormat) {
					altFormattedDateTime += $.datepicker.formatTime(this._defaults.altTimeFormat, this, this._defaults) + altTimeSuffix;
				}
				else {
					altFormattedDateTime += this.formattedTime + altTimeSuffix;
				}
				this.$altInput.val(altFormattedDateTime);
			} else {
				this.$input.val(formattedDateTime);
			}

			this.$input.trigger("change");
		},

		_onFocus: function () {
			if (!this.$input.val() && this._defaults.defaultValue) {
				this.$input.val(this._defaults.defaultValue);
				var inst = $.datepicker._getInst(this.$input.get(0)),
					tp_inst = $.datepicker._get(inst, 'timepicker');
				if (tp_inst) {
					if (tp_inst._defaults.timeOnly && (inst.input.val() !== inst.lastVal)) {
						try {
							$.datepicker._updateDatepicker(inst);
						} catch (err) {
							$.timepicker.log(err);
						}
					}
				}
			}
		},

		/*
		* Small abstraction to control types
		* We can add more, just be sure to follow the pattern: create, options, value
		*/
		_controls: {
			// slider methods
			slider: {
				create: function (tp_inst, obj, unit, val, min, max, step) {
					var rtl = tp_inst._defaults.isRTL; // if rtl go -60->0 instead of 0->60
					return obj.prop('slide', null).slider({
						orientation: "horizontal",
						value: rtl ? val * -1 : val,
						min: rtl ? max * -1 : min,
						max: rtl ? min * -1 : max,
						step: step,
						slide: function (event, ui) {
							tp_inst.control.value(tp_inst, $(this), unit, rtl ? ui.value * -1 : ui.value);
							tp_inst._onTimeChange();
						},
						stop: function (event, ui) {
							tp_inst._onSelectHandler();
						}
					});	
				},
				options: function (tp_inst, obj, unit, opts, val) {
					if (tp_inst._defaults.isRTL) {
						if (typeof(opts) === 'string') {
							if (opts === 'min' || opts === 'max') {
								if (val !== undefined) {
									return obj.slider(opts, val * -1);
								}
								return Math.abs(obj.slider(opts));
							}
							return obj.slider(opts);
						}
						var min = opts.min, 
							max = opts.max;
						opts.min = opts.max = null;
						if (min !== undefined) {
							opts.max = min * -1;
						}
						if (max !== undefined) {
							opts.min = max * -1;
						}
						return obj.slider(opts);
					}
					if (typeof(opts) === 'string' && val !== undefined) {
						return obj.slider(opts, val);
					}
					return obj.slider(opts);
				},
				value: function (tp_inst, obj, unit, val) {
					if (tp_inst._defaults.isRTL) {
						if (val !== undefined) {
							return obj.slider('value', val * -1);
						}
						return Math.abs(obj.slider('value'));
					}
					if (val !== undefined) {
						return obj.slider('value', val);
					}
					return obj.slider('value');
				}
			},
			// select methods
			select: {
				create: function (tp_inst, obj, unit, val, min, max, step) {
					var sel = '<select class="ui-timepicker-select" data-unit="' + unit + '" data-min="' + min + '" data-max="' + max + '" data-step="' + step + '">',
						format = tp_inst._defaults.pickerTimeFormat || tp_inst._defaults.timeFormat;

					for (var i = min; i <= max; i += step) {
						sel += '<option value="' + i + '"' + (i === val ? ' selected' : '') + '>';
						if (unit === 'hour') {
							sel += $.datepicker.formatTime($.trim(format.replace(/[^ht ]/ig, '')), {hour: i}, tp_inst._defaults);
						}
						else if (unit === 'millisec' || unit === 'microsec' || i >= 10) { sel += i; }
						else {sel += '0' + i.toString(); }
						sel += '</option>';
					}
					sel += '</select>';

					obj.children('select').remove();

					$(sel).appendTo(obj).change(function (e) {
						tp_inst._onTimeChange();
						tp_inst._onSelectHandler();
					});

					return obj;
				},
				options: function (tp_inst, obj, unit, opts, val) {
					var o = {},
						$t = obj.children('select');
					if (typeof(opts) === 'string') {
						if (val === undefined) {
							return $t.data(opts);
						}
						o[opts] = val;	
					}
					else { o = opts; }
					return tp_inst.control.create(tp_inst, obj, $t.data('unit'), $t.val(), o.min || $t.data('min'), o.max || $t.data('max'), o.step || $t.data('step'));
				},
				value: function (tp_inst, obj, unit, val) {
					var $t = obj.children('select');
					if (val !== undefined) {
						return $t.val(val);
					}
					return $t.val();
				}
			}
		} // end _controls

	});

	$.fn.extend({
		/*
		* shorthand just to use timepicker.
		*/
		timepicker: function (o) {
			o = o || {};
			var tmp_args = Array.prototype.slice.call(arguments);

			if (typeof o === 'object') {
				tmp_args[0] = $.extend(o, {
					timeOnly: true
				});
			}

			return $(this).each(function () {
				$.fn.datetimepicker.apply($(this), tmp_args);
			});
		},

		/*
		* extend timepicker to datepicker
		*/
		datetimepicker: function (o) {
			o = o || {};
			var tmp_args = arguments;

			if (typeof(o) === 'string') {
				if (o === 'getDate') {
					return $.fn.datepicker.apply($(this[0]), tmp_args);
				} else {
					return this.each(function () {
						var $t = $(this);
						$t.datepicker.apply($t, tmp_args);
					});
				}
			} else {
				return this.each(function () {
					var $t = $(this);
					$t.datepicker($.timepicker._newInst($t, o)._defaults);
				});
			}
		}
	});

	/*
	* Public Utility to parse date and time
	*/
	$.datepicker.parseDateTime = function (dateFormat, timeFormat, dateTimeString, dateSettings, timeSettings) {
		var parseRes = parseDateTimeInternal(dateFormat, timeFormat, dateTimeString, dateSettings, timeSettings);
		if (parseRes.timeObj) {
			var t = parseRes.timeObj;
			parseRes.date.setHours(t.hour, t.minute, t.second, t.millisec);
			parseRes.date.setMicroseconds(t.microsec);
		}

		return parseRes.date;
	};

	/*
	* Public utility to parse time
	*/
	$.datepicker.parseTime = function (timeFormat, timeString, options) {
		var o = extendRemove(extendRemove({}, $.timepicker._defaults), options || {}),
			iso8601 = (timeFormat.replace(/\'.*?\'/g, '').indexOf('Z') !== -1);

		// Strict parse requires the timeString to match the timeFormat exactly
		var strictParse = function (f, s, o) {

			// pattern for standard and localized AM/PM markers
			var getPatternAmpm = function (amNames, pmNames) {
				var markers = [];
				if (amNames) {
					$.merge(markers, amNames);
				}
				if (pmNames) {
					$.merge(markers, pmNames);
				}
				markers = $.map(markers, function (val) {
					return val.replace(/[.*+?|()\[\]{}\\]/g, '\\$&');
				});
				return '(' + markers.join('|') + ')?';
			};

			// figure out position of time elements.. cause js cant do named captures
			var getFormatPositions = function (timeFormat) {
				var finds = timeFormat.toLowerCase().match(/(h{1,2}|m{1,2}|s{1,2}|l{1}|c{1}|t{1,2}|z|'.*?')/g),
					orders = {
						h: -1,
						m: -1,
						s: -1,
						l: -1,
						c: -1,
						t: -1,
						z: -1
					};

				if (finds) {
					for (var i = 0; i < finds.length; i++) {
						if (orders[finds[i].toString().charAt(0)] === -1) {
							orders[finds[i].toString().charAt(0)] = i + 1;
						}
					}
				}
				return orders;
			};

			var regstr = '^' + f.toString()
					.replace(/([hH]{1,2}|mm?|ss?|[tT]{1,2}|[zZ]|[lc]|'.*?')/g, function (match) {
							var ml = match.length;
							switch (match.charAt(0).toLowerCase()) {
							case 'h':
								return ml === 1 ? '(\\d?\\d)' : '(\\d{' + ml + '})';
							case 'm':
								return ml === 1 ? '(\\d?\\d)' : '(\\d{' + ml + '})';
							case 's':
								return ml === 1 ? '(\\d?\\d)' : '(\\d{' + ml + '})';
							case 'l':
								return '(\\d?\\d?\\d)';
							case 'c':
								return '(\\d?\\d?\\d)';
							case 'z':
								return '(z|[-+]\\d\\d:?\\d\\d|\\S+)?';
							case 't':
								return getPatternAmpm(o.amNames, o.pmNames);
							default:    // literal escaped in quotes
								return '(' + match.replace(/\'/g, "").replace(/(\.|\$|\^|\\|\/|\(|\)|\[|\]|\?|\+|\*)/g, function (m) { return "\\" + m; }) + ')?';
							}
						})
					.replace(/\s/g, '\\s?') +
					o.timeSuffix + '$',
				order = getFormatPositions(f),
				ampm = '',
				treg;

			treg = s.match(new RegExp(regstr, 'i'));

			var resTime = {
				hour: 0,
				minute: 0,
				second: 0,
				millisec: 0,
				microsec: 0
			};

			if (treg) {
				if (order.t !== -1) {
					if (treg[order.t] === undefined || treg[order.t].length === 0) {
						ampm = '';
						resTime.ampm = '';
					} else {
						ampm = $.inArray(treg[order.t].toUpperCase(), o.amNames) !== -1 ? 'AM' : 'PM';
						resTime.ampm = o[ampm === 'AM' ? 'amNames' : 'pmNames'][0];
					}
				}

				if (order.h !== -1) {
					if (ampm === 'AM' && treg[order.h] === '12') {
						resTime.hour = 0; // 12am = 0 hour
					} else {
						if (ampm === 'PM' && treg[order.h] !== '12') {
							resTime.hour = parseInt(treg[order.h], 10) + 12; // 12pm = 12 hour, any other pm = hour + 12
						} else {
							resTime.hour = Number(treg[order.h]);
						}
					}
				}

				if (order.m !== -1) {
					resTime.minute = Number(treg[order.m]);
				}
				if (order.s !== -1) {
					resTime.second = Number(treg[order.s]);
				}
				if (order.l !== -1) {
					resTime.millisec = Number(treg[order.l]);
				}
				if (order.c !== -1) {
					resTime.microsec = Number(treg[order.c]);
				}
				if (order.z !== -1 && treg[order.z] !== undefined) {
					resTime.timezone = $.timepicker.timezoneOffsetNumber(treg[order.z]);
				}


				return resTime;
			}
			return false;
		};// end strictParse

		// First try JS Date, if that fails, use strictParse
		var looseParse = function (f, s, o) {
			try {
				var d = new Date('2012-01-01 ' + s);
				if (isNaN(d.getTime())) {
					d = new Date('2012-01-01T' + s);
					if (isNaN(d.getTime())) {
						d = new Date('01/01/2012 ' + s);
						if (isNaN(d.getTime())) {
							throw "Unable to parse time with native Date: " + s;
						}
					}
				}

				return {
					hour: d.getHours(),
					minute: d.getMinutes(),
					second: d.getSeconds(),
					millisec: d.getMilliseconds(),
					microsec: d.getMicroseconds(),
					timezone: d.getTimezoneOffset() * -1
				};
			}
			catch (err) {
				try {
					return strictParse(f, s, o);
				}
				catch (err2) {
					$.timepicker.log("Unable to parse \ntimeString: " + s + "\ntimeFormat: " + f);
				}				
			}
			return false;
		}; // end looseParse
		
		if (typeof o.parse === "function") {
			return o.parse(timeFormat, timeString, o);
		}
		if (o.parse === 'loose') {
			return looseParse(timeFormat, timeString, o);
		}
		return strictParse(timeFormat, timeString, o);
	};

	/**
	 * Public utility to format the time
	 * @param {string} format format of the time
	 * @param {Object} time Object not a Date for timezones
	 * @param {Object} [options] essentially the regional[].. amNames, pmNames, ampm
	 * @returns {string} the formatted time
	 */
	$.datepicker.formatTime = function (format, time, options) {
		options = options || {};
		options = $.extend({}, $.timepicker._defaults, options);
		time = $.extend({
			hour: 0,
			minute: 0,
			second: 0,
			millisec: 0,
			microsec: 0,
			timezone: null
		}, time);

		var tmptime = format,
			ampmName = options.amNames[0],
			hour = parseInt(time.hour, 10);

		if (hour > 11) {
			ampmName = options.pmNames[0];
		}

		tmptime = tmptime.replace(/(?:HH?|hh?|mm?|ss?|[tT]{1,2}|[zZ]|[lc]|'.*?')/g, function (match) {
			switch (match) {
			case 'HH':
				return ('0' + hour).slice(-2);
			case 'H':
				return hour;
			case 'hh':
				return ('0' + convert24to12(hour)).slice(-2);
			case 'h':
				return convert24to12(hour);
			case 'mm':
				return ('0' + time.minute).slice(-2);
			case 'm':
				return time.minute;
			case 'ss':
				return ('0' + time.second).slice(-2);
			case 's':
				return time.second;
			case 'l':
				return ('00' + time.millisec).slice(-3);
			case 'c':
				return ('00' + time.microsec).slice(-3);
			case 'z':
				return $.timepicker.timezoneOffsetString(time.timezone === null ? options.timezone : time.timezone, false);
			case 'Z':
				return $.timepicker.timezoneOffsetString(time.timezone === null ? options.timezone : time.timezone, true);
			case 'T':
				return ampmName.charAt(0).toUpperCase();
			case 'TT':
				return ampmName.toUpperCase();
			case 't':
				return ampmName.charAt(0).toLowerCase();
			case 'tt':
				return ampmName.toLowerCase();
			default:
				return match.replace(/'/g, "");
			}
		});

		return tmptime;
	};

	/*
	* the bad hack :/ override datepicker so it doesn't close on select
	// inspired: http://stackoverflow.com/questions/1252512/jquery-datepicker-prevent-closing-picker-when-clicking-a-date/1762378#1762378
	*/
	$.datepicker._base_selectDate = $.datepicker._selectDate;
	$.datepicker._selectDate = function (id, dateStr) {
		var inst = this._getInst($(id)[0]),
			tp_inst = this._get(inst, 'timepicker');

		if (tp_inst) {
			tp_inst._limitMinMaxDateTime(inst, true);
			inst.inline = inst.stay_open = true;
			//This way the onSelect handler called from calendarpicker get the full dateTime
			this._base_selectDate(id, dateStr);
			inst.inline = inst.stay_open = false;
			this._notifyChange(inst);
			this._updateDatepicker(inst);
		} else {
			this._base_selectDate(id, dateStr);
		}
	};

	/*
	* second bad hack :/ override datepicker so it triggers an event when changing the input field
	* and does not redraw the datepicker on every selectDate event
	*/
	$.datepicker._base_updateDatepicker = $.datepicker._updateDatepicker;
	$.datepicker._updateDatepicker = function (inst) {

		// don't popup the datepicker if there is another instance already opened
		var input = inst.input[0];
		if ($.datepicker._curInst && $.datepicker._curInst !== inst && $.datepicker._datepickerShowing && $.datepicker._lastInput !== input) {
			return;
		}

		if (typeof(inst.stay_open) !== 'boolean' || inst.stay_open === false) {

			this._base_updateDatepicker(inst);

			// Reload the time control when changing something in the input text field.
			var tp_inst = this._get(inst, 'timepicker');
			if (tp_inst) {
				tp_inst._addTimePicker(inst);
			}
		}
	};

	/*
	* third bad hack :/ override datepicker so it allows spaces and colon in the input field
	*/
	$.datepicker._base_doKeyPress = $.datepicker._doKeyPress;
	$.datepicker._doKeyPress = function (event) {
		var inst = $.datepicker._getInst(event.target),
			tp_inst = $.datepicker._get(inst, 'timepicker');

		if (tp_inst) {
			if ($.datepicker._get(inst, 'constrainInput')) {
				var ampm = tp_inst.support.ampm,
					tz = tp_inst._defaults.showTimezone !== null ? tp_inst._defaults.showTimezone : tp_inst.support.timezone,
					dateChars = $.datepicker._possibleChars($.datepicker._get(inst, 'dateFormat')),
					datetimeChars = tp_inst._defaults.timeFormat.toString()
											.replace(/[hms]/g, '')
											.replace(/TT/g, ampm ? 'APM' : '')
											.replace(/Tt/g, ampm ? 'AaPpMm' : '')
											.replace(/tT/g, ampm ? 'AaPpMm' : '')
											.replace(/T/g, ampm ? 'AP' : '')
											.replace(/tt/g, ampm ? 'apm' : '')
											.replace(/t/g, ampm ? 'ap' : '') + 
											" " + tp_inst._defaults.separator + 
											tp_inst._defaults.timeSuffix + 
											(tz ? tp_inst._defaults.timezoneList.join('') : '') + 
											(tp_inst._defaults.amNames.join('')) + (tp_inst._defaults.pmNames.join('')) + 
											dateChars,
					chr = String.fromCharCode(event.charCode === undefined ? event.keyCode : event.charCode);
				return event.ctrlKey || (chr < ' ' || !dateChars || datetimeChars.indexOf(chr) > -1);
			}
		}

		return $.datepicker._base_doKeyPress(event);
	};

	/*
	* Fourth bad hack :/ override _updateAlternate function used in inline mode to init altField
	* Update any alternate field to synchronise with the main field.
	*/
	$.datepicker._base_updateAlternate = $.datepicker._updateAlternate;
	$.datepicker._updateAlternate = function (inst) {
		var tp_inst = this._get(inst, 'timepicker');
		if (tp_inst) {
			var altField = tp_inst._defaults.altField;
			if (altField) { // update alternate field too
				var altFormat = tp_inst._defaults.altFormat || tp_inst._defaults.dateFormat,
					date = this._getDate(inst),
					formatCfg = $.datepicker._getFormatConfig(inst),
					altFormattedDateTime = '', 
					altSeparator = tp_inst._defaults.altSeparator ? tp_inst._defaults.altSeparator : tp_inst._defaults.separator, 
					altTimeSuffix = tp_inst._defaults.altTimeSuffix ? tp_inst._defaults.altTimeSuffix : tp_inst._defaults.timeSuffix,
					altTimeFormat = tp_inst._defaults.altTimeFormat !== null ? tp_inst._defaults.altTimeFormat : tp_inst._defaults.timeFormat;
				
				altFormattedDateTime += $.datepicker.formatTime(altTimeFormat, tp_inst, tp_inst._defaults) + altTimeSuffix;
				if (!tp_inst._defaults.timeOnly && !tp_inst._defaults.altFieldTimeOnly && date !== null) {
					if (tp_inst._defaults.altFormat) {
						altFormattedDateTime = $.datepicker.formatDate(tp_inst._defaults.altFormat, date, formatCfg) + altSeparator + altFormattedDateTime;
					}
					else {
						altFormattedDateTime = tp_inst.formattedDate + altSeparator + altFormattedDateTime;
					}
				}
				$(altField).val(altFormattedDateTime);
			}
		}
		else {
			$.datepicker._base_updateAlternate(inst);
		}
	};

	/*
	* Override key up event to sync manual input changes.
	*/
	$.datepicker._base_doKeyUp = $.datepicker._doKeyUp;
	$.datepicker._doKeyUp = function (event) {
		var inst = $.datepicker._getInst(event.target),
			tp_inst = $.datepicker._get(inst, 'timepicker');

		if (tp_inst) {
			if (tp_inst._defaults.timeOnly && (inst.input.val() !== inst.lastVal)) {
				try {
					$.datepicker._updateDatepicker(inst);
				} catch (err) {
					$.timepicker.log(err);
				}
			}
		}

		return $.datepicker._base_doKeyUp(event);
	};

	/*
	* override "Today" button to also grab the time.
	*/
	$.datepicker._base_gotoToday = $.datepicker._gotoToday;
	$.datepicker._gotoToday = function (id) {
		var inst = this._getInst($(id)[0]),
			$dp = inst.dpDiv;
		this._base_gotoToday(id);
		var tp_inst = this._get(inst, 'timepicker');
		selectLocalTimezone(tp_inst);
		var now = new Date();
		this._setTime(inst, now);
		$('.ui-datepicker-today', $dp).click();
	};
	$.datepicker._clearDate=function(id) {
		var target = $(id);
		var inst = this._getInst(target[0]);
		target.val('');
		this._hideDatepicker(target[0]);
	};

	/*
	* Disable & enable the Time in the datetimepicker
	*/
	$.datepicker._disableTimepickerDatepicker = function (target) {
		var inst = this._getInst(target);
		if (!inst) {
			return;
		}

		var tp_inst = this._get(inst, 'timepicker');
		$(target).datepicker('getDate'); // Init selected[Year|Month|Day]
		if (tp_inst) {
			inst.settings.showTimepicker = false;
			tp_inst._defaults.showTimepicker = false;
			tp_inst._updateDateTime(inst);
		}
	};

	$.datepicker._enableTimepickerDatepicker = function (target) {
		var inst = this._getInst(target);
		if (!inst) {
			return;
		}

		var tp_inst = this._get(inst, 'timepicker');
		$(target).datepicker('getDate'); // Init selected[Year|Month|Day]
		if (tp_inst) {
			inst.settings.showTimepicker = true;
			tp_inst._defaults.showTimepicker = true;
			tp_inst._addTimePicker(inst); // Could be disabled on page load
			tp_inst._updateDateTime(inst);
		}
	};

	/*
	* Create our own set time function
	*/
	$.datepicker._setTime = function (inst, date) {
		var tp_inst = this._get(inst, 'timepicker');
		if (tp_inst) {
			var defaults = tp_inst._defaults;

			// calling _setTime with no date sets time to defaults
			tp_inst.hour = date ? date.getHours() : defaults.hour;
			tp_inst.minute = date ? date.getMinutes() : defaults.minute;
			tp_inst.second = date ? date.getSeconds() : defaults.second;
			tp_inst.millisec = date ? date.getMilliseconds() : defaults.millisec;
			tp_inst.microsec = date ? date.getMicroseconds() : defaults.microsec;

			//check if within min/max times.. 
			tp_inst._limitMinMaxDateTime(inst, true);

			tp_inst._onTimeChange();
			tp_inst._updateDateTime(inst);
		}
	};

	/*
	* Create new public method to set only time, callable as $().datepicker('setTime', date)
	*/
	$.datepicker._setTimeDatepicker = function (target, date, withDate) {
		var inst = this._getInst(target);
		if (!inst) {
			return;
		}

		var tp_inst = this._get(inst, 'timepicker');

		if (tp_inst) {
			this._setDateFromField(inst);
			var tp_date;
			if (date) {
				if (typeof date === "string") {
					tp_inst._parseTime(date, withDate);
					tp_date = new Date();
					tp_date.setHours(tp_inst.hour, tp_inst.minute, tp_inst.second, tp_inst.millisec);
					tp_date.setMicroseconds(tp_inst.microsec);
				} else {
					tp_date = new Date(date.getTime());
					tp_date.setMicroseconds(date.getMicroseconds());
				}
				if (tp_date.toString() === 'Invalid Date') {
					tp_date = undefined;
				}
				this._setTime(inst, tp_date);
			}
		}

	};

	/*
	* override setDate() to allow setting time too within Date object
	*/
	$.datepicker._base_setDateDatepicker = $.datepicker._setDateDatepicker;
	$.datepicker._setDateDatepicker = function (target, date) {
		var inst = this._getInst(target);
		if (!inst) {
			return;
		}

		if (typeof(date) === 'string') {
			date = new Date(date);
			if (!date.getTime()) {
				$.timepicker.log("Error creating Date object from string.");
			}
		}

		var tp_inst = this._get(inst, 'timepicker');
		var tp_date;
		if (date instanceof Date) {
			tp_date = new Date(date.getTime());
			tp_date.setMicroseconds(date.getMicroseconds());
		} else {
			tp_date = date;
		}
		
		// This is important if you are using the timezone option, javascript's Date 
		// object will only return the timezone offset for the current locale, so we 
		// adjust it accordingly.  If not using timezone option this won't matter..
		// If a timezone is different in tp, keep the timezone as is
		if (tp_inst) {
			// look out for DST if tz wasn't specified
			if (!tp_inst.support.timezone && tp_inst._defaults.timezone === null) {
				tp_inst.timezone = tp_date.getTimezoneOffset() * -1;
			}
			date = $.timepicker.timezoneAdjust(date, tp_inst.timezone);
			tp_date = $.timepicker.timezoneAdjust(tp_date, tp_inst.timezone);
		}

		this._updateDatepicker(inst);
		this._base_setDateDatepicker.apply(this, arguments);
		this._setTimeDatepicker(target, tp_date, true);
	};

	/*
	* override getDate() to allow getting time too within Date object
	*/
	$.datepicker._base_getDateDatepicker = $.datepicker._getDateDatepicker;
	$.datepicker._getDateDatepicker = function (target, noDefault) {
		var inst = this._getInst(target);
		if (!inst) {
			return;
		}

		var tp_inst = this._get(inst, 'timepicker');

		if (tp_inst) {
			// if it hasn't yet been defined, grab from field
			if (inst.lastVal === undefined) {
				this._setDateFromField(inst, noDefault);
			}

			var date = this._getDate(inst);
			if (date && tp_inst._parseTime($(target).val(), tp_inst.timeOnly)) {
				date.setHours(tp_inst.hour, tp_inst.minute, tp_inst.second, tp_inst.millisec);
				date.setMicroseconds(tp_inst.microsec);

				// This is important if you are using the timezone option, javascript's Date 
				// object will only return the timezone offset for the current locale, so we 
				// adjust it accordingly.  If not using timezone option this won't matter..
				if (tp_inst.timezone != null) {
					// look out for DST if tz wasn't specified
					if (!tp_inst.support.timezone && tp_inst._defaults.timezone === null) {
						tp_inst.timezone = date.getTimezoneOffset() * -1;
					}
					date = $.timepicker.timezoneAdjust(date, tp_inst.timezone);
				}
			}
			return date;
		}
		return this._base_getDateDatepicker(target, noDefault);
	};

	/*
	* override parseDate() because UI 1.8.14 throws an error about "Extra characters"
	* An option in datapicker to ignore extra format characters would be nicer.
	*/
	$.datepicker._base_parseDate = $.datepicker.parseDate;
	$.datepicker.parseDate = function (format, value, settings) {
		var date;
		try {
			date = this._base_parseDate(format, value, settings);
		} catch (err) {
			// Hack!  The error message ends with a colon, a space, and
			// the "extra" characters.  We rely on that instead of
			// attempting to perfectly reproduce the parsing algorithm.
			if (err.indexOf(":") >= 0) {
				date = this._base_parseDate(format, value.substring(0, value.length - (err.length - err.indexOf(':') - 2)), settings);
				$.timepicker.log("Error parsing the date string: " + err + "\ndate string = " + value + "\ndate format = " + format);
			} else {
				throw err;
			}
		}
		return date;
	};

	/*
	* override formatDate to set date with time to the input
	*/
	$.datepicker._base_formatDate = $.datepicker._formatDate;
	$.datepicker._formatDate = function (inst, day, month, year) {
		var tp_inst = this._get(inst, 'timepicker');
		if (tp_inst) {
			tp_inst._updateDateTime(inst);
			return tp_inst.$input.val();
		}
		return this._base_formatDate(inst);
	};

	/*
	* override options setter to add time to maxDate(Time) and minDate(Time). MaxDate
	*/
	$.datepicker._base_optionDatepicker = $.datepicker._optionDatepicker;
	$.datepicker._optionDatepicker = function (target, name, value) {
		var inst = this._getInst(target),
			name_clone;
		if (!inst) {
			return null;
		}

		var tp_inst = this._get(inst, 'timepicker');
		if (tp_inst) {
			var min = null,
				max = null,
				onselect = null,
				overrides = tp_inst._defaults.evnts,
				fns = {},
				prop;
			if (typeof name === 'string') { // if min/max was set with the string
				if (name === 'minDate' || name === 'minDateTime') {
					min = value;
				} else if (name === 'maxDate' || name === 'maxDateTime') {
					max = value;
				} else if (name === 'onSelect') {
					onselect = value;
				} else if (overrides.hasOwnProperty(name)) {
					if (typeof (value) === 'undefined') {
						return overrides[name];
					}
					fns[name] = value;
					name_clone = {}; //empty results in exiting function after overrides updated
				}
			} else if (typeof name === 'object') { //if min/max was set with the JSON
				if (name.minDate) {
					min = name.minDate;
				} else if (name.minDateTime) {
					min = name.minDateTime;
				} else if (name.maxDate) {
					max = name.maxDate;
				} else if (name.maxDateTime) {
					max = name.maxDateTime;
				}
				for (prop in overrides) {
					if (overrides.hasOwnProperty(prop) && name[prop]) {
						fns[prop] = name[prop];
					}
				}
			}
			for (prop in fns) {
				if (fns.hasOwnProperty(prop)) {
					overrides[prop] = fns[prop];
					if (!name_clone) { name_clone = $.extend({}, name); }
					delete name_clone[prop];
				}
			}
			if (name_clone && isEmptyObject(name_clone)) { return; }
			if (min) { //if min was set
				if (min === 0) {
					min = new Date();
				} else {
					min = new Date(min);
				}
				tp_inst._defaults.minDate = min;
				tp_inst._defaults.minDateTime = min;
			} else if (max) { //if max was set
				if (max === 0) {
					max = new Date();
				} else {
					max = new Date(max);
				}
				tp_inst._defaults.maxDate = max;
				tp_inst._defaults.maxDateTime = max;
			} else if (onselect) {
				tp_inst._defaults.onSelect = onselect;
			}
		}
		if (value === undefined) {
			return this._base_optionDatepicker.call($.datepicker, target, name);
		}
		return this._base_optionDatepicker.call($.datepicker, target, name_clone || name, value);
	};
	
	/*
	* jQuery isEmptyObject does not check hasOwnProperty - if someone has added to the object prototype,
	* it will return false for all objects
	*/
	var isEmptyObject = function (obj) {
		var prop;
		for (prop in obj) {
			if (obj.hasOwnProperty(prop)) {
				return false;
			}
		}
		return true;
	};

	/*
	* jQuery extend now ignores nulls!
	*/
	var extendRemove = function (target, props) {
		$.extend(target, props);
		for (var name in props) {
			if (props[name] === null || props[name] === undefined) {
				target[name] = props[name];
			}
		}
		return target;
	};

	/*
	* Determine by the time format which units are supported
	* Returns an object of booleans for each unit
	*/
	var detectSupport = function (timeFormat) {
		var tf = timeFormat.replace(/'.*?'/g, '').toLowerCase(), // removes literals
			isIn = function (f, t) { // does the format contain the token?
					return f.indexOf(t) !== -1 ? true : false;
				};
		return {
				hour: isIn(tf, 'h'),
				minute: isIn(tf, 'm'),
				second: isIn(tf, 's'),
				millisec: isIn(tf, 'l'),
				microsec: isIn(tf, 'c'),
				timezone: isIn(tf, 'z'),
				ampm: isIn(tf, 't') && isIn(timeFormat, 'h'),
				iso8601: isIn(timeFormat, 'Z')
			};
	};

	/*
	* Converts 24 hour format into 12 hour
	* Returns 12 hour without leading 0
	*/
	var convert24to12 = function (hour) {
		hour %= 12;

		if (hour === 0) {
			hour = 12;
		}

		return String(hour);
	};

	var computeEffectiveSetting = function (settings, property) {
		return settings && settings[property] ? settings[property] : $.timepicker._defaults[property];
	};

	/*
	* Splits datetime string into date and time substrings.
	* Throws exception when date can't be parsed
	* Returns {dateString: dateString, timeString: timeString}
	*/
	var splitDateTime = function (dateTimeString, timeSettings) {
		// The idea is to get the number separator occurrences in datetime and the time format requested (since time has
		// fewer unknowns, mostly numbers and am/pm). We will use the time pattern to split.
		var separator = computeEffectiveSetting(timeSettings, 'separator'),
			format = computeEffectiveSetting(timeSettings, 'timeFormat'),
			timeParts = format.split(separator), // how many occurrences of separator may be in our format?
			timePartsLen = timeParts.length,
			allParts = dateTimeString.split(separator),
			allPartsLen = allParts.length;

		if (allPartsLen > 1) {
			return {
				dateString: allParts.splice(0, allPartsLen - timePartsLen).join(separator),
				timeString: allParts.splice(0, timePartsLen).join(separator)
			};
		}

		return {
			dateString: dateTimeString,
			timeString: ''
		};
	};

	/*
	* Internal function to parse datetime interval
	* Returns: {date: Date, timeObj: Object}, where
	*   date - parsed date without time (type Date)
	*   timeObj = {hour: , minute: , second: , millisec: , microsec: } - parsed time. Optional
	*/
	var parseDateTimeInternal = function (dateFormat, timeFormat, dateTimeString, dateSettings, timeSettings) {
		var date,
			parts,
			parsedTime;

		parts = splitDateTime(dateTimeString, timeSettings);
		date = $.datepicker._base_parseDate(dateFormat, parts.dateString, dateSettings);

		if (parts.timeString === '') {
			return {
				date: date
			};
		}

		parsedTime = $.datepicker.parseTime(timeFormat, parts.timeString, timeSettings);

		if (!parsedTime) {
			throw 'Wrong time format';
		}

		return {
			date: date,
			timeObj: parsedTime
		};
	};

	/*
	* Internal function to set timezone_select to the local timezone
	*/
	var selectLocalTimezone = function (tp_inst, date) {
		if (tp_inst && tp_inst.timezone_select) {
			var now = date || new Date();
			tp_inst.timezone_select.val(-now.getTimezoneOffset());
		}
	};

	/*
	* Create a Singleton Instance
	*/
	$.timepicker = new Timepicker();

	/**
	 * Get the timezone offset as string from a date object (eg '+0530' for UTC+5.5)
	 * @param {number} tzMinutes if not a number, less than -720 (-1200), or greater than 840 (+1400) this value is returned
	 * @param {boolean} iso8601 if true formats in accordance to iso8601 "+12:45"
	 * @return {string}
	 */
	$.timepicker.timezoneOffsetString = function (tzMinutes, iso8601) {
		if (isNaN(tzMinutes) || tzMinutes > 840 || tzMinutes < -720) {
			return tzMinutes;
		}

		var off = tzMinutes,
			minutes = off % 60,
			hours = (off - minutes) / 60,
			iso = iso8601 ? ':' : '',
			tz = (off >= 0 ? '+' : '-') + ('0' + Math.abs(hours)).slice(-2) + iso + ('0' + Math.abs(minutes)).slice(-2);
		
		if (tz === '+00:00') {
			return 'Z';
		}
		return tz;
	};

	/**
	 * Get the number in minutes that represents a timezone string
	 * @param  {string} tzString formatted like "+0500", "-1245", "Z"
	 * @return {number} the offset minutes or the original string if it doesn't match expectations
	 */
	$.timepicker.timezoneOffsetNumber = function (tzString) {
		var normalized = tzString.toString().replace(':', ''); // excuse any iso8601, end up with "+1245"

		if (normalized.toUpperCase() === 'Z') { // if iso8601 with Z, its 0 minute offset
			return 0;
		}

		if (!/^(\-|\+)\d{4}$/.test(normalized)) { // possibly a user defined tz, so just give it back
			return tzString;
		}

		return ((normalized.substr(0, 1) === '-' ? -1 : 1) * // plus or minus
					((parseInt(normalized.substr(1, 2), 10) * 60) + // hours (converted to minutes)
					parseInt(normalized.substr(3, 2), 10))); // minutes
	};

	/**
	 * No way to set timezone in js Date, so we must adjust the minutes to compensate. (think setDate, getDate)
	 * @param  {Date} date
	 * @param  {string} toTimezone formatted like "+0500", "-1245"
	 * @return {Date}
	 */
	$.timepicker.timezoneAdjust = function (date, toTimezone) {
		var toTz = $.timepicker.timezoneOffsetNumber(toTimezone);
		if (!isNaN(toTz)) {
			date.setMinutes(date.getMinutes() + -date.getTimezoneOffset() - toTz);
		}
		return date;
	};

	/**
	 * Calls `timepicker()` on the `startTime` and `endTime` elements, and configures them to
	 * enforce date range limits.
	 * n.b. The input value must be correctly formatted (reformatting is not supported)
	 * @param  {Element} startTime
	 * @param  {Element} endTime
	 * @param  {Object} options Options for the timepicker() call
	 * @return {jQuery}
	 */
	$.timepicker.timeRange = function (startTime, endTime, options) {
		return $.timepicker.handleRange('timepicker', startTime, endTime, options);
	};

	/**
	 * Calls `datetimepicker` on the `startTime` and `endTime` elements, and configures them to
	 * enforce date range limits.
	 * @param  {Element} startTime
	 * @param  {Element} endTime
	 * @param  {Object} options Options for the `timepicker()` call. Also supports `reformat`,
	 *   a boolean value that can be used to reformat the input values to the `dateFormat`.
	 * @param  {string} method Can be used to specify the type of picker to be added
	 * @return {jQuery}
	 */
	$.timepicker.datetimeRange = function (startTime, endTime, options) {
		$.timepicker.handleRange('datetimepicker', startTime, endTime, options);
	};

	/**
	 * Calls `datepicker` on the `startTime` and `endTime` elements, and configures them to
	 * enforce date range limits.
	 * @param  {Element} startTime
	 * @param  {Element} endTime
	 * @param  {Object} options Options for the `timepicker()` call. Also supports `reformat`,
	 *   a boolean value that can be used to reformat the input values to the `dateFormat`.
	 * @return {jQuery}
	 */
	$.timepicker.dateRange = function (startTime, endTime, options) {
		$.timepicker.handleRange('datepicker', startTime, endTime, options);
	};

	/**
	 * Calls `method` on the `startTime` and `endTime` elements, and configures them to
	 * enforce date range limits.
	 * @param  {string} method Can be used to specify the type of picker to be added
	 * @param  {Element} startTime
	 * @param  {Element} endTime
	 * @param  {Object} options Options for the `timepicker()` call. Also supports `reformat`,
	 *   a boolean value that can be used to reformat the input values to the `dateFormat`.
	 * @return {jQuery}
	 */
	$.timepicker.handleRange = function (method, startTime, endTime, options) {
		options = $.extend({}, {
			minInterval: 0, // min allowed interval in milliseconds
			maxInterval: 0, // max allowed interval in milliseconds
			start: {},      // options for start picker
			end: {}         // options for end picker
		}, options);

		function checkDates(changed, other) {
			var startdt = startTime[method]('getDate'),
				enddt = endTime[method]('getDate'),
				changeddt = changed[method]('getDate');

			if (startdt !== null) {
				var minDate = new Date(startdt.getTime()),
					maxDate = new Date(startdt.getTime());

				minDate.setMilliseconds(minDate.getMilliseconds() + options.minInterval);
				maxDate.setMilliseconds(maxDate.getMilliseconds() + options.maxInterval);

				if (options.minInterval > 0 && minDate > enddt) { // minInterval check
					endTime[method]('setDate', minDate);
				}
				else if (options.maxInterval > 0 && maxDate < enddt) { // max interval check
					endTime[method]('setDate', maxDate);
				}
				else if (startdt > enddt) {
					other[method]('setDate', changeddt);
				}
			}
		}

		function selected(changed, other, option) {
			if (!changed.val()) {
				return;
			}
			var date = changed[method].call(changed, 'getDate');
			if (date !== null && options.minInterval > 0) {
				if (option === 'minDate') {
					date.setMilliseconds(date.getMilliseconds() + options.minInterval);
				}
				if (option === 'maxDate') {
					date.setMilliseconds(date.getMilliseconds() - options.minInterval);
				}
			}
			if (date.getTime) {
				other[method].call(other, 'option', option, date);
			}
		}

		$.fn[method].call(startTime, $.extend({
			onClose: function (dateText, inst) {
				checkDates($(this), endTime);
			},
			onSelect: function (selectedDateTime) {
				selected($(this), endTime, 'minDate');
			}
		}, options, options.start));
		$.fn[method].call(endTime, $.extend({
			onClose: function (dateText, inst) {
				checkDates($(this), startTime);
			},
			onSelect: function (selectedDateTime) {
				selected($(this), startTime, 'maxDate');
			}
		}, options, options.end));

		checkDates(startTime, endTime);
		selected(startTime, endTime, 'minDate');
		selected(endTime, startTime, 'maxDate');
		return $([startTime.get(0), endTime.get(0)]);
	};

	/**
	 * Log error or data to the console during error or debugging
	 * @param  {Object} err pass any type object to log to the console during error or debugging
	 * @return {void}
	 */
	$.timepicker.log = function (err) {
		if (window.console) {
			window.console.log(err);
		}
	};

	/*
	 * Add util object to allow access to private methods for testability.
	 */
	$.timepicker._util = {
		_extendRemove: extendRemove,
		_isEmptyObject: isEmptyObject,
		_convert24to12: convert24to12,
		_detectSupport: detectSupport,
		_selectLocalTimezone: selectLocalTimezone,
		_computeEffectiveSetting: computeEffectiveSetting,
		_splitDateTime: splitDateTime,
		_parseDateTimeInternal: parseDateTimeInternal
	};

	/*
	* Microsecond support
	*/
	if (!Date.prototype.getMicroseconds) {
		Date.prototype.microseconds = 0;
		Date.prototype.getMicroseconds = function () { return this.microseconds; };
		Date.prototype.setMicroseconds = function (m) {
			this.setMilliseconds(this.getMilliseconds() + Math.floor(m / 1000));
			this.microseconds = m % 1000;
			return this;
		};
	}

	/*
	* Keep up with the version
	*/
	$.timepicker.version = "1.4.1";

})(jQuery);
/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
$(function($){
	$.datepicker.regional['zh-CN'] = {
		clearText: '清除',
		prevText: '&#x3c;上月',
		nextText: '下月&#x3e;',
		currentText: '今天',
		monthNames: ['一月','二月','三月','四月','五月','六月',
		'七月','八月','九月','十月','十一月','十二月'],
		monthNamesShort: ['一','二','三','四','五','六',
		'七','八','九','十','十一','十二'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		weekHeader: '周',
		dateFormat: 'yy-mm-dd',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: true,
		closeText: '关闭',
		showClearButton: true,
		showButtonPanel: true,
		showWeek:true,
		yearSuffix: '年'};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
	 $.timepicker.regional['zh-CN'] = {  
        timeOnlyTitle: '选择时间',  
        timeText: '时间',  
        hourText: '小时',  
        minuteText: '分钟',  
        secondText: '秒钟',  
        millisecText: '微秒',  
        timezoneText: '时区',  
        currentText: '现在时间',  
        closeText: '关闭',  
        timeFormat: 'HH:mm:ss',  
        amNames: ['AM', 'A'],  
        pmNames: ['PM', 'P'],  
        isRTL: false  
    };  
    $.timepicker.setDefaults($.timepicker.regional['zh-CN']);  
});

/*
 * jQuery Form Plugin
 * version: 2.36 (07-NOV-2009)
 * @requires jQuery v1.2.6 or later
 *
 * Examples and documentation at: http://malsup.com/jquery/form/
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
;(function($) {

/*
	Usage Note:
	-----------
	Do not use both ajaxSubmit and ajaxForm on the same form.  These
	functions are intended to be exclusive.  Use ajaxSubmit if you want
	to bind your own submit handler to the form.  For example,

	$(document).ready(function() {
		$('#myForm').bind('submit', function() {
			$(this).ajaxSubmit({
				target: '#output'
			});
			return false; // <-- important!
		});
	});

	Use ajaxForm when you want the plugin to manage all the event binding
	for you.  For example,

	$(document).ready(function() {
		$('#myForm').ajaxForm({
			target: '#output'
		});
	});

	When using ajaxForm, the ajaxSubmit function will be invoked for you
	at the appropriate time.
*/

/**
 * ajaxSubmit() provides a mechanism for immediately submitting
 * an HTML form using AJAX.
 */
$.fn.ajaxSubmit = function(options) {
	// fast fail if nothing selected (http://dev.jquery.com/ticket/2752)
	if (!this.length) {
		log('ajaxSubmit: skipping submit process - no element selected');
		return this;
	}

	if (typeof options == 'function')
		options = { success: options };

	var url = $.trim(this.attr('action'));
	if (url) {
		// clean url (don't include hash vaue)
		url = (url.match(/^([^#]+)/)||[])[1];
   	}
   	url = url || window.location.href || '';

	options = $.extend({
		url:  url,
		type: this.attr('method') || 'GET',
		iframeSrc: /^https/i.test(window.location.href || '') ? 'javascript:false' : 'about:blank'
	}, options || {});

	// hook for manipulating the form data before it is extracted;
	// convenient for use with rich editors like tinyMCE or FCKEditor
	var veto = {};
	this.trigger('form-pre-serialize', [this, options, veto]);
	if (veto.veto) {
		log('ajaxSubmit: submit vetoed via form-pre-serialize trigger');
		return this;
	}

	// provide opportunity to alter form data before it is serialized
	if (options.beforeSerialize && options.beforeSerialize(this, options) === false) {
		log('ajaxSubmit: submit aborted via beforeSerialize callback');
		return this;
	}

	var a = this.formToArray(options.semantic);
	if (options.data) {
		options.extraData = options.data;
		for (var n in options.data) {
		  if(options.data[n] instanceof Array) {
			for (var k in options.data[n])
			  a.push( { name: n, value: options.data[n][k] } );
		  }
		  else
			 a.push( { name: n, value: options.data[n] } );
		}
	}

	// give pre-submit callback an opportunity to abort the submit
	if (options.beforeSubmit && options.beforeSubmit(a, this, options) === false) {
		log('ajaxSubmit: submit aborted via beforeSubmit callback');
		return this;
	}

	// fire vetoable 'validate' event
	this.trigger('form-submit-validate', [a, this, options, veto]);
	if (veto.veto) {
		log('ajaxSubmit: submit vetoed via form-submit-validate trigger');
		return this;
	}

	var q = $.param(a);

	if (options.type.toUpperCase() == 'GET') {
		options.url += (options.url.indexOf('?') >= 0 ? '&' : '?') + q;
		options.data = null;  // data is null for 'get'
	}
	else
		options.data = q; // data is the query string for 'post'

	var $form = this, callbacks = [];
	if (options.resetForm) callbacks.push(function() { $form.resetForm(); });
	if (options.clearForm) callbacks.push(function() { $form.clearForm(); });

	// perform a load on the target only if dataType is not provided
	if (!options.dataType && options.target) {
		var oldSuccess = options.success || function(){};
		callbacks.push(function(data) {
			$(options.target).html(data).each(oldSuccess, arguments);
		});
	}
	else if (options.success)
		callbacks.push(options.success);

	options.success = function(data, status) {
		for (var i=0, max=callbacks.length; i < max; i++)
			callbacks[i].apply(options, [data, status, $form]);
	};

	// are there files to upload?
	var files = $('input:file', this).fieldValue();
	var found = false;
	for (var j=0; j < files.length; j++)
		if (files[j])
			found = true;

	var multipart = false;
//	var mp = 'multipart/form-data';
//	multipart = ($form.attr('enctype') == mp || $form.attr('encoding') == mp);

	// options.iframe allows user to force iframe mode
	// 06-NOV-09: now defaulting to iframe mode if file input is detected
   if ((files.length && options.iframe !== false) || options.iframe || found || multipart) {
	   // hack to fix Safari hang (thanks to Tim Molendijk for this)
	   // see:  http://groups.google.com/group/jquery-dev/browse_thread/thread/36395b7ab510dd5d
	   if (options.closeKeepAlive)
		   $.get(options.closeKeepAlive, fileUpload);
	   else
		   fileUpload();
	   }
   else
	   $.ajax(options);

	// fire 'notify' event
	this.trigger('form-submit-notify', [this, options]);
	return this;


	// private function for handling file uploads (hat tip to YAHOO!)
	function fileUpload() {
		var form = $form[0];

		if ($(':input[name=submit]', form).length) {
			alert('Error: Form elements must not be named "submit".');
			return;
		}

		var opts = $.extend({}, $.ajaxSettings, options);
		var s = $.extend(true, {}, $.extend(true, {}, $.ajaxSettings), opts);

		var id = 'jqFormIO' + (new Date().getTime());
		var $io = $('<iframe id="' + id + '" name="' + id + '" src="'+ opts.iframeSrc +'" />');
		var io = $io[0];

		$io.css({ position: 'absolute', top: '-1000px', left: '-1000px' });

		var xhr = { // mock object
			aborted: 0,
			responseText: null,
			responseXML: null,
			status: 0,
			statusText: 'n/a',
			getAllResponseHeaders: function() {},
			getResponseHeader: function() {},
			setRequestHeader: function() {},
			abort: function() {
				this.aborted = 1;
				$io.attr('src', opts.iframeSrc); // abort op in progress
			}
		};

		var g = opts.global;
		// trigger ajax global events so that activity/block indicators work like normal
		if (g && ! $.active++) $.event.trigger("ajaxStart");
		if (g) $.event.trigger("ajaxSend", [xhr, opts]);

		if (s.beforeSend && s.beforeSend(xhr, s) === false) {
			s.global && $.active--;
			return;
		}
		if (xhr.aborted)
			return;

		var cbInvoked = 0;
		var timedOut = 0;

		// add submitting element to data if we know it
		var sub = form.clk;
		if (sub) {
			var n = sub.name;
			if (n && !sub.disabled) {
				options.extraData = options.extraData || {};
				options.extraData[n] = sub.value;
				if (sub.type == "image") {
					options.extraData[name+'.x'] = form.clk_x;
					options.extraData[name+'.y'] = form.clk_y;
				}
			}
		}

		// take a breath so that pending repaints get some cpu time before the upload starts
		setTimeout(function() {
			// make sure form attrs are set
			var t = $form.attr('target'), a = $form.attr('action');

			// update form attrs in IE friendly way
			form.setAttribute('target',id);
			if (form.getAttribute('method') != 'POST')
				form.setAttribute('method', 'POST');
			if (form.getAttribute('action') != opts.url)
				form.setAttribute('action', opts.url);

			// ie borks in some cases when setting encoding
			if (! options.skipEncodingOverride) {
				$form.attr({
					encoding: 'multipart/form-data',
					enctype:  'multipart/form-data'
				});
			}

			// support timout
			if (opts.timeout)
				setTimeout(function() { timedOut = true; cb(); }, opts.timeout);

			// add "extra" data to form if provided in options
			var extraInputs = [];
			try {
				if (options.extraData)
					for (var n in options.extraData)
						extraInputs.push(
							$('<input type="hidden" name="'+n+'" value="'+options.extraData[n]+'" />')
								.appendTo(form)[0]);

				// add iframe to doc and submit the form
				$io.appendTo('body');
				io.attachEvent ? io.attachEvent('onload', cb) : io.addEventListener('load', cb, false);
				form.submit();
			}
			finally {
				// reset attrs and remove "extra" input elements
				form.setAttribute('action',a);
				t ? form.setAttribute('target', t) : $form.removeAttr('target');
				$(extraInputs).remove();
			}
		}, 10);

		var domCheckCount = 50;

		function cb() {
			if (cbInvoked++) return;

			io.detachEvent ? io.detachEvent('onload', cb) : io.removeEventListener('load', cb, false);

			var ok = true;
			try {
				if (timedOut) throw 'timeout';
				// extract the server response from the iframe
				var data, doc;

				doc = io.contentWindow ? io.contentWindow.document : io.contentDocument ? io.contentDocument : io.document;
				
				var isXml = opts.dataType == 'xml' || doc.XMLDocument || $.isXMLDoc(doc);
				log('isXml='+isXml);
				if (!isXml && (doc.body == null || doc.body.innerHTML == '')) {
				 	if (--domCheckCount) {
						// in some browsers (Opera) the iframe DOM is not always traversable when
						// the onload callback fires, so we loop a bit to accommodate
						cbInvoked = 0;
						setTimeout(cb, 100);
						return;
					}
					log('Could not access iframe DOM after 50 tries.');
					return;
				}

				xhr.responseText = doc.body ? doc.body.innerHTML : null;
				xhr.responseXML = doc.XMLDocument ? doc.XMLDocument : doc;
				xhr.getResponseHeader = function(header){
					var headers = {'content-type': opts.dataType};
					return headers[header];
				};

				if (opts.dataType == 'json' || opts.dataType == 'script') {
					// see if user embedded response in textarea
					var ta = doc.getElementsByTagName('textarea')[0];
					if (ta)
						xhr.responseText = ta.value;
					else {
						// account for browsers injecting pre around json response
						var pre = doc.getElementsByTagName('pre')[0];
						if (pre)
							xhr.responseText = pre.innerHTML;
					}			  
				}
				else if (opts.dataType == 'xml' && !xhr.responseXML && xhr.responseText != null) {
					xhr.responseXML = toXml(xhr.responseText);
				}
				data = $.httpData(xhr, opts.dataType);
			}
			catch(e){
				ok = false;
				$.handleError(opts, xhr, 'error', e);
			}

			// ordering of these callbacks/triggers is odd, but that's how $.ajax does it
			if (ok) {
				opts.success(data, 'success');
				if (g) $.event.trigger("ajaxSuccess", [xhr, opts]);
			}
			if (g) $.event.trigger("ajaxComplete", [xhr, opts]);
			if (g && ! --$.active) $.event.trigger("ajaxStop");
			if (opts.complete) opts.complete(xhr, ok ? 'success' : 'error');

			// clean up
			setTimeout(function() {
				$io.remove();
				xhr.responseXML = null;
			}, 100);
		};

		function toXml(s, doc) {
			if (window.ActiveXObject) {
				doc = new ActiveXObject('Microsoft.XMLDOM');
				doc.async = 'false';
				doc.loadXML(s);
			}
			else
				doc = (new DOMParser()).parseFromString(s, 'text/xml');
			return (doc && doc.documentElement && doc.documentElement.tagName != 'parsererror') ? doc : null;
		};
	};
};

/**
 * ajaxForm() provides a mechanism for fully automating form submission.
 *
 * The advantages of using this method instead of ajaxSubmit() are:
 *
 * 1: This method will include coordinates for <input type="image" /> elements (if the element
 *	is used to submit the form).
 * 2. This method will include the submit element's name/value data (for the element that was
 *	used to submit the form).
 * 3. This method binds the submit() method to the form for you.
 *
 * The options argument for ajaxForm works exactly as it does for ajaxSubmit.  ajaxForm merely
 * passes the options argument along after properly binding events for submit elements and
 * the form itself.
 */
$.fn.ajaxForm = function(options) {
	return this.ajaxFormUnbind().bind('submit.form-plugin', function() {
		$(this).ajaxSubmit(options);
		return false;
	}).bind('click.form-plugin', function(e) {
		var target = e.target;
		var $el = $(target);
		if (!($el.is(":submit,input:image"))) {
			// is this a child element of the submit el?  (ex: a span within a button)
			var t = $el.closest(':submit');
			if (t.length == 0)
				return;
			target = t[0];
		}
		var form = this;
		form.clk = target;
		if (target.type == 'image') {
			if (e.offsetX != undefined) {
				form.clk_x = e.offsetX;
				form.clk_y = e.offsetY;
			} else if (typeof $.fn.offset == 'function') { // try to use dimensions plugin
				var offset = $el.offset();
				form.clk_x = e.pageX - offset.left;
				form.clk_y = e.pageY - offset.top;
			} else {
				form.clk_x = e.pageX - target.offsetLeft;
				form.clk_y = e.pageY - target.offsetTop;
			}
		}
		// clear form vars
		setTimeout(function() { form.clk = form.clk_x = form.clk_y = null; }, 100);
	});
};

// ajaxFormUnbind unbinds the event handlers that were bound by ajaxForm
$.fn.ajaxFormUnbind = function() {
	return this.unbind('submit.form-plugin click.form-plugin');
};

/**
 * formToArray() gathers form element data into an array of objects that can
 * be passed to any of the following ajax functions: $.get, $.post, or load.
 * Each object in the array has both a 'name' and 'value' property.  An example of
 * an array for a simple login form might be:
 *
 * [ { name: 'username', value: 'jresig' }, { name: 'password', value: 'secret' } ]
 *
 * It is this array that is passed to pre-submit callback functions provided to the
 * ajaxSubmit() and ajaxForm() methods.
 */
$.fn.formToArray = function(semantic) {
	var a = [];
	if (this.length == 0) return a;

	var form = this[0];
	var els = semantic ? form.getElementsByTagName('*') : form.elements;
	if (!els) return a;
	for(var i=0, max=els.length; i < max; i++) {
		var el = els[i];
		var n = el.name;
		if (!n) continue;

		if (semantic && form.clk && el.type == "image") {
			// handle image inputs on the fly when semantic == true
			if(!el.disabled && form.clk == el) {
				a.push({name: n, value: $(el).val()});
				a.push({name: n+'.x', value: form.clk_x}, {name: n+'.y', value: form.clk_y});
			}
			continue;
		}

		var v = $.fieldValue(el, true);
		if (v && v.constructor == Array) {
			for(var j=0, jmax=v.length; j < jmax; j++)
				a.push({name: n, value: v[j]});
		}
		else if (v !== null && typeof v != 'undefined')
			a.push({name: n, value: v});
	}

	if (!semantic && form.clk) {
		// input type=='image' are not found in elements array! handle it here
		var $input = $(form.clk), input = $input[0], n = input.name;
		if (n && !input.disabled && input.type == 'image') {
			a.push({name: n, value: $input.val()});
			a.push({name: n+'.x', value: form.clk_x}, {name: n+'.y', value: form.clk_y});
		}
	}
	return a;
};

/**
 * Serializes form data into a 'submittable' string. This method will return a string
 * in the format: name1=value1&amp;name2=value2
 */
$.fn.formSerialize = function(semantic) {
	//hand off to jQuery.param for proper encoding
	return $.param(this.formToArray(semantic));
};

/**
 * Serializes all field elements in the jQuery object into a query string.
 * This method will return a string in the format: name1=value1&amp;name2=value2
 */
$.fn.fieldSerialize = function(successful) {
	var a = [];
	this.each(function() {
		var n = this.name;
		if (!n) return;
		var v = $.fieldValue(this, successful);
		if (v && v.constructor == Array) {
			for (var i=0,max=v.length; i < max; i++)
				a.push({name: n, value: v[i]});
		}
		else if (v !== null && typeof v != 'undefined')
			a.push({name: this.name, value: v});
	});
	//hand off to jQuery.param for proper encoding
	return $.param(a);
};

/**
 * Returns the value(s) of the element in the matched set.  For example, consider the following form:
 *
 *  <form><fieldset>
 *	  <input name="A" type="text" />
 *	  <input name="A" type="text" />
 *	  <input name="B" type="checkbox" value="B1" />
 *	  <input name="B" type="checkbox" value="B2"/>
 *	  <input name="C" type="radio" value="C1" />
 *	  <input name="C" type="radio" value="C2" />
 *  </fieldset></form>
 *
 *  var v = $(':text').fieldValue();
 *  // if no values are entered into the text inputs
 *  v == ['','']
 *  // if values entered into the text inputs are 'foo' and 'bar'
 *  v == ['foo','bar']
 *
 *  var v = $(':checkbox').fieldValue();
 *  // if neither checkbox is checked
 *  v === undefined
 *  // if both checkboxes are checked
 *  v == ['B1', 'B2']
 *
 *  var v = $(':radio').fieldValue();
 *  // if neither radio is checked
 *  v === undefined
 *  // if first radio is checked
 *  v == ['C1']
 *
 * The successful argument controls whether or not the field element must be 'successful'
 * (per http://www.w3.org/TR/html4/interact/forms.html#successful-controls).
 * The default value of the successful argument is true.  If this value is false the value(s)
 * for each element is returned.
 *
 * Note: This method *always* returns an array.  If no valid value can be determined the
 *	   array will be empty, otherwise it will contain one or more values.
 */
$.fn.fieldValue = function(successful) {
	for (var val=[], i=0, max=this.length; i < max; i++) {
		var el = this[i];
		var v = $.fieldValue(el, successful);
		if (v === null || typeof v == 'undefined' || (v.constructor == Array && !v.length))
			continue;
		v.constructor == Array ? $.merge(val, v) : val.push(v);
	}
	return val;
};

/**
 * Returns the value of the field element.
 */
$.fieldValue = function(el, successful) {
	var n = el.name, t = el.type, tag = el.tagName.toLowerCase();
	if (typeof successful == 'undefined') successful = true;

	if (successful && (!n || el.disabled || t == 'reset' || t == 'button' ||
		(t == 'checkbox' || t == 'radio') && !el.checked ||
		(t == 'submit' || t == 'image') && el.form && el.form.clk != el ||
		tag == 'select' && el.selectedIndex == -1))
			return null;

	if (tag == 'select') {
		var index = el.selectedIndex;
		if (index < 0) return null;
		var a = [], ops = el.options;
		var one = (t == 'select-one');
		var max = (one ? index+1 : ops.length);
		for(var i=(one ? index : 0); i < max; i++) {
			var op = ops[i];
			if (op.selected) {
				var v = op.value;
				if (!v) // extra pain for IE...
					v = (op.attributes && op.attributes['value'] && !(op.attributes['value'].specified)) ? op.text : op.value;
				if (one) return v;
				a.push(v);
			}
		}
		return a;
	}
	return el.value;
};

/**
 * Clears the form data.  Takes the following actions on the form's input fields:
 *  - input text fields will have their 'value' property set to the empty string
 *  - select elements will have their 'selectedIndex' property set to -1
 *  - checkbox and radio inputs will have their 'checked' property set to false
 *  - inputs of type submit, button, reset, and hidden will *not* be effected
 *  - button elements will *not* be effected
 */
$.fn.clearForm = function() {
	return this.each(function() {
		$('input,select,textarea', this).clearFields();
	});
};

/**
 * Clears the selected form elements.
 */
$.fn.clearFields = $.fn.clearInputs = function() {
	return this.each(function() {
		var t = this.type, tag = this.tagName.toLowerCase();
		if (t == 'text' || t == 'password' || tag == 'textarea')
			this.value = '';
		else if (t == 'checkbox' || t == 'radio')
			this.checked = false;
		else if (tag == 'select')
			this.selectedIndex = -1;
	});
};

/**
 * Resets the form data.  Causes all form elements to be reset to their original value.
 */
$.fn.resetForm = function() {
	return this.each(function() {
		// guard against an input with the name of 'reset'
		// note that IE reports the reset function as an 'object'
		if (typeof this.reset == 'function' || (typeof this.reset == 'object' && !this.reset.nodeType))
			this.reset();
	});
};

/**
 * Enables or disables any matching elements.
 */
$.fn.enable = function(b) {
	if (b == undefined) b = true;
	return this.each(function() {
		this.disabled = !b;
	});
};

/**
 * Checks/unchecks any matching checkboxes or radio buttons and
 * selects/deselects and matching option elements.
 */
$.fn.selected = function(select) {
	if (select == undefined) select = true;
	return this.each(function() {
		var t = this.type;
		if (t == 'checkbox' || t == 'radio')
			this.checked = select;
		else if (this.tagName.toLowerCase() == 'option') {
			var $sel = $(this).parent('select');
			if (select && $sel[0] && $sel[0].type == 'select-one') {
				// deselect all other options
				$sel.find('option').selected(false);
			}
			this.selected = select;
		}
	});
};

// helper fn for console logging
// set $.fn.ajaxSubmit.debug to true to enable debug logging
function log() {
	if ($.fn.ajaxSubmit.debug && window.console && window.console.log)
		window.console.log('[jquery.form] ' + Array.prototype.join.call(arguments,''));
};

})(jQuery);

/*
 * Metadata - jQuery plugin for parsing metadata from elements
 *
 * Copyright (c) 2006 John Resig, Yehuda Katz, J�örn Zaefferer, Paul McLanahan
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 * Revision: $Id: jquery.metadata.js 4187 2007-12-16 17:15:27Z joern.zaefferer $
 *
 */

/**
 * Sets the type of metadata to use. Metadata is encoded in JSON, and each property
 * in the JSON will become a property of the element itself.
 *
 * There are three supported types of metadata storage:
 *
 *   attr:  Inside an attribute. The name parameter indicates *which* attribute.
 *          
 *   class: Inside the class attribute, wrapped in curly braces: { }
 *   
 *   elem:  Inside a child element (e.g. a script tag). The
 *          name parameter indicates *which* element.
 *          
 * The metadata for an element is loaded the first time the element is accessed via jQuery.
 *
 * As a result, you can define the metadata type, use $(expr) to load the metadata into the elements
 * matched by expr, then redefine the metadata type and run another $(expr) for other elements.
 * 
 * @name $.metadata.setType
 *
 * @example <p id="one" class="some_class {item_id: 1, item_label: 'Label'}">This is a p</p>
 * @before $.metadata.setType("class")
 * @after $("#one").metadata().item_id == 1; $("#one").metadata().item_label == "Label"
 * @desc Reads metadata from the class attribute
 * 
 * @example <p id="one" class="some_class" data="{item_id: 1, item_label: 'Label'}">This is a p</p>
 * @before $.metadata.setType("attr", "data")
 * @after $("#one").metadata().item_id == 1; $("#one").metadata().item_label == "Label"
 * @desc Reads metadata from a "data" attribute
 * 
 * @example <p id="one" class="some_class"><script>{item_id: 1, item_label: 'Label'}</script>This is a p</p>
 * @before $.metadata.setType("elem", "script")
 * @after $("#one").metadata().item_id == 1; $("#one").metadata().item_label == "Label"
 * @desc Reads metadata from a nested script element
 * 
 * @param String type The encoding type
 * @param String name The name of the attribute to be used to get metadata (optional)
 * @cat Plugins/Metadata
 * @descr Sets the type of encoding to be used when loading metadata for the first time
 * @type undefined
 * @see metadata()
 */

;(function($) {

$.extend({
	metadata : {
		defaults : {
			type: 'class',
			name: 'metadata',
			cre: /({.*})/,
			single: 'metadata'
		},
		setType: function( type, name ){
			this.defaults.type = type;
			this.defaults.name = name;
		},
		get: function( elem, opts ){
			var settings = $.extend({},this.defaults,opts);
			// check for empty string in single property
			if ( !settings.single.length ) settings.single = 'metadata';
			
			var data = $.data(elem, settings.single);
			// returned cached data if it already exists
			if ( data ) return data;
			
			data = "{}";
			
			if ( settings.type == "class" ) {
				var m = settings.cre.exec( elem.className );
				if ( m )
					data = m[1];
			} else if ( settings.type == "elem" ) {
				if( !elem.getElementsByTagName )
					return undefined;
				var e = elem.getElementsByTagName(settings.name);
				if ( e.length )
					data = $.trim(e[0].innerHTML);
			} else if ( elem.getAttribute != undefined ) {
				var attr = elem.getAttribute( settings.name );
				if ( attr )
					data = attr;
			}
			
			if ( data.indexOf( '{' ) <0 )
			data = "{" + data + "}";
			
			data = eval("(" + data + ")");
			
			$.data( elem, settings.single, data );
			return data;
		}
	}
});

/**
 * Returns the metadata object for the first member of the jQuery object.
 *
 * @name metadata
 * @descr Returns element's metadata object
 * @param Object opts An object contianing settings to override the defaults
 * @type jQuery
 * @cat Plugins/Metadata
 */
$.fn.metadata = function( opts ){
	return $.metadata.get( this[0], opts );
};

})(jQuery);
/**
 * jQuery Validation Plugin 1.9.0
 *
 * http://bassistance.de/jquery-plugins/jquery-plugin-validation/
 * http://docs.jquery.com/Plugins/Validation
 *
 * Copyright (c) 2006 - 2011 Jörn Zaefferer
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
;(function(c){c.extend(c.fn,{validate:function(a){if(this.length){var b=c.data(this[0],"validator");if(b)return b;if (typeof(Worker)!=="undefined"){this.attr('novalidate','novalidate');};b=new c.validator(a,this[0]);c.data(this[0],"validator",b);if(b.settings.onsubmit){a=this.find("input, button");a.filter(".cancel").click(function(){b.cancelSubmit=true});b.settings.submitHandler&&a.filter(":submit").click(function(){b.submitButton=this});this.submit(function(d){function e(){if(b.settings.submitHandler){if(b.submitButton)var f=c("<input type='hidden'/>").attr("name",
b.submitButton.name).val(b.submitButton.value).appendTo(b.currentForm);b.settings.submitHandler.call(b,b.currentForm);b.submitButton&&f.remove();return false}return true}b.settings.debug&&d.preventDefault();if(b.cancelSubmit){b.cancelSubmit=false;return e()}if(b.form()){if(b.pendingRequest){b.formSubmitted=true;return false}return e()}else{b.focusInvalid();return false}})}return b}else a&&a.debug&&window.console&&console.warn("nothing selected, can't validate, returning nothing")},valid:function(){if(c(this[0]).is("form"))return this.validate().form();
else{var a=true,b=c(this[0].form).validate();this.each(function(){a&=b.element(this)});return a}},removeAttrs:function(a){var b={},d=this;c.each(a.split(/\s/),function(e,f){b[f]=d.attr(f);d.removeAttr(f)});return b},rules:function(a,b){var d=this[0];if(a){var e=c.data(d.form,"validator").settings,f=e.rules,g=c.validator.staticRules(d);switch(a){case "add":c.extend(g,c.validator.normalizeRule(b));f[d.name]=g;if(b.messages)e.messages[d.name]=c.extend(e.messages[d.name],b.messages);break;case "remove":if(!b){delete f[d.name];
return g}var h={};c.each(b.split(/\s/),function(j,i){h[i]=g[i];delete g[i]});return h}}d=c.validator.normalizeRules(c.extend({},c.validator.metadataRules(d),c.validator.classRules(d),c.validator.attributeRules(d),c.validator.staticRules(d)),d);if(d.required){e=d.required;delete d.required;d=c.extend({required:e},d)}return d}});c.extend(c.expr[":"],{blank:function(a){return!c.trim(""+a.value)},filled:function(a){return!!c.trim(""+a.value)},unchecked:function(a){return!a.checked}});c.validator=function(a,
b){this.settings=c.extend(true,{},c.validator.defaults,a);this.currentForm=b;this.init()};c.validator.format=function(a,b){if(arguments.length==1)return function(){var d=c.makeArray(arguments);d.unshift(a);return c.validator.format.apply(this,d)};if(arguments.length>2&&b.constructor!=Array)b=c.makeArray(arguments).slice(1);if(b.constructor!=Array)b=[b];c.each(b,function(d,e){a=a.replace(RegExp("\\{"+d+"\\}","g"),e)});return a};c.extend(c.validator,{defaults:{messages:{},groups:{},rules:{},errorClass:"error",
validClass:"valid",errorElement:"label",focusInvalid:true,errorContainer:c([]),errorLabelContainer:c([]),onsubmit:true,ignore:":hidden",ignoreTitle:false,onfocusin:function(a){this.lastActive=a;if(this.settings.focusCleanup&&!this.blockFocusCleanup){this.settings.unhighlight&&this.settings.unhighlight.call(this,a,this.settings.errorClass,this.settings.validClass);this.addWrapper(this.errorsFor(a)).hide()}},onfocusout:function(a){if(!this.checkable(a)&&(a.name in this.submitted||!this.optional(a)))this.element(a)},
onkeyup:function(a){if(a.name in this.submitted||a==this.lastElement)this.element(a)},onclick:function(a){if(a.name in this.submitted)this.element(a);else a.parentNode.name in this.submitted&&this.element(a.parentNode)},highlight:function(a,b,d){a.type==="radio"?this.findByName(a.name).addClass(b).removeClass(d):c(a).addClass(b).removeClass(d)},unhighlight:function(a,b,d){a.type==="radio"?this.findByName(a.name).removeClass(b).addClass(d):c(a).removeClass(b).addClass(d)}},setDefaults:function(a){c.extend(c.validator.defaults,
a)},messages:{required:"This field is required.",remote:"Please fix this field.",email:"Please enter a valid email address.",url:"Please enter a valid URL.",date:"Please enter a valid date.",dateISO:"Please enter a valid date (ISO).",number:"Please enter a valid number.",digits:"Please enter only digits.",creditcard:"Please enter a valid credit card number.",equalTo:"Please enter the same value again.",accept:"Please enter a value with a valid extension.",maxlength:c.validator.format("Please enter no more than {0} characters."),
minlength:c.validator.format("Please enter at least {0} characters."),rangelength:c.validator.format("Please enter a value between {0} and {1} characters long."),range:c.validator.format("Please enter a value between {0} and {1}."),max:c.validator.format("Please enter a value less than or equal to {0}."),min:c.validator.format("Please enter a value greater than or equal to {0}.")},autoCreateRanges:false,prototype:{init:function(){function a(e){var f=c.data(this[0].form,"validator"),g="on"+e.type.replace(/^validate/,
"");f.settings[g]&&f.settings[g].call(f,this[0],e)}this.labelContainer=c(this.settings.errorLabelContainer);this.errorContext=this.labelContainer.length&&this.labelContainer||c(this.currentForm);this.containers=c(this.settings.errorContainer).add(this.settings.errorLabelContainer);this.submitted={};this.valueCache={};this.pendingRequest=0;this.pending={};this.invalid={};this.reset();var b=this.groups={};c.each(this.settings.groups,function(e,f){c.each(f.split(/\s/),function(g,h){b[h]=e})});var d=
this.settings.rules;c.each(d,function(e,f){d[e]=c.validator.normalizeRule(f)});c(this.currentForm).validateDelegate("[type='text'], [type='password'], [type='file'], select, textarea, [type='number'], [type='search'] ,[type='tel'], [type='url'], [type='email'], [type='datetime'], [type='date'], [type='month'], [type='week'], [type='time'], [type='datetime-local'], [type='range'], [type='color'] ","focusin focusout keyup",a).validateDelegate("[type='radio'], [type='checkbox'], select, option","click",
a);this.settings.invalidHandler&&c(this.currentForm).bind("invalid-form.validate",this.settings.invalidHandler)},form:function(){this.checkForm();c.extend(this.submitted,this.errorMap);this.invalid=c.extend({},this.errorMap);this.valid()||c(this.currentForm).triggerHandler("invalid-form",[this]);this.showErrors();return this.valid()},checkForm:function(){this.prepareForm();for(var a=0,b=this.currentElements=this.elements();b[a];a++)this.check(b[a]);return this.valid()},element:function(a){this.lastElement=
a=this.validationTargetFor(this.clean(a));this.prepareElement(a);this.currentElements=c(a);var b=this.check(a);if(b)delete this.invalid[a.name];else this.invalid[a.name]=true;if(!this.numberOfInvalids())this.toHide=this.toHide.add(this.containers);this.showErrors();return b},showErrors:function(a){if(a){c.extend(this.errorMap,a);this.errorList=[];for(var b in a)this.errorList.push({message:a[b],element:this.findByName(b)[0]});this.successList=c.grep(this.successList,function(d){return!(d.name in a)})}this.settings.showErrors?
this.settings.showErrors.call(this,this.errorMap,this.errorList):this.defaultShowErrors()},resetForm:function(){c.fn.resetForm&&c(this.currentForm).resetForm();this.submitted={};this.lastElement=null;this.prepareForm();this.hideErrors();this.elements().removeClass(this.settings.errorClass)},numberOfInvalids:function(){return this.objectLength(this.invalid)},objectLength:function(a){var b=0,d;for(d in a)b++;return b},hideErrors:function(){this.addWrapper(this.toHide).hide()},valid:function(){return this.size()==
0},size:function(){return this.errorList.length},focusInvalid:function(){if(this.settings.focusInvalid)try{c(this.findLastActive()||this.errorList.length&&this.errorList[0].element||[]).filter(":visible").focus().trigger("focusin")}catch(a){}},findLastActive:function(){var a=this.lastActive;return a&&c.grep(this.errorList,function(b){return b.element.name==a.name}).length==1&&a},elements:function(){var a=this,b={};return c(this.currentForm).find("input, select, textarea").not(":submit, :reset, :image, [disabled]").not(this.settings.ignore).filter(function(){!this.name&&
a.settings.debug&&window.console&&console.error("%o has no name assigned",this);if(this.name in b||!a.objectLength(c(this).rules()))return false;return b[this.name]=true})},clean:function(a){return c(a)[0]},errors:function(){return c(this.settings.errorElement+"."+this.settings.errorClass,this.errorContext)},reset:function(){this.successList=[];this.errorList=[];this.errorMap={};this.toShow=c([]);this.toHide=c([]);this.currentElements=c([])},prepareForm:function(){this.reset();this.toHide=this.errors().add(this.containers)},
prepareElement:function(a){this.reset();this.toHide=this.errorsFor(a)},check:function(a){a=this.validationTargetFor(this.clean(a));var b=c(a).rules(),d=false,e;for(e in b){var f={method:e,parameters:b[e]};try{var g=c.validator.methods[e].call(this,a.value.replace(/\r/g,""),a,f.parameters);if(g=="dependency-mismatch")d=true;else{d=false;if(g=="pending"){this.toHide=this.toHide.not(this.errorsFor(a));return}if(!g){this.formatAndAdd(a,f);return false}}}catch(h){this.settings.debug&&window.console&&console.log("exception occured when checking element "+
a.id+", check the '"+f.method+"' method",h);throw h;}}if(!d){this.objectLength(b)&&this.successList.push(a);return true}},customMetaMessage:function(a,b){if(c.metadata){var d=this.settings.meta?c(a).metadata()[this.settings.meta]:c(a).metadata();return d&&d.messages&&d.messages[b]}},customMessage:function(a,b){var d=this.settings.messages[a];return d&&(d.constructor==String?d:d[b])},findDefined:function(){for(var a=0;a<arguments.length;a++)if(arguments[a]!==undefined)return arguments[a]},defaultMessage:function(a,
b){return this.findDefined(this.customMessage(a.name,b),this.customMetaMessage(a,b),!this.settings.ignoreTitle&&a.title||undefined,c.validator.messages[b],"<strong>Warning: No message defined for "+a.name+"</strong>")},formatAndAdd:function(a,b){var d=this.defaultMessage(a,b.method),e=/\$?\{(\d+)\}/g;if(typeof d=="function")d=d.call(this,b.parameters,a);else if(e.test(d))d=jQuery.format(d.replace(e,"{$1}"),b.parameters);this.errorList.push({message:d,element:a});this.errorMap[a.name]=d;this.submitted[a.name]=
d},addWrapper:function(a){if(this.settings.wrapper)a=a.add(a.parent(this.settings.wrapper));return a},defaultShowErrors:function(){for(var a=0;this.errorList[a];a++){var b=this.errorList[a];this.settings.highlight&&this.settings.highlight.call(this,b.element,this.settings.errorClass,this.settings.validClass);this.showLabel(b.element,b.message)}if(this.errorList.length)this.toShow=this.toShow.add(this.containers);if(this.settings.success)for(a=0;this.successList[a];a++)this.showLabel(this.successList[a]);
if(this.settings.unhighlight){a=0;for(b=this.validElements();b[a];a++)this.settings.unhighlight.call(this,b[a],this.settings.errorClass,this.settings.validClass)}this.toHide=this.toHide.not(this.toShow);this.hideErrors();this.addWrapper(this.toShow).show()},validElements:function(){return this.currentElements.not(this.invalidElements())},invalidElements:function(){return c(this.errorList).map(function(){return this.element})},showLabel:function(a,b){var d=this.errorsFor(a);if(d.length){d.removeClass(this.settings.validClass).addClass(this.settings.errorClass);
d.attr("generated")&&d.html(b)}else{d=c("<"+this.settings.errorElement+"/>").attr({"for":this.idOrName(a),generated:true}).addClass(this.settings.errorClass).html(b||"");if(this.settings.wrapper)d=d.hide().show().wrap("<"+this.settings.wrapper+"/>").parent();this.labelContainer.append(d).length||(this.settings.errorPlacement?this.settings.errorPlacement(d,c(a)):d.insertAfter(a))}if(!b&&this.settings.success){d.text("");typeof this.settings.success=="string"?d.addClass(this.settings.success):this.settings.success(d)}this.toShow=
this.toShow.add(d)},errorsFor:function(a){var b=this.idOrName(a);return this.errors().filter(function(){return c(this).attr("for")==b})},idOrName:function(a){return this.groups[a.name]||(this.checkable(a)?a.name:a.id||a.name)},validationTargetFor:function(a){if(this.checkable(a))a=this.findByName(a.name).not(this.settings.ignore)[0];return a},checkable:function(a){return/radio|checkbox/i.test(a.type)},findByName:function(a){var b=this.currentForm;return c(document.getElementsByName(a)).map(function(d,
e){return e.form==b&&e.name==a&&e||null})},getLength:function(a,b){switch(b.nodeName.toLowerCase()){case "select":return c("option:selected",b).length;case "input":if(this.checkable(b))return this.findByName(b.name).filter(":checked").length}return a.length},depend:function(a,b){return this.dependTypes[typeof a]?this.dependTypes[typeof a](a,b):true},dependTypes:{"boolean":function(a){return a},string:function(a,b){return!!c(a,b.form).length},"function":function(a,b){return a(b)}},optional:function(a){return!c.validator.methods.required.call(this,
c.trim(a.value),a)&&"dependency-mismatch"},startRequest:function(a){if(!this.pending[a.name]){this.pendingRequest++;this.pending[a.name]=true}},stopRequest:function(a,b){this.pendingRequest--;if(this.pendingRequest<0)this.pendingRequest=0;delete this.pending[a.name];if(b&&this.pendingRequest==0&&this.formSubmitted&&this.form()){c(this.currentForm).submit();this.formSubmitted=false}else if(!b&&this.pendingRequest==0&&this.formSubmitted){c(this.currentForm).triggerHandler("invalid-form",[this]);this.formSubmitted=
false}},previousValue:function(a){return c.data(a,"previousValue")||c.data(a,"previousValue",{old:null,valid:true,message:this.defaultMessage(a,"remote")})}},classRuleSettings:{required:{required:true},email:{email:true},url:{url:true},date:{date:true},dateISO:{dateISO:true},dateDE:{dateDE:true},number:{number:true},numberDE:{numberDE:true},digits:{digits:true},creditcard:{creditcard:true}},addClassRules:function(a,b){a.constructor==String?this.classRuleSettings[a]=b:c.extend(this.classRuleSettings,
a)},classRules:function(a){var b={};(a=c(a).attr("class"))&&c.each(a.split(" "),function(){this in c.validator.classRuleSettings&&c.extend(b,c.validator.classRuleSettings[this])});return b},attributeRules:function(a){var b={};a=c(a);for(var d in c.validator.methods){var e;if(e=d==="required"&&typeof c.fn.prop==="function"?a.prop(d):a.attr(d))b[d]=e;else if(a[0].getAttribute("type")===d)b[d]=true}b.maxlength&&/-1|2147483647|524288/.test(b.maxlength)&&delete b.maxlength;return b},metadataRules:function(a){if(!c.metadata)return{};
var b=c.data(a.form,"validator").settings.meta;return b?c(a).metadata()[b]:c(a).metadata()},staticRules:function(a){var b={},d=c.data(a.form,"validator");if(d.settings.rules)b=c.validator.normalizeRule(d.settings.rules[a.name])||{};return b},normalizeRules:function(a,b){c.each(a,function(d,e){if(e===false)delete a[d];else if(e.param||e.depends){var f=true;switch(typeof e.depends){case "string":f=!!c(e.depends,b.form).length;break;case "function":f=e.depends.call(b,b)}if(f)a[d]=e.param!==undefined?
e.param:true;else delete a[d]}});c.each(a,function(d,e){a[d]=c.isFunction(e)?e(b):e});c.each(["minlength","maxlength","min","max"],function(){if(a[this])a[this]=Number(a[this])});c.each(["rangelength","range"],function(){if(a[this])a[this]=[Number(a[this][0]),Number(a[this][1])]});if(c.validator.autoCreateRanges){if(a.min&&a.max){a.range=[a.min,a.max];delete a.min;delete a.max}if(a.minlength&&a.maxlength){a.rangelength=[a.minlength,a.maxlength];delete a.minlength;delete a.maxlength}}a.messages&&delete a.messages;
return a},normalizeRule:function(a){if(typeof a=="string"){var b={};c.each(a.split(/\s/),function(){b[this]=true});a=b}return a},addMethod:function(a,b,d){c.validator.methods[a]=b;c.validator.messages[a]=d!=undefined?d:c.validator.messages[a];b.length<3&&c.validator.addClassRules(a,c.validator.normalizeRule(a))},methods:{required:function(a,b,d){if(!this.depend(d,b))return"dependency-mismatch";switch(b.nodeName.toLowerCase()){case "select":return(a=c(b).val())&&a.length>0;case "input":if(this.checkable(b))return this.getLength(a,
b)>0;default:return c.trim(a).length>0}},remote:function(a,b,d){if(this.optional(b))return"dependency-mismatch";var e=this.previousValue(b);this.settings.messages[b.name]||(this.settings.messages[b.name]={});e.originalMessage=this.settings.messages[b.name].remote;this.settings.messages[b.name].remote=e.message;d=typeof d=="string"&&{url:d}||d;if(this.pending[b.name])return"pending";if(e.old===a)return e.valid;e.old=a;var f=this;this.startRequest(b);var g={};g[b.name]=a;c.ajax(c.extend(true,{url:d,
mode:"abort",port:"validate"+b.name,dataType:"json",data:g,success:function(h){f.settings.messages[b.name].remote=e.originalMessage;var j=h===true;if(j){var i=f.formSubmitted;f.prepareElement(b);f.formSubmitted=i;f.successList.push(b);f.showErrors()}else{i={};h=h||f.defaultMessage(b,"remote");i[b.name]=e.message=c.isFunction(h)?h(a):h;f.showErrors(i)}e.valid=j;f.stopRequest(b,j)}},d));return"pending"},minlength:function(a,b,d){return this.optional(b)||this.getLength(c.trim(a),b)>=d},maxlength:function(a,
b,d){return this.optional(b)||this.getLength(c.trim(a),b)<=d},rangelength:function(a,b,d){a=this.getLength(c.trim(a),b);return this.optional(b)||a>=d[0]&&a<=d[1]},min:function(a,b,d){return this.optional(b)||a>=d},max:function(a,b,d){return this.optional(b)||a<=d},range:function(a,b,d){return this.optional(b)||a>=d[0]&&a<=d[1]},email:function(a,b){return this.optional(b)||/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(a)},
url:function(a,b){return this.optional(b)||/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(a)},
date:function(a,b){return this.optional(b)||!/Invalid|NaN/.test(new Date(a))},dateISO:function(a,b){return this.optional(b)||/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/.test(a)},number:function(a,b){return this.optional(b)||/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(a)},digits:function(a,b){return this.optional(b)||/^\d+$/.test(a)},creditcard:function(a,b){if(this.optional(b))return"dependency-mismatch";if(/[^0-9 -]+/.test(a))return false;var d=0,e=0,f=false;a=a.replace(/\D/g,"");for(var g=a.length-1;g>=
0;g--){e=a.charAt(g);e=parseInt(e,10);if(f)if((e*=2)>9)e-=9;d+=e;f=!f}return d%10==0},accept:function(a,b,d){d=typeof d=="string"?d.replace(/,/g,"|"):"png|jpe?g|gif";return this.optional(b)||a.match(RegExp(".("+d+")$","i"))},equalTo:function(a,b,d){d=c(d).unbind(".validate-equalTo").bind("blur.validate-equalTo",function(){c(b).valid()});return a==d.val()}}});c.format=c.validator.format})(jQuery);
(function(c){var a={};if(c.ajaxPrefilter)c.ajaxPrefilter(function(d,e,f){e=d.port;if(d.mode=="abort"){a[e]&&a[e].abort();a[e]=f}});else{var b=c.ajax;c.ajax=function(d){var e=("port"in d?d:c.ajaxSettings).port;if(("mode"in d?d:c.ajaxSettings).mode=="abort"){a[e]&&a[e].abort();return a[e]=b.apply(this,arguments)}return b.apply(this,arguments)}}})(jQuery);
(function(c){!jQuery.event.special.focusin&&!jQuery.event.special.focusout&&document.addEventListener&&c.each({focus:"focusin",blur:"focusout"},function(a,b){function d(e){e=c.event.fix(e);e.type=b;return c.event.handle.call(this,e)}c.event.special[b]={setup:function(){this.addEventListener(a,d,true)},teardown:function(){this.removeEventListener(a,d,true)},handler:function(e){arguments[0]=c.event.fix(e);arguments[0].type=b;return c.event.handle.apply(this,arguments)}}});c.extend(c.fn,{validateDelegate:function(a,
b,d){return this.bind(b,function(e){var f=c(e.target);if(f.is(a))return d.apply(f,arguments)})}})})(jQuery);

/**
 * jQuery Validation Plugin 1.9.0
 *
 * http://bassistance.de/jquery-plugins/jquery-plugin-validation/
 * http://docs.jquery.com/Plugins/Validation
 *
 * Copyright (c) 2006 - 2011 Jörn Zaefferer
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
;(function(){function a(b){return b.replace(/<.[^<>]*?>/g," ").replace(/&nbsp;|&#160;/gi," ").replace(/[0-9.(),;:!?%#$'"_+=\/-]*/g,"")}jQuery.validator.addMethod("maxWords",function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length<d},jQuery.validator.format("Please enter {0} words or less."));jQuery.validator.addMethod("minWords",function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length>=d},jQuery.validator.format("Please enter at least {0} words."));jQuery.validator.addMethod("rangeWords",
function(b,c,d){return this.optional(c)||a(b).match(/\b\w+\b/g).length>=d[0]&&b.match(/bw+b/g).length<d[1]},jQuery.validator.format("Please enter between {0} and {1} words."))})();jQuery.validator.addMethod("letterswithbasicpunc",function(a,b){return this.optional(b)||/^[a-z-.,()'\"\s]+$/i.test(a)},"Letters or punctuation only please");jQuery.validator.addMethod("alphanumeric",function(a,b){return this.optional(b)||/^\w+$/i.test(a)},"Letters, numbers, spaces or underscores only please");
jQuery.validator.addMethod("lettersonly",function(a,b){return this.optional(b)||/^[a-z]+$/i.test(a)},"Letters only please");jQuery.validator.addMethod("nowhitespace",function(a,b){return this.optional(b)||/^\S+$/i.test(a)},"No white space please");jQuery.validator.addMethod("ziprange",function(a,b){return this.optional(b)||/^90[2-5]\d\{2}-\d{4}$/.test(a)},"Your ZIP-code must be in the range 902xx-xxxx to 905-xx-xxxx");
jQuery.validator.addMethod("integer",function(a,b){return this.optional(b)||/^-?\d+$/.test(a)},"A positive or negative non-decimal number please");
jQuery.validator.addMethod("vinUS",function(a){if(a.length!=17)return false;var b,c,d,f,e,g=["A","B","C","D","E","F","G","H","J","K","L","M","N","P","R","S","T","U","V","W","X","Y","Z"],i=[1,2,3,4,5,6,7,8,1,2,3,4,5,7,9,2,3,4,5,6,7,8,9],j=[8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2],h=0;for(b=0;b<17;b++){f=j[b];d=a.slice(b,b+1);if(b==8)e=d;if(isNaN(d))for(c=0;c<g.length;c++){if(d.toUpperCase()===g[c]){d=i[c];d*=f;if(isNaN(e)&&c==8)e=g[c];break}}else d*=f;h+=d}a=h%11;if(a==10)a="X";if(a==e)return true;return false},
"The specified vehicle identification number (VIN) is invalid.");jQuery.validator.addMethod("dateITA",function(a,b){var c=false;if(/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(a)){var d=a.split("/");c=parseInt(d[0],10);var f=parseInt(d[1],10);d=parseInt(d[2],10);var e=new Date(d,f-1,c);c=e.getFullYear()==d&&e.getMonth()==f-1&&e.getDate()==c?true:false}else c=false;return this.optional(b)||c},"Please enter a correct date");
jQuery.validator.addMethod("dateNL",function(a,b){return this.optional(b)||/^\d\d?[\.\/-]\d\d?[\.\/-]\d\d\d?\d?$/.test(a)},"Vul hier een geldige datum in.");jQuery.validator.addMethod("time",function(a,b){return this.optional(b)||/^([01]\d|2[0-3])(:[0-5]\d){0,2}$/.test(a)},"Please enter a valid time, between 00:00 and 23:59");jQuery.validator.addMethod("time12h",function(a,b){return this.optional(b)||/^((0?[1-9]|1[012])(:[0-5]\d){0,2}(\ [AP]M))$/i.test(a)},"Please enter a valid time, between 00:00 am and 12:00 pm");
jQuery.validator.addMethod("phoneUS",function(a,b){a=a.replace(/\s+/g,"");return this.optional(b)||a.length>9&&a.match(/^(1-?)?(\([2-9]\d{2}\)|[2-9]\d{2})-?[2-9]\d{2}-?\d{4}$/)},"Please specify a valid phone number");jQuery.validator.addMethod("phoneUK",function(a,b){return this.optional(b)||a.length>9&&a.match(/^(\(?(0|\+44)[1-9]{1}\d{1,4}?\)?\s?\d{3,4}\s?\d{3,4})$/)},"Please specify a valid phone number");
jQuery.validator.addMethod("mobileUK",function(a,b){return this.optional(b)||a.length>9&&a.match(/^((0|\+44)7(5|6|7|8|9){1}\d{2}\s?\d{6})$/)},"Please specify a valid mobile number");jQuery.validator.addMethod("strippedminlength",function(a,b,c){return jQuery(a).text().length>=c},jQuery.validator.format("Please enter at least {0} characters"));
jQuery.validator.addMethod("email2",function(a,b){return this.optional(b)||/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(a)},jQuery.validator.messages.email);
jQuery.validator.addMethod("url2",function(a,b){return this.optional(b)||/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)*(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(a)},
jQuery.validator.messages.url);
jQuery.validator.addMethod("creditcardtypes",function(a,b,c){if(/[^0-9-]+/.test(a))return false;a=a.replace(/\D/g,"");b=0;if(c.mastercard)b|=1;if(c.visa)b|=2;if(c.amex)b|=4;if(c.dinersclub)b|=8;if(c.enroute)b|=16;if(c.discover)b|=32;if(c.jcb)b|=64;if(c.unknown)b|=128;if(c.all)b=255;if(b&1&&/^(51|52|53|54|55)/.test(a))return a.length==16;if(b&2&&/^(4)/.test(a))return a.length==16;if(b&4&&/^(34|37)/.test(a))return a.length==15;if(b&8&&/^(300|301|302|303|304|305|36|38)/.test(a))return a.length==14;if(b&
16&&/^(2014|2149)/.test(a))return a.length==15;if(b&32&&/^(6011)/.test(a))return a.length==16;if(b&64&&/^(3)/.test(a))return a.length==16;if(b&64&&/^(2131|1800)/.test(a))return a.length==15;if(b&128)return true;return false},"Please enter a valid credit card number.");
jQuery.validator.addMethod("ipv4",function(a,b){return this.optional(b)||/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/i.test(a)},"Please enter a valid IP v4 address.");
jQuery.validator.addMethod("ipv6",function(a,b){return this.optional(b)||/^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}:([0-9A-Fa-f]{1,4}:)?[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){4}:([0-9A-Fa-f]{1,4}:){0,2}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){3}:([0-9A-Fa-f]{1,4}:){0,3}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){2}:([0-9A-Fa-f]{1,4}:){0,4}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){6}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(([0-9A-Fa-f]{1,4}:){0,5}:((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|(::([0-9A-Fa-f]{1,4}:){0,5}((\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b)\.){3}(\b((25[0-5])|(1\d{2})|(2[0-4]\d)|(\d{1,2}))\b))|([0-9A-Fa-f]{1,4}::([0-9A-Fa-f]{1,4}:){0,5}[0-9A-Fa-f]{1,4})|(::([0-9A-Fa-f]{1,4}:){0,6}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:))$/i.test(a)},"Please enter a valid IP v6 address.");
jQuery.validator.addMethod("pattern",function(a,b,c){return this.optional(b)||c.test(a)},"Invalid format.");

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: CN
 */
jQuery.extend(jQuery.validator.messages, {
        required: "必选字段",
		remote: "请修正该字段",
		email: "请输入正确格式的电子邮件",
		url: "请输入合法的网址",
		date: "请输入合法的日期",
		dateISO: "请输入合法的日期 (ISO).",
		number: "请输入合法的数字",
		digits: "只能输入整数",
		creditcard: "请输入合法的信用卡号",
		equalTo: "请再次输入相同的值",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
		minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
		rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
		min: jQuery.validator.format("请输入一个最小为 {0} 的值")
});
/* @projectDescription jQuery Password Strength Plugin - A jQuery plugin to provide accessibility functions
 * @author Tane Piper (digitalspaghetti@gmail.com)
 * @version 2.0
 * @website: http://digitalspaghetti.me.uk/digitalspaghetti
 * @license MIT License: http://www.opensource.org/licenses/mit-license.php
 * 
 * === Changelog ===
 * Version 2.1 (18/05/2008)
 * Added a jQuery method to add a new rule: jQuery('input[@type=password]').pstrength.addRule(name, method, score, active)
 * Added a jQuery method to change a rule score: jQuery('input[@type=password]').pstrength.changeScore('one_number', 50);
 * Added a jQuery method to change a rules active state: jQuery('input[@type=password]').pstrength.ruleActive('one_number', false);
 * Hide the 'password to short' span if the password is more than the min chars
 * 
 * Version 2.0 (17/05/2008)
 * Completly re-wrote the plugin from scratch.  Plugin now features lamda functions for validation and
 * custom validation rules 
 * Plugin now exists in new digitalspaghetti. namespace to stop any conflits with other plugins.
 * Updated documentation
 * 
 * Version 1.4 (12/02/2008)
 * Added some improvments to i18n stuff from Raffael Luthiger.
 * Version 1.3 (02/01/2008)
 * Changing coding style to more OO
 * Added default messages object for i18n
 * Changed password length score to Math.pow (thanks to Keith Mashinter for this suggestion)
 * Version 1.2 (03/09/2007)
 * Added more options for colors and common words
 * Added common words checked to see if words like 'password' or 'qwerty' are being entered
 * Added minimum characters required for password
 * Re-worked scoring system to give better results
 * Version 1.1 (20/08/2007)
 * Changed code to be more jQuery-like
 * Version 1.0 (20/07/2007)
 * Initial version.
 */

// Create our namespaced object
/*global window */
/*global jQuery */
/*global digitalspaghetti*/
window.digitalspaghetti = window.digitalspaghetti || {};
digitalspaghetti.password = {	
	'defaults' : {
		'displayMinChar': true,
		'minChar': 8,
		'minCharText': 'You must enter a minimum of %d characters',
		'colors': ["#f00", "#c06", "#f60", "#3c0", "#3f0"],
		'scores': [20, 30, 43, 50],
		'verdicts':	['Weak', 'Normal', 'Medium', 'Strong', 'Very Strong'],
		'raisePower': 1.4,
		'debug': false
	},
	el:{
		passwordMinChar:null,
		passwordStrengthBar:null
	},
	'ruleScores' : {
		'length': 0,
		'lowercase': 1,
		'uppercase': 1,
		'one_number': 1,
		'three_numbers': 1,
		'one_special_char': 3,
		'two_special_char': 5,
		'upper_lower_combo': 2,
		'letter_number_combo': 10,
		'letter_number_char_combo': 10
	},
	'rules' : {
		'length': true,
		'lowercase': true,
		'uppercase': true,
		'one_number': true,
		'three_numbers': true,
		'one_special_char': true,
		'two_special_char': true,
		'upper_lower_combo': true,
		'letter_number_combo': true,
		'letter_number_char_combo': true
	},
	'validationRules': {
		'length': function (word, score) {
			digitalspaghetti.password.tooShort = false;
			var wordlen = word.length;
			var lenScore = Math.pow(wordlen, digitalspaghetti.password.options.raisePower);
			if (wordlen < digitalspaghetti.password.options.minChar) {
				lenScore = (lenScore - 100);
				digitalspaghetti.password.tooShort = true;
			}
			return lenScore;
		},
		'lowercase': function (word, score) {
			return word.match(/[a-z]/) && score;
		},
		'uppercase': function (word, score) {
			return word.match(/[A-Z]/) && score;
		},
		'one_number': function (word, score) {
			return word.match(/\d+/) && score;
		},
		'three_numbers': function (word, score) {
			return word.match(/(.*[0-9].*[0-9].*[0-9])/) && score;
		},
		'one_special_char': function (word, score) {
			return word.match(/.[!,@,#,$,%,\^,&,*,?,_,~]/) && score;
		},
		'two_special_char': function (word, score) {
			return word.match(/(.*[!,@,#,$,%,\^,&,*,?,_,~].*[!,@,#,$,%,\^,&,*,?,_,~])/) && score;
		},
		'upper_lower_combo': function (word, score) {
			return word.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/) && score;
		},
		'letter_number_combo': function (word, score) {
			return word.match(/([a-zA-Z])/) && word.match(/([0-9])/) && score;
		},
		'letter_number_char_combo' : function (word, score) {
			return word.match(/([a-zA-Z0-9].*[!,@,#,$,%,\^,&,*,?,_,~])|([!,@,#,$,%,\^,&,*,?,_,~].*[a-zA-Z0-9])/) && score;
		}
	},
	'attachWidget': function (element) {
		var output = ['<div id="password-strength">'];
		if (digitalspaghetti.password.options.displayMinChar && !digitalspaghetti.password.tooShort) {
			output.push('<span class="password-min-char">' + digitalspaghetti.password.options.minCharText.replace('%d', digitalspaghetti.password.options.minChar) + '</span>');
		}
		output.push('<span class="password-strength-bar"></span>');
		output.push('</div>');
		output = output.join('');
		jQuery(element).after(output);
	},
	'debugOutput': function (element) {
		if (typeof console.log === 'function') {
			console.log(digitalspaghetti.password);	
		} else {
			alert(digitalspaghetti.password);
		}
	},
	'addRule': function (name, method, score, active) {
		digitalspaghetti.password.rules[name] = active;
		digitalspaghetti.password.ruleScores[name] = score;
		digitalspaghetti.password.validationRules[name] = method;
		return true;
	},
	'init': function (element, options) {
		digitalspaghetti.password.options = jQuery.extend({}, digitalspaghetti.password.defaults, options);
		digitalspaghetti.password.attachWidget(element);
		jQuery(element).keyup(function () {
			digitalspaghetti.password.calculateScore(jQuery(this).val());
		});
		if (digitalspaghetti.password.options.debug) {
			digitalspaghetti.password.debugOutput();
		}
	},
	'calculateScore': function (word) {
		digitalspaghetti.password.totalscore = 0;
		digitalspaghetti.password.width = 0;
		for (var key in digitalspaghetti.password.rules) if (digitalspaghetti.password.rules.hasOwnProperty(key)) {
			if (digitalspaghetti.password.rules[key] === true) {
				var score = digitalspaghetti.password.ruleScores[key];
				var result = digitalspaghetti.password.validationRules[key](word, score);
				if (result) {
					digitalspaghetti.password.totalscore += result;
				}
			}
			if (digitalspaghetti.password.totalscore <= digitalspaghetti.password.options.scores[0]) {
				digitalspaghetti.password.strColor = digitalspaghetti.password.options.colors[0];
				digitalspaghetti.password.strText = digitalspaghetti.password.options.verdicts[0];
				digitalspaghetti.password.width =  "25";
			} else if (digitalspaghetti.password.totalscore > digitalspaghetti.password.options.scores[0] && digitalspaghetti.password.totalscore <= digitalspaghetti.password.options.scores[1]) {
				digitalspaghetti.password.strColor = digitalspaghetti.password.options.colors[1];
				digitalspaghetti.password.strText = digitalspaghetti.password.options.verdicts[1];
				digitalspaghetti.password.width =  "25";
			} else if (digitalspaghetti.password.totalscore > digitalspaghetti.password.options.scores[1] && digitalspaghetti.password.totalscore <= digitalspaghetti.password.options.scores[2]) {
				digitalspaghetti.password.strColor = digitalspaghetti.password.options.colors[2];
				digitalspaghetti.password.strText = digitalspaghetti.password.options.verdicts[2];
				digitalspaghetti.password.width =  "50";
			} else if (digitalspaghetti.password.totalscore > digitalspaghetti.password.options.scores[2] && digitalspaghetti.password.totalscore <= digitalspaghetti.password.options.scores[3]) {
				digitalspaghetti.password.strColor = digitalspaghetti.password.options.colors[3];
				digitalspaghetti.password.strText = digitalspaghetti.password.options.verdicts[3];
				digitalspaghetti.password.width =  "75";
			} else {
				digitalspaghetti.password.strColor = digitalspaghetti.password.options.colors[4];
				digitalspaghetti.password.strText = digitalspaghetti.password.options.verdicts[4];
				digitalspaghetti.password.width =  "99";
			}
			
			if (digitalspaghetti.password.options.displayMinChar && !digitalspaghetti.password.tooShort) {
				if(!digitalspaghetti.password.el.passwordMinChar){
					digitalspaghetti.password.el.passwordMinChar=jQuery('.password-min-char');
				}
				digitalspaghetti.password.el.passwordMinChar.hide();
			} else {
				if(!digitalspaghetti.password.el.passwordMinChar){
					digitalspaghetti.password.el.passwordMinChar=jQuery('.password-min-char');
				}
				digitalspaghetti.password.el.passwordMinChar.show();
			}
			if(!digitalspaghetti.password.el.passwordStrengthBar){
				digitalspaghetti.password.el.passwordStrengthBar=jQuery('.password-strength-bar');
			}
			digitalspaghetti.password.el.passwordStrengthBar.css({'display': 'block', 'background-color': digitalspaghetti.password.strColor, 'width': digitalspaghetti.password.width + "%"}).text(digitalspaghetti.password.strText);
		}
	}
};

jQuery.extend(jQuery.fn, {
	'pstrength': function (options) {
		return this.each(function () {
			digitalspaghetti.password.init(this, options);
		});
	}
});
jQuery.extend(jQuery.fn.pstrength, {
	'addRule': function (name, method, score, active) {
		digitalspaghetti.password.addRule(name, method, score, active);
		return true;
	},
	'changeScore': function (rule, score) {
		digitalspaghetti.password.ruleScores[rule] = score;
		return true;
	},
	'ruleActive': function (rule, active) {
		digitalspaghetti.password.rules[rule] = active;
		return true;
	}
});
;(function($){
/**
 * jqGrid Chinese Translation for v4.2
 * henryyan 2011.11.30
 * http://www.wsria.com
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 * 
 * update 2011.11.30
 *		add double u3000 SPACE for search:odata to fix SEARCH box display err when narrow width from only use of eq/ne/cn/in/lt/gt operator under IE6/7
**/
$.jgrid = {
	defaults : {
		recordtext: "{0} - {1}\u3000共 {2} 条",	// 共字前是全角空格
		emptyrecords: "无数据显示",
		loadtext: "读取中...",
		pgtext : " {0} 共 {1} 页"
	},
	search : {
		caption: "搜索...",
		Find: "查找",
		Reset: "重置",
		odata : ['等于\u3000\u3000', '不等\u3000\u3000', '小于\u3000\u3000', '小于等于','大于\u3000\u3000','大于等于', 
			'开始于','不开始于','属于\u3000\u3000','不属于','结束于','不结束于','包含\u3000\u3000','不包含','空值于\u3000\u3000','非空值'],
		groupOps: [	{ op: "AND", text: "所有" },	{ op: "OR",  text: "任一" }	],
		matchText: " 匹配",
		rulesText: " 规则"
	},
	edit : {
		addCaption: "添加记录",
		editCaption: "编辑记录",
		bSubmit: "提交",
		bCancel: "取消",
		bClose: "关闭",
		saveData: "数据已改变，是否保存？",
		bYes : "是",
		bNo : "否",
		bExit : "取消",
		msg: {
			required:"此字段必需",
			number:"请输入有效数字",
			minValue:"输值必须大于等于 ",
			maxValue:"输值必须小于等于 ",
			email: "这不是有效的e-mail地址",
			integer: "请输入有效整数",
			date: "请输入有效时间",
			url: "无效网址。前缀必须为 ('http://' 或 'https://')",
			nodefined : " 未定义！",
			novalue : " 需要返回值！",
			customarray : "自定义函数需要返回数组！",
			customfcheck : "Custom function should be present in case of custom checking!"
			
		}
	},
	view : {
		caption: "查看记录",
		bClose: "关闭"
	},
	del : {
		caption: "删除",
		msg: "删除所选记录？",
		bSubmit: "删除",
		bCancel: "取消"
	},
	nav : {
		edittext: "",
		edittitle: "编辑所选记录",
		addtext:"",
		addtitle: "添加新记录",
		deltext: "",
		deltitle: "删除所选记录",
		searchtext: "",
		searchtitle: "查找",
		refreshtext: "",
		refreshtitle: "刷新表格",
		alertcap: "注意",
		alerttext: "请选择记录",
		viewtext: "",
		viewtitle: "查看所选记录"
	},
	col : {
		caption: "选择列",
		bSubmit: "确定",
		bCancel: "取消"
	},
	errors : {
		errcap : "错误",
		nourl : "没有设置url",
		norecords: "没有要处理的记录",
		model : "colNames 和 colModel 长度不等！"
	},
	formatter : {
		integer : {thousandsSeparator: " ", defaultValue: '0'},
		number : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0.00'},
		currency : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
		date : {
			dayNames:   [
				"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat",
		         "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
			],
			monthNames: [
				"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
			],
			AmPm : ["am","pm","AM","PM"],
			S: function (j) {return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th'},
			srcformat: 'Y-m-d',
			newformat: 'm-d-Y',
			masks : {
				ISO8601Long:"Y-m-d H:i:s",
				ISO8601Short:"Y-m-d",
				ShortDate: "Y/j/n",
				LongDate: "l, F d, Y",
				FullDateTime: "l, F d, Y g:i:s A",
				MonthDay: "F d",
				ShortTime: "g:i A",
				LongTime: "g:i:s A",
				SortableDateTime: "Y-m-d\\TH:i:s",
				UniversalSortableDateTime: "Y-m-d H:i:sO",
				YearMonth: "F, Y"
			},
			reformatAfterEdit : false
		},
		baseLinkUrl: '',
		showAction: '',
		target: '',
		checkbox : {disabled:true},
		idName : 'id'
	}
};
})(jQuery);

/* 
* jqGrid  4.3.1 - jQuery Grid 
* Copyright (c) 2008, Tony Tomov, tony@trirand.com 
* Dual licensed under the MIT and GPL licenses 
* http://www.opensource.org/licenses/mit-license.php 
* http://www.gnu.org/licenses/gpl-2.0.html 
* Date:2011-12-20 
* Modules: grid.base.js; jquery.fmatter.js; grid.custom.js; grid.common.js; grid.formedit.js; grid.filter.js; grid.inlinedit.js; grid.celledit.js; jqModal.js; jqDnR.js; grid.subgrid.js; grid.grouping.js; grid.treegrid.js; grid.import.js; JsonXml.js; grid.tbltogrid.js; grid.jqueryui.js; 
*/
/*
 jqGrid  4.3.1  - jQuery Grid
 Copyright (c) 2008, Tony Tomov, tony@trirand.com
 Dual licensed under the MIT and GPL licenses
 http://www.opensource.org/licenses/mit-license.php
 http://www.gnu.org/licenses/gpl-2.0.html
 Date: 2011-12-20
*/
(function(b){b.jgrid=b.jgrid||{};b.extend(b.jgrid,{htmlDecode:function(d){if(d&&(d=="&nbsp;"||d=="&#160;"||d.length===1&&d.charCodeAt(0)===160))return"";return!d?d:String(d).replace(/&gt;/g,">").replace(/&lt;/g,"<").replace(/&quot;/g,'"').replace(/&amp;/g,"&")},htmlEncode:function(d){return!d?d:String(d).replace(/&/g,"&amp;").replace(/\"/g,"&quot;").replace(/</g,"&lt;").replace(/>/g,"&gt;")},format:function(d){var i=b.makeArray(arguments).slice(1);if(d===undefined)d="";return d.replace(/\{(\d+)\}/g,
function(g,c){return i[c]})},getCellIndex:function(d){d=b(d);if(d.is("tr"))return-1;d=(!d.is("td")&&!d.is("th")?d.closest("td,th"):d)[0];if(b.browser.msie)return b.inArray(d,d.parentNode.cells);return d.cellIndex},stripHtml:function(d){d+="";var i=/<("[^"]*"|'[^']*'|[^'">])*>/gi;if(d)return(d=d.replace(i,""))&&d!=="&nbsp;"&&d!=="&#160;"?d.replace(/\"/g,"'"):"";else return d},realType:function(d){return Object.prototype.toString.call(d).slice(8,-1)},stripPref:function(d,i){var g=this.realType(d);if(g==
"String"||g=="Number"){d=String(d);i=d!==""?String(i).replace(String(d),""):i}return i},stringToDoc:function(d){var i;if(typeof d!=="string")return d;try{i=(new DOMParser).parseFromString(d,"text/xml")}catch(g){i=new ActiveXObject("Microsoft.XMLDOM");i.async=false;i.loadXML(d)}return i&&i.documentElement&&i.documentElement.tagName!="parsererror"?i:null},parse:function(d){if(d.substr(0,9)=="while(1);")d=d.substr(9);if(d.substr(0,2)=="/*")d=d.substr(2,d.length-4);d||(d="{}");return b.jgrid.useJSON===
true&&typeof JSON==="object"&&typeof JSON.parse==="function"?JSON.parse(d):eval("("+d+")")},parseDate:function(d,i){var g={m:1,d:1,y:1970,h:0,i:0,s:0,u:0},c,h,k;c=/[\\\/:_;.,\t\T\s-]/;if(i&&i!==null&&i!==undefined){i=b.trim(i);i=i.split(c);d=d.split(c);var l=b.jgrid.formatter.date.monthNames,a=b.jgrid.formatter.date.AmPm,q=function(x,y){if(x===0){if(y===12)y=0}else if(y!==12)y+=12;return y};c=0;for(h=d.length;c<h;c++){if(d[c]=="M"){k=b.inArray(i[c],l);if(k!==-1&&k<12)i[c]=k+1}if(d[c]=="F"){k=b.inArray(i[c],
l);if(k!==-1&&k>11)i[c]=k+1-12}if(d[c]=="a"){k=b.inArray(i[c],a);if(k!==-1&&k<2&&i[c]==a[k]){i[c]=k;g.h=q(i[c],g.h)}}if(d[c]=="A"){k=b.inArray(i[c],a);if(k!==-1&&k>1&&i[c]==a[k]){i[c]=k-2;g.h=q(i[c],g.h)}}if(i[c]!==undefined)g[d[c].toLowerCase()]=parseInt(i[c],10)}g.m=parseInt(g.m,10)-1;c=g.y;if(c>=70&&c<=99)g.y=1900+g.y;else if(c>=0&&c<=69)g.y=2E3+g.y}return new Date(g.y,g.m,g.d,g.h,g.i,g.s,g.u)},jqID:function(d){return String(d).replace(/[!"#$%&'()*+,.\/:;<=>?@\[\\\]\^`{|}~]/g,"\\$&")},guid:1,uidPref:"jqg",
randId:function(d){return(d?d:b.jgrid.uidPref)+b.jgrid.guid++},getAccessor:function(d,i){var g,c,h=[],k;if(typeof i==="function")return i(d);g=d[i];if(g===undefined)try{if(typeof i==="string")h=i.split(".");if(k=h.length)for(g=d;g&&k--;){c=h.shift();g=g[c]}}catch(l){}return g},getXmlData:function(d,i,g){var c=typeof i==="string"?i.match(/^(.*)\[(\w+)\]$/):null;if(typeof i==="function")return i(d);if(c&&c[2])return c[1]?b(c[1],d).attr(c[2]):b(d).attr(c[2]);else{d=b(i,d);if(g)return d;return d.length>
0?b(d).text():undefined}},ajaxOptions:{},from:function(d){return new function(i,g){if(typeof i=="string")i=b.data(i);var c=this,h=i,k=true,l=false,a=g,q=/[\$,%]/g,x=null,y=null,E=0,I=false,M="",N=[],V=true;if(typeof i=="object"&&i.push){if(i.length>0)V=typeof i[0]!="object"?false:true}else throw"data provides is not an array";this._hasData=function(){return h===null?false:h.length===0?false:true};this._getStr=function(o){var n=[];l&&n.push("jQuery.trim(");n.push("String("+o+")");l&&n.push(")");k||
n.push(".toLowerCase()");return n.join("")};this._strComp=function(o){return typeof o=="string"?".toString()":""};this._group=function(o,n){return{field:o.toString(),unique:n,items:[]}};this._toStr=function(o){if(l)o=b.trim(o);k||(o=o.toLowerCase());return o=o.toString().replace(/\\/g,"\\\\").replace(/\"/g,'\\"')};this._funcLoop=function(o){var n=[];b.each(h,function(t,F){n.push(o(F))});return n};this._append=function(o){var n;if(a===null)a="";else a+=M===""?" && ":M;for(n=0;n<E;n++)a+="(";if(I)a+=
"!";a+="("+o+")";I=false;M="";E=0};this._setCommand=function(o,n){x=o;y=n};this._resetNegate=function(){I=false};this._repeatCommand=function(o,n){if(x===null)return c;if(o!==null&&n!==null)return x(o,n);if(y===null)return x(o);if(!V)return x(o);return x(y,o)};this._equals=function(o,n){return c._compare(o,n,1)===0};this._compare=function(o,n,t){if(t===undefined)t=1;if(o===undefined)o=null;if(n===undefined)n=null;if(o===null&&n===null)return 0;if(o===null&&n!==null)return 1;if(o!==null&&n===null)return-1;
if(!k&&typeof o!=="number"&&typeof n!=="number"){o=String(o).toLowerCase();n=String(n).toLowerCase()}if(o<n)return-t;if(o>n)return t;return 0};this._performSort=function(){if(N.length!==0)h=c._doSort(h,0)};this._doSort=function(o,n){var t=N[n].by,F=N[n].dir,T=N[n].type,J=N[n].datefmt;if(n==N.length-1)return c._getOrder(o,t,F,T,J);n++;t=c._getGroup(o,t,F,T,J);F=[];for(T=0;T<t.length;T++){J=c._doSort(t[T].items,n);for(var D=0;D<J.length;D++)F.push(J[D])}return F};this._getOrder=function(o,n,t,F,T){var J=
[],D=[],ca=t=="a"?1:-1,X,fa;if(F===undefined)F="text";fa=F=="float"||F=="number"||F=="currency"||F=="numeric"?function(R){R=parseFloat(String(R).replace(q,""));return isNaN(R)?0:R}:F=="int"||F=="integer"?function(R){return R?parseFloat(String(R).replace(q,"")):0}:F=="date"||F=="datetime"?function(R){return b.jgrid.parseDate(T,R).getTime()}:b.isFunction(F)?F:function(R){R||(R="");return b.trim(String(R).toUpperCase())};b.each(o,function(R,aa){X=n!==""?b.jgrid.getAccessor(aa,n):aa;if(X===undefined)X=
"";X=fa(X,aa);D.push({vSort:X,index:R})});D.sort(function(R,aa){R=R.vSort;aa=aa.vSort;return c._compare(R,aa,ca)});F=0;for(var pa=o.length;F<pa;){t=D[F].index;J.push(o[t]);F++}return J};this._getGroup=function(o,n,t,F,T){var J=[],D=null,ca=null,X;b.each(c._getOrder(o,n,t,F,T),function(fa,pa){X=b.jgrid.getAccessor(pa,n);if(X===undefined)X="";if(!c._equals(ca,X)){ca=X;D!==null&&J.push(D);D=c._group(n,X)}D.items.push(pa)});D!==null&&J.push(D);return J};this.ignoreCase=function(){k=false;return c};this.useCase=
function(){k=true;return c};this.trim=function(){l=true;return c};this.noTrim=function(){l=false;return c};this.execute=function(){var o=a,n=[];if(o===null)return c;b.each(h,function(){eval(o)&&n.push(this)});h=n;return c};this.data=function(){return h};this.select=function(o){c._performSort();if(!c._hasData())return[];c.execute();if(b.isFunction(o)){var n=[];b.each(h,function(t,F){n.push(o(F))});return n}return h};this.hasMatch=function(){if(!c._hasData())return false;c.execute();return h.length>
0};this.andNot=function(o,n,t){I=!I;return c.and(o,n,t)};this.orNot=function(o,n,t){I=!I;return c.or(o,n,t)};this.not=function(o,n,t){return c.andNot(o,n,t)};this.and=function(o,n,t){M=" && ";if(o===undefined)return c;return c._repeatCommand(o,n,t)};this.or=function(o,n,t){M=" || ";if(o===undefined)return c;return c._repeatCommand(o,n,t)};this.orBegin=function(){E++;return c};this.orEnd=function(){if(a!==null)a+=")";return c};this.isNot=function(o){I=!I;return c.is(o)};this.is=function(o){c._append("this."+
o);c._resetNegate();return c};this._compareValues=function(o,n,t,F,T){var J;J=V?"jQuery.jgrid.getAccessor(this,'"+n+"')":"this";if(t===undefined)t=null;var D=t,ca=T.stype===undefined?"text":T.stype;if(t!==null)switch(ca){case "int":case "integer":D=isNaN(Number(D))||D===""?"0":D;J="parseInt("+J+",10)";D="parseInt("+D+",10)";break;case "float":case "number":case "numeric":D=String(D).replace(q,"");D=isNaN(Number(D))||D===""?"0":D;J="parseFloat("+J+")";D="parseFloat("+D+")";break;case "date":case "datetime":D=
String(b.jgrid.parseDate(T.newfmt||"Y-m-d",D).getTime());J='jQuery.jgrid.parseDate("'+T.srcfmt+'",'+J+").getTime()";break;default:J=c._getStr(J);D=c._getStr('"'+c._toStr(D)+'"')}c._append(J+" "+F+" "+D);c._setCommand(o,n);c._resetNegate();return c};this.equals=function(o,n,t){return c._compareValues(c.equals,o,n,"==",t)};this.notEquals=function(o,n,t){return c._compareValues(c.equals,o,n,"!==",t)};this.isNull=function(o,n,t){return c._compareValues(c.equals,o,null,"===",t)};this.greater=function(o,
n,t){return c._compareValues(c.greater,o,n,">",t)};this.less=function(o,n,t){return c._compareValues(c.less,o,n,"<",t)};this.greaterOrEquals=function(o,n,t){return c._compareValues(c.greaterOrEquals,o,n,">=",t)};this.lessOrEquals=function(o,n,t){return c._compareValues(c.lessOrEquals,o,n,"<=",t)};this.startsWith=function(o,n){var t=n===undefined||n===null?o:n;t=l?b.trim(t.toString()).length:t.toString().length;if(V)c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".substr(0,"+t+") == "+
c._getStr('"'+c._toStr(n)+'"'));else{t=l?b.trim(n.toString()).length:n.toString().length;c._append(c._getStr("this")+".substr(0,"+t+") == "+c._getStr('"'+c._toStr(o)+'"'))}c._setCommand(c.startsWith,o);c._resetNegate();return c};this.endsWith=function(o,n){var t=n===undefined||n===null?o:n;t=l?b.trim(t.toString()).length:t.toString().length;V?c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".substr("+c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".length-"+t+","+t+') == "'+c._toStr(n)+
'"'):c._append(c._getStr("this")+".substr("+c._getStr("this")+'.length-"'+c._toStr(o)+'".length,"'+c._toStr(o)+'".length) == "'+c._toStr(o)+'"');c._setCommand(c.endsWith,o);c._resetNegate();return c};this.contains=function(o,n){V?c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+'.indexOf("'+c._toStr(n)+'",0) > -1'):c._append(c._getStr("this")+'.indexOf("'+c._toStr(o)+'",0) > -1');c._setCommand(c.contains,o);c._resetNegate();return c};this.groupBy=function(o,n,t,F){if(!c._hasData())return null;
return c._getGroup(h,o,n,t,F)};this.orderBy=function(o,n,t,F){n=n===undefined||n===null?"a":b.trim(n.toString().toLowerCase());if(t===null||t===undefined)t="text";if(F===null||F===undefined)F="Y-m-d";if(n=="desc"||n=="descending")n="d";if(n=="asc"||n=="ascending")n="a";N.push({by:o,dir:n,type:t,datefmt:F});return c};return c}(d,null)},extend:function(d){b.extend(b.fn.jqGrid,d);this.no_legacy_api||b.fn.extend(d)}});b.fn.jqGrid=function(d){if(typeof d=="string"){var i=b.jgrid.getAccessor(b.fn.jqGrid,
d);if(!i)throw"jqGrid - No such method: "+d;var g=b.makeArray(arguments).slice(1);return i.apply(this,g)}return this.each(function(){if(!this.grid){var c=b.extend(true,{url:"",height:150,page:1,rowNum:20,rowTotal:null,records:0,pager:"",pgbuttons:true,pginput:true,colModel:[],rowList:[],colNames:[],sortorder:"asc",sortname:"",datatype:"xml",mtype:"GET",altRows:false,selarrrow:[],savedRow:[],shrinkToFit:true,xmlReader:{},jsonReader:{},subGrid:false,subGridModel:[],reccount:0,lastpage:0,lastsort:0,
selrow:null,beforeSelectRow:null,onSelectRow:null,onSortCol:null,ondblClickRow:null,onRightClickRow:null,onPaging:null,onSelectAll:null,loadComplete:null,gridComplete:null,loadError:null,loadBeforeSend:null,afterInsertRow:null,beforeRequest:null,beforeProcessing:null,onHeaderClick:null,viewrecords:false,loadonce:false,multiselect:false,multikey:false,editurl:null,search:false,caption:"",hidegrid:true,hiddengrid:false,postData:{},userData:{},treeGrid:false,treeGridModel:"nested",treeReader:{},treeANode:-1,
ExpandColumn:null,tree_root_level:0,prmNames:{page:"page",rows:"rows",sort:"sidx",order:"sord",search:"_search",nd:"nd",id:"id",oper:"oper",editoper:"edit",addoper:"add",deloper:"del",subgridid:"id",npage:null,totalrows:"totalrows"},forceFit:false,gridstate:"visible",cellEdit:false,cellsubmit:"remote",nv:0,loadui:"enable",toolbar:[false,""],scroll:false,multiboxonly:false,deselectAfterSort:true,scrollrows:false,autowidth:false,scrollOffset:18,cellLayout:5,subGridWidth:20,multiselectWidth:20,gridview:false,
rownumWidth:25,rownumbers:false,pagerpos:"center",recordpos:"right",footerrow:false,userDataOnFooter:false,hoverrows:true,altclass:"ui-priority-secondary",viewsortcols:[false,"vertical",true],resizeclass:"",autoencode:false,remapColumns:[],ajaxGridOptions:{},direction:"ltr",toppager:false,headertitles:false,scrollTimeout:40,data:[],_index:{},grouping:false,groupingView:{groupField:[],groupOrder:[],groupText:[],groupColumnShow:[],groupSummary:[],showSummaryOnHide:false,sortitems:[],sortnames:[],groupDataSorted:false,
summary:[],summaryval:[],plusicon:"ui-icon-circlesmall-plus",minusicon:"ui-icon-circlesmall-minus"},ignoreCase:false,cmTemplate:{},idPrefix:""},b.jgrid.defaults,d||{}),h={headers:[],cols:[],footers:[],dragStart:function(e,f,j){this.resizing={idx:e,startX:f.clientX,sOL:j[0]};this.hDiv.style.cursor="col-resize";this.curGbox=b("#rs_m"+b.jgrid.jqID(c.id),"#gbox_"+b.jgrid.jqID(c.id));this.curGbox.css({display:"block",left:j[0],top:j[1],height:j[2]});b.isFunction(c.resizeStart)&&c.resizeStart.call(this,
f,e);document.onselectstart=function(){return false}},dragMove:function(e){if(this.resizing){var f=e.clientX-this.resizing.startX;e=this.headers[this.resizing.idx];var j=c.direction==="ltr"?e.width+f:e.width-f,m;if(j>33){this.curGbox.css({left:this.resizing.sOL+f});if(c.forceFit===true){m=this.headers[this.resizing.idx+c.nv];f=c.direction==="ltr"?m.width-f:m.width+f;if(f>33){e.newWidth=j;m.newWidth=f}}else{this.newWidth=c.direction==="ltr"?c.tblwidth+f:c.tblwidth-f;e.newWidth=j}}}},dragEnd:function(){this.hDiv.style.cursor=
"default";if(this.resizing){var e=this.resizing.idx,f=this.headers[e].newWidth||this.headers[e].width;f=parseInt(f,10);this.resizing=false;b("#rs_m"+b.jgrid.jqID(c.id)).css("display","none");c.colModel[e].width=f;this.headers[e].width=f;this.headers[e].el.style.width=f+"px";this.cols[e].style.width=f+"px";if(this.footers.length>0)this.footers[e].style.width=f+"px";if(c.forceFit===true){f=this.headers[e+c.nv].newWidth||this.headers[e+c.nv].width;this.headers[e+c.nv].width=f;this.headers[e+c.nv].el.style.width=
f+"px";this.cols[e+c.nv].style.width=f+"px";if(this.footers.length>0)this.footers[e+c.nv].style.width=f+"px";c.colModel[e+c.nv].width=f}else{c.tblwidth=this.newWidth||c.tblwidth;b("table:first",this.bDiv).css("width",c.tblwidth+"px");b("table:first",this.hDiv).css("width",c.tblwidth+"px");this.hDiv.scrollLeft=this.bDiv.scrollLeft;if(c.footerrow){b("table:first",this.sDiv).css("width",c.tblwidth+"px");this.sDiv.scrollLeft=this.bDiv.scrollLeft}}b.isFunction(c.resizeStop)&&c.resizeStop.call(this,f,e)}this.curGbox=
null;document.onselectstart=function(){return true}},populateVisible:function(){h.timer&&clearTimeout(h.timer);h.timer=null;var e=b(h.bDiv).height();if(e){var f=b("table:first",h.bDiv),j,m;if(f[0].rows.length)try{m=(j=f[0].rows[1])?b(j).outerHeight()||h.prevRowHeight:h.prevRowHeight}catch(p){m=h.prevRowHeight}if(m){h.prevRowHeight=m;var C=c.rowNum;j=h.scrollTop=h.bDiv.scrollTop;var s=Math.round(f.position().top)-j,A=s+f.height();m*=C;var z,u,w;if(A<e&&s<=0&&(c.lastpage===undefined||parseInt((A+j+
m-1)/m,10)<=c.lastpage)){u=parseInt((e-A+m-1)/m,10);if(A>=0||u<2||c.scroll===true){z=Math.round((A+j)/m)+1;s=-1}else s=1}if(s>0){z=parseInt(j/m,10)+1;u=parseInt((j+e)/m,10)+2-z;w=true}if(u)if(!(c.lastpage&&z>c.lastpage||c.lastpage==1||z===c.page&&z===c.lastpage))if(h.hDiv.loading)h.timer=setTimeout(h.populateVisible,c.scrollTimeout);else{c.page=z;if(w){h.selectionPreserver(f[0]);h.emptyRows(h.bDiv,false,false)}h.populate(u)}}}},scrollGrid:function(e){if(c.scroll){var f=h.bDiv.scrollTop;if(h.scrollTop===
undefined)h.scrollTop=0;if(f!=h.scrollTop){h.scrollTop=f;h.timer&&clearTimeout(h.timer);h.timer=setTimeout(h.populateVisible,c.scrollTimeout)}}h.hDiv.scrollLeft=h.bDiv.scrollLeft;if(c.footerrow)h.sDiv.scrollLeft=h.bDiv.scrollLeft;e&&e.stopPropagation()},selectionPreserver:function(e){var f=e.p,j=f.selrow,m=f.selarrrow?b.makeArray(f.selarrrow):null,p=e.grid.bDiv.scrollLeft,C=f.gridComplete;f.gridComplete=function(){f.selrow=null;f.selarrrow=[];if(f.multiselect&&m&&m.length>0)for(var s=0;s<m.length;s++)m[s]!=
j&&b(e).jqGrid("setSelection",m[s],false);j&&b(e).jqGrid("setSelection",j,false);e.grid.bDiv.scrollLeft=p;f.gridComplete=C;f.gridComplete&&C()}}};if(this.tagName.toUpperCase()!="TABLE")alert("Element is not a table");else{b(this).empty().attr("tabindex","1");this.p=c;this.p.useProp=!!b.fn.prop;var k,l,a;if(this.p.colNames.length===0)for(k=0;k<this.p.colModel.length;k++)this.p.colNames[k]=this.p.colModel[k].label||this.p.colModel[k].name;if(this.p.colNames.length!==this.p.colModel.length)alert(b.jgrid.errors.model);
else{var q=b("<div class='ui-jqgrid-view'></div>"),x,y=b.browser.msie?true:false,E=b.browser.webkit||b.browser.safari?true:false;a=this;a.p.direction=b.trim(a.p.direction.toLowerCase());if(b.inArray(a.p.direction,["ltr","rtl"])==-1)a.p.direction="ltr";l=a.p.direction;b(q).insertBefore(this);b(this).appendTo(q).removeClass("scroll");var I=b("<div class='ui-jqgrid ui-widget ui-widget-content ui-corner-all'></div>");b(I).insertBefore(q).attr({id:"gbox_"+this.id,dir:l});b(q).appendTo(I).attr("id","gview_"+
this.id);x=y&&b.browser.version<=6?'<iframe style="display:block;position:absolute;z-index:-1;filter:Alpha(Opacity=\'0\');" src="javascript:false;"></iframe>':"";b("<div class='ui-widget-overlay jqgrid-overlay' id='lui_"+this.id+"'></div>").append(x).insertBefore(q);b("<div class='loading ui-state-default ui-state-active' id='load_"+this.id+"'>"+this.p.loadtext+"</div>").insertBefore(q);b(this).attr({cellspacing:"0",cellpadding:"0",border:"0",role:"grid","aria-multiselectable":!!this.p.multiselect,
"aria-labelledby":"gbox_"+this.id});var M=function(e,f){e=parseInt(e,10);return isNaN(e)?f?f:0:e},N=function(e,f,j,m,p,C){var s=a.p.colModel[e],A=s.align,z='style="',u=s.classes,w=s.name,r=[];if(A)z+="text-align:"+A+";";if(s.hidden===true)z+="display:none;";if(f===0)z+="width: "+h.headers[e].width+"px;";else if(s.cellattr&&b.isFunction(s.cellattr))if((e=s.cellattr.call(a,p,j,m,s,C))&&typeof e==="string"){e=e.replace(/style/i,"style").replace(/title/i,"title");if(e.indexOf("title")>-1)s.title=false;
if(e.indexOf("class")>-1)u=undefined;r=e.split("style");if(r.length===2){r[1]=b.trim(r[1].replace("=",""));if(r[1].indexOf("'")===0||r[1].indexOf('"')===0)r[1]=r[1].substring(1);z+=r[1].replace(/'/gi,'"')}else z+='"'}if(!r.length){r[0]="";z+='"'}z+=(u!==undefined?' class="'+u+'"':"")+(s.title&&j?' title="'+b.jgrid.stripHtml(j)+'"':"");z+=' aria-describedby="'+a.p.id+"_"+w+'"';return z+r[0]},V=function(e){return e===undefined||e===null||e===""?"&#160;":a.p.autoencode?b.jgrid.htmlEncode(e):e+""},o=
function(e,f,j,m,p){var C=a.p.colModel[j];if(typeof C.formatter!=="undefined"){e={rowId:e,colModel:C,gid:a.p.id,pos:j};f=b.isFunction(C.formatter)?C.formatter.call(a,f,e,m,p):b.fmatter?b.fn.fmatter(C.formatter,f,e,m,p):V(f)}else f=V(f);return f},n=function(e,f,j,m,p){f=o(e,f,j,p,"add");return'<td role="gridcell" '+N(j,m,f,p,e,true)+">"+f+"</td>"},t=function(e,f,j){var m='<input role="checkbox" type="checkbox" id="jqg_'+a.p.id+"_"+e+'" class="cbox" name="jqg_'+a.p.id+"_"+e+'"/>';return'<td role="gridcell" '+
N(f,j,"",null,e,true)+">"+m+"</td>"},F=function(e,f,j,m){j=(parseInt(j,10)-1)*parseInt(m,10)+1+f;return'<td role="gridcell" class="ui-state-default jqgrid-rownum" '+N(e,f,j,null,f,true)+">"+j+"</td>"},T=function(e){var f,j=[],m=0,p;for(p=0;p<a.p.colModel.length;p++){f=a.p.colModel[p];if(f.name!=="cb"&&f.name!=="subgrid"&&f.name!=="rn"){j[m]=e=="local"?f.name:e=="xml"||e==="xmlstring"?f.xmlmap||f.name:f.jsonmap||f.name;m++}}return j},J=function(e){var f=a.p.remapColumns;if(!f||!f.length)f=b.map(a.p.colModel,
function(j,m){return m});if(e)f=b.map(f,function(j){return j<e?null:j-e});return f},D=function(e,f,j){if(a.p.deepempty)b("#"+b.jgrid.jqID(a.p.id)+" tbody:first tr:gt(0)").remove();else{var m=b("#"+b.jgrid.jqID(a.p.id)+" tbody:first tr:first")[0];b("#"+b.jgrid.jqID(a.p.id)+" tbody:first").empty().append(m)}if(f&&a.p.scroll){b(">div:first",e).css({height:"auto"}).children("div:first").css({height:0,display:"none"});e.scrollTop=0}if(j===true)if(a.p.treeGrid===true){a.p.data=[];a.p._index={}}},ca=function(){var e=
a.p.data.length,f,j,m;f=a.p.rownumbers===true?1:0;j=a.p.multiselect===true?1:0;m=a.p.subGrid===true?1:0;f=a.p.keyIndex===false||a.p.loadonce===true?a.p.localReader.id:a.p.colModel[a.p.keyIndex+j+m+f].name;for(j=0;j<e;j++){m=b.jgrid.getAccessor(a.p.data[j],f);a.p._index[m]=j}},X=function(e,f,j,m,p){var C=new Date,s=a.p.datatype!="local"&&a.p.loadonce||a.p.datatype=="xmlstring",A=a.p.xmlReader,z=a.p.datatype=="local"?"local":"xml";if(s){a.p.data=[];a.p._index={};a.p.localReader.id="_id_"}a.p.reccount=
0;if(b.isXMLDoc(e)){if(a.p.treeANode===-1&&!a.p.scroll){D(f,false,true);j=1}else j=j>1?j:1;var u,w,r=0,G,O=0,S=0,K=0,L,Z=[],P,v={},B,H,U=[],ia=a.p.altRows===true?" "+a.p.altclass:"";A.repeatitems||(Z=T(z));L=a.p.keyIndex===false?A.id:a.p.keyIndex;if(Z.length>0&&!isNaN(L)){if(a.p.remapColumns&&a.p.remapColumns.length)L=b.inArray(L,a.p.remapColumns);L=Z[L]}z=(L+"").indexOf("[")===-1?Z.length?function(ga,ba){return b(L,ga).text()||ba}:function(ga,ba){return b(A.cell,ga).eq(L).text()||ba}:function(ga,
ba){return ga.getAttribute(L.replace(/[\[\]]/g,""))||ba};a.p.userData={};a.p.page=b.jgrid.getXmlData(e,A.page)||0;a.p.lastpage=b.jgrid.getXmlData(e,A.total);if(a.p.lastpage===undefined)a.p.lastpage=1;a.p.records=b.jgrid.getXmlData(e,A.records)||0;if(b.isFunction(A.userdata))a.p.userData=A.userdata.call(a,e)||{};else b.jgrid.getXmlData(e,A.userdata,true).each(function(){a.p.userData[this.getAttribute("name")]=b(this).text()});e=b.jgrid.getXmlData(e,A.root,true);(e=b.jgrid.getXmlData(e,A.row,true))||
(e=[]);var $=e.length,W=0,ha={},ja=parseInt(a.p.rowNum,10);if($>0&&a.p.page<=0)a.p.page=1;if(e&&$){var qa=a.p.scroll?b.jgrid.randId():1;if(p)ja*=p+1;p=b.isFunction(a.p.afterInsertRow);var ya="";if(a.p.grouping&&a.p.groupingView.groupCollapse===true)ya=' style="display:none;"';for(;W<$;){B=e[W];H=z(B,qa+W);H=a.p.idPrefix+H;u=j===0?0:j+1;u=(u+W)%2==1?ia:"";U.push("<tr"+ya+' id="'+H+'" tabindex="-1" role="row" class ="ui-widget-content jqgrow ui-row-'+a.p.direction+""+u+'">');if(a.p.rownumbers===true){U.push(F(0,
W,a.p.page,a.p.rowNum));K=1}if(a.p.multiselect===true){U.push(t(H,K,W));O=1}if(a.p.subGrid===true){U.push(b(a).jqGrid("addSubGridCell",O+K,W+j));S=1}if(A.repeatitems){P||(P=J(O+S+K));var Ca=b.jgrid.getXmlData(B,A.cell,true);b.each(P,function(ga){var ba=Ca[this];if(!ba)return false;G=ba.textContent||ba.text;v[a.p.colModel[ga+O+S+K].name]=G;U.push(n(H,G,ga+O+S+K,W+j,B))})}else for(u=0;u<Z.length;u++){G=b.jgrid.getXmlData(B,Z[u]);v[a.p.colModel[u+O+S+K].name]=G;U.push(n(H,G,u+O+S+K,W+j,B))}U.push("</tr>");
if(a.p.grouping){u=a.p.groupingView.groupField.length;for(var Da=[],za=0;za<u;za++)Da.push(v[a.p.groupingView.groupField[za]]);ha=b(a).jqGrid("groupingPrepare",U,Da,ha,v);U=[]}if(s||a.p.treeGrid===true){v._id_=H;a.p.data.push(v);a.p._index[H]=a.p.data.length-1}if(a.p.gridview===false){b("tbody:first",f).append(U.join(""));p&&a.p.afterInsertRow.call(a,H,v,B);U=[]}v={};r++;W++;if(r==ja)break}}if(a.p.gridview===true){w=a.p.treeANode>-1?a.p.treeANode:0;if(a.p.grouping){b(a).jqGrid("groupingRender",ha,
a.p.colModel.length);ha=null}else a.p.treeGrid===true&&w>0?b(a.rows[w]).after(U.join("")):b("tbody:first",f).append(U.join(""))}if(a.p.subGrid===true)try{b(a).jqGrid("addSubGrid",O+K)}catch(Ka){}a.p.totaltime=new Date-C;if(r>0)if(a.p.records===0)a.p.records=$;U=null;if(a.p.treeGrid===true)try{b(a).jqGrid("setTreeNode",w+1,r+w+1)}catch(La){}if(!a.p.treeGrid&&!a.p.scroll)a.grid.bDiv.scrollTop=0;a.p.reccount=r;a.p.treeANode=-1;a.p.userDataOnFooter&&b(a).jqGrid("footerData","set",a.p.userData,true);if(s){a.p.records=
$;a.p.lastpage=Math.ceil($/ja)}m||a.updatepager(false,true);if(s)for(;r<$;){B=e[r];H=z(B,r);H=a.p.idPrefix+H;if(A.repeatitems){P||(P=J(O+S+K));var Ha=b.jgrid.getXmlData(B,A.cell,true);b.each(P,function(ga){var ba=Ha[this];if(!ba)return false;G=ba.textContent||ba.text;v[a.p.colModel[ga+O+S+K].name]=G})}else for(u=0;u<Z.length;u++){G=b.jgrid.getXmlData(B,Z[u]);v[a.p.colModel[u+O+S+K].name]=G}v._id_=H;a.p.data.push(v);a.p._index[H]=a.p.data.length-1;v={};r++}}},fa=function(e,f,j,m,p){var C=new Date;
if(e){if(a.p.treeANode===-1&&!a.p.scroll){D(f,false,true);j=1}else j=j>1?j:1;var s,A=a.p.datatype!="local"&&a.p.loadonce||a.p.datatype=="jsonstring";if(A){a.p.data=[];a.p._index={};a.p.localReader.id="_id_"}a.p.reccount=0;if(a.p.datatype=="local"){f=a.p.localReader;s="local"}else{f=a.p.jsonReader;s="json"}var z=0,u,w,r=[],G,O=0,S=0,K=0,L,Z,P={},v,B,H=[],U=a.p.altRows===true?" "+a.p.altclass:"";a.p.page=b.jgrid.getAccessor(e,f.page)||0;L=b.jgrid.getAccessor(e,f.total);a.p.lastpage=L===undefined?1:
L;a.p.records=b.jgrid.getAccessor(e,f.records)||0;a.p.userData=b.jgrid.getAccessor(e,f.userdata)||{};f.repeatitems||(G=r=T(s));s=a.p.keyIndex===false?f.id:a.p.keyIndex;if(r.length>0&&!isNaN(s)){if(a.p.remapColumns&&a.p.remapColumns.length)s=b.inArray(s,a.p.remapColumns);s=r[s]}(Z=b.jgrid.getAccessor(e,f.root))||(Z=[]);L=Z.length;e=0;if(L>0&&a.p.page<=0)a.p.page=1;var ia=parseInt(a.p.rowNum,10),$=a.p.scroll?b.jgrid.randId():1;if(p)ia*=p+1;var W=b.isFunction(a.p.afterInsertRow),ha={},ja="";if(a.p.grouping&&
a.p.groupingView.groupCollapse===true)ja=' style="display:none;"';for(;e<L;){p=Z[e];B=b.jgrid.getAccessor(p,s);if(B===undefined){B=$+e;if(r.length===0)if(f.cell){u=b.jgrid.getAccessor(p,f.cell);B=u!==undefined?u[s]||B:B}}B=a.p.idPrefix+B;u=j===1?0:j;u=(u+e)%2==1?U:"";H.push("<tr"+ja+' id="'+B+'" tabindex="-1" role="row" class= "ui-widget-content jqgrow ui-row-'+a.p.direction+""+u+'">');if(a.p.rownumbers===true){H.push(F(0,e,a.p.page,a.p.rowNum));K=1}if(a.p.multiselect){H.push(t(B,K,e));O=1}if(a.p.subGrid){H.push(b(a).jqGrid("addSubGridCell",
O+K,e+j));S=1}if(f.repeatitems){if(f.cell)p=b.jgrid.getAccessor(p,f.cell);G||(G=J(O+S+K))}for(w=0;w<G.length;w++){u=b.jgrid.getAccessor(p,G[w]);H.push(n(B,u,w+O+S+K,e+j,p));P[a.p.colModel[w+O+S+K].name]=u}H.push("</tr>");if(a.p.grouping){u=a.p.groupingView.groupField.length;w=[];for(var qa=0;qa<u;qa++)w.push(P[a.p.groupingView.groupField[qa]]);ha=b(a).jqGrid("groupingPrepare",H,w,ha,P);H=[]}if(A||a.p.treeGrid===true){P._id_=B;a.p.data.push(P);a.p._index[B]=a.p.data.length-1}if(a.p.gridview===false){b("#"+
b.jgrid.jqID(a.p.id)+" tbody:first").append(H.join(""));W&&a.p.afterInsertRow.call(a,B,P,p);H=[]}P={};z++;e++;if(z==ia)break}if(a.p.gridview===true){v=a.p.treeANode>-1?a.p.treeANode:0;if(a.p.grouping)b(a).jqGrid("groupingRender",ha,a.p.colModel.length);else a.p.treeGrid===true&&v>0?b(a.rows[v]).after(H.join("")):b("#"+b.jgrid.jqID(a.p.id)+" tbody:first").append(H.join(""))}if(a.p.subGrid===true)try{b(a).jqGrid("addSubGrid",O+K)}catch(ya){}a.p.totaltime=new Date-C;if(z>0)if(a.p.records===0)a.p.records=
L;if(a.p.treeGrid===true)try{b(a).jqGrid("setTreeNode",v+1,z+v+1)}catch(Ca){}if(!a.p.treeGrid&&!a.p.scroll)a.grid.bDiv.scrollTop=0;a.p.reccount=z;a.p.treeANode=-1;a.p.userDataOnFooter&&b(a).jqGrid("footerData","set",a.p.userData,true);if(A){a.p.records=L;a.p.lastpage=Math.ceil(L/ia)}m||a.updatepager(false,true);if(A)for(;z<L&&Z[z];){p=Z[z];B=b.jgrid.getAccessor(p,s);if(B===undefined){B=$+z;if(r.length===0)if(f.cell)B=b.jgrid.getAccessor(p,f.cell)[s]||B}if(p){B=a.p.idPrefix+B;if(f.repeatitems){if(f.cell)p=
b.jgrid.getAccessor(p,f.cell);G||(G=J(O+S+K))}for(w=0;w<G.length;w++){u=b.jgrid.getAccessor(p,G[w]);P[a.p.colModel[w+O+S+K].name]=u}P._id_=B;a.p.data.push(P);a.p._index[B]=a.p.data.length-1;P={}}z++}}},pa=function(){function e(v){var B=0,H,U,ia,$,W;if(v.groups!==undefined){(U=v.groups.length&&v.groupOp.toString().toUpperCase()==="OR")&&r.orBegin();for(H=0;H<v.groups.length;H++){B>0&&U&&r.or();try{e(v.groups[H])}catch(ha){alert(ha)}B++}U&&r.orEnd()}if(v.rules!==undefined){if(B>0){U=r.select();r=b.jgrid.from(U);
if(a.p.ignoreCase)r=r.ignoreCase()}try{(ia=v.rules.length&&v.groupOp.toString().toUpperCase()==="OR")&&r.orBegin();for(H=0;H<v.rules.length;H++){W=v.rules[H];$=v.groupOp.toString().toUpperCase();if(w[W.op]&&W.field){if(B>0&&$&&$==="OR")r=r.or();r=w[W.op](r,$)(W.field,W.data,m[W.field])}B++}ia&&r.orEnd()}catch(ja){alert(ja)}}}var f,j=false,m={},p=[],C=[],s,A,z;if(b.isArray(a.p.data)){var u=a.p.grouping?a.p.groupingView:false;b.each(a.p.colModel,function(){A=this.sorttype||"text";if(A=="date"||A=="datetime"){if(this.formatter&&
typeof this.formatter==="string"&&this.formatter=="date"){s=this.formatoptions&&this.formatoptions.srcformat?this.formatoptions.srcformat:b.jgrid.formatter.date.srcformat;z=this.formatoptions&&this.formatoptions.newformat?this.formatoptions.newformat:b.jgrid.formatter.date.newformat}else s=z=this.datefmt||"Y-m-d";m[this.name]={stype:A,srcfmt:s,newfmt:z}}else m[this.name]={stype:A,srcfmt:"",newfmt:""};if(a.p.grouping&&this.name==u.groupField[0]){var v=this.name;if(typeof this.index!="undefined")v=
this.index;p[0]=m[v];C.push(v)}if(!j&&(this.index==a.p.sortname||this.name==a.p.sortname)){f=this.name;j=true}});if(a.p.treeGrid)b(a).jqGrid("SortTree",f,a.p.sortorder,m[f].stype,m[f].srcfmt);else{var w={eq:function(v){return v.equals},ne:function(v){return v.notEquals},lt:function(v){return v.less},le:function(v){return v.lessOrEquals},gt:function(v){return v.greater},ge:function(v){return v.greaterOrEquals},cn:function(v){return v.contains},nc:function(v,B){return B==="OR"?v.orNot().contains:v.andNot().contains},
bw:function(v){return v.startsWith},bn:function(v,B){return B==="OR"?v.orNot().startsWith:v.andNot().startsWith},en:function(v,B){return B==="OR"?v.orNot().endsWith:v.andNot().endsWith},ew:function(v){return v.endsWith},ni:function(v,B){return B==="OR"?v.orNot().equals:v.andNot().equals},"in":function(v){return v.equals},nu:function(v){return v.isNull},nn:function(v,B){return B==="OR"?v.orNot().isNull:v.andNot().isNull}},r=b.jgrid.from(a.p.data);if(a.p.ignoreCase)r=r.ignoreCase();if(a.p.search===
true){var G=a.p.postData.filters;if(G){if(typeof G=="string")G=b.jgrid.parse(G);e(G)}else try{r=w[a.p.postData.searchOper](r)(a.p.postData.searchField,a.p.postData.searchString,m[a.p.postData.searchField])}catch(O){}}if(a.p.grouping){r.orderBy(C,u.groupOrder[0],p[0].stype,p[0].srcfmt);u.groupDataSorted=true}if(f&&a.p.sortorder&&j)a.p.sortorder.toUpperCase()=="DESC"?r.orderBy(a.p.sortname,"d",m[f].stype,m[f].srcfmt):r.orderBy(a.p.sortname,"a",m[f].stype,m[f].srcfmt);G=r.select();var S=parseInt(a.p.rowNum,
10),K=G.length,L=parseInt(a.p.page,10),Z=Math.ceil(K/S),P={};G=G.slice((L-1)*S,L*S);m=r=null;P[a.p.localReader.total]=Z;P[a.p.localReader.page]=L;P[a.p.localReader.records]=K;P[a.p.localReader.root]=G;P[a.p.localReader.userdata]=a.p.userData;G=null;return P}}},R=function(){a.grid.hDiv.loading=true;if(!a.p.hiddengrid)switch(a.p.loadui){case "enable":b("#load_"+b.jgrid.jqID(a.p.id)).show();break;case "block":b("#lui_"+b.jgrid.jqID(a.p.id)).show();b("#load_"+b.jgrid.jqID(a.p.id)).show()}},aa=function(){a.grid.hDiv.loading=
false;switch(a.p.loadui){case "enable":b("#load_"+b.jgrid.jqID(a.p.id)).hide();break;case "block":b("#lui_"+b.jgrid.jqID(a.p.id)).hide();b("#load_"+b.jgrid.jqID(a.p.id)).hide()}},ka=function(e){if(!a.grid.hDiv.loading){var f=a.p.scroll&&e===false,j={},m,p=a.p.prmNames;if(a.p.page<=0)a.p.page=1;if(p.search!==null)j[p.search]=a.p.search;if(p.nd!==null)j[p.nd]=(new Date).getTime();if(p.rows!==null)j[p.rows]=a.p.rowNum;if(p.page!==null)j[p.page]=a.p.page;if(p.sort!==null)j[p.sort]=a.p.sortname;if(p.order!==
null)j[p.order]=a.p.sortorder;if(a.p.rowTotal!==null&&p.totalrows!==null)j[p.totalrows]=a.p.rowTotal;var C=a.p.loadComplete,s=b.isFunction(C);s||(C=null);var A=0;e=e||1;if(e>1)if(p.npage!==null){j[p.npage]=e;A=e-1;e=1}else C=function(u){a.p.page++;a.grid.hDiv.loading=false;s&&a.p.loadComplete.call(a,u);ka(e-1)};else p.npage!==null&&delete a.p.postData[p.npage];if(a.p.grouping){b(a).jqGrid("groupingSetup");if(a.p.groupingView.groupDataSorted===true)j[p.sort]=a.p.groupingView.groupField[0]+" "+a.p.groupingView.groupOrder[0]+
", "+j[p.sort]}b.extend(a.p.postData,j);var z=!a.p.scroll?1:a.rows.length-1;if(b.isFunction(a.p.datatype))a.p.datatype.call(a,a.p.postData,"load_"+a.p.id);else{if(b.isFunction(a.p.beforeRequest)){j=a.p.beforeRequest.call(a);if(j===undefined)j=true;if(j===false)return}m=a.p.datatype.toLowerCase();switch(m){case "json":case "jsonp":case "xml":case "script":b.ajax(b.extend({url:a.p.url,type:a.p.mtype,dataType:m,data:b.isFunction(a.p.serializeGridData)?a.p.serializeGridData.call(a,a.p.postData):a.p.postData,
success:function(u,w,r){b.isFunction(a.p.beforeProcessing)&&a.p.beforeProcessing.call(a,u,w,r);m==="xml"?X(u,a.grid.bDiv,z,e>1,A):fa(u,a.grid.bDiv,z,e>1,A);C&&C.call(a,u);f&&a.grid.populateVisible();if(a.p.loadonce||a.p.treeGrid)a.p.datatype="local";e===1&&aa()},error:function(u,w,r){b.isFunction(a.p.loadError)&&a.p.loadError.call(a,u,w,r);e===1&&aa()},beforeSend:function(u,w){var r=true;if(b.isFunction(a.p.loadBeforeSend))r=a.p.loadBeforeSend.call(a,u,w);if(r===undefined)r=true;if(r===false)return false;
else R()}},b.jgrid.ajaxOptions,a.p.ajaxGridOptions));break;case "xmlstring":R();j=b.jgrid.stringToDoc(a.p.datastr);X(j,a.grid.bDiv);s&&a.p.loadComplete.call(a,j);a.p.datatype="local";a.p.datastr=null;aa();break;case "jsonstring":R();j=typeof a.p.datastr=="string"?b.jgrid.parse(a.p.datastr):a.p.datastr;fa(j,a.grid.bDiv);s&&a.p.loadComplete.call(a,j);a.p.datatype="local";a.p.datastr=null;aa();break;case "local":case "clientside":R();a.p.datatype="local";j=pa();fa(j,a.grid.bDiv,z,e>1,A);C&&C.call(a,
j);f&&a.grid.populateVisible();aa()}}}},sa=function(e){b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.hDiv)[a.p.useProp?"prop":"attr"]("checked",e);if(a.p.frozenColumns&&a.p.id+"_frozen")b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.fhDiv)[a.p.useProp?"prop":"attr"]("checked",e)};x=function(e,f){var j="",m="<table cellspacing='0' cellpadding='0' border='0' style='table-layout:auto;' class='ui-pg-table'><tbody><tr>",p="",C,s,A,z,u=function(w){var r;if(b.isFunction(a.p.onPaging))r=a.p.onPaging.call(a,w);a.p.selrow=null;
if(a.p.multiselect){a.p.selarrrow=[];sa(false)}a.p.savedRow=[];if(r=="stop")return false;return true};e=e.substr(1);f+="_"+e;C="pg_"+e;s=e+"_left";A=e+"_center";z=e+"_right";b("#"+b.jgrid.jqID(e)).append("<div id='"+C+"' class='ui-pager-control' role='group'><table cellspacing='0' cellpadding='0' border='0' class='ui-pg-table' style='width:100%;table-layout:fixed;height:100%;' role='row'><tbody><tr><td id='"+s+"' align='left'></td><td id='"+A+"' align='center' style='white-space:pre;'></td><td id='"+
z+"' align='right'></td></tr></tbody></table></div>").attr("dir","ltr");if(a.p.rowList.length>0){p="<td dir='"+l+"'>";p+="<select class='ui-pg-selbox' role='listbox'>";for(s=0;s<a.p.rowList.length;s++)p+='<option role="option" value="'+a.p.rowList[s]+'"'+(a.p.rowNum==a.p.rowList[s]?' selected="selected"':"")+">"+a.p.rowList[s]+"</option>";p+="</select></td>"}if(l=="rtl")m+=p;if(a.p.pginput===true)j="<td dir='"+l+"'>"+b.jgrid.format(a.p.pgtext||"","<input class='ui-pg-input' type='text' size='2' maxlength='7' value='0' role='textbox'/>",
"<span id='sp_1_"+b.jgrid.jqID(e)+"'></span>")+"</td>";if(a.p.pgbuttons===true){s=["first"+f,"prev"+f,"next"+f,"last"+f];l=="rtl"&&s.reverse();m+="<td id='"+s[0]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-first'></span></td>";m+="<td id='"+s[1]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-prev'></span></td>";m+=j!==""?"<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>"+j+"<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>":
"";m+="<td id='"+s[2]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-next'></span></td>";m+="<td id='"+s[3]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-end'></span></td>"}else if(j!=="")m+=j;if(l=="ltr")m+=p;m+="</tr></tbody></table>";a.p.viewrecords===true&&b("td#"+e+"_"+a.p.recordpos,"#"+C).append("<div dir='"+l+"' style='text-align:"+a.p.recordpos+"' class='ui-paging-info'></div>");b("td#"+e+"_"+a.p.pagerpos,"#"+C).append(m);p=b(".ui-jqgrid").css("font-size")||
"11px";b(document.body).append("<div id='testpg' class='ui-jqgrid ui-widget ui-widget-content' style='font-size:"+p+";visibility:hidden;' ></div>");m=b(m).clone().appendTo("#testpg").width();b("#testpg").remove();if(m>0){if(j!=="")m+=50;b("td#"+e+"_"+a.p.pagerpos,"#"+C).width(m)}a.p._nvtd=[];a.p._nvtd[0]=m?Math.floor((a.p.width-m)/2):Math.floor(a.p.width/3);a.p._nvtd[1]=0;m=null;b(".ui-pg-selbox","#"+C).bind("change",function(){a.p.page=Math.round(a.p.rowNum*(a.p.page-1)/this.value-0.5)+1;a.p.rowNum=
this.value;if(f)b(".ui-pg-selbox",a.p.pager).val(this.value);else a.p.toppager&&b(".ui-pg-selbox",a.p.toppager).val(this.value);if(!u("records"))return false;ka();return false});if(a.p.pgbuttons===true){b(".ui-pg-button","#"+C).hover(function(){if(b(this).hasClass("ui-state-disabled"))this.style.cursor="default";else{b(this).addClass("ui-state-hover");this.style.cursor="pointer"}},function(){if(!b(this).hasClass("ui-state-disabled")){b(this).removeClass("ui-state-hover");this.style.cursor="default"}});
b("#first"+b.jgrid.jqID(f)+", #prev"+b.jgrid.jqID(f)+", #next"+b.jgrid.jqID(f)+", #last"+b.jgrid.jqID(f)).click(function(){var w=M(a.p.page,1),r=M(a.p.lastpage,1),G=false,O=true,S=true,K=true,L=true;if(r===0||r===1)L=K=S=O=false;else if(r>1&&w>=1)if(w===1)S=O=false;else{if(w===r)L=K=false}else if(r>1&&w===0){L=K=false;w=r-1}if(this.id==="first"+f&&O){a.p.page=1;G=true}if(this.id==="prev"+f&&S){a.p.page=w-1;G=true}if(this.id==="next"+f&&K){a.p.page=w+1;G=true}if(this.id==="last"+f&&L){a.p.page=r;G=
true}if(G){if(!u(this.id))return false;ka()}return false})}a.p.pginput===true&&b("input.ui-pg-input","#"+C).keypress(function(w){if((w.charCode?w.charCode:w.keyCode?w.keyCode:0)==13){a.p.page=b(this).val()>0?b(this).val():a.p.page;if(!u("user"))return false;ka();return false}return this})};var Ea=function(e,f,j,m){if(a.p.colModel[f].sortable)if(!(a.p.savedRow.length>0)){if(!j){if(a.p.lastsort==f)if(a.p.sortorder=="asc")a.p.sortorder="desc";else{if(a.p.sortorder=="desc")a.p.sortorder="asc"}else a.p.sortorder=
a.p.colModel[f].firstsortorder||"asc";a.p.page=1}if(m)if(a.p.lastsort==f&&a.p.sortorder==m&&!j)return;else a.p.sortorder=m;j=a.grid.headers[a.p.lastsort].el;m=a.grid.headers[f].el;b("span.ui-grid-ico-sort",j).addClass("ui-state-disabled");b(j).attr("aria-selected","false");b("span.ui-icon-"+a.p.sortorder,m).removeClass("ui-state-disabled");b(m).attr("aria-selected","true");if(!a.p.viewsortcols[0])if(a.p.lastsort!=f){b("span.s-ico",j).hide();b("span.s-ico",m).show()}e=e.substring(5+a.p.id.length+1);
a.p.sortname=a.p.colModel[f].index||e;j=a.p.sortorder;if(b.isFunction(a.p.onSortCol))if(a.p.onSortCol.call(a,e,f,j)=="stop"){a.p.lastsort=f;return}if(a.p.datatype=="local")a.p.deselectAfterSort&&b(a).jqGrid("resetSelection");else{a.p.selrow=null;a.p.multiselect&&sa(false);a.p.selarrrow=[];a.p.savedRow=[]}if(a.p.scroll){j=a.grid.bDiv.scrollLeft;D(a.grid.bDiv,true,false);a.grid.hDiv.scrollLeft=j}a.p.subGrid&&a.p.datatype=="local"&&b("td.sgexpanded","#"+b.jgrid.jqID(a.p.id)).each(function(){b(this).trigger("click")});
ka();a.p.lastsort=f;if(a.p.sortname!=e&&f)a.p.lastsort=f}},Ia=function(e){var f,j={},m=E?0:a.p.cellLayout;for(f=j[0]=j[1]=j[2]=0;f<=e;f++)if(a.p.colModel[f].hidden===false)j[0]+=a.p.colModel[f].width+m;if(a.p.direction=="rtl")j[0]=a.p.width-j[0];j[0]-=a.grid.bDiv.scrollLeft;if(b(a.grid.cDiv).is(":visible"))j[1]+=b(a.grid.cDiv).height()+parseInt(b(a.grid.cDiv).css("padding-top"),10)+parseInt(b(a.grid.cDiv).css("padding-bottom"),10);if(a.p.toolbar[0]===true&&(a.p.toolbar[1]=="top"||a.p.toolbar[1]==
"both"))j[1]+=b(a.grid.uDiv).height()+parseInt(b(a.grid.uDiv).css("border-top-width"),10)+parseInt(b(a.grid.uDiv).css("border-bottom-width"),10);if(a.p.toppager)j[1]+=b(a.grid.topDiv).height()+parseInt(b(a.grid.topDiv).css("border-bottom-width"),10);j[2]+=b(a.grid.bDiv).height()+b(a.grid.hDiv).height();return j},Fa=function(e){var f,j=a.grid.headers,m=b.jgrid.getCellIndex(e);for(f=0;f<j.length;f++)if(e===j[f].el){m=f;break}return m};this.p.id=this.id;if(b.inArray(a.p.multikey,["shiftKey","altKey",
"ctrlKey"])==-1)a.p.multikey=false;a.p.keyIndex=false;for(k=0;k<a.p.colModel.length;k++){a.p.colModel[k]=b.extend(true,{},a.p.cmTemplate,a.p.colModel[k].template||{},a.p.colModel[k]);if(a.p.keyIndex===false&&a.p.colModel[k].key===true)a.p.keyIndex=k}a.p.sortorder=a.p.sortorder.toLowerCase();if(a.p.grouping===true){a.p.scroll=false;a.p.rownumbers=false;a.p.subGrid=false;a.p.treeGrid=false;a.p.gridview=true}if(this.p.treeGrid===true){try{b(this).jqGrid("setTreeGrid")}catch(Ma){}if(a.p.datatype!="local")a.p.localReader=
{id:"_id_"}}if(this.p.subGrid)try{b(a).jqGrid("setSubGrid")}catch(Na){}if(this.p.multiselect){this.p.colNames.unshift("<input role='checkbox' id='cb_"+this.p.id+"' class='cbox' type='checkbox'/>");this.p.colModel.unshift({name:"cb",width:E?a.p.multiselectWidth+a.p.cellLayout:a.p.multiselectWidth,sortable:false,resizable:false,hidedlg:true,search:false,align:"center",fixed:true})}if(this.p.rownumbers){this.p.colNames.unshift("");this.p.colModel.unshift({name:"rn",width:a.p.rownumWidth,sortable:false,
resizable:false,hidedlg:true,search:false,align:"center",fixed:true})}a.p.xmlReader=b.extend(true,{root:"rows",row:"row",page:"rows>page",total:"rows>total",records:"rows>records",repeatitems:true,cell:"cell",id:"[id]",userdata:"userdata",subgrid:{root:"rows",row:"row",repeatitems:true,cell:"cell"}},a.p.xmlReader);a.p.jsonReader=b.extend(true,{root:"rows",page:"page",total:"total",records:"records",repeatitems:true,cell:"cell",id:"id",userdata:"userdata",subgrid:{root:"rows",repeatitems:true,cell:"cell"}},
a.p.jsonReader);a.p.localReader=b.extend(true,{root:"rows",page:"page",total:"total",records:"records",repeatitems:false,cell:"cell",id:"id",userdata:"userdata",subgrid:{root:"rows",repeatitems:true,cell:"cell"}},a.p.localReader);if(a.p.scroll){a.p.pgbuttons=false;a.p.pginput=false;a.p.rowList=[]}a.p.data.length&&ca();var da="<thead><tr class='ui-jqgrid-labels' role='rowheader'>",Ga,na,ta,ra,ua,Y,Q,oa;na=oa="";if(a.p.shrinkToFit===true&&a.p.forceFit===true)for(k=a.p.colModel.length-1;k>=0;k--)if(!a.p.colModel[k].hidden){a.p.colModel[k].resizable=
false;break}if(a.p.viewsortcols[1]=="horizontal"){oa=" ui-i-asc";na=" ui-i-desc"}Ga=y?"class='ui-th-div-ie'":"";oa="<span class='s-ico' style='display:none'><span sort='asc' class='ui-grid-ico-sort ui-icon-asc"+oa+" ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-"+l+"'></span>";oa+="<span sort='desc' class='ui-grid-ico-sort ui-icon-desc"+na+" ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-"+l+"'></span></span>";for(k=0;k<this.p.colNames.length;k++){na=a.p.headertitles?' title="'+b.jgrid.stripHtml(a.p.colNames[k])+
'"':"";da+="<th id='"+a.p.id+"_"+a.p.colModel[k].name+"' role='columnheader' class='ui-state-default ui-th-column ui-th-"+l+"'"+na+">";na=a.p.colModel[k].index||a.p.colModel[k].name;da+="<div id='jqgh_"+a.p.id+"_"+a.p.colModel[k].name+"' "+Ga+">"+a.p.colNames[k];a.p.colModel[k].width=a.p.colModel[k].width?parseInt(a.p.colModel[k].width,10):150;if(typeof a.p.colModel[k].title!=="boolean")a.p.colModel[k].title=true;if(na==a.p.sortname)a.p.lastsort=k;da+=oa+"</div></th>"}da+="</tr></thead>";oa=null;
b(this).append(da);b("thead tr:first th",this).hover(function(){b(this).addClass("ui-state-hover")},function(){b(this).removeClass("ui-state-hover")});if(this.p.multiselect){var Aa=[],va;b("#cb_"+b.jgrid.jqID(a.p.id),this).bind("click",function(){a.p.selarrrow=[];var e=a.p.frozenColumns===true?a.p.id+"_frozen":"";if(this.checked){b(a.rows).each(function(f){if(f>0)if(!b(this).hasClass("ui-subgrid")&&!b(this).hasClass("jqgroup")&&!b(this).hasClass("ui-state-disabled")){b("#jqg_"+b.jgrid.jqID(a.p.id)+
"_"+b.jgrid.jqID(this.id))[a.p.useProp?"prop":"attr"]("checked",true);b(this).addClass("ui-state-highlight").attr("aria-selected","true");a.p.selarrrow.push(this.id);a.p.selrow=this.id;if(e){b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(this.id),a.grid.fbDiv)[a.p.useProp?"prop":"attr"]("checked",true);b("#"+b.jgrid.jqID(this.id),a.grid.fbDiv).addClass("ui-state-highlight")}}});va=true;Aa=[]}else{b(a.rows).each(function(f){if(f>0)if(!b(this).hasClass("ui-subgrid")&&!b(this).hasClass("ui-state-disabled")){b("#jqg_"+
b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(this.id))[a.p.useProp?"prop":"attr"]("checked",false);b(this).removeClass("ui-state-highlight").attr("aria-selected","false");Aa.push(this.id);if(e){b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(this.id),a.grid.fbDiv)[a.p.useProp?"prop":"attr"]("checked",false);b("#"+b.jgrid.jqID(this.id),a.grid.fbDiv).removeClass("ui-state-highlight")}}});a.p.selrow=null;va=false}if(b.isFunction(a.p.onSelectAll))a.p.onSelectAll.call(a,va?a.p.selarrrow:Aa,va)})}if(a.p.autowidth===
true){da=b(I).innerWidth();a.p.width=da>0?da:"nw"}(function(){var e=0,f=E?0:a.p.cellLayout,j=0,m,p=a.p.scrollOffset,C,s=false,A,z=0,u=0,w;b.each(a.p.colModel,function(){if(typeof this.hidden==="undefined")this.hidden=false;this.widthOrg=C=M(this.width,0);if(this.hidden===false){e+=C+f;if(this.fixed)z+=C+f;else j++;u++}});if(isNaN(a.p.width))a.p.width=h.width=e;else h.width=a.p.width;a.p.tblwidth=e;if(a.p.shrinkToFit===false&&a.p.forceFit===true)a.p.forceFit=false;if(a.p.shrinkToFit===true&&j>0){A=
h.width-f*j-z;if(!isNaN(a.p.height)){A-=p;s=true}e=0;b.each(a.p.colModel,function(r){if(this.hidden===false&&!this.fixed){this.width=C=Math.round(A*this.width/(a.p.tblwidth-f*j-z));e+=C;m=r}});w=0;if(s){if(h.width-z-(e+f*j)!==p)w=h.width-z-(e+f*j)-p}else if(!s&&Math.abs(h.width-z-(e+f*j))!==1)w=h.width-z-(e+f*j);a.p.colModel[m].width+=w;a.p.tblwidth=e+w+f*j+z;if(a.p.tblwidth>a.p.width){a.p.colModel[m].width-=a.p.tblwidth-parseInt(a.p.width,10);a.p.tblwidth=a.p.width}}})();b(I).css("width",h.width+
"px").append("<div class='ui-jqgrid-resize-mark' id='rs_m"+a.p.id+"'>&#160;</div>");b(q).css("width",h.width+"px");da=b("thead:first",a).get(0);var wa="";if(a.p.footerrow)wa+="<table role='grid' style='width:"+a.p.tblwidth+"px' class='ui-jqgrid-ftable' cellspacing='0' cellpadding='0' border='0'><tbody><tr role='row' class='ui-widget-content footrow footrow-"+l+"'>";q=b("tr:first",da);var xa="<tr class='jqgfirstrow' role='row' style='height:auto'>";a.p.disableClick=false;b("th",q).each(function(e){ta=
a.p.colModel[e].width;if(typeof a.p.colModel[e].resizable==="undefined")a.p.colModel[e].resizable=true;if(a.p.colModel[e].resizable){ra=document.createElement("span");b(ra).html("&#160;").addClass("ui-jqgrid-resize ui-jqgrid-resize-"+l);b.browser.opera||b(ra).css("cursor","col-resize");b(this).addClass(a.p.resizeclass)}else ra="";b(this).css("width",ta+"px").prepend(ra);var f="";if(a.p.colModel[e].hidden){b(this).css("display","none");f="display:none;"}xa+="<td role='gridcell' style='height:0px;width:"+
ta+"px;"+f+"'></td>";h.headers[e]={width:ta,el:this};ua=a.p.colModel[e].sortable;if(typeof ua!=="boolean")ua=a.p.colModel[e].sortable=true;f=a.p.colModel[e].name;f=="cb"||f=="subgrid"||f=="rn"||a.p.viewsortcols[2]&&b(">div",this).addClass("ui-jqgrid-sortable");if(ua)if(a.p.viewsortcols[0]){b("div span.s-ico",this).show();e==a.p.lastsort&&b("div span.ui-icon-"+a.p.sortorder,this).removeClass("ui-state-disabled")}else if(e==a.p.lastsort){b("div span.s-ico",this).show();b("div span.ui-icon-"+a.p.sortorder,
this).removeClass("ui-state-disabled")}if(a.p.footerrow)wa+="<td role='gridcell' "+N(e,0,"",null,"",false)+">&#160;</td>"}).mousedown(function(e){if(b(e.target).closest("th>span.ui-jqgrid-resize").length==1){var f=Fa(this);if(a.p.forceFit===true){var j=a.p,m=f,p;for(p=f+1;p<a.p.colModel.length;p++)if(a.p.colModel[p].hidden!==true){m=p;break}j.nv=m-f}h.dragStart(f,e,Ia(f));return false}}).click(function(e){if(a.p.disableClick)return a.p.disableClick=false;var f="th>div.ui-jqgrid-sortable",j,m;a.p.viewsortcols[2]||
(f="th>div>span>span.ui-grid-ico-sort");e=b(e.target).closest(f);if(e.length==1){f=Fa(this);if(!a.p.viewsortcols[2]){j=true;m=e.attr("sort")}Ea(b("div",this)[0].id,f,j,m);return false}});if(a.p.sortable&&b.fn.sortable)try{b(a).jqGrid("sortableColumns",q)}catch(Oa){}if(a.p.footerrow)wa+="</tr></tbody></table>";xa+="</tr>";this.appendChild(document.createElement("tbody"));b(this).addClass("ui-jqgrid-btable").append(xa);xa=null;q=b("<table class='ui-jqgrid-htable' style='width:"+a.p.tblwidth+"px' role='grid' aria-labelledby='gbox_"+
this.id+"' cellspacing='0' cellpadding='0' border='0'></table>").append(da);var ea=a.p.caption&&a.p.hiddengrid===true?true:false;k=b("<div class='ui-jqgrid-hbox"+(l=="rtl"?"-rtl":"")+"'></div>");da=null;h.hDiv=document.createElement("div");b(h.hDiv).css({width:h.width+"px"}).addClass("ui-state-default ui-jqgrid-hdiv").append(k);b(k).append(q);q=null;ea&&b(h.hDiv).hide();if(a.p.pager){if(typeof a.p.pager=="string"){if(a.p.pager.substr(0,1)!="#")a.p.pager="#"+a.p.pager}else a.p.pager="#"+b(a.p.pager).attr("id");
b(a.p.pager).css({width:h.width+"px"}).appendTo(I).addClass("ui-state-default ui-jqgrid-pager ui-corner-bottom");ea&&b(a.p.pager).hide();x(a.p.pager,"")}a.p.cellEdit===false&&a.p.hoverrows===true&&b(a).bind("mouseover",function(e){Q=b(e.target).closest("tr.jqgrow");b(Q).attr("class")!=="ui-subgrid"&&b(Q).addClass("ui-state-hover")}).bind("mouseout",function(e){Q=b(e.target).closest("tr.jqgrow");b(Q).removeClass("ui-state-hover")});var la,ma;b(a).before(h.hDiv).click(function(e){Y=e.target;Q=b(Y,a.rows).closest("tr.jqgrow");
if(b(Q).length===0||Q[0].className.indexOf("ui-state-disabled")>-1||b(Y,a).closest("table.ui-jqgrid-btable")[0].id.replace("_frozen","")!==a.id)return this;var f=b(Y).hasClass("cbox"),j=true;if(b.isFunction(a.p.beforeSelectRow))j=a.p.beforeSelectRow.call(a,Q[0].id,e);if(Y.tagName=="A"||(Y.tagName=="INPUT"||Y.tagName=="TEXTAREA"||Y.tagName=="OPTION"||Y.tagName=="SELECT")&&!f)return this;if(j===true){if(a.p.cellEdit===true)if(a.p.multiselect&&f)b(a).jqGrid("setSelection",Q[0].id,true);else{la=Q[0].rowIndex;
ma=b.jgrid.getCellIndex(Y);try{b(a).jqGrid("editCell",la,ma,true)}catch(m){}}else if(a.p.multikey)if(e[a.p.multikey])b(a).jqGrid("setSelection",Q[0].id,true);else{if(a.p.multiselect&&f){f=b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+Q[0].id).is(":checked");b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+Q[0].id)[a.p.useProp?"prop":"attr"]("checked",f)}}else{if(a.p.multiselect&&a.p.multiboxonly)if(!f){var p=a.p.frozenColumns?a.p.id+"_frozen":"";b(a.p.selarrrow).each(function(C,s){var A=a.rows.namedItem(s);b(A).removeClass("ui-state-highlight");
b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(s))[a.p.useProp?"prop":"attr"]("checked",false);if(p){b("#"+b.jgrid.jqID(s),"#"+b.jgrid.jqID(p)).removeClass("ui-state-highlight");b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(s),"#"+b.jgrid.jqID(p))[a.p.useProp?"prop":"attr"]("checked",false)}});a.p.selarrrow=[]}b(a).jqGrid("setSelection",Q[0].id,true)}if(b.isFunction(a.p.onCellSelect)){la=Q[0].id;ma=b.jgrid.getCellIndex(Y);a.p.onCellSelect.call(a,la,ma,b(Y).html(),e)}}return this}).bind("reloadGrid",
function(e,f){if(a.p.treeGrid===true)a.p.datatype=a.p.treedatatype;f&&f.current&&a.grid.selectionPreserver(a);if(a.p.datatype=="local"){b(a).jqGrid("resetSelection");a.p.data.length&&ca()}else if(!a.p.treeGrid){a.p.selrow=null;if(a.p.multiselect){a.p.selarrrow=[];sa(false)}a.p.savedRow=[]}a.p.scroll&&D(a.grid.bDiv,true,false);if(f&&f.page){var j=f.page;if(j>a.p.lastpage)j=a.p.lastpage;if(j<1)j=1;a.p.page=j;a.grid.bDiv.scrollTop=a.grid.prevRowHeight?(j-1)*a.grid.prevRowHeight*a.p.rowNum:0}if(a.grid.prevRowHeight&&
a.p.scroll){delete a.p.lastpage;a.grid.populateVisible()}else a.grid.populate();return false});b.isFunction(this.p.ondblClickRow)&&b(this).dblclick(function(e){Y=e.target;Q=b(Y,a.rows).closest("tr.jqgrow");if(b(Q).length===0)return false;la=Q[0].rowIndex;ma=b.jgrid.getCellIndex(Y);a.p.ondblClickRow.call(a,b(Q).attr("id"),la,ma,e);return false});b.isFunction(this.p.onRightClickRow)&&b(this).bind("contextmenu",function(e){Y=e.target;Q=b(Y,a.rows).closest("tr.jqgrow");if(b(Q).length===0)return false;
a.p.multiselect||b(a).jqGrid("setSelection",Q[0].id,true);la=Q[0].rowIndex;ma=b.jgrid.getCellIndex(Y);a.p.onRightClickRow.call(a,b(Q).attr("id"),la,ma,e);return false});h.bDiv=document.createElement("div");if(y)if(String(a.p.height).toLowerCase()==="auto")a.p.height="100%";b(h.bDiv).append(b('<div style="position:relative;'+(y&&b.browser.version<8?"height:0.01%;":"")+'"></div>').append("<div></div>").append(this)).addClass("ui-jqgrid-bdiv").css({height:a.p.height+(isNaN(a.p.height)?"":"px"),width:h.width+
"px"}).scroll(h.scrollGrid);b("table:first",h.bDiv).css({width:a.p.tblwidth+"px"});if(y){b("tbody",this).size()==2&&b("tbody:gt(0)",this).remove();a.p.multikey&&b(h.bDiv).bind("selectstart",function(){return false})}else a.p.multikey&&b(h.bDiv).bind("mousedown",function(){return false});ea&&b(h.bDiv).hide();h.cDiv=document.createElement("div");var Ba=a.p.hidegrid===true?b("<a role='link' href='javascript:void(0)'/>").addClass("ui-jqgrid-titlebar-close HeaderButton").hover(function(){Ba.addClass("ui-state-hover")},
function(){Ba.removeClass("ui-state-hover")}).append("<span class='ui-icon ui-icon-circle-triangle-n'></span>").css(l=="rtl"?"left":"right","0px"):"";b(h.cDiv).append(Ba).append("<span class='ui-jqgrid-title"+(l=="rtl"?"-rtl":"")+"'>"+a.p.caption+"</span>").addClass("ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix");b(h.cDiv).insertBefore(h.hDiv);if(a.p.toolbar[0]){h.uDiv=document.createElement("div");if(a.p.toolbar[1]=="top")b(h.uDiv).insertBefore(h.hDiv);else a.p.toolbar[1]==
"bottom"&&b(h.uDiv).insertAfter(h.hDiv);if(a.p.toolbar[1]=="both"){h.ubDiv=document.createElement("div");b(h.uDiv).insertBefore(h.hDiv).addClass("ui-userdata ui-state-default").attr("id","t_"+this.id);b(h.ubDiv).insertAfter(h.hDiv).addClass("ui-userdata ui-state-default").attr("id","tb_"+this.id);ea&&b(h.ubDiv).hide()}else b(h.uDiv).width(h.width).addClass("ui-userdata ui-state-default").attr("id","t_"+this.id);ea&&b(h.uDiv).hide()}if(a.p.toppager){a.p.toppager=b.jgrid.jqID(a.p.id)+"_toppager";h.topDiv=
b("<div id='"+a.p.toppager+"'></div>")[0];a.p.toppager="#"+a.p.toppager;b(h.topDiv).insertBefore(h.hDiv).addClass("ui-state-default ui-jqgrid-toppager").width(h.width);x(a.p.toppager,"_t")}if(a.p.footerrow){h.sDiv=b("<div class='ui-jqgrid-sdiv'></div>")[0];k=b("<div class='ui-jqgrid-hbox"+(l=="rtl"?"-rtl":"")+"'></div>");b(h.sDiv).append(k).insertAfter(h.hDiv).width(h.width);b(k).append(wa);h.footers=b(".ui-jqgrid-ftable",h.sDiv)[0].rows[0].cells;if(a.p.rownumbers)h.footers[0].className="ui-state-default jqgrid-rownum";
ea&&b(h.sDiv).hide()}k=null;if(a.p.caption){var Ja=a.p.datatype;if(a.p.hidegrid===true){b(".ui-jqgrid-titlebar-close",h.cDiv).click(function(e){var f=b.isFunction(a.p.onHeaderClick),j=".ui-jqgrid-bdiv, .ui-jqgrid-hdiv, .ui-jqgrid-pager, .ui-jqgrid-sdiv",m,p=this;if(a.p.toolbar[0]===true){if(a.p.toolbar[1]=="both")j+=", #"+b(h.ubDiv).attr("id");j+=", #"+b(h.uDiv).attr("id")}m=b(j,"#gview_"+b.jgrid.jqID(a.p.id)).length;if(a.p.gridstate=="visible")b(j,"#gbox_"+b.jgrid.jqID(a.p.id)).slideUp("fast",function(){m--;
if(m===0){b("span",p).removeClass("ui-icon-circle-triangle-n").addClass("ui-icon-circle-triangle-s");a.p.gridstate="hidden";b("#gbox_"+b.jgrid.jqID(a.p.id)).hasClass("ui-resizable")&&b(".ui-resizable-handle","#gbox_"+b.jgrid.jqID(a.p.id)).hide();if(f)ea||a.p.onHeaderClick.call(a,a.p.gridstate,e)}});else a.p.gridstate=="hidden"&&b(j,"#gbox_"+b.jgrid.jqID(a.p.id)).slideDown("fast",function(){m--;if(m===0){b("span",p).removeClass("ui-icon-circle-triangle-s").addClass("ui-icon-circle-triangle-n");if(ea){a.p.datatype=
Ja;ka();ea=false}a.p.gridstate="visible";b("#gbox_"+b.jgrid.jqID(a.p.id)).hasClass("ui-resizable")&&b(".ui-resizable-handle","#gbox_"+b.jgrid.jqID(a.p.id)).show();if(f)ea||a.p.onHeaderClick.call(a,a.p.gridstate,e)}});return false});if(ea){a.p.datatype="local";b(".ui-jqgrid-titlebar-close",h.cDiv).trigger("click")}}}else b(h.cDiv).hide();b(h.hDiv).after(h.bDiv).mousemove(function(e){if(h.resizing){h.dragMove(e);return false}});b(".ui-jqgrid-labels",h.hDiv).bind("selectstart",function(){return false});
b(document).mouseup(function(){if(h.resizing){h.dragEnd();return false}return true});a.formatCol=N;a.sortData=Ea;a.updatepager=function(e,f){var j,m,p,C,s,A,z,u="",w=a.p.pager?"_"+b.jgrid.jqID(a.p.pager.substr(1)):"",r=a.p.toppager?"_"+a.p.toppager.substr(1):"";p=parseInt(a.p.page,10)-1;if(p<0)p=0;p*=parseInt(a.p.rowNum,10);s=p+a.p.reccount;if(a.p.scroll){j=b("tbody:first > tr:gt(0)",a.grid.bDiv);p=s-j.length;a.p.reccount=j.length;if(m=j.outerHeight()||a.grid.prevRowHeight){j=p*m;m*=parseInt(a.p.records,
10);b(">div:first",a.grid.bDiv).css({height:m}).children("div:first").css({height:j,display:j?"":"none"})}a.grid.bDiv.scrollLeft=a.grid.hDiv.scrollLeft}u=a.p.pager?a.p.pager:"";u+=a.p.toppager?u?","+a.p.toppager:a.p.toppager:"";if(u){z=b.jgrid.formatter.integer||{};j=M(a.p.page);m=M(a.p.lastpage);b(".selbox",u)[this.p.useProp?"prop":"attr"]("disabled",false);if(a.p.pginput===true){b(".ui-pg-input",u).val(a.p.page);C=a.p.toppager?"#sp_1"+w+",#sp_1"+r:"#sp_1"+w;b(C).html(b.fmatter?b.fmatter.util.NumberFormat(a.p.lastpage,
z):a.p.lastpage)}if(a.p.viewrecords)if(a.p.reccount===0)b(".ui-paging-info",u).html(a.p.emptyrecords);else{C=p+1;A=a.p.records;if(b.fmatter){C=b.fmatter.util.NumberFormat(C,z);s=b.fmatter.util.NumberFormat(s,z);A=b.fmatter.util.NumberFormat(A,z)}b(".ui-paging-info",u).html(b.jgrid.format(a.p.recordtext,C,s,A))}if(a.p.pgbuttons===true){if(j<=0)j=m=0;if(j==1||j===0){b("#first"+w+", #prev"+w).addClass("ui-state-disabled").removeClass("ui-state-hover");a.p.toppager&&b("#first_t"+r+", #prev_t"+r).addClass("ui-state-disabled").removeClass("ui-state-hover")}else{b("#first"+
w+", #prev"+w).removeClass("ui-state-disabled");a.p.toppager&&b("#first_t"+r+", #prev_t"+r).removeClass("ui-state-disabled")}if(j==m||j===0){b("#next"+w+", #last"+w).addClass("ui-state-disabled").removeClass("ui-state-hover");a.p.toppager&&b("#next_t"+r+", #last_t"+r).addClass("ui-state-disabled").removeClass("ui-state-hover")}else{b("#next"+w+", #last"+w).removeClass("ui-state-disabled");a.p.toppager&&b("#next_t"+r+", #last_t"+r).removeClass("ui-state-disabled")}}}e===true&&a.p.rownumbers===true&&
b("td.jqgrid-rownum",a.rows).each(function(G){b(this).html(p+1+G)});f&&a.p.jqgdnd&&b(a).jqGrid("gridDnD","updateDnD");b.isFunction(a.p.gridComplete)&&a.p.gridComplete.call(a);b.isFunction(a.p._complete)&&a.p._complete.call(a)};a.refreshIndex=ca;a.setHeadCheckBox=sa;a.formatter=function(e,f,j,m,p){return o(e,f,j,m,p)};b.extend(h,{populate:ka,emptyRows:D});this.grid=h;a.addXmlData=function(e){X(e,a.grid.bDiv)};a.addJSONData=function(e){fa(e,a.grid.bDiv)};this.grid.cols=this.rows[0].cells;ka();a.p.hiddengrid=
false;b(window).unload(function(){a=null})}}}})};b.jgrid.extend({getGridParam:function(d){var i=this[0];if(i&&i.grid)return d?typeof i.p[d]!="undefined"?i.p[d]:null:i.p},setGridParam:function(d){return this.each(function(){this.grid&&typeof d==="object"&&b.extend(true,this.p,d)})},getDataIDs:function(){var d=[],i=0,g,c=0;this.each(function(){if((g=this.rows.length)&&g>0)for(;i<g;){if(b(this.rows[i]).hasClass("jqgrow")){d[c]=this.rows[i].id;c++}i++}});return d},setSelection:function(d,i){return this.each(function(){function g(x){var y=
b(c.grid.bDiv)[0].clientHeight,E=b(c.grid.bDiv)[0].scrollTop,I=c.rows[x].offsetTop;x=c.rows[x].clientHeight;if(I+x>=y+E)b(c.grid.bDiv)[0].scrollTop=I-(y+E)+x+E;else if(I<y+E)if(I<E)b(c.grid.bDiv)[0].scrollTop=I}var c=this,h,k,l,a,q;if(d!==undefined){i=i===false?false:true;k=c.rows.namedItem(d+"");if(!(!k||!k.className||k.className.indexOf("ui-state-disabled")>-1)){if(c.p.scrollrows===true){h=c.rows.namedItem(d).rowIndex;h>=0&&g(h)}if(c.p.frozenColumns===true)q=c.p.id+"_frozen";if(c.p.multiselect){c.setHeadCheckBox(false);
c.p.selrow=k.id;l=b.inArray(c.p.selrow,c.p.selarrrow);if(l===-1){k.className!=="ui-subgrid"&&b(k).addClass("ui-state-highlight").attr("aria-selected","true");h=true;b("#jqg_"+b.jgrid.jqID(c.p.id)+"_"+b.jgrid.jqID(c.p.selrow))[c.p.useProp?"prop":"attr"]("checked",h);c.p.selarrrow.push(c.p.selrow)}else{k.className!=="ui-subgrid"&&b(k).removeClass("ui-state-highlight").attr("aria-selected","false");h=false;b("#jqg_"+b.jgrid.jqID(c.p.id)+"_"+b.jgrid.jqID(c.p.selrow))[c.p.useProp?"prop":"attr"]("checked",
h);c.p.selarrrow.splice(l,1);a=c.p.selarrrow[0];c.p.selrow=a===undefined?null:a}if(q){l===-1?b("#"+b.jgrid.jqID(d),"#"+b.jgrid.jqID(q)).addClass("ui-state-highlight"):b("#"+b.jgrid.jqID(d),"#"+b.jgrid.jqID(q)).removeClass("ui-state-highlight");b("#jqg_"+b.jgrid.jqID(c.p.id)+"_"+b.jgrid.jqID(d),"#"+b.jgrid.jqID(q))[c.p.useProp?"prop":"attr"]("checked",h)}c.p.onSelectRow&&i&&c.p.onSelectRow.call(c,k.id,h)}else if(k.className!=="ui-subgrid"){if(c.p.selrow!=k.id){b(c.rows.namedItem(c.p.selrow)).removeClass("ui-state-highlight").attr({"aria-selected":"false",
tabindex:"-1"});b(k).addClass("ui-state-highlight").attr({"aria-selected":"true",tabindex:"0"});if(q){b("#"+b.jgrid.jqID(c.p.selrow),"#"+b.jgrid.jqID(q)).removeClass("ui-state-highlight");b("#"+b.jgrid.jqID(d),"#"+b.jgrid.jqID(q)).addClass("ui-state-highlight")}h=true}else h=false;c.p.selrow=k.id;c.p.onSelectRow&&i&&c.p.onSelectRow.call(c,k.id,h)}}}})},resetSelection:function(d){return this.each(function(){var i=this,g,c;if(typeof d!=="undefined"){c=d===i.p.selrow?i.p.selrow:d;b("#"+b.jgrid.jqID(i.p.id)+
" tbody:first tr#"+b.jgrid.jqID(c)).removeClass("ui-state-highlight").attr("aria-selected","false");if(i.p.multiselect){b("#jqg_"+b.jgrid.jqID(i.p.id)+"_"+b.jgrid.jqID(c))[i.p.useProp?"prop":"attr"]("checked",false);i.setHeadCheckBox(false)}c=null}else if(i.p.multiselect){b(i.p.selarrrow).each(function(h,k){g=i.rows.namedItem(k);b(g).removeClass("ui-state-highlight").attr("aria-selected","false");b("#jqg_"+b.jgrid.jqID(i.p.id)+"_"+b.jgrid.jqID(k))[i.p.useProp?"prop":"attr"]("checked",false)});i.setHeadCheckBox(false);
i.p.selarrrow=[]}else if(i.p.selrow){b("#"+b.jgrid.jqID(i.p.id)+" tbody:first tr#"+b.jgrid.jqID(i.p.selrow)).removeClass("ui-state-highlight").attr("aria-selected","false");i.p.selrow=null}if(i.p.cellEdit===true)if(parseInt(i.p.iCol,10)>=0&&parseInt(i.p.iRow,10)>=0){b("td:eq("+i.p.iCol+")",i.rows[i.p.iRow]).removeClass("edit-cell ui-state-highlight");b(i.rows[i.p.iRow]).removeClass("selected-row ui-state-hover")}i.p.savedRow=[]})},getRowData:function(d){var i={},g,c=false,h,k=0;this.each(function(){var l=
this,a,q;if(typeof d=="undefined"){c=true;g=[];h=l.rows.length}else{q=l.rows.namedItem(d);if(!q)return i;h=2}for(;k<h;){if(c)q=l.rows[k];if(b(q).hasClass("jqgrow")){b("td",q).each(function(x){a=l.p.colModel[x].name;if(a!=="cb"&&a!=="subgrid"&&a!=="rn")if(l.p.treeGrid===true&&a==l.p.ExpandColumn)i[a]=b.jgrid.htmlDecode(b("span:first",this).html());else try{i[a]=b.unformat(this,{rowId:q.id,colModel:l.p.colModel[x]},x)}catch(y){i[a]=b.jgrid.htmlDecode(b(this).html())}});if(c){g.push(i);i={}}}k++}});
return g?g:i},delRowData:function(d){var i=false,g,c;this.each(function(){if(g=this.rows.namedItem(d)){b(g).remove();this.p.records--;this.p.reccount--;this.updatepager(true,false);i=true;if(this.p.multiselect){c=b.inArray(d,this.p.selarrrow);c!=-1&&this.p.selarrrow.splice(c,1)}if(d==this.p.selrow)this.p.selrow=null}else return false;if(this.p.datatype=="local"){var h=this.p._index[d];if(typeof h!="undefined"){this.p.data.splice(h,1);this.refreshIndex()}}if(this.p.altRows===true&&i){var k=this.p.altclass;
b(this.rows).each(function(l){l%2==1?b(this).addClass(k):b(this).removeClass(k)})}});return i},setRowData:function(d,i,g){var c,h=true,k;this.each(function(){if(!this.grid)return false;var l=this,a,q,x=typeof g,y={};q=l.rows.namedItem(d);if(!q)return false;if(i)try{b(this.p.colModel).each(function(N){c=this.name;if(i[c]!==undefined){y[c]=this.formatter&&typeof this.formatter==="string"&&this.formatter=="date"?b.unformat.date(i[c],this):i[c];a=l.formatter(d,i[c],N,i,"edit");k=this.title?{title:b.jgrid.stripHtml(a)}:
{};l.p.treeGrid===true&&c==l.p.ExpandColumn?b("td:eq("+N+") > span:first",q).html(a).attr(k):b("td:eq("+N+")",q).html(a).attr(k)}});if(l.p.datatype=="local"){var E=l.p._index[d];if(l.p.treeGrid)for(var I in l.p.treeReader)y.hasOwnProperty(l.p.treeReader[I])&&delete y[l.p.treeReader[I]];if(typeof E!="undefined")l.p.data[E]=b.extend(true,l.p.data[E],y);y=null}}catch(M){h=false}if(h){if(x==="string")b(q).addClass(g);else x==="object"&&b(q).css(g);b.isFunction(l.p._complete)&&l.p._complete.call(l)}});
return h},addRowData:function(d,i,g,c){g||(g="last");var h=false,k,l,a,q,x,y,E,I,M="",N,V,o,n,t;if(i){if(b.isArray(i)){N=true;g="last";V=d}else{i=[i];N=false}this.each(function(){var F=i.length;x=this.p.rownumbers===true?1:0;a=this.p.multiselect===true?1:0;q=this.p.subGrid===true?1:0;if(!N)if(typeof d!="undefined")d+="";else{d=b.jgrid.randId();if(this.p.keyIndex!==false){V=this.p.colModel[this.p.keyIndex+a+q+x].name;if(typeof i[0][V]!="undefined")d=i[0][V]}}o=this.p.altclass;for(var T=0,J="",D={},
ca=b.isFunction(this.p.afterInsertRow)?true:false;T<F;){n=i[T];l="";if(N){try{d=n[V]}catch(X){d=b.jgrid.randId()}J=this.p.altRows===true?(this.rows.length-1)%2===0?o:"":""}d=this.p.idPrefix+d;if(x){M=this.formatCol(0,1,"",null,d,true);l+='<td role="gridcell" aria-describedby="'+this.p.id+'_rn" class="ui-state-default jqgrid-rownum" '+M+">0</td>"}if(a){I='<input role="checkbox" type="checkbox" id="jqg_'+this.p.id+"_"+d+'" class="cbox"/>';M=this.formatCol(x,1,"",null,d,true);l+='<td role="gridcell" aria-describedby="'+
this.p.id+'_cb" '+M+">"+I+"</td>"}if(q)l+=b(this).jqGrid("addSubGridCell",a+x,1);for(E=a+q+x;E<this.p.colModel.length;E++){t=this.p.colModel[E];k=t.name;D[k]=t.formatter&&typeof t.formatter==="string"&&t.formatter=="date"?b.unformat.date(n[k],t):n[k];I=this.formatter(d,b.jgrid.getAccessor(n,k),E,n,"edit");M=this.formatCol(E,1,I,n,d,true);l+='<td role="gridcell" aria-describedby="'+this.p.id+"_"+k+'" '+M+">"+I+"</td>"}l='<tr id="'+d+'" role="row" tabindex="-1" class="ui-widget-content jqgrow ui-row-'+
this.p.direction+" "+J+'">'+l+"</tr>";if(this.rows.length===0)b("table:first",this.grid.bDiv).append(l);else switch(g){case "last":b(this.rows[this.rows.length-1]).after(l);y=this.rows.length-1;break;case "first":b(this.rows[0]).after(l);y=1;break;case "after":if(y=this.rows.namedItem(c))b(this.rows[y.rowIndex+1]).hasClass("ui-subgrid")?b(this.rows[y.rowIndex+1]).after(l):b(y).after(l);y++;break;case "before":if(y=this.rows.namedItem(c)){b(y).before(l);y=y.rowIndex}y--}this.p.subGrid===true&&b(this).jqGrid("addSubGrid",
a+x,y);this.p.records++;this.p.reccount++;ca&&this.p.afterInsertRow.call(this,d,n,n);T++;if(this.p.datatype=="local"){D[this.p.localReader.id]=d;this.p._index[d]=this.p.data.length;this.p.data.push(D);D={}}}if(this.p.altRows===true&&!N)if(g=="last")(this.rows.length-1)%2==1&&b(this.rows[this.rows.length-1]).addClass(o);else b(this.rows).each(function(fa){fa%2==1?b(this).addClass(o):b(this).removeClass(o)});this.updatepager(true,true);h=true})}return h},footerData:function(d,i,g){function c(q){for(var x in q)if(q.hasOwnProperty(x))return false;
return true}var h,k=false,l={},a;if(typeof d=="undefined")d="get";if(typeof g!="boolean")g=true;d=d.toLowerCase();this.each(function(){var q=this,x;if(!q.grid||!q.p.footerrow)return false;if(d=="set")if(c(i))return false;k=true;b(this.p.colModel).each(function(y){h=this.name;if(d=="set"){if(i[h]!==undefined){x=g?q.formatter("",i[h],y,i,"edit"):i[h];a=this.title?{title:b.jgrid.stripHtml(x)}:{};b("tr.footrow td:eq("+y+")",q.grid.sDiv).html(x).attr(a);k=true}}else if(d=="get")l[h]=b("tr.footrow td:eq("+
y+")",q.grid.sDiv).html()})});return d=="get"?l:k},showHideCol:function(d,i){return this.each(function(){var g=this,c=false,h=b.browser.webkit||b.browser.safari?0:g.p.cellLayout,k;if(g.grid){if(typeof d==="string")d=[d];i=i!="none"?"":"none";var l=i===""?true:false,a=g.p.groupHeader&&(typeof g.p.groupHeader==="object"||b.isFunction(g.p.groupHeader));a&&b(g).jqGrid("destroyGroupHeader",false);b(this.p.colModel).each(function(q){if(b.inArray(this.name,d)!==-1&&this.hidden===l){if(g.p.frozenColumns===
true&&this.frozen===true)return true;b("tr",g.grid.hDiv).each(function(){b(this.cells[q]).css("display",i)});b(g.rows).each(function(){b(this.cells[q]).css("display",i)});g.p.footerrow&&b("tr.footrow td:eq("+q+")",g.grid.sDiv).css("display",i);k=this.widthOrg?this.widthOrg:parseInt(this.width,10);if(i==="none")g.p.tblwidth-=k+h;else g.p.tblwidth+=k+h;this.hidden=!l;c=true}});if(c===true)b(g).jqGrid("setGridWidth",g.p.shrinkToFit===true?g.p.tblwidth:g.p.width);a&&b(g).jqGrid("setGroupHeaders",g.p.groupHeader)}})},
hideCol:function(d){return this.each(function(){b(this).jqGrid("showHideCol",d,"none")})},showCol:function(d){return this.each(function(){b(this).jqGrid("showHideCol",d,"")})},remapColumns:function(d,i,g){function c(l){var a;a=l.length?b.makeArray(l):b.extend({},l);b.each(d,function(q){l[q]=a[this]})}function h(l,a){b(">tr"+(a||""),l).each(function(){var q=this,x=b.makeArray(q.cells);b.each(d,function(){var y=x[this];y&&q.appendChild(y)})})}var k=this.get(0);c(k.p.colModel);c(k.p.colNames);c(k.grid.headers);
h(b("thead:first",k.grid.hDiv),g&&":not(.ui-jqgrid-labels)");i&&h(b("#"+b.jgrid.jqID(k.p.id)+" tbody:first"),".jqgfirstrow, tr.jqgrow, tr.jqfoot");k.p.footerrow&&h(b("tbody:first",k.grid.sDiv));if(k.p.remapColumns)if(k.p.remapColumns.length)c(k.p.remapColumns);else k.p.remapColumns=b.makeArray(d);k.p.lastsort=b.inArray(k.p.lastsort,d);if(k.p.treeGrid)k.p.expColInd=b.inArray(k.p.expColInd,d)},setGridWidth:function(d,i){return this.each(function(){if(this.grid){var g=this,c,h=0,k=b.browser.webkit||
b.browser.safari?0:g.p.cellLayout,l,a=0,q=false,x=g.p.scrollOffset,y,E=0,I=0,M;if(typeof i!="boolean")i=g.p.shrinkToFit;if(!isNaN(d)){d=parseInt(d,10);g.grid.width=g.p.width=d;b("#gbox_"+b.jgrid.jqID(g.p.id)).css("width",d+"px");b("#gview_"+b.jgrid.jqID(g.p.id)).css("width",d+"px");b(g.grid.bDiv).css("width",d+"px");b(g.grid.hDiv).css("width",d+"px");g.p.pager&&b(g.p.pager).css("width",d+"px");g.p.toppager&&b(g.p.toppager).css("width",d+"px");if(g.p.toolbar[0]===true){b(g.grid.uDiv).css("width",d+
"px");g.p.toolbar[1]=="both"&&b(g.grid.ubDiv).css("width",d+"px")}g.p.footerrow&&b(g.grid.sDiv).css("width",d+"px");if(i===false&&g.p.forceFit===true)g.p.forceFit=false;if(i===true){b.each(g.p.colModel,function(){if(this.hidden===false){c=this.widthOrg?this.widthOrg:parseInt(this.width,10);h+=c+k;if(this.fixed)E+=c+k;else a++;I++}});if(a===0)return;g.p.tblwidth=h;y=d-k*a-E;if(!isNaN(g.p.height))if(b(g.grid.bDiv)[0].clientHeight<b(g.grid.bDiv)[0].scrollHeight||g.rows.length===1){q=true;y-=x}h=0;var N=
g.grid.cols.length>0;b.each(g.p.colModel,function(V){if(this.hidden===false&&!this.fixed){c=this.widthOrg?this.widthOrg:parseInt(this.width,10);c=Math.round(y*c/(g.p.tblwidth-k*a-E));if(!(c<0)){this.width=c;h+=c;g.grid.headers[V].width=c;g.grid.headers[V].el.style.width=c+"px";if(g.p.footerrow)g.grid.footers[V].style.width=c+"px";if(N)g.grid.cols[V].style.width=c+"px";l=V}}});if(!l)return;M=0;if(q){if(d-E-(h+k*a)!==x)M=d-E-(h+k*a)-x}else if(Math.abs(d-E-(h+k*a))!==1)M=d-E-(h+k*a);g.p.colModel[l].width+=
M;g.p.tblwidth=h+M+k*a+E;if(g.p.tblwidth>d){q=g.p.tblwidth-parseInt(d,10);g.p.tblwidth=d;c=g.p.colModel[l].width-=q}else c=g.p.colModel[l].width;g.grid.headers[l].width=c;g.grid.headers[l].el.style.width=c+"px";if(N)g.grid.cols[l].style.width=c+"px";if(g.p.footerrow)g.grid.footers[l].style.width=c+"px"}if(g.p.tblwidth){b("table:first",g.grid.bDiv).css("width",g.p.tblwidth+"px");b("table:first",g.grid.hDiv).css("width",g.p.tblwidth+"px");g.grid.hDiv.scrollLeft=g.grid.bDiv.scrollLeft;g.p.footerrow&&
b("table:first",g.grid.sDiv).css("width",g.p.tblwidth+"px")}}}})},setGridHeight:function(d){return this.each(function(){if(this.grid){var i=b(this.grid.bDiv);i.css({height:d+(isNaN(d)?"":"px")});this.p.frozenColumns===true&&b("#"+this.p.id+"_frozen").parent().height(i.height()-16);this.p.height=d;this.p.scroll&&this.grid.populateVisible()}})},setCaption:function(d){return this.each(function(){this.p.caption=d;b("span.ui-jqgrid-title, span.ui-jqgrid-title-rtl",this.grid.cDiv).html(d);b(this.grid.cDiv).show()})},
setLabel:function(d,i,g,c){return this.each(function(){var h=-1;if(this.grid)if(typeof d!="undefined"){b(this.p.colModel).each(function(a){if(this.name==d){h=a;return false}});if(h>=0){var k=b("tr.ui-jqgrid-labels th:eq("+h+")",this.grid.hDiv);if(i){var l=b(".s-ico",k);b("[id^=jqgh_]",k).empty().html(i).append(l);this.p.colNames[h]=i}if(g)typeof g==="string"?b(k).addClass(g):b(k).css(g);typeof c==="object"&&b(k).attr(c)}}})},setCell:function(d,i,g,c,h,k){return this.each(function(){var l=-1,a,q;if(this.grid){if(isNaN(i))b(this.p.colModel).each(function(y){if(this.name==
i){l=y;return false}});else l=parseInt(i,10);if(l>=0)if(a=this.rows.namedItem(d)){var x=b("td:eq("+l+")",a);if(g!==""||k===true){a=this.formatter(d,g,l,a,"edit");q=this.p.colModel[l].title?{title:b.jgrid.stripHtml(a)}:{};this.p.treeGrid&&b(".tree-wrap",b(x)).length>0?b("span",b(x)).html(a).attr(q):b(x).html(a).attr(q);if(this.p.datatype=="local"){a=this.p.colModel[l];g=a.formatter&&typeof a.formatter==="string"&&a.formatter=="date"?b.unformat.date(g,a):g;q=this.p._index[d];if(typeof q!="undefined")this.p.data[q][a.name]=
g}}if(typeof c==="string")b(x).addClass(c);else c&&b(x).css(c);typeof h==="object"&&b(x).attr(h)}}})},getCell:function(d,i){var g=false;this.each(function(){var c=-1;if(this.grid){if(isNaN(i))b(this.p.colModel).each(function(l){if(this.name===i){c=l;return false}});else c=parseInt(i,10);if(c>=0){var h=this.rows.namedItem(d);if(h)try{g=b.unformat(b("td:eq("+c+")",h),{rowId:h.id,colModel:this.p.colModel[c]},c)}catch(k){g=b.jgrid.htmlDecode(b("td:eq("+c+")",h).html())}}}});return g},getCol:function(d,
i,g){var c=[],h,k=0,l,a,q;i=typeof i!="boolean"?false:i;if(typeof g=="undefined")g=false;this.each(function(){var x=-1;if(this.grid){if(isNaN(d))b(this.p.colModel).each(function(M){if(this.name===d){x=M;return false}});else x=parseInt(d,10);if(x>=0){var y=this.rows.length,E=0;if(y&&y>0){for(;E<y;){if(b(this.rows[E]).hasClass("jqgrow")){try{h=b.unformat(b(this.rows[E].cells[x]),{rowId:this.rows[E].id,colModel:this.p.colModel[x]},x)}catch(I){h=b.jgrid.htmlDecode(this.rows[E].cells[x].innerHTML)}if(g){q=
parseFloat(h);k+=q;if(E===0)a=l=q;else{l=Math.min(l,q);a=Math.max(a,q)}}else i?c.push({id:this.rows[E].id,value:h}):c.push(h)}E++}if(g)switch(g.toLowerCase()){case "sum":c=k;break;case "avg":c=k/y;break;case "count":c=y;break;case "min":c=l;break;case "max":c=a}}}}});return c},clearGridData:function(d){return this.each(function(){if(this.grid){if(typeof d!="boolean")d=false;if(this.p.deepempty)b("#"+b.jgrid.jqID(this.p.id)+" tbody:first tr:gt(0)").remove();else{var i=b("#"+b.jgrid.jqID(this.p.id)+
" tbody:first tr:first")[0];b("#"+b.jgrid.jqID(this.p.id)+" tbody:first").empty().append(i)}this.p.footerrow&&d&&b(".ui-jqgrid-ftable td",this.grid.sDiv).html("&#160;");this.p.selrow=null;this.p.selarrrow=[];this.p.savedRow=[];this.p.records=0;this.p.page=1;this.p.lastpage=0;this.p.reccount=0;this.p.data=[];this.p._index={};this.updatepager(true,false)}})},getInd:function(d,i){var g=false,c;this.each(function(){if(c=this.rows.namedItem(d))g=i===true?c:c.rowIndex});return g},bindKeys:function(d){var i=
b.extend({onEnter:null,onSpace:null,onLeftKey:null,onRightKey:null,scrollingRows:true},d||{});return this.each(function(){var g=this;b("body").is("[role]")||b("body").attr("role","application");g.p.scrollrows=i.scrollingRows;b(g).keydown(function(c){var h=b(g).find("tr[tabindex=0]")[0],k,l,a,q=g.p.treeReader.expanded_field;if(h){a=g.p._index[h.id];if(c.keyCode===37||c.keyCode===38||c.keyCode===39||c.keyCode===40){if(c.keyCode===38){l=h.previousSibling;k="";if(l)if(b(l).is(":hidden"))for(;l;){l=l.previousSibling;
if(!b(l).is(":hidden")&&b(l).hasClass("jqgrow")){k=l.id;break}}else k=l.id;b(g).jqGrid("setSelection",k)}if(c.keyCode===40){l=h.nextSibling;k="";if(l)if(b(l).is(":hidden"))for(;l;){l=l.nextSibling;if(!b(l).is(":hidden")&&b(l).hasClass("jqgrow")){k=l.id;break}}else k=l.id;b(g).jqGrid("setSelection",k)}if(c.keyCode===37){g.p.treeGrid&&g.p.data[a][q]&&b(h).find("div.treeclick").trigger("click");b.isFunction(i.onLeftKey)&&i.onLeftKey.call(g,g.p.selrow)}if(c.keyCode===39){g.p.treeGrid&&!g.p.data[a][q]&&
b(h).find("div.treeclick").trigger("click");b.isFunction(i.onRightKey)&&i.onRightKey.call(g,g.p.selrow)}}else if(c.keyCode===13)b.isFunction(i.onEnter)&&i.onEnter.call(g,g.p.selrow);else c.keyCode===32&&b.isFunction(i.onSpace)&&i.onSpace.call(g,g.p.selrow)}})})},unbindKeys:function(){return this.each(function(){b(this).unbind("keydown")})},getLocalRow:function(d){var i=false,g;this.each(function(){if(typeof d!=="undefined"){g=this.p._index[d];if(g>=0)i=this.p.data[g]}});return i}})})(jQuery);
(function(b){b.fmatter={};b.extend(b.fmatter,{isBoolean:function(a){return typeof a==="boolean"},isObject:function(a){return a&&(typeof a==="object"||b.isFunction(a))||false},isString:function(a){return typeof a==="string"},isNumber:function(a){return typeof a==="number"&&isFinite(a)},isNull:function(a){return a===null},isUndefined:function(a){return typeof a==="undefined"},isValue:function(a){return this.isObject(a)||this.isString(a)||this.isNumber(a)||this.isBoolean(a)},isEmpty:function(a){if(!this.isString(a)&&
this.isValue(a))return false;else if(!this.isValue(a))return true;a=b.trim(a).replace(/\&nbsp\;/ig,"").replace(/\&#160\;/ig,"");return a===""}});b.fn.fmatter=function(a,c,d,f,g){var e=c;d=b.extend({},b.jgrid.formatter,d);if(b.fn.fmatter[a])e=b.fn.fmatter[a](c,d,f,g);return e};b.fmatter.util={NumberFormat:function(a,c){b.fmatter.isNumber(a)||(a*=1);if(b.fmatter.isNumber(a)){var d=a<0,f=a+"",g=c.decimalSeparator?c.decimalSeparator:".",e;if(b.fmatter.isNumber(c.decimalPlaces)){var h=c.decimalPlaces;
f=Math.pow(10,h);f=Math.round(a*f)/f+"";e=f.lastIndexOf(".");if(h>0){if(e<0){f+=g;e=f.length-1}else if(g!==".")f=f.replace(".",g);for(;f.length-1-e<h;)f+="0"}}if(c.thousandsSeparator){h=c.thousandsSeparator;e=f.lastIndexOf(g);e=e>-1?e:f.length;g=f.substring(e);for(var i=-1,j=e;j>0;j--){i++;if(i%3===0&&j!==e&&(!d||j>1))g=h+g;g=f.charAt(j-1)+g}f=g}f=c.prefix?c.prefix+f:f;return f=c.suffix?f+c.suffix:f}else return a},DateFormat:function(a,c,d,f){var g=/^\/Date\((([-+])?[0-9]+)(([-+])([0-9]{2})([0-9]{2}))?\)\/$/,
e=typeof c==="string"?c.match(g):null;g=function(m,r){m=String(m);for(r=parseInt(r,10)||2;m.length<r;)m="0"+m;return m};var h={m:1,d:1,y:1970,h:0,i:0,s:0,u:0},i=0,j,k=["i18n"];k.i18n={dayNames:f.dayNames,monthNames:f.monthNames};if(a in f.masks)a=f.masks[a];if(!isNaN(c-0)&&String(a).toLowerCase()=="u")i=new Date(parseFloat(c)*1E3);else if(c.constructor===Date)i=c;else if(e!==null){i=new Date(parseInt(e[1],10));if(e[3]){a=Number(e[5])*60+Number(e[6]);a*=e[4]=="-"?1:-1;a-=i.getTimezoneOffset();i.setTime(Number(Number(i)+
a*6E4))}}else{c=String(c).split(/[\\\/:_;.,\t\T\s-]/);a=a.split(/[\\\/:_;.,\t\T\s-]/);e=0;for(j=a.length;e<j;e++){if(a[e]=="M"){i=b.inArray(c[e],k.i18n.monthNames);if(i!==-1&&i<12)c[e]=i+1}if(a[e]=="F"){i=b.inArray(c[e],k.i18n.monthNames);if(i!==-1&&i>11)c[e]=i+1-12}if(c[e])h[a[e].toLowerCase()]=parseInt(c[e],10)}if(h.f)h.m=h.f;if(h.m===0&&h.y===0&&h.d===0)return"&#160;";h.m=parseInt(h.m,10)-1;i=h.y;if(i>=70&&i<=99)h.y=1900+h.y;else if(i>=0&&i<=69)h.y=2E3+h.y;i=new Date(h.y,h.m,h.d,h.h,h.i,h.s,h.u)}if(d in
f.masks)d=f.masks[d];else d||(d="Y-m-d");a=i.getHours();c=i.getMinutes();h=i.getDate();e=i.getMonth()+1;j=i.getTimezoneOffset();var l=i.getSeconds(),n=i.getMilliseconds(),o=i.getDay(),p=i.getFullYear(),q=(o+6)%7+1,s=(new Date(p,e-1,h)-new Date(p,0,1))/864E5,t={d:g(h),D:k.i18n.dayNames[o],j:h,l:k.i18n.dayNames[o+7],N:q,S:f.S(h),w:o,z:s,W:q<5?Math.floor((s+q-1)/7)+1:Math.floor((s+q-1)/7)||(((new Date(p-1,0,1)).getDay()+6)%7<4?53:52),F:k.i18n.monthNames[e-1+12],m:g(e),M:k.i18n.monthNames[e-1],n:e,t:"?",
L:"?",o:"?",Y:p,y:String(p).substring(2),a:a<12?f.AmPm[0]:f.AmPm[1],A:a<12?f.AmPm[2]:f.AmPm[3],B:"?",g:a%12||12,G:a,h:g(a%12||12),H:g(a),i:g(c),s:g(l),u:n,e:"?",I:"?",O:(j>0?"-":"+")+g(Math.floor(Math.abs(j)/60)*100+Math.abs(j)%60,4),P:"?",T:(String(i).match(/\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g)||[""]).pop().replace(/[^-+\dA-Z]/g,""),Z:"?",c:"?",r:"?",U:Math.floor(i/1E3)};return d.replace(/\\.|[dDjlNSwzWFmMntLoYyaABgGhHisueIOPTZcrU]/g,
function(m){return m in t?t[m]:m.substring(1)})}};b.fn.fmatter.defaultFormat=function(a,c){return b.fmatter.isValue(a)&&a!==""?a:c.defaultValue?c.defaultValue:"&#160;"};b.fn.fmatter.email=function(a,c){return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):'<a href="mailto:'+a+'">'+a+"</a>"};b.fn.fmatter.checkbox=function(a,c){var d=b.extend({},c.checkbox),f;b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));f=d.disabled===true?'disabled="disabled"':
"";if(b.fmatter.isEmpty(a)||b.fmatter.isUndefined(a))a=b.fn.fmatter.defaultFormat(a,d);a+="";a=a.toLowerCase();return'<input type="checkbox" '+(a.search(/(false|0|no|off)/i)<0?" checked='checked' ":"")+' value="'+a+'" offval="no" '+f+"/>"};b.fn.fmatter.link=function(a,c){var d={target:c.target},f="";b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(d.target)f="target="+d.target;return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):"<a "+f+' href="'+
a+'">'+a+"</a>"};b.fn.fmatter.showlink=function(a,c){var d={baseLinkUrl:c.baseLinkUrl,showAction:c.showAction,addParam:c.addParam||"",target:c.target,idName:c.idName},f="";b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(d.target)f="target="+d.target;d=d.baseLinkUrl+d.showAction+"?"+d.idName+"="+c.rowId+d.addParam;return b.fmatter.isString(a)||b.fmatter.isNumber(a)?"<a "+f+' href="'+d+'">'+a+"</a>":b.fn.fmatter.defaultFormat(a,c)};b.fn.fmatter.integer=
function(a,c){var d=b.extend({},c.integer);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.number=function(a,c){var d=b.extend({},c.number);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.currency=function(a,c){var d=
b.extend({},c.currency);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.date=function(a,c,d,f){d=b.extend({},c.date);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));return!d.reformatAfterEdit&&f=="edit"?b.fn.fmatter.defaultFormat(a,c):b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):b.fmatter.util.DateFormat(d.srcformat,
a,d.newformat,d)};b.fn.fmatter.select=function(a,c){a+="";var d=false,f=[],g;if(b.fmatter.isUndefined(c.colModel.formatoptions)){if(!b.fmatter.isUndefined(c.colModel.editoptions)){d=c.colModel.editoptions.value;g=c.colModel.editoptions.separator===undefined?":":c.colModel.editoptions.separator}}else{d=c.colModel.formatoptions.value;g=c.colModel.formatoptions.separator===undefined?":":c.colModel.formatoptions.separator}if(d){var e=c.colModel.editoptions.multiple===true?true:false,h=[],i;if(e){h=a.split(",");
h=b.map(h,function(n){return b.trim(n)})}if(b.fmatter.isString(d))for(var j=d.split(";"),k=0,l=0;l<j.length;l++){i=j[l].split(g);if(i.length>2)i[1]=jQuery.map(i,function(n,o){if(o>0)return n}).join(":");if(e){if(jQuery.inArray(i[0],h)>-1){f[k]=i[1];k++}}else if(b.trim(i[0])==b.trim(a)){f[0]=i[1];break}}else if(b.fmatter.isObject(d))if(e)f=jQuery.map(h,function(n){return d[n]});else f[0]=d[a]||""}a=f.join(", ");return a===""?b.fn.fmatter.defaultFormat(a,c):a};b.fn.fmatter.rowactions=function(a,c,d,
f){var g={keys:false,onEdit:null,onSuccess:null,afterSave:null,onError:null,afterRestore:null,extraparam:{},url:null,delOptions:{},editOptions:{}};a=b.jgrid.jqID(a);c=b.jgrid.jqID(c);f=b("#"+c)[0].p.colModel[f];b.fmatter.isUndefined(f.formatoptions)||(g=b.extend(g,f.formatoptions));if(!b.fmatter.isUndefined(b("#"+c)[0].p.editOptions))g.editOptions=b("#"+c)[0].p.editOptions;if(!b.fmatter.isUndefined(b("#"+c)[0].p.delOptions))g.delOptions=b("#"+c)[0].p.delOptions;var e=b("#"+c)[0];f=function(j,k){g.afterSave&&
g.afterSave.call(e,j,k);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide()};var h=function(j){g.afterRestore&&g.afterRestore.call(e,j);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide()};if(b("#"+a,
"#"+c).hasClass("jqgrid-new-row")){var i=e.p.prmNames;g.extraparam[i.oper]=i.addoper}switch(d){case "edit":b("#"+c).jqGrid("editRow",a,g.keys,g.onEdit,g.onSuccess,g.url,g.extraparam,f,g.onError,h);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").hide();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").show();b.isFunction(e.p._complete)&&e.p._complete.call(e);break;case "save":if(b("#"+c).jqGrid("saveRow",a,g.onSuccess,
g.url,g.extraparam,f,g.onError,h)){b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide();b.isFunction(e.p._complete)&&e.p._complete.call(e)}break;case "cancel":b("#"+c).jqGrid("restoreRow",a,h);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel",
"#"+c+".ui-jqgrid-btable:first").hide();b.isFunction(e.p._complete)&&e.p._complete.call(e);break;case "del":b("#"+c).jqGrid("delGridRow",a,g.delOptions);break;case "formedit":b("#"+c).jqGrid("setSelection",a);b("#"+c).jqGrid("editGridRow",a,g.editOptions)}};b.fn.fmatter.actions=function(a,c){var d={keys:false,editbutton:true,delbutton:true,editformbutton:false};b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend(d,c.colModel.formatoptions));var f=c.rowId,g="",e;if(typeof f=="undefined"||
b.fmatter.isEmpty(f))return"";if(d.editformbutton){e="onclick=jQuery.fn.fmatter.rowactions('"+f+"','"+c.gid+"','formedit',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";g=g+"<div title='"+b.jgrid.nav.edittitle+"' style='float:left;cursor:pointer;' class='ui-pg-div ui-inline-edit' "+e+"><span class='ui-icon ui-icon-pencil'></span></div>"}else if(d.editbutton){e="onclick=jQuery.fn.fmatter.rowactions('"+f+"','"+c.gid+"','edit',"+
c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover') ";g=g+"<div title='"+b.jgrid.nav.edittitle+"' style='float:left;cursor:pointer;' class='ui-pg-div ui-inline-edit' "+e+"><span class='ui-icon ui-icon-pencil'></span></div>"}if(d.delbutton){e="onclick=jQuery.fn.fmatter.rowactions('"+f+"','"+c.gid+"','del',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";g=g+"<div title='"+
b.jgrid.nav.deltitle+"' style='float:left;margin-left:5px;' class='ui-pg-div ui-inline-del' "+e+"><span class='ui-icon ui-icon-trash'></span></div>"}e="onclick=jQuery.fn.fmatter.rowactions('"+f+"','"+c.gid+"','save',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";g=g+"<div title='"+b.jgrid.edit.bSubmit+"' style='float:left;display:none' class='ui-pg-div ui-inline-save' "+e+"><span class='ui-icon ui-icon-disk'></span></div>";
e="onclick=jQuery.fn.fmatter.rowactions('"+f+"','"+c.gid+"','cancel',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";g=g+"<div title='"+b.jgrid.edit.bCancel+"' style='float:left;display:none;margin-left:5px;' class='ui-pg-div ui-inline-cancel' "+e+"><span class='ui-icon ui-icon-cancel'></span></div>";return"<div style='margin-left:8px;'>"+g+"</div>"};b.unformat=function(a,c,d,f){var g,e=c.colModel.formatter,h=c.colModel.formatoptions||
{},i=/([\.\*\_\'\(\)\{\}\+\?\\])/g,j=c.colModel.unformat||b.fn.fmatter[e]&&b.fn.fmatter[e].unformat;if(typeof j!=="undefined"&&b.isFunction(j))g=j(b(a).text(),c,a);else if(!b.fmatter.isUndefined(e)&&b.fmatter.isString(e)){g=b.jgrid.formatter||{};switch(e){case "integer":h=b.extend({},g.integer,h);c=h.thousandsSeparator.replace(i,"\\$1");g=b(a).text().replace(RegExp(c,"g"),"");break;case "number":h=b.extend({},g.number,h);c=h.thousandsSeparator.replace(i,"\\$1");g=b(a).text().replace(RegExp(c,"g"),
"").replace(h.decimalSeparator,".");break;case "currency":h=b.extend({},g.currency,h);c=h.thousandsSeparator.replace(i,"\\$1");g=b(a).text().replace(RegExp(c,"g"),"").replace(h.decimalSeparator,".").replace(h.prefix,"").replace(h.suffix,"");break;case "checkbox":h=c.colModel.editoptions?c.colModel.editoptions.value.split(":"):["Yes","No"];g=b("input",a).is(":checked")?h[0]:h[1];break;case "select":g=b.unformat.select(a,c,d,f);break;case "actions":return"";default:g=b(a).text()}}return g!==undefined?
g:f===true?b(a).text():b.jgrid.htmlDecode(b(a).html())};b.unformat.select=function(a,c,d,f){d=[];a=b(a).text();if(f===true)return a;c=b.extend({},c.colModel.editoptions);if(c.value){var g=c.value;c=c.multiple===true?true:false;f=[];var e;if(c){f=a.split(",");f=b.map(f,function(k){return b.trim(k)})}if(b.fmatter.isString(g))for(var h=g.split(";"),i=0,j=0;j<h.length;j++){e=h[j].split(":");if(e.length>2)e[1]=jQuery.map(e,function(k,l){if(l>0)return k}).join(":");if(c){if(jQuery.inArray(e[1],f)>-1){d[i]=
e[0];i++}}else if(b.trim(e[1])==b.trim(a)){d[0]=e[0];break}}else if(b.fmatter.isObject(g)||b.isArray(g)){c||(f[0]=a);d=jQuery.map(f,function(k){var l;b.each(g,function(n,o){if(o==k){l=n;return false}});if(typeof l!="undefined")return l})}return d.join(", ")}else return a||""};b.unformat.date=function(a,c){var d=b.jgrid.formatter.date||{};b.fmatter.isUndefined(c.formatoptions)||(d=b.extend({},d,c.formatoptions));return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):b.fmatter.util.DateFormat(d.newformat,
a,d.srcformat,d)}})(jQuery);
(function(a){a.jgrid.extend({getColProp:function(b){var e={},c=this[0];if(!c.grid)return false;c=c.p.colModel;for(var j=0;j<c.length;j++)if(c[j].name==b){e=c[j];break}return e},setColProp:function(b,e){return this.each(function(){if(this.grid)if(e)for(var c=this.p.colModel,j=0;j<c.length;j++)if(c[j].name==b){a.extend(this.p.colModel[j],e);break}})},sortGrid:function(b,e,c){return this.each(function(){var j=-1;if(this.grid){if(!b)b=this.p.sortname;for(var k=0;k<this.p.colModel.length;k++)if(this.p.colModel[k].index==
b||this.p.colModel[k].name==b){j=k;break}if(j!=-1){k=this.p.colModel[j].sortable;if(typeof k!=="boolean")k=true;if(typeof e!=="boolean")e=false;k&&this.sortData("jqgh_"+this.p.id+"_"+b,j,e,c)}}})},GridDestroy:function(){return this.each(function(){if(this.grid){this.p.pager&&a(this.p.pager).remove();var b=this.id;try{a("#gbox_"+b).remove()}catch(e){}}})},GridUnload:function(){return this.each(function(){if(this.grid){var b={id:a(this).attr("id"),cl:a(this).attr("class")};this.p.pager&&a(this.p.pager).empty().removeClass("ui-state-default ui-jqgrid-pager corner-bottom");
var e=document.createElement("table");a(e).attr({id:b.id});e.className=b.cl;b=this.id;a(e).removeClass("ui-jqgrid-btable");if(a(this.p.pager).parents("#gbox_"+b).length===1){a(e).insertBefore("#gbox_"+b).show();a(this.p.pager).insertBefore("#gbox_"+b)}else a(e).insertBefore("#gbox_"+b).show();a("#gbox_"+b).remove()}})},setGridState:function(b){return this.each(function(){if(this.grid)if(b=="hidden"){a(".ui-jqgrid-bdiv, .ui-jqgrid-hdiv","#gview_"+this.p.id).slideUp("fast");this.p.pager&&a(this.p.pager).slideUp("fast");
this.p.toppager&&a(this.p.toppager).slideUp("fast");if(this.p.toolbar[0]===true){this.p.toolbar[1]=="both"&&a(this.grid.ubDiv).slideUp("fast");a(this.grid.uDiv).slideUp("fast")}this.p.footerrow&&a(".ui-jqgrid-sdiv","#gbox_"+this.p.id).slideUp("fast");a(".ui-jqgrid-titlebar-close span",this.grid.cDiv).removeClass("ui-icon-circle-triangle-n").addClass("ui-icon-circle-triangle-s");this.p.gridstate="hidden"}else if(b=="visible"){a(".ui-jqgrid-hdiv, .ui-jqgrid-bdiv","#gview_"+this.p.id).slideDown("fast");
this.p.pager&&a(this.p.pager).slideDown("fast");this.p.toppager&&a(this.p.toppager).slideDown("fast");if(this.p.toolbar[0]===true){this.p.toolbar[1]=="both"&&a(this.grid.ubDiv).slideDown("fast");a(this.grid.uDiv).slideDown("fast")}this.p.footerrow&&a(".ui-jqgrid-sdiv","#gbox_"+this.p.id).slideDown("fast");a(".ui-jqgrid-titlebar-close span",this.grid.cDiv).removeClass("ui-icon-circle-triangle-s").addClass("ui-icon-circle-triangle-n");this.p.gridstate="visible"}})},filterToolbar:function(b){b=a.extend({autosearch:true,
searchOnEnter:true,beforeSearch:null,afterSearch:null,beforeClear:null,afterClear:null,searchurl:"",stringResult:false,groupOp:"AND",defaultSearch:"bw"},b||{});return this.each(function(){function e(d,g){var h=a(d);h[0]&&jQuery.each(g,function(){this.data!==undefined?h.bind(this.type,this.data,this.fn):h.bind(this.type,this.fn)})}var c=this;if(!this.ftoolbar){var j=function(){var d={},g=0,h,f,i={},m;a.each(c.p.colModel,function(){f=this.index||this.name;m=this.searchoptions&&this.searchoptions.sopt?
this.searchoptions.sopt[0]:this.stype=="select"?"eq":b.defaultSearch;if(h=a("#gs_"+a.jgrid.jqID(this.name),this.frozen===true&&c.p.frozenColumns===true?c.grid.fhDiv:c.grid.hDiv).val()){d[f]=h;i[f]=m;g++}else try{delete c.p.postData[f]}catch(r){}});var n=g>0?true:false;if(b.stringResult===true||c.p.datatype=="local"){var l='{"groupOp":"'+b.groupOp+'","rules":[',t=0;a.each(d,function(r,v){if(t>0)l+=",";l+='{"field":"'+r+'",';l+='"op":"'+i[r]+'",';v+="";l+='"data":"'+v.replace(/\\/g,"\\\\").replace(/\"/g,
'\\"')+'"}';t++});l+="]}";a.extend(c.p.postData,{filters:l});a.each(["searchField","searchString","searchOper"],function(r,v){c.p.postData.hasOwnProperty(v)&&delete c.p.postData[v]})}else a.extend(c.p.postData,d);var o;if(c.p.searchurl){o=c.p.url;a(c).jqGrid("setGridParam",{url:c.p.searchurl})}var q=false;if(a.isFunction(b.beforeSearch))q=b.beforeSearch.call(c);q||a(c).jqGrid("setGridParam",{search:n}).trigger("reloadGrid",[{page:1}]);o&&a(c).jqGrid("setGridParam",{url:o});a.isFunction(b.afterSearch)&&
b.afterSearch()},k=a("<tr class='ui-search-toolbar' role='rowheader'></tr>"),p;a.each(c.p.colModel,function(){var d=this,g,h,f,i;h=a("<th role='columnheader' class='ui-state-default ui-th-column ui-th-"+c.p.direction+"'></th>");g=a("<div style='width:100%;position:relative;height:100%;padding-right:0.3em;'></div>");this.hidden===true&&a(h).css("display","none");this.search=this.search===false?false:true;if(typeof this.stype=="undefined")this.stype="text";f=a.extend({},this.searchoptions||{});if(this.search)switch(this.stype){case "select":if(i=
this.surl||f.dataUrl)a.ajax(a.extend({url:i,dataType:"html",success:function(o){if(f.buildSelect!==undefined)(o=f.buildSelect(o))&&a(g).append(o);else a(g).append(o);f.defaultValue&&a("select",g).val(f.defaultValue);a("select",g).attr({name:d.index||d.name,id:"gs_"+d.name});f.attr&&a("select",g).attr(f.attr);a("select",g).css({width:"100%"});f.dataInit!==undefined&&f.dataInit(a("select",g)[0]);f.dataEvents!==undefined&&e(a("select",g)[0],f.dataEvents);b.autosearch===true&&a("select",g).change(function(){j();
return false});o=null}},a.jgrid.ajaxOptions,c.p.ajaxSelectOptions||{}));else{var m;if(d.searchoptions&&d.searchoptions.value)m=d.searchoptions.value;else if(d.editoptions&&d.editoptions.value)m=d.editoptions.value;if(m){i=document.createElement("select");i.style.width="100%";a(i).attr({name:d.index||d.name,id:"gs_"+d.name});var n,l;if(typeof m==="string"){m=m.split(";");for(var t=0;t<m.length;t++){n=m[t].split(":");l=document.createElement("option");l.value=n[0];l.innerHTML=n[1];i.appendChild(l)}}else if(typeof m===
"object")for(n in m)if(m.hasOwnProperty(n)){l=document.createElement("option");l.value=n;l.innerHTML=m[n];i.appendChild(l)}f.defaultValue&&a(i).val(f.defaultValue);f.attr&&a(i).attr(f.attr);f.dataInit!==undefined&&f.dataInit(i);f.dataEvents!==undefined&&e(i,f.dataEvents);a(g).append(i);b.autosearch===true&&a(i).change(function(){j();return false})}}break;case "text":i=f.defaultValue?f.defaultValue:"";a(g).append("<input type='text' style='width:95%;padding:0px;' name='"+(d.index||d.name)+"' id='gs_"+
d.name+"' value='"+i+"'/>");f.attr&&a("input",g).attr(f.attr);f.dataInit!==undefined&&f.dataInit(a("input",g)[0]);f.dataEvents!==undefined&&e(a("input",g)[0],f.dataEvents);if(b.autosearch===true)b.searchOnEnter?a("input",g).keypress(function(o){if((o.charCode?o.charCode:o.keyCode?o.keyCode:0)==13){j();return false}return this}):a("input",g).keydown(function(o){switch(o.which){case 13:return false;case 9:case 16:case 37:case 38:case 39:case 40:case 27:break;default:p&&clearTimeout(p);p=setTimeout(function(){j()},
500)}})}a(h).append(g);a(k).append(h)});a("table thead",c.grid.hDiv).append(k);this.ftoolbar=true;this.triggerToolbar=j;this.clearToolbar=function(d){var g={},h,f=0,i;d=typeof d!="boolean"?true:d;a.each(c.p.colModel,function(){h=this.searchoptions&&this.searchoptions.defaultValue?this.searchoptions.defaultValue:"";i=this.index||this.name;switch(this.stype){case "select":var q;a("#gs_"+a.jgrid.jqID(this.name)+" option",this.frozen===true&&c.p.frozenColumns===true?c.grid.fhDiv:c.grid.hDiv).each(function(s){if(s===
0)this.selected=true;if(a(this).text()==h){this.selected=true;q=a(this).val();return false}});if(q){g[i]=q;f++}else try{delete c.p.postData[i]}catch(r){}break;case "text":a("#gs_"+a.jgrid.jqID(this.name),this.frozen===true&&c.p.frozenColumns===true?c.grid.fhDiv:c.grid.hDiv).val(h);if(h){g[i]=h;f++}else try{delete c.p.postData[i]}catch(v){}}});var m=f>0?true:false;if(b.stringResult===true||c.p.datatype=="local"){var n='{"groupOp":"'+b.groupOp+'","rules":[',l=0;a.each(g,function(q,r){if(l>0)n+=",";
n+='{"field":"'+q+'",';n+='"op":"eq",';r+="";n+='"data":"'+r.replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"}';l++});n+="]}";a.extend(c.p.postData,{filters:n});a.each(["searchField","searchString","searchOper"],function(q,r){c.p.postData.hasOwnProperty(r)&&delete c.p.postData[r]})}else a.extend(c.p.postData,g);var t;if(c.p.searchurl){t=c.p.url;a(c).jqGrid("setGridParam",{url:c.p.searchurl})}var o=false;if(a.isFunction(b.beforeClear))o=b.beforeClear.call(c);o||d&&a(c).jqGrid("setGridParam",{search:m}).trigger("reloadGrid",
[{page:1}]);t&&a(c).jqGrid("setGridParam",{url:t});a.isFunction(b.afterClear)&&b.afterClear()};this.toggleToolbar=function(){var d=a("tr.ui-search-toolbar",c.grid.hDiv),g=c.p.frozenColumns===true?a("tr.ui-search-toolbar",c.grid.hDiv):false;if(d.css("display")=="none"){d.show();g&&g.show()}else{d.hide();g&&g.hide()}}}})},destroyGroupHeader:function(b){if(typeof b=="undefined")b=true;return this.each(function(){var e,c,j,k,p,d;c=this.grid;var g=a("table.ui-jqgrid-htable thead",c.hDiv),h=this.p.colModel;
if(c){e=a("<tr>",{role:"rowheader"}).addClass("ui-jqgrid-labels");k=c.headers;c=0;for(j=k.length;c<j;c++){p=h[c].hidden?"none":"";p=a(k[c].el).width(k[c].width).css("display",p);try{p.removeAttr("rowSpan")}catch(f){p.attr("rowSpan",1)}e.append(p);d=p.children("span.ui-jqgrid-resize");if(d.length>0)d[0].style.height="";p.children("div")[0].style.top=""}a(g).children("tr.ui-jqgrid-labels").remove();a(g).prepend(e);b===true&&a(this).jqGrid("setGridParam",{groupHeader:null})}})},setGroupHeaders:function(b){b=
a.extend({useColSpanStyle:false,groupHeaders:[]},b||{});return this.each(function(){this.p.groupHeader=b;var e=this,c,j,k=0,p,d,g,h,f,i=e.p.colModel,m=i.length,n=e.grid.headers,l=a("table.ui-jqgrid-htable",e.grid.hDiv),t=l.children("thead").children("tr.ui-jqgrid-labels:last").addClass("jqg-second-row-header");p=l.children("thead");var o,q=l.find(".jqg-first-row-header");if(q.html()===null)q=a("<tr>",{role:"row","aria-hidden":"true"}).addClass("jqg-first-row-header").css("height","auto");else q.empty();
var r,v=function(s,u){for(var w=0,x=u.length;w<x;w++)if(u[w].startColumnName===s)return w;return-1};a(e).prepend(p);p=a("<tr>",{role:"rowheader"}).addClass("ui-jqgrid-labels jqg-third-row-header");for(c=0;c<m;c++){g=n[c].el;h=a(g);j=i[c];d={height:"0px",width:n[c].width+"px",display:j.hidden?"none":""};a("<th>",{role:"gridcell"}).css(d).addClass("ui-first-th-"+e.p.direction).appendTo(q);g.style.width="";d=v(j.name,b.groupHeaders);if(d>=0){d=b.groupHeaders[d];k=d.numberOfColumns;f=d.titleText;for(d=
j=0;d<k&&c+d<m;d++)i[c+d].hidden||j++;d=a("<th>").attr({role:"columnheader"}).addClass("ui-state-default ui-th-column-header ui-th-"+e.p.direction).css({height:"22px","border-top":"0px none"}).html(f);j>0&&d.attr("colspan",String(j));e.p.headertitles&&d.attr("title",d.text());j===0&&d.hide();h.before(d);p.append(g);k-=1}else if(k===0)if(b.useColSpanStyle)h.attr("rowspan","2");else{a("<th>",{role:"columnheader"}).addClass("ui-state-default ui-th-column-header ui-th-"+e.p.direction).css({display:j.hidden?
"none":"","border-top":"0px none"}).insertBefore(h);p.append(g)}else{p.append(g);k--}}i=a(e).children("thead");i.prepend(q);p.insertAfter(t);l.append(i);if(b.useColSpanStyle){l.find("span.ui-jqgrid-resize").each(function(){var s=a(this).parent();if(s.is(":visible"))this.style.cssText="height: "+s.height()+"px !important; cursor: col-resize;"});l.find("div.ui-jqgrid-sortable").each(function(){var s=a(this),u=s.parent();u.is(":visible")&&u.is(":has(span.ui-jqgrid-resize)")&&s.css("top",(u.height()-
s.outerHeight())/2+"px")})}if(a.isFunction(e.p.resizeStop))o=e.p.resizeStop;r=i.find("tr.jqg-first-row-header");e.p.resizeStop=function(s,u){r.find("th").eq(u).width(s);a.isFunction(o)&&o.call(e,s,u)}})},setFrozenColumns:function(){return this.each(function(){if(this.grid){var b=this,e=b.p.colModel,c=0,j=e.length,k=-1,p=false;if(!(b.p.subGrid==true||b.p.treeGrid===true||b.p.cellEdit==true||b.p.sortable||b.p.scroll||b.p.grouping)){b.p.rownumbers&&c++;for(b.p.multiselect&&c++;c<j;){if(e[c].frozen===
true){p=true;k=c}else break;c++}if(k>=0&&p){e=b.p.caption?a(b.grid.cDiv).outerHeight():0;c=a(".ui-jqgrid-htable","#gview_"+a.jgrid.jqID(b.p.id)).height();b.p.orgEvents={};if(b.p.toppager)e+=a(b.grid.topDiv).outerHeight();if(b.p.toolbar[0]==true)if(b.p.toolbar[1]!="bottom")e+=a(b.grid.uDiv).outerHeight();b.grid.fhDiv=a('<div style="position:absolute;left:0px;top:'+e+"px;height:"+c+'px;" class="frozen-div ui-state-default ui-jqgrid-hdiv"></div>');b.grid.fbDiv=a('<div style="position:absolute;left:0px;top:'+
(parseInt(e,10)+parseInt(c,10)+1)+'px;overflow-y:hidden" class="frozen-bdiv ui-jqgrid-bdiv"></div>');a("#gview_"+a.jgrid.jqID(b.p.id)).append(b.grid.fhDiv);e=a(".ui-jqgrid-htable","#gview_"+a.jgrid.jqID(b.p.id)).clone(true);if(b.p.groupHeader){a("tr.jqg-first-row-header, tr.jqg-third-row-header",e).each(function(){a("th:gt("+k+")",this).remove()});var d=-1,g=-1;a("tr.jqg-second-row-header th",e).each(function(){var h=parseInt(a(this).attr("colspan"),10);if(h){d+=h;g++}if(d===k)return false});if(d!==
k)g=k;a("tr.jqg-second-row-header",e).each(function(){a("th:gt("+g+")",this).remove()})}else a("tr",e).each(function(){a("th:gt("+k+")",this).remove()});a(e).width(1);a(b.grid.fhDiv).append(e).mousemove(function(h){if(b.grid.resizing){b.grid.dragMove(h);return false}});if(a.isFunction(b.p.resizeStop))b.p.orgEvents.resizeStop=b.p.resizeStop;b.p.resizeStop=function(h,f){var i=a(".ui-jqgrid-htable",b.grid.fhDiv);a("th:eq("+f+")",i).width(h);i=a(".ui-jqgrid-btable",b.grid.fbDiv);a("tr:first td:eq("+f+
")",i).width(h);if(a.isFunction(b.p.orgEvents.resizeStop))b.p.orgEvents.resizeStop.call(b,h,f);else b.p.orgEvents.resizeStop=null};b.p.orgEvents.onSortCol=a.isFunction(b.p.onSortCol)?b.p.onSortCol:null;b.p.onSortCol=function(h,f,i){var m=a("tr.ui-jqgrid-labels:last th:eq("+b.p.lastsort+")",b.grid.fhDiv),n=a("tr.ui-jqgrid-labels:last th:eq("+f+")",b.grid.fhDiv);a("span.ui-grid-ico-sort",m).addClass("ui-state-disabled");a(m).attr("aria-selected","false");a("span.ui-icon-"+b.p.sortorder,n).removeClass("ui-state-disabled");
a(n).attr("aria-selected","true");if(!b.p.viewsortcols[0])if(b.p.lastsort!=f){a("span.s-ico",m).hide();a("span.s-ico",n).show()}a.isFunction(b.p.orgEvents.onSortCol)&&b.p.orgEvents.onSortCol.call(b,h,f,i)};a("#gview_"+a.jgrid.jqID(b.p.id)).append(b.grid.fbDiv);jQuery(b.grid.bDiv).scroll(function(){jQuery(b.grid.fbDiv).scrollTop(jQuery(this).scrollTop())});b.p.orgEvents.complete=a.isFunction(b.p._complete)?b.p._complete:null;b.p.hoverrows===true&&a("#"+a.jgrid.jqID(b.p.id)).unbind("mouseover").unbind("mouseout");
b.p._complete=function(){a("#"+a.jgrid.jqID(b.p.id)+"_frozen").remove();jQuery(b.grid.fbDiv).height(jQuery(b.grid.bDiv).height()-16);var h=a("#"+a.jgrid.jqID(b.p.id)).clone(true);a("tr",h).each(function(){a("td:gt("+k+")",this).remove()});a(h).width(1).attr("id",a.jgrid.jqID(b.p.id)+"_frozen");a(b.grid.fbDiv).append(h);if(b.p.hoverrows===true){a("tr.jqgrow",h).hover(function(){a(this).addClass("ui-state-hover");a("#"+a.jgrid.jqID(this.id),"#"+a.jgrid.jqID(b.p.id)).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover");
a("#"+a.jgrid.jqID(this.id),"#"+a.jgrid.jqID(b.p.id)).removeClass("ui-state-hover")});a("tr.jqgrow","#"+a.jgrid.jqID(b.p.id)).hover(function(){a(this).addClass("ui-state-hover");a("#"+a.jgrid.jqID(this.id),"#"+a.jgrid.jqID(b.p.id)+"_frozen").addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover");a("#"+a.jgrid.jqID(this.id),"#"+a.jgrid.jqID(b.p.id)+"_frozen").removeClass("ui-state-hover")})}h=null;a.isFunction(b.p.orgEvents.complete)&&b.p.orgEvents.complete.call(b)};b.p.frozenColumns=
true}}}})},destroyFrozenColumns:function(){return this.each(function(){if(this.grid)if(this.p.frozenColumns===true){a(this.grid.fhDiv).remove();a(this.grid.fbDiv).remove();this.grid.fhDiv=null;this.grid.fbDiv=null;this.p._complete=this.p.orgEvents.complete;this.p.resizeStop=this.p.orgEvents.resizeStop;this.p.onSortCol=this.p.orgEvents.onSortCol;this.p.orgEvents=null;if(this.p.hoverrows==true){var b;a("#"+a.jgrid.jqID(this.p.id)).bind("mouseover",function(e){b=a(e.target).closest("tr.jqgrow");a(b).attr("class")!==
"ui-subgrid"&&a(b).addClass("ui-state-hover")}).bind("mouseout",function(e){b=a(e.target).closest("tr.jqgrow");a(b).removeClass("ui-state-hover")})}this.p.frozenColumns=false}})}})})(jQuery);
(function(a){a.extend(a.jgrid,{showModal:function(b){b.w.show()},closeModal:function(b){b.w.hide().attr("aria-hidden","true");b.o&&b.o.remove()},hideModal:function(b,c){c=a.extend({jqm:true,gb:""},c||{});if(c.onClose){var d=c.onClose(b);if(typeof d=="boolean"&&!d)return}if(a.fn.jqm&&c.jqm===true)a(b).attr("aria-hidden","true").jqmHide();else{if(c.gb!=="")try{a(".jqgrid-overlay:first",c.gb).hide()}catch(f){}a(b).hide().attr("aria-hidden","true")}},findPos:function(b){var c=0,d=0;if(b.offsetParent){do{c+=
b.offsetLeft;d+=b.offsetTop}while(b=b.offsetParent)}return[c,d]},createModal:function(b,c,d,f,g,h,j){var e=document.createElement("div"),k,q=this;j=a.extend({},j||{});k=a(d.gbox).attr("dir")=="rtl"?true:false;e.className="ui-widget ui-widget-content ui-corner-all ui-jqdialog";e.id=b.themodal;var i=document.createElement("div");i.className="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix";i.id=b.modalhead;a(i).append("<span class='ui-jqdialog-title'>"+d.caption+"</span>");var n=
a("<a href='javascript:void(0)' class='ui-jqdialog-titlebar-close ui-corner-all'></a>").hover(function(){n.addClass("ui-state-hover")},function(){n.removeClass("ui-state-hover")}).append("<span class='ui-icon ui-icon-closethick'></span>");a(i).append(n);if(k){e.dir="rtl";a(".ui-jqdialog-title",i).css("float","right");a(".ui-jqdialog-titlebar-close",i).css("left","0.3em")}else{e.dir="ltr";a(".ui-jqdialog-title",i).css("float","left");a(".ui-jqdialog-titlebar-close",i).css("right","0.3em")}var r=document.createElement("div");
a(r).addClass("ui-jqdialog-content ui-widget-content").attr("id",b.modalcontent);a(r).append(c);e.appendChild(r);a(e).prepend(i);if(h===true)a("body").append(e);else typeof h=="string"?a(h).append(e):a(e).insertBefore(f);a(e).css(j);if(typeof d.jqModal==="undefined")d.jqModal=true;c={};if(a.fn.jqm&&d.jqModal===true){if(d.left===0&&d.top===0&&d.overlay){j=[];j=this.findPos(g);d.left=j[0]+4;d.top=j[1]+4}c.top=d.top+"px";c.left=d.left}else if(d.left!==0||d.top!==0){c.left=d.left;c.top=d.top+"px"}a("a.ui-jqdialog-titlebar-close",
i).click(function(){var o=a("#"+b.themodal).data("onClose")||d.onClose,s=a("#"+b.themodal).data("gbox")||d.gbox;q.hideModal("#"+b.themodal,{gb:s,jqm:d.jqModal,onClose:o});return false});if(d.width===0||!d.width)d.width=300;if(d.height===0||!d.height)d.height=200;if(!d.zIndex){f=a(f).parents("*[role=dialog]").filter(":first").css("z-index");d.zIndex=f?parseInt(f,10)+2:950}f=0;if(k&&c.left&&!h){f=a(d.gbox).width()-(!isNaN(d.width)?parseInt(d.width,10):0)-8;c.left=parseInt(c.left,10)+parseInt(f,10)}if(c.left)c.left+=
"px";a(e).css(a.extend({width:isNaN(d.width)?"auto":d.width+"px",height:isNaN(d.height)?"auto":d.height+"px",zIndex:d.zIndex,overflow:"hidden"},c)).attr({tabIndex:"-1",role:"dialog","aria-labelledby":b.modalhead,"aria-hidden":"true"});if(typeof d.drag=="undefined")d.drag=true;if(typeof d.resize=="undefined")d.resize=true;if(d.drag){a(i).css("cursor","move");if(a.fn.jqDrag)a(e).jqDrag(i);else try{a(e).draggable({handle:a("#"+i.id)})}catch(m){}}if(d.resize)if(a.fn.jqResize){a(e).append("<div class='jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se ui-icon-grip-diagonal-se'></div>");
a("#"+b.themodal).jqResize(".jqResize",b.scrollelm?"#"+b.scrollelm:false)}else try{a(e).resizable({handles:"se, sw",alsoResize:b.scrollelm?"#"+b.scrollelm:false})}catch(l){}d.closeOnEscape===true&&a(e).keydown(function(o){if(o.which==27){o=a("#"+b.themodal).data("onClose")||d.onClose;q.hideModal(this,{gb:d.gbox,jqm:d.jqModal,onClose:o})}})},viewModal:function(b,c){c=a.extend({toTop:true,overlay:10,modal:false,overlayClass:"ui-widget-overlay",onShow:this.showModal,onHide:this.closeModal,gbox:"",jqm:true,
jqM:true},c||{});if(a.fn.jqm&&c.jqm===true)c.jqM?a(b).attr("aria-hidden","false").jqm(c).jqmShow():a(b).attr("aria-hidden","false").jqmShow();else{if(c.gbox!==""){a(".jqgrid-overlay:first",c.gbox).show();a(b).data("gbox",c.gbox)}a(b).show().attr("aria-hidden","false");try{a(":input:visible",b)[0].focus()}catch(d){}}},info_dialog:function(b,c,d,f){var g={width:290,height:"auto",dataheight:"auto",drag:true,resize:false,caption:"<b>"+b+"</b>",left:250,top:170,zIndex:1E3,jqModal:true,modal:false,closeOnEscape:true,
align:"center",buttonalign:"center",buttons:[]};a.extend(g,f||{});var h=g.jqModal,j=this;if(a.fn.jqm&&!h)h=false;b="";if(g.buttons.length>0)for(f=0;f<g.buttons.length;f++){if(typeof g.buttons[f].id=="undefined")g.buttons[f].id="info_button_"+f;b+="<a href='javascript:void(0)' id='"+g.buttons[f].id+"' class='fm-button ui-state-default ui-corner-all'>"+g.buttons[f].text+"</a>"}f=isNaN(g.dataheight)?g.dataheight:g.dataheight+"px";var e="<div id='info_id'>";e+="<div id='infocnt' style='margin:0px;padding-bottom:1em;width:100%;overflow:auto;position:relative;height:"+
f+";"+("text-align:"+g.align+";")+"'>"+c+"</div>";e+=d?"<div class='ui-widget-content ui-helper-clearfix' style='text-align:"+g.buttonalign+";padding-bottom:0.8em;padding-top:0.5em;background-image: none;border-width: 1px 0 0 0;'><a href='javascript:void(0)' id='closedialog' class='fm-button ui-state-default ui-corner-all'>"+d+"</a>"+b+"</div>":b!==""?"<div class='ui-widget-content ui-helper-clearfix' style='text-align:"+g.buttonalign+";padding-bottom:0.8em;padding-top:0.5em;background-image: none;border-width: 1px 0 0 0;'>"+
b+"</div>":"";e+="</div>";try{a("#info_dialog").attr("aria-hidden")=="false"&&this.hideModal("#info_dialog",{jqm:h});a("#info_dialog").remove()}catch(k){}this.createModal({themodal:"info_dialog",modalhead:"info_head",modalcontent:"info_content",scrollelm:"infocnt"},e,g,"","",true);b&&a.each(g.buttons,function(i){a("#"+this.id,"#info_id").bind("click",function(){g.buttons[i].onClick.call(a("#info_dialog"));return false})});a("#closedialog","#info_id").click(function(){j.hideModal("#info_dialog",{jqm:h});
return false});a(".fm-button","#info_dialog").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});a.isFunction(g.beforeOpen)&&g.beforeOpen();this.viewModal("#info_dialog",{onHide:function(i){i.w.hide().remove();i.o&&i.o.remove()},modal:g.modal,jqm:h});a.isFunction(g.afterOpen)&&g.afterOpen();try{a("#info_dialog").focus()}catch(q){}},createEl:function(b,c,d,f,g){function h(m,l){a.isFunction(l.dataInit)&&l.dataInit(m);l.dataEvents&&a.each(l.dataEvents,
function(){this.data!==undefined?a(m).bind(this.type,this.data,this.fn):a(m).bind(this.type,this.fn)});return l}function j(m,l,o){var s=["dataInit","dataEvents","dataUrl","buildSelect","sopt","searchhidden","defaultValue","attr"];if(typeof o!="undefined"&&a.isArray(o))s=a.extend(s,o);a.each(l,function(p,t){a.inArray(p,s)===-1&&a(m).attr(p,t)});l.hasOwnProperty("id")||a(m).attr("id",a.jgrid.randId())}var e="";switch(b){case "textarea":e=document.createElement("textarea");if(f)c.cols||a(e).css({width:"98%"});
else if(!c.cols)c.cols=20;if(!c.rows)c.rows=2;if(d=="&nbsp;"||d=="&#160;"||d.length==1&&d.charCodeAt(0)==160)d="";e.value=d;j(e,c);c=h(e,c);a(e).attr({role:"textbox",multiline:"true"});break;case "checkbox":e=document.createElement("input");e.type="checkbox";if(c.value){b=c.value.split(":");if(d===b[0]){e.checked=true;e.defaultChecked=true}e.value=b[0];a(e).attr("offval",b[1])}else{b=d.toLowerCase();if(b.search(/(false|0|no|off|undefined)/i)<0&&b!==""){e.checked=true;e.defaultChecked=true;e.value=
d}else e.value="on";a(e).attr("offval","off")}j(e,c,["value"]);c=h(e,c);a(e).attr("role","checkbox");break;case "select":e=document.createElement("select");e.setAttribute("role","select");f=[];if(c.multiple===true){b=true;e.multiple="multiple";a(e).attr("aria-multiselectable","true")}else b=false;if(typeof c.dataUrl!="undefined")a.ajax(a.extend({url:c.dataUrl,type:"GET",dataType:"html",context:{elem:e,options:c,vl:d},success:function(m){var l=[],o=this.elem,s=this.vl,p=a.extend({},this.options),t=
p.multiple===true;if(typeof p.buildSelect!="undefined")m=p.buildSelect(m);if(m=a(m).html()){a(o).append(m);j(o,p);p=h(o,p);if(typeof p.size==="undefined")p.size=t?3:1;if(t){l=s.split(",");l=a.map(l,function(u){return a.trim(u)})}else l[0]=a.trim(s);setTimeout(function(){a("option",o).each(function(){a(this).attr("role","option");if(a.inArray(a.trim(a(this).text()),l)>-1||a.inArray(a.trim(a(this).val()),l)>-1)this.selected="selected"})},0)}}},g||{}));else if(c.value){var k;if(typeof c.size==="undefined")c.size=
b?3:1;if(b){f=d.split(",");f=a.map(f,function(m){return a.trim(m)})}if(typeof c.value==="function")c.value=c.value();var q,i,n=c.separator===undefined?":":c.separator;if(typeof c.value==="string"){q=c.value.split(";");for(k=0;k<q.length;k++){i=q[k].split(n);if(i.length>2)i[1]=a.map(i,function(m,l){if(l>0)return m}).join(":");g=document.createElement("option");g.setAttribute("role","option");g.value=i[0];g.innerHTML=i[1];e.appendChild(g);if(!b&&(a.trim(i[0])==a.trim(d)||a.trim(i[1])==a.trim(d)))g.selected=
"selected";if(b&&(a.inArray(a.trim(i[1]),f)>-1||a.inArray(a.trim(i[0]),f)>-1))g.selected="selected"}}else if(typeof c.value==="object"){n=c.value;for(k in n)if(n.hasOwnProperty(k)){g=document.createElement("option");g.setAttribute("role","option");g.value=k;g.innerHTML=n[k];e.appendChild(g);if(!b&&(a.trim(k)==a.trim(d)||a.trim(n[k])==a.trim(d)))g.selected="selected";if(b&&(a.inArray(a.trim(n[k]),f)>-1||a.inArray(a.trim(k),f)>-1))g.selected="selected"}}j(e,c,["value"]);c=h(e,c)}break;case "text":case "password":case "button":k=
b=="button"?"button":"textbox";e=document.createElement("input");e.type=b;e.value=d;j(e,c);c=h(e,c);if(b!="button")if(f)c.size||a(e).css({width:"98%"});else if(!c.size)c.size=20;a(e).attr("role",k);break;case "image":case "file":e=document.createElement("input");e.type=b;j(e,c);c=h(e,c);break;case "custom":e=document.createElement("span");try{if(a.isFunction(c.custom_element))if(n=c.custom_element.call(this,d,c)){n=a(n).addClass("customelement").attr({id:c.id,name:c.name});a(e).empty().append(n)}else throw"e2";
else throw"e1";}catch(r){r=="e1"&&this.info_dialog(a.jgrid.errors.errcap,"function 'custom_element' "+a.jgrid.edit.msg.nodefined,a.jgrid.edit.bClose);r=="e2"?this.info_dialog(a.jgrid.errors.errcap,"function 'custom_element' "+a.jgrid.edit.msg.novalue,a.jgrid.edit.bClose):this.info_dialog(a.jgrid.errors.errcap,typeof r==="string"?r:r.message,a.jgrid.edit.bClose)}}return e},checkDate:function(b,c){var d={},f;b=b.toLowerCase();f=b.indexOf("/")!=-1?"/":b.indexOf("-")!=-1?"-":b.indexOf(".")!=-1?".":"/";
b=b.split(f);c=c.split(f);if(c.length!=3)return false;f=-1;for(var g,h=-1,j=-1,e=0;e<b.length;e++){g=isNaN(c[e])?0:parseInt(c[e],10);d[b[e]]=g;g=b[e];if(g.indexOf("y")!=-1)f=e;if(g.indexOf("m")!=-1)j=e;if(g.indexOf("d")!=-1)h=e}g=b[f]=="y"||b[f]=="yyyy"?4:b[f]=="yy"?2:-1;e=function(q){for(var i=1;i<=q;i++){this[i]=31;if(i==4||i==6||i==9||i==11)this[i]=30;if(i==2)this[i]=29}return this}(12);var k;if(f===-1)return false;else{k=d[b[f]].toString();if(g==2&&k.length==1)g=1;if(k.length!=g||d[b[f]]===0&&
c[f]!="00")return false}if(j===-1)return false;else{k=d[b[j]].toString();if(k.length<1||d[b[j]]<1||d[b[j]]>12)return false}if(h===-1)return false;else{k=d[b[h]].toString();if(k.length<1||d[b[h]]<1||d[b[h]]>31||d[b[j]]==2&&d[b[h]]>(d[b[f]]%4===0&&(d[b[f]]%100!==0||d[b[f]]%400===0)?29:28)||d[b[h]]>e[d[b[j]]])return false}return true},isEmpty:function(b){return b.match(/^\s+$/)||b===""?true:false},checkTime:function(b){var c=/^(\d{1,2}):(\d{2})([ap]m)?$/;if(!this.isEmpty(b))if(b=b.match(c)){if(b[3]){if(b[1]<
1||b[1]>12)return false}else if(b[1]>23)return false;if(b[2]>59)return false}else return false;return true},checkValues:function(b,c,d,f,g){var h,j;if(typeof f==="undefined")if(typeof c=="string"){f=0;for(g=d.p.colModel.length;f<g;f++)if(d.p.colModel[f].name==c){h=d.p.colModel[f].editrules;c=f;try{j=d.p.colModel[f].formoptions.label}catch(e){}break}}else{if(c>=0)h=d.p.colModel[c].editrules}else{h=f;j=g===undefined?"_":g}if(h){j||(j=d.p.colNames[c]);if(h.required===true)if(this.isEmpty(b))return[false,
j+": "+a.jgrid.edit.msg.required,""];f=h.required===false?false:true;if(h.number===true)if(!(f===false&&this.isEmpty(b)))if(isNaN(b))return[false,j+": "+a.jgrid.edit.msg.number,""];if(typeof h.minValue!="undefined"&&!isNaN(h.minValue))if(parseFloat(b)<parseFloat(h.minValue))return[false,j+": "+a.jgrid.edit.msg.minValue+" "+h.minValue,""];if(typeof h.maxValue!="undefined"&&!isNaN(h.maxValue))if(parseFloat(b)>parseFloat(h.maxValue))return[false,j+": "+a.jgrid.edit.msg.maxValue+" "+h.maxValue,""];if(h.email===
true)if(!(f===false&&this.isEmpty(b))){g=/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i;
if(!g.test(b))return[false,j+": "+a.jgrid.edit.msg.email,""]}if(h.integer===true)if(!(f===false&&this.isEmpty(b))){if(isNaN(b))return[false,j+": "+a.jgrid.edit.msg.integer,""];if(b%1!==0||b.indexOf(".")!=-1)return[false,j+": "+a.jgrid.edit.msg.integer,""]}if(h.date===true)if(!(f===false&&this.isEmpty(b))){c=d.p.colModel[c].formatoptions&&d.p.colModel[c].formatoptions.newformat?d.p.colModel[c].formatoptions.newformat:d.p.colModel[c].datefmt||"Y-m-d";if(!this.checkDate(c,b))return[false,j+": "+a.jgrid.edit.msg.date+
" - "+c,""]}if(h.time===true)if(!(f===false&&this.isEmpty(b)))if(!this.checkTime(b))return[false,j+": "+a.jgrid.edit.msg.date+" - hh:mm (am/pm)",""];if(h.url===true)if(!(f===false&&this.isEmpty(b))){g=/^(((https?)|(ftp)):\/\/([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i;if(!g.test(b))return[false,j+": "+a.jgrid.edit.msg.url,""]}if(h.custom===true)if(!(f===false&&this.isEmpty(b)))if(a.isFunction(h.custom_func)){b=h.custom_func.call(d,b,j);return a.isArray(b)?
b:[false,a.jgrid.edit.msg.customarray,""]}else return[false,a.jgrid.edit.msg.customfcheck,""]}return[true,"",""]}})})(jQuery);
(function(a){var d={};a.jgrid.extend({searchGrid:function(f){f=a.extend({recreateFilter:false,drag:true,sField:"searchField",sValue:"searchString",sOper:"searchOper",sFilter:"filters",loadDefaults:true,beforeShowSearch:null,afterShowSearch:null,onInitializeSearch:null,afterRedraw:null,closeAfterSearch:false,closeAfterReset:false,closeOnEscape:false,multipleSearch:false,multipleGroup:false,top:0,left:0,jqModal:true,modal:false,resize:true,width:450,height:"auto",dataheight:"auto",showQuery:false,errorcheck:true,
sopt:null,stringResult:undefined,onClose:null,onSearch:null,onReset:null,toTop:true,overlay:30,columns:[],tmplNames:null,tmplFilters:null,tmplLabel:" Template: ",showOnLoad:false,layer:null},a.jgrid.search,f||{});return this.each(function(){function b(){if(a.isFunction(f.beforeShowSearch)){x=f.beforeShowSearch(a("#"+q));if(typeof x==="undefined")x=true}if(x){a.jgrid.viewModal("#"+G.themodal,{gbox:"#gbox_"+q,jqm:f.jqModal,modal:f.modal,overlay:f.overlay,toTop:f.toTop});a.isFunction(f.afterShowSearch)&&
f.afterShowSearch(a("#"+q))}}var e=this;if(e.grid){var q="fbox_"+e.p.id,x=true,G={themodal:"searchmod"+q,modalhead:"searchhd"+q,modalcontent:"searchcnt"+q,scrollelm:q},B=e.p.postData[f.sFilter];if(typeof B==="string")B=a.jgrid.parse(B);f.recreateFilter===true&&a("#"+G.themodal).remove();if(a("#"+G.themodal).html()!==null)b();else{var w=a("<div><div id='"+q+"' class='searchFilter' style='overflow:auto'></div></div>").insertBefore("#gview_"+e.p.id),n="left",j="";if(e.p.direction=="rtl"){n="right";j=
" style='text-align:left'";w.attr("dir","rtl")}var s=a.extend([],e.p.colModel),M="<a href='javascript:void(0)' id='"+q+"_search' class='fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset'><span class='ui-icon ui-icon-search'></span>"+f.Find+"</a>",c="<a href='javascript:void(0)' id='"+q+"_reset' class='fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search'><span class='ui-icon ui-icon-arrowreturnthick-1-w'></span>"+f.Reset+"</a>",t="",o="",i,m=false,H=-1;if(f.showQuery)t=
"<a href='javascript:void(0)' id='"+q+"_query' class='fm-button ui-state-default ui-corner-all fm-button-icon-left'><span class='ui-icon ui-icon-comment'></span>Query</a>";if(f.columns.length)s=f.columns;else a.each(s,function(u,C){if(!C.label)C.label=e.p.colNames[u];if(!m){var A=typeof C.search==="undefined"?true:C.search,l=C.hidden===true;if(C.searchoptions&&C.searchoptions.searchhidden===true&&A||A&&!l){m=true;i=C.index||C.name;H=u}}});if(!B&&i||f.multipleSearch===false){var J="eq";if(H>=0&&s[H].searchoptions&&
s[H].searchoptions.sopt)J=s[H].searchoptions.sopt[0];else if(f.sopt&&f.sopt.length)J=f.sopt[0];B={groupOp:"AND",rules:[{field:i,op:J,data:""}]}}m=false;if(f.tmplNames&&f.tmplNames.length){m=true;o=f.tmplLabel;o+="<select class='ui-template'>";o+="<option value='default'>Default</option>";a.each(f.tmplNames,function(u,C){o+="<option value='"+u+"'>"+C+"</option>"});o+="</select>"}n="<table class='EditTable' style='border:0px none;margin-top:5px' id='"+q+"_2'><tbody><tr><td colspan='2'><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr><td class='EditButton' style='text-align:"+
n+"'>"+c+o+"</td><td class='EditButton' "+j+">"+t+M+"</td></tr></tbody></table>";a("#"+q).jqFilter({columns:s,filter:f.loadDefaults?B:null,showQuery:f.showQuery,errorcheck:f.errorcheck,sopt:f.sopt,groupButton:f.multipleGroup,ruleButtons:f.multipleSearch,afterRedraw:f.afterRedraw,_gridsopt:a.jgrid.search.odata,ajaxSelectOptions:e.p.ajaxSelectOptions,onChange:function(){this.p.showQuery&&a(".query",this).html(this.toUserFriendlyString())},direction:e.p.direction});w.append(n);m&&f.tmplFilters&&f.tmplFilters.length&&
a(".ui-template",w).bind("change",function(){var u=a(this).val();u=="default"?a("#"+q).jqFilter("addFilter",B):a("#"+q).jqFilter("addFilter",f.tmplFilters[parseInt(u,10)]);return false});if(f.multipleGroup===true)f.multipleSearch=true;if(a.isFunction(f.onInitializeSearch))f.onInitializeSearch(a("#"+q));f.gbox="#gbox_"+q;f.layer?a.jgrid.createModal(G,w,f,"#gview_"+e.p.id,a("#gbox_"+e.p.id)[0],"#"+f.layer,{position:"relative"}):a.jgrid.createModal(G,w,f,"#gview_"+e.p.id,a("#gbox_"+e.p.id)[0]);t&&a("#"+
q+"_query").bind("click",function(){a(".queryresult",w).toggle();return false});if(f.stringResult===undefined)f.stringResult=f.multipleSearch;a("#"+q+"_search").bind("click",function(){var u=a("#"+q),C={},A,l=u.jqFilter("filterData");if(f.errorcheck){u[0].hideError();f.showQuery||u.jqFilter("toSQLString");if(u[0].p.error){u[0].showError();return false}}if(f.stringResult){try{A=xmlJsonClass.toJson(l,"","",false)}catch(y){try{A=JSON.stringify(l)}catch(h){}}if(typeof A==="string"){C[f.sFilter]=A;a.each([f.sField,
f.sValue,f.sOper],function(){C[this]=""})}}else if(f.multipleSearch){C[f.sFilter]=l;a.each([f.sField,f.sValue,f.sOper],function(){C[this]=""})}else{C[f.sField]=l.rules[0].field;C[f.sValue]=l.rules[0].data;C[f.sOper]=l.rules[0].op;C[f.sFilter]=""}e.p.search=true;a.extend(e.p.postData,C);if(a.isFunction(f.onSearch))f.onSearch();a(e).trigger("reloadGrid",[{page:1}]);f.closeAfterSearch&&a.jgrid.hideModal("#"+G.themodal,{gb:"#gbox_"+e.p.id,jqm:f.jqModal,onClose:f.onClose});return false});a("#"+q+"_reset").bind("click",
function(){var u={},C=a("#"+q);e.p.search=false;if(f.multipleSearch===false)u[f.sField]=u[f.sValue]=u[f.sOper]="";else u[f.sFilter]="";C[0].resetFilter();m&&a(".ui-template",w).val("default");a.extend(e.p.postData,u);if(a.isFunction(f.onReset))f.onReset();a(e).trigger("reloadGrid",[{page:1}]);return false});b();a(".fm-button:not(.ui-state-disabled)",w).hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")})}}})},editGridRow:function(f,b){b=a.extend({top:0,
left:0,width:300,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,url:null,mtype:"POST",clearAfterAdd:true,closeAfterEdit:false,reloadAfterSubmit:true,onInitializeForm:null,beforeInitData:null,beforeShowForm:null,afterShowForm:null,beforeSubmit:null,afterSubmit:null,onclickSubmit:null,afterComplete:null,onclickPgButtons:null,afterclickPgButtons:null,editData:{},recreateForm:false,jqModal:true,closeOnEscape:false,addedrow:"first",topinfo:"",bottominfo:"",saveicon:[],closeicon:[],
savekey:[false,13],navkeys:[false,38,40],checkOnSubmit:false,checkOnUpdate:false,_savedData:{},processing:false,onClose:null,ajaxEditOptions:{},serializeEditData:null,viewPagerButtons:true},a.jgrid.edit,b||{});d[a(this)[0].p.id]=b;return this.each(function(){function e(){a("#"+i+" > tbody > tr > td > .FormElement").each(function(){var g=a(".customelement",this);if(g.length){var k=a(g[0]).attr("name");a.each(c.p.colModel,function(){if(this.name===k&&this.editoptions&&a.isFunction(this.editoptions.custom_value)){try{h[k]=
this.editoptions.custom_value(a("#"+a.jgrid.jqID(k),"#"+i),"get");if(h[k]===undefined)throw"e1";}catch(p){p==="e1"?a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.novalue,jQuery.jgrid.edit.bClose):a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,p.message,jQuery.jgrid.edit.bClose)}return true}})}else{switch(a(this).get(0).type){case "checkbox":if(a(this).is(":checked"))h[this.name]=a(this).val();else{g=a(this).attr("offval");h[this.name]=g}break;case "select-one":h[this.name]=
a("option:selected",this).val();O[this.name]=a("option:selected",this).text();break;case "select-multiple":h[this.name]=a(this).val();h[this.name]=h[this.name]?h[this.name].join(","):"";var v=[];a("option:selected",this).each(function(p,E){v[p]=a(E).text()});O[this.name]=v.join(",");break;case "password":case "text":case "textarea":case "button":h[this.name]=a(this).val()}if(c.p.autoencode)h[this.name]=a.jgrid.htmlEncode(h[this.name])}});return true}function q(g,k,v,p){var E,D,z,L=0,r,R,F,T=[],I=
false,ca="",P;for(P=1;P<=p;P++)ca+="<td class='CaptionTD'>&#160;</td><td class='DataTD'>&#160;</td>";if(g!="_empty")I=a(k).jqGrid("getInd",g);a(k.p.colModel).each(function(S){E=this.name;R=(D=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false)?"style='display:none'":"";if(E!=="cb"&&E!=="subgrid"&&this.editable===true&&E!=="rn"){if(I===false)r="";else if(E==k.p.ExpandColumn&&k.p.treeGrid===true)r=a("td:eq("+S+")",k.rows[I]).text();else{try{r=a.unformat(a("td:eq("+
S+")",k.rows[I]),{rowId:g,colModel:this},S)}catch(ea){r=this.edittype&&this.edittype=="textarea"?a("td:eq("+S+")",k.rows[I]).text():a("td:eq("+S+")",k.rows[I]).html()}if(!r||r=="&nbsp;"||r=="&#160;"||r.length==1&&r.charCodeAt(0)==160)r=""}var X=a.extend({},this.editoptions||{},{id:E,name:E}),Y=a.extend({},{elmprefix:"",elmsuffix:"",rowabove:false,rowcontent:""},this.formoptions||{}),da=parseInt(Y.rowpos,10)||L+1,fa=parseInt((parseInt(Y.colpos,10)||1)*2,10);if(g=="_empty"&&X.defaultValue)r=a.isFunction(X.defaultValue)?
X.defaultValue():X.defaultValue;if(!this.edittype)this.edittype="text";if(c.p.autoencode)r=a.jgrid.htmlDecode(r);F=a.jgrid.createEl(this.edittype,X,r,false,a.extend({},a.jgrid.ajaxOptions,k.p.ajaxSelectOptions||{}));if(r===""&&this.edittype=="checkbox")r=a(F).attr("offval");if(r===""&&this.edittype=="select")r=a("option:eq(0)",F).text();if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[E]=r;a(F).addClass("FormElement");if(this.edittype=="text"||this.edittype=="textarea")a(F).addClass("ui-widget-content ui-corner-all");
z=a(v).find("tr[rowpos="+da+"]");if(Y.rowabove){X=a("<tr><td class='contentinfo' colspan='"+p*2+"'>"+Y.rowcontent+"</td></tr>");a(v).append(X);X[0].rp=da}if(z.length===0){z=a("<tr "+R+" rowpos='"+da+"'></tr>").addClass("FormData").attr("id","tr_"+E);a(z).append(ca);a(v).append(z);z[0].rp=da}a("td:eq("+(fa-2)+")",z[0]).html(typeof Y.label==="undefined"?k.p.colNames[S]:Y.label);a("td:eq("+(fa-1)+")",z[0]).append(Y.elmprefix).append(F).append(Y.elmsuffix);T[L]=S;L++}});if(L>0){P=a("<tr class='FormData' style='display:none'><td class='CaptionTD'></td><td colspan='"+
(p*2-1)+"' class='DataTD'><input class='FormElement' id='id_g' type='text' name='"+k.p.id+"_id' value='"+g+"'/></td></tr>");P[0].rp=L+999;a(v).append(P);if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[k.p.id+"_id"]=g}return T}function x(g,k,v){var p,E=0,D,z,L,r,R;if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate){d[c.p.id]._savedData={};d[c.p.id]._savedData[k.p.id+"_id"]=g}var F=k.p.colModel;if(g=="_empty"){a(F).each(function(){p=this.name;L=a.extend({},this.editoptions||
{});if((z=a("#"+a.jgrid.jqID(p),"#"+v))&&z.length&&z[0]!==null){r="";if(L.defaultValue){r=a.isFunction(L.defaultValue)?L.defaultValue():L.defaultValue;if(z[0].type=="checkbox"){R=r.toLowerCase();if(R.search(/(false|0|no|off|undefined)/i)<0&&R!==""){z[0].checked=true;z[0].defaultChecked=true;z[0].value=r}else{z[0].checked=false;z[0].defaultChecked=false}}else z.val(r)}else if(z[0].type=="checkbox"){z[0].checked=false;z[0].defaultChecked=false;r=a(z).attr("offval")}else if(z[0].type&&z[0].type.substr(0,
6)=="select")z[0].selectedIndex=0;else z.val(r);if(d[c.p.id].checkOnSubmit===true||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[p]=r}});a("#id_g","#"+v).val(g)}else{var T=a(k).jqGrid("getInd",g,true);if(T){a('td[role="gridcell"]',T).each(function(I){p=F[I].name;if(p!=="cb"&&p!=="subgrid"&&p!=="rn"&&F[I].editable===true){if(p==k.p.ExpandColumn&&k.p.treeGrid===true)D=a(this).text();else try{D=a.unformat(a(this),{rowId:g,colModel:F[I]},I)}catch(ca){D=F[I].edittype=="textarea"?a(this).text():a(this).html()}if(c.p.autoencode)D=
a.jgrid.htmlDecode(D);if(d[c.p.id].checkOnSubmit===true||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[p]=D;p=a.jgrid.jqID(p);switch(F[I].edittype){case "password":case "text":case "button":case "image":case "textarea":if(D=="&nbsp;"||D=="&#160;"||D.length==1&&D.charCodeAt(0)==160)D="";a("#"+p,"#"+v).val(D);break;case "select":var P=D.split(",");P=a.map(P,function(ea){return a.trim(ea)});a("#"+p+" option","#"+v).each(function(){this.selected=!F[I].editoptions.multiple&&(a.trim(D)==a.trim(a(this).text())||
P[0]==a.trim(a(this).text())||P[0]==a.trim(a(this).val()))?true:F[I].editoptions.multiple?a.inArray(a.trim(a(this).text()),P)>-1||a.inArray(a.trim(a(this).val()),P)>-1?true:false:false});break;case "checkbox":D+="";if(F[I].editoptions&&F[I].editoptions.value)if(F[I].editoptions.value.split(":")[0]==D){a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("checked",true);a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("defaultChecked",true)}else{a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("checked",false);a("#"+p,"#"+
v)[c.p.useProp?"prop":"attr"]("defaultChecked",false)}else{D=D.toLowerCase();if(D.search(/(false|0|no|off|undefined)/i)<0&&D!==""){a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("checked",true);a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("defaultChecked",true)}else{a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("checked",false);a("#"+p,"#"+v)[c.p.useProp?"prop":"attr"]("defaultChecked",false)}}break;case "custom":try{if(F[I].editoptions&&a.isFunction(F[I].editoptions.custom_value))F[I].editoptions.custom_value(a("#"+
p,"#"+v),"set",D);else throw"e1";}catch(S){S=="e1"?a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.nodefined,jQuery.jgrid.edit.bClose):a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,S.message,jQuery.jgrid.edit.bClose)}}E++}});E>0&&a("#id_g","#"+i).val(g)}}}function G(){a.each(c.p.colModel,function(g,k){if(k.editoptions&&k.editoptions.NullIfEmpty===true)if(h.hasOwnProperty(k.name)&&h[k.name]==="")h[k.name]="null"})}function B(){var g,k=[true,"",""],v={},p=
c.p.prmNames,E,D,z,L,r;if(a.isFunction(d[c.p.id].beforeCheckValues)){var R=d[c.p.id].beforeCheckValues(h,a("#"+o),h[c.p.id+"_id"]=="_empty"?p.addoper:p.editoper);if(R&&typeof R==="object")h=R}for(z in h)if(h.hasOwnProperty(z)){k=a.jgrid.checkValues(h[z],z,c);if(k[0]===false)break}G();if(k[0]){if(a.isFunction(d[c.p.id].onclickSubmit))v=d[c.p.id].onclickSubmit(d[c.p.id],h)||{};if(a.isFunction(d[c.p.id].beforeSubmit))k=d[c.p.id].beforeSubmit(h,a("#"+o))}if(k[0]&&!d[c.p.id].processing){d[c.p.id].processing=
true;a("#sData","#"+i+"_2").addClass("ui-state-active");D=p.oper;E=p.id;h[D]=a.trim(h[c.p.id+"_id"])=="_empty"?p.addoper:p.editoper;if(h[D]!=p.addoper)h[E]=h[c.p.id+"_id"];else if(h[E]===undefined)h[E]=h[c.p.id+"_id"];delete h[c.p.id+"_id"];h=a.extend(h,d[c.p.id].editData,v);if(c.p.treeGrid===true){if(h[D]==p.addoper){L=a(c).jqGrid("getGridParam","selrow");h[c.p.treeGridModel=="adjacency"?c.p.treeReader.parent_id_field:"parent_id"]=L}for(r in c.p.treeReader)if(c.p.treeReader.hasOwnProperty(r)){v=
c.p.treeReader[r];if(h.hasOwnProperty(v))h[D]==p.addoper&&r==="parent_id_field"||delete h[v]}}h[E]=a.jgrid.stripPref(c.p.idPrefix,h[E]);r=a.extend({url:d[c.p.id].url?d[c.p.id].url:a(c).jqGrid("getGridParam","editurl"),type:d[c.p.id].mtype,data:a.isFunction(d[c.p.id].serializeEditData)?d[c.p.id].serializeEditData(h):h,complete:function(F,T){h[E]=c.p.idPrefix+h[E];if(T!="success"){k[0]=false;k[1]=a.isFunction(d[c.p.id].errorTextFormat)?d[c.p.id].errorTextFormat(F):T+" Status: '"+F.statusText+"'. Error code: "+
F.status}else if(a.isFunction(d[c.p.id].afterSubmit))k=d[c.p.id].afterSubmit(F,h);if(k[0]===false){a("#FormError>td","#"+i).html(k[1]);a("#FormError","#"+i).show()}else{a.each(c.p.colModel,function(){if(O[this.name]&&this.formatter&&this.formatter=="select")try{delete O[this.name]}catch(P){}});h=a.extend(h,O);c.p.autoencode&&a.each(h,function(P,S){h[P]=a.jgrid.htmlDecode(S)});if(h[D]==p.addoper){k[2]||(k[2]=a.jgrid.randId());h[E]=k[2];if(d[c.p.id].closeAfterAdd){if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");
else if(c.p.treeGrid===true)a(c).jqGrid("addChildNode",k[2],L,h);else{a(c).jqGrid("addRowData",k[2],h,b.addedrow);a(c).jqGrid("setSelection",k[2])}a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}else if(d[c.p.id].clearAfterAdd){if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");else c.p.treeGrid===true?a(c).jqGrid("addChildNode",k[2],L,h):a(c).jqGrid("addRowData",k[2],h,b.addedrow);x("_empty",c,o)}else if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");
else c.p.treeGrid===true?a(c).jqGrid("addChildNode",k[2],L,h):a(c).jqGrid("addRowData",k[2],h,b.addedrow)}else{if(d[c.p.id].reloadAfterSubmit){a(c).trigger("reloadGrid");d[c.p.id].closeAfterEdit||setTimeout(function(){a(c).jqGrid("setSelection",h[E])},1E3)}else c.p.treeGrid===true?a(c).jqGrid("setTreeRow",h[E],h):a(c).jqGrid("setRowData",h[E],h);d[c.p.id].closeAfterEdit&&a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}if(a.isFunction(d[c.p.id].afterComplete)){g=
F;setTimeout(function(){d[c.p.id].afterComplete(g,h,a("#"+o));g=null},500)}if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate){a("#"+o).data("disabled",false);if(d[c.p.id]._savedData[c.p.id+"_id"]!="_empty")for(var I in d[c.p.id]._savedData)if(h[I])d[c.p.id]._savedData[I]=h[I]}}d[c.p.id].processing=false;a("#sData","#"+i+"_2").removeClass("ui-state-active");try{a(":input:visible","#"+o)[0].focus()}catch(ca){}}},a.jgrid.ajaxOptions,d[c.p.id].ajaxEditOptions);if(!r.url&&!d[c.p.id].useDataProxy)if(a.isFunction(c.p.dataProxy))d[c.p.id].useDataProxy=
true;else{k[0]=false;k[1]+=" "+a.jgrid.errors.nourl}if(k[0])if(d[c.p.id].useDataProxy){v=c.p.dataProxy.call(c,r,"set_"+c.p.id);if(typeof v=="undefined")v=[true,""];if(v[0]===false){k[0]=false;k[1]=v[1]||"Error deleting the selected row!"}else{r.data.oper==p.addoper&&d[c.p.id].closeAfterAdd&&a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});r.data.oper==p.editoper&&d[c.p.id].closeAfterEdit&&a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}}else a.ajax(r)}if(k[0]===
false){a("#FormError>td","#"+i).html(k[1]);a("#FormError","#"+i).show()}}function w(g,k){var v=false,p;for(p in g)if(g[p]!=k[p]){v=true;break}return v}function n(){var g=true;a("#FormError","#"+i).hide();if(d[c.p.id].checkOnUpdate){h={};O={};e();N=a.extend({},h,O);if(U=w(N,d[c.p.id]._savedData)){a("#"+o).data("disabled",true);a(".confirm","#"+m.themodal).show();g=false}}return g}function j(){if(f!=="_empty"&&typeof c.p.savedRow!=="undefined"&&c.p.savedRow.length>0&&a.isFunction(a.fn.jqGrid.restoreRow))for(var g=
0;g<c.p.savedRow.length;g++)if(c.p.savedRow[g].id==f){a(c).jqGrid("restoreRow",f);break}}function s(g,k){g===0?a("#pData","#"+i+"_2").addClass("ui-state-disabled"):a("#pData","#"+i+"_2").removeClass("ui-state-disabled");g==k?a("#nData","#"+i+"_2").addClass("ui-state-disabled"):a("#nData","#"+i+"_2").removeClass("ui-state-disabled")}function M(){var g=a(c).jqGrid("getDataIDs"),k=a("#id_g","#"+i).val();return[a.inArray(k,g),g]}var c=this;if(c.grid&&f){var t=c.p.id,o="FrmGrid_"+t,i="TblGrid_"+t,m={themodal:"editmod"+
t,modalhead:"edithd"+t,modalcontent:"editcnt"+t,scrollelm:o},H=a.isFunction(d[c.p.id].beforeShowForm)?d[c.p.id].beforeShowForm:false,J=a.isFunction(d[c.p.id].afterShowForm)?d[c.p.id].afterShowForm:false,u=a.isFunction(d[c.p.id].beforeInitData)?d[c.p.id].beforeInitData:false,C=a.isFunction(d[c.p.id].onInitializeForm)?d[c.p.id].onInitializeForm:false,A=true,l=1,y=0,h,O,N,U;if(f==="new"){f="_empty";b.caption=d[c.p.id].addCaption}else b.caption=d[c.p.id].editCaption;b.recreateForm===true&&a("#"+m.themodal).html()!==
null&&a("#"+m.themodal).remove();var Q=true;if(b.checkOnUpdate&&b.jqModal&&!b.modal)Q=false;if(a("#"+m.themodal).html()!==null){if(u){A=u(a("#"+o));if(typeof A=="undefined")A=true}if(A===false)return;j();a(".ui-jqdialog-title","#"+m.modalhead).html(b.caption);a("#FormError","#"+i).hide();if(d[c.p.id].topinfo){a(".topinfo","#"+i).html(d[c.p.id].topinfo);a(".tinfo","#"+i).show()}else a(".tinfo","#"+i).hide();if(d[c.p.id].bottominfo){a(".bottominfo","#"+i+"_2").html(d[c.p.id].bottominfo);a(".binfo",
"#"+i+"_2").show()}else a(".binfo","#"+i+"_2").hide();x(f,c,o);f=="_empty"||!d[c.p.id].viewPagerButtons?a("#pData, #nData","#"+i+"_2").hide():a("#pData, #nData","#"+i+"_2").show();if(d[c.p.id].processing===true){d[c.p.id].processing=false;a("#sData","#"+i+"_2").removeClass("ui-state-active")}if(a("#"+o).data("disabled")===true){a(".confirm","#"+m.themodal).hide();a("#"+o).data("disabled",false)}H&&H(a("#"+o));a("#"+m.themodal).data("onClose",d[c.p.id].onClose);a.jgrid.viewModal("#"+m.themodal,{gbox:"#gbox_"+
t,jqm:b.jqModal,jqM:false,overlay:b.overlay,modal:b.modal});Q||a(".jqmOverlay").click(function(){if(!n())return false;a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false});J&&J(a("#"+o))}else{var K=isNaN(b.dataheight)?b.dataheight:b.dataheight+"px";K=a("<form name='FormPost' id='"+o+"' class='FormGrid' onSubmit='return false;' style='width:100%;overflow:auto;position:relative;height:"+K+";'></form>").data("disabled",false);var V=a("<table id='"+i+
"' class='EditTable' cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>");if(u){A=u(a("#"+o));if(typeof A=="undefined")A=true}if(A===false)return;j();a(c.p.colModel).each(function(){var g=this.formoptions;l=Math.max(l,g?g.colpos||0:0);y=Math.max(y,g?g.rowpos||0:0)});a(K).append(V);u=a("<tr id='FormError' style='display:none'><td class='ui-state-error' colspan='"+l*2+"'></td></tr>");u[0].rp=0;a(V).append(u);u=a("<tr style='display:none' class='tinfo'><td class='topinfo' colspan='"+
l*2+"'>"+d[c.p.id].topinfo+"</td></tr>");u[0].rp=0;a(V).append(u);A=(u=c.p.direction=="rtl"?true:false)?"nData":"pData";var W=u?"pData":"nData";q(f,c,V,l);A="<a href='javascript:void(0)' id='"+A+"' class='fm-button ui-state-default ui-corner-left'><span class='ui-icon ui-icon-triangle-1-w'></span></a>";W="<a href='javascript:void(0)' id='"+W+"' class='fm-button ui-state-default ui-corner-right'><span class='ui-icon ui-icon-triangle-1-e'></span></a>";var $="<a href='javascript:void(0)' id='sData' class='fm-button ui-state-default ui-corner-all'>"+
b.bSubmit+"</a>",Z="<a href='javascript:void(0)' id='cData' class='fm-button ui-state-default ui-corner-all'>"+b.bCancel+"</a>";A="<table border='0' cellspacing='0' cellpadding='0' class='EditTable' id='"+i+"_2'><tbody><tr><td colspan='2'><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr id='Act_Buttons'><td class='navButton'>"+(u?W+A:A+W)+"</td><td class='EditButton'>"+$+Z+"</td></tr>";A+="<tr style='display:none' class='binfo'><td class='bottominfo' colspan='2'>"+d[c.p.id].bottominfo+
"</td></tr>";A+="</tbody></table>";if(y>0){var aa=[];a.each(a(V)[0].rows,function(g,k){aa[g]=k});aa.sort(function(g,k){if(g.rp>k.rp)return 1;if(g.rp<k.rp)return-1;return 0});a.each(aa,function(g,k){a("tbody",V).append(k)})}b.gbox="#gbox_"+t;var ba=false;if(b.closeOnEscape===true){b.closeOnEscape=false;ba=true}K=a("<span></span>").append(K).append(A);a.jgrid.createModal(m,K,b,"#gview_"+c.p.id,a("#gbox_"+c.p.id)[0]);if(u){a("#pData, #nData","#"+i+"_2").css("float","right");a(".EditButton","#"+i+"_2").css("text-align",
"left")}d[c.p.id].topinfo&&a(".tinfo","#"+i).show();d[c.p.id].bottominfo&&a(".binfo","#"+i+"_2").show();A=K=null;a("#"+m.themodal).keydown(function(g){var k=g.target;if(a("#"+o).data("disabled")===true)return false;if(d[c.p.id].savekey[0]===true&&g.which==d[c.p.id].savekey[1])if(k.tagName!="TEXTAREA"){a("#sData","#"+i+"_2").trigger("click");return false}if(g.which===27){if(!n())return false;ba&&a.jgrid.hideModal(this,{gb:b.gbox,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false}if(d[c.p.id].navkeys[0]===
true){if(a("#id_g","#"+i).val()=="_empty")return true;if(g.which==d[c.p.id].navkeys[1]){a("#pData","#"+i+"_2").trigger("click");return false}if(g.which==d[c.p.id].navkeys[2]){a("#nData","#"+i+"_2").trigger("click");return false}}});if(b.checkOnUpdate){a("a.ui-jqdialog-titlebar-close span","#"+m.themodal).removeClass("jqmClose");a("a.ui-jqdialog-titlebar-close","#"+m.themodal).unbind("click").click(function(){if(!n())return false;a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});
return false})}b.saveicon=a.extend([true,"left","ui-icon-disk"],b.saveicon);b.closeicon=a.extend([true,"left","ui-icon-close"],b.closeicon);if(b.saveicon[0]===true)a("#sData","#"+i+"_2").addClass(b.saveicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.saveicon[2]+"'></span>");if(b.closeicon[0]===true)a("#cData","#"+i+"_2").addClass(b.closeicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.closeicon[2]+"'></span>");
if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate){$="<a href='javascript:void(0)' id='sNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+b.bYes+"</a>";W="<a href='javascript:void(0)' id='nNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+b.bNo+"</a>";Z="<a href='javascript:void(0)' id='cNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+b.bExit+"</a>";K=b.zIndex||999;K++;a("<div class='ui-widget-overlay jqgrid-overlay confirm' style='z-index:"+
K+";display:none;'>&#160;"+(a.browser.msie&&a.browser.version==6?'<iframe style="display:block;position:absolute;z-index:-1;filter:Alpha(Opacity=\'0\');" src="javascript:false;"></iframe>':"")+"</div><div class='confirm ui-widget-content ui-jqconfirm' style='z-index:"+(K+1)+"'>"+b.saveData+"<br/><br/>"+$+W+Z+"</div>").insertAfter("#"+o);a("#sNew","#"+m.themodal).click(function(){B();a("#"+o).data("disabled",false);a(".confirm","#"+m.themodal).hide();return false});a("#nNew","#"+m.themodal).click(function(){a(".confirm",
"#"+m.themodal).hide();a("#"+o).data("disabled",false);setTimeout(function(){a(":input","#"+o)[0].focus()},0);return false});a("#cNew","#"+m.themodal).click(function(){a(".confirm","#"+m.themodal).hide();a("#"+o).data("disabled",false);a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false})}C&&C(a("#"+o));f=="_empty"||!d[c.p.id].viewPagerButtons?a("#pData,#nData","#"+i+"_2").hide():a("#pData,#nData","#"+i+"_2").show();H&&H(a("#"+o));a("#"+m.themodal).data("onClose",
d[c.p.id].onClose);a.jgrid.viewModal("#"+m.themodal,{gbox:"#gbox_"+t,jqm:b.jqModal,overlay:b.overlay,modal:b.modal});Q||a(".jqmOverlay").click(function(){if(!n())return false;a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false});J&&J(a("#"+o));a(".fm-button","#"+m.themodal).hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});a("#sData","#"+i+"_2").click(function(){h={};O={};a("#FormError","#"+i).hide();
e();if(h[c.p.id+"_id"]=="_empty")B();else if(b.checkOnSubmit===true){N=a.extend({},h,O);if(U=w(N,d[c.p.id]._savedData)){a("#"+o).data("disabled",true);a(".confirm","#"+m.themodal).show()}else B()}else B();return false});a("#cData","#"+i+"_2").click(function(){if(!n())return false;a.jgrid.hideModal("#"+m.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false});a("#nData","#"+i+"_2").click(function(){if(!n())return false;a("#FormError","#"+i).hide();var g=M();g[0]=parseInt(g[0],
10);if(g[0]!=-1&&g[1][g[0]+1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("next",a("#"+o),g[1][g[0]]);x(g[1][g[0]+1],c,o);a(c).jqGrid("setSelection",g[1][g[0]+1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("next",a("#"+o),g[1][g[0]+1]);s(g[0]+1,g[1].length-1)}return false});a("#pData","#"+i+"_2").click(function(){if(!n())return false;a("#FormError","#"+i).hide();var g=M();if(g[0]!=-1&&g[1][g[0]-1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("prev",a("#"+o),
g[1][g[0]]);x(g[1][g[0]-1],c,o);a(c).jqGrid("setSelection",g[1][g[0]-1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("prev",a("#"+o),g[1][g[0]-1]);s(g[0]-1,g[1].length-1)}return false})}H=M();s(H[0],H[1].length-1)}})},viewGridRow:function(f,b){b=a.extend({top:0,left:0,width:0,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,jqModal:true,closeOnEscape:false,labelswidth:"30%",closeicon:[],navkeys:[false,38,40],onClose:null,beforeShowForm:null,beforeInitData:null,
viewPagerButtons:true},a.jgrid.view,b||{});return this.each(function(){function e(){if(b.closeOnEscape===true||b.navkeys[0]===true)setTimeout(function(){a(".ui-jqdialog-titlebar-close","#"+M.modalhead).focus()},0)}function q(l,y,h,O){for(var N,U,Q,K=0,V,W,$=[],Z=false,aa="<td class='CaptionTD form-view-label ui-widget-content' width='"+b.labelswidth+"'>&#160;</td><td class='DataTD form-view-data ui-helper-reset ui-widget-content'>&#160;</td>",ba="",g=["integer","number","currency"],k=0,v=0,p,E,D,
z=1;z<=O;z++)ba+=z==1?aa:"<td class='CaptionTD form-view-label ui-widget-content'>&#160;</td><td class='DataTD form-view-data ui-widget-content'>&#160;</td>";a(y.p.colModel).each(function(){U=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false;if(!U&&this.align==="right")if(this.formatter&&a.inArray(this.formatter,g)!==-1)k=Math.max(k,parseInt(this.width,10));else v=Math.max(v,parseInt(this.width,10))});p=k!==0?k:v!==0?v:0;Z=a(y).jqGrid("getInd",l);a(y.p.colModel).each(function(L){N=
this.name;E=false;W=(U=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false)?"style='display:none'":"";D=typeof this.viewable!="boolean"?true:this.viewable;if(N!=="cb"&&N!=="subgrid"&&N!=="rn"&&D){V=Z===false?"":N==y.p.ExpandColumn&&y.p.treeGrid===true?a("td:eq("+L+")",y.rows[Z]).text():a("td:eq("+L+")",y.rows[Z]).html();E=this.align==="right"&&p!==0?true:false;a.extend({},this.editoptions||{},{id:N,name:N});var r=a.extend({},{rowabove:false,rowcontent:""},this.formoptions||
{}),R=parseInt(r.rowpos,10)||K+1,F=parseInt((parseInt(r.colpos,10)||1)*2,10);if(r.rowabove){var T=a("<tr><td class='contentinfo' colspan='"+O*2+"'>"+r.rowcontent+"</td></tr>");a(h).append(T);T[0].rp=R}Q=a(h).find("tr[rowpos="+R+"]");if(Q.length===0){Q=a("<tr "+W+" rowpos='"+R+"'></tr>").addClass("FormData").attr("id","trv_"+N);a(Q).append(ba);a(h).append(Q);Q[0].rp=R}a("td:eq("+(F-2)+")",Q[0]).html("<b>"+(typeof r.label==="undefined"?y.p.colNames[L]:r.label)+"</b>");a("td:eq("+(F-1)+")",Q[0]).append("<span>"+
V+"</span>").attr("id","v_"+N);E&&a("td:eq("+(F-1)+") span",Q[0]).css({"text-align":"right",width:p+"px"});$[K]=L;K++}});if(K>0){l=a("<tr class='FormData' style='display:none'><td class='CaptionTD'></td><td colspan='"+(O*2-1)+"' class='DataTD'><input class='FormElement' id='id_g' type='text' name='id' value='"+l+"'/></td></tr>");l[0].rp=K+99;a(h).append(l)}return $}function x(l,y){var h,O,N=0,U,Q;if(Q=a(y).jqGrid("getInd",l,true)){a("td",Q).each(function(K){h=y.p.colModel[K].name;O=y.p.colModel[K].editrules&&
y.p.colModel[K].editrules.edithidden===true?false:y.p.colModel[K].hidden===true?true:false;if(h!=="cb"&&h!=="subgrid"&&h!=="rn"){U=h==y.p.ExpandColumn&&y.p.treeGrid===true?a(this).text():a(this).html();a.extend({},y.p.colModel[K].editoptions||{});h=a.jgrid.jqID("v_"+h);a("#"+h+" span","#"+s).html(U);O&&a("#"+h,"#"+s).parents("tr:first").hide();N++}});N>0&&a("#id_g","#"+s).val(l)}}function G(l,y){l===0?a("#pData","#"+s+"_2").addClass("ui-state-disabled"):a("#pData","#"+s+"_2").removeClass("ui-state-disabled");
l==y?a("#nData","#"+s+"_2").addClass("ui-state-disabled"):a("#nData","#"+s+"_2").removeClass("ui-state-disabled")}function B(){var l=a(w).jqGrid("getDataIDs"),y=a("#id_g","#"+s).val();return[a.inArray(y,l),l]}var w=this;if(w.grid&&f){var n=w.p.id,j="ViewGrid_"+n,s="ViewTbl_"+n,M={themodal:"viewmod"+n,modalhead:"viewhd"+n,modalcontent:"viewcnt"+n,scrollelm:j},c=a.isFunction(b.beforeInitData)?b.beforeInitData:false,t=true,o=1,i=0;if(a("#"+M.themodal).html()!==null){if(c){t=c(a("#"+j));if(typeof t==
"undefined")t=true}if(t===false)return;a(".ui-jqdialog-title","#"+M.modalhead).html(b.caption);a("#FormError","#"+s).hide();x(f,w);a.isFunction(b.beforeShowForm)&&b.beforeShowForm(a("#"+j));a.jgrid.viewModal("#"+M.themodal,{gbox:"#gbox_"+n,jqm:b.jqModal,jqM:false,overlay:b.overlay,modal:b.modal});e()}else{var m=isNaN(b.dataheight)?b.dataheight:b.dataheight+"px";m=a("<form name='FormPost' id='"+j+"' class='FormGrid' style='width:100%;overflow:auto;position:relative;height:"+m+";'></form>");var H=a("<table id='"+
s+"' class='EditTable' cellspacing='1' cellpadding='2' border='0' style='table-layout:fixed'><tbody></tbody></table>");if(c){t=c(a("#"+j));if(typeof t=="undefined")t=true}if(t===false)return;a(w.p.colModel).each(function(){var l=this.formoptions;o=Math.max(o,l?l.colpos||0:0);i=Math.max(i,l?l.rowpos||0:0)});a(m).append(H);q(f,w,H,o);c=w.p.direction=="rtl"?true:false;t="<a href='javascript:void(0)' id='"+(c?"nData":"pData")+"' class='fm-button ui-state-default ui-corner-left'><span class='ui-icon ui-icon-triangle-1-w'></span></a>";
var J="<a href='javascript:void(0)' id='"+(c?"pData":"nData")+"' class='fm-button ui-state-default ui-corner-right'><span class='ui-icon ui-icon-triangle-1-e'></span></a>",u="<a href='javascript:void(0)' id='cData' class='fm-button ui-state-default ui-corner-all'>"+b.bClose+"</a>";if(i>0){var C=[];a.each(a(H)[0].rows,function(l,y){C[l]=y});C.sort(function(l,y){if(l.rp>y.rp)return 1;if(l.rp<y.rp)return-1;return 0});a.each(C,function(l,y){a("tbody",H).append(y)})}b.gbox="#gbox_"+n;var A=false;if(b.closeOnEscape===
true){b.closeOnEscape=false;A=true}m=a("<span></span>").append(m).append("<table border='0' class='EditTable' id='"+s+"_2'><tbody><tr id='Act_Buttons'><td class='navButton' width='"+b.labelswidth+"'>"+(c?J+t:t+J)+"</td><td class='EditButton'>"+u+"</td></tr></tbody></table>");a.jgrid.createModal(M,m,b,"#gview_"+w.p.id,a("#gview_"+w.p.id)[0]);if(c){a("#pData, #nData","#"+s+"_2").css("float","right");a(".EditButton","#"+s+"_2").css("text-align","left")}b.viewPagerButtons||a("#pData, #nData","#"+s+"_2").hide();
m=null;a("#"+M.themodal).keydown(function(l){if(l.which===27){A&&a.jgrid.hideModal(this,{gb:b.gbox,jqm:b.jqModal,onClose:b.onClose});return false}if(b.navkeys[0]===true){if(l.which===b.navkeys[1]){a("#pData","#"+s+"_2").trigger("click");return false}if(l.which===b.navkeys[2]){a("#nData","#"+s+"_2").trigger("click");return false}}});b.closeicon=a.extend([true,"left","ui-icon-close"],b.closeicon);if(b.closeicon[0]===true)a("#cData","#"+s+"_2").addClass(b.closeicon[1]=="right"?"fm-button-icon-right":
"fm-button-icon-left").append("<span class='ui-icon "+b.closeicon[2]+"'></span>");a.isFunction(b.beforeShowForm)&&b.beforeShowForm(a("#"+j));a.jgrid.viewModal("#"+M.themodal,{gbox:"#gbox_"+n,jqm:b.jqModal,modal:b.modal});a(".fm-button:not(.ui-state-disabled)","#"+s+"_2").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});e();a("#cData","#"+s+"_2").click(function(){a.jgrid.hideModal("#"+M.themodal,{gb:"#gbox_"+n,jqm:b.jqModal,onClose:b.onClose});
return false});a("#nData","#"+s+"_2").click(function(){a("#FormError","#"+s).hide();var l=B();l[0]=parseInt(l[0],10);if(l[0]!=-1&&l[1][l[0]+1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("next",a("#"+j),l[1][l[0]]);x(l[1][l[0]+1],w);a(w).jqGrid("setSelection",l[1][l[0]+1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("next",a("#"+j),l[1][l[0]+1]);G(l[0]+1,l[1].length-1)}e();return false});a("#pData","#"+s+"_2").click(function(){a("#FormError","#"+s).hide();var l=B();if(l[0]!=
-1&&l[1][l[0]-1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("prev",a("#"+j),l[1][l[0]]);x(l[1][l[0]-1],w);a(w).jqGrid("setSelection",l[1][l[0]-1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("prev",a("#"+j),l[1][l[0]-1]);G(l[0]-1,l[1].length-1)}e();return false})}m=B();G(m[0],m[1].length-1)}})},delGridRow:function(f,b){b=a.extend({top:0,left:0,width:240,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,url:"",mtype:"POST",reloadAfterSubmit:true,
beforeShowForm:null,beforeInitData:null,afterShowForm:null,beforeSubmit:null,onclickSubmit:null,afterSubmit:null,jqModal:true,closeOnEscape:false,delData:{},delicon:[],cancelicon:[],onClose:null,ajaxDelOptions:{},processing:false,serializeDelData:null,useDataProxy:false},a.jgrid.del,b||{});d[a(this)[0].p.id]=b;return this.each(function(){var e=this;if(e.grid)if(f){var q=a.isFunction(d[e.p.id].beforeShowForm),x=a.isFunction(d[e.p.id].afterShowForm),G=a.isFunction(d[e.p.id].beforeInitData)?d[e.p.id].beforeInitData:
false,B=e.p.id,w={},n=true,j="DelTbl_"+B,s,M,c,t,o={themodal:"delmod"+B,modalhead:"delhd"+B,modalcontent:"delcnt"+B,scrollelm:j};if(jQuery.isArray(f))f=f.join();if(a("#"+o.themodal).html()!==null){if(G){n=G(a("#"+j));if(typeof n=="undefined")n=true}if(n===false)return;a("#DelData>td","#"+j).text(f);a("#DelError","#"+j).hide();if(d[e.p.id].processing===true){d[e.p.id].processing=false;a("#dData","#"+j).removeClass("ui-state-active")}q&&d[e.p.id].beforeShowForm(a("#"+j));a.jgrid.viewModal("#"+o.themodal,
{gbox:"#gbox_"+B,jqm:d[e.p.id].jqModal,jqM:false,overlay:d[e.p.id].overlay,modal:d[e.p.id].modal})}else{var i=isNaN(d[e.p.id].dataheight)?d[e.p.id].dataheight:d[e.p.id].dataheight+"px";i="<div id='"+j+"' class='formdata' style='width:100%;overflow:auto;position:relative;height:"+i+";'>";i+="<table class='DelTable'><tbody>";i+="<tr id='DelError' style='display:none'><td class='ui-state-error'></td></tr>";i+="<tr id='DelData' style='display:none'><td >"+f+"</td></tr>";i+='<tr><td class="delmsg" style="white-space:pre;">'+
d[e.p.id].msg+"</td></tr><tr><td >&#160;</td></tr>";i+="</tbody></table></div>";i+="<table cellspacing='0' cellpadding='0' border='0' class='EditTable' id='"+j+"_2'><tbody><tr><td><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr><td class='DelButton EditButton'>"+("<a href='javascript:void(0)' id='dData' class='fm-button ui-state-default ui-corner-all'>"+b.bSubmit+"</a>")+"&#160;"+("<a href='javascript:void(0)' id='eData' class='fm-button ui-state-default ui-corner-all'>"+b.bCancel+
"</a>")+"</td></tr></tbody></table>";b.gbox="#gbox_"+B;a.jgrid.createModal(o,i,b,"#gview_"+e.p.id,a("#gview_"+e.p.id)[0]);if(G){n=G(a("#"+j));if(typeof n=="undefined")n=true}if(n===false)return;a(".fm-button","#"+j+"_2").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});b.delicon=a.extend([true,"left","ui-icon-scissors"],d[e.p.id].delicon);b.cancelicon=a.extend([true,"left","ui-icon-cancel"],d[e.p.id].cancelicon);if(b.delicon[0]===true)a("#dData",
"#"+j+"_2").addClass(b.delicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.delicon[2]+"'></span>");if(b.cancelicon[0]===true)a("#eData","#"+j+"_2").addClass(b.cancelicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.cancelicon[2]+"'></span>");a("#dData","#"+j+"_2").click(function(){var m=[true,""];w={};var H=a("#DelData>td","#"+j).text();if(a.isFunction(d[e.p.id].onclickSubmit))w=d[e.p.id].onclickSubmit(d[e.p.id],
H)||{};if(a.isFunction(d[e.p.id].beforeSubmit))m=d[e.p.id].beforeSubmit(H);if(m[0]&&!d[e.p.id].processing){d[e.p.id].processing=true;a(this).addClass("ui-state-active");c=e.p.prmNames;s=a.extend({},d[e.p.id].delData,w);t=c.oper;s[t]=c.deloper;M=c.id;H=H.split(",");for(var J in H)if(H.hasOwnProperty(J))H[J]=a.jgrid.stripPref(e.p.idPrefix,H[J]);s[M]=H.join();J=a.extend({url:d[e.p.id].url?d[e.p.id].url:a(e).jqGrid("getGridParam","editurl"),type:d[e.p.id].mtype,data:a.isFunction(d[e.p.id].serializeDelData)?
d[e.p.id].serializeDelData(s):s,complete:function(u,C){if(C!="success"){m[0]=false;m[1]=a.isFunction(d[e.p.id].errorTextFormat)?d[e.p.id].errorTextFormat(u):C+" Status: '"+u.statusText+"'. Error code: "+u.status}else if(a.isFunction(d[e.p.id].afterSubmit))m=d[e.p.id].afterSubmit(u,s);if(m[0]===false){a("#DelError>td","#"+j).html(m[1]);a("#DelError","#"+j).show()}else{if(d[e.p.id].reloadAfterSubmit&&e.p.datatype!="local")a(e).trigger("reloadGrid");else{var A=[];A=H.split(",");if(e.p.treeGrid===true)try{a(e).jqGrid("delTreeNode",
e.p.idPrefix+A[0])}catch(l){}else for(var y=0;y<A.length;y++)a(e).jqGrid("delRowData",e.p.idPrefix+A[y]);e.p.selrow=null;e.p.selarrrow=[]}a.isFunction(d[e.p.id].afterComplete)&&setTimeout(function(){d[e.p.id].afterComplete(u,H)},500)}d[e.p.id].processing=false;a("#dData","#"+j+"_2").removeClass("ui-state-active");m[0]&&a.jgrid.hideModal("#"+o.themodal,{gb:"#gbox_"+B,jqm:b.jqModal,onClose:d[e.p.id].onClose})}},a.jgrid.ajaxOptions,d[e.p.id].ajaxDelOptions);if(!J.url&&!d[e.p.id].useDataProxy)if(a.isFunction(e.p.dataProxy))d[e.p.id].useDataProxy=
true;else{m[0]=false;m[1]+=" "+a.jgrid.errors.nourl}if(m[0])if(d[e.p.id].useDataProxy){J=e.p.dataProxy.call(e,J,"del_"+e.p.id);if(typeof J=="undefined")J=[true,""];if(J[0]===false){m[0]=false;m[1]=J[1]||"Error deleting the selected row!"}else a.jgrid.hideModal("#"+o.themodal,{gb:"#gbox_"+B,jqm:b.jqModal,onClose:d[e.p.id].onClose})}else a.ajax(J)}if(m[0]===false){a("#DelError>td","#"+j).html(m[1]);a("#DelError","#"+j).show()}return false});a("#eData","#"+j+"_2").click(function(){a.jgrid.hideModal("#"+
o.themodal,{gb:"#gbox_"+B,jqm:d[e.p.id].jqModal,onClose:d[e.p.id].onClose});return false});q&&d[e.p.id].beforeShowForm(a("#"+j));a.jgrid.viewModal("#"+o.themodal,{gbox:"#gbox_"+B,jqm:d[e.p.id].jqModal,overlay:d[e.p.id].overlay,modal:d[e.p.id].modal})}x&&d[e.p.id].afterShowForm(a("#"+j));d[e.p.id].closeOnEscape===true&&setTimeout(function(){a(".ui-jqdialog-titlebar-close","#"+o.modalhead).focus()},0)}})},navGrid:function(f,b,e,q,x,G,B){b=a.extend({edit:true,editicon:"ui-icon-pencil",add:true,addicon:"ui-icon-plus",
del:true,delicon:"ui-icon-trash",search:true,searchicon:"ui-icon-search",refresh:true,refreshicon:"ui-icon-refresh",refreshstate:"firstpage",view:false,viewicon:"ui-icon-document",position:"left",closeOnEscape:true,beforeRefresh:null,afterRefresh:null,cloneToTop:false,alertwidth:200,alertheight:"auto",alerttop:null,alertleft:null,alertzIndex:null},a.jgrid.nav,b||{});return this.each(function(){if(!this.nav){var w={themodal:"alertmod",modalhead:"alerthd",modalcontent:"alertcnt"},n=this,j;if(!(!n.grid||
typeof f!="string")){if(a("#"+w.themodal).html()===null){if(!b.alerttop&&!b.alertleft){if(typeof window.innerWidth!="undefined"){b.alertleft=window.innerWidth;b.alerttop=window.innerHeight}else if(typeof document.documentElement!="undefined"&&typeof document.documentElement.clientWidth!="undefined"&&document.documentElement.clientWidth!==0){b.alertleft=document.documentElement.clientWidth;b.alerttop=document.documentElement.clientHeight}else{b.alertleft=1024;b.alerttop=768}b.alertleft=b.alertleft/
2-parseInt(b.alertwidth,10)/2;b.alerttop=b.alerttop/2-25}a.jgrid.createModal(w,"<div>"+b.alerttext+"</div><span tabindex='0'><span tabindex='-1' id='jqg_alrt'></span></span>",{gbox:"#gbox_"+n.p.id,jqModal:true,drag:true,resize:true,caption:b.alertcap,top:b.alerttop,left:b.alertleft,width:b.alertwidth,height:b.alertheight,closeOnEscape:b.closeOnEscape,zIndex:b.alertzIndex},"","",true)}var s=1;if(b.cloneToTop&&n.p.toppager)s=2;for(var M=0;M<s;M++){var c=a("<table cellspacing='0' cellpadding='0' border='0' class='ui-pg-table navtable' style='float:left;table-layout:auto;'><tbody><tr></tr></tbody></table>"),
t,o;if(M===0){t=f;o=n.p.id;if(t==n.p.toppager){o+="_top";s=1}}else{t=n.p.toppager;o=n.p.id+"_top"}n.p.direction=="rtl"&&a(c).attr("dir","rtl").css("float","right");if(b.add){q=q||{};j=a("<td class='ui-pg-button ui-corner-all'></td>");a(j).append("<div class='ui-pg-div'><span class='ui-icon "+b.addicon+"'></span>"+b.addtext+"</div>");a("tr",c).append(j);a(j,c).attr({title:b.addtitle||"",id:q.id||"add_"+o}).click(function(){a(this).hasClass("ui-state-disabled")||(a.isFunction(b.addfunc)?b.addfunc():
a(n).jqGrid("editGridRow","new",q));return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});j=null}if(b.edit){j=a("<td class='ui-pg-button ui-corner-all'></td>");e=e||{};a(j).append("<div class='ui-pg-div'><span class='ui-icon "+b.editicon+"'></span>"+b.edittext+"</div>");a("tr",c).append(j);a(j,c).attr({title:b.edittitle||"",id:e.id||"edit_"+o}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var i=
n.p.selrow;if(i)a.isFunction(b.editfunc)?b.editfunc(i):a(n).jqGrid("editGridRow",i,e);else{a.jgrid.viewModal("#"+w.themodal,{gbox:"#gbox_"+n.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});j=null}if(b.view){j=a("<td class='ui-pg-button ui-corner-all'></td>");B=B||{};a(j).append("<div class='ui-pg-div'><span class='ui-icon "+b.viewicon+"'></span>"+b.viewtext+
"</div>");a("tr",c).append(j);a(j,c).attr({title:b.viewtitle||"",id:B.id||"view_"+o}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var i=n.p.selrow;if(i)a.isFunction(b.viewfunc)?b.viewfunc(i):a(n).jqGrid("viewGridRow",i,B);else{a.jgrid.viewModal("#"+w.themodal,{gbox:"#gbox_"+n.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});j=null}if(b.del){j=
a("<td class='ui-pg-button ui-corner-all'></td>");x=x||{};a(j).append("<div class='ui-pg-div'><span class='ui-icon "+b.delicon+"'></span>"+b.deltext+"</div>");a("tr",c).append(j);a(j,c).attr({title:b.deltitle||"",id:x.id||"del_"+o}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var i;if(n.p.multiselect){i=n.p.selarrrow;if(i.length===0)i=null}else i=n.p.selrow;if(i)"function"==typeof b.delfunc?b.delfunc(i):a(n).jqGrid("delGridRow",i,x);else{a.jgrid.viewModal("#"+w.themodal,{gbox:"#gbox_"+
n.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});j=null}if(b.add||b.edit||b.del||b.view)a("tr",c).append("<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>");if(b.search){j=a("<td class='ui-pg-button ui-corner-all'></td>");G=G||{};a(j).append("<div class='ui-pg-div'><span class='ui-icon "+b.searchicon+
"'></span>"+b.searchtext+"</div>");a("tr",c).append(j);a(j,c).attr({title:b.searchtitle||"",id:G.id||"search_"+o}).click(function(){a(this).hasClass("ui-state-disabled")||a(n).jqGrid("searchGrid",G);return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});G.showOnLoad&&G.showOnLoad===true&&a(j,c).click();j=null}if(b.refresh){j=a("<td class='ui-pg-button ui-corner-all'></td>");a(j).append("<div class='ui-pg-div'><span class='ui-icon "+
b.refreshicon+"'></span>"+b.refreshtext+"</div>");a("tr",c).append(j);a(j,c).attr({title:b.refreshtitle||"",id:"refresh_"+o}).click(function(){if(!a(this).hasClass("ui-state-disabled")){a.isFunction(b.beforeRefresh)&&b.beforeRefresh();n.p.search=false;try{var i=n.p.id;n.p.postData.filters="";a("#fbox_"+i).jqFilter("resetFilter");a.isFunction(n.clearToolbar)&&n.clearToolbar(false)}catch(m){}switch(b.refreshstate){case "firstpage":a(n).trigger("reloadGrid",[{page:1}]);break;case "current":a(n).trigger("reloadGrid",
[{current:true}])}a.isFunction(b.afterRefresh)&&b.afterRefresh()}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});j=null}j=a(".ui-jqgrid").css("font-size")||"11px";a("body").append("<div id='testpg2' class='ui-jqgrid ui-widget ui-widget-content' style='font-size:"+j+";visibility:hidden;' ></div>");j=a(c).clone().appendTo("#testpg2").width();a("#testpg2").remove();a(t+"_"+b.position,t).append(c);
if(n.p._nvtd){if(j>n.p._nvtd[0]){a(t+"_"+b.position,t).width(j);n.p._nvtd[0]=j}n.p._nvtd[1]=j}c=j=j=null;this.nav=true}}}})},navButtonAdd:function(f,b){b=a.extend({caption:"newButton",title:"",buttonicon:"ui-icon-newwin",onClickButton:null,position:"last",cursor:"pointer"},b||{});return this.each(function(){if(this.grid){if(f.indexOf("#")!==0)f="#"+f;var e=a(".navtable",f)[0],q=this;if(e)if(!(b.id&&a("#"+b.id,e).html()!==null)){var x=a("<td></td>");b.buttonicon.toString().toUpperCase()=="NONE"?a(x).addClass("ui-pg-button ui-corner-all").append("<div class='ui-pg-div'>"+
b.caption+"</div>"):a(x).addClass("ui-pg-button ui-corner-all").append("<div class='ui-pg-div'><span class='ui-icon "+b.buttonicon+"'></span>"+b.caption+"</div>");b.id&&a(x).attr("id",b.id);if(b.position=="first")e.rows[0].cells.length===0?a("tr",e).append(x):a("tr td:eq(0)",e).before(x);else a("tr",e).append(x);a(x,e).attr("title",b.title||"").click(function(G){a(this).hasClass("ui-state-disabled")||a.isFunction(b.onClickButton)&&b.onClickButton.call(q,G);return false}).hover(function(){a(this).hasClass("ui-state-disabled")||
a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")})}}})},navSeparatorAdd:function(f,b){b=a.extend({sepclass:"ui-separator",sepcontent:""},b||{});return this.each(function(){if(this.grid){if(f.indexOf("#")!==0)f="#"+f;var e=a(".navtable",f)[0];if(e){var q="<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='"+b.sepclass+"'></span>"+b.sepcontent+"</td>";a("tr",e).append(q)}}})},GridToForm:function(f,b){return this.each(function(){var e=this;
if(e.grid){var q=a(e).jqGrid("getRowData",f);if(q)for(var x in q)a("[name="+a.jgrid.jqID(x)+"]",b).is("input:radio")||a("[name="+a.jgrid.jqID(x)+"]",b).is("input:checkbox")?a("[name="+a.jgrid.jqID(x)+"]",b).each(function(){if(a(this).val()==q[x])a(this)[e.p.useProp?"prop":"attr"]("checked",true);else a(this)[e.p.useProp?"prop":"attr"]("checked",false)}):a("[name="+a.jgrid.jqID(x)+"]",b).val(q[x])}})},FormToGrid:function(f,b,e,q){return this.each(function(){if(this.grid){e||(e="set");q||(q="first");
var x=a(b).serializeArray(),G={};a.each(x,function(B,w){G[w.name]=w.value});if(e=="add")a(this).jqGrid("addRowData",f,G,q);else e=="set"&&a(this).jqGrid("setRowData",f,G)}})}})})(jQuery);
(function(c){c.fn.jqFilter=function(k){if(typeof k==="string"){var w=c.fn.jqFilter[k];if(!w)throw"jqFilter - No such method: "+k;var B=c.makeArray(arguments).slice(1);return w.apply(this,B)}var o=c.extend(true,{filter:null,columns:[],onChange:null,afterRedraw:null,checkValues:null,error:false,errmsg:"",errorcheck:true,showQuery:true,sopt:null,ops:[{name:"eq",description:"equal",operator:"="},{name:"ne",description:"not equal",operator:"<>"},{name:"lt",description:"less",operator:"<"},{name:"le",description:"less or equal",
operator:"<="},{name:"gt",description:"greater",operator:">"},{name:"ge",description:"greater or equal",operator:">="},{name:"bw",description:"begins with",operator:"LIKE"},{name:"bn",description:"does not begin with",operator:"NOT LIKE"},{name:"in",description:"in",operator:"IN"},{name:"ni",description:"not in",operator:"NOT IN"},{name:"ew",description:"ends with",operator:"LIKE"},{name:"en",description:"does not end with",operator:"NOT LIKE"},{name:"cn",description:"contains",operator:"LIKE"},{name:"nc",
description:"does not contain",operator:"NOT LIKE"},{name:"nu",description:"is null",operator:"IS NULL"},{name:"nn",description:"is not null",operator:"IS NOT NULL"}],numopts:["eq","ne","lt","le","gt","ge","nu","nn","in","ni"],stropts:["eq","ne","bw","bn","ew","en","cn","nc","nu","nn","in","ni"],_gridsopt:[],groupOps:[{op:"AND",text:"AND"},{op:"OR",text:"OR"}],groupButton:true,ruleButtons:true,direction:"ltr"},k||{});return this.each(function(){if(!this.filter){this.p=o;if(this.p.filter===null||this.p.filter===
undefined)this.p.filter={groupOp:this.p.groupOps[0].op,rules:[],groups:[]};var q,x=this.p.columns.length,j,y=/msie/i.test(navigator.userAgent)&&!window.opera;if(this.p._gridsopt.length)for(q=0;q<this.p._gridsopt.length;q++)this.p.ops[q].description=this.p._gridsopt[q];this.p.initFilter=c.extend(true,{},this.p.filter);if(x){for(q=0;q<x;q++){j=this.p.columns[q];if(j.stype)j.inputtype=j.stype;else if(!j.inputtype)j.inputtype="text";if(j.sorttype)j.searchtype=j.sorttype;else if(!j.searchtype)j.searchtype=
"string";if(j.hidden===undefined)j.hidden=false;if(!j.label)j.label=j.name;if(j.index)j.name=j.index;if(!j.hasOwnProperty("searchoptions"))j.searchoptions={};if(!j.hasOwnProperty("searchrules"))j.searchrules={}}this.p.showQuery&&c(this).append("<table class='queryresult ui-widget ui-widget-content' style='display:block;max-width:440px;border:0px none;' dir='"+this.p.direction+"'><tbody><tr><td class='query'></td></tr></tbody></table>");var z=function(d,g){var a=[true,""];if(c.isFunction(g.searchrules))a=
g.searchrules(d,g);else if(c.jgrid&&c.jgrid.checkValues)try{a=c.jgrid.checkValues(d,-1,null,g.searchrules,g.label)}catch(b){}if(a&&a.length&&a[0]===false){o.error=!a[0];o.errmsg=a[1]}};this.onchange=function(){this.p.error=false;this.p.errmsg="";return c.isFunction(this.p.onChange)?this.p.onChange.call(this,this.p):false};this.reDraw=function(){c("table.group:first",this).remove();var d=this.createTableForGroup(o.filter,null);c(this).append(d);c.isFunction(this.p.afterRedraw)&&this.p.afterRedraw.call(this,
this.p)};this.createTableForGroup=function(d,g){var a=this,b,e=c("<table class='group ui-widget ui-widget-content' style='border:0px none;'><tbody></tbody></table>"),i="left";if(this.p.direction=="rtl"){i="right";e.attr("dir","rtl")}g===null&&e.append("<tr class='error' style='display:none;'><th colspan='5' class='ui-state-error' align='"+i+"'></th></tr>");var f=c("<tr></tr>");e.append(f);i=c("<th colspan='5' align='"+i+"'></th>");f.append(i);if(this.p.ruleButtons===true){var h=c("<select class='opsel'></select>");
i.append(h);f="";var l;for(b=0;b<o.groupOps.length;b++){l=d.groupOp===a.p.groupOps[b].op?" selected='selected'":"";f+="<option value='"+a.p.groupOps[b].op+"'"+l+">"+a.p.groupOps[b].text+"</option>"}h.append(f).bind("change",function(){d.groupOp=c(h).val();a.onchange()})}f="<span></span>";if(this.p.groupButton){f=c("<input type='button' value='+ {}' title='Add subgroup' class='add-group'/>");f.bind("click",function(){if(d.groups===undefined)d.groups=[];d.groups.push({groupOp:o.groupOps[0].op,rules:[],
groups:[]});a.reDraw();a.onchange();return false})}i.append(f);if(this.p.ruleButtons===true){f=c("<input type='button' value='+' title='Add rule' class='add-rule ui-add'/>");var m;f.bind("click",function(){if(d.rules===undefined)d.rules=[];for(b=0;b<a.p.columns.length;b++){var n=typeof a.p.columns[b].search==="undefined"?true:a.p.columns[b].search,s=a.p.columns[b].hidden===true;if(a.p.columns[b].searchoptions.searchhidden===true&&n||n&&!s){m=a.p.columns[b];break}}d.rules.push({field:m.name,op:(m.searchoptions.sopt?
m.searchoptions.sopt:a.p.sopt?a.p.sopt:m.searchtype==="string"?a.p.stropts:a.p.numopts)[0],data:""});a.reDraw();return false});i.append(f)}if(g!==null){f=c("<input type='button' value='-' title='Delete group' class='delete-group'/>");i.append(f);f.bind("click",function(){for(b=0;b<g.groups.length;b++)if(g.groups[b]===d){g.groups.splice(b,1);break}a.reDraw();a.onchange();return false})}if(d.groups!==undefined)for(b=0;b<d.groups.length;b++){i=c("<tr></tr>");e.append(i);f=c("<td class='first'></td>");
i.append(f);f=c("<td colspan='4'></td>");f.append(this.createTableForGroup(d.groups[b],d));i.append(f)}if(d.groupOp===undefined)d.groupOp=a.p.groupOps[0].op;if(d.rules!==undefined)for(b=0;b<d.rules.length;b++)e.append(this.createTableRowForRule(d.rules[b],d));return e};this.createTableRowForRule=function(d,g){var a=this,b=c("<tr></tr>"),e,i,f,h,l="",m;b.append("<td class='first'></td>");var n=c("<td class='columns'></td>");b.append(n);var s=c("<select></select>"),p,t=[];n.append(s);s.bind("change",
function(){d.field=c(s).val();f=c(this).parents("tr:first");for(e=0;e<a.p.columns.length;e++)if(a.p.columns[e].name===d.field){h=a.p.columns[e];break}if(h){h.searchoptions.id=c.jgrid.randId();if(y&&h.inputtype==="text")if(!h.searchoptions.size)h.searchoptions.size=10;var r=c.jgrid.createEl(h.inputtype,h.searchoptions,"",true,a.p.ajaxSelectOptions,true);c(r).addClass("input-elm");i=h.searchoptions.sopt?h.searchoptions.sopt:a.p.sopt?a.p.sopt:h.searchtype==="string"?a.p.stropts:a.p.numopts;var u="",
A=0;t=[];c.each(a.p.ops,function(){t.push(this.name)});for(e=0;e<i.length;e++){p=c.inArray(i[e],t);if(p!==-1){if(A===0)d.op=a.p.ops[p].name;u+="<option value='"+a.p.ops[p].name+"'>"+a.p.ops[p].description+"</option>";A++}}c(".selectopts",f).empty().append(u);c(".selectopts",f)[0].selectedIndex=0;if(c.browser.msie&&c.browser.version<9){u=parseInt(c("select.selectopts",f)[0].offsetWidth)+1;c(".selectopts",f).width(u);c(".selectopts",f).css("width","auto")}c(".data",f).empty().append(r);c(".input-elm",
f).bind("change",function(){d.data=c(this).val();a.onchange()});setTimeout(function(){d.data=c(r).val();a.onchange()},0)}});for(e=n=0;e<a.p.columns.length;e++){m=typeof a.p.columns[e].search==="undefined"?true:a.p.columns[e].search;var C=a.p.columns[e].hidden===true;if(a.p.columns[e].searchoptions.searchhidden===true&&m||m&&!C){m="";if(d.field===a.p.columns[e].name){m=" selected='selected'";n=e}l+="<option value='"+a.p.columns[e].name+"'"+m+">"+a.p.columns[e].label+"</option>"}}s.append(l);l=c("<td class='operators'></td>");
b.append(l);h=o.columns[n];h.searchoptions.id=c.jgrid.randId();if(y&&h.inputtype==="text")if(!h.searchoptions.size)h.searchoptions.size=10;n=c.jgrid.createEl(h.inputtype,h.searchoptions,d.data,true,a.p.ajaxSelectOptions,true);var v=c("<select class='selectopts'></select>");l.append(v);v.bind("change",function(){d.op=c(v).val();f=c(this).parents("tr:first");var r=c(".input-elm",f)[0];if(d.op==="nu"||d.op==="nn"){d.data="";r.value="";r.setAttribute("readonly","true");r.setAttribute("disabled","true")}else{r.removeAttribute("readonly");
r.removeAttribute("disabled")}a.onchange()});i=h.searchoptions.sopt?h.searchoptions.sopt:a.p.sopt?a.p.sopt:h.searchtype==="string"?o.stropts:a.p.numopts;l="";c.each(a.p.ops,function(){t.push(this.name)});for(e=0;e<i.length;e++){p=c.inArray(i[e],t);if(p!==-1){m=d.op===a.p.ops[p].name?" selected='selected'":"";l+="<option value='"+a.p.ops[p].name+"'"+m+">"+a.p.ops[p].description+"</option>"}}v.append(l);l=c("<td class='data'></td>");b.append(l);l.append(n);c(n).addClass("input-elm").bind("change",function(){d.data=
c(this).val();a.onchange()});l=c("<td></td>");b.append(l);if(this.p.ruleButtons===true){n=c("<input type='button' value='-' title='Delete rule' class='delete-rule ui-del'/>");l.append(n);n.bind("click",function(){for(e=0;e<g.rules.length;e++)if(g.rules[e]===d){g.rules.splice(e,1);break}a.reDraw();a.onchange();return false})}return b};this.getStringForGroup=function(d){var g="(",a;if(d.groups!==undefined)for(a=0;a<d.groups.length;a++){if(g.length>1)g+=" "+d.groupOp+" ";try{g+=this.getStringForGroup(d.groups[a])}catch(b){alert(b)}}if(d.rules!==
undefined)try{for(a=0;a<d.rules.length;a++){if(g.length>1)g+=" "+d.groupOp+" ";g+=this.getStringForRule(d.rules[a])}}catch(e){alert(e)}g+=")";return g==="()"?"":g};this.getStringForRule=function(d){var g="",a="",b,e;for(b=0;b<this.p.ops.length;b++)if(this.p.ops[b].name===d.op){g=this.p.ops[b].operator;a=this.p.ops[b].name;break}for(b=0;b<this.p.columns.length;b++)if(this.p.columns[b].name===d.field){e=this.p.columns[b];break}b=d.data;if(a==="bw"||a==="bn")b+="%";if(a==="ew"||a==="en")b="%"+b;if(a===
"cn"||a==="nc")b="%"+b+"%";if(a==="in"||a==="ni")b=" ("+b+")";o.errorcheck&&z(d.data,e);return c.inArray(e.searchtype,["int","integer","float","number","currency"])!==-1||a==="nn"||a==="nu"?d.field+" "+g+" "+b:d.field+" "+g+' "'+b+'"'};this.resetFilter=function(){this.p.filter=c.extend(true,{},this.p.initFilter);this.reDraw();this.onchange()};this.hideError=function(){c("th.ui-state-error",this).html("");c("tr.error",this).hide()};this.showError=function(){c("th.ui-state-error",this).html(this.p.errmsg);
c("tr.error",this).show()};this.toUserFriendlyString=function(){return this.getStringForGroup(o.filter)};this.toString=function(){function d(a){var b="(",e;if(a.groups!==undefined)for(e=0;e<a.groups.length;e++){if(b.length>1)b+=a.groupOp==="OR"?" || ":" && ";b+=d(a.groups[e])}if(a.rules!==undefined)for(e=0;e<a.rules.length;e++){if(b.length>1)b+=a.groupOp==="OR"?" || ":" && ";var i=a.rules[e];if(g.p.errorcheck){var f=void 0,h=void 0;for(f=0;f<g.p.columns.length;f++)if(g.p.columns[f].name===i.field){h=
g.p.columns[f];break}h&&z(i.data,h)}b+=i.op+"(item."+i.field+",'"+i.data+"')"}b+=")";return b==="()"?"":b}var g=this;return d(this.p.filter)};this.reDraw();if(this.p.showQuery)this.onchange();this.filter=true}}})};c.extend(c.fn.jqFilter,{toSQLString:function(){var k="";this.each(function(){k=this.toUserFriendlyString()});return k},filterData:function(){var k;this.each(function(){k=this.p.filter});return k},getParameter:function(k){if(k!==undefined)if(this.p.hasOwnProperty(k))return this.p[k];return this.p},
resetFilter:function(){return this.each(function(){this.resetFilter()})},addFilter:function(k){if(typeof k==="string")k=jQuery.jgrid.parse(k);this.each(function(){this.p.filter=k;this.reDraw();this.onchange()})}})})(jQuery);
(function(a){a.jgrid.inlineEdit=a.jgrid.inlineEdit||{};a.jgrid.extend({editRow:function(c,d,b,h,l,n,s,o,f){var m={},g=a.makeArray(arguments).slice(1);if(a.jgrid.realType(g[0])==="Object")m=g[0];else{if(typeof d!=="undefined")m.keys=d;if(a.isFunction(b))m.oneditfunc=b;if(a.isFunction(h))m.successfunc=h;if(typeof l!=="undefined")m.url=l;if(typeof n!=="undefined")m.extraparam=n;if(a.isFunction(s))m.aftersavefunc=s;if(a.isFunction(o))m.errorfunc=o;if(a.isFunction(f))m.afterrestorefunc=f}m=a.extend(true,
{keys:false,oneditfunc:null,successfunc:null,url:null,extraparam:{},aftersavefunc:null,errorfunc:null,afterrestorefunc:null,restoreAfterError:true,mtype:"POST"},a.jgrid.inlineEdit,m);return this.each(function(){var i=this,e,q,w=0,x=null,v={},r,j;if(i.grid){r=a(i).jqGrid("getInd",c,true);if(r!==false)if((a(r).attr("editable")||"0")=="0"&&!a(r).hasClass("not-editable-row")){j=i.p.colModel;a('td[role="gridcell"]',r).each(function(k){e=j[k].name;var z=i.p.treeGrid===true&&e==i.p.ExpandColumn;if(z)q=a("span:first",
this).html();else try{q=a.unformat(this,{rowId:c,colModel:j[k]},k)}catch(A){q=j[k].edittype&&j[k].edittype=="textarea"?a(this).text():a(this).html()}if(e!="cb"&&e!="subgrid"&&e!="rn"){if(i.p.autoencode)q=a.jgrid.htmlDecode(q);v[e]=q;if(j[k].editable===true){if(x===null)x=k;z?a("span:first",this).html(""):a(this).html("");var p=a.extend({},j[k].editoptions||{},{id:c+"_"+e,name:e});if(!j[k].edittype)j[k].edittype="text";if(q=="&nbsp;"||q=="&#160;"||q.length==1&&q.charCodeAt(0)==160)q="";p=a.jgrid.createEl(j[k].edittype,
p,q,true,a.extend({},a.jgrid.ajaxOptions,i.p.ajaxSelectOptions||{}));a(p).addClass("editable");z?a("span:first",this).append(p):a(this).append(p);j[k].edittype=="select"&&typeof j[k].editoptions!=="undefined"&&j[k].editoptions.multiple===true&&typeof j[k].editoptions.dataUrl==="undefined"&&a.browser.msie&&a(p).width(a(p).width());w++}}});if(w>0){v.id=c;i.p.savedRow.push(v);a(r).attr("editable","1");a("td:eq("+x+") input",r).focus();m.keys===true&&a(r).bind("keydown",function(k){if(k.keyCode===27){a(i).jqGrid("restoreRow",
c,f);return false}if(k.keyCode===13){if(k.target.tagName=="TEXTAREA")return true;a(i).jqGrid("saveRow",c,m);return false}});a.isFunction(m.oneditfunc)&&m.oneditfunc.call(i,c)}}}})},saveRow:function(c,d,b,h,l,n,s){var o=a.makeArray(arguments).slice(1),f={};if(a.jgrid.realType(o[0])==="Object")f=o[0];else{if(a.isFunction(d))f.successfunc=d;if(typeof b!=="undefined")f.url=b;if(typeof h!=="undefined")f.extraparam=h;if(a.isFunction(l))f.aftersavefunc=l;if(a.isFunction(n))f.errorfunc=n;if(a.isFunction(s))f.afterrestorefunc=
s}f=a.extend(true,{successfunc:null,url:null,extraparam:{},aftersavefunc:null,errorfunc:null,afterrestorefunc:null,restoreAfterError:true,mtype:"POST"},a.jgrid.inlineEdit,f);var m=false,g=this[0],i,e={},q={},w={},x,v,r;if(!g.grid)return m;r=a(g).jqGrid("getInd",c,true);if(r===false)return m;o=a(r).attr("editable");f.url=f.url?f.url:g.p.editurl;if(o==="1"){var j;a('td[role="gridcell"]',r).each(function(p){j=g.p.colModel[p];i=j.name;if(i!="cb"&&i!="subgrid"&&j.editable===true&&i!="rn"&&!a(this).hasClass("not-editable-cell")){switch(j.edittype){case "checkbox":var t=
["Yes","No"];if(j.editoptions)t=j.editoptions.value.split(":");e[i]=a("input",this).is(":checked")?t[0]:t[1];break;case "text":case "password":case "textarea":case "button":e[i]=a("input, textarea",this).val();break;case "select":if(j.editoptions.multiple){t=a("select",this);var u=[];e[i]=a(t).val();e[i]=e[i]?e[i].join(","):"";a("select option:selected",this).each(function(B,C){u[B]=a(C).text()});q[i]=u.join(",")}else{e[i]=a("select option:selected",this).val();q[i]=a("select option:selected",this).text()}if(j.formatter&&
j.formatter=="select")q={};break;case "custom":try{if(j.editoptions&&a.isFunction(j.editoptions.custom_value)){e[i]=j.editoptions.custom_value.call(g,a(".customelement",this),"get");if(e[i]===undefined)throw"e2";}else throw"e1";}catch(y){y=="e1"&&a.jgrid.info_dialog(a.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.nodefined,a.jgrid.edit.bClose);y=="e2"?a.jgrid.info_dialog(a.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.novalue,a.jgrid.edit.bClose):a.jgrid.info_dialog(a.jgrid.errors.errcap,
y.message,a.jgrid.edit.bClose)}}v=a.jgrid.checkValues(e[i],p,g);if(v[0]===false){v[1]=e[i]+" "+v[1];return false}if(g.p.autoencode)e[i]=a.jgrid.htmlEncode(e[i]);if(f.url!=="clientArray"&&j.editoptions&&j.editoptions.NullIfEmpty===true)if(e[i]==="")w[i]="null"}});if(v[0]===false){try{var k=a.jgrid.findPos(a("#"+a.jgrid.jqID(c),g.grid.bDiv)[0]);a.jgrid.info_dialog(a.jgrid.errors.errcap,v[1],a.jgrid.edit.bClose,{left:k[0],top:k[1]})}catch(z){alert(v[1])}return m}var A;o=g.p.prmNames;A=o.oper;k=o.id;
if(e){e[A]=o.editoper;e[k]=c;if(typeof g.p.inlineData=="undefined")g.p.inlineData={};e=a.extend({},e,g.p.inlineData,f.extraparam)}if(f.url=="clientArray"){e=a.extend({},e,q);g.p.autoencode&&a.each(e,function(p,t){e[p]=a.jgrid.htmlDecode(t)});k=a(g).jqGrid("setRowData",c,e);a(r).attr("editable","0");for(o=0;o<g.p.savedRow.length;o++)if(g.p.savedRow[o].id==c){x=o;break}x>=0&&g.p.savedRow.splice(x,1);a.isFunction(f.aftersavefunc)&&f.aftersavefunc.call(g,c,k);m=true;a(r).unbind("keydown")}else{a("#lui_"+
g.p.id).show();w=a.extend({},e,w);w[k]=a.jgrid.stripPref(g.p.idPrefix,w[k]);a.ajax(a.extend({url:f.url,data:a.isFunction(g.p.serializeRowData)?g.p.serializeRowData.call(g,w):w,type:f.mtype,async:false,complete:function(p,t){a("#lui_"+g.p.id).hide();if(t==="success"){var u=true,y;if(a.isFunction(f.successfunc)){y=f.successfunc.call(g,p);if(a.isArray(y)){u=y[0];e=y[1]?y[1]:e}else u=y}if(u===true){g.p.autoencode&&a.each(e,function(B,C){e[B]=a.jgrid.htmlDecode(C)});e=a.extend({},e,q);a(g).jqGrid("setRowData",
c,e);a(r).attr("editable","0");for(u=0;u<g.p.savedRow.length;u++)if(g.p.savedRow[u].id==c){x=u;break}x>=0&&g.p.savedRow.splice(x,1);a.isFunction(f.aftersavefunc)&&f.aftersavefunc.call(g,c,p);m=true;a(r).unbind("keydown")}else{a.isFunction(f.errorfunc)&&f.errorfunc.call(g,c,p,t);f.restoreAfterError===true&&a(g).jqGrid("restoreRow",c,f.afterrestorefunc)}}},error:function(p,t){a("#lui_"+g.p.id).hide();if(a.isFunction(f.errorfunc))f.errorfunc.call(g,c,p,t);else try{a.jgrid.info_dialog(a.jgrid.errors.errcap,
'<div class="ui-state-error">'+p.responseText+"</div>",a.jgrid.edit.bClose,{buttonalign:"right"})}catch(u){alert(p.responseText)}f.restoreAfterError===true&&a(g).jqGrid("restoreRow",c,f.afterrestorefunc)}},a.jgrid.ajaxOptions,g.p.ajaxRowOptions||{}))}}return m},restoreRow:function(c,d){var b=a.makeArray(arguments).slice(1),h={};if(a.jgrid.realType(b[0])==="Object")h=b[0];else if(a.isFunction(d))h.afterrestorefunc=d;h=a.extend(true,a.jgrid.inlineEdit,h);return this.each(function(){var l=this,n,s,o=
{};if(l.grid){s=a(l).jqGrid("getInd",c,true);if(s!==false){for(var f=0;f<l.p.savedRow.length;f++)if(l.p.savedRow[f].id==c){n=f;break}if(n>=0){if(a.isFunction(a.fn.datepicker))try{a("input.hasDatepicker","#"+a.jgrid.jqID(s.id)).datepicker("hide")}catch(m){}a.each(l.p.colModel,function(){if(this.editable===true&&this.name in l.p.savedRow[n]&&!a(this).hasClass("not-editable-cell"))o[this.name]=l.p.savedRow[n][this.name]});a(l).jqGrid("setRowData",c,o);a(s).attr("editable","0").unbind("keydown");l.p.savedRow.splice(n,
1);a("#"+a.jgrid.jqID(c),"#"+a.jgrid.jqID(l.p.id)).hasClass("jqgrid-new-row")&&setTimeout(function(){a(l).jqGrid("delRowData",c)},0)}a.isFunction(h.afterrestorefunc)&&h.afterrestorefunc.call(l,c)}}})},addRow:function(c){c=a.extend(true,{rowID:"new_row",initdata:{},position:"first",useDefValues:true,useFormatter:false,addRowParams:{extraparam:{}}},c||{});return this.each(function(){if(this.grid){var d=this;c.useDefValues===true&&a(d.p.colModel).each(function(){if(this.editoptions&&this.editoptions.defaultValue){var h=
this.editoptions.defaultValue;h=a.isFunction(h)?h.call(d):h;c.initdata[this.name]=h}});a(d).jqGrid("addRowData",c.rowID,c.initdata,c.position);a("#"+a.jgrid.jqID(c.rowID),"#"+a.jgrid.jqID(d.p.id)).addClass("jqgrid-new-row");if(c.useFormatter)a("#"+a.jgrid.jqID(c.rowID)+" .ui-inline-edit","#"+a.jgrid.jqID(d.p.id)).click();else{var b=d.p.prmNames;c.addRowParams.extraparam[b.oper]=b.addoper;a(d).jqGrid("editRow",c.rowID,c.addRowParams);a(d).jqGrid("setSelection",c.rowID)}}})},inlineNav:function(c,d){d=
a.extend({edit:true,editicon:"ui-icon-pencil",add:true,addicon:"ui-icon-plus",save:true,saveicon:"ui-icon-disk",cancel:true,cancelicon:"ui-icon-cancel",addParams:{useFormatter:false},editParams:{}},a.jgrid.nav,d||{});return this.each(function(){if(this.grid){var b=this;if(d.addParams.useFormatter===true){var h=b.p.colModel,l;for(l=0;l<h.length;l++)if(h[l].formatter&&h[l].formatter==="actions"){if(h[l].formatoptions){h=a.extend({keys:false,onEdit:null,onSuccess:null,afterSave:null,onError:null,afterRestore:null,
extraparam:{},url:null},h[l].formatoptions);d.addParams.addRowParams={keys:h.keys,oneditfunc:h.onEdit,successfunc:h.onSuccess,url:h.url,extraparam:h.extraparam,aftersavefunc:h.afterSavef,errorfunc:h.onError,afterrestorefunc:h.afterRestore}}break}}d.add&&a(b).jqGrid("navButtonAdd",c,{caption:d.addtext,title:d.addtitle,buttonicon:d.addicon,id:b.p.id+"_iladd",onClickButton:function(){a(b).jqGrid("addRow",d.addParams);if(!d.addParams.useFormatter){a("#"+b.p.id+"_ilsave").removeClass("ui-state-disabled");
a("#"+b.p.id+"_ilcancel").removeClass("ui-state-disabled");a("#"+b.p.id+"_iladd").addClass("ui-state-disabled");a("#"+b.p.id+"_iledit").addClass("ui-state-disabled")}}});d.edit&&a(b).jqGrid("navButtonAdd",c,{caption:d.edittext,title:d.edittitle,buttonicon:d.editicon,id:b.p.id+"_iledit",onClickButton:function(){var n=a(b).jqGrid("getGridParam","selrow");if(n){a(b).jqGrid("editRow",n,d.editParams);a("#"+b.p.id+"_ilsave").removeClass("ui-state-disabled");a("#"+b.p.id+"_ilcancel").removeClass("ui-state-disabled");
a("#"+b.p.id+"_iladd").addClass("ui-state-disabled");a("#"+b.p.id+"_iledit").addClass("ui-state-disabled")}else{a.jgrid.viewModal("#alertmod",{gbox:"#gbox_"+b.p.id,jqm:true});a("#jqg_alrt").focus()}}});if(d.save){a(b).jqGrid("navButtonAdd",c,{caption:d.savetext||"",title:d.savetitle||"Save row",buttonicon:d.saveicon,id:b.p.id+"_ilsave",onClickButton:function(){var n=b.p.savedRow[0].id;if(n){if(a("#"+a.jgrid.jqID(n),"#"+a.jgrid.jqID(b.p.id)).hasClass("jqgrid-new-row")){var s=b.p.prmNames,o=s.oper;
if(!d.editParams.extraparam)d.editParams.extraparam={};d.editParams.extraparam[o]=s.addoper}if(a(b).jqGrid("saveRow",n,d.editParams)){a("#"+b.p.id+"_ilsave").addClass("ui-state-disabled");a("#"+b.p.id+"_ilcancel").addClass("ui-state-disabled");a("#"+b.p.id+"_iladd").removeClass("ui-state-disabled");a("#"+b.p.id+"_iledit").removeClass("ui-state-disabled")}}else{a.jgrid.viewModal("#alertmod",{gbox:"#gbox_"+b.p.id,jqm:true});a("#jqg_alrt").focus()}}});a("#"+b.p.id+"_ilsave").addClass("ui-state-disabled")}if(d.cancel){a(b).jqGrid("navButtonAdd",
c,{caption:d.canceltext||"",title:d.canceltitle||"Cancel row editing",buttonicon:d.cancelicon,id:b.p.id+"_ilcancel",onClickButton:function(){var n=b.p.savedRow[0].id;if(n){a(b).jqGrid("restoreRow",n,d.editParams);a("#"+b.p.id+"_ilsave").addClass("ui-state-disabled");a("#"+b.p.id+"_ilcancel").addClass("ui-state-disabled");a("#"+b.p.id+"_iladd").removeClass("ui-state-disabled");a("#"+b.p.id+"_iledit").removeClass("ui-state-disabled")}else{a.jgrid.viewModal("#alertmod",{gbox:"#gbox_"+b.p.id,jqm:true});
a("#jqg_alrt").focus()}}});a("#"+b.p.id+"_ilcancel").addClass("ui-state-disabled")}}})}})})(jQuery);
(function(b){b.jgrid.extend({editCell:function(d,f,a){return this.each(function(){var c=this,h,e,g,i;if(!(!c.grid||c.p.cellEdit!==true)){f=parseInt(f,10);c.p.selrow=c.rows[d].id;c.p.knv||b(c).jqGrid("GridNav");if(c.p.savedRow.length>0){if(a===true)if(d==c.p.iRow&&f==c.p.iCol)return;b(c).jqGrid("saveCell",c.p.savedRow[0].id,c.p.savedRow[0].ic)}else window.setTimeout(function(){b("#"+c.p.knv).attr("tabindex","-1").focus()},0);i=c.p.colModel[f];h=i.name;if(!(h=="subgrid"||h=="cb"||h=="rn")){g=b("td:eq("+
f+")",c.rows[d]);if(i.editable===true&&a===true&&!g.hasClass("not-editable-cell")){if(parseInt(c.p.iCol,10)>=0&&parseInt(c.p.iRow,10)>=0){b("td:eq("+c.p.iCol+")",c.rows[c.p.iRow]).removeClass("edit-cell ui-state-highlight");b(c.rows[c.p.iRow]).removeClass("selected-row ui-state-hover")}b(g).addClass("edit-cell ui-state-highlight");b(c.rows[d]).addClass("selected-row ui-state-hover");try{e=b.unformat(g,{rowId:c.rows[d].id,colModel:i},f)}catch(k){e=i.edittype&&i.edittype=="textarea"?b(g).text():b(g).html()}if(c.p.autoencode)e=
b.jgrid.htmlDecode(e);if(!i.edittype)i.edittype="text";c.p.savedRow.push({id:d,ic:f,name:h,v:e});if(e=="&nbsp;"||e=="&#160;"||e.length==1&&e.charCodeAt(0)==160)e="";if(b.isFunction(c.p.formatCell)){var j=c.p.formatCell.call(c,c.rows[d].id,h,e,d,f);if(j!==undefined)e=j}j=b.extend({},i.editoptions||{},{id:d+"_"+h,name:h});var m=b.jgrid.createEl(i.edittype,j,e,true,b.extend({},b.jgrid.ajaxOptions,c.p.ajaxSelectOptions||{}));b.isFunction(c.p.beforeEditCell)&&c.p.beforeEditCell.call(c,c.rows[d].id,h,e,
d,f);b(g).html("").append(m).attr("tabindex","0");window.setTimeout(function(){b(m).focus()},0);b("input, select, textarea",g).bind("keydown",function(l){if(l.keyCode===27)if(b("input.hasDatepicker",g).length>0)b(".ui-datepicker").is(":hidden")?b(c).jqGrid("restoreCell",d,f):b("input.hasDatepicker",g).datepicker("hide");else b(c).jqGrid("restoreCell",d,f);l.keyCode===13&&b(c).jqGrid("saveCell",d,f);if(l.keyCode==9)if(c.grid.hDiv.loading)return false;else l.shiftKey?b(c).jqGrid("prevCell",d,f):b(c).jqGrid("nextCell",
d,f);l.stopPropagation()});b.isFunction(c.p.afterEditCell)&&c.p.afterEditCell.call(c,c.rows[d].id,h,e,d,f)}else{if(parseInt(c.p.iCol,10)>=0&&parseInt(c.p.iRow,10)>=0){b("td:eq("+c.p.iCol+")",c.rows[c.p.iRow]).removeClass("edit-cell ui-state-highlight");b(c.rows[c.p.iRow]).removeClass("selected-row ui-state-hover")}g.addClass("edit-cell ui-state-highlight");b(c.rows[d]).addClass("selected-row ui-state-hover");if(b.isFunction(c.p.onSelectCell)){e=g.html().replace(/\&#160\;/ig,"");c.p.onSelectCell.call(c,
c.rows[d].id,h,e,d,f)}}c.p.iCol=f;c.p.iRow=d}}})},saveCell:function(d,f){return this.each(function(){var a=this,c;if(!(!a.grid||a.p.cellEdit!==true)){c=a.p.savedRow.length>=1?0:null;if(c!==null){var h=b("td:eq("+f+")",a.rows[d]),e,g,i=a.p.colModel[f],k=i.name,j=b.jgrid.jqID(k);switch(i.edittype){case "select":if(i.editoptions.multiple){j=b("#"+d+"_"+j,a.rows[d]);var m=[];if(e=b(j).val())e.join(",");else e="";b("option:selected",j).each(function(o,p){m[o]=b(p).text()});g=m.join(",")}else{e=b("#"+d+
"_"+j+">option:selected",a.rows[d]).val();g=b("#"+d+"_"+j+">option:selected",a.rows[d]).text()}if(i.formatter)g=e;break;case "checkbox":var l=["Yes","No"];if(i.editoptions)l=i.editoptions.value.split(":");g=e=b("#"+d+"_"+j,a.rows[d]).is(":checked")?l[0]:l[1];break;case "password":case "text":case "textarea":case "button":g=e=b("#"+d+"_"+j,a.rows[d]).val();break;case "custom":try{if(i.editoptions&&b.isFunction(i.editoptions.custom_value)){e=i.editoptions.custom_value.call(a,b(".customelement",h),"get");
if(e===undefined)throw"e2";else g=e}else throw"e1";}catch(q){q=="e1"&&b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+b.jgrid.edit.msg.nodefined,jQuery.jgrid.edit.bClose);q=="e2"?b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+b.jgrid.edit.msg.novalue,jQuery.jgrid.edit.bClose):b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,q.message,jQuery.jgrid.edit.bClose)}}if(g!==a.p.savedRow[c].v){if(b.isFunction(a.p.beforeSaveCell))if(c=a.p.beforeSaveCell.call(a,
a.rows[d].id,k,e,d,f))g=e=c;var r=b.jgrid.checkValues(e,f,a);if(r[0]===true){c={};if(b.isFunction(a.p.beforeSubmitCell))(c=a.p.beforeSubmitCell.call(a,a.rows[d].id,k,e,d,f))||(c={});b("input.hasDatepicker",h).length>0&&b("input.hasDatepicker",h).datepicker("hide");if(a.p.cellsubmit=="remote")if(a.p.cellurl){var n={};if(a.p.autoencode)e=b.jgrid.htmlEncode(e);n[k]=e;l=a.p.prmNames;i=l.id;j=l.oper;n[i]=b.jgrid.stripPref(a.p.idPrefix,a.rows[d].id);n[j]=l.editoper;n=b.extend(c,n);b("#lui_"+a.p.id).show();
a.grid.hDiv.loading=true;b.ajax(b.extend({url:a.p.cellurl,data:b.isFunction(a.p.serializeCellData)?a.p.serializeCellData.call(a,n):n,type:"POST",complete:function(o,p){b("#lui_"+a.p.id).hide();a.grid.hDiv.loading=false;if(p=="success")if(b.isFunction(a.p.afterSubmitCell)){var s=a.p.afterSubmitCell.call(a,o,n.id,k,e,d,f);if(s[0]===true){b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");b.isFunction(a.p.afterSaveCell)&&
a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}else{b.jgrid.info_dialog(b.jgrid.errors.errcap,s[1],b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}}else{b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");b.isFunction(a.p.afterSaveCell)&&a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}},error:function(o,p){b("#lui_"+a.p.id).hide();a.grid.hDiv.loading=false;b.isFunction(a.p.errorCell)?
a.p.errorCell.call(a,o,p):b.jgrid.info_dialog(b.jgrid.errors.errcap,o.status+" : "+o.statusText+"<br/>"+p,b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}},b.jgrid.ajaxOptions,a.p.ajaxCellOptions||{}))}else try{b.jgrid.info_dialog(b.jgrid.errors.errcap,b.jgrid.errors.nourl,b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}catch(t){}if(a.p.cellsubmit=="clientArray"){b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");
b.isFunction(a.p.afterSaveCell)&&a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}}else try{window.setTimeout(function(){b.jgrid.info_dialog(b.jgrid.errors.errcap,e+" "+r[1],b.jgrid.edit.bClose)},100);b(a).jqGrid("restoreCell",d,f)}catch(u){}}else b(a).jqGrid("restoreCell",d,f)}b.browser.opera?b("#"+a.p.knv).attr("tabindex","-1").focus():window.setTimeout(function(){b("#"+a.p.knv).attr("tabindex","-1").focus()},0)}})},restoreCell:function(d,f){return this.each(function(){var a=
this,c;if(!(!a.grid||a.p.cellEdit!==true)){c=a.p.savedRow.length>=1?0:null;if(c!==null){var h=b("td:eq("+f+")",a.rows[d]);if(b.isFunction(b.fn.datepicker))try{b("input.hasDatepicker",h).datepicker("hide")}catch(e){}b(h).empty().attr("tabindex","-1");b(a).jqGrid("setCell",a.rows[d].id,f,a.p.savedRow[c].v,false,false,true);b.isFunction(a.p.afterRestoreCell)&&a.p.afterRestoreCell.call(a,a.rows[d].id,a.p.savedRow[c].v,d,f);a.p.savedRow.splice(0,1)}window.setTimeout(function(){b("#"+a.p.knv).attr("tabindex",
"-1").focus()},0)}})},nextCell:function(d,f){return this.each(function(){var a=false;if(!(!this.grid||this.p.cellEdit!==true)){for(var c=f+1;c<this.p.colModel.length;c++)if(this.p.colModel[c].editable===true){a=c;break}if(a!==false)b(this).jqGrid("editCell",d,a,true);else this.p.savedRow.length>0&&b(this).jqGrid("saveCell",d,f)}})},prevCell:function(d,f){return this.each(function(){var a=false;if(!(!this.grid||this.p.cellEdit!==true)){for(var c=f-1;c>=0;c--)if(this.p.colModel[c].editable===true){a=
c;break}if(a!==false)b(this).jqGrid("editCell",d,a,true);else this.p.savedRow.length>0&&b(this).jqGrid("saveCell",d,f)}})},GridNav:function(){return this.each(function(){function d(g,i,k){if(k.substr(0,1)=="v"){var j=b(a.grid.bDiv)[0].clientHeight,m=b(a.grid.bDiv)[0].scrollTop,l=a.rows[g].offsetTop+a.rows[g].clientHeight,q=a.rows[g].offsetTop;if(k=="vd")if(l>=j)b(a.grid.bDiv)[0].scrollTop=b(a.grid.bDiv)[0].scrollTop+a.rows[g].clientHeight;if(k=="vu")if(q<m)b(a.grid.bDiv)[0].scrollTop=b(a.grid.bDiv)[0].scrollTop-
a.rows[g].clientHeight}if(k=="h"){k=b(a.grid.bDiv)[0].clientWidth;j=b(a.grid.bDiv)[0].scrollLeft;m=a.rows[g].cells[i].offsetLeft;if(a.rows[g].cells[i].offsetLeft+a.rows[g].cells[i].clientWidth>=k+parseInt(j,10))b(a.grid.bDiv)[0].scrollLeft=b(a.grid.bDiv)[0].scrollLeft+a.rows[g].cells[i].clientWidth;else if(m<j)b(a.grid.bDiv)[0].scrollLeft=b(a.grid.bDiv)[0].scrollLeft-a.rows[g].cells[i].clientWidth}}function f(g,i){var k,j;if(i=="lft"){k=g+1;for(j=g;j>=0;j--)if(a.p.colModel[j].hidden!==true){k=j;break}}if(i==
"rgt"){k=g-1;for(j=g;j<a.p.colModel.length;j++)if(a.p.colModel[j].hidden!==true){k=j;break}}return k}var a=this;if(!(!a.grid||a.p.cellEdit!==true)){a.p.knv=a.p.id+"_kn";var c=b("<span style='width:0px;height:0px;background-color:black;' tabindex='0'><span tabindex='-1' style='width:0px;height:0px;background-color:grey' id='"+a.p.knv+"'></span></span>"),h,e;b(c).insertBefore(a.grid.cDiv);b("#"+a.p.knv).focus().keydown(function(g){e=g.keyCode;if(a.p.direction=="rtl")if(e==37)e=39;else if(e==39)e=37;
switch(e){case 38:if(a.p.iRow-1>0){d(a.p.iRow-1,a.p.iCol,"vu");b(a).jqGrid("editCell",a.p.iRow-1,a.p.iCol,false)}break;case 40:if(a.p.iRow+1<=a.rows.length-1){d(a.p.iRow+1,a.p.iCol,"vd");b(a).jqGrid("editCell",a.p.iRow+1,a.p.iCol,false)}break;case 37:if(a.p.iCol-1>=0){h=f(a.p.iCol-1,"lft");d(a.p.iRow,h,"h");b(a).jqGrid("editCell",a.p.iRow,h,false)}break;case 39:if(a.p.iCol+1<=a.p.colModel.length-1){h=f(a.p.iCol+1,"rgt");d(a.p.iRow,h,"h");b(a).jqGrid("editCell",a.p.iRow,h,false)}break;case 13:parseInt(a.p.iCol,
10)>=0&&parseInt(a.p.iRow,10)>=0&&b(a).jqGrid("editCell",a.p.iRow,a.p.iCol,true);break;default:return true}return false})}})},getChangedCells:function(d){var f=[];d||(d="all");this.each(function(){var a=this,c;!a.grid||a.p.cellEdit!==true||b(a.rows).each(function(h){var e={};if(b(this).hasClass("edited")){b("td",this).each(function(g){c=a.p.colModel[g].name;if(c!=="cb"&&c!=="subgrid")if(d=="dirty"){if(b(this).hasClass("dirty-cell"))try{e[c]=b.unformat(this,{rowId:a.rows[h].id,colModel:a.p.colModel[g]},
g)}catch(i){e[c]=b.jgrid.htmlDecode(b(this).html())}}else try{e[c]=b.unformat(this,{rowId:a.rows[h].id,colModel:a.p.colModel[g]},g)}catch(k){e[c]=b.jgrid.htmlDecode(b(this).html())}});e.id=this.id;f.push(e)}})});return f}})})(jQuery);
(function(b){b.fn.jqm=function(a){var f={overlay:50,closeoverlay:true,overlayClass:"jqmOverlay",closeClass:"jqmClose",trigger:".jqModal",ajax:e,ajaxText:"",target:e,modal:e,toTop:e,onShow:e,onHide:e,onLoad:e};return this.each(function(){if(this._jqm)return j[this._jqm].c=b.extend({},j[this._jqm].c,a);l++;this._jqm=l;j[l]={c:b.extend(f,b.jqm.params,a),a:e,w:b(this).addClass("jqmID"+l),s:l};f.trigger&&b(this).jqmAddTrigger(f.trigger)})};b.fn.jqmAddClose=function(a){return o(this,a,"jqmHide")};b.fn.jqmAddTrigger=
function(a){return o(this,a,"jqmShow")};b.fn.jqmShow=function(a){return this.each(function(){b.jqm.open(this._jqm,a)})};b.fn.jqmHide=function(a){return this.each(function(){b.jqm.close(this._jqm,a)})};b.jqm={hash:{},open:function(a,f){var c=j[a],d=c.c,i="."+d.closeClass,g=parseInt(c.w.css("z-index"));g=g>0?g:3E3;var h=b("<div></div>").css({height:"100%",width:"100%",position:"fixed",left:0,top:0,"z-index":g-1,opacity:d.overlay/100});if(c.a)return e;c.t=f;c.a=true;c.w.css("z-index",g);if(d.modal){k[0]||
setTimeout(function(){p("bind")},1);k.push(a)}else if(d.overlay>0)d.closeoverlay&&c.w.jqmAddClose(h);else h=e;c.o=h?h.addClass(d.overlayClass).prependTo("body"):e;if(q){b("html,body").css({height:"100%",width:"100%"});if(h){h=h.css({position:"absolute"})[0];for(var m in{Top:1,Left:1})h.style.setExpression(m.toLowerCase(),"(_=(document.documentElement.scroll"+m+" || document.body.scroll"+m+"))+'px'")}}if(d.ajax){g=d.target||c.w;h=d.ajax;g=typeof g=="string"?b(g,c.w):b(g);h=h.substr(0,1)=="@"?b(f).attr(h.substring(1)):
h;g.html(d.ajaxText).load(h,function(){d.onLoad&&d.onLoad.call(this,c);i&&c.w.jqmAddClose(b(i,c.w));r(c)})}else i&&c.w.jqmAddClose(b(i,c.w));d.toTop&&c.o&&c.w.before('<span id="jqmP'+c.w[0]._jqm+'"></span>').insertAfter(c.o);d.onShow?d.onShow(c):c.w.show();r(c);return e},close:function(a){a=j[a];if(!a.a)return e;a.a=e;if(k[0]){k.pop();k[0]||p("unbind")}a.c.toTop&&a.o&&b("#jqmP"+a.w[0]._jqm).after(a.w).remove();if(a.c.onHide)a.c.onHide(a);else{a.w.hide();a.o&&a.o.remove()}return e},params:{}};var l=
0,j=b.jqm.hash,k=[],q=b.browser.msie&&b.browser.version=="6.0",e=false,r=function(a){var f=b('<iframe src="javascript:false;document.write(\'\');" class="jqm"></iframe>').css({opacity:0});if(q)if(a.o)a.o.html('<p style="width:100%;height:100%"/>').prepend(f);else b("iframe.jqm",a.w)[0]||a.w.prepend(f);s(a)},s=function(a){try{b(":input:visible",a.w)[0].focus()}catch(f){}},p=function(a){b(document)[a]("keypress",n)[a]("keydown",n)[a]("mousedown",n)},n=function(a){var f=j[k[k.length-1]];(a=!b(a.target).parents(".jqmID"+
f.s)[0])&&s(f);return!a},o=function(a,f,c){return a.each(function(){var d=this._jqm;b(f).each(function(){if(!this[c]){this[c]=[];b(this).click(function(){for(var i in{jqmShow:1,jqmHide:1})for(var g in this[i])if(j[this[i][g]])j[this[i][g]].w[i](this);return e})}this[c].push(d)})})}})(jQuery);
(function(b){b.fn.jqDrag=function(a){return l(this,a,"d")};b.fn.jqResize=function(a,e){return l(this,a,"r",e)};b.jqDnR={dnr:{},e:0,drag:function(a){if(c.k=="d")d.css({left:c.X+a.pageX-c.pX,top:c.Y+a.pageY-c.pY});else{d.css({width:Math.max(a.pageX-c.pX+c.W,0),height:Math.max(a.pageY-c.pY+c.H,0)});M1&&f.css({width:Math.max(a.pageX-M1.pX+M1.W,0),height:Math.max(a.pageY-M1.pY+M1.H,0)})}return false},stop:function(){b(document).unbind("mousemove",i.drag).unbind("mouseup",i.stop)}};var i=b.jqDnR,c=i.dnr,
d=i.e,f,l=function(a,e,n,m){return a.each(function(){e=e?b(e,a):a;e.bind("mousedown",{e:a,k:n},function(g){var j=g.data,h={};d=j.e;f=m?b(m):false;if(d.css("position")!="relative")try{d.position(h)}catch(o){}c={X:h.left||k("left")||0,Y:h.top||k("top")||0,W:k("width")||d[0].scrollWidth||0,H:k("height")||d[0].scrollHeight||0,pX:g.pageX,pY:g.pageY,k:j.k};M1=f&&j.k!="d"?{X:h.left||f1("left")||0,Y:h.top||f1("top")||0,W:f[0].offsetWidth||f1("width")||0,H:f[0].offsetHeight||f1("height")||0,pX:g.pageX,pY:g.pageY,
k:j.k}:false;if(b("input.hasDatepicker",d[0])[0])try{b("input.hasDatepicker",d[0]).datepicker("hide")}catch(p){}b(document).mousemove(b.jqDnR.drag).mouseup(b.jqDnR.stop);return false})})},k=function(a){return parseInt(d.css(a))||false};f1=function(a){return parseInt(f.css(a))||false}})(jQuery);
(function(b){b.jgrid.extend({setSubGrid:function(){return this.each(function(){var f;this.p.subGridOptions=b.extend({plusicon:"ui-icon-plus",minusicon:"ui-icon-minus",openicon:"ui-icon-carat-1-sw",expandOnLoad:false,delayOnLoad:50,selectOnExpand:false,reloadOnExpand:true},this.p.subGridOptions||{});this.p.colNames.unshift("");this.p.colModel.unshift({name:"subgrid",width:b.browser.safari?this.p.subGridWidth+this.p.cellLayout:this.p.subGridWidth,sortable:false,resizable:false,hidedlg:true,search:false,
fixed:true});f=this.p.subGridModel;if(f[0]){f[0].align=b.extend([],f[0].align||[]);for(var d=0;d<f[0].name.length;d++)f[0].align[d]=f[0].align[d]||"left"}})},addSubGridCell:function(f,d){var a="",n,s;this.each(function(){a=this.formatCol(f,d);s=this.p.id;n=this.p.subGridOptions.plusicon});return'<td role="gridcell" aria-describedby="'+s+'_subgrid" class="ui-sgcollapsed sgcollapsed" '+a+"><a href='javascript:void(0);'><span class='ui-icon "+n+"'></span></a></td>"},addSubGrid:function(f,d){return this.each(function(){var a=
this;if(a.grid){var n=function(g,j,e){j=b("<td align='"+a.p.subGridModel[0].align[e]+"'></td>").html(j);b(g).append(j)},s=function(g,j){var e,c,h,k=b("<table cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>"),i=b("<tr></tr>");for(c=0;c<a.p.subGridModel[0].name.length;c++){e=b("<th class='ui-state-default ui-th-subgrid ui-th-column ui-th-"+a.p.direction+"'></th>");b(e).html(a.p.subGridModel[0].name[c]);b(e).width(a.p.subGridModel[0].width[c]);b(i).append(e)}b(k).append(i);if(g){h=
a.p.xmlReader.subgrid;b(h.root+" "+h.row,g).each(function(){i=b("<tr class='ui-widget-content ui-subtblcell'></tr>");if(h.repeatitems===true)b(h.cell,this).each(function(m){n(i,b(this).text()||"&#160;",m)});else{var o=a.p.subGridModel[0].mapping||a.p.subGridModel[0].name;if(o)for(c=0;c<o.length;c++)n(i,b(o[c],this).text()||"&#160;",c)}b(k).append(i)})}e=b("table:first",a.grid.bDiv).attr("id")+"_";b("#"+e+j).append(k);a.grid.hDiv.loading=false;b("#load_"+a.p.id).hide();return false},v=function(g,j){var e,
c,h,k,i,o=b("<table cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>"),m=b("<tr></tr>");for(c=0;c<a.p.subGridModel[0].name.length;c++){e=b("<th class='ui-state-default ui-th-subgrid ui-th-column ui-th-"+a.p.direction+"'></th>");b(e).html(a.p.subGridModel[0].name[c]);b(e).width(a.p.subGridModel[0].width[c]);b(m).append(e)}b(o).append(m);if(g){k=a.p.jsonReader.subgrid;e=g[k.root];if(typeof e!=="undefined")for(c=0;c<e.length;c++){h=e[c];m=b("<tr class='ui-widget-content ui-subtblcell'></tr>");
if(k.repeatitems===true){if(k.cell)h=h[k.cell];for(i=0;i<h.length;i++)n(m,h[i]||"&#160;",i)}else{var u=a.p.subGridModel[0].mapping||a.p.subGridModel[0].name;if(u.length)for(i=0;i<u.length;i++)n(m,h[u[i]]||"&#160;",i)}b(o).append(m)}}c=b("table:first",a.grid.bDiv).attr("id")+"_";b("#"+c+j).append(o);a.grid.hDiv.loading=false;b("#load_"+a.p.id).hide();return false},z=function(g){var j,e,c,h;j=b(g).attr("id");e={nd_:(new Date).getTime()};e[a.p.prmNames.subgridid]=j;if(!a.p.subGridModel[0])return false;
if(a.p.subGridModel[0].params)for(h=0;h<a.p.subGridModel[0].params.length;h++)for(c=0;c<a.p.colModel.length;c++)if(a.p.colModel[c].name==a.p.subGridModel[0].params[h])e[a.p.colModel[c].name]=b("td:eq("+c+")",g).text().replace(/\&#160\;/ig,"");if(!a.grid.hDiv.loading){a.grid.hDiv.loading=true;b("#load_"+a.p.id).show();if(!a.p.subgridtype)a.p.subgridtype=a.p.datatype;if(b.isFunction(a.p.subgridtype))a.p.subgridtype.call(a,e);else a.p.subgridtype=a.p.subgridtype.toLowerCase();switch(a.p.subgridtype){case "xml":case "json":b.ajax(b.extend({type:a.p.mtype,
url:a.p.subGridUrl,dataType:a.p.subgridtype,data:b.isFunction(a.p.serializeSubGridData)?a.p.serializeSubGridData.call(a,e):e,complete:function(k){a.p.subgridtype=="xml"?s(k.responseXML,j):v(b.jgrid.parse(k.responseText),j)}},b.jgrid.ajaxOptions,a.p.ajaxSubgridOptions||{}))}}return false},l,t,w,x=0,p,q;b.each(a.p.colModel,function(){if(this.hidden===true||this.name=="rn"||this.name=="cb")x++});var y=a.rows.length,r=1;if(d!==undefined&&d>0){r=d;y=d+1}for(;r<y;){b(a.rows[r]).hasClass("jqgrow")&&b(a.rows[r].cells[f]).bind("click",
function(){var g=b(this).parent("tr")[0];q=g.nextSibling;if(b(this).hasClass("sgcollapsed")){t=a.p.id;l=g.id;if(a.p.subGridOptions.reloadOnExpand===true||a.p.subGridOptions.reloadOnExpand===false&&!b(q).hasClass("ui-subgrid")){w=f>=1?"<td colspan='"+f+"'>&#160;</td>":"";p=true;if(b.isFunction(a.p.subGridBeforeExpand))p=a.p.subGridBeforeExpand.call(a,t+"_"+l,l);if(p===false)return false;b(g).after("<tr role='row' class='ui-subgrid'>"+w+"<td class='ui-widget-content subgrid-cell'><span class='ui-icon "+
a.p.subGridOptions.openicon+"'></span></td><td colspan='"+parseInt(a.p.colNames.length-1-x,10)+"' class='ui-widget-content subgrid-data'><div id="+t+"_"+l+" class='tablediv'></div></td></tr>");b.isFunction(a.p.subGridRowExpanded)?a.p.subGridRowExpanded.call(a,t+"_"+l,l):z(g)}else b(q).show();b(this).html("<a href='javascript:void(0);'><span class='ui-icon "+a.p.subGridOptions.minusicon+"'></span></a>").removeClass("sgcollapsed").addClass("sgexpanded");a.p.subGridOptions.selectOnExpand&&b(a).jqGrid("setSelection",
l)}else if(b(this).hasClass("sgexpanded")){p=true;if(b.isFunction(a.p.subGridRowColapsed)){l=g.id;p=a.p.subGridRowColapsed.call(a,t+"_"+l,l)}if(p===false)return false;if(a.p.subGridOptions.reloadOnExpand===true)b(q).remove(".ui-subgrid");else b(q).hasClass("ui-subgrid")&&b(q).hide();b(this).html("<a href='javascript:void(0);'><span class='ui-icon "+a.p.subGridOptions.plusicon+"'></span></a>").removeClass("sgexpanded").addClass("sgcollapsed")}return false});a.p.subGridOptions.expandOnLoad===true&&
b(a.rows[r].cells[f]).trigger("click");r++}a.subGridXml=function(g,j){s(g,j)};a.subGridJson=function(g,j){v(g,j)}}})},expandSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d)(d=b("td.sgcollapsed",d)[0])&&b(d).trigger("click")}})},collapseSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d)(d=b("td.sgexpanded",d)[0])&&b(d).trigger("click")}})},
toggleSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d){var a=b("td.sgcollapsed",d)[0];if(a)b(a).trigger("click");else(a=b("td.sgexpanded",d)[0])&&b(a).trigger("click")}}})}})})(jQuery);
(function(e){e.jgrid.extend({groupingSetup:function(){return this.each(function(){var a=this.p.groupingView;if(a!==null&&(typeof a==="object"||e.isFunction(a)))if(a.groupField.length){if(typeof a.visibiltyOnNextGrouping=="undefined")a.visibiltyOnNextGrouping=[];for(var c=0;c<a.groupField.length;c++){a.groupOrder[c]||(a.groupOrder[c]="asc");a.groupText[c]||(a.groupText[c]="{0}");if(typeof a.groupColumnShow[c]!="boolean")a.groupColumnShow[c]=true;if(typeof a.groupSummary[c]!="boolean")a.groupSummary[c]=
false;if(a.groupColumnShow[c]===true){a.visibiltyOnNextGrouping[c]=true;e(this).jqGrid("showCol",a.groupField[c])}else{a.visibiltyOnNextGrouping[c]=e("#"+this.p.id+"_"+a.groupField[c]).is(":visible");e(this).jqGrid("hideCol",a.groupField[c])}a.sortitems[c]=[];a.sortnames[c]=[];a.summaryval[c]=[];if(a.groupSummary[c]){a.summary[c]=[];for(var b=this.p.colModel,d=0,g=b.length;d<g;d++)b[d].summaryType&&a.summary[c].push({nm:b[d].name,st:b[d].summaryType,v:""})}}this.p.scroll=false;this.p.rownumbers=false;
this.p.subGrid=false;this.p.treeGrid=false;this.p.gridview=true}else this.p.grouping=false;else this.p.grouping=false})},groupingPrepare:function(a,c,b,d){this.each(function(){c[0]+="";var g=c[0].toString().split(" ").join(""),h=this.p.groupingView,f=this;if(b.hasOwnProperty(g))b[g].push(a);else{b[g]=[];b[g].push(a);h.sortitems[0].push(g);h.sortnames[0].push(e.trim(c[0].toString()));h.summaryval[0][g]=e.extend(true,[],h.summary[0])}h.groupSummary[0]&&e.each(h.summaryval[0][g],function(){this.v=e.isFunction(this.st)?
this.st.call(f,this.v,this.nm,d):e(f).jqGrid("groupingCalculations."+this.st,this.v,this.nm,d)})});return b},groupingToggle:function(a){this.each(function(){var c=this.p.groupingView,b=a.lastIndexOf("_"),d=a.substring(0,b+1);b=parseInt(a.substring(b+1),10)+1;var g=c.minusicon,h=c.plusicon,f=e("#"+a);f=f.length?f[0].nextSibling:null;var k=e("#"+a+" span.tree-wrap-"+this.p.direction),l=false;if(k.hasClass(g)){if(c.showSummaryOnHide&&c.groupSummary[0]){if(f)for(;f;){if(e(f).hasClass("jqfoot"))break;
e(f).hide();f=f.nextSibling}}else if(f)for(;f;){if(e(f).attr("id")==d+String(b))break;e(f).hide();f=f.nextSibling}k.removeClass(g).addClass(h);l=true}else{if(f)for(;f;){if(e(f).attr("id")==d+String(b))break;e(f).show();f=f.nextSibling}k.removeClass(h).addClass(g)}e.isFunction(this.p.onClickGroup)&&this.p.onClickGroup.call(this,a,l)});return false},groupingRender:function(a,c){return this.each(function(){var b=this,d=b.p.groupingView,g="",h="",f,k=d.groupCollapse?d.plusicon:d.minusicon,l,r,m;if(!d.groupDataSorted){d.sortitems[0].sort();
d.sortnames[0].sort();if(d.groupOrder[0].toLowerCase()=="desc"){d.sortitems[0].reverse();d.sortnames[0].reverse()}}k+=" tree-wrap-"+b.p.direction;for(m=0;m<c;){if(b.p.colModel[m].name==d.groupField[0]){r=m;break}m++}e.each(d.sortitems[0],function(o,n){f=b.p.id+"ghead_"+o;h="<span style='cursor:pointer;' class='ui-icon "+k+"' onclick=\"jQuery('#"+b.p.id+"').jqGrid('groupingToggle','"+f+"');return false;\"></span>";try{l=b.formatter(f,d.sortnames[0][o],r,d.sortitems[0])}catch(v){l=d.sortnames[0][o]}g+=
'<tr id="'+f+'" role="row" class= "ui-widget-content jqgroup ui-row-'+b.p.direction+'"><td colspan="'+c+'">'+h+e.jgrid.format(d.groupText[0],l,a[n].length)+"</td></tr>";for(var i=0;i<a[n].length;i++)g+=a[n][i].join("");if(d.groupSummary[0]){i="";if(d.groupCollapse&&!d.showSummaryOnHide)i=' style="display:none;"';g+="<tr"+i+' role="row" class="ui-widget-content jqfoot ui-row-'+b.p.direction+'">';i=d.summaryval[0][n];for(var p=b.p.colModel,q,s=a[n].length,j=0;j<c;j++){var t="<td "+b.formatCol(j,1,"")+
">&#160;</td>",u="{0}";e.each(i,function(){if(this.nm==p[j].name){if(p[j].summaryTpl)u=p[j].summaryTpl;if(this.st=="avg")if(this.v&&s>0)this.v/=s;try{q=b.formatter("",this.v,j,this)}catch(w){q=this.v}t="<td "+b.formatCol(j,1,"")+">"+e.jgrid.format(u,q)+"</td>";return false}});g+=t}g+="</tr>"}});e("#"+b.p.id+" tbody:first").append(g);g=null})},groupingGroupBy:function(a,c){return this.each(function(){if(typeof a=="string")a=[a];var b=this.p.groupingView;this.p.grouping=true;if(typeof b.visibiltyOnNextGrouping==
"undefined")b.visibiltyOnNextGrouping=[];var d;for(d=0;d<b.groupField.length;d++)!b.groupColumnShow[d]&&b.visibiltyOnNextGrouping[d]&&e(this).jqGrid("showCol",b.groupField[d]);for(d=0;d<a.length;d++)b.visibiltyOnNextGrouping[d]=e("#"+this.p.id+"_"+a[d]).is(":visible");this.p.groupingView=e.extend(this.p.groupingView,c||{});b.groupField=a;e(this).trigger("reloadGrid")})},groupingRemove:function(a){return this.each(function(){if(typeof a=="undefined")a=true;this.p.grouping=false;if(a===true){for(var c=
this.p.groupingView,b=0;b<c.groupField.length;b++)!c.groupColumnShow[b]&&c.visibiltyOnNextGrouping[b]&&e(this).jqGrid("showCol",c.groupField);e("tr.jqgroup, tr.jqfoot","#"+this.p.id+" tbody:first").remove();e("tr.jqgrow:hidden","#"+this.p.id+" tbody:first").show()}else e(this).trigger("reloadGrid")})},groupingCalculations:{sum:function(a,c,b){return parseFloat(a||0)+parseFloat(b[c]||0)},min:function(a,c,b){if(a==="")return parseFloat(b[c]||0);return Math.min(parseFloat(a),parseFloat(b[c]||0))},max:function(a,
c,b){if(a==="")return parseFloat(b[c]||0);return Math.max(parseFloat(a),parseFloat(b[c]||0))},count:function(a,c,b){if(a==="")a=0;return b.hasOwnProperty(c)?a+1:0},avg:function(a,c,b){return parseFloat(a||0)+parseFloat(b[c]||0)}}})})(jQuery);
(function(d){d.jgrid.extend({setTreeNode:function(a,c){return this.each(function(){var b=this;if(b.grid&&b.p.treeGrid)for(var e=b.p.expColInd,g=b.p.treeReader.expanded_field,h=b.p.treeReader.leaf_field,f=b.p.treeReader.level_field,l=b.p.treeReader.icon_field,i=b.p.treeReader.loaded,j,o,n,k;a<c;){k=b.p.data[b.p._index[b.rows[a].id]];if(b.p.treeGridModel=="nested")if(!k[h]){j=parseInt(k[b.p.treeReader.left_field],10);o=parseInt(k[b.p.treeReader.right_field],10);k[h]=o===j+1?"true":"false";b.rows[a].cells[b.p._treeleafpos].innerHTML=
k[h]}j=parseInt(k[f],10);if(b.p.tree_root_level===0){n=j+1;o=j}else{n=j;o=j-1}n="<div class='tree-wrap tree-wrap-"+b.p.direction+"' style='width:"+n*18+"px;'>";n+="<div style='"+(b.p.direction=="rtl"?"right:":"left:")+o*18+"px;' class='ui-icon ";if(k[i]!==undefined)k[i]=k[i]=="true"||k[i]===true?true:false;if(k[h]=="true"||k[h]===true){n+=(k[l]!==undefined&&k[l]!==""?k[l]:b.p.treeIcons.leaf)+" tree-leaf treeclick";k[h]=true;o="leaf"}else{k[h]=false;o=""}k[g]=(k[g]=="true"||k[g]===true?true:false)&&
k[i];n+=k[g]===false?k[h]===true?"'":b.p.treeIcons.plus+" tree-plus treeclick'":k[h]===true?"'":b.p.treeIcons.minus+" tree-minus treeclick'";n+="></div></div>";d(b.rows[a].cells[e]).wrapInner("<span class='cell-wrapper"+o+"'></span>").prepend(n);if(j!==parseInt(b.p.tree_root_level,10))(k=(k=d(b).jqGrid("getNodeParent",k))&&k.hasOwnProperty(g)?k[g]:true)||d(b.rows[a]).css("display","none");d(b.rows[a].cells[e]).find("div.treeclick").bind("click",function(m){m=d(m.target||m.srcElement,b.rows).closest("tr.jqgrow")[0].id;
m=b.p._index[m];if(!b.p.data[m][h])if(b.p.data[m][g]){d(b).jqGrid("collapseRow",b.p.data[m]);d(b).jqGrid("collapseNode",b.p.data[m])}else{d(b).jqGrid("expandRow",b.p.data[m]);d(b).jqGrid("expandNode",b.p.data[m])}return false});b.p.ExpandColClick===true&&d(b.rows[a].cells[e]).find("span.cell-wrapper").css("cursor","pointer").bind("click",function(m){m=d(m.target||m.srcElement,b.rows).closest("tr.jqgrow")[0].id;var r=b.p._index[m];if(!b.p.data[r][h])if(b.p.data[r][g]){d(b).jqGrid("collapseRow",b.p.data[r]);
d(b).jqGrid("collapseNode",b.p.data[r])}else{d(b).jqGrid("expandRow",b.p.data[r]);d(b).jqGrid("expandNode",b.p.data[r])}d(b).jqGrid("setSelection",m);return false});a++}})},setTreeGrid:function(){return this.each(function(){var a=this,c=0,b=false,e,g,h=[];if(a.p.treeGrid){a.p.treedatatype||d.extend(a.p,{treedatatype:a.p.datatype});a.p.subGrid=false;a.p.altRows=false;a.p.pgbuttons=false;a.p.pginput=false;a.p.gridview=true;if(a.p.rowTotal===null)a.p.rowNum=1E4;a.p.multiselect=false;a.p.rowList=[];a.p.expColInd=
0;a.p.treeIcons=d.extend({plus:"ui-icon-triangle-1-"+(a.p.direction=="rtl"?"w":"e"),minus:"ui-icon-triangle-1-s",leaf:"ui-icon-radio-off"},a.p.treeIcons||{});if(a.p.treeGridModel=="nested")a.p.treeReader=d.extend({level_field:"level",left_field:"lft",right_field:"rgt",leaf_field:"isLeaf",expanded_field:"expanded",loaded:"loaded",icon_field:"icon"},a.p.treeReader);else if(a.p.treeGridModel=="adjacency")a.p.treeReader=d.extend({level_field:"level",parent_id_field:"parent",leaf_field:"isLeaf",expanded_field:"expanded",
loaded:"loaded",icon_field:"icon"},a.p.treeReader);for(g in a.p.colModel)if(a.p.colModel.hasOwnProperty(g)){e=a.p.colModel[g].name;if(e==a.p.ExpandColumn&&!b){b=true;a.p.expColInd=c}c++;for(var f in a.p.treeReader)a.p.treeReader[f]==e&&h.push(e)}d.each(a.p.treeReader,function(l,i){if(i&&d.inArray(i,h)===-1){if(l==="leaf_field")a.p._treeleafpos=c;c++;a.p.colNames.push(i);a.p.colModel.push({name:i,width:1,hidden:true,sortable:false,resizable:false,hidedlg:true,editable:true,search:false})}})}})},expandRow:function(a){this.each(function(){var c=
this;if(c.grid&&c.p.treeGrid){var b=d(c).jqGrid("getNodeChildren",a),e=c.p.treeReader.expanded_field;d(b).each(function(){var g=d.jgrid.getAccessor(this,c.p.localReader.id);d("#"+g,c.grid.bDiv).css("display","");this[e]&&d(c).jqGrid("expandRow",this)})}})},collapseRow:function(a){this.each(function(){var c=this;if(c.grid&&c.p.treeGrid){var b=d(c).jqGrid("getNodeChildren",a),e=c.p.treeReader.expanded_field;d(b).each(function(){var g=d.jgrid.getAccessor(this,c.p.localReader.id);d("#"+g,c.grid.bDiv).css("display",
"none");this[e]&&d(c).jqGrid("collapseRow",this)})}})},getRootNodes:function(){var a=[];this.each(function(){var c=this;if(c.grid&&c.p.treeGrid)switch(c.p.treeGridModel){case "nested":var b=c.p.treeReader.level_field;d(c.p.data).each(function(){parseInt(this[b],10)===parseInt(c.p.tree_root_level,10)&&a.push(this)});break;case "adjacency":var e=c.p.treeReader.parent_id_field;d(c.p.data).each(function(){if(this[e]===null||String(this[e]).toLowerCase()=="null")a.push(this)})}});return a},getNodeDepth:function(a){var c=
null;this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":c=parseInt(a[this.p.treeReader.level_field],10)-parseInt(this.p.tree_root_level,10);break;case "adjacency":c=d(this).jqGrid("getNodeAncestors",a).length}});return c},getNodeParent:function(a){var c=null;this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var b=this.p.treeReader.left_field,e=this.p.treeReader.right_field,g=this.p.treeReader.level_field,h=parseInt(a[b],
10),f=parseInt(a[e],10),l=parseInt(a[g],10);d(this.p.data).each(function(){if(parseInt(this[g],10)===l-1&&parseInt(this[b],10)<h&&parseInt(this[e],10)>f){c=this;return false}});break;case "adjacency":var i=this.p.treeReader.parent_id_field,j=this.p.localReader.id;d(this.p.data).each(function(){if(this[j]==a[i]){c=this;return false}})}});return c},getNodeChildren:function(a){var c=[];this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var b=this.p.treeReader.left_field,
e=this.p.treeReader.right_field,g=this.p.treeReader.level_field,h=parseInt(a[b],10),f=parseInt(a[e],10),l=parseInt(a[g],10);d(this.p.data).each(function(){parseInt(this[g],10)===l+1&&parseInt(this[b],10)>h&&parseInt(this[e],10)<f&&c.push(this)});break;case "adjacency":var i=this.p.treeReader.parent_id_field,j=this.p.localReader.id;d(this.p.data).each(function(){this[i]==a[j]&&c.push(this)})}});return c},getFullTreeNode:function(a){var c=[];this.each(function(){var b;if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var e=
this.p.treeReader.left_field,g=this.p.treeReader.right_field,h=this.p.treeReader.level_field,f=parseInt(a[e],10),l=parseInt(a[g],10),i=parseInt(a[h],10);d(this.p.data).each(function(){parseInt(this[h],10)>=i&&parseInt(this[e],10)>=f&&parseInt(this[e],10)<=l&&c.push(this)});break;case "adjacency":if(a){c.push(a);var j=this.p.treeReader.parent_id_field,o=this.p.localReader.id;d(this.p.data).each(function(n){b=c.length;for(n=0;n<b;n++)if(c[n][o]==this[j]){c.push(this);break}})}}});return c},getNodeAncestors:function(a){var c=
[];this.each(function(){if(this.grid&&this.p.treeGrid)for(var b=d(this).jqGrid("getNodeParent",a);b;){c.push(b);b=d(this).jqGrid("getNodeParent",b)}});return c},isVisibleNode:function(a){var c=true;this.each(function(){if(this.grid&&this.p.treeGrid){var b=d(this).jqGrid("getNodeAncestors",a),e=this.p.treeReader.expanded_field;d(b).each(function(){c=c&&this[e];if(!c)return false})}});return c},isNodeLoaded:function(a){var c;this.each(function(){if(this.grid&&this.p.treeGrid){var b=this.p.treeReader.leaf_field;
c=a!==undefined?a.loaded!==undefined?a.loaded:a[b]||d(this).jqGrid("getNodeChildren",a).length>0?true:false:false}});return c},expandNode:function(a){return this.each(function(){if(this.grid&&this.p.treeGrid){var c=this.p.treeReader.expanded_field,b=this.p.treeReader.parent_id_field,e=this.p.treeReader.loaded,g=this.p.treeReader.level_field,h=this.p.treeReader.left_field,f=this.p.treeReader.right_field;if(!a[c]){var l=d.jgrid.getAccessor(a,this.p.localReader.id),i=d("#"+l,this.grid.bDiv)[0],j=this.p._index[l];
if(d(this).jqGrid("isNodeLoaded",this.p.data[j])){a[c]=true;d("div.treeclick",i).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus")}else{a[c]=true;d("div.treeclick",i).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus");this.p.treeANode=i.rowIndex;this.p.datatype=this.p.treedatatype;this.p.treeGridModel=="nested"?d(this).jqGrid("setGridParam",{postData:{nodeid:l,n_left:a[h],n_right:a[f],n_level:a[g]}}):d(this).jqGrid("setGridParam",
{postData:{nodeid:l,parentid:a[b],n_level:a[g]}});d(this).trigger("reloadGrid");a[e]=true;this.p.treeGridModel=="nested"?d(this).jqGrid("setGridParam",{postData:{nodeid:"",n_left:"",n_right:"",n_level:""}}):d(this).jqGrid("setGridParam",{postData:{nodeid:"",parentid:"",n_level:""}})}}}})},collapseNode:function(a){return this.each(function(){if(this.grid&&this.p.treeGrid){var c=this.p.treeReader.expanded_field;if(a[c]){a[c]=false;c=d.jgrid.getAccessor(a,this.p.localReader.id);c=d("#"+c,this.grid.bDiv)[0];
d("div.treeclick",c).removeClass(this.p.treeIcons.minus+" tree-minus").addClass(this.p.treeIcons.plus+" tree-plus")}}})},SortTree:function(a,c,b,e){return this.each(function(){if(this.grid&&this.p.treeGrid){var g,h,f,l=[],i=this,j;g=d(this).jqGrid("getRootNodes");g=d.jgrid.from(g);g.orderBy(a,c,b,e);j=g.select();g=0;for(h=j.length;g<h;g++){f=j[g];l.push(f);d(this).jqGrid("collectChildrenSortTree",l,f,a,c,b,e)}d.each(l,function(o){var n=d.jgrid.getAccessor(this,i.p.localReader.id);d("#"+i.p.id+" tbody tr:eq("+
o+")").after(d("tr#"+n,i.grid.bDiv))});l=j=g=null}})},collectChildrenSortTree:function(a,c,b,e,g,h){return this.each(function(){if(this.grid&&this.p.treeGrid){var f,l,i,j;f=d(this).jqGrid("getNodeChildren",c);f=d.jgrid.from(f);f.orderBy(b,e,g,h);j=f.select();f=0;for(l=j.length;f<l;f++){i=j[f];a.push(i);d(this).jqGrid("collectChildrenSortTree",a,i,b,e,g,h)}}})},setTreeRow:function(a,c){var b=false;this.each(function(){if(this.grid&&this.p.treeGrid)b=d(this).jqGrid("setRowData",a,c)});return b},delTreeNode:function(a){return this.each(function(){var c=
this.p.localReader.id,b=this.p.treeReader.left_field,e=this.p.treeReader.right_field,g,h,f;if(this.grid&&this.p.treeGrid){var l=this.p._index[a];if(l!==undefined){g=parseInt(this.p.data[l][e],10);h=g-parseInt(this.p.data[l][b],10)+1;l=d(this).jqGrid("getFullTreeNode",this.p.data[l]);if(l.length>0)for(var i=0;i<l.length;i++)d(this).jqGrid("delRowData",l[i][c]);if(this.p.treeGridModel==="nested"){c=d.jgrid.from(this.p.data).greater(b,g,{stype:"integer"}).select();if(c.length)for(f in c)c[f][b]=parseInt(c[f][b],
10)-h;c=d.jgrid.from(this.p.data).greater(e,g,{stype:"integer"}).select();if(c.length)for(f in c)c[f][e]=parseInt(c[f][e],10)-h}}}})},addChildNode:function(a,c,b){var e=this[0];if(b){var g=e.p.treeReader.expanded_field,h=e.p.treeReader.leaf_field,f=e.p.treeReader.level_field,l=e.p.treeReader.parent_id_field,i=e.p.treeReader.left_field,j=e.p.treeReader.right_field,o=e.p.treeReader.loaded,n,k,m,r,p;n=0;var s=c,t;if(typeof a==="undefined"||a===null){p=e.p.data.length-1;if(p>=0)for(;p>=0;){n=Math.max(n,
parseInt(e.p.data[p][e.p.localReader.id],10));p--}a=n+1}var u=d(e).jqGrid("getInd",c);t=false;if(c===undefined||c===null||c===""){s=c=null;n="last";r=e.p.tree_root_level;p=e.p.data.length+1}else{n="after";k=e.p._index[c];m=e.p.data[k];c=m[e.p.localReader.id];r=parseInt(m[f],10)+1;p=d(e).jqGrid("getFullTreeNode",m);if(p.length){s=p=p[p.length-1][e.p.localReader.id];p=d(e).jqGrid("getInd",s)+1}else p=d(e).jqGrid("getInd",c)+1;if(m[h]){t=true;m[g]=true;d(e.rows[u]).find("span.cell-wrapperleaf").removeClass("cell-wrapperleaf").addClass("cell-wrapper").end().find("div.tree-leaf").removeClass(e.p.treeIcons.leaf+
" tree-leaf").addClass(e.p.treeIcons.minus+" tree-minus");e.p.data[k][h]=false;m[o]=true}}k=p+1;b[g]=false;b[o]=true;b[f]=r;b[h]=true;if(e.p.treeGridModel==="adjacency")b[l]=c;if(e.p.treeGridModel==="nested"){var q;if(c!==null){h=parseInt(m[j],10);f=d.jgrid.from(e.p.data);f=f.greaterOrEquals(j,h,{stype:"integer"});f=f.select();if(f.length)for(q in f){f[q][i]=f[q][i]>h?parseInt(f[q][i],10)+2:f[q][i];f[q][j]=f[q][j]>=h?parseInt(f[q][j],10)+2:f[q][j]}b[i]=h;b[j]=h+1}else{h=parseInt(d(e).jqGrid("getCol",
j,false,"max"),10);f=d.jgrid.from(e.p.data).greater(i,h,{stype:"integer"}).select();if(f.length)for(q in f)f[q][i]=parseInt(f[q][i],10)+2;f=d.jgrid.from(e.p.data).greater(j,h,{stype:"integer"}).select();if(f.length)for(q in f)f[q][j]=parseInt(f[q][j],10)+2;b[i]=h+1;b[j]=h+2}}if(c===null||d(e).jqGrid("isNodeLoaded",m)||t){d(e).jqGrid("addRowData",a,b,n,s);d(e).jqGrid("setTreeNode",p,k)}m&&!m[g]&&d(e.rows[u]).find("div.treeclick").click()}}})})(jQuery);
(function(b){b.jgrid.extend({jqGridImport:function(a){a=b.extend({imptype:"xml",impstring:"",impurl:"",mtype:"GET",impData:{},xmlGrid:{config:"roots>grid",data:"roots>rows"},jsonGrid:{config:"grid",data:"data"},ajaxOptions:{}},a||{});return this.each(function(){var d=this,c=function(f,g){var e=b(g.xmlGrid.config,f)[0],h=b(g.xmlGrid.data,f)[0],i;if(xmlJsonClass.xml2json&&b.jgrid.parse){e=xmlJsonClass.xml2json(e," ");e=b.jgrid.parse(e);for(var l in e)if(e.hasOwnProperty(l))i=e[l];if(h){h=e.grid.datatype;
e.grid.datatype="xmlstring";e.grid.datastr=f;b(d).jqGrid(i).jqGrid("setGridParam",{datatype:h})}else b(d).jqGrid(i)}else alert("xml2json or parse are not present")},j=function(f,g){if(f&&typeof f=="string"){var e=b.jgrid.parse(f),h=e[g.jsonGrid.config];if(e=e[g.jsonGrid.data]){var i=h.datatype;h.datatype="jsonstring";h.datastr=e;b(d).jqGrid(h).jqGrid("setGridParam",{datatype:i})}else b(d).jqGrid(h)}};switch(a.imptype){case "xml":b.ajax(b.extend({url:a.impurl,type:a.mtype,data:a.impData,dataType:"xml",
complete:function(f,g){if(g=="success"){c(f.responseXML,a);b.isFunction(a.importComplete)&&a.importComplete(f)}}},a.ajaxOptions));break;case "xmlstring":if(a.impstring&&typeof a.impstring=="string"){var k=b.jgrid.stringToDoc(a.impstring);if(k){c(k,a);b.isFunction(a.importComplete)&&a.importComplete(k);a.impstring=null}k=null}break;case "json":b.ajax(b.extend({url:a.impurl,type:a.mtype,data:a.impData,dataType:"json",complete:function(f,g){if(g=="success"){j(f.responseText,a);b.isFunction(a.importComplete)&&
a.importComplete(f)}}},a.ajaxOptions));break;case "jsonstring":if(a.impstring&&typeof a.impstring=="string"){j(a.impstring,a);b.isFunction(a.importComplete)&&a.importComplete(a.impstring);a.impstring=null}}})},jqGridExport:function(a){a=b.extend({exptype:"xmlstring",root:"grid",ident:"\t"},a||{});var d=null;this.each(function(){if(this.grid){var c=b.extend({},b(this).jqGrid("getGridParam"));if(c.rownumbers){c.colNames.splice(0,1);c.colModel.splice(0,1)}if(c.multiselect){c.colNames.splice(0,1);c.colModel.splice(0,
1)}if(c.subGrid){c.colNames.splice(0,1);c.colModel.splice(0,1)}c.knv=null;if(c.treeGrid)for(var j in c.treeReader)if(c.treeReader.hasOwnProperty(j)){c.colNames.splice(c.colNames.length-1);c.colModel.splice(c.colModel.length-1)}switch(a.exptype){case "xmlstring":d="<"+a.root+">"+xmlJsonClass.json2xml(c,a.ident)+"</"+a.root+">";break;case "jsonstring":d="{"+xmlJsonClass.toJson(c,a.root,a.ident,false)+"}";if(c.postData.filters!==undefined){d=d.replace(/filters":"/,'filters":');d=d.replace(/}]}"/,"}]}")}}}});
return d},excelExport:function(a){a=b.extend({exptype:"remote",url:null,oper:"oper",tag:"excel",exportOptions:{}},a||{});return this.each(function(){if(this.grid){var d;if(a.exptype=="remote"){d=b.extend({},this.p.postData);d[a.oper]=a.tag;d=jQuery.param(d);d=a.url.indexOf("?")!=-1?a.url+"&"+d:a.url+"?"+d;window.location=d}}})}})})(jQuery);
var xmlJsonClass={xml2json:function(a,b){if(a.nodeType===9)a=a.documentElement;var h=this.toJson(this.toObj(this.removeWhite(a)),a.nodeName,"\t");return"{\n"+b+(b?h.replace(/\t/g,b):h.replace(/\t|\n/g,""))+"\n}"},json2xml:function(a,b){var h=function(d,c,i){var g="",k,j;if(d instanceof Array)if(d.length===0)g+=i+"<"+c+">__EMPTY_ARRAY_</"+c+">\n";else{k=0;for(j=d.length;k<j;k+=1){var l=i+h(d[k],c,i+"\t")+"\n";g+=l}}else if(typeof d==="object"){k=false;g+=i+"<"+c;for(j in d)if(d.hasOwnProperty(j))if(j.charAt(0)===
"@")g+=" "+j.substr(1)+'="'+d[j].toString()+'"';else k=true;g+=k?">":"/>";if(k){for(j in d)if(d.hasOwnProperty(j))if(j==="#text")g+=d[j];else if(j==="#cdata")g+="<![CDATA["+d[j]+"]]\>";else if(j.charAt(0)!=="@")g+=h(d[j],j,i+"\t");g+=(g.charAt(g.length-1)==="\n"?i:"")+"</"+c+">"}}else if(typeof d==="function")g+=i+"<"+c+"><![CDATA["+d+"]]\></"+c+">";else{if(d===undefined)d="";g+=d.toString()==='""'||d.toString().length===0?i+"<"+c+">__EMPTY_STRING_</"+c+">":i+"<"+c+">"+d.toString()+"</"+c+">"}return g},
e="",f;for(f in a)if(a.hasOwnProperty(f))e+=h(a[f],f,"");return b?e.replace(/\t/g,b):e.replace(/\t|\n/g,"")},toObj:function(a){var b={},h=/function/i;if(a.nodeType===1){if(a.attributes.length){var e;for(e=0;e<a.attributes.length;e+=1)b["@"+a.attributes[e].nodeName]=(a.attributes[e].nodeValue||"").toString()}if(a.firstChild){var f=e=0,d=false,c;for(c=a.firstChild;c;c=c.nextSibling)if(c.nodeType===1)d=true;else if(c.nodeType===3&&c.nodeValue.match(/[^ \f\n\r\t\v]/))e+=1;else if(c.nodeType===4)f+=1;
if(d)if(e<2&&f<2){this.removeWhite(a);for(c=a.firstChild;c;c=c.nextSibling)if(c.nodeType===3)b["#text"]=this.escape(c.nodeValue);else if(c.nodeType===4)if(h.test(c.nodeValue))b[c.nodeName]=[b[c.nodeName],c.nodeValue];else b["#cdata"]=this.escape(c.nodeValue);else if(b[c.nodeName])if(b[c.nodeName]instanceof Array)b[c.nodeName][b[c.nodeName].length]=this.toObj(c);else b[c.nodeName]=[b[c.nodeName],this.toObj(c)];else b[c.nodeName]=this.toObj(c)}else if(a.attributes.length)b["#text"]=this.escape(this.innerXml(a));
else b=this.escape(this.innerXml(a));else if(e)if(a.attributes.length)b["#text"]=this.escape(this.innerXml(a));else{b=this.escape(this.innerXml(a));if(b==="__EMPTY_ARRAY_")b="[]";else if(b==="__EMPTY_STRING_")b=""}else if(f)if(f>1)b=this.escape(this.innerXml(a));else for(c=a.firstChild;c;c=c.nextSibling)if(h.test(a.firstChild.nodeValue)){b=a.firstChild.nodeValue;break}else b["#cdata"]=this.escape(c.nodeValue)}if(!a.attributes.length&&!a.firstChild)b=null}else if(a.nodeType===9)b=this.toObj(a.documentElement);
else alert("unhandled node type: "+a.nodeType);return b},toJson:function(a,b,h,e){if(e===undefined)e=true;var f=b?'"'+b+'"':"",d="\t",c="\n";if(!e)c=d="";if(a==="[]")f+=b?":[]":"[]";else if(a instanceof Array){var i,g,k=[];g=0;for(i=a.length;g<i;g+=1)k[g]=this.toJson(a[g],"",h+d,e);f+=(b?":[":"[")+(k.length>1?c+h+d+k.join(","+c+h+d)+c+h:k.join(""))+"]"}else if(a===null)f+=(b&&":")+"null";else if(typeof a==="object"){i=[];for(g in a)if(a.hasOwnProperty(g))i[i.length]=this.toJson(a[g],g,h+d,e);f+=(b?
":{":"{")+(i.length>1?c+h+d+i.join(","+c+h+d)+c+h:i.join(""))+"}"}else f+=typeof a==="string"?(b&&":")+'"'+a.replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"':(b&&":")+'"'+a.toString()+'"';return f},innerXml:function(a){var b="";if("innerHTML"in a)b=a.innerHTML;else{var h=function(e){var f="",d;if(e.nodeType===1){f+="<"+e.nodeName;for(d=0;d<e.attributes.length;d+=1)f+=" "+e.attributes[d].nodeName+'="'+(e.attributes[d].nodeValue||"").toString()+'"';if(e.firstChild){f+=">";for(d=e.firstChild;d;d=d.nextSibling)f+=
h(d);f+="</"+e.nodeName+">"}else f+="/>"}else if(e.nodeType===3)f+=e.nodeValue;else if(e.nodeType===4)f+="<![CDATA["+e.nodeValue+"]]\>";return f};for(a=a.firstChild;a;a=a.nextSibling)b+=h(a)}return b},escape:function(a){return a.replace(/[\\]/g,"\\\\").replace(/[\"]/g,'\\"').replace(/[\n]/g,"\\n").replace(/[\r]/g,"\\r")},removeWhite:function(a){a.normalize();var b;for(b=a.firstChild;b;)if(b.nodeType===3)if(b.nodeValue.match(/[^ \f\n\r\t\v]/))b=b.nextSibling;else{var h=b.nextSibling;a.removeChild(b);
b=h}else{b.nodeType===1&&this.removeWhite(b);b=b.nextSibling}return a}};
function tableToGrid(n,o){jQuery(n).each(function(){if(!this.grid){jQuery(this).width("99%");var a=jQuery(this).width(),d=jQuery("tr td:first-child input[type=checkbox]:first",jQuery(this)),b=jQuery("tr td:first-child input[type=radio]:first",jQuery(this));d=d.length>0;b=!d&&b.length>0;var l=d||b,c=[],g=[];jQuery("th",jQuery(this)).each(function(){if(c.length===0&&l){c.push({name:"__selection__",index:"__selection__",width:0,hidden:true});g.push("__selection__")}else{c.push({name:jQuery(this).attr("id")||
jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"),index:jQuery(this).attr("id")||jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"),width:jQuery(this).width()||150});g.push(jQuery(this).html())}});var f=[],h=[],i=[];jQuery("tbody > tr",jQuery(this)).each(function(){var j={},e=0;jQuery("td",jQuery(this)).each(function(){if(e===0&&l){var k=jQuery("input",jQuery(this)),m=k.attr("value");h.push(m||f.length);k.is(":checked")&&i.push(m);j[c[e].name]=
k.attr("value")}else j[c[e].name]=jQuery(this).html();e++});e>0&&f.push(j)});jQuery(this).empty();jQuery(this).addClass("scroll");jQuery(this).jqGrid(jQuery.extend({datatype:"local",width:a,colNames:g,colModel:c,multiselect:d},o||{}));for(a=0;a<f.length;a++){b=null;if(h.length>0)if((b=h[a])&&b.replace)b=encodeURIComponent(b).replace(/[.\-%]/g,"_");if(b===null)b=a+1;jQuery(this).jqGrid("addRowData",b,f[a])}for(a=0;a<i.length;a++)jQuery(this).jqGrid("setSelection",i[a])}})};
(function(a){if(a.browser.msie&&a.browser.version==8)a.expr[":"].hidden=function(b){return b.offsetWidth===0||b.offsetHeight===0||b.style.display=="none"};a.jgrid._multiselect=false;if(a.ui)if(a.ui.multiselect){if(a.ui.multiselect.prototype._setSelected){var q=a.ui.multiselect.prototype._setSelected;a.ui.multiselect.prototype._setSelected=function(b,h){var c=q.call(this,b,h);if(h&&this.selectedList){var f=this.element;this.selectedList.find("li").each(function(){a(this).data("optionLink")&&a(this).data("optionLink").remove().appendTo(f)})}return c}}if(a.ui.multiselect.prototype.destroy)a.ui.multiselect.prototype.destroy=
function(){this.element.show();this.container.remove();a.Widget===undefined?a.widget.prototype.destroy.apply(this,arguments):a.Widget.prototype.destroy.apply(this,arguments)};a.jgrid._multiselect=true}a.jgrid.extend({sortableColumns:function(b){return this.each(function(){function h(){c.p.disableClick=true}var c=this,f=c.p.id;f={tolerance:"pointer",axis:"x",scrollSensitivity:"1",items:">th:not(:has(#jqgh_"+f+"_cb,#jqgh_"+f+"_rn,#jqgh_"+f+"_subgrid),:hidden)",placeholder:{element:function(g){return a(document.createElement(g[0].nodeName)).addClass(g[0].className+
" ui-sortable-placeholder ui-state-highlight").removeClass("ui-sortable-helper")[0]},update:function(g,j){j.height(g.currentItem.innerHeight()-parseInt(g.currentItem.css("paddingTop")||0,10)-parseInt(g.currentItem.css("paddingBottom")||0,10));j.width(g.currentItem.innerWidth()-parseInt(g.currentItem.css("paddingLeft")||0,10)-parseInt(g.currentItem.css("paddingRight")||0,10))}},update:function(g,j){var i=a(j.item).parent();i=a(">th",i);var l={},m=c.p.id+"_";a.each(c.p.colModel,function(k){l[this.name]=
k});var d=[];i.each(function(){var k=a(">div",this).get(0).id.replace(/^jqgh_/,"").replace(m,"");k in l&&d.push(l[k])});a(c).jqGrid("remapColumns",d,true,true);a.isFunction(c.p.sortable.update)&&c.p.sortable.update(d);setTimeout(function(){c.p.disableClick=false},50)}};if(c.p.sortable.options)a.extend(f,c.p.sortable.options);else if(a.isFunction(c.p.sortable))c.p.sortable={update:c.p.sortable};if(f.start){var e=f.start;f.start=function(g,j){h();e.call(this,g,j)}}else f.start=h;if(c.p.sortable.exclude)f.items+=
":not("+c.p.sortable.exclude+")";b.sortable(f).data("sortable").floating=true})},columnChooser:function(b){function h(d,k){if(d)if(typeof d=="string")a.fn[d]&&a.fn[d].apply(k,a.makeArray(arguments).slice(2));else a.isFunction(d)&&d.apply(k,a.makeArray(arguments).slice(2))}var c=this;if(!a("#colchooser_"+c[0].p.id).length){var f=a('<div id="colchooser_'+c[0].p.id+'" style="position:relative;overflow:hidden"><div><select multiple="multiple"></select></div></div>'),e=a("select",f);b=a.extend({width:420,
height:240,classname:null,done:function(d){d&&c.jqGrid("remapColumns",d,true)},msel:"multiselect",dlog:"dialog",dlog_opts:function(d){var k={};k[d.bSubmit]=function(){d.apply_perm();d.cleanup(false)};k[d.bCancel]=function(){d.cleanup(true)};return{buttons:k,close:function(){d.cleanup(true)},modal:d.modal?d.modal:false,resizable:d.resizable?d.resizable:true,width:d.width+20}},apply_perm:function(){a("option",e).each(function(){this.selected?c.jqGrid("showCol",g[this.value].name):c.jqGrid("hideCol",
g[this.value].name)});var d=[];a("option:selected",e).each(function(){d.push(parseInt(this.value,10))});a.each(d,function(){delete i[g[parseInt(this,10)].name]});a.each(i,function(){var k=parseInt(this,10);var p=d,o=k;if(o>=0){var n=p.slice(),r=n.splice(o,Math.max(p.length-o,o));if(o>p.length)o=p.length;n[o]=k;d=n.concat(r)}else d=void 0});b.done&&b.done.call(c,d)},cleanup:function(d){h(b.dlog,f,"destroy");h(b.msel,e,"destroy");f.remove();d&&b.done&&b.done.call(c)},msel_opts:{}},a.jgrid.col,b||{});
if(a.ui)if(a.ui.multiselect)if(b.msel=="multiselect"){if(!a.jgrid._multiselect){alert("Multiselect plugin loaded after jqGrid. Please load the plugin before the jqGrid!");return}b.msel_opts=a.extend(a.ui.multiselect.defaults,b.msel_opts)}b.caption&&f.attr("title",b.caption);if(b.classname){f.addClass(b.classname);e.addClass(b.classname)}if(b.width){a(">div",f).css({width:b.width,margin:"0 auto"});e.css("width",b.width)}if(b.height){a(">div",f).css("height",b.height);e.css("height",b.height-10)}var g=
c.jqGrid("getGridParam","colModel"),j=c.jqGrid("getGridParam","colNames"),i={},l=[];e.empty();a.each(g,function(d){i[this.name]=d;if(this.hidedlg)this.hidden||l.push(d);else e.append("<option value='"+d+"' "+(this.hidden?"":"selected='selected'")+">"+j[d]+"</option>")});var m=a.isFunction(b.dlog_opts)?b.dlog_opts.call(c,b):b.dlog_opts;h(b.dlog,f,m);m=a.isFunction(b.msel_opts)?b.msel_opts.call(c,b):b.msel_opts;h(b.msel,e,m)}},sortableRows:function(b){return this.each(function(){var h=this;if(h.grid)if(!h.p.treeGrid)if(a.fn.sortable){b=
a.extend({cursor:"move",axis:"y",items:".jqgrow"},b||{});if(b.start&&a.isFunction(b.start)){b._start_=b.start;delete b.start}else b._start_=false;if(b.update&&a.isFunction(b.update)){b._update_=b.update;delete b.update}else b._update_=false;b.start=function(c,f){a(f.item).css("border-width","0px");a("td",f.item).each(function(j){this.style.width=h.grid.cols[j].style.width});if(h.p.subGrid){var e=a(f.item).attr("id");try{a(h).jqGrid("collapseSubGridRow",e)}catch(g){}}b._start_&&b._start_.apply(this,
[c,f])};b.update=function(c,f){a(f.item).css("border-width","");h.p.rownumbers===true&&a("td.jqgrid-rownum",h.rows).each(function(e){a(this).html(e+1+(parseInt(h.p.page,10)-1)*parseInt(h.p.rowNum,10))});b._update_&&b._update_.apply(this,[c,f])};a("tbody:first",h).sortable(b);a("tbody:first",h).disableSelection()}})},gridDnD:function(b){return this.each(function(){function h(){var e=a.data(c,"dnd");a("tr.jqgrow:not(.ui-draggable)",c).draggable(a.isFunction(e.drag)?e.drag.call(a(c),e):e.drag)}var c=
this;if(c.grid)if(!c.p.treeGrid)if(a.fn.draggable&&a.fn.droppable){a("#jqgrid_dnd").html()===null&&a("body").append("<table id='jqgrid_dnd' class='ui-jqgrid-dnd'></table>");if(typeof b=="string"&&b=="updateDnD"&&c.p.jqgdnd===true)h();else{b=a.extend({drag:function(e){return a.extend({start:function(g,j){if(c.p.subGrid){var i=a(j.helper).attr("id");try{a(c).jqGrid("collapseSubGridRow",i)}catch(l){}}for(i=0;i<a.data(c,"dnd").connectWith.length;i++)a(a.data(c,"dnd").connectWith[i]).jqGrid("getGridParam",
"reccount")=="0"&&a(a.data(c,"dnd").connectWith[i]).jqGrid("addRowData","jqg_empty_row",{});j.helper.addClass("ui-state-highlight");a("td",j.helper).each(function(m){this.style.width=c.grid.headers[m].width+"px"});e.onstart&&a.isFunction(e.onstart)&&e.onstart.call(a(c),g,j)},stop:function(g,j){if(j.helper.dropped&&!e.dragcopy){var i=a(j.helper).attr("id");a(c).jqGrid("delRowData",i)}for(i=0;i<a.data(c,"dnd").connectWith.length;i++)a(a.data(c,"dnd").connectWith[i]).jqGrid("delRowData","jqg_empty_row");
e.onstop&&a.isFunction(e.onstop)&&e.onstop.call(a(c),g,j)}},e.drag_opts||{})},drop:function(e){return a.extend({accept:function(g){if(!a(g).hasClass("jqgrow"))return g;g=a(g).closest("table.ui-jqgrid-btable");if(g.length>0&&a.data(g[0],"dnd")!==undefined){g=a.data(g[0],"dnd").connectWith;return a.inArray("#"+this.id,g)!=-1?true:false}return false},drop:function(g,j){if(a(j.draggable).hasClass("jqgrow")){var i=a(j.draggable).attr("id");i=j.draggable.parent().parent().jqGrid("getRowData",i);if(!e.dropbyname){var l=
0,m={},d,k=a("#"+this.id).jqGrid("getGridParam","colModel");try{for(var p in i){if(i.hasOwnProperty(p)&&k[l]){d=k[l].name;m[d]=i[p]}l++}i=m}catch(o){}}j.helper.dropped=true;if(e.beforedrop&&a.isFunction(e.beforedrop)){d=e.beforedrop.call(this,g,j,i,a("#"+c.id),a(this));if(typeof d!="undefined"&&d!==null&&typeof d=="object")i=d}if(j.helper.dropped){var n;if(e.autoid)if(a.isFunction(e.autoid))n=e.autoid.call(this,i);else{n=Math.ceil(Math.random()*1E3);n=e.autoidprefix+n}a("#"+this.id).jqGrid("addRowData",
n,i,e.droppos)}e.ondrop&&a.isFunction(e.ondrop)&&e.ondrop.call(this,g,j,i)}}},e.drop_opts||{})},onstart:null,onstop:null,beforedrop:null,ondrop:null,drop_opts:{activeClass:"ui-state-active",hoverClass:"ui-state-hover"},drag_opts:{revert:"invalid",helper:"clone",cursor:"move",appendTo:"#jqgrid_dnd",zIndex:5E3},dragcopy:false,dropbyname:false,droppos:"first",autoid:true,autoidprefix:"dnd_"},b||{});if(b.connectWith){b.connectWith=b.connectWith.split(",");b.connectWith=a.map(b.connectWith,function(e){return a.trim(e)});
a.data(c,"dnd",b);c.p.reccount!="0"&&!c.p.jqgdnd&&h();c.p.jqgdnd=true;for(var f=0;f<b.connectWith.length;f++)a(b.connectWith[f]).droppable(a.isFunction(b.drop)?b.drop.call(a(c),b):b.drop)}}}})},gridResize:function(b){return this.each(function(){var h=this;if(h.grid&&a.fn.resizable){b=a.extend({},b||{});if(b.alsoResize){b._alsoResize_=b.alsoResize;delete b.alsoResize}else b._alsoResize_=false;if(b.stop&&a.isFunction(b.stop)){b._stop_=b.stop;delete b.stop}else b._stop_=false;b.stop=function(c,f){a(h).jqGrid("setGridParam",
{height:a("#gview_"+h.p.id+" .ui-jqgrid-bdiv").height()});a(h).jqGrid("setGridWidth",f.size.width,b.shrinkToFit);b._stop_&&b._stop_.call(h,c,f)};b.alsoResize=b._alsoResize_?eval("("+("{'#gview_"+h.p.id+" .ui-jqgrid-bdiv':true,'"+b._alsoResize_+"':true}")+")"):a(".ui-jqgrid-bdiv","#gview_"+h.p.id);delete b._alsoResize_;a("#gbox_"+h.p.id).resizable(b)}})}})})(jQuery);

;(function($){
/**
 * jqGrid extension for manipulating columns properties
 * Piotr Roznicki roznicki@o2.pl
 * http://www.roznicki.prv.pl
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl-2.0.html
**/
$.jgrid.extend({
	setColumns : function(p) {
		p = $.extend({
			top : 0,
			left: 0,
			width: 200,
			height: 'auto',
			dataheight: 'auto',
			modal: false,
			drag: true,
			beforeShowForm: null,
			afterShowForm: null,
			afterSubmitForm: null,
			closeOnEscape : true,
			ShrinkToFit : false,
			jqModal : false,
			saveicon: [true,"left","ui-icon-disk"],
			closeicon: [true,"left","ui-icon-close"],
			onClose : null,
			colnameview : true,
			closeAfterSubmit : true,
			updateAfterCheck : false,
			recreateForm : false
		}, $.jgrid.col, p ||{});
		return this.each(function(){
			var $t = this;
			if (!$t.grid ) { return; }
			var onBeforeShow = typeof p.beforeShowForm === 'function' ? true: false;
			var onAfterShow = typeof p.afterShowForm === 'function' ? true: false;
			var onAfterSubmit = typeof p.afterSubmitForm === 'function' ? true: false;			
			var gID = $t.p.id,
			dtbl = "ColTbl_"+gID,
			IDs = {themodal:'colmod'+gID,modalhead:'colhd'+gID,modalcontent:'colcnt'+gID, scrollelm: dtbl};
			if(p.recreateForm===true && $("#"+IDs.themodal).html() != null) {
				$("#"+IDs.themodal).remove();
			}
			if ( $("#"+IDs.themodal).html() != null ) {
				if(onBeforeShow) { p.beforeShowForm($("#"+dtbl)); }
				$.jgrid.viewModal("#"+IDs.themodal,{gbox:"#gbox_"+gID,jqm:p.jqModal, jqM:false, modal:p.modal});
				if(onAfterShow) { p.afterShowForm($("#"+dtbl)); }
			} else {
				var dh = isNaN(p.dataheight) ? p.dataheight : p.dataheight+"px";
				var formdata = "<div id='"+dtbl+"' class='formdata' style='width:100%;overflow:auto;position:relative;height:"+dh+";'>";
				formdata += "<table class='ColTable' cellspacing='1' cellpading='2' border='0'><tbody>";
				for(i=0;i<this.p.colNames.length;i++){
					if(!$t.p.colModel[i].hidedlg) { // added from T. Tomov
						formdata += "<tr><td style='white-space: pre;'><input type='checkbox' style='margin-right:5px;' id='col_" + this.p.colModel[i].name + "' class='cbox' value='T' " + 
						((this.p.colModel[i].hidden===false)?"checked":"") + "/>" +  "<label for='col_" + this.p.colModel[i].name + "'>" + this.p.colNames[i] + ((p.colnameview) ? " (" + this.p.colModel[i].name + ")" : "" )+ "</label></td></tr>";
					}
				}
				formdata += "</tbody></table></div>"
				var bS  = !p.updateAfterCheck ? "<a href='javascript:void(0)' id='dData' class='fm-button ui-state-default ui-corner-all'>"+p.bSubmit+"</a>" : "",
				bC  ="<a href='javascript:void(0)' id='eData' class='fm-button ui-state-default ui-corner-all'>"+p.bCancel+"</a>";
				formdata += "<table border='0' class='EditTable' id='"+dtbl+"_2'><tbody><tr style='display:block;height:3px;'><td></td></tr><tr><td class='DataTD ui-widget-content'></td></tr><tr><td class='ColButton EditButton'>"+bS+"&#160;"+bC+"</td></tr></tbody></table>";
				p.gbox = "#gbox_"+gID;
				$.jgrid.createModal(IDs,formdata,p,"#gview_"+$t.p.id,$("#gview_"+$t.p.id)[0]);
				if(p.saveicon[0]==true) {
					$("#dData","#"+dtbl+"_2").addClass(p.saveicon[1] == "right" ? 'fm-button-icon-right' : 'fm-button-icon-left')
					.append("<span class='ui-icon "+p.saveicon[2]+"'></span>");
				}
				if(p.closeicon[0]==true) {
					$("#eData","#"+dtbl+"_2").addClass(p.closeicon[1] == "right" ? 'fm-button-icon-right' : 'fm-button-icon-left')
					.append("<span class='ui-icon "+p.closeicon[2]+"'></span>");
				}
				if(!p.updateAfterCheck) {
					$("#dData","#"+dtbl+"_2").click(function(e){
						for(i=0;i<$t.p.colModel.length;i++){
							if(!$t.p.colModel[i].hidedlg) { // added from T. Tomov
								var nm = $t.p.colModel[i].name.replace(/\./g, "\\.");
								if($("#col_" + nm,"#"+dtbl).attr("checked")) {
									$($t).jqGrid("showCol",$t.p.colModel[i].name);
									$("#col_" + nm,"#"+dtbl).attr("defaultChecked",true); // Added from T. Tomov IE BUG
								} else {
									$($t).jqGrid("hideCol",$t.p.colModel[i].name);
									$("#col_" + nm,"#"+dtbl).attr("defaultChecked",""); // Added from T. Tomov IE BUG
								}
							}
						}
						if(p.ShrinkToFit===true) {
							$($t).jqGrid("setGridWidth",$t.grid.width-0.001,true);
						}
						if(p.closeAfterSubmit) $.jgrid.hideModal("#"+IDs.themodal,{gb:"#gbox_"+gID,jqm:p.jqModal, onClose: p.onClose});
						if (onAfterSubmit) { p.afterSubmitForm($("#"+dtbl)); }
						return false;
					});
				} else {
					$(":input","#"+dtbl).click(function(e){
						var cn = this.id.substr(4);
						if(cn){
							if(this.checked) {
								$($t).jqGrid("showCol",cn);
							} else {
								$($t).jqGrid("hideCol",cn);
							}
							if(p.ShrinkToFit===true) {
								$($t).jqGrid("setGridWidth",$t.grid.width-0.001,true);
							}
						}
						return this;
					});
				}
				$("#eData", "#"+dtbl+"_2").click(function(e){
					$.jgrid.hideModal("#"+IDs.themodal,{gb:"#gbox_"+gID,jqm:p.jqModal, onClose: p.onClose});
					return false;
				});
				$("#dData, #eData","#"+dtbl+"_2").hover(
				   function(){$(this).addClass('ui-state-hover');}, 
				   function(){$(this).removeClass('ui-state-hover');}
				);				
				if(onBeforeShow) { p.beforeShowForm($("#"+dtbl)); }
				$.jgrid.viewModal("#"+IDs.themodal,{gbox:"#gbox_"+gID,jqm:p.jqModal, jqM: true, modal:p.modal});
				if(onAfterShow) { p.afterShowForm($("#"+dtbl)); }
			}
		});
	}
});
})(jQuery);
/// <reference path="../intellisense/jquery-1.2.6-vsdoc-cn.js" />
/* --------------------------------------------------	
参数说明
option: {width:Number, items:Array, onShow:Function, rule:JSON}
成员语法(三种形式)	-- para.items
-> {text:String, icon:String, type:String, alias:String, width:Number, items:Array}		--	菜单组
-> {text:String, icon:String, type:String, alias:String, action:Function }				--	菜单项
-> {type:String}																		--	菜单分隔线
--------------------------------------------------*/
(function($) {
    function returnfalse() { return false; };
    $.fn.contextmenu = function(option) {
        option = $.extend({ alias: "cmroot", width: 150 }, option);
        var ruleName = null, target = null,
	    groups = {}, mitems = {}, actions = {}, showGroups = [],
        itemTpl = "<div class='b-m-$[type]' unselectable=on><nobr unselectable=on><img src='$[icon]' align='absmiddle'/><span unselectable=on>$[text]</span></nobr></div>";
        var gTemplet = $("<div/>").addClass("b-m-mpanel").attr("unselectable", "on").css("display", "none");
        var iTemplet = $("<div/>").addClass("b-m-item").attr("unselectable", "on");
        var sTemplet = $("<div/>").addClass("b-m-split");
        //创建菜单组
        var buildGroup = function(obj) {
            groups[obj.alias] = this;
            this.gidx = obj.alias;
            this.id = obj.alias;
            if (obj.disable) {
                this.disable = obj.disable;
                this.className = "b-m-idisable";
            }
            $(this).width(obj.width).click(returnfalse).mousedown(returnfalse).appendTo($("body"));
            obj = null;
            return this;
        };
        var buildItem = function(obj) {
            var T = this;
            T.title = obj.text;
            T.idx = obj.alias;
            T.gidx = obj.gidx;
            T.data = obj;
            T.innerHTML = itemTpl.replace(/\$\[([^\]]+)\]/g, function() {
                return obj[arguments[1]];
            });
            if (obj.disable) {
                T.disable = obj.disable;
                T.className = "b-m-idisable";
            }
            obj.items && (T.group = true);
            obj.action && (actions[obj.alias] = obj.action);
            mitems[obj.alias] = T;
            T = obj = null;
            return this;
        };
        //添加菜单项
        var addItems = function(gidx, items) {
            var tmp = null;
            for (var i = 0; i < items.length; i++) {
                if (items[i].type == "splitLine") {
                    //菜单分隔线
                    tmp = sTemplet.clone()[0];
                } else {
                    items[i].gidx = gidx;
                    if (items[i].type == "group") {
                        //菜单组
                        buildGroup.apply(gTemplet.clone()[0], [items[i]]);
                        arguments.callee(items[i].alias, items[i].items);
                        items[i].type = "arrow";
                        tmp = buildItem.apply(iTemplet.clone()[0], [items[i]]);
                    } else {
                        //菜单项
                        items[i].type = "ibody";
                        tmp = buildItem.apply(iTemplet.clone()[0], [items[i]]);
                        $(tmp).click(function(e) {
                            if (!this.disable) {
                                if ($.isFunction(actions[this.idx])) {
                                    actions[this.idx].call(this, target);
                                }
                                hideMenuPane();
                            }
                            return false;
                        });

                    } //Endif
                    $(tmp).bind("contextmenu", returnfalse).hover(overItem, outItem);
                } //Endif
                groups[gidx].appendChild(tmp);
                tmp = items[i] = items[i].items = null;
            } //Endfor
            gidx = items = null;
        };
        var overItem = function(e) {
            //如果菜单项不可用          
            if (this.disable)
                return false;
            hideMenuPane.call(groups[this.gidx]);
            //如果是菜单组
            if (this.group) {
                var pos = $(this).offset();
                var width = $(this).outerWidth();
                showMenuGroup.apply(groups[this.idx], [pos, width]);
            }
            this.className = "b-m-ifocus";
            return false;
        };
        //菜单项失去焦点
        var outItem = function(e) {
            //如果菜单项不可用
            if (this.disable )
                return false;
            if (!this.group) {
                //菜单项
                this.className = "b-m-item";
            } //Endif
            return false;
        };
        //在指定位置显示指定的菜单组
        var showMenuGroup = function(pos, width) {
            var bwidth = $("body").width();
            var bheight = document.documentElement.clientHeight;
            var mwidth = $(this).outerWidth();
            var mheight = $(this).outerHeight();
            pos.left = (pos.left + width + mwidth > bwidth) ? (pos.left - mwidth < 0 ? 0 : pos.left - mwidth) : pos.left + width;
            pos.top = (pos.top + mheight > bheight) ? (pos.top - mheight + (width > 0 ? 25 : 0) < 0 ? 0 : pos.top - mheight + (width > 0 ? 25 : 0)) : pos.top;
            $(this).css(pos).show();
            showGroups.push(this.gidx);
        };
        //隐藏菜单组
        var hideMenuPane = function() {
            var alias = null;
            for (var i = showGroups.length - 1; i >= 0; i--) {
                if (showGroups[i] == this.gidx)
                    break;
                alias = showGroups.pop();
                groups[alias].style.display = "none";
                mitems[alias] && (mitems[alias].className = "b-m-item");
            } //Endfor
            //CollectGarbage();
        };
        function applyRule(rule) {
            if (ruleName && ruleName == rule.name)
                return false;
            for (var i in mitems)
                disable(i, !rule.disable);
            for (var i = 0; i < rule.items.length; i++)
                disable(rule.items[i], rule.disable);
            ruleName = rule.name;
        };
        function disable(alias, disabled) {
            var item = mitems[alias];
            item.className = (item.disable = item.lastChild.disabled = disabled) ? "b-m-idisable" : "b-m-item";
        };

        /** 右键菜单显示 */
        function showMenu(e, menutarget) {
            target = menutarget;
            showMenuGroup.call(groups.cmroot, { left: e.pageX, top: e.pageY }, 0);
            $(document).one('mousedown', hideMenuPane);
        }
        var $root = $("#" + option.alias);
        var root = null;
        if ($root.length == 0) {
            root = buildGroup.apply(gTemplet.clone()[0], [option]);
            root.applyrule = applyRule;
            root.showMenu = showMenu;
            addItems(option.alias, option.items);
        }
        else {
            root = $root[0];
        }
        var me = $(this).each(function() {
            return $(this).bind('contextmenu', function(e) {
                var bShowContext = (option.onContextMenu && $.isFunction(option.onContextMenu)) ? option.onContextMenu.call(this, e) : true;
                if (bShowContext) {
                    if (option.onShow && $.isFunction(option.onShow)) {
                        option.onShow.call(this, root);
                    }
                    root.showMenu(e, this);
                }
                return false;
            });
        });
        //设置显示规则
        if (option.rule) {
            applyRule(option.rule);
        }
        gTemplet = iTemplet = sTemplet = itemTpl = buildGroup = buildItem = null;
        addItems = overItem = outItem = null;
        //CollectGarbage();
        return me;
    }
})(jQuery);
/*
 * Poshy Tip jQuery plugin v1.1
 * http://vadikom.com/tools/poshy-tip-jquery-plugin-for-stylish-tooltips/
 * Copyright 2010-2011, Vasil Dinkov, http://vadikom.com/
 */

(function($) {

	var tips = [],
		reBgImage = /^url\(["']?([^"'\)]*)["']?\);?$/i,
		rePNG = /\.png$/i,
		ie6 = $.browser.msie && $.browser.version == 6;

	// make sure the tips' position is updated on resize
	function handleWindowResize() {
		$.each(tips, function() {
			this.refresh(true);
		});
	}
	$(window).resize(handleWindowResize);

	$.Poshytip = function(elm, options) {
		this.$elm = $(elm);
		this.opts = $.extend({}, $.fn.poshytip.defaults, options);
		this.$tip = $(['<div class="',this.opts.className,'">',
				'<div class="tip-inner tip-bg-image"></div>',
				'<div class="tip-arrow tip-arrow-top tip-arrow-right tip-arrow-bottom tip-arrow-left"></div>',
			'</div>'].join('')).appendTo(document.body);
		this.$arrow = this.$tip.find('div.tip-arrow');
		this.$inner = this.$tip.find('div.tip-inner');
		this.disabled = false;
		this.content = null;
		this.init();
	};

	$.Poshytip.prototype = {
		init: function() {
			tips.push(this);

			// save the original title and a reference to the Poshytip object
			var title = this.$elm.attr('title');
			this.$elm.data('title.poshytip', title !== undefined ? title : null)
				.data('poshytip', this);

			// hook element events
			if (this.opts.showOn != 'none') {
				this.$elm.bind({
					'mouseenter.poshytip': $.proxy(this.mouseenter, this),
					'mouseleave.poshytip': $.proxy(this.mouseleave, this)
				});
				switch (this.opts.showOn) {
					case 'hover':
						if (this.opts.alignTo == 'cursor')
							this.$elm.bind('mousemove.poshytip', $.proxy(this.mousemove, this));
						if (this.opts.allowTipHover)
							this.$tip.hover($.proxy(this.clearTimeouts, this), $.proxy(this.mouseleave, this));
						break;
					case 'focus':
						this.$elm.bind({
							'focus.poshytip': $.proxy(this.show, this),
							'blur.poshytip': $.proxy(this.hide, this)
						});
						break;
				}
			}
		},
		mouseenter: function(e) {
			if (this.disabled)
				return true;

			this.$elm.attr('title', '');
			if (this.opts.showOn == 'focus')
				return true;

			this.clearTimeouts();
			this.showTimeout = setTimeout($.proxy(this.show, this), this.opts.showTimeout);
		},
		mouseleave: function(e) {
			if (this.disabled || this.asyncAnimating && (this.$tip[0] === e.relatedTarget || jQuery.contains(this.$tip[0], e.relatedTarget)))
				return true;

			var title = this.$elm.data('title.poshytip');
			if (title !== null && title!==this.$elm.attr('title'))
				this.$elm.attr('btitle', title);
			if (this.opts.showOn == 'focus')
				return true;

			this.clearTimeouts();
			this.hideTimeout = setTimeout($.proxy(this.hide, this), this.opts.hideTimeout);
		},
		mousemove: function(e) {
			if (this.disabled)
				return true;

			this.eventX = e.pageX;
			this.eventY = e.pageY;
			if (this.opts.followCursor && this.$tip.data('active')) {
				this.calcPos();
				this.$tip.css({left: this.pos.l, top: this.pos.t});
				if (this.pos.arrow)
					this.$arrow[0].className = 'tip-arrow tip-arrow-' + this.pos.arrow;
			}
		},
		show: function() {
			if (this.disabled || this.$tip.data('active'))
				return;

			this.reset();
			this.update();
			this.display();
			if (this.opts.timeOnScreen)
				setTimeout($.proxy(this.hide, this), this.opts.timeOnScreen);
		},
		hide: function() {
			if (this.disabled || !this.$tip.data('active'))
				return;

			this.display(true);
		},
		reset: function() {
			this.$tip.queue([]).detach().css('visibility', 'hidden').data('active', false);
			this.$inner.find('*').poshytip('hide');
			if (this.opts.fade)
				this.$tip.css('opacity', this.opacity);
			this.$arrow[0].className = 'tip-arrow tip-arrow-top tip-arrow-right tip-arrow-bottom tip-arrow-left';
			this.asyncAnimating = false;
		},
		update: function(content, dontOverwriteOption) {
			if (this.disabled)
				return;

			var async = content !== undefined;
			if (async) {
				if (!dontOverwriteOption)
					this.opts.content = content;
				if (!this.$tip.data('active'))
					return;
			} else {
				content = this.opts.content;
			}

			// update content only if it has been changed since last time
			var self = this,
				newContent = typeof content == 'function' ?
					content.call(this.$elm[0], function(newContent) {
						self.update(newContent);
					}) :
					content == '[title]' ? this.$elm.data('title.poshytip') : content;
			if (this.content !== newContent) {
				this.$inner.empty().append(newContent);
				this.content = newContent;
			}

			this.refresh(async);
		},
		refresh: function(async) {
			if (this.disabled)
				return;

			if (async) {
				if (!this.$tip.data('active'))
					return;
				// save current position as we will need to animate
				var currPos = {left: this.$tip.css('left'), top: this.$tip.css('top')};
			}

			// reset position to avoid text wrapping, etc.
			this.$tip.css({left: 0, top: 0}).appendTo(document.body);

			// save default opacity
			if (this.opacity === undefined)
				this.opacity = this.$tip.css('opacity');

			// check for images - this code is here (i.e. executed each time we show the tip and not on init) due to some browser inconsistencies
			var bgImage = this.$tip.css('background-image').match(reBgImage),
				arrow = this.$arrow.css('background-image').match(reBgImage);

			if (bgImage) {
				var bgImagePNG = rePNG.test(bgImage[1]);
				// fallback to background-color/padding/border in IE6 if a PNG is used
				if (ie6 && bgImagePNG) {
					this.$tip.css('background-image', 'none');
					this.$inner.css({margin: 0, border: 0, padding: 0});
					bgImage = bgImagePNG = false;
				} else {
					this.$tip.prepend('<table border="0" cellpadding="0" cellspacing="0"><tr><td class="tip-top tip-bg-image" colspan="2"><span></span></td><td class="tip-right tip-bg-image" rowspan="2"><span></span></td></tr><tr><td class="tip-left tip-bg-image" rowspan="2"><span></span></td><td></td></tr><tr><td class="tip-bottom tip-bg-image" colspan="2"><span></span></td></tr></table>')
						.css({border: 0, padding: 0, 'background-image': 'none', 'background-color': 'transparent'})
						.find('.tip-bg-image').css('background-image', 'url("' + bgImage[1] +'")').end()
						.find('td').eq(3).append(this.$inner);
				}
				// disable fade effect in IE due to Alpha filter + translucent PNG issue
				if (bgImagePNG && !$.support.opacity)
					this.opts.fade = false;
			}
			// IE arrow fixes
			if (arrow && !$.support.opacity) {
				// disable arrow in IE6 if using a PNG
				if (ie6 && rePNG.test(arrow[1])) {
					arrow = false;
					this.$arrow.css('background-image', 'none');
				}
				// disable fade effect in IE due to Alpha filter + translucent PNG issue
				this.opts.fade = false;
			}

			var $table = this.$tip.find('table');
			if (ie6) {
				// fix min/max-width in IE6
				this.$tip[0].style.width = '';
				$table.width('auto').find('td').eq(3).width('auto');
				var tipW = this.$tip.width(),
					minW = parseInt(this.$tip.css('min-width')),
					maxW = parseInt(this.$tip.css('max-width'));
				if (!isNaN(minW) && tipW < minW)
					tipW = minW;
				else if (!isNaN(maxW) && tipW > maxW)
					tipW = maxW;
				this.$tip.add($table).width(tipW).eq(0).find('td').eq(3).width('100%');
			} else if ($table[0]) {
				// fix the table width if we are using a background image
				// IE9, FF4 use float numbers for width/height so use getComputedStyle for them to avoid text wrapping
				// for details look at: http://vadikom.com/dailies/offsetwidth-offsetheight-useless-in-ie9-firefox4/
				$table.width('auto').find('td').eq(3).width('auto').end().end().width(document.defaultView && document.defaultView.getComputedStyle && parseFloat(document.defaultView.getComputedStyle(this.$tip[0], null).width) || this.$tip.width()).find('td').eq(3).width('100%');
			}
			this.tipOuterW = this.$tip.outerWidth();
			this.tipOuterH = this.$tip.outerHeight();

			this.calcPos();

			// position and show the arrow image
			if (arrow && this.pos.arrow) {
				this.$arrow[0].className = 'tip-arrow tip-arrow-' + this.pos.arrow;
				this.$arrow.css('visibility', 'inherit');
			}

			if (async) {
				this.asyncAnimating = true;
				var self = this;
				this.$tip.css(currPos).animate({left: this.pos.l, top: this.pos.t}, 200, function() { self.asyncAnimating = false; });
			} else {
				this.$tip.css({left: this.pos.l, top: this.pos.t});
			}
		},
		display: function(hide) {
			var active = this.$tip.data('active');
			if (active && !hide || !active && hide)
				return;

			this.$tip.stop();
			if ((this.opts.slide && this.pos.arrow || this.opts.fade) && (hide && this.opts.hideAniDuration || !hide && this.opts.showAniDuration)) {
				var from = {}, to = {};
				// this.pos.arrow is only undefined when alignX == alignY == 'center' and we don't need to slide in that rare case
				if (this.opts.slide && this.pos.arrow) {
					var prop, arr;
					if (this.pos.arrow == 'bottom' || this.pos.arrow == 'top') {
						prop = 'top';
						arr = 'bottom';
					} else {
						prop = 'left';
						arr = 'right';
					}
					var val = parseInt(this.$tip.css(prop));
					from[prop] = val + (hide ? 0 : (this.pos.arrow == arr ? -this.opts.slideOffset : this.opts.slideOffset));
					to[prop] = val + (hide ? (this.pos.arrow == arr ? this.opts.slideOffset : -this.opts.slideOffset) : 0) + 'px';
				}
				if (this.opts.fade) {
					from.opacity = hide ? this.$tip.css('opacity') : 0;
					to.opacity = hide ? 0 : this.opacity;
				}
				this.$tip.css(from).animate(to, this.opts[hide ? 'hideAniDuration' : 'showAniDuration']);
			}
			hide ? this.$tip.queue($.proxy(this.reset, this)) : this.$tip.css('visibility', 'inherit');
			this.$tip.data('active', !active);
		},
		disable: function() {
			this.reset();
			this.disabled = true;
		},
		enable: function() {
			this.disabled = false;
		},
		destroy: function() {
			this.reset();
			this.$tip.remove();
			delete this.$tip;
			this.content = null;
			this.$elm.unbind('.poshytip').removeData('title.poshytip').removeData('poshytip');
			tips.splice($.inArray(this, tips), 1);
		},
		clearTimeouts: function() {
			if (this.showTimeout) {
				clearTimeout(this.showTimeout);
				this.showTimeout = 0;
			}
			if (this.hideTimeout) {
				clearTimeout(this.hideTimeout);
				this.hideTimeout = 0;
			}
		},
		calcPos: function() {
			var pos = {l: 0, t: 0, arrow: ''},
				$win = $(window),
				win = {
					l: $win.scrollLeft(),
					t: $win.scrollTop(),
					w: $win.width(),
					h: $win.height()
				}, xL, xC, xR, yT, yC, yB;
			if (this.opts.alignTo == 'cursor') {
				xL = xC = xR = this.eventX;
				yT = yC = yB = this.eventY;
			} else { // this.opts.alignTo == 'target'
				var elmOffset = this.$elm.offset(),
					elm = {
						l: elmOffset.left,
						t: elmOffset.top,
						w: this.$elm.outerWidth(),
						h: this.$elm.outerHeight()
					};
				xL = elm.l + (this.opts.alignX != 'inner-right' ? 0 : elm.w);	// left edge
				xC = xL + Math.floor(elm.w / 2);				// h center
				xR = xL + (this.opts.alignX != 'inner-left' ? elm.w : 0);	// right edge
				yT = elm.t + (this.opts.alignY != 'inner-bottom' ? 0 : elm.h);	// top edge
				yC = yT + Math.floor(elm.h / 2);				// v center
				yB = yT + (this.opts.alignY != 'inner-top' ? elm.h : 0);	// bottom edge
			}

			// keep in viewport and calc arrow position
			switch (this.opts.alignX) {
				case 'right':
				case 'inner-left':
					pos.l = xR + this.opts.offsetX;
					if (pos.l + this.tipOuterW > win.l + win.w)
						pos.l = win.l + win.w - this.tipOuterW;
					if (this.opts.alignX == 'right' || this.opts.alignY == 'center')
						pos.arrow = 'left';
					break;
				case 'center':
					pos.l = xC - Math.floor(this.tipOuterW / 2);
					if (pos.l + this.tipOuterW > win.l + win.w)
						pos.l = win.l + win.w - this.tipOuterW;
					else if (pos.l < win.l)
						pos.l = win.l;
					break;
				default: // 'left' || 'inner-right'
					pos.l = xL - this.tipOuterW - this.opts.offsetX;
					if (pos.l < win.l)
						pos.l = win.l;
					if (this.opts.alignX == 'left' || this.opts.alignY == 'center')
						pos.arrow = 'right';
			}
			switch (this.opts.alignY) {
				case 'bottom':
				case 'inner-top':
					pos.t = yB + this.opts.offsetY;
					// 'left' and 'right' need priority for 'target'
					if (!pos.arrow || this.opts.alignTo == 'cursor')
						pos.arrow = 'top';
					if (pos.t + this.tipOuterH > win.t + win.h) {
						pos.t = yT - this.tipOuterH - this.opts.offsetY;
						if (pos.arrow == 'top')
							pos.arrow = 'bottom';
					}
					break;
				case 'center':
					pos.t = yC - Math.floor(this.tipOuterH / 2);
					if (pos.t + this.tipOuterH > win.t + win.h)
						pos.t = win.t + win.h - this.tipOuterH;
					else if (pos.t < win.t)
						pos.t = win.t;
					break;
				default: // 'top' || 'inner-bottom'
					pos.t = yT - this.tipOuterH - this.opts.offsetY;
					// 'left' and 'right' need priority for 'target'
					if (!pos.arrow || this.opts.alignTo == 'cursor')
						pos.arrow = 'bottom';
					if (pos.t < win.t) {
						pos.t = yB + this.opts.offsetY;
						if (pos.arrow == 'bottom')
							pos.arrow = 'top';
					}
			}
			this.pos = pos;
		}
	};

	$.fn.poshytip = function(options) {
		if (typeof options == 'string') {
			var args = arguments,
				method = options;
			Array.prototype.shift.call(args);
			// unhook live events if 'destroy' is called
			if (method == 'destroy')
				this.die('mouseenter.poshytip').die('focus.poshytip');
			return this.each(function() {
				var poshytip = $(this).data('poshytip');
				if (poshytip && poshytip[method])
					poshytip[method].apply(poshytip, args);
			});
		}

		var opts = $.extend({}, $.fn.poshytip.defaults, options);

		// generate CSS for this tip class if not already generated
		if (!$('#poshytip-css-' + opts.className)[0])
			$(['<style id="poshytip-css-',opts.className,'" type="text/css">',
				'div.',opts.className,'{visibility:hidden;position:absolute;top:0;left:0;}',
				'div.',opts.className,' table, div.',opts.className,' td{margin:0;font-family:inherit;font-size:inherit;font-weight:inherit;font-style:inherit;font-variant:inherit;}',
				'div.',opts.className,' td.tip-bg-image span{display:block;font:1px/1px sans-serif;height:',opts.bgImageFrameSize,'px;width:',opts.bgImageFrameSize,'px;overflow:hidden;}',
				'div.',opts.className,' td.tip-right{background-position:100% 0;}',
				'div.',opts.className,' td.tip-bottom{background-position:100% 100%;}',
				'div.',opts.className,' td.tip-left{background-position:0 100%;}',
				'div.',opts.className,' div.tip-inner{background-position:-',opts.bgImageFrameSize,'px -',opts.bgImageFrameSize,'px;}',
				'div.',opts.className,' div.tip-arrow{visibility:hidden;position:absolute;overflow:hidden;font:1px/1px sans-serif;}',
			'</style>'].join('')).appendTo('head');

		// check if we need to hook live events
		if (opts.liveEvents && opts.showOn != 'none') {
			var deadOpts = $.extend({}, opts, { liveEvents: false });
			switch (opts.showOn) {
				case 'hover':
					this.live('mouseenter.poshytip', function() {
						var $this = $(this);
						if (!$this.data('poshytip'))
							$this.poshytip(deadOpts).poshytip('mouseenter');
					});
					break;
				case 'focus':
					this.live('focus.poshytip', function() {
						var $this = $(this);
						if (!$this.data('poshytip'))
							$this.poshytip(deadOpts).poshytip('show');
					});
					break;
			}
			return this;
		}

		return this.each(function() {
			new $.Poshytip(this, opts);
		});
	}

	// default settings
	$.fn.poshytip.defaults = {
		content: 		'[title]',	// content to display ('[title]', 'string', element, function(updateCallback){...}, jQuery)
		className:		'tip-yellow',	// class for the tips
		bgImageFrameSize:	10,		// size in pixels for the background-image (if set in CSS) frame around the inner content of the tip
		showTimeout:		500,		// timeout before showing the tip (in milliseconds 1000 == 1 second)
		hideTimeout:		100,		// timeout before hiding the tip
		timeOnScreen:		0,		// timeout before automatically hiding the tip after showing it (set to > 0 in order to activate)
		showOn:			'hover',	// handler for showing the tip ('hover', 'focus', 'none') - use 'none' to trigger it manually
		liveEvents:		false,		// use live events
		alignTo:		'cursor',	// align/position the tip relative to ('cursor', 'target')
		alignX:			'right',	// horizontal alignment for the tip relative to the mouse cursor or the target element
							// ('right', 'center', 'left', 'inner-left', 'inner-right') - 'inner-*' matter if alignTo:'target'
		alignY:			'top',		// vertical alignment for the tip relative to the mouse cursor or the target element
							// ('bottom', 'center', 'top', 'inner-bottom', 'inner-top') - 'inner-*' matter if alignTo:'target'
		offsetX:		-22,		// offset X pixels from the default position - doesn't matter if alignX:'center'
		offsetY:		18,		// offset Y pixels from the default position - doesn't matter if alignY:'center'
		allowTipHover:		true,		// allow hovering the tip without hiding it onmouseout of the target - matters only if showOn:'hover'
		followCursor:		false,		// if the tip should follow the cursor - matters only if showOn:'hover' and alignTo:'cursor'
		fade: 			true,		// use fade animation
		slide: 			true,		// use slide animation
		slideOffset: 		8,		// slide animation offset
		showAniDuration: 	300,		// show animation duration - set to 0 if you don't want show animation
		hideAniDuration: 	300		// hide animation duration - set to 0 if you don't want hide animation
	};

})(jQuery);
/**
 * JQuery AutoComplete Plugin - SelectInPlace
 * Powered by http://www.codigg.com
 */
(function($) {

$.fn.selectInPlace = function(options) {
	
	var settings = {
		data		: null,		
		postDataFunction	: null,
		url 		: "",				
		param		: "keyword",		
		dynamic 	: false, 			
		cache		: false,
		minchar		: 1,				
		opacity		: 1.0,				
		zindex		: 20000,			
		height		: 200,				
		delay		: 0,				
		max			: 5,				
		loadingImg	: RESOURCE_PATH+'/resource/external/selectInPlace/ajax-loader.gif',
		loadingText	: 'Loading...',		
		autoChange	: true,				
		type		: "GET",			
		multiple	: true,				
		separator	: ',',				
		labelMethod	: formatText,		
		htmlMethod	: formatHtml,		
		valueMethod	: getValue,	
		fullMessage	: "you cannot select more .",
		width       : 0
	};
	
	var opts = $.extend({}, settings, options);
	
	// container
	var jsH = "jSIPHover";
	var jH  = "."+jsH;
	var jC  = "#jSIPContainer";
	if($(jC).length == 0){
		$("body").append('<div id="jSIPContainer"></div>');
		$(jC).hide();
		$(jC).css({
			position: "absolute",
			opacity: opts.opacity,
			zIndex: opts.zindex
		});
	}
	
	// 
	if(!opts.dynamic){
		if(opts.url!='' && !opts.data){
			$.getJSON(opts.url, function(json){
				opts.data = json;
			});
		}
	}
	
	// outerHTML funciton for cross-browser
	$.fn.outer = function() {
		 return $($('<div></div>').html(this.clone())).html();
    };
    
	// bind click method
	function doclick(event){
		if($(jC).css('display')!='none'){
			var hide = true;
			var target = $(event.target);
			if(target.parent().hasClass('bit-input')
					&& target.attr('id')==$(jC).data('field') )
				hide = false;
			else if(target.hasClass('bit-input')
					&& target.firstChild().attr('id') == $(jC).data('field'))
				hide = false;
			else if(target.hasClass('holder')
					&& $('#'+target.attr('id')+' textarea').attr('id') == $(jC).data('field') )
				hide = false;
			
			if(hide){
				// hide and clear the old data
				$(jC).hide();
				$("ul.holder[id^='holder_'] textarea").val('').data("before",'');
			}
		}
	}
	
	$(document).bind("click", doclick);
	
    // 
    function live(holderId){
	    $("#"+holderId).live("click" , function(){
	    	var id = $(this).attr('id');
	    	$("#"+id+" textarea[id^='input_']").focus();
	    });
	    
	    $("#"+holderId+" .closebutton").live("click",function(){
	    	var p = $(this).parent();
	    	options.itemClose(p.data("data"));
	    	for(var i=0;i<=10;i++){
	    		if(p.hasClass("bit-box"))
	    			break;
	    		p = p.parent();
	    	}
	    	var oe = p.parent().prev();
	    	var vs = $.trim(oe.val())==''? new Array(): oe.val().split(opts.separator);
	    	var v = p.data("data")+'';
	    	vs = $.grep(vs,function(item,i){return item!=v;});
	    	oe.val(vs.join(opts.separator));
	    	p.remove();
	    });
	    
	    $("#"+holderId+" .bit-box").live("mouseover",function(){
	    	$(this).addClass("bit-box-focus");
	    }).live("mouseout",function(){
	    	$(this).removeClass("bit-box-focus");
	    });
    }
    
    var timeout = null;
    
    // label for selected items
    function formatText(elem){
    	return '<LI class="bit-box">'+elem.children(".title").text()+'<A class="closebutton" href="#"></A>';
    }
    
    function setAutochange(textBox){
    	if (opts.autoChange){
			$(textBox).val($(jH).children(".title").text());
			$(textBox).data('before',$(jH).children(".title").text());
    	}
    }
    
    function formatHtml(item){
    	return '<li><img src="'+item.image+'"/><div class="title">'+item.label+'</div><div>&nbsp;'+item.desc+'</div></li>';
    }
    
    function getValue(item){
    	return item.value;
    }
    
    function getdata(field){
    	var ov = $("#"+field).val();
		return $.trim(ov)==''? new Array(): ov.split(opts.separator);
    }
	
	function setdata(textBox,field){
		var v = $(jH).data("data")+'';
		var html = opts.labelMethod($(jH));
		var e = $(html).data("data",v);
		if(opts.multiple){
			var vs = getdata(field);
			if($.inArray(v,vs) < 0 ){
				vs.push(v);
				$("#"+field).val(vs.join(opts.separator));
				$(textBox).parent().before(e);
			}
		}else{
			var t = $(textBox).parent().prev();
			if($.trim(t.outer())=='')
				$(textBox).parent().before(e);
			else
				t.replaceWith(e);
			$("#"+field).val(v);
		}
		$(textBox).data('before','').val('').focus();
	}
	
	function bind(textBox,field){
		$(jC+" ul li").bind("mouseover",	function(){
			$(jH).removeClass(jsH);
			$(this).addClass(jsH);
			setAutochange(textBox);
		});
		$(jC+" ul li").click(function(){
			$(this).addClass(jsH);
			setdata(textBox,field);
		});
		$(".jSIPLoading").hide();	
	}
	
	function showContainer(holderId){
		// show suggestions container
		var offSet = $("#"+holderId).offset();
		$(jC).css({
			position: "absolute",
			top: offSet.top + $("#"+holderId).outerHeight() + "px",
			left: offSet.left,
			width: $("#"+holderId).outerWidth()-2 + "px"
		}).show();
	}
	
	function adjustHeight(holderId){
		var outerheight = $(jC +" ul").outerHeight();
		if(outerheight > opts.height){
			$(jC + " ul").css({
				height: opts.height+"px"
			});
		}
	}
	
	function getRegExp(key){
		return new RegExp("^"+key,"i");
	}
	
	function match(item,re){
		return re==null ? true : item.label.search(re)>-1;
	}
	
	function action(holderId,textBox,id){
		var vs = getdata(id);
		if ($(".jSIPLoading").length == 0){
			$('<div class="jSIPLoading"><img src="'+opts.loadingImg+'" align="bottom" /> '+ opts.loadingText+'</div>').prependTo("#jSIPContainer");
			$('<div class="jSIPMessage"></div>').prependTo("#jSIPContainer");
		}
		$(".jSIPMessage").hide();
		$(jC).find('ul').remove();
		$(jC).data('field',textBox.id);
		
		if(opts.multiple && vs.length>=opts.max){
			$(".jSIPLoading").hide();
			$(".jSIPMessage").html(opts.fullMessage).show();
			showContainer(holderId);
		}else{
			$(".jSIPLoading").show();
			$(".jSIPMessage").hide();
			
			$(jC).find('ul').remove();
			
			var postData = '';
			if (opts.param == '')
				postData = $(textBox).serialize();
			else 
				postData = opts.param + "=" + $(textBox).val();
			
			if(!opts.cache){
				postData+="&_r="+Math.random();	
			}
			var data=options.postDataFunction();
			postData=postData+"&"+$.param(data);
			// 
			if(!opts.dynamic){
				showContainer(holderId);
				var key = $(textBox).val();
				var re = key==''? null : getRegExp(key);
				$(jC).append('<ul></ul>');
				var parent = $(jC+" ul");
				$.each(opts.data, function(i,item){
					var v = opts.valueMethod(item);
					if(match(item,re) && $.inArray(v+'',vs)==-1){
						var e = $(opts.htmlMethod(item)).data('data',v);
						parent.append(e);
					}
				});
				adjustHeight(holderId);
				bind(textBox,id);
			}else{
				if(timeout)
					clearTimeout(timeout);
				timeout = setTimeout(function () {
					showContainer(holderId);
					$.ajax({
						url:opts.url,
						data:postData,
						type:'post',
						dataType:"json",
						complete:function(json){
							var jsonData=eval("("+json.responseText+")");
							$(jC).children().remove();
							$(jC).append('<ul style="width:'+(opts.width+10)+'px"></ul>');
							var parent = $(jC+" ul");
							$.each(jsonData, function(i,item){
								var v = opts.valueMethod(item);
								if($.inArray(v+'',vs)==-1){
									var e = $(opts.htmlMethod(item)).data('data',v);
									parent.append(e);
								}
							});
							adjustHeight(holderId);
							bind(textBox,id);
						}
					});
				}, opts.delay);
			}
		}
	}
	
	var idx = 1;
	
	return this.each(function(){
		var containerWidth = $(this).outerWidth();
		var id = $(this).attr('id');
		if(!id){
			id = 'field_'+ (idx++) ;
			$(this).attr('id',id);
		}
		// create a new input box
		var holderId="holder_"+id;
		var inputId="input_"+id;
		
		$(this).after('<ul class="holder" id="'+holderId+'"><li class="bit-input"><textarea id="'+inputId+'"/></li></ul>');
		
		// replace the origin one
		var h = $(this).outer().replace(/type=\"?text\"?/, 'type="hidden"');
		if(h.indexOf('type="hidden"')<0){
			h = h.replace(/<input /gi, '<input type="hidden" ');
		}
		$(this).replaceWith(h);
		$(this).remove();
		
		live(holderId);
		
		
		$("#"+holderId).css({
			width:containerWidth+"px"
		});
		
		if(opts.minchar<=0){
			$("#"+holderId).click(function(e){
				var textBox = $('#'+holderId+' textarea')[0];
				action(holderId,textBox,id);
			});
		}
		
		$("#"+inputId).keyup(function(e){
			var textBox = this;
			var beforeVal = $(this).data('before');
			var textVal = this.value;
			
			if(textVal != beforeVal)
				$(textBox).data('before',textBox.value);
			
			if(e.keyCode==8 && beforeVal==''){
				$(textBox).parent().prev().children(".closebutton").click();
			}else if (textVal.length >= opts.minchar){
				if (e.keyCode == 27 ) {// escape key
					$(jC).hide();
				}else if (e.keyCode == 13 ) { // enter key
					if ($(jH).length == 1){
						setdata(textBox,id);
					}
					$(jC).hide();
				}else if (e.keyCode == 40) { // down
					if ($(jH).length == 1) {
						if (!$(jH).next().length == 0) {
							$(jH).next().addClass(jsH);
							$(".jSIPHover:eq(0)").removeClass(jsH);
							setAutochange(textBox);
						}
					}else {
						$("#jSIPContainer ul li:first-child").addClass(jsH);
						setAutochange(textBox);
					}
					
					var scrHeight=0;
					var selectLI=$(".jSIPHover:eq(0)").text();
					var maxHeight=$("#jSIPContainer ul").height();
					$("#jSIPContainer ul li").each(function(i,n){
						scrHeight=scrHeight+$(this).outerHeight();
						if($(this).text()==selectLI)
						return false;
					})
					$(".jSIPHover:eq(0)").parent().scrollTop(scrHeight-maxHeight);
				}else if (e.keyCode == 38) {
					// if any suggestion is highlighted
					if ($(jH).length == 1 ) {
						if (!$(jH).prev().length == 0) {
							$(jH).prev().addClass(jsH);
							$(".jSIPHover:eq(1)").removeClass(jsH);
							setAutochange(textBox);
						}
						// if is first child
						else {
							$(jH).removeClass(jsH);
						}
					}
					var scrHeight=0;
					var selectLI=$(".jSIPHover:eq(0)").text();
					var maxHeight=$("#jSIPContainer ul").height();
					var HeightLi=$(".jSIPHover:eq(0)").outerHeight();
					$("#jSIPContainer ul li").each(function(i,n){
						scrHeight=scrHeight+$(this).outerHeight();
						if($(this).text()==selectLI)
						return false;
					})
					$(".jSIPHover:eq(0)").parent().scrollTop(scrHeight-HeightLi);
				}else if (this.value != beforeVal){
					action(holderId,textBox,id)
				}
			}else{
				$(jH).removeClass(jsH);
				$(jC).hide();
			}
		});
		
	});
};
})(jQuery);
(function ($) {
	$.fn.uploadFile=function(option){
		function   GetCookie(sName){     
		    var   aCookie   =   document.cookie.split("; "); 
		    for(var i=0;i<aCookie.length;i++) {      
		        var aCrumb=aCookie[i].split("=");
		        if(sName==aCrumb[0])     
		            return unescape(aCrumb[1]);   
		    }       
		    return null;  
		}
		var self = $(this);
		var selfId=self.attr("id")
		var thisTitle=document.title;
		var rename=false;
		var fileExtBol=false;
		var flashMessage=$.flashVersion();
		var sid=GetCookie("sid");
		var returnBoo=true;
		var targetId = "";
		if($("#targetId").length>0){
			targetId  = $("#targetId").val();
		 }
		var targetType = "";
		//安全检测*.rtf;*.tar;*.vsd;*.tif;验证去除增加音频文件*.mp3;*.wma;*.wav;*.rm;*.amr;*.3gpp;
		var filenameExt='*.jpg;*.gif;*.png;*.zip;*.jpeg;*.pdf;*.pptx;*.xlsx;*.rar;*.bmp;*.xls;*.docx;*.doc;*.txt;*.ceb;*.mp3;*.wma;*.wav;*.rm;*.amr;*.3gpp';
		var defaultOption={
			queueID        : "",
			sizeLimit      : 6291456,
			selectInputId  : "",
			targetType	   : "",
			containId      : true,
			fileDataName   : 'uploadFile',  
			method 		   : "GET",
			scriptData	   : {sid:sid,isFlash:true,targetType:"",targetId:targetId},
			uploader       : PATH+'/resource/external/uploadify/uploadify.swf',
			script         : PATH+'/enclosure/enclosureUpload.action',
			cancelImg      : RESOURCE_PATH+'/resource/external/uploadify/cancel.png',
			buttonImg	   : RESOURCE_PATH+'/resource/external/uploadify/uploadButton.jpg',
			folder         : '/',
			multi          : true,
			auto           : true,
			queueSizeLimit : 10,
			maxFileUpload : 10,
			onQueueFull    :function(){
					//alert("单次文件上传，最多选择"+defaultOption.queueSizeLimit+"个文件");
					$.messageBox({message:"单次文件上传，最多选择"+defaultOption.queueSizeLimit+"个文件",level: "error"});
					return false;
				},
			removeCompleted: false,
			width : 60,
			height: 20,
			fileExt        : filenameExt,
			fileDesc       : '文档及图片',
			onSelect:function(event,ID,fileObj){
				document.getElementById(self.attr("id")+"Uploader").updateSettings("script",PATH+'/enclosure/enclosureUpload.action');
				document.title=thisTitle;
				returnBoo=true;
				$("#"+defaultOption.selectInputId+" option").each(function(){
					//修改BUG避免重复上传同一文件.
					var str=$(this).attr("value");
					str = str.replace(/,/g, "");
					if(returnBoo && str==fileObj.name){
						$.messageBox({level:'error',message:"文件不允许重名。请修改文件名后再上传"});
						//$(this).remove();
						returnBoo=false;
					};
				});
				var fileExtNumber=4;
				if(fileObj.name.substring(fileObj.name.length-5,fileObj.name.length-4)=='.'){
					fileExtNumber=5;
				}
				if(fileObj.name.substring(fileObj.name.length-3,fileObj.name.length-2)=='.'){
					fileExtNumber=3;
				}
				var flieExtName=fileObj.name.substring(fileObj.name.length-fileExtNumber,fileObj.name.length);
				var flieExtNameArr=defaultOption.fileExt.split(";");
				for(var i=0;i<flieExtNameArr.length;i++){
					if(flieExtNameArr[i]==('*'+flieExtName.toLowerCase())){
						fileExtBol=true;
					};
				};
				if(returnBoo && !fileExtBol){
					$.messageBox({level:'error',message:"该类型文件不允许上传"});
					$(this).remove();
					returnBoo = false;
				};
				if(returnBoo && $("#"+defaultOption.queueID+" .uploadifyQueueItem").size()>=defaultOption.maxFileUpload){
					$.messageBox({level:'error',message:"最多允许上传"+defaultOption.maxFileUpload+"个文件"});
					returnBoo = false;
				};
				if(returnBoo && fileObj.size>defaultOption.sizeLimit){//如果文件大小大于默认文件大小
					$.messageBox({level:'error',message:"文件不能大于"+parseInt(defaultOption.sizeLimit/1024/1024)+"M。请重新上传文件"});
					returnBoo = false;
				}
				if(returnBoo && fileObj.size<=0){
					$.messageBox({level:'error',message:"不允许上传空文件"});
					returnBoo = false;
				}
				$(".upload-panel").show();
				if(!returnBoo){
					document.getElementById(self.attr("id")+"Uploader").updateSettings("script",'');
				}
				return returnBoo;
			}
        };
		
		$.extend(defaultOption,option);
		if(flashMessage){
			$("#custom-queue").html(flashMessage);
			$("#"+selfId+"Uploader").remove();
		}
		var events={
		  	onAllComplete  : function(event,data) {
			  	var size=$("#"+defaultOption.queueID).attr("totalSize");
			  	if(size==undefined){
			  		$("#"+defaultOption.queueID).attr("totalSize",data.allBytesLoaded);
			  	}else{
			  		$("#"+defaultOption.queueID).attr("totalSize",(parseInt(size)+data.allBytesLoaded));
			  	}
			  	if(option.onAllComplete){
			  		option.onAllComplete.call(null,event,data);
			  	}
			  	//wangxiaohu add 20140504 用户行为分析 文件上传统计功能添加 wsmalltiger@163.com
			  	if(self.attr('UBA_TABLE_ID') != null && self.attr('UBA_TABLE_ID') != '' && self.attr('UBA_useTime_startTime') != null && self.attr('UBA_useTime_startTime') != ''){
			  		var _endTime = new Date().getTime() - self.attr('UBA_useTime_startTime');
			  		if(!isNaN(_endTime) && _endTime > 0){
			  			//上传文件个数:文件总大小:上传平均速度KB/s:出现错误个数
				  		var _jsonData = '{"text": "文件上传", "useTime": ' + _endTime +', "oldValue": "", "newValue": "'+ (data.filesUploaded +":"+ data.allBytesLoaded +":"+ data.speed +":"+ data.errors) + '", "writeIndex": '+ (self.attr('uba_writeIndex') == null || self.attr('uba_writeIndex') == '' ? 0 : self.attr('uba_writeIndex')) +', "tabIndex": '+$("#"+self.attr('UBA_TABLE_ID')).attr('uba_tabId_index')+"}";
				  		$("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo', ($("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo') == null ? '' : $("#"+self.attr('UBA_TABLE_ID')).attr('uba_trajectoryInfo')) + "," +  _jsonData);
			  		}
			  	}
			  	//wangxiaohu end
			},
			onComplete	: function(e,queueId,fileObj,response,data){
				if(response=="false"){
					$.messageBox({level:'error',message:"该类型文件不允许上传"});
					$("#"+self.attr("id")+queueId).remove();
					return;
				}
				$("a","#"+self.attr("id")+queueId).data("filename",fileObj.name);
				if(returnBoo && $("#"+defaultOption.selectInputId+" option").size()<=defaultOption.maxFileUpload){
					var upFileName = fileObj.name.replace(/'/g, "&apos;");//如果文件名含单引号，HTML中单引号需要转义
					if (defaultOption.containId){
						$("#"+defaultOption.selectInputId).append("<option value=',"+upFileName+"' selected></option>");
					}else{
						$("#"+defaultOption.selectInputId).append("<option value='"+upFileName+"' selected></option>");
					}
				}
				if(option.onComplete){
			  		option.onComplete.call(null,e,queueId,fileObj,response,data);
			  	}
				var queueID = $("#"+defaultOption.queueID);
				queueID.scrollTop=queueID.scrollHeight-queueID.offsetHeight;
			},
			onCancel:function(event,ID,fileObj){
				if(confirm("该操作将直接删除上传的文件，确认删除吗？")){
					
				}else{
					return false;
				}
				//var fileName=$("#"+selfId+ID).find(".fileName").text();
				var fileName=$("a","#"+selfId+ID).data("filename");
				$.ajax({
	        		url:defaultOption.removeAction,
					type:"post",
					data:{fileName: fileName},
	        		success:function(){
						if (defaultOption.containId){
							$("option[value=',"+fileName+"']",$("#"+defaultOption.selectInputId)).remove();
						}else{
							$("option[value='"+fileName+"']",$("#"+defaultOption.selectInputId)).remove();
						}
	        		}
	        	});
			}
		};
		if(option.targetType != null || option.targetType != ""){
			defaultOption.scriptData.targetType=option.targetType;//反填
			targetType = option.targetType;//反填
		}
		$.extend(defaultOption,events);
		self.uploadify(defaultOption); 
		var settings=jQuery(this).data('settings');
		if(settings==null){
			settings = defaultOption;
		}
		self.unbind("uploadifySelectOnce").bind("uploadifySelectOnce", {'action': settings.onSelectOnce}, function(event, data) {
			if($("#"+defaultOption.selectInputId+" option").size()>=defaultOption.maxFileUpload){
				return false;
			}
			event.data.action(event, data);
			if (settings.auto) {
				if (settings.checkScript) { 
					jQuery(this).uploadifyUpload(null, false);
				} else {
					jQuery(this).uploadifyUpload(null, true);
				}
			}
		});
		document.title=thisTitle;
		$("#"+selfId+"Uploader").attr("title","仅支持JPG、GIF、PNG、ZIP、JPEG、PDF、PPTX、XLSX、RAR、BMP、XLS、DOCX、DOC、TXT、CEB、MP3、WMA、WAV、RM格式的文件").css({"margin":"5px 0"});
	};
	
	$.fn.addUploadFileValue = function(option){
		var self = $(this);
		function removeItem(id){
			$("#item"+self.attr("id")+id).remove();
		};
		var defaultOption={
			filename:"",
			filesize:"",
			id:"",
			link:"javascript:void(0)",
			showCloseButton:true,
			onRemove:function(id){}
		};
		$.extend(defaultOption,option);
		if(option.onRemove){
			defaultOption.onRemove=function(){
				option.onRemove.call(null,defaultOption.id);
			};
		};
		var fileSizeMsg="";
		if(defaultOption.filesize!=""&&defaultOption.filesize!=0){
			fileSizeMsg = '('+defaultOption.filesize+')';
		};
		if(defaultOption.showCloseButton){
			var canelHtml='<div class="cancel"><a href="javascript:void(0)" id="'+$(this).attr("id")+defaultOption.id+'"><img src="'+RESOURCE_PATH+'/resource/external/uploadify/delete.jpg" border="0"></a></div>';
		}
		else{
			var canelHtml='';
			$("#custom_file_uploadUploader").remove();
		};
		var itemHtml = '<div id="item'+self.attr("id")+defaultOption.id+'" class="uploadifyQueueItem completed">'+canelHtml+'<a href="'+defaultOption.link+'" target="_blank"><span class="fileName">'+defaultOption.filename+' '+fileSizeMsg+'</span></a></div>';
		$(this).append($(itemHtml));
		if(defaultOption.showCloseButton){
			$("#"+$(this).attr("id")+defaultOption.id).click(function(){
				if(confirm("该操作将直接删除上传的文件，确认删除吗？")){
					
				}else{
					return false;
				}
				defaultOption.onRemove(defaultOption.id);
				removeItem(defaultOption.id);
			})
		};
	}
	
	$.fn.getTotalUploadFiles = function(){
		
	}
	
	$.fn.getTotalUploadSize = function(){
		return $(this).attr("totalSize");
	}
	$.flashVersion=function(){
		var f;
		var up=false;
		var p = navigator.plugins;
        if (p && p.length) {
            for (var i = 0; i < p.length; i++) {
                if (p[i].name.indexOf('Shockwave Flash') > -1) {
                    if(p[i].description.split('Shockwave ')[1]<="Flash 6.0 r154"){
                    	//up=false;
                    }
                    break;
                }
            }
        } else if (window.ActiveXObject) {
            for (var j=9;j>=6;j--) {
                   try {   
                    var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+j+"');");
                    if (fl) {
                        f=j + '.0';
                        break;
                    }
                   }
                   catch(e) {}
            }
            if(f<="6.0"){
            	up=true;
            }
        }
        if(up){
        	return '<div id="flashMessage">您当前的flash版本过低，导致上传功能暂时无法使用，请<a href="http://get.adobe.com/cn/flashplayer/" target="_blank">点击这里</a>进行升级。</div>';
        }
        else{
        	return false;
        }
	}
})(jQuery);