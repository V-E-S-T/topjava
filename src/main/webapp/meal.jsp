<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Meal List</title>
    <style>
        .normal {color: green}
        .exceeded {color: red}
    </style>
</head>
<body>
    <section>
        <h1>Meal list</h1>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th width="80">ID</th>
                <th width="80">Date time</th>
                <th width="120">Description</th>
                <th width="80">Calories</th>
            </tr>
            </thead>
            <c:forEach items="${mealList}" var="meal">
                <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
                <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                    <td>${meal.id}</td>
                    <td>
                        <%=TimeUtil.toString(meal.getDateTime())%>
                    </td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>
