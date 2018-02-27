<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html >

<head>
  <title>动态分享 </title>
  <link rel="stylesheet" type="text/css" media="all" href="style.css">

  <script src="js/jquery.min.js"></script>
  
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script>
  <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Kappe Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.useso.com/css?family=Roboto:400,300,100,500,700,900' rel='stylesheet' type='text/css'>
  
</head>

<body>

<img src="resource/7.jpg" style="width:100%;height:700px;;position:absolute;z-index:-1;">

<div  class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">主页</a></li>
					<li><a href="/Time_flow/showFriend.do" class="black" >我的好友</a>		
				</ul>
			</div>
			
		</div>
		
		
		<div class="content">
			<div class="contact">
				<h1>Friend information</h1>
				<hr>
				<br>
				
		
	   		 <c:forEach var="p" items="${requestScope.peopleList}">
				<p>账号：${p.getId()}</p>
				<p>昵称：${p.getUsername()}</p>   
                <p>年龄：${p.getAge()}</p>
                <p>性别：${p.getSex()} </p>				
				<p>邮箱：${p.getEmail()}</p>
				 </c:forEach>
				 <hr>
				 <c:forEach var="p" items="${requestScope.peopleList}">
				<p><a href="/Time_flow/deleteFriend.do?friendId=${p.getId()}">删除好友</a></p>
				</c:forEach>
    	 
				
				
		</div>
			<div class="map">
			<iframe></iframe>
			</div>
		</div>
		
		
    </div>
	
</body>
</html>