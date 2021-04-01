function myFunction(){
/*    var txt = '{"name":"santtu"}';
    var obj = JSON.parse(txt);
    document.getElementById("demo").innerHTML = obj.name;
*/
    var mydata = JSON.parse(data);
    var mydata2 = JSON.parse(otsikko);
    document.getElementById("demo").innerHTML = (mydata[0].name);
    document.getElementById("demot").innerHTML = (mydata[0].nametwo);
    
    document.getElementById("otsikko1").innerHTML = (mydata2[0].otsikko1);
    document.getElementById("otsikko2").innerHTML = (mydata2[0].otsikko2);
    document.getElementById("otsikko3").innerHTML = (mydata2[0].otsikko3);
    //alert(mydata[0].name);
    //document.getElementById("demo").innerHTML = mydata.name;
}

function saveEdits(){
    //get the edit element
    var editElem = document.getElementById("edit");
    //get the eduted element content
    var userVersion = editElem.innerHTML;
    //save the content to local storage
    localStorage.userEdits = userVersion;
    //write user that edits saved
    document.getElementById("update").innerHTML="Edits saved!";
    console.log(localStorage.getItem("userEdits"));
}

function checkEdits() {

    //find out if the user has previously saved edits
    if(localStorage.userEdits!=null)
    document.getElementById("edit").innerHTML = localStorage.userEdits;
    
    }