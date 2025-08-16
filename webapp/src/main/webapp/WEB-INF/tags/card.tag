<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="cardPrice" required="true" type="java.lang.Double" %>
<%@ attribute name="cardImg" required="false" %>
<%@ attribute name="cardName" required="true" %>
<%@ attribute name="cardArtist" required="true" %>
<%@ attribute name="cardDate" required="true" %>
<%@ attribute name="cardDisabled" required="false" type="java.lang.Boolean" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="card">
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
    <h3 class="card-title"><c:out value="${cardName}"/></h3>

    <div class="card-body">
        <p class="card-text">Artist: <c:out value="${cardArtist}"/></p>
        <p class="card-text">Date: <c:out value="${cardDate}"/></p>
        <p class="card-text">Price: $<c:out value="${cardPrice}"/></p>
    </div>

</div>


