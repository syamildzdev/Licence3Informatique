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
    <title><s:text name="choixCorrection.titre"/></title>
</head>
<body>

<s:text name="choixCorrection"/>

<ul>
    <s:iterator value="%{qcms}" var="qcmCourant">
        <li>
            <s:url action="validercorrection" var="url">
                <s:param name="idQuestionnaire" value="#qcmCourant.idQuestionnaire"/>
            </s:url>

            <s:a href="%{url}"><s:property value="#qcmCourant.libelleQuestionnaire"/></s:a>
        </li>
    </s:iterator>
</ul>

</body>
</html>
