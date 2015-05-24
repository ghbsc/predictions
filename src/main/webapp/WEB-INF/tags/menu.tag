
   <%@ include file="/WEB-INF/TagHeader.jspf" %>
    <c:url var='homePageURL' value='/predictionlist/list' />
    <li><a href='${homePageURL}' title='Home page'>Home</a></li>
    <c:url var='searchURL' value='/pub/search/SearchAction.show' />
    <li><a href='${searchURL}' title='Search all predictions'>Search</a></li>
	<sec:authorize access="!isAuthenticated()">    
	    <c:url var='loginURL' value='/main/lists/PredictionListAction.list' />
	    <li><a href='${loginURL}' title='Login and add predictions'>Login</a></li>
	</sec:authorize>      
	<sec:authorize access="isAuthenticated()">
	      <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
	</sec:authorize>   
  <li><a href='mailto:support@web4j.com'>Contact</a>
    