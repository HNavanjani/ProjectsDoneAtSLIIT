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


 
 <h2><center>ABOUT US</center></h2>
 <p   style="text-align:justify">
<h4>OUR VISSION AND MISSION :</h4>
Our vission is to become one of the top computer and mobile
accessories providers in Sri Lankan market  and achieve highest
ratings in customers satisfaction. We are likely to provide 
our customers with a reliable and professional service with 
different branded computer and mobile accessories.
</p>
<p style="text-align:justify">
<h4>WHAT DO WE DO?</h4>
MobileShop gives you a chance to quickly and easily find the phone you want and have it delivered to your home in no time, regardless of your location, as long as it is in Sri Lanka.
</p>
<p style="text-align:justify">
<h4>WHY DO CUSTOMERS LOVE US?</h4>
We have been in the business for quite a while now, and it that time we have not only managed to make close relationships with numerous suppliers all over the world, but also to recognize what people need. This means that we are always able to offer all the latest products, great prices, reliable service, fast delivery and premium customer support.
</p>




<br/>
<br/>

<h4>COMPANY DETAILS</h4>
<p style="text-align:justify">
<b>Company Name</b>
<br/>
ehut 
Online Computer and Mobile Accessories Shop
<br/>
<b>Our email</b>
<br/>
service@ehut.com
<br/>
<b>Contact Us</b>
<br/>
(855)906-9121
<br/>
<b>Our Bank Details</b>
<br/>
Bank : Community One<br/>
Account Name:ehut online store<br/>
Account No:223 242 26<br/>
</p>

  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
