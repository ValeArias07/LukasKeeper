let dataArrayIncome = [];
let dataArrayExpenses = [];

let backgroundIncome =[];
let backgroundExpenses =[];

const callData = (chooseService) => {
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            let json = xhr.responseText;
            let response = JSON.parse(json);
            
            for (let i = 0; i < response.length; i++) {
                let dot = response[i];
                if(chooseService === 1){
                    dataArrayExpenses.push({x:dot.date.substring(8,10),y: (-1)*dot.value});
                    backgroundExpenses[i]="rgb(57, 77, 114)";
                } else{
                    dataArrayIncome.push({x:dot.date.substring(8,10),y:dot.value});
                    backgroundIncome[i]="rgb(248, 126, 150)";
                }
                
                
                
                
            }
            init();
        }
    });
    
    let session = JSON.parse(window.localStorage.getItem('session'));
    let url = "http://localhost:8081/LukasKeeper_war/api/incomes/getMonthlyData?email="+session.email+"&date=2021-06"

    if(chooseService === 1){
        url = "http://localhost:8081/LukasKeeper_war/api/expenses/getMonthlyData?email="+session.email+"&date=2021-05"
    }
    xhr.open("GET", url);

    xhr.send();
};

var ctx = document.getElementById("myChart").getContext("2d");

const init = () => {
    var myChart = new Chart(ctx, {
        type: "scatter",
        plugins: [plugin],
        data: {
            
            datasets: 
            [
                {
                  label: 'Ingresos',
                  fill: false,
                  lineTension: 0.5,
                  data: dataArrayIncome,
                  showLine: true,
                  backgroundColor: backgroundIncome
                },
                {
                    label: 'Gastos',
                    fill: false,
                    lineTension: 0.5,
                    data: dataArrayExpenses,
                    showLine: true,
                    backgroundColor: backgroundExpenses
                }
              ]

        }, options : {
            scales: {
              yAxes: [{
                scaleLabel: {
                  display: true,
                  labelString: 'Pesos $'
                }
              }],
              xAxes: [{
                scaleLabel: {
                  display: true,
                  labelString: 'Dia del mes'
                }
              }]
            }
          }
    });
}

const plugin = {
    id: 'custom_canvas_background_color',
    beforeDraw: (chart) => {
        const ctx = chart.canvas.getContext('2d');
        ctx.save();
        ctx.globalCompositeOperation = 'destination-over';
        ctx.fillStyle = 'white';
        ctx.fillRect(0, 0, chart.width, chart.height);
        ctx.restore();
    }
};

callData(0);
callData(1);
