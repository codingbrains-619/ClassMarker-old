<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<script>
window.addEventListener("load", init);
function init() {
	let message = document.getElementById('alert');
	console.log("Message is ",message.innerText);
	if (message.innerText == "Added") {
		message.innerText = " ";
		alert("Role Added....");
	}
}
</script>
</head>
<body>
<div class='w-100 float-right pr-2'>
     <h6 id="alert" class="text-center"><s:property value="message"/></h6>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Role</h1>
<s:form action="addrole" method="post" namespace="/">
	<s:textfield type="text" name="rolename" 
	cssClass="form-group form-control" label="Role Name" 
	placeholder="Enter Role Name"/>
	<s:textfield type="text" name="roledesc" 
	cssClass="form-group form-control" label="Role Description" 
	placeholder="Enter Role Description"/>
   	<s:checkboxlist list="rightlist" name="selectedright" 
	label="Rights"/>
	<s:submit cssClass="form-group btn btn-primary mx-5" value="submit"/>
</s:form> 


<s:form name="showrole" action="showrole">
                <s:submit value="Fetch Records"/>
</s:form>

<table class="table table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Role Name</th>
			<th>Role Description</th>
			<th>Rights</th>
		</tr>
	</thead>
	<s:iterator value="rolelist">
	<tr>
			<td><s:property value="rolename"/></td>
			<td><s:property value="roledesc"/></td>
			<td><s:property value="showrights"/></td>
	<tr>
	</s:iterator>
</table>
</div>
</body>
</html>