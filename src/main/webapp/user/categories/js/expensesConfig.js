var canvasA = document.getElementById('canvasE');
const addBtn=document.getElementById('addBtn');
const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');
const entretenimientoInformacion = document.getElementById('entretenimientoInformacion');
const saludInformacion = document.getElementById('saludInformacion');

const getAllExpenses = () =>{
    let session = JSON.parse(window.localStorage.getItem('session'));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            entretenimientoInformacion.innerHTML = '';
            saludInformacion.innerHTML = '';

            for(let i = 0; i<response.length;i++){
                let expenses = response[i];
                let view = new loadExpensesElements(debts);
                view.onDeleteFinish = () =>{
                    //if(expenses.id)
                    debtsInformation.removeChild(document.getElementById('debts' + debts.id));
                };
                debtsInformation.appendChild(view.render());

            }
        }
    });
    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/expenses/list?email=' + session.email);
    xhr.send();
};

getAllExpenses();



loadContainerAdd=()=>{
    window.location="../add/addExpenses.html";
    console.log("add");
}

loadContainerPeriod = () => {
    canvasA.innerHTML = "<h2>Period</h2>";
    console.log("period");
}

loadContainerTimeLine = () => {
    canvasA.innerHTML = "<h2>Timeline</h2>";
    console.log("time");
}

loadContainerCompare = () => {
    canvasA.innerHTML = "<h2>Compare</h2>";
    console.log("com");
}

loadContainerIndicador = () => {
    canvasA.innerHTML = "<h2>Indicadores</h2>";
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

authSession();
addBtn.addEventListener('click', loadContainerAdd);
periodBtn.addEventListener('click', loadContainerPeriod);
timelineBtn.addEventListener('click', loadContainerTimeLine);
compareBtn.addEventListener('click', loadContainerCompare);
indicatorsBtn.addEventListener('click', loadContainerIndicador);