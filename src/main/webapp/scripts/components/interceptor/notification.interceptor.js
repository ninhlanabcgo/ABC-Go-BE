 'use strict';

angular.module('abcgoApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-abcgoApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-abcgoApp-params')});
                }
                return response;
            },
        };
    });