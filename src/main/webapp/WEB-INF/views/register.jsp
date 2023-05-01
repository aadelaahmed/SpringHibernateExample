<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST"
           action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="firstName">Name</form:label></td>
<%--            <td><spring:message code="name"/> </td>--%>
            <td><form:input path="firstName"/></td>
            <form:errors path="firstName" delimiter=","/>
        </tr>
        <tr>
            <td><form:label path="id">Id</form:label></td>
<%--            <td><spring:message code="id"/> </td>--%>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Contact Number</form:label></td>
<%--            <td><spring:message code="phone"/> </td>--%>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>