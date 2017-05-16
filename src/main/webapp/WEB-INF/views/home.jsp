<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alina</title>

<!-- Bootstrap -->
<link href="${ctx}/res/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/res/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<link href="${ctx}/res/css/p.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/res/js/html5shiv-3.7.2.min.js"></script>
      <script src="${ctx}/res/js/respond-1.4.2.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 sidebar">
				<ul class="nav nav-sidebar-all">
					<li role="presentation" class="active"><a href="javascript:;">全部</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<c:forEach items="${user.contactsGroup}" var="group">
						<li role="presentation" class="active"><a href="javascript:;">${group.groupName}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-md-10 col-md-offset-2">
				<div class="btn-group btn-group-sm mtm10px">
					<button type="button" class="btn btn-default">新建</button>
					<button type="button" class="btn btn-default">删除</button>
					<form action="${ctx}/logout" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button type="submit" class="btn btn-default">退出</button>
					</form>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>姓名</th>
							<th>电话</th>
							<th>QQ号</th>
							<th>分组</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contacts.content}" var="contactsItem"
							varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td><a href="#detail">${contactsItem.fullName}</a></td>
								<td>${contactsItem.phone }</td>
								<td>${contactsItem.id }</td>
								<td>${contactsItem.contactsGroup.groupName }</td>
							</tr>
						</c:forEach>
						<tr>
							<td>1</td>
							<td>小明</td>
							<td>13631882974</td>
							<td>748920938</td>
							<td>好友</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/res/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/res/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		window.onhashchange = function() {
			alert(1)
		}
	</script>
</body>
</html>