 
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
	        $.get("http://api.openweathermap.org/data/2.5/weather?q=faifrield,us&units=metric&mode=json&appid=e464bf3e13849921887950f827be20f5")
	        	.done(function(data){
	        						var value="";
	        							value+=data.name+ "\n" +data.main.temp +" C\n" + data.weather[0].description;
	        						var marker = new google.maps.Marker({
	        																position: myLatLng,
	        																map: map,
	        																title:value
	        						});
	        		})
	        	.fail(function(xhr,status,exception){
	             										console.log(exception);
	            });
	        
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
	        function getWeather(city){
	        								$.get("http://api.openweathermap.org/data/2.5/weather?q="+city+",us&units=metric&mode=json&appid=e464bf3e13849921887950f827be20f5")
	        								.done(function(data){
	        														content+=	"<p>"+data.name+ "<\p>"+"<img class='img' src='http://openweathermap.org/img/w/"+data.weather[0].icon+".png'/>" +data.main.temp +" C, " + data.weather[0].description ;
	        														$("#bothWeather").append(content);
	        														content="";
	        								}).fail(function(xhr,status,exception){
	        																		console.log(exception);
	        								});
	        					}
	        
	       
	})
	}
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
	      
	    if(city!=""){
	    	
	    	//Displaying day
			var weekdays = new Array(7);
			weekdays[0] = "Sunday";
			weekdays[1] = "Monday";
			weekdays[2] = "Tuesday";
			weekdays[3] = "Wednesday";
			weekdays[4] = "Thursday";
			weekdays[5] = "Friday";
			weekdays[6] = "Saturday";			
	    	$.get(url).done(function(data){
	    	 
	    		var content=""; 
	    		content+=	"<h3>City :"+data.city.name+"   Country "+data.city.country+"</h3>";
	    		content+=	"<h4>Todays"+"<img   src='http://openweathermap.org/img/w/"+data.list[0].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[0].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[0].weather[0].description+"</span>"+
	    	 				"<h4>"+weekdays[new Date(data.list[3].dt_txt).getDay()] +
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[3].weather[0].icon+".png'/>"+
	    	 				"<span> "+data.list[3].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[3].weather[0].description+"</span>"+"</h4>"+
	    	 				"<h4>"+weekdays[new Date(data.list[11].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[11].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[11].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[11].weather[0].description+"</span>"+"</h4>"+
	    	 				"<h4>"+weekdays[new Date(data.list[19].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[19].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[19].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[19].weather[0].description+"</span>"+"</h4>"+
	    	 				"<h4>"+weekdays[new Date(data.list[27].dt_txt).getDay()] + 
	    	 				"<img  src='http://openweathermap.org/img/w/"+data.list[27].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[27].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[27].weather[0	].description+"</span>"+"</h4>"+
	    	 				"<h4>"+weekdays[new Date(data.list[35].dt_txt).getDay()] + 
	    	 				"<img    src='http://openweathermap.org/img/w/"+data.list[35].weather[0].icon+".png'/>"+
	    	 				"<span>"+data.list[35].main.temp+" C  </span>"+
	    	 				"<span>, "+data.list[35].weather[0	].description+"</span></h4>";
	    		$("#weather").append(content);
	    	})
	    	.fail(function(xhr,status,exception){
	    											console.log(exception);
	    		})	
	    	}
		});
	 
	});

	 
 