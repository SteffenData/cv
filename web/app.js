
angular.module('common.services', []);
// Declare app level module which depends on views, and components
angular.module('myApp', [
    'common.services',
    'ui.router',
    'ui.bootstrap',
    'angular-ladda'

]).
config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state("startpage",{
            url:"/startpage",
            templateUrl:"templates/startpage.html",
            controller:"startpageController"
        })
        .state("applicant",{
            url:"/applicant/:id",
            templateUrl:"templates/profile.html",
            controller:"applicantController"
        })
        .state("resume",{
            url:"/resume/:id",
            templateUrl:"templates/resume.html",
            controller:"resumeController"
        })
        .state("resume.skill",{
            url:"/skill/:rating/:expname",
            templateUrl:"templates/skill.html",
            controller:"skillController"
        })
        
        .state("contact",{
            url:"/contact",
            templateUrl:"templates/contact.html",
            controller:"contactController"
        })
            .state("contacts",{
            url:"/contacts",
            templateUrl:"index.html",
            controller:"indexController"
        });
   

    $urlRouterProvider.otherwise("/startpage");


});
