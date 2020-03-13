<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Faculties</title>
  <style>
  table {
    width: 300px;
  }
  </style>
</head>
<body>
    <h1>${title}</h1>
    <table styles=>
        <tr>
            <th>ID</th>
            <th>Title</th>
        </tr>
        <c:forEach items="${faculties}" var="faculty">
            <tr>
                <td>${faculty.id}</td>
                <td>${faculty.title}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>