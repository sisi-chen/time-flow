<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
 
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/55/sjckzedf/jquery-1.8.0.min.js"></script>
<title>时光流影官方网站</title>



<style type="text/css"> 
<!-- 

/*这是控制超链接字体颜色*/
a:link{ color:#f00/*颜色自定义*/;font-family:"楷体"; font-size:20px;} /* 未访问的链接 */ 
a:visited{color:#1E90FF/*颜色自定义*/} /* 已访问的链接 */ 
a:active{ color:#660099/*颜色自定义*/}/* 点击激活链接 */ 

/*这是控制登录框的样式*/
#leftMenu { background:rgba(255,251,240, 0.7); height: 300px; width: 300px; 
 position: absolute; right: 200px; top: 200px;padding: 10px; 
 } 

 /*这是控制按钮样式*/
.className{
  line-height:30px;
  height:30px;
  width:70px;
  color:#fafcfd;
  background-color:#05dbf0;
  font-size:16px;
  font-weight:normal;
  font-family:Arial;
  border:2px solid #dcdcdc;
  -webkit-border-top-left-radius:11px;
  -moz-border-radius-topleft:11px;
  border-top-left-radius:11px;
  -webkit-border-top-right-radius:11px;
  -moz-border-radius-topright:11px;
  border-top-right-radius:11px;
  -webkit-border-bottom-left-radius:11px;
  -moz-border-radius-bottomleft:11px;
  border-bottom-left-radius:11px;
  -webkit-border-bottom-right-radius:11px;
  -moz-border-radius-bottomright:11px;
  border-bottom-right-radius:11px;
  -moz-box-shadow: inset 0px 0px 9px -2px #e3dcdc;
  -webkit-box-shadow: inset 0px 0px 9px -2px #e3dcdc;
  box-shadow: inset 0px 0px 9px -2px #e3dcdc;
  text-align:center;
  display:inline-block;
  text-decoration:none;
}
.className:hover{
  background-color:#10ecf6;
} 

 --> 
</style> 






</head>

<body>
<div style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="resource/LoginBg.jpg" height="100%" width="100%"/> 
</div>

<div style="position: absolute; right: 200px; top: 100px;padding: 10px" ><img src="resource/LOG.jpg" height="50px" width="300px"/> </div>

<div id="leftMenu" >
<form action="./login_do" method="post" accept-charset="UTF-8">
<table   height=”300px”, width="300px", cellSpacing="15px" >
	<tr><td colspan="2" ><font size="5px" color="#333333">登录</font></td></tr>
    <tr><td  colspan="2" align="center"><input type="text"  name="user_id"  style="width:200px; height:30px;" placeholder="帐号" id="user_id"><td></tr>
    <tr><td colspan="2" align="center"><input type="text"  name="password"        style="width:200px; height:30px;" id="password" placeholder="密码"  ></td></tr>
    <tr><td  colspan="2" align="right"><p><font color="#1E90FF"><a href="f_password.jsp" >忘记密码</a></font></p></td></tr>
    <tr><td colspan="2"  align="center"><input type="submit" name="zhanghao" value="登录" style="width:200px; height:30px;" class="className" ></td></tr>
    <tr><td colspan="2"  align="right"><p>没有帐号?<u><a href="register.jsp"  onClick="queren()" />立即注册>></a></u></p></td></tr>
</table>
</form>
</div>


</body>
</html>
