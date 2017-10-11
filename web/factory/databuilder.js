/**
 * Created by juhlm on 23-02-2017.
 */





angular.module('common.services')
        .factory('getprofile', ['$http', '$rootScope', '$q', function ($http, $rootScope, $q) {

                return {
                    getData: function (profileId) {
                        var defered = $q.defer();
                        $http.get("api/profile/" + profileId)
                                .then(function (response) {
                                    defered.resolve(response.data);
                                }, function (response) {
                                    throw {type: "http", data: response.data};
                                });
                        return defered.promise;
                    }
                };
            }]).factory('getresume', ['$http', '$rootScope', '$q', function ($http, $rootScope, $q) {

        return {
            getData: function (resumeId) {
                var defered = $q.defer();
                $http.get("api/resume/" + resumeId)
                        .then(function (response) {
                            defered.resolve(response.data);
                        }, function (response) {
                            throw {type: "http", data: response.data};
                        });
                return defered.promise;
            }
        };
    }]).factory('readfiles', ['$http', '$rootScope', '$q', function ($http, $rootScope, $q){

return{
    getData: function (url){
        var defered = $q.defer();
        $http.get('jsonfiles/' + url)
                .then(function (response){
                    defered.resolve(response.data);
                }, function (response){
                   throw {type: "http", data: response.data};
                });
                return defered.promise;
    }
};
    }]);
