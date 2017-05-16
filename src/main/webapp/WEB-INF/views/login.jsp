<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录</title>
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/p.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="${ctx}/static/js/html5shiv-3.7.2.min.js"></script>
      <script src="${ctx}/static/js/respond-1.4.2.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
    <c:if test="${param.error}">
    	Invalid username and password.
    </c:if>
     <div th:if="${param.logout}">
         You have been logged out.
     </div>
      <form action="${ctx}/login" method="post">
        <h2 class="form-signin-heading">请登入</h2>
        <label for="inputEmail" class="sr-only">手机号</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="手机号">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div> <!-- /container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>