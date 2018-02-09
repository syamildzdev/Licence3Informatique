<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 08/02/18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<H1>COUCOU patate!</H1>
<c:forEach var="qcm" items="${listeQCM}">
    <a href="/run?action=lancerQcm&idQuestionnaire=${qcm.idQuestionnaire}">
                ${qcm.libelleQuestionnaire} ${qcm.libelleQuestionnaire}
    </a>
</c:forEach>
<form method="post" action="/run?action=lancerQCM">
    <select>
    <c:forEach var="qcm" items="${listeQCM}">
        <option>
            value="${qcm.idQuestionnaire}">${qcm.libelleQuestionnaire}
        </option>
    </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>
