var canvasA = document.getElementById('canvas');
const addBtn=document.getElementById('addBtn');
const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');


loadContainerAdd=()=>{
    window.location="../add/addDebts.html";
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