let allSavings = [];

const getAllSavings = ()=>{
    
    //GET
    let xhr = new XMLHttpRequest();

    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);


            for(let i = 0; i < response.length; i++){
                let currentSaving = response[i];
                
            }
            
        }
        
    });

    let session = JSON.parse(window.localStorage.getItem('session'));

    console.log(window.localStorage.getItem('session'));

    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/savings/getAllPlans?email='+session.email);
    xhr.send();

}

getAllSavings();