<?php
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<link rel="stylesheet"type="text/css"href="div3clmns.css"/> 

<style>
input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}


input[type=submit] {
    background-color: #ff3399;
    color: white;
	font-weight::bold;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
     opacity: 0.8;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
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

<h2>GET IN TOUCH</h2>
<p style="text-align:justify">
We are eager to discuss your business needs,and answer any questions you may have.Enter your details and we will get back to you shortly.
</p>
  <form action="Submit.html">

<h1>Contact Form</h1>


<div class="imgcontainer">
    <img src="comment_user.png" alt="Avatar" class="avatar">
  </div>


<div class="container">
  <form action="/action_page.php">
    <label for="fname">Name</label>
    <input type="text" id="fname" name="firstname" required placeholder="Your name..">

    <label for="email">Email</label>
    <input type="text" id="email" name="email" required placeholder="Your email address..">

    <label for="subject">Subject</label>
	<input type="text" id="subject" name="subject" required placeholder="Subject.." >
    

    <label for="subject">Message</label>
    <textarea id="message" name="message" required placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">
  </form>
</div>


<br/>
<br/>

<div class="container">
<h3 style="color:red;">Company Details</h3>
<p>
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

  </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
</body>
</html>
