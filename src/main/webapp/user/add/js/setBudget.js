//Views
var session = JSON.parse(window.localStorage.getItem('session'));
const budget = document.getElementById('budget');
const alertPercentage = document.getElementById('alert');
const percentage = document.getElementById('percentage');
const range = document.getElementById('range');
const spends = document.getElementById('spends');

const formatterPeso = new Intl.NumberFormat('es-CO', {
    style: 'currency',
    currency: 'COP',
    minimumFractionDigits: 0
  });

btSave.addEventListener('click', validate);
btMetaPorAhorros.addEventListener('click', completeBySavings);
range.addEventListener('change', updateRangeLabel);
budget.addEventListener('change', updateRangeLabel);

function toRegister(){
    let monthlyPlan = new MonthlyPlan(budget.Value, percentageAlert.Value, percentageSpend.Value);

    //POST
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.status === 4) {
            console.log(xhr.responseText);
        }
    });
    xhr.open('POST', "http://localhost:8081/LukasKeeper_war/api/savings/list?email="+session.email);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(monthlyPlan)); //toJson
}

function completeBySavings(){

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState == 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            let totalSavings =0;
            for(let i=0; i<response.length; i++){
                let plan = response[i];
                totalSavings += plan.monthlyFee;
            }

            if(budget.value == ''){
                alert('Digite su presupuesto');
            }else if(budget.value<=totalSavings){
                alert('La cuota mensual de los ahorros superan el presupuesto, por favor establece un plan diferente');
            }else if(totalSavings==0){
                alert('No posees planes de ahorro. Crea un plan de ahorro para utilizar esta opción');
            }else{
                let perc = (1 - totalSavings/budget.value)*100;
                spends.value = formatterPeso.format(totalSavings);
                range.value = perc;
                percentage.textContent = (perc+'  ').substring(0,4) + '%';
            }
        }
    });
    xhr.open('GET', "http://localhost:8081/LukasKeeper_war/api/savings/list?email="+session.email);
    xhr.send();
}

function updateRangeLabel(){
    if(budget.value != ''){
        percentage.textContent = range.value+ '%';
        spends.value = formatterPeso.format(budget.value * range.value/100);
    }
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

function validate(){
    alert("entra");
    if (budget.Value !== '') {
        toRegister();
    }else{
        alert('Campo vacío: presupuesto');
    }
}