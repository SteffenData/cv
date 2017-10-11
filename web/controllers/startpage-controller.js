
angular.module('myApp')
        .controller('startpageController',
                ['$scope',
                    'changeLanguagesService',
                    'readfiles',
                    'changeLanguagesService',
                    function ($scope, changeLanguagesService, readfiles, changeLanguagesService) {

                        var url = "danish.json"
                        $scope.data = {};

                        $scope.change = function (selectedflag) {
                            changeLanguagesService.changeLanguages(selectedflag);
                        };
                        $scope.getTexts = function () {
                            if (changeLanguagesService.selectedLaunguages() == 2) {
                                url = "english.json"
                            } else {
                                url = "danish.json"
                            }

                            readfiles.getData(url)
                                    .then(function (data) {
                                        $scope.data = angular.copy(data.startpage.lines);
                                    }), function (error) {
                                console.log(error);
                            };
                        };
                        $scope.getTexts();
                        $scope.$on("languageChanged", function() {
                            $scope.getTexts();
                        });
                    }]);
