$(function(){
    var $elevators =$('#elevators');
    var $eno=$('#eno');
    var $ename=$('#ename');
    var $price=$('#price');
    var $stock=$('#stock');
    var $features=$('#features');
    var $etype=$('#etype');
    $('#add-elevator').on('click',function(){
    var addElevator={
    "eno": $eno.val(),
    "ename": $ename.val(),
    "price": $price.val(),
    "stock": $stock.val(),
    "features": $features.val(),
    "etype": $etype.val(),
    };
console.log("data from form is working");
    $.ajax({
    type:'POST',
    url:'http://localhost:8082/ElevatorsKart-0.0.1-SNAPSHOT/rest/elevators/addNewElevator',
    contentType:'application/json',
    dataType: 'html',
    data:JSON.stringify(addElevator),
    success:function(newelevator){
    $elevators.append('<li>Equipment Details Updated </li>')
   alert("Elevator Data Updated");    
},  
    //$elevators.append('<li>eno:'+newelevator.eno+'ename:'+newelevator.ename+'price:'+newelevator.price+'stock:'+newelevator.stock+'features:'+newelevator.features+'etype:'+newelevator.etype+'</li>')   
    	//},
    error:function(){
    alert('new elevator is not added');
    }
    });
    console.log("valid");
    });
    console.log("hi");
    });