<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html >

<head>
  <title>个人信息 </title>
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
					<li><a href="/Time_flow/PersonMessage" class="black2">个人信息</a></li>		
				</ul>
			</div>
			
			<div style="width:100%; height:25px;background:gray;">
			<form action="/Time_flow/addFriend.do" method="post" accept-charset="UTF-8">
					<input type="text"  name="friendId"  value="" placeholder="请输入好友Id"/ style="width:60%;">
					<input type="submit" name="add" value="查找" >
				</form>
			
			</div>
			
		</div>
		
		
		<div class="content">
			<div class="contact">
				<h1>My friends 好友列表</h1>
				<hr>
				<br>
				
		
	   		 <c:forEach items="${list}" var="friend">
	       		
	           		<p><a href="/Time_flow/friendMessage.do?friendId=${friend.getFriendId()}" > ${friend.getFriendName()}</a></p>
	      		 
	  		  </c:forEach>
    	 
				
				
		</div>
			<div class="map">
			<iframe></iframe>
			</div>
		</div>
		
		
    </div>
	
</body>
</html>