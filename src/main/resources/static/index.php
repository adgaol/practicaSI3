<?php
	$con = mysqli_connect('localhost','root','','test');
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!--script src="map.js"></script-->
<script type="text/javascript">
	google.charts.load('current', {'packages':['geochart']});
	google.setOnLoadCallback(drawChart);
	 
	function drawChart() {
		 
		var data = google.visualization.arrayToDataTable([
			['Pais','Compras'],
			<?php 
				$query = "SELECT lugar.pais as Pais ,COUNT(compra.lugarid) as Compras FROM compra LEFT JOIN lugar on compra.lugarid = lugar.lugarid GROUP BY compra.lugarid ";
				$exec = mysqli_query($con,$query);
				while($row = mysqli_fetch_array($exec)){
					echo "['".$row['Pais']."',".$row['Compras']."],";
				}
			?> 
		 ]);
	
		var options = {
			region: '150',
			width: 350,
			height:350,
		};
		
		var chart = new google.visualization.GeoChart(document.getElementById("PieChart"));
		
		chart.draw(data,options); 
	}
</script>
</head>
<body>
<div class="container-fluid">
	<div id="Map" style="width: 100%; height: 500px;"></div>
	<div id="PieChart" style="width: 100%; height: 500px;"></div>
 </div>
</body>
</html>