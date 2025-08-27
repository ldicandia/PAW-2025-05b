// ===== FUNCIONALIDAD DE FILTROS DE BÚSQUEDA =====

document.addEventListener('DOMContentLoaded', function() {
    // Buscar todos los contenedores de filtros en la página
    const filterContainers = document.querySelectorAll('.search-filters-container');
    
    filterContainers.forEach(function(container) {
        // Obtener elementos del contenedor
        const mainSearch = container.querySelector('.search-input');
        const filtersToggle = container.querySelector('.filters-toggle-btn');
        const filtersPanel = container.querySelector('.filters-panel');
        const clearFilters = container.querySelector('.btn-clear-filters');
        const applyFilters = container.querySelector('.btn-apply-filters');
        
        if (!mainSearch || !filtersToggle || !filtersPanel) return;
        
        // Extraer el ID único
        const uniqueId = mainSearch.id.replace('mainSearch_', '');
        
        // Toggle del panel de filtros
        filtersToggle.addEventListener('click', function() {
            filtersPanel.classList.toggle('filters-panel-open');
            filtersToggle.classList.toggle('active');
        });
        
        // Limpiar filtros
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
        
        // Aplicar filtros
        if (applyFilters) {
            applyFilters.addEventListener('click', function() {
                filtersPanel.classList.remove('filters-panel-open');
                filtersToggle.classList.remove('active');
            });
        }
    });
});
