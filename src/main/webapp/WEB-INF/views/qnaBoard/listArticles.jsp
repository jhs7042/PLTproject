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
<title>Q&A게시판</title>
</head>
<body>
	<div class="container" align="center">
        <div class="col-sm-8">
            <table class="table table-striped table-hover table-sm table-bordered">
                <thead align="center">
                    <tr class="table-active">
                        <th style="width:10%">작성자</th>
                        <th style="width:60%">제목</th>
                        <th style="width:20%">작성일</th>
                        <th style="width:10%">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                    	<c:when test="${articlesList.isEmpty()}">
                    		<tr align="center">
	                    		<td>
	                    			<p align="center">
										<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
									</p>
	                    		</td>
                    		</tr>
                    	</c:when>
                    	<c:when test="${articlesList != null}">
                    		<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
                    			<tr align="center">
									<td>${article.id}<input type="hidden" name="articleNO" value="${article.articleNO}"></td>
									<td align="left">
									<c:choose>
										<c:when test="${article.level > 1}">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-return-right" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  											<path fill-rule="evenodd" d="M10.146 5.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L12.793 9l-2.647-2.646a.5.5 0 0 1 0-.708z"/>
  											<path fill-rule="evenodd" d="M3 2.5a.5.5 0 0 0-.5.5v4A2.5 2.5 0 0 0 5 9.5h8.5a.5.5 0 0 0 0-1H5A1.5 1.5 0 0 1 3.5 7V3a.5.5 0 0 0-.5-.5z"/>
											</svg>
											</span>
											<a href="${contextPath}/qnaBoard/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
										</c:when>
										<c:otherwise>
											<a href="${contextPath}/qnaBoard/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
										</c:otherwise>
									</c:choose>
									</td>
									<td>${article.writeDate}</td>
									<td>${article.viewCount}</td>
								</tr>
							</c:forEach>
                    	</c:when>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
		<c:if test="${isLogOn == true && member != null}">
		<div class="text-center">
			<a href="${contextPath}/qnaBoard/articleForm.do">질문작성</a>
		</div>
		</c:if>
</body>
</html>