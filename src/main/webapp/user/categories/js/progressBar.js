let allSavings = [];
const tableContainer = document.getElementById('content-bars');

const getAllSavings = ()=>{
    
    //GET
    let xhr = new XMLHttpRequest();

    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);


            for(let i = 0; i < response.length; i++){
                let container = document.createElement('div');
                container.className = 'progress-container';

                let component = document.createElement('div');
                component.className = 'table-headers';

                let goal = document.createElement('p');
                let progress = document.createElement('p');
                let time = document.createElement('p');
                let share = document.createElement('p');

                let currentSaving = response[i];
                goal.innerHTML = currentSaving.description;
                progress.innerHTML = '$ '+currentSaving.totalFee+'/'+currentSaving.goal;
                
                let percentage = currentSaving.totalFee/currentSaving.goal;
                percentage = percentage*100;

                let date = currentSaving.date;
                date = date.substring(5,7);

                let month;
                

                let d = new Date();
                let n = d.getMonth();
                date = date - n;

                if(date < 0){
                    month = 'Vencido';
                } else if(date === 1){
                    month = ' Mes';
                } else{
                    month = ' Meses';
                }

                if(month ==='Vencido'){
                    time.innerHTML = month;
                } else{
                    time.innerHTML = date+month;
                }


                share.innerHTML = '$ '+currentSaving.monthlyFee;

                component.appendChild(goal);
                component.appendChild(progress);
                component.appendChild(time);
                component.appendChild(share);

                let outterBar = document.createElement('div');
                outterBar.className = 'myProgress';

                let innerBar = document.createElement('div');
                innerBar.className = 'myBar';
                innerBar.idName = 'myBar'+currentSaving.id;

                innerBar.innerHTML = percentage.toFixed(1)+'%';
                
                innerBar.style.width = percentage+'%';
                outterBar.appendChild(innerBar);

                
                container.appendChild(component);
                container.appendChild(outterBar);

                tableContainer.appendChild(container);

                
            }
            
        }
        
    });

    let session = JSON.parse(window.localStorage.getItem('session'));

    

    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/savings/getAllPlans?email='+session.email);
    xhr.send();

}

getAllSavings();