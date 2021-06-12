const description = document.getElementById('txtDescription');
const cost = document.getElementById('txtCost');
const date = document.getElementById('expectedDate');
const btSave = document.getElementById('btSave');


toRegister=()=>{
        let savingplan = new SavingPlan(description, cost, date);
        let session = JSON.parse(window.localStorage.getItem('session'));
        //POST
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            console.log(xhr.responseText);
        });
        xhr.open('POST', "api/savings/addPlan?email="+session.email);
        xhr.setRequestHeader('Content-type', 'application/json');
        xhr.send(JSON.stringify(savingplan)); //toJson
}


checkFields=()=>{

    if((description.value).length===0 || (cost.value).length===0 || (date.value).length===0){
        alert("Por favor, digita todos los campos")
    }else{
        toRegister();
    }
}

btSave.addEventListener('click', checkFields);