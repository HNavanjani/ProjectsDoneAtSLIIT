
<?php
session_start();
?>

<?php
$link=mysqli_connect("localhost","root","");
mysqli_select_db($link,"newehutdb1");
?>





<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/> 
<title>Online Computer & Mobile Accessories Shop</title>
<style>
div#el1
{
    position: absolute;
    left: 990px;
    top: 5px;
}
div#el2
{
    position: absolute;
    left: 925px;
    top: 25px;
}
div#el4
{
    position: absolute;
    left: 950px;
    top: 100px;
}
a:hover#cart {
    color: red;
    background-color: transparent;
    text-decoration: underline;
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




table  {
    border-collapse: collapse;
    width: 100%;
}
th,  td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #cce6ff}

th {
    background-color: blue;
    color: white;
}



div#el3
{
    position: absolute;
    left: 250px;
    top: 60px;
}

</style>


</head>
<body>

		
<a href="index.php"><img src="e_hut.png" width="20%" height="20%"></a>
<div id="el3">
	<h1><p align="center"><font color ="#000000 " ><mark>&nbsp Computer and Mobile Accessories &nbsp<br/> &nbsp World's Most Admired Brands Under One Roof &nbsp</mark></p></font></h1>

</div>

	<link rel="stylesheet"type="text/css"href="Drop_Down_Menu.css"/>	
    
	<ul>
    <li><a href="index.php">Home</a></li>
    <li><a href="About_Us.php">About Us </a></li>
    
    <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtnhm">Product Categories</a>
    <div class="dropdown-content">
      <a href="computers.php">Laptops and Notebooks</a>
      <a href="Mobile.php">Smart Phones</a>
      <a href="mycart19.php">Mobile Accessories</a>
	  <a href="mycart20.php">Computer Accessories</a>
	  
	  
	  
    </div>
	</li>
	
	<li><a href="Contact_Us.php">Contact Us </a></li>

	<?php if (isset($_SESSION['usr_id'])) { ?>
<li style="float:right"><a href="cart.php" ID="cart"><img src="shoppingcart_50.png" width="50%" height="10%" ></a></li>
				<?php } else { ?>

				
				<li style="float:right"><a href="selling.php" ID="cart"><img src="shoppingcart_50.png" width="50%" height="10%" ></a></li>

				<?php } ?>


				<?php if (isset($_SESSION['usr_id'])) { ?>
				<li><a href="logout.php">Signed in as <?php echo $_SESSION['usr_name']; ?></p>Log Out</a></li>
				<?php } else { ?>

				
				<li><a href="Sign_In.php">Login</a></li>
				<li><a href="Sign_Up.php">Sign Up</a></li>
				<?php } ?>
				
				<div id="el2">	
	<form name="form2" action="" method="post">
    <li style="float:right"><td><input type="text" name="t1"placeholder="Search Brands..." ></td>
	<input type="submit" name="submit6" value="Search"   id="popUpYes">
    </li>
	</form>
	</div>
	
	<div id="el4">
		<li style="float:right"><a href="Profile.php">MyProfile</a></li>

	</div>
	

	</ul>
	</div>
    
    
</body>
</html>