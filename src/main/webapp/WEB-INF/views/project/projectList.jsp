<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA리스트</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var id='${member.id}';
	
	$(function(){
		getProjectList();
		
	});
	
	function getProjectList(){
		$.ajax({
			url:"${contextPath}/project/getList.do",
			type:"GET",
			success:function(data){
				console.log(data);
				var html="";
				if(data.length>0){
					for(i=0; i<data.length; i++){
						if(data[i].level == 1){
							html+="<div class='col-sm-6 border'>";
							html+="<input type='hidden' name='articleNO' id='articleNO' value='"+data[i].articleNO+"'>";
							html+="<div class='form-inline text-center mb-2 mt-2'>";
							html+="<h5>"+data[i].writer+"</h5>";
							html+="<div class='ml-4'><button class='btn btn-primary' onClick='mod_enable("+data[i].articleNO+");'>수정</button>";
	                        html+="<button class='btn btn-warning' onClick='delPro("+data[i].articleNO+");'>삭제</button>"
	                        html+="<button class='btn btn-danger' data-toggle='modal' data-target='#answer"+data[i].articleNO+"'>답변</button></div>"
	                        html+="<div class='ml-auto'>"+data[i].writeDate+"</div></div>"
	                        html+="<form><div class='form-group'>"
	                        html+="<input type='hidden' id='modify"+data[i].articleNO+"' value='수정완료' class='btn btn-primary float-left mb-2' onClick='modPro("+data[i].articleNO+");'>";
	                        html+="<input type='hidden' id='cancel"+data[i].articleNO+"' value='취소' class='btn btn-danger float-left' onClick='backToList();'>";
	                        html+="<textarea class='form-control' id='area"+data[i].articleNO+"'cols='20' rows='5' readonly>"+data[i].content+"</textarea>"
	                        html+="</div></form></div>"
	                        html+="<div class='modal fade' id='answer"+data[i].articleNO+"'>";
	                        html+="<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>";
	                        html+="<h4 class='modal-title'>답변하기</h4>";
	                        html+="<button type='button' class='close' data-dismiss='modal'>&times;<button></div>";
	                        html+="<form id='answerForm' action='${contextPath}/project/addAnswer.do' method='POST'><div class='modal-body'>";
	                        html+="<input type='hidden' name='writer' value='"+id+"'>";
	                        html+="<input type='hidden' name='articleNO' value='"+data[i].articleNO+"'>";
	                        html+="<textarea class='form-control' cols='20' rows='5' name='content'></textarea></div>";
	                        html+="<div class='modal-footer'><button type='submit' class='btn btn-info'>등록</button>";
	                        html+="<button type='button' class='btn btn-danger' data-dismiss='modal'>닫기</button></div></form></div></div></div>";
						}else{
							html+="<div class='col-sm-6 pb-1 bg-secondary'>";
							html+="<div class='form-inline text-center mb-2'>";
							html+="<div class='form-inline'>"
							html+="<i class='material-icons'>subdirectory_arrow_right</i>"
							html+="<h5 class='mt-3'>"+data[i].writer+"</h5></div>";
							html+="<div class='ml-4'><button class='btn btn-primary' onClick='mod_enable("+data[i].articleNO+");'>수정</button>";
	                        html+="<button class='btn btn-warning' onClick='delPro("+data[i].articleNO+");'>삭제</button></div>"
	                        html+="<div class='ml-auto'>"+data[i].writeDate+"</div></div>"
	                        html+="<form><div class='form-group'>"
	                        html+="<input type='hidden' id='modify"+data[i].articleNO+"' value='수정완료' class='btn btn-primary float-left mb-2' onClick='modPro("+data[i].articleNO+");'>";
	                        html+="<input type='hidden' id='cancel"+data[i].articleNO+"' value='취소' class='btn btn-danger float-left' onClick='backToList();'>";
	                        html+="<textarea class='form-control' id='area"+data[i].articleNO+"' cols='20' rows='5' readonly>"+data[i].content+"</textarea>"
	                        html+="</div></form></div>"
						}
					}
				}
				$("#projectList").html(html);
			}
		});
	}
	
	function addQue(){
		$.ajax({
			url:"${contextPath}/project/addQue.do",
			type:"POST",
			data:$('#queForm').serialize(),
			success:function(data){
				getProjectList();
			}
		});
	}
	
	function mod_enable(no){
		document.getElementById('area'+no).readOnly = false;
		var btn1 = document.getElementById('modify'+no);
		btn1.setAttribute('type', 'button');
		var btn2 = document.getElementById('cancel'+no);
		btn2.setAttribute('type', 'button');
	}
	
	function modPro(no){
		var content = document.getElementById('area'+no).value;
		$.ajax({
			url:"${contextPath}/project/modPro.do",
			type:"POST",
			data:{'content':content, 'articleNO':no},
			success:function(data){
				alert('수정 완료했습니다.');
				getProjectList();
			}
		});
	}
	
	function delPro(no){
		if(confirm("정말로 삭제하겠습니까?") != 0){
			$.ajax({
				url:"${contextPath}/project/delPro.do",
				type:"POST",
				data:{'articleNO':no},
				success:function(data){
					alert('정상적으로 삭제되었습니다.');
					getProjectList();
				}
			});			
		}else{
			getProjectList();
		}
	}
	
	function backToList(){
		location.href="${contextPath}/project/projectList.do"
	}
	
</script>
</head>
<body>
	<div class="container" align="center">
		<div class="form-row col-sm-6 border">
            <div>
                <h2>문의</h2>
            </div>
            <div class="ml-auto mt-1">
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#question">질문하기</button>
            </div>
        </div>
        <div class="form-group" id="projectList">
        
        </div>
	</div>
	<!-- 질문하기 모달 -->
    <div class="modal fade" id="question">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">질문하기</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form id="queForm">
                    <div class="modal-body">
                    	<input type="hidden" name="writer" value="${member.id}">
						<textarea class="form-control" cols="20" rows="5" name="content"></textarea>
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn btn-info" onClick="addQue()">등록</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>