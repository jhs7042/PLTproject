<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="container" align="center">
        <form class="col-sm-4 border border-dark py-4" method="post" action="${contextPath}/member/login.do">
	        <div class="form-group col-sm-10">
	            <label for="InputId">Id</label>
	            <input type="text" name="id" class="form-control" id="InputId" placeholder="아이디">
	        </div>
	        <div class="form-group col-sm-10">
	            <label for="InputPassword">Password</label>
	            <input type="password" name="pwd" class="form-control" id="InputPassword" placeholder="비밀번호">
	        </div>
	        <button type="submit" class="btn btn-primary">로그인</button>
	        <button type="reset" class="btn btn-danger">다시입력</button>
    	</form>
    </div>
</body>
</html>