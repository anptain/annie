<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册</title>

<!-- Bootstrap -->
<link href="${ctx}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link href="${ctx}/static/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<link href="${ctx}/static/css/p.css" rel="stylesheet">
<link href="${ctx}/static/css/register.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/res/js/html5shiv-3.7.2.min.js"></script>
      <script src="${ctx}/res/js/respond-1.4.2.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="navbar navbar-default">
		<div class="container">
			<div class="login-link">
				<span>我已注册，现在就</span>
				<button type="button" class="btn btn-default btn-sm">登录</button>
			</div>
			<div class="mod-header">
				<a href="#"> <img src="${ctx }/res/img/log_regist.png">
				</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-xs-7">构建中。</div>
			<div class="col-xs-5">
				<form class="form-horizontal form-register" role="form"
					method="post" action="${ctx}/do-register">
					<div class="form-group">
						<label for="inputEmail3" class="col-xs-3 control-label">姓名</label>
						<div class="col-xs-8 col-name">
							<div class="col-xs-6">
								<input type="text" class="form-control" id="lastName"
									name="lastName" placeholder="姓氏">
							</div>
							<div class="col-xs-6">
								<input type="text" class="form-control" id="firstName"
									name="firstName" placeholder="名字">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-xs-3 control-label">手机号</label>
						<div class="col-xs-8">
							<input type="text" class="form-control" id="username" name="phone" placeholder="手机号">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-xs-3 control-label">密码</label>
						<div class="col-xs-8">
							<input type="password" class="form-control" id="password" name="password" placeholder="密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-xs-3 control-label">确认密码</label>
						<div class="col-xs-8">
							<input type="password" class="form-control" id="againPassword" name="againPassword" placeholder="确认密码">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-8">
							<button class="btn btn-primary btn-block " type="submit">注册</button>
						</div>
					</div>
				</form>
			</div>

		</div>

	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/res/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/res/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>