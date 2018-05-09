<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <!-- to make placeholder work -->
<html>
<head>
<title>Admission Form</title>
</head>
<body>
<a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=en">English</a> | 
<a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=fr">French</a>
	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h1>
	<form:errors path="student.*" />
	<h2>${headerMessage}</h2>
	<form action="/FirstSpringMVCProject/submitAdmissionForm5.html"
		method="post">
		<table>
		<tr>
			<td><spring:message code="label.studentName" /></td><td><input type="text" name="studentName" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.studentHobby" /></td><td><input type="text" name="studentHobby" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.studentMobile" /></td><td><input type="text" name="studentMobile" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.studentDOB" /></td><td><input type="text" name="studentDOB" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.studentSkills" /></td><td> <select name="studentSkills" multiple>
													<option value="Java Core">Java Core</option>
													<option value="Spring Core">Spring Core</option>
													<option value="Spring MVC">Spring MVC</option>
												</select></td>
		</tr>
		</table>
		<table>
		<tr>
			<td><spring:message code="label.studentAddress.country" /><input type="text" name="studentAddress.country" /></td>
			<td><spring:message code="label.studentAddress.city" /><input type="text" name="studentAddress.city" /></td>
			<td><spring:message code="label.studentAddress.street" /><input type="text" name="studentAddress.street" /></td>
			<td><spring:message code="label.studentAddress.pincode" /><input type="text" name="studentAddress.pincode" /></td>
		</tr>
		<tr><td><input type="submit" value="${labelSubmitAdmissionForm}"/></td></tr>
		</table>
	</form>
</body>
</html>