const amount = document.getElementById('txtAmount');
const debt = document.getElementById('planSelecter');
const btAdd = document.getElementById("btAdd");

const savingPlans=[];

toRegister = () => {

    let fee = {
        value: amount.value,
        idDebts: planSelecter.options[planSelecter.selectedIndex].value
    };
    console.log(fee)
    let session = JSON.parse(window.localStorage.getItem('session'));
    //POST
    let xhr = new XMLHttpRequest();
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    xhr.open('POST', baseUrl + "api/debts/addFee?email="+session.email);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(fee));

    xhr.onload = () => {
        let textAdd = 'Ocurrio un error al agregar la cuota';
        if(xhr.status === 200){
            textAdd = 'Cuota agregada exitosamente'
            amount.value = '';
            planSelecter.selectedIndex = 0;
        }
        alert(textAdd)
    }
}
loadOptionsOfPlanSelecter = () => {

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            for (let i = 0; i < response.length; i++) {
                let plan = response[i];
                console.log(plan);
                let option = document.createElement("option");
                option.value = plan.id;
                option.innerHTML = plan.description;
                planSelecter.add(option);
            }
        }
    });
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    let session = JSON.parse(window.localStorage.getItem('session'));
    xhr.open('GET', baseUrl + "api/debts/list?email=" + session.email);
    xhr.send();
}

btAdd.addEventListener('click', toRegister);
loadOptionsOfPlanSelecter();