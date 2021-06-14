const periodBtn = document.getElementById('periodBtn');
const compareBtn = document.getElementById('compareBtn');

let dataArray = [];
let labelArray = [];

let dataAditionalArray = [];
let labelAditionalArray = [];

let background =[];
let backgroundAditional =[];

const callAditionalData = () => {
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            let json = xhr.responseText;
            let response = JSON.parse(json);

            for (let i = 0; i < response.length; i++) {
                let dot = response[i];
                dataAditionalArray[i]=dot.value;
                labelAditionalArray[i]="Dia " +dot.date.substring(8,10);
                backgroundAditional[i]="rgb(57, 77,114)";
            }
            initDoubleChart();
        }
    });
    let session = JSON.parse(window.localStorage.getItem('session'));

    xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/expenses/getMonthlyData?email="+session.email+"&date=2021-06");

    xhr.send();
};

const callData = () => {
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            let json = xhr.responseText;
            let response = JSON.parse(json);
            
            for (let i = 0; i < response.length; i++) {
                let dot = response[i];
                dataArray[i]=dot.value;
                labelArray[i]="Dia " +dot.date.substring(8,10);
                background[i]="rgb(248, 126, 150)";
                
            }
            init();
        }
    });
    let session = JSON.parse(window.localStorage.getItem('session'));
    
    xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/incomes/getMonthlyData?email="+session.email+"&date=2021-06");

    xhr.send();
};

var ctx = document.getElementById("myChart").getContext("2d");

const init = () => {
    var myChart = new Chart(ctx, {
        type: "line",
        plugins: [plugin],
        data: {
            labels: labelArray,
            datasets: [{
                label: 'Ingresos',
                fill: false,
                lineTension: 0.5,
                data: dataArray,
                backgroundColor: background
            }]
        }, options:{
            scales:{
                YAxes:{
                    ticks:{
                        beginAtZero:true
                    }
                }
            }
        }
    });
}

const initDoubleChart = () => {
    var myChart = new Chart(ctx, {
        type: "line",
        plugins: [plugin],
        data: {
            datasets: [{
                label: 'Ingresos',
                fill: false,
                lineTension: 0.5,
                data: dataArray,
                backgroundColor: background
            },{
                label: 'Gastos',
                fill: false,
                lineTension: 0.5,
                data: dataAditionalArray,
                backgroundColor: backgroundAditional
            }]
        }, options:{
            scales:{
                YAxes:{
                    ticks:{
                        beginAtZero:true
                    }
                }
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

periodBtn.addEventListener('click', init);
compareBtn.addEventListener('click', callAditionalData);

callData();
callAditionalData();