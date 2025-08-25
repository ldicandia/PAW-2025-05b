<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/components.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/hero.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/searchFilters.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
          integrity="sha512-SOMEHASH..."
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <title>Vinyl Store - Página Principal</title>
</head>
<body>

<!-- Header -->
<paw:header />

<!-- Hero Section -->
<paw:hero />

<!-- Filtros de Búsqueda -->
<paw:searchFilters instanceId="main" />

<!-- Contenido de la página -->
<div class="component-container">
    
    <!-- Sección de Botones Demo -->
    <div class="mt-5">
        <h2>Botones</h2>
        
        <!-- Botones Primarios (Rosa) -->
        <div class="btn-group">
            <paw:button text="Vender Disco" variant="primary" size="sm" />
            <paw:button text="Vender Disco" variant="primary" size="md" />
            <paw:button text="Vender Disco" variant="primary" size="lg" />
        </div>
        
        <!-- Botones Explorar Discos -->
        <div class="btn-group">
            <button class="browse-records-button browse-records-button-sm">Explorar Discos</button>
            <button class="browse-records-button browse-records-button-md">Explorar Discos</button>
            <button class="browse-records-button browse-records-button-lg">Explorar Discos</button>
        </div>
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

</div>

<!-- CÓDIGO PROVISIONAL - Este JavaScript inline debe ser reemplazado por lógica del backend cuando se implemente la funcionalidad real -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    const filterContainers = document.querySelectorAll('.search-filters-container');
    
    filterContainers.forEach(function(container) {
        const mainSearch = container.querySelector('.search-input');
        const filtersToggle = container.querySelector('.filters-toggle-btn');
        const filtersPanel = container.querySelector('.filters-panel');
        const clearFilters = container.querySelector('.btn-clear-filters');
        const applyFilters = container.querySelector('.btn-apply-filters');
        
        if (!mainSearch || !filtersToggle || !filtersPanel) return;
        
        const uniqueId = mainSearch.id.replace('mainSearch_', '');
        
        filtersToggle.addEventListener('click', function() {
            filtersPanel.classList.toggle('filters-panel-open');
            filtersToggle.classList.toggle('active');
        });
        
        if (clearFilters) {
            clearFilters.addEventListener('click', function() {
                const genreFilter = container.querySelector(`#genreFilter_${uniqueId}`);
                const conditionFilter = container.querySelector(`#conditionFilter_${uniqueId}`);
                const minPrice = container.querySelector(`#minPrice_${uniqueId}`);
                const maxPrice = container.querySelector(`#maxPrice_${uniqueId}`);
                const sortFilter = container.querySelector(`#sortFilter_${uniqueId}`);
                
                mainSearch.value = '';
                if (genreFilter) genreFilter.value = '';
                if (conditionFilter) conditionFilter.value = '';
                if (minPrice) minPrice.value = '';
                if (maxPrice) maxPrice.value = '';
                if (sortFilter) sortFilter.value = 'recent';
            });
        }
        
        if (applyFilters) {
            applyFilters.addEventListener('click', function() {
                filtersPanel.classList.remove('filters-panel-open');
                filtersToggle.classList.remove('active');
            });
        }
    });
});
</script>

</body>
</html>
