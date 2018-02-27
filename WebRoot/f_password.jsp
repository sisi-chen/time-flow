<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
  <head>
  <meta charset="utf-8">
  <style>
  #div1{width:100%;height:100%;;z-index:-1;}
 #div2 { background:rgba(255,251,240, 0.7); height: 200px; width: 400px; 
 position: absolute; right: 400px; top: 200px;padding: 10px; 
 } 
  </style>
 
  </head>
  
  <body>
    <div id="div1">
     <img src="resource/f_pass.jpg" height="100%" width="100%" />
     <div id="div2">
     <form method="post" action="/Time_flow/forget.do">
         <table border="0" width="100%" height="50%" align="center"> 
         <tr>
         <td><font size="3px" color="#333333">请输入你的账号:</font></td>
         <td><input type="text" name="user_id"  style="width:200px; height:30px;" ></td>
         </tr>
         <tr>
         <td ><font size="3px" color="#333333">请输入你的Eail:</font></td>
         <td><input type="text" name="email"  style="width:200px; height:30px;" ></td>
         </tr>
          <tr><td  colspan="2" align="center"><input type="submit"  name="验证"  style="width:100px; height:30px;" ></td></tr>
         </table>
         </form>
     </div>
    </div>>
  </body>
</html>
