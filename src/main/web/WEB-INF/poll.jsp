<%@ page import="java.util.Map" %>
<%@ page import="com.model.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Answer" %><%--
<%@ page import="com.model.Answer" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 11/24/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Опрос</title>

    <style>
        div {
            margin-left: 300px;
            height: 700px;
            width: 1400px;
            background-color: #aaa7a7;
        }

        p.center {
            text-align: -webkit-center;
            color: silver;
        }

        p.large {
            font-size: 500%;
        }

        a.large {
            font-size: 60px;
        }

        a.center {
            text-align: -webkit-center;
        }

    </style>
</head>
<body>
<div>
    <c:forEach var="question" items="${questionAnswerMap.keySet()}">
        ${question.text}<br><br>
        <c:forEach var="answers" items="${questionAnswerMap.values()}">
            <c:forEach var="answer" items="${answers}">
                ${answer.text}<br>
            </c:forEach>
        </c:forEach>
        <br><br><br><br>
    </c:forEach>
</div>
</body>
</html>
