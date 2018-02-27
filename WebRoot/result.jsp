<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title></title>
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

<div  class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">主页</a></li>
					<li class="black" ><a href="/Time_flow/findAlbumPage.do" >返回</a></li>		
				</ul>
			</div>
			
			
		<div style="width:100%;height:150px;background:gray;">
		 <form method="post" enctype="multipart/form-data" action="/Time_flow/upload.do?album_name=${album_name}">
        	<table style="width:100%">
        	 
      		  <tr>
          		  <td width="40%"><label for="album_name">相片名：</label><td>
            	  <td align="center ,left" ><input type="text" name="name"   style="width:50%; height:30px; margin:5px;"  tabindex="1" ></td>
       		 </tr>
       		 
       		  <tr>
       		 	<td width="40%"><label for="file">图片：</label></td>
       		 	<td colspan="2" align="center,left"><div><input style="width:50%;height:30px;margin-top:4px;" type="file" name="file"></div></td>
       		 </tr>
      		 
        	  <tr>
         		<td colspan="4" align="center"> 
           			<div class="center">
			        	 <input type="submit" name="loginbtn" id="loginbtn"  class="flatbtn-blu hidemodal" value="上传" tabindex="3">
	            	</div>
	       		</td>
	   		  </tr>
	   		  
	          </table>
        	 </form>
			</div>
			
			
		</div>

  

     <div style="width:75%;height:650px;float:left;border:1px solid black;padding:5px;">
	    <c:forEach items="${list}" var="image">
	       <div style="width:200px;height:150px;float: left;margin:20px;">
	          <table border="0">
	          	<thead>
	          		<tr>
	          			<td colspan="2">
	          				<img style="width:190px;height:160px;" src="${basePath}${image.url}"/>
	          			</td>
	          		</tr>
	          
	          		<tr>
	          			<td style="height:35px;">
	          				  ${image.name}
	          			</td>
	          			<td>
	          			   <select name="" onchange="location.href=this.value">
							  <optgroup label="选项">
							     <option value="editor" name="editor">
							     	  <a href="#" >
							     	    编辑
							          </a>
							        </option>
					                <option value="/Time_flow/photoDelete.do?image_name=${image.name}&&album_name=${album_name}" name="delete">
					                                              删除 					            	 	
					            	</option>
							  </optgroup>
			 			   </select>
	          			</td>
	          		</tr>
	          </table>
	       </div>
	    </c:forEach>
     </div>
     
    <div style="width:60%;height:50px;margin:0px auto;line-height:50px;text-align:center;">
         <c:choose>
            <c:when test="${courentpage>1}">
                <a href="findPage.do?page=${courentpage-1}">上一页</a>&nbsp;
            </c:when>
            <c:otherwise>
               <a>上一页</a>&nbsp;
            </c:otherwise>
         </c:choose>
		  	 第${courentpage}/${totalpage}页&nbsp;
		 <c:choose>
            <c:when test="${courentpage<totalpage}">
                <a href="findPage.do?page=${courentpage+1}">下一页</a>&nbsp;
            </c:when>
            <c:otherwise>
               <a>下一页</a>&nbsp;
            </c:otherwise>
         </c:choose>
     </div>
   
    </div>
	
	
	
</body>
</html>