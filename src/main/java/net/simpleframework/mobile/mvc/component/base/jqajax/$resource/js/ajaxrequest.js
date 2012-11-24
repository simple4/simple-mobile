/**
 * @author shihb(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
function evalJSON(str) {
	var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
	if (cx.test(str)) {
			str = str.replace(cx, function (a) {
	        return '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
	      });
	}
    return eval('(' + str + ')');
	     
}
//添加1个字符串参数如 a=1
function addone(map,str){
	if(str&&str.indexOf('=') > -1){
		  var nv = str.split('=');
		  map.put(nv[0],nv[1]);
	   }
}
//添加参数的name和参数的值
function strTomap(str){
	var map=new Map();
	if(str){
		if(str.indexOf('&') > -1){
			$.each(str.split('&'),function(i, n){
				addone(map,n);
			});
		}else{
			addone(map,str);
		}
	}
	return map;
}