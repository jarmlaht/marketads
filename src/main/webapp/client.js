var app = angular.module('MarketAdsApp', []);

app.controller('MarketAdsController', function($scope, $http) {
    $http.get("http://mepa-store-api.herokuapp.com/marketads")
    .success(function(response) {
        $scope.listitems = response;
    }).error(function() {
        console.log("Error in getting marketads!");
    });

    $scope.findbyid = function($scope, $http) {
        var url = "http://mepa-store-api.herokuapp.com/marketads/" + $scope.searchid;
        $http({
            method: 'GET',
            url:url
        }).success(function(response) {
            $scope.listitems = response;
        }).error(function(){
            console.log("MarketAdsController: Error in finding an item!");
        });
    };

    $scope.additem = function() {
        $http({
            method: 'POST',
            url: 'http://mepa-store-api.herokuapp.com/marketads/',
            data: {'title': $scope.newitem.title,
                'description': $scope.newitem.description,
                'price': $scope.newitem.price,
                'email': $scope.newitem.email,
                'tel': $scope.newitem.tel,
                'id':0},
            headers: 'Content-type: application/json'
        }).success(function() {
            console.log("MarketAdsController: success");
        }).error(function(){
            console.log("MarketAdsController: error");
        });
    };
    
    $scope.deleteitem = function() {
        $http({
            method: 'DELETE',
            url:'http://mepa-store-api.herokuapp.com/marketads/' + $scope.deleteid
        }).success(function() {
            console.log("MarketAdsController: List item deleted");
        }).error(function(){
            console.log("MarketAdsController: Error in deleting an item!");
        });
    };
        
    $scope.listall = function() {
        var url = "http://mepa-store-api.herokuapp.com/marketads";
        $http({
            method: 'GET',
            url: url
        }).success(function(response) {
            console.log("MarketAdsController: Success!");
            $scope.listitems = response;
        }).error(function() {
            console.log("MarketAdsController: Error in getting response from " + url);
        });
    };
});

