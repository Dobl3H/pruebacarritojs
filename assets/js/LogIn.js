const formulario = document.getElementById("formInicioSesion");

formulario.addEventListener("submit", (e) => {
  let correo = document.getElementById("correo").value;
  let contraseña = document.getElementById("password").value;
  const expresionCorreo = /\w+@\w+\.+[a-z]/;
  const expresionPass = /^.{4,12}$/;

  if (!expresionCorreo.test(correo)) {
    alert("El correo es invalido");
    document.getElementById("correo").focus();
  }
  if (!expresionPass.test(contraseña)) {
    alert(
      "la contraseña es Invalida" +
        "\nLa contraseña debe tener de 4 a 12 caracteres"
    );
    document.getElementById("password").focus();
  } else {
    console.log(correo + " " + contraseña);
    document.getElementById("correo").value = "";
    document.getElementById("password").value = "";
  }

  let sesion = { correo, contraseña };
  let sesionJson = JSON.stringify(sesion);
  console.log(sesion);
  console.log(sesionJson);


  e.preventDefault();
});
