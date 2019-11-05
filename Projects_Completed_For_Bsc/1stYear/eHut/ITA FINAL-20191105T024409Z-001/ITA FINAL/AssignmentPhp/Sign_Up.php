<?php
session_start();

if(isset($_SESSION['usr_id'])) {
	header("Location: indexx.php");
}

include_once 'dbconnect.php';

$error = false;

if (isset($_POST['signup'])) {
	$name = mysqli_real_escape_string($con, $_POST['name']);
	$email = mysqli_real_escape_string($con, $_POST['email']);
	$password = mysqli_real_escape_string($con, $_POST['password']);
	$cpassword = mysqli_real_escape_string($con, $_POST['cpassword']);
	
	if (!preg_match("/^[a-zA-Z ]+$/",$name)) {
		$error = true;
		$name_error = "<span style='color:red'>Name must contain only alphabets and space"."</br/>";
	}
	if(!filter_var($email,FILTER_VALIDATE_EMAIL)) {
		$error = true;
		$email_error = "<span style='color:red'>Please Enter Valid Email ID"."</br/>";
	}
	if(strlen($password) < 6) {
		$error = true;
		$password_error = "<span style='color:red'>Password must be minimum of 6 characters"."</br/>";
	}
	if($password != $cpassword) {
		$error = true;
		$cpassword_error = "<span style='color:red'>Password and Confirm Password doesn't match"."</br/>";
	}
	if (!$error) {
		if(mysqli_query($con, "INSERT INTO users(name,email,password) VALUES('" . $name . "', '" . $email . "', '" . md5($password) . "')")) {
			$successmsg = "Successfully Registered! <a href='Sign_In.php'>Click here to Login</a>";
		$_SESSION['login'] = true;
		} 
		else {
			$errormsg = "Error in registering...Please try again later!";
		}
	}		
}
?>
<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
?>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/> 
<title>Online Computer & Mobile Accessories Shop</title>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 
<script src="Form_Validation.js"></script>


<style>

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}


.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}


button {
    background-color:#ff3399;
    color: white;
	font-weight:bold;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.container {
    padding: 16px;
}


.clearfix::after {
    content: "";
    
    display: table;
}


</style>


</head>
<body>
<?php 
include("LogHeader.php"); 
?>
<?php
include "content.php"
?>
    
    <?php 
include("Primarybar.php"); 
?>
    
    <div id="content">
        
		
		<h2>Signup Form</h2>
<form role="form" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" name="signupform">


<div class="imgcontainer">
    <img src="add_user.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
  
    
	
				<fieldset>
					<legend>Sign Up</legend>

						<label for="name">Name</label>
						<input type="text" name="name" placeholder="Enter Full Name" required value="<?php if($error) echo $name; ?>" class="form-control" />
						<span ><?php if (isset($name_error)) echo $name_error; ?></span>
					
						<label for="name">Email</label>
						<input type="text" name="email" placeholder="Email" required value="<?php if($error) echo $email; ?>" class="form-control" />
						<span ><?php if (isset($email_error)) echo $email_error; ?></span>

						<label for="name">Password</label>
						<input type="password" name="password" placeholder="Password" required class="form-control" />
						<span ><?php if (isset($password_error)) echo $password_error; ?></span>

						<label for="name">Confirm Password</label>
						<input type="password" name="cpassword" placeholder="Confirm Password" required class="form-control" />
						<span ><?php if (isset($cpassword_error)) echo $cpassword_error; ?></span>

						<input type="submit" name="signup" value="Sign Up" />
				</fieldset>
			</form>
			<span style='color:green'><?php if (isset($successmsg)) { echo $successmsg; } ?></span>
			<span style='color:red'><?php if (isset($errormsg)) { echo $errormsg; } ?></span>
		
	
		


  </div>
  </form>
  
  				Already Registered? <a href="Sign_In.php">Login Here</a>

    </div>
    
    <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
</body>
</html>