'use strict';

angular.module('abcgoApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
