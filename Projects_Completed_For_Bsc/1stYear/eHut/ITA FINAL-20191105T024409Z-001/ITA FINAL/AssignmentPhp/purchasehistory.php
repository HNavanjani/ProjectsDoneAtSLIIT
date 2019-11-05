<?php   

 session_start();  
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
 
 
 <!DOCTYPE html>  
 <html>  
      <head>  
	  
	  <style>
	  #content{
		  border-style: solid; 
		  border-width:thin; 
		  border-color:black;
		  padding :30px;
	  }
	  
	  
div#el1
{
    position: absolute;
    left: 900px;
    top: 30px;
}

</style>
	  
	  </style>
           <title>ehut|Invoice</title>  
            </head>  
      <body>  


    
				
			<div id="el1">	
			
			<?php
			date_default_timezone_set('Asia/Colombo');
            echo $date = date('m/d/Y h:i:s a', time());
			?>
			<br/>
			<?php
			echo "User Name : ";echo $_SESSION['usr_name']. "<br/>";
			echo "User ID : "  ;echo $_SESSION['usr_id']. "<br/>";

			?>
			 
			
			</div>
                
				<h3>Order Details</h3>  
                <div class="table-responsive">  
                     <table class="table table-bordered">  
                          <tr>  
                               <th width="40%">Item Name</th>  
                               <th width="10%">Quantity</th>  
                               <th width="20%">Price</th>  
                               <th width="15%">Total</th>  
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
                               <td>Rs. <?php echo $values["item_price"]; ?></td>  
                               <td>Rs. <?php echo number_format($values["item_quantity"] * $values["item_price"], 2); ?></td>  
                          </tr>  
                          <?php  
                                    $total = $total + ($values["item_quantity"] * $values["item_price"]);  
                               }  
                          ?>  
                          <tr>  
						  <br/><br/>
                               <td colspan="3" align="right"><b>Total</td> </b> 
                               <td align="right"> Rs. <?php echo number_format($total, 2) ?></td>  
                               <td></td>  
                          </tr>  
                          <?php  
                          }  
                          ?>  
                     </table>  

                </div>  
           </div>  
   
   
   
  
 
   
   
      </body>  
 </html>
   