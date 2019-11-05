function putTrain(){

    $.put = function(url, data, callback, type){

if ( $.isFunction(data) ){
type = type || callback,
callback = data,
data = {}
}

return $.ajax({
url: url,
type: 'PUT',
success: callback,
data: data,
contentType: type
});
}

    console.log("hii");
    var $idd="5d9312510ef5912accb6f270";

    $.put('http://localhost:3000/train/id/'+$idd, {tname:'tin tin'}, function(result){
console.log(result);
}) 
  }
