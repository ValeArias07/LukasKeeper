var canvas = document.getElementById('canvasContainer');
var canvasA = document.getElementById('canvas');
var label = document.getElementById('label');
const periodBtn = document.getElementById('periodBtn');
const timelineBtn = document.getElementById('timelineBtn');
const compareBtn = document.getElementById('compareBtn');
const indicatorsBtn = document.getElementById('indicatorsBtn');


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

periodBtn.addEventListener('click', loadContainerPeriod);
timelineBtn.addEventListener('click', loadContainerTimeLine);
compareBtn.addEventListener('click', loadContainerCompare);
indicatorsBtn.addEventListener('click', loadContainerIndicador);