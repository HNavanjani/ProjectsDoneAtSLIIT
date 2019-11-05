<?php
session_start();
?>
<?php
$link=mysqli_connect("localhost","root","");
mysqli_select_db($link,"newehutdb1");
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
<!DOCTYPE html>
<html>
<head>
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
<title></title>
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
<form name="formp" action="" method="post">
<table>

<tr>
<td>Enter Current Password</td>
<td><input type="password" name="t1"></td>
</tr>
<tr>
<td>Enter New Password</td>
<td><input type="password" name="t2"></td>
</tr>


<tr>
<td><input type="submit" name="submitp" value="Update Password"id="popUpYesp">



</td>
</tr>
</table>
<a href='Sign_In.php'>Click here to Sign in with your new password</a>";
</form>

<?php


if(isset($_POST["submitp"]))
{
	mysqli_query($link,"update users set password ='$_POST[t2]'where password='$_POST[t1]' ");
	
}
	
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

