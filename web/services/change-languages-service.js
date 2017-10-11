/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('myApp');
app.factory('changeLanguagesService', [
    '$state',
    '$rootScope',
    function ($state, $rootScope) {

        var danish = true;
        
        var changeLanguages = function (boolean) {

            if (danish !== boolean) {
                danish = boolean;
                console.log(boolean);
                $rootScope.$broadcast("languageChanged");
            }
        };
        
        var selectedLaunguages = function (){
            if(danish == true){
                console.log(1);
                return 1;
            }else {
                console.log(2);
                return 2;
            }
        };
        
        var self;
        return self = {
            changeLanguages:changeLanguages,
            selectedLaunguages:selectedLaunguages
        };

    }]);

