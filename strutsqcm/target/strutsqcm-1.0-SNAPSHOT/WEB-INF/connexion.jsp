<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 20/02/18
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="connexion.titre"/></title>
</head>
<body>

</body>

<s:form action="connexion">
    <s:textfield name="login" key="connexion.login"/>
    <s:password name="password" key="connexion.password"/>
    <s:submit/>
</s:form>

</html>
