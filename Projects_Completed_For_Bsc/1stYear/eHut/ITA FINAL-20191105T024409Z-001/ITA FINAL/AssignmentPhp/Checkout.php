<?php
session_start();



include_once 'dbconnect.php';

$error = false;


if(!$_SESSION['login']){
   header("location:Sign_In.php");
   die;
}


if (isset($_POST['signup'])) {
	$name = mysqli_real_escape_string($con, $_POST['name']);
	$address = mysqli_real_escape_string($con, $_POST['address']);
	$zip = mysqli_real_escape_string($con, $_POST['zip']);
	$email = mysqli_real_escape_string($con, $_POST['email']);
	

	
	if (!preg_match("/^[a-zA-Z ]+$/",$name)) {
		$error = true;
		$name_error = "<span style='color:red'>Name must contain only alphabets and space"."<br/>";
	}
	if (!preg_match("/^[0-9a-zA-Z]+$/",$address)) {
		$error = true;
		$address_error = "<span style='color:red'>Address must contain only alphabets and numbers"."<br/>";
	}
	 
	if (!preg_match("/^[0-9]+$/",$zip)) {
		$error = true;
		$zip_error = "<span style='color:red'>Zip Code must contain only numbers"."<br/>";
	}
	 
	if(!filter_var($email,FILTER_VALIDATE_EMAIL)) {
		$error = true;
		$email_error = "<span style='color:red'>Please Enter Valid Email ID"."<br/>";
	}
	
	if (!$error) {
		if(mysqli_query($con, "INSERT INTO users(name,Address,ZipCode,email) VALUES('" . $name . "', '" . $address . "','" . $zip . "','" . $email . "' )")) {
			$successmsg = "Successfully Completed! <a href='checkoutpayment.php'>Click here to Enter Your Payment Details</a>";

		} else {
			$errormsg = "Error in completing...Please try again later!";
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
<script src="CForm_Validation.js"></script>


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
        
		
		<h2>Checkout</h2>
		<h3>Where would you like the order shipped to ?</h3>
<form role="form" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" name="signupform">


<div class="imgcontainer">
    <img src="add_user.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
  
    
	
				<fieldset>
					<legend>Step:1</legend>

						
						<label for="name"> Name</label>
						<input type="text" name="name" placeholder="Enter Name" required value="<?php if($error) echo $name; ?>" class="form-control" />
						<span ><?php if (isset($name_error)) echo $name_error; ?></span>
						
						
						<label for="name">Address</label>
						<input type="text" name="address" placeholder="Enter Address" required value="<?php if($error) echo $address; ?>" class="form-control" />
						<span ><?php if (isset($address_error)) echo $address_error; ?></span>
						
						
						<label for="name">Zip Code</label>
						<input type="text" name="zip" placeholder="Enter Zip Code" required value="<?php if($error) echo $zip; ?>" class="form-control" />
						<span ><?php if (isset($zip_error)) echo $zip_error; ?></span>
						
					
						<label for="name">Email</label>
						<input type="text" name="email" placeholder="Email" required value="<?php if($error) echo $email; ?>" class="form-control" />
						<span ><?php if (isset($email_error)) echo $email_error; ?></span>

						
						<input type="submit" name="signup" value="Submit" />
				</fieldset>
			</form>
			
		


  </div>
  </form>
  
  				<span style='color:green'><?php if (isset($successmsg)) { echo $successmsg; } ?></span>
			<span style='color:red'><?php if (isset($errormsg)) { echo $errormsg; } ?></span>
		
	
    </div>
    
    <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
</body>
</html>