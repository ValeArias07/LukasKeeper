const sidebar = document.getElementById('sidebar');

loadSideBard=()=> {
    sidebar.innerHTML = ' <div class="sidebar">\n' +
        '                <center>\n' +
        '                    <img src="../../images/model.jpg" class="profile_image" alt="">\n' +
        '                    <h4>Hola, <label id="nameModel"></label>! </h4>\n' +
        '                </center>\n' +
        '                <a href="../categories/incomes.html"><img src="../../images/income.png" class="icons" align="center"><span>Ingresos</span></a>\n' +
        '                <a href="../categories/expenses.html"><img src="../../images/expending.png" class="icons" align="center"><span>Gastos</span></a>\n' +
        '                <a href="../categories/debts.html"><img src="../../images/debt.png" class="icons" align="center"><span>Deudas</span></a>\n' +
        '                <a href="../categories/savings.html"><img src="../../images/saving.png" class="icons" align="center"><span>Ahorros</span></a>\n' +
        '\n' +
        '                <h5> Recomiendanos a un amigo<br> LukasKeeper © 2021 </h5>\n' +
        '            </div>';
}
loadSideBard();