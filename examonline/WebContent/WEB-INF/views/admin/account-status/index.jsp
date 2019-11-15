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
				<div id="result"></div>
				<div class="uk-pagination uk-flex-center pager" uk-margin>
					<ul class="uk-pagination uk-flex-center pager" uk-margin>
						<li class="link-paging"><a href="#"><span uk-pagination-previous></span></a></li>
						<li class="uk-disabled"><span id="curpage">1 of 1
								pages</span></li>
						<li class="link-paging"><a href="#"><span uk-pagination-next></span></a></li>
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
										<input id="statusId" class="uk-input" type="text"
											name="accountStatusId" placeholder="Account Status Code"
											style="display: none">
										<div class="uk-width-1-4@s">
											<input id="code" class="uk-input" type="text"
												placeholder="Account Status Code" name="code"
												disabled="disabled">
										</div>
										<div class="uk-width-1-2@s">
											<input id="shortDescription" class="uk-input"
												name="shortDescription" type="text"
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
		if (myParam == 'true') {
			showMessage('top-end', 'Successful', 'success');
		}
	</script>
	<script type="text/javascript" src="custom/js/panigationStatus.js"></script>
</body>
</html>