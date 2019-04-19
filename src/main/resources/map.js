<?php
	$con = mysqli_connect('localhost','root','','test');
?>
$(document).ready(function(){
    google.charts.load('current', {'packages':['map']});
	google.setOnLoadCallback(drawChart);
	 
	function drawChart() {
		 
		var data = google.visualization.arrayToDataTable([
			['Pais','Compras'],
			<?php 
				$query = "SELECT lugar.pais ,COUNT(compra.lugarid) FROM compra LEFT JOIN lugar on compra.lugarid = lugar.lugarid GROUP BY compra.lugarid ";
				$exec = mysqli_query($con,$query);
				while($row = mysqli_fetch_array($exec)){
					echo "['".$row['Pais']."',".$row['Compras']."],";
				}
			?> 
		 ]);

		var options = {
			showTooltip: true,
            showInfoWindow: true
		};
		
		var chart = new google.visualization.Map(document.getElementById("PieChart"));
		
		chart.draw(data,options); 
    }
})