<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
<h2><spring:message code="register.title"/></h2>
<c:url var="registerUrl" value="/create"/>
<form action="${registerUrl}" method="post">
    <div>
        <label>Email:
            <input type="text" name="email"/>
        </label>
    </div>
    <div>
        <label>Password:
            <input type="password" name="password"/>
        </label>
    </div>
    <div>
        <input type="submit" value="Let's Go!"/>
    </div>
</form>
</body>
</html>
