let dataArray = [];
let labelArray = [];
let background =[];

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
    
    xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/expenses/getMonthlyData?email="+session.email+"&date=2021-05");

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

callData();
