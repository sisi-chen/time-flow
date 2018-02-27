<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html lang="en-US">
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

<script type="text/javascript">
	function over()
	{
		document.getElementById("p").style.display="block";
		clearTimeout(aa);
	}
	
	function out()
	{
		aa = setTimeout(hide,100);
	}
	
	function hide()
	{
		document.getElementById("p").style.display = "none";
	}
	
</script>


<body>
		
<img src="resource/6.jpg" style="width:100%;height:780px;;position:absolute;z-index:-1;">

<div id="d1" class="header">
    	<div class="header-left">
			<div class="logo">
				<img src="images/LOG.jpg" alt="">
			</div>
			<div class="top-nav">
				<ul>
				    <li ><a href="index.jsp" style="text-decoration: NONE">主页</a></li>
					<li class="black" ><a href="#loginmodal"  id="modaltrigger">创建相册</a></li>
					<li><a href="#editor"  id="myeditor" >修改相册</a></li>	
				</ul>
			</div>
			
		</div>
		
  		<!--负责相册显示  -->
		
		<div class="content">
		   <c:forEach  var="album" items="${list}">
			<div class="content-grid" style="width:200px;height:200px;margin:10px;">
				<a href="/Time_flow/findPage.do?album_name=${album.getAlbumName()}" class="b-link-stripe b-animate-go  thickbox">
					<img  src="${basePath}${album.getUrl()}"  style="width:180px;height:150px;"/>
						<div class="b-wrapper">
							<h2 class="b-animate b-from-left    b-delay03 ">
								<span>进入相册</span>
								<p> Enter album</p>
								<i> </i>
							</h2>
						</div>
				       </a>
				       
							   		    
	          ${album.getAlbumName()}  <a href="/Time_flow/albumDelete.do?album_name=${album.getAlbumName()}" name="delete">删除  </a> 
					            
				
					</div>
			</c:forEach>
	
			
     		
	   </div>
	   
	  <!--<div style="width:700px;height:50px;background:#808080;margin:0px auto;line-height:50px;text-align:center;">
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
    -->
</div>

<!-- 相册创建的div -->
     <div id="loginmodal" style="display:none;">
        <form id="loginform" name="loginform" method="post" enctype="multipart/form-data" action="/Time_flow/createAlbum.do">
        	<table width="100%" >	
        	 <tr>
        	 	 <td colspan="3" align="center" ><h3 margin-top="10px">相册创建</h3></td>	
        		 <td align="right"><a  class="hidemodal" id="X"  style="margin-top=0px ,margin-right=0px;" border="1">&times;</a> </td>
        	</tr>
        	
      		 <tr>
          		  <td align="right" colspan="2"><label for="album_name">相册名:</label></td>
            	  <td align="center ,left" colspan="2"><input type="text" name="album_name" id="album_name" class="txtfield" style="width:150px; height:30px; margin:5px;"  tabindex="1" ></td>  	  
       		 </tr>
       		 
       		 <tr>
       		 	<td align="right"colspan="2"><label for="file">封面上传：</label></td>
       		 	<td colspan="2" align="center,left" ><div><input style="width:150px;height:30px;margin-top:4px;margin-left:10px;" type="file" name="file"></div></td>
       		 </tr>
      	
      		 <tr>
      			<td align="right" colspan="2"><label for="type">类型:</label><td>
      			<td height="30px" colspan="1" >
				  <select name="type"  style="margin-left:4px;">
					<optgroup label="风格">
						<option value="people" name="people">人物 </option>
						<option value="scenery"name="scenery">风景 </option>
						<option value="lift"   name="lift">生活 </option>
						<option value="animal" name="animal">动物</option>
						<option value="cartoon"name="cartoon">卡通 </option>
					</optgroup>
			 	 </select>
				</td>
			  </tr>
		 
        	  <tr>
         		 <td colspan="4" align="center"> 
           			<div class="center">
			        	 <input type="submit" name="loginbtn" id="loginbtn"  class="flatbtn-blu hidemodal" value="确定" tabindex="3">
	            	</div>
	       		 </td>
	   		  </tr>
	         </table>
         </form>
   	</div>

	 <!-- 相册删除的div -->
		<div id="editor" style="display:none;index-z:10;">
            <form id="loginform" name="loginform" method="post" enctype="multipart/form-data" action="/Time_flow/updateAlbum.do">
        	<table width="100%">	
        	<tr>
        		<td colspan="3"  >
        			<h3>相册修改</h3>
        		</td>	
        		<td><a  class="hidemodal" id="X"  style="margin-top=0px ,margin-right=0px;" border="1">&times;</a>  </td>
        	</tr>
        		
        		
        	  <tr>
          		  <td align="right"><label for="oldname">旧的相册名:</label><td>
            	  <td align="center ,left" ><input type="text" name="oldname" id="oldname" class="txtfield" style="width:150px; height:30px; margin:5px;"  tabindex="1" ></td>  	  
       		 </tr>
      		  <tr>
          		  <td align="right"><label for="album_name">新的相册名:</label><td>
            	  <td align="center ,left" ><input type="text" name="album_name" id="album_name" class="txtfield" style="width:150px; height:30px; margin:5px;"  tabindex="1" ></td>  	  
       		 </tr>
       		 
       		 <tr>
       		 	<td align="right"><label for="file">修改封面：</label></td>
       		 	<td colspan="2" align="center,left"><div><input style="width:150px;height:30px;margin-top:4px;margin-left:10px;" type="file" name="file"></div></td>
       		 </tr>
      	
      		 <tr>
      			<td align="right"><label for="type">类型:</label><td>
      			<td height="30px">
				  <select name="type"  style="margin-left:4px;">
					<optgroup label="风格">
						<option value="people" name="people">人物 </option>
						<option value="scenery"name="scenery">风景 </option>
						<option value="lift"   name="lift">生活 </option>
						<option value="animal" name="animal">动物</option>
						<option value="cartoon"name="cartoon">卡通 </option>
					</optgroup>
			 	 </select>
				</td>
			  </tr>
		 
        	  <tr>
         		<td colspan="3" align="center"> 
           			<div class="center">
			        	 <input type="submit" name="loginbtn" id="loginbtn"  class="flatbtn-blu hidemodal" value="确定" tabindex="3">
	            	</div>
	       		</td>
	   		  </tr>
	          </table>
        	 </form>
   		 </div>
	
<script type="text/javascript">
$(function(){
  
  $('#modaltrigger').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
  
  $('#myeditor').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
});
</script>


</body>
</html>