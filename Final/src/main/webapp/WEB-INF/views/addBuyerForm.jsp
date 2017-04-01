<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>Add Buyer</title>
</head>
<script type="text/javascript">
	var xmlHttp = GetXmlHttpObject();
	function getUser() {
		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;
		}
		var username = document.getElementById("username").value;
		var query = "name=" + username;
		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {
				document.getElementById("usernamespan").innerHTML = xmlHttp.responseText;
			}
		}
		xmlHttp.open("POST", "getbuyer.htm", true);
		xmlHttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlHttp.send(query);
	}

	function GetXmlHttpObject() {
		var xmlHttp = null;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}

	function formatCheck() {

		var pattern = /^[0-9a-zA-Z]*$/;
		var patternnum = /^[0-9]*$/;
		var patternemail = /^[0-9a-zA-Z@.-_]*$/;

		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var phonenumber = document.getElementById("phonenumber").value;
		var email = document.getElementById("email").value;

		if (!username.match(pattern) || !password.match(pattern)
				|| !phonenumber.match(patternnum) || !email.match(patternemail)) {
			alert("Correct Format Needed!");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
body, html {
	height: 100%;
	background-repeat: no-repeat;
	background-color: #d3d3d3;
	font-family: 'Oxygen', sans-serif;
}

.main {
	margin-top: 70px;
}

h1.title {
	font-size: 50px;
	font-family: 'Passion One', cursive;
	font-weight: 400;
}

hr {
	width: 10%;
	color: #fff;
}

.form-group {
	margin-bottom: 15px;
}

label {
	margin-bottom: 15px;
}

input, input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 330px;
	padding: 40px 40px;
}

</style>
<body>
    <div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Register a New Buyer</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form:form class="form-horizontal" method="post" action="addbuyeruser.htm" commandName="buyerUser"
					onsubmit="return formatCheck()" >
						
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon" ><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" onblur="getUser()"
									path="username" name="username" id="username"  placeholder="Enter your Username"/>
									
								</div>
								<span id="usernamespan" style="color: red"></span>
								<font color="red"><form:errors path="username" /></font>
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<form:input type="password" class="form-control" path="password"
									name="password" id="password"  placeholder="Enter your Password"/>
									
								</div>
								<font color="red"><form:errors path="password" /></font>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="email"
									name="email" id="email"  placeholder="Enter your Email"/>
									
								</div>
								<font color="red"> <form:errors path="email" /></font>
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Phone Number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-phone-square fa-lg" aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="phonenumber" path="phoneNumber"
									id="phonenumber"  placeholder="Enter your Phone Number"/>
									
								</div>
								<font color="red"> <form:errors path="phoneNumber" /></font>
							</div>
						</div>

						<div class="form-group ">
							<input type="submit" value="Register" class="btn btn-primary btn-lg btn-block login-button" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>