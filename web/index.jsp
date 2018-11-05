<%--
  Created by IntelliJ IDEA.
  User: daidai
  Date: 2018/10/25
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/select/selectYe.action" method="post">
    请输入学工号<input type="text" name="xgh" /><br>
    <input type="submit"/>
  </form>


  <form action="${pageContext.request.contextPath}/select/selectRecord.action" method="post">
    请输入学工号<input type="text" name="xgh" /><br>
    <input type="submit"/>
  </form>


  <form action="${pageContext.request.contextPath}/select/selectRecord.action" method="post">
    请输入学工号<input type="text" name="xgh" /><br>
    输入起始页<input type="text" name="currentPage" /><br>
    <input type="submit"/>
  </form>

  <form action="${pageContext.request.contextPath}/select/checklogin.action" method="post">
      请输入学工号<input type="text" name="xgh" /><br>
      输入起始页<input type="text" name="password" /><br>
      <input type="submit"/>
  </form>
  </body>
</html>
