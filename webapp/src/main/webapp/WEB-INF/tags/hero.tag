<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<section class="hero-section">
  <!-- Background pattern -->
  <div class="hero-background">
    <div class="hero-bg-circle-1"></div>
    <div class="hero-bg-circle-2"></div>
  </div>

  <div class="hero-container">
    <div class="hero-grid">
      <!-- Content -->
      <div class="hero-content">
        <div class="hero-text">
          <h1 class="hero-title">
            El Mejor
            <span class="hero-title-gradient">Mercado de Vinilos</span>
          </h1>
          <p class="hero-description">
            Descubre joyas raras, intercambia tu colección y conéctate con otros entusiastas del vinilo. 
            Compra, vende e intercambia discos en la comunidad de vinilos más confiable del mundo.
          </p>
        </div>

        <div class="hero-buttons">
          <button class="btn-start-collecting">
            Comenzar a Coleccionar
          </button>
          <button class="btn-browse-records">
            Explorar Discos
          </button>
        </div>

        <div class="hero-stats">
          <div class="hero-stat">
            <div class="hero-stat-icon">
              <svg class="hero-stat-svg" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 7h8m0 0v8m0-8l-8 8-4-4-6 6"></path>
              </svg>
            </div>
            <div>
              <div class="hero-stat-number">50K+</div>
              <div class="hero-stat-label">Discos Listados</div>
            </div>
          </div>
          <div class="hero-stat">
            <div class="hero-stat-icon">
              <svg class="hero-stat-svg" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7h12m0 0l-4-4m4 4l-4 4m0 6H4m0 0l4 4m-4-4l4-4"></path>
              </svg>
            </div>
            <div>
              <div class="hero-stat-number">2K+</div>
              <div class="hero-stat-label">Intercambios</div>
            </div>
          </div>
        </div>
      </div>

      <!-- Vinyl Records Showcase -->
      <div class="vinyl-showcase">
        <div class="vinyl-grid">
          <div class="vinyl-column">
            <div class="vinyl-record large rotate-3">
              <div class="vinyl-outer-ring large"></div>
              <div class="vinyl-inner-ring large"></div>
              <div class="vinyl-center-dot large"></div>
            </div>
            <div class="vinyl-record small rotate-neg-2">
              <div class="vinyl-outer-ring small"></div>
              <div class="vinyl-inner-ring small"></div>
              <div class="vinyl-center-dot small"></div>
            </div>
          </div>
          <div class="vinyl-column">
            <div class="vinyl-record small rotate-1">
              <div class="vinyl-outer-ring small"></div>
              <div class="vinyl-inner-ring small"></div>
              <div class="vinyl-center-dot small"></div>
            </div>
            <div class="vinyl-record large rotate-neg-1">
              <div class="vinyl-outer-ring large"></div>
              <div class="vinyl-inner-ring large"></div>
              <div class="vinyl-center-dot large"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
