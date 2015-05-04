<tags:templatepage title="Log In To Your Account">

<div class="body">
 <form method="POST" action="<c:url value='/j_spring_security_check' />" class="user-input" name='giveMeFocus'>
	<c:if test="${param.error != null}">
	    <div class="alert alert-error">
	        Invalid username and password.
	    </div>
	</c:if>
	<c:if test="${param.logout != null}">
	    <div class="alert alert-success">
	        You have been logged out.
	    </div>
	</c:if>
	 <table align="center">
		 <tr>
		  <td><label>Name</label></td>
		  <td><input type="text" name="username" id="username" size='30'></td>
		 </tr>
		 <tr>
		  <td><label>Password (or phrase)</label></td>
		  <%-- 'autocomplete' is a non-HTML attribute, supported by some browsers. Prevents prepopulation of passwords.--%>
		  <td><input type="password" name="password" id="password" autocomplete="false" size='30'></td>
		 </tr>
		 <tr align="center">
		 	<td colspan="2"><input type="submit" value="Login"></td>
		 </tr>
	 </table> 
 </form>	
</div>

</tags:templatepage>