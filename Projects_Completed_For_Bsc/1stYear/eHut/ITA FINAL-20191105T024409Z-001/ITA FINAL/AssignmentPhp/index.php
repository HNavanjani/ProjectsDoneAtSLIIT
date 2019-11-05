<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
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

<?php 
include("Header.php"); 
?>
<?php
include "content.php"
?>

<img src="innovation.jpg" width ="100%" height ="100%" align="center">

<div class="btn-group2">

   <button class="button">Dell</button>
  <button class="button">Asus</button>
  <button class="button">Apple</button>
  <button class="button">Samsung</button>
  <button class="button">Lenovo</button>
  <button class="button">Microsoft</button>
  <button class="button">Toshiba</button>
  <button class="button">Alcatel</button>
  <button class="button">Micromax&nbsp;&nbsp;&nbsp;&nbsp;</button>
  <button class="button">MotorolaMoto</button>
  <button class="button">Fone</button>
  <button class="button">Google</button>
  <button class="button">OnePlus</button>
  <button class="button">Huawei</button>
  <button class="button">LG</button>
  <button class="button">HTC</button>
  <button class="button">Sony</button>
  <button class="button">DigitalStorm</button>


  
  	  


</div>
  
</body>
</html>
