
   <%@ include file="/WEB-INF/TagHeader.jspf" %>
    <c:url var='homePageURL' value='/Home.jsp' />
    <li><a href='${homePageURL}' title='Home page'>Home</a></li>
    <c:url var='searchURL' value='/pub/search/SearchAction.show' />
    <li><a href='${searchURL}' title='Search all predictions'>Search</a></li>
    <c:url var='loginURL' value='/main/lists/PredictionListAction.list' />
    <li><a href='${loginURL}' title='Login and add predictions'>Login</a></li>
    
  <li><a href='mailto:support@web4j.com'>Contact</a>
    