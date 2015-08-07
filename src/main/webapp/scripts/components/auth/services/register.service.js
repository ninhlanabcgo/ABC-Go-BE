'use strict';

angular.module('abcgoApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


