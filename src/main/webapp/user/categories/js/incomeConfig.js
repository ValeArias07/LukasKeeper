const extraInformationContainer = document.getElementById('extraInformation');
const salarioInformationContainer = document.getElementById('salarioInformation');

const getAllIncomes = () =>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            extraInformationContainer.innerHTML = '';
            for(let i = 0; i<response.length;i++){
                let income = response[i];
                let view = new loadIncomeElements(income);
                view.onDeleteFinish = () =>{
                    extraInformationContainer.removeChild(document.getElementById('toDoComponent' + income.id));
                };
            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/LukasKeeper/api/incomes/list');
    xhr.send();
};

getAllIncomes();



