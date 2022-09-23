
const formulario = document.getElementById('formRegistro');

formulario.addEventListener('submit', (e) => {
    let nombre = document.getElementById("name").value;
    let correoE = document.getElementById("correo").value;
    let contra1 = document.getElementById("palabraSecreta1").value;
    let contra2 = document.getElementById("palabraSecreta2").value;
   let date = document.getElementById("fecha").value;
    const expresionCorreo = /\w+@\w+\.+[a-z]/;
    const expresionPass = /^.{4,12}$/;




    if (nombre == "") {
      //alert('Ingrese Nombre');
      document.getElementById("name").focus();
    } else if (correoE == "") {
      //alert('Ingrese Correo Electronico');
      document.getElementById("correo").focus();
    } else if (!expresionCorreo.test(correoE)) {
      alert("El correo es invalido");
      document.getElementById("correo").focus();
      //return false;
    } else if (contra1 == "") {
      //alert('Ingrese Contraseña');
      document.getElementById("palabraSecreta1").focus();
    } else if (!expresionPass.test(contra1) || !expresionPass.test(contra2)) {
      alert(
        "la contraseña es Invalida" +
          "\nLa contraseña debe tener de 4 a 12 caracteres"
      );
      document.getElementById("palabraSecreta1").focus();
      //return false;
    } else if (contra2 == "") {
      //alert('Confirme Contraseña ');
      document.getElementById("palabraSecreta2").focus();
    } else if (!expresionPass.test(contra1) || !expresionPass.test(contra2)) {
      alert(
        "la contraseña es Invalida" +
          "\nLa contraseña debe tener de 4 a 12 caracteres"
      );
      document.getElementById("palabraSecreta2").focus();
      //return false;
    } else if (contra1 != contra2){ //para que las contraseñas sean iguales
      alert("La contraseñas deben ser iguales")
    } else if (date == "") {
      alert('Ingrese Fecha de Nacimiento');
      document.getElementById("fecha").focus();
    } else {
      console.log(
        nombre + " " + correoE + " " + contra1 + " " + contra2 + " " + date
      );
      document.getElementById("name").value = "";
      document.getElementById("correo").value = "";
      document.getElementById("palabraSecreta1").value = "";
      document.getElementById("palabraSecreta2").value = "";
      document.getElementById("fecha").value = "";
  
      let registro = { nombre, correoE, contra1, contra1, date };
      let registroJson = JSON.stringify(registro);
      console.log(registro);
      console.log(registroJson);
      
    }
      e.preventDefault();
/***********************************CONEXIÓN CON LA API */

      fetch('https://akan-un-lugar-para-el-arte-1.herokuapp.com/registro',  {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre_usuario: nombre,
            email: correoE,      
            password: contra1,
            fecha_Nacimiento: date,
            
        }),
      })
          //Para guardar el id_registro:
      .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
          
            localStorage.setItem('id_registro',data.id_registro); //para guardar el id_registro en el LocalStorage
            window.location.replace("Login.html");

           

        })
        .catch((error) => {
            console.error('Error:', error);

            
        });

          /* .then(resp => {
            if( resp.ok) {
                  
                  url = window.location;
                  const path = url.pathname.substring(0, url.pathname.lastIndexOf('/') + 1)
                  location.href = path +  'pago.html';
            }
        })  */
        
        /* .catch((error) => {
            console.error('Error:', error);
        });  */

});
// ************ LOCAL STORAGE

/* localStorage.setItem(registroJson);
if (localStorage.getItem('registroJson')){
  registroJson=JSON.parse(localStorage.getItem('registroJson'))
  console.log("exp",registroJson);
} */

