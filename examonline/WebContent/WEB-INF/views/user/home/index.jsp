<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
							<h3 class="uk-card-title uk-text-center">Please choose level</h3>
							<hr class="uk-divider-icon">
							<form>
								<div class="uk-margin">
									<div class="uk-grid-small uk-child-width-auto uk-grid verve-margin-label">
										<label><input class="uk-radio" type="radio"
											name="level" checked> Easy</label> <label><input
											class="uk-radio" type="radio" name="level"> Medium</label> <label><input
											class="uk-radio" type="radio" name="level"> Hard</label>
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
</body>
</html>