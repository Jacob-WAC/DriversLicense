<!-- prettier-ignore -->
<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<!-- prettier-ignore -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prettier-ignore -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- prettier-ignore -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div>
            <form:form
                action="/licenses"
                method="post"
                modelAttribute="license"
            >
                <div>
                    <form:label path="person">rating</form:label>
                    <form:select path="person">
                        <c:forEach items="${persons}" var="p">
                            <form:option value="${p.id} "
                                >${p.firstName} ${p.lastName}</form:option
                            >
                        </c:forEach>
                    </form:select>
                </div>
                <div>
                    <form:label path="state">state</form:label>
                    <form:errors path="state" />
                    <form:input path="state" />
                </div>
                <div>
                    <form:label path="expirationDate"
                        >Expiration Date</form:label
                    >
                    <form:errors path="expirationDate" />
                    <form:input type="date" path="expirationDate" />
                </div>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </body>
</html>
