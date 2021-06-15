var canvasA = document.getElementById('canvasE');
const addBtn=document.getElementById('addBtn');
const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');
const entretenimientoInformation = document.getElementById('entretenimientoInformation');
const saludInformation = document.getElementById('saludInformation');

const getAllExpenses = () =>{
    let session = JSON.parse(window.localStorage.getItem('session'));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            entretenimientoInformation.innerHTML = '';
            saludInformation.innerHTML = '';

            for(let i = 0; i<response.length;i++){
                let expenses = response[i];
                let view = new loadExpensesElements(expenses);
                view.onDeleteFinish = () =>{
                    if(expenses.idDefaultCategory === 90000008) {
                        saludInformation.removeChild(document.getElementById('expenses' + expenses.id));
                    } else{
                        entretenimientoInformation.removeChild(document.getElementById('expenses' + expenses.id));
                    }
                };
                if(expenses.idDefaultCategory === 90000008) {
                    saludInformacion.appendChild(view.render());
                } else {
                    entretenimientoInformation.appendChild(view.render());
                }

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