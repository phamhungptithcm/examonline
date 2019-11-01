<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Result - ExamOnline</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<table class="uk-table">
			<tr>
				<td width="50%">
					<div class="uk-margin">
						<div
							class="uk-card uk-card-default uk-card-body uk-width-1-1@m verve-margin-top">
							<div class="row">
								<div class="col-md-5">
									<div class="uk-text-middle uk-text-center">
										<div class="verve-scoretitle">Score</div>
										<div class="verve-score">${quizResultDTO.score}</div>
									</div>
								</div>
								<div class="col-md-7">
									<div>
										<ul class="uk-list">
											<li class=""><span uk-icon="icon: info"></span> Total
												number of correct/error answers<span> 10/0</span></li>
											<li class=""><span uk-icon="icon: clock"></span> Total
												times to do lesson <span> ${quizResultDTO.time }
													seconds</span></li>
											<li class=""><span uk-icon="icon: question"></span>Total
												number of questions ignored <span> 0</span></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="uk-margin">
						<div class="uk-text-lighter uk-text-middle">
							<a href="home/index.htm" uk-switcher-item="1"><span
								uk-icon="chevron-left"></span> Back to home</a>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="">
						<span uk-icon="icon:  bookmark"></span> <span>Result</span>
						<hr class="uk-divider-icon">
						<div id="verve-exam-container" class="mx-auto my-5">
							<c:forEach var="resultQuiz"
								items="${quizResultDTO.resultQuizDTOs}" varStatus="indexQ">
								<div class="uk-margin">
									<div class="uk-form-label">
										<span class="verve-index">${indexQ.index+1}. </span>
										${resultQuiz.question.content}
									</div>
								</div>
								<div class="">
									<c:forEach var="answer"
										items="${resultQuiz.question.answerDTOs}" varStatus="indexA">
										<c:choose>
											<c:when
												test="${resultQuiz.question.answerId == answer.answerId }">
												<label> <c:if
														test="${resultQuiz.question.isCorrect == true}">
														<i class="fa fa-check-circle-o" style="color: #00E60F" aria-hidden="true"></i>
														<span class="verve-index"> <c:if
																test="${indexA.index == 0}"> A.</c:if> <c:if
																test="${indexA.index == 1}"> B.</c:if> <c:if
																test="${indexA.index == 2}"> C.</c:if> <c:if
																test="${indexA.index == 3}"> D.</c:if>
														</span> ${answer.content}
													</c:if> <c:if test="${resultQuiz.question.isCorrect == false}">
														<i class="fa fa-times-circle-o" style="color: #F93434" aria-hidden="true"></i>
														<span class="verve-index"> <c:if
																test="${indexA.index == 0}"> A.</c:if> <c:if
																test="${indexA.index == 1}"> B.</c:if> <c:if
																test="${indexA.index == 2}"> C.</c:if> <c:if
																test="${indexA.index == 3}"> D.</c:if>
														</span> ${answer.content}
													</c:if>
												</label><br>
											</c:when>
											<c:otherwise>
												<label><i class="fa fa-circle-thin"
													aria-hidden="true" style="color: #0091FF"></i><span class="verve-index"> <c:if
															test="${indexA.index == 0}"> A.</c:if> <c:if
															test="${indexA.index == 1}"> B.</c:if> <c:if
															test="${indexA.index == 2}"> C.</c:if> <c:if
															test="${indexA.index == 3}"> D.</c:if>
												</span> ${answer.content} </label>
												<br>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</div>
				</td>
			</tr>

		</table>

	</div>

	<script>
		// Initialize the plugin
		const demo = document.querySelector('#verve-exam-container');
		const ps = new PerfectScrollbar(demo);
	</script>
</body>
</html>