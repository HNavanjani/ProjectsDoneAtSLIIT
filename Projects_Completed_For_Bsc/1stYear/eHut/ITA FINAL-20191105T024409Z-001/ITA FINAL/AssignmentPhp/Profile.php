<?php
session_start();


include_once 'dbconnect.php';

if (isset($_POST['login'])) {

	$email = mysqli_real_escape_string($con, $_POST['email']);
	$password = mysqli_real_escape_string($con, $_POST['password']);
	$result = mysqli_query($con, "SELECT * FROM users WHERE email = '" . $email. "' and password = '" . md5($password) . "'");

	if ($row = mysqli_fetch_array($result)) {
		$_SESSION['usr_id'] = $row['id'];
		$_SESSION['usr_name'] = $row['name'];
		header("Location: indexx.php");
	} else {
		$errormsg = "Incorrect Email or Password!!!";
	}
}
?>
<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
?>


<?php
if(!$_SESSION['login']){
   header("location:Sign_In.php");
   die;
}
?>








<?php   
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
 if(isset($_POST["add_to_cart"]))  
 {  
      if(isset($_SESSION["shopping_cart"]))  
      {  
           $item_array_id = array_column($_SESSION["shopping_cart"], "item_id");  
           if(!in_array($_GET["id"], $item_array_id))  
           {  
                $count = count($_SESSION["shopping_cart"]);  
                $item_array = array(  
                     'item_id'               =>     $_GET["id"],  
                     'item_name'               =>     $_POST["hidden_name"],  
	                 'description'               =>     $_POST["hidden_description"],  
				 
                     'item_price'          =>     $_POST["hidden_price"],  
                     'item_quantity'          =>     $_POST["quantity"]  
                );  
                $_SESSION["shopping_cart"][$count] = $item_array;  
           }  
           else  
           {  
                echo '<script>alert("Item Already Added")</script>';  
                echo '<script>window.location="mycart.php"</script>';  
           }  
      }  
      else  
      {  
           $item_array = array(  
                'item_id'               =>     $_GET["id"],  
                'item_name'               =>     $_POST["hidden_name"], 
                'item_description'               =>     $_POST["hidden_description"],  
				
                'item_price'          =>     $_POST["hidden_price"],  
                'item_quantity'          =>     $_POST["quantity"]  
           );  
           $_SESSION["shopping_cart"][0] = $item_array;  
      }  
 }  
 if(isset($_GET["action"]))  
 {  
      if($_GET["action"] == "delete")  
      {  
           foreach($_SESSION["shopping_cart"] as $keys => $values)  
           {  
                if($values["item_id"] == $_GET["id"])  
                {  
                     unset($_SESSION["shopping_cart"][$keys]);  
                     echo '<script>alert("Item Removed")</script>';  
                     echo '<script>window.location="mycart.php"</script>';  
                }  
           }  
      }  
 }  
 
 
 
 
 ?>
 




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 
<style>
#popUpYesp
{
  width: 200px;
  height: 30px;
  background-color: #ff0066;
  border-radius: 12px;
  font-weight:bold;
}
#popUpYesp:hover
{
  background-color: #ff80b3;
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




<div id="content" >	



  <h1>Welcome <?php echo $_SESSION['usr_name']; ?> !</h1>
  
<a href="indexx.php"><button id="popUpYesp">Edit Profile</button></a>
<a href="purchasehistory.php"><button id="popUpYesp" name="history">View P History</button></a>




<br/>
  <h2>Checkout the....</h2>
  
  
 <img src="Premium.png">
 <?php
 include("Premium.php");
 ?>
  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
