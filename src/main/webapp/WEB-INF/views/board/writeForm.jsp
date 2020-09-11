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

	function backToList(obj){
		obj.action = "${contextPath}/board/boardList.do";
		obj.submit();
	}
	
</script>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/board/write.do">
               <table class="table">
                   <h2>게시글 작성</h2>
                   <tr>
                       <td align="center">작성자</td>
                       <td><input name="id" type="text" class="form-control" value="${member.id}" readonly></td>
                   </tr>
                   <tr>
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control"></td>
                   </tr>
                   <tr>
                       <td align="center">내용</td>
                       <td><textarea name="content" class="form-control" rows="10"></textarea></td>
                   </tr>
               </table>
               <button type="submit" class="btn btn-primary">글쓰기</button>
               <button class="btn btn-danger" onClick = "backToList(this.form)">목록</button>
           </form>
        </div>
	</div>
</body>
</html>