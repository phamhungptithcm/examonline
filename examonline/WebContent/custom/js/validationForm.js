function validationFormLogin() {
	var username = document.forms["formLogin"]["username"].value;
	var checkUsername =  validateUsername(username);
	if(!checkUsername) {
		
	}
}
function validationFormSignUp() {
	var error = document.getElementsByClassName("error-massage");
	for(i = 0; i < error.length; i++) {
		document.getElementsByClassName("error-massage")[i].innerHTML = "";
	}
	var isValid = true;
	/*Validate Username*/
	var username = document.forms["formSignup"]["username"].value;
	var checkUsername =  validateUsername(username);
	if(!checkUsername) {
		document.getElementById("username-error").innerHTML = "Enter a valid username";
		isValid = false;
	}
	/*Validate Password*/
	var password = document.forms["formSignup"]["password"].value;
	var checkPassword = validatePassword(password);
	if(!checkPassword) {
		document.getElementById("password-error").innerHTML = "Passwords must be uppercase, lowercase, special characters and at least 8 characters long!";
		isValid = false;
	} else {
		var repassword = document.getElementById("repassword").value;
		if (repassword === "") {
			document.getElementById("repassword-error").innerHTML = "Enter a valid password";
			isValid = false;
		} else if (repassword !== password){
			document.getElementById("repassword-error").innerHTML = "Password doesn't match. Please try again!";
			isValid = false;
		}
	}
	/*Validate Email*/
	var email = document.forms["formSignup"]["email"].value;
	var checkEmail = validateEmail(email);
	if(!checkEmail) {
		document.getElementById("email-error").innerHTML = "Invalid email! Please enter valid email";
		isValid = false;
	}
	/*Validate Phone Number*/
	var phoneNumber = document.forms["formSignup"]["phoneNum"].value;
	var checkPhoneNumber = validatePhone(phoneNumber);
	if(!checkPhoneNumber) {
		document.getElementById("phonenumber-error").innerHTML = "Invalid phone number! Please enter valid phone number";
		isValid = false;
	}
	return isValid;
}

function validateEmail(email) {
    const EMAIL_REGEX =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(EMAIL_REGEX.test(email)) {
        return true;
    }
    return false;
};

function validatePhone(phone) {
    //Bắt đầu 0 + (9, 10) số;
    const PHONE_REGEX = /^0\d{9,10}$/;
    if(PHONE_REGEX.test(phone)) {
        return true;
    }
    return false;
};

function validateUsername(username) {
    // Kiểm tra required
    if (username !== null && username.trim() !== '') {
        return true;
    }
    return false;
};

function validatePassword(password) {
    // Chu thuong, hoa, ki tu dac biet, so toi thieu 8 ki tu
    const PASSWORD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
    if(PASSWORD_REGEX.test(password)) {
        return true;
    }
    return false;
};