<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 28/02/18
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="partie.titre"/></title>
</head>
<body>
<table>

    <s:iterator value="%{plateau}" var="x">
        <s:iterator value="%{plateau}" var="y">
            <li><s:property /></li>
        </s:iterator>
    </s:iterator>

</table>


</body>
</html>
