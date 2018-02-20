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
    <title><s:text name="choixqcm.titre"/></title>
</head>
<body>

<s:form action="questioncourate">
    <s:select list="%{qcms}" listKey="idQuestionnaire" listValue="libelleQuestionnaire" key="choixqcm.select"/>
    <s:submit/>
</s:form>

</body>
</html>
