<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/components.css"/>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet"/>
</head>
<body>

<div style="display: flex; justify-content: center;">
    <paw:button text="Enviar" size="lg" disabled="true" />
    <paw:button text="Cancelar" cssClass="btn-custom" />
    <paw:button text="Aceptar" />
</div>

<div class="card-container">
    <paw:card cardPrice="100"
              cardName="cardName" cardArtist="cardArtist"
              cardDate="2020-06-06"
              cardImg="/images/defaultVinyl.jpg"/>

    <paw:card cardPrice="100"
              cardName="cardName" cardArtist="cardArtist"
              cardDate="2020-06-06"
              cardImg="/images/defaultVinyl.jpg"/>
</div>

<div style="display: flex; justify-content: center;">
    <form action="${pageContext.request.contextPath}/processInputMail" method="post" class="form-group">
        <paw:input
                inputId="email"
                inputLabel="Email"
                inputName="email"
                inputType="email"
                inputValue="${email}"
                inputError="${emailError}"
                />
        <paw:input
            inputId="password"
            inputLabel="Password"
            inputName="password"
            inputType="password"
            inputValue="${password}"
            inputError="${passwordError}"
            />
        <paw:button text="Ingresar" type="submit" cssClass="btn-primary" />
    </form>
</div>


</body>
</html>
