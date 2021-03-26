function myFunction(){
/*    var txt = '{"name":"santtu"}';
    var obj = JSON.parse(txt);
    document.getElementById("demo").innerHTML = obj.name;
*/
    var mydata = JSON.parse(data);
    document.getElementById("demo").innerHTML = (mydata[0].name);
    document.getElementById("demot").innerHTML = (mydata[0].nametwo);
    
    //alert(mydata[0].name);
    //document.getElementById("demo").innerHTML = mydata.name;
}

function saveEdits(){
    var editElem = document.getElementById("edit");
    var userVersion = editElem.innerHTML;
    localStorage.userEdits = userVersion;
    document.getElementById("update").innerHTML="Edits saved!";
    
}

function checkEdits() {

    //find out if the user has previously saved edits
    if(localStorage.userEdits!=null)
    document.getElementById("edit").innerHTML = localStorage.userEdits;
    
    }