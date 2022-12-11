angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage, $sessionStorage) {
    const contextPath = 'http://localhost:8080/app-core/api/v1';

    if ($localStorage.springWebUser) {
        try {
            let jwt = $localStorage.springWebUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 1000);
            if (currentTime > payload.exp) {
                console.log("Token is expired!!!");
                delete $localStorage.springWebUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }

        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }

    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/app-core/api/v1/products')
            .then(function (response) {
                $scope.productList = response.data;
                // console.log(response);
            });
    };

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8080/app-core/api/v1/products/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8080/app-core/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.loadProducts();
            });
    }

    // $scope.loadProducts = function (pageIndex = 1) {
    //     $http({
    //         url: contextPath + '/products',
    //         method: 'GET',
    //         params: {
    //             title_part: $scope.filter ? $scope.filter.title_part : null,
    //             min_price: $scope.filter ? $scope.filter.min_price : null,
    //             max_price: $scope.filter ? $scope.filter.max_price : null
    //         }
    //     }).then(function (response) {
    //         $scope.ProductsPage = response.data;
    //     });
    // };

    $scope.tryToAuth = function () {
        $http.post('http://localhost:8080/app-core/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    //Подшиваем токен ко всем запросам на бэк!
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
                // alert(response.data.token);
            }, function errorCallback(response) {
            });
    };

    // $scope.tryToRegNewUser = function () {
    //     $http.post('http://localhost:8080/app-core/reg', $scope.user)
    //         .then(function successCallback(response) {
    //             $scope.user.username = response.data.username;
    //             $scope.user.password = response.data.password;
    //             $scope.user.email = response.data.email;
    //         });
    // };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        // if ($scope.user.username) {
        //     $scope.user.username = null;
        // }
        // if ($scope.user.password) {
        //     $scope.user.password = null;
        // }
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:8080/app-core/auth/about')
            .then(function (response) {
                alert(response.data.value);
            });
            // .then(function successCallback(response) {
            //     alert('MY NAME IS: ' + response.data.username);
            // }, function errorCallback(response) {
            //     alert('UNAUTHORIZED');
            // });
    };

    $scope.loadCart = function () {
        $http.get('http://localhost:8088/app-cart/api/v1/cart/')
            .then(function (response) {
                $scope.cart = response.data;
            });
    }

    $scope.addToCart = function (id) {
        $http.get('http://localhost:8088/app-cart/api/v1/cart/add/' + id)
            .then(function (response) {
                $scope.loadCart();
         });
    }

    $scope.deleteFromCart = function (id) {
        $http.delete('http://localhost:8088/app-cart/api/v1/cart/delete/' + id)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.createOrder = function () {

    }

    $scope.loadProducts();
    $scope.loadCart();
});
