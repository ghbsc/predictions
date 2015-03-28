<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%-- Login Page. Configured in web.xml. --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<tags:headsimple title='Home'/>
 	
<body onload='showFocus()'>

<tags:headerAndMenu/> 

<h2>Log In To Your Account</h2>

<div class="body">
 <form method="POST" action='<%= response.encodeURL("j_security_check") %>' class="user-input" name='giveMeFocus'>
	 <table align="center">
		 <tr>
		  <td><label>Name</label></td>
		  <td><input type="text" name="j_username" size='30'></td>
		 </tr>
		 <tr>
		  <td><label>Password (or phrase)</label></td>
		  <%-- 'autocomplete' is a non-HTML attribute, supported by some browsers. Prevents prepopulation of passwords.--%>
		  <td><input type="password" name="j_password" autocomplete="false" size='30'></td>
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
