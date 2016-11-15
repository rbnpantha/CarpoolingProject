 
	function initMap() {
		
	        var myLatLng = {lat: 41.0086111, lng:-91.9625};
	        var directionsService = new google.maps.DirectionsService;
	        var directionsDisplay = new google.maps.DirectionsRenderer;
	        var map = new google.maps.Map(document.getElementById('map'), {
	        																	zoom: 8,
	        																	center: myLatLng
	        																});  
	        directionsDisplay.setMap(map);
	        
	        //showing marker with weather information
	        
	        
	        //Information for route
	        $("#directionSubmit").click(function(){ 
	        	 
	        	 directionsService.route({
	        		 						origin: $("#start").val(),
	        		 						destination: $("#end").val(), 
	        		 						optimizeWaypoints: true,
	        		 						travelMode:'DRIVING'
	        	 	}, function(response, status) {
	        	 									if (status === 'OK') {
	        	 											directionsDisplay.setDirections(response);
	        	 											var route = response.routes[0];
	        	 											var summaryPanel = document.getElementById('summaryPanel');
	        	 											summaryPanel.innerHTML = '';
	                   // For each route, display summary information.
	        	 											for (var i = 0; i < route.legs.length; i++) {
	        	 												var routeSegment = i + 1;
	        	 												summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
	        	 												'</b><br>';
	        	 												summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
	        	 												summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
	        	 												summaryPanel.innerHTML += route.legs[i].distance.text +  '<br><br>';
	        	 											}
	        	 									} 
	        	 									else {
	        	 											window.alert('Directions request failed due to ' + status);
	        	 										}
	       	 })
	       	 
	       	 var content="";
	         $("#bothWeather").empty();
	         var Scity="";
	         var Ecity="";
	         $("#bothWeather").empty();
	         Scity=$("#start").val();
	         Ecity=$("#end").val(); 
	        if(Scity!="" && Ecity!=""){
	        	 getWeather(Scity);
		         getWeather(Ecity);
	        }
	         //getting the weather information by city
	       
//end of initMap()
	
	$(function(){ 
			
		$("#submit").click(function(){
		$("#weather").empty(); 
		var city="";
		city=$('#city').val();
		var api="http://api.openweathermap.org/data/2.5/forecast?q=";
		var countryCode=",us";
	    var apiKey="&appid=e464bf3e13849921887950f827be20f5"; 
	    var units="&units=metric&mode=json";
	    var url= api + city + countryCode + units + apiKey;
	      
	   
		});
	 
	});

	 