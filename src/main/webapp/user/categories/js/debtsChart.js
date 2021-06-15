const periodBtn = document.getElementById('periodBtn');
const compareBtn = document.getElementById('compareBtn');

let dataArray = [];
let labelArray = [];

let sumDebts=0;
let sumSavings=0;
let balanceDebts=0;
let background =[];
var canvas = document.getElementById("canvas");

const callData = () => {
    if(labelArray.length ===0) {
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', () => {
            if (xhr.readyState === 4) {
                let json = xhr.responseText;
                let response = JSON.parse(json);

                for (let i = 0; i < response.length; i++) {
                    let dot = response[i];
                    dataArray[i] = dot.value;
                    labelArray[i] = "Dia " + dot.date.substring(8, 10);
                    sumDebts += dot.value;
                    background[i] = "rgb(248, 126, 150)";
                }
                init();
            }
        });
        let session = JSON.parse(window.localStorage.getItem('session'));

        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/debts/getMonthlyData?email=" + session.email +"&date=2021-06");

        xhr.send();
        return labelArray;
    }else{
        return labelArray;
    }
};

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

const init = () => {
    canvas.innerHTML='<h2> Comparacion en el tiempo</h2> <canvas id="myChart" width="870" height="430"></canvas>';
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "line",
        plugins: [plugin],
        data: {
            labels: callData(),
            datasets: [{
                label: 'Deudas',
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
    canvas.innerHTML='<h2> Comparacion con respecto a los ahorros </h2> <canvas id="myChart" width="870" height="430"></canvas>';
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "pie",
        plugins: [plugin],
        data: {
            labels:['Deudas','Ahorros'],
            datasets: [{
                label: 'Comparacion',
                data: [balanceDebts, sumSavings],
                backgroundColor: ["rgb(248, 126, 150)","rgb(57, 77, 114)"]
            }]
        }
    });
}

const getBalance=()=>{
    if(balanceDebts===0) {
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', () => {
            if (xhr.readyState === 4) {
                let json = xhr.responseText;
                let response = JSON.parse(json);
                balanceDebts = response;
            }
        });
        let session = JSON.parse(window.localStorage.getItem('session'));
        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/debts/balance?email=" + session.email);
        xhr.send();
        return balanceDebts;
    }else{
        return balanceDebts;
    }
}

const callAditionalData = () => {
    if(sumSavings==0){
        getBalance();
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', () => {
            if (xhr.readyState === 4) {
                let json = xhr.responseText;
                let response = JSON.parse(json);
                sumSavings=response;
                initDoubleChart();
            }
        });
        let session = JSON.parse(window.localStorage.getItem('session'));
        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/savings/getAllSumFee?email="+session.email);
        xhr.send();
    }else{
        initDoubleChart();
    }
};

periodBtn.addEventListener('click', init);
compareBtn.addEventListener('click', callAditionalData);

init();