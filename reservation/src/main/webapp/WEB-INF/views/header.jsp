<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<h1>점심에 뭐 먹을까의 header입니다.</h1>
	</div>
	<c:if test="${user.name} != null and ${user.name} != ''">
		<span>${user.name}님 맛점하세요.</span><a class="logout" href="javascript:void(0)">로그아웃</a>
	</c:if>
</body>
</html>