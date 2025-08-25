<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="showGenre" required="false" type="java.lang.Boolean" %>
<%@ attribute name="showCondition" required="false" type="java.lang.Boolean" %>
<%@ attribute name="showPriceRange" required="false" type="java.lang.Boolean" %>
<%@ attribute name="showSorting" required="false" type="java.lang.Boolean" %>
<%@ attribute name="showCurrency" required="false" type="java.lang.Boolean" %>
<%@ attribute name="searchPlaceholder" required="false" %>
<%@ attribute name="cssClass" required="false" %>
<%@ attribute name="instanceId" required="false" %>

<c:set var="showGenreFilter" value="${not empty showGenre ? showGenre : true}" />
<c:set var="showConditionFilter" value="${not empty showCondition ? showCondition : true}" />
<c:set var="showPriceRangeFilter" value="${not empty showPriceRange ? showPriceRange : true}" />
<c:set var="showSortingFilter" value="${not empty showSorting ? showSorting : true}" />
<c:set var="showCurrencySelector" value="${not empty showCurrency ? showCurrency : true}" />
<c:set var="searchPlaceholderText" value="${not empty searchPlaceholder ? searchPlaceholder : 'Buscar por discos, artistas o álbumes...'}" />
<c:set var="additionalCssClass" value="${not empty cssClass ? cssClass : ''}" />
<c:set var="uniqueId" value="${not empty instanceId ? instanceId : 'filters'}" />

<div class="search-filters-container${additionalCssClass}">
    
    <!-- Barra de búsqueda principal -->
    <div class="search-main-section">
        <div class="search-input-wrapper">
            <i class="fa fa-search search-icon"></i>
            <input type="text" 
                   class="search-input" 
                   placeholder="${searchPlaceholderText}"
                   id="mainSearch_${uniqueId}">
        </div>
        
        <button class="filters-toggle-btn" id="filtersToggle_${uniqueId}">
            <i class="fa fa-sliders-h"></i>
            Filtros
        </button>
        
        <c:if test="${showCurrencySelector}">
            <div class="currency-selector">
                <select class="currency-select" id="currencySelect_${uniqueId}">
                    <option value="EUR">EUR (€)</option>
                    <option value="USD">USD ($)</option>
                    <option value="ARS">ARS ($)</option>
                </select>
            </div>
        </c:if>
    </div>
    
    <!-- Panel de filtros expandible -->
    <div class="filters-panel" id="filtersPanel_${uniqueId}">
        <div class="filters-grid">
            
            <!-- Filtro de Género -->
            <c:if test="${showGenreFilter}">
                <div class="filter-group">
                    <label class="filter-label" for="genreFilter_${uniqueId}">Género</label>
                    <select class="filter-select" id="genreFilter_${uniqueId}">
                        <option value="">Todos los Géneros</option>
                        <option value="rock">Rock</option>
                        <option value="jazz">Jazz</option>
                        <option value="electronic">Electrónica</option>
                        <option value="hip-hop">Hip Hop</option>
                        <option value="classical">Clásica</option>
                        <option value="pop">Pop</option>
                        <option value="folk">Folk</option>
                        <option value="blues">Blues</option>
                        <option value="reggae">Reggae</option>
                        <option value="country">Country</option>
                    </select>
                </div>
            </c:if>
            
            <!-- Filtro de Condición -->
            <c:if test="${showConditionFilter}">
                <div class="filter-group">
                    <label class="filter-label" for="conditionFilter_${uniqueId}">Condición</label>
                    <select class="filter-select" id="conditionFilter_${uniqueId}">
                        <option value="">Todas las Condiciones</option>
                        <option value="mint">Mint (M)</option>
                        <option value="near-mint">Near Mint (NM)</option>
                        <option value="very-good-plus">Very Good+ (VG+)</option>
                        <option value="very-good">Very Good (VG)</option>
                        <option value="good">Good (G)</option>
                    </select>
                </div>
            </c:if>
            
            <!-- Filtro de Rango de Precio -->
            <c:if test="${showPriceRangeFilter}">
                <div class="filter-group">
                    <label class="filter-label">Rango de Precio</label>
                    <div class="price-range-inputs">
                        <input type="number" 
                               class="price-input" 
                               placeholder="Mín" 
                               id="minPrice_${uniqueId}">
                        <span class="price-separator">-</span>
                        <input type="number" 
                               class="price-input" 
                               placeholder="Máx" 
                               id="maxPrice_${uniqueId}">
                    </div>
                </div>
            </c:if>
            
            <!-- Filtro de Ordenamiento -->
            <c:if test="${showSortingFilter}">
                <div class="filter-group">
                    <label class="filter-label" for="sortFilter_${uniqueId}">Ordenar Por</label>
                    <select class="filter-select" id="sortFilter_${uniqueId}">
                        <option value="recent">Más Recientes</option>
                        <option value="price-low">Precio: Menor a Mayor</option>
                        <option value="price-high">Precio: Mayor a Menor</option>
                        <option value="alphabetical">Alfabético</option>
                        <option value="most-viewed">Más Vistos</option>
                    </select>
                </div>
            </c:if>
        </div>
        
        <!-- Botones de acción -->
        <div class="filters-actions">
            <button class="btn-clear-filters" id="clearFilters_${uniqueId}">
                Limpiar Filtros
            </button>
            <button class="btn-apply-filters" id="applyFilters_${uniqueId}">
                Aplicar Filtros
            </button>
        </div>
    </div>
</div>


