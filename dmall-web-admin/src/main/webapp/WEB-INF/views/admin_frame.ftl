<#--<#assign frame = "com.shuodao.common.freemarker.AdminFrameSupportFunction"?new() />-->
<#--<#assign menu = "com.tuli.dmall.web.admin.freemarker.AdminMenuFunction"?new() />-->
<#macro page title>
<#assign time=.now?string("yyyyMMddHHmmss")/>
<#--<#if frame("admin_user")??>
	<#assign adminUser = frame("admin_user") />
</#if>-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>${title!} - 管理后台</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="" />
	<meta name="author" content="" />
   <link href="${request.contextPath}/fonts/font-awesome-4.5.0/css/font-awesome.min.css" rel="stylesheet">
   <link href="${request.contextPath}/css/styles.min.css" rel="stylesheet" type='text/css' media="all" />
   <link href="${request.contextPath}/css/dropdown-submenu.css" rel="stylesheet" type='text/css' media="all" />
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <script type='text/javascript' src='${request.contextPath}/js/jquery-1.9.1.min.js'></script>
   <script type='text/javascript' src='${request.contextPath}/js/jquery-1.10.2.min.js'></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries. Placeholdr.js enables the placeholder attribute -->
	<!--[if lt IE 9]>
		<script type="text/javascript" src="${request.contextPath}/js/html5.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/respond.min.js"></script>
        <link rel="stylesheet" href="${request.contextPath}/css/ie8.css">
	<![endif]-->
</head>
<body class="">
    <header class="navbar navbar-inverse navbar-fixed-top" role="banner">
        <a id="leftmenu-trigger" class="pull-left" data-toggle="tooltip" data-placement="bottom" title="打开/关闭边栏"></a>
        <div class="navbar-header pull-left">
            <a class="navbar-brand" href="index" style='background:url("../img/logo.jpg") no-repeat center center;background-size: contain'></a>
        </div>
		<ul class="nav navbar-nav pull-left">
        	<li class="dropdown">
        		<a href="index" class="username" ><span class="hidden-xs">后台管理</span></a>
        	</li>
        </ul>       
        <ul class="nav navbar-nav  pull-right toolbar">
        	<li id="right_dropdown" class="dropdown ">
        		<a href="#"  class="dropdown-toggle username" data-toggle="dropdown"><#if (admin_user.name)?has_content>${admin_user.name?html}<#else>未设置昵称</#if> <i class="fa fa-caret-down fa-scale"></i></a>
        		<ul class="dropdown-menu userinfo arrow">
        			<li class="username">
                        <a href="#">
        				    <div class="pull-left"><h5>您好, <#if (admin_user.name)?has_content>${admin_user.name?html}<#else>未设置昵称</#if>!</h5></div>
                        </a>
        			</li>
        			<li class="userlinks">
        				<ul class="dropdown-menu">
        					<#--
        					<li><a href="#">Edit Profile <i class="pull-right icon-pencil"></i></a></li>
        					<li><a href="#">Account <i class="pull-right icon-cog"></i></a></li>
        					<li><a href="#">Help <i class="pull-right icon-question-sign"></i></a></li>
        					<li class="divider"></li>
        					-->
        					<li><a href="${request.contextPath}/admin/logout" class="text-right">退出</a></li>
        				</ul>
        			</li>
        		</ul>
        	</li>
		</ul>
    </header>

    <div id="page-container">
        <!-- BEGIN SIDEBAR -->
        <nav id="page-leftbar" role="navigation">
                <!-- BEGIN SIDEBAR MENU -->
            <ul class="acc-menu" id="sidebar">
                ${admin_menu!}
            </ul>
            <!-- END SIDEBAR MENU -->
        </nav> 
<div id="page-content">
	<div id='wrap'>
		<#nested>
	</div> <!--wrap -->
</div> <!-- page-content -->

    <footer role="contentinfo">
        <div class="clearfix">
            <ul class="list-unstyled list-inline">
                <li>tuli &copy; 2017</li>
                <!--li class="pull-right"><a href="javascript:;" id="back-to-top">Top <i class="icon-arrow-up"></i></a></li-->
                <button class="pull-right btn btn-inverse btn-xs" id="back-to-top" style="margin-top: -1px; text-transform: uppercase;"><i class="fa fa-arrow-up"></i></button>
            </ul>
        </div>
    </footer>

