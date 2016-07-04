<%@ page contentType="text/html;charset=gb2312"%> 
<% response.setHeader("Expires","0"); %> 
<%@ page import = "java.sql.*"   import="com.zhouqiang.entity.*"%>
<%@page import="javax.servlet.http.HttpSession" %>
<html>
<script language="javascript"> 
var times=4; 
clock(); 
function clock() 
{ 
   window.setTimeout('clock()',1000); 
   times=times-1; 
   time.innerHTML =times; 
} 
</script>
<head>

<meta http-equiv= "Refresh" content= "3;   url=index.html "><!-- 在这里设置跳转页面 -->
</head>
<br><br><br><br><br><br><br><br>
<center>
<%! String result = null; %>
<%
    result = (String)session.getAttribute("mydata");
	out.println(result);
%>
<table> 
<tr> 
<td> 　　该页面将在 </td> 
<td> <div class="STYLE1" id= "time"> 3 </div> </td> 
<td> 秒后自动跳转 </td> 
</tr> 
</table>
<a href="javascript:history.go(-1);">返回一页</a>
</center>
</body>
</html>
