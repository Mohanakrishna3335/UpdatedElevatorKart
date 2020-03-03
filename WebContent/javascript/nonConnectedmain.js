$(function(){
    var $elevators =$('#elevators');
    $.ajax({
    type:'GET',
    url:'http://localhost:8082/ElevatorsKart-0.0.1-SNAPSHOT/rest/elevators/nonConnectedElevators',
    contentType:'application/json',
    dataType:'json',
    success:function(koneNonConnectedelevators){
    console.log('success',koneNonConnectedelevators) 
    //alert(allelevators.ename);
  var getnonconnectedelevators = koneNonConnectedelevators.koneNonConnectedelevators;
    for (i = 0; i < getnonconnectedelevators.length; ++i) {
        $elevators.append('<tr>'+
        		'<td>'+getnonconnectedelevators[i].eno+'</td>'+
        		'<td>'+getnonconnectedelevators[i].ename+'</td>'+
        		'<td>'+getnonconnectedelevators[i].price+'</td>'+
        		'<td>'+getnonconnectedelevators[i].stock+'</td>'+
        		'<td>'+getnonconnectedelevators[i].features+'</td>'+
        		'<td>'+getnonconnectedelevators[i].etype+'</td>'+
        		'</tr>');
    }
    },
    error:function(){
    alert('error in loading function');
    }
    });
});
    