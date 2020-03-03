$(function(){
    var $elevators =$('#elevators');
    $.ajax({
    type:'GET',
    url:'http://localhost:8082/ElevatorsKart-0.0.1-SNAPSHOT/rest/elevators/allElevators',
    contentType:'application/json',
    dataType:'json',
    success:function(allelevators){
    console.log('success',allelevators) 
    //alert(allelevators.ename);
  var getallelevators = allelevators.allelevators;
    for (i = 0; i < getallelevators.length; ++i) {
    
    	$elevators.append('<tr>'+
        		'<td>'+getallelevators[i].eno+'</td>'+
        		'<td>'+getallelevators[i].ename+'</td>'+
        		'<td>'+getallelevators[i].price+'</td>'+
        		'<td>'+getallelevators[i].stock+'</td>'+
        		'<td>'+getallelevators[i].features+'</td>'+
        		'<td>'+getallelevators[i].etype+'</td>'+
        		'</tr>');
    }
    },
    error:function(){
    alert('error in loading function');
    }
    });
});
    