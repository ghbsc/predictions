<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/TagHeader.jspf" %>

<%@attribute name="message" required="true"%>

<c:if test="${not empty message}">
	<p class="display-messages">
	   <span class="message">${message}</span><br>
	</p>
</c:if>