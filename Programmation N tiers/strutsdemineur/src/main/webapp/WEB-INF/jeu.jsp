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

    <s:iterator value="%{plateau}" var="myPlateau" status="x">
        <tr>
        <s:iterator var="maCase" value="#myPlateau" status="y">
            <td>
                <s:if test="#maCase.cachee">
                    <s:url action="jouer" var="url"></s:url>
                    <s:a href="%{url}">?</s:a>
                </s:if>
                <s:else>
                    <s:property value="#maCase.valeur"/>
                </s:else>
 <%--            <s:property value="#x.index"/>,
                <s:property value="#y.index"/>

                pour les images :
                <img src="img/box${maCase.valeur}">
--%>

            </td>
        </s:iterator>
        </tr>
    </s:iterator>
</table>


</body>
</html>
