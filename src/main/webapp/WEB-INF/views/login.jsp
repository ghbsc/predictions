<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%-- Login Page. Configured in web.xml. --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<tags:headsimple title='Home'/>
 	
<body onload='showFocus()'>

<tags:headerAndMenu/> 

<h2>Log In To Your Account</h2>

<div class="body">
 <form method="POST" action='/login' class="user-input" name='giveMeFocus'>
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
		  <td><input type="text" name="loginname" id="loginname" size='30'></td>
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

<P>
</body>
</html>
