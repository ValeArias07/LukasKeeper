const periodBtn = document.getElementById('periodBtn');
const compareBtn = document.getElementById('compareBtn');

let dataArray = [];
let labelArray = [];

let sumIncome=0;
let sumExpense=0;

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
                    dataArray[i] = (-1)*dot.value;
                    labelArray[i] = "Dia " + dot.date.substring(8, 10);
                    sumExpense += dot.value;
                    background[i] = "rgb(248, 126, 150)";
                }
                sumExpense*=(-1);
                init();
            }
        });
        let session = JSON.parse(window.localStorage.getItem('session'));

        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/expenses/getMonthlyData?email=" + session.email + "&date=2021-06");

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
                label: 'Gastos',
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
    canvas.innerHTML='<h2> Comparacion con respecto a los ingresos </h2> <canvas id="myChart" width="870" height="430"></canvas>';
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "pie",
        plugins: [plugin],
        data: {
            labels:['Gastos','Ingresos'],
            datasets: [{
                label: 'Comparacion',
                data: [sumExpense,sumIncome],
                backgroundColor: ["rgb(57, 77, 114)","rgb(248, 126, 150)"]
            }]
        }
    });
}

const callAditionalData = () => {
    if(sumIncome==0){
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', () => {
            if (xhr.readyState === 4) {
                let json = xhr.responseText;
                let response = JSON.parse(json);

                for (let i = 0; i < response.length; i++) {
                    let dot = response[i];
                    sumIncome+=dot.value;
                }
            }
        });
        let session = JSON.parse(window.localStorage.getItem('session'));
        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/incomes/getMonthlyData?email="+session.email+"&date=2021-06");
        xhr.send();
    }else{
        initDoubleChart();
    }
};

periodBtn.addEventListener('click', init);
compareBtn.addEventListener('click', initDoubleChart);

init();
callAditionalData();