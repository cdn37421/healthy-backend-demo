<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Members</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Healthy members systems demo</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Member -->

			<input type="button" value="Add Member"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>


				<c:forEach var="tempMember" items="${members}">


					<c:url var="updateLink" value="/member/showFormForUpdate">
						<c:param name="memberId" value="${tempMember.id }" />
					</c:url>

					<c:url var="deleteLink" value="/member/delete">
						<c:param name="memberId" value="${tempMember.id }" />
					</c:url>

					<tr>
						<td>${tempMember.firstName}</td>
						<td>${tempMember.lastName}</td>
						<td>${tempMember.email}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							|<a href="${deleteLink }"
							onclick="if(!(confirm('Are you sure you want to delete this Member?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









