/**
 * Created by juhlm on 25-02-2017.
 */
angular.module('myApp')
    .controller('applicantController',
        ["$scope",
            '$stateParams',
            "$state",
            'getprofile',
             function ($scope,$stateParams, $state,getprofile) {
   
    var mydata = {};

                var getData = function () {
                     getprofile.getData($stateParams.id)
                         .then(function(data){

                             $scope.profile = angular.copy(data);

                         }),function (error) {
                         console.log(error);
                     };
                 }();

        }]);

