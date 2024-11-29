<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<c:choose>
	<c:when test="${sessionScope.account == null}">
		<li><a href="${pageContext.request.contextPath }/login">Login
		</a></li>
		<li><a href="${pageContext.request.contextPath }/register">Register</a></li>
	</c:when>
	<c:otherwise>
		<li><a
			href="${pageContext.request.contextPath }/member/myaccount">${sessionScope.account.fullname}</a></li>
I 									<li><a href="${pageContext.request.contextPath }/Logout">Logout</a></li>
	</c:otherwise>
</c:choose>