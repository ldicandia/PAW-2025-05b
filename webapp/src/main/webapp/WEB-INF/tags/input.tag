<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="inputId" required="true" %>
<%@ attribute name="inputLabel" required="true" %>
<%@ attribute name="inputName" required="true" %>
<%@ attribute name="inputType" required="false" %> <%-- text, number, date, email --%>
<%@ attribute name="inputValue" required="false" %>
<%@ attribute name="inputRequired" required="false" type="java.lang.Boolean" %>
<%@ attribute name="inputPattern" required="false" %> <%-- regex HTML --%>
<%@ attribute name="inputError" required="false" %> <%-- mensaje de error si aplica --%>
<%@ attribute name="inputHelp" required="false" %>
<%@ attribute name="inputMin" required="false" type="java.lang.Number" %>
<%@ attribute name="inputMax" required="false" type="java.lang.Number" %>
<%@ attribute name="inputMaxlength" required="false" type="java.lang.Integer" %>
<%@ attribute name="inputPlaceholder" required="false" %> <%-- texto de fondo --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="t" value="${not empty inputType ? inputType : 'text'}"/>
<c:set var="isReq" value="${inputRequired ne null ? inputRequired : false}"/>

<div class="form-group">
    <label for="${inputId}"><c:out value="${inputLabel}"/></label>
    <input id="${inputId}" name="${inputName}" type="${t}" class="form-control"
           value="<c:out value='${inputValue}'/>"
           placeholder="<c:out value='${inputPlaceholder}'/>"
           <c:if test="${isReq}">required</c:if>
           <c:if test="${not empty inputPattern}">pattern="${inputPattern}"</c:if>
           <c:if test="${not empty inputMin}">min="${inputMin}"</c:if>
           <c:if test="${not empty inputMax}">max="${inputMax}"</c:if>
           <c:if test="${not empty inputMaxlength}">maxlength="${inputMaxlength}"</c:if> />

    <c:if test="${not empty inputHelp}">
        <small class="form-text"><c:out value="${inputHelp}"/></small>
    </c:if>

    <c:if test="${not empty inputError}">
        <div class="invalid-feedback" style="display:block"><c:out value="${inputError}"/></div>
    </c:if>
</div>