<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 

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


  <h2>MacBook</h2>

<p style="text-align:justify">
Apple has updated its most attractive laptop yet with an Intel Skylake Core M processor. Still clocking in at 1.1GHz to start, the 2016 MacBook aims at those who don't need power as much as portability and pizazz. The stylish, aluminum unibody design and the Retina display are all back, too. Aside from a 3.5mm headphone jack, the only connector port remains USB-C, though the reversible interface has gained traction since last year's debut. If you're willing to lug cable adapters and take a performance hit in the name of stellar design, the brand new, appetizing Rose Gold finish might be just for you.


</p>
		
		
<img src="mb1.png" width="80%" height="80%">

<img src="mb2.png" width="80%" height="80%">

<img src="mb3.png" width="80%" height="80%">

<img src="mb4.png" width="80%" height="80%">


  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
