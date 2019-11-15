<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Person Edit</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<div class="uk-margin">
			<div class="uk-child-width-1-1@s uk-grid-match" uk-grid>
				<div>
					<div class="uk-card uk-card-default uk-card-hover uk-card-body">
						<h3 class="uk-card-title uk-text-center" id="formTitle">Edit
							person</h3>
						<hr class="uk-divider-icon">
						<div class="uk-margin" style="padding: 10px 0px 40px 0px">
							<form:form cssClass="uk-grid-small"
								action="admin/person/edit.htm" method="post"
								modelAttribute="personDTO">

								<div class="row uk-margin">
									<div class="col-sm-1">
										<form:input path="personId" cssClass="uk-input"
											readonly="true" />

									</div>
									<div class="col-sm-4">
										<form:input path="firstName" cssClass="uk-input"
											placeholder="First Name" />
										<form:errors path="firstName" cssClass="uk-alert-danger" />
									</div>
									<div class="col-sm-4">
										<form:input path="lastName" cssClass="uk-input"
											placeholder="Last Name" />
										<form:errors path="lastName" cssClass="uk-alert-danger" />
									</div>
									<div class="col-sm-3" style="padding-top: 10px;">
										<form:radiobutton path="gender" value="true"
											cssClass="uk-radio" />
										Male
										<form:radiobutton path="gender" value="false"
											cssClass="uk-radio" />
										Female
										<form:errors path="gender" cssClass="uk-alert-danger" />
									</div>
								</div>
								<div class="row uk-margin">
									<div class="col-sm-6">
										<form:input path="phoneNum" cssClass="uk-input"
											placeholder="Phone Number" />
										<form:errors path="phoneNum" cssClass="uk-alert-danger" />
									</div>
									<div class="col-sm-6">
										<form:input path="email" cssClass="uk-input"
											placeholder="Email Address" />
										<form:errors path="email" cssClass="uk-alert-danger" />
									</div>
								</div>
								<div class="row uk-margin">
									<div class="col-sm">
										<form:input path="address" cssClass="uk-input"
											placeholder="Address" />
										<form:errors path="address" cssClass="uk-alert-danger" />
									</div>
								</div>
								<div class="row uk-margin">
									<div class="col-sm uk-text-right">
										<button class="uk-button uk-button-primary verve-btn-primary">Save</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>