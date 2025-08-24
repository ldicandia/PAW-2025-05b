<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo - VinylVault</title>
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/components.css'/>">
</head>
<body>
    
    <!-- Header -->
    <paw:header />
    
    <!-- Contenido de la página -->
    <div class="component-container">
        
        <!-- Sección de Botones -->
        <div class="mt-5">
            <h2>Botones</h2>
            
            <div class="btn-group">
                <paw:button text="Primario" variant="primary" size="md" />
                <paw:button text="Secundario" variant="secondary" size="md" />
                <paw:button text="Personalizado" variant="custom" size="md" />
            </div>
            
            <div class="btn-group">
                <paw:button text="Pequeño" variant="primary" size="sm" />
                <paw:button text="Mediano" variant="primary" size="md" />
                <paw:button text="Grande" variant="primary" size="lg" />
            </div>
            
            <div class="btn-group">
                <paw:button text="Deshabilitado" variant="primary" disabled="true" />
            </div>
        </div>
        
        <!-- Sección de Cards -->
        <div class="mt-5">
            <h2>Tarjetas</h2>
            
            <div class="card-container">
                <div class="card">
                    <div class="card-header">
                        <img src="<c:url value='/images/defaultVinyl.jpg'/>" alt="Disco de Vinilo">
                    </div>
                    <div class="card-body">
                        <h3 class="card-title">The Dark Side of the Moon</h3>
                        <p class="card-text">Pink Floyd</p>
                    </div>
                </div>
                
                <div class="card">
                    <div class="card-header">
                        <img src="<c:url value='/images/defaultVinyl.jpg'/>" alt="Disco de Vinilo">
                    </div>
                    <div class="card-body">
                        <h3 class="card-title">Abbey Road</h3>
                        <p class="card-text">The Beatles</p>
                    </div>
                </div>
                
                <div class="card">
                    <div class="card-header">
                        <img src="<c:url value='/images/defaultVinyl.jpg'/>" alt="Disco de Vinilo">
                    </div>
                    <div class="card-body">
                        <h3 class="card-title">Led Zeppelin IV</h3>
                        <p class="card-text">Led Zeppelin</p>
                    </div>
                </div>
                
                <div class="card">
                    <div class="card-header">
                        <img src="<c:url value='/images/defaultVinyl.jpg'/>" alt="Disco de Vinilo">
                    </div>
                    <div class="card-body">
                        <h3 class="card-title">Thriller</h3>
                        <p class="card-text">Michael Jackson</p>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Sección de Inputs -->
        <div class="mt-5">
            <h2>Campos de Entrada</h2>
            
            <div class="form-group">
                <label class="form-label">Correo Electrónico</label>
                <input type="email" class="form-input" placeholder="Ingresa tu correo electrónico">
            </div>
            
            <div class="form-group">
                <label class="form-label">Contraseña</label>
                <input type="password" class="form-input" placeholder="Ingresa tu contraseña">
            </div>
        </div>
        
    </div>
    
</body>
</html>
