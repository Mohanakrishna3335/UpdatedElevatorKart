$(function(){
    var $elevators =$('#elevators');
    $.ajax({
    type:'GET',
    url:'http://localhost:8082/ElevatorsKart-0.0.1-SNAPSHOT/rest/elevators/connectedElevators',
    contentType:'application/json',
    dataType:'json',
    success:function(koneConnectedelevators){
    console.log('success',koneConnectedelevators);
  var getconnectedelevators = koneConnectedelevators.koneConnectedelevators;
    for (i = 0; i < getconnectedelevators.length; ++i) {
        
    	$elevators.append('<tr>'+
        		'<td>'+getconnectedelevators[i].eno+'</td>'+
        		'<td>'+getconnectedelevators[i].ename+'</td>'+
        		'<td>'+getconnectedelevators[i].price+'</td>'+
        		'<td>'+getconnectedelevators[i].stock+'</td>'+
        		'<td>'+getconnectedelevators[i].features+'</td>'+
        		'<td>'+getconnectedelevators[i].etype+'</td>'+
        		'</tr>');
    	}
    
    },
    error:function(){
    alert('error in loading function');
    }
    });
});
    