<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Account Status</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<h1 class="uk-heading-line uk-text-center">
			<span>Manage Account Status</span>
		</h1>
		<div class="row uk-margin-top">
			<div class="col-sm-6">
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
									account status</h3>
								<hr class="uk-divider-icon">
								<div class="uk-margin">
									<div class="custom-control custom-switch">
										<input type="checkbox" class="custom-control-input"
											id="switchMode" onchange="switchModes('status')"> <label
											id="switchModeTitle" class="custom-control-label"
											for="switchMode">EDIT</label>
									</div>
								</div>
								<div class="uk-margin" style="padding: 10px 0px 40px 0px">
									<form class="uk-grid-small" id="accForm"
										action="admin/account-status/update.htm" method="post" uk-grid>
										<input id="statusId" class="uk-input" type="text" name="accountStatusId"
											placeholder="Account Status Code" style="display: none">
										<div class="uk-width-1-4@s">
											<input id="code" class="uk-input" type="text"
												placeholder="Account Status Code" name="code" disabled="disabled">
										</div>
										<div class="uk-width-1-2@s">
											<input id="shortDescription" class="uk-input" name="shortDescription" type="text"
												placeholder="Short Description">
										</div>
										<div class="uk-width-1-4@s">
											<button class="uk-button uk-button-primary verve-btn-primary"
												type="submit">Save</button>
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