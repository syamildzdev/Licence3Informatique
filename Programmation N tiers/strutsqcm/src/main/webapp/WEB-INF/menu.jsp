<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 20/02/18
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="menu.titre"></s:text></title>
</head>
<body>

<s:text name="menu.texte1"/>
<ul>
    <li><s:a action="gotochoixqcm"><s:text name="menu.choixqcm"></s:text></s:a></li>
    <li><s:a action="gotocorrection"><s:text name="menu.correction"></s:text></s:a></li>
    <li><s:a action="deconnexion"><s:text name="menu.deconnexion"/></s:a></li>
</ul>
</body>
</html>
