<tags:templatepage title="Prediction">
	<tags:confirmationMessages message="${confirmationMessage}" />

	<form:form action='${pageContext.request.contextPath}/prediction/update' method="post" 
		class="user-input" modelAttribute='predictionForm'> 
	  <w:populate using="itemForEdit"> 
		<form:hidden path='id' />
		<form:hidden path='parentId' /> 
	   	<!--<input name="ParentId" type="hidden"> -->
	   
	   <table align="center">
	     <tr>
	       <td><label alt='Required, max 255 characters'>Prediction</label></td>
	       <td>
	       	<form:textarea path='text' rows='3' cols='40' alt='Max 255 characters' />
	       </td>
	      </tr>
	      <tr>
	       <td><label>Remark</label></td>
	       <td><form:textarea path='remark' rows='3' cols='40' /></td>
	      </tr>
	      <tr>
	       <td><label>Outcome</label></td>
	       <td>
       		<form:select path='outcome'>
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

</tags:templatepage>