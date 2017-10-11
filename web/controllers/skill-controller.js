angular.module('myApp')
    .controller('skillController',
        ["$scope",
            '$stateParams',
            "$state",
            'getresume',
            'sortingService',
            function ($scope,$stateParams, $state,getresume,sortingService) {
                
                if($stateParams.rating !=null){
               $scope.skill = sortingService.getSkillByName($stateParams.rating,$stateParams.expname);
           }
          
            }]);