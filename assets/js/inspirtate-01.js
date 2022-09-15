// alert ("estás en insp");


// var reproducirVideo = document.querySelector('imagen-video');

//mouseover
// reproducirVideo.addEventListener('play',function () {
// console.log("play");
// });

do {
    i = i + 1;
    result = result + i;
  } while (i < 5);


for (let i = 0; i <2; i++){
var iconoSpot = document.getElementById ("icon-inspirate-01");
iconoSpot.addEventListener("mouseover", function(){

  

        console.log("for principal " + i);
        // for (let j = 0; j <i;j++){
        // console.log("for interno" + j);
        // }

});
}

 let iconoIg = document.getElementById ("icon-inspirate-02");
iconoIg.addEventListener("mouseover", function(){

 console.log("click en el icono de IG");


});
var iconoTiktok = document.getElementById ("icon-inspirate-04");
iconoTiktok.addEventListener("mouseover", function(){

    console.log("click en el icono Tiktok");


});

var iconoChrom = document.getElementById ("icon-inspirate-03");
iconoChrom.addEventListener("mouseover", function(){

    console.log("click en el icono Google");


});

