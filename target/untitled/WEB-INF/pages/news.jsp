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
<a href="/"> Back to main page </a>>
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
    <th width="60">Edit</th>
    <th width="60">Delete</th>
    <c:forEach items="${listNews}" var="news">
<tr>
    <td>${news.ID}</td>
    <td><a href="/newsdate/${news.ID}" target="_blank">${news.title}</a></td>
    <td>${news.category}</td>
    <td>${news.content}</td>
    <td>${news.date}</td>
        <td><a href="<c:url value='/edit/${news.ID}'/>"> Edit </a></td>
        <td><a href="<c:url value='/remove/${news.ID}'/>"> Delete </a></td>
</tr>
    </c:forEach>

</table>
</c:if>
<h1>Add News</h1>

<c:url var="addAction" value="/news/add"/>

<form:form action="${addAction}" commandName="news">
    <table>
        <c:if test="${!empty news.content}">
            <tr>
                <td>
                    <form:label path="ID">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="ID" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="ID"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="category">
                    <spring:message text="category"/>
                </form:label>
            </td>
            <td>
                <form:input path="category"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="content">
                    <spring:message text="content"/>
                </form:label>
            </td>
            <td>
                <form:input path="content"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty news.content}">
                    <input type="submit"
                           value="<spring:message text="Edit News"/>"/>
                </c:if>
                <c:if test="${empty news.content}">
                    <input type="submit"
                           value="<spring:message text="Add News"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<form action = "newscategory" method = "GET" >
    <table border = "0">

        <tr>
            <h2>Search</h2>
            <%--<td><b>Category</b></td>--%>
            <%--<td><input type = "text" name = "category"--%>
                       <%--value = "" size = "70"/></td>--%>
                <b>Category</b>
                <form:select path="news" name="category">
                    <form:option value=""> --ALL--</form:option>
                    <form:options  items="${listCategory}" />
                </form:select>

        </tr>
        <tr>
            <td><b>Title</b></td>
            <td><input type = "text" name = "title"
                       value = "" size = "70"/></td>
        </tr>
        <tr>
            <td><b>Content</b></td>
            <td><input type = "text" name = "content"
                       value = "" size = "70"/></td>
        </tr>



        <tr>
            <td colspan = "2"><input type = "submit" value = "Search"/></td>
        </tr>
    </table>
</form>

</body>
</html>
