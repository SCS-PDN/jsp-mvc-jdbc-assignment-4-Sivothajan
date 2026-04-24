<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    <title>My Courses</title>
</head>
<body>
<h2>My Courses</h2>

<table>
    <tr>
        <th>Name</th>
        <th>Instructor</th>
        <th>Credits</th>
    </tr>

    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>${course.credits}</td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="${pageContext.request.contextPath}/courses">All Courses</a>
</body>
</html>