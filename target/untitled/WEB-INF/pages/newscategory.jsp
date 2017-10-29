<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
    <title>Title</title>
</head>
<body>
<a href="/news"> Back to news page </a>>
<br/>
<br/>
<h1> News</h1>

<c:if test="${!empty listNews}">
    <table class="tg">
        <tr></tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Category</th>
        <th width="120">Data</th>
        <th width="60">Date</th>

        <c:forEach items="${listNews}" var="news">
            <tr>
                <td>${news.ID}</td>
                <td><a href="/newsdate/${news.ID}" target="_blank">${news.title}</a></td>
                <td>${news.category}</td>
                <td>${news.content}</td>
                <td>${news.date}</td>

            </tr>
        </c:forEach>

    </table>
</c:if>


</body>
</html>
