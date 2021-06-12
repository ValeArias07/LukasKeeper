var canvas = document.getElementById('canvasContainer');
var canvasA = document.getElementById('canvas');

const addPlanBtn = document.getElementById('addPlanBtn');
const addSaving = document.getElementById('addSaving');
const setBudget = document.getElementById('setBudget');
const compareBtn = document.getElementById('compareBtn');


goToAddPlan=()=>{
    window.location.href="../addPlan.html";
}

goToAddSaving=()=>{
    window.location.href="../addSaving.html";
}

goToSetBudget=()=>{
    window.location.href="../setBudget.html";
}

loadContainerCompare = () => {
    canvasA.innerHTML = "<h2>Compare</h2>";
}

addPlanBtn.addEventListener('click', goToAddPlan);
addSaving.addEventListener('click', goToAddSaving);
setBudget.addEventListener('click', goToSetBudget);
compareBtn.addEventListener('click', loadContainerIndicador);
