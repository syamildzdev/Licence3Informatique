<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 28/02/18
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="connexion.titre"/></title>
</head>
<body>

<s:form name="connexion">
    <s:textfield name="pseudo" key="connexion.pseudo"/>
    <s:submit/>
</s:form>

</body>
</html>
