<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
			<tr id="${quiz.examId}" onclick="updateQuiz(${quiz.examId})">
				<td>${indexQuiz.index +1 }</td>
				<td>${quiz.account.userName}</td>
				<td>${quiz.account.person.firstName}
					${quiz.account.person.lastName}</td>
				<td>${quiz.dateCreated}</td>
				<td>${quiz.score}</td>
				<td><a href="admin/quiz/detail.htm?id=${quiz.examId}"
					uk-icon="icon: more" uk-tooltip="View Detail"></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>