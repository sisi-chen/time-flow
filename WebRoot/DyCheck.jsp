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
<img src="resource/pg1.jpg" style="width:100%;min-height:100%;position:absolute;z-index:-1;">


<div  class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">主页</a></li>
					<li class="black" ><a href="#loginmodal" id="modaltrigger">创建动态</a></li>		
				</ul>
			</div>
			
		</div>
    
	 <div id="r3">
	   <c:forEach  var="dynamic" items="${list}">

	      			 <div style="width:400px;min-height:200px;margin:10px auto;border:1px dashed gray;">
	      		
	      				   <div>
	      				   <div style="width:50px;height:50px;float:left;">
	      				   <img src="resource/1.jpg"  style="width:50px;height:50px;">
	      				   </div><br>
	      				        <span style="font-weight:bold;"> 用户：${dynamic.getUser_id()}</span>
	      				      <br>
	      				      <br> 
	      				      <br>
	      				   &nbsp;<span> ${dynamic.getMessage()}</span>
	      				      
	      				   </div>
	      				   <br>
	          		      <img style="width:200px;height:150px;margin:0 auto;" src="${basePath}${dynamic.getUrl()}"/>
                          <div>
                          <br>                     
                         </div>
                         <form method="get" enctype="multipart/form-data" action="/Time_flow/DynamicComment.do">
                           <div align="center">
                           <input type="text" id="news_id" name="news_id" value=${dynamic.getNews_id()} style="width:30px">
                           <input type="submit" value="评论" >
                           </div>
                          </form>
	       			 </div>
	   			 </c:forEach>
	     
	 </div>
</div>	


<div id="loginmodal" style="display:none;">
   
            <form id="loginform" name="loginform" method="post" enctype="multipart/form-data" action="/Time_flow/createDynamic.do">
        	<table width="300px">
        	<tr>
        		<td colspan="3" >
        			<h3>发表动态：</h3>
        		</td>	
        		<td><a  class="hidemodal" id="X"  style="margin-top=0px ,margin-right=0px;" border="1">&times;</a>  </td>
        	</tr>
        	 <tr>
          		  <td><label for="album_name">动态编号</label><td>
            	  <td align="center ,left" ><input type="text" name="news_id" id="news_id" class="txtfield" style="width:150px; height:30px; margin:5px;"  tabindex="1" ></td>
       		 </tr>
      		  <tr>
          		  <td><label for="album_name">说点什么吧</label><td>
            	  <td align="center ,left" ><input type="text" name="message" id="message" class="txtfield" style="width:150px; height:30px; margin:5px;"  tabindex="1" ></td>
       		 </tr>
       		 
       		  <tr>
       		 	<td align="right"><label for="file">图片：</label></td>
       		 	<td colspan="2" align="center,left"><div><input style="width:150px;height:30px;margin-top:4px;margin-left:10px;" type="file" name="file"></div></td>
       		 </tr>
      		 
        	  <tr>
         		<td colspan="4" align="center"> 
           			<div class="center">
			        	 <input type="submit" name="loginbtn" id="loginbtn"  class="flatbtn-blu hidemodal" value="发表" tabindex="3">
	            	</div>
	       		</td>
	   		  </tr>
	   		  
	          </table>
        	 </form>
   		 </div>
   		 
<script type="text/javascript">
$(function(){

  $('#modaltrigger').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
  
});

</script>

</body>
</html>