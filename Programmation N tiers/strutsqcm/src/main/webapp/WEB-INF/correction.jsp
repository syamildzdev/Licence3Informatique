<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 20/02/18
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="correction.titre"/></title>
</head>
<body>

<s:text name="correction.text"/>

<ul>
    <li><s:a action="gotomenu"><s:text name="correction.gotomenu"></s:text></s:a></li>

    <s:iterator value="%{correction}" var="correction">
        <li>
            <s:text name=""/><s:property value="#correction.question"/>
            <s:property value="#correction.reponseDonnee"/>
            <s:property value="#correction.reponseAttendue"/>

        </li>
    </s:iterator>
</ul>

<s:form>
    <!----->
</s:form>

</body>
</html>
