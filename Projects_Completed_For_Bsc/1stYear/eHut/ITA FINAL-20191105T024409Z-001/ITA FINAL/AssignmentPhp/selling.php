<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 

<style type="text/css">
a.define:link {
    text-decoration: none;
	color: black;

}

a.define:visited {
    text-decoration: none;
	color: black;

}

a.define:hover {
    text-decoration: none;
	color: black;

}

a.define:active {
    text-decoration: none;
	color: black;

}
</style>


</head>
<body>
<?php 
include("Header.php"); 
?>
<?php
include "content.php"
?>
<?php 
include("Primarybar.php"); 
?>


<div id="content" >	


  <h4>Please login in to continue....</h4>
		
		<h2><a href="Sign_Up.php">Sign Up Now !</h2></a>
		<br/>
		<br/>
		<br/>
		<h4>Already have an account ? </h4><a href="Sign_In.php"><h2>Login here</a></h2>
		
		<br/>
		<br/>
		<br/>
		
		<img src="payments.png">
		

  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
