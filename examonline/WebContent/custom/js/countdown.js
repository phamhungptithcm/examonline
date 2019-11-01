var timer = document.getElementById("countdown");

var counter = 0;
var timeleft = 10;
function setTimeLeft(time) {
	timeleft = time;
}
function nf(number) {
	return (number < 10 ? '0' : '') + number
}
function convertSeconds(s) { 
	var minutes = Math.floor(s / 60);
	var hours = Math.floor(minutes / 60);
	var seconds = s % 60;
	if(hours <= 0) {
		return nf(minutes) + ":" + nf(seconds);
	} else {
		return nf(hours) +":" + nf(minutes) + ":" + nf(seconds);
	}
	
}

timer.innerHTML = convertSeconds(timeleft - counter);
function timeIt() {
	counter++;
	timer.innerHTML = convertSeconds(timeleft - counter);
	if(counter == timeleft) {
		var url= "exam/submit-quiz.htm"; 
	    window.location = url; 
	}
}
setInterval(timeIt, 1000);