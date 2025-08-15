<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet"/>
</head>
<body>
<h2>Hello <c:out value="${user.email}" escapeXml="true"/> !</h2>
<h2>Hello <c:out value="${name}" escapeXml="true"/> !</h2>
<h2>Your Id is:  <c:out value="${user.id}" escapeXml="true"/> !</h2>
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

<paw:button text="Enviar" size="lg" disabled="true" />

<paw:button text="Cancelar" cssClass="btn-custom" />

<paw:button text="Aceptar" />

</body>
</html>
