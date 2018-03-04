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

    <s:iterator value="plateau" status="plateauStatus">
        <tr>
            <s:if test="#plateauStatus.even == true">
                <td style="background: #CCCCCC"><s:property/></td>
            </s:if>
            <s:elseif test="#plateauStatus.first == true">
                <td><s:property/> (This is first value) </td>
            </s:elseif>
            <s:else>
                <td><s:property/></td>
            </s:else>
        </tr>
    </s:iterator>

</table>


</body>
</html>
