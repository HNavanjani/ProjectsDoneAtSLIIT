<?php   

 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
 
 if(!$_SESSION['login']){
   header("location:Sign_In.php");
   die;
}








				
 if(isset($_POST["add_to_cart"]))  
 {  
      if(isset($_SESSION["shopping_cart"]))  
      {  
           $item_array_id = array_column($_SESSION["shopping_cart"], "item_id");  
           if(!in_array($_GET["id"], $item_array_id))  
           {  
                $count = count($_SESSION["shopping_cart"]);  
                $item_array = array(  
                     'item_id'               =>     $_GET["id"],  
                     'item_name'               =>     $_POST["hidden_name"],  
                     'item_price'          =>     $_POST["hidden_price"],  
                     'item_quantity'          =>     $_POST["quantity"]  
                );  
                $_SESSION["shopping_cart"][$count] = $item_array;  
           }  
           else  
           {  
                echo '<script>alert("Item Already Added")</script>';  
                echo '<script>window.location="mycart.php"</script>';  
           }  
      }  
      else  
      {  
           $item_array = array(  
                'item_id'               =>     $_GET["id"],  
                'item_name'               =>     $_POST["hidden_name"],  
                'item_price'          =>     $_POST["hidden_price"],  
                'item_quantity'          =>     $_POST["quantity"]  
           );  
           $_SESSION["shopping_cart"][0] = $item_array;  
      }  
 }  
 if(isset($_GET["action"]))  
 {  
      if($_GET["action"] == "delete")  
      {  
           foreach($_SESSION["shopping_cart"] as $keys => $values)  
           {  
                if($values["item_id"] == $_GET["id"])  
                {  
                     unset($_SESSION["shopping_cart"][$keys]);  
                     echo '<script>alert("Item Removed")</script>';  
                     echo '<script>window.location="mycart.php"</script>';  
                }  
           }  
      }  
 }  

 ?>
 
 
 
 
				
           
 
 

			
			
			
			 
			
			
                          <?php   
                          if(!empty($_SESSION["shopping_cart"]))  
                          {  
                               $total = 0;  
                               foreach($_SESSION["shopping_cart"] as $keys => $values)  
                               {  
                          ?>  
                               <?php  number_format($values["item_quantity"] * $values["item_price"], 2); ?> 
                          <?php  
                                    $total = $total + ($values["item_quantity"] * $values["item_price"]);  
                               }  
                          ?>  
                          
                                <?php  number_format($total, 2) ?> 

                          <?php  
                          }  
                          ?>  
                     
<?php
if (isset($_POST['signup'])) {

 if(mysqli_query($con, "INSERT INTO shoppingcart(total) VALUES('" . $total . "')")) {
			$successmsg = "Thank You, Your order has been Placed!<a href='bill.php'>Click to Recieve the Invoice </a>";
		} else {
			$errormsg = "Error ...Please try again later!";
		}
}


	   ?>

      </body>  
 </html>
   