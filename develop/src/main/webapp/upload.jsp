<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="plugin/uuid.js"></script>
<title>Insert title here</title>

</head>
<body>
	<div>
		<form action="upload/upfile" enctype="multipart/form-data" method="post">
			<input type="file"  name="upload">
			<input type="hidden" >
			<input type="submit" value="提交">
		</form>
	</div>
	<script type="text/javascript">
		var x=Math.uuid();
		$("input").eq(1).val(x);
	</script>
</body>
</html>