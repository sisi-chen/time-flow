<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
  <title>������Ϣ </title>
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
				    <li ><a href="index.jsp" style="text-decoration: NONE">��ҳ</a></li>	
				    <li><a href="UpdateMessage.jsp">�޸�����</a>	</li>
				</ul>
			</div>
			
		</div>


		<div class="content">
			<div class="contact">
				<h1>Personal information</h1>
				<c:forEach var="p" items="${requestScope.peopleList}">
				<p>�˺ţ�${p.getId()}</p>
				<p>�ǳƣ�${p.getUsername()}</p>   
                <p>���䣺${p.getAge()}</p>
                <p>�Ա�${p.getSex()} </p>				
				<p>���䣺${p.getEmail()}</p>
				 </c:forEach>
				 <div class="clear"> </div>
			</div>
			<div class="map">
			<iframe></iframe>
			</div>
		</div>
</div>


</body>
</html>