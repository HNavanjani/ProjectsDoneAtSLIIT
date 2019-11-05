<?php
session_start();



include_once 'dbconnect.php';

$error = false;

if(!$_SESSION['login']){
   header("location:Sign_In.php");
   die;
}













if (isset($_POST['signup'])) {
	$creditcardno = mysqli_real_escape_string($con, $_POST['creditcardno']);
	$creditcardpin = mysqli_real_escape_string($con, $_POST['creditcardpin']);

	
	
	
	if (!preg_match("/^[0-9]+$/",$creditcardno)) {
		$error = true;
		$creditcardno_error = "<span style='color:red'>Credit Card No must contain only numbers"."<br/>";
	}
	if (!preg_match("/^[0-9]+$/",$creditcardpin)) {
		$error = true;
		$creditcardpin_error = "<span style='color:red'>Credit Card Pin must contain only numbers"."<br/>";
	}
	
	 
	
	
	if (!$error) {
		if(mysqli_query($con, "INSERT INTO billinginfo(CreditCardNo,CreditCardPin) VALUES('" . $creditcardno . "', '" . $creditcardpin . "')")) {
			$successmsg = "Thank You, Your order has been Placed!<a href='bill.php'>Click here to Recieve the Invoice</a>";
		} 
		else {
			$errormsg = "Error in completing...Please try again later!";
		}
	}
	
	
	
	
	
	
}




?>


<?php

include "shoppinghistory.php"

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
		<h3>Please fill your payment information</h3>
<form role="form" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" name="payment">


<div class="imgcontainer">
    <img src="add_user.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
  
    
	
				<fieldset>
					<legend>Step:2</legend>

						<label for="name">Credit Card No</label>
						<input type="text" name="creditcardno" placeholder="Enter Credit Card No" required value="<?php if($error) echo $creditcardno; ?>" class="form-control" />
						<span ><?php if (isset($creditcardno_error)) echo $creditcardno_error; ?></span>
						
					
						<label for="name">Credit Card Pin</label>
						<input type="text" name="creditcardpin" placeholder="Enter Credit Card Pin" required value="<?php if($error) echo $creditcardpin; ?>" class="form-control" />
						<span ><?php if (isset($creditcardpin_error)) echo $creditcardpin_error; ?></span>
						
						
					
						
						
						
						<input type="submit" name="signup" value="Place Order" />

						
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