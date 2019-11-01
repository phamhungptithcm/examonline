<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Account Overview - ExamOnline</title>
</head>
<body>
	<jsp:include page="accountinfor.jsp"></jsp:include>

	<div class="row verve-margin-top">
		<div class="col-md-4">
			<div class="uk-card uk-card-default uk-card-body uk-width-1-1@m"
				uk-tooltip="Exam information with the highest score">
				<div class="row">
					<div class="col-md-6">
						<h3 class="uk-card-title">Score</h3>
					</div>
					<div class="col-md-6 uk-text-right">
						<h3 class="uk-card-title">10</h3>
					</div>
				</div>
				<ul class="uk-list">
					<li class=""><span uk-icon="icon: info"></span> Total number
						of correct/error answers<span class=""> 10/0</span></li>
					<li class=""><span uk-icon="icon: clock"></span> Total times
						to do lesson <span> 100 seconds</span></li>
					<li class=""><span uk-icon="icon: question"></span>Total
						number of questions ignored <span> 0</span></li>
				</ul>
			</div>
		</div>
		<div class="col-md-8">
			<h5 class="uk-card-title">
				<span uk-icon="icon: history"></span> Recent History
			</h5>
			<div id="verve-history-container" class="mx-auto my-5">
				<div class="verve-timeline">
					<ul id="verve-timeEntity">
						<div class="verve-subtimeline verve-accountCurrent">
							<span class="verve-dotStatus"></span>
							<div class="verve-itemDetail">
								<div class="verve-acContent">
									<table style="width: 100%">
										<colgroup>
											<col width="100px">
											<col width="auto">
										</colgroup>
										<tbody>
											<tr>
												<td>Now</td>
												<td>Account currently in session</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<c:forEach var="exam" items="${exams}">
							<li><span class="verve-timelineHeader">${exam.strStartDate}</span>
								<div class="verve-subtimeline">
									<ul>
										<c:forEach var="examDetail" items="${exam.examDetails}">
											<li class="verve-itemDetail"><table style="width: 100%">
													<colgroup>
														<col width="100px">
														<col width="auto">
														<col width="100px">
													</colgroup>
													<tbody>
														<tr>
															<td>${examDetail.startTime }</td>
															<td><a class="uk-link-reset"
																href="account-management/exam-result.htm?examId=${examDetail.examId}">${examDetail.examName}</a></td>
															<td style="color: #000000">${examDetail.score}<i
																class="fa fa-star" aria-hidden="true"
																style="color: yellow;"></i></td>
														</tr>
													</tbody>
												</table></li>
										</c:forEach>
									</ul>
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script>
		// Initialize the plugin
		const demo = document.querySelector('#verve-history-container');
		const ps = new PerfectScrollbar(demo);
	</script>
</body>
</html>