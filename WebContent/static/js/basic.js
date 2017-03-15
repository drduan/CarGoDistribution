
/**
 * @author jabriel
 */


$(function(){
	
	$("#select-list1 input").focus(function(){
		
		selectCity();
	});
	
	$(".select-box").hover(function(){
		$(document).off("click");
	}, function(){
		$(document).on("click", function(){
			seledtOptionHide();
		});
	});
	$(document).on("click", function(){
		seledtOptionHide();	
	});
	
	
	
	
	
})
//阻止冒泡和默认行为
var stop = function(e){
	
		//阻止事件冒泡
		e.cancelBubble = true;//IE
		e.stopPropagation();//DOM
		
		//停止默认行为
		e.returnValue = false;//IE
		e.preventDefault();//DOM
}

//隐藏下拉框
var seledtOptionHide = function(){
	$(".select-box input").removeClass("se");
	$(".select-option").hide();
}
//城市选择
var selectCity = function(){
	var inp = $("#select-list1 input");
	var inp2 = $("#select-list2 input");
	var city = $("#select-list1 .select-option");
	var	city2 = $("#select-list2 .select-option");
	var _val = "";
	inp.addClass("se");
	city2.hide();
	city.show();
	city.find("a").click(function(e){
		_val = $(this).html();
		var index = $(this).attr("data");
		city2.find("li").empty();
		if( typeof COK !== "undefined"){

			for(var i in COK[index]){
				
				if(/0$/.test(i)){
					continue;
				}
				var html = '<a href="#" data="';
				html += i;
				html += '">';
				html += COK[index][i];
				html += '</a>';
				city2.find("li").append(html);
			}
		}
		city.hide();
		inp.removeClass("se");
		inp2.addClass("se");
		city2.show();
		inp.val(_val);
		inp.attr("data", index);
		city2.find("a").click(function(e){
			var val2 = $(this).html();
			city2.hide();
			inp2.val(val2);
			inp2.attr("data", $(this).attr("data"));
			inp2.removeClass("se");
			stop(e);
		});
		stop(e);	
	});
	
}


