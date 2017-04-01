<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js"></script>
<title>Menu</title>
</head>
<style type="text/css">
	.logout,.login {
		margin-left: 10px;
		margin-right: 10px;
	}
	#role {
		width: 173px;
		height: 30px;
	}
	.links {
		margin-left: 30px;
	}
</style>
<script type="text/javascript">
	function check() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var role = document.getElementById("role").value;

		if (username == '') {
			document.getElementById("usernamespan").innerHTML = "Please Enter UserName";
			return false;
		} else {
			document.getElementById("usernamespan").innerHTML = "";
		}
		if (password == '') {
			document.getElementById("passwordspan").innerHTML = "Please Enter Password";
			return false;
		} else {
			document.getElementById("passwordspan").innerHTML = "";
		}
		if (role == 'chooseyourrole') {
			document.getElementById("rolespan").innerHTML = "Please Choose your role";
			return false;
		} else {
			document.getElementById("rolespan").innerHTML = "";
		}

		return true;
	}
	function clean() {
		document.getElementById("username").value = '';
		document.getElementById("password").value = '';
		document.getElementById("role").value = 'chooseyourrole';

	}
</script>
<body>
	<div class="login">
		<form action="login.htm" method="post" target="contents"
			onsubmit="return check()">
			<br>
			<input type="text" name="username" id="username"
				value="${cookie.username.value}" placeholder="Username"/><br /> <span id="usernamespan"
				style="color: red"></span><br /> 
			<input type="password"
				name="password" id="password" value="${cookie.password.value}" placeholder="Password"/><br />
			<span id="passwordspan" style="color: red"></span><br /> 
			<select name="role" id="role">
				<option value="chooseyourrole">Choose Your Role</option>
				<option value="buyer">Buyer</option>
				<option value="seller">Seller</option>
			</select><br /> <span id="rolespan" style="color: red"></span><br /> 
			<br>
			<br>
			<input type="submit" value="Sign In" class="btn btn-primary btn-block btn-signin"/>&nbsp<br /> <br />
		</form>
	</div>
	<div class="logout">
		<form action="logout.htm" method="post" target="contents">
			<!-- <button name="action" value="logout">Log Out</button><br/><br/> -->
			<input type="submit" value="Sign Out" onclick="clean()" class="btn btn-primary btn-block"/><br /> <br />
		</form>
	</div>
	<div class="links">
		<a href="addselleruser.htm" target="contents">Register As A Seller</a>
		<br /> <br /> 
		<a href="addbuyeruser.htm" target="contents">Register As A Buyer</a> <br /> <br /> 
		<a href="manageuser.htm" target="contents">System Administrator</a>
	</div>
</body>
</html>