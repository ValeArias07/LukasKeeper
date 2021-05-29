const description = document.getElementById('txtDescription');
const cost = document.getElementById('txtCost');
const date = document.getElementById('expectedDate');

btSave.addEventListener('click', toRegister);

function toRegister(){
    if(true){
        let savingplan = new SavingPlan(description, cost, date);
        //POST
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            console.log(xhr.responseText);
        });
        xhr.open('POST', "url");
        xhr.setRequestHeader('Content-type', 'application/json');
        xhr.send(JSON.stringify(savingplan)); //toJson
    }else{
        alert("Check Fields");
    }
}