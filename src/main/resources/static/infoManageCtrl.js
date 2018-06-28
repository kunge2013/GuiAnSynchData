angular.module('myApp', []).controller('infoManageCtrl', function($scope,$http) {
    $scope.cxsPId = '';
    $scope.cxsPName = '';
    $scope.localPId = '';
    $scope.localPName = '';
   
    $scope.infoData = [];
    $scope.localProjects = [];
    $scope.localProject={};
    /**
     * 请求后台数据
     */
    $http.post('./infoList.do').
    success(function(data) {
        $scope.infoData = data.infoData;
        $scope.localProjects = data.localProjects;
    }).
    error(function(err) {
    	 console.log(err);
    });
    
    
    $scope.edit = true;
    $scope.error = false;
    $scope.incomplete = false; 
    $scope.editInfoManage = function(idx) {
      if (idx == 'new') {
    	$scope.idx = null;
        $scope.incomplete = true;
        $scope.cxsPId = '';
        $scope.cxsPName = '';
        $scope.localPName = '';
        $scope.localPId = '';
        $scope.localProject = '';
        } else {
        var data = {};
        
        for(var index = 0 ;index < $scope.infoData.length;index++)
        {
        	if($scope.infoData[index].idx == idx){
        		data = $scope.infoData[index];
        		break;
        	}
        }
        
        $scope.idx = idx;
        $scope.cxsPId =  data.cxsPId;
        $scope.cxsPName = data.cxsPName;
        $scope.localPName =  data.localPName;
        $scope.localPId =  data.localPId;
        $scope.localProject = "{\"localPName\":\""+data.localPName+"\",\"localPId\":\"" +data.localPId+"\"}";
      }
    };
    
    $scope.removeInfoManage = function(idx){
    	if(idx){
    		  $http({
    	             method: "POST",
    	             url: './removeInfo.do',
    	             params: {
    	            	 		idx:idx
    						 },
    	             headers: {'Cache-Control':'no-cache'}
    	         }).success(function(data) {
    	             $scope.infoData = data.infoData;
    	             $scope.idx = null; 
    	             $scope.cxsPId = '';
    	             $scope.cxsPName = '';
    	             $scope.localPName = '';
    	             $scope.localPId = '';
    	             $scope.localProject = '';
    	       });
    	}
    };
    //保存数据
    $scope.saveInfo = function(){
    	 var objData = {};
         if($scope.idx)
         {
        	 objData.idx = $scope.idx;
         }
         objData.cxsPName = $scope.cxsPName;
    	 objData.cxsPId = $scope.cxsPId;
         objData.localPName = $scope.localPName;
         objData.localPId = $scope.localPId;
         
         $http({
             method: "POST",
             url: './saveInfo.do',
             params: {
            	 	 idx:$scope.idx,
		        	 cxsPName:$scope.cxsPName,
		        	 cxsPId:$scope.cxsPId,
		        	 localPName:$scope.localPName,
		        	 localPId:$scope.localPId
					},
             headers: {'Cache-Control':'no-cache'}
         }).success(function(data) {
        	 console.log(data);
             $scope.infoData = data.infoData;
             $scope.idx = null; 
             $scope.cxsPId = '';
             $scope.cxsPName = '';
             $scope.localPName = '';
             $scope.localPId = '';
             $scope.localProject = '';
       });

         
    };
    $scope.$watch('localProject',function() {
    	try{
    		var selectInfo = JSON.parse($scope.localProject);
		    $scope.localPName = selectInfo.localPId;
	        $scope.localPId = selectInfo.localPName;
    	}catch(e){
    		console.log(e);
    	}
    	
    });
    
    $scope.$watch('cxsPId',function() {$scope.test();});
    $scope.$watch('cxsPName',function() {$scope.test();});
    $scope.$watch('localPName',function() {$scope.test();});
    $scope.$watch('localPId',function() {$scope.test();});
    
    $scope.test = function() {
      $scope.incomplete = false;
      if ($scope.edit && (!$scope.cxsPId.length ||
        !$scope.cxsPName.length ||
        !$scope.localPName.length || !$scope.localPId.length)) {
        $scope.incomplete = true;
      }
    };
    })
    
