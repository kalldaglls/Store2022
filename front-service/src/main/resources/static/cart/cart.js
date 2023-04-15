angular.module('app').controller('cartController', function ($scope, $rootScope, $http, $localStorage) {
    $scope.loadCart = function () {
            $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId)
                .then(function (response) {
                    $scope.cart = response.data;
                });
        };



            $scope.deleteFromCart = function (id) {
                $http.delete('http://localhost:5555/cart/api/v1/cart/delete/' + id)
                    .then(function (response) {
                        $scope.loadCart();
                    });
            }

                $scope.createOrder = function () {
                    $http.post('http://localhost:5555/core/api/v1/orders')
                        .then(function (response) {
            //                $scope.newOrder= null;
            //                $scope.clearCart;
                              $scope.loadCart();
//                              $scope.loadOrders();
                        });
                }

//                 $scope.createOrder = function () {
//                                    alert("Get lost!");
//                                        };
//

                $scope.clearCart = function () {
                    $http.delete('http://localhost:5555/cart/api/v1/cart/deleteCart/')
                        .then(function (response) {
                        alert(response.toString());
                    });
                }

             $scope.loadCart();
});