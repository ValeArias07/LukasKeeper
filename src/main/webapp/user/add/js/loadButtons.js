var canvas = document.getElementById('canvasContainer');
var canvasA = document.getElementById('canvas');
var label = document.getElementById('label');
const addBtn = document.getElementById('addBtn');
const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');

loadContainerAdd = () => {
    window.location.href = '../add/addIncomes.html';
}

loadContainerPeriod = () => {
    canvasA.innerHTML = "<h2>Period</h2>";
}

loadContainerTimeLine = () => {
    canvasA.innerHTML = "<h2>Timeline</h2>";
}

loadContainerCompare = () => {
    canvasA.innerHTML = "<h2>Compare</h2>";
}

loadContainerIndicador = () => {
    canvasA.innerHTML = "<h2>Indicadores</h2>";
}

addBtn.addEventListener('click', loadContainerAdd);
periodBtn.addEventListener('click', loadContainerPeriod);
timelineBtn.addEventListener('click', loadContainerTimeLine);
compareBtn.addEventListener('click', loadContainerCompare);
indicatorsBtn.addEventListener('click', loadContainerIndicador);