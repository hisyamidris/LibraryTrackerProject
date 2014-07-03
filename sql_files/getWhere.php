<?php
    
    if(isset($_REQUEST['user']))
       {
       $con = mysql_connect("198.56.164.147","username","password");
       if (!$con)
       {
       die('Could not connect: ' . mysql_error());
       }
       mysql_select_db("trincli0200", $con);
       
       $name = $_REQUEST['user'];
       
       $result = mysql_query("SELECT * FROM librarybooks WHERE title LIKE '%$name%' ") or die('Errant query:');
       
       
       while($row = mysql_fetch_assoc($result))
       {
       $output[]=$row;
       
       }
       
       print(json_encode($output));
       
       mysql_close($con);
       }
    else
       {
       $output = "not found";
       print(json_encode($output));
       }




?>