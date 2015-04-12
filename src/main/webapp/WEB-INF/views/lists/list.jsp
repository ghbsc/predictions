
<tags:templatepage title="Prediction Lists">

<c:if test="${not empty confirmationMessage}">
	<p class="display-messages">
	   <span class="message">${confirmationMessage}</span><br>
	</p>
</c:if>

<form:form action='${pageContext.request.contextPath}/predictionlist/update' 
	class="user-input" modelAttribute='predictionListForm' method='post'>
	<form:hidden path="id" /> 
    <table align="center">
     <tr>
      <td><label>Title</label></td>
      <td>
      	<form:input path="title" type="text" />
      	<form:errors path="title" />
      </td>
     </tr>
     <tr>
      <td align="center" colspan=2>
       <input type='submit' value="Add/Edit" name="AddEdit">
      </td>
     </tr>
    </table>
</form:form>

<p>

<c:if test="${not empty predictionLists}">
<table class="report" title="Prediction Lists" align="center"> 
 <tr>
  <th title="Line Number">#</th>
  <th>Title</th>
  <th>Created</th>
  <th>Details</th>
  <th>Link</th>
  <th><a href='http://www.json.org/' title='JSON data interchange format'>JSON</a></th>
 </tr>
<w:alternatingRow>
<c:forEach var="item" items="${predictionLists}">
 <tr class="row_highlight">
  <td title="Line Number">${index.count}</td>
  <td>${item.title}</td>
  <td>
	${item.creationDate}
   </td>
  <td>
    <c:url value="/prediction/list" var="predictionsURL"> 
      <c:param name='parentId' value='${item.id}' />
    </c:url>
    <A HREF='${predictionsURL}' title='Edit the predictions in the list'>details</A>
  </td>   
  <td>
    <c:url value="/pub/viewlist/ViewPublicListAction.do" var="viewPublicPredictionsURL"> 
      <c:param name='ListId' value='${item.id}' />
    </c:url>
    <A HREF='${viewPublicPredictionsURL}' title='Public link to your prediction list'>link</A>
  </td>   
  <td>
    <c:url value="/pub/json/ViewPublicListJsonAction.do" var="jsonURL"> 
      <c:param name='ListId' value='${item.id}' />
    </c:url>
    <A HREF='${jsonURL}' title='Public link to your list as JSON data'>link</A>
  </td>   
  <td>
 	<c:url value='/predictionlist/edit' var='editURL'>
 		<c:param name='id' value='${item.id}' />
 	</c:url>
 	<a href='${editURL}' title='Prediction Lists'>edit</a>
  </td>
   <td>
 	<c:url value='/predictionlist/delete' var='deleteURL'>
 		<c:param name='id' value='${item.id}' />
 	</c:url>
 	<a href='${deleteURL}' title='Prediction Lists'>delete</a>
  </td> 
 </tr>
</c:forEach>
</w:alternatingRow>
</table>
</c:if>

</p>

</tags:templatepage>

