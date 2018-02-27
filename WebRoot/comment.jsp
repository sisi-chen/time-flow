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

<style type="text/css">

#r3{width:60%;min-height:650px;margin:10px auto;border:1px solid green;
top:0px;overflow:scroll; position:relative;}

</style>

<body>
<img src="resource/pg2.jpg" style="width:100%;min-height:100%;position:absolute;z-index:-1;">


<div  class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">主页</a></li>
					<li><a href="/Time_flow/findDynamicPage.do">返回</a></li>		
				</ul>
			</div>
			
		</div>
    
	 <div id="r3">

	      			 <div style="width:60%;min-height:200px;border:1px dashed green;;margin:10px auto;position:relative;">
	      		
	      				   <div>
	      				  <div style="width:50px;height:50px;float:left;">
	      				   <img src="resource/1.jpg"  style="width:50px;height:50px;">
	      				  </div><br>
	      				               <span style="font-weight:bold">  用户：${dy.getUser_id()} </span>
	      				      <br>
	      				      <br> 
	      				     &nbsp; <span>${dy.getMessage()}</span>
	      				     
	    				    
	      				   </div>
	      				   <br>
	          		      <img style="width:200px;height:150px;margin:0 auto;" src="${basePath}${dy.getUrl()}"/>
	          		      
                          <div>
                          
                          <form method="post" action="/Time_flow/Comment.do" accept-charset="UTF-8">
                          <input type="text" id="news_id" name="news_id" value=${dy.getNews_id()} style="width:30px">动态编码
                          <input type="text" id="news" name="news" class="txtfield">
                          <input type="submit"   value="评论" >
                          </form>
                                    
                       </div>
                         <c:forEach  var="news" items="${ns}">
                         <span><font color="blue">${news.getUser_id()}</font>: ${news.getNews()}</span><br>
                         </c:forEach>
                          <c:forEach  var="news" items="${n}">
                         <span><font color="blue">${news.getUser_id()}</font>: ${news.getNews()}</span><br>
                         </c:forEach>
                            
	       			 </div>
	   			 
</div>
</div>	




</body>
</html>