</div> <!-- page-container -->

<script type='text/javascript' src='${request.contextPath}/js/bootstrap.min.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/enquire.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/jquery.cookie.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/jquery.touchSwipe.min.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/jquery.nicescroll.min.js'></script>
<script type='text/javascript' src='${request.contextPath}/js/application.js'></script>

<script type='text/javascript' src='${request.contextPath}/plugins/form-toggle/toggle.min.js'></script> 
<script type='text/javascript' src='${request.contextPath}/plugins/form-parsley/parsley.min.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/formvalidation.js'></script> 
<script type='text/javascript' src='${request.contextPath}/js/dropdown_submenu.js'></script>
<script type='text/javascript' src='${request.contextPath}/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>
<script type='text/javascript' src='${request.contextPath}/plugins/form-datepicker/js/locales/bootstrap-datepicker.zh-CN.js'></script>

<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/form-datetimepicker/css/bootstrap-datetimepicker.css">
<script type="text/javascript" src="${request.contextPath}/plugins/form-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/plugins/form-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<!--图片，声音效果-->
<link href="${request.contextPath}/plugins/lightbox/css/lightbox.css" rel="stylesheet" type='text/css' media="all" /> 
<script type='text/javascript' src='${request.contextPath}/plugins/lightbox/js/lightbox.min.js'></script>
	
<!--弹出框引用-->
<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/sweetalert/dist/sweetalert.css">
<script src="${request.contextPath}/plugins/sweetalert/dist/sweetalert.min.js"></script>
   
<!--过渡 动画插件-->
<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/transition/css/transition.css">
<script type="text/javascript" src="${request.contextPath}/plugins/transition/js/transition.js"></script>
<!--过渡 动画插件-->
<!--full screen editor-->
<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/form-fseditor/fseditor.css">
<script type="text/javascript" src="${request.contextPath}/plugins/form-fseditor/jquery.fseditor-min.js"></script>
<!--full screen editor end-->
<!--时间范围插件-->
<#--<script type="text/javascript" src="${request.contextPath}/plugins/form-daterangepicker/moment.min.js"></script>-->
<script type="text/javascript" src="${request.contextPath}/plugins/bootstrap-daterangepicker-2.1.19/moment.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/plugins/bootstrap-daterangepicker-2.1.19/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/bootstrap-daterangepicker-2.1.19/daterangepicker.css">

<!--时间范围插件 end-->

<!--select2-->
<link rel="stylesheet" type="text/css" href="${request.contextPath}/plugins/select2/select2-4.0.2/css/select2.min.css">
<script type="text/javascript" src="${request.contextPath}/plugins/select2/select2-4.0.2/js/select2.min.js"></script>
<!--select2 end-->

<style>
	.table-hover > tbody > tr:hover > td,
	.table-hover > tbody > tr:hover > th {
	 	 background-color: #dfe1e4;
	}
</style>

<script type='text/javascript'>
$(".acc-menu").each(function(index, ele){
	if($.trim($(this).html()) == ""){
		$(this).parent().remove();
	}
});
$(function(){
	$('.link_tip').tooltip();
	swal.setDefaults({
			 	cancelButtonText:"取消", 
			 	confirmButtonText: "确定",
			 	confirmButtonColor: "#DD6B55"
			});
});
function showTip(id,status,tip){
	var element = $('#'+id);
	$('body').animate({scrollTop:0});
	element.removeClass("alert-success");
	element.removeClass("alert-danger");
	var html;
	if(status=="success"){
		element.addClass("alert-success");
		html = "<strong><i class='fa fa-check-square'></i> </strong> "+tip;			
	} else{
		element.addClass("alert-danger");
		html = "<strong><i class='fa fa-warning'></i> </strong> "+tip;
	}
	element.html(html);
	if(status=="success"){
		element.fadeIn('slow',function(){
			setTimeout("window.location.reload()",500);
		});
	} else{
		element.fadeIn('slow');
	}
}
</script>
${html_other_script!}
</body>
</html>
</#macro>
