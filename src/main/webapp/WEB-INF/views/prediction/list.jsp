<tags:templatepage title="Prediction">

	<form action='${pageContext.request.contextPath}/prediction/update' method="post" 
		class="user-input" modelAttribute='predictionForm'> 
	  <w:populate using="itemForEdit"> 
	   <input name="Id" type="hidden">
	   <input name="ParentId" type="hidden">
	   <table align="center">
	     <tr>
	       <td><label alt='Required, max 255 characters'>Prediction</label></td>
	       <td>
	         <textarea name='Text' alt='Max 255 characters' rows='3'  cols='40'></textarea>
	       </td>
	      </tr>
	      <tr>
	       <td><label>Remark</label></td>
	       <td><textarea name='Remark' rows='3'  cols='40'></textarea></td>
	      </tr>
	      <tr>
	       <td><label>Outcome</label></td>
	       <td>
	         <select name='Outcome'> 
	           <option> </option> 
	           <c:forEach var='item' items='${outcome}'>
	             <option value='${item.id}'>${item}</option>
	           </c:forEach>
	         </select>
	        </td>
	      </tr>
	    <tr>
	     <td align="center" colspan=2>
	      <input type='submit' value="Add/Edit">
	     </td>
	    </tr>
	   </table>
	  </w:populate>
	</form>

</tags:templatepage>