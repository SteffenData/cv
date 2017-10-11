/**
 * Created by juhlm on 01-03-2017.
 */
angular.module('myApp')
    .controller('resumeController',
        ["$scope",
            '$stateParams',
            'getresume',
            'sortingService',
            function ($scope,$stateParams,getresume,sortingService) {

                var getData = function () {
                    getresume.getData($stateParams.id)
                        .then(function(data){

                            $scope.resume = sortingService.experience(angular.copy(data));
                        }),function (error) {
                        console.log(error);
                    };
                }();
            }]);