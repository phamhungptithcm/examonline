<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Quiz</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<h1 class="uk-heading-line uk-text-center">
			<span>Manage Quiz</span>
		</h1>
		<div class="row uk-margin-top">
			<div class="col-sm-6">
				<div class="uk-margin-top">
					<div id="result"></div>
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
									Quiz</h3>
								<hr class="uk-divider-icon">
								<div class="uk-margin" style="padding: 10px 0px 40px 0px">
									<form class="uk-grid-small" id="accForm"
										action="admin/quiz/update.htm" method="post" uk-grid>
										<div class="uk-width-1-4@s">
											<input id="examId" name="examId" class="uk-input" type="text"
												readonly="readonly" placeholder="Exam ID">
										</div>
										<div class="uk-width-1-4@s">
											<input id="score" name="score" class="uk-input" type="number"
												placeholder="Score">
										</div>
										<div class="uk-width-1-1@s">
											<textarea class="uk-textarea" rows="5" name="comment"
												placeholder="Comment *" required="required"></textarea>
										</div>
										<div class="uk-width-1-1@s">
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
	<script type="text/javascript" src="custom/js/panigationQuiz.js">
	</script>
</body>
</html>