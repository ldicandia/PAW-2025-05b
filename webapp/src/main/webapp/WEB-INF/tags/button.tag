<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="text" required="true" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="size" required="false" %>
<%@ attribute name="cssClass" required="false" %>
<%@ attribute name="variant" required="false" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="icon" required="false" %>
<%@ attribute name="iconPosition" required="false" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="btnSize" value="${not empty size ? size : 'md'}" />
<c:set var="btnCssClass" value="${not empty cssClass ? cssClass : ''}" />
<c:set var="btnVariant" value="${not empty variant ? variant : 'primary'}" />
<c:set var="btnDisabled" value="${disabled ne null ? disabled : false}" />
<c:set var="btnType" value="${type ne null ? type : 'button'}" />
<c:set var="classes" value="btn btn-${btnSize} btn-${btnVariant} ${btnCssClass}" />

<button type="${btnType}"
        class="${classes}"
        <c:if test="${btnDisabled}">disabled</c:if>>
    <c:choose>
        <c:when test="${not empty icon and (empty iconPosition or iconPosition eq 'left')}">
            <i class="${icon}"></i>
            <span><c:out value="${text}" /></span>
        </c:when>
        <c:when test="${not empty icon and iconPosition eq 'right'}">
            <span><c:out value="${text}" /></span>
            <i class="${icon}"></i>
        </c:when>
        <c:otherwise>
            <c:out value="${text}" />
        </c:otherwise>
    </c:choose>
</button>
