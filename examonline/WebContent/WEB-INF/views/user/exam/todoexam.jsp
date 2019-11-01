<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="resultDTO"
	value="${sessionScope['scopedTarget.resultService']}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>To Do - ExamOnline</title>

</head>
<body>
	<div class="uk-container uk-margin">
		<table class="uk-table">
			<tr>
				<td width="60%"><div class="">
						<div>
							<div class="row">
								<div class="col-3">
									<span uk-icon="icon:  bookmark"></span> <span>Reading
										Section</span>
								</div>
								<div class="col-9"></div>
							</div>
							<hr class="uk-divider-icon">
							<p class="verve-card-title uk-text-center">You will read 10
								sentences. Choose the best word or phrase that best completes
								each sentence</p>
						</div>

						<div id="verve-exam-container" class="mx-auto my-5">
							<form action="#" method="post">
								<c:forEach var="question" items="${questions}"
									varStatus="indexQ">
									<div class="uk-margin">
										<div class="uk-form-label">
											<span class="verve-index">${indexQ.index+1}. </span>
											${question.content}
										</div>
										<c:forEach var="answer" items="${question.anwsers}"
											varStatus="indexA">
											<div class="uk-form-controls">
												<label><input class="uk-radio" type="radio"
													name="${question.questionId}" value="${answer.anwserId}"
													onclick="updateResult(${question.questionId}, ${answer.anwserId})">
													<span class="verve-index"> <c:if
															test="${indexA.index == 0}"> A.</c:if> <c:if
															test="${indexA.index == 1}"> B.</c:if> <c:if
															test="${indexA.index == 2}"> C.</c:if> <c:if
															test="${indexA.index == 3}"> D.</c:if>
												</span>${answer.content}</label><br>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</form>
						</div>
					</div></td>
				<td width="40%"><div class="">
						<div class="row">
							<div class="col">
								<span uk-icon="icon: print"></span> <span> The answer has
									been selected</span>
							</div>
							<div class="col uk-text-right">
								<span uk-icon="icon: clock"></span> <span> Section time
									left: <span id="countdown">0</span>
								</span>
							</div>
						</div>
						<hr class="uk-divider-icon">
						<div class="row uk-margin">
							<div class="col">
								<p>
									<label>Fullname: ${infoDTOGlobal.fullName} </label>
								</p>
								<p>
									<label>Date of Birth: ${infoDTOGlobal.dateOfBirth}</label>
								</p>
							</div>
							<div class="col verve-padding-left">
								<p>
									<label>Subject: ${subject}</label>
								</p>

								<p>
									<label>Date of Test: 28/08/2019</label>
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm">
								<c:forEach var="question" items="${questions}"
									varStatus="indexQ" begin="0" end="4">
									<div class="uk-margin verve-anwserselected">
										<label><span class="verve-index">${indexQ.index+1}.
										</span></label>
										<c:forEach var="answer" items="${question.anwsers}"
											varStatus="indexA">
											<span><label><i id="${answer.anwserId}"
													class="fa fa-circle-thin ${question.questionId}-display"></i></label> </span>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
							<div class="col-sm verve-padding-left">
								<c:forEach var="question" items="${questions}"
									varStatus="indexQ" begin="5" end="10">
									<div class="uk-margin verve-anwserselected">
										<label><span class="verve-index">${indexQ.index+1}.
										</span></label>
										<c:forEach var="answer" items="${question.anwsers}"
											varStatus="indexA">
											<span><label><i id="${answer.anwserId}"
													class="fa fa-circle-thin ${question.questionId}-display"></i></label> </span>
										</c:forEach>
									</div>
								</c:forEach>
							</div>

						</div>
						<div class="uk-margin verve-right">
							<a class="uk-button uk-button-primary verve-btn-primary"
								href="exam/submit-quiz.htm">Submit</a>
						</div>
					</div></td>
			</tr>
		</table>

	</div>
	<script type="text/javascript" src="custom/js/ajax.js"></script>
	<script>
		// Initialize the plugin
		const demo = document.querySelector('#verve-exam-container');
		const ps = new PerfectScrollbar(demo);
	</script>
	<script src="custom/js/countdown.js"></script>
</body>
</html>