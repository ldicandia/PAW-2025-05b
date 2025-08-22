<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/components.css" rel="stylesheet" />
</head>
<body>

<div style="display: flex; justify-content: center;">
    <paw:button text="Enviar" size="lg" disabled="true" />
    <paw:button text="Cancelar" cssClass="btn-custom" />
    <paw:button text="Aceptar" />
</div>

<div class="card-container">
    <paw:card cardPrice="100"
              cardName="The Shaver Mystery [Amazing stories]" cardArtist="Robert Dietz"
              cardDate="2020-06-06"
              cardImg="/images/defaultVinyl.jpg"/>

    <paw:card cardPrice="55600"
              cardName="Stoffel [Kalahari Oyster Cult]" cardArtist="Robert Dietz"
              cardDate="2020-06-06"
              cardImg="/images/defaultVinyl.jpg"/>
</div>

<div style="display: flex; justify-content: center;">
    <form action="${pageContext.request.contextPath}/processInputMail" method="post" class="form-group">

        <paw:input inputId="email" inputLabel="Correo electronico" inputName="email"
                      inputType="email" inputPlaceholder="Ingrese su correo electronico" />

        <paw:input inputId="contraceña" inputLabel="Contraceña" inputName="contraceña"
                   inputType="contraceña" inputPlaceholder="Ingrese su contraceña" />

        <paw:button text="Ingresar" type="submit" cssClass="btn-primary" />
    </form>
</div>


</body>
</html>
