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



<div  class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">��ҳ</a></li>	
				    <li><a href="/Time_flow/PersonMessage" class="black2">����</a></li>	
				</ul>
			</div>
			
		</div>


		<div class="content">
			<div class="contact">
				<h1>Modify data</h1>
				
		<hr>
		
		<div>
		<form action="/Time_flow/Update" method="post" accept-charset="UTF-8">
		<table>
		<tr>
			<td style="width:200px; height:30px;padding-left:20px">�ǳ�</td>
			<td><input type="text"  name="user_name" placeholder="�µ��ǳ�"></td>
		 </tr>
		<tr>
			<td style="width:200px; height:30px;padding-left:20px">����</td>
			<td><input type="text"  name="age" placeholder="�µ�����"></td>
		 </tr>
		<tr>
			<td style="width:200px; height:30px;padding-left:20px">�Ա�</td>
			<td>
			  <select name="sex">
				<optgroup label="�Ա�">
					<option value="boy" name="boy">�� </option>
					<option value="girl" name="girl">Ů </option>
				</optgroup>
			  </select>
			</td>
		 </tr>
		<tr>
			<td style="width:200px; height:30px;padding-left:20px">����</td>
			<td><input type="text"  name="Email" placeholder="�µ�����"></td>
		 </tr>
		
		</table>
		<br><br><br>
		<table width="100%">
		<tr><td align="center"><input type="submit" value="�ύ"  style="width:150px; height:30px;" class="className"></td></tr>
		</table>
		</form>
		</div>
					
	</div>
		    <div class="map">
			<iframe></iframe>
			</div>
		</div>
</div>



</html>