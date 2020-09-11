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
<style>
	.carousel-control-prev-icon{
		color:#bada55;;
	}
</style>
<title>메인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<h1 align="center">분야별 베스트셀러</h1>
	<div align="center" style="width: 1030px; height: 710px; margin:0 auto">
		<div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	    <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	    <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	    <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	    <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	     <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	     <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	    
	     <div id="novel" class="carousel slide m-5px" data-ride="carousel" style="width: 250px; height: 350px; float:left;">
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	            <li data-target="#novel" data-slide-to="0" class="active"></li>
	            <li data-target="#novel" data-slide-to="1"></li>
	            <li data-target="#novel" data-slide-to="2"></li>
	            <li data-target="#novel" data-slide-to="3"></li>
	            <li data-target="#novel" data-slide-to="4"></li>
	        </ul>
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	        <h2 class="text-center">소설</h2>
	            <div class="carousel-item active">
	                <img src="${contextPath}//resources/img/novel1.jpg" alt="novel1">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel2.jpg" alt="novel2">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel3.jpg" alt="novel3">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel4.jpg" alt="novel4">
	            </div>
	            <div class="carousel-item">
	                <img src="${contextPath}//resources/img/novel5.jpg" alt="novel5">
	            </div>
	        </div>
	
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#novel" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="carousel-control-next" href="#novel" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
	    </div>
	</div>
</body>
</html>