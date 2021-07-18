/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Almacenamiento de imagen */
var dataUrl;

/* variable de obtención del elemento a ser renderizado */
var canvas = document.getElementById('lienzo');

/* variable de contexto para el tipo de dibujo, dimensión */
var ctx = canvas.getContext('2d');

/* variable donde identificamos las coordenadas del canvas */
var coor = canvas.getBoundingClientRect();

/* variables de coordenas*/
var x = 0;
var y = 0;

/* variables de control */
var actDibujando = false;  // true para dibujar  false para no dibujar
var opColor = '#563d7c'; // color del dibujo
var texturaLinea = 1; // grosor de la línea

/* funciones de cambio de color */
function changecolor(nuevoColor) {
    opColor = nuevoColor;
}
;

/* funciones de cambio de textura */
function changetextura(nuevaTextura) {
    texturaLinea = nuevaTextura;
}
;

/* presionado de botón de mouse */
canvas.addEventListener('mousedown', function (env) {
    x = env.clientX - coor.left;
    y = env.clientY - coor.top;
    actDibujando = true;
});

/* movimiento del mouse */
canvas.addEventListener('mousemove', function (env) {
    if (actDibujando === true) {
        graficar(x, y, env.clientX - coor.left, env.clientY - coor.top);
        x = env.clientX - coor.left;
        y = env.clientY - coor.top;
    }
});

/* alza de botón de mouse */
canvas.addEventListener('mouseup', function (env) {
    if (actDibujando === true) {
        graficar(x, y, env.clientX - coor.left, env.clientY - coor.top);
        x = 0;
        y = 0;
        actDibujando = false;
    }
});

/* dibujando en canvas */
function graficar(xInicial, yInicial, xFinal, yFinal) {
    ctx.beginPath();
    ctx.strokeStyle = opColor;
    ctx.lineWidth = texturaLinea;
    ctx.moveTo(xInicial, yInicial);
    ctx.lineTo(xFinal, yFinal);
    ctx.stroke();
    ctx.closePath();
}
;

/* función para exportar */
function exportar() {
    let nombre = document.getElementById('nombreImagen').value;
    let formato = document.getElementById('formato').value;
    if (formato === 'png') {
        dataUrl = canvas.toDataURL('image/png', 0);
    } else {
        dataUrl = canvas.toDataURL('image/jpeg', 1.0);
    }
    $.ajax({
        method: 'POST',
        url: 'ClientServlet',
        data: {nombre: nombre, formato: formato, datos: dataUrl},
        success: function (data) {
            alert(data);
        },
        error: function (data, error) {
            console.log(error);
        }
    });
    console.log(dataUrl);
}
;