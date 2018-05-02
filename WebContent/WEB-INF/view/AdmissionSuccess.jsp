<html>
<head>
<title>Admission Success</title>
</head>
<body>
	<h1>Congratulations!! Success!!</h1>
	<h2>${headerMessage}</h2>
	<table>
		<tr><td>Student Name : </td><td>${student.studentName}</td></tr>
		<tr><td>Student Hobby : </td><td>${student.studentHobby}</td></tr>
		<tr><td>Student Mobile : </td><td>${student.studentMobile}</td></tr>
		<tr><td>Student DOB : </td><td>${student.studentDOB}</td></tr>
		<tr><td>Student Skills : </td><td>${student.studentSkills}</td></tr>
		<tr>
			<td>Student Address: </td>
			<td>
				Country: ${student.studentAddress.country}
				City: ${student.studentAddress.city}
				Street: ${student.studentAddress.street}
				Pincode: ${student.studentAddress.pincode}
			</td>
		</tr>
	</table>
</body>
</html>