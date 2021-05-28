const head= document.getElementById('header');
const footer= document.getElementById('footer');

loadElements=()=>{

    head.innerHTML= '<header>\n' +
        '        <a class="logo" href="/"><img src="../../images/logoDark.png" alt="logo" width="200px"> </a>\n' +
        '        <nav>\n' +
        '            <ul class="nav__links">\n' +
        '                <li><a href="../../index.html" id="b">Inicio</a></li>\n' +
        '                <li><a href="# " id="b">Servicios</a></li>\n' +
        '                <li><a href="../../information/contact.html">Contactanos</a></li>\n' +
        '                <li><a href="../../information/help.html">Ayuda </a></li>\n' +
        '                <li><a href="signup.html">Registrarse</a></li>\n' +
        '                <li><a href="login.html">Iniciar Sesión</a></li>\n' +
        '            </ul>\n' +
        '        </nav>\n' +
        '    </header>';



    footer.innerHTML= ' <footer>\n' +
        '        <a class=" logo " href="/ "><img src="../../images/logo.png " alt="logo " width="200px "> </a>\n' +
        '        <nav>\n' +
        '            <ul class="nav_links ">\n' +
        '                <li><a href="../../index.html " id="b ">Inicio</a></li>\n' +
        '                <li><a href="# " id="b ">Servicios</a></li>\n' +
        '                <li><a href="contact.html ">Contactanos</a></li>\n' +
        '                <li><a href="help.html ">Ayuda </a></li>\n' +
        '                <li><a href="signup.html"">Registrarse</a></li>\n' +
        '                <li><a href="../../user/login.html ">Iniciar Sesión</a></li>\n' +
        '            </ul>\n' +
        '        </nav>\n' +
        '    </footer>';
}
loadElements();