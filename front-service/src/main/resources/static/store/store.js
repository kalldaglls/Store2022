angular.module('app').controller('storeController', function ($scope, $rootScope, $http, $localStorage) {
        $scope.loadProducts = function () {
            $http.get('http://localhost:5555/core/api/v1/products')
                .then(function (response) {
                    $scope.productList = response.data;
                });
        };

            $scope.addToCart = function (id) {
                    $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/add/' + id)
                        .then(function (response) {
                     });
                };

    $scope.loadProducts();
});