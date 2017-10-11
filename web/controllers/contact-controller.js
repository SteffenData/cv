/**
 * Created by juhlm on 01-03-2017.
 */
angular.module('myApp')
        .controller('contactController',
                ["$scope",
                    '$stateParams',
                    "$state",
                    '$http',
                    function ($scope, $stateParams, $state, $http) {
                        $scope.mail = {
                            subject: "",
                            body: ""};

                        $scope.contactform = null;
                        $scope.alerts = [];
                        $scope.closeAlert = function (index) {
                            $scope.alerts.splice(index, 1);
                        };
                        $scope.formsending = false;


                        $scope.sendmail = function (element) {
                            $scope.contactform.$setSubmitted();

                            if ($scope.contactform.$invalid) {
                                console.log("det har jeg")
                               
                                return;
                            }

                            $scope.formsending = true;
                            $http({
                                method: 'POST',
                                url: 'api/sendmail/add',
                                data: $scope.mail,
                                headers: {'Content-Type': 'application/json'}
                            }).then(function (response) {
                                console.log(response);
                                $scope.formsending = false;
                                $scope.mail = {};
                                $scope.alerts.push("Tak for din besked");
                                $scope.contactform.$setPristine();
                            }, function (fail) { // optional
                                console.log("response");

                            });
                        };
                    }]);