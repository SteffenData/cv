/**
 * Created by juhlm on 06-03-2017.
 */
'use strict';

var app = angular.module('myApp');
app.factory('sortingService', [
    '$state',
    '$rootScope',
    function ($state, $rootScope) {

        var list = {};

        var experience = function (experience) {

            list = experience;

            return list;
        };

        var getSkillByName = function (skillName, expName) {

            var explist;
            explist = list.experience;
            var oneExpWithSkils = [];
            if (explist !== null) {
                for (var i = 0; i < explist.length; i++) {
                    if (explist[i].name === expName) {
                        oneExpWithSkils = explist[i].skills;
                        
                            for(var k =0; k < oneExpWithSkils.length;k++){
                               
                                if(oneExpWithSkils[k].skillName === skillName){
                                    
                               return oneExpWithSkils[k];
                           }  
                           }
                    }
                }     
                console.log("er der data");
            }         
        };

        var self;
        return self = {
            experience: experience,
            getSkillByName: getSkillByName
        };
    }]);