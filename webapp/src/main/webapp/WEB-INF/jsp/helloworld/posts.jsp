<%--
  Created by IntelliJ IDEA.
  User: luupercich
  Date: 25/08/2025
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="es">
<head class = "page">
  <meta charset="UTF-8"/>
  <title>Vinilos en venta</title>

  <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/components.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/cards.css'/>">

  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<main class="page">
  <paw:header />

  <h1 class="page-title">Vinilos</h1>

  <section class="cards-grid">
    <c:choose>
      <c:when test="${not empty vinylList}">
        <c:forEach var="v" items="${vinylList}">
          <fmt:formatNumber value="${v.price}" type="number" maxFractionDigits="0" var="priceFmt"/>
          <fmt:formatDate value="${v.releaseDate}" pattern="yyyy-MM-dd" var="dateFmt"/>
          <paw:card
                  cardPrice="${priceFmt}"
                  cardImg="${v.imageUrl}"
                  cardName="${v.title}"
                  cardArtist="${v.artist}"
                  cardDate="${dateFmt}"
          />
        </c:forEach>
      </c:when>
      <c:otherwise>
        <div class="empty-state">
          Aún no hay vinilos publicados.
        </div>
      </c:otherwise>
    </c:choose>
  </section>
</main>

</body>
</html>
