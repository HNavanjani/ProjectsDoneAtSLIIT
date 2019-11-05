<?php
$link=mysqli_connect("localhost","root","");
mysqli_select_db($link,"newehutdb1");
?>

<?php
include "Header.php"
?>


<?php
	if(isset($_POST["submit6"]))
{
	$res=mysqli_query($link,"select * from searchproduct where brand='$_POST[t1]'");
	echo "<table border=1>";
	echo "<tr>";
		echo "<th>"; echo "ProductID"; echo "</th>";
		echo "<th>"; echo "CategoryID"; echo "</th>";
		echo "<th>"; echo "CompanyID"; echo "</th>";
		echo "<th>"; echo "Brand"; echo "</th>";
        echo "<th>"; echo "ProductName"; echo "</th>";
        echo "<th>"; echo "ProductImage"; echo "</th>";
		echo "<th>"; echo "ProductDescription"; echo "</th>";
		echo "<th>"; echo "UnitPrice"; echo "</th>";
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
		echo "<td>"; echo $row["ProductImage"]; echo "</td>";
		echo "<td>"; echo $row["ProductDescription"]; echo "</td>";
		echo "<td>"; echo $row["UnitPrice"]; echo "</td>";
		echo "<td>"; echo $row["UnitsInStock"]; echo "</td>";
		echo "<td>"; echo $row["QuantityPerUnit"]; echo "</td>";
		echo "</tr>";
	}
	echo "</table>";
	
}
?>