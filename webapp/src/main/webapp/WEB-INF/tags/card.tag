<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<%@ attribute name="cardPrice" required="true" type="java.lang.Double" %>
<%@ attribute name="cardImg" required="false" %>
<%@ attribute name="cardName" required="true" %>
<%@ attribute name="cardArtist" required="true" %>
<%@ attribute name="cardDate" required="true" %>
<%@ attribute name="cardDisabled" required="false" type="java.lang.Boolean" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="card" style="max-width: 200px"> <%-- Ajusta el ancho máximo de la tarjeta, arreglar --%>
    <div class="card-header">
        <c:choose>
            <c:when test="${not empty cardImg}">
                <c:url var="imgUrl" value="${cardImg}" />
            </c:when>
            <c:otherwise>
                <c:url var="imgUrl" value="/images/defaultVinyl.jpg" />
            </c:otherwise>
        </c:choose>
        <img src="${imgUrl}" alt="Vinyl image" class="card-img-top"/>
    </div>
    <h2 class="card-title"><c:out value="${cardName}"/></h2>

    <div class="card-body">
        <p class="card-text">Artista: <c:out value="${cardArtist}"/></p>
        <p class="card-text">Fecha: <c:out value="${cardDate}"/></p>
        <p class="card-text">Precio: $<c:out value="${cardPrice}"/></p>
    </div>
    <paw:button text="Comprar" size="sm" type="submit"
                cssClass="btn-primary"/>
</div>


