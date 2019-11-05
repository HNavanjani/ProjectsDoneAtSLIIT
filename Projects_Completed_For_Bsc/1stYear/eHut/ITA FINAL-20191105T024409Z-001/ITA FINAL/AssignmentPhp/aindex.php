<?php
session_start();
include_once 'dbconnect.php';
?>

<?php
if(!$_SESSION['adlogin']){
   header("location:adminlog.php");
   die;
}
?>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
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

#popUpYes
{
  width: 60px;
  height: 30px;
  background-color: #ff8000;
  border-radius: 12px;
  font-weight:bold;
  
}
#popUpYes:hover
{
  background-color: #ff0000;
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
<div id="el3">
<br/>
<a href="producthandling.php"><button id="popUpYesp">Product Handling</button></a>

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

