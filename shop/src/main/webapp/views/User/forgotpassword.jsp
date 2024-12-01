<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
	<h1>Forgot Your Password?</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<br /> <br />
				<c:if test="${alert != null}">
					<h3 class="alert alert-danger">${alert}</h3>
				</c:if>
				<form action="${pageContext.request.contextPath }/forgotpass"
					method="post" class="form-horizontal form-without-legend"
					role="form">
					<div class="form-group">
						<label for="email" class="col-lg-4 control-label">Email</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" name="email" required>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-lg-4 control-label">Phone</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" name="phone" required>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
							<button type="submit" class="btn btn-primary">Send</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<br /> <br />
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Enter the e-mail address and username associated with your
						account. Click submit to have your password e-mailed to you.</p>

					<button type="button" class="btn btn-default">More details</button>
					<br /> <br /> <br /> <br />
				</div>
			</div>
		</div>
	</div>
</div>

<!-- END CONTENT -->
