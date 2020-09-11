<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

	function backToList(obj, NO){
		obj.action = "${contextPath}/board/viewArticle.do?articleNO="+NO;
		obj.submit();
	}
	
</script>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/board/updateArticle.do?articleNO=+${board.articleNO}">
               <table class="table">
                   <h2>게시글 수정</h2>
                   <tr>
                       <td align="center">작성자</td>
                       <td><input name="id" type="text" class="form-control" value="${board.id}" readonly></td>
                   </tr>
                   <tr>
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control" value="${board.title}"></td>
                   </tr>
                   <tr>
                       <td align="center">내용</td>
                       <td><textarea name="content" class="form-control" rows="10">${board.content}</textarea></td>
                   </tr>
               </table>
               <button type="submit" class="btn btn-warning">수정하기</button>
               <button class="btn btn-danger" onClick = "backToList(this.form, ${board.articleNO})">취소</button>
           </form>
        </div>
	</div>
</body>
</html>