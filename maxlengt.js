function myFunction(){
/*    var txt = '{"name":"santtu"}';
    var obj = JSON.parse(txt);
    document.getElementById("demo").innerHTML = obj.name;
*/
    var mydata = JSON.parse(data);
    document.getElementById("demo").innerHTML = (mydata[0].name);
    //alert(mydata[0].name);
    //document.getElementById("demo").innerHTML = mydata.name;
}