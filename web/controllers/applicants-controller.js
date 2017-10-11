/**
 * Created by juhlm on 23-02-2017.
 */
angular.module('myApp')
    .controller('applicantsController',
        ["$scope",
            'getallapplicants', function ($scope,getallapplicants) {
                
        var getData = function () {
            getallapplicants.getData()
                .then(function(data){
                    $scope.data = angular.copy(data);

            }),function (error) {
                console.log(error);
            };
        }();
 }]);

