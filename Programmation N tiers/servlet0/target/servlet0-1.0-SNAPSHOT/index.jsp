<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Le titre</title>
</head>
<body>
<p>EL activée ? ${3 + 4}</p>
<a href="/run">Lancer la servlet</a>
<c:redirect url="/run? action=gotoLogin"></c:redirect>
</body>
</html>