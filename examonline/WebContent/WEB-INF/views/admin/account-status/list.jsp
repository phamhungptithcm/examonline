<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="uk-table uk-table-hover uk-table-divider">
	<thead>
		<tr>
			<th>STT</th>
			<th>STATUS CODE</th>
			<th>SHORT DESCRIPTION</th>
			<th><a href="" uk-icon="icon: trash" style="color: #F93434;"
				uk-tooltip="Move all to trash"></a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="status" items="${accountStatuses}"
			varStatus="indexStatus">
			<tr id="${status.accountStatusId}"
				onclick="updateAccountStatus(${status.accountStatusId})">
				<td>${indexStatus.index +1 }</td>
				<td>${status.accoutStatusCode}</td>
				<td>${status.shortDescription}</td>
				<td><a uk-icon="icon: trash" style="color: #F93434;"
					uk-tooltip="Move to trash"
					onclick="deleteData(${status.accountStatusId},'account_status')"></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>