<?php
session_start();
include_once 'dbconnect.php';
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
<meta charset="utf-8"/>
<style>

.btn-group2 .button {
    background-color: #ff9900; 
    border: 1px solid orange;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
    float: left;
	display:inline-block;
}
.btn-group2 .button:not(:last-child) {
    border-right: none; 
}
.btn-group2 .button:hover {
    background-color: #ffbf00;
}
div#el3
{
    position: absolute;
    left: 600px;
    top: 300px;
}

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
<div id="el3">
<a href="resetpw.php"><button id="popUpYesp">Reset Password</button></a>


</div>

<p>Signed in as <?php echo $_SESSION['usr_name']; ?></p>
<img src="loggeduser.png" width="10%" height="10%" ></li>
<br/>
<br/>



</div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>	

</body>
</html>

