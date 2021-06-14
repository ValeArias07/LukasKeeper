const amount = document.getElementById('txtAmount');
const planSelecter = document.getElementById('planSelecter');
const btAdd = document.getElementById("btAdd");
toRegister = () => {
    let saving = {
        value: amount.value,
        idSavingPlan: planSelecter.options[planSelecter.selectedIndex].value,
        // El back se encarga de ponerle la fecha actual
    };
    console.log(saving)
    //POST
    let xhr = new XMLHttpRequest();
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    xhr.open('POST', baseUrl + "api/savings/addSaving");
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onload = () => {
        let textAdd = 'Ocurrio un error al agregar el ahorro';
        if(xhr.status === 200){
            textAdd = 'Ahorro agregado exitosamente'
            amount.value = '';
            planSelecter.selectedIndex = 0;
        }
        alert(textAdd)
    }

    xhr.send(JSON.stringify(saving)); //toJson
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
                var option = document.createElement("option");
                option.value = plan.id;
                option.innerHTML = plan.description + ' - Meta: $' + plan.goal;
                planSelecter.add(option);
            }
        }
    });
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    let session = JSON.parse(window.localStorage.getItem('session'));
    xhr.open('GET', baseUrl + "api/savings/list?email=" + session.email);
    xhr.send();
}

loadOptionsOfPlanSelecter();
btAdd.addEventListener('click', toRegister);