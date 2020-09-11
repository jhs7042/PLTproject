<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
   request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<div class="container" align="center">
        <div class="col-sm-2"></div>
	        <form class="col-sm-4 border border-dark py-4" method="post" action="${contextPath}/member/modMember.do">
		        <div class="form-group col-sm-10">
		            <label for="InputId">Id</label>
		            <input type="text" name="id" class="form-control" id="InputId" placeholder="아이디" value="${member.id}" readonly>
		        </div>
		        <div class="form-group col-sm-10">
		            <label for="InputPassword">Password</label>
		            <input type="password" name="pwd" class="form-control" id="InputPassword" placeholder="비밀번호" value="${member.pwd}">
		        </div>
		        <div class="form-group col-sm-10">
		            <label for="exampleInputPassword">Email</label>
		            <input type="text" name="email" class="form-control" id="exampleInputPassword" placeholder="이메일" value="${member.email}">
		        </div>
		        <button type="submit" class="btn btn-primary">정보수정</button>
		        <button type="reset" class="btn btn-danger">다시입력</button>
	        <br>
    	</form>
    </div>
</body>
</html>