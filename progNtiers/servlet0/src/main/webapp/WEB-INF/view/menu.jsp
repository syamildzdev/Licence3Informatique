<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
  Created by IntelliJ IDEA.
  User: o2175179
  Date: 08/02/18
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Bonjour <c:out value="${pseudo}" /></h1>

    <a href="/run?action=choixQCM">Participer à un questionnaire</a>
    <br>
    <a href="/run?action=historique">Historique des questionnaires</a>

</body>
</html>
