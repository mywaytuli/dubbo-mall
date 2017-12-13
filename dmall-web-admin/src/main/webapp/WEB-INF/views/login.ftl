<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Avant</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Avant">
    <meta name="author" content="The Red Team">

    <!-- <link href="assets/less/styles.less" rel="stylesheet/less" media="all"> -->
    <link href="${request.contextPath}/fonts/font-awesome-4.5.0/css/font-awesome.css" rel="stylesheet">
    <link href="${request.contextPath}/css/styles.min.css" rel="stylesheet" type='text/css' media="all" />
    <link href="${request.contextPath}/css/dropdown-submenu.css" rel="stylesheet" type='text/css' media="all" />
    <!-- <script type="text/javascript" src="assets/js/less.js"></script> -->
</head><body class="focusedform">

<div class="verticalcenter">
	<a href="index.htm"><img src="${request.contextPath}/img/logo-big.png" alt="Logo" class="brand" /></a>
	<div class="panel panel-primary">
		<div class="panel-body">
			<h4 class="text-center" style="margin-bottom: 25px;">Log in to get started or <a href="extras-signupform.htm">Sign Up</a></h4>
				<form action="#" class="form-horizontal" style="margin-bottom: 0px !important;">
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input type="text" class="form-control" id="username" placeholder="Username">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input type="password" class="form-control" id="password" placeholder="Password">
								</div>
							</div>
						</div>
						<div class="clearfix">
							<div class="pull-right"><label><input type="checkbox" style="margin-bottom: 20px" checked=""> Remember Me</label></div>
						</div>
					</form>
					
		</div>
		<div class="panel-footer">
			<a href="extras-forgotpassword.htm" class="pull-left btn btn-link" style="padding-left:0">Forgot password?</a>
			
			<div class="pull-right">
				<a href="#" class="btn btn-default">Reset</a>
				<a href="javascript:void(0);" class="btn btn-primary" id="log_in">Log In</a>
			</div>
		</div>
	</div>
 </div>
		<script src="${request.contextPath}/js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="${request.contextPath}/plugins/crypto-js/crypto-js.js" type="text/javascript"></script>
        <script src="${request.contextPath}/plugins/crypto-js/sha1.js" type="text/javascript"></script>
		<script>
			$("#log_in").click(function () {
			    var _username = $.trim($("#username").val());
                var _password = $.trim($("#password").val());
                if(_username && _password) {
                    $.post("${request.contextPath}/admin/getToken", function (data) {
						var _token = JSON.parse(data);
                        _password = CryptoJS.SHA1(_password) + CryptoJS.SHA1(_token);
                        $.post("${request.contextPath}/admin/login.do",{account: _username, pwd: _password}, function (data) {
//							alert(JSON.parse(data).code);
							var _result = JSON.parse(data);
							if(_result.code == "1") {
							    window.location.href="${request.contextPath}/admin/index";
							} else if(_result.code == "2") {
							    alert(_result.error);
							} else {
							    //
							}
                        });
                    });
				}
            });
		</script>
</body>
</html>