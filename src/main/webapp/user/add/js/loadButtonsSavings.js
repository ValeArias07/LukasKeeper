const addPlanBtn = document.getElementById('addBtn');
const addSaving = document.getElementById('addSaving');
const setBudget = document.getElementById('setBudget');
const compareBtn = document.getElementById('compareBtn');


goToAddPlan=()=>{
    window.location.href="addPlan.html";
}

goToAddSaving=()=>{
    window.location.href="addSaving.html";
}

goToSetBudget=()=>{
    window.location.href="setBudget.html";
}



addPlanBtn.addEventListener('click', goToAddPlan);
addSaving.addEventListener('click', goToAddSaving);
setBudget.addEventListener('click', goToSetBudget);
//compareBtn.addEventListener('click', loadContainerIndicador);
