<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Question Edit</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<div class="uk-margin">
			<div class="uk-child-width-1-1@s uk-grid-match" uk-grid>

				<div class="uk-card uk-card-default uk-card-hover uk-card-body">
					<form:form cssClass="uk-grid-small"
						action="admin/question/edit.htm" method="post"
						modelAttribute="question">
						<div class="row">
							<div class="col-sm-6">
								<h3 class="uk-card-title uk-text-center" id="formTitle">Edit
									Question</h3>
								<hr class="uk-divider-icon">
								<div class="uk-margin" style="padding: 10px 0px 40px 0px">
									<div class="row uk-margin">
										<div class="col-sm-2">
											<form:input path="questionId" cssClass="uk-input"
												readonly="true" />
										</div>
										<div class="col-sm-4">
											<form:input path="createdBy" cssClass="uk-input"
												readonly="true" />
										</div>
										<div class="col-sm-4">
											<form:select path="level" cssClass="uk-select">
												<form:options items="${subjects}" />
											</form:select>
										</div>
										<div class="col-sm-2 verve-checkbox-middle">
											<form:checkbox path="isActive" cssClass="uk-checkbox" />
											Active
										</div>
									</div>
									<div class="uk-margin">
										<form:textarea path="Content" cssClass="uk-textarea"
											placeholder="Content*" rows="5" />
										<form:errors path="content" cssClass="uk-alert-danger" />
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<h3 class="uk-card-title uk-text-center" id="formTitle">Edit
									Answer</h3>
								<hr class="uk-divider-icon">
								<div class="uk-margin" style="padding: 10px 0px 40px 0px">
									<div class="uk-margin verve-inline-flex">
										<form:input path="anwsers[0].anwserId" cssClass="uk-input"
											cssStyle="width: 40px;margin-right: 5px; padding: 14px;"
											readonly="true" />
										</span>
										<form:input path="anwsers[0].content" cssClass="uk-input" />
										<span class="verve-checkbox-middle"
											uk-tooltip="Set this answer to true"> <form:checkbox
												path="anwsers[0].status" cssClass="uk-checkbox" />
										</span>
										<form:errors path="anwsers[0].content"
											cssClass="uk-alert-danger" />
									</div>
									<div class="uk-margin verve-inline-flex">
										<form:input path="anwsers[1].anwserId" cssClass="uk-input"
											cssStyle="width: 40px;margin-right: 5px; padding: 14px;"
											readonly="true" />
										<form:input path="anwsers[1].content" cssClass="uk-input" />
										<span class="verve-checkbox-middle"
											uk-tooltip="Set this answer to true"> <form:checkbox
												path="anwsers[1].status" cssClass="uk-checkbox" />
										</span>
										<form:errors path="anwsers[1].content"
											cssClass="uk-alert-danger" />
									</div>
									<div class="uk-margin verve-inline-flex">
										<form:input path="anwsers[2].anwserId" cssClass="uk-input"
											cssStyle="width: 40px;margin-right: 5px; padding: 14px;"
											readonly="true" />
										<form:input path="anwsers[2].content" cssClass="uk-input" />
										<span class="verve-checkbox-middle"
											uk-tooltip="Set this answer to true"> <form:checkbox
												path="anwsers[2].status" cssClass="uk-checkbox" />
										</span>
										<form:errors path="anwsers[2].content"
											cssClass="uk-alert-danger" />
									</div>
									<div class="uk-margin verve-inline-flex">
										<form:input path="anwsers[3].anwserId" cssClass="uk-input"
											cssStyle="width: 40px;margin-right: 5px; padding: 14px;"
											readonly="true" />
										<form:input path="anwsers[3].content" cssClass="uk-input" />
										<span class="verve-checkbox-middle"
											uk-tooltip="Set this answer to true"> <form:checkbox
												path="anwsers[3].status" cssClass="uk-checkbox" />
										</span>
										<form:errors path="anwsers[3].content"
											cssClass="uk-alert-danger" />
									</div>
								</div>
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
</body>
</html>