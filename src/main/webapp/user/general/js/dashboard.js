let saldov = document.getElementById('saldov');
let ingresov = document.getElementById('ingresov');
let gastosv = document.getElementById('gastosv');
let session = JSON.parse(window.localStorage.getItem('session'));

var ingreso=0;
var gasto=0;

renderInfoIngreso=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);

            ingresov.innerHTML = response.toString();
            ingreso=response;
            console.log(ingreso);
            let op=(ingreso-gasto);
            console.log(op);
            saldov.innerHTML=op;
        }
    });
    xhr.open('GET','http://localhost:8081/LukasKeeper_war/api/expenses/getBalanceIncome?email='+session.email);
    xhr.send();
}

renderInfoGasto=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState==4){

            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            gasto=(-1)*response;
            gastosv.innerHTML = (-1)*response;
            renderInfoIngreso();
        }
    });

    xhr.open('GET','http://localhost:8081/LukasKeeper_war/api/expenses/getBalanceExpenses?email='+session.email);
    xhr.send();
}
renderInfoGasto();