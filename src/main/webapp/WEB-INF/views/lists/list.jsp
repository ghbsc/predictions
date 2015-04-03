
<tags:templatepage title="Prediction Lists">

<form:form action='${pageContext.request.contextPath}/prediction' 
	class="user-input" modelAttribute='predictionList'> 
    <input name="Id" type="hidden">
    <table align="center">
     <tr>
      <td><label>Title</label></td>
      <td><form:input path="title" type="text" /></td>
     </tr>
     <tr>
      <td align="center" colspan=2>
       <input type='submit' value="Add/Edit">
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
    <c:url value="/main/prediction/PredictionAction.list" var="predictionsURL"> 
      <c:param name='ParentId' value='${item.id}' />
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
 	<c:url value='/prediction/edit' var='editURL'>
 		<c:param name='id' value='${item.id}' />
 	</c:url>
 	<a href='${editURL}' title='Prediction Lists'>edit</a>
  </td>
  
  <tags:editLinksFineGrained baseURL='${baseURL}' id='${item.id}'/>
 </tr>
</c:forEach>
</w:alternatingRow>
</table>
</c:if>

</p>

</tags:templatepage>

