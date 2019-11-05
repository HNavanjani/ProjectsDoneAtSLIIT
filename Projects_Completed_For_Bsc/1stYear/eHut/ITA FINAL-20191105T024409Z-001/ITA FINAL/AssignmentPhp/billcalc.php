<?php   

 session_start();  
 $connect = mysqli_connect("localhost", "root", "", "ehutdb1");  
 
 ?>
 
 
 <!DOCTYPE html>  
 <html>  
      <head>  
	  
	  <style>
	  

</style>
</head>
	<body>
                
				<h3>Customer Invoice</h3>  
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
                               <td> <?php echo $values["item_price"]; ?></td>  
                               <td> <?php echo number_format($values["item_quantity"] * $values["item_price"], 2); ?></td>  
                          </tr>  
                          <?php  
                                    $total = $total + ($values["item_quantity"] * $values["item_price"]);  
                               }  
                          ?>  
                          <tr>  
						  <br/><br/>
                               <td colspan="3" align="right"><b>Total</td> </b> 
                               <td align="right">  <?php echo number_format($total, 2) ?></td>  
                               <td></td>  
                          </tr>  
                          <?php  
                          }  
                          ?>  
                     </table>  

              
      </body>  
 </html>
   