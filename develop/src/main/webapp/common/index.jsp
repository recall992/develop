<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/plugin.jsp"></jsp:include>
<title>登录</title>
<style>
	.fd {
		margin-top: 120px;
	}
</style>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 fd well">
				<form class="form-horizontal">
					<h2 class="form-signin-heading text-center">Sign in</h2>
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密码</label>
						<div class="col-sm-9">
							<input type="password" name="pwd" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-success btn-block">Sign
								in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			var x = $('form').bootstrapValidator({
				message : '输入的格式不对',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					name : {
						message : 'The username is not valid',
						validators : {
							notEmpty : {
								message : '用户名不能为空'
							}
						}
					},
					pwd : {
						validators : {
							notEmpty : {
								message : '密码不能为空'
							},
						}
					}
				},
				submitHandler : function(validator, form, submitButton) {
					form.ajaxForm({
						url : '',
						type : 'POST',
						dataType : 'json',
						success : function(msg) {

						},
						error : function() {

						}
					})
				}
			});

		})
	</script>
</body>
</html>