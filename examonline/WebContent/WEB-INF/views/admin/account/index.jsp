<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Account Edit</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<h1 class="uk-heading-line uk-text-center">
			<span>Manage Account</span>
		</h1>
		<div class="row uk-margin-top">
			<div class="col-sm-6">
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
						<c:forEach var="account" items="${accounts}"
							varStatus="indexAccount">
							<tr id="${account.accountNumber}"
								onclick="updateAccount(${account.accountNumber})"
								uk-tooltip="Click to edit">
								<td>${indexAccount.index +1 }</td>
								<td>${account.userName}</td>
								<td>${account.password}</td>
								<td>${account.accountStatus.shortDescription}</td>
								<td>${account.accountPlan.shortDescription}</td>
								<td><c:if
										test="${account.accountStatus.accountStatusId != 3}">
										<a uk-icon="icon: trash" style="color: #F93434;"
											uk-tooltip="Move to trash"
											onclick="deleteData(${account.accountNumber},'account_main')"></a>
									</c:if></td>
								<td><a uk-icon="icon: info"
									href="#personInfo-${account.accountNumber}" uk-toggle></td>
							</tr>
							<div id="personInfo-${account.accountNumber}" class="uk-flex-top"
								uk-modal>
								<div
									class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">

									<button class="uk-modal-close-default" type="button" uk-close></button>
									<h2 class="uk-modal-title uk-text-center">Person
										Information</h2>
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
										<a href="admin/account-management/update-person.htm"><span uk-icon="pencil"></span>Edit Person Information</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<ul class="uk-pagination uk-flex-center" uk-margin>
						<li><a href="#"><span uk-pagination-previous></span></a></li>
						<li><a href="#">1</a></li>
						<li class="uk-disabled"><span>...</span></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li class="uk-active"><span>7</span></li>
						<li><a href="#">8</a></li>
						<li><a href="#"><span uk-pagination-next></span></a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="uk-margin">
					<div class="uk-child-width-1-1@s uk-grid-match" uk-grid>
						<div>
							<div class="uk-card uk-card-default uk-card-hover uk-card-body">
								<h3 class="uk-card-title uk-text-center" id="formTitle">Update
									account</h3>
								<hr class="uk-divider-icon">
								<div class="uk-margin">
									<div class="custom-control custom-switch">
										<input type="checkbox" class="custom-control-input"
											id="switchMode" onchange="switchModes('')"> <label
											id="switchModeTitle" class="custom-control-label"
											for="switchMode">EDIT</label>
									</div>
								</div>
								<div class="uk-margin" style="padding: 10px 0px 40px 0px">
									<form class="uk-grid-small" id="accForm" action="admin/account-management/update.htm" method="post" uk-grid>
										<input id="accountNumber" name="accountNumber" class="uk-input"
												type="text" hidden="true">
										<div class="uk-width-1-4@s">
											<input id="username" name="username" class="uk-input"
												type="text" placeholder="Username" disabled="disabled">
										</div>
										<div class="uk-width-1-4@s">
											<input id="password" name="password" class="uk-input"
												type="text" placeholder="Password">
										</div>
										<div class="uk-width-1-4@s">
											<div class="uk-form-controls">
												<select class="uk-select" id="accountStatus" name="accountStatusId">
													<option id="statusDefault">-------Select
														Status-------</option>
													<c:forEach var="status" items="${accountStatuses }">
														<option value="${status.accountStatusId}">${status.shortDescription}</option>
													</c:forEach>

												</select>
											</div>
										</div>
										<div class="uk-width-1-4@s">
											<div class="uk-form-controls">
												<select class="uk-select" id="accountPlan" name="accountPlanId">
													<option id="planDefault">-------Select Plan-------</option>
													<c:forEach var="plan" items="${accountPlans}">
														<option value="${plan.accountPlanId}">${plan.shortDescription}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="uk-width-1-1@s">
											<button class="uk-button uk-button-primary verve-btn-primary" type="submit">Save</button>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="custom/js/helper.js"></script>
	<script type="text/javascript" src="custom/js/ajax.js"></script>
	<script type="text/javascript">
	 var myParam = location.search.split('status=')[1];
	 	if(myParam == 'true') {
	 		showMessage('top-end','Successful','success');
	 	}
	</script>
</body>
</html>