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



</style>
</head>
<body>




<div class="btn-group2">

   <a href="mycart.php"><button class="button">Dell</button></a>
  <a href="mycart2.php"><button class="button">Asus</button></a>
  <a href="mycart3.php"><button class="button">Apple</button></a>
  <a href="mycart4.php"><button class="button">Samsung</button></a>
  <a href="mycart5.php"><button class="button">Lenovo</button></a>
  <a href="mycart6.php"><button class="button">Microsoft</button></a>
  <a href="mycart7.php"><button class="button">Toshiba</button></a>
  <a href="mycart8.php"><button class="button">Alcatel</button></a>
  <a href="mycart9.php"><button class="button">Acer</button></a>
  <a href="mycart10.php"><button class="button">Oppo</button></a>
  <a href="mycart11.php"><button class="button">Apple iphones</button></a>
  <a href="mycart12.php"><button class="button">HP</button></a>
  <a href="mycart13.php"><button class="button">Google</button></a>
  <a href="mycart14.php"><button class="button">OnePlus</button></a>
  <a href="mycart15.php"><button class="button">Huawei</button></a>
  <a href="mycart16.php"><button class="button">LG</button></a>
  <a href="mycart17.php"><button class="button">HTC</button></a>
  <a href="mycart18.php"><button class="button">Sony</button></a>


 


  
  	  


</div>
  
</body>
</html>
