const description = document.getElementById('txtDescription');
const cost = document.getElementById('txtCost');
const date = document.getElementById('expectedDate');
const btSave = document.getElementById('btSave');


toRegister = () => {
    let savingplan = new SavingPlan(description.value, cost.value, date.value);
    console.log(savingplan)
    let session = JSON.parse(window.localStorage.getItem('session'));
    //POST
    let xhr = new XMLHttpRequest();
    // xhr.addEventListener('readystatechange', () => {
    //     console.log(xhr.responseText);
    // });
    xhr.onload = () => {
        let textAdd = 'Ocurrio un error al agregar el plan';
        if(xhr.status === 200){
            textAdd = 'Plan agregado exitosamente'
            description.value = '';
            cost.value = '';
            date.value = '';
        }

        alert(textAdd)
    }
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    xhr.open('POST', baseUrl + "api/savings/addPlan?email=" + session.email);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(savingplan)); //toJson
}


checkFields = () => {

    if ((description.value).length === 0 || (cost.value).length === 0 || (date.value).length === 0) {
        alert("Por favor, digita todos los campos")
    } else {
        toRegister();
    }
}

btSave.addEventListener('click', checkFields);