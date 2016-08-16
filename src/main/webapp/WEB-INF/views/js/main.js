$(document).ready(function(){
	 
	//清除原有链接与提交
 	$("a").attr("href","javascript:;;").click(function(){alert("正在开发中!!")})
 	$("form").attr("action",""); 
	 
 	//登入注册
	if ($(".link-login")) {
		$('.link-login').unbind("click"); 
		$(".link-login").attr("href","./login.html");
	}
	//分类 
	if ($("#genre")) {
		$('#genre').unbind("click"); 
		$("#genre").attr("href","./genre.html");
	}
	//画师之家ID 
 	if ($("#painter")) {
		$('#painter').unbind("click"); 
		$("#painter").attr("href","./image.html");
	}
	//注册
	if ($("#link-reg")) {
		$('#link-reg').unbind("click"); 
		$("#link-reg").attr("href","./register.html");
	}

	 
	//返回登入
	if ($("#link-login")) {
		$('#link-login').unbind("click"); 
		$("#link-login").attr("href","./login.html");
	}
    
	//登入
	if ($("#btn-login")) {
		//$('#btn-login').unbind("click"); 
		$('#btn-login').click(function(){
			window.location.href="user_core.html";
		})
		$("#btn-login").attr("href","./login.html");
	}
	//新建小说
	if($(".js-block-main >.clearfix >a").length>0){ 
		$(".js-block-main >.clearfix >a").unbind("click"); 
		$(".js-block-main >.clearfix >a").attr("href","./add_chapter.html");
	}
})   
 
  