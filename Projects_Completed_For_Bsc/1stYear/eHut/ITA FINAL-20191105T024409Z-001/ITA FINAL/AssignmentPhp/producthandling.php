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
if(!$_SESSION['adlogin']){
   header("location:adminlog.php");
   die;
}
?>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 
<style>

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




<div id="content">
<h1>Product Handling System</h1>
<form name="form1" action="" method="post">
<table>
<tr>
<td>Enter ProductID</td>
<td><input type="text" name="t1"></td>
<td><input type="text" name="t11"placeholder="Update ProductId" ></td>
</tr>
<tr>
<td>Enter CaregoryID</td>
<td><input type="text" name="t2"></td>
<td><input type="text" name="t12"placeholder="Update CaregoryID" ></td>
</tr>
<tr>
<td>Enter CompanyID</td>
<td><input type="text" name="t3"></td>
<td><input type="text" name="t13"placeholder="Update CompanyID" ></td>
</tr>
<td>Enter Brand</td>
<td><input type="text" name="t4"></td>
<td><input type="text" name="t14"placeholder="Update Brand" ></td>
</tr>
<tr>
<td>Enter ProductName</td>
<td><input type="text" name="t5"></td>
<td><input type="text" name="t15"placeholder="Update ProductName" ></td>
</tr>
<tr>
<td>Enter ProductDescription</td>
<td><input type="text" name="t6"></td>
<td><input type="text" name="t16"placeholder="Update ProductDescription" ></td>
</tr>
<tr>
<td>Enter ProductImage File Name with Extension </td>
<td><input type="text" name="t7">
</td>
<td><input type="text" name="t17"placeholder="Update ProductImage"></td>
</tr>

<tr>
<td>Enter UnitPrice</td>
<td><input type="text" name="t8"></td>
<td><input type="text" name="t18"placeholder="Update UnitPrice" ></td>
</tr>
<tr>
<td>Enter UnitsInStock</td>
<td><input type="text" name="t9"></td>
<td><input type="text" name="t19"placeholder="Update UnitsInStock" ></td>
</tr>
<tr>
<td>Enter QuantityPerUnit</td>
<td><input type="text" name="t10"></td>
<td><input type="text" name="t20"placeholder="Update QuantityPerUnit" ></td>
</tr>



<tr  >
<th colspan="4"align="right" >
<input type="submit" name="submit1" value="Insert Product Details"id="popUpYesp">
<input type="submit" name="submit2" value="Delete Product Details" id="popUpYesp">
<input type="submit" name="submit3" value="Update Product Details"id="popUpYesp">
<input type="submit" name="submit4" value="Display All Products"id="popUpYesp">
<input type="submit" name="submit5" value="Search by ProductID"id="popUpYesp">
<input type="reset" name="submit6" value="Reset Data"id="popUpYesp">



</th>
</tr>
</table>
</form>
<br/>
<br/>


<?php
if(isset($_POST["submit1"]))
{
	mysqli_query($link,"insert into searchproduct values('$_POST[t1]','$_POST[t2]','$_POST[t3]','$_POST[t4]','$_POST[t5]','$_POST[t6]','$_POST[t7]','$_POST[t8]','$_POST[t9]','$_POST[t10]')");
	
}

if(isset($_POST["submit2"]))
{
	mysqli_query($link,"delete from searchproduct where ProductID='$_POST[t1]'");
}




if(isset($_POST["submit3"]))
{
	mysqli_query($link,"update searchproduct set ProductID ='$_POST[t11]'where ProductID='$_POST[t1]'");
	mysqli_query($link,"update searchproduct set CategoryID ='$_POST[t12]'where CategoryID='$_POST[t2]'");
	mysqli_query($link,"update searchproduct set CompanyID ='$_POST[t13]'where CompanyID='$_POST[t3]'");
	mysqli_query($link,"update searchproduct set brand ='$_POST[t14]'where brand='$_POST[t4]'");
	mysqli_query($link,"update searchproduct set ProductName ='$_POST[t15]'where ProductName='$_POST[t5]'");
	mysqli_query($link,"update searchproduct set ProductDescription ='$_POST[t16]'where ProductDescription='$_POST[t6]'");
	mysqli_query($link,"update searchproduct set image ='$_POST[t17]'where image='$_POST[t7]'");
	mysqli_query($link,"update searchproduct set UnitPrice ='$_POST[t18]'where UnitPrice='$_POST[t8]'");
	mysqli_query($link,"update searchproduct set UnitsInStock ='$_POST[t19]'where UnitsInStock='$_POST[t9]'");
	mysqli_query($link,"update searchproduct set QuantityPerUnit ='$_POST[t20]'where QuantityPerUnit='$_POST[t10]'");

}








