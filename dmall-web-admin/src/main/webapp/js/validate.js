//验证邮箱格式
function checkEmail(email) {
	var validateEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return (validateEmail.test(email));
}
//判断密码的强弱
function checkPasswordLevel(password){
	var weak = /^\d+$/;
	if(weak.test(password)){
		return 1;
	}
	var average = /^[A-Za-z]+$/;
	if(average.test(password)){
		return 2;
	}
	var strong = /\d+/g;
	if (strong.test(password) && !weak.test(password)&& !average.test(password)) {
		return 3;
	}
	return 1;
}
//判断手机号格式是否正确
function checkMobile(str) {
	var re = /^1\d{10}$/;
	if (re.test(str)) {
		return true;
	}
	return false;
}

function checkTel(str){
	if(/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(str)){
		return true;
	} 
	return false;
}
