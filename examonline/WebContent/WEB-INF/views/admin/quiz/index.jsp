<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Quiz</title>
</head>
<body>
	<div class="uk-container uk-margin">
		<h1 class="uk-heading-line uk-text-center">
			<span>Manage Account Plan</span>
		</h1>
		<div class="row uk-margin-top">
			<div class="col-sm-6">
				<table class="uk-table uk-table-hover uk-table-divider">
					<thead>
						<tr>
							<th>STT</th>
							<th>Student ID</th>
							<th>Student</th>
							<th>Exam Date</th>
							<th>Score</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="quiz" items="${exams}" varStatus="indexQuiz">
							<tr id="${quiz.examId}"
								onclick="updateAccountPlan(${quiz.examId})">
								<td>${indexQuiz.index +1 }</td>
								<td>${quiz.account.userName}</td>
								<td>${quiz.account.person.firstName} ${quiz.account.person.lastName}</td>
								<td>${quiz.dateCreated}</td>
								<td>${quiz.score}</td>
								<td><a uk-icon="icon: trash" style="color: #F93434;"
									uk-tooltip="Move to trash"
									onclick="deleteData(${quiz.examId},'account_quiz')"></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<ul class="uk-pagination uk-flex-center" uk-margin>
						<li><a href="#"><span uk-pagination-previous></span></a></li>
						<li><a href="#">1</a></li>
						<li class="uk-disabled"><span>...</span></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li class="uk-active"><span>7</span></li>
						<li><a href="#">8</a></li>
						<li><a href="#"><span uk-pagination-next></span></a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="uk-margin"></div>
			</div>
		</div>
	</div>
</body>
</html>