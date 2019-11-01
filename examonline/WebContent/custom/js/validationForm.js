function validationFormLogin() {
	var username = document.forms["formLogin"]["username"].value;
	var checkUsername =  validateUsername(username);
	if(!checkUsername) {
		
	}
	
	
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