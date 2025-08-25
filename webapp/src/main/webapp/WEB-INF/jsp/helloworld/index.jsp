<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/components.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
          integrity="sha512-SOMEHASH..."
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Vinyl Store - Página Principal</title>
</head>
<body>

<!-- Botones de Acción Global -->
<div class="btn-group" style="margin: 2rem 0;">
    <paw:button text="Enviar" variant="secondary" size="lg" />
    <paw:button text="Cancelar" variant="primary" size="lg" />
    <paw:button text="Aceptar" variant="secondary" size="lg" />
</div>

<!-- Tarjetas de Productos -->
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

<!-- Formulario de Login -->
<div style="display: flex; justify-content: center; margin: 3rem 0;">
    <form action="<c:url value='/processInputMail'/>" method="post" class="form-group" style="background: #f8fafc; padding: 2rem; border-radius: 1rem; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);">

        <paw:input inputId="email" inputLabel="Correo electrónico" inputName="email"
                      inputType="email" inputPlaceholder="Ingrese su correo electrónico" />

        <paw:input inputId="contraceña" inputLabel="Contraseña" inputName="contraceña"
                   inputType="password" inputPlaceholder="Ingrese su contraseña" />

        <div style="text-align: center; margin-top: 1.5rem;">
            <paw:button text="Ingresar" type="submit" variant="primary" size="lg" />
        </div>
    </form>
</div>

</body>
</html>
