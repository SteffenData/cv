/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('myApp')
    .controller('indexController',
        ["$scope",
          '$rootScope',
          'changeLanguagesService',
            function ($scope,$rootScope,changeLanguagesService) {

      var numbervalue = changeLanguagesService.selectedLaunguages();

      $scope.numbervalue = numbervalue
      
    $scope.$watch(function (numbervalue){
        $scope.numbervalue = changeLanguagesService.selectedLaunguages();
    });
    
}]);

