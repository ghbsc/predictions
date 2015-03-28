
<tags:templatepage title="Prediction Lists">



<c:if test="${not empty predictions}">
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
<c:forEach var="item" items="${predictions}">
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
  <tags:editLinksFineGrained baseURL='${baseURL}' id='${item.id}'/>
 </tr>
</c:forEach>
</w:alternatingRow>
</table>
</c:if>

</tags:templatepage>

