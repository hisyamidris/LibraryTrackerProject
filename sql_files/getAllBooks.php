<?php

$con = mysql_connect("198.56.164.147","trincli0200","InJPaCllnyUVxarOJaKlb4zd");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
mysql_select_db("trincli0200", $con);

$result = mysql_query("SELECT * FROM librarybooks");

while($row = mysql_fetch_assoc($result))
  {
        $output[]=$row;
  }

print(json_encode($output));

mysql_close($con);


?>