//Views

const budget = document.getElementById('budget');
const alertPercentage = document.getElementById('alert');
var percentage = document.getElementById('percentage');
var range = document.getElementById('range');
var spends = document.getElementById('spends');
const totalSavings = 500000;

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
        console.log(xhr.responseText);
    });
    xhr.open('POST', "URL");
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(monthlyPlan)); //toJson
}

function completeBySavings(){
    if(budget.value == ''){
        alert('Digite su presupuesto');
    }else if(budget.value<=totalSavings){
        alert('La cuota mensual de los ahorros superan el presupuesto, por favor establece un plan diferente');
    }else{
        let perc = totalSavings*100/budget.value;
        spends.value = formatterPeso.format(totalSavings);
        range.value = perc;
        percentage.textContent = (perc+'  ').substring(0,4) + '%';
    }
}

function updateRangeLabel(){
    if(budget.value != ''){
        percentage.textContent = range.value+ '%';
        spends.value = formatterPeso.format(budget.value * range.value/100);
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