<?php
session_start();

if(isset($_SESSION['usr_id'])!="") {
	header("Location: Profile.php");
}

include_once 'dbconnect.php';

if (isset($_POST['login'])) {

	$email = mysqli_real_escape_string($con, $_POST['email']);
	$password = mysqli_real_escape_string($con, $_POST['password']);
	$result = mysqli_query($con, "SELECT * FROM users WHERE email = '" . $email. "' and password = '" . md5($password) . "'");

	if ($row = mysqli_fetch_array($result)) {
		$_SESSION['usr_id'] = $row['id'];
		$_SESSION['usr_name'] = $row['name'];
		header("Location: Profile.php");
		$_SESSION['login'] = true;

	} else {
		$errormsg = "Incorrect Email or Password!!!";
	}
}
?>





<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 


<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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



.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}




</style>


</head>
<body>
<?php 
include("LogHeader.php"); 
?>
<?php 
include("Primarybar.php"); 
?>


<div id="content" >	


 <h1>Login Form</h1>

    <form role="form" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" name="loginform">
  <div class="imgcontainer">
    <img src="users.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
					
						<label for="name">Email</label>
						<input type="text" name="email" placeholder="Your Email" required class="form-control" />

						<label for="name">Password</label>
						<input type="password" name="password" placeholder="Your Password" required class="form-control" />

						<input type="submit" name="login" value="Login" class="btn btn-primary" />
						
						
	
			</form>
			<span ><?php if (isset($errormsg)) { echo $errormsg; } ?></span>
		New User? <a href="Sign_Up.php">Sign Up Here</a>
  </div>

  
</form>
		
		
		
  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
