<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head> 
<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/55/sjckzedf/jquery-1.8.0.min.js"></script>
<title>ʱ����Ӱ�ٷ���վ</title>



<style type="text/css"> 
<!-- 
a:link{ color:#f00/*��ɫ�Զ���*/;font-family:"����"; font-size:20px;} /* δ���ʵ����� */ 
a:visited{color:#1E90FF/*��ɫ�Զ���*/} /* �ѷ��ʵ����� */ 
a:active{ color:#660099/*��ɫ�Զ���*/}/* ����������� */ 


#leftMenu { background:rgba(255,251,240, 0.7); height: 370px; width: 300px; 
 position: absolute; right: 200px; top: 200px;padding: 10px; 
 } 

 
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
 
<script type="text/javascript">
function queren()
{
var se=confirm("���ύ");
 window.location = "./login.jsp"
 if (se==true)
  {
  alert("�㰴�µ��ǡ�ȷ�ϡ�");
  }
else
  {
  alert("�㰴�µ��ǡ�ȡ����");
  }
  
}
</script> 


</head>
<body ">

<div style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="resource/LoginBg.jpg" height="100%" width="100%"/> 
</div>


<div id="leftMenu" >
<form action="/Time_flow/register.do" accept-charset="UTF-8" method="post">
<table   height=��300px��, width="300px", cellSpacing="15px"  >
	<tr><td colspan="2" ><font size="5px" color="#333333">�û�ע��</font></td></tr>
   <tr><td  colspan="2" align="center"><input type="text"  name="user_id"  style="width:200px; height:30px;" placeholder="��������ĸ������������ʺ�" ><td></tr>
   <tr ><td colspan="2" align="center"><input type="text"  name="password"        style="width:200px; height:30px;"  placeholder="���볤��Ϊ5-10���ַ�"  ></td></tr>
   <tr><td  colspan="2" align="center"><input type="text"  name="user_name"  style="width:200px; height:30px;" placeholder="�ǳƲ��ܳ���5�������ַ�" > </td></tr>
   <tr><td  colspan="2" align="center"><input type="text"  name="age"  style="width:200px; height:30px;" placeholder="����������1-100" ></td></tr>
   	<tr><td  style="padding-left:25px">�Ա�</td>
		<td><input type="radio" name="sex"  id="sex" value="boy" checked>��
		<input type="radio" name="sex" id="sex" value="girl">Ů</td></tr>
   <tr><td  colspan="2" align="center"><input type="text"  name="Email"  style="width:200px; height:30px;" placeholder="����������" ></td></tr>
   <tr><td colspan="2"  align="center"><input type="submit" name="zhanghao" value="����ע��"   style="width:200px; height:30px;" class="className" ></td></tr>
</table>
</form>
</div>


</body>
</html>