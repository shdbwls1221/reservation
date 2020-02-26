<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/header.jsp" />
<!-- /header -->
<div id="container">
	<div>
		<form name="loginForm" action="/reservation/login/action.do" method="POST">
			<input type="text" name="loginId" id="loginId" placeholder="아이디를 입력해주세요." maxlength="15"/>
			<input type="password" name="loginPassword" id="loginPassword" placeholder="비밀번호를 입력해주세요." maxlength="20"/>
			<button type="submit">로그인</button>
		</form>
		<a href="javascript:void(0)"><span>회원가입</span></a>
	</div>
</div>
<!-- footer -->
<jsp:include page="/WEB-INF/views/footer.jsp" />
<!-- /footer -->
</body>
</html>