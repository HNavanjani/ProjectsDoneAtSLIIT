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


  <h2>Samsung Galaxy S8</h2>

<p  style="text-align:justify">
Samsung has confirmed that it's coming, and online leaks have revealed what we can expect from the Galaxy S8. 
Set to launch on 29 March, the Samsung Galaxy S8 will be the first smartphone to come with Samsung's own artificial intelligence (AI) assistant, called 'Bixby', built in. That won't be its only similarity to the iPhone, as rumour has it that the Galaxy S8 will also dump the headphone jack, in favour of audio over USB-C.
Further speculation points to a 2K-resolution AMOLED Edge display, baked-in IP68 certification, both fingerprint and iris scanners, Qualcomm Snapdragon 835 power and a dual rear-facing camera setup. 

</p>



<img src="sg1.png" width="80%" height="80%">

<img src="sg2.png" width="80%" height="80%">

<img src="sg3.png" width="80%" height="80%">

<img src="sg4.png" width="80%" height="80%">



  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
