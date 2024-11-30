<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
	<h1>Create an account</h1>
	<div class="content-form-page">
		<div class="row">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			<div class="col-md-7 col-sm-7">
				<form action="${pageContext.request.contextPath }/register"
					method="post" class="form-horizontal" role="form">
					<fieldset>
						<legend>Your personal details</legend>
						<div class="form-group">
							<label for="firstname" class="col-lg-4 control-label">First Name <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="firstname" name="firstname">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-lg-4 control-label">Last Name <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="lastname" name="lastname">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-lg-4 control-label">Phone
								number <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="phone" name="phone">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email <span
								class="require">*</span></label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="email" name="email">
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Your Account</legend>

						<div class="form-group">
							<label for="hashed_password" class="col-lg-4 control-label">
								Password <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<!-- Input for password -->
								<div class="input-group">
									<input type="hashed_password" class="form-control" id="hashed_password" name="hashed_password">
									<!-- Eye icon -->
									<span class="input-group-addon"> <i id="togglePassword" class="fa fa-eye"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="passwordConfirm" class="col-lg-4 control-label">Confirm password <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<!-- Input for password -->
								<div class="input-group">
									<input type="password" class="form-control"
										id="passwordConfirm" name="passwordConfirm">
									<!-- Eye icon -->
									<span class="input-group-addon"> <i id="togglePassword" class="fa fa-eye"></i>
									</span>
								</div>
							</div>
						</div>

						<div class="row">
							<div
								class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
								<button type="submit" class="btn btn-primary">Create an
									account</button>
								<button type="button" class="btn btn-default">Cancel</button>
							</div>
						</div>
				</form>
			</div>
			
		</div>
	</div>
</div>
<!-- END CONTENT -->

<!-- Font Awesome (for the eye icon) -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">

<!-- Add some custom styles if needed -->
<style>
.input-group-addon {
	cursor: pointer;
}
</style>

<!-- JavaScript to handle show/hide password functionality -->
<script>
	const passwordInput = document.getElementById('passwordConfirm');
	const togglePassword = document.getElementById('togglePassword');

	// Handle mouse down event (to show the password)
	togglePassword.addEventListener('mousedown', function() {
		passwordInput.type = 'text'; // Change type to text to show password
	});

	// Handle mouse up or mouse leave event (to hide the password)
	togglePassword.addEventListener('mouseup', function() {
		passwordInput.type = 'password'; // Change type back to password to hide it
	});
	togglePassword.addEventListener('mouseleave', function() {
		passwordInput.type = 'password'; // Also hide if the mouse leaves the button
	});
</script>