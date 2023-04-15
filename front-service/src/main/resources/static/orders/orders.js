angular.module('app').controller('ordersController', function ($scope, $rootScope, $http) {
           $scope.loadOrders = function () {
                    $http.get('http://localhost:5555/core/api/v1/orders')
                        .then(function (response) {
                            $scope.orders = response.data;
                        });
                };

    $scope.loadOrders();
});