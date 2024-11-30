<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br /> <br /> <br /> <span> he thong da gui ma kich hoat den
			email cua ban</span> <span>xin vui long kiem tra email de lay ma kich
			hoat tai khoan cua ban</span> <br />
		<div>
			<form action="VerifyCode" method="post"
				class="log-reg-block sky-form">
				<div class="input-group">
					<input type="text" name="authcode"
						class="form-control margin-top-20">
				</div>
				<input type="submit" value="kich hoat"
					class="btn-u btn-u-sea-shop margin-top-20">
			</form>
		</div>
		<br /> <br /> <br />
	</div>


</body>
</html>