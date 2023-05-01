<%--
  Created by IntelliJ IDEA.
  User: aa800
  Date: 4/27/2023
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Uploading file</title>
</head>
<body>
<form method="POST" action="uploadcv" enctype="multipart/form-data">
  <table>
    <tr>
      <td><label path="file">Select a file to upload</label></td>
      <td><input type="file" name="file" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>
