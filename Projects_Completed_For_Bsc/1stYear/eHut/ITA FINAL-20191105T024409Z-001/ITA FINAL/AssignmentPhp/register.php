<?php  
      
$conn=mysqli_connect("localhost","root","","newehutdb1")
or die("Failed to Connect".mysqli_connect_error());

$firstname = mysqli_real_escape_string($conn,$_POST['fname']);
$lastname = mysqli_real_escape_string($conn,$_POST['lname']);
$username = mysqli_real_escape_string($conn,$_POST['username']);
$password = mysqli_real_escape_string($conn,$_POST['password']);
$email = mysqli_real_escape_string($conn,$_POST['email']);


$query ="INSERT INTO admin(A_fname,A_lname,A_UserName,A_Password,A_email) values('$firstname','$lastname','$username','$password','$email')";


if(!mysqli_query($conn,$query)
{
	echo "Error".mysqli_error($conn);
}
else
{
	header("location:Sign_Up.php?msg=1");
}


























?>   


