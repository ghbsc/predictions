<tags:templatepage title="Prediction">
	<tags:confirmationMessages message="${confirmationMessage}" />

	<form:form action='${pageContext.request.contextPath}/prediction/update' method="post" 
		class="user-input" modelAttribute='predictionForm'> 
	  <w:populate using="itemForEdit"> 
		<form:hidden path='id' />
		<form:hidden path='parentId' /> 
	   
	   <table align="center">
	     <tr>
	       <td><label alt='Required, max 255 characters'>Prediction</label></td>
	       <td>
	       	<form:textarea path='text' rows='3' cols='40' alt='Max 255 characters' />
      		<form:errors path="text" />	       	
	       </td>
	      </tr>
	      <tr>
	       <td><label>Remark</label></td>
	       <td>
	       	<form:textarea path='remark' rows='3' cols='40' />
      		<form:errors path="remark" />	       	
	       	</td>
	      </tr>
	      <tr>
	       <td><label>Outcome</label></td>
	       <td>
       		<form:select path='outcome.id'>
       			<form:option value='' label='' />
       			<form:options items='${outcomes}' itemValue='id' itemLabel='text'/>
       		</form:select>
	        </td>
	      </tr>
	    <tr>
	     <td align="center" colspan=2>
	      <input type='submit' value="Add/Edit">
	     </td>
	    </tr>
	   </table>
	  </w:populate>
	</form:form>

<c:if test="${not empty predictions}">
<p>
	<%-- Listing. --%>
	<table class="report" title="Prediction Listing" align="center"> 
	 <tr>
	  <th title="Line Number">#</th>
	  <th>Prediction/Remark</th>
	  <th>Created</th>
	  <th>Outcome</th>
	  <th>Score(%)</th>
	  <th>Outcome Date</th>
	 </tr>
	<w:alternatingRow> 
	<c:forEach var="item" items="${predictions}" varStatus="index">
	 <tr class="row_highlight">
	  <td title="Line Number">${index.count}</td>
	  <td>${item.text} <i>${item.remark}</i></td>
	  <td>
	  	<fmt:formatDate value='${item.creationDate}' var='creationFormattedDate' type='date' 
	  					pattern='MM-dd-yyyy' />
	  	${creationFormattedDate}
	  </td>
	  <td nowrap>${item.outcome.text}</td>
	  <td>${item.outcome.weight}</td>
	  <td>
	  	<fmt:formatDate value='${item.outcomeDate}' var='outcomeFormattedDate' type='date'
	  					pattern='MM-dd-yyyy' />
	  	${outcomeFormattedDate}
	  </td>
	  <td>
	 	<c:url value='/prediction/edit' var='editURL'>
	 		<c:param name='id' value='${item.id}' />
			<c:param name='parentId' value='${item.predictionList.id}' />	 		
	 	</c:url>
	 	<a href='${editURL}' title='Prediction'>edit</a>
	  </td>	  
	  <td>
	 	<c:url value='/prediction/delete' var='deleteURL'>
	 		<c:param name='id' value='${item.id}' />
	 		<c:param name='parentId' value='${item.predictionList.id}' />	 		
	 	</c:url>
	 	<a href='${deleteURL}' title='Prediction'>delete</a>
	  </td> 	  
	 </tr>
	</c:forEach>
	</w:alternatingRow>
	</table>
</p>
</c:if>

</tags:templatepage>