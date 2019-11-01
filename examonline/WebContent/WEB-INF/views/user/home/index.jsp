<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home - ExamOnline</title>
</head>
<body>
	<div class="uk-section uk-flex uk-flex-middle uk-animation-slide-top">
		<div class="uk-width-1-1">
			<div class="uk-container">
				<div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
					<div class="uk-width-1-1@m">
						<div
							class="uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large">
							<h3 class="uk-card-title uk-text-center">Please choose
								subject</h3>
							<hr class="uk-divider-icon">
							<form action="exam/to-do.htm" method="post">
								<div class="uk-margin">
									<div
										class="uk-grid-small uk-child-width-auto uk-grid verve-margin-label">
										<c:forEach var="subject" items="${subjects}">
											<label><input class="uk-radio" type="radio"
												name="subject" id="${subject.key }" value="${subject.key }">
												<span> ${subject.value}</span></label>
										</c:forEach>
									</div>
								</div>
								<div class="uk-margin">
									<button
										class="uk-button uk-button-primary uk-width-1-1 verve-btn-success">Start</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById("1").checked = true;
	</script>
</body>
</html>