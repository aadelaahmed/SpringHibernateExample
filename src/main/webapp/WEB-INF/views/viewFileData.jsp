<%--
  Created by IntelliJ IDEA.
  User: aa800
  Date: 4/27/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show File Data</title>
</head>
<body>
<h2>Submitted File</h2>
<table>
  <tr>
    <td>OriginalFileName:</td>
    <td>${file.originalFilename}</td>
  </tr>
  <tr>
    <td>Type:</td>
    <td>${file.contentType}</td>
  </tr>
</table>
</body>
</html>
