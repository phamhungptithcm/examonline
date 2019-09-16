<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reset Password - ExamOnline</title>
</head>
<body>
	<div class="uk-section uk-flex uk-flex-middle uk-animation-slide-top">
		<div class="uk-width-1-1">
			<div class="uk-container">
				<div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
					<div class="uk-width-1-1@m">
						<div
							class="uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large">
							<h3 class="uk-card-title uk-text-center">Enter a new
								password</h3>
							<hr class="uk-divider-icon">
							<form action="account/account-log.htm?reset" method="post">
								<div class="uk-margin">
									<div class="uk-inline uk-width-1-1">
										<span class="uk-form-icon" uk-icon="icon: lock"></span>
										<form:input path="password" class="uk-input uk-form-large"
											type="password" placeholder="Password" />
									</div>
								</div>
								<div class="uk-margin">
									<div class="uk-inline uk-width-1-1">
										<span class="uk-form-icon" uk-icon="icon: lock"></span>
										<form:input path="password" class="uk-input uk-form-large"
											type="password" placeholder="Confirm Password" />
									</div>
								</div>
								<div class="uk-margin">
									<button
										class="uk-button uk-button-primary uk-width-1-1 verve-btn-success">Save</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>