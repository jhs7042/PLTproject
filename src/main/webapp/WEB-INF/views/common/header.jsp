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
<title>상단부</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var id = '${member.id}';
	$(function(){
		unReadCount();
	});
	
	function unReadCount(){
		$.ajax({
			url:"${contextPath}/message/unReadCount.do",
			type:"GET",
			data:{'id':id},
			success:function(data){
				$("#unReadCount").html(data);
			}
		});
	}
</script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="${contextPath}/main.do">
            	Online BookStore
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
        aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collpase navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">도서목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/board/boardList.do">게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/qnaBoard/listArticles.do">QnA 게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/project/projectList.do">프로젝트에 들어갈 게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/notice/noticeList.do">공지사항</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
            <c:choose>
            	<c:when test="${isLogOn == true && member != null}">
            		<li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	                        	쪽지
	                    </a>
	                    <div class="dropdown-menu">
	                        <a class="dropdown-item" href="#">
	                        	<button class="btn btn-default text-muted" data-target="#mesPop" data-toggle="modal">쪽지 보내기</button>
	                        </a>
	                        <a class="dropdown-item text-muted text-center" href="${contextPath}/message/messageList.do?id=${member.id}">쪽지 함</a>
	                    </div>
	             	</li>
	             	<li>
	             		<span class="badge badge-danger mt-3" id="unReadCount"></span>
	             	</li>
            		<li class="nav-item">
                    	<a class="nav-link" href="${contextPath}/member/modForm.do?id=${member.id}">내 정보 수정</a>
                	</li>
	                <li class="nav-item">
	                    <a class="nav-link" href="${contextPath}/member/logout.do">로그 아웃</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="${contextPath}/member/deleteMember.do?id=${member.id}">탈퇴</a>
	                </li>
            	</c:when>
            	<c:otherwise>
            		<li class="nav-item">
            			<a class="nav-link" href="${contextPath}/member/joinForm.do">
            				<button class="btn btn-default text-muted">회원가입</button>
            			</a>
            		</li>
            		<li class="nav-item">
            			<a class="nav-link" href="#">
            				<button class="btn btn-default text-muted" data-target="#loginPop" data-toggle="modal">로그인</button>
            			</a>
            		</li>
            	</c:otherwise>
            </c:choose>
            </ul>
        </div>
    </nav>
    
    <div class="modal fade" id="loginPop">
        <div class="modal-dialog">
            <div class="modal-content" align="center">
            	<!-- Modal Header -->
		        <div class="modal-header">
		        	<h4 class="modal-title">로그인</h4>
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		      	</div>
		      	<div class="modal-body">
	                <form class="py-4" method="post" action="${contextPath}/member/login.do">
	                    <div class="form-group col-sm-10">
	                        <label for="InputId">Id</label>
	                        <input type="text" name="id" class="form-control" id="InputId" placeholder="아이디">
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputPassword">Password</label>
	                        <input type="password" name="pwd" class="form-control" id="InputPassword" placeholder="비밀번호">
	                    </div>
	                    <button type="submit" class="btn btn-primary">로그인</button>
	                    <button type="reset" class="btn btn-warning">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="mesPop">
        <div class="modal-dialog">
            <div class="modal-content" align="center">
            	<!-- Modal Header -->
		        <div class="modal-header">
		        	<h4 class="modal-title">쪽지 보내기</h4>
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		      	</div>
		      	<div class="modal-body">
	                <form class="py-4" method="post" action="${contextPath}/message/send.do">
	                	<input type="hidden" name="sendId" value="${member.id}"> 
	                    <div class="form-group col-sm-10">
	                        <label for="inputReplyToId">수신자</label>
	                        <input type="text" name="ToId" class="form-control" id="inputReplyToId" placeholder="받을 사람">
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputReplyContent">내용</label>
	                        <textarea class="form-control" name="content" id="InputReplyContent" rows="5" cols="10"></textarea>
	                    </div>
	                    <button type="submit" class="btn btn-primary">전송</button>
	                    <button type="reset" class="btn btn-warning">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>
    
	<br>
</body>
</html>