if(isset($_POST["submit4"]))
{
	$res=mysqli_query($link,"select * from searchproduct");
	echo "<table border=1 >";
	echo "<tr>";
		echo "<th>"; echo "ProductID"; echo "</th>";
		echo "<th>"; echo "CategoryID"; echo "</th>";
		echo "<th>"; echo "CompanyID"; echo "</th>";
		echo "<th>"; echo "Brand"; echo "</th>";
		echo "<th>"; echo "ProductName"; echo "</th>";
		echo "<th>"; echo "ProductDescription"; echo "</th>";
		echo "<th>"; echo "ProductImage"; echo "</th>";

		echo "<th>"; echo "UnitPrice (Rs.)"; echo "</th>";
		echo "<th>"; echo "UnitsInStock"; echo "</th>";
		echo "<th>"; echo "QuantityPerUnit"; echo "</th>";



		echo "</tr>";
	while($row=mysqli_fetch_array($res))
	{
		echo "<tr>";
		echo "<td>"; echo $row["ProductID"];  echo "</td>";
		echo "<td>"; echo $row["CategoryID"]; echo "</td>";
		echo "<td>"; echo $row["CompanyID"]; echo "</td>";
		echo "<td>"; echo $row["brand"]; echo "</td>";
		echo "<td>"; echo $row["ProductName"]; echo "</td>";
		echo "<td>"; echo $row["ProductDescription"]; echo "</td>";?>
		<td><img src="<?php echo $row["image"]; ?> "style="zoom: 0.5"/><br />  </td>



<?php
		echo "<td>"; echo $row["UnitPrice"]; echo "</td>";
		echo "<td>"; echo $row["UnitsInStock"]; echo "</td>";
		echo "<td>"; echo $row["QuantityPerUnit"]; echo "</td>";

		echo "</tr>";
	}
	echo "</table>";
	
}




if(isset($_POST["submit5"]))
{
	$res=mysqli_query($link,"select * from searchproduct where ProductID='$_POST[t1]'");
	echo "<table border=1>";
	echo "<tr>";
		echo "<th>"; echo "ProductID"; echo "</th>";
		echo "<th>"; echo "CategoryID"; echo "</th>";
		echo "<th>"; echo "CompanyID"; echo "</th>";
		echo "<th>"; echo "Brand"; echo "</th>";
		echo "<th>"; echo "ProductName"; echo "</th>";
		echo "<th>"; echo "ProductDescription"; echo "</th>";
		echo "<th>"; echo "ProductImage"; echo "</th>";

		echo "<th>"; echo "UnitPrice (Rs.)"; echo "</th>";
		echo "<th>"; echo "UnitsInStock"; echo "</th>";
		echo "<th>"; echo "QuantityPerUnit"; echo "</th>";
		echo "</tr>";
	while($row=mysqli_fetch_array($res))
	{
		echo "<tr>";
		echo "<td>"; echo $row["ProductID"];  echo "</td>";
		echo "<td>"; echo $row["CategoryID"]; echo "</td>";
		echo "<td>"; echo $row["CompanyID"]; echo "</td>";
		echo "<td>"; echo $row["brand"]; echo "</td>";
		echo "<td>"; echo $row["ProductName"]; echo "</td>";
		echo "<td>"; echo $row["ProductDescription"]; echo "</td>";
		?>		
		<td><img src="<?php echo $row["image"]; ?> "style="zoom: 0.5"/><br />  </td>
		<?php
		echo "<td>"; echo $row["UnitPrice"]; echo "</td>";
		echo "<td>"; echo $row["UnitsInStock"]; echo "</td>";
		echo "<td>"; echo $row["QuantityPerUnit"]; echo "</td>";
		echo "</tr>";
	}
	echo "</table>";
	
}

	
?>

		</div>
		
  
<?php 
include("Footer.php"); 
?>
  

</body>
</html>

