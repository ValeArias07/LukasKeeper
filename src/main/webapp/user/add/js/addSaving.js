const amount = document.getElementById('txtAmount');
const planSelecter = document.getElementById('planSelecter');
const btAdd = document.getElementById("btAdd");
toRegister = () => {
    let saving = {
        value: amount.value,
        idSavingPlan: planSelecter.options[planSelecter.selectedIndex].value,
        date: '2021-06-12' // El back se encarga de ponerle la fecha actual
    };

    //POST
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "url");
    xhr.setRequestHeader('Content-type', 'application/json');
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