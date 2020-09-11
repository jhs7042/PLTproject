<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
<style>
	#tr_btn_modify{
		display:none;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var boId = '${article.articleNO}';
	var id = '${member.id}';
	function addComment(){
		$.ajax({
			url:"${contextPath}/board/addComment.do",
			type:"POST",
			data:$('#commentForm').serialize(),
			success:function(data){
				if(data == "success"){
					getCommentList();
					$('#comcontent').val('');
				}
			}
		});
	}
	
	function updateComment(){
		
	}
	
	$(function(){
		getCommentList();
	});
	
	function getCommentList(){
		$.ajax({
			url:"${contextPath}/board/commentList.do",
			type:"GET",
			data:{'boId':boId},
			success : function(data){
				console.log(data["content"]);
	            var html = "";
	            var cCnt = data.length;
	            if(data.length > 0){
	                for(i=0; i<data.length; i++){
	                	if(id == data[i].writer){
		                    html += "<table class='table border rounded mb-0'>"
			        	    html += "<tr><td class='float-left'>"
			        	    html += "<strong id='writer'>"+data[i].writer+"</strong></td>"
			        	    html += "<td class='float-left'>"
			        	    html += "<button type='button' class='btn btn-outline-warning btn-sm' onClick='updateComment()'>수정</button>"
			        	    html += "<button type='button' class='btn btn-outline-danger btn-sm' onClick='deleteComment()'>삭제</button></td></tr>"
			        	    html += "<tr><td id='content'>"+data[i].content+"</td></tr></table>"
	                	}else{
	                		html += "<table class='table border rounded mb-0'>"
    		        	    html += "<tr><td class='float-left'>"
    		        	    html += "<strong id='writer'>"+data[i].writer+"</strong></td>"
    		        	    html += "<tr><td id='content'>"+data[i].content+"</td></tr></table>"
	                	}
	                }
	            } else {
	                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
	                html += "</table></div>";
	            }
	            $("#cCnt").html(cCnt);
	            $("#commentList").html(html);
	        }
		});
	}

	
	function backToList(obj){
		obj.action = "${contextPath}/board/boardList.do";
		obj.submit();
	}
</script>
</head>
<body>
	<div class="container" align="center">
        <form class="col-sm-10 py-4" method="post" action="${contextPath}/board/updateForm.do">
	        <div class="form-group col-sm-10">
	            <label class="float-left" for="showTitle">글 제목 :</label>
	            <input type="text" name="title" class="form-control" id="showTitle" value="${article.title}" readonly>
	            <input type="hidden" id="boId" name="articleNO" value="${article.articleNO}">
	        </div>
	        <div class="form-group col-sm-10">
	            <label class="float-left" for="showId">아이디 :</label>
	            <input type="text" name="id" class="form-control" id="showId" value="${article.id}" readonly>
	        </div>
	        <div class="form-group col-sm-10">
	            <label class="float-left" for="showContent">글 내용 :</label>
	            <textarea name="content" class="form-control" id="showContent" readonly>${article.content}</textarea>
	        </div>
	        <div class="form-group col-sm-10">
	            <label class="float-left" for="showWriteDate">작성일 :</label>
	            <input type="text" name="writeDate" class="form-control" id="showWriteDate" value="${article.writeDate}" readonly>
	        </div>
	        <c:if test="${isLogOn == true && member.id == article.id}">
    			<button type="submit" class="btn btn-warning">수정하기</button>
    			<button type="button" class="btn btn-danger" onclick="location.href='${contextPath}/board/deleteArticle.do?articleNO=${article.articleNO}'">삭제하기</button>
    		</c:if>
    		<button type="button" class="btn btn-success" onClick="backToList(this.form)">목록으로</button>
    	</form>
    	
    	<form class="col-sm-8 pb-4" id="commentForm" method="post">
	    	<span><strong>Comments</strong></span> <span id="cCnt"></span>
	    	<div class="form-row col-sm-12">
	    		<div class="form-row col-sm-10">
	    			<input type="hidden" name="writer" value="${member.id}">
	    			<input type="hidden" name="boId" value="${article.articleNO}">
	    			<textarea name="content" class="form-control" id="comcontent"></textarea>
	    		</div>
	    		<span class="form-row col-sm-2">
	    			<button type="button" class="btn btn-primary ml-auto" onClick="addComment()">댓글<br>등록</button>
	    		</span>
	    	</div>
    	</form>
    	<div class="container col-sm-8">
    		<form id="commentListForm" name="commentListForm">
		        <div id="commentList">

		        </div>
    		</form>
		</div>
    </div>
</body>
</html>