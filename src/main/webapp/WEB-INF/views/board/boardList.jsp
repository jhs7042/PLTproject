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
<style>
	.cls1{
		text-decoration: none;
	}
	.cls2{
		text-align: center;
		font-size: 30px;
	}
	.txt_center{
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>글목록창</title>
</head>
<body>
	<div class="container" align="center">
        <div class="col-sm-8">
            <table class="table table-striped table-hover table-sm table-bordered">
                <thead align="center">
                    <tr class="table-active">
                        <th style="width:10%">글번호</th>
                        <th style="width:20%">작성자</th>
                        <th style="width:50%">제목</th>
                        <th style="width:20%">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                    	<c:when test="${boardList.isEmpty()}">
                    		<tr align="center">
	                    		<td>
	                    			<p align="center">
										<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
									</p>
	                    		</td>
                    		</tr>
                    	</c:when>
                    	<c:when test="${boardList != null}">
                    		<c:forEach var="article" items="${boardList}" varStatus="articleNum">
                    			<tr align="center">
									<td>${article.articleNO}</td>
									<td>${article.id}</td>
									<td align="left">
										<a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
									</td>
									<td>${article.writeDate}</td>
								</tr>
							</c:forEach>
                    	</c:when>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
		<c:if test="${isLogOn == true && member != null}">
			<a class="cls1" href="${contextPath}/board/writeForm.do">
				<p class="cls2">글쓰기</p>
			</a>
		</c:if>
</body>
</html>