const saldov = document.getElementById('saldov');
const ingresov = document.getElementById('ingresov');
const gastosv = document.getElementById('gastosv');

renderInfoSaldo=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
       if(xhr.readyState==4){
           let json = xhr.responseText;
           let response = JSON.parse(json);
           console.log(response);

            saldov.innerHTML = response.toString();
       }
    });
    xhr.open('GET','inserteurldelservicio');
    xhr.send();
}

renderInfoSaldo();

renderInfoIngreso=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);

            ingresov.innerHTML = response.toString();
        }
    });
    xhr.open('GET','inserteurldelservicio');
    xhr.send();
}

renderInfoIngreso();

renderInfoGasto=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState==4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);

            gastosv.innerHTML = response.toString();
        }
    });
    xhr.open('GET','inserteurldelservicio');
    xhr.send();
}

renderInfoGasto();