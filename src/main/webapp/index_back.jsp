<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/static/js/html5shiv-3.7.2.min.js"></script>
      <script src="${ctx}/static/js/respond-1.4.2.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1>你好！</h1>
	<form action="${ctx}/file/upload" method="post" enctype="multipart/form-data" id="simple-form">
		<input type="file" name="file" id="sss_a" /> <a id="pp_submit">提交</a>
	</form>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.form.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#pp_submit').on('click', function() {
				var newForm = $('<form action="" method="POST" enctype="multipart/form-data"></form>');
				$('body').append(newForm);
				jQuery('#sss_a').appendTo(newForm);
				newForm.ajaxSubmit({
					type : "post", //提交方式  
					dataType : "json", //数据类型  
					url : "${ctx}/file/upload", //请求url  
					success : function(data) { //提交成功的回调函数
						debugger;
						alert(data.result);
					}
				});
			});
		});
	</script>

</body>
</html>