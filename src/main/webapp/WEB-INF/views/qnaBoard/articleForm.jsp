<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script src = "${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function backToList(obj){
		obj.action = "${contextPath}/qnaBoard/listArticles.do";
		obj.submit();
	}
</script>
<meta charset="UTF-8">
<title>글쓰기 창</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/qnaBoard/insertArticle.do" enctype="multipart/form-data">
               <table class="table">
                   <h2>게시글 작성</h2>
                   <tr class="col-sm-10">
                       <td align="center">작성자</td>
                       <td><input name="id" type="text" class="form-control" value="${member.id}" readonly></td>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">제목</td>
                       <td><input name="title" type="text" class="form-control"></td>
                   </tr>
                   <tr class="col-sm-10">
                       <td align="center">내용</td>
                       <td>
                       <textarea id = "description" class="form-group" name = "content" rows = "5" cols = "100"></textarea>
                       <script>
                       var id='${member.id}';
					   //id가 description인 태그에 ckeditor를 적용시킴
					   CKEDITOR.replace("description",{
						   filebrowserImageUploadUrl  : "${contextPath}/qnaBoard/imageUpload.do?id="+id //이미지 업로드 기능을 추가하기위한 코드
					   });
					   </script>
                       </td>
                   </tr>
				  <tr>
				  	<td></td>
				  	<td></td>
				  </tr>
               </table>
               <button type="submit" class="btn btn-primary">글쓰기</button>
               <button class="btn btn-danger" onClick = "backToList(this.form)">목록</button>
           </form>
        </div>
	</div>
</body>
</html>