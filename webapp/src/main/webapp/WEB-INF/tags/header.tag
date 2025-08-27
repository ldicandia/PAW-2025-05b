<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="showSearch" required="false" %>
<%@ attribute name="showUser" required="false" %>
<%@ attribute name="brandName" required="false" %>
<%@ attribute name="searchPlaceholder" required="false" %>
<%@ attribute name="exploreButtonText" required="false" %>
<%@ attribute name="sellButtonText" required="false" %>
<%@ attribute name="cssClass" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<c:set var="showSearchBar" value="${not empty showSearch ? showSearch : true}" />
<c:set var="showUserSection" value="${not empty showUser ? showUser : true}" />
<c:set var="brandNameText" value="${not empty brandName ? brandName : 'VinylVault'}" />
<c:set var="searchPlaceholderText" value="${not empty searchPlaceholder ? searchPlaceholder : 'Buscar discos, artistas o géneros...'}" />
<c:set var="exploreButtonTextValue" value="${not empty exploreButtonText ? exploreButtonText : 'Explorar'}" />
<c:set var="sellButtonTextValue" value="${not empty sellButtonText ? sellButtonText : 'Vender Disco'}" />
<c:set var="additionalCssClass" value="${not empty cssClass ? cssClass : ''}" />

<header class="header${additionalCssClass}">
    <div class="header-container">
        <div class="header-content">
            
            <!-- Logo y Brand -->
            <div class="header-logo">
                <div class="logo-icon">
                    <div class="logo-inner"></div>
                </div>
                <span class="brand-name"><c:out value="${brandNameText}" /></span>
            </div>

            <!-- Barra de Búsqueda -->
            <c:if test="${showSearchBar}">
                <div class="header-search">
                    <div class="search-container">
                        <div class="search-icon">
                            <svg class="search-svg" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
                            </svg>
                        </div>
                        <input 
                            type="text" 
                            placeholder="<c:out value='${searchPlaceholderText}' />" 
                            class="search-input"
                        />
                    </div>
                </div>
            </c:if>

            <!-- Navegación -->
            <div class="header-navigation">
                <button class="nav-button browse-button"><c:out value="${exploreButtonTextValue}" /></button>
                <paw:button text="${sellButtonTextValue}" variant="primary" size="md" cssClass="list-record-btn" />
                
                <!-- Corazón (Favoritos) -->
                <button class="nav-icon-button">
                    <i class="fa-regular fa-heart"></i>
                </button>
                
                <!-- Carrito de Compras -->
                <button class="nav-icon-button">
                    <i class="fa fa-shopping-cart"></i>
                </button>
                
                <!-- Usuario (Perfil) -->
                <button class="nav-icon-button">
                    <svg class="nav-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path>
                    </svg>
                </button>
            </div>

            <!-- Botón de menú móvil -->
            <div class="header-mobile-menu">
                <button class="mobile-menu-button">
                    <svg class="mobile-menu-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
                    </svg>
                </button>
            </div>
        </div>
    </div>
</header>
