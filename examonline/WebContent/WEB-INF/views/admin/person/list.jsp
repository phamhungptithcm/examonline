<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="uk-table uk-table-hover uk-table-divider">
	<thead>
		<tr>
			<th>STT</th>
			<th>Username</th>
			<th>Fullname</th>
			<th>Gender</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Address</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="person" items="${persons}" varStatus="indexPerson">
			<tr>
				<td>${indexPerson.index +1 }</td>
				<td>${person.account.userName}</td>
				<td>${person.firstName}${person.lastName}</td>
				<td>${person.gender}</td>
				<td>${person.phoneNumber}</td>
				<td>${person.emailAddress}</td>
				<td>${person.address}</td>
				<td><a href="admin/person/edit.htm?id=${person.personId}"
					uk-icon="icon: pencil" uk-tooltip="Edit"></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>