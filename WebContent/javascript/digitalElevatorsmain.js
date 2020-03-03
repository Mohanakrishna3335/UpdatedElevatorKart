$(function(){
    var $elevators =$('#elevators');
    $.ajax({
    type:'GET',
    url:'http://localhost:8082/ElevatorsKart-0.0.1-SNAPSHOT/rest/elevators/digitalElevators',
    contentType:'application/json',
    dataType:'json',
    success:function(konedigitalexperience){
    console.log('success',konedigitalexperience) 
    //alert(allelevators.ename);
  var getdigitalelevators = konedigitalexperience.konedigitalexperience;
    for (i = 0; i < getdigitalelevators.length; ++i) {
    	$elevators.append('<tr>'+
        		'<td>'+getdigitalelevators[i].eno+'</td>'+
        		'<td>'+getdigitalelevators[i].ename+'</td>'+
        		'<td>'+getdigitalelevators[i].price+'</td>'+
        		'<td>'+getdigitalelevators[i].stock+'</td>'+
        		'<td>'+getdigitalelevators[i].features+'</td>'+
        		'<td>'+getdigitalelevators[i].etype+'</td>'+
        		'</tr>');
    }
    },
    error:function(){
    alert('error in loading function');
    }
    });
});
  