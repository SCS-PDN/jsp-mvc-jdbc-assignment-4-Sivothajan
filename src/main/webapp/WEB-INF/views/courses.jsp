<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    <title>Courses</title>
</head>
<body>
<h2>Available Courses</h2>

<a href="${pageContext.request.contextPath}/my-courses">My Courses</a> |
<a href="${pageContext.request.contextPath}/logout">Logout</a>

<table>
    <tr>
        <th>Name</th>
        <th>Instructor</th>
        <th>Credits</th>
        <th>Action</th>
    </tr>

    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>${course.credits}</td>
            <td>
                <form action="register/${course.courseId}" method="post">
                    <button type="submit">Register</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>