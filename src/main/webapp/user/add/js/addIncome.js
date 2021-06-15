const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const button = document.getElementById('button');

var canvas = document.getElementById('canvasContainer');
var canvasA = document.getElementById('canvas');

const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');


const getSelectors=()=>{
    var indexCategory= document.getElementById("incomeType").selectedIndex;
    var idCategory=document.getElementById("incomeType").options[indexCategory].value;

    var indexFrequency= document.getElementById("frequencyType").selectedIndex;
    var idFrequency=document.getElementById("frequencyType").options[indexFrequency].text;
    addIncome(idCategory,idFrequency) ;
}

const addIncome=(idCategory, idFrequency)=>{
    let xhr = new XMLHttpRequest();
    const income = new Income(value.value, description.value, date.value, idFrequency, idCategory);
    let session = JSON.parse(window.localStorage.getItem('session'));
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/incomes/add?email="+session.email);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(income));
    alert("Ingreso añadido!");
}

button.addEventListener('click', getSelectors);

loadContainerPeriod = () => {
    window.location="../categories/incomes.html";
}

loadContainerTimeLine = () => {
    window.location="../categories/incomes.html";
}

loadContainerCompare = () => {
    window.location="../categories/incomes.html";
}

loadContainerIndicador = () => {
    window.location="../categories/incomes.html";
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

authSession();
periodBtn.addEventListener('click', loadContainerPeriod);
timelineBtn.addEventListener('click', loadContainerTimeLine);
compareBtn.addEventListener('click', loadContainerCompare);
indicatorsBtn.addEventListener('click', loadContainerIndicador);