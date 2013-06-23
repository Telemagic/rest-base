/**
 * Mini controller that talks to the Hello Service upon request.
 */
function HelloCtrl($scope, $http) {
    $scope.name = '';
    $scope.say = {};
    $scope.getData = function() {
        $http.get('service/hello?name=' + $scope.name)
        .success(function(data) {
            $scope.say = data;
        })
        .error(function(data, status) {
            alert("Error calling server, got stat " + status);
        })
    };
}
