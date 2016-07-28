<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path %>/plugin/jquery-3.0.0.js"></script>
<script type="text/javascript" src="<%=path %>/plugin/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path %>/plugin/bootstrap-3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=path %>/plugin/bootstrapvalidator/css/bootstrapValidator.min.css" />
<script type="text/javascript" src="<%=path %>/plugin/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=path %>/plugin/jquery.form.js"></script>
</head>
<body>

</body>
</html>