<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="uk-table uk-table-hover uk-table-divider">
	<thead>
		<tr>
			<th>STT</th>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>STATUS</th>
			<th>PLAN</th>
			<th></th>
			<th>Detail</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="account" items="${accounts}" varStatus="indexAccount">
			<tr id="${account.accountNumber}"
				onclick="updateAccount(${account.accountNumber})"
				uk-tooltip="Click to edit">
				<td>${indexAccount.index +1 }</td>
				<td>${account.userName}</td>
				<td>${account.password}</td>
				<td>${account.accountStatus.shortDescription}</td>
				<td>${account.accountPlan.shortDescription}</td>
				<td><c:if test="${account.accountStatus.accountStatusId != 3}">
						<a uk-icon="icon: trash" style="color: #F93434;"
							uk-tooltip="Move to trash"
							onclick="deleteData(${account.accountNumber},'account_main')"></a>
					</c:if></td>
				<td><a uk-icon="icon: info"
					href="#personInfo-${account.accountNumber}" uk-toggle></td>
			</tr>
			<div id="personInfo-${account.accountNumber}" class="uk-flex-top"
				uk-modal>
				<div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">

					<button class="uk-modal-close-default" type="button" uk-close></button>
					<h2 class="uk-modal-title uk-text-center">Person Information</h2>
					<hr class="uk-divider-icon">
					<ul class="uk-list uk-list-divider">
						<li><span style="width: 50px; font-weight: bold;">Fullname:</span>
							${account.person.firstName } ${account.person.lastName}</li>
						<li><span style="width: 50px; font-weight: bold;">Gender:</span>
							${account.person.gender}</li>
						<li><span style="width: 50px; font-weight: bold;">Phone:</span>
							${account.person.phoneNumber}</li>
						<li><span style="width: 50px; font-weight: bold;">Email:</span>
							${account.person.emailAddress}</li>
						<li><span style="width: 50px; font-weight: bold;">Address:</span>
							${account.person.address}</li>
					</ul>
					<div class="uk-margin uk-text-center">
						<a href="admin/account-management/update-person.htm"><span
							uk-icon="pencil"></span>Edit Person Information</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</tbody>
</table>