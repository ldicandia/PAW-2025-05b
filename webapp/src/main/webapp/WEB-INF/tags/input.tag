<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="inputId" required="true" %>
<%@ attribute name="inputLabel" required="true" %>
<%@ attribute name="inputName" required="true" %>
<%@ attribute name="inputType" required="false" %>
<%@ attribute name="inputValue" required="false" %>
<%@ attribute name="inputRequired" required="false" type="java.lang.Boolean" %>
<%@ attribute name="inputPattern" required="false" %>
<%@ attribute name="inputError" required="false" %>
<%@ attribute name="inputHelp" required="false" %>
<%@ attribute name="inputMin" required="false" type="java.lang.Number" %>
<%@ attribute name="inputMax" required="false" type="java.lang.Number" %>
<%@ attribute name="inputMaxlength" required="false" type="java.lang.Integer" %>
<%@ attribute name="inputPlaceholder" required="false" %>
<%@ attribute name="cssClass" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="inputTypeValue" value="${not empty inputType ? inputType : 'text'}"/>
<c:set var="isRequired" value="${inputRequired ne null ? inputRequired : false}"/>
<c:set var="additionalCssClass" value="${not empty cssClass ? cssClass : ''}"/>

<div class="form-group">
    <label for="${inputId}" class="form-label">
        <c:out value="${inputLabel}"/>
        <c:if test="${isRequired}">
            <span class="required-indicator">*</span>
        </c:if>
    </label>
    
    <input id="${inputId}" 
           name="${inputName}" 
           type="${inputTypeValue}" 
           class="form-control${additionalCssClass}"
           value="<c:out value='${inputValue}'/>"
           placeholder="<c:out value='${inputPlaceholder}'/>"
           <c:if test="${isRequired}">required</c:if>
           <c:if test="${not empty inputPattern}">pattern="<c:out value='${inputPattern}'/>"</c:if>
           <c:if test="${not empty inputMin}">min="${inputMin}"</c:if>
           <c:if test="${not empty inputMax}">max="${inputMax}"</c:if>
           <c:if test="${not empty inputMaxlength}">maxlength="${inputMaxlength}"</c:if> />

    <c:if test="${not empty inputHelp}">
        <small class="form-text text-muted">
            <c:out value="${inputHelp}"/>
        </small>
    </c:if>

    <c:if test="${not empty inputError}">
        <div class="invalid-feedback" role="alert">
            <c:out value="${inputError}"/>
        </div>
    </c:if>
</div>