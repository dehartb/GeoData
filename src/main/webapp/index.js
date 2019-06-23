var app = angular.module("geoData", ["checklist-model"]); 
app.controller("baseController", function($scope,$http) {
	$scope.totalTodos = 4;
	$scope.Items = [];
	$scope.Years = [];
	$scope.Areas = [];
	
	$scope.User = {
		Years: []
	};
	
	$scope.changefont = function() {
		console.log("I'm here");
        var x = document.getElementById("cn");
	    x.style.fontSize = "25px";           
	    x.style.color = "red"; 
	};
	
	$scope.checkAll = function() {
		console.log("this is it");
	    $scope.User.Years = angular.copy($scope.Years);
	    
	    $scope.User.Years = [];
	    $scope.User.Years.push($scope.Years[0]);
	};
	
	$scope.uncheckAll = function() {
	    $scope.User.Years = [];
	};
	
	$scope.getItems = function()
	{
		var url = 'http://turbos-mac-mini:7001/GeoData/getItems';
		console.log(url);
		 $http.get(url)
	        .success(function(data) {
	            $scope.Items = data;
	            console.log(data)
	        })
	        .error(function(data) {
	            alert(data);
	            console.log('Error: ' + data);
	        });
	};
	
	$scope.getYears = function(itemCode, areaCode)
	{
		var url = 'http://turbos-mac-mini:7001/GeoData/getYears/' + itemCode + '/' + areaCode;
		console.log(url);
		 $http.get(url)
	        .success(function(data) {
	            $scope.Years = data;
	            console.log(data)
	        })
	        .error(function(data) {
	            alert(data);
	            console.log('Error: ' + data);
	        });
	};
	
	$scope.getAreas = function(itemCode)
	{
		var url = 'http://turbos-mac-mini:7001/GeoData/getAreas/' + itemCode;
		console.log(url);
		 $http.get(url)
	        .success(function(data) {
	            $scope.Areas = data;
	            console.log(data)
	        })
	        .error(function(data) {
	            alert(data);
	            console.log('Error: ' + data);
	        });
	};
	

});


