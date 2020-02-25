<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 메인</title>
</head>
<script>
function addDish(){
	alert('메뉴를추가합니다');
}
function addRstnt(){
	alert('식당을 추가합니다');
}
</script>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/header.jsp" />
<!-- /header -->
<div id="container">
	<div>
		<div>
			<a href="javascript:void(0)">X</a>
			<h2>깡장집</h2>
		</div>
		<table>
			<tr>
				<th>위치</th><td>서울시 종로구 ---</td>
			</tr>
			<tr>
				<th>카츠동</th><td>6.0/10.0</td>
			</tr>
			<tr>
				<th>가격</th><td>8000원</td>
			</tr>
			<tr>
				<th colspan="2">설명</th>
			</tr>
			<tr>
				<td colspan="2">무난했다.</td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="">+</button></td>
			</tr>
		</table>
	</div>
	<div>
		<a href="javascript:addRstnt()">+</a>
		<!-- <button onclick="addRstnt()">식당추가</button> -->
	</div>
	<!-- 식당 추가 폼 -->
	<form name="rstntForm" action="/main/addRstnt.do">
	<div class="formContainer">
		<div>식당이름</div><input type="text" name="rstntName" maxlength="20"/>
		<div>위치</div><input type="text" name="rstntLocation" maxlength="30" />
		<button>+</button>
	</div>
	</form>
	
	<form name="menuForm" action="/main/addMenu.do" >
	<div class="formContainer">
		<div>메뉴이름</div><input type="text" name="menuName" maxlength="20" />
		<div>맛 점수</div><input type="text" name="menuScore" maxlength="5"/>/10.0
		<div>설명</div><input type="text" name="description"/>
		<button>+</button>
	<div>
	</form>
</div>
<!-- /container -->
<!-- footer -->
<jsp:include page="/WEB-INF/views/footer.jsp" />
<!-- /footer -->
</body>
</html>