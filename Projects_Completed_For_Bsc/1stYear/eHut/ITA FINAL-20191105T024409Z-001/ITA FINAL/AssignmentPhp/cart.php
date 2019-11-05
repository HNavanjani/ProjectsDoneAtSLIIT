<?php   
 session_start();  
 $connect = mysqli_connect("localhost", "root", "", "newehutdb1");  
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
	                 'description'               =>     $_POST["hidden_description"],  
				 
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
                'item_description'               =>     $_POST["hidden_description"],  
				
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
 
 
 
 
 
 
 
 <!DOCTYPE html>  
 <html>  
      <head>  
           <title>ehut|Shopping Cart</title>  
            </head>  
      <body>  
	  <?php 
include("LogHeader.php"); 
?>
<?php
include("Premium.php");
?>
<?php 
include("Primarybar.php"); 
?>


<div id="content" >	
           
                <div style="clear:both"></div>  
                <br />  
                <h3>Order Details</h3>  
                <div class="table-responsive">  
                     <table class="table table-bordered">  
                          <tr>  
                               <th width="40%">Item Name</th>  
                               <th width="10%">Quantity</th>  
                               <th width="20%">Price</th>  
                               <th width="15%">Total</th>  
                               <th width="5%">Action</th>  
                          </tr>  
                          <?php   
                          if(!empty($_SESSION["shopping_cart"]))  
                          {  
                               $total = 0;  
                               foreach($_SESSION["shopping_cart"] as $keys => $values)  
                               {  
                          ?>  
                          <tr>  
                               <td><?php echo $values["item_name"]; ?></td>  
                               <td><?php echo $values["item_quantity"]; ?></td>  
                               <td>Rs.<?php echo $values["item_price"]; ?></td>  
                               <td>Rs. <?php echo number_format($values["item_quantity"] * $values["item_price"], 2); ?></td>  
                               <td><a href="mycart.php?action=delete&id=<?php echo $values["item_id"]; ?>"><span class="text-danger">Remove</span></a></td>  
                          </tr>  
                          <?php  
                                    $total = $total + ($values["item_quantity"] * $values["item_price"]);  
                               }  
                          ?>  
                          <tr>  
                               <td colspan="3" align="right">Total</td>  
                               <td align="right">Rs. <?php echo number_format($total, 2); ?></td>  
                               <td></td>  
                          </tr>  
                          <?php  
                          }  
                          ?>  
                     </table>  
					<a href="Checkout.php"><input type="submit" name="checkout" style="margin-top:5px;"  value="Procced to Checkout" /> </a> 

                </div>  
           </div> 




		   <span style='color:green'><?php if (isset($successmsg)) { echo $successmsg; } ?></span>
			<span style='color:red'><?php if (isset($errormsg)) { echo $errormsg; } ?></span>
		
	
           <br />  
		   </div>
  <?php 
include("Secondarybar.php"); 
?>
<?php 
include("Footer.php"); 
?>
  
      </body>  
 </html>
   