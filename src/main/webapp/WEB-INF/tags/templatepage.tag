<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/TagHeader.jspf" %>

<%@attribute name="title" required="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
 <tags:head/>
<body onload='showFocus()'>
<tags:headerAndMenu/> 
<h2>${title}</h2>
<tags:displayMessages/>
<div class="body">
		<jsp:doBody />
</div>
 <tags:footer/>
</body>
</html>
