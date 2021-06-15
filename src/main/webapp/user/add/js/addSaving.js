const amount = document.getElementById('txtAmount');
const planSelecter = document.getElementById('planSelecter');
const btAdd = document.getElementById("btAdd");

const savingPlans=[];

toRegister = () => {
    let saving = {
        value: amount.value,
        idSavingPlan: planSelecter.options[planSelecter.selectedIndex].value,
    };
    console.log(saving)

    //POST
    let xhr = new XMLHttpRequest();
    let baseUrl = window.location.origin + '/' + location.pathname.split('/')[1] + '/';
    xhr.open('POST', baseUrl + "api/savings/addSaving");
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(saving));

    xhr.onload = () => {
        let textAdd = 'Ocurrio un error al agregar el ahorro';
        if(xhr.status === 200){
            textAdd = 'Ahorro agregado exitosamente'
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

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

btAdd.addEventListener('click', toRegister);
loadOptionsOfPlanSelecter();