/**
 * 依赖 transition css; jquery.js
 */
var transition = {	
		init:function(){
			var html = "";
			html+="<div class='spinner' id='loadinggif' style='display:none;'><div class='bounce1'></div><div class='bounce2'></div><div class='bounce3'></div><p class='loadingplan'></p></div>";
			$("body").append(html);
		},
		show:function(){
			$("#loadinggif").show();
		},
		hide:function(){
			$("#loadinggif").hide();
		}
}
$(function(){
	transition.init();
